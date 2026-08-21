<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("DATE_TIME_DB_FORMAT",
			Constants.DATE_TIME_DB_FORMAT);

	pageContext.setAttribute("DATE_TIME_FORMAT",
			WorkflowConstants.WORKFLOW_DATE_FORMAT);

	pageContext.setAttribute("WORKFLOW_PRIORITY",
			WorkflowConstants.WORKFLOW_PRIORITY);
	pageContext.setAttribute("WORKFLOW_PRIORITY_LOW",
			WorkflowConstants.WORKFLOW_PRIORITY_LOW);
	pageContext.setAttribute("WORKFLOW_PRIORITY_LOW_LABEL",
			WorkflowConstants.WORKFLOW_PRIORITY_LOW_LABEL);
	pageContext.setAttribute("WORKFLOW_PRIORITY_MEDIUM",
			WorkflowConstants.WORKFLOW_PRIORITY_MEDIUM);
	pageContext.setAttribute("WORKFLOW_PRIORITY_MEDIUM_LABEL",
			WorkflowConstants.WORKFLOW_PRIORITY_MEDIUM_LABEL);
	pageContext.setAttribute("WORKFLOW_PRIORITY_HIGH",
			WorkflowConstants.WORKFLOW_PRIORITY_HIGH);
	pageContext.setAttribute("WORKFLOW_PRIORITY_HIGH_LABEL",
			WorkflowConstants.WORKFLOW_PRIORITY_HIGH_LABEL);
	pageContext.setAttribute("WORKFLOW_PROCESSDESCRIPTION",
			WorkflowConstants.WORKFLOW_PROCESSDESCRIPTION);
	pageContext.setAttribute("WORKFLOW_TRANSITION",
			WorkflowConstants.WORKFLOW_TRANSITION);
	pageContext.setAttribute("WORKFLOW_NAME",
			WorkflowConstants.WORKFLOW_NAME);
	pageContext.setAttribute("WORKFLOW_ACTION",
			WorkflowConstants.WORKFLOW_ACTION);
	pageContext.setAttribute("WORKFLOW_ACTION_COMPLETE_TASK",
			WorkflowConstants.WORKFLOW_ACTION_COMPLETE_TASK);
	pageContext.setAttribute("WORKFLOW_ACTION_CREATE_PROCESS",
			WorkflowConstants.WORKFLOW_ACTION_CREATE_PROCESS);
	pageContext.setAttribute("TAKE_TASK",
			WorkflowConstants.WORKFLOW_ACTION_TAKE_TASK);
	pageContext.setAttribute("KILL_JOB",
			WorkflowConstants.WORKFLOW_ACTION_KILL_JOB);
	pageContext.setAttribute("END_JOB",
			WorkflowConstants.WORKFLOW_ACTION_KILL_JOB);
	pageContext.setAttribute("WORKFLOW_TRANSISTION",
			WorkflowConstants.WORKFLOW_TRANSISTION);
	pageContext.setAttribute("WORKFLOW_ENTITYNAME",
			WorkflowConstants.WORKFLOW_ENTITYNAME);
	pageContext.setAttribute("WORKFLOW_ENTITYID",
			WorkflowConstants.WORKFLOW_ENTITYID);
	pageContext.setAttribute("WORKFLOW_JOB_ID",
			WorkflowConstants.WORKFLOW_JOB_ID);
	pageContext.setAttribute("WORKFLOW_TASK_ID",
			WorkflowConstants.WORKFLOW_TASK_ID);
	pageContext.setAttribute("WORKFLOW_COMMENTS",
			WorkflowConstants.WORKFLOW_COMMENTS);
	pageContext.setAttribute("WORKFLOW_DUE_DATE",
			WorkflowConstants.WORKFLOW_DUE_DATE);

	pageContext.setAttribute("APPL_STATUS_CLOSED",
			CoreConstants.APPL_STATUS_CLOSED);
	pageContext.setAttribute("APPL_STATUS_NEW",
			CoreConstants.APPL_STATUS_NEW);
	pageContext.setAttribute("APPL_STATUS_PARKED",
			CoreConstants.APPL_STATUS_PARKED);
	pageContext.setAttribute("APPL_STATUS_APPROVED",
			CoreConstants.APPL_STATUS_APPROVED);
	pageContext.setAttribute("APPL_STATUS_VERIFICATION",
			CoreConstants.APPL_STATUS_VERIFICATION);
	pageContext.setAttribute("APPL_STATUS_CREATE",
			CoreConstants.APPL_STATUS_CREATE);

	pageContext.setAttribute("APPLICATION_STATUS_LIST",
			CommonUtils.getApplicationStatusList());
