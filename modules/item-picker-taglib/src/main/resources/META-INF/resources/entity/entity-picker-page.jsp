<%@include file="/picker-init.jsp" %>

<div class="strasbourg-entity-picker form-group">
	<p>
		<label>
			<liferay-ui:message key="${label}" />
			<c:if test="${required}">
				<span class="icon-asterisk text-warning"> 
					<span class="sr-only"><liferay-ui:message key="required" /></span>
				</span>
			</c:if>
		</label>
	</p>
	<ul id="entities-thumbnails-${name}">
		<c:forEach items="${entities}" var="entity">
			<li>
				${not empty entity.titleMap ? entity.getTitle(locale) : entity.title} <a href="#" class="remove-entity" data-entry-id="${entity.classPK}"><i class="icon-remove"></i></a>
			</li>
		</c:forEach>
	</ul>
	<p>
		<aui:button name="choose-entity-${name}" id="choose-entity-${name}" value="select" />
	</p>
	<div class="has-error">
		<aui:input name="${name}" type="hidden" value="${value}">
			<c:if test="${required}">
				<aui:validator name="required"
					errorMessage="this-field-is-required" />
			</c:if>
		</aui:input>
	</div>
</div>
<c:set var="dialogTitle" value="${type}" />
<c:if test="${multiple}">
	<c:set var="dialogTitle" value="${dialogTitle.concat('s')}" />
</c:if>
<aui:script>
$('#<portlet:namespace />choose-entity-${name}').on('click',
	function(event) {
		var multipleSelection = ${multiple};
		Liferay.Util.openSelectionModal(
			{
				selectEventName: 'itemSelected${name}',
				onSelect: function(item) {
					var items = [];
					if (multipleSelection && !!item) {
						items = item;
					} else if (!!item) {
						items.push(item);
					}

					for (var i = 0; i < items.length; i++) {
						var selectedItem = items[i];
						var htmlToAppend = '<li>'
							+ selectedItem.title + ' <a href="#" class="remove-entity" data-entry-id="' + selectedItem.entityId + '"><i class="icon-remove"></i></a>';
							+ '</li>';
						if (!multipleSelection) {
							$('#entities-thumbnails-${name}').empty();
							$('#entities-thumbnails-${name}').append(htmlToAppend);
							$('#<portlet:namespace />${name}').val(selectedItem.entityId);
						} else {
							var currentValue = $('#<portlet:namespace />${name}').val();
							var newValue = currentValue;
							if (currentValue.indexOf(selectedItem.entityId) === -1) {
								if (currentValue.length > 0) {
									newValue += ',';
								}
								newValue += selectedItem.entityId;
								$('#<portlet:namespace />${name}').val(newValue);
								$('#entities-thumbnails-${name}').append(htmlToAppend);
							}
						}
					}
				},
				title: '<liferay-ui:message key="${dialogTitle}"/>',
				url: '${itemSelectorURL}'
			}
		);
	}
);
$('#entities-thumbnails-${name}').on('click', '.remove-entity', function(e) {
	e.preventDefault();
	var valueToRemove = $(this).data('entry-id');
	$(this).parent().remove();
	var currentValue = $('#<portlet:namespace />${name}').val();
	var newValue = currentValue.replace(valueToRemove, '');
	newValue = newValue.replace(',,', ',');
	if (newValue[0] === ',') {
		newValue = newValue.slice(1);
	}
	if (newValue[newValue.length - 1] == ',') {
		newValue = newValue.slice(0, -1);
	}
	$('#<portlet:namespace />${name}').val(newValue);
});
</aui:script>