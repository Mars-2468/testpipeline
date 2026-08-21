<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.mars.common.utils.SessionUser"%>
<%@ page import="com.mars.common.model.User"%>
<jsp:directive.include file="/pages/common/include.jsp" />


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

pageContext.setAttribute("LABEL_RADIO_COMMERICAL", CoreConstants.LABEL_RADIO_COMMERICAL);
pageContext.setAttribute("LABEL_RADIO_CHARITABLE", CoreConstants.LABEL_RADIO_CHARITABLE);
pageContext.setAttribute("LABEL_RADIO_GOVERNMENT", CoreConstants.LABEL_RADIO_GOVERNMENT);

pageContext.setAttribute("RADIO_COMMERICAL", CoreConstants.RADIO_COMMERICAL);
pageContext.setAttribute("RADIO_CHARITABLE", CoreConstants.RADIO_CHARITABLE);
pageContext.setAttribute("RADIO_GOVERNMENT", CoreConstants.RADIO_GOVERNMENT);
%>
<%
HttpSession session1 = request.getSession();
SessionUser sessionUser = (SessionUser) session1.getAttribute("SessionUser");
Long userId = sessionUser.getUserId();
request.setAttribute("userId", userId);
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
		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/editWaterQualityComplaint.do');
	}

	function saveMandapCertificates() {

		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveWaterQualityComplaint.do');
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

	function download(id, url) {

		document.getElementById('rtiApplicationRefId').value = id;

		alert("Certificate has been generated successfully.");

		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'
				+ url);

	}
</script>
<style type="text/css">
input[type=text] {
	height: 35px;
	font-size: 15px;
}

.ClsButton {
	background-color: rgb(66, 124, 212);
	border: none;
	border-radius: 5px;
	min-height: 30px;
	min-width: 120px;
}

.ClsButton:hover {
	background: rgb(83, 83, 212);
	color: white;
}

a {
	text-decoration: none !important;
}
</style>

</style>
<div class="container">
	<h3 style="font-size: 18px; font-weight: bold;">

		<fmt:message key="Application Form For Water Quality Complaint" />
		:
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>


	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<input type="hidden" name="id"
		value="${waterQualityComplaint.newWaterQualityComplaintId}">
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		<tr>
		<c:if test="${not empty waterQualityComplaint.CINNo}">

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="label.waterquality.cin" /><span class="ClsRequiredFields"></span>:
				</td>
				<td><input type="text" class="form-control"
					style="width: 300px" id="changedHospitalNameAndAddress"
					maxlength="30" name="changedHospitalNameAndAddress"
					value="<c:out value="${waterQualityComplaint.CINNo}"/>" /></td>
			</c:if>
		
			<c:if test="${not empty waterQualityComplaint.zoneNo}">

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="label.waterquality.zone" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 300px" id="ownerName" maxlength="50" name="ownerName"
					value="<c:out value="${waterQualityComplaint.zoneNo}"/>" /></td>
			</c:if>
			</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterquality.consumerName" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterQualityComplaint.consumerName}"/>" /></td>

<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterquality.consumerAddress" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterQualityComplaint.exitingAddress}"/>" /></td>
	
		</tr>
		<tr>
			<c:if test="${not empty waterQualityComplaint.esr}">

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="ESR" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 300px" id="ownerName" maxlength="50" name="ownerName"
					value="<c:out value="${waterQualityComplaint.esr}"/>" /></td>
			</c:if>
			<c:if test="${not empty waterQualityComplaint.existingEsr}">
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="ESR" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 300px" id="ownerName" maxlength="50" name="ownerName"
					value="<c:out value="${waterQualityComplaint.existingEsr}"/>" /></td>

			</c:if>

				<!-- </tr>
		<tr>


			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="label.waterquality.consumerNo" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 300px" id="ownerName" maxlength="50" name="ownerName"
					value="<c:out value="${waterQualityComplaint.consumerNo}"/>" /></td> 
		
		-->
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterquality.meterNo" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterQualityComplaint.meterNo}"/>" /></td>
		</tr>
		
		<tr>

<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.waterDisconnection.meterTapSize" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
	id="ownerName" maxlength="50" name="ownerName"
	value="<c:out value="${waterQualityComplaint.tap_size}"/>" /></td>


