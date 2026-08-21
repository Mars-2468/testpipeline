<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<script type="text/javascript">
 function editReceivedMode(id)
{
	document.getElementById('receivedModeId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/receivedMode/editReceivedMode.do');
}
function searchFileType()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/receivedMode/listReceivedMode.do');
} 
</script>
<div class="mainHdr">
	<h3> <a href="<c:out value="${contextRoot}"/>/receivedMode/editReceivedMode.do">
			Add New File Received Mode
		</a>
		List File Received Mode
	</h3>
</div>
<div valign="top" id="SetFormHeight">



<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
	<thead>
		<tr>
			<td  wrap>
			<fmt:message key="city.list.label.name"/>
			 </td>
			
		</tr>
	</thead>
	<tbody>
		<c:set var="hasRows" value="false" />
		<c:forEach var="receivedMode" items="${requestScope.listReceivedMode}" varStatus="rowNumber">
			<c:set var="hasRows" value="true" />	
			<tr>
				<td><a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editReceivedMode('${receivedMode.receivedModeId}');">
					<c:out value="${receivedMode.receivedModeName}"/></a>				
				</td>
				
			</tr>
		</c:forEach>
		<c:if test="${hasRows == false}">
		<tr>
			<td colspan=3  class="clsNoRecords" align="center">
			<fmt:message key="list.label.norecords"/></td>
		</tr></c:if>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="3">
			<c:if test="${not empty requestScope.listReceivedMode}">
			<span><%@include file="/pages/common/pagination.jsp"%></span>
			</c:if>
			</td>
		</tr>
	</tfoot>
</table>
<input type="hidden" id="receivedModeId" name="receivedModeId" value="" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>