<#setting locale = locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostnames?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${page.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>
<header class="mns-header-standard">
    <div class="container">
        <h1>${page.getName(locale)}</h1>
        <div class="mns-wrapper-bread">
            <div class="mns-breadcrumbs mns-bread-color">
                 <#if !page.ancestors?has_content || page.ancestors?reverse[0].friendlyURL != '/accueil'>
                    <a href="${homeURL}"><@liferay_ui.message key="home" /></a>
                </#if>
                <#list page.ancestors?reverse as ancestor>
                    <a href="${homeURL}${ancestor.friendlyURL?remove_beginning('/')}">${ancestor.getName(locale)}</a>
                </#list>
                <span>${page.getName(locale)}</span>
            </div>
        </div>
    </div>
</header>
<script>
    $('.navbar.mns-nav').addClass('mns-nav-no-header');
</script>