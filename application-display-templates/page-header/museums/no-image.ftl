<!-- Entête de page - sans image -->
<#setting locale = locale />
<div class="page-header">
    <div class="page-header-info">
        <div class="page-header-title-and-share">
            <div class="page-header-title">
                <h1>${page.getName(locale)}</h1>
            </div>
            <div class="page-header-share">
                <span><@liferay_ui.message key="eu.share-page" /></span>
                <div class="page-header-share-buttons">
                    <a href="https://www.facebook.com/sharer.php?u=${currentURL}" target="_blank"><div class="facebook"></div></a>
                    <div class="twitter"></div>
                </div>
            </div>
        </div>
        <div class="page-header-description">
            ${page.getDescription(locale)}
        </div>
    </div>
</div>