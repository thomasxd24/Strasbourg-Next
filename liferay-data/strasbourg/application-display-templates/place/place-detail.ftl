<!-- Detail lieu -->
<#setting locale=locale />

<#assign imageUrl="" />
<!-- 1ere image au dessus de l'adresse -->
<#if entry.imagesURLs?first?has_content>
    <#assign imageUrl=themeDisplay.getPortalURL() + entry.imagesURLs?first?replace('@', ""
        )?replace('cdn_hostroot_path', "" ) />
</#if>
<!-- banniere -->
<#if entry.imageURL?has_content>
    <#assign imageUrl=themeDisplay.getPortalURL() + entry.imageURL?replace('@', "" )?replace('cdn_hostroot_path', ""
        ) />
</#if>

<#-- Liste des infos a partager -->
<#assign openGraph={ "og:title" :"${entry.getAlias(locale)?html}", "og:description"
:'${entry.getPresentation(locale)?replace("<[^>]*>", "", "r")?html}',
"og:image":"${imageUrl}"
} />

<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}

<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content ||
    themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
    <#else>
        <#assign homeURL="/" />
</#if>

<#assign fileEntryHelper=serviceLocator.findService("eu.strasbourg.utils.api.FileEntryHelperService") />
<#assign
    EventLocalService=serviceLocator.findService("eu.strasbourg.service.agenda.service.EventLocalService") />

    <div class="st-barre-single-sit">
        <div class="st-barre-inner st-wrapper">
            <div class="st-container-left">
                <div class="st-image">
                    <figure class="st-fit-cover" role="group">
                        <picture>
                            <!-- <img width="" height="" alt="" src="${imageUrl}"> -->
                            <img width="" height="" alt="" src="https://placehold.co/80x80?text=a+changer">
                        </picture>
                    </figure>
                </div>
                <div class="st-content">
                    <p class="st-title">${entry.getAlias(locale)}</p>
                    <address><#if entry.addressStreet?has_content>
                        ${entry.addressStreet} <br>
                    </#if>
                    <#if entry.addressComplement?has_content>
                        ${entry.addressComplement} <br>
                    </#if>
                    <#if entry.addressDistribution?has_content>
                        ${entry.addressDistribution} <br>
                    </#if>
                    ${entry.addressZipCode} ${entry.getCity(locale)}
                    </address>
                    <#if !entry.isOpenNow()>
                        <p class="st-ouverture st--open">Ouvert actuellement</p>
                    <#else>
                        <p class="st-ouverture st--closed">Ferme actuellement</p>
                    </#if>
                </div>
            </div>
            <div class="st-container-right">
                <ul class="st-liens-rapides">
                    <li>
                        <a href="#" class="st-btn-icon-outline" target="_blank" rel="noopener"
                           title="Ouvrir le lien (nouvelle )">
                            <span class="st-icon-clock" aria-hidden="true"></span>
                        </a>
                    </li>
                    <#if entry.phone?has_content>
                        <li>
                            <a href="tel:0325030111" class="st-btn-icon-outline" target="_blank" rel="noopener"
                            title="<@liferay_ui.message key="phone" /> : ${entry.phone}">
                                <span class="st-icon-phone" aria-hidden="true"></span>
                            </a>
                        </li>
                    </#if>
                    <li>
                        <button class="st-btn-icon-outline" data-overlay-open="overlay-contactsit"
                                aria-label="Nous contacter par mail">
                            <span class="st-icon-email" aria-hidden="true"></span>
                        </button>
                    </li>
                        <#if entry.getSiteLabel(locale)?has_content && entry.getSiteURL(locale)?has_content>
                            <li>
                                <a href="${entry.getSiteURL(locale)}" class="st-btn-icon-outline" target="_blank" rel="noopener"
                                title="${entry.getSiteLabel(locale)}">
                                    <span class="st-icon-web" aria-hidden="true"></span>
                                </a>
                            </li>
                        </#if>
                        <#if entry.getFacebookLabel(locale)?has_content && entry.getFacebookURL(locale)?has_content>
                            <li>
                                <a href="${entry.getFacebookURL(locale)}" class="st-btn-icon-outline" target="_blank" rel="noopener"
                                   title="${entry.getFacebookLabel(locale)}">
                                    <span class="st-icon-facebook" aria-hidden="true"></span>
                                </a>
                            </li>
                        </#if>
                        <#if entry.getInstagramLabel(locale)?has_content && entry.getInstagramURL(locale)?has_content>
                            <li>
                                <a href="${entry.getInstagramURL(locale)}" class="st-btn-icon-outline" target="_blank" rel="noopener"
                                   title="${entry.getInstagramLabel(locale)}">
                                    <span class="st-icon-instagram" aria-hidden="true"></span>
                                </a>
                            </li>
                        </#if>
                    
                    
                </ul>
    
                <button class="st-btn-favoris" data-addpanier="10525">
                    Ajouter aux favoris
                </button>

                <div class="st-social-share">
                    <input class="st-toggle-input" id="toggle-input" type="checkbox">
                    <label for="toggle-input" class="st-toggle">
                        <span class="st-icon-social-share"></span>
                    </label>
                
                    <ul class="st-network-list">
                        <li>
                            <a href="#facebook" aria-label="Partagez sur Facebook"
                               class="st-btn-social st-icon-facebook st-ga-event-facebook" target="_blank"
                               title="Lien de partage sur Facebook"></a>
                        </li>
                        <li>
                            <a href="#twitter" aria-label="Partagez sur Twitter"
                               class="st-btn-social st-icon-twitter st-ga-event-twitter" target="_blank"
                               title="Lien de partage sur Twitter"></a>
                        </li>
                        <li>
                            <a href="#linkedin" aria-label="Partagez sur LinkedIn"
                               class="st-btn-social st-icon-linkedin st-ga-event-linkedin" target="_blank"
                               title="Lien de partage sur LinkedIn"></a>
                        </li>
                        <li>
                            <a href="#Mail" aria-label="Partagez par Email" class="st-btn-social st-icon-email st-ga-event-mail"
                               title="Lien de partage par Email"></a>
                        </li>
                    </ul>
                </div>
                
            </div>
        </div>
    </div>
    

