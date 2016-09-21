<#if entries?has_content>
    <div class="items-carousel news-carousel">
        <h3 class="items-carousel-title"><@liferay_ui["message"] key="eu.our" /> <span><@liferay_ui["message"] key="eu.news" /></span></h3>
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
    </div>
</#if>