<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.category" /><span
		class="ClsRequiredFields"></span>: </td>
<td><input type="text" class="form-control" style="width: 300px"
	id="ownerName" maxlength="50" name="ownerName"
	value="<c:out value="${waterQualityComplaint.category}"/>" /></td>


</tr>
<tr>

<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.waterDisconnection.balance_arrears" />:</span></td>

			<td><input type="text" class="form-control" style="width: 300px"
	id="ownerName" maxlength="50" name="ownerName"
	value="<c:out value="${waterQualityComplaint.balance_arrears}"/>" /></td>


<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.cut_off_date" /><span
		class="ClsRequiredFields"></span>: </td>
<td><input type="text" class="form-control" style="width: 300px"
	id="ownerName" maxlength="50" name="ownerName"
	value="<c:out value="${waterQualityComplaint.cut_off_date}"/>" /></td>


</tr>
		<tr>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterquality.email" /><span class="ClsRequiredFields"></span>:</td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterQualityComplaint.email}"/>" /></td>

		
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterquality.mobileNo" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="label.waterquality.consumer" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${waterQualityComplaint.mobileNo}"/>" /></td>
				</tr>
				
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterquality.title" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 300px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterQualityComplaint.title}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.name" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterQualityComplaint.firstName}"/>" /></td>

		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.fathername" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 300px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterQualityComplaint.middleName}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.surnname" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterQualityComplaint.lastName}"/>" /></td>
		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterquality.fullName" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterQualityComplaint.fullName}"/>" /></td>

			<!--  <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterquality.flatNo" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterQualityComplaint.plotNo}"/>" /></td>

		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterquality.buildingName" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${waterQualityComplaint.buildingName}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterquality.streetname" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterQualityComplaint.streetName}"/>" /></td>

		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterquality.areaname" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${waterQualityComplaint.areaName}"/>" /></td>-->

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterquality.address" />:</span></td>
			<td><textarea class="form-control" style="width: 300px"
					id="ownerAddress" maxlength="200" rows="2" name="ownerAddress">${waterQualityComplaint.fullAddress}</textarea></td>

		</tr>
		<!--  <tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterquality.landmark" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${waterQualityComplaint.landmark}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterquality.pincode" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${waterQualityComplaint.pinCode}"/>" /></td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterquality.aadhaar" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${waterQualityComplaint.aadhaarNo}"/>" /></td>

		
			

			<!-- <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterquality.receiptNo" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterQualityComplaint.dreceiptNo}"/>" /></td>

	<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.city" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterQualityComplaint.applicantcity}"/>" /></td>
		</tr>-->


		<tr>
						<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterMeterComplaint.problemDesc" />:</span></td>
			<td><textarea class="form-control" style="width: 300px"
					id="ownerAddress" maxlength="200" rows="2" name="ownerAddress">${waterQualityComplaint.problem}</textarea></td>

		
			 <td><span class="ClsLabel" style="font-size:14px"> Current Status:</span></td>
     <td> <span class="ClsLabel" style="font-size:14px">
     <c:if test="${requestScope.rtiApplication.workFlowStatus==0}">
						Citizen Form Submitted. 
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
						Citizen Payment Pending.
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
						Citizen Payment Completed.
					</c:if>
											
					<c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						Completed and File Uploaded for Citizen
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						Rejected
					</c:if></span>
        
  </td>   
		</tr>
	</table>
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		<!-- <tr>
			<td colspan="5"><span class="ClsLabel"
				style="font-size: 15px; font-weight: bold;"><fmt:message
						key="List of Documents (Attachment) For Water Quality Complaint" />:</span></td>
			<c:set var="doc"
				value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
			<c:if test="${doc[0] != 'null'}">

				<tr>
					<td style="width: 600px; height: 30px"><span class="ClsLabel"
						style="font-size: 14px;"><fmt:message
								key="label.waterquality.idproofdoc" />:</span></td>

					<td style="text-align: center"><a class="ClsButton"
						type="button" target="_blank" href="<c:out value="${doc[0]}"/>"><span
							style="align-items: center">Download</span></a></td>
				</tr>
			</c:if>
			<c:if test="${doc[1] != 'null'}">

				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="label.waterquality.currentBilldoc" />:</span></td>
					<td style="text-align: center"><a class="ClsButton"
						type="button" target="_blank" href="<c:out value="${doc[1]}"/>"><span
							style="align-items: center">Download</span></a></td>

				</tr>
			</c:if>
			<c:if test="${doc[2] != 'null'}">

				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="label.waterquality.demandpaiddoc" />:</span></td>
					<td style="text-align: center"><a class="ClsButton"
						type="button" target="_blank" href="<c:out value="${doc[2]}"/>"><span
							style="align-items: center">Download</span></a></td>

				</tr>
			</c:if>
			<c:if test="${doc[3] != 'null'}">

				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="label.waterquality.addressdoc" />:</span></td>
					<td style="text-align: center"><a class="ClsButton"
						type="button" target="_blank" href="<c:out value="${doc[3]}"/>"><span
							style="align-items: center">Download</span></a></td>

				</tr>
			</c:if>
			<c:if test="${doc[4] != 'null'}">

				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="label.waterquality.signaturedoc" />:</span></td>
					<td style="text-align: center"><a class="ClsButton"
						type="button" target="_blank" href="<c:out value="${doc[4]}"/>"><span
							style="align-items: center">Download</span></a></td>

				</tr>
			</c:if>-->
		<!-- Add on -->
		
		
		<tr>	
	    <td>
                           <span class="ClsLabel" style="font-size:14px;width: 400px"><fmt:message key="Fees for the Request" />:</span>
                        </td>
                         <c:choose>
        <c:when test="${userId == 3950 || userId == 4150 || userId == 4151 || userId == 4152 || userId == 4153 || userId == 4154 || userId == 4155 || userId ==4156 || userId == 4157 || userId == 4158 || userId == 1 || userId == 4550}">
        
                           <td>
                            <input type="number" class="form-control" id="feesApplicable" maxlength="5"  style="width:200px" name="demandfees" value="<c:out value="${waterQualityComplaint.demandfees}"/>" oninput="validateInput(this);"/>
                          </td>
     	 </c:when>
        <c:otherwise>
            <td>
                            <!-- <input type="number" class="form-control" id="feesApplicable" maxlength="5" style="margin-left: 192px;width:200px" name="demandfees" readonly value="<c:out value="${waterDisconnection.demandfees}"/>"/>-->
                            <input type="number" class="form-control" id="feesApplicable" maxlength="5" style="width:200px" name="demandfees" readonly
    value="<c:out value="${waterQualityComplaint.demandfees}"/>"
    oninput="validateInput(this);">
                            
            </td>
        </c:otherwise>
    </c:choose>