%>


<script type="text/javascript"
	src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.ajaxfileupload.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script type="text/javascript">
	function editRTIApplicationdog() {
		document.getElementById('rtiApplicationId').value = id;
		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/editLayoutOfBuilding.do');
	}

	function saveLayoutOfBuildingCertificates() {

		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveLayoutCertificates.do');
	}

	function rtiApplicationSearch() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/listRTIApplicationReports.do');
	}

	function viewNoting() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/viewNoting.do');
	}

	function viewDrafts() {
		//document.getElementById('manageRTIApplicationId').value=id;
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/viewDrafts.do');
	}

	function downloadRTIApplicationList() {
		//document.getElementById('manageRTIApplicationId').value=id;
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/downloadRTIApplicationList.do');
	}

	function listRTIApplicationReports() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/listRTIApplicationReports.do');
	}

	function sendEmail() {
		//document.getElementById('manageRTIApplicationId').value=id;
		document.getElementById('actionTaken').value = 'email';
		onPageSubmit('<c:out value="${contextRoot}"/>/emailsms/emailSMS.do');
	}

	function sendSMS() {
		//document.getElementById('manageRTIApplicationId').value=id;
		document.getElementById('actionTaken').value = 'sms';
		onPageSubmit('<c:out value="${contextRoot}"/>/emailsms/emailSMS.do');
	}
</script>
<style type="text/css">
input[type=text] {
	height: 35px;
	font-size: 15px;
}

.ClsButton[type=button] {
	background-color:  rgb(66, 124, 212);
	border: none;
	border-radius: 5px;
	min-height: 30px;
	min-width: 120px;
	
}

 .ClsButton:hover {
	background: rgb(83, 83, 212);
	 color:white;
}
a {
  text-decoration: none !important;
 
}

</style>
<form>
	<div class="container">
		<h3 style="font-size: 18px; font-weight: bold;">

			<fmt:message key="Application form for Layout Of Building" />
			:
			<c:if test="${requestScope.rtiApplication != null}">
				<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
			</c:if>


		</h3>
	</div>
	<div valign="top" id="SetFormHeight">
	<input type="hidden" name="id"
		value="${layoutOfBuilding.layoutRegistrationId}">
		<table width="100%" border="0" cellpadding="2" cellspacing="2"
			class="container">
			<tr>
			<tr>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="First Name" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 180px;" id="ownerName" maxlength="50"
					name="ownerName"
					value="<c:out value="${layoutOfBuilding.firstName}"/>" /></td>

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Middle Name" />:</span><span class="ClsRequiredFields"></span></td>
				<td><input type="text" class="form-control"
					style="width: 180px" id="ownerName" maxlength="50" name="ownerName"
					value="<c:out value="${layoutOfBuilding.middleName}"/>" /></td>

				</td>
			</tr>
				<tr>
			<td><span
				class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Last Name" />:</span></td>
			<td><input type="text" class="form-control" style="width: 180px;"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${layoutOfBuilding.lastName}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Full Name" />:</span><span class="ClsRequiredFields"></span></td>
			<td>
<input type="text" class="form-control" style="width: 200px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${layoutOfBuilding.fullName}"/>" />
			</td>
		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Address For Correspondance" />:</span></td>
