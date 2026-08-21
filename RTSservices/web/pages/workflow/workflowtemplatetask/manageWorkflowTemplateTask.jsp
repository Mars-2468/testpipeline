<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants"/>
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("BOOLEAN_TRUE_LABEL", Constants.BOOLEAN_TRUE_LABEL);
	pageContext.setAttribute("BOOLEAN_FALSE_LABEL", Constants.BOOLEAN_FALSE_LABEL);
	pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);
%>

<div class="mainHdr">
	<h3>
		<c:choose>
			<c:when test="${workflowTemplateTask.workflowTemplateTaskId==0}">
			<fmt:message key="workflowTemplateTask.manage.pagetitle.new"/></c:when>
			<c:otherwise><fmt:message key="workflowTemplateTask.manage.pagetitle.edit"/></c:otherwise>
		</c:choose>
	</h3>
</div>

<div valign="top" id="SetFormHeight">
<table border="0" cellpadding="2" cellspacing="2" class="dataForm">
<tr>
<td colspan="2">
<spring:bind path="workflowTemplateTask.workflowTemplateTaskId">
<input type="hidden" id="workflowTemplateTaskId" name="workflowTemplateTaskId" value="<c:out value="${workflowTemplateTask.workflowTemplateTaskId}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="workflowTemplateTask.manage.label.workflowTemplate"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="workflowTemplateTask.workflowTemplate.workflowTemplateId">
<select name="workflowTemplateId" id="workflowTemplateId">
<option value=""> <--- Select workflowTemplate ---> </option>
<c:forEach var="workflowTemplate" items="${requestScope.workflowTemplateList}">
<c:choose>
<c:when test="${workflowTemplateTask.workflowTemplate.workflowTemplateId==workflowTemplate.workflowTemplateId}">
<option value="${workflowTemplate.workflowTemplateId}" selected="selected">
<c:out value="${workflowTemplate.workflowTemplateName}"/>
</option>
</c:when>
<c:otherwise>
<option value="${workflowTemplate.workflowTemplateId}">
<c:out value="${workflowTemplate.workflowTemplateName}"/>
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
<span class="ClsLabel"><fmt:message key="workflowTemplateTask.manage.label.assigneePlaceHolder"/></span></td>
<td>
<spring:bind path="workflowTemplateTask.assigneePlaceHolder">
<input type="text" class="ClsTextbox" id="assigneePlaceHolder" maxlength="50" name="assigneePlaceHolder" value="<c:out value="${workflowTemplateTask.assigneePlaceHolder}"/>" />
</spring:bind>
</td>
</tr>

<tr>
<td>
<span class="ClsLabel"><fmt:message key="workflowTemplateTask.manage.label.level"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="workflowTemplateTask.level">
<input type="text" class="ClsTextbox" id="level" maxlength="2" name="level" value="<c:out value="${workflowTemplateTask.level}"/>" />
</spring:bind>
</td>
</tr>

<tr>
<td>
<span class="ClsLabel"><fmt:message key="workflowTemplateTask.manage.label.durationInDays"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="workflowTemplateTask.durationInDays">
<input type="text" class="ClsTextbox" id="durationInDays" maxlength="2" name="durationInDays" value="<c:out value="${workflowTemplateTask.durationInDays}"/>" />
</spring:bind>
</td>
</tr>


<tr>
<td>
<span class="ClsLabel"><fmt:message key="workflowTemplateTask.manage.label.defaultEmployee"/></span></td>
<td>
<spring:bind path="workflowTemplateTask.defaultEmployee.employeeId">
<select name="defaultEmployeeId" id="defaultEmployeeId">
<option value=""> <--- Select defaultEmployee ---> </option>
<c:forEach var="defaultEmployee" items="${requestScope.employeeList}">
<c:choose>
<c:when test="${workflowTemplateTask.defaultEmployee.employeeId==defaultEmployee.employeeId}">
<option value="${defaultEmployee.employeeId}" selected="selected">
<c:out value="${defaultEmployee.firstName}" /> <c:out value="${defaultEmployee.lastName}" /> 
</option>
</c:when>
<c:otherwise>
<option value="${defaultEmployee.employeeId}">
<c:out value="${defaultEmployee.firstName}" /> <c:out value="${defaultEmployee.lastName}" />
</option>
</c:otherwise>
</c:choose>
</c:forEach>
</select>
</spring:bind>
</td>
</tr>
<tr><td  colspan="2" style="padding-top:5px"></td></tr>
<tr><td></td>
<td>
<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveWorkflowTemplateTask(this.form);">
<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
<c:if test="${workflowTemplateTask.workflowTemplateTaskId!=0}">
<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteWorkflowTemplateTask(this.form);">
</c:if>
</tr>
</table>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/>
</div>
<script type="text/javascript">
function saveWorkflowTemplateTask(frm)
{
	var arrRequiredElements=new Array('durationInDays','level','workflowTemplateId');
	var arrRequiredElementsMessages=new Array('<fmt:message key="workflowTemplateTask.manage.label.durationInDays"/>','<fmt:message key="workflowTemplateTask.manage.label.level"/>','<fmt:message key="workflowTemplateTask.manage.label.workflowTemplate"/>');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
		{	var arrLongElements=new Array('durationInDays','level');
	var arrLongElementsMessages=new Array('<fmt:message key="workflowTemplateTask.manage.label.durationInDays"/>','<fmt:message key="workflowTemplateTask.manage.label.level"/>');
	if(isLongArray(arrLongElements,arrLongElementsMessages))
		{		navigate(frm,'<c:out value="${contextRoot}"/>/workflowtemplatetask/saveWorkflowTemplateTask.do');
		}
		}
}
</script><script type="text/javascript">
function deleteWorkflowTemplateTask(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/workflowtemplatetask/deleteWorkflowTemplateTask.do');
}
}
</script>