</tr>
			

					<!-- Demand Upload old -->
		
   	<tr>
	    <td colspan="1" style="width:555px;">
        <span class="" style="font-size: 14px">
            <fmt:message key="Upload Demand" />:
        </span>
    </td>
    <c:choose>
        <c:when test="${empty waterQualityComplaint.uploadedDemand}">
            <c:if test="${userId == 3950 || userId == 4150 || userId == 4151 || userId == 4152 || userId == 4153 || userId == 4154 || userId == 4155 || userId == 4156 || userId == 4157 || userId == 4158 || userId == 1 || userId == 4550}">
                <td>
                    <input type="file" name="demanddoc" id="demanddoc" style="width: 220px" />
               
                    <input type="button" class="ClsButton clsButtonUpload" id="demandUpload" name="demandUpload" value="Upload" onclick="uploadPoliceNoc1();">
                </td>
            </c:if>
        </c:when>
        <c:otherwise>
            <c:if test="${not empty waterQualityComplaint.uploadedDemand}">
                <td>
                    <a target="_blank" href="<c:out value='${waterQualityComplaint.uploadedDemand}'/>" id="uploadCer">
                        <input type="button" class="ClsButton clsButtonUpload" id="demanddownload" name="demanddownload" class="imagefile" value="Download">
                    </a>
                </td>
            </c:if>
        </c:otherwise>
    </c:choose>
</tr>
   	
