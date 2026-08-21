<%@include file="/pages/common/include.jsp"%>
<%@ page import="com.mars.common.utils.Constants"%>
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
%>
<div id="PageTitleHeight">
	<table cellpadding="0" cellspacing="0" width="98%">
		<tr>
			<td colspan="2">
				<div class="ClsPageTitle">
					<c:choose>
						<c:when test="${rolePermission.rolePermissionId==0}">
							<fmt:message key="rolePermission.manage.pagetitle.new" />
						</c:when>
						<c:otherwise>
							<fmt:message key="Edit RolePermission Details" />
						</c:otherwise>
					</c:choose>
				</div>
			</td>
		</tr>
	</table>
</div>
<div valign="top"  id="SetFormHeight">
	<table border="0" cellpadding="2" cellspacing="2">
		<tr>
			<td colspan="2">
				<spring:bind path="rolePermission.rolePermissionId">
					<input type="hidden" id="rolePermissionId" name="rolePermissionId" value="<c:out value="${rolePermission.rolePermissionId}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="rolePermission.manage.label.role" /> </span><span class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="rolePermission.role.roleId">
					<select name="roleId" id="roleId">
						<option value="-1">
							<--- Select role --->
						</option>
						<c:forEach var="role" items="${requestScope.roleList}">
							<c:choose>
								<c:when test="${rolePermission.role.roleId==role.roleId}">
									<option value="<c:out value="${role.roleId}"/>" selected="selected">
										<c:out value="${role.roleId}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="<c:out value="${role.roleId}"/>">
										<c:out value="${role.roleId}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="rolePermission.manage.label.permission" /> </span><span class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="rolePermission.permission.permissionId">
					<select name="permissionId" id="permissionId">
						<option value="-1">
							<--- Select permission --->
						</option>
						<c:forEach var="permission" items="${requestScope.permissionList}">
							<c:choose>
								<c:when test="${rolePermission.permission.permissionId==permission.permissionId}">
									<option value="<c:out value="${permission.permissionId}"/>" selected="selected">
										<c:out value="${permission.permissionId}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="<c:out value="${permission.permissionId}"/>">
										<c:out value="${permission.permissionId}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="padding-top:5px"></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveRolePermission(this.form);">
				<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
				<c:if test="${rolePermission.rolePermissionId!=0}">
					<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteRolePermission(this.form);">
				</c:if>
		</tr>
	</table>
</div>
<script type="text/javascript">
function saveRolePermission(frm)
{
	var arrElements=new Array('roleId','permissionId');
	if(checkMandatoryMsg(arrElements, "Please fill all the required fields which are marked with *"))
		{		navigate(frm,'<c:out value="${contextRoot}"/>/rolepermission/saveRolePermission.do');
		}
}
function deleteRolePermission(id)
{
	if(confirmDelete()){
		onPageSubmit('<c:out value="${contextRoot}"/>/rolepermission/deleteRolePermission.do');
	}
}
</script>
