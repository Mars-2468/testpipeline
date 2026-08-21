<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<%@page import="com.mars.workflow.model.PersonalTask"%>

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
<%
    int currentYear = java.time.Year.now().getValue();
    int startYear = 2023; // Start from the year 2023
    String hiddenYear = request.getParameter("year"); // Get the hidden field value
    int selectedYear = (hiddenYear != null && !hiddenYear.isEmpty()) ? Integer.parseInt(hiddenYear) : currentYear;
%>
<script type="text/javascript">
function getPendingTasks()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/workflow/listTasks.do');
}

function getCompletedTasks()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/workflow/listCompletedTasks.do');
}

/* function getGroupTasks()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/workflow/listGroupTasks.do');
}

function takeTask(taskId)
{
	document.getElementById('${pageScope.WORKFLOW_TASK_ID}').value=taskId;
	onPageSubmit('<c:out value="${contextRoot}"/>/workflow/saveTaskOwnership.do');
} */

function editRTIApplication(refId,id) {
	document.getElementById('rtiApplicationRefId').value = refId;
	document.getElementById('rtiApplicationId').value = id;
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editAnyRTIApplication.do');
}

function getpersonaltaskList(){
	onPageSubmit('<c:out value="${contextRoot}"/>/workflow/listTasks.do');
}

</script>


<div class="mainHdr d-flex justify-content-between align-items-center">
    <h3 class="mb-0">Personal Task List</h3>
    <c:if test="${personalTasksList.rtiApplication.rtiserviceid==90}">
    <div class="d-flex align-items-center ms-2">
        <h6 id="yearLabel" class="mb-0 me-2" style="font-size: 15px;">Year:</h6>
         <select id="year" name="year" class="ClsTextbox mb-0" onchange="getpersonaltaskList()" style="width: 130px;">
            <% 
                for (int year = currentYear; year >= startYear; year--) {
                    String selected = (year == selectedYear) ? "selected" : "";
            %>
                    <option value="<%= year %>" <%= selected %>><%= year %></option>
            <% 
                }
            %>
        </select>
        <input type="hidden" id="yearSelectHidden" name="year" value="<%= selectedYear %>"/>
    </div>
    </c:if>
</div>


<div valign="top" id="SetFormHeight">
<div id="tabs">
 <!--  <ul>
	<li>
		<a linkindex="1" href="#tabs-1" onclick="Javascript:getPendingTasks();">Pending Tasks</a>
	</li>
	<li>
		<a linkindex="2" href="#tabs-2" onclick="Javascript:getCompletedTasks();">Completed Tasks</a>
	</li>
	
   </ul> -->

   <div id="tabs-1">
	<c:if test="${not empty displaymode and displaymode eq 'inbox' }">
		<table cellpadding="0" cellspacing="0" border="1" width="98%"
			class="dataGrid">
			<thead>
				<tr>
					<td width="2%">
						
					</td>
					<td width="70px">
						Computer Number
					</td>
					<td width="150px">
						Application Number
					</td>
					<td width="150px">
						Registration Date
					</td>					
					<td width="150px">
						Assigned Date
					</td>
					<td width="50px">
						Pending (In days)
					</td>
					<td >
						Subject
					</td>
					<td>
					Status
					</td>
				</tr>
			</thead>
			<tbody>
			   <c:choose>
					<c:when test="${not empty requestScope.PersonalTasksList}">
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
									</c:choose><%-- ${personalTasksList.task.priority } --%>
								</td>
								<td>
								 ${personalTasksList.rtiApplication.rtiApplicationId}

								</td>
								<input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="<c:out value="${personalTasksList.rtiApplication.rtiApplicationRefId}" />" />
									<input type="hidden" id="rtiApplicationId" name="rtiApplicationId" value="" />
								
								<td><a style="margin-right: 15px;" title="<fmt:message key="list.link.EditOrViewLink"/>"
