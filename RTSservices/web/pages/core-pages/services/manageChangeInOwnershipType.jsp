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
pageContext.setAttribute("UPLOAD_PATH", CoreConstants.UPLOAD_PATH);
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
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIManagePermission.do');
	}

	function saveMandapCertificates() {

		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveMandapCertificates.do');
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

@media print{

body *{

visibility: hidden

}

.print-container, .print-container *{
 visibility: visible;
}
}

 #print-target, #print-target * {
        visibility: visible; /* Make the target element and its children visible */
      }

      #print-target {
        position: absolute;
        left: 0;
        top: 0;
      }
@page {
  size: legal landscape; /* Landscape orientation for Legal size */
}
@media print {
  body {
    transform: scale(1.18); /* Adjust the scale factor as needed */
    transform-origin: center center;
  }

  /* Adjust font sizes for better readability */
  .element {
    font-size: 10px; /* Adjust font size as needed */
  }

  /* Reduce padding and margins to fit content */
  .container {
    padding: 5px; /* Adjust padding as needed */
    margin: 0; /* Reset margin to fit content */
  }

  /* Adjust other elements as necessary */
}


@media print {
  /* Prevent the specified element from breaking across pages */
  .element-to-prevent-break {
    page-break-inside: avoid;
  }
}

@media print {
  /* Prevent the specified section from breaking across pages */
  .fav-pagination-buttons {
    page-break-inside: avoid;
  }
}

 @page {
     size: auto ;
     }

input[type="text"], textarea {
	background-color: #e9ecef;
	width: 290px;
	box-sizing: border-box;
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

.form {
	background-color: white;
	background-image: url("D:\nmmc_RTS1\RTI\web\images\flag-bg.jpg");
	background-position: right center;
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

.action {
	width: 100px;
	height: 32px;
}

.generateaction {
	width: 155px;
	height: 32px;
}

.download {
	font-size: 13px;
}
.ClsButton {
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

<div class = "row print-container">
<div class="container">
	<h3 style="font-size: 18px; font-weight: bold;">

		<fmt:message key="Application Form For Change Of Ownership" />
		:
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>


	</h3>
</div>
<div valign="top" id="">
	<input type="hidden" name="id"
		value="${changeInOwnershipType.changeOwnershipID}">
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		<tr>
		<tr>
		<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.cinNo" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.CINNo}"/>" readonly /></td>




			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.zoneNo" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${changeInOwnershipType.zoneNo}"/>" readonly/></td>
</tr>
<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.existingConsumerName" />:</span></td>
			<td><textarea class="form-control" style="width: 300px"
					id="ownerAddress" maxlength="200" rows="2" name="ownerAddress" readonly>${changeInOwnershipType.existingConsumerName}</textarea>
		


			
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.meterNo" /><span
					class="ClsRequiredFields"></span>: </td>

			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.meterNo}"/>" readonly/></td>
</tr><tr>
		

<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.waterDisconnection.meterTapSize" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
	id="ownerName" maxlength="50" name="ownerName"
	value="<c:out value="${changeInOwnershipType.tap_size}"/>" readonly/></td>


<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.category" /><span
		class="ClsRequiredFields"></span>: </td>
<td><input type="text" class="form-control" style="width: 300px"
	id="ownerName" maxlength="50" name="ownerName"
	value="<c:out value="${changeInOwnershipType.category}"/>" readonly/></td>
</tr>
		<tr>



<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.waterDisconnection.balance_arrears" />:</span></td>

			<td><input type="text" class="form-control" style="width: 300px"
	id="ownerName" maxlength="50" name="ownerName"
	value="<c:out value="${changeInOwnershipType.balance_arrears}"/>" readonly/></td>

<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.cut_off_date" /><span
		class="ClsRequiredFields"></span>: </td>
<td><input type="text" class="form-control" style="width: 300px"
	id="ownerName" maxlength="50" name="ownerName"
	value="<c:out value="${changeInOwnershipType.cut_off_date}"/>" readonly/></td>

</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.consumerAddress" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><textarea class="form-control" style="width: 300px"
					id="ownerAddress" maxlength="200" rows="2" name="ownerAddress" readonly>${changeInOwnershipType.consumerAddress}</textarea>

<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.email" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${changeInOwnershipType.emailId}"/>" readonly/></td>

		</tr>
<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.mobileNo" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.mobileNo}"/>" readonly/></td>		
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="ESR" />:</span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.existingEsr}"/>" readonly/></td>

</tr>
<tr>

			
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.title" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 300px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.title}"/>" readonly/></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.name" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 300px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.firstName}"/>" readonly/></td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.fathername" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.middleName}"/>" readonly/></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.surnname" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 300px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.lastName}"/>" readonly/></td>
				</tr>
				
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.fullname" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.fullName}"/>" readonly/></td>
			<!-- <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.plotNo" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${changeInOwnershipType.plotNo}"/>" /></td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.buildingName" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.buildingName}"/>" /></td>



			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.streetName" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.streetName}"/>" /></td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.areaName" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.areaName}"/>" /></td>


			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.landmark" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.landmark}"/>" /></td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.pincode" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.pinCode}"/>" /></td>





			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.aadharNo" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.aadharNo}"/>" /></td>
		</tr>


		<tr>-->
			
		<!-- </tr>


		<tr>
		<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.city" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.applicantcity}"/>" /></td>-->
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.addressForCorrespondence" /><span
					class="ClsRequiredFields"></span>: </td>
					<td><textarea class="form-control" style="width: 300px"
					id="ownerAddress" maxlength="200" rows="2" name="ownerAddress" readonly>${changeInOwnershipType.addressForCorrespondence}</textarea>
		
		
		</tr>



			
		
		<!-- <tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.depositeReciptNo" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.depositReceiptNo}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.depositeReceiptDate" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><input type="date" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.depositReceiptDate}"/>" /></td>
		</tr>
		<tr>


			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.purposeOfOwnership" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><textarea type="text" class="form-control"
					style="width: 300px" id="ownerName" maxlength="50" name="ownerName">${changeInOwnershipType.purposeOfOwnership}</textarea></td>
