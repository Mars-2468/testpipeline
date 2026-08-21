<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>

<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("DATE_TIME_DB_FORMAT", Constants.DATE_TIME_DB_FORMAT);

	pageContext.setAttribute("DATE_TIME_FORMAT", WorkflowConstants.WORKFLOW_DATE_FORMAT);
	
	pageContext.setAttribute("WORKFLOW_PRIORITY", WorkflowConstants.WORKFLOW_PRIORITY);
	pageContext.setAttribute("WORKFLOW_PRIORITY_LOW", WorkflowConstants.WORKFLOW_PRIORITY_LOW);
	pageContext.setAttribute("WORKFLOW_PRIORITY_LOW_LABEL", WorkflowConstants.WORKFLOW_PRIORITY_LOW_LABEL);
	pageContext.setAttribute("WORKFLOW_PRIORITY_MEDIUM", WorkflowConstants.WORKFLOW_PRIORITY_MEDIUM);
	pageContext.setAttribute("WORKFLOW_PRIORITY_MEDIUM_LABEL", WorkflowConstants.WORKFLOW_PRIORITY_MEDIUM_LABEL);
	pageContext.setAttribute("WORKFLOW_PRIORITY_HIGH", WorkflowConstants.WORKFLOW_PRIORITY_HIGH);
	pageContext.setAttribute("WORKFLOW_PRIORITY_HIGH_LABEL", WorkflowConstants.WORKFLOW_PRIORITY_HIGH_LABEL);

	pageContext.setAttribute("WORKFLOW_PROCESSDESCRIPTION", WorkflowConstants.WORKFLOW_PROCESSDESCRIPTION);
	pageContext.setAttribute("WORKFLOW_TRANSITION", WorkflowConstants.WORKFLOW_TRANSITION);
	pageContext.setAttribute("WORKFLOW_NAME", WorkflowConstants.WORKFLOW_NAME);

	pageContext.setAttribute("WORKFLOW_ACTION", WorkflowConstants.WORKFLOW_ACTION);
	pageContext.setAttribute("WORKFLOW_ACTION_COMPLETE_TASK", WorkflowConstants.WORKFLOW_ACTION_COMPLETE_TASK);
	pageContext.setAttribute("WORKFLOW_ACTION_CREATE_PROCESS", WorkflowConstants.WORKFLOW_ACTION_CREATE_PROCESS);
	pageContext.setAttribute("TAKE_TASK", WorkflowConstants.WORKFLOW_ACTION_TAKE_TASK);
	pageContext.setAttribute("KILL_JOB", WorkflowConstants.WORKFLOW_ACTION_KILL_JOB);

	pageContext.setAttribute("END_JOB", WorkflowConstants.WORKFLOW_ACTION_KILL_JOB);

	pageContext.setAttribute("WORKFLOW_TRANSISTION", WorkflowConstants.WORKFLOW_TRANSISTION);
	pageContext.setAttribute("WORKFLOW_ENTITYNAME", WorkflowConstants.WORKFLOW_ENTITYNAME);
	pageContext.setAttribute("WORKFLOW_ENTITYID", WorkflowConstants.WORKFLOW_ENTITYID);

	pageContext.setAttribute("WORKFLOW_JOB_ID", WorkflowConstants.WORKFLOW_JOB_ID);
	pageContext.setAttribute("WORKFLOW_TASK_ID", WorkflowConstants.WORKFLOW_TASK_ID);
	pageContext.setAttribute("WORKFLOW_COMMENTS", WorkflowConstants.WORKFLOW_COMMENTS);
	pageContext.setAttribute("WORKFLOW_DUE_DATE", WorkflowConstants.WORKFLOW_DUE_DATE);
	
	
	pageContext.setAttribute("APPL_STATUS_CLOSED", CoreConstants.APPL_STATUS_CLOSED);
	pageContext.setAttribute("APPL_STATUS_NEW", CoreConstants.APPL_STATUS_NEW);
	pageContext.setAttribute("APPL_STATUS_PARKED", CoreConstants.APPL_STATUS_PARKED);
	
	pageContext.setAttribute("APPL_STATUS_APPROVED", CoreConstants.APPL_STATUS_APPROVED);
	pageContext.setAttribute("APPL_STATUS_VERIFICATION", CoreConstants.APPL_STATUS_VERIFICATION);
	pageContext.setAttribute("APPL_STATUS_CREATE", CoreConstants.APPL_STATUS_CREATE);
