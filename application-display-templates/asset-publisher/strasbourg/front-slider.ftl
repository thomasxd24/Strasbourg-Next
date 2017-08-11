<#setting locale = locale />
<script type="text/javascript">
    <#assign newsCount = 0 />
    <#assign editionCount = 0 />
    <#assign eventCount = 0 />
    var une_source = [
    <#if entries?has_content>
      <#list entries as curEntry>
        <#if curEntry.className == 'com.liferay.journal.model.JournalArticle'>
          <#assign newsCount = newsCount + 1 />
          <#assign docXml = saxReaderUtil.read(curEntry.getAssetRenderer().getArticle().getContentByLocale(locale)) />
          <#assign title = docXml.valueOf("//dynamic-element[@name='title']/dynamic-content/text()") />
          <#assign chapo = docXml.valueOf("//dynamic-element[@name='chapo']/dynamic-content/text()") />
          <#assign image = docXml.valueOf("//dynamic-element[@name='image']/dynamic-content/text()") />
          <#assign currentURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, curEntry) />
          <#assign viewURL = curEntry.getAssetRenderer().getURLViewInContext(renderRequest, renderResponse, currentURL) />
          {
            category: 'actu',
            title: '${title?js_string}',
            lead: '${chapo?js_string}',
            picture: '${image}',
            link: '${viewURL}'
            <#if curEntry.tagNames?seq_contains('focus')>
              ,is_Big: true
            </#if>
          }

        <#elseif curEntry.className == 'eu.strasbourg.service.edition.model.Edition'>
          <#assign editionCount = editionCount + 1 />
          <#assign edition = curEntry.getAssetRenderer().getEdition() />
          {
            category: 'mag',
            title: '${edition.getTitle(locale)?js_string}',
            lead: '${edition.getDescription(locale)?js_string}',
            link: 'http://google.fr',
            picture: '${edition.imageURL}'
            <#if curEntry.tagNames?seq_contains('focus')>
              ,is_Big: true
            </#if>
          }
        <#elseif curEntry.className == 'eu.strasbourg.service.agenda.model.Event'>
          <#assign eventCount = eventCount + 1 />
          <#assign event = curEntry.getAssetRenderer().getEvent() />
            {
              category: 'agenda',
              title: '${event.getTitle(locale)?js_string}',
              lead: '${event.getDescription(locale)?js_string}',
              link: '#',
              ville: '${event.getCity(locale)} <#if event.getCity(locale)?has_content>-</#if> ${event.getPlaceAlias(locale)}',
              date_start: '11.06',
              date_end: '24.06',
              date_prefix: 'Du',
              date_suffix: 'Au'
              <#if curEntry.tagNames?seq_contains('focus')>
                ,is_Big: true
              </#if>
            }
        </#if>
        <#sep>, </#sep>
      </#list>
    </#if>
    ];
</script>

<section id="seu-une">
  <div class="seu-une-top-background"></div>
  <div class="seu-une-background"  style="background-image: url(/o/strasbourg-theme/images/blurry.jpg);"></div>
  <div class="seu-container seu-top-line">
      <h2 class="seu-section-title">
          <span class="seu-title">à la une</span>
      </h2>
      <div class="seu-filters">
          <button class="seu-actu-filter seu-actif" data-category="tous">
           <span class="seu-flexbox">
             <span class="seu-btn-text">Tous</span>
          </span>
          </button>
          <#if (newsCount > 0)>
            <button class="seu-actu-filter" data-category="actu">
              <span class="seu-flexbox">
                <span class="seu-btn-text">Actus</span>
              </span>
            </button>
          </#if>
          <#if (editionCount > 0)>
           <button class="seu-actu-filter" data-category="mag">
            <span class="seu-flexbox">
               <span class="seu-btn-text">Mag'</span>
            </span>
          </button>
          </#if>
          <#if (eventCount > 0)>
            <button class="seu-actu-filter" data-category="agenda">
              <span class="seu-flexbox">
                <span class="seu-btn-text">Agenda</span>
              </span>
            </button>
          </#if>
      </div>
  </div>
  <div class="seu-slider-une-container">
      <div class="seu-slider-overflow">
          <div class="seu-slider">
          </div>
      </div>
      <div class="owl-nav">
          <button class="seu-owl-prev">
          <span class="seu-picto"></span>
          </button>
          <button class="seu-owl-next">
          <span class="seu-picto"></span>
          </button>
      </div>
  </div>
  
  <div id="seu-une-templates">
      <!--Template Event-->
      <div class="seu-item seu-event">
          <a href="__link__" class="seu-link" title="__title__">
              <div class="seu-date">
                  <div class="seu-date-sup">
                      <span class="seu-date-prefix">__date_prefix__</span>
                      <span class="seu-date-start">__date_start__</span>
                      <span class="seu-date-suffix">__date_suffix__</span>
                  </div>
                  <div class="seu-date-end">__date_end__</div>
              </div>
              <div class="seu-title dotme" data-dot="3">__title__</div>
              <div class="seu-ville">__ville__</div>
              <div class="seu-lead dotme" data-dot="7">__lead__</div>
          </a>
      </div>
      <!-- Template actu-->
      <div class="seu-item seu-actu">
          <a href="__link__" class="seu-link" title="__title__">
              <div class="seu-text">
                  <div class="seu-title dotme" data-dot="3">__title__</div>
                  <div class="seu-lead dotme" data-dot="3">__lead__</div>
              </div>
              <div class="seu-picture" style="background-image: url(__picture__)">
              </div>
          </a>
      </div>
      <!--Template Mag-->
      <div class="seu-item seu-mag">
          <a href="__link__" class="seu-link" title="__title__">
              <div class="seu-picture" style="background-image: url(__picture__)">
              </div>
              <div class="seu-mag-logo">
                  <div class="seu-mag-text">Mag'</div>
                  <div class="seu-mag-picto"></div>
              </div>
              <div class="seu-text">
                  <div class="seu-title dotme" data-dot="3">__title__</div>
                  <div class="seu-lead dotme" data-dot="3">__lead__</div>
              </div>
          </a>
      </div>
  </div>
  <div class="seu-btn-line">
      <a href="#" class="seu-btn-square seu-filled seu-second" title="Toute l'actualité">
      <span class="seu-flexbox">
      <span class="seu-btn-text">Toute l'actu</span>
      <span class="seu-btn-arrow"></span>
      </span>
      </a>
  </div>
</section>