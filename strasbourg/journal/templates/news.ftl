<#setting locale = locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>

<#-- Récupération de DateHelper pour le format date -->
<#assign dateHelperService = serviceLocator.findService("eu.strasbourg.utils.api.DateHelperService") />

<#assign currentUrl = themeDisplay.getPortalURL() + themeDisplay.getURLCurrent() />

<#assign imageUrl = ""/>
<!-- image -->
<#if thumbnail.getData()?has_content>
    <#assign imageUrl = thumbnail.getData() />
</#if>
<script>
    title = '${title.getData()?html?js_string}';
    description = '${chapo.getData()?replace("<[^>]*>", "", "r")?html?js_string}';
    imageUrl = '${imageUrl}';
</script>

<main class="seu-container" style="margin-bottom: 50px">
    <div class="detail-line">
        <div class="filler"></div>
        <p class="seu-published">
            <@liferay_ui.message key="eu.published-on" /> 
            ${dateHelperService.displayShortDate(dateHelperService.convertStringToDate(.vars['reserved-article-display-date'].getData(), "EEE, dd MMM yyyy hh:mm:ss Z"), locale)} 
            - <@liferay_ui.message key="eu.modified-on" /> 
            ${dateHelperService.displayShortDate(dateHelperService.convertStringToDate(.vars['reserved-article-modified-date'].getData(), "EEE, dd MMM yyyy hh:mm:ss Z"), locale)} 
        </p>
        <a href="#" class="add-favorites"
            data-type="6" 
            data-title="${title.getData()}" 
            data-url="${currentUrl}" 
            data-group-id=${themeDisplay.scopeGroupId}
            data-id="${.vars['reserved-article-id'].data}">
            <span><@liferay_ui.message key="eu.add-to-favorite" /></span>
        </a>
    </div>
    <h1>
        ${title.getData()}
        <#assign journalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService")>
        <#assign journalArticle = journalArticleLocalService.getArticle(groupId, .vars['reserved-article-id'].data)>
        <#assign assetEntryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService") />
        <#assign asset = assetEntryLocalService.getEntry('com.liferay.journal.model.JournalArticle', journalArticle.getResourcePrimKey()) >
        <#assign assetVocabularyHelper = serviceLocator.findService("eu.strasbourg.utils.api.AssetVocabularyHelperService") />
        <#assign newsTypes = assetVocabularyHelper.getAssetEntryCategoriesByVocabulary(asset, "type d'actualite") />
        <#if newsTypes?has_content>
            <p class="seu-event-categories">
                <#list newsTypes as type>
                        <a href="${homeURL}actualite?_eu_strasbourg_portlet_search_asset_SearchAssetPortlet_categoriesIds=${type.getCategoryId()}&p_p_id=eu_strasbourg_portlet_search_asset_SearchAssetPortlet">
                            ${type.getTitle(locale)}
                        </a>
                        <#sep>, </#sep>
                </#list>
            </p>
        </#if>
    </h1>
    <div class="hat">
        <div>
            ${chapo.getData()}
        </div>
    </div>
    <div class="rte">
        ${content.getData()}
    </div>
</main>
<#if image.getData()?has_content>
    <script>
        if ($('.region-banner').length == 0) {
            var bannerHtml = '<div class="region-banner"></div>';
            $('.region-post-header').addClass('has-banner').prepend(bannerHtml);
        }
    </script>
    <style>
        .region-banner {
            background-image: url(${image.getData()}) !important;
        }
    </style>
</#if>
<style>
.search-asset-portlet, .page-header {
    display: none !important;
}
</style>