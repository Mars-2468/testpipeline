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
<%
int day = 0;
int flag = 0;
long diffHours = 0;
%>
<style type="text/css">
input[type="text"], textarea {
	background-color: #e9ecef;
	border: 1px solid #c8c8c8;
	box-shadow: 0 0 2px #c8c8c8;
	border-radius: 5px;
	color: #333;
}

.ClsSelect {
	background-color: white;
	width: 200px;
	box-sizing: border-box;
	border: 1px solid #c8c8c8;
	box-shadow: 0 0 2px #c8c8c8;
	border-radius: 5px;
	color: #333;
}

.imagefile.downloadFile:hover {
	background-color: #008CBA;
	color: white;
	transition: background-color 0.3s;
}

.mainHdr {
	background-color: white;
}

.ClsLabel {
	font-style: normal;
	font-family: inherit;
	font-size: 10px;
	font-weight: 520 !important;
}
</style>

<style type="text/css">
input[type=text] {
	height: 35px;
	font-size: 15px;
}

a {
	text-decoration: none !important;
}

.taskaction {
	width: 100px;
	height: 32px;
}

.taskgenerateaction {
	width: 130px;
	height: 32px;
}

.download {
	font-size: 13px;
}
</style>

<c:if test="${workflowRequired eq 'true'}">
	<div class="workflowBox" id="workflowDiv">
		<div
			style="background-color: #e6e6e6; height: 40px; padding: 5px 10px 8px;">
			<span class="ClsTitle">Workflow Details</span>
			<!--<c:if
				test="${not empty IS_MY_JOB && IS_MY_JOB eq true && not empty IS_MY_TASK && IS_MY_TASK eq true}"> 
				<span class="ClsTitle"
					style="float: right; font-size:10px;padding-bottom:5px;">Edit
					Data</span>
				<span style="float: right;"><input type="checkbox"
						id="workflowEdit" name="workflowEdit"
						onchange="disableEnableControls(this)" class="clsText" /> </span>
			</c:if> -->
		</div>

		<c:choose>
			<c:when test="${not empty nmmcWorkflowInstance.id}">
				<div style="padding: 10px">
					<h3 class="tab">${requestScope.WORKFLOW_COMMENTS}</h3>
					<c:if test="${not empty PROCESS_ENDED and PROCESS_ENDED==false}">
						<div class="formBox">
							<table class="formTable" width="99%" border="0"
								style="float: left; margin-right: 15px; background-color: whitesmoke;">
								<tr id="commentsDisable">
									<td class="clsLabel">Priority</td>
									<td class="clsInput" colspan="3"><input type="radio"
										name="${pageScope.WORKFLOW_PRIORITY}"
										value="<c:out value="${pageScope.WORKFLOW_PRIORITY_LOW}"/>">
										<label for="low"> <c:out
												value="${pageScope.WORKFLOW_PRIORITY_LOW_LABEL}" />
									</label> <input type="radio" name="${pageScope.WORKFLOW_PRIORITY}"
										value="<c:out value="${pageScope.WORKFLOW_PRIORITY_MEDIUM}"/>"
										checked> <label for="medium"> <c:out
												value="${pageScope.WORKFLOW_PRIORITY_MEDIUM_LABEL}" />
									</label> <input type="radio" name="${pageScope.WORKFLOW_PRIORITY}"
										value="<c:out value="${pageScope.WORKFLOW_PRIORITY_HIGH}"/>">
										<label for="high"> <c:out
												value="${pageScope.WORKFLOW_PRIORITY_HIGH_LABEL}" />
									</label></td>

									<!-- <td class="clsLabel">
										Re-Assign to User
									</td> -->
									<%-- <td>
					<select class="ClsSelect" id="toUserName" name="toUserName" style="width:200px">
						<option value=""><--- Select ---></option>
						<c:forEach var="user" items="${requestScope.userList}">
							<option value="<c:out value="${user.userName}"/>" 
								<c:if test="${user.userName eq requestScope.toUserName}"> selected </c:if>>
								<c:out value="${user.firstName} ${user.lastName}" />
							</option>
						</c:forEach>
					</select>
				</td> --%>

									<!-- <td colspan="4" align="right">
					<input type="button" class="ClsButton" id="assignTasks" name="assignTasks" value="Re-Assign Task" onclick="javascript:reassignWorkflowTask(this.form);">
				</td> -->

								</tr>

								<tr id="descriptionDisabled">
									<td class="clsLabel" style="font-size: 11px">Remarks</td>
									<td class="clsInput"><textarea class="form-control"
											style="width: 300px;" id="${WORKFLOW_COMMENTS}"
											maxlength="250" name="${WORKFLOW_COMMENTS}"></textarea></td>
								</tr>

								<tr>
									<td class="clsLabel">Action</td>
									<td class="clsInput" colspan="3"><c:set
											var="workflowButton" value="On"></c:set> <c:if
											test="${not empty IS_MY_TASK and IS_MY_TASK==false}">
											<c:set var="workflowButton" value="Off"></c:set>
										</c:if> <c:forEach var="taskTransitionName"
											items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
											<c:choose>
												<c:when
													test="${taskTransitionName eq 'Accept' or taskTransitionName eq 'Update Status and Forward' or taskTransitionName eq 'Scrutiny' or taskTransitionName eq 'Issue LOI' or taskTransitionName eq 'approve' or taskTransitionName eq 'Approve' or taskTransitionName eq 'Complete' or taskTransitionName eq 'Complete'}">
													<div class="statusOption">
														<div class="status approve${workflowButton}"
															title="${taskTransitionName}"
															id="workflow_tras_${taskTransitionName}"
															onclick="javascript:completeTask('${taskTransitionName}')"
															style="cursor: pointer"></div>
														<c:out value="${taskTransitionName}" />
													</div>
												</c:when>
												<c:when test="${taskTransitionName eq 'Close-Application'}">
													<div class="statusOption">
														<div class="status approve${workflowButton}"
															title="${taskTransitionName}"
															id="workflow_tras_${taskTransitionName}"
															onclick="javascript:completeTask('${taskTransitionName}')"
															style="cursor: pointer"></div>
														Close Application
													</div>
												</c:when>
												<c:when
													test="${taskTransitionName eq 'Issue Truti Patra' or taskTransitionName eq 'reject' or taskTransitionName eq 'Reject' or taskTransitionName eq 'end' or taskTransitionName eq 'End' or taskTransitionName eq 'Close'}">
													<div class="statusOption">
														<div class="status reject${workflowButton}"
															title="${taskTransitionName}"
															id="workflow_tras_${taskTransitionName}"
															onclick="javascript:rejectTask('${taskTransitionName}')"
															style="cursor: pointer"></div>
														<c:out value="${taskTransitionName}" />
													</div>
												</c:when>
												<c:when
													test="${taskTransitionName eq 'reverify' or taskTransitionName eq 'Reverify' or taskTransitionName eq 'Re-verify' or taskTransitionName eq 're-verify' or taskTransitionName eq 'Re-Verify'}">
													<div class="statusOption">
														<div class="status reverify${workflowButton}"
															id="workflow_tras_${taskTransitionName}"
															title="${taskTransitionName}"
															onclick="javascript:completeTask('${taskTransitionName}')"
															style="cursor: pointer"></div>
														<c:out value="${taskTransitionName}" />
													</div>
												</c:when>
												<c:otherwise>
													<div class="statusOption">
														<div class="status others${workflowButton}"
															id="workflow_tras_${taskTransitionName}"
															title="${taskTransitionName}"
															onclick="javascript:completeTask('${taskTransitionName}')"
															style="cursor: pointer"></div>
														<c:out value="${taskTransitionName}" />
													</div>
												</c:otherwise>
											</c:choose>
										</c:forEach> <!-- 	<div class="statusOption">
											<div class="status reject${workflowButton}"
												title="Discard Workflow" id="KillWorkflow"
												onclick="javascript:killCurrentWorkflow(this.form)"
												style="cursor:pointer"></div>
											Discard Workflow
										</div> --></td>
								</tr>
							</table>
						</div>
					</c:if>
					<div id="pending"></div>
			<c:if test="${not empty requestScope.TASK_HISTORY}">
					<table border="0" width="100%" class="dataGrid"
						style="table-layout: fixed">
						<thead>
							<tr class="ClsTRHeaderList">
								<td>Task Id</td>
								<td>Action</td>
								<td>User Name</td>
								<td>Start Date</td>
								<td>End Date</td>
								<td>Number Of Days</td>
								<td>Comments</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="listTaskHistory"
								items="${requestScope.TASK_HISTORY}">
								<c:forEach var="taskHistory" items="${listTaskHistory}">
									<tr>
										<td><c:out value="${taskHistory.taskId}" /></td>
										<td><c:out value="${taskHistory.outcome}" /></td>
										<td><c:out value="${taskHistory.assignee}" /></td>
										<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
												value="${taskHistory.createTime}" /></td>
										<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
												value="${taskHistory.endTime}" /></td>
										<td><fmt:formatDate pattern="dd-MM-yyyy" var="createDate"
												value="${taskHistory.createTime}" /> <fmt:formatDate
												pattern="dd-MM-yyyy" var="endDate"
												value="${taskHistory.endTime}" /> <fmt:formatDate
												pattern="yyyy-MM-dd HH:mm:ss" var="createDateWithTime"
												value="${taskHistory.createTime}" /> <%
 String date1 = (String) pageContext.getAttribute("createDate");
 String date2 = (String) pageContext.getAttribute("endDate");
 int days = 0;

 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd-MM-yyyy");
 if ((date1 != null || date1 == "") && (date2 != null || date2 == "")) {
 	java.util.Date sd = formatter.parse(date1);
 	java.util.Date ed = formatter.parse(date2);
 	days = (int) ((ed.getTime() - sd.getTime()) / (1000 * 60 * 60 * 24));
 }
 /*  if(date1!=null && date1!=""){
 	 ////////
 	 java.text.SimpleDateFormat formatter1 = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");													
 	 String createDateWithTime=(String)pageContext.getAttribute("createDateWithTime");
 	 java.util.Date ed1= formatter.parse(createDateWithTime);
 	 
 	 java.util.Date CurentTime = new Date();
 	 long diff = CurentTime.getTime() - ed1.getTime();
 	  diffHours = diff / (60 * 60 * 1000);
  } */

 out.println(days);
 %> <c:if
												test="${taskHistory.outcome=='Workflow Created' || taskHistory.outcome==null}">
												<%
												String dateCreate = (String) pageContext.getAttribute("createDate");
												if (dateCreate != null || dateCreate == "") {
													java.util.Date std = formatter.parse(dateCreate);
													java.util.Date end = new java.util.Date();
													day = (int) ((end.getTime() - std.getTime()) / (1000 * 60 * 60 * 24));
												}
												%>


											</c:if> <c:if test="${taskHistory.outcome=='Approve'}">
												<script type="text/javascript">
		                                        <%flag = (int) 1;%>
		                                        </script>
											</c:if> <%--   <c:if test="${status.last}"> --%> <script
												type="text/javascript">
		                                        //pendingDiv();
		                                        function pendingDiv(){
		                                       
		                                        	if(<%=flag%>==0){
		                                    		var pendingdays = "<%=day%>";
		                                    		var action="${taskHistory.outcome}";
		                                        	document.getElementById("pending").innerHTML="Task Status Details - <span style='color:red'>Workflow pending from "+pendingdays+" days.</span>";
		                                        	}
		                                        }
		                                        
		                                        </script> <%-- </c:if> --%></td>

										<td style="word-wrap: break-word;"><c:out
												value="${taskHistory.comments}" /></td>
									</tr>
								</c:forEach>
							</c:forEach>

						</tbody>
					</table>
					</c:if>
				</div>
			</c:when>

			<c:otherwise>
				<div style="padding: 10px">
					<h3 class="tab">Send Demand to Citizen</h3>
					<table class="formTable" border="0" width="40%">
						<tr>
							<td class="ClsLabel" style="font-size: 14px">Remarks</td>
							<td><textarea class="form-control" style="width: 300px;"
									id="${WORKFLOW_COMMENTS}" maxlength="250"
									name="${WORKFLOW_COMMENTS}" style="width:300px;"></textarea></td>
						</tr>
						<tr>
							<td class="ClsLabel"></td>
							<td><input type="button" name="CreateWorkflow"
								id="CreateWorkflow" value="Send Demand"
								onclick="javascript:createWorkflow(this.form);"
								class="btn-primary taskaction"
								style="border: 1px solid #007bff; background-color: #007bff; color: #fff;border-radius: 3px;"
								onmouseover="this.style.backgroundColor = '#0056b3';"
								onmouseout="this.style.backgroundColor = '#007bff';" />
								&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
								name="RejectCreateWorkflow" id="RejectCreateWorkflow"
								value="Reject Application"
								onclick="javascript:killCurrentWorkflow(this.form);"
								class="btn-danger taskgenerateaction"
								style="background-color: #dc3545; border: 1px solid #dc3545; color: #fff; border-radius: 5px;"
								onmouseover="this.style.backgroundColor = '#c82333';"
								onmouseout="this.style.backgroundColor = '#dc3545';" /></td>
						</tr>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
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