%>
<script type="text/javascript">
	function editRTIApplication() {
		//document.getElementById('rtiApplicationId').value = id;
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplication.do');
	} 
function rtiApplicationSearch() { 
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/listRTIApplicationSearch.do');
}

function sendEmail()
{
	//document.getElementById('manageRTIApplicationId').value=id;
	document.getElementById('actionTaken').value='email'; 
	onPageSubmit('<c:out value="${contextRoot}"/>/emailsms/emailSMS.do');
}

function sendSMS()
{
	//document.getElementById('manageRTIApplicationId').value=id;
	document.getElementById('actionTaken').value='sms';
	onPageSubmit('<c:out value="${contextRoot}"/>/emailsms/emailSMS.do'); 
}
	
function createLetter(){
	//document.getElementById('manageRTIApplicationId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/draft/editDraft.do');
}

function activateParkedRTIApplication(){
	//document.getElementById('manageRTIApplicationId').value=id;
	document.getElementById('actionTaken').value='unPark';
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplicationPark.do');
}

function parkRTIApplication(){
	//document.getElementById('manageRTIApplicationId').value=id;
	document.getElementById('actionTaken').value='park';
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplicationPark.do');
}

</script>

<div class="mainHdr">
	<h3>
		RTI Application Search
	</h3>
</div>

