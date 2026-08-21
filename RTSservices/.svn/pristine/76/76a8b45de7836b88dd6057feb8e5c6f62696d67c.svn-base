<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<script type="text/javascript">
function editEmployee(id)
{
	document.getElementById('employeeId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/employee/editEmployee.do');
}
</script>
<div class="mainHdr">
	<h3> <a href="<c:out value="${contextRoot}"/>/employee/editEmployee.do">
			<fmt:message key="employee.manage.pagetitle.new" /> 
		</a>
		<fmt:message key="employee.list.pagetitle.list" />
	</h3>
</div>
<div valign="top"  id="SetFormHeight">
<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
<thead>
<tr>
<td onclick="javascript:resort('upper(firstName)')" style="cursor:pointer" wrap>
<fmt:message key="employee.list.label.firstName"/>
<span id="upper(firstName)"></span></td>
<td onclick="javascript:resort('upper(designation.name)')" style="cursor:pointer" wrap>
<fmt:message key="employee.list.label.designation"/>
<span id="upper(designation.name)"></span></td>
<td onclick="javascript:resort('upper(department.name)')" style="cursor:pointer" wrap>
<fmt:message key="employee.list.label.department"/>
<span id="upper(department.name)"></span></td>
</tr>
</thead>
<tbody>
<c:set var="hasRows" value="false" />
<c:forEach var="EmployeeList" items="${requestScope.EmployeeList}" varStatus="rowNumber">
<c:set var="hasRows" value="true" />
<tr>
<td><a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editEmployee('${EmployeeList.employeeId}');">
	<c:out value="${EmployeeList.firstName} ${EmployeeList.middleName} ${EmployeeList.lastName}"/></a>
</td>
<td><c:out value="${EmployeeList.designation.name}"/></td>
<td><c:out value="${EmployeeList.department.name}"/></td>
</tr>
</c:forEach>
<c:if test="${hasRows == false}">
<tr>
<td colspan=4  class="clsNoRecords" align="center">
<fmt:message key="list.label.norecords"/></td></tr></c:if>
</tbody>
<tfoot>
<tr>
<td colspan="4">
<c:if test="${requestScope.EmployeeList != null}">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</c:if>
</td>
</tr>
</tfoot>
</table>
<input type="hidden" id="employeeId" name="employeeId" value="<c:out value="${employee.employeeId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>