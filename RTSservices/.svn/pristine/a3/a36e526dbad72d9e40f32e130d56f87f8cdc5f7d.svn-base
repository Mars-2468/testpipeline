<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<script type="text/javascript">
function editWorkflowTemplateTask(id)
{
	document.getElementById('workflowTemplateTaskId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/workflowtemplatetask/editWorkflowTemplateTask.do');
}
</script>

<div class="mainHdr">
	<h3> <a href="<c:out value="${contextRoot}"/>/workflowtemplatetask/editWorkflowTemplateTask.do">
			<fmt:message key="workflowtemplatetask.manage.pagetitle.create"/>
		</a>
		<fmt:message key="workflowtemplatetask.list.pagetitle.list"/>
	</h3>
</div>

<div valign="top" class="ClsBlueGradientStrip" id="SetFormHeight">
<table class="dataGrid" cellpadding="0" cellspacing="1" width="98%">
<thead>
	<tr class="ClsTRHeaderList">
	<td onclick="javascript:resort('workflowTemplateTaskId')" style="cursor:pointer" >
	<fmt:message key="workflowTemplateTask.list.label.workflowTemplateTaskId"/>
	</td>
	<td onclick="javascript:resort('workflowTemplate.workflowTemplateName')" style="cursor:pointer" wrap>
	<fmt:message key="workflowTemplateTask.list.label.workflowTemplate"/>
	<span id="workflowTemplate.workflowTemplateName"></span></td>
	<td onclick="javascript:resort('level')" style="cursor:pointer" wrap>
	<fmt:message key="workflowTemplateTask.list.label.level"/>
	<span id="level"></span></td>
	<td onclick="javascript:resort('durationInDays')" style="cursor:pointer" wrap>
	<fmt:message key="workflowTemplateTask.list.label.durationInDays"/>
	<span id="durationInDays"></span></td>
	</tr>
</thead>
<tbody>
	<c:set var="hasRows" value="false" /><c:set var="rowStyle" value="" />
	<c:forEach var="WorkflowTemplateTaskList" items="${requestScope.WorkflowTemplateTaskList}" varStatus="rowNumber">
	<c:set var="rowStyle" value="ClsTRContentListWhite" />
	<c:set var="hasRows" value="true" />
	<c:if test="${ rowNumber.count % 2 == 0 }"><c:set var="rowStyle" value="ClsTRContentListGrey" /></c:if>
	<tr class="${rowStyle}">
	<td><a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editWorkflowTemplateTask('${WorkflowTemplateTaskList.workflowTemplateTaskId}');">
	<c:out value="${WorkflowTemplateTaskList.workflowTemplateTaskId}"/></a></td>
	<td><c:out value="${WorkflowTemplateTaskList.workflowTemplate.workflowTemplateName}"/></td>
	<td><c:out value="${WorkflowTemplateTaskList.level}"/></td>
	<td><c:out value="${WorkflowTemplateTaskList.durationInDays}"/></td>
	</tr>
	</c:forEach>
	<c:if test="${hasRows == false}">
	<tr class="${rowStyle}">
	<td colspan=4  class="clsNoRecords" align="center">
	<fmt:message key="list.label.norecords"/></td></tr></c:if>
</tbody>
<tfoot>	
	<tr class="ClsTRHeaderList">
	<td colspan="4">
	<c:if test="${requestScope.WorkflowTemplateTaskList != null}">
	<span><%@include file="/pages/common/pagination.jsp"%></span>
	</c:if>
	</td>
	</tr>
</tfoot>
</table>
<input type="hidden" id="workflowTemplateTaskId" name="workflowTemplateTaskId" value="<c:out value="${workflowTemplateTask.workflowTemplateTaskId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>