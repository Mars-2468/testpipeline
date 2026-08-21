<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils,com.mars.rti.utils.CoreConstants;"/>

<%pageContext.setAttribute("applicationStatusList", CommonUtils.getAplicationStatus());%>
<%pageContext.setAttribute("RTI_STATUS_PENDING", CoreConstants.RTI_STATUS_PENDING);%>
<%pageContext.setAttribute("RTI_STATUS_ACTIVE", CoreConstants.RTI_STATUS_ACTIVE);%>
<%pageContext.setAttribute("RTI_STATUS_FORWARD", CoreConstants.RTI_STATUS_FORWARD);%>
<%pageContext.setAttribute("RTI_STATUS_VERIFIED", CoreConstants.RTI_STATUS_VERIFIED);%>
<%pageContext.setAttribute("RTI_STATUS_ACCEPTED", CoreConstants.RTI_STATUS_ACCEPTED);%>

<script type="text/javascript">

function editInboxFile(id,inboxId) {
	document.getElementById('inboxId').value=inboxId;
	document.getElementById('rtiApplicationId').value=id;
	
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplication.do');
}
function searchInbox() {
	onPageSubmit('<c:out value="${contextRoot}"/>/inbox/listInbox.do');
}

 function acceptFile(id)
{
     document.getElementById('inboxId').value=id;
     onPageSubmit('<c:out value="${contextRoot}"/>/inbox/acceptFile.do');
					
} 
</script>


<div valign="top" id="SetFormHeight">
	<div id="SearchDivId" class="ClsSearch">
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			<fmt:message key="inbox.list.search.header" />
		</div>
		<table id="SearchTable" class="searchForm" border="0" cellpadding="2" cellspacing="1" width="100%" style="display:none;">
			<tr>
				<td width="17%">
					<fmt:message key="rtiApplication.list.label.rtiApplnNumber" />
				</td>
				<td width="15%">
					<input type="text"  maxlength="30" name="searchApplication" class="ClsAutoTextbox" id="searchApplication" 
						value="<c:out value="${SearchOptions.application}"/>" />
				</td>
				
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="button" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchInbox()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchInbox()" />

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
				<td onclick="javascript:resort('rtiApplnNumber');" style="cursor: pointer" wrap>
					<fmt:message key="rtiApplication.list.label.rtiApplnNumber"/>
						<span id="rtiApplnNumber"></span>
				</td>
				<td class="ClsTDHeaderList" onclick="javascript:resort('fromUser')" style="cursor:pointer" wrap>
					<fmt:message key="inbox.manage.label.fromuser" />
					<span id="fromUser"></span>
				</td>
				
				<td class="ClsTDHeaderList" onclick="javascript:resortDate('startDate')" style="cursor:pointer" wrap>
					<fmt:message key="inbox.manage.label.startdate" />
					<span id="to_date(startDate,'dd-mm-yyyy')"></span>
				</td>
							
				<td class="ClsTDHeaderList" onclick="javascript:resort('status')" style="cursor:pointer" nowrap>
					<fmt:message key="inbox.manage.label.status" />
					<span id="status"></span>
				</td>
				<td class="ClsTDHeaderList" onclick="javascript:resortDate('inwardNo')" style="cursor:pointer" wrap>
					<fmt:message key="inbox.manage.label.inwardNo" />
					<span id="inwardNo"></span>
				</td>
				
				<td class="ClsTDHeaderList" onclick="javascript:resort('action')" style="cursor:pointer" nowrap>
					<fmt:message key="inbox.manage.label.action" />
					<span id="action"></span>
				</td>
			</tr>
		</thead>
		<tbody>
			<c:set var="hasRows" value="false" />
				<c:forEach var="inboxList" items="${requestScope.inboxList}" varStatus="rowNumber">
				<c:set var="hasRows" value="true" />	
					<tr>
					    <c:if test="${not empty inboxList.rtiApplication}">
						<td>
							<c:if test="${inboxList.status == pageScope.RTI_STATUS_ACCEPTED}">
								<a title="<fmt:message key="list.link.EditOrViewLink"/>" 
									href="javascript:editInboxFile('${inboxList.rtiApplication.rtiApplicationId}','${inboxList.inboxId}');">
								<c:out value="${inboxList.rtiApplication.rtiApplnNumber}" /></a>
							</c:if>
							<c:if test="${inboxList.status != pageScope.RTI_STATUS_ACCEPTED}">
								<c:out value="${inboxList.rtiApplication.rtiApplnNumber}" />
							</c:if>
						</td>
						</c:if>
						
						<td>
							<c:out value="${inboxList.fromUser.firstName}" />
						</td>
						
						<td>
							<c:out value="${inboxList.createdDate}" />
						</td>
						
						<td>
							<c:if test="${inboxList.status == pageScope.RTI_STATUS_ACTIVE}">
								<c:out value="Created" />
							</c:if>
							<c:if test="${inboxList.status == pageScope.RTI_STATUS_FORWARD}">
								<c:out value="Forwarded" />
							</c:if>
						    <c:if test="${inboxList.status == pageScope.RTI_STATUS_PENDING}">
								<c:out value="Pending" />
							</c:if>
							<c:if test="${inboxList.status == pageScope.RTI_STATUS_ACCEPTED}">
								<c:out value="Accepted" />
							</c:if>
							<c:if test="${inboxList.status == pageScope.RTI_STATUS_VERIFIED}">
								<c:out value="Verified" />
							</c:if>
								<%-- <c:forEach items="${pageScope.applicationStatusList}" var="statusList">			
										<c:if test="${inboxList.status == statusList[0]}"> 
											<c:out value="${statusList[1]}" />
										</c:if>
								</c:forEach> --%>
						</td>
						
						<td nowrap>
								<c:out value="${inboxList.inwardNo}" />
						</td>
						
						<c:if test="${not empty inboxList.rtiApplication}">
						    <td>
							     <c:if test="${inboxList.status==pageScope.RTI_STATUS_PENDING}">
						             <a title="Accept" href="javascript:acceptFile('${inboxList.inboxId}');">
										Accept
									  </a>
								  </c:if>
								  
								  <c:if test="${inboxList.status==pageScope.RTI_STATUS_ACCEPTED}">
								  		<c:out value="Accepted" />
								  </c:if>
					    	</td>
				    	</c:if>
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
				<c:if test="${requestScope.inboxList!= null && requestScope.totalCount>0}">
					<span><%@include file="/pages/common/pagination.jsp"%></span>
				</c:if>
			</td>
		</tr>
	</tfoot>
</table>
<input type="hidden" id="rtiApplicationId" name="rtiApplicationId" value="" /> 
<input type="hidden" id="inboxId" name="inboxId" value="" />
<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" />

<script type="text/javascript">

<script type="text/javascript">
insert_image('${contextRoot}');
$(".viewTd").each(function () {
    $(this).html($(this).text());
});
</script>
</div>

