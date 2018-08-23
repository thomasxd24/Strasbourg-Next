<!-- SLIDER DE PARTICIPATIONS AVEC MARGE -->

<!-- Recuperation de la localisation de l'utilisateur -->
<#setting locale = locale />

<!-- Recuperation de l'URL de "base" du site -->
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>

<section id="pro-link-participation" class="pro-bloc-slider pro-slider-participation">
    <div class="container">
        
        <div class="col-lg-10 col-lg-offset-1">
            <h2>Les participations (${entries?size})</h2>
            <a href="${themeDisplay.getPortalURL()}${homeURL}participations" class="pro-btn" title="Lien vers la page Toutes les participations">Voir Toutes les participations</a>
        </div>

        <div class="col-lg-10 col-lg-offset-1">
            <div class="owl-carousel owl-opacify owl-theme owl-cards">

                <!-- Parcours des entites de l'asset publisher -->
                <#list entries as curEntry>
                    
                    <!-- Recuperation de l'entite -->
                    <#assign entry = curEntry.getAssetRenderer().getParticipation() />

                    <!-- Recuperation du status de la participation (terminee, bientot, etc.) -->
                    <#assign participationStatus = entry.getParticipationStatus() />

                    <!-- Adaptation du message a afficher dans le 'span-pro-time' -->
                    <#if participationStatus == "soon_arrived">
                        <#assign proDuree = "Début dans " + entry.getTodayPublicationDifferenceDays() + " jour(s)"  />
                    <#elseif participationStatus == "new" || participationStatus == "in_progress" || participationStatus == "soon_finished" >
                        <#assign proDuree = "Fin dans " + entry.getTodayExpirationDifferenceDays() + "jour(s)" />
                    <#elseif participationStatus == "finished" >
                        <#assign proDuree = "Terminée"  />
                    </#if>

                    <!-- Recuperation du type de la participation (information, concertation, etc.) -->
                    <#assign participationType = entry.getTypeCategory().getTitle(locale) />

                    <!-- Recuperation de la couleur hexa correspondant au type de la participation -->
                    <#assign participationColor = entry.getTypeCategoryColor() />

                    <div class="item pro-bloc-card-participation type-color-hexa-${participationColor}" data-linkall="a">
                        <div>
                            <div class="pro-header-participation">
                                <figure role="group">
                                    <!-- Si une image de la participation existe -->
                                    <#if entry.getImageURL()?has_content>
                                        <img src="${entry.getImageURL()}" width="40" height="40" alt="Image participation"/>
                                    </#if>
                                </figure>
                                <p>Concertation publiée par :</p>
                                <p><strong>${entry.getAuthor()}</strong></p>
                            </div>
                            <div class="pro-content-participation">
                                <a href="${homeURL}detail-participation/-/entity/id/${entry.participationId}" title="lien de la page">
                                    <h3>${entry.title}</h3>
                                </a>
                                <span class="pro-time">
                                    Publiée le <time datetime="${entry.publicationDate?string['dd/MM/yyyy']}">${entry.publicationDate?date?string['dd/MM/yyyy']}</time> / <span class="pro-duree">${proDuree}</span>
                                </span>
                            </div>
                            
                            <#if participationStatus == "soon_arrived"> 
                                <div class="pro-footer-participation pro-participation-soon">
                                    <div class="pro-avis">
                                        <span class="pro-like">${entry.nbLikes}</span>
                                        <span class="pro-dislike">${entry.nbDislikes}</span>
                                    </div>
                                    <a href="${homeURL}detail-participation/-/entity/id/${entry.participationId}#pro-link-commentaire" class="pro-form-style" title="Lien vers la page détail Participation - Lien des commentaires">
                                        Bientôt disponible
                                    </a>
                                </div>
                            <#elseif participationStatus == "new" || participationStatus == "in_progress" || participationStatus == "soon_finished" >
                                <div class="pro-footer-participation">
                                    <a href="${homeURL}detail-participation/-/entity/id/${entry.participationId}#pro-link-commentaire" class="pro-form-style" title="Lien vers la page détail Participation - Lien des commentaires">
                                        Réagissez...
                                    </a>
                                </div>
                            <#elseif participationStatus == "finished" >
                                <div class="pro-footer-participation pro-participation-deadline">
                                    <div class="pro-avis">
                                        <span class="pro-like">${entry.nbLikes}</span>
                                        <span class="pro-dislike">${entry.nbDislikes}</span>
                                    </div>
                                    <p>Participation terminée</p>
                                </div>
                            </#if>
                        </div>

                        <!-- Cree le style de couleur hexa a la volee pour l'application de la couleur !-->
                        <#if participationColor?has_content>
                            <style style="display: none" >
                                .type-color-hexa-${participationColor}>*:before {
                                    background:#${participationColor};
                                }
                            </style>
                        </#if>

                    </div>

                </#list>

            </div>
        </div>

    </div>
</section>
<style>
    .pro-bloc-slider.pro-slider-participation {
        margin-top: 0px;
    }
</style>