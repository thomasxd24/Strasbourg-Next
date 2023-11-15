<%@ include file="/video-bo-init.jsp" %>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}'/>

<liferay-portlet:renderURL varImpl="galleriesURL">
    <portlet:param name="mvcPath" value="/video-bo-view-galleries.jsp"/>
    <portlet:param name="tab" value="galleries"/>
    <portlet:param name="orderByCol" value="${dc.orderByCol}"/>
    <portlet:param name="orderByType" value="${dc.orderByType}"/>
    <portlet:param name="keywords" value="${dc.keywords}"/>
    <portlet:param name="delta" value="${dc.searchContainer.delta}"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="addGalleryURL">
    <portlet:param name="cmd" value="editGallery"/>
    <portlet:param name="tab" value="galleries"/>
    <portlet:param name="mvcPath" value="/video-bo-edit-gallery.jsp"/>
    <portlet:param name="backURL" value="${galleriesURL}"/>
</liferay-portlet:renderURL>

<clay:management-toolbar
        managementToolbarDisplayContext="${managementDC}"
/>
<div class="container-fluid container-fluid-max-xl main-content-body">

    <aui:form method="post" name="fm">
        <liferay-ui:search-container id="galleriesSearchContainer"
                                     searchContainer="${dc.searchContainer}">

            <liferay-ui:search-container-row
                    className="eu.strasbourg.service.video.model.VideoGallery"
                    modelVar="gallery" keyProperty="galleryId">
                <liferay-portlet:renderURL varImpl="editGalleryURL">
                    <portlet:param name="cmd" value="editGallery"/>
                    <portlet:param name="galleryId" value="${gallery.galleryId}"/>
                    <portlet:param name="backURL" value="${galleriesURL}"/>
                    <portlet:param name="mvcPath" value="/video-bo-edit-gallery.jsp"/>
                    <portlet:param name="tab" value="galleries"/>
                </liferay-portlet:renderURL>

                <liferay-ui:search-container-column-text>
                    <img src="${gallery.imageURL}" style="max-height:120px;"/>
                </liferay-ui:search-container-column-text>

                <liferay-ui:search-container-column-text cssClass="content-column"
                                                         href="${editGalleryURL}" name="title" truncate="true"
                                                         orderable="true" value="${gallery.titleCurrentValue}"/>

                <fmt:formatDate value="${gallery.modifiedDate}"
                                var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm"/>
                <liferay-ui:search-container-column-text
                        name="modified-date" orderable="true"
                        value="${formattedModifiedDate}"/>

                <liferay-ui:search-container-column-text name="status">
                    <aui:workflow-status markupView="lexicon" showIcon="false"
                                         showLabel="false" status="${gallery.status}"/>
                </liferay-ui:search-container-column-text>

                <liferay-ui:search-container-column-text>
                    <clay:dropdown-actions
                            aria-label="<liferay-ui:message key='show-actions' />"
                            dropdownItems="${dc.getActionsGallery(gallery).getActionDropdownItems()}"
                    />
                </liferay-ui:search-container-column-text>

            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator paginate="true" displayStyle="list"
                                        markupView="lexicon" searchContainer="${dc.searchContainer}"/>
        </liferay-ui:search-container>
    </aui:form>
</div>

<liferay-portlet:actionURL name="selectionAction"
                           var="deleteSelectionURL">
    <portlet:param name="cmd" value="delete"/>
    <portlet:param name="tab" value="galleries"/>
    <portlet:param name="mvcPath" value="/video-bo-view-galleries.jsp"/>
    <portlet:param name="orderByCol" value="${dc.orderByCol}"/>
    <portlet:param name="orderByType" value="${dc.orderByType}"/>
    <portlet:param name="keywords" value="${dc.keywords}"/>
    <portlet:param name="delta" value="${dc.searchContainer.delta}"/>
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
                           var="publishSelectionURL">
    <portlet:param name="cmd" value="publish"/>
    <portlet:param name="tab" value="galleries"/>
    <portlet:param name="mvcPath" value="/video-bo-view-galleries.jsp" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
                           var="unpublishSelectionURL">
    <portlet:param name="cmd" value="unpublish"/>
    <portlet:param name="tab" value="galleries"/>
    <portlet:param name="mvcPath" value="/video-bo-view-galleries.jsp" />
</liferay-portlet:actionURL>

<aui:script>
    var form = document.querySelector("[name='<portlet:namespace/>fm']");

    function deleteSelection() {
        if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-selected-entries"/>')) {
            submitForm(form, '${deleteSelectionURL}');
        }
    }
    function publishSelection() {
        if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-publish-selected-entries"/>')) {
            submitForm(form, '${publishSelectionURL}');
        }
    }
    function unpublishSelection()
    {
        if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-unpublish-selected-entries"/>'))
        {
            submitForm(form, '${unpublishSelectionURL}');
        }
    }
</aui:script>