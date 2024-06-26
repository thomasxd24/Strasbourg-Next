<%@ include file="/agenda-export-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.agenda.model.AgendaExport"%>
<c:set var="agendaExport" value="${dc.agendaExport}" />
<c:set var="toExport" value="${dc.toExport}" />

<liferay-portlet:actionURL name="deleteAgendaExport" var="deleteAgendaExportURL">
	<portlet:param name="cmd" value="deleteAgendaExport" />
	<portlet:param name="tab" value="agendaExports" />
	<portlet:param name="agendaExportId"
		value="${not empty agendaExport ? agendaExport.agendaExportId : ''}" />
    <portlet:param name="mvcPath" value="/agenda-export-bo-view-agenda-export.jsp" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="saveAgendaExport" varImpl="saveAgendaExportURL">
	<portlet:param name="tab" value="agendaExports" />
    <portlet:param name="backURL" value="${param.backURL}" />
	<portlet:param name="agendaExportId"
		value="${not empty agendaExport ? agendaExport.agendaExportId : ''}" />
</liferay-portlet:actionURL>

<liferay-portlet:resourceURL var="exportAgendaExportURL" id="exportAgendaExport">
</liferay-portlet:resourceURL>

<div class="container-fluid container-fluid-max-xl main-content-body">
    <aui:form action="${(toExport eq true) ? dc.cleanResourceURL(exportAgendaExportURL) : saveAgendaExportURL}" method="POST" name="fm">

		<aui:model-context bean="${agendaExport}" model="<%=AgendaExport.class %>" />
        <div class="sheet"><div class="panel-group panel-group-flush">
			<aui:input name="agendaExportId" type="hidden" />

			<aui:fieldset collapsed="false" collapsible="true"
				label="general">

				<aui:input name="title">
					<aui:validator name="required"
						errorMessage="this-field-is-required" />
				</aui:input>

			</aui:fieldset>

           <aui:fieldset collapsed="true" collapsible="true" label="eu.agenda.export.period">
                <label>
                    <span><liferay-ui:message key="eu.agenda.export.period" /></span>
                    <span class="icon-asterisk text-warning"></span>
                </label>
                <liferay-ui:error key="period-date-error" message="period-date-error" />
                <liferay-ui:error key="period-error" message="period-error" />
                <div id="date-fields">
                    <c:forEach items="${dc.getOrCreateAgendaExportPeriods()}" var="period" varStatus="status">
                        <div class="lfr-form-row lfr-form-row-inline">
                            <div class="row-fields">
                                <fmt:formatDate value="${period.startDate}" pattern="dd/MM/yyyy" type="date" var="formattedStartDate"/>
                                <fmt:formatDate value="${period.endDate}" pattern="dd/MM/yyyy" type="date" var="formattedEndDate"/>
                                <liferay-util:include page="/includes/period-row.jsp" servletContext="<%=application %>">
                                    <liferay-util:param name="index" value="0" />
                                    <liferay-util:param name="startDate" value="${formattedStartDate}" />
                                    <liferay-util:param name="endDate" value="${formattedEndDate}" />
                                </liferay-util:include>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div id="required-period" style="display:none">
                    <span><liferay-ui:message key="eu.agenda.export.period.required" /><span>
                </div>
           </aui:fieldset>

           <aui:fieldset collapsed="true" collapsible="true" label="eu.agenda.export.period.categories">
                <c:forEach var="vocabulary" items="${dc.eventVocabularies}" varStatus="status">
                    <label><span>${vocabulary.getTitle(locale)}</span></label>
                    <select
                        id="vocabulary${status.index}"
                        class="choices-element"
                        name="<portlet:namespace />vocabulary_${status.index}_select"
                        placeholder="<liferay-ui:message key="select-multiple" />"
                    multiple>
                        <c:forEach var="category" items="${vocabulary.categories}">
                            <option
                                value="${category.categoryId}"
                                <c:if test="${fn:contains(dc.getSavedCategoriesByVocabulary(vocabulary.vocabularyId), Long.toString(category.categoryId) )}">
                                    selected="selected"
                                </c:if>
                            >
                                ${category.getTitle(locale)}
                            </option>
                        </c:forEach>
                    </select>
                    <aui:input
                        type="hidden"
                        name="vocabulary_${status.index}_id"
                        value="${vocabulary.vocabularyId}"
                    />
                </c:forEach>
                 <aui:input type="hidden" name="vocabulary_number" value="${dc.eventVocabularies.size()}"/>
           </aui:fieldset>

           <aui:fieldset collapsed="true" collapsible="true" label="Tags">
               <liferay-asset:asset-tags-selector
                       className="<%= AgendaExport.class.getName() %>"
                       classPK="${dc.agendaExport.agendaExportId}"
               />
           </aui:fieldset>

            <%--
           <aui:fieldset collapsible="true" label="eu.agenda.export.languages">
                <aui:select name="language" label="detail-target-site">
                    <c:forEach var="language" items="${dc.languageList}">
                        <aui:option
                            value="${language}"
                            selected="${language eq dc.agendaExport.language ? true : false}"
                        >
                            ${language}
                        </aui:option>
                    </c:forEach>
                </aui:select>
           </aui:fieldset>
           --%>

            <aui:fieldset collapsible="true" label="eu.agenda.export.format.title">

                <aui:select name="exportFormat" label="eu.agenda.export.target.format">
                   <c:forEach var="format" items="${dc.formatExportList}">
                       <aui:option
                           value="${format}"
                           selected="${format eq dc.agendaExport.exportFormat ? true : false}"
                       >
                           ${format}
                       </aui:option>
                   </c:forEach>
                </aui:select>

                <aui:select name="template" label="eu.agenda.export.target.template">
                   <c:forEach var="template" items="${dc.templateList}">
                       <aui:option
                           value="${template.key}"
                           selected="${template.key eq dc.agendaExport.templateId ? true : false}"
                       >
                           ${template.value}
                       </aui:option>
                   </c:forEach>
                   <aui:validator name="required" errorMessage="this-field-is-required" />
                </aui:select>
                <div id="required-template" style="display:none">
                    <span><liferay-ui:message key="eu.agenda.export.template.required" /><span>
                </div>
            </aui:fieldset>

            <aui:fieldset collapsible="true" label="eu.agenda.export.format.configurations">

                <aui:select id="aggregationLevel" name="aggregationLevel" label="eu.agenda.export.aggregation.level">
                   <c:forEach var="level" items="${dc.aggregationLevel}">
                       <aui:option
                           value="${level.key}"
                           selected="${level.key eq dc.getAggregationDepth() ? true : false}"
                       >
                           ${level.value}
                       </aui:option>
                   </c:forEach>
                </aui:select>

                <%-- First level Aggregation --%>

                <div id="firstAggregationBlock" class="aggregationFields">
                    <aui:select id="firstAggregationType" name="firstAggregationType" cssClass="aggregation-type" label="eu.agenda.export.aggregation.types.first">
                        <c:forEach var="type" items="${dc.aggregationTypes}">
                           <aui:option
                                value="${type.key}"
                                selected="${type.key eq dc.getAggregationSavedValue('first', 'type') ? true : false}"
                           >
                               ${type.value}
                           </aui:option>
                        </c:forEach>
                    </aui:select>

                    <div class="wrapper">
                        <aui:select id="firstAggregationVocabulary" cssClass="vocabulary-select" name="firstAggregationVocabulary" label="eu.agenda.export.aggregation.vocabulary">
                            <aui:option value="">
                                <liferay-ui:message key="eu.agenda.export.aggregation.value.none" />
                            </aui:option>
                            <c:forEach var="vocabulary" items="${dc.eventVocabularies}">
                                <aui:option
                                    value="${vocabulary.vocabularyId}"
                                    selected="${dc.getAggregationSavedValue('first', 'vocabulary') eq vocabulary.vocabularyId ? true : false}"
                                >
                                    ${vocabulary.getTitle(locale)}
                               </aui:option>
                            </c:forEach>
                        </aui:select>
                    </div>

                    <div class="wrapper">
                        <aui:select id="firstAggregationCategory" name="firstAggregationCategory" label="eu.agenda.export.aggregation.category">
                            <aui:option value="">
                                <liferay-ui:message key="eu.agenda.export.aggregation.value.none" />
                            </aui:option>
                            <c:forEach var="category" items="${dc.getSavedEventCategories('first')}">
                                <aui:option
                                    value="${category.key}"
                                    selected="${dc.getAggregationSavedValue('first', 'category') eq category.key ? true : false}"
                                >
                                    ${category.value}
                               </aui:option>
                            </c:forEach>
                        </aui:select>
                        <div>
                            <aui:input
                                type="checkbox"
                                name="firstCategoryFilter"
                                cssClass="category-checkboxes"
                                label="eu.agenda.export.aggregation.category.check"
                                checked="${dc.getAggregationCategoryFilter('first')}" >
                            </aui:input>
                        </div>
                        <div id="required-first-category" style="display:none">
                             <span><liferay-ui:message key="eu.agenda.export.category.required" /><span>
                         </div>
                    </div>
                </div>

                <%-- Second level Aggregation --%>

                <div id="secondAggregationBlock" class="aggregationFields">
                    <aui:select id="secondAggregationType" name="secondAggregationType" cssClass="aggregation-type" label="eu.agenda.export.aggregation.types.second">
                        <c:forEach var="type" items="${dc.aggregationTypes}">
                           <aui:option
                               value="${type.key}"
                                selected="${dc.getAggregationSavedValue('second', 'type') eq type.key ? true : false}"
                           >
                               ${type.value}
                           </aui:option>
                        </c:forEach>
                    </aui:select>

                    <div class="wrapper">
                        <aui:select id="secondAggregationVocabulary" cssClass="vocabulary-select" name="secondAggregationVocabulary" label="eu.agenda.export.aggregation.vocabulary">
                            <aui:option value="">
                                <liferay-ui:message key="eu.agenda.export.aggregation.value.none" />
                            </aui:option>
                            <c:forEach var="vocabulary" items="${dc.eventVocabularies}">
                                <aui:option
                                  value="${vocabulary.vocabularyId}"
                                  selected="${dc.getAggregationSavedValue('second', 'vocabulary') eq vocabulary.vocabularyId ? true : false}"
                                >
                                    ${vocabulary.getTitle(locale)}
                               </aui:option>
                            </c:forEach>
                        </aui:select>
                    </div>

                    <div class="wrapper">
                        <aui:select id="secondAggregationCategory" name="secondAggregationCategory" label="eu.agenda.export.aggregation.category">
                            <aui:option value="">
                                <liferay-ui:message key="eu.agenda.export.aggregation.value.none" />
                            </aui:option>
                            <c:forEach var="category" items="${dc.getSavedEventCategories('second')}">
                                <aui:option
                                    value="${category.key}"
                                    selected="${dc.getAggregationSavedValue('second', 'category') eq category.key ? true : false}"
                                >
                                    ${category.value}
                               </aui:option>
                            </c:forEach>
                        </aui:select>
                        <div>
                            <aui:input
                                type="checkbox"
                                name="secondCategoryFilter"
                                cssClass="category-checkboxes"
                                label="eu.agenda.export.aggregation.category.check"
                                checked="${dc.getAggregationCategoryFilter('second')}" >
                            </aui:input>
                        </div>
                        <div id="required-second-category" style="display:none">
                             <span><liferay-ui:message key="eu.agenda.export.category.required" /><span>
                         </div>
                    </div>
                </div>
            </aui:fieldset>

        </div></div>

		<aui:button-row>
            <c:if test="${toExport ne true}">
                <c:if test="${(dc.hasPermission('ADD_AGENDA_EXPORT') and empty agendaExport or dc.hasPermission('EDIT_AGENDA_EXPORT') and dc.canEditAdminContent(agendaExport.agendaExportId) and not empty agendaExport) and empty themeDisplay.scopeGroup.getStagingGroup()}">
                    <aui:input type="hidden" name="workflowAction" value="" />
                    <c:if test="${dc.workflowEnabled}">
                        <aui:button cssClass="btn-lg" type="submit" value="save" />
                    </c:if>
                    <c:if test="${not dc.workflowEnabled}">
                        <aui:button cssClass="btn-lg" type="submit" name="publish"
                                value="eu.publish" />
                        <aui:button cssClass="btn-lg btn-default" type="submit" name="save-as-draft"
                                value="save-as-draft" />
                    </c:if>
                </c:if>
                <c:if test="${not empty agendaExport and dc.canEditAdminContent(agendaExport.agendaExportId) and dc.hasPermission('DELETE_AGENDA_EXPORT') and dc.canEditAdminContent(agendaExport.agendaExportId) and empty themeDisplay.scopeGroup.getStagingGroup()}">
                    <aui:button cssClass="btn-lg" onClick='<%=renderResponse.getNamespace() + "deleteEntity();"%>' type="cancel"
                        value="delete" />
                </c:if>
            </c:if>
            <c:if test="${toExport eq true}">
                <aui:button id="export-btn-submit" cssClass="btn-lg" type="submit" value="eu.export"/>
            </c:if>
			<aui:button cssClass="btn-lg" href="${param.backURL}" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>

