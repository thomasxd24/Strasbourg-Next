package eu.strasbourg.portlet.place.csmap.action;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.csmap.constants.CodeCacheEnum;
import eu.strasbourg.service.csmap.model.PlaceCategories;
import eu.strasbourg.service.csmap.service.CsmapCacheLocalService;
import eu.strasbourg.service.csmap.service.PlaceCategoriesLocalService;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.constants.VocabularyNames;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        property = {"javax.portlet.name=" + StrasbourgPortletKeys.CSMAP_BO_PLACE,
                "mvc.command.name=savePlaceCategories"},
        service = MVCActionCommand.class)
public class SaveCsmapPlaceCategoriesActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest request, ActionResponse response) {
        long placeCategoriesId = ParamUtil.getLong(request, "placeCategoriesId");
        PlaceCategories placeCategories;
        if (placeCategoriesId != 0) {
            try {
                placeCategories = _placeCategoriesLocalService.getPlaceCategories(placeCategoriesId);
            } catch (Exception e) {
                placeCategories = _placeCategoriesLocalService.createPlaceCategories(placeCategoriesId);
            }
        } else {
            placeCategories = _placeCategoriesLocalService.createPlaceCategories();
        }

        StringBuilder placeTypes = new StringBuilder();
        long[] placeTypesIds = ParamUtil.getLongValues(request, "Vocabulary_" + getTypeVocabularyId());
        List<Long> placeTypesIdsList = Arrays.stream(placeTypesIds).boxed().collect(Collectors.toList());
        for (long placeTypesId : placeTypesIds) {
            if (placeTypes.toString().equals("")) {
                placeTypes = new StringBuilder(String.valueOf(placeTypesId));
            } else {
                placeTypes.append(",").append(placeTypesId);
            }
            try {
                AssetCategory placeTypeCategory = _assetCategoryLocalService.getAssetCategory(placeTypesId);
                AssetCategory parentCategory = placeTypeCategory.getParentCategory();
                if (Validator.isNotNull(parentCategory)) {
                    long parentId = parentCategory.getCategoryId();
                    if (!placeTypesIdsList.contains(parentId) && placeTypes.indexOf(""+parentId) == -1) {
                        placeTypes.append(",").append(parentId);
                    }
                }
            } catch (PortalException e) {
                _log.error(e.getMessage() + " : " + placeTypesId);
            }
        }
        placeCategories.setCategoriesIds(placeTypes.toString());

        _placeCategoriesLocalService.updatePlaceCategories(placeCategories);

        // Régénération du cache des catégories de lieu pour CSMap
        _csmapCacheLocalService.generateCsmapCache(CodeCacheEnum.CATEGORIES.getId());

        // Post / Redirect / Get si tout est bon
        ThemeDisplay themeDisplay = (ThemeDisplay) request
                .getAttribute(WebKeys.THEME_DISPLAY);
        String portletName = (String) request.getAttribute(WebKeys.PORTLET_ID);
        PortletURL renderURL = PortletURLFactoryUtil.create(request,
                portletName, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
        renderURL.setParameter("tab", request.getParameter("tab"));
        renderURL.setParameter("mvcPath", request.getParameter("mvcPath"));
        try {
            response.sendRedirect(renderURL.toString());
        } catch (IOException e) {
            _log.error(e);
        }
    }

    private PlaceCategoriesLocalService _placeCategoriesLocalService;
    private AssetCategoryLocalService _assetCategoryLocalService;
    private CsmapCacheLocalService _csmapCacheLocalService;

    @Reference(unbind = "-")
    protected void setPlaceCategoriesLocalService(PlaceCategoriesLocalService placeCategoriesLocalService) {
        _placeCategoriesLocalService = placeCategoriesLocalService;
    }

    @Reference(unbind = "-")
    protected void setAssetCategoryLocalService(AssetCategoryLocalService assetCategoryLocalService) {
        _assetCategoryLocalService = assetCategoryLocalService;
    }

    @Reference(unbind = "-")
    protected void setCsmapCacheLocalService(CsmapCacheLocalService csmapCacheLocalService) {
        _csmapCacheLocalService = csmapCacheLocalService;
    }

    private String getTypeVocabularyId() {
        try {
            AssetVocabulary type = AssetVocabularyHelper.getGlobalVocabulary(VocabularyNames.PLACE_TYPE);
            if (Validator.isNotNull(type))
                return String.valueOf(type.getVocabularyId());
        } catch (PortalException e) {
            _log.error(e.getMessage());
        }
        return null;
    }

    private final Log _log = LogFactoryUtil.getLog(this.getClass());
}
