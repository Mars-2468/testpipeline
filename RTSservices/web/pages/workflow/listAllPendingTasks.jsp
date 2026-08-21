<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("DATE_TIME_DB_FORMAT", Constants.DATE_TIME_DB_FORMAT);

	pageContext.setAttribute("DATE_TIME_FORMAT", WorkflowConstants.WORKFLOW_DATE_FORMAT);
	pageContext.setAttribute("WORKFLOW_ACTION", WorkflowConstants.WORKFLOW_ACTION);
	pageContext.setAttribute("TAKE_TASK", WorkflowConstants.WORKFLOW_ACTION_TAKE_TASK);
	pageContext.setAttribute("BACK_TO_GROUP", WorkflowConstants.WORKFLOW_ACTION_BACK_TO_GROUP);

	pageContext.setAttribute("WORKFLOW_JOB_ID", WorkflowConstants.WORKFLOW_JOB_ID);
	pageContext.setAttribute("WORKFLOW_TASK_ID", WorkflowConstants.WORKFLOW_TASK_ID);
	pageContext.setAttribute("WORKFLOW_ENTITYNAME", WorkflowConstants.WORKFLOW_ENTITYNAME);
	pageContext.setAttribute("WORKFLOW_ENTITYID", WorkflowConstants.WORKFLOW_ENTITYID);

	pageContext.setAttribute("WORKFLOW_PRIORITY_LOW", WorkflowConstants.WORKFLOW_PRIORITY_LOW);
	pageContext.setAttribute("WORKFLOW_PRIORITY_MEDIUM", WorkflowConstants.WORKFLOW_PRIORITY_MEDIUM);
	pageContext.setAttribute("WORKFLOW_PRIORITY_HIGH", WorkflowConstants.WORKFLOW_PRIORITY_HIGH);
%>

<script type="text/javascript">
/* function getPendingTasks()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/workflow/listTasks.do');
}

function getCompletedTasks()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/workflow/listCompletedTasks.do');
}

function getGroupTasks()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/workflow/listGroupTasks.do');
}

function takeTask(taskId)
{
	document.getElementById('${pageScope.WORKFLOW_TASK_ID}').value=taskId;
	onPageSubmit('<c:out value="${contextRoot}"/>/workflow/saveTaskOwnership.do');
} */
</script>

<div class="mainHdr">
	<h3>
		<%-- <c:out value="${pageHeading}" /></h3> --%>
		Pending Task List More Than 48 Hours
		<span style="float: right;" ><a href="prinListAllPendingTaskTasks.do" target="_blank" style="font-size: 11px" >print</a></span></h3> 
		
</div>

<div valign="top" id="SetFormHeight">
<div id="tabs">
  <ul>
	<li>
		<!-- <a linkindex="1" href="#tabs-1" onclick="Javascript:getPendingTasks();">Pending Tasks</a> -->
		<a linkindex="1" href="#tabs-1">Pending Tasks</a>
		
	</li>
	<!-- <li>
		<a linkindex="2" href="#tabs-2" onclick="Javascript:getCompletedTasks();">Completed Tasks</a>
	</li> -->
	
   </ul>

   <div id="tabs-1">
	<c:if test="${not empty displaymode and displaymode eq 'inbox' }">
		<table cellpadding="0" cellspacing="0" border="1" width="98%"
			class="dataGrid">
			<thead>
				<tr>
					<td width="2%">
						
					</td>					
					<td width="15%">
						Task Name
					</td>
					<td width="19%">
						Pending At
					</td>
					<td width="15%">
						Entity Name
					</td>
					<td width="15%">
						Entity Details
					</td>					
					<td width="21%">
						Start Date
					</td>

				 <!-- <td width="15%">
						Due Date
					</td> --> 
					<td width="6%">
						Pending (In Hours)
					</td>
					<td width="19%">
						Description
					</td>					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="personalTasksList"
					items="${requestScope.PersonalTasksList}" varStatus="rowNumber">
					<tr>
						<td align="center">
							<c:choose>
								<c:when
									test="${pageScope.WORKFLOW_PRIORITY_LOW eq personalTasksList.task.priority}">
									<img
										src="<c:out value="${contextRoot}"/>/images/orangeflag.gif"
										alt="Low Priority" title="Low Priority" />
								</c:when>
								<c:when
									test="${pageScope.WORKFLOW_PRIORITY_HIGH eq personalTasksList.task.priority}">
									<img src="<c:out value="${contextRoot}"/>/images/redflag.gif"
										alt="High Priority" title="High Priority" />
								</c:when>
								<c:otherwise>
									<img src="<c:out value="${contextRoot}"/>/images/greenflag.gif"
										alt="Medium Priority" title="Medium Priority"/>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<a href="javascript:void(0)"
								onclick="javascript:openPage('${personalTasksList.task.id}','${personalTasksList.task.executionId}',${personalTasksList.entityId},'${personalTasksList.entityName}' )"><c:out
									value="${personalTasksList.task.name}" /> </a>
						</td>
						<td>
							<c:out value="${personalTasksList.task.assignee}" />
						</td>
						<td>
							<c:out value="${personalTasksList.entityName}" />
						</td>
						<td>
							<c:out value="${personalTasksList.entityDetails}" />
						</td>						
						<td nowrap="nowrap">
							<fmt:formatDate var="fmtPersonalTaskStartDate"
								value="${personalTasksList.task.createTime}" type="both"
								dateStyle="full" timeStyle="short"
								pattern="${pageScope.DATE_TIME_FORMAT}" />
							<c:out value="${fmtPersonalTaskStartDate}" />
						</td>
					 	<%-- <td>
							<fmt:formatDate var="fmtPersonalDuetDate"
								value="${personalTasksList.task.duedate}" type="both"
								dateStyle="full" timeStyle="short"
								pattern="${pageScope.DATE_FORMAT}" />
							<c:out value="${fmtPersonalDuetDate}" />
						</td>  --%>
						
						 <td>
							<fmt:formatDate var="fmtPersonalPendingSince"
								value="${personalTasksList.task.createTime}" 
								pattern="${pageScope.DATE_TIME_DB_FORMAT}" />
							
							<%
							 String personalPending=(String)pageContext.getAttribute("fmtPersonalPendingSince");							
							 long pendingHrs=0;                           
							 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
							 if((personalPending!=null || personalPending=="")){
								 java.util.Date sd= formatter.parse(personalPending);								 
								 pendingHrs= (new java.util.Date().getTime()-sd.getTime())/(60 * 60 * 1000);	 
							 }
					 		%>							
							<%=pendingHrs%>	
						</td>
						
						<td>
							<c:out value="${personalTasksList.task.description}" />
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="8">
						<c:if test="${requestScope.PersonalTasksList != null }">
							<span><%@include file="/pages/common/pagination.jsp"%></span>
						</c:if>
					</td>
				</tr>
			</tfoot>
		</table>
	</c:if>
	</div>	
						
