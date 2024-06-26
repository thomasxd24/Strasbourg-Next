<%@ include file="/council-bo-init.jsp"%>

<%@page import="eu.strasbourg.service.council.model.CouncilSession"%>

<%-- URL : definit le lien menant vers la page de listage de l'entite --%>
<liferay-portlet:renderURL varImpl="councilSessionsURL">
	<portlet:param name="tab" value="councilSessions" />
    <portlet:param name="mvcPath" value="/council-bo-view-council-sessions.jsp" />
</liferay-portlet:renderURL>


<%-- URL : definit le lien menant vers la suppression de l'entite --%>
<liferay-portlet:actionURL name="deleteCouncilSession" var="deleteCouncilSessionURL">
	<portlet:param name="cmd" value="deleteCouncilSession" />
	<portlet:param name="tab" value="councilSessions" />
    <portlet:param name="mvcPath" value="/council-bo-view-council-sessions.jsp" />
	<portlet:param name="councilSessionId"
	    value="${not empty dc.councilSession ? dc.councilSession.councilSessionId : ''}" />
    <portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>

<%-- URL : definit le lien menant vers la sauvegarde de l'entite --%>
<liferay-portlet:actionURL name="saveCouncilSession" varImpl="saveCouncilSessionURL">
	<portlet:param name="tab" value="councilSessions" />
    <portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>

<%-- URL : definit le lien menant vers la gestion des procurations --%>
<liferay-portlet:renderURL varImpl="manageProcurationsURL">
    <portlet:param name="tab" value="councilSessions" />
    <portlet:param name="cmd" value="manageProcurations" />
    <portlet:param name="councilSessionId" value="${dc.councilSession.councilSessionId}" />
    <portlet:param name="backURL" value="${councilSessionsURL}" />
    <portlet:param name="mvcPath" value="/council-bo-manage-procurations.jsp" />
</liferay-portlet:renderURL>


<%-- URL : definit le lien menant vers la gestion des déliberations --%>
<liferay-portlet:renderURL varImpl="deliberationsURL">
    <portlet:param name="tab" value="deliberations" />
    <portlet:param name="cmd" value="viewDeliberations" />
    <portlet:param name="mvcPath" value="/council-bo-view-deliberations.jsp" />
</liferay-portlet:renderURL>





<liferay-portlet:resourceURL id="closeProcuration" var="closeProcurationURL"
        copyCurrentRenderParameters="false">
</liferay-portlet:resourceURL>


<div name="warnDiv" class="warnDiv" style="display: none;">
    <span name="warnMessageInput"> </span>
        <button id="closeMessageWarn" class="closeMessageWarn" name="closeMessageWarn">
            <liferay-ui:icon icon="times" markupView="lexicon"/>
        </button>
</div>
<div name="errorDiv" class="errorDiv" style="display: none;">
    <span name="errorMessageInput"> </span>
        <button id="closeMessageError" class="closeMessageError" name="closeMessageError">
            <liferay-ui:icon icon="times" markupView="lexicon"/>
        </button>
</div>

<aui:input cssClass="typeCouncilSessionHidden" id="typeCouncilSessionHidden" type="hidden"
    name="typeCouncilSessionHidden"
    value="${dc.councilSession.getTypeCouncil().getTitle()}" />

<aui:input cssClass="officalIdHidden" id="councilIdHidden" type="hidden"
    name="councilIdHidden"
    value="${not empty dc.councilSession ? dc.councilSession.councilSessionId : ''}" />

