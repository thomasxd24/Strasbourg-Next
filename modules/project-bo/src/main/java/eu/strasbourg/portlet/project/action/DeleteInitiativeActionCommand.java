package eu.strasbourg.portlet.project.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import eu.strasbourg.service.project.service.InitiativeLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import java.io.IOException;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StrasbourgPortletKeys.PROJECT_BO,
		"mvc.command.name=deleteInitiative" 
	},
	service = MVCActionCommand.class
)
public class DeleteInitiativeActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest request, ActionResponse response)
		throws PortletException {

		try {
			long initiativeId = ParamUtil.getLong(request, "initiativeId");
			_initiativeLocalService.removeInitiative(initiativeId);
			response.sendRedirect(ParamUtil.getString(request, "backURL"));
		} catch (PortalException e) {
			_log.error(e);
		} catch (IOException e) {
			_log.error(e);
        }
        return true;
	}

	@Reference(unbind = "-")
	protected void setInitiativeLocalService(InitiativeLocalService initiativeLocalService) {
		_initiativeLocalService = initiativeLocalService;
	}
	
	private InitiativeLocalService _initiativeLocalService;

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

}