-->




	

			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.altermobileNo" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${changeInOwnershipType.alterMobileNo}"/>" readonly/></td>		
				
			 <td><span class="ClsLabel" style="font-size:14px;"> Current Status:</span></td>
     <td> <span class="ClsLabel" style="font-size:14px;color:forestgreen;">
     <c:if test="${requestScope.rtiApplication.workFlowStatus==0}">
						<b>Citizen Form Submitted.</b> 
	</c:if>
					 <c:if test="${requestScope.rtiApplication.workFlowStatus==9}">
						<b>Under Approval Authority</b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
						<b>Citizen Payment Pending.</b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
						<b>Citizen Payment Completed.</b>
					</c:if>
											
					<c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						<b>Completed and File Uploaded for Citizen</b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						<b>Rejected</b>
					</c:if></span>
        
  </td>   
		</tr>




		<%--  <td colspan="6" align="center">
                   	<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
                      <a target="_blank" href="" id="genCerBtn">
                      
                      <button name="rtiApplicationRefId" class="ClsButton clsButtonUpload" onclick="download(${zoneCertificates.rti_ref_id},'zoneCertificateReport.do')">GENERATE CERTIFICATE</button>
                     </a>
                 
	   </td>  --%>



		<!--      <tr>
            <td colspan="6" style="padding-top:5px">
                <img src="../images/Transpx.gif" height="15px" />
            </td>
        </tr> -->


		<%-- <tr>
			<td colspan="6" align="center"><input type="button"
				class="ClsButton" id="save" name="save" value="Save"
				onclick="javascript:savemTPRegistrationCertificate(this.form);"
				tabindex="31"> <input type="button" class="ClsButton"
				id="clear" name="clear"
				value="<fmt:message key="common.button.clear"/>"
				onclick="javascript:clearFields('SearchTable');searchRTIApplication()" />
	

	