<div valign="top" id="SetFormHeight">
<div id="tabs">
  <ul>
	<li>
		<a linkindex="1" href="#tabs-1" onclick="Javascript:getPendingTasks();">File Search</a>
	</li>
	<!-- <li>
		<a linkindex="2" href="#tabs-2" onclick="Javascript:getCompletedTasks();">Completed Tasks</a>
	</li> -->
	
   </ul>

   <div id="tabs-1"> 
		<div class="ClsSearch">
		
			<button type="button" class="btn btn-primary btn-xs" onclick="editRTIApplication()"  >View Application</button>
		 	<button type="button" class="btn btn-primary btn-xs" onclick="sendEmail()"  >Send eMail</button>
			<button type="button" class="btn btn-primary btn-xs" onclick="sendSMS()" >Send SMS</button>
			<button type="button" class="btn btn-primary btn-xs" onclick="createLetter()"  >Create Draft</button>
			
			 <c:choose>
				<c:when test="${not empty rtiApplication.isApplicationParked &&  rtiApplication.isApplicationParked == 1}">
					<button type="button" class="btn btn-primary btn-xs" onclick="activateParkedRTIApplication()"  >Activate  Application</button>	
				</c:when>
				<c:otherwise>
					<button type="button" class="btn btn-primary btn-xs" onclick="parkRTIApplication()"  >Park Application</button>						
				</c:otherwise>
			</c:choose>
		</div>
		<div id="SearchDivId" class="ClsSearch">
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			Search RTI Application
		</div>
		<br>
		<table id="SearchTable" class="searchForm" border="0" cellpadding="2" cellspacing="1" width="100%" >
			 
			<tr>
				<td width="17%">
					Application Number
				</td>
				<td width="15%">
					<input type="text" onkeyup="javascript:regNoAutoComplete(event,this.value)" maxlength="30" name="rtiApplicationNumber" class="ClsTextbox"  id="rtiApplicationNumber" value="<c:out value="${SearchOptions.rtiApplicationNumber}"/>" />
				</td>				
				<td width="17%">
					Application  Ref No.
				</td>
				<td width="15%">
                   <input type="text" class="ClsTextbox"  id="receivedFileRefNo" maxlength="30" name="receivedFileRefNo" value="<c:out value="${SearchOptions.receivedFileRefNo}"/>" tabindex="1" /> 				 
				</td>
				<td width="17%">
					Application Received Department 
				</td>
				<td width="15%">
                    <select class="ClsTextbox" name="rtiAplicationReceivedDepartment" id="rtiAplicationReceivedDepartment" >
						<option value=""><--- Select ---></option>
							<c:forEach var="department" items="${requestScope.departmentList}">
								<option value="${department.departmentId}">
									<c:out value="${department.name}" /></option>							
							</c:forEach>
					</select>	
                </td>  
			</tr>			 
			
			<tr>
				<tr>
				<td><span class="ClsLabel">Assigned <fmt:message key="rtiApplication.manage.label.department" /></span>
				</td>
				<td>
					<select class="ClsTextbox" name="assignedDepartment" id="assignedDepartment"
						onchange="getToSectionsOnDepartment(this.value);">
						<option value=""><--- Select ---></option>
							<c:forEach var="department" items="${requestScope.departmentList}">
								<option value="${department.departmentId}">
									<c:out value="${department.name}" /></option>							
							</c:forEach>
						</select>			
				</td>	
				<td><span class="ClsLabel">Assigned <fmt:message	key="rtiApplication.manage.label.section" /> </span></td>
				<td><select name="assignedSection" id="assignedSection" class="ClsTextbox" onchange="getUsersOnSection(this.value);">
							<option value=""><--- Select Section ---></option>							
					</select>
				</td>	
				<td><span class="ClsLabel">Assigned <fmt:message	key="rtiApplication.manage.label.user" /> </span></td>
				<td> <select name="assignedUser" id="assignedUser" class="ClsTextbox">
					<option value=""><--- Select User ---></option>					
					</select>
				</td>		
			</tr>
			
			</tr>
			
			<tr>
			
				<td width="17%">
					Application Status
				</td>
				 
				<td width="15%">
                   <select class="ClsTextbox" name="finalStatus" id="finalStatus"  >
                   		<option value="">Select</option>
						<option value="all">All</option>	
						<option value="${pageScope.APPL_STATUS_NEW}">New</option>
						<option value="${pageScope.APPL_STATUS_CREATE}">Acceptance Level</option>	
						<option value="${pageScope.APPL_STATUS_VERIFICATION}">Verification Level</option>	
						<option value="${pageScope.APPL_STATUS_APPROVED}">Approval Level</option>	
						<option value="${pageScope.APPL_STATUS_CLOSED}">Closed</option>
						<option value="${pageScope.APPL_STATUS_PARKED}">Parked</option>																								
					</select>
				</td>
				<td width="15%">
					Registration <fmt:message key="search.label.between" />
				</td>
				<td  colspan="3">
					<input type="text" class="ClsTextboxDate" id="creationFromDate"   maxlength="10" name="creationFromDate" readonly value="${SearchOptions.creationFromDate}" />
					&nbsp;&nbsp; - &nbsp;&nbsp;
					<input type="text" class="ClsTextboxDate" id="creationToDate"    maxlength="10" name="creationToDate" readonly  value="${SearchOptions.creationToDate}"  />
				</td> 			
			</tr>			
			
			<tr>
				<td colspan="4" align="center">
					<input type="button" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:rtiApplicationSearch()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');rtiApplicationSearch()" />

				</td>
			</tr>
		</table>
		<c:if test="${SearchOptions.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>
		
		
		<table cellpadding="0" cellspacing="0" border="1" width="98%"
			class="dataGrid">
			<thead>
				<tr>
					<td width="2%">
						
					</td>
					<td width="20px">
						
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
					<td width="55px">
						Pending (In days)
					</td>
					<td width="100px">
						Pending With
					</td>
					<td>
						Subject
					</td> 
					<td width="60px">
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
								   <c:if test="${personalTasksList.rtiApplication.finalStatus ne pageScope.APPL_STATUS_CLOSED}">
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
											<c:when
												test="${pageScope.WORKFLOW_PRIORITY_MEDIUM eq personalTasksList.task.priority}">
												<img src="<c:out value="${contextRoot}"/>/images/greenflag.gif"
													alt="Medium Priority" title="Medium Priority"/>
											</c:when>
											
										</c:choose><%-- ${personalTasksList.task.priority } --%>
									</c:if>
									<c:if test="${personalTasksList.rtiApplication.finalStatus eq pageScope.APPL_STATUS_CLOSED}">
										 <img src="<c:out value="${contextRoot}"/>/images/Ico_Close.gif"
													alt="File Is Closed" title="Medium Priority"/>
									</c:if>
									 <c:if test="${not empty personalTasksList.rtiApplication.isApplicationParked &&  personalTasksList.rtiApplication.isApplicationParked == 1 }">
									   <img src="<c:out value="${contextRoot}"/>/images/parked.jpg"
													alt="File Is Closed" title="Medium Priority"/>
									 </c:if>
									
								</td>
								<td>	
									  <input type="checkbox" id="actionCheckbox" name="actionCheckbox" value="${personalTasksList.rtiApplication.rtiApplicationId}">
								</td>
								<td>									
									<%-- <c:choose>
										 <c:when test="${not empty  personalTasksList.rtiApplication.assignedDepartment.departmentId  
										 			&& personalTasksList.rtiApplication.assignedDepartment.departmentId == user.department.departmentId}">
										 	<a href="javascript:void(0)" onclick="javascript:editFileCreation('${personalTasksList.rtiApplication.rtiApplicationId}' )"> 
											 ${personalTasksList.rtiApplication.rtiApplicationId}
											</a>
										 </c:when>
										 <c:otherwise>
										 	 ${personalTasksList.rtiApplication.rtiApplicationId}
										 </c:otherwise>
									 </c:choose> --%>
									 ${personalTasksList.rtiApplication.rtiApplicationId}
								</td>
								<td>
									${personalTasksList.rtiApplication.rtiApplnNumber}
								</td>
								<td>
									${personalTasksList.rtiApplication.registrationDate}
								</td>						
								<td nowrap="nowrap"> 
									${personalTasksList.rtiApplicationDetails.assignedStartDate}
								</td>
								
								 <td>
									<fmt:formatDate var="fmtPersonalPendingSince"
										value="${personalTasksList.task.createTime}" 
										pattern="${pageScope.DATE_TIME_DB_FORMAT}" />
									
									<%
									 String personalPending=(String)pageContext.getAttribute("fmtPersonalPendingSince");							
									 long pendingDays=0;                           
									 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
									 if((personalPending!=null || personalPending=="")){
										 java.util.Date sd= formatter.parse(personalPending);								 
										 pendingDays = (new java.util.Date().getTime()-sd.getTime())/(24 * 60 * 60 * 1000);	
										 
									 }
							 		%>							
									<%=pendingDays%>	
								</td>
								<td>
									<c:if test="${personalTasksList.rtiApplication.finalStatus ne pageScope.APPL_STATUS_CLOSED }">
									  ${personalTasksList.rtiApplication.assigneeUserId.firstName} -  ${personalTasksList.rtiApplication.assigneeUserId.userName} 
									</c:if> 
								</td>
								<td>
									${personalTasksList.rtiApplication.subject}
								</td>
								<td>
									${personalTasksList.rtiApplication.finalStatus}
								</td>								
								<%-- <td>
									<c:if test="${personalTasksList.rtiApplication.finalStatus ne pageScope.APPL_STATUS_CLOSED}">
									   <c:if test="${not empty  personalTasksList.rtiApplication.assignedDepartment.departmentId  
										 					&& personalTasksList.rtiApplication.assignedDepartment.departmentId == user.department.departmentId}">									
									   		<c:choose>
											     <c:when test="${personalTasksList.rtiApplication.isApplicationParked == 1 }">
											        <a href="#" onclick="actionTakenOnFile('${personalTasksList.rtiApplication.rtiApplicationId}','unPark')">Activate parked File</a>
											     </c:when>
											     <c:otherwise>
											     	<a href="#" onclick="actionTakenOnFile('${personalTasksList.rtiApplication.rtiApplicationId}','park')">Park</a>
											     </c:otherwise>
										   </c:choose>
									   </c:if>	
								   </c:if>					   
								</td> --%>
							</tr>
						</c:forEach>
				     </c:when>
					<c:otherwise>
					    <tr>
							<td colspan="9"  class="clsNoRecords" >
								No Records Found
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="9">
						<c:if test="${requestScope.PersonalTasksList != null }">
							<%-- <span><%@include file="/pages/common/pagination.jsp"%></span> --%>
							<span><%@include file="/pages/common/paginationWithPriority.jsp"%></span> 
						</c:if>
					</td>
				</tr>
			</tfoot>
		</table>
 
	</div>
	
	<input type="hidden" name="tenancyId" id="tenancyId" value="${tenancyId}">
	<input type="hidden" name="rtiApplicationId" id="rtiApplicationId">
	<input type="hidden" name="manageRTIApplicationId" id="manageRTIApplicationId">
	<input type="hidden" name="actionTaken" id="actionTaken">
	