<script type="text/javascript">
	function openPage(taskId, workflowJobId, entityId, entityName)
	{		
			var url = "";
			var entityur="";
			if(entityName!='')
			{
				var hiddenFieldId = "";

				/* if(entityName.match("TradeAndStorage_Registration")){
					url = "<c:out value="${contextRoot}"/>/tradeandstorage/editTradeAndStorage.do";
					hiddenFieldId = "tradeAndStorageId";	
				}
				if(entityName.match("Industry_Registration")){
					url = "<c:out value="${contextRoot}"/>/industry/editIndustry.do";
					hiddenFieldId = "industryId";	
				}
				if(entityName.match("SignBoard_Registration")){
					url = "<c:out value="${contextRoot}"/>/signboard/editSignBoard.do";
					hiddenFieldId = "signBoardId";	
				}
				if(entityName.match("MuttonShop_Registration")){
					url = "<c:out value="${contextRoot}"/>/muttonshop/editMuttonShop.do";
					hiddenFieldId = "muttonShopId";	
				}
				if(entityName.match("Hospital_Registration")){
					url = "<c:out value="${contextRoot}"/>/hospital/editHospital.do";
					hiddenFieldId = "hospitalId";	
				}
				if(entityName.match("Clinic_Registration")){
					url = "<c:out value="${contextRoot}"/>/clinic/editClinic.do";
					hiddenFieldId = "clinicId";	
				}
				if(entityName.match("LicenseCancel_Registration")){
					url = "<c:out value="${contextRoot}"/>/licensecancel/editLicenseCancel.do";
					hiddenFieldId = "applicationDetailsId";	
				}
				if(entityName.match("LicenseTransfer_Registration")){
					url = "<c:out value="${contextRoot}"/>/licensetransfer/editLicenseTransfer.do";
					hiddenFieldId = "applicationDetailsId";	
				}
				if(entityName.match("BusinessName_Registration")){
					url = "<c:out value="${contextRoot}"/>/businessname/editBusinessName.do";
					hiddenFieldId = "applicationDetailsId";	
				}
				if(entityName.match("RenewLicense_Registration")){
					url = "<c:out value="${contextRoot}"/>/renewlicense/editRenewLicense.do";
					hiddenFieldId = "applicationDetailsId";	
				}
				if(entityName.match("DuplicateLicense_Registration")){
					url = "<c:out value="${contextRoot}"/>/duplicatelicense/editDuplicateLicense.do";
					hiddenFieldId = "applicationDetailsId";	
				}
				var field = document.createElement("input");
				field.setAttribute("type","hidden");
				field.setAttribute("id",hiddenFieldId);
				field.setAttribute("name",hiddenFieldId);
				field.setAttribute("value",entityId);
				document.getElementById('SetFormHeight').appendChild(field);

				document.getElementById('${pageScope.WORKFLOW_JOB_ID}').value=workflowJobId;
				document.getElementById('${pageScope.WORKFLOW_TASK_ID}').value=taskId;
				document.getElementById('${pageScope.WORKFLOW_ENTITYID}').value=entityId;
				document.getElementById('${pageScope.WORKFLOW_ENTITYNAME}').value=entityName;
				onPageSubmit(url); */
			}
		}
		
	</script>

	<input type="hidden"
		name="<c:out value="${pageScope.WORKFLOW_ENTITYNAME}"/>"
		id="<c:out value="${pageScope.WORKFLOW_ENTITYNAME}"/>" />

	<input type="hidden"
		name="<c:out value="${pageScope.WORKFLOW_ENTITYID}"/>"
		id="<c:out value="${pageScope.WORKFLOW_ENTITYID}"/>" />

	<input type="hidden"
		name="<c:out value="${pageScope.WORKFLOW_JOB_ID}"/>"
		id="<c:out value="${pageScope.WORKFLOW_JOB_ID}"/>" />

	<input type="hidden"
		name="<c:out value="${pageScope.WORKFLOW_TASK_ID}"/>"
		id="<c:out value="${pageScope.WORKFLOW_TASK_ID}"/>" />
		
	<input type="hidden" name="taskId"	value=""/>		
		
</div>
