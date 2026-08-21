<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<script type="text/javascript">
function editWorkflowTemplateUserMappingDetails(id)
{
	document.getElementById('workflowTemplateUserMappingDetailsId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/workflowtemplateusermappingdetails/editWorkflowTemplateUserMappingDetails.do');
}
</script><div id="PageTitleHeight"><table width="100%" cellpadding="0" cellspacing="0">
<tr>
<td>
<div class="ClsPageTitle">
<fmt:message key="workflowtemplateusermappingdetails.list.pagetitle.list"/>
</div>
</td>
<td align="right" style="padding-right:10px">
<a href="<c:out value="${contextRoot}"/>/workflowtemplateusermappingdetails/editWorkflowTemplateUserMappingDetails.do">
<b><fmt:message key="workflowtemplateusermappingdetails.manage.pagetitle.new"/></b>
</a>
</td>
</tr>
</table>
</div><div valign="top" class="ClsBlueGradientStrip" id="SetFormHeight"><table cellpadding="0" cellspacing="1" width="98%">
<tr class="ClsTRHeaderList">
<td><fmt:message key="workflowTemplateUserMappingDetails.list.label.workflowTemplateUserMappingDetailsId"/></td>
<td onclick="javascript:resort('workflowTemplateUserMapping.workflowTemplateUserMappingId')" style="cursor:pointer" wrap>
<fmt:message key="workflowTemplateUserMappingDetails.list.label.workflowTemplateUserMapping"/>
<span id="workflowTemplateUserMapping"></span></td>
<td onclick="javascript:resort('workflowTemplateTask.workflowTemplateTaskId')" style="cursor:pointer" wrap>
<fmt:message key="workflowTemplateUserMappingDetails.list.label.workflowTemplateTask"/>
<span id="workflowTemplateTask"></span></td>
<td onclick="javascript:resort('employee.employeeId')" style="cursor:pointer" wrap>
<fmt:message key="workflowTemplateUserMappingDetails.list.label.employee"/>
<span id="employee"></span></td>
</tr>
<c:set var="hasRows" value="false" /><c:set var="rowStyle" value="" /><c:forEach var="WorkflowTemplateUserMappingDetailsList" items="${requestScope.WorkflowTemplateUserMappingDetailsList}" varStatus="rowNumber">
<c:set var="rowStyle" value="ClsTRContentListWhite" /><c:set var="hasRows" value="true" /><c:if test="${ rowNumber.count % 2 == 0 }"><c:set var="rowStyle" value="ClsTRContentListGrey" /></c:if><tr class="${rowStyle}">
<td><a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editWorkflowTemplateUserMappingDetails('${WorkflowTemplateUserMappingDetailsList.workflowTemplateUserMappingDetailsId}');"><c:out value="${WorkflowTemplateUserMappingDetailsList.workflowTemplateUserMappingDetailsId}"/></a></td>
<td><c:out value="${WorkflowTemplateUserMappingDetailsList.workflowTemplateUserMapping.workflowTemplateUserMappingId}"/></td>
<td><c:out value="${WorkflowTemplateUserMappingDetailsList.workflowTemplateTask.workflowTemplateTaskId}"/></td>
<td><c:out value="${WorkflowTemplateUserMappingDetailsList.employee.employeeId}"/></td>
</tr>
</c:forEach>
<c:if test="${hasRows == false}">
<tr class="${rowStyle}">
<td colspan=4  class="clsNoRecords" align="center">
<fmt:message key="list.label.norecords"/></td></tr></c:if><tr class="ClsTRHeaderList">
<td colspan="4">
<c:if test="${requestScope.WorkflowTemplateUserMappingDetailsList != null}">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</c:if>
</td>
</tr>
</table>
<input type="hidden" id="workflowTemplateUserMappingDetailsId" name="workflowTemplateUserMappingDetailsId" value="<c:out value="${workflowTemplateUserMappingDetails.workflowTemplateUserMappingDetailsId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>