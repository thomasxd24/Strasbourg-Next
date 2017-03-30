<%@ include file="/place-bo-init.jsp"%>
						
<div class="schedule-label" id="${param.index}"><label><liferay-ui:message key="date-exception" /> ${param.index}</label></div>
<div class="heure${param.index}" <c:if test="${not empty param and param.closed }">style="display: none;"</c:if>>
	<aui:input type="text" value="${param.startHour}" name="startHour${param.index}" label="start-hour" >
		<aui:validator errorMessage="hour-required" 
		name="custom">
	        function(val, fieldNode, ruleValue) {
		        var regex = new RegExp(/([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$/i);
		        return regex.test(val);
	        }
		</aui:validator>
	</aui:input>
	<div class="place-schedule-start-hour" style="display: none">
		<liferay-ui:message key="this-field-is-required" />
	</div>
	<aui:input type="text" value="${param.endHour}" name="endHour${param.index}" label="end-hour" >
		<aui:validator errorMessage="hour-required" 
		name="custom">
	        function(val, fieldNode, ruleValue) {
		        var regex = new RegExp(/([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$/i);
		        return regex.test(val);
	        }
		</aui:validator>
	</aui:input>
	<div class="place-schedule-end-hour" style="display: none">
		<liferay-ui:message key="this-field-is-required" />
	</div>
</div>
			
<aui:input name="scheduleExceptionDescription${param.index}" label="description" value="${param.comment}" localized="true" type="textarea"  />
<div class="place-schedule-description" style="display: none">
	<liferay-ui:message key="this-field-is-required" />
</div>

<aui:input type="date" name="startDateScheduleException${param.index}" label="start-date" value="${param.startDate}" />
<div class="place-schedule-start-date" style="display: none">
	<liferay-ui:message key="this-field-is-required" />
</div>

<aui:input type="date" name="endDateScheduleException${param.index}" label="end-date" value="${param.endDate}" />
<div class="place-schedule-end-date" style="display: none">
	<liferay-ui:message key="this-field-is-required" />
</div>
		

<aui:input name="closed${param.index}" label="closed" type="toggle-switch" 
	value="${not empty param ? param.closed : false}" onClick="affichageHeures(this, ${param.index})" />

