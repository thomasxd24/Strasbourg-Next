<%@ include file="/comment-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL varImpl="commentsURL">
	<portlet:param name="tab" value="comments" />
	<portlet:param name="mvcPath" value="/comment-bo-view-comments.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<%-- URL : definit le lien vers la page d'ajout/edition d'une entite --%>
<liferay-portlet:renderURL varImpl="addCommentsURL">
	<portlet:param name="cmd" value="editComments" />
	<portlet:param name="tab" value="comments" />
	<portlet:param name="mvcPath" value="/comment-bo-edit-comment.jsp" />
	<portlet:param name="backURL" value="${commentsURL}" />
</liferay-portlet:renderURL>

<%-- Composant : barre de filtres et de gestion des entite --%>
<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>
<%-- Composant : tableau de visualisation des entites --%>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">

		<liferay-ui:search-container id="commentsSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.comment.model.Comment" modelVar="comment"
				keyProperty="commentId" escapedModel="true">
				
				<%-- URL : definit le lien vers la page d'edition de l'entite selectionnee --%>
				<liferay-portlet:renderURL varImpl="editCommentURL">
					<portlet:param name="cmd" value="editComment" />
					<portlet:param name="commentId" value="${comment.commentId}" />
					<portlet:param name="backURL" value="${commentsURL}" />
					<portlet:param name="tab" value="comments" />
					<portlet:param name="mvcPath" value="/comment-bo-edit-comment.jsp" />
				</liferay-portlet:renderURL>

				<%-- Colonne : userName --%>
				<liferay-ui:search-container-column-text
					href="${editCommentURL}" name="userName" orderable="true"
					value="${comment.userName}" />

                <%-- Colonne : comment --%>
				<liferay-ui:search-container-column-text cssClass="content-column"
                     href="${editCommentURL}" name="comment" truncate="true" orderable="true"
                     value="${comment.text}" />
				
				<%-- Colonne : Date de modification --%>
				<fmt:formatDate value="${comment.modifiedDate}"
					var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text
					name="modified-date" orderable="true"
					value="${formattedModifiedDate}" />

				<%-- Colonne : Statut --%>
				<liferay-ui:search-container-column-text name="status" orderable="true">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${comment.status}" />
				</liferay-ui:search-container-column-text>

				<%-- Colonne : le nombre de signalement--%>
				<liferay-ui:search-container-column-text
                    name="reportings" orderable="true" align="center"
                    value="${comment.getCountSignalements()}" />

				<%-- Colonne : Type de l'entite --%>
				<liferay-ui:search-container-column-text
                    name="entityType" truncate="true" orderable="true"
                    value="${comment.getTypeAssetEntry()}" />

				<%-- Colonne : nom de l'entite--%>
				<liferay-ui:search-container-column-text cssClass="content-column"
                    name="entityName" truncate="true" orderable="true"
                    value="${comment.getAssetEntryTitle()}" />

				<%-- Colonne : lien vers la page--%>
				<liferay-ui:search-container-column-text  name="linkTitle" >
				    <aui:button style="width: min-content" href="${comment.urlProjectCommentaire}" value="link"/>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>

			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>

	<liferay-portlet:resourceURL var="exportCommentsXlsxURL" id="exportCommentsXlsx">
	</liferay-portlet:resourceURL>
	<form method="POST" action="${exportCommentsXlsxURL}">
		<aui:input type="hidden" name="commentIds" value="${dc.allCommentIds}" />
		<aui:button-row>
			<aui:button cssClass="btn-lg" type="submit"
				value="export-comments-xlsx" />
		</aui:button-row>


	</form>
</div>

<%-- URL : definit le lien vers l'action de suppression --%>
<liferay-portlet:actionURL name="selectionAction" var="deleteSelectionURL">
	<portlet:param name="cmd" value="delete" />
	<portlet:param name="tab" value="comments" />
	<portlet:param name="mvcPath" value="/comment-bo-view-comments.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- URL : definit le lien vers l'action de publication --%>
<liferay-portlet:actionURL name="selectionAction" var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="comments" />
	<portlet:param name="mvcPath" value="/comment-bo-view-comments.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- URL : definit le lien vers l'action de depublication --%>
<liferay-portlet:actionURL name="selectionAction" var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="comments" />
	<portlet:param name="mvcPath" value="/comment-bo-view-comments.jsp" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- Script : permet l'affichage des alertes de validation d'action --%>
<aui:script>
	var form = document.querySelector("[name='<portlet:namespace />fm']");
	function deleteSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-selected-entries" />')) {
			submitForm(form, '${deleteSelectionURL}');
		}
	}
	function publishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-publish-selected-entries" />')) {

			submitForm(form, '${publishSelectionURL}');
		}
	}
	function unpublishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-unpublish-selected-entries" />')) {

			submitForm(form, '${unpublishSelectionURL}');
		}
	}
	function formatComment(commentaire){
		return (comment.length()<20)?comment: comment.substring(0, 15) + "...";
	}
</aui:script>