<input type="hidden" class="ClsTextbox" style="width:180px" id="rtiapplrefno" maxlength="12" name="rtiapplrefno" value="<c:out value="${zoneCertificates.rtiapplrefno}"/>" />
                       
<input type="hidden" class="ClsTextbox_mr" style="width:180px" id="rti_ref_id" maxlength="12" name="rti_ref_id" value="<c:out value="${zoneCertificates.rti_ref_id}"/>" />
         --%>

	</table>
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		<tr>
			<td colspan="5"><span class="ClsLabel"
				style="font-size: 15px; font-weight: bold;"><fmt:message
						key="List of Documents (Attachment) For Change Of Ownership" />:</span></td>
						<c:set var="doc"
							value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
			<c:if test="${doc[0] != 'null'}">

				<tr>
					<td style="width: 600px; height: 30px"><span class="ClsLabel"
						style="font-size: 14px;"><fmt:message
								key="Self-Attested Applicant's ID Proof
								(स्वयं-साक्षांकित अर्जदाराचा ओळखपत्र पुरावा)" />:</span></td>

					<td style="text-align: center">
						<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
				</tr>
			</c:if>
			<c:if test="${doc[1] != 'null'}">
				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="Copy Of Latest Paid Bill (नवीनतम देय बिलाची प्रत)" />:</span></td>
					<td style="text-align: center"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[1]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

				</tr>
			</c:if>
			<!--<c:if test="${doc[2] != 'null'}">

				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="label.changeInOwnershipType.copyOfDemandPaid" />:</span></td>
					<td style="text-align: center"><a class="ClsButton"
						type="button" target="_blank" href="<c:out value="${doc[2]}"/>"><span
							style="align-items: center">Download</span></a></td>
				</tr>
			</c:if>-->
			<c:if test="${doc[2] != 'null'}">

				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="Copy Of Address/Ownership Proof/Tax Receipt/Sale Deed/Gift Deed (पत्त्याची प्रत/मालकीचा पुरावा/कर पावती/विक्री करार/भेटपत्र)" />:</span></td>
					<td style="text-align: center"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[2]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

				</tr>
			</c:if>
			<c:if test="${doc[3] != 'null'}">

				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="Any other Supporting document.
								(इतर कोणतेही सहाय्यक दस्तऐवज)" />:</span></td>
					<td style="text-align: center">
					
					<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[3]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
</td>

				</tr>
			</c:if>
	
		<!-- Add on -->
		
		
		<tr>	
	    <td>
                           <span class="ClsLabel" style="font-size:14px;width: 400px"><fmt:message key="Fees for the Request" />:</span>
                        </td>
                         <c:choose>
               <c:when test="${empty changeInOwnershipType.demandfees and requestScope.forLogin eq 'nothing'}">
                           <td style="text-align: center">
                            <input type="number" class="form-control" id="feesApplicable" maxlength="5"  style="margin-left: 192px;width:200px" name="demandfees" value="<c:out value="${changeInOwnershipType.demandfees}"/>"
                             oninput="validateInput(this);" />
                          </td>
     	 </c:when>
        <c:otherwise>
            <td style="text-align: center">
                            <!-- <input type="number" class="form-control" id="feesApplicable" maxlength="5" style="margin-left: 192px;width:200px" name="demandfees" readonly value="<c:out value="${waterDisconnection.demandfees}"/>"/>-->
                            <input type="number" class="form-control" id="feesApplicable" maxlength="5" style="margin-left: 192px; width:200px" name="demandfees" readonly
    value="<c:out value="${changeInOwnershipType.demandfees}"/>"
    oninput="restrictInput(this);">
                            
            </td>
        </c:otherwise>
    </c:choose>
