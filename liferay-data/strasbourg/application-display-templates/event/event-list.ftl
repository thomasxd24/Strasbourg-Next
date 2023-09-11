<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>
<div class="st-wrapper st-bloc st-bloc-agenda-home ">
    <h2 class="st-h2 st-titre">L’agenda</h2>
    <ul class="st-cards-wrapper st--has-cards-horizontal st-basic-grid st-col-2@t-small">
        <#list entries as entry>
            <#assign event=entry.getAssetRenderer().getEvent() />
            <li>
                <div class="st-card-container">
                    <a href="${homeURL}evenement/-/entity/id/${event.eventId}/${event.getNormalizedTitle(locale)}" class="st-card st-card-agenda st--text-only st--card-horizontal st--with-gradient">
                        <div class="st-caption">
                            <p class="st-title-card">
                                ${event.getTitle(locale)}
                            </p>
                            <p class="st-surtitre-cat">
                                ${event.getTypeLabel(locale)}
                            </p>
                            <p class="st-date">
                                <#if event.firstStartDate?date==event.lastEndDate?date>
                                    <@liferay_ui.message key="eu.event.the" />
                                    ${event.firstStartDate?date?string['dd.MM.YYYY']}
                                <#else>
                                    <@liferay_ui.message key="eu.event.from-date" />
                                    ${event.firstStartDate?date?string['dd.MM.YYYY']}
                                    <@liferay_ui.message key="eu.event.to" />
                                    ${event.lastEndDate?date?string['dd.MM.YYYY']}
                                </#if>
                            </p>
                            <p class="st-location">
                                ${event.getPlaceAlias(locale)}
                                - ${event.getPlaceCity(locale)}
                            </p>
                        </div>
                    </a>
                    <button class="st-btn-favorite-card" data-addpanier="postID">
                        <@liferay_ui.message key='eu.add-to-favorite' />
                    </button>
                </div>
            </li>
        </#list>
    </ul>
    <a href="${homeURL}agenda" class="st-btn st--btn-secondary st--btn-full-width-mobile st-btn-cta">
        <@liferay_ui.message key="eu.all-events" />
    </a>
</div>