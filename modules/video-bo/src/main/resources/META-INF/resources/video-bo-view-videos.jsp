<%@ include file="/video-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />

<liferay-portlet:renderURL varImpl="videosURL">
	<portlet:param name="tab" value="videos" />
	<portlet:param name="mvcPath" value="/video-bo-view-videos.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="addVideoURL">
	<portlet:param name="cmd" value="editVideo" />
	<portlet:param name="tab" value="videos" />
	<portlet:param name="mvcPath" value="/video-bo-edit-video.jsp" />
	<portlet:param name="backURL" value="${videosURL}" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>
<div class="container-fluid container-fluid-max-xl main-content-body">

	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="videosSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.video.model.Video"
				modelVar="video" keyProperty="videoId">
				<liferay-portlet:renderURL varImpl="editVideoURL">
					<portlet:param name="cmd" value="editVideo" />
					<portlet:param name="videoId" value="${video.videoId}" />
					<portlet:param name="backURL" value="${videosURL}" />
					<portlet:param name="mvcPath" value="/video-bo-edit-video.jsp" />
					<portlet:param name="tab" value="videos" />
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text>
					<img src="${video.imageURL}" style="max-height:120px;"/>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editVideoURL}" name="title" truncate="true"
					orderable="true" value="${video.titleCurrentValue}" />
					
				<liferay-ui:search-container-column-text
					name="eu.video.provider">
					<c:forEach var="provider" items="${video.providers}" varStatus="status">
						<c:if test="${status.index gt 0}">
						 - 
						</c:if>
						${provider.getTitle(locale)}
					</c:forEach>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					name="themes">
					<c:forEach var="theme" items="${video.themes}" varStatus="status">
						<c:if test="${status.index gt 0}">
						 - 
						</c:if>
						${theme.getTitle(locale)}
					</c:forEach>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					cssClass="content-column table-cell-content" name="galleries">
					<c:forEach var="gallery" items="${video.videoGalleries}" varStatus="status">
						<c:if test="${status.index gt 0}">
						 - 
						</c:if>
						${gallery.getTitle(locale)}
					</c:forEach>
				</liferay-ui:search-container-column-text>

				<fmt:formatDate value="${video.modifiedDate}"
					var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text
					name="modified-date" truncate="true" orderable="true"
					value="${formattedModifiedDate}" />
					
				<liferay-ui:search-container-column-text name="user">
					${video.statusByUserName}
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${video.status}" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsVideo(video).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>

<liferay-portlet:actionURL name="selectionAction"
	var="deleteSelectionURL">
	<portlet:param name="cmd" value="delete" />
	<portlet:param name="tab" value="videos" />
	<portlet:param name="mvcPath" value="/video-bo-view-videos.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="selectionAction"
	var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="videos" />
	<portlet:param name="mvcPath" value="/video-bo-view-videos.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="selectionAction"
	var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="videos" />
	<portlet:param name="mvcPath" value="/video-bo-view-videos.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:actionURL>
<liferay-portlet:renderURL varImpl="filterSelectionURL">
	<portlet:param name="tab" value="videos" />
	<portlet:param name="mvcPath" value="/video-bo-view-videos.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:renderURL>

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

	function getCategoriesByVocabulary(vocabularyId, vocabularyName, categoriesId) {
		const portletURL = "${videosURL}";

		const url = Liferay.Util.PortletURL.createPortletURL(portletURL, {
			p_p_id: "com_liferay_asset_categories_selector_web_portlet_AssetCategoriesSelectorPortlet",
			p_p_lifecycle: 0,
			p_p_state: "pop_up",
			eventName: "com_liferay_asset_categories_selector_web_portlet_AssetCategoriesSelectorPortlet_selectCategory",
			selectedCategories: categoriesId,
			singleSelect : false,
			vocabularyIds: vocabularyId,
		});

		Liferay.Util.openSelectionModal(
			{
				onSelect: function (selectedItem) {
					if (selectedItem) {
						var url = "${filterSelectionURL}";
						if(!url.includes("filterCategoriesIdByVocabulariesName"))
							url += "&<portlet:namespace />filterCategoriesIdByVocabulariesName=";
						if(url.includes(encodeURIComponent(vocabularyName).replaceAll("%20","+").replaceAll("'","%27")+'__')){
							const regex = encodeURIComponent(vocabularyName).replaceAll("%20","\\+").replaceAll("'","%27") + "(.(?<!___))*___";
							const re = new RegExp(regex, 'gi');
							url = url.replace(re,"");
						}
						for(index in Object.keys(selectedItem)){
							var selection = selectedItem[Object.keys(selectedItem)[index]];
							url += encodeURIComponent(vocabularyName) + '__' + encodeURIComponent(selection.title) + '__' + selection.categoryId + '___';
						}
						submitForm(form, url);
					}
				},
				selectEventName: 'com_liferay_asset_categories_selector_web_portlet_AssetCategoriesSelectorPortlet_selectCategory',
				title: vocabularyName,
				multiple: true,
				url: url
			}
		)
	}
</aui:script>