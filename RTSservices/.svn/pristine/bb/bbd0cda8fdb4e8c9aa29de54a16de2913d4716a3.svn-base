<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants"/>
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("ACTIVE_LABEL", Constants.ACTIVE_LABEL);
	pageContext.setAttribute("INACTIVE_LABEL", Constants.INACTIVE_LABEL);
	pageContext.setAttribute("ACTIVE", Constants.ACTIVE);
	pageContext.setAttribute("INACTIVE", Constants.INACTIVE);
	pageContext.setAttribute("WORKFLOW_DEPLOY_PROCESSES", WorkflowConstants.WORKFLOW_ACTION_DEPLOY_PROCESSES);
%>
<script type="text/javascript">
function editWorkflowTemplate(id)
{
	document.getElementById('workflowTemplateId').value=id;
	//document.getElementById('WORKFLOW_ACTION').value="";
	onPageSubmit('<c:out value="${contextRoot}"/>/workflowtemplate/editWorkflowTemplate.do');
}

function deployWorkFlowProcess()
{
	document.getElementById('WORKFLOW_ACTION').value='<c:out value="${pageScope.WORKFLOW_DEPLOY_PROCESSES}"/>';
	onPageSubmit('<c:out value="${contextRoot}"/>/workflowtemplate/listWorkflowTemplate.do');
}
</script>
<style type="text/css">
.btn-success {
    --bs-btn-color: #fff;
    --bs-btn-bg: #00a659;
    --bs-btn-border-color: #198754;
    --bs-btn-hover-color: #fff;
    --bs-btn-hover-bg: #168b54;	border: none;
	border-radius: 5px;
	min-height: 30px;
	min-width: 120px;
}

.btn-danger {
    --bs-btn-color: #fff;
    --bs-btn-bg: #e61f2c;
    --bs-btn-border-color: #df2d2d;
    --bs-btn-hover-color: #fff;
    --bs-btn-hover-bg: #ee1717;	border: none;
	border-radius: 5px;
	min-height: 30px;
	min-width: 120px;
}
.ClsTRHeaderList {
    background: #678dc5;
    font-weight: bold;
    color: white;
}

</style>
<div class="mainHdr">
	<h3>
 	<div class="status reverifyOn"	id="workflowssync" title="Re-deploy the Workflows"
				style="cursor:pointer;float: right" onclick="deployWorkFlowProcess()">
			</div> 
		<a href="<c:out value="${contextRoot}"/>/workflowtemplate/listWorkflowTemplate.do?WORKFLOW_ACTION=DEPLOY_PROCESSES">
			<div class="status reverifyOn"
				id="workflowssync"
				title="Re-deploy the Workflows"
				style="cursor:pointer;float: left">
			</div> 
		</a>  
	 <a href="<c:out value="${contextRoot}"/>/workflowtemplate/editWorkflowTemplate.do">
			<fmt:message key="workflowtemplate.manage.pagetitle.create"/>
		</a>  
		<fmt:message key="workflowtemplate.list.pagetitle.list"/>
	</h3>
</div>

<div valign="top" class="ClsBlueGradientStrip" id="SetFormHeight">

<table class="dataGrid boxshadow" cellpadding="0" cellspacing="1" width="98%">
<thead>
	<tr class="ClsTRHeaderList">
	<td onclick="javascript:resort('workflowTemplateName')" style="cursor:pointer;width:548px;"><fmt:message key="workflowTemplate.manage.label.templatename"/>
	<span id="workflowTemplateName"></span>
	</td>
	<td wrap>
	<fmt:message key="workflowTemplate.list.label.status"/>
	</td>
	</tr>
</thead>
<tbody>
	<c:set var="hasRows" value="false" /><c:set var="rowStyle" value="" />
	<c:forEach var="WorkflowTemplateList" items="${requestScope.WorkflowTemplateList}" varStatus="rowNumber">
	<c:set var="rowStyle" value="ClsTRContentListWhite" />
	<c:set var="hasRows" value="true" />
	<c:if test="${ rowNumber.count % 2 == 0 }"><c:set var="rowStyle" value="ClsTRContentListGrey" /></c:if>
	<tr class="${rowStyle}">
	<td><a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editWorkflowTemplate('${WorkflowTemplateList.workflowTemplateId}');">
	<c:out value="${WorkflowTemplateList.workflowTemplateName}"/></a></td>
	<td>
		<c:choose>
			<c:when test="${WorkflowTemplateList.status==pageScope.INACTIVE}">
			<c:out value="${pageScope.INACTIVE_LABEL}" />
			</c:when>
			<c:otherwise>
			<c:out value="${pageScope.ACTIVE_LABEL}" />
			</c:otherwise>
		</c:choose>
	</td>
	</tr>
	</c:forEach>

	<c:if test="${hasRows == false}">
	<tr class="${rowStyle}">
	<td colspan=2  class="clsNoRecords" align="center">
	<fmt:message key="list.label.norecords"/></td>
	</tr></c:if>
</tbody>
<tfoot>	
	<tr class="ClsTRHeaderList">
	<td colspan="2">
	<c:if test="${requestScope.WorkflowTemplateList != null}">
	<span><%@include file="/pages/common/pagination.jsp"%></span>
	</c:if>
	</td>
	</tr>
</tfoot>
</table>
<input type="hidden" id="workflowTemplateId" name="workflowTemplateId" value="<c:out value="${workflowTemplate.workflowTemplateId}"/>" />
<input type="hidden" id="WORKFLOW_ACTION" name="WORKFLOW_ACTION" value="" />
<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>