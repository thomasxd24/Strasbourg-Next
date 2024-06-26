package eu.strasbourg.portlet.help.action;

import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import eu.strasbourg.service.help.model.HelpProposal;
import eu.strasbourg.service.help.service.HelpProposalLocalService;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.HELP_BO,
                "mvc.command.name=changeActivityHelpProposal"
        },
        service = MVCActionCommand.class
)
public class ChangeActivityHelpActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {

        try {
            long helpProposalId = ParamUtil.getLong(request, "helpProposalId");
            HelpProposal helpProposal = _helpProposalLocalService.getHelpProposal(helpProposalId);
            long helpAssetId = helpProposal.getAssetEntry().getEntryId();
            ServiceContext sc = ServiceContextFactory.getInstance(request);

            // Update category
            List<AssetCategory> categories = helpProposal.getCategories();
            AssetCategory active = AssetVocabularyHelper.getCategory("Active", sc.getScopeGroupId());
            AssetCategory inactive = AssetVocabularyHelper.getCategory("Inactive", sc.getScopeGroupId());
            // Active --> Inactive
            if (active != null && inactive != null && categories.contains(active)) {
                AssetEntryAssetCategoryRelLocalServiceUtil.deleteAssetEntryAssetCategoryRel(helpAssetId, active.getCategoryId());
                //AssetCategoryLocalServiceUtil.deleteAssetEntryAssetCategory(helpAssetId, active);
                AssetEntryAssetCategoryRelLocalServiceUtil.addAssetEntryAssetCategoryRel(helpAssetId, inactive.getCategoryId());
                //AssetCategoryLocalServiceUtil.addAssetEntryAssetCategory(helpAssetId, inactive);
            }
            // Inactive --> Active
            else if (active != null && inactive != null && categories.contains(inactive)) {
                AssetEntryAssetCategoryRelLocalServiceUtil.deleteAssetEntryAssetCategoryRel(helpAssetId, inactive.getCategoryId());
              //  AssetCategoryLocalServiceUtil.deleteAssetEntryAssetCategory(helpAssetId, inactive);
                AssetEntryAssetCategoryRelLocalServiceUtil.addAssetEntryAssetCategoryRel(helpAssetId, active.getCategoryId());
                //AssetCategoryLocalServiceUtil.addAssetEntryAssetCategory(helpAssetId, active);
            }
            _helpProposalLocalService.reindexById(helpProposal.getHelpProposalId());
        } catch (PortalException e) {
            _log.error(e);
        }
        return true;
    }

    @Reference(unbind = "-")
    protected void setHelpProposalLocalService(HelpProposalLocalService helpProposalLocalService) {
        _helpProposalLocalService = helpProposalLocalService;
    }

    private HelpProposalLocalService _helpProposalLocalService;

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}
