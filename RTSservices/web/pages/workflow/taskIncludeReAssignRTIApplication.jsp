<%@page import="java.util.Date"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<%
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
%>
<%int day=0;int flag=0;  long diffHours=0;%>
<c:if test="${workflowRequired eq 'true'}">
	<div class="workflowBox" id="workflowDiv">	
  <br>
		<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
			<tr>
				<td><span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.department" /></span>
				<span class="ClsRequiredFields">*</span>
				</td>
				<td>
					<select class="ClsTextbox" name="departmentId" id="departmentId"
						onchange="getToSectionsOnDepartment(this.value);">
						<option value=""><--- Select ---></option>
							<c:forEach var="department" items="${requestScope.departmentList}">
								<option value="${department.departmentId}">
									<c:out value="${department.name}" /></option>							
							</c:forEach>
						</select>			
				</td>	
				<td><span class="ClsLabel"><fmt:message	key="rtiApplication.manage.label.section" /> </span> <span class="ClsRequiredFields">*</span></td>
				<td><select name="toSectionId" id="toSectionId" class="ClsTextbox" onchange="getUsersOnSection(this.value);">
							<option value=""><--- Select Section ---></option>
							<c:forEach var="section" items="${requestScope.sectionList}">
								<option value="${section.sectionId}">
									<c:out value="${section.name}" />
								</option>
							</c:forEach>
					</select>
				</td>	
				<td><span class="ClsLabel"><fmt:message	key="rtiApplication.manage.label.user" /> </span> <span
						class="ClsRequiredFields">*</span></td>
				<td><select name="userId" id="userId" class="ClsTextbox">
					<option value=""><--- Select User ---></option>
					<c:forEach var="user" items="${requestScope.userList}">
						<option value="${user.userName}">
							<c:out value="${user.firstName}" />
							<c:out value="${user.lastName}" />
						</option>
					</c:forEach>
					</select>
				</td>	
				
				<td> 
					 <c:if test="${not empty PROCESS_ENDED and PROCESS_ENDED==false}">
					  <div class="statusOption">
									<div class="status approveOn"
										onclick="javascript: assignTaskToUser(this.form);" 
										style="cursor:pointer"></div>
									    Re-Assign Task
								</div>
					 </c:if>
				</td>		
			</tr>
			
			
		</table> 
		<br> 
			 
	</div>

	<input type="hidden"
		name="<c:out value="${pageScope.WORKFLOW_ACTION}"/>"
		id="<c:out value="${pageScope.WORKFLOW_ACTION}"/>" value="" />

	<input type="hidden"
		name="<c:out value="${pageScope.WORKFLOW_TRANSISTION}"/>"
		id="<c:out value="${pageScope.WORKFLOW_TRANSISTION}"/>" value="" />

	<input type="hidden" name="<c:out value="${pageScope.WORKFLOW_NAME}"/>"
		id="<c:out value="${pageScope.WORKFLOW_NAME}"/>"
		value="<c:out value="${requestScope.WORKFLOW_NAME}"/>" />

	<input type="hidden"
		name="<c:out value="${pageScope.WORKFLOW_ENTITYNAME}"/>"
		id="<c:out value="${pageScope.WORKFLOW_ENTITYNAME}"/>"
		value="<c:out value="${requestScope.WORKFLOW_ENTITYNAME}"/>" />

	<input type="hidden"
		name="<c:out value="${pageScope.WORKFLOW_ENTITYID}"/>"
		id="<c:out value="${pageScope.WORKFLOW_ENTITYID}"/>"
		value="<c:out value="${requestScope.WORKFLOW_ENTITYID}"/>" />

	<input type="hidden"
		name="<c:out value="${pageScope.WORKFLOW_JOB_ID}"/>"
		id="<c:out value="${pageScope.WORKFLOW_JOB_ID}"/>"
		value="<c:out value="${requestScope.WORKFLOW_JOB_ID}"/>" />

	<input type="hidden"
		name="<c:out value="${pageScope.WORKFLOW_TASK_ID}"/>"
		id="<c:out value="${pageScope.WORKFLOW_TASK_ID}"/>"
		value="<c:out value="${requestScope.WORKFLOW_TASK_ID}"/>" />

</c:if>

<td>
<input type="hidden"  id="taskId" name="taskId" value="<c:out value="${personalTask.task.id}"/>" />
<input type="hidden"  id="selectedTaskIds" name="selectedTaskIds" value="<c:out value="${personalTask.task.id}"/>" />
</td>

<script>

function getToSectionsOnDepartment(departmentId){
	
	var selectElement = document.getElementById("toSectionId");
	removeAllOptions(selectElement);
	CommonServiceDWR.getSectionsOnDepartment(departmentId, setToSectionsOnDepartment);
	if(departmentId==null || departmentId=='')
	{
		var selectElement = document.getElementById("userId");
		removeAllOptions(selectElement);
	}else{
		getUsersOnDepartment(departmentId);
	}
	
	/* CommonServiceDWR.getSectionsOnDepartment(departmentId, setToSectionsOnDepartment);
	getUsersOnDepartment(departmentId); */
}

