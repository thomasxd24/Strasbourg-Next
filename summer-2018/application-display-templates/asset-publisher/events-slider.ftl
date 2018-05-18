<!-- Slider événements -->
<#setting locale = locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>
<div class="mns-section-agenda">
    <div class="container">
        <div class="col-xs-12" style="text-align: center;">
            <div  class="mns-portlet-title">
                <h2><@liferay_ui.message key="agenda" /></h2>
            </div>
        </div>
        <div class="owl-carousel owl-theme col-xs-12" id="owl-agenda">
            <#list entries as curEntry>
                <#if (curEntry?index == 20)>
                    <#break>
                </#if>
                <#assign event = curEntry.getAssetRenderer().getEvent() />
                <div class="item">
                    <div class="mns-bloc-agenda" itemscope itemtype="http://schema.org/Event">
                        <a href="${homeURL}event/-/entity/id/${event.eventId}">
                            <span class="date">${event.getEventScheduleDisplay(locale)}</span>
                            <figure>
                                <img src='${event.getImageURL()}' alt="${event.getTitle(locale)}" width="270" height="400" class="fit-cover" />
                            </figure>
                            <div>
                                <div class="col-xs-12 mns-indic">
                                    <span class="ico-map-marker" itemprop="location" itemscope itemtype="http://schema.org/Place"><span itemprop="address" itemscope itemtype="http://schema.org/PostalAddress">${event.getPlaceAlias(locale)}</span></span>
                                </div>
                                <div class="col-xs-12 mns-indic">
                                    <span class="ico-type">${event.getTypeLabel(locale)}</span>
                                </div>
                                <h3 itemprop="name">${event.getTitle(locale)}</h3>
                                <span class="basic-link"><@liferay_ui.message key="eu.discover" /></span>
                            </div>
                        </a>
                    </div>
                </div>
            </#list>
        </div>
        <div class="col-xs-12 mns-right">
            <span><a href="/agenda" class="link align-right"><@liferay_ui.message key="eu.all-agenda" /></a></span>
        </div>    
    </div>
</div>