</tr>
			
			     <!-- Add on -->
	<tr>
    <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="Remark for Approval Authourity" />:</span>
    </td>
    <c:choose>
        <c:when test="${empty changeInOwnershipType.approvalRemark and requestScope.forLogin eq 'nothing'}">
            <td style="text-align: center;">
            <textarea class="form-control" style="width: 310px;margin-left: 182px;"
					id="approvalRemark" maxlength="200" name="approvalRemark" rows="2">${changeInOwnershipType.approvalRemark}</textarea></td>
            
               
        </c:when>
        <c:otherwise>
            <td style="text-align: center;">
               <textarea class="form-control" style="width: 310px;margin-left: 182px;"
					id="approvalRemark" maxlength="200" name="approvalRemark" rows="2" readonly>${changeInOwnershipType.approvalRemark}</textarea></td>
            
        </c:otherwise>
    </c:choose>
</tr>
		
			

					<!-- Demand Upload old -->
		
   	<tr>
    <td>
        <span class="" style="font-size: 14px">
            <fmt:message key="Demand Letter" />:
        </span>
    </td>
    <c:choose>
      
            <c:when test="${empty changeInOwnershipType.uploadedDemand and requestScope.forLogin eq 'nothing'}">
                <td style="text-align: center">
                    <input type="file" name="demanddoc" id="demanddoc" style="width: 220px" onchange="confirmFileUpload()"/>
               
  <!--  <input type="button" class="ClsButton clsButtonUpload" id="demandUpload" name="demandUpload" value="Upload" onclick="uploadPoliceNoc1();">-->
                </td>
        </c:when>
        <c:otherwise>
            <c:if test="${not empty changeInOwnershipType.uploadedDemand}">
                <td style="text-align: center">
                				
  <a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${changeInOwnershipType.uploadedDemand}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>

                   
                </td>
            </c:if>
        </c:otherwise>
    </c:choose>
</tr>
<c:if test="${requestScope.forLogin eq 'nothing'|| (requestScope.forLogin eq 'L2' and requestScope.rtiApplication.workFlowStatus == 9)}"	>	

	<tr>
    <td colspan="4" align="center">
        <input type="button"
               class="btn btn-primary"
               style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745;margin-left:50px;"
               id="savefees" name="savefees"
               value="<fmt:message key="Save"/>"
               onclick="javascript:saveFees(this.form);"
               >
    </td>
</tr>
</c:if>
					<!-- Agreement Upload old -->
		
   	<tr>
    <td>
        <span class="" style="font-size: 14px">
            <fmt:message key="Water Supply Agreement" />:
        </span>
    </td>
    <c:choose>
        <c:when test="${empty changeInOwnershipType.agreement and requestScope.forLogin eq 'nothing'}">
                <td>
                    <input type="file" name="agreementdoc" id="agreementdoc" style="width: 220px" />
               
                    
                       <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="agreementUpload" name="agreementUpload" type="button" target="_blank" onclick="uploadAgreement();"><span
							class="download" style="align-items: center">Upload</span></a>
 </td>
        </c:when>
        <c:otherwise>
            <c:if test="${not empty changeInOwnershipType.agreement}">
                <td style="text-align: center">
                 <a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${changeInOwnershipType.agreement}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>

                   
                </td>
            </c:if>
        </c:otherwise>
    </c:choose>
</tr>
   	
<c:if test="${requestScope.forLogin eq 'nothing' and requestScope.rtiApplication.workFlowStatus == 3 || requestScope.rtiApplication.workFlowStatus == 2 || requestScope.rtiApplication.workFlowStatus == 1 }">
  
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
       <c:if test="${changeInOwnershipType.paymentStatus=='Paid'}">checked="checked" disabled="true"</c:if> />
       


                &nbsp;&nbsp;&nbsp; Paid&nbsp;&nbsp;&nbsp;
            </label>
        </td>
    </tr>
