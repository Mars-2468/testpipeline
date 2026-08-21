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
						<c:when test="${userRole.userRoleId==0}">
							<fmt:message key="userRole.manage.pagetitle.new" />
						</c:when>
						<c:otherwise>
							<fmt:message key="Edit UserRole Details" />
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
			<td colspan="2" >
				<spring:bind path="userRole.userRoleId">
					<input type="hidden" id="userRoleId" name="userRoleId" value="<c:out value="${userRole.userRoleId}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="userRole.manage.label.userRoleStDate" />
				</span>
			</td>
			<td>
				<!-- ====Display Calendar ==== -->
				<spring:bind path="userRole.userRoleStDate">
					<input type="text" class="ClsTextbox" id="userRoleStDate" maxlength="10" name="userRoleStDate" value="<c:out value="${userRole.userRoleStDate}"/>" />
				</spring:bind>
				<span onclick="javascript:showCalendarControl('userRoleStDate',event);" style="cursor:pointer"> <img src="<c:out value="${contextRoot}"/>/images/Ico_Calendar.gif" width="16" height="16" />
				</span>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="userRole.manage.label.userRoleEndDate" />
				</span>
			</td>
			<td>
				<!-- ====Display Calendar ==== -->
				<spring:bind path="userRole.userRoleEndDate">
					<input type="text" class="ClsTextbox" id="userRoleEndDate" maxlength="10" name="userRoleEndDate" value="<c:out value="${userRole.userRoleEndDate}"/>" />
				</spring:bind>
				<span onclick="javascript:showCalendarControl('userRoleEndDate',event);" style="cursor:pointer"> <img src="<c:out value="${contextRoot}"/>/images/Ico_Calendar.gif" width="16" height="16" />
				</span>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="userRole.manage.label.isDefault" />
				</span>
			</td>
			<td>
				<spring:bind path="userRole.isDefault">
					<input type="text" class="ClsTextbox" id="isDefault" maxlength="5" name="isDefault" value="<c:out value="${userRole.isDefault}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="userRole.manage.label.user" />
				</span><span class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="userRole.user.userId">
					<select name="userId" id="userId">
						<option value="-1">
							<--- Select user --->
						</option>
						<c:forEach var="user" items="${requestScope.userList}">
							<c:choose>
								<c:when test="${userRole.user.userId==user.userId}">
									<option value="<c:out value="${user.userId}"/>" selected="selected">
										<c:out value="${user.userId}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="<c:out value="${user.userId}"/>">
										<c:out value="${user.userId}" />
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
				<span class="ClsLabel"><fmt:message key="userRole.manage.label.role" />
				</span><span class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="userRole.role.roleId">
					<select name="roleId" id="roleId">
						<option value="-1">
							<--- Select role --->
						</option>
						<c:forEach var="role" items="${requestScope.roleList}">
							<c:choose>
								<c:when test="${userRole.role.roleId==role.roleId}">
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
			<td colspan="2" style="padding-top:5px"></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveUserRole(this.form);">
				<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
				<c:if test="${userRole.userRoleId!=0}">
					<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteUserRole(this.form);">
				</c:if>
		</tr>
	</table>
</div>
<script type="text/javascript">
function saveUserRole(frm)
{
	var arrElements=new Array('userId','roleId');
	if(checkMandatoryMsg(arrElements, "Please fill all the required fields which are marked with *"))
		{		navigate(frm,'<c:out value="${contextRoot}"/>/userrole/saveUserRole.do');
		}
}
</script>
<script type="text/javascript">
function deleteUserRole(id)
{
	if(confirmDelete()){
		onPageSubmit('<c:out value="${contextRoot}"/>/userrole/deleteUserRole.do');
	}
}
</script>
