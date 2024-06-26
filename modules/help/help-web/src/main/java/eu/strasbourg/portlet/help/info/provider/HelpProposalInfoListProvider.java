package eu.strasbourg.portlet.help.info.provider;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.info.collection.provider.CollectionQuery;
import com.liferay.info.collection.provider.InfoCollectionProvider;
import com.liferay.info.pagination.InfoPage;
import com.liferay.info.pagination.Pagination;
import com.liferay.info.sort.Sort;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.util.SessionParamUtil;
import eu.strasbourg.service.help.model.HelpProposal;
import eu.strasbourg.service.help.service.HelpProposalLocalService;
import eu.strasbourg.service.oidc.service.PublikUserLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import java.util.Locale;


@Component(service = InfoCollectionProvider.class)
public class HelpProposalInfoListProvider implements InfoCollectionProvider<AssetEntry> {

    @Override
    public InfoPage<AssetEntry> getCollectionInfoPage(CollectionQuery collectionQuery) {

        // Recuperer l'utilisateur publik courant.
        HttpServletRequest  request = ServiceContextThreadLocal.getServiceContext().getRequest();
        boolean isLoggedIn = SessionParamUtil.getBoolean(request, "publik_logged_in");
        String currentPublikUserId = "";
        if (isLoggedIn) {
            currentPublikUserId = SessionParamUtil.getString(request, "publik_internal_id");
        }

        // Recuperer les propositions d'aides pour cet utilisateur
        List<AssetEntry> helpProposalsAssets = new ArrayList<>();
        if (!currentPublikUserId.equals(""))
        {
            List<HelpProposal> helpProposals = _helProposalLocalService.getByPublikID(currentPublikUserId);
            for (HelpProposal helpProposal: helpProposals) {
                helpProposalsAssets.add(helpProposal.getAssetEntry());
            }
        }
        return InfoPage.of(helpProposalsAssets);
    }
   /* @Override
    public List<AssetEntry> getInfoList(InfoListProviderContext infoListProviderContext) {

        // Recuperer l'utilisateur publik courant.
        HttpServletRequest  request = ServiceContextThreadLocal.getServiceContext().getRequest();
        boolean isLoggedIn = SessionParamUtil.getBoolean(request, "publik_logged_in");
        String currentPublikUserId = "";
        if (isLoggedIn) {
            currentPublikUserId = SessionParamUtil.getString(request, "publik_internal_id");
        }

        // Recuperer les propositions d'aides pour cet utilisateur
        List<AssetEntry> helpProposalsAssets = new ArrayList<>();
        if (!currentPublikUserId.equals(""))
        {
            List<HelpProposal> helpProposals = _helProposalLocalService.getByPublikID(currentPublikUserId);
            for (HelpProposal helpProposal: helpProposals) {
                helpProposalsAssets.add(helpProposal.getAssetEntry());
            }
        }

        return helpProposalsAssets;
    }*/

   /* @Override
    public List<AssetEntry> getInfoList(
            InfoListProviderContext infoListProviderContext, Pagination pagination,
            Sort sort) {


        return getInfoList(infoListProviderContext);
    }*/



   /* @Override
    public int getInfoListCount(InfoListProviderContext infoListProviderContext) {
        return getInfoList(infoListProviderContext).size();
    }*/

    @Override
    public String getLabel(Locale locale) {
        return "Propositions d'aide";
    }

    @Reference
    HelpProposalLocalService _helProposalLocalService;

    @Reference
    PublikUserLocalService _publikUserLocalService;

   }