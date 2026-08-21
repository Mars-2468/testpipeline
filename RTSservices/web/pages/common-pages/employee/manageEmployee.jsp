<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);%>
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${employee.employeeId==0}"><fmt:message key="employee.manage.pagetitle.new" /></c:when>
			<c:otherwise><fmt:message key="employee.manage.pagetitle.edit" /></c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top"  id="SetFormHeight"><table border="0" cellpadding="2" cellspacing="2" class="dataForm">
<tr>
<td colspan="2">
<spring:bind path="employee.employeeId">
<input type="hidden" id="employeeId" name="employeeId" value="<c:out value="${employee.employeeId}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="employee.manage.label.firstName"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="employee.firstName">
<input type="text" class="ClsTextbox" id="firstName" style="width: 220px" maxlength="25" name="firstName" value="<c:out value="${employee.firstName}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="employee.manage.label.middleName"/></span></td>
<td>
<spring:bind path="employee.middleName">
<input type="text" class="ClsTextbox" id="middleName" style="width: 220px" maxlength="25" name="middleName" value="<c:out value="${employee.middleName}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="employee.manage.label.lastName"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="employee.lastName">
<input type="text" class="ClsTextbox" id="lastName"  style="width: 220px" maxlength="25" name="lastName" value="<c:out value="${employee.lastName}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel">E-Mail</span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="employee.email">
<input style="width: 220px" type="text" class="ClsTextbox" id="email" maxlength="50" name="email" value="<c:out value="${employee.email}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<!--<td><span class="ClsLabel"><fmt:message key="employee.manage.label.status"/></span></td>-->
<td>
<spring:bind path="employee.status">
<input type="hidden" class="ClsTextbox" id="status" maxlength="255" name="status" value="<c:out value="${employee.status}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="employee.manage.label.designation"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="employee.designation.designationId">
<select name="designationId" id="designationId" class="ClsTextbox">
<option value=""> <--- Select ---> </option>
<c:forEach var="designation" items="${requestScope.designationList}">
<c:choose>
<c:when test="${employee.designation.designationId==designation.designationId}">
<option value="${designation.designationId}" selected="selected">
<c:out value="${designation.name}"/>
</option>
</c:when>
<c:otherwise>
<option value="${designation.designationId}">
<c:out value="${designation.name}"/>
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
<span class="ClsLabel"><fmt:message key="employee.manage.label.department"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="employee.department.departmentId">
<select name="departmentId" id="departmentId" class="ClsTextbox">
<option value=""> <--- Select ---> </option>
<c:forEach var="department" items="${requestScope.departmentList}">
<c:choose>
<c:when test="${employee.department.departmentId==department.departmentId}">
<option value="${department.departmentId}" selected="selected">
<c:out value="${department.name}"/>
</option>
</c:when>
<c:otherwise>
<option value="${department.departmentId}">
<c:out value="${department.name}"/>
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
<span class="ClsLabel"><fmt:message key="employee.manage.label.superior"/></span></td>
<td>
<select name="superiorId" id="superiorId" class="ClsTextbox">
<option value=""> <--- Select ---> </option>
<c:forEach var="superior" items="${requestScope.employeeList}">
<c:choose>
<c:when test="${employee.superior.employeeId==superior.employeeId}">
<option value="${superior.employeeId}" selected="selected">
<c:out value="${superior.firstName} ${superior.middleName} ${superior.lastName}"/>
</option>
</c:when>
<c:otherwise>
<option value="${superior.employeeId}">
<c:out value="${superior.firstName} ${superior.middleName} ${superior.lastName}"/>
</option>
</c:otherwise>
</c:choose>
</c:forEach>
</select>
</td>
</tr>
<tr><td  colspan="2" style="padding-top:5px"></td></tr>
<tr><td></td>
<td>
<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveEmployee(this.form);">
<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
<c:if test="${employee.employeeId!=0}">
<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteEmployee(this.form);">
</c:if>
</tr>
</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/><script type="text/javascript">
function saveEmployee(frm)
{
	var arrRequiredElements=new Array('firstName','lastName','designationId','departmentId','email');
	var arrRequiredElementsMessages=new Array('<fmt:message key="employee.manage.label.firstName"/>','<fmt:message key="employee.manage.label.lastName"/>','<fmt:message key="employee.manage.label.designation"/>','<fmt:message key="employee.manage.label.department"/>','E-Mail');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
		{	
			var arrAlphaElements=new Array('firstName','middleName','lastName');
			var arrAlphaElementsMessages=new Array('<fmt:message key="employee.manage.label.firstName"/>','<fmt:message key="employee.manage.label.middleName"/>','<fmt:message key="employee.manage.label.lastName"/>');
			if(isAlphaAray(arrAlphaElements,arrAlphaElementsMessages))
			{	
				if(isValidEmail(document.getElementById('email').value,"E-Mail")) 
				{	
					navigate(frm,'<c:out value="${contextRoot}"/>/employee/saveEmployee.do');
				}
			}
		}
}
</script><script type="text/javascript">
function deleteEmployee(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/employee/deleteEmployee.do');
}
}
</script>