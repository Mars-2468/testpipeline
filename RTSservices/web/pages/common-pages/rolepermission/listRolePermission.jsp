<%@include file="/pages/common/include.jsp"%>
<script type="text/javascript">
function editRolePermission(id)
{
	document.getElementById('rolePermissionId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/rolepermission/editRolePermission.do');
}
</script><div id="PageTitleHeight"><table width="100%" cellpadding="0" cellspacing="0">
<tr>
<td>
<div class="ClsPageTitle">
List RolePermission Details
</div>
</td>
<td align="right" style="padding-right:10px">
<a href="<c:out value="${contextRoot}"/>/rolepermission/editRolePermission.do">
<b>Create RolePermission</b>
</a>
</td>
</tr>
</table>
</div><div valign="top"  id="SetFormHeight"><table border="0" bordercolordark="white" cellpadding="0" cellspacing="0" width="98%">
<tr>
<td><fmt:message key="rolePermission.list.label.rolePermissionId"/></td>
<td onclick="javascript:resort('role')" style="cursor:pointer" wrap><fmt:message key="rolePermission.list.label.role"/><span id="role"></span></td>
<td onclick="javascript:resort('permission')" style="cursor:pointer" wrap><fmt:message key="rolePermission.list.label.permission"/><span id="permission"></span></td>
</tr>
<c:forEach var="RolePermissionList" items="${requestScope.RolePermissionList}" varStatus="rowNumber">
<tr class="<c:out value="${rowStyle}"/>">
<td><a href="javascript:editRolePermission('${RolePermissionList.rolePermissionId}');"><c:out value="${RolePermissionList.rolePermissionId}"/></a></td>
<td><c:out value="${RolePermissionList.role}"/></td>
<td><c:out value="${RolePermissionList.permission}"/></td>
</tr>
</c:forEach>
<tr>
<td colspan="3">
<c:if test="${requestScope.RolePermissionList != null}">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</c:if>
</td>
</tr>

</table>
<input type="hidden" id="rolePermissionId" name="rolePermissionId" value="<c:out value="${rolePermission.rolePermissionId}"/>" />

<input type="hidden" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('<c:out value="${contextRoot}"/>');
</script>
</div>