<#setting locale = locale />

<!-- Slider d'images -->
<#assign fileEntryHelper = serviceLocator.findService("eu.strasbourg.utils.api.FileEntryHelperService") />
<div class="mns-slider-full">
    <div class="owl-carousel owl-theme" id="owl-slider">
        <#if image?has_content && image.getSiblings()?has_content>
            <#list image.getSiblings() as curImage>
                <div class="item">
                    <figure>
                        <img src="${curImage.data}" alt="${curImage.children[0].data}" />
                    </figure>
                    <div class="caption">
                        <h3>${curImage.children[0].data}</h3>
                        <p style="color: white;">${curImage.children[1].data}</p>
                    </div>
                </div>
            </#list>
        </#if>
    </div>
</div>