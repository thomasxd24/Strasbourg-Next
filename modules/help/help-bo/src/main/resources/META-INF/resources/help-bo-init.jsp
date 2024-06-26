<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://xmlns.jcp.org/portlet_3_0" prefix="portlet" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay" %>
<%@ taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %>

<%@ taglib uri="http://strasbourg.eu/tld/picker" prefix="strasbourg-picker" %>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-util:html-bottom>
	<script src="/o/helpbo/js/help-bo-main.js" type="text/javascript"></script>
</liferay-util:html-bottom>

<jsp:useBean id="vocabularyHelper" class="eu.strasbourg.utils.AssetVocabularyHelper" />

