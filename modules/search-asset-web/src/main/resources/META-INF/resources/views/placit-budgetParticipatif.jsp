<%@ include file="/search-asset-init.jsp" %>

<liferay-portlet:actionURL varImpl="searchActionURL" />

<div class="pro-search-listing">
     <div class="container">
        <div class="row">
            <div class="col-md-8 pro-bloc-listing-participation">
                <div id="breadcrumb">
		            <span>
		                <span><a href="${dc.getHomeURL()}"><liferay-ui:message key="eu.breadcrumb-home" /></a>
		                    <span class="breadcrumb_last"><liferay-ui:message key="eu.breadcrumb-budgetParticipatif" /></span>
		                </span>
		            </span>
                </div>

                 <div class="pro-wrapper-sort">
                    <c:choose>
                        <c:when test='${isUserloggedIn}'>
                            <a id="buttonDeposer" href="" class="pro-btn-yellow" data-toggle="modal" data-target="#modalBudget"><liferay-ui:message key="file-budget" /></a>
                        </c:when>
                        <c:otherwise>
                            <a id="buttonDeposer" href="" class="pro-btn-yellow" data-toggle="modal" data-target="#myModal"><liferay-ui:message key="file-budget" /></a>
                        </c:otherwise>
                    </c:choose>
 				</div>
 				
 				<div class="row pro-wrapper-listing-participation">
                    <div class="col-xs-12">
                        <!-- Resultats -->
                        <aui:form method="post" name="fm">
                            <div class="pro-listing-budget">
                            </div>
                        </aui:form>

                    </div>
                </div>
                
                <div class="col-md-4 pro-wrapper-aside">
	                <div class="pro-bloc-facette pro-bloc-facette-participation">
	                    <span class="pro-affiner"><liferay-ui:message key="eu.refine-research" /> <span class="icon-ico-chevron-down"></span></span>
	
	                    <!-- Formulaire -->
	                    <aui:form action="${searchActionURL}" method="get" name="fm"
	                        id="search-asset-form">
	                        <liferay-portlet:renderURLParams varImpl="searchActionURL" />
	                        <liferay-util:include page="/forms/placit-budgetParticipatif-form.jsp"
	                            servletContext="<%=application%>" />
	                    </aui:form>
	                </div>
	                 <div class="pro-widget-participation">
	                    <h4><liferay-ui:message key="eu.most.signed" /></h4>
	                    <c:forEach var="petitionMost" items="${petitionListMostSigned}">
	                        <a href="${dc.getHomeURL()}detail-petition/-/entity/id/${petitionMost.petitionId}" title="Lien vers Titre de la petition">
	                            <div class="pro-meta">
	                                <span>${petitionMost.getDistrictLabel(locale)}</span>
	
	                                <span>${petitionMost.getThematicLabel(locale)}</span>
	                            </div>
	                            <h3>${petitionMost.title}</h3>
	
	                            <div class="pro-meta-footer">
	                                <span class="pro-citoyen-petition"><strong>${petitionMost.getNombreSignature()} Signataire(s) </strong>sur ${petitionMost.getQuotaSignature()} n&eacute;cessaires</span>
	                                <span class="pro-comments pro-comments-right"><strong>${petitionMost.nbApprovedComments} </strong></span>
	                            </div>
	                        </a>
	                    </c:forEach>
	                </div>
	
	                <div class="pro-widget-participation">
	                    <h4><liferay-ui:message key="eu.less.signed" /></h4>
	                    <c:forEach var="petitionMost" items="${petitionListLessSigned}">
	                        <a href="${dc.getHomeURL()}detail-petition/-/entity/id/${petitionMost.petitionId}" title="Lien vers Titre de la petition">
	                            <div class="pro-meta">
	                                <span>${petitionMost.getDistrictLabel(locale)}</span>
	
	                                <span>${petitionMost.getThematicLabel(locale)}</span>
	                            </div>
	                            <h3>${petitionMost.title}</h3>
	
	                            <div class="pro-meta-footer">
	                                <span class="pro-citoyen-petition"><strong>${petitionMost.getNombreSignature()} Signataire(s) </strong>sur ${petitionMost.getQuotaSignature()} n&eacute;cessaires</span>
	                                <span class="pro-comments pro-comments-right"><strong>${petitionMost.nbApprovedComments} </strong></span>
	                            </div>
	                        </a>
	                    </c:forEach>
	                </div>
	
	                <div class="pro-widget-participation">
	                    <h4><liferay-ui:message key="eu.most.commented-fe" /></h4>
	                    <c:forEach var="petitionMost" items="${petitionListMostCommented}">
	                        <a href="${dc.getHomeURL()}detail-petition/-/entity/id/${petitionMost.petitionId}" title="Lien vers Titre de la petition">
	                            <div class="pro-meta">
	                                <span>${petitionMost.getDistrictLabel(locale)}</span>
	
	                                <span>${petitionMost.getThematicLabel(locale)}</span>
	                            </div>
	                            <h3>${petitionMost.title}</h3>
	
	                            <div class="pro-meta-footer">
	                                <span class="pro-citoyen-petition"><strong>${petitionMost.getNombreSignature()} Signataire(s) </strong>sur ${petitionMost.getQuotaSignature()} n&eacute;cessaires</span>
	                                <span class="pro-comments pro-comments-right"><strong>${petitionMost.nbApprovedComments} </strong></span>
	                            </div>
	                        </a>
	                    </c:forEach>
	                </div>
            	</div>
                
            </div>
        </div>
    </div>
</div>