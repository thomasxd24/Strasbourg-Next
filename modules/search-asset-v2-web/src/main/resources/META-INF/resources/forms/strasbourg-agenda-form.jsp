<%@ include file="/search-asset-init.jsp"%>
<div class="st-barre-listing-sit st--listing-agenda">
    <div class="st-barre-inner st-wrapper form-styles">
<c:if test="${dc.displayDatesButtons}">
    <c:set var="dateSelected" value="${dc.dateSelected}" />
    <input type="hidden" name="<portlet:namespace />dateSelected" value="" />
        <div class="st-filtre st-group-field st--is-date">
            <label for="<portlet:namespace />fromDate"><liferay-ui:message key="eu.event.from-date" /></label>
            <div class="st-field-date">
                <input name="from" data-type="date" type="text" id="<portlet:namespace />fromDate" placeholder="JJ/MM/AAAA"
                       value="${dc.fromDay}/${dc.fromMonthValue lt 10 ? '0' :''}${dc.fromMonthValue}/${dc.fromYear}" />
                <input type="hidden" name="<portlet:namespace />fromDay" data-name="fromDay" value="${dc.fromDay}" />
                <input type="hidden" name="<portlet:namespace />fromMonth" data-name="fromMonth" value="${dc.fromMonthIndex}" />
                <input type="hidden" name="<portlet:namespace />fromYear" data-name="fromYear" value="${dc.fromYear}" />
            </div>
        </div>

        <div class="st-filtre st-group-field st--is-date">
            <label for="<portlet:namespace />toDate"><liferay-ui:message key="eu.event.to" /></label>
            <div class="st-field-date">
                <input name="to" data-type="date" type="text" id="<portlet:namespace />toDate" placeholder="JJ/MM/AAAA"
                       value="${dc.toDay}/${dc.toMonthValue lt 10 ? '0' :''}${dc.toMonthValue}/${dc.toYear}" />
                <input type="hidden" name="<portlet:namespace />toDay" data-name="toDay" value="${dc.toDay}" />
                <input type="hidden" name="<portlet:namespace />toMonth" data-name="toMonth" value="${dc.toMonthIndex}" />
                <input type="hidden" name="<portlet:namespace />toYear" data-name="toYear" value="${dc.toYear}" />
            </div>
        </div>
</c:if>

        <div class="st-filtre st-group-field st--is-expanded">
            <label for="type"><liferay-ui:message key="eu.event-type" /></label>
            <div class="st-field-select">
                <select id="type" name="<portlet:namespace />vocabulary_1" multiple="multiple" >
                    <option value="" disabled><liferay-ui:message key="eu.event-choose-type" /></option>
                    <c:set var="typeVocabulary" value="${vocabularyAccessor.eventTypes}" />
                    <c:forEach items="${dc.getDropdownRootCategories(typeVocabulary)}" var="category">
                        <c:set var="category" value="${category}" scope="request"/>
                        <c:set var="dc" value="${dc}" scope="request"/>
                        <c:set var="level" value="0" scope="request" />
                        <jsp:include page="/forms/category-option.jsp"/>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="st-filtre st-group-field st--is-expanded">
            <label for="place"><liferay-ui:message key="eu.place" /></label>
            <div class="st-field-select">
                <select id="place"  class="" name="idSIGPlace" multiple="multiple" >
                </select>
            </div>
        </div>

        <div class="st-filtre st-group-field  st--is-expanded">
            <label for="filter-lieu"><liferay-ui:message key="keywords" /></label>
            <input id="filter-lieu" type="text" name="<portlet:namespace />keywords"
                   placeholder="<liferay-ui:message key="please-enter-keyword" />" value="${dc.keywords}" />
        </div>

        <aui:input type="hidden" name="vocabulariesCount" value="4" />

        <div class="col-right">
            <p class="st-resultats st--resultats-agenda">
                <span class="st-resultats-range">${(dc.pager.currentPage - 1) * dc.delta + 1} <liferay-ui:message key="eu.to" />
                ${(dc.pager.currentPage * dc.delta) > dc.searchContainer.total ? dc.searchContainer.total : dc.pager.currentPage * dc.delta}
                </span>
                <span class="st-resultats-total">${dc.searchContainer.total} <liferay-ui:message key="results" /></span>
                <span class="st-resultats-period st-hide-from@t-portrait">Du </span>
            </p>

            <button class="st-btn st--btn-filtres">Filtrer <span class="st-filter-counter" aria-atomic="true">(2)</span></button>
        </div>
    </div>
