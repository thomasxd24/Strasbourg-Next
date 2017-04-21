<%@ include file="/place-schedule-init.jsp" %>
<jsp:useBean id="now" class="java.util.Date" />

<liferay-portlet:renderURL var="previousURL">
	<portlet:param name="categoryId" value="${category.categoryId}" />
	<portlet:param name="date" value="${previous}" />
	<portlet:param name="placeId" value="${placeId}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="nextURL">
	<portlet:param name="categoryId" value="${category.categoryId}" />
	<portlet:param name="date" value="${next}" />
	<portlet:param name="placeId" value="${placeId}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="changeDataURL">
	<portlet:param name="categoryId" value="${category.categoryId}" />
</liferay-portlet:renderURL>

<div class="container-fluid-1280 main-content-body">
	<c:choose>
		<c:when test="${noconfig}">
			<liferay-ui:message key="no-config" />
		</c:when>
		<c:when test="${empty places}">
			<liferay-ui:message key="no-places-x" arguments="${category.getTitle(locale)}" />
		</c:when>
		<c:otherwise>				
			<div class="row row-spacing">
				<form action="${changeDataURL}" method="post" name="fm">
				
					<div class="col-md-3" >
						<fmt:formatDate value="${jourChoisi}" pattern="yyyy-MM-dd" type="date" var="formattedDate"/>
						<aui:input type="date" name="date" value="${formattedDate}" inlineField="true" inlineLabel="left" label="date" style="margin-left: 10px;" />
					</div>
					
					<div class="col-md-6" >
						<aui:select class="form-control" name="placeId" label="select-place"  inlineField="true" inlineLabel="left" style="margin-left: 10px;" >
					        <aui:option value="" >
			        			${category.getTitle(locale).toUpperCase()}
			        		</aui:option>
							<c:forEach var="place" items="${places}">
			       				<c:if test="${place.placeId == placeId}">
							        <aui:option value="${place.placeId}" selected="true" >
					        			 - ${place.getAlias(locale)}
					        		</aui:option>
						        </c:if>	
			       				<c:if test="${place.placeId != placeId}">
							        <aui:option value="${place.placeId}" >
					        			 - ${place.getAlias(locale)}
					        		</aui:option>
						        </c:if>	
					        </c:forEach>
					    </aui:select>
					</div>
					
					<div class="col-md-2" >
						<aui:button cssClass="btn-lg" type="button" value="filtered" onClick="document.forms['fm'].submit(); return false;"/>
					</div>
					
					<div class="col-md-1" ></div>
					
				</form>
			</div>
			
			
			<aui:fieldset>${textSchedule}</aui:fieldset>
			
			<h3><liferay-ui:message key="title-schedule" /> ${category.getTitle(locale)}</h3>
			
			<aui:button-row>
				<div class="left" >
					<aui:button cssClass="btn-lg" type="button" href="${previousURL}" value="previous" />
				</div>
				
				<div class="right" >
					<aui:button cssClass="btn-lg" type="button" href="${nextURL}" value="next" />
				</div>
			</aui:button-row>
				
			<aui:fieldset>
	       		<c:if test="${!empty selectedPlaces}">
					<table>
					    <tr>
					        <th class="place" >
					        	${category.getTitle(locale)}
					        </th>
							<c:choose>
								<c:when test="${piscine}">
							        <th class="occupation" >
							        	<liferay-ui:message key="attendance" />
							        </th>
								</c:when>
								<c:when test="${parking}">
							        <th class="occupation" >
							        	<liferay-ui:message key="occupation" />
							        </th>
								</c:when>
							</c:choose>
							<fmt:formatDate value="${now}" type="date" var="formattedDateJour" dateStyle="SHORT"/>
							<c:forEach var="jour" items="${semaine}" varStatus="status" >
								<c:if test="${jour[1] != formattedDateJour}">
					        		<th class="jours screen" >
								</c:if>
								<c:if test="${jour[1] == formattedDateJour}">
					        		<th class="jours" >
									<c:set var="displayDate" value="${status.count}" />
								</c:if>
					        	${jour[0]}</th>
							</c:forEach>
					    </tr>
						<c:set var="color" value="1" />
						<c:forEach var="place" items="${selectedPlaces}">
							<tr class="color${place.SIGid}">
								<td >
								    <strong  class="title">${fn:toUpperCase(place.getAlias(locale))}</strong><br/>
								    ${place.getCity(locale)}<br />
									<strong><a href="${detailURL}/-/entity/place/${place.placeId}" class="linkMuseum"><liferay-ui:message key="link-detail" /></a></strong>
								</td>
								<c:if test="${piscine}">
										<c:set var="occupationState" value="${place.getRealTime('1')}" />
										<td rowspan="${place.getSubPlaces().size() + 1}" class="${occupationState.getCssClass()}" >
											<liferay-ui:message key="${occupationState.getLabel()}" />
											<c:if test="${not empty occupationState.getOccupation()}">
												<br/>${occupationState.getOccupation()} 
												<c:if test="${occupationState.getOccupation() <= 1}">
													<liferay-ui:message key="person" />
												</c:if>
												<c:if test="${occupationState.getOccupation() > 1}">
													<liferay-ui:message key="persons" />
												</c:if>
											</c:if>
								    	</td>
							    </c:if>
								<c:if test="${parking}">
										<c:set var="occupationState" value="${place.getRealTime('2')}" />
										<td rowspan="${place.getSubPlaces().size() + 1}" class="${occupationState.getCssClass()}" >
											<c:if test="${empty occupationState.getOccupation()}">
												<liferay-ui:message key="${occupationState.getLabel()}" />
											</c:if>
											<c:if test="${not empty occupationState.getOccupation()}">
												${occupationState.getOccupation()} 
												<liferay-ui:message key="places_available" /><br/>
												<liferay-ui:message key="capacity" /> ${occupationState.getCapacity()} 
											</c:if>
								    	</td>
							    </c:if>
							    <c:set var="hasURL" value="0" />
								<c:forEach var="period" items="${place.periods}" varStatus="status" >
									<c:if test="${!empty period.linkURL && !empty period.linkLabel}">  
										<td colspan="7">
									    	<a href="${period.getLinkURL(locale)}" target="_blank"> ${period.getLinkLabel(locale)}</a>
									    </td>   
										<c:set var="hasURL" value="1" />
										<c:set var="status.index" value="${items.size}" />
									</c:if>
								</c:forEach> 

								<c:if test="${hasURL == 0}">
									<c:forEach var="horaires" items="${place.getHoraire(jourChoisi, locale)}" varStatus="status" >
										<c:if test="${displayDate != status.count}">
							        		<td class="screen" >
										</c:if>
										<c:if test="${displayDate == status.count}">
							        		<td >
										</c:if>
											<c:forEach var="placeSchedule" items="${horaires.value}" varStatus="status">
												<c:if test="${placeSchedule.isException() || placeSchedule.isPublicHoliday()}">
													<span style="color:#B22222;">                              
												</c:if>
												<c:choose>
													<c:when test="${placeSchedule.isClosed()}">
														<liferay-ui:message key="eu.closed" />
													</c:when>
													<c:when test="${placeSchedule.isAlwaysOpen()}">
												        <liferay-ui:message key="always-open" />
													</c:when>
													<c:otherwise>
														<c:if test="${status.count > 1}">
															<br>
														</c:if>
														${placeSchedule.startTime} - ${placeSchedule.endTime} 
													</c:otherwise>
												</c:choose>
												<c:if test="${placeSchedule.isException() || placeSchedule.isPublicHoliday()}">
													*</span>                             
												</c:if>
											</c:forEach>
										</td>
									</c:forEach>
								</c:if>
							</tr>  
							<c:forEach var="subPlace" items="${place.getSubPlaces()}">
								<tr class="color${color}">
									 <td class="subPlace">
									    <strong>${fn:toUpperCase(subPlace.getName(locale))}</strong>
									</td>
								    <c:set var="hasURL" value="0" />
									<c:forEach var="period" items="${subPlace.periods}"  varStatus="status">
										<c:if test="${!empty period.linkURL && !empty period.linkLabel}">  
											<td colspan="7">
										    	<a href="${period.getLinkURL(locale)}" target="_blank"> ${period.getLinkLabel(locale)}</a>
										    </td>   
											<c:set var="hasURL" value="1" />                    
										</c:if>
									</c:forEach> 

									<c:if test="${hasURL == 0}">
										<c:forEach var="horaires" items="${subPlace.getHoraire(jourChoisi, locale)}" varStatus="status" >
											<c:if test="${displayDate != status.count}">
								        		<td class="screen" >
											</c:if>
											<c:if test="${displayDate == status.count}">
								        		<td >
											</c:if>
												<c:forEach var="placeSchedule" items="${horaires.value}" varStatus="status">
													<c:if test="${placeSchedule.isException() || placeSchedule.isPublicHoliday()}">
														<span style="color:#B22222;">                              
													</c:if>
													<c:choose>
														<c:when test="${placeSchedule.isClosed()}">
															<liferay-ui:message key="eu.closed" />
														</c:when>
														<c:when test="${placeSchedule.isAlwaysOpen()}">
													        <liferay-ui:message key="always-open" />
														</c:when>
														<c:otherwise>
															<c:if test="${status.count > 1}">
																<br>
															</c:if>
															${placeSchedule.startTime} - ${placeSchedule.endTime} 
														</c:otherwise>
													</c:choose>   
													<c:if test="${placeSchedule.isException() || placeSchedule.isPublicHoliday()}">
														*</span>                             
													</c:if>
												</c:forEach>
											</td>
										</c:forEach>
									</c:if>
								</tr>
							</c:forEach>
						</c:forEach>
					</table>
		       	</c:if>
			</aui:fieldset>
			
			<aui:button-row>
				<div class="left" >
					<aui:button cssClass="btn-lg" type="button" href="${previousURL}" value="previous" />
				</div>
				
				<div class="right" >
					<aui:button cssClass="btn-lg" type="button" href="${nextURL}" value="next" />
				</div>
			</aui:button-row>
			
       		<c:if test="${!empty exceptions}">
                <strong  style="color:#B22222;">
                	*<liferay-ui:message key="eu.exceptional-closings-openings" />
                </strong>
                <p>
					<c:forEach var="exceptions" items="${exceptions}" varStatus="status">
						<c:forEach var="placeSchedule" items="${exceptions.value}" varStatus="status2">
							<c:if test="${status.count + status2.count > 2}">
								<br>
							</c:if>
							<strong>
								${exceptions.key} - 
								${placeSchedule.period} 
							</strong>
							<c:if test="${placeSchedule.isClosed()}">
								<liferay-ui:message key="eu.closed" />
							</c:if>
							<c:if test="${!placeSchedule.isClosed()}">
								${placeSchedule.startTime} - ${placeSchedule.endTime}
							</c:if>
							- ${placeSchedule.getDescription()}
						</c:forEach>
					</c:forEach>
				</p>
       		</c:if>
			
		</c:otherwise>
	</c:choose>	
</div>
