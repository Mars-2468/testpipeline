<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);pageContext.setAttribute("BOOLEAN_TRUE_LABEL", Constants.BOOLEAN_TRUE_LABEL);pageContext.setAttribute("BOOLEAN_FALSE_LABEL", Constants.BOOLEAN_FALSE_LABEL);pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);%><div id="PageTitleHeight">
<table cellpadding="0" cellspacing="0" width="98%">
<tr>
<td colspan="2">
<div class="ClsPageTitle">
<c:choose><c:when test="${workflowTemplateUserMappingDetails.workflowTemplateUserMappingDetailsId==0}">
<fmt:message key="workflowTemplateUserMappingDetails.manage.pagetitle.new"/>
</c:when>
<c:otherwise>
<fmt:message key="workflowTemplateUserMappingDetails.manage.pagetitle.edit"/>
</c:otherwise>
</c:choose>
</div>
</td>
</tr>
</table>
</div>
<div valign="top" class="ClsBlueGradientStrip" id="SetFormHeight"><table border="0" cellpadding="2" cellspacing="2">
<tr>
<td colspan="2">
<spring:bind path="workflowTemplateUserMappingDetails.workflowTemplateUserMappingDetailsId">
<input type="hidden" id="workflowTemplateUserMappingDetailsId" name="workflowTemplateUserMappingDetailsId" value="<c:out value="${workflowTemplateUserMappingDetails.workflowTemplateUserMappingDetailsId}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="workflowTemplateUserMappingDetails.manage.label.workflowTemplateUserMapping"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="workflowTemplateUserMappingDetails.workflowTemplateUserMapping.workflowTemplateUserMappingId">
<select name="workflowTemplateUserMappingId" id="workflowTemplateUserMappingId">
<option value=""> <--- Select workflowTemplateUserMapping ---> </option>
<c:forEach var="workflowTemplateUserMapping" items="${requestScope.workflowTemplateUserMappingList}">
<c:choose>
<c:when test="${workflowTemplateUserMappingDetails.workflowTemplateUserMapping.workflowTemplateUserMappingId==workflowTemplateUserMapping.workflowTemplateUserMappingId}">
<option value="${workflowTemplateUserMapping.workflowTemplateUserMappingId}" selected="selected">
<c:out value="${workflowTemplateUserMapping.workflowTemplateUserMappingId}"/>
</option>
</c:when>
<c:otherwise>
<option value="${workflowTemplateUserMapping.workflowTemplateUserMappingId}">
<c:out value="${workflowTemplateUserMapping.workflowTemplateUserMappingId}"/>
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
<span class="ClsLabel"><fmt:message key="workflowTemplateUserMappingDetails.manage.label.workflowTemplateTask"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="workflowTemplateUserMappingDetails.workflowTemplateTask.workflowTemplateTaskId">
<select name="workflowTemplateTaskId" id="workflowTemplateTaskId">
<option value=""> <--- Select workflowTemplateTask ---> </option>
<c:forEach var="workflowTemplateTask" items="${requestScope.workflowTemplateTaskList}">
<c:choose>
<c:when test="${workflowTemplateUserMappingDetails.workflowTemplateTask.workflowTemplateTaskId==workflowTemplateTask.workflowTemplateTaskId}">
<option value="${workflowTemplateTask.workflowTemplateTaskId}" selected="selected">
<c:out value="${workflowTemplateTask.workflowTemplateTaskId}"/>
</option>
</c:when>
<c:otherwise>
<option value="${workflowTemplateTask.workflowTemplateTaskId}">
<c:out value="${workflowTemplateTask.workflowTemplateTaskId}"/>
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
<span class="ClsLabel"><fmt:message key="workflowTemplateUserMappingDetails.manage.label.employee"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="workflowTemplateUserMappingDetails.employee.employeeId">
<select name="employeeId" id="employeeId">
<option value=""> <--- Select employee ---> </option>
<c:forEach var="employee" items="${requestScope.employeeList}">
<c:choose>
<c:when test="${workflowTemplateUserMappingDetails.employee.employeeId==employee.employeeId}">
<option value="${employee.employeeId}" selected="selected">
<c:out value="${employee.employeeId}"/>
</option>
</c:when>
<c:otherwise>
<option value="${employee.employeeId}">
<c:out value="${employee.employeeId}"/>
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
<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveWorkflowTemplateUserMappingDetails(this.form);">
<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
<c:if test="${workflowTemplateUserMappingDetails.workflowTemplateUserMappingDetailsId!=0}">
<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteWorkflowTemplateUserMappingDetails(this.form);">
</c:if>
</tr>
</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/><script type="text/javascript">
function saveWorkflowTemplateUserMappingDetails(frm)
{
	var arrRequiredElements=new Array('workflowTemplateUserMappingId','workflowTemplateTaskId','employeeId');
	var arrRequiredElementsMessages=new Array('<fmt:message key="workflowTemplateUserMappingDetails.manage.label.workflowTemplateUserMapping"/>','<fmt:message key="workflowTemplateUserMappingDetails.manage.label.workflowTemplateTask"/>','<fmt:message key="workflowTemplateUserMappingDetails.manage.label.employee"/>');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
		{		navigate(frm,'<c:out value="${contextRoot}"/>/workflowtemplateusermappingdetails/saveWorkflowTemplateUserMappingDetails.do');
		}
}
</script><script type="text/javascript">
function deleteWorkflowTemplateUserMappingDetails(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/workflowtemplateusermappingdetails/deleteWorkflowTemplateUserMappingDetails.do');
}
}
</script>