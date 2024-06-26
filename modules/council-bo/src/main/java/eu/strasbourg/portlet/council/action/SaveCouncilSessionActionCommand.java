package eu.strasbourg.portlet.council.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.council.model.CouncilSession;
import eu.strasbourg.service.council.model.CouncilSessionModel;
import eu.strasbourg.service.council.model.Official;
import eu.strasbourg.service.council.service.CouncilSessionLocalService;
import eu.strasbourg.service.council.service.CouncilSessionLocalServiceUtil;
import eu.strasbourg.service.council.service.OfficialLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.COUNCIL_BO,
                "mvc.command.name=saveCouncilSession"
        },
        service = MVCActionCommand.class
)
public class SaveCouncilSessionActionCommand implements MVCActionCommand {

    private final Log log = LogFactoryUtil.getLog(this.getClass().getName());

    private long councilSessionId;
    private long typeId;
    private String title;
    private Date date;

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) {
        try {
            // Récupération du contexte de la requêtes
            ServiceContext sc = ServiceContextFactory.getInstance(request);
            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

            // Validation
            boolean isValid = this.validate(request);
            if (!isValid) {
                // Si pas valide : on reste sur la page d'édition
                PortalUtil.copyRequestParameters(request, response);

                String portletName = (String) request.getAttribute(WebKeys.PORTLET_ID);
                PortletURL returnURL = PortletURLFactoryUtil.create(request, portletName, themeDisplay.getPlid(),
                        PortletRequest.RENDER_PHASE);

                response.setRenderParameter("backURL", returnURL.toString());
                response.setRenderParameter("cmd", "editCouncilSession");
                response.setRenderParameter("mvcPath", "/council-bo-edit-council-session.jsp");
                return false;
            }

            // Si édition ou création d'une nouvelle entrée
            CouncilSession councilSession;
            if (this.councilSessionId == 0) {
                councilSession = this.councilSessionLocalService.createCouncilSession(sc);
            } else {
                councilSession = this.councilSessionLocalService.getCouncilSession(this.councilSessionId);
            }

            // Champ : titre
            councilSession.setTitle(this.title);

            // Champ : type
            councilSession.setTypeId(this.typeId);

            // Champ : date
            councilSession.setDate(this.date);

            // Champ : président du conseil
            long officialLeaderId = ParamUtil.getLong(request, "officialLeaderId");
            councilSession.setOfficialLeaderId(officialLeaderId);

            // Mise à jour de l'entrée en base
            this.councilSessionLocalService.updateCouncilSession(councilSession, sc);
            response.sendRedirect(ParamUtil.getString(request, "backURL"));

        } catch (PortalException e) {
            log.error(e);
        } catch (IOException e) {
            log.error(e);
        }
        return true;
    }

    /**
     * Validation de la requête
     */
    private boolean validate(ActionRequest request)  {
        boolean isValid = true;

        this.councilSessionId = ParamUtil.getLong(request, "councilSessionId");

        // Récupération du type
        this.typeId = ParamUtil.getLong(request, "council-type");

        // Titre
        this.title = ParamUtil.getString(request, "title");
        if (Validator.isNull(title)) {
            SessionErrors.add(request, "title-error");
            isValid = false;
        }

        // Titre déjà utilisé ?
        if (this.councilSessionLocalService.isTitleAlreadyUsedInCouncilTypeId(this.title, this.councilSessionId, this.typeId)) {
            SessionErrors.add(request, "title-already-used-error");
            isValid = false;
        }

        // Date
        if (Validator.isNull(ParamUtil.getString(request, "date"))) {
            SessionErrors.add(request, "date-error");
            isValid = false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.date = ParamUtil.getDate(request, "date", dateFormat);

        // Vérification conseil du même type sur le même jour
        GregorianCalendar gregorianCalendar = CouncilSessionLocalServiceUtil.calculDateForFindCouncil();
        Date date = gregorianCalendar.getTime();

        List<CouncilSession> councilSessions = CouncilSessionLocalServiceUtil.getFutureCouncilSessions(date); // tous les conseils a partir d'aujourd'hui
        List<CouncilSession> councilSessionListByType = CouncilSessionLocalServiceUtil.findByTypeId(this.typeId); // tous les conseils d'un type (passés et futurs)

        List<Date> datesForCouncilsToCome = councilSessions.stream().map(CouncilSessionModel::getDate).collect(Collectors.toList());
        List<Date> datesForCouncilsOfType = councilSessionListByType.stream().filter(x -> x.getCouncilSessionId() != this.councilSessionId).map(CouncilSessionModel::getDate).collect(Collectors.toList());

        List<Date> commonDatesList = datesForCouncilsOfType.stream()
                .filter(councilDate -> datesForCouncilsToCome.contains(councilDate)).collect(Collectors.toList());

        if (!commonDatesList.isEmpty()) {
            for (Date dateToCome : commonDatesList) {
                String formattedDate = dateFormat.format(dateToCome);
                String formattedWantedDate = dateFormat.format(this.date);
                if (formattedDate.equals(formattedWantedDate)) {
                    SessionErrors.add(request, "council-of-type-already-exist-error");
                    isValid = false;
                }
            }
        }

        // Official leader
        long officialLeaderId = ParamUtil.getLong(request, "officialLeaderId");
        if (Validator.isNull(officialLeaderId)) {
            SessionErrors.add(request, "official-leader-not-found-error");
            isValid = false;
        }
        Official official = this.officialLocalService.fetchOfficial(officialLeaderId);
        if (Validator.isNull(officialLeaderId)) {
            SessionErrors.add(request, "official-leader-not-found-error");
            isValid = false;
        } else if (!official.getCouncilTypesIds().contains(""+this.typeId)) {
            SessionErrors.add(request, "official-leader-type-error");
            isValid = false;
        }

        return isValid;
    }

    @Reference(unbind = "-")
    protected void setCouncilSessionLocalService(CouncilSessionLocalService councilSessionLocalService) {
        this.councilSessionLocalService = councilSessionLocalService;
    }

    @Reference(unbind = "-")
    protected void setOfficialLocalService(OfficialLocalService officialLocalService) {
        this.officialLocalService = officialLocalService;
    }

    private CouncilSessionLocalService councilSessionLocalService;
    private OfficialLocalService officialLocalService;

}