</c:if>





		<!-- acknowledgement upload -->
			<c:if test="${requestScope.forLogin eq 'nothing' and requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus == 1 }">
			<tr>
    <td colspan="1">
        <span class="" style="font-size: 14px">
            <fmt:message key="Acknowledgement Report" />:
        </span>
    </td>
    <c:choose>
        <c:when test="${empty changeInOwnershipType.acknowledgement}">
        		<c:if test="${requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus == 1 || requestScope.rtiApplication.workFlowStatus == 5}">
        
                <td>
                    <input type="file" name="acknowledgementdoc" id="acknowledgementdoc" style="width: 220px" />
                

        <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="acknowledgementUpload" name="acknowledgementUpload" type="button" target="_blank" onclick="uploadFireNoc();"><span
							class="download" style="align-items: center">Upload</span></a>
            </td>
                         </c:if>
                
        </c:when>
        <c:otherwise>
            <c:if test="${not empty changeInOwnershipType.acknowledgement}">
            <td style="text-align: center">
             <a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${changeInOwnershipType.acknowledgement}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>


                </td>
            </c:if>
        </c:otherwise>
    </c:choose>
</tr>           
</c:if>
<c:if test="${requestScope.forLogin eq 'nothing' and requestScope.rtiApplication.workFlowStatus==3}">

<tr id="paymentid">
    <td colspan="4" align="center" id="paymentids">
        <input type="button" class="btn btn-primary" style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745; margin-left:50px;" id="savePayment" name="savePayment" value="Save" 
                       onclick="javascript:savePaymentStatus(this.form);"
      disabled="false">
    </td>
</tr>
</c:if>
<tr>
<td colspan="4" align="center">
<button type="button" class="btn btn-danger  btn_sm printMe">
             View and Print
            
        </button>
        </td>
</tr>


		</table>	<br>
</div>

<input type="hidden" class="ClsTextbox" id="changeOwnershipID" style="width: 180px" name="changeOwnershipID" value="<c:out value='${changeInOwnershipType.changeOwnershipID}' />" />
<input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="${requestScope.rtiApplication.rtiApplicationId}" />
<input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${changeInOwnershipType.rtiRefId}" />


<c:choose>
    <c:when test="${requestScope.forLogin eq 'L2'}">
        <c:choose>
            <c:when test="${requestScope.workFlowStatus ne '3' and requestScope.workFlowStatus ne '2' and requestScope.workFlowStatus eq '9'}">
                <%@include file="/pages/workflow/taskInclude.jsp"%>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>
    </c:when>
    <c:when test="${requestScope.forLogin eq 'nothing' and (requestScope.workFlowStatus eq '0' or requestScope.workFlowStatus eq '9') }">
    </c:when>
     <c:when test="${requestScope.forLogin eq 'nothing' and (requestScope.workFlowStatus ne '0' and requestScope.workFlowStatus ne '9')}">
             <%@include file="/pages/workflow/taskInclude.jsp"%>     
    </c:when>
    <c:when test="${requestScope.forLogin eq 'L3'}"></c:when>
     <c:otherwise>
        <%@include file="/pages/workflow/taskInclude.jsp"%>
    </c:otherwise>
</c:choose>




<script type="text/javascript">
	function saveEntity() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createChangeInOwnershipWork.do');
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
            inputElement.value = inputElement.value.slice(0, 4);
            alert("Please enter a value with a maximum of 5 digits.");
        }

        if (inputElement.value == 0) {
            if (confirm("Are you sure?")) {
                inputElement.value = 0;
                $('#demanddoc').prop('disabled', true);
            }
        } else {
            $('#demanddoc').prop('disabled', false);
        }
    }
</script>
	
<script type="text/javascript">
function saveFees() {
	var feeId = $('#feesApplicable').val();
    var demanddoc = '${changeInOwnershipType.uploadedDemand}';
    var approvalRemark = $('#approvalRemark').val();

 
    

  if (feeId!== ''  && approvalRemark!== '') {
	   if (feeId > 0) { // When fees are greater than zero, demand document upload is required
           var idProofFile = $("#demanddoc").get(0).files[0];
           if (!idProofFile) {
               alert("Please upload the Demand document.");
               return false;
           }

           var fileName = idProofFile.name;
           var fileExtension = fileName.split('.').pop().toLowerCase();

           if (fileExtension !== 'pdf') {
               alert("Please select a PDF file.");
               return false;
           }
       }
        if (confirm('Are you sure you want to save?')) {
        var uid = $('#rtiApplicationRefIds').val();
        uploadPoliceNoc1();

        onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveChangeInOwnershipWater.do');
        feeId.prop('readonly', true);
        } else {
            return false;
        }
    } else {
         alert("Please enter the required details.");
        return false;
    }
}