</div>
<%--
<div class="seu-filter-block">

    <c:if test="${dc.displayDatesButtons}">
        <div class="title">
            <label><liferay-ui:message key="eu.event.by-date" /></label>
        </div>
    </c:if>
    <div class="seu-filter-line seu-filter-line-date">
        <c:if test="${dc.displayDatesButtons}">
            <c:set var="dateSelected" value="${dc.dateSelected}" />
            <input type="hidden" name="<portlet:namespace />dateSelected" value="" />
            <div class="seu-filter-line">
                <div class="widget button">
                    <button id="today" type="button" class="seu-btn-square seu-bordered seu-core ${dateSelected == 'today' ? 'active' : ''}">
                        <span class="seu-flexbox">
                            <span class="seu-btn-text" style="margin-right: 0"><liferay-ui:message key="today" /></span>
                        </span>
                    </button>
                </div>

                <div class="widget button">
                    <button id="tomorrow" type="button" class="seu-btn-square seu-bordered seu-core ${dateSelected == 'tomorrow' ? 'active' : ''}">
                        <span class="seu-flexbox">
                            <span class="seu-btn-text" style="margin-right: 0"><liferay-ui:message key="tomorrow" /></span>
                        </span>
                    </button>
                </div>

                <div class="widget button">
                    <button id="week-end" type="button" class="seu-btn-square seu-bordered seu-core ${dateSelected == 'week-end' ? 'active' : ''}">
                        <span class="seu-flexbox">
                            <span class="seu-btn-text" style="margin-right: 0"><liferay-ui:message key="eu.this-week-end" /></span>
                        </span>
                    </button>
                </div>
            </div>
        </c:if>

        <div class="seu-filter-line">
            <div class="content">
                <label class="title" for="<portlet:namespace />fromDate"><liferay-ui:message key="eu.event.from-date" /></label>
                <input class="date" name="from" data-type="date" type="text" id="<portlet:namespace />fromDate" placeholder="JJ/MM/AAAA"
                    value="${dc.fromDay}/${dc.fromMonthValue lt 10 ? '0' :''}${dc.fromMonthValue}/${dc.fromYear}">
                <input type="hidden" name="<portlet:namespace />fromDay" data-name="fromDay" value="${dc.fromDay}" />
                <input type="hidden" name="<portlet:namespace />fromMonth" data-name="fromMonth" value="${dc.fromMonthIndex}" />
                <input type="hidden" name="<portlet:namespace />fromYear" data-name="fromYear" value="${dc.fromYear}" />
            </div>

            <div class="content">
                <label class="title" for="<portlet:namespace />toDate"><liferay-ui:message key="eu.event.to" /></label>
                <input class="date" name="to" data-type="date" type="text" id="<portlet:namespace />toDate" placeholder="JJ/MM/AAAA"
                    value="${dc.toDay}/${dc.toMonthValue lt 10 ? '0' :''}${dc.toMonthValue}/${dc.toYear}">
                <input type="hidden" name="<portlet:namespace />toDay" data-name="toDay" value="${dc.toDay}" />
                <input type="hidden" name="<portlet:namespace />toMonth" data-name="toMonth" value="${dc.toMonthIndex}" />
                <input type="hidden" name="<portlet:namespace />toYear" data-name="toYear" value="${dc.toYear}" />
            </div>
        </div>
    </div>
</div>

<c:set var="showAdvancedSearch" value="${not empty dc.filterCategoriesIdsString}" />
<c:if test="${showAdvancedSearch}">
	<c:set var="displayBlockIfAdvancedSearch" value="style=\"display: block;\"" />
	<c:set var="openIfAdvancedSearch" value="opened" />
</c:if>
<div class="seu-btn-line advanced">
    <div class="seu-filter-line">
        <div class="widget">
            <div class="title">
                <label for="type"><liferay-ui:message key="eu.event-type" /></label>
            </div>
            <div class="content">
                <select class="" id="type" multiple="multiple" name="<portlet:namespace />vocabulary_1">
                    <option value="" disabled><liferay-ui:message key="eu.event-choose-type" /></option>
                    <c:set var="typeVocabulary" value="${vocabularyAccessor.eventTypes}" />
                    <c:forEach items="${dc.getDropdownRootCategories(typeVocabulary)}" var="category">
                        <c:set var="category" value="${category}" scope="request"/>
                        <c:set var="dc" value="${dc}" scope="request"/>
                        <c:set var="level" value="0" scope="request" />
                        <jsp:include page="/forms/category-option.jsp"/>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="widget">
            <div class="title">
                <label for="theme"><liferay-ui:message key="eu.place" /></label>
            </div>
            <div class="content">
                <select  class="" name="idSIGPlace" >
                </select>
            </div>
        </div>

        <div class="widget">
            <div class="title">
                <label for="name"><liferay-ui:message key="keywords" /></label>
            </div>
            <div class="content">
                <input type="text" id="name" name="<portlet:namespace />keywords"
                    placeholder="<liferay-ui:message key="please-enter-keyword" />" value="${dc.keywords}">
            </div>
        </div>
        <aui:input type="hidden" name="vocabulariesCount" value="4" />
    </div>

    <button type="button" class="seu-btn-square seu-filled seu-second seu-trigger-advanced-search ${openIfAdvancedSearch}">
        <span class="seu-flexbox">
            <span class="seu-btn-text"><liferay-ui:message key="advanced-search" /></span>
            <span class="seu-btn-arrow"></span>
        </span>
    </button>