<c:if test="${(requestScope.rtiApplication.workFlowStatus == 3 || requestScope.rtiApplication.workFlowStatus == 2 || requestScope.rtiApplication.workFlowStatus == 1 || requestScope.rtiApplication.workFlowStatus == 5) && (userId == 3950 || userId == 4150 || userId == 4151 || userId == 4152 || userId == 4153 || userId == 4154 || userId == 4155 || userId == 4156 || userId == 4157 || userId == 4158 || userId == 1 || userId == 4550)}">
    <tr style="height: 60px;">
        <td colspan="7" style="background-color: white; background-color: #e0e0e0;">
            <span class="ClsLabel" style="font-size: 14px">
                <fmt:message key="Payment Status:" />
            </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            <label for="payment" class="ClsLabel" style="font-size: 12px;">
                &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
               <input type="checkbox" class="form-check-input" id="payment"
       style="width: 20px; height: 20px; margin-top: -2px;"
       name="paymentStatus" value="Paid"
       <c:if test="${waterQualityComplaint.paymentStatus=='Paid'}">checked="checked" disabled="true"</c:if> />
       


                &nbsp;&nbsp;&nbsp; Paid&nbsp;&nbsp;&nbsp;
            </label>
        </td>
    </tr>
</c:if>





		<!-- acknowledgement upload -->
		<c:if test="${(requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus == 1 || requestScope.rtiApplication.workFlowStatus == 5) && (userId == 3950 || userId == 4150 || userId == 4151 || userId == 4152 || userId == 4153 || userId == 4154 || userId == 4155 || userId ==4156 || userId == 4157 || userId == 4158 || userId == 1 || userId == 4550 )}">
		
			<tr>
    <td colspan="1">
        <span class="" style="font-size: 14px">
            <fmt:message key="Acknowledgement Report" />:
        </span>
    </td>
    <c:choose>
        <c:when test="${empty waterQualityComplaint.acknowledgement}">
        		<c:if test="${(requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus == 1 || requestScope.rtiApplication.workFlowStatus == 5) && (userId == 3950 || userId == 4150 || userId == 4151 || userId == 4152 || userId == 4153 || userId == 4154 || userId == 4155 || userId ==4156 || userId == 4157 || userId == 4158 || userId == 1 || userId == 4550)}">
        
                <td>
                    <input type="file" name="acknowledgementdoc" id="acknowledgementdoc" style="width: 220px" />
                
                    <input type="button" class="ClsButton clsButtonUpload" id="acknowledgementUpload" name="acknowledgementUpload" value="Upload" onclick="uploadFireNoc();">
                </td>
                         </c:if>
                
        </c:when>
        <c:otherwise>
            <c:if test="${not empty waterQualityComplaint.acknowledgement}">
            <td>
                    <a target="_blank" href="<c:out value='${waterQualityComplaint.acknowledgement}'/>" id="uploadCer">
                        <input type="button" class="ClsButton clsButtonUpload" id="acknowledgementdownload" name="acknowledgementdownload" class="imagefile" style="" value="Download">
                    </a>
                </td>
            </c:if>
        </c:otherwise>
    </c:choose>
</tr>           
</c:if>
<c:if test="${(requestScope.rtiApplication.workFlowStatus==3) && (userId == 3950 || userId == 4150 || userId == 4151 || userId == 4152 || userId == 4153 || userId == 4154 || userId == 4155 || userId ==4156 || userId == 4157 || userId == 4158 || userId == 1 || userId == 4550)}">

<tr id="paymentid">
    <td colspan="4" align="center" id="paymentids">
        <input type="button" class="btn btn-primary" style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745; margin-left:50px;" id="savePayment" name="savePayment" value="Save" 
                       onclick="javascript:savePaymentStatus(this.form);"
      disabled="false">
    </td>
</tr>
</c:if>



        <c:if test="${userId == 3950 || userId == 4150 || userId == 4151 || userId == 4152 || userId == 4153 || userId == 4154 || userId == 4155 || userId ==4156 || userId == 4157 || userId == 4158 || userId == 1 || userId == 4550}">

	<tr>
    <td colspan="4" align="center">
        <input type="button"
               class="btn btn-primary"
               style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745;margin-left:50px;"
               id="savefees" name="savefees"
               value="<fmt:message key="Save"/>"
               onclick="javascript:saveFees(this.form);"
               disabled="false">
    </td>
</tr>
</c:if>
		</table>

	<br>

</div>