<td><textarea class="form-control" style="width: 350px;"
					id="ownerAddress" maxlength="200" name="ownerAddress" rows="2">${layoutOfBuilding.fullAddress}</textarea>

			</td>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Email Id" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 350px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${layoutOfBuilding.emailId}"/>" /></td>

		</tr>
		
				<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Mobile No" />:</span></td>
			<td><input type="text" class="form-control" style="width: 130px"             
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${layoutOfBuilding.mobileNo}"/>"/>
				</td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Aadhaar No" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 150px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${layoutOfBuilding.aadhaarNo}"/>" /></td>

		</tr>
			<tr>

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Owner Name" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 230px" id="changedHospitalNameAndAddress"
					maxlength="30" name="changedHospitalNameAndAddress"
					value="<c:out value="${layoutOfBuilding.ownerName}"/>" /></td>

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Plot No" /><span class="ClsRequiredFields"></span>: </td>
				<td><input type="text" class="form-control"
					style="width: 150px" id="ownerName" maxlength="50" name="ownerName"
					value="<c:out value="${layoutOfBuilding.plotNo}"/>" /></td>

			</tr>
			<tr>

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Revenue No" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 100px" id="changedHospitalNameAndAddress"
					maxlength="30" name="changedHospitalNameAndAddress"
					value="<c:out value="${layoutOfBuilding.revenueNo}"/>" /></td>

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Survey No" /><span class="ClsRequiredFields"></span>: </td>
				<td><input type="text" class="form-control"
					style="width: 100px" id="ownerName" maxlength="50" name="ownerName"
					value="<c:out value="${layoutOfBuilding.surveyNo}"/>" /></td>

			</tr>
			<tr>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Gat No" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 180px" id="ownerName" maxlength="50" name="ownerName"
					value="<c:out value="${layoutOfBuilding.gatNo}"/>" /></td>

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Khasara No" />:</span><span class="ClsRequiredFields"></span></td>
				<td><input type="text" class="form-control"
					style="width: 100px" id="ownerName" maxlength="50" name="ownerName"
					value="<c:out value="${layoutOfBuilding.khasaraNo}"/>" /></td>

				</td>
			</tr>
			<tr>

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Final Plot No" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 100px" id="changedHospitalNameAndAddress"
					maxlength="30" name="changedHospitalNameAndAddress"
					value="<c:out value="${layoutOfBuilding.finalPlotNo}"/>" /></td>

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Mouje" /><span class="ClsRequiredFields"></span>: </td>
				<td><input type="text" class="form-control"
					style="width: 100px" id="ownerName" maxlength="50" name="ownerName"
					value="<c:out value="${layoutOfBuilding.mouje}"/>" /></td>

			</tr>
			<tr>

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Road/Street" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 180px" id="changedHospitalNameAndAddress"
					maxlength="30" name="changedHospitalNameAndAddress"
					value="<c:out value="${layoutOfBuilding.road}"/>" /></td>

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Society" /><span class="ClsRequiredFields"></span>: </td>
				<td><input type="text" class="form-control"
					style="width: 180px" id="ownerName" maxlength="50" name="ownerName"
					value="<c:out value="${layoutOfBuilding.society}"/>" /></td>

			</tr>

			<tr>

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="License No" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 180px" id="changedHospitalNameAndAddress"
					maxlength="30" name="changedHospitalNameAndAddress"
					value="<c:out value="${layoutOfBuilding.licenseNo}"/>" /></td>

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Address Of Owner" /><span class="ClsRequiredFields"></span>:
				</td>
				<td><textarea class="form-control" style="width: 350px;"
						id="ownerAddress" maxlength="200" name="ownerAddress" rows="2">${layoutOfBuilding.addressOfOwner}</textarea>
			</tr>
		</table>
		<table>
			<tr>
				<td colspan="5"><span class="ClsLabel"
					style="font-size: 15px; font-weight: bold;"><fmt:message
							key="List of Documents (Attachment) For Layout Of Building" />:</span></td>
							
							<tr>
			<td style="width: 300px;height: 30px"><span class="ClsLabel" style="font-size: 14px;"><fmt:message
						key=" Signature of Owner" />:</span></td>

  <c:set var="doc" value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
