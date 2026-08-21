<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<script type="text/javascript">
 function editFileCommunicationMode(id)
{
	document.getElementById('deliveryModeId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/deliveryMode/editDeliveryMode.do');
}
function searchFileType()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/deliveryMode/listDeliveryMode.do');
} 
</script>
<div class="mainHdr">
	<h3> <a href="<c:out value="${contextRoot}"/>/deliveryMode/editDeliveryMode.do">
			 New Delivery Mode
		</a>
		List Delivery Mode
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
		<c:forEach var="deliveryMode" items="${deliveryModeList}" varStatus="rowNumber">
			<c:set var="hasRows" value="true" />	
			<tr>
				<td><%-- <a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editFileCommunicationMode('${fileCommunicationModeList.fileCommunicationModeId}');"> --%>
					<c:out value="${deliveryMode.deliveryModeName}"/><!-- </a>	 -->			
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
			<c:if test="${not empty requestScope.deliveryModeList }">
			<span><%@include file="/pages/common/pagination.jsp"%></span>
			</c:if>
			</td>
		</tr>
	</tfoot>
</table>
<input type="hidden" id="deliveryModeId" name="deliveryModeId" value="" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>