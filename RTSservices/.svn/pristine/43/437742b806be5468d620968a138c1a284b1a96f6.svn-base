<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>

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
		//document.getElementById('rtiApplicationId').value = id;
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplicationdog.do');
	}

	function savenoDuesCertificate() {

		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveNoDuesCertificate.do');
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
	width: 290px;
	box-sizing: border-box;
	border: 1px solid black;
	box-shadow: 0 0 5px;
	border-radius: 30px;
}
</style>
<div class="mainHdr">
	<h3>
		<fmt:message key="Application for No Dues Certificate" />
	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<table width="98%" border="0" cellpadding="2" cellspacing="2"
		class="dataForm">
		<tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Full name of property holder as per document" />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 180px"
				id="propertyHolderName" maxlength="50" name="propertyHolderName"
				value="<c:out value="${noDuesCertificate.propertyHolderName}"/>" /></td>


			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="PLot No." />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 180px"
				id="plotNo" maxlength="50" name="plotNo"
				value="<c:out value="${noDuesCertificate.plotNo}"/>" /></td>

		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Name of the Building" />:</span></td>
			<td><textarea class="ClsTextbox" style="width: 170px"
					id="buildingName" maxlength="30" name="buildingName">${noDuesCertificate.buildingName}</textarea>
				&nbsp;</td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Street Name" /></span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="ClsTextbox" style="width: 180px"
				id="streetName" maxlength="50" name="streetName"
				value="<c:out value="${noDuesCertificate.streetName}"/>" /> &nbsp;</td>
		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Name of the area" />:</span></td>
			<td><textarea class="ClsTextbox" style="width: 170px"
					id="areaName" maxlength="30" name="areaName">${noDuesCertificate.areaName}</textarea>
				&nbsp;</td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Pincode" /></span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="ClsTextbox" style="width: 180px"
				id="pincode" maxlength="50" name="pincode"
				value="<c:out value="${noDuesCertificate.pincode}"/>" /> &nbsp;</td>
		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Landmark" />:</span></td>
			<td><textarea class="ClsTextbox" style="width: 170px"
					id="landmark" maxlength="30" name="landmark">${noDuesCertificate.landmark}</textarea>
				&nbsp;</td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Part Name" /></span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="ClsTextbox" style="width: 180px"
				id="partName" maxlength="50" name="partName"
				value="<c:out value="${noDuesCertificate.partName}"/>" /> &nbsp;</td>
		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="geoLocation" />:</span></td>
			<td><textarea class="ClsTextbox" style="width: 170px"
					id="geoLocation" maxlength="30" name="geoLocation">${noDuesCertificate.geoLocation}</textarea>
				&nbsp;</td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="City Survey Number" /></span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="ClsTextbox" style="width: 180px"
				id="citySurveyNumber" maxlength="50" name="citySurveyNumber"
				value="<c:out value="${noDuesCertificate.citySurveyNumber}"/>" />
				&nbsp;</td>
		</tr>

		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="mobileNumber" /></span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="ClsTextbox" id="mobileNumber"
				style="width: 180px" name="mobileNumber" pattern="[0-9]{9}"
				value="<c:out value="${noDuesCertificate.mobileNumber}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Email" />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 170px"
				id="email" maxlength="30" name="email"
				value="<c:out value="${noDuesCertificate.email}"/>" /> &nbsp;</td>
		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Tap Account Number" />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 170px"
				id="tapAccountNumber" maxlength="30" name="tapAccountNumber"
				value="<c:out value="${noDuesCertificate.tapAccountNumber}"/>" />
				&nbsp;</td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Electric Meter Number" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="ClsTextbox" style="width: 170px"
				id="electricMeterNumber" maxlength="30" name="electricMeterNumber"
				value="<c:out value="${noDuesCertificate.electricMeterNumber}"/>" />
				&nbsp;</td>

		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Zonal Office" /><span class="ClsRequiredFields"></span>: </td>
			<td><select name="zonalOffice" class="ClsTextbox"
				style="width: 180px">
					<option value="zone1">Zone 1</option>
					<option value="zone2">zone 2</option>
					<option value="zone3">zone 3</option>
			</select></td>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="No Dues Reason" /><span class="ClsRequiredFields"></span>: </td>
			<td><select name="noDuesReason" class="ClsTextbox"
				style="width: 180px">
					<option value="reason1">reason 1</option>
					<option value="reason2">reason 2</option>
					<option value="reason2">reason 3</option>
			</select></td>
		</tr>
<tr>
     <td><span class="ClsLabel" style="font-size:14px"> Current Status:</span></td>
     <td> <span class="ClsLabel" style="font-size:14px">
     <c:if test="${requestScope.rtiApplication.workFlowStatus==0}">
						Citizen Form Submitted. 
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
						Citizen Payment Pending. 
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
						Citizen Payment Received
					</c:if>
											
					<c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						Certificate Issued to Citizen.
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						Rejected
					</c:if></span>
     </td>      
     <td><span class="ClsLabel" style="font-size:14px">Certificate Upload: </span> </td>
     <%@include file="/pages/common-pages/dms/fileUpload.jsp"%>    
     </tr>
		<tr>
			<td colspan="6" style="padding-top: 5px"><img
				src="../images/Transpx.gif" height="15px" /></td>
		</tr>
		<tr>
			<td colspan="6" align="center"><input type="button"
				class="ClsButton" id="save" name="save" value="Save"
				onclick="javascript:savenoDuesCertificate(this.form);" tabindex="31">
				<input type="button" class="ClsButton" id="clear" name="clear"
				value="<fmt:message key="common.button.clear"/>"
				onclick="javascript:clearFields('SearchTable');searchRTIApplication()" />
	

	<input type="hidden" class="ClsTextbox_mr" style="width: 180px"
		id="ndcId" maxlength="12" name="ndcId"
		value="<c:out value="${noDuesCertificate.ndcId}"/>" /> 
		<input type="hidden" class="ClsTextbox" style="width:180px" id="rtiapplrefno" maxlength="12" name="rtiapplrefno" value="<c:out value="${treeTrimming.rtiapplrefno}"/>" />
                       
        

      </table>
  
    

     <%@include file="/pages/workflow/taskInclude.jsp"%>
</div>

<script type="text/javascript">
function saveEntity()
{
	savebiologicalWasteDisposalCertificate(this.form);
}


</script>