<%-- Composant : Body --%>
<div class="container-fluid container-fluid-max-xl main-content-body">

	<%-- Composant : definit la liste des messages d'erreur  (voir methode "validate" dans le saveAction de l'entite) --%>
	<liferay-ui:error key="title-error" message="title-error" />
	<liferay-ui:error key="title-already-used-error" message="title-already-used-error" />
	<liferay-ui:error key="date-error" message="date-error" />
	<liferay-ui:error key="title-already-exist-error" message="title-already-exist-error" />
	<liferay-ui:error key="official-leader-not-found-error" message="official-leader-not-found-error" />
	<liferay-ui:error key="official-leader-type-error" message="official-leader-type-error" />
    <liferay-ui:error key="official-voter-type-error" message="official-voter-type-error" />
    <liferay-ui:error key="official-voters-limit-error" message="official-voters-limit-error" />
    <liferay-ui:error key="council-of-type-already-exist-error" message="council-of-type-already-exist-error" />

	<%-- Composant : definit la liste des messages d'erreur  (voir methode "doProcessAction" dans le deleteAction de l'entite) --%>
	<liferay-ui:error key="council-has-delib-error" message="council-has-delib-error" />

	<%-- Composant : formulaire de saisie de l'entite --%>
	<aui:form action="${saveCouncilSessionURL}" method="post" name="fm" onSubmit="submitForm(event);">

		<%-- Propriete : definit l'entite de reference pour le formulaire--%>
		<aui:model-context bean="${dc.councilSession}" model="<%=CouncilSession.class %>" />
        <div class="sheet"><div class="panel-group panel-group-flush">

			<%-- Champ : (cache) PK de l'entite --%>
			<aui:input name="councilSessionId" type="hidden" />

			<%-- Groupe de champs : Generalites --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="general">

			    <%-- Champ : Titre --%>
                <aui:input name="title" required="true" size="75" />

                <%-- Champ : Type --%>
                <aui:select cssClass="toCustomSelect" id="council-type" name="council-type" label="council-type">
                    <c:forEach items="${dc.authorizedTypes}" var="type">
                        <aui:option value="${type.typeId}" selected="${dc.councilSession.typeId == type.typeId}">${type.title}</aui:option>
                    </c:forEach>
                </aui:select>

			    <%-- Champ : Date --%>
                <aui:input name="date" required="true" />

				<%-- Champ : President --%>
				<c:set var="officialLeaderFullName" value="${not empty officialLeaderId ? dc.officialLeaderFullName : ''}" />
				<div class="official-autocomplete-input-wrapper" id="official-autocomplete-input-wrapper">
                    <aui:input cssClass="autocomplete-shown" label="official-leader" type="text"
                        name="officialLeaderFullName" value="${officialLeaderFullName}" required="true" />
                    <aui:input cssClass="autocomplete-hidden" type="hidden" name="officialLeaderId" required="true" />
                </div>

			</aui:fieldset>

			<%-- Groupe de champs : Procuration --%>
			<aui:fieldset collapsed="<%=true%>" collapsible="<%=true%>" label="absents-and-procurations" >

                <c:choose>
                    <c:when test="${dc.isStillOpen()}">
                        <p style="color: red; text-align:center;">Des procurations sont encore ouvertes, veuillez toutes les fermer en fin de conseil pour permettre le recalcul</p>
                    </c:when>
                </c:choose>

                <div id="procurations-table">
                    <table border="1">

                        <tr>
                            <th class="th-hidden"/>
                            <th class="th-hidden"/>
                            <th class="th-hidden"/>
                            <th class="th-hidden"/>
                            <th colspan="2">
                                <strong><liferay-ui:message key="start" /></strong>
                            </th>
                            <th colspan="2">
                                <strong><liferay-ui:message key="end" /></strong>
                            </th>
                        </tr>

                        <tr>
                            <th>
                                <strong><liferay-ui:message key="official" /></strong>
                            </th>
                            <th>
                                <strong><liferay-ui:message key="procuration-mode" /></strong>
                            </th>
                            <th>
                                <strong><liferay-ui:message key="presential" /></strong>
                            </th>
                            <th>
                                <strong><liferay-ui:message key="official-receiver" /></strong>
                            </th>
                            <th>
                                <strong><liferay-ui:message key="hour" /></strong>
                            </th>
                            <th>
                                <strong><liferay-ui:message key="from-point" /></strong>
                            </th>
                            <th>
                                <strong><liferay-ui:message key="hour" /></strong>
                            </th>
                            <th>
                                <strong><liferay-ui:message key="to-point" /></strong>
                            </th>
                        </tr>

                        <c:set var="procurationsHistoric" value="${dc.getProcurationsHistoric()}" />
                        <c:forEach var="procuration" items="${procurationsHistoric}">
                            <c:set var="official" value="${dc.getOfficial(procuration.officialUnavailableId)}" />
                            <c:set var="officialVotersIdValue" value="${procuration.officialVotersId}" />
                            <c:set var="officialVotersFullName" value="${procuration.officialVotersFullName}" />
                            <c:set var="disabledInput" value="true" />

                            <tr data-council-types="${official.councilTypesIds}">
                                <td class="text-left">
                                    ${official.fullName}
                                </td>
                                <td>
                                <c:choose>
                                    <c:when test="${procuration.procurationMode eq 0}">
                                        -
                                    </c:when>
                                    <c:otherwise>
                                        ${procuration.procurationMode eq 4?procuration.otherProcurationMode:dc.getProcurationMode(procuration.procurationMode)}
                                    </c:otherwise>
                                </c:choose>
                                </td>
                                <td>
                                    ${empty dc.getProcurationPresential(procuration.presential)?"-":dc.getProcurationPresential(procuration.presential)}
                                </td>
                                <td class="text-left">
                                    ${empty officialVotersFullName?"Aucun":officialVotersFullName}
                                </td>
                                <td>
                                    ${dc.getStartHour(procuration)}
                                </td>
                                <td>
                                    ${dc.getStartDelibOrder(procuration.startDelib)}${procuration.isAfterVote && not empty dc.getStartDelibOrder(procuration.startDelib)?" - Intervenu apres le vote":""}
                                </td>
                                <td>
                                    ${dc.getEndHour(procuration)}
                                </td>
                                <td>
                                    ${dc.getEndDelibOrder(procuration.endDelib)}
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                </div>

                <button id="closeAllProcurationsButton" class="closeAll" name="closeAllProcurationsButton" title ="Fermer toutes les procurations"
                    action="closeAll" >
                    <liferay-ui:icon
                        icon="times-circle"
                        markupView="lexicon"
                        cssClass="closeAllIcon"
                    />
                    Fermer les procurations
                </button>
			</aui:fieldset>

            <aui:input cssClass="actionHidden" id="actionHidden" type="hidden"
                name="actionHidden"
                value="${actionValue}" />
        </div></div>

		<%-- Composant : Menu de gestion de l'entite --%>
		<aui:button-row>

			<aui:input type="hidden" name="workflowAction" value="" />

			<%-- Test : Verification des droits d'edition et de sauvegarde --%>
			<c:if test="${(dc.hasPermission('ADD_COUNCIL_SESSION') and empty dc.councilSession or dc.hasPermission('EDIT_COUNCIL_SESSION') and not empty dc.councilSession) and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<c:if test="${dc.workflowEnabled}">
					<aui:button cssClass="btn-lg" type="submit" value="save" />
				</c:if>
                <c:if test="${not dc.workflowEnabled}">
                    <aui:button cssClass="btn-lg" type="submit" name="publish" value="save" />
                </c:if>
			</c:if>

			<%-- Test : Verification des droits de supression --%>
			<c:if test="${not empty dc.councilSession && dc.hasPermission('DELETE_COUNCIL_SESSION') and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" onClick='<%=renderResponse.getNamespace() + "deleteEntity();"%>' type="cancel" value="delete" />
			</c:if>

			<%-- Composant : bouton de retour a la liste des entites --%>
			<aui:button cssClass="btn-lg" href="${councilSessionsURL}" type="cancel" />

            <c:if test="${not empty dc.councilSession}">
                <%-- Composant : bouton de gestion des procurations --%>
                <aui:button cssClass="btn-lg" href="${manageProcurationsURL}" type="cancel" value="Gestion des procurations" />

                <%-- Composant : bouton de gestion des deliberations --%>
                <aui:button cssClass="btn-lg" href="${deliberationsURL}" type="cancel" value="gestion-deliberations" />

                <!-- RESOURCE ACTION : Export de historique des procurations -->
                <liferay-portlet:resourceURL id="exportProcurationsHistoric" var="exportProcurationsHistoricURL"
                        copyCurrentRenderParameters="false">
                    <portlet:param name="councilSessionId"
                        value="${not empty dc.councilSession ? dc.councilSession.councilSessionId : ''}" />
                </liferay-portlet:resourceURL>
                <aui:button cssClass="btn-lg exportProcurations" href="${exportProcurationsHistoricURL}" type="cancel" value="export-procurations" />
            </c:if>

		</aui:button-row>

	</aui:form>