href="javascript:editRTIApplication('${personalTasksList.rtiApplication.rtiApplicationRefId}','${personalTasksList.rtiApplication.rtiApplicationId}');">
<c:out value="${personalTasksList.rtiApplication.rtiApplnNumber}" />
</a></td>
							
								<td>
									${personalTasksList.rtiApplication.registrationDate}
								</td>						
								<td nowrap="nowrap">
									<%-- <fmt:formatDate var="fmtPersonalTaskStartDate"
										value="${personalTasksList.task.createTime}" type="both"
										dateStyle="full" timeStyle="short"
										pattern="${pageScope.DATE_TIME_FORMAT}" />
									<c:out value="${fmtPersonalTaskStartDate}" /> --%>
									${personalTasksList.rtiApplicationDetails.assignedStartDate}
								</td>
								
								 <td>
									<%-- <fmt:formatDate var="fmtPersonalPendingSince"
										value="${personalTasksList.rtiApplicationDetails.createdDate}" 
										pattern="${pageScope.DATE_TIME_DB_FORMAT}" /> --%>
									<c:set var="personalPending" value="${personalTasksList.rtiApplicationDetails.createdDate}" />
									<%
									 String personalPending=(String)pageContext.getAttribute("personalPending");							
									 long pendingDays=0;                           
									 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/MM/yyyy");
									 if (personalPending != null && !personalPending.equals("")) {
										 
										 java.util.Date sd= formatter.parse(personalPending);								 
										 pendingDays = (new java.util.Date().getTime()-sd.getTime())/(24 * 60 * 60 * 1000);	
										 
									 }
							 		%>							
									<%=pendingDays%>	
								</td>
								
								<td>
									${personalTasksList.rtiApplication.subject}
								</td>
								<td> 
                   <c:if test="${personalTasksList.rtiApplication.workFlowStatus==0}">
						Citizen Form Submitted. 
					</c:if>
					<c:if test="${personalTasksList.rtiApplication.workFlowStatus==3}">
						Citizen Payment Pending. 
					</c:if>
					<c:if test="${personalTasksList.rtiApplication.workFlowStatus==2}">
                           <c:choose>
                        <c:when test="${rtiApplication.applicationCost==0.0}">
                         Verification is Completed 
                        </c:when>
                        <c:otherwise>
                             Payment Completed
                        </c:otherwise></c:choose>
                       </c:if>
											
					<c:if test="${personalTasksList.rtiApplication.workFlowStatus==1}">
						Completed and File Uploaded for Citizen
					</c:if>
					<c:if test="${personalTasksList.rtiApplication.workFlowStatus==5}">
						Rejected
					</c:if>
					<c:if test="${personalTasksList.rtiApplication.workFlowStatus==12}">
						Citizen Visit Date Rescheduled
					</c:if>
					<c:if test="${personalTasksList.rtiApplication.workFlowStatus==9}">
						Higher Authority Approval Pending 
					</c:if> 
					<c:if test="${personalTasksList.rtiApplication.workFlowStatus==10}">
						Higher Authority Approval Completed 
					</c:if>
					<c:if test="${personalTasksList.rtiApplication.workFlowStatus==12}">
						Citizen Visit Date Rescheduled
					</c:if>
     </td>     
								
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>						 
							<td colspan="8"  class="clsNoRecords" >
								 No Pending Task
							</td>
						</tr>					  
					</c:otherwise>
				</c:choose>		
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
	<div id="tabs-2">
	<c:if test="${not empty displaymode and displaymode eq 'outbox' }">
		<table cellpadding="0" cellspacing="0" border="1" width="98%"
			class="dataGrid">
			<thead>
				<tr>
					<td>
						Task Id
					</td>
					<td>
						Entity Name
					</td>
					<td>
						Entity Details
					</td>					
					<td>
						Action
					</td>
					<td width="125px">
						Start Date
					</td>
					<td width="125px">
						End Date
					</td>
					<td width="25%">
						Description
					</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="completedTasks"
					items="${requestScope.CompletedTasksList}" varStatus="rowNumber">
					<tr>
						<td>
							<c:out value="${completedTasks.taskId}" />
						</td>
						<td>
							<c:out value="${completedTasks.entityName}" />
						</td>
						<td>
							<c:out value="${completedTasks.entityDetails}" />
						</td>						
						<td>
							<c:out value="${completedTasks.outcome}" />
						</td>
						<td nowrap="nowrap">
							<fmt:formatDate var="fmtTaskStartDate"
								value="${completedTasks.createTime}" type="both"
								dateStyle="full" timeStyle="short"
								pattern="${pageScope.DATE_TIME_FORMAT}" />
							<c:out value="${fmtTaskStartDate}" />
						</td>
						<td nowrap="nowrap">
							<fmt:formatDate var="fmtEndTime"
								value="${completedTasks.endTime}" type="both" dateStyle="full"
								timeStyle="short" pattern="${pageScope.DATE_TIME_FORMAT}" />
							<c:out value="${fmtEndTime}" />
						</td>
						<td>
							<c:out value="${completedTasks.comments}" />
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="8">
						<c:if test="${requestScope.CompletedTasksList != null }">
							<span><%@include file="/pages/common/pagination.jsp"%></span>
						</c:if>
					</td>
				</tr>
			</tfoot>
		</table>
	</c:if>
	</div>
