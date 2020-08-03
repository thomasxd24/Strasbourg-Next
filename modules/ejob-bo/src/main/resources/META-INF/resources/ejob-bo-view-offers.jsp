<%@ include file="/ejob-bo-init.jsp"%>

<liferay-portlet:renderURL varImpl="offersURL">
	<portlet:param name="tab" value="offers" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="addOffersURL">
	<portlet:param name="cmd" value="editOffers" />
	<portlet:param name="mvcPath" value="/ejob-bo-edit-offer.jsp" />
	<portlet:param name="returnURL" value="${offersURL}" />
</liferay-portlet:renderURL>


<liferay-frontend:management-bar includeCheckBox="true" searchContainerId="offersSearchContainer">
    <liferay-frontend:management-bar-filters>
        <liferay-frontend:management-bar-sort orderByCol="${dc.orderByCol}"
            orderByType="${dc.orderByType}"
            orderColumns='<%= new String[] {"title", "date"} %>'
            portletURL="${offersURL}" />
    </liferay-frontend:management-bar-filters>
</liferay-frontend:management-bar>


<div class="container-fluid-1280 main-content-body">

	<%-- Composant : definit la liste des messages d'erreur  (voir methode "doProcessAction" dans le deleteAction de l'entite) --%>
	<liferay-ui:error key="offers-error" message="offers-error" />

	<aui:form method="post" name="fm">
		<aui:input type="hidden" name="selectionIds" />
		<liferay-ui:search-container id="offersSearchContainer" searchContainer="${dc.searchContainer}">
			<liferay-ui:search-container-results results="${dc.offers}" />

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.ejob.model.Offer"
				modelVar="offer" keyProperty="offerId" rowIdProperty="offerId">

				<liferay-portlet:renderURL varImpl="editOfferURL">
					<portlet:param name="cmd" value="editOffer" />
					<portlet:param name="offerId" value="${offer.offerId}" />
					<portlet:param name="returnURL" value="${offersURL}" />
					<portlet:param name="mvcPath" value="/ejob-bo-edit-offer.jsp" />
				</liferay-portlet:renderURL>

                <!-- Colonne : Nom d'utilisateur -->
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editOfferURL}" name="username" truncate="true"
					orderable="true" value="${offer.userName}" />

                <!-- Colonne : Titre -->
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editOfferURL}" name="title" truncate="true"
					orderable="true" value="${offer.post}" />

				<fmt:formatDate value="${offer.date}"
					var="formattedDate" type="date" pattern="dd/MM/yyyy" />

				<!-- Colonne : Date -->
				<liferay-ui:search-container-column-text cssClass="content-column"
					name="date" truncate="true" orderable="true"
					value="${formattedDate}" />

                <!-- ACTIONS -->
				<liferay-ui:search-container-column-text>
					<liferay-ui:icon-menu markupView="lexicon">

						<!-- ACTION : Édition -->
						<c:if test="${dc.hasPermission('EDIT_OFFER') and empty themeDisplay.scopeGroup.getStagingGroup()}">
							<liferay-ui:icon message="edit" url="${editOfferURL}" />
						</c:if>

                        <!-- ACTION : Supprimer -->
						<liferay-portlet:actionURL name="deleteOffer" var="deleteOfferURL">
							<portlet:param name="cmd" value="deleteOffer" />
							<portlet:param name="tab" value="offers" />
							<portlet:param name="offerId" value="${offer.offerId}" />
						</liferay-portlet:actionURL>
						<c:if test="${dc.hasPermission('DELETE_OFFER') and empty themeDisplay.scopeGroup.getStagingGroup()}">
							<liferay-ui:icon message="delete" url="${deleteOfferURL}" />
						</c:if>

					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>

<c:if test="${dc.hasPermission('ADD_OFFER') and empty themeDisplay.scopeGroup.getStagingGroup()}">
	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title="Ajouter une offre" url="${addOffersURL}" />
	</liferay-frontend:add-menu>
</c:if>