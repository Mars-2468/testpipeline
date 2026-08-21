<%@page import="com.mars.common.utils.CommonUtils"%>
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
	
	pageContext.setAttribute("APPLICATION_STATUS_LIST", CommonUtils.getApplicationStatusList());
%>
<script type="text/javascript">
function editRTIApplication() {
	//document.getElementById('rtiApplicationId').value = id;
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplication.do');
} 
function rtiApplicationSearch() { 
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/listRTIApplicationReports.do');
}

function viewNoting() { 
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/viewNoting.do');
} 

function viewDrafts(){
	//document.getElementById('manageRTIApplicationId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/viewDrafts.do');
}

function downloadRTIApplicationList(){
	//document.getElementById('manageRTIApplicationId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/downloadRTIApplicationList.do');
}


function listRTIApplicationReports()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/listRTIApplicationReports.do');	
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
	




</script>

<div class="mainHdr">
	<h3>
		RTI Application Report Search
	</h3>
</div>

<div valign="top" id="SetFormHeight">
<div id="tabs">
  <ul>
	<li>
		<a linkindex="1" href="#tabs-1" onclick="Javascript:getPendingTasks();">RTI Reports</a>
	</li> 
	
   </ul>

   <div id="tabs-1"> 
		<div class="ClsSearch" id="actionButton">		
			<button type="button" class="btn btn-primary btn-xs" onclick="editRTIApplication()" id="viewApplication" >View Application</button>
			<button type="button" class="btn btn-primary btn-xs" onclick="downloadRTIApplicationList()"  id="downloadApplList">Download Application List</button>	
			<button type="button" class="btn btn-primary btn-xs" onclick="viewNoting()"  id="downloadNoting">Download Noting</button>	
			<div style="float: right;">
				<select class="ClsSelect" name="draftType" id="draftType" style="width: 130px; height: 20px; vertical-align: middle;" >
					<option value="">All</option> 
					<c:forEach var="draftType" items="${draftTypeList}">
						<c:choose>
							<c:when test="${selectedDraftTypeId==draftType.draftTypeId}">
								<option value="${draftType.draftTypeId}" selected="selected">
									<c:out value="${draftType.draftTypeName}" /></option>
							</c:when>
							<c:otherwise>
								<option value="${draftType.draftTypeId}">${draftType.draftTypeName}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>															 
				</select>
				<button type="button" class="btn btn-primary btn-xs" onclick="viewDrafts()" id="downlaodDraft"  >Download Drafts</button>
			</div>
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
					<input type="text" onkeyup="javascript:regNoAutoComplete(event,this.value)" maxlength="30" name="rtiApplicationNumber" class="ClsTextbox"  id="rtiApplicationNumber" value="${SearchOptions.rtiApplicationNumber}" />
				</td>	 			
				<%-- <td width="17%">
					Application  Type
				</td>
				<td width="15%">
					<input type="radio"   name="isRTIAppealApplication" id="rtiApplication" value="0" <c:if test ="${SearchOptions.isRTIAppealApplication==0}"> checked="checked"</c:if> /> RTI Application 
					<input type="radio"  name="isRTIAppealApplication" id="rtiApplicationAppeal" value="0" <c:if test ="${SearchOptions.isRTIAppealApplication==1}"> checked="checked"</c:if>  /> Appeal Application
                </td>  --%>
				<td width="17%">
					Application Received Department 
				</td>
				<td width="15%">
                    <select class="ClsTextbox" name="rtiAplicationReceivedDepartment" id="rtiAplicationReceivedDepartment" >
						<option value=""><--- Select ---></option>
							<c:forEach var="department" items="${requestScope.departmentList}"> 
								<c:choose>
									<c:when test="${department.departmentId == SearchOptions.rtiAplicationReceivedDepartment}">
										<option selected="selected" value="${department.departmentId}"> ${department.name}</option>	
									</c:when>
									<c:otherwise>
										<option value="${department.departmentId}"> ${department.name}</option>	
									</c:otherwise>	
								</c:choose>						
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
							<c:choose>
								<c:when test="${department.departmentId == SearchOptions.assignedDepartment}">
									<option selected="selected" value="${department.departmentId}"> ${department.name}</option>	
								</c:when>
								<c:otherwise>
									<option value="${department.departmentId}"> ${department.name}</option>	
								</c:otherwise>	
							</c:choose>													
						</c:forEach>
					</select>			
				</td>	 	
				<td><span class="ClsLabel">Assigned <fmt:message	key="rtiApplication.manage.label.section" /> </span></td>
				<td><select name="assignedSection" id="assignedSection" class="ClsTextbox" onchange="getUsersOnSection(this.value);">
						<option value=""><--- Select Section ---></option>
						<c:forEach var="section" items="${requestScope.sectionList}">
							<c:choose>
								<c:when test="${section.sectionId == SearchOptions.assignedSection}">
									<option selected="selected" value="${section.sectionId}"> ${section.name}</option>	
								</c:when>
								<c:otherwise>
									<option  value="${section.sectionId}"> ${section.name}</option>	
								</c:otherwise>	
							</c:choose>													
						</c:forEach>							
					</select>
				</td>	
				<td><span class="ClsLabel">Assigned <fmt:message	key="rtiApplication.manage.label.user" /> </span></td>
				<td> 
					<select name="assignedUser" id="assignedUser" class="ClsTextbox">
						<option value=""><--- Select User ---></option>	
						<c:forEach var="user" items="${requestScope.userList}">
							<c:choose>
								<c:when test="${user.userId == SearchOptions.assignedUser}">
									<option selected="selected" value="${user.userId}"> ${user.firstName} ${user.lastName} - ${user.userName}</option>	
								</c:when>
								<c:otherwise>
									<option  value="${user.userId}">  ${user.firstName} ${user.lastName} - ${user.userName}</option>	
								</c:otherwise>	
							</c:choose>													
						</c:forEach>				
					</select>
				</td>		
			</tr>
			<tr>			
				<td width="17%">
					Application Status
				</td>				 
				<td width="15%">
                   <select class="ClsTextbox" name="finalStatus" id="finalStatus"  >
                   		<option value=""><--- Select Status ---></option>
                   		
                   		<c:forEach items="${pageScope.APPLICATION_STATUS_LIST}" var="applicationStatus">
                   			<c:choose>
	                   			<c:when test="${applicationStatus eq SearchOptions.finalStatus}"> 
	                   				<option  selected="selected" value="${applicationStatus}">${applicationStatus}</option>
	                   			</c:when>
	                   			<c:otherwise>
	                   				<option value="${applicationStatus}">${applicationStatus}</option>
	                   			</c:otherwise>
                   			</c:choose>             			
                   			
                   		</c:forEach> 																					
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
				<td colspan="6" align="center">
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
		
		
		 <table cellpadding="0" cellspacing="1" width="100%" class="dataGrid">
			<thead>
				<tr>
					<td style="width: 15px"></td>
					<td style="width: 140px" onclick="javascript:resort('upper(rtiApplicationId)');"
						style="cursor: pointer" wrap>Computer Number <span
						id="upper(rtiApplicationId)"></span>
					</td>
					<td  style="width: 150px" onclick="javascript:resort('upper(rtiApplnNumber)');"
						style="cursor: pointer" wrap><fmt:message
							key="rtiApplication.list.label.rtiApplnNumber" /> <span
						id="upper(rtiApplnNumber)"></span>
					</td>
					
					<td  style="width: 150px" onclick="javascript:resort('upper(registrationDate)');"
						style="cursor: pointer" wrap>Registration Date <span
						id="upper(registrationDate)"></span>
					</td>
					<td  style="width: 170px" onclick="javascript:resort('upper(applicantName)');"
						style="cursor: pointer" wrap>Applicant Name <span
						id="upper(applicantName)"></span>
					</td>
					<td onclick="javascript:resort('subject');"
						style="cursor: pointer" wrap>Subject <span
						id="upper(subject)"></span>
					</td>
				</tr>
			</thead>
			<tbody>
				<c:set var="hasRows" value="false" />
				<c:forEach var="rtiApplnList"
					items="${requestScope.rtiApplicationList}" varStatus="rowNumber">
					<c:set var="hasRows" value="true" />
					<tr>
						<td>	
							 <input type="checkbox" id="actionCheckbox" name="actionCheckbox" value="${rtiApplnList.rtiApplicationId}">
						</td>
						<td> 
							<c:out value="${rtiApplnList.rtiApplicationId}" />
						</td>
						<td> 
							<c:out value="${rtiApplnList.rtiApplnNumber}" />
						</td>
						<td><c:out value="${rtiApplnList.registrationDate}" /></td>
						<td><c:out value="${rtiApplnList.applicantName}" /></td>
						<td><c:out value="${rtiApplnList.subject}" /></td>
					</tr>
				</c:forEach>
	
				<c:if test="${hasRows == false}">
					<tr>
						<td colspan="5" class="clsNoRecords" align="center"><fmt:message
								key="list.label.norecords" /></td>
					</tr>
				</c:if>
			</tbody>
	
			<tfoot>
				<tr>
					<td colspan="6"><c:if test="${requestScope.rtiApplicationList != null && requestScope.totalCount>0}">
							<span><%@include file="/pages/common/pagination.jsp"%></span>
						</c:if></td>
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