<div id="tabs-3">
	<c:if test="${not empty displaymode and displaymode eq 'groupbox' }">
		<table cellpadding="0" cellspacing="0" border="1" width="98%"
			class="dataGrid">
			<thead>
				<tr>
					<td width="2%">
						
					</td>
					<td width="15%">
						Task Name
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

					<td width="15%">
						Due Date
					</td>
					<td width="19%">
						Description
					</td>
					<td>
						Action
					</td>					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="groupTask"
					items="${requestScope.GroupTasksList}" varStatus="rowNumber">
					<tr>
						<td align="center">
							<c:choose>
								<c:when
									test="${pageScope.WORKFLOW_PRIORITY_LOW eq groupTask.task.priority}">
									<img
										src="<c:out value="${contextRoot}"/>/images/orangeflag.gif"
										alt="Low Priority" title="Low Priority" />
								</c:when>
								<c:when
									test="${pageScope.WORKFLOW_PRIORITY_HIGH eq groupTask.task.priority}">
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
							<c:out value="${groupTask.task.name}" />
						</td>
						<td>
							<c:out value="${groupTask.entityName}" />
						</td>
						<td>
							<c:out value="${groupTask.entityDetails}" />
						</td>						
						<td nowrap="nowrap">
							<fmt:formatDate var="fmtPersonalTaskStartDate"
								value="${groupTask.task.createTime}" type="both"
								dateStyle="full" timeStyle="short"
								pattern="${pageScope.DATE_TIME_FORMAT}" />
							<c:out value="${fmtPersonalTaskStartDate}" />
						</td>
						<td>
							<fmt:formatDate var="fmtPersonalDuetDate"
								value="${groupTask.task.duedate}" type="both"
								dateStyle="full" timeStyle="short"
								pattern="${pageScope.DATE_FORMAT}" />
							<c:out value="${fmtPersonalDuetDate}" />
						</td>
						<td>
							<c:out value="${groupTask.task.description}" />
						</td>
											
						<td>
							<img name="takeTaskIcon" id="takeTaskIcon" src="<c:out value="${contextRoot}"/>/images/Ico_Individual.gif" onclick="javascript:takeTask('<c:out value="${groupTask.task.id}" />');"
						title="Take Ownership of the task" style="cursor:pointer" />
						</td>						
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="8">
						<c:if test="${requestScope.groupTask != null}">
							<span><%@include file="/pages/common/pagination.jsp"%></span>
						</c:if>
					</td>
				</tr>
			</tfoot>
		</table>
	</c:if>
	</div>	
</div>
<script type="text/javascript">
	function openPage(taskId, workflowJobId, entityId, entityName)
	{
		
			var url = "";
			var entityur="";
			if(entityName!='')
			{
				var hiddenFieldId = "";

				
				
				/* if(entityName.match("")){
					url = "<c:out value="${contextRoot}"/>/duplicatelicense/editDuplicateLicense.do";
					hiddenFieldId = "rtiApplicationId";	
				} */
				url = "<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplication.do";
				hiddenFieldId = "rtiApplicationId";	
				if(entityName.match("BirthRegistration")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editBirthRegistrationCertificate.do";
					hiddenFieldId = "rtiApplicationRefId";	
				}
				if(entityName.match("DeathRegistration")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editDeathRegistrationCertificate.do";
					hiddenFieldId = "rtiApplicationRefId";	
				}
				if(entityName.match("DogLicense")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editDogLicenseCertificate.do";
					hiddenFieldId = "rtiApplicationRefId";	
				}
				if(entityName.match("TreeTrimming")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editTreeTrimmingCertificate.do";
					hiddenFieldId = "rtiApplicationRefId";	
				}
				if(entityName.match("ZoneCertificate")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editzoneCertificate.do";
					hiddenFieldId = "rtiApplicationRefId";	
				}
				if(entityName.match("MTPRegistrationCertificate")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editMTPRegistrationCertificate.do";
					hiddenFieldId = "rtiApplicationRefId";	
				}
				if(entityName.match("BiologicalWasteDisposal")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editBiologicalWasteDisposal.do";
					hiddenFieldId = "rtiApplicationRefId";	
				}
				if(entityName.match("NursingHomes")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editNurshingHome.do";
					hiddenFieldId = "rtiApplicationRefId";	
				}
				if(entityName.match("NoDuesCertificate")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editNoDuesCertificate.do";
					hiddenFieldId = "rtiApplicationRefId";	
				}
				if(entityName.match("TreeCutting")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editTreeCuttingApplication.do";
					hiddenFieldId = "rtiApplicationRefId";	
				}
				if(entityName.match("MarriageRegistration")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editBirthRegistrationCertificate.do";
					hiddenFieldId = "rtiApplicationRefId";	
				}
				if(entityName.match("PropertyOwnerChange")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editPropertyOwnershipChange.do";
					hiddenFieldId = "rtiApplicationRefId";	
				}
				if(entityName.match("WaterOwnerChange")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editWaterOwnershipChange.do";
					hiddenFieldId = "rtiApplicationRefId";	
				}
				if(entityName.match("RenewalDogLicense")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editRenewalDogLicenseCertificate.do";
					hiddenFieldId = "rtiApplicationRefId";	
				}
				if(entityName.match("RenewalNursingHome")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editRenewalNurshingHome.do";
					hiddenFieldId = "rtiApplicationRefId";	
				}
				if(entityName.match("NursingHomeChangesApplication")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editNursingHomeChangesApplication.do";
					hiddenFieldId = "rtiApplicationRefId";	
				}
				if(entityName.match("NoDuesCertificateWater")){
					url = "<c:out value="${contextRoot}"/>/rtiapplication/editNoDuesCertificateWater.do";
					hiddenFieldId = "rtiApplicationRefId";	
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
				onPageSubmit(url);
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
		<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>"/>
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" />
</div>
