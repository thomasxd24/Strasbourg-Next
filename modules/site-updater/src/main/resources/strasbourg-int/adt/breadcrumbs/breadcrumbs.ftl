<!-- Fil d'ariane -->
<#setting locale = locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>
<div class="region-nav-tools">
    <div class="block-container-breadcrumb">
        <h2 class="hidden">Vous êtes ici</h2>
        <a href="../" class="back">Précédent</a>
        <ul class="page-depth">
            <li>
                <a href="${homeURL}"><@liferay_ui.message key="home" /></a>
            </li>
            <#if entries?has_content>
                <#list entries as curEntry>
                    <#if !curEntry.baseModel?has_content || curEntry.baseModel.friendlyURL != '/accueil'>
                        <li>
                            <#if curEntry?is_last>
                                <div class="page active">${curEntry.getTitle()}</div>
                            <#else>
                                <#if curEntry.getURL()?has_content>
                                    <a href="${curEntry.getURL()}">${curEntry.getTitle()}</a>
                                <#else>
                                    <div class="page active">${curEntry.getTitle()}</div>
                                </#if>
                            </#if>
                        </li>
                    </#if>
                </#list>
            </#if>
        </ul>
    </div>
</div>