<input type="hidden" class="ClsTextbox" id="waterQualityComplaintId" style="width: 180px" name="waterQualityComplaintId" value="<c:out value="${waterQualityComplaint.newWaterQualityComplaintId}"/>" />
<input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId"
	value="<c:out value="${requestScope.rtiApplication.rtiApplicationId}"/>" />

				  			  <input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${waterQualityComplaint.rti_ref_id}" />
	
<%@include file="/pages/workflow/taskInclude.jsp"%>

<script type="text/javascript">
function saveEntity()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createWaterQualityComplaintWork.do');
}
	</script>
	
	<script>
    function validateInput(inputElement) {
        // Ensure non-negative values
        if (inputElement.value < 0) {
            inputElement.value = "";
            alert("Please enter a non-negative value.");
        }

        // Limit to four digits
        if (inputElement.value.length > 6) {
            inputElement.value = inputElement.value.slice(0, 5);
            alert("Please enter a value with a maximum of 5 digits.");
        }

        // Ensure non-zero values
        if (inputElement.value == 0) {
            inputElement.value = "";
            alert("Please enter a non-zero value.");
        }
    }
</script>
<script type="text/javascript">
function saveFees() {
	var feeId = $('#feesApplicable');
    var demanddoc = '${waterQualityComplaint.uploadedDemand}';

    if (feeId.val() !== '') {
       if (confirm('Are you sure you want to save?')) {
        var uid = $('#rtiApplicationRefIds').val();
        onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveQualityComplaintWater.do');
        feeId.prop('readonly', true);
        } else {
            return false;
        }
    } else {
        alert("Please save fees.");
        return false;
    }
}

// Attach click event listener to demandUpload button
$('#demandUpload').click(function() {
    // Set a flag to indicate that the button has been clicked
    $(this).prop('clicked', true);
});
</script>

<script>
    function savePaymentStatus() {
        var payment = $('#payment');
       // var acknowledgementdoc = $('#acknowledgementdoc');
       // var acknowledgementUpload = $('#acknowledgementUpload');

        if (payment.prop('checked')) {
            if (confirm('Are you sure you want to save?')) {
				var uid = $('#rtiApplicationRefIds').val();
            
            // Assuming onPageSubmit is a function that handles form submission
            onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveQualityComplaintWaterPayment.do');

            // Disable user interaction with the payment checkbox after saving
            payment.prop('disabled', true);
            payment.prop('readonly', true);
            $("#payment").prop("checked") 
            $("#savePayment").hide();
            } else {
                return false;
            }
        } else {
            alert("Please select the Payment Status");
            return false;

        }
    }
    $('#acknowledgementUpload').click(function() {
        // Set a flag to indicate that the button has been clicked
        $(this).prop('clicked', true);
    });
</script>






<script>
    $(document).ready(function () {
        // Ensure the button is not disabled initially
            var payment = $('#payment').val();
        $("#payment").prop('disabled', false);

        $("#savePayment").prop('disabled', false);
        $("#demanddownload").prop('disabled', false);
        $("#acknowledgementdownload").prop('disabled', false);
        
             


    });
    </script>

    
  

  



<script>

$(document).ready(function () {
    var feeId = $('#feesApplicable').val();
    $("#feesApplicable").prop('disabled', false);

    $("#savefees").prop('disabled', false);

    // If feeId is not empty, disable the button on document ready
    if (feeId !== "") {
        $("#feesApplicable").prop('disabled', true);
        $("#savefees").prop('disabled', true);
        $("#savefees").hide();


    }
    
});

</script>


<script>

$(document).ready(function() {
	  var workflowstatus = "${requestScope.rtiApplication.workFlowStatus}";
	  if (workflowstatus ==5) {
			var elements = document.getElementsByClassName("tab")[0];
		    elements.innerHTML = "RTI Application is Rejected".fontcolor("red");
		    $('#commentsDisable *').attr('disabled', true);
		    $('#CreateWorkflow').attr('disabled', true);
		    $('#RejectCreateWorkflow').attr('disabled', true);
		    $('#WORKFLOW_COMMENTS').attr('disabled', true);

	  }
	});
   
</script>

