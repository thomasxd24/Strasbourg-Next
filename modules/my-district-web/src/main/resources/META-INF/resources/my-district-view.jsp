<%@ include file="/my-district-init.jsp" %>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:setLocale value="${locale}" />
<c:set var="virtualHostName" value="${dc.getVirtualHostName()}"/>
<c:if test="${empty virtualHostName}">
	<c:set var="homeURL" value="/web/mon-strasbourg/"/>
</c:if>
<c:if test="${not empty virtualHostName}">
	<c:set var="homeURL" value="https://${virtualHostName}/"/>
</c:if>
<c:set var="virtualStrasbourgHostName" value="${dc.getVirtualStrasbourgHostName()}"/>
<c:if test="${empty virtualStrasbourgHostName}">
	<c:set var="homeStrasbourgURL" value="/web/strasbourg.eu/"/>
</c:if>
<c:if test="${not empty virtualStrasbourgHostName}">
	<c:set var="homeStrasbourgURL" value="https://${virtualStrasbourgHostName}/"/>
</c:if>

<c:set var="district" value="${dc.district}" />
<c:if test="${empty district}">
	<div class="wi-wrapper">
        <div id="districts-configuration">
            <h1><liferay-ui:message key="my-district" /></h1>
            <c:set var="error" value="${dc.hasError()}" />
            <c:if test="${error}">
                <!-- erreur technique -->
                <div class="error"><liferay-ui:message key="webservice-indispo-district" /></div>
            </c:if>
            <c:if test="${!error}">
                <c:if test="${empty dc.address}">
                    ${dc.getNoAddressText()}
                    <div align="center">
                        <a href="${strasbourgPropsUtil.getPublikProfileURL()}" class="btn-square--bordered--core">
                            <span class="flexbox">
                                <span class="btn-text"><liferay-ui:message key="modify-account" /></span>
                                <span class="btn-arrow"></span>
                            </span>
                        </a>
                    </div>
                </c:if>
                <c:if test="${!empty dc.address}">
                    <p style="margin-top: 40px">
                        L'adresse renseign&eacute;e dans votre profil ne correspond pas &agrave; un quartier de Strasbourg.
                        <br>Vous pouvez voir les pages des quartiers de la ville en cliquant sur les liens ci-dessous.
                        <br>
                    </p>
                </c:if>
            </c:if>
            <br/>
            <ul style="list-style: disc; margin-top: 20px;">
                <c:forEach var="district" items="${dc.allDistricts}">
                    <li><a href="${homeURL}mon-quartier?district=${district[1]}">${district[0]}</a></li>
                </c:forEach>
            </ul>
        </div>
	</div>
