<jsp:directive.include file="/pages/common/include.jsp" />
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("DATE_TIME_FORMAT", WorkflowConstants.WORKFLOW_DATE_FORMAT);
	pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
%>

<div class="mainHdr">
	<h3>
		<fmt:message key="reassignworkflow.manage.pagetitle"/>
	</h3>
</div>

<div valign="top" id="SetFormHeight" class="boxshadowBorder">
	<table border="0" cellpadding="2" cellspacing="2" width="100%" class="dataForm">
		<tr>
			<td>
				<span class="ClsLabel"><span class="ClsRequiredFields">*</span><fmt:message key="reassignworkflow.manage.label.user" /></span>
			</td>
			<td>
				<select class="ClsSelect" id="frmUserName" name="frmUserName" style="width: 400px">
					<option value=""><--- Select ---></option>
					<c:forEach var="user" items="${requestScope.userList}">
						<option value="<c:out value="${user.userName}"/>" 
							<c:if test="${user.userName eq requestScope.frmUserName}"> selected </c:if>>
							<c:out value="${user.firstName} ${user.lastName}" />
						</option>
					</c:forEach>
				</select>
			</td>
 			<c:if test="${not empty requestScope.personalTasksList}">
				<td>
					<span class="ClsLabel"><span class="ClsRequiredFields">*</span><fmt:message key="reassignworkflow.manage.label.toUser" /></span>
				</td>
				<td>
					<select class="ClsSelect" id="toUserName" name="toUserName" style="width:400px">
						<option value=""><--- Select ---></option>
						<c:forEach var="user" items="${requestScope.userList}">
							<option value="<c:out value="${user.userName}"/>" 
								<c:if test="${user.userName eq requestScope.toUserName}"> selected </c:if>>
								<c:out value="${user.firstName} ${user.lastName}" />
							</option>
						</c:forEach>
					</select>
				</td>
			</c:if>
 		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="button" class="ClsButton" id="getList" name="getList" value="Get Assigned Tasks" onclick="javascript:getAssignedTasks(this.form);">
			</td>
		</tr>
		<c:if test="${not empty requestScope.personalTasksList}">
			<tr>
				<td colspan="4">
					<table cellpadding="0" cellspacing="0" border="1" width="98%" class="dataGrid">
						<thead>
							<tr>
								<td width="2%">
									<input type="checkbox" class="parent" id="checkAll" name="checkAll" value="" onclick="ToggleAll(this,'taskId');"/>
								</td>
								<td width="15%"><span class="ClsLabel"><fmt:message key="reassignworkflow.manage.label.entityDetails" /></span></td>
								<td width="15%"><span class="ClsLabel"><fmt:message key="reassignworkflow.manage.label.entityName" /></span></td>
								<td width="15%"><span class="ClsLabel"><fmt:message key="reassignworkflow.manage.label.taskName" /></span></td>																					
								<td width="21%"><span class="ClsLabel"><fmt:message key="reassignworkflow.manage.label.startDate" /></span></td>			
								<td width="19%"><span class="ClsLabel"><fmt:message key="reassignworkflow.manage.label.desc" /></span></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="personalTask" items="${requestScope.personalTasksList}" varStatus="rowNumber">
								<tr>
									<td>
										<input type="checkbox" class="childs" id="taskId" name="taskId" value="<c:out value="${personalTask.task.id}"/>" 
										onclick="Toggle(this,'checkAll');"/>
									</td>
									<td><c:out value="${personalTask.entityDetails}" /></td>
									<td><c:out value="${personalTask.entityName}" /></td>
									<td><c:out value="${personalTask.task.name}" /></td>														
									<td nowrap="nowrap">
										<fmt:formatDate var="fmtPersonalTaskStartDate"
											value="${personalTask.task.createTime}" type="both"
											dateStyle="full" timeStyle="short"
											pattern="${pageScope.DATE_TIME_FORMAT}" />
										<c:out value="${fmtPersonalTaskStartDate}" />
									</td>									
									<td>
										<c:out value="${personalTask.task.description}" />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</td>
			</tr>			
			<tr>
				<td colspan="4" align="center">
					<input type="button" class="ClsButton" id="assignTasks" name="assignTasks" value="Assign Tasks" onclick="javascript:reassignWorkflowTask(this.form);">
					<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
				</td>
			</tr>
		</c:if>
	</table>
	<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/>
	<input type="hidden" id="selectedTaskIds" name="selectedTaskIds" value="" />
</div>

<script type="text/javascript">

function reassignWorkflowTask(frm)
{
	document.getElementById("selectedTaskIds").value = getSelectedValue("taskId");
	navigate(frm,'<c:out value="${contextRoot}"/>/reassignworkflow/reassignWorkflowTask.do');
}
function getAssignedTasks(frm)
{	
	var arrRequiredElements=new Array('frmUserName');
	var arrRequiredElementsMessages=new Array('<fmt:message key="reassignworkflow.manage.label.user" />');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages)){
	navigate(frm,'<c:out value="${contextRoot}"/>/reassignworkflow/listUserTasks.do');
	}
}


</script>