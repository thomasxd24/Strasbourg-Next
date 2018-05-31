<%@ include file="/project-bo-init.jsp"%>

<c:set var="tab" value="${not empty param.tab ? param.tab : 'projects' }" />

<liferay-portlet:renderURL var="projectsURL">
	<portlet:param name="tab" value="projects" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="cmd" value="search" />
	<portlet:param name="tab" value="${param.tab}" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
</liferay-portlet:renderURL>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<aui:nav-item href="${projectsURL}" label="projects"
			selected="${tab eq 'projects'}" />
	</aui:nav>

	<aui:nav-bar-search>
		<aui:form action="${searchURL}" name="searchFm">
			<liferay-ui:input-search markupView="lexicon" />
		</aui:form>
	</aui:nav-bar-search>
</aui:nav-bar>

<c:choose>
    <c:when test="${tab eq 'projects'}">
		<liferay-util:include page="/project-bo-view-projects.jsp" servletContext="<%=application %>">
		</liferay-util:include>
    </c:when>
</c:choose>