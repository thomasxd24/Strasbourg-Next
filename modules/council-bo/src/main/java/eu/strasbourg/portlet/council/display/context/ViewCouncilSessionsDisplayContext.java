package eu.strasbourg.portlet.council.display.context;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.council.util.CouncilSessionsActionDropdownItemsProvider;
import eu.strasbourg.portlet.council.utils.UserRoleType;
import eu.strasbourg.service.council.model.CouncilSession;
import eu.strasbourg.service.council.service.CouncilSessionLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewCouncilSessionsDisplayContext extends ViewBaseDisplayContext<CouncilSession> {

    private List<Long> typeCouncilIds;

    public ViewCouncilSessionsDisplayContext(RenderRequest request, RenderResponse response) {
        super(request, response, CouncilSession.class);
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
        typeCouncilIds = new ArrayList<>();
        initAuthorizedTypeCouncilsIds();
    }
    /**
     * Retourne le dropdownItemsProvider de l’entité
     *
     */
    @SuppressWarnings("unused")
    public CouncilSessionsActionDropdownItemsProvider getActionsConcilSessions(CouncilSession councilSession) {
        return new CouncilSessionsActionDropdownItemsProvider(councilSession, this._request,
                this._response);
    }

    private void initAuthorizedTypeCouncilsIds() {
        if(typeCouncilIds.size() == 0) {
            typeCouncilIds = UserRoleType.typeIdsForUser(_themeDisplay);
        }
    }

    /**
     * Retourne la liste des sessions correspondant à la recherche lancée en ignorant la pagination
     */
    private List<CouncilSession> getAllCouncilSessions() throws PortalException {
        Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());

        List<CouncilSession> results = new ArrayList<>();
        if (hits != null) {
            for (Document document : hits.getDocs()) {
                CouncilSession councilSession = CouncilSessionLocalServiceUtil
                        .fetchCouncilSession(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                // Seuls les conseils ayant un type de conseil autorisé par les droits du User sont ajoutés aux résultats
                if (councilSession != null && typeCouncilIds.contains(councilSession.getTypeId())) {
                    results.add(councilSession);
                }
            }
        }

        return results;
    }

    /**
     * Retourne la liste des PK de toutes les sessions
     * @return liste de PK (ex: "1,5,7,8")
     */
    @SuppressWarnings("unused")
    public String getAllCouncilSessionIds() throws PortalException {
        StringBuilder councilSessionsIds = new StringBuilder();
        for (CouncilSession councilSession : this.getAllCouncilSessions()) {
            if (councilSessionsIds.length() > 0) {
                councilSessionsIds.append(",");
            }
            councilSessionsIds.append(councilSession.getCouncilSessionId());
        }
        return councilSessionsIds.toString();
    }

    /**
     * Retourne le searchContainer des councilSessions
     *
     */
    @Override
    public SearchContainer<CouncilSession> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL;
            portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/council-bo-view-council-sessions.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab","councilSessions")
                    .setParameter("filterCategoriesIdByVocabulariesName", getFilterCategoriesIdByVocabulariesName())
                    .buildPortletURL();
            _searchContainer = new SearchContainer<>(_request, null, null,
                    SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, null, "no-entries-were-found");
            _searchContainer.setEmptyResultsMessageCssClass(
                    "taglib-empty-result-message-header-has-plus-btn");
            _searchContainer.setOrderByColParam("orderByCol");
            _searchContainer.setOrderByTypeParam("orderByType");
            _searchContainer.setOrderByCol(getOrderByCol());
            _searchContainer.setOrderByType(getOrderByType());
            Hits hits;
            try {
                hits = getHits(this._themeDisplay.getScopeGroupId());
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
            _searchContainer.setResultsAndTotal(
                    () -> {
                        // Création de la liste d'objet
                        List<CouncilSession> results = new ArrayList<>();
                        if (hits != null) {
                            for (Document document : hits.getDocs()) {
                                CouncilSession councilSession = CouncilSessionLocalServiceUtil.fetchCouncilSession(
                                        GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                // Seuls les conseils ayant un type de conseil autorisé par les droits du User sont ajoutés aux résultats
                                if (councilSession != null && typeCouncilIds.contains(councilSession.getTypeId())) {
                                    results.add(councilSession);
                                }
                            }
                        }
                        return results;
                    }, hits.getLength()
            );
        }
        _searchContainer.setRowChecker(
                new EmptyOnClickRowChecker(_response));

        return _searchContainer;
    }

    @Override
    public String getOrderByColSearchField() {
        switch (this.getOrderByCol()) {
            case "title":
                return "localized_title_fr_FR_sortable";
            case "date":
                return "date_sortable";
            default:
                return "modified_sortable";
        }
    }

    @Override
    public String getOrderByCol() {
        return ParamUtil.getString(this._request, "orderByCol",
                "date");
    }

    private final RenderRequest _request;
    private final ThemeDisplay _themeDisplay;
    protected SearchContainer<CouncilSession> _searchContainer;
    private final RenderResponse _response;
}