<main class="st-fiche st-fiche-mediatheque" role="main" tabindex="-1">
    <header
        class="st-header-fiche-lieu <#if entry.isEnabled()>st--sans-image<#else>st--avec-image</#if>"
        role="banner">
        <div class="st-wrapper st-wrapper-small">
            <h1>${entry.getAlias(locale)}</h1>
            <ul class="st-breadcrumbs" aria-label="Fil d'ariane de la page">
                <li class="st-breadcrumbs__item">
                    <a href="/" class="st-breadcrumbs__link">Accueil</a>
                </li>
                <li class="st-breadcrumbs__item">
                    <a href="#" class="st-breadcrumbs__link">Pratique</a>
                </li>
                <li class="st-breadcrumbs__item">
                    <a href="#" class="st-breadcrumbs__link">Rechercher un lieu public</a>
                </li>
                <li class="st-breadcrumbs__item">
                    <span>${entry.getAlias(locale)}</span>
                </li>
            </ul>
        </div>

        <div class="st-wrapper st-cover-container">
            <#if entry.isEnabled()>
                <div class="st-top-bar">
                    <h2 class="st-title">Affluence faible</h2>
                    <div class="st-content">
                        <p class="st-frequentation">
                            14 personnes
                        </p>
                        <p class="st-surtitre-cat">
                            sur une capacite maximum de 250 personnes
                        </p>
                        <p class="st-small-text">
                            La frequentation est donnee a titre indicatif et dans la configuration ou
                            tous les bassins
                            sont ouverts
                        </p>
                    </div>
                </div>
                <#else>
                    <div class="st-image">
                        <span class="st-credits" aria-hidden="true"> Abraham Lebowski</span>
                        <figure class="st-fit-cover figcaption-only-credits" role="group"
                            aria-label="Photo,  Abraham Lebowski">
                            <picture>
                                <img width="" height="" alt="Photo" src="${imageUrl}">
                            </picture>
                            <figcaption>
                                <span class="st-sr-only">Photo, Abraham Lebowski</span>
                            </figcaption>
                        </figure>
                    </div>
            </#if>
            <div class="maps" data-lat="${ entry.getMercatorY() }" data-lng="${ entry.getMercatorX() }" data-callback="initMap" data-zoom="17">

            </div>
        </div>
    </header>

    <div class="st-content">

        <!-- Horaires -->
        <#if entry.periods?has_content || entry.hasURLSchedule>
            <div class="st-sit-onglet st-wrapper st-wrapper-small">
                <h2 class="st-bloc-title">
                    <@liferay_ui.message key="eu.times" />
                </h2>
                <div class="st-container">
                    <div class="st-slider-thumb st-js-slider-onglet splide" role="group"
                        aria-label="Slider avec des informations sur les horaires de visite">
                        <div class="splide__track">
                            <ul class="splide__list">
                                <li class="splide__slide st-single-ancre">
                                    <p class="st-title">
                                        <@liferay_ui.message key="eu.place.next-days" />
                                    </p>
                                </li>
                                <#if entry.defaultPeriod?has_content>
                                    <li class="splide__slide st-single-ancre">
                                        <p class="st-title">${entry.defaultPeriod.getName(locale)}
                                        </p>
                                    </li>
                                </#if>

                                <!-- Autres periodes -->
                                <#list entry.nonDefaultPeriods as period>
                                    <li class="splide__slide st-single-ancre">
                                        <p class="st-title">${period.getName(locale)}</p>
                                        <p class="st-date">${period.getDisplay(locale)}</p>
                                    </li>
                                </#list>

                            </ul>
                        </div>
                        <div class="splide__arrows st-nav-arrows">
                            <button
                                class="splide__arrow splide__arrow--prev st-btn-arrow st--prev"></button>
                            <button
                                class="splide__arrow splide__arrow--next st-btn-arrow st--next"></button>
                        </div>
                    </div>
                    <div class="st-slider-content st-js-slider-onglet-content splide" role="group"
                        aria-label="Contenu des slides">

                        <div class="splide__track">
                            <ul class="splide__list">

                                <!-- Jours suivants -->
                                <li class="splide__slide st-single-slide">
                                    <#if entry.publishedSubPlaces?has_content>
                                        <p class="st-title">${entry.getAlias(locale)}</p>
                                    </#if>
                                    
                                    <ul class="st-single-slide-container">
                                        <#assign daySchedulesMap=entry.getFollowingWeekSchedules(.now,
                                            locale) />
                                        <#assign hasException=false />
                                        <#list daySchedulesMap?keys as day>
                                            <!-- Correctif car suite a une modif on n'envoie plus une liste vide mais null, donc erreur freemarker -->
                                            <#if daySchedulesMap[day]?size !=1 ||
                                                (daySchedulesMap[day]?size==1 &&
                                                daySchedulesMap[day][0]?? &&
                                                daySchedulesMap[day][0]?has_content)>

                                                <li>
                                                    <p class="st-title">${day}</p>
                                                    <div class="st-info">
                                                        <#list daySchedulesMap[day] as schedule>
                                                            <#if schedule.isException() ||
                                                                schedule.isPublicHoliday()>
                                                                <#assign hasException=true />
                                                                <#assign hasAnyException=true />
                                                                <#else>
                                                                    <#assign hasException=false />
                                                            </#if>
                                                            <#if schedule.isClosed()>
                                                                <p class="st-ouverture st--closed">
                                                                    <@liferay_ui.message
                                                                        key="eu.closed" />
                                                                </p>
                                                                <#elseif schedule.isAlwaysOpen()>
                                                                    <p class="st-ouverture">
                                                                        <@liferay_ui.message
                                                                            key="always-open" />
                                                                    </p>
                                                                    <#else>
                                                                        <#list schedule.openingTimes as
                                                                            openingTime>
                                                                            <p>
                                                                                ${openingTime.first} -
                                                                                ${openingTime.second}
                                                                                <#if hasException>
                                                                                    <span
                                                                                        class="st-symbol">*</span>
                                                                                </#if>
                                                                            </p>
                                                                            <#if
                                                                                schedule.comments[openingTime?index]?has_content>
                                                                                <p class="st-note">
                                                                                    ${schedule.comments[openingTime?index]}
                                                                                </p>
                                                                            </#if>

                                                                        </#list>
                                                            </#if>
                                                        </#list>

                                                    </div>
                                                </li>

                                            </#if>
                                        </#list>
                                    </ul>
                                    <!-- Jours suivants pour les sous-lieux -->
                                    <#list entry.publishedSubPlaces as subPlace>
                                        <p class="st-title">${subPlace.getName(locale)}</p>
                                        <ul class="st-single-slide-container">
                                            <#assign
                                                daySchedulesMap=subPlace.getFollowingWeekSchedules(.now,
                                                locale) />
                                            <#list daySchedulesMap?keys as day>
                                                <!-- Correctif car suite a une modif on n'envoie plus une liste vide mais null, donc erreur freemarker -->
                                                <#if daySchedulesMap[day]?size !=1 ||
                                                    (daySchedulesMap[day]?size==1 &&
                                                    daySchedulesMap[day][0]?? &&
                                                    daySchedulesMap[day][0]?has_content)>
                                                    <li>
                                                        <p class="st-title">${day}</p>
                                                        <div class="st-info">
                                                            <#list daySchedulesMap[day] as schedule>
                                                                <#if schedule.isException() ||
                                                                    schedule.isPublicHoliday()>
                                                                    <#assign hasException=true />
                                                                    <#assign hasAnyException=true />
                                                                    <#else>
                                                                        <#assign hasException=false />
                                                                </#if>
                                                                <#if schedule.isClosed()>
                                                                    <p class="st-ouverture st--closed">
                                                                        <@liferay_ui.message
                                                                            key="eu.closed" />
                                                                    </p>
                                                                    <#elseif schedule.isAlwaysOpen()>
                                                                        <p class="st-ouverture">
                                                                            <@liferay_ui.message
                                                                                key="always-open" />
                                                                        </p>
                                                                        <#else>
                                                                            <#list schedule.openingTimes
                                                                                as openingTime>
                                                                                <p>
                                                                                    ${openingTime.first}
                                                                                    -
                                                                                    ${openingTime.second}
                                                                                    <#if hasException>
                                                                                        <span
                                                                                            class="st-symbol">*</span>
                                                                                    </#if>
                                                                                </p>
                                                                                <#if
                                                                                    schedule.comments[openingTime?index]?has_content>
                                                                                    <p class="st-note">
                                                                                        ${schedule.comments[openingTime?index]}
                                                                                    </p>
                                                                                </#if>

                                                                            </#list>
                                                                </#if>

                                                            </#list>
                                                        </div>
                                                    </li>
                                                </#if>
                                            </#list>
                                        </ul>
                                    </#list>
                                    <#if hasAnyException?has_content && hasAnyException>
                                        <!-- Message pour exceptions -->
                                        <p class="st-note">
                                            <@liferay_ui.message
                                                key="eu.place.look-at-exceptionnal-schedule" />
                                        </p>
                                    </#if>

                                </li>

                                <!-- Periode par defaut -->
                                <#if entry.defaultPeriod?has_content>
                                    <li class="splide__slide st-single-slide">
                                        <#if entry.publishedSubPlaces?has_content>
                                            <p class="st-title">${entry.getAlias(locale)}</p>
                                        </#if>
                                        <ul class="st-single-slide-container">
                                            <#assign
                                                weekSchedules=entry.defaultPeriod.getWeekSchedule() />
                                            <#assign day=0 />
                                            <#list weekSchedules as schedule>
                                                <@showTime day schedule hasException />
                                                <#assign day=day + 1 />
                                            </#list>
                                        </ul>
                                        <!-- Periode par defaut pour les sous-lieux -->
                                        <#list entry.publishedSubPlaces as subPlace>
                                            <p class="st-small-title">${subPlace.getName(locale)}
                                            </p>
                                            <ul class="st-single-slide-container">
                                                <#assign
                                                    weekSchedules=subPlace.defaultPeriod.getWeekSchedule(subPlace.subPlaceId) />
                                                <#assign day=0 />
                                                <#list weekSchedules as schedule>
                                                    <@showTime day schedule hasException />
                                                    <#assign day=day + 1 />
                                                </#list>
                                            </ul>
                                        </#list>
                                        <#if hasAnyException?has_content && hasAnyException>
                                            <!-- Message pour exceptions -->
                                            <p class="st-note">
                                                <@liferay_ui.message
                                                    key="eu.place.look-at-exceptionnal-schedule" />
                                            </p>
                                        </#if>

                                    </li>
                                </#if>

                                <!-- Autres periodes -->
                                <#list entry.nonDefaultPeriods as period>
                                    <li class="splide__slide st-single-slide">
                                        <#if entry.publishedSubPlaces?has_content>
                                            <p class="st-title">${entry.getAlias(locale)}</p>
                                        </#if>
                                        
                                        <ul class="st-single-slide-container">
                                            <#assign weekSchedules=period.getWeekSchedule() />
                                            <#assign day=0 />
                                            <#list weekSchedules as schedule>
                                                <@showTime day schedule hasException />
                                                <#assign day=day + 1 />
                                            </#list>
                                        </ul>
                                        <!-- Periode par defaut pour les sous-lieux -->
                                        <#list entry.publishedSubPlaces as subPlace>
                                            <p class="st-small-title">${subPlace.getName(locale)}
                                            </p>
                                            <ul class="st-single-slide-container">
                                                <#assign
                                                    weekSchedules=subPlace.defaultPeriod.getWeekSchedule(subPlace.subPlaceId) />
                                                <#assign day=0 />
                                                <#list weekSchedules as schedule>
                                                    <@showTime day schedule hasException />
                                                    <#assign day=day + 1 />
                                                </#list>
                                            </ul>
                                        </#list>
                                        <#if hasAnyException?has_content && hasAnyException>
                                            <!-- Message pour exceptions -->
                                            <p class="st-note">
                                                <@liferay_ui.message
                                                    key="eu.place.look-at-exceptionnal-schedule" />
                                            </p>
                                        </#if>
                                    </li>


                                </#list>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <#if entry.hasURLSchedule>
                            <a href="${entry.getScheduleLinkURL(locale)}" target="_blank"
                                title="${entry.getScheduleLinkName(locale)} (<@liferay_ui.message key="
                                eu.new-window" />)">
                            <button class="st-btn st--btn-secondary st--btn-full-width">
                                ${entry.getScheduleLinkName(locale)}
                            </button>
                            </a>
                        </#if>
                    </div>
                    <div class="st-bottom-part st-text-styles">
                        <#if !entry.hasURLSchedule>
                            <!-- Liste des exceptions -->
                            <#assign exceptions=entry.getPlaceScheduleExceptionFreeMarker(.now, true,
                                locale) />
                            <#if exceptions?has_content || (hasAnyException?has_content &&
                                hasAnyException)>
                                <#assign totalExceptionsCount=0 />
                                <p class="st-title">
                                    <@liferay_ui.message key="eu.exceptional-closings-openings" />
                                </p>
                                <ul>
                                    <#list exceptions as exception>
                                        <#assign totalExceptionsCount++ />
                                        <li>
                                            <strong>${exception.getPeriodDisplay(locale)}</strong> :
                                            <#if exception.isClosed()>
                                                <@liferay_ui.message key="eu.closed" />
                                                <#else>
                                                    <#list exception.openingTimes as openingTime>
                                                        ${openingTime.first} - ${openingTime.second}
                                                        <#sep>, </#sep>
                                                    </#list>
                                            </#if>
                                            - ${exception.description}
                                        </li>
                                    </#list>
                                    <#list entry.publishedSubPlaces as subPlace>
                                        <#assign
                                            exceptions=subPlace.getSubPlaceScheduleExceptionFreeMarker(.now,
                                            true, locale) />
                                        <#if exceptions?has_content>
                                            <#list exceptions as exception>
                                                <#assign totalExceptionsCount++ />
                                                <li>
                                                    <strong>${subPlace.getName(locale)} -
                                                        ${exception.getPeriodDisplay(locale)}</strong>
                                                    :
                                                    <#if exception.isClosed()>
                                                        <@liferay_ui.message key="eu.closed" />
                                                        <#else>
                                                            <#list exception.openingTimes as
                                                                openingTime>
                                                                ${openingTime.first} -
                                                                ${openingTime.second}<#sep>, </#sep>
                                                            </#list>
                                                    </#if>
                                                    - ${exception.description}
                                                </li>
                                            </#list>
                                        </#if>
                                    </#list>
                                </ul>
                            </#if>
                        </#if>
                        <#if entry.getExceptionalSchedule(locale)?has_content>
                            <p class="st-small-title">
                                <@liferay_ui.message key="eu.exceptional-schedule" />
                            </p>
                            ${entry.getExceptionalSchedule(locale)}

                        </#if>
                    </div>
                </div>
            </div>
        </#if>
        <#if entry.hasScheduleTable()>
            <#assign
                assetVocabularyHelper=serviceLocator.findService("eu.strasbourg.utils.api.AssetVocabularyHelperService") />
            <#list entry.types as type>
                <#if (assetVocabularyHelper.getCategoryProperty(type.categoryId, 'schedule' )=='true' )>
                    <#assign category=type />
                </#if>
            </#list>
            <!-- Listing Lieu meme type -->
            <div class="st-sit-contact st--contact-with-icon st-wrapper st-wrapper-small ">
                <div class="st-container">

                    <div class="st-col-left">
                        <span class="st-icon-piscine" aria-hidden="true"></span>
                    </div>
                    <div class="st-col-right">
                        <div class="st-content">
                            <h2 class="st-h2">Vous preferez aller ailleurs ?</h2>
                            <p class="st-surtitre-cat">Il y a d'autres
                                ${category.getTitle(locale)?lower_case} dans l'eurometropole</p>
                        </div>
                        <a href="${homeURL}horaires-lieux/-/schedules/category/${category.categoryId}"
                            class="st-btn st--btn-secondary">
                            <@liferay_ui.message key="eu.see-all-schedule-of" />
                            ${category.getTitle(locale)?lower_case}
                        </a>
                    </div>
                </div>
            </div>
        </#if>





        <!-- Presentation -->
        <#if entry.getPresentation(locale)?has_content>
            <div class="st-sit-presentation st-wrapper st-wrapper-small">
                <h2 class="st-h2 st-bloc-title">
                    <@liferay_ui.message key="eu.presentation" />
                </h2>
                <div class="st-component-container">
                    <div class="st-limit-height st--is-overflowing">
                        <p>${entry.getPresentation(locale)}</p>
                    </div>
                    <div class="st-show-more">
                        <button class="st-btn-arrow st--down" aria-expanded="false" aria-controls="123"
                            aria-label="Voir tout le texte" data-open-label="Voir tout le texte"
                            data-close-label="Reduire l'affichage du texte">
                        </button>
                    </div>
                </div>
            </div>
        </#if>

        <!-- Agenda  -->
        <#assign
            placeEvents=EventLocalService.getCurrentAndFuturePublishedEventsFromPlace(entry.getSIGid()) />
        <#if entry.displayEvents && placeEvents?has_content>
            <div class="st-sit-agenda st-wrapper st-wrapper-small">
                <h2 class="st-h2 st-sit-title">
                    <@liferay_ui.message key="agenda" />
                </h2>
                <ul class="st-cards-wrapper st-cards-horizontales">
                    <#assign i=0 />
                    <#list placeEvents?sort_by("startDateFirstCurrentAndFuturePeriod") as event>
                        <#if i==5>
                            <#break>
                        </#if>
                        <li>
                            <div class="st-card-container">
                                <a href="${homeURL}evenement/-/entity/id/${event.eventId}/${event.getNormalizedTitle(locale)}"
                                    class="st-card st-card-agenda" title="${event.getTitle(locale)}">
                                    <div class="st-caption">
                                        <p class="st-title-card">${event.getTitle(locale)}</p>
                                        <p class="st-surtitre-cat">Categories event</p>
                                        <p class="st-date">
                                            <#if event.firstStartDate?date==event.lastEndDate?date>
                                                <@liferay_ui.message key="eu.event.the" />
                                                ${event.firstStartDate?date?string['dd/MM']}
                                                <#else>
                                                    <@liferay_ui.message key="eu.event.from-date" />
                                                    ${event.firstStartDate?date?string['dd/MM']}
                                                    <@liferay_ui.message key="eu.event.to" />
                                                    ${event.lastEndDate?date?string['dd/MM']}
                                            </#if>
                                        </p>
                                        <p class="st-location">
                                            ${event.getPlaceAlias(locale)}
                                            <#if event.getPlaceAddress(locale)?has_content>
                                                - ${event.getPlaceAddress(locale)}
                                            </#if>
                                            - ${event.placeZipCode} ${event.getPlaceCity(locale)}
                                        </p>
                                    </div>
                                    <div class="st-image">

                                        <figure class="st-fit-cover" role="group">
                                            <picture>
                                                <img width="" height="" alt=""
                                                    src="${event.getImageURL()}">
                                            </picture>
                                        </figure>

                                    </div>
                                </a>
                                <button class="st-btn-favoris st--only-icon" data-addpanier="postID">
                                    Ajouter a mes favoris
                                </button>

                            </div>
                        </li>
                        <#assign i++>
                    </#list>
                </ul>
                <a href="${homeURL}agenda?idSIGPlace=${entry.getSIGid()}"
                    class="st-btn st--btn-secondary">Tous les evenements</a>
            </div>
        </#if>
        <!-- Fin Agenda -->

        <!-- Activite -->
        <#assign
            activityLocalService=serviceLocator.findService("eu.strasbourg.service.activity.service.ActivityLocalService") />
        <#assign placeActivityAgenda=activityLocalService.getPlaceAgenda(entry.getSIGid(), locale) />
        <#if placeActivityAgenda.periods?has_content>
            <div class="st-sit-onglet st-wrapper st-wrapper-small">
                <h2 class="st-bloc-title">
                    <@liferay_ui.message key="eu.activity.activities" />
                </h2>
                <div class="st-container">
                    <div class="st-slider-thumb st-js-slider-onglet splide" role="group"
                        aria-label="Slider avec des informations sur les horaires de visite">
                        <div class="splide__track">
                            <ul class="splide__list">
                                <#list placeActivityAgenda.periods as period>
                                    <li class="splide__slide st-single-ancre">
                                        <p class="st-title">${period.periodName}</p>
                                    </li>
                                </#list>
                            </ul>
                        </div>
                        <div class="splide__arrows st-nav-arrows">
                            <button
                                class="splide__arrow splide__arrow--prev st-btn-arrow st--prev"></button>
                            <button
                                class="splide__arrow splide__arrow--next st-btn-arrow st--next"></button>
                        </div>
                    </div>
                    <div class="st-slider-content st-js-slider-onglet-content splide" role="group"
                        aria-label="Contenu des slides">
                        <div class="splide__track">
                            <ul class="splide__list">
                                <#list placeActivityAgenda.periods as period>
                                    <li class="splide__slide st-single-slide">
                                        <#list period.courses as course>
                                            <div class="st-detail-lien">
                                                <p class="st-small-title">${course.courseName}</p>
                                                <a href="${homeURL}cours/-/entity/id/${course.courseId}"
                                                    class="st-btn st--btn-secondary st--btn-xs">
                                                    <@liferay_ui.message key="eu.see-detail" />
                                                </a>
                                            </div>
                                            <ul class="st-single-slide-container">
                                                <#list 0..6 as day>
                                                    <#assign schedules=course.getSchedulesForDay(day) />
                                                    <#if schedules?has_content>
                                                        <li>
                                                            <p class="st-title">
                                                                <@liferay_ui.message
                                                                    key="${course.getDayName(day)}" />
                                                            </p>
                                                            <div class="st-info">
                                                                <p>
                                                                    <#list schedules as schedule>
                                                                        ${schedule.startTime} -
                                                                        ${schedule.endTime}<#sep><br>
                                                                        </#sep>
                                                                    </#list>
                                                                </p>
                                                            </div>
                                                        </li>
                                                    </#if>
                                                </#list>
                                            </ul>
                                        </#list>

                                    </li>
                                </#list>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </#if>

          <!-- Documents Utiles/Medias -->
          <#if entry.documentURLs?has_content || entry.videos?has_content>
          <div class="st-bloc st-bloc-liens st-wrapper st-wrapper-small">
            <h2 class="st-bloc-title"><@liferay_ui.message key="eu.place.medias" /></h2>
            <div class="st-component-container">
                <ul class="st-liste st-limit-height">
                    <#list entry.documentURLs as fileURL>
                        <#if fileURL?has_content>
                            <#assign file = fileEntryHelper.getFileEntryByRelativeURL(fileURL) />
                            <#assign title = fileEntryHelper.getFileTitle(file.getFileEntryId(), locale) />
                            <#assign size = fileEntryHelper.getReadableFileEntrySize(file.getFileEntryId(), locale) />
                            <li class="st-lien-container">
                                <a href="${fileURL}" class="st-lien" download>
                                    <p class="st-title-lien">${title}</p>
                                    <div class="st-lien-content">
                                        <p class="st-type">(${file.getExtension()?upper_case} - ${size})</p>
                                        <p class="st-text"><@liferay_ui.message key="download" /></p>
                
                                    </div>
                                    <span class="st-sr-only"><@liferay_ui.message key="download" /></span>
                                </a>
                            </li>
                        </#if>
                    </#list>
                    <!-- A fix pour les video TODO -->
                    <#list entry.videos as video>
                            <li class="st-lien-container">
                                <a href="#" class="st-lien">
                                    <p class="st-title-lien">${video.getTitle(locale)}</p>
                                    <div class="st-lien-content">
                                        <p class="st-type">Video</p>
                                        <p class="st-text">Regarder</p>
                                    </div>
                                </a>
                            </li>
                        </#list>
                </ul>
                <div class="st-show-more">
                    <button class="st-btn-arrow st--down" aria-expanded="false" aria-controls="123"
                        aria-label="Voir tout le texte" data-open-label="Voir tout le texte"
                        data-close-label="Reduire l'affichage du texte">
                    </button>
                </div>
            </div>
        </div>
        </#if>

        <div class="st-sit-info-acces st-wrapper st-wrapper-small">
            <!-- Informations complementaires -->
            <#if entry.getAdditionalInformation(locale)?has_content>
                <div class="st-infos">
                    <div class="st-component-container st-text-styles">
                        <h2 class="st-h2 st-sit-title">
                            <@liferay_ui.message key="eu.place.additional-information" />
                        </h2>
                        <div class="st-limit-height st--is-overflowing">
                            ${entry.getAdditionalInformation(locale)}
                        </div>
                        <div class="st-show-more">
                            <button class="st-btn-arrow st--down" aria-expanded="false"
                                aria-controls="123" aria-label="Voir tout le texte"
                                data-open-label="Voir tout le texte"
                                data-close-label="Reduire l'affichage du texte">
                            </button>
                        </div>
                    </div>
                </div>
            </#if>

          

            <!-- Acces -->
            <#if entry.getAccess(locale)?has_content>
                <div class="st-acces">
                    <div class="st-component-container st-text-styles">
                        <h2 class="st-h2 st-sit-title">
                            <@liferay_ui.message key="access" />
                        </h2>
                        <div class="st-limit-height">
                            ${entry.getAccess(locale)}
                        </div>
                        <div class="st-show-more">
                            <button class="st-btn-arrow st--down" aria-expanded="false"
                                aria-controls="123" aria-label="Voir tout le texte"
                                data-open-label="Voir tout le texte"
                                data-close-label="Reduire l'affichage du texte">
                            </button>
                        </div>
                    </div>
                </div>
            </#if>

        </div>
        <!-- Acces pour handicapes -->
        <#if entry.hasAnyAccessForDisabled() || entry.getAccessForDisabled(locale)?has_content>
            <div class="st-sit-bloc-services-handicap st-wrapper st-wrapper-small">
                <h2 class="st-h2 st-sit-title">
                    <@liferay_ui.message key="eu.access-for-disabled" />
                </h2>
                <ul class="st-meta-wrapper">
                    <#if entry.accessForWheelchair>
                        <li>
                            <span class="st-icon-handicap" aria-hidden="true"></span>
                            <@liferay_ui.message key='eu.access-for-wheelchair' />
                        </li>
                    </#if>
                    <#if entry.accessForDeaf>
                        <li>
                            <span class="st-icon-handicap-vision" aria-hidden="true"></span>
                            <@liferay_ui.message key='eu.access-for-deaf' />">
                        </li>
                    </#if>
                    <#if entry.accessForBlind>
                        <li>
                            <span class="st-icon-handicap-vision" aria-hidden="true"></span>
                            <@liferay_ui.message key='eu.access-for-blind' />
                        </li>
                    </#if>

                    <#if entry.accessForDeficient>
                        <li>
                            <span class="st-icon-handicap-vision" aria-hidden="true"></span>
                            <@liferay_ui.message key='eu.access-for-deficient' />
                        </li>
                    </#if>

                    <#if entry.accessForElder>
                        <li>
                            <span class="st-icon-handicap-vision" aria-hidden="true"></span>
                            <@liferay_ui.message key='eu.access-for-elder' />
                        </li>
                    </#if>
                </ul>
                <div class="st-component-container">
                    <#if entry.getAccessForDisabled(locale)?has_content>
                        <div class="st-limit-height st--is-overflowing">
                            ${entry.getAccessForDisabled(locale)}
                        </div>
                    </#if>
                    <div class="st-show-more">
                        <button class="st-btn-arrow st--down" aria-expanded="false" aria-controls="123"
                            aria-label="Voir tout le texte" data-open-label="Voir tout le texte"
                            data-close-label="Reduire l'affichage du texte">
                        </button>
                    </div>
                </div>
            </div>
        </#if>

        <div class="st-sit-services st-wrapper st-wrapper-small">
            <!-- Services -->
            <#if entry.getServiceAndActivities(locale)?has_content>
                <div class="st-services">
                    <div class="st-component-container st-text-styles">
                        <h2 class="st-h2 st-sit-title">
                            <@liferay_ui.message key="eu.services-and-activities" />
                        </h2>
                        <div class="st-limit-height">
                            ${entry.getServiceAndActivities(locale)}
                        </div>
                        <div class="st-show-more">
                            <button class="st-btn-arrow st--down" aria-expanded="false"
                                aria-controls="123" aria-label="Voir tout le texte"
                                data-open-label="Voir tout le texte"
                                data-close-label="Reduire l'affichage du texte">
                            </button>
                        </div>
                    </div>
                </div>
            </#if>
            <!-- Caracteristiques -->
            <#if entry.getCharacteristics(locale)?has_content>
                <div class="st-caracteristiques">
                    <div class="st-component-container st-text-styles">
                        <h2 class="st-h2 st-sit-title">
                            <@liferay_ui.message key="eu.features" />
                        </h2>
                        <div class="st-limit-height st--is-overflowing">
                            ${entry.getCharacteristics(locale)}
                        </div>
                        <div class="st-show-more">
                            <button class="st-btn-arrow st--down" aria-expanded="false"
                                aria-controls="123" aria-label="Voir tout le texte"
                                data-open-label="Voir tout le texte"
                                data-close-label="Reduire l'affichage du texte">
                            </button>
                        </div>
                    </div>
                </div>
            </#if>


        </div>

        <div class="st-sit-contact st--contact-two-links st-wrapper">
            <div class="st-container">
                <div class="st-col-left">
                    <h2 class="st-h2">Contact</h2>
                    <p class="st-surtitre-cat">${entry.getAlias(locale)}</p>
                </div>
                <div class="st-col-right">
                    <a href="tel:+330388451010" class="st-btn st--btn-secondary">+33 (0)3 88 45 10 10</a>
                    <a href="mailto:contact@thuria.com" class="st-btn st--btn-secondary">Contacter par mail</a>
                </div>
            </div>
        </div>
    


    </div>


