<!--
Application Display Template par défaut utilisé pour le site des musées.
Affichage de l'ensemble des sous-pages, avec l'image si elle existe
Si la sous-page a elle même des sous-pages, affichage de celles-ci
Sinon affichage de la description
-->
<#list entries as currentPage>
  <div class="rubric-page">
    <div class="rubric-page-image">
      <a href="${themeDisplay.pathFriendlyURLPublic}${currentPage.group.friendlyURL}${currentPage.friendlyURL}">
        <img src="${currentPage.expandoBridge.attributes["image"]}" />
      </a>
    </div>
    <div class="rubric-page-name">
      <a href="${themeDisplay.pathFriendlyURLPublic}${currentPage.group.friendlyURL}${currentPage.friendlyURL}">
        ${currentPage.getName(locale)}
      </a>
    </div>
    <#if currentPage.children?has_content>
      <ul class="rubric-page-links" role="nav">
        <#list currentPage.children as currentSubPage>
          <li>
            <a href="${themeDisplay.pathFriendlyURLPublic}${currentPage.group.friendlyURL}${currentSubPage.friendlyURL}">
              ${currentSubPage.getName(locale)}
            </a>
          </li>
        </#list>
      </ul>
    <#else>
      <div class="rubric-page-description">
        <p>
          ${currentPage.getDescription(locale)}
        </p>
      </div>
      <div class="rubric-page-read-more">
        <a href="${themeDisplay.pathFriendlyURLPublic}${currentPage.group.friendlyURL}${currentPage.friendlyURL}">
          <@liferay_ui.message key="read-more" />
        </a>
      </div>
    </#if>
  </div>
</#list>