<div id="result"></div>

<liferay-util:html-top>
	<script>
        var getPeriodRowJSPURL = '${periodRowURL}';
        var getSlotRowJSPURL = '${slotRowURL}';
        var getAttendanceRowJSPURL = '${attendanceRowURL}';
        var getScheduleExceptionRowJSPURL = '${scheduleExceptionRowURL}';
	</script>
</liferay-util:html-top>
<liferay-util:html-bottom>
    <!-- Include Choices CSS -->
	<link rel="stylesheet" href="/o/agendaexportbo/css/vendors/choices.min.css">
	<!-- Include Choices JavaScript -->
	<script src="/o/agendaexportbo/js/vendors/moment.min.js"
		type="text/javascript"></script>
    <script src="/o/agendaexportbo/js/vendors/choices.min.js"
            type="text/javascript"></script>
	<script
		src="/o/agendaexportbo/js/vendors/daterangepicker.js"
		type="text/javascript"></script>
	<script
		src="/o/agendaexportbo/js/vendors/jquery.autocomplete.js"
		type="text/javascript"></script>
	<script
		src="/o/agendaexportbo/js/agenda-export-bo-edit-event.js"
		type="text/javascript"></script>
</liferay-util:html-bottom>

<script type="text/javascript">

    var exportResourceUrl = '${exportAgendaExportURL}';

</script>

<aui:script>
	function <portlet:namespace />deleteEntity() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this-entry" />')) {
			window.location = '${deleteAgendaExportURL}';
		}
	}
</aui:script>