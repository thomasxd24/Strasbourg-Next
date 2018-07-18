<%@ include file="/resid-init.jsp" %>

<section id="resid">
	<c:if test="${dc.showDeleteButton()}">
		<button class="delete-wi" data-portlet-id="${themeDisplay.portletDisplay.id}"></button>
	</c:if>
    <h2><liferay-ui:message key="account-resid" /></h2>
	<!-- Etape 1 -->
    <div class="form-group">
		<div class="content" align="center">
			<a href="${dc.residURL}" target="_blank" class="btn-square--bordered--core" title="<liferay-ui:message key="bind-accounts"/>(<liferay-ui:message key="eu.new-window"/>)">
				<span class="flexbox">
					<span class="btn-text">
						<liferay-ui:message key="bind-accounts"/>
					</span>
					<span class="btn-arrow"></span>
				</span>
			</a>
		</div>
	</div>
</section>