<td> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[0]}"/>"><span style="margin-left:20px;">Download</span></a>		
	</td>					</tr>
			<tr>
				<td style="width: 300px; height: 30px"><span class="ClsLabel"
					style="font-size: 14px;"><fmt:message
							key="Site Plan showing the
								Surrounding Land" />:</span></td>

						
<td> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[1]}"/>"><span style="margin-left:20px;">Download</span></a>		
	</td>			
			<tr>
			<tr>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Building Plan,Sections
								and Elevations" />:</span></td>
<td> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[2]}"/>"><span style="margin-left:20px;">Download</span></a>		
	</td>	
			</tr>
			<tr>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Copy of Sanctioned
								Layout Plan(if any)" />:</span></td>
				<td> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[3]}"/>"><span style="margin-left:20px;">Download</span></a>		
	</td>	
			<tr>
				<tr>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Latest Property Tax
								Reciept" />:</span></td>				                 
			<td> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[4]}"/>"><span style="margin-left:20px;">Download</span></a>		
	</td>	
		 
		
			<tr>
			<tr>
				<tr>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Key Plan" />:</span></td>                 
			<td> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[5]}"/>"><span style="margin-left:20px;">Download</span></a>		
	</td>	
		 
		
			<tr>
			<tr>
				<tr>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Affidavit" />:</span></td>                 
			<td> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[6]}"/>"><span style="margin-left:20px;">Download</span></a>		
	</td>	
		 
		
			<tr>
			<tr>
				<tr>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key=" No Objection Certificate" />:</span></td>                 
			<td> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[7]}"/>"><span style="margin-left:20px;">Download</span></a>		
	</td>	
		 
		
			<tr>
     <td><span class="ClsLabel" style="font-size: 14px">
						Current Status:</span></td>
				<td style="width: 230px; height: 30px"><span class="ClsLabel"
					style="font-size: 14px"> <c:if
							test="${requestScope.rtiApplication.workFlowStatus==0}">
						Citizen Form Submitted. 
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
						Citizen Payment Pending. 
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
						Citizen Payment Completed
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						Completed and File Uploaded for Citizen
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						Rejected
					</c:if></span></td>
				<td><span class="ClsLabel" style="font-size: 14px">Certificate
						Upload: </span></td>
				<%@include file="/pages/common-pages/dms/fileUpload.jsp"%>
			</tr>
			
			<tr>
			<td colspan="6" style="padding-top: 5px"><img
					src="../images/Transpx.gif" height="15px" /></td>
		</tr>
		
		<!--		<tr>
			<td colspan="6" align="center"><input type="button"
				class="ClsButton" id="save" name="save" value="Save"
				onclick="javascript:savemTPRegistrationCertificate(this.form);"
				tabindex="31"> <input type="button" class="ClsButton"
				id="clear" name="clear"
				value="<fmt:message key="common.button.clear"/>"
				onclick="javascript:clearFields('SearchTable');searchRTIApplication()" />
	

	<input type="hidden" class="ClsTextbox_mr" style="width: 180px"
		id="mtpId" maxlength="12" name="mtpId"
		value="<c:out value="${mTPRegistrationCertificate.mtpId}"/>" /> <input
		type="hidden" class="ClsTextbox_mr" style="width: 180px"
		id="rtiApplicationRefId" maxlength="12" name="rtiApplicationRefId"
		value="<c:out value="${mTPRegistrationCertificate.mtpId}"/>" />
		
<input type="hidden" class="ClsTextbox" style="width:180px" id="rtiapplrefno" maxlength="12" name="rtiapplrefno" value="<c:out value="${treeTrimming.rtiapplrefno}"/>" />-->
      </table>
      <br>
   </div>
    
                                          
     <%@include file="/pages/workflow/taskInclude.jsp"%>
</div>

<script type="text/javascript">
function saveEntity()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createLayoutOfBuildingWork.do'); 
}


</script>
