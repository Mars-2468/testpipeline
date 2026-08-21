<%@include file="/pages/common/include.jsp"%>
<script type="text/javascript">
function editUserRole(id)
{
	document.getElementById('userRoleId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/userrole/editUserRole.do');
}
</script><div id="PageTitleHeight"><table width="100%" cellpadding="0" cellspacing="0">
<tr>
<td>
<div class="ClsPageTitle">
List UserRole Details
</div>
</td>
<td align="right" style="padding-right:10px">
<a href="<c:out value="${contextRoot}"/>/userrole/editUserRole.do">
<b>Create UserRole</b>
</a>
</td>
</tr>
</table>
</div><div valign="top"  id="SetFormHeight"><table border="0" bordercolordark="white" cellpadding="0" cellspacing="0" width="98%">
<tr>
<td><fmt:message key="userRole.list.label.userRoleId"/></td>
<td onclick="javascript:resortDate('userRoleStDate')" style="cursor:pointer" wrap><fmt:message key="userRole.list.label.userRoleStDate"/><span id="to_date(userRoleStDate,'dd-mm-yyyy')"></span></td>
<td onclick="javascript:resortDate('userRoleEndDate')" style="cursor:pointer" wrap><fmt:message key="userRole.list.label.userRoleEndDate"/><span id="to_date(userRoleEndDate,'dd-mm-yyyy')"></span></td>
<td onclick="javascript:resort('isDefault')" style="cursor:pointer" wrap><fmt:message key="userRole.list.label.isDefault"/><span id="isDefault"></span></td>
<td onclick="javascript:resort('user')" style="cursor:pointer" wrap><fmt:message key="userRole.list.label.user"/><span id="user"></span></td>
<td onclick="javascript:resort('role')" style="cursor:pointer" wrap><fmt:message key="userRole.list.label.role"/><span id="role"></span></td>
</tr>
<c:forEach var="UserRoleList" items="${requestScope.UserRoleList}" varStatus="rowNumber">
<tr class="<c:out value="${rowStyle}"/>">
<td><a href="javascript:editUserRole('${UserRoleList.userRoleId}');"><c:out value="${UserRoleList.userRoleId}"/></a></td>
<td><c:out value="${UserRoleList.userRoleStDate}"/></td>
<td><c:out value="${UserRoleList.userRoleEndDate}"/></td>
<td><c:out value="${UserRoleList.isDefault}"/></td>
<td><c:out value="${UserRoleList.user}"/></td>
<td><c:out value="${UserRoleList.role}"/></td>
</tr>
</c:forEach>
<tr>
<td colspan="6">
<c:if test="${requestScope.UserRoleList != null}">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</c:if>
</td>
</tr>

</table>
<input type="hidden" id="userRoleId" name="userRoleId" value="<c:out value="${userRole.userRoleId}"/>" />

<input type="hidden" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('<c:out value="${contextRoot}"/>');
</script>
</div>