</c:if>
<c:if test="${not empty district}">
	<div id="district">

		<section id="sliders">
			<script type="text/javascript">
                var mega_source = [];
			</script>
			<h2><liferay-ui:message key="district-actualities" /></h2>
			<c:if test="${not empty dc.actusAndWebmags}">
			    <script type="text/javascript">
			        mega_source.push([
			        	<c:forEach var="curEntry" items="${dc.actusAndWebmags}" varStatus="loopStatus">
			        		<c:if test="${curEntry.getClassName().equals('com.liferay.journal.model.JournalArticle')}">
				                <c:set var="article" value="${curEntry.getAssetRenderer().getArticle()}"/>
				          		<c:set var="title" value="${dc.DeleteTag(dc.getJournalArticleTitle(article,locale))}"/>
								<c:set var="chapo" value="${dc.DeleteTag(dc.getJournalArticleCatcher(article,locale))}"/>
								<c:set var="image" value="${dc.getJournalArticleImage(article,locale)}"/>
								<c:set var="id" value="${article.getArticleId()}"/>
								<c:set var="groupId" value="${article.getGroupId()}"/>
								<c:set var="currentURL" value="${assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, curEntry)}"/>
								<c:set var="viewURL" value="${curEntry.getAssetRenderer().getURLViewInContext(renderRequest, renderResponse, currentURL)}"/>
				              {
				            	<c:if test="${dc.isMag(curEntry.getTagNames())}">
				                  category: 'mag',
				  	            </c:if>
					          	<c:if test="${!dc.isMag(curEntry.getTagNames())}">
				                  category: 'actu',
				  	            </c:if>
				                title: '${dc.getJSONEncodedString(title)}',
				                lead: '${dc.getJSONEncodedString(chapo)}',
				                picture: '${image}',
				                link: '${viewURL}',
				                id: '${id}',
				                groupId: '${groupId}',
				                // La notion de big signifie ici que l'on veut 4 items par vues
				                //is_Big: true
				              }
				            </c:if>
			        		<c:if test="${!loopStatus.last}">,
			 	        	</c:if>
						</c:forEach>
			        ]);
			    </script>
		      
		        <div class="slider--mega">
		            <div class="slider-mega-container">
		                <div class="slider-overflow">
		                    <div class="slider">
		                    </div>
		                </div>
		                <div class="owl-nav">
		                    <button class="owl-prev">
		                        <span class="picto"></span>
		                    </button>
		                    <button class="owl-next">
		                        <span class="picto"></span>
		                    </button>
		                </div>
		            </div>
		            <div id="mega-templates">
		                <!-- Template actu-->
		                <div class="item actu">
		                    <a href="__link__" class="link" title="__title__">
		                        <div class="text">
		                            <div class="title dotme" data-dot="3">__title__</div>
		                            <div class="lead dotme" data-dot="3">__lead__</div>
		                        </div>
		                        <div class="picture" style="background-image: url(__picture__)">
		                        </div> 
		                    </a>
					        <a href="#" class="add-favorites"
					            data-type="6" 
					            data-title="__title__" 
					            data-url="__link__" 
					            data-id="__id__"
					            data-group-id="__groupId__">
					            <span><liferay-ui:message key="eu.add-to-favorite" /></span>
					        </a>
		                </div>
		
		                <!--Template Mag-->
		                <div class="item mag">
		                    <a href="__link__" class="link" title="__title__">
		                        <div class="picture" style="background-image: url(__picture__)">
		                        </div>
		                        <div class="mag-logo">
		                            <div class="mag-text">Mag'</div>
		                            <div class="mag-picto"></div>
		                        </div>
		                        <div class="text">
		                            <div class="title dotme" data-dot="3">__title__</div>
		                            <div class="lead dotme" data-dot="3">__lead__</div>
		                        </div>
					        </a>
					        <a href="#" class="add-favorites"
					            data-type="6" 
					            data-title="__title__" 
					            data-url="__link__" 
					            data-id="__id__"
					            data-group-id="__groupId__">
					            <span><liferay-ui:message key="eu.add-to-favorite" /></span>
		                    </a>
		                </div>
		            </div>
		        </div>
				<div class="seu-btn-line"> 	
					<a href="${homeStrasbourgURL}actualite" class="btn-square--bordered--core" title="<liferay-ui:message key="eu.all-news" />">
						<span class="flexbox">
							<span class="btn-text"><liferay-ui:message key="eu.all-news" /></span>
							<span class="btn-arrow"></span>
						</span>
					</a>
				</div>
			</c:if>
			<c:if test="${empty dc.actusAndWebmags}">
				<p><liferay-ui:message key="no-actu" /></p>
			</c:if>

			<h2><liferay-ui:message key="district-events" /></h2>
			<c:if test="${not empty dc.events}">
			    <script type="text/javascript">
		        	mega_source.push([
			        	<c:forEach var="curEntry" items="${dc.events}" varStatus="loopStatus">
							<c:set var="event" value="${curEntry.getAssetRenderer().getEvent()}"/>
			              {
			                category: 'agenda',
			                title: '${dc.getJSONEncodedString(dc.DeleteTag(event.getTitle(locale)))}',
			                type: '${dc.getJSONEncodedString(dc.DeleteTag(event.getTypeLabel(locale)))}',
			                link: '${homeStrasbourgURL}evenement/-/entity/id/${event.eventId}/${event.getNormalizedTitle(locale)}',
			                ville: '${event.getCity(locale)} <c:if test="${not empty event.getCity(locale)}">-</c:if> ${dc.getJSONEncodedString(event.getPlaceAlias(locale))}',
			                id: '${event.eventId}',
			                <c:if test="${event.getFirstStartDate().equals(event.getLastEndDate())}">
								<fmt:formatDate value="${event.getFirstStartDate()}" pattern="dd.MM" type="date" var="firstStartDate" />
								date_start: '',
								date_end: '${firstStartDate}',
								date_prefix: '<liferay-ui:message key="eu.event.the" />',
								date_suffix: '',
			                </c:if>
			        		<c:if test="${!event.getFirstStartDate().equals(event.getLastEndDate())}">
								<fmt:formatDate value="${event.getFirstStartDate()}" pattern="dd.MM" type="date" var="firstStartDate" />
								<fmt:formatDate value="${event.getLastEndDate()}" pattern="dd.MM" type="date" var="lastEndDate" />
								date_start: '${firstStartDate}',
								date_end: '${lastEndDate}',
								date_prefix: '<liferay-ui:message key="eu.event.from-date" />',
								date_suffix: '<liferay-ui:message key="eu.event.to" />',
			                </c:if>
				                // La notion de big signifie ici que l'on veut 4 items par vues
				          	//is_Big: true
			              }
			        		<c:if test="${!loopStatus.last}">,
			 	        	</c:if>
						</c:forEach>
			        ]);
			    </script>
		      
		        <div class="slider--mega">
		            <div class="slider-mega-container">
		                <div class="slider-overflow">
		                    <div class="slider">
		                    </div>
		                </div>
		                <div class="owl-nav">
		                    <button class="owl-prev">
		                        <span class="picto"></span>
		                    </button>
		                    <button class="owl-next">
		                        <span class="picto"></span>
		                    </button>
		                </div>
		            </div>
		            <div id="mega-templates">
		                <!--Template Event-->
		                <div class="item event">
		                    <a href="__link__" class="link" title="__title__">
		                        <div class="date">
		                            <div class="date-sup">
		                                <span class="date-prefix">__date_prefix__</span>
		                                <span class="date-start">__date_start__</span>
		                                <span class="date-suffix">__date_suffix__</span>
		                            </div>
		                            <div class="date-end">__date_end__</div>
		                        </div>
		                        <div class="title dotme" data-dot="3">__title__</div>		
		                        <div class="ville">__ville__</div>
		                        <div class="item-categories" data-dot="3">__type__</div>                        
		                    </a>
					        <a href="#" class="add-favorites"
					            data-type="2" 
					            data-title="__title__" 
					            data-url="__link__" 
					            data-id="__id__" >
					            <span><liferay-ui:message key="eu.add-to-favorite" /></span>
					        </a>
		                </div>
		            </div>
		        </div> 
				<div class="seu-btn-line"> 	
					<a href="${homeStrasbourgURL}agenda" class="btn-square--bordered--core" title="<liferay-ui:message key="eu.all-events" />">
						<span class="flexbox">
							<span class="btn-text"><liferay-ui:message key="eu.all-events" /></span>
							<span class="btn-arrow"></span>
						</span>
					</a>
				</div>
			</c:if>
			<c:if test="${empty dc.events}">
				<p><liferay-ui:message key="no-event" /></p>
			</c:if>
		</section>
		
		<section id="elu-direction">
			<div class="flexbox">
				<div class="container-left">
					<c:set var="official" value="${dc.official}"/>
					<c:if test="${not empty official}">
						<div class="wi-wrapper">
							<section id="elu">
								<h2><c:if test="${official.gender == 1}"><liferay-ui:message key="neighborhood-assistant" /></c:if><c:if test="${official.gender == 2}"><liferay-ui:message key="neighborhood-assistante" /></c:if></h2>
								<img alt="" title="${official.firstName} ${official.lastName}" src="${official.imageURL}">
								<div class="seu-text">
									<div class="seu-title dotme" data-dot="3" style="word-wrap: break-word;">${official.firstName} ${official.lastName}</div>
									<div class="seu-lead dotme" data-dot="3" style="word-wrap: break-word;">${official.getName(official.fonctionCity,locale)}</div>
								</div>
								<a href="${homeStrasbourgURL}elu/-/entity/id/${official.officialId}" class="btn-square--bordered--core" title="${official.firstName} ${official.lastName}">
										<span class="flexbox">
											<span class="btn-text"><liferay-ui:message key="know-more" /></span>
											<span class="btn-arrow"></span>
										</span>
								</a>
							</section>
						</div>
					</c:if>
				</div>
				<div class="container-right">
					<c:set var="territoryDirection" value="${dc.territoryDirection}"/>
					<c:if test="${not empty territoryDirection}">
						<div class="wi-wrapper">
							<section id="direction">
								<h2><liferay-ui:message key="territory-direction" /></h2>
								<p>${dc.territoryDirectionText}</p>
								<div class="flexbox">
									<div class="container-left">
										<h3><liferay-ui:message key="eu.place.address-details" /></h3>
										<div class="rte">
											<p style="margin-bottom: 0px;">
												<c:if test="${not empty territoryDirection.alias}">
													${territoryDirection.alias} <br />
												</c:if>
												<c:if test="${not empty territoryDirection.addressStreet}">
													${territoryDirection.addressStreet} <br />
												</c:if>
												<c:if test="${not empty territoryDirection.addressComplement}">
													${territoryDirection.addressComplement} <br />
												</c:if>
												<c:if test="${not empty territoryDirection.addressDistribution}">
													${territoryDirection.addressDistribution} <br />
												</c:if>
													${territoryDirection.addressZipCode} ${territoryDirection.getCity(locale)}
											</p>
											<c:if test="${not empty territoryDirection.phone}">
												<p>
													<liferay-ui:message key="phone" /> : ${territoryDirection.phone}
												</p>
											</c:if>
										</div>
										<a href="#" class="add-favorites"
										   data-type="1"
										   data-title="${territoryDirection.getAlias(locale)}"
										   data-url="${themeDisplay.getPortalURL()}${homeStrasbourgURL}lieu/-/entity/sig/${territoryDirection.getSIGid()}/${territoryDirection.getNormalizedAlias(locale)}"
										   data-id="${territoryDirection.placeId}">
											<span><liferay-ui:message key="eu.add-to-favorite" /></span>
										</a>
									</div>
								</div>
								<a href="${homeStrasbourgURL}lieu/-/entity/sig/${territoryDirection.SIGid}/${territoryDirection.getNormalizedAlias(locale)}" class="btn-square--bordered--core" title="${territoryDirection.getAlias(locale)}">
										<span class="flexbox">
											<span class="btn-text"><liferay-ui:message key="detailed-card" /></span>
											<span class="btn-arrow"></span>
										</span>
								</a>
							</section>
						</div>
					</c:if>
				</div>
			</div>
		</section>

		<c:set var="townHall" value="${dc.townHall}"/>
		<c:if test="${not empty townHall}">
			<div class="wi-wrapper">
				<section id="mairie">
					<h2><liferay-ui:message key="town-hall" /></h2>
					<p>${dc.townHallText}</p>
					<div class="flexbox">
						<div class="container-left">
							<h3><liferay-ui:message key="eu.place.address-details" /></h3>
							<div class="rte">
								<p style="margin-bottom: 0px;">
									<c:if test="${not empty townHall.alias}">
										${townHall.alias} <br />
									</c:if>
									<c:if test="${not empty townHall.addressStreet}">
										${townHall.addressStreet} <br />
									</c:if>
									<c:if test="${not empty townHall.addressComplement}">
										${townHall.addressComplement} <br />
									</c:if>
									<c:if test="${not empty townHall.addressDistribution}">
										${townHall.addressDistribution} <br />
									</c:if>
										${townHall.addressZipCode} ${townHall.getCity(locale)}
								</p>
								<c:if test="${not empty townHall.phone}">
									<p>
										<liferay-ui:message key="phone" /> : ${townHall.phone}
									</p>
								</c:if>
							</div>
							<a href="#" class="add-favorites"
							   data-type="1"
							   data-title="${townHall.getAlias(locale)}"
							   data-url="${homeStrasbourgURL}lieu/-/entity/sig/${townHall.getSIGid()}/${townHall.getNormalizedAlias(locale)}"
							   data-id="${townHall.placeId}">
								<span><liferay-ui:message key="eu.add-to-favorite" /></span>
							</a>
						</div>
						<div class="container-right">
							<c:if test="${townHall.isEnabled()}">
								<c:set var="occupationState" value="${townHall.getRealTime()}" />
								<div class="flexbox">
									<div class="container-left" style="display: inline-table; width: auto;">
										<!-- green orange red black -->
										<div class="crowded-amount ${occupationState.cssClass}" style="font-size: 1.5rem">
											${occupationState.occupationLabel}
										</div>
									</div>
									<div class="container-right" style="width: auto;">
										<p class="crowded-caption">
											<liferay-ui:message key="${occupationState.label}" />
										</p>
										<p class="crowded-fyi">
											<liferay-ui:message key="estimated-time-explanation" />
										</p>
									</div>
								</div>
							</c:if>
						</div>
					</div>
					<a href="${homeStrasbourgURL}lieu/-/entity/sig/${townHall.SIGid}/${townHall.getNormalizedAlias(locale)}" class="btn-square--bordered--core" title="${townHall.getAlias(locale)}">
							<span class="flexbox">
								<span class="btn-text"><liferay-ui:message key="detailed-card" /></span>
								<span class="btn-arrow"></span>
							</span>
					</a>
				</section>
			</div>
		</c:if>

        <c:set var="sectorSchools" value="${dc.sectorSchools}"/>
	    <c:if test="${empty dc.address || !dc.isStrasbourg() || not empty sectorSchools}">
            <div class="wi-wrapper">
                <section id="ecoles">
                    <h2><liferay-ui:message key="sector-schools" /></h2>
                    <c:if test="${empty sectorSchools}">
                        <p><liferay-ui:message key="no-school" /></p>
                    </c:if>
                    <c:if test="${not empty sectorSchools}">
                        <c:set var="error" value="${dc.hasError()}" />
                        <c:if test="${error}">
                            <!-- erreur technique -->
                            <div class="error"><liferay-ui:message key="eu.webservice-indispo" /></div>
                        </c:if>
                        <c:if test="${!error}">
                            <div class="ecoles-grid">
                                <c:forEach items="${sectorSchools}" var="school">
                                    <div class="ecoles-teaser">
                                        <h3>${school.getAlias(locale)}</h3>
                                        <div class="rte">
                                            <p>
                                                <c:if test="${not empty school.addressStreet}">
                                                    ${school.addressStreet} <br />
                                                </c:if>
                                                <c:if test="${not empty school.addressComplement}">
                                                    ${school.addressComplement} <br />
                                                </c:if>
                                                <c:if test="${not empty school.addressDistribution}">
                                                    ${school.addressDistribution} <br />
                                                </c:if>
                                                    ${school.addressZipCode} ${school.getCity(locale)}
                                            </p>
                                        </div>
                                        <a href="#" class="add-favorites"
                                           data-type="1"
                                           data-title="${school.getAlias(locale)}"
                                           data-url="${homeStrasbourgURL}lieu/-/entity/sig/${school.getSIGid()}/${school.getNormalizedAlias(locale)}"
                                           data-id="${school.placeId}">
                                            <span><liferay-ui:message key="eu.add-to-favorite" /></span>
                                        </a>
                                        <a href="${homeStrasbourgURL}lieu/-/entity/sig/${school.SIGid}/${school.getNormalizedAlias(locale)}" class="btn-square--bordered--core" title="${school.getAlias(locale)}">
                                                <span class="flexbox">
                                                    <span class="btn-text"><liferay-ui:message key="detailed-card" /></span>
                                                    <span class="btn-arrow"></span>
                                                </span>
                                        </a>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>
				    </c:if>
			    </section>
		    </div>
		</c:if>
	</div>
</c:if>