</div>
<script type="text/javascript">
$(document).ready(function() { 
    $('.main').css("height","auto");
});
</script>
<script type="text/javascript">
		 $("input:checkbox").on('click', function() { 
		  var $box = $(this);
		  if ($box.is(":checked")) { 
		    var group = "input:checkbox[name='" +$box.attr("name") + "']"; 
		    $(group).prop("checked", false);
		    $box.prop("checked", true);		   
		    $("#manageRTIApplicationId").val($box.val());
		    $("#rtiApplicationId").val($box.val());
		  } else {
		    $box.prop("checked", false);
		    $("#manageRTIApplicationId").val('');
		    $("#rtiApplicationId").val($box.val());
		  }
		});  
</script>

<script type="text/javascript">	
	function getToSectionsOnDepartment(departmentId){
		//alert(departmentId)
		var selectElement = document.getElementById("assignedSection");
		removeAllOptions(selectElement);
		CommonServiceDWR.getSectionsOnDepartment(departmentId, setToSectionsOnDepartment);
		if(departmentId==null || departmentId=='')
		{
			var selectElement = document.getElementById("assignedUser");
			removeAllOptions(selectElement);
		}else{
			getUsersOnDepartment(departmentId);
		}		
	}
	
	function setToSectionsOnDepartment(dataList){
		
		var selectElement = document.getElementById("assignedSection");
		removeAllOptions(selectElement);
		if(dataList!=null){
			for(var i=1;i<=dataList.length;i++){				
				var optn = document.createElement("OPTION");
				optn.text = dataList[i-1].name ;
				optn.value = dataList[i-1].sectionId ;
				selectElement.options.add(optn);
			}
		}	
	} 
	
	function getUsersOnSection(toSectionId){
		
		var tenancyId =  document.getElementById("tenancyId").value;		
		if(toSectionId==null || toSectionId==''){
			var selectElement = document.getElementById("assignedUser");
			removeAllOptions(selectElement);
			
			departmentId = document.getElementById("assignedDepartment").value;
			if(departmentId==null || departmentId=='')
			{
				var selectElement = document.getElementById("assignedUser");
				removeAllOptions(selectElement);
			}else{
				getUsersOnDepartment(departmentId);
			}
		
		}else{
			CommonServiceDWR.getUsersOnSection(toSectionId, tenancyId, setUsersOnSection);
		}
		
		
	}
	
	function setUsersOnSection(dataList){
		var selectElement = document.getElementById("assignedUser");
		removeAllOptions(selectElement);
		if(dataList!=null){
			for(var i=1;i<=dataList.length;i++){
				
				var optn = document.createElement("OPTION");
				optn.text = dataList[i-1].firstName +" "+dataList[i-1].lastName+" "+dataList[i-1].userName;
				optn.value = dataList[i-1].userId ;
				selectElement.options.add(optn);
			}
		}
	}
	
	function getUsersOnDepartment(departmentId){
		var selectElement = document.getElementById("assignedUser");
		removeAllOptions(selectElement);
		var tenancyId =  document.getElementById("tenancyId").value;
		CommonServiceDWR.getUsersOnDepartment(departmentId, tenancyId, setUsersOnDepartment);
	}
	
	function setUsersOnDepartment(dataList){
		var selectElement = document.getElementById("assignedUser");
		removeAllOptions(selectElement);
		/* if(dataList!=null){
			for(var i=1;i<=dataList.length;i++){
				
				var optn = document.createElement("OPTION");
				optn.text = dataList[i-1].firstName +" "+dataList[i-1].lastName+" "+dataList[i-1].userName;
				optn.value = dataList[i-1].userId ;
				selectElement.options.add(optn);
			}
		}	 */
	}


	
	</script>		
</div>