<td><input type="hidden" id="taskId" name="taskId"
	value="<c:out value="${personalTask.task.id}"/>" /> <input
	type="hidden" id="selectedTaskIds" name="selectedTaskIds"
	value="<c:out value="${personalTask.task.id}"/>" /></td>
<script type="text/javascript">
disableControlsByJquery(true);
$('#workflowDiv *').removeAttr('disabled');
function reassignWorkflowTask(frm)
{
	var touser = document.getElementById('toUserName').value;
	
	var taskid= document.getElementById('taskId').value;
	document.getElementById("selectedTaskIds").value = taskid;
	if(touser != null && touser !=''){
		navigate(frm,'<c:out value="${contextRoot}"/>/reassignworkflowLicense/reassignWorkflowTaskLicense.do');
	}
	else{
		alert('Please Select the Re-Assign to User');
	    return false;
	}
	
}

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
	    }

		$('.downloadFile1').removeAttr('disabled');
		 $('.downloadFile1').removeClass("not-active");
		 $('.downloadFile3').removeAttr('disabled');
		 $('.downloadFile3').removeClass("not-active");


			$('.downloadFile').removeAttr('disabled');
			 $('.downloadFile').removeClass("not-active");
			 $('.downloadFile2').removeAttr('disabled');
			 $('.downloadFile2').removeClass("not-active");   
	} 
	
	function killCurrentWorkflow( frm ) {
	 if(checkMandatoryDetailed(new Array('${WORKFLOW_COMMENTS}'),new Array('Description')))
	 {
		
		if(confirm(" Do you really want to Discard the current WorkFlow ? ")){
			document.getElementById('<c:out value="${pageScope.WORKFLOW_ACTION}"/>').value='<c:out value="${pageScope.KILL_JOB}"/>';
			disableControlsByJquery(false);
			saveEntity();
		} else {
			return false;
		}
	 }else return false;
	}
	
	function createWorkflow( frm ) {
		
		
	  if(checkMandatoryDetailed(new Array('${WORKFLOW_COMMENTS}'),new Array('Task Description')))
	  {
		if(confirm(" Do you really want to Create WorkFlow ? ")){
			document.getElementById('<c:out value="${pageScope.WORKFLOW_ACTION}"/>').value='<c:out value="${pageScope.WORKFLOW_ACTION_CREATE_PROCESS}"/>';
			if(checkMandatoryDocs()){
				disableControlsByJquery(false);
				saveEntity();
			}

		} else {
			return false;
		}
	  }else return false;
	}


		function killWorkflow( frm ) {
			  if(checkMandatoryDetailed(new Array('${WORKFLOW_COMMENTS}'),new Array('Task Description')))
			  {
				if(confirm(" Do you really want to Create WorkFlow ? ")){
					if(checkMandatoryDocs()){
						disableControlsByJquery(false);
						rejectWorkflow();
					}

				} else {
					return false;
				}
			  }else return false;
			}
	
	function completeTaskDoc(transistionName) {
	if(checkMandatoryDetailed(new Array('idProof'),new Array('File Upload')))
	{
	
		completeTask(transistionName);
	}else return false;	
	}
	function completeTask(transistionName) {
		 var value = '${requestScope.rtiApplication.pdfFilesSavedPath}';
		 var tax = '${requestScope.rtiApplication.workFlowStatus}';
		    if (value === '' && tax!=='9') {
		        alert("Please Upload the Certificate!!");
		        return false;
		    }
		    
	if(checkMandatoryDetailed(new Array('${WORKFLOW_COMMENTS}'),new Array('Remarks')))
	{
		document.getElementById('<c:out value="${pageScope.WORKFLOW_ACTION}"/>').value='<c:out value="${pageScope.WORKFLOW_ACTION_COMPLETE_TASK}"/>';
		document.getElementById('<c:out value="${pageScope.WORKFLOW_TRANSISTION}"/>').value=transistionName;
		disableControlsByJquery(false);
		saveEntity();
	}else return false;
	}	
	
	function rejectTask(transistionName) {
		 var deptValue = '${requestScope.rtiApplication.department}';
		    if (deptValue === 'WATER-DEPARTMENT') {
		        alert("You don't have permission to reject the application!!");
		    	return false;
		    }else if(checkMandatoryDetailed(new Array('${WORKFLOW_COMMENTS}'),new Array('Remarks')))
	{
		document.getElementById('<c:out value="${pageScope.WORKFLOW_ACTION}"/>').value='<c:out value="${pageScope.WORKFLOW_ACTION_COMPLETE_TASK}"/>';
		document.getElementById('<c:out value="${pageScope.WORKFLOW_TRANSISTION}"/>').value=transistionName;
		disableControlsByJquery(false);
		saveEntity();
	}else return false;
	}
	
	
	function rejectTask(transistionName) {
		 var deptValue = '${requestScope.rtiApplication.department}';
		    if (deptValue === 'WATER-DEPARTMENT') {
		        alert("You don't have permission to reject the application!!");
		    	return false;
		    }else if(checkMandatoryDetailed(new Array('${WORKFLOW_COMMENTS}'),new Array('Remarks')))
	{
		document.getElementById('<c:out value="${pageScope.WORKFLOW_ACTION}"/>').value='<c:out value="${pageScope.WORKFLOW_ACTION_COMPLETE_TASK}"/>';
		document.getElementById('<c:out value="${pageScope.WORKFLOW_TRANSISTION}"/>').value=transistionName;
		disableControlsByJquery(false);
		saveEntity();
	}else return false;
	}	
	$('.mainHdr a').attr("href","javascript:void(0)");
	
	//$('#SetFormHeight a').attr("href","javascript:void(0)");
	<c:choose>
		<c:when test="${not empty IS_MY_TASK and IS_MY_TASK==false}">
		
			
			$('#commentsDisable *').attr('disabled', true);
			$('#genCerBtn').hide();
			$('#dsc').hide();
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
			$('#birthupload').attr('disabled', true);
			$('#birthdownload').attr('disabled', true);
			$('#zonemapdocupload').attr('disabled', true);
			$('#zonemapdownload').attr('disabled', true);
			$('#zoneMapidProof').attr('disabled', true);
			$('#paymentReceiptidProof').attr('disabled', true);
			   $('#paymentReceiptdocupload').attr('disabled', true);
			     $('#paymentReceiptdownload').attr('disabled', true);
		</c:when>
		<c:when test="${not empty IS_MY_TASK and IS_MY_TASK==true}">
		disableControlsByJquery(true);
		$('#workflowDiv *').removeAttr('disabled');
		$('#dmsDocsCheckListTableId *').removeAttr('disabled');
		$('#uuid').removeAttr('disabled');
		 $('.downloadFile').attr('disabled');
		// $('.downloadFile').attr("onclick", "javascript:void(0)");
		 $('.downloadFile2').attr('disabled');
		// $('.downloadFile2').attr("onclick", "javascript:void(0)");
		 $('.downloadFile1').removeAttr('disabled');
		 $('.downloadFile1').removeClass("not-active");
		 $('.downloadFile3').removeAttr('disabled');
		 $('.downloadFile3').removeClass("not-active");
		 <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
		 $('#idProof').removeAttr('disabled'); 
			$('.clsButtonUpload').removeAttr('disabled');
			</c:if>
		</c:when>
		<c:when test="${not empty PROCESS_ENDED and PROCESS_ENDED == true}">
		disableControlsByJquery(true);
		$('.downloadFile').attr('disabled');
		$('.downloadFile').attr("onclick", "javascript:void(0)");
		$('.downloadFile1').removeAttr('disabled');
		 $('.downloadFile1').removeClass("not-active");
		 $('.downloadFile3').removeAttr('disabled');
		 $('.downloadFile3').removeClass("not-active");
		 $('.downloadFile2').attr('disabled');
		 $('.downloadFile2').attr("onclick", "javascript:void(0)");
		 $('#uuid').removeAttr('disabled');
		//$('#SetFormHeight a').attr("onclick", "javascript:void(0)");
		//$('.mainHdr a').attr("onclick", "javascript:void(0)");
		</c:when>

		</c:choose>
		
		 $('.downloadFile1').removeAttr('disabled');
		 $('.downloadFile1').removeClass("not-active");
		 $('.downloadFile3').removeAttr('disabled');
		 $('.downloadFile3').removeClass("not-active");

		 $('.downloadFile').removeAttr('disabled');
		 $('.downloadFile').removeClass("not-active");

		 $('.downloadFile3').removeAttr('disabled');
		 $('.downloadFile3').removeClass("not-active");
		 $('#download1').removeAttr('disabled');
		 $('#download2').removeAttr('disabled');
		 $('#download3').removeAttr('disabled');
		 $('#download4').removeAttr('disabled');
		 $('#download11').removeAttr('disabled');
		 $('#download22').removeAttr('disabled');
		 $('#download33').removeAttr('disabled');
		 $('#download44').removeAttr('disabled');
		 $('#uploadCer').removeAttr('disabled');
		 $('#uploadCerBtn1').removeAttr('disabled');
		 $('#uploadCerBtn2').removeAttr('disabled');
		 $('#uploadCerBtn3').removeAttr('disabled');
		 $('#uploadCerBtn').removeAttr('disabled');
		 $('#birthupload').removeAttr('disabled');
		 $('#birthdownload').removeAttr('disabled');
		 $('#zonemapdocupload').removeAttr('disabled');
		 $('#zonemapdownload').removeAttr('disabled');
		 $('#zoneMapidProof').removeAttr('disabled');
	     $('#paymentReceiptidProof').removeAttr('disabled');
	     $('#paymentReceiptdocupload').removeAttr('disabled');
	     $('#paymentReceiptdownload').removeAttr('disabled');

		 var rejected = '${requestScope.rtiApplication.workFlowStatus}';


if(rejected==5){
	
	 var elements = document.getElementsByClassName("tab")[0];
	    elements.innerHTML = "Application has been Rejected".fontcolor("red");
        $('#commentsDisable *').attr('disabled', true);
        $('#CreateWorkflow').attr('disabled', true);
        $('#RejectCreateWorkflow').attr('disabled', true);
        $('#WORKFLOW_COMMENTS').attr('disabled', true);
}

</script>