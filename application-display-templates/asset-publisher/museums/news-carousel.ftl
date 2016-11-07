<#if entries?has_content>
    <div class="items-carousel news-carousel">
        <h3 class="items-carousel-title">
            <@liferay_ui["message"] key="eu.our" /> 
            <br><span><@liferay_ui["message"] key="eu.news" /></span>

            <#assign PortalUtil = staticUtil["com.liferay.portal.kernel.util.PortalUtil"] />
            <!-- Le lien vers la page de toutes les actualités est défini comme étant la page "/videos", modifier la ligne ci-dessous si besoin -->
            <a href="https://facebook.com/"><@liferay_ui.message key="eu.join-us" /></a>
            <a href="${PortalUtil.getGroupFriendlyURL(themeDisplay.getLayoutSet(), themeDisplay)}/actualites"><@liferay_ui.message key="eu.news.all-news" /></a>    
        </h3>
        <div class="owl-carousel ">
          <#list entries as curEntry>
            <#assign docXml = saxReaderUtil.read(curEntry.getAssetRenderer().getArticle().getContentByLocale(locale)) />
            <#assign title = docXml.valueOf("//dynamic-element[@name='title']/dynamic-content/text()") />
            <#assign chapo = docXml.valueOf("//dynamic-element[@name='chapo']/dynamic-content/text()") />
            <#assign image = docXml.valueOf("//dynamic-element[@name='image']/dynamic-content/text()") />
            <#assign content = docXml.valueOf("//dynamic-element[@name='content']/dynamic-content/text()") />
            <#assign publishDate = curEntry.getPublishDate() />
            <#assign currentURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, curEntry) />
            <#assign viewURL = curEntry.getAssetRenderer().getURLViewInContext(renderRequest, renderResponse, currentURL) />
            <div class="item"> 
                <div class="item-image">
                    <a href="${viewURL}">
                        <img src="${image}" >
                    </a>
                </div>
                <div class="item-info">
                    <div class="item-date">
                        <date><@liferay_ui["message"] key="eu.published-on" /> ${publishDate?date}</date>
                    </div>
                    <div class="item-title">
                        <h4><a href="${viewURL}">${title}</a></h4>
                    </div>
                    <div class="item-content">
                        ${chapo}
                    </div>
                </div>
            </div>
          </#list>
        </div>
        <div class="news-secondary-links">
            <a href="${PortalUtil.getGroupFriendlyURL(themeDisplay.getLayoutSet(), themeDisplay)}/actualites"><@liferay_ui.message key="eu.news.all-news" /></a>  
            <a href="https://facebook.com/"><@liferay_ui.message key="eu.join-us" /></a>
        </div>
    </div>
</#if>
