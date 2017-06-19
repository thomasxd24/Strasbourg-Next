<!DOCTYPE html>

<#include init />

<#assign currentGroup = layout.getGroup() />
<#assign currentGroupName = currentGroup.getName() />
<#assign isHome = layout.getFriendlyURL() == "/accueil" />
<#if locale.language == "en">
  <#assign websiteUrl = "http://www.en.strasbourg.eu" />
<#else>
  <#if locale.language == "fr">
    <#assign websiteUrl = "http://www.strasbourg.eu" />
  <#else>
    <#if locale.language == "de">
      <#assign websiteUrl = "http://www.de.strasbourg.eu" />
    </#if>
  </#if>
</#if>

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}" class="no-js">

  <head>
    <title>${the_title} | ${currentGroupName}</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
      <meta name="description" content="" />
    <meta content="" name="keywords">
    <meta name="format-detection" content="telephone=no">

    <link rel="Shortcut icon" href="${images_folder}/favicon/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" sizes="57x57" href="${images_folder}/favicon/apple-touch-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="${images_folder}/images/favicon/apple-touch-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="${images_folder}/images/favicon/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="${images_folder}/images/favicon/apple-touch-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="${images_folder}/images/favicon/apple-touch-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="${images_folder}/images/favicon/apple-touch-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="${images_folder}/images/favicon/apple-touch-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="${images_folder}/images/favicon/apple-touch-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="${images_folder}/images/favicon/apple-touch-icon-180x180.png">
    <link rel="icon" type="image/png" href="${images_folder}/favicon/favicon-32x32.png" sizes="32x32">
    <link rel="icon" type="image/png" href="${images_folder}/favicon/android-chrome-192x192.png" sizes="192x192">
    <link rel="icon" type="image/png" href="${images_folder}/favicon/favicon-96x96.png" sizes="96x96">
    <link rel="icon" type="image/png" href="${images_folder}/favicon/favicon-16x16.png" sizes="16x16">

    <link rel="stylesheet" type="text/css" href="${css_folder}/sae.css" media="screen" />

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <@liferay_util["include"] page=top_head_include />

  </head>

  <body class="${css_class} <#if isHome> front-home </#if> <#if !isHome> class-inner </#if>">
    
    <@liferay_ui["quick-access"] contentId="#main-content" />

    <@liferay_util["include"] page=body_top_include />
    <@liferay.control_menu />
      
    <!-- Menu responsive -->
    <nav id="mmenu" data='mmenu'>
      <ul class="list-principal">
      </ul>
    </nav>

    <main id="skiptocontent" class="wrapper" role="main">
      <!-- Header -->
      <!-- pre-header -->
      <nav class="nav-lang"> 
        <div class="center"> 
          <a href="http://www.europtimist.eu/" title="Strasbourg.eu (<@liferay.language key="new-window" />" class="logo-strasbourg" target="_blank">
            <img src="${images_folder}/pre-header/logo_strasbourg.png" alt="Strasbourg.eu" />
          </a>
          <ul style="display: none;"> 
            <li <#if locale.language == "fr"> class="active" </#if> ><a accesskey="1" href="${portalUtil.getLayoutURL(themeDisplay.getLayout(),themeDisplay)}?p_p_id=82&amp;p_p_lifecycle=1&amp;p_p_state=normal&amp;p_p_mode=view&amp;_82_struts_action=%2Flanguage%2Fview&amp;languageId=fr_FR" title="Français">FR</a></li>
            <li <#if locale.language == "en"> class="active" </#if> ><a accesskey="1" href="${portalUtil.getLayoutURL(themeDisplay.getLayout(),themeDisplay)}?p_p_id=82&amp;p_p_lifecycle=1&amp;p_p_state=normal&amp;p_p_mode=view&amp;_82_struts_action=%2Flanguage%2Fview&amp;languageId=en_US" title="English">EN</a></li>
            <li <#if locale.language == "de"> class="active" </#if> ><a accesskey="1" href="${portalUtil.getLayoutURL(themeDisplay.getLayout(),themeDisplay)}?p_p_id=82&amp;p_p_lifecycle=1&amp;p_p_state=normal&amp;p_p_mode=view&amp;_82_struts_action=%2Flanguage%2Fview&amp;languageId=de_DE" title="Deutsch">DE</a></li>
          </ul>
          <div class="clearfix"></div> 
        </div> 
      </nav>
      <!-- Header HP comprenant la video / menu principal + sous menu / la popup search / le titre -->
      <header class="page-header">
         <#if !isHome>
          <div style="display: none">
        </#if>
        <#assign VOID = freeMarkerPortletPreferences.setValue("portletSetupPortletDecoratorId", "barebone") />
        <@liferay_portlet["runtime"]
          defaultPreferences="${freeMarkerPortletPreferences}"
          portletProviderAction=portletProviderAction.VIEW
          portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
          instanceId="header-sae"
          settingsScope="group" />
        ${freeMarkerPortletPreferences.reset()}
        <#if !isHome>
          </div>
	        <script>
		        var elements = document.getElementsByClassName('parameter-video');
		        while(elements.length > 0){
		            elements[0].parentNode.removeChild(elements[0]);
		        }
	        </script>
        </#if>
        <#include "${full_templates_path}/navigation.ftl" />
        
        <div id="search-engine">
          <div class="container">
            <input placeholder="Votre recherche ici" class="search-input" name="keywords" value="" id="keywords" type="text">
            <button type="submit" id="btn-search" name="searchbutton"><img src="${images_folder}/pictos/search-send.png" alt="Recherche"></button> 
          </div>
          <div class="content-close">
            <button type="button" id="search-close" tabindex="0"><img src="${images_folder}/pictos/close.png" alt="Fermer la recherche"></button>
          </div>
        </div>
        <#if isHome>
          <!-- Contenu web header-title-sae -->
          <#assign VOID = freeMarkerPortletPreferences.setValue("portletSetupPortletDecoratorId", "barebone") />
          <@liferay_portlet["runtime"]
            defaultPreferences="${freeMarkerPortletPreferences}"
            portletProviderAction=portletProviderAction.VIEW
            portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
            instanceId="header-title-sae"
            settingsScope="group" />
          ${freeMarkerPortletPreferences.reset()}
        </#if>
      
        <#if !isHome>
          <div class="fil-ariane">
            <div class="container">
              <div class="nav">
                <#assign layoutService = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService") />
                <#assign parentURL = "/" />
                <#if layout.getParentPlid() gt 0>
                  <#assign parentLayout = layoutService.fetchLayout(layout.getParentPlid()!0) />
                  <#assign parentName = parentLayout.getName(themeDisplay.getLocale()) />
                  <#assign parentURL = parentLayout.getFriendlyURL() />
                </#if>
                <ul class="back-to">
                <#if parentLayout?has_content>
                  <li class="back-to">
                    <a href="${parentURL}">Retour vers "${parentName}"</a>
                  </li>
                <#else>
                  <li class="back-to">
                    <a href="${parentURL}">Retour vers "Accueil"</a>
                  </li>
                </#if>
                </ul>
                <@liferay.breadcrumbs />
              </div>
            </div>
        </#if>
      </header>
      <!-- End header -->

      <div class="content">
        <section class="">
            <#if selectable>
              <@liferay_util["include"] page=content_include />
            <#else>
              ${portletDisplay.recycle()}

              ${portletDisplay.setTitle(the_title)}

              <@liferay_theme["wrap-portlet"] page="portlet.ftl">
                <@liferay_util["include"] page=content_include />
              </@>
            </#if>
        </section>    
      </div>

      <!-- FOOTER -->
      <footer class="footer">
        <#assign VOID = freeMarkerPortletPreferences.setValue("portletSetupPortletDecoratorId", "barebone") />
        <@liferay_portlet["runtime"]
          defaultPreferences="${freeMarkerPortletPreferences}"
          portletProviderAction=portletProviderAction.VIEW
          portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
          instanceId="footer"
          settingsScope="group" />
        ${freeMarkerPortletPreferences.reset()}
        <!-- <div class="closure">
            <div class="center">
                <a href="${websiteUrl}" title="Strasbourg.eu (<@liferay_ui.message key='new-window' />)" target="_blank">Strasbourg.eu</a>
            </div>
        </div> -->
      </footer>
      <!-- END FOOTER -->

    </main>
    <script type="text/javascript" src="${javascript_folder}/bootstrapValidator.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${javascript_folder}/owl.carousel.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${javascript_folder}/parallax.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${javascript_folder}/jquery.dotdotdot.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${javascript_folder}/jquery.mmenu.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${javascript_folder}/device.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${javascript_folder}/custom-select.js" charset="utf-8"></script>
    <script type="text/javascript" src="${javascript_folder}/environment.js" charset="utf-8"></script>
    <script type="text/javascript" src="${javascript_folder}/based.js" charset="utf-8"></script>
    <@liferay_util["include"] page=body_bottom_include />
    <@liferay_util["include"] page=bottom_include />
 </body>
</html>