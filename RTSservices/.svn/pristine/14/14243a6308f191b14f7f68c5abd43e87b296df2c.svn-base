<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<script type="text/javascript">
function editApplication(id)
{
	document.getElementById('applicationId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/application/editApplication.do');
}
</script>
<div class="mainHdr">
	<h3> <%-- <a href="<c:out value="${contextRoot}"/>/application/editApplication.do">
			<fmt:message key="application.manage.pagetitle.new"/> 
		</a> --%>
		<fmt:message key="application.list.pagetitle.list"/>
	</h3>
</div>
<div valign="top"  id="SetFormHeight">
<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
<thead>
<tr>
<td onclick="javascript:resort('upper(name)')" style="cursor:pointer" wrap>
<fmt:message key="application.list.label.name"/>
<span id="upper(name)"></span></td>

</tr>

</thead>
<tbody>
<c:set var="hasRows" value="false" />
<c:forEach var="ApplicationList" items="${requestScope.ApplicationList}" varStatus="rowNumber">
<c:set var="hasRows" value="true" />
<tr>
<td><%-- <a title="<fmt:message key="list.link.EditOrViewLink"/>" 
href="javascript:editApplication('${ApplicationList.applicationId}');">
<c:out value="${ApplicationList.name}"/></a> --%>
<c:out value="${ApplicationList.name}"/>
</td>

</tr>
</c:forEach>
<c:if test="${hasRows == false}">
<tr>
<td colspan=2  class="clsNoRecords" align="center">
<fmt:message key="list.label.norecords"/></td></tr></c:if>
</tbody>
<tfoot>
<tr>
<td colspan="2">
<c:if test="${requestScope.ApplicationList != null}">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</c:if>
</td>
</tr>
</tfoot>
</table>
<input type="hidden" id="applicationId" name="applicationId" value="<c:out value="${application.applicationId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>