</div>

<div class="seu-filter-advanced-search" ${displayBlockIfAdvancedSearch}>
    <div class="seu-filter-line">
        <div class="widget">
            <div class="title">
                <label for="public"><liferay-ui:message key="eu.event-public" /></label>
            </div>
            <div class="content">
                <select class="" id="public" multiple="multiple" name="<portlet:namespace />vocabulary_0">
                    <option value="" disabled><liferay-ui:message key="eu.event-choose-public" /></option>
                    <c:set var="publicVocabulary" value="${vocabularyAccessor.eventPublics}" />
                    <c:forEach items="${dc.getDropdownRootCategories(publicVocabulary)}" var="category">
						<c:set var="category" value="${category}" scope="request"/>
						<c:set var="dc" value="${dc}" scope="request"/>
						<c:set var="level" value="0" scope="request" />
						<jsp:include page="/forms/category-option.jsp"/>
					</c:forEach>
                </select>
            </div>
        </div>

        <div class="widget">
            <div class="title">
                <label for="theme"><liferay-ui:message key="eu.event-theme" /></label>
            </div>
            <div class="content">
                <select class="" id="theme" multiple="multiple" name="<portlet:namespace />vocabulary_2">
                    <option value="" disabled><liferay-ui:message key="eu.event-choose-theme" /></option>
                    <c:set var="themeVocabulary" value="${vocabularyAccessor.eventThemes}" />
                    <c:forEach items="${dc.getDropdownRootCategories(themeVocabulary)}" var="category">
						<c:set var="category" value="${category}" scope="request"/>
						<c:set var="dc" value="${dc}" scope="request"/>
						<c:set var="level" value="0" scope="request" />
						<jsp:include page="/forms/category-option.jsp"/>
					</c:forEach>
                </select>
            </div>
        </div>

        <div class="widget">
            <div class="title">
                <label for="territoire"><liferay-ui:message key="eu.event-territory" /></label>
            </div>
            <div class="content">
                <select class="" id="territoire" multiple="multiple" name="<portlet:namespace />vocabulary_3">
                    <option value="" disabled><liferay-ui:message key="eu.event-choose-territory" /></option>
                    <c:set var="territoryVocabulary" value="${vocabularyAccessor.territories}" />
                    <c:forEach items="${dc.getDropdownRootCategories(territoryVocabulary)}" var="category">
						<c:set var="category" value="${category}" scope="request"/>
						<c:set var="dc" value="${dc}" scope="request"/>
						<c:set var="level" value="0" scope="request" />
						<jsp:include page="/forms/category-option.jsp"/>
					</c:forEach>
                </select>
            </div>
        </div>
    </div>                    
</div>

<aui:input type="hidden" name="vocabulariesCount" value="4" />

<div class="seu-btn-line">
	<liferay-portlet:renderURL var="agendaURL" />
	<button type="button" onclick="window.location.href = '${agendaURL}'" class="seu-btn-square seu-bordered seu-core"> 
	    <span class="seu-flexbox">            
	        <span class="seu-btn-text" style="margin-right: 0"><liferay-ui:message key="cancel" /></span>
	    </span>
	</button>

    <button type="submit" class="seu-btn-square seu-filled seu-core">
        <span class="seu-flexbox">
            <span class="seu-btn-text"><liferay-ui:message key="search" /></span>
            <span class="seu-btn-arrow"></span>
        </span>
    </button>
</div>
--%>
<liferay-util:html-bottom>
    <aui:script>
        var idSIGPlace = '${dc.idSIGPlace}' ;
    </aui:script>
	
	<script src="/o/searchassetv2web/js/bloc-date.js"></script>
	<script src="/o/searchassetv2web/js/strasbourg-agenda.js"></script>
</liferay-util:html-bottom>

	