$('#viewApplication').attr('disabled', true);
$('#downloadNoting').attr('disabled', true);
$('#downlaodDraft').attr('disabled', true);
	$('.main').css("height","auto");

	 $("input:checkbox").on('click', function() { 
	  var $box = $(this);
	  if ($box.is(":checked")) { 
	    var group = "input:checkbox[name='" +$box.attr("name") + "']"; 
	    $(group).prop("checked", false);
	    $box.prop("checked", true);		   
	    $("#manageRTIApplicationId").val($box.val());
	    $("#rtiApplicationId").val($box.val());
	    
	    $('#viewApplication').attr('disabled', false);
	    $('#downloadNoting').attr('disabled', false);
	    $('#downlaodDraft').attr('disabled', false);
	    $('#downloadApplList').attr('disabled', false);
		   
	   // $('#actionButton *').attr('disabled', false); 
		//$("#actionButton").children().prop('disabled', false);
	  } else {
	    $box.prop("checked", false);
	    $("#manageRTIApplicationId").val('');
	    $("#rtiApplicationId").val('');
	    
	   // $('#actionButton *').attr('disabled', true); 
		//$("#actionButton").children().prop('disabled', true);
	    $('#viewApplication').attr('disabled', true);
	    $('#downloadNoting').attr('disabled', true);
	    $('#downlaodDraft').attr('disabled', true);
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