// Attach click event listener to demandUpload button
$('#demandUpload').click(function() {
    // Set a flag to indicate that the button has been clicked
    $(this).prop('clicked', true);
});
$(document).ready(function() {
    // Ensure demand document input is disabled if the initial fee is zero or negative
    var initialFee = $('#feesApplicable').val();
    if (initialFee == 0 || initialFee < 0) {
        $('#demanddoc').prop('disabled', true);
    }
});
</script>

<script>
    function savePaymentStatus() {
        var payment = $('#payment');
       // var acknowledgementdoc = $('#acknowledgementdoc');
       // var acknowledgementUpload = $('#acknowledgementUpload');

        if (payment.prop('checked') ) {
            if (confirm('Are you sure you want to save?')) {
				var uid = $('#rtiApplicationRefIds').val();
            
            // Assuming onPageSubmit is a function that handles form submission
            onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveChangeInOwnershipWaterPayment.do');

            // Disable user interaction with the payment checkbox after saving
            payment.prop('disabled', true);
            payment.prop('readonly', true);
            $("#payment").prop("checked") 
            $("#savePayment").hide();
            } else {
                return false;
            }
        } else {
            alert("Please select the Payment Status.");
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
$("#approvalRemark").prop('disabled', false);

    $("#savefees").prop('disabled', false);

    // If feeId is not empty, disable the button on document ready
    if (feeId !== "") {
        $("#feesApplicable").prop('disabled', true);
  $("#approvalRemark").prop('disabled', true);
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
		    elements.innerHTML = "RTS Application is Rejected".fontcolor("red");
		    $('#commentsDisable *').attr('disabled', true);
		    $('#CreateWorkflow').attr('disabled', true);
		    $('#RejectCreateWorkflow').attr('disabled', true);
		    $('#WORKFLOW_COMMENTS').attr('disabled', true);

	  }
	});
   
