<%@ include file="/project-popup-init.jsp"%>
<%@page
	import="com.liferay.portal.kernel.security.permission.ResourceActionsUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetRendererFactory"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="true"
	var="configurationRenderURL" />

<div class="container-fluid-1280 main-content-body">
	<liferay-ui:error key="wrong-friendly-url" message="wrong-friendly-url" />
	<aui:form action="${configurationActionURL}" method="post" name="fm" >

		<aui:input name="cmd" type="hidden" value="update" />

		<aui:input name="redirect" type="hidden"
			value="${configurationRenderURL}" />
		
		<aui:fieldset-group markupView="lexicon">
			<!-- Affichage -->
			<aui:fieldset collapsed="true" collapsible="true"
				label="display">

				<!-- Formulaire de recherche -->
				<aui:select name="popupTemplateId">
					<aui:option value="submitPetition" selected="${popupTemplateId eq 'submitPetition'}">
						<liferay-ui:message key="submitPetition" />
					</aui:option>
					<aui:option value="signPetition" selected="${popupTemplateId eq 'signPetition'}">
						<liferay-ui:message key="signPetition" />
					</aui:option>
					<aui:option value="giveInitiativeHelp" selected="${popupTemplateId eq 'giveInitiativeHelp'}">
						<liferay-ui:message key="giveInitiativeHelp" />
					</aui:option>
					<aui:option value="contactInitiativeAuthor" selected="${popupTemplateId eq 'contactInitiativeAuthor'}">
						<liferay-ui:message key="contactInitiativeAuthor" />
					</aui:option>
					<aui:option value="submitInitiative" selected="${popupTemplateId eq 'submitInitiative'}">
						<liferay-ui:message key="submitInitiative" />
					</aui:option>
					<aui:option value="submitBudget" selected="${popupTemplateId eq 'submitBudget'}">
						<liferay-ui:message key="submitBudget" />
					</aui:option>
					<aui:option value="editBudget" selected="${popupTemplateId eq 'editBudget'}">
						<liferay-ui:message key="editBudget" />
					</aui:option>
					<aui:option value="giveBudgetSupport" selected="${popupTemplateId eq 'giveBudgetSupport'}">
						<liferay-ui:message key="giveBudgetSupport" />
					</aui:option>
				</aui:select>
			</aui:fieldset>

			<!-- Desactivation de la popup -->
			<aui:fieldset collapsed="true" collapsible="true"
				label="disabling">

                <aui:input type="checkbox" name="disable" value="${disable}" label="disable" />
			</aui:fieldset>

		</aui:fieldset-group>

		<aui:button-row>
			<aui:button type="submit"></aui:button>
		</aui:button-row>
	</aui:form>
</div>