<script>
$(document).ready(function() {
    var userId = <%= request.getAttribute("userId") %>; // Retrieve userId from JSP attribute
    var feesApplicable = '${waterQualityComplaint.demandfees}';
    var demanddoc = '${waterQualityComplaint.uploadedDemand}';
    var workflowStatus = '${requestScope.rtiApplication.workFlowStatus}';
    var acknowledgementdoc = $('#acknowledgementdoc').val();

    if (userId == 3950 || userId == 1 || userId == 4550 || userId == 4150 || userId == 4151 || userId == 4152 || userId == 4153 || userId == 4154 || userId == 4155 || userId == 4156 || userId == 4157 || userId == 4158 ) {
        // Disable the input box if the condition is met
        $("#demanddoc").prop('disabled', false);
        $("#demandUpload").prop('disabled', false);
        $("#acknowledgementdoc").prop('disabled', false);
        $("#acknowledgementUpload").prop('disabled', false);
    }

    var elements = document.getElementsByClassName("tab")[0];
    
    if (((demanddoc === '' || demanddoc === null )|| (feesApplicable === '' || feesApplicable === null)) && (workflowStatus == 0) && (userId == 3950 || userId == 4150 || userId == 4151 || userId == 4152 || userId == 4153 || userId == 4154 || userId == 4155 || userId == 4156 || userId == 4157 || userId == 4158 || userId == 1 || userId == 4550)) {
        // Case 1
        elements.innerHTML = "Please save fees and upload a demand";
        elements.style.color = "blue";
        $('#commentsDisable *').attr('disabled', true);
        $('#CreateWorkflow').attr('disabled', true);
        $('#RejectCreateWorkflow').attr('disabled', true);
        $('#WORKFLOW_COMMENTS').attr('disabled', true);
    } else if ((demanddoc !== '' && feesApplicable !== '') && (workflowStatus == 0) && (userId== 3153 || userId == 3950 || userId == 4150 || userId == 4151 || userId == 4152 || userId == 4153 || userId == 4154 || userId == 4155 || userId == 4156 || userId == 4157 || userId == 4158 || userId == 4550)) {
        // Case 2
        elements.innerHTML = "Currently you do not have permission to work on this task.";
        elements.style.color = "red"; // You can set a different color here
        $('#commentsDisable *').attr('disabled', true);
        $('#CreateWorkflow').attr('disabled', true);
        $('#RejectCreateWorkflow').attr('disabled', true);
        $('#WORKFLOW_COMMENTS').attr('disabled', true);
    }
});

	</script>
	<script>
	$(document).ready(function() {
	    var userId = <%= request.getAttribute("userId") %>; // Retrieve userId from JSP attribute
	    var feesApplicable = '${waterQualityComplaint.demandfees}';
        var demanddoc = '${waterQualityComplaint.uploadedDemand}';
	    var workflowStatus = '${requestScope.rtiApplication.workFlowStatus}';
	    var acknowledgementdoc = $('#acknowledgementdoc').val();

	    if ((demanddoc === '' || feesApplicable === '') && (workflowStatus == 0 || workflowStatus == 3) && (userId== 3153 || userId == 2500 || userId == 2501 || userId == 2502 || userId == 2503 || userId == 2504 || userId == 2505 || userId == 3150 || userId == 3152 || userId == 3050 || userId == 3151)) {
	        var elements = document.getElementsByClassName("tab")[0];
	        elements.innerHTML = "Currently you do not have permission to work on this task.".fontcolor("red");
	        $('#commentsDisable *').attr('disabled', true);
	        $('#CreateWorkflow').attr('disabled', true);
	        $('#RejectCreateWorkflow').attr('disabled', true);
	        $('#WORKFLOW_COMMENTS').attr('disabled', true);
	    }
	    if ((workflowStatus == 3) && (userId== 3153 || userId == 2500 || userId == 2501 || userId == 2502 || userId == 2503 || userId == 2504 || userId == 2505 || userId == 3150 || userId == 3152 || userId == 3050 || userId == 3151)) {
	        var elements = document.getElementsByClassName("tab")[0];
	        elements.innerHTML = "Currently you do not have permission to work on this task.".fontcolor("red");
	        $('#commentsDisable *').attr('disabled', true);
	        $('#CreateWorkflow').attr('disabled', true);
	        $('#RejectCreateWorkflow').attr('disabled', true);
	        $('#WORKFLOW_COMMENTS').attr('disabled', true);
	    }
	});

	
	$(document).ready(function() {
	    var userId = <%= request.getAttribute("userId") %>; // Retrieve userId from JSP attribute
	    var userId = <%= request.getAttribute("userId") %>; // Retrieve userId from JSP attribute
	    var feesApplicable = '${waterQualityComplaint.demandfees}';
	    var workflowStatus = '${requestScope.rtiApplication.workFlowStatus}';
        var demanddoc = '${waterQualityComplaint.uploadedDemand}';
        var acknowledgementdoc = '${waterQualityComplaint.acknowledgement}';

       
	});
	</script>
	
	

	

	<script type="text/javascript">
	
    function uploadPoliceNoc1() {
        console.log("@@upoading@@");
        var url = window.location.href;
        var basePath = url.split('${contextRoot}')[0] + '${contextRoot}/';
        var filesPath = "";
        var data = new FormData();
        var idProofFile = $("#demanddoc").get(0).files[0];
        

        if (!idProofFile) {
            alert("Please upload the Demand.");
            return; 
        }
        
        var fileName = idProofFile.name;
        var fileExtension = fileName.split('.').pop().toLowerCase();

        if (fileExtension !== 'pdf') {
            alert("Please select a PDF file.");
            return;
        }
        
        data.append('idProof1', $("#demanddoc").get(0).files[0]);


        var isFileSelected = false

        var array_element = "";
        var file = $('input[id="demanddoc"]');
        for (var i = 0; i < file.length; i++) {
   			var array_element = file[i];
   			var element = array_element.value.split("\\");
   			var a = element[element.length-1];
   			const splitName = a.split(".pdf")[0].replaceAll(/[^a-zA-Z0-9]/g, ""); 
   			const value = splitName + ".pdf";
   			 if(a==='' || a===undefined){
   		        filesPath += "null" + ",";
   	             isFileSelected = false;
            } else {
                filesPath = filesPath + basePath + "WaterQualityComplaint/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 1;
        var uid1 = document.getElementById('waterQualityComplaintId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadManageWaterQualityComplaint.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false 
            }).done(function (data) {
            alert("Demand uploaded Successfully");
            

        });
        alert("Upload has been done successfully!");

        var a = filesPath.substring(0, filesPath.lastIndexOf(","));
        filesPath = filesPath.replace(/\s/g, "");
        $("#filesPath").val(filesPath);
        console.log(filesPath);
        window.location.reload();

    }
    </script>
    
    
    	<script type="text/javascript">
    
    
    function uploadFireNoc() {
        console.log("@@upoading@@");
        var url = window.location.href;
        var basePath = url.split('${contextRoot}')[0] + '${contextRoot}/';
        var filesPath = "";
        var data = new FormData();
        var idProofFile = $("#acknowledgementdoc").get(0).files[0];
        if (!idProofFile) {
            alert("Please upload the Acknowledgement.");
            return; 
        }
        var fileName = idProofFile.name;
        var fileExtension = fileName.split('.').pop().toLowerCase();

        if (fileExtension !== 'pdf') {
            alert("Please select a PDF file.");
            return;
        }
        data.append('idProof2', $("#acknowledgementdoc").get(0).files[0]);


        var isFileSelected = false

        var array_element = "";
        var file = $('input[id="acknowledgementdoc"]');
        for (var i = 0; i < file.length; i++) {
   			var array_element = file[i];
   			var element = array_element.value.split("\\");
   			var a = element[element.length-1];
   			const splitName = a.split(".pdf")[0].replaceAll(/[^a-zA-Z0-9]/g, ""); 
   			const value = splitName + ".pdf";
   			 if(a==='' || a===undefined){
   		        filesPath += "null" + ",";
   	             isFileSelected = false;
            } else {
                filesPath = filesPath + basePath + "WaterQualityComplaint/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 2;
        var uid1 = document.getElementById('waterQualityComplaintId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadManageWaterQualityComplaint.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false 
        }).done(function (data) {
            alert("Acknowledgement uploaded Successfully");

        });
        alert("Upload has been done successfully!");

        var a = filesPath.substring(0, filesPath.lastIndexOf(","));
        filesPath = filesPath.replace(/\s/g, "");
        $("#filesPath").val(filesPath);
        console.log(filesPath);
        window.location.reload();

    }
    </script>




