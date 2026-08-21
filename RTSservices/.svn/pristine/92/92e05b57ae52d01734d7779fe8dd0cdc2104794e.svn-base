<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils,com.mars.common.utils.Constants,com.mars.rti.utils.CoreConstants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<%pageContext.setAttribute("applicationStatusList", CommonUtils.getAplicationStatus());%>
<%pageContext.setAttribute("RTI_STATUS_PENDING", CoreConstants.RTI_STATUS_PENDING);%>
<%pageContext.setAttribute("RTI_STATUS_ACTIVE", CoreConstants.RTI_STATUS_ACTIVE);%>
<%pageContext.setAttribute("RTI_STATUS_FORWARD", CoreConstants.RTI_STATUS_FORWARD);%>
<%pageContext.setAttribute("RTI_STATUS_VERIFIED", CoreConstants.RTI_STATUS_VERIFIED);%>
<%pageContext.setAttribute("RTI_STATUS_ACCEPTED", CoreConstants.RTI_STATUS_ACCEPTED);%>

<script type="text/javascript">
function editOutboxFile(id) {
	document.getElementById('fileCreationId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplication.do');
}

function searchOutbox() {
	onPageSubmit('<c:out value="${contextRoot}"/>/outbox/listOutbox.do');
}
</script>

<div valign="top" id="SetFormHeight">
	<div id="SearchDivId" class="ClsSearch">
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			<fmt:message key="outbox.list.search.header" />
		</div>
		<table id="SearchTable" class="searchForm" border="0" cellpadding="2" cellspacing="1" width="100%" style="display:none;">
			<tr>
				<td width="17%">
					<fmt:message key="outbox.list.label.OutboxId" />
				</td>
				<td width="15%">
					<input type="text" maxlength="30" name="searchApplication" class="ClsAutoTextbox" id="searchApplication" 
						value="<c:out value="${SearchOptions.application}"/>" />
				</td>
				
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="button" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchOutbox()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchOutbox()" />

				</td>
			</tr>
		</table>
		<c:if test="${SearchOptions.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>
	<table border="0" class="dataGrid" cellpadding="0" cellspacing="1" width="98%">
		<thead>
		<tr class="ClsTRHeaderList">
			<td onclick="javascript:resort('upper(rtiApplnNumber)');" style="cursor: pointer" wrap>
				<fmt:message key="rtiApplication.list.label.rtiApplnNumber"/>
					<span id="upper(rtiApplnNumber)"></span>
			</td>
			<td class="ClsTDHeaderList" onclick="javascript:resort('upper(toUser)')" style="cursor:pointer" wrap>
				<fmt:message key="outbox.list.label.toUser" />
				<span id="upper(fileName)"></span>
			</td>
			<td class="ClsTDHeaderList" onclick="javascript:resortDate('Date')" style="cursor:pointer" wrap>
				<fmt:message key="outbox.list.label.date" />
				<span id="to_date(startDate,'dd-mm-yyyy')"></span>
			</td>
			
			<td class="ClsTDHeaderList" onclick="javascript:resort('upper(status)')" style="cursor:pointer" nowrap>
				<fmt:message key="outbox.list.label.status" />
				<span id="upper(status)"></span>
			</td>
			<td class="ClsTDHeaderList" onclick="javascript:resortDate('outwardNo')" style="cursor:pointer" wrap>
				<fmt:message key="outbox.list.label.outwardNo" />
				<span id="upper(inwardNo)"></span>
			</td>
		</tr>
		</thead>
		<tbody>
		<c:set var="hasRows" value="false" />
		<c:forEach var="outboxList" items="${requestScope.outboxList}" varStatus="rowNumber">
		<c:set var="hasRows" value="true" />	
		<tr>
		    <c:if test="${rtiApplication.rtiApplicationId != 0}">
			 <td>
			 <c:if test="${outboxList.rtiApplication.rtiApplicationId != 0}">
				<a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editOutboxFile('${outboxList.rtiApplication.rtiApplicationId}');">
				<c:out value="${outboxList.rtiApplication.rtiApplnNumber}" /></a>
			 </c:if>
			</td> 
			</c:if>
			
			<td>
				<c:out value="${outboxList.toUser.firstName}" />
			</td>
			
			<td>
				<c:out value="${outboxList.applnForwardDate}" />
			</td>
			
			<td>
				<c:if test="${outboxList.status == pageScope.RTI_STATUS_ACTIVE}">
					<c:out value="Created" />
				</c:if>
				<c:if test="${outboxList.status == pageScope.RTI_STATUS_FORWARD}">
					<c:out value="Forwarded" />
				</c:if>
			    <c:if test="${outboxList.status == pageScope.RTI_STATUS_PENDING}">
					<c:out value="Pending" />
				</c:if>
				<c:if test="${outboxList.status == pageScope.RTI_STATUS_ACCEPTED}">
					<c:out value="Accepted" />
				</c:if>
				<c:if test="${outboxList.status == pageScope.RTI_STATUS_VERIFIED}">
					<c:out value="Verified" />
				</c:if>
			</td>
			
			<td nowrap>
					<c:out value="${outboxList.outwardNo}" />
			</td>
		</tr>
		</c:forEach>
		
		<c:if test="${hasRows == false}">
			<tr>
				<td colspan=3  class="clsNoRecords" align="center">
				<fmt:message key="list.label.norecords"/></td>
			</tr>
		</c:if>
	</tbody>
	
	<tfoot>
		<tr>
			<td colspan="9">
				<c:if test="${requestScope.outboxList!= null && requestScope.totalCount>0}">
					<span><%@include file="/pages/common/pagination.jsp"%></span>
				</c:if>
			</td>
		</tr>
	</tfoot>
	</table>
</div>