</script>

	
	

	<script type="text/javascript">
	
    function uploadPoliceNoc1() {
        console.log("@@upoading@@");
        var url = window.location.href;
        var basePath = '${pageContext.getAttribute("UPLOAD_PATH")}';
        var filesPath = "";
        var data = new FormData();
        var idProofFile = $("#demanddoc").get(0).files[0];
        

       
        
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
                filesPath = filesPath + basePath + "ChangeInOwnershipType/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 1;
        var uid1 = document.getElementById('changeOwnershipID').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadManageWaterChangeInOwnership.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false,
            async:false
            }).done(function (data) {
            	if(data.status==true || data.status=='true'){
              	  
                   return;
              	}else{
                
                    return false;

              	}            

        });

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
        var basePath = '${pageContext.getAttribute("UPLOAD_PATH")}';
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
                filesPath = filesPath + basePath + "ChangeInOwnershipType/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 2;
        var uid1 = document.getElementById('changeOwnershipID').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadManageWaterChangeInOwnership.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false 
        }).done(function (data) {
        	if(data.status==true || data.status=='true'){
            	  
                alert("Acknowledgement uploaded Successfully");
                window.location.reload(); 
          	}else{
                alert("Acknowledgement upload failed!!");

          	}
        	


        });

        var a = filesPath.substring(0, filesPath.lastIndexOf(","));
        filesPath = filesPath.replace(/\s/g, "");
        $("#filesPath").val(filesPath);
        console.log(filesPath);


    }
    
    function uploadAgreement() {
        console.log("@@upoading@@");
        var url = window.location.href;
        var basePath = '${pageContext.getAttribute("UPLOAD_PATH")}';
        var filesPath = "";
        var data = new FormData();
        var idProofFile = $("#agreementdoc").get(0).files[0];
        if (!idProofFile) {
            alert("Please upload the Supporting Document.");
            return; 
        }
        var fileName = idProofFile.name;
        var fileExtension = fileName.split('.').pop().toLowerCase();

        if (fileExtension !== 'pdf') {
            alert("Please select a PDF file.");
            return;
        }
        data.append('idProof3', $("#agreementdoc").get(0).files[0]);


        var isFileSelected = false

        var array_element = "";
        var file = $('input[id="agreementdoc"]');
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
                filesPath = filesPath + basePath + "ChangeInOwnershipType/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 3;
        var uid1 = document.getElementById('changeOwnershipID').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadManageWaterChangeInOwnership.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false 
        }).done(function (data) {
        	if(data.status==true || data.status=='true'){
          	  
                alert("Agreement uploaded Successfully");
                window.location.reload(); 
          	}else{
                alert("Agreement upload failed!!");

          	}
        	

        });

        var a = filesPath.substring(0, filesPath.lastIndexOf(","));
        filesPath = filesPath.replace(/\s/g, "");
        $("#filesPath").val(filesPath);
        console.log(filesPath);


    }
    

 	function docDownload(filesPath) {
 	    var encodedFilePath = encodeURIComponent(filesPath);

 	    var encodedFilesPath = btoa(encodedFilePath); 

 	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
 	}
	$('.printMe').on('click', function () {
		 window.print();
		 });
	
	$(document).ready(function() {
 	    var demandfees = "${changeInOwnershipType.demandfees}";
 		var workflowStatus="${requestScope.rtiApplication.workFlowStatus}";
 	    if ((demandfees == 0 || demandfees < 0) && workflowStatus!=='5' ){     
 	        var elements = document.getElementsByClassName("tab")[0];
 	        elements.innerHTML = "".fontcolor("red");
 	        $('#commentsDisable *').attr('disabled', true);
 	        $('#CreateWorkflow').attr('disabled', true);
 	        $('#CreateWorkflow').hide();
 	        $('#RejectCreateWorkflow').attr('disabled', false);
 	        $('#WORKFLOW_COMMENTS').attr('disabled', false);
 	        $('#idProof').attr('disabled', false);
 	    }else if(workflowStatus==='1'){
 			 var elements = document.getElementsByClassName("tab")[0];
 		    elements.innerHTML = "Application is closed".fontcolor("green");
 		    $('#commentsDisable *').attr('disabled', true);
 	       $('#CreateWorkflow').attr('disabled', true);
 	       $('#CreateWorkflow').hide();
 	       $('#RejectCreateWorkflow').attr('disabled', true);
 	       $('#WORKFLOW_COMMENTS').attr('disabled', true);
 	}else if(workflowStatus==='5'){
 		 var elements = document.getElementsByClassName("tab")[0];
 		    elements.innerHTML = "Application has been rejected".fontcolor("red").font-size("x-large");
 		    $('#commentsDisable *').attr('disabled', true);
 	       $('#CreateWorkflow').attr('disabled', true);
 	       $('#CreateWorkflow').hide();
 	       $('#RejectCreateWorkflow').hide();

 	       $('#RejectCreateWorkflow').attr('disabled', true);
 	       $('#WORKFLOW_COMMENTS').attr('disabled', true);
 	       
 	}
 	});

    </script>
    <script>
function confirmFileUpload() {
    var fileInput = document.getElementById('demanddoc');
    var fileName = fileInput.value.split('\\').pop();
    var confirmation = confirm('You have selected "' + fileName + '". Are you sure you want to proceed? Please confirm. Once uploaded, the file cannot be changed.');

    //var confirmation = confirm('You have selected "' + fileName + '". Are you sure this is the correct file?');
    if (!confirmation) {
        fileInput.value = ''; // Reset the file input
    }
}
</script>