function setToSectionsOnDepartment(dataList){
	
	var selectElement = document.getElementById("toSectionId");
	removeAllOptions(selectElement);
	if(dataList!=null){
		for(var i=1;i<=dataList.length;i++){				
			var optn = document.createElement("OPTION");
			optn.text = dataList[i-1].name ;
			optn.value = dataList[i-1].sectionId ;
			selectElement.options.add(optn);
		}
	}	
	
	/* var selectElement = document.getElementById("toSectionId");
	removeAllOptions(selectElement);
	for(var i=1;i<=dataList.length;i++){
		
		var optn = document.createElement("OPTION");
		optn.text = dataList[i-1].name ;
		optn.value = dataList[i-1].sectionId ;
		selectElement.options.add(optn);
	} */
} 

function getUsersOnSection(toSectionId){
	var tenancyId =  document.getElementById("tenancyId").value;		
	if(toSectionId==null || toSectionId==''){
		var selectElement = document.getElementById("userId");
		removeAllOptions(selectElement);
		
		departmentId = document.getElementById("departmentId").value;
		if(departmentId==null || departmentId=='')
		{
			var selectElement = document.getElementById("userId");
			removeAllOptions(selectElement);
		}else{
			getUsersOnDepartment(departmentId);
		}
	
	}else{
		CommonServiceDWR.getUsersOnSection(toSectionId, tenancyId, setUsersOnSection);
	}
	/* var tenancyId =  document.getElementById("tenancyId").value;
	CommonServiceDWR.getUsersOnSection(toSectionId, tenancyId, setUsersOnSection); */
}

function setUsersOnSection(dataList){
	var selectElement = document.getElementById("userId");
	removeAllOptions(selectElement);
	if(dataList!=null){
		for(var i=1;i<=dataList.length;i++){
			
			var optn = document.createElement("OPTION");
			optn.text = dataList[i-1].firstName +" "+dataList[i-1].lastName+" "+dataList[i-1].userName;
			optn.value = dataList[i-1].userId ;
			selectElement.options.add(optn);
		}
	}
	/* var selectElement = document.getElementById("userId");
	removeAllOptions(selectElement);
	for(var i=1;i<=dataList.length;i++){
		
		var optn = document.createElement("OPTION");
		optn.text = dataList[i-1].firstName +" "+dataList[i-1].lastName+" - "+dataList[i-1].userName;
		optn.value = dataList[i-1].userId ;
		selectElement.options.add(optn);
	} */
}


function getUsersOnDepartment(departmentId){
	var selectElement = document.getElementById("userId");
	removeAllOptions(selectElement);
	var tenancyId =  document.getElementById("tenancyId").value;
	CommonServiceDWR.getUsersOnDepartment(departmentId, tenancyId, setUsersOnDepartment);
	/* var tenancyId =  document.getElementById("tenancyId").value;
	CommonServiceDWR.getUsersOnDepartment(departmentId, tenancyId, setUsersOnDepartment); */
}

function setUsersOnDepartment(dataList){
	var selectElement = document.getElementById("userId");
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
<script type="text/javascript">

	function disableEnableControls(obj) {
		if(obj.checked) {
			disableControlsByJquery(false);
		} else {
			disableControlsByJquery(true);
			$('#workflowDiv *').removeAttr('disabled');
		}
	}

 function disableControlsByJquery(blnStatus) {
	    if (!blnStatus) {
	        $('#SetFormHeight *').removeAttr('disabled');
	        $('#SetFormHeight a').removeClass("not-active");
	    } else {
			$('#SetFormHeight *').attr('disabled', true);
			$('#SetFormHeight a').addClass("not-active");
			$('.downloadFile1').removeAttr('disabled');
			 $('.downloadFile1').removeClass("not-active");
			 $('.downloadFile3').removeAttr('disabled');
			 $('.downloadFile3').removeClass("not-active");
	    }   
	} 
	
	
		$('.mainHdr a').attr("href","javascript:void(0)");
	//$('#SetFormHeight a').attr("href","javascript:void(0)");
 
 
				disableControlsByJquery(true);
				$('#commentsDisable *').attr('disabled', true);
				$('#commentsDisable *').addClass("not-active");
				$('#descriptionDisabled *').attr('disabled', true);
				$('#descriptionDisabled *').addClass("not-active");
				$('#uuid').removeAttr('disabled');
				//$('#SetFormHeight a').attr("onclick","javascript:void(0)");
				$('.mainHdr a').attr("onclick","javascript:void(0)");
				<c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
					document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick","javascript:void(0);");
					document.getElementById('workflow_tras_${taskTransitionName}').removeAttribute("style");
				</c:forEach>
				//Disable the Discard Workflow icon also if the task is not owned
				document.getElementById('KillWorkflow').setAttribute("onclick","javascript:void(0);");
				document.getElementById('KillWorkflow').removeAttribute("style");		
 
	
</script>
