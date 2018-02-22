<%@ include file="/interest-viewer-init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="true"
	var="configurationRenderURL" />

<div class="container-fluid-1280 main-content-body">
	<aui:form action="${configurationActionURL}" method="post" name="fm">
	
		<aui:input name="cmd" type="hidden"
			value="update" />
	
		<aui:input name="redirect" type="hidden"
			value="${configurationRenderURL}" />
			
		<aui:fieldset>
			<!-- Mode d'affichage -->
			<aui:select name="template">
				<aui:option value="liste" selected="${template eq 'liste'}">
					<liferay-ui:message key="list" />
				</aui:option>
				<aui:option value="widget" selected="${template eq 'widget'}">
					<liferay-ui:message key="widget" />
				</aui:option>
			</aui:select>
		</aui:fieldset>
		
		<aui:fieldset>
			<aui:input name="noInterestMap" value="${noInterest}" localized="true" type="editor" label="text" />
		</aui:fieldset>
		
		<aui:button-row>
			<aui:button type="submit"></aui:button>
		</aui:button-row>
	</aui:form>
</div>

<style>
	fieldset {
		margin-bottom: 20px;
	}
</style>