</div>

<liferay-util:html-top>
	<script>
		var editCouncilSession = true;
		var currentGroupId = ${dc.groupId}
	</script>
</liferay-util:html-top>

<liferay-util:html-bottom>
	<script	src="/o/agendabo/js/vendors/jquery.autocomplete.js"></script>
	<script src="/o/councilbo/js/council-bo-edit-council-session.js" type="text/javascript"></script>
</liferay-util:html-bottom>

<%-- Script : permet l'affichage des alertes de validation d'action --%>
<aui:script>
	function <portlet:namespace />deleteEntity() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this-entry" />')) {
			window.location = '${deleteCouncilSessionURL}';
		}
	}


    var namespace = '_eu_strasbourg_portlet_council_CouncilBOPortlet_';
    // Permet de passer des paramètres au bouton closeAllProcurations
    var closeAllProcurationsButton = document.getElementById("closeAllProcurationsButton");
    var action = document.getElementById(namespace+"actionHidden");
    closeAllProcurationsButton.addEventListener("click", function(element) {
        action.value = element.currentTarget.attributes["action"].value;

        if (window.confirm("Voulez-vous vraiment fermer toutes les procurations ?")) {
            closeProcuration(null);
        } else {
            element.preventDefault();
        }
    });



     function closeProcuration(officialId) {

             event.preventDefault();

             var councilSessionId = document.getElementById(namespace+"councilIdHidden").value;
             if(councilSessionId != ""){
                 if (officialId != null) {
                     var procurationId = document.getElementById(namespace+"procurationIdHidden").value;
                 } else {
                     var action = document.getElementById(namespace+"actionHidden").value;
                 }

                 AUI().use('aui-io-request', function(A) {
                         try {
                             A.io.request('${closeProcurationURL}', {
                                 method : 'POST',
                                 dataType: 'json',

                                 data:{
                                     <portlet:namespace/>action: action,
                                     <portlet:namespace/>officialId: officialId,
                                     <portlet:namespace/>councilSessionId: councilSessionId,
                                     <portlet:namespace/>procurationId: procurationId
                                 },
                                  on: {
                                     complete: function(e) {
                                     var response = e.details[1].responseText;
                                     if (response != "") {
                                         window.scrollTo(0, 0);
                                         var data = JSON.parse(response);

                                        var dataError = JSON.stringify(data.error);
                                        if (typeof dataError !== "undefined") {
                                             if(data.error.length != 0) {
                                                 var errorInputSpan = $("span[name=" + "errorMessageInput]")[0];
                                                 var errorDiv = $("div[name=" + "errorDiv]")[0];
                                                 errorInputSpan.innerHTML=data.error.error;
                                                 errorDiv.style.display="flex";
                                             }
                                         }
                                        var dataWarn = JSON.stringify(data.warn);
                                        if ( dataWarn !== {} || typeof dataWarn !== "undefined") {
                                             if (data.warn.length != 0) {
                                                 var warnInputSpan = $("span[name=" + "warnMessageInput]")[0];
                                                 var warnDiv = $("div[name=" + "warnDiv]")[0];
                                                 warnInputSpan.innerHTML=data.warn.warn;
                                                 warnDiv.style.display="flex";
                                             }
                                        }
                                     }
                                         window.location.reload();
                                         $("button[name="+ officialId + "-closeButton]")[0].attributes["procuration-id"].value='';
                                         $("select[name=" + namespace + officialId + "-modeSelect]").prop('disabled', true);
                                         $("select[name=" + namespace + officialId + "-presentialSelect]").prop('disabled', true);
                                         $("input[name=" + namespace + officialId + "-officialVoters]").prop('disabled', true);
                                         $("input[name=" + namespace + officialId + "-autre]").prop('disabled', true);
                                     }
                                 }
                             });
                         }
                         catch(error) {
                             if(!(error instanceof TypeError)){
                                 console.log(error);
                             } else console.log("petite erreur sans importance")
                         }
                     });
                     }
                 }

</aui:script>