</main>

<!-- Mise en place adict strasbourg pour les cartes -->
<script type="text/javascript">
    function initMap() {
        L.tileLayer.wms('https://adict.strasbourg.eu/mapproxy/service?', {
            layers: 'monstrasbourg'
        }).addTo(th_maps.maps[0]);
    }
</script>


<#macro showTime day schedule hasException>
    <li>
        <p class="st-title">
            <@liferay_ui.message key="jour-semaine${day}" />
        </p>
        <div class="st-info">
            <#if schedule.isClosed()>
                <p class="st-ouverture st--closed">
                    <@liferay_ui.message key="eu.closed" />
                </p>
                <#elseif schedule.isAlwaysOpen()>
                    <p class="st-ouverture">
                        <@liferay_ui.message key="always-open" />
                    </p>
                    <#else>
                        <#list schedule.openingTimes as openingTime>
                            <p>
                                ${openingTime.first}
                                -
                                ${openingTime.second}
                                <#if hasException>
                                    <span class="st-symbol">*</span>
                                </#if>
                            </p>
                            <#if schedule.comments[openingTime?index]?has_content>
                                <p class="st-note">
                                    ${schedule.comments[openingTime?index]}
                                </p>
                            </#if>

                        </#list>
            </#if>
        </div>
    </li>
</#macro>
