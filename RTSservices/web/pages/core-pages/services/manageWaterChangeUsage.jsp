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


pageContext.setAttribute("LABEL_RADIO_PERMANENT",  CoreConstants.LABEL_RADIO_PERMANENT);
pageContext.setAttribute("LABEL_RADIO_TEMPORARY",  CoreConstants.LABEL_RADIO_TEMPORARY);


pageContext.setAttribute("RADIO_PERMANENT",  CoreConstants.RADIO_PERMANENT);
pageContext.setAttribute("RADIO_TEMPORARY",  CoreConstants.RADIO_TEMPORARY); 
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

	function savewaterConnectionUsageCertificates() {

		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/savewaterConnectionUsage.do');
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

	function downloadRTIApplicationList(){
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

	function download(id,url) {

		document.getElementById('rtiApplicationRefId').value = id;
		
		alert("Certificate has been generated successfully.");
		
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);

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

		<fmt:message key="Application Form For Change Of Category " />
		:
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>


	</h3>
</div>
<div valign="top" id="">
	<input type="hidden" name="id"
		value="${waterConnectionUsage.waterConnectionUsageId}">
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		<tr>
		       
               <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.CINNo" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.CINNo}"/>" readonly/></td>         
		
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.zoneNo" />:</span><span class="ClsRequiredFields"></span></td>
			
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.zoneNo}"/>" readonly/></td>	
		</tr>
		<tr>		
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.consumerName" />:</span></td>
			
	<td><textarea class="form-control" style="width: 300px;"
					id="ownerAddress" maxlength="200" name="ownerAddress" rows="2" readonly>${waterConnectionUsage.consumerName}</textarea></td>
	
			

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.consumerAddress" />:</span></td>
			<td><textarea class="form-control" style="width: 300px;"
					id="ownerAddress" maxlength="200" name="ownerAddress" rows="2" readonly>${waterConnectionUsage.consumerAddress}</textarea></td>
         </tr>
		<tr>              

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.meterNo" />:</span><span class="ClsRequiredFields"></span></td>
			
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.meterNo}"/>" readonly/></td>
		

<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.waterDisconnection.meterTapSize" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
	id="ownerName" maxlength="50" name="ownerName"
	value="<c:out value="${waterConnectionUsage.tap_size}"/>" readonly/></td>
</tr>
		<tr>

<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.category" /><span
		class="ClsRequiredFields"></span>: </td>
<td><input type="text" class="form-control" style="width: 300px"
	id="ownerName" maxlength="50" name="ownerName"
	value="<c:out value="${waterConnectionUsage.category}"/>" readonly/></td>




<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.waterDisconnection.balance_arrears" />:</span></td>

			<td><input type="text" class="form-control" style="width: 300px"
	id="ownerName" maxlength="50" name="ownerName"
	value="<c:out value="${waterConnectionUsage.balance_arrears}"/>" readonly/></td>

</tr>
		<tr>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.cut_off_date" /><span
		class="ClsRequiredFields"></span>: </td>
<td><input type="text" class="form-control" style="width: 300px"
	id="ownerName" maxlength="50" name="ownerName"
	value="<c:out value="${waterConnectionUsage.cut_off_date}"/>" readonly/></td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.changeInOwnershipType.category" /><span
		class="ClsRequiredFields"></span>: </td>
<td>
		<select id="proposedCategory" class="form-control" style="width: 300px; height: 35px; background-image: none;" name="proposedCategory">

									<option value="${waterConnectionUsage.proposedCategory}" selected >${waterConnectionUsage.proposedCategory}</option>
									
								<c:forEach var="proposedCategoryType" items="${requestScope.proposedCategoryType}">
										<option value="${proposedCategoryType.categorytypeNameValue}">
											<c:out value="${proposedCategoryType.categorytypeNameValue}" />
										</option>
									</c:forEach>
								</select>


</tr>
    <input type="hidden" name="proposedCategory" value="${waterConnectionUsage.proposedCategory}" id="proposedCategoryHidden">

<tr>
	<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.email" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.email}"/>" readonly/></td>

		


				
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.mobileNo" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.mobileNo}"/>" readonly/></td>

		</tr>
		<tr>	
<c:if test="${totalNumberOfResidentialFlats != null && totalNumberOfResidentialFlats != ''}">
		<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterDisconnection.totalNumberOfResidentialFlats" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="totalNumberOfResidentialFlats" maxlength="50" name="totalNumberOfResidentialFlats"
				value="<c:out value="${waterConnectionUsage.totalNumberOfResidentialFlats}"/>" /></td>
			</c:if>		
		
				
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.altermobileNo" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.alterMobileNo}"/>" readonly/></td>	
				</tr>	
			<!-- <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.title" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 300px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.title}"/>" readonly/></td>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.name" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 300px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.firstName}"/>" readonly/></td>
	</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.fathername" />:</span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.middleName}"/>" /></td>

			
		
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.surnname" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 300px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.lastName}"/>" /></td>
</tr>
<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.fullName" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td>
<input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.fullName}"/>" />
			</td>
		<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.plotNo" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.plotNo}"/>" /></td>

		
</tr>
<tr>
			

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.buildingName" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${waterConnectionUsage.buildingName}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.streetName" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.streetName}"/>" /></td>

		</tr>
<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.areaName" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${waterConnectionUsage.areaName}"/>" /></td>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.landmark" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${waterConnectionUsage.landmark}"/>" /></td>
</tr>
<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.email" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.email}"/>" readonly/></td>

		

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.pincode" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${waterConnectionUsage.pincode}"/>" readonly/></td>
</tr>



<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.aadhaarNo" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.aadhaarNo}"/>" readonly/></td>
				
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.mobileNo" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.mobileNo}"/>" readonly/></td>

		</tr>
		<tr>
		<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.city" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.applicantcity}"/>" readonly/></td>
		
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.address" />:</span></td>
			<td><textarea class="form-control" style="width: 300px;"
					id="ownerAddress" maxlength="200" name="ownerAddress" rows="2" readonly>${waterConnectionUsage.address}</textarea></td>
		</tr>-->

						<!-- <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.dreceiptNo" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${waterConnectionUsage.dreceiptNo}"/>" readonly/></td>
		</tr>
		<tr>



			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterChangeUsage.receiptDate" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${waterConnectionUsage.receiptDate}"/>" readonly/></td>
	<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterDisconnectionru.purpose" />:</span></td>
			<td><textarea class="form-control" style="width: 300px;"
					id="ownerAddress" maxlength="200" name="ownerAddress" rows="2">${waterConnectionUsage.purpose}</textarea></td>
		</tr>-->
		
		
		<tr>
			 <td><span class="ClsLabel" style="font-size:14px"> Current Status:</span></td>
     <td> <span class="ClsLabel" style="font-size:14px;color:forestgreen;">
     <c:if test="${requestScope.rtiApplication.workFlowStatus==0}">
						<b>Citizen Form Submitted. </b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
						<b>In Process</b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
						<b>In Process</b>
					</c:if>
											
					<c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						<b>Completed and File Uploaded for Citizen</b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						<b>Rejected</b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==9}">
						<b>Under Approval Authority</b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==10}">
						<b>Under Higher Approval Authority</b>
					</c:if>
					
					</span>
        
  </td>   
		</tr>
		
	</table>
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
<tr>
			<td colspan="5"><span class="ClsLabel"
				style="font-size: 15px; font-weight: bold;"><fmt:message
						key="List of Documents (with attachment) For Water Connection Usage" />:</span></td>
  <c:if test="${doc[0] != 'null'}">
		<tr>
			<td style="width: 600px; height: 30px"><span class="ClsLabel"
				style="font-size: 14px;"><fmt:message
						key="label.changeInOwnershipType.applicantId" />:</span></td>
         
			<td style="text-align: center">
                    <c:set var="doc" value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>		
		</td>
</tr>
		</c:if>
		<tr>
		<c:if test="${doc[1] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Any other Supporting document for Change in Category (ग्राहक प्रकार बदलासाठी इतर कोणतेही सहाय्यक दस्तऐवज)" />:</span></td>
<td style="text-align: center"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[1]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>		
	</td>	

		</tr>
		</c:if>
		<!--<c:if test="${doc[2] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterDisconnection.demandReceipt" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[2]}"/>"><span style="align-items: center">Download</span></a>				
	</td>	
	</tr>
	</c:if>
	
	<c:if test="${doc[2] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterDisconnection.copyOfAddressFile" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[2]}"/>"><span style="align-items: center">Download</span></a>				
	</td>	
	</tr>
	</c:if>
	<c:if test="${doc[3] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.signatureOfConsumer" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[3]}"/>"><span style="align-items: center">Download</span></a>				
	</td>	
	</tr>
      </c:if>
	
	<!-- Add on -->
		
		
		<!-- <tr>	
	    <td>
                           <span class="ClsLabel" style="font-size:14px;width: 400px"><fmt:message key="Fees for the Request" />:</span>
                        </td>
                         <c:choose>
            <c:when test="${empty waterConnectionUsage.demandfees}">
        
                           <td style="text-align: center">
                            <input type="number" class="form-control" id="feesApplicable" maxlength="5"  style="margin-left: 192px;width:200px" name="demandfees" value="<c:out value="${waterConnectionUsage.demandfees}"/>" oninput="validateInput(this);"/>
                          </td>
     	 </c:when>
        <c:otherwise>
            <td style="text-align: center">
                            <!-- <input type="number" class="form-control" id="feesApplicable" maxlength="5" style="margin-left: 192px;width:200px" name="demandfees" readonly value="<c:out value="${waterDisconnection.demandfees}"/>"/>-->
                           <!--  <input type="number" class="form-control" id="feesApplicable" maxlength="5" style="margin-left: 192px; width:200px" name="demandfees" readonly
    value="<c:out value="${waterConnectionUsage.demandfees}"/>">
                            
            </td>
        </c:otherwise>
    </c:choose>
</tr>-->
<!-- Add on -->
	<tr>
    <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="Remark for Approval Authourity" />:</span>
    </td>
    <c:choose>
        <c:when test="${empty waterConnectionUsage.approvalRemark}">
            <td style="text-align: center;">
            <textarea class="form-control" style="width: 310px;margin-left: 182px;"
					id="approvalRemark" maxlength="200" name="approvalRemark" rows="2">${waterConnectionUsage.approvalRemark}</textarea></td>
            
               
        </c:when>
        <c:otherwise>
            <td style="text-align: center;">
               <textarea class="form-control" style="width: 310px;margin-left: 182px;"
					id="approvalRemark" maxlength="200" name="approvalRemark" rows="2" readonly>${waterConnectionUsage.approvalRemark}</textarea></td>
            
        </c:otherwise>
    </c:choose>
</tr>
   <tr>
    <c:choose>
    <c:when test="${requestScope.for2remarks eq 'show'}">
        <td>
            <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="Remark for Higher Approval Authority" />:</span>
        </td>
      <td style="text-align: center;">
                    <textarea class="form-control" style="width: 310px;margin-left: 182px;"
                        id="higherapprovalRemark" maxlength="200" name="higherapprovalRemark" rows="2">${waterConnectionUsage.higherapprovalRemark}</textarea>
	  </td>
    </c:when>
    <c:otherwise>
    
    </c:otherwise>
    
    </c:choose>
    
      
        
    </tr>
					<!-- Demand Upload old -->
		
   <!-- 	<tr>
    <td>
        <span class="" style="font-size: 14px">
            <fmt:message key="Upload Demand" />:
        </span>
    </td>
    <c:choose>
        <c:when test="${empty waterConnectionUsage.uploadedDemand}">
             <td style="text-align: center">
                    <input type="file" name="demanddoc" id="demanddoc" style="width: 220px" onchange="confirmFileUpload()"/>
               
              </td>
   </c:when>
        <c:otherwise>
            <c:if test="${not empty waterConnectionUsage.uploadedDemand}">
                <td style="text-align: center">
                    <a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${waterConnectionUsage.uploadedDemand}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                </td>
            </c:if>
        </c:otherwise>
    </c:choose>
</tr>-->
	<c:choose>
    <c:when test="${requestScope.for2ndSave eq 'show'}">
	<tr>
    <td colspan="4" align="center">
        <input type="button"
               class="btn btn-primary"
               style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745;margin-left:50px;"
               id="savefees" name="savefees"
               value="<fmt:message key="Save"/>"
               onclick="javascript:saveFees(this.form);"/>
    </td>
    
</tr>


</c:when>
</c:choose>
	<!-- Agreement Upload old -->
		
   	<tr>
    <td>
        <span class="" style="font-size: 14px">
            <fmt:message key="Supporting document (If any)" />:
        </span>
    </td>
    <c:choose>
        <c:when test="${empty waterConnectionUsage.supportingdoc}">
                <td>
                    <input type="file" name="supportingdoc" id="agreementdoc" style="width: 220px" />
               
                     <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="agreementUpload"  name="supportingUpload" type="button" target="_blank" onclick="uploadAgreement();"><span
							class="download" style="align-items: center">Upload</span></a>
 </td>
        </c:when>
        <c:otherwise>
            <c:if test="${not empty waterConnectionUsage.supportingdoc}">
                <td style="text-align: center">
                 
                       <a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${waterConnectionUsage.supportingdoc}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                </td>
            </c:if>
        </c:otherwise>
    </c:choose>
</tr>
           
     
  

	

<!--<c:choose>
    <c:when test="${(requestScope.rtiApplication.workFlowStatus == 3 || requestScope.rtiApplication.workFlowStatus == 2 || requestScope.rtiApplication.workFlowStatus == 1) and requestScope.forPaidCheckbox == 3}">
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
       <c:if test="${waterConnectionUsage.paymentStatus=='Paid'}">checked="checked" disabled="true"</c:if> />
       


                &nbsp;&nbsp;&nbsp; Paid&nbsp;&nbsp;&nbsp;
            </label>
        </td>
    </tr>
</c:when>
    <c:otherwise>
        <!-- You can add content here for the otherwise case if needed -->
   <!--  </c:otherwise>
</c:choose>-->





		<!-- acknowledgement upload -->
		<c:if test="${(requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus == 1 )and requestScope.forPaidCheckbox == 3}">
		
			<tr>
    <td colspan="1">
        <span class="" style="font-size: 14px">
            <fmt:message key="Acknowledgement Report" />:
        </span>
    </td>
    <c:choose>
        <c:when test="${empty waterConnectionUsage.acknowledgement}">
        		<c:if test="${requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus == 1}">
        
                <td>
                    <input type="file" name="acknowledgementdoc" id="acknowledgementdoc" style="width: 220px" />
                

   <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="acknowledgementUpload"  type="button" target="_blank" onclick="uploadFireNoc();"><span
							class="download" style="align-items: center">Upload</span></a>                </td>
                         </c:if>
                
        </c:when>
        <c:otherwise>
            <c:if test="${not empty waterConnectionUsage.acknowledgement}">
            <td style="text-align: center">
                                     <a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${waterConnectionUsage.acknowledgement}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                </td>
            </c:if>
        </c:otherwise>
    </c:choose>
</tr>           
</c:if>
<!--<c:if test="${requestScope.saveFees eq 'show'}">

<tr id="paymentid">
    <td colspan="4" align="center" id="paymentids">
        <input type="button" class="btn btn-primary" style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745; margin-left:50px;" id="savePayment" name="savePayment" value="Save" 
                       onclick="javascript:savePaymentStatus(this.form);"
      disabled="false">
    </td>
</tr>
</c:if>-->
<tr>
<td colspan="4" align="center">
<button type="button" class="btn btn-danger  btn_sm printMe">
             View and Print
            
        </button>
        </td>
</tr>


        
		</table>

	<br>
</div>


 <input type="hidden" class="ClsTextbox" id="waterConnectionUsageId" style="width:180px"  name="waterConnectionUsageId" value="<c:out value="${waterConnectionUsage.waterConnectionUsageId}"/>" />
    <input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="<c:out value="${requestScope.rtiApplication.rtiApplicationId}"/>" />
	<input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${waterConnectionUsage.rti_ref_id}" />

<c:choose>
    <c:when test="${requestScope.forLogin eq 'show'}">
		<%@include file="/pages/workflow/taskInclude.jsp"%>
    </c:when>
    <c:when test="${requestScope.forLogin eq 'hide'}">
    </c:when>
    <c:otherwise>
    </c:otherwise>
</c:choose>
</div>

<script type="text/javascript">
function saveEntity()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createWaterConnectionUsageWork.do');
}
	</script>
	
	<script>
function restrictInput(element) {
    // Remove any non-digit characters
    var inputValue = element.value.replace(/[^0-9]/g, '');

    // Limit to a maximum of 5 digits
    inputValue = inputValue.substring(0, 5);

    // Update the input value
    element.value = inputValue;

    // Check if the value is negative
    if (inputValue < 0) {
        // Display an error message or take appropriate action
        alert("Please enter a non-negative value.");
        // You may choose to clear the input or handle it differently
        element.value = '';
    }
}
</script>
	
<script type="text/javascript">
    function saveFees() {
        var proposedCategory = $('#proposedCategory').val();
        var approvalRemark = $('#approvalRemark').val();
        var higherapprovalRemark = $('#higherapprovalRemark').val();
        var workflowStatus = "${requestScope.rtiApplication.workFlowStatus}";

        // Debugging output
        console.log("proposedCategory:", proposedCategory);
        console.log("approvalRemark:", approvalRemark);
        console.log("higherapprovalRemark:", higherapprovalRemark);
        console.log("workflowStatus:", workflowStatus);

        if (workflowStatus === '9' && higherapprovalRemark !== undefined && higherapprovalRemark !== '') {
            // If workflow status is 9 and higherapprovalRemark is provided, submit the form
            onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveConnectionUsageWater.do');
        } else if (workflowStatus === '0' && proposedCategory !== '' && approvalRemark !== '' && (higherapprovalRemark === '' || higherapprovalRemark === undefined)) {
            // If workflow status is 0, proposedCategory and approvalRemark are provided, and higherapprovalRemark is not required, confirm and submit
            if (confirm('Are you sure you want to save?')) {
                onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveConnectionUsageWater.do');
                $('#proposedCategory').prop('disabled', true);
            } else {
                return false;
            }
        } else {
            // If none of the above conditions are met, show an alert
            alert("Please enter the required details.");
            return false;
        }
    }

    $(document).ready(function() {
        var higherapprovalRemark = "${waterConnectionUsage.higherapprovalRemark}";
        var approvalRemark = "${waterConnectionUsage.approvalRemark}";

        if (higherapprovalRemark !== '') {
            $('#higherapprovalRemark').attr('readonly', true);
            
        }
        if(approvalRemark !== ''){
        $('#proposedCategory').prop('disabled', true);
        //$('#proposedCategory').prop('readonly', true);

        }

    });
</script>





<script>
    function savePaymentStatus() {
        var payment = $('#payment');
       // var acknowledgementdoc = $('#acknowledgementdoc');
      //  var acknowledgementUpload = $('#acknowledgementUpload');

        if (payment.prop('checked')) {
            if (confirm('Are you sure you want to save?')) {
				var uid = $('#rtiApplicationRefIds').val();
            
            // Assuming onPageSubmit is a function that handles form submission
            onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveConnectionUsageWaterPayment.do');

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

/*$(document).ready(function() {
	  var workflowstatus = "${requestScope.rtiApplication.workFlowStatus}";
	  if (workflowstatus ==5) {
			var elements = document.getElementsByClassName("tab")[0];
		    elements.innerHTML = "RTS Application is Rejected".fontcolor("red");
		    $('#commentsDisable *').attr('disabled', true);
		    $('#CreateWorkflow').attr('disabled', true);
		    $('#RejectCreateWorkflow').attr('disabled', true);
		    $('#WORKFLOW_COMMENTS').attr('disabled', true);

	  }
	});*/
   
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
                filesPath = filesPath + basePath + "waterConnectionUsage/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 1;
        var uid1 = document.getElementById('waterConnectionUsageId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadManageWaterConnectionUsage.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false ,
            async:false
            }).done(function (data) {
            	if(data.status==true || data.status=='true'){
              	  return; 
              	}else{
                    //alert("Demand upload failed!!");

              	}
            

        });

        var a = filesPath.substring(0, filesPath.lastIndexOf(","));
        filesPath = filesPath.replace(/\s/g, "");
        $("#filesPath").val(filesPath);
        console.log(filesPath);


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
                filesPath = filesPath + basePath + "waterConnectionUsage/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 2;
        var uid1 = document.getElementById('waterConnectionUsageId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadManageWaterConnectionUsage.do?appType="+appType+"&UID="+uid1,
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
    </script>
        <script>
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
                filesPath = filesPath + basePath + "waterConnectionUsage/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 3;
        var uid1 = document.getElementById('waterConnectionUsageId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadManageWaterConnectionUsage.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false 
        }).done(function (data) {
        	if(data.status==true || data.status=='true'){
            	  
                alert("Supporting Document uploaded Successfully");
                window.location.reload(); 
          	}else{
                alert("Supporting Document upload failed!!");

          	}      
        });

        var a = filesPath.substring(0, filesPath.lastIndexOf(","));
        filesPath = filesPath.replace(/\s/g, "");
        $("#filesPath").val(filesPath);
        console.log(filesPath);


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

        if (inputElement.value == 0) {
            if (confirm("Are you sure?")) {
                inputElement.value = 0;
                $('#demanddoc').prop('disabled', true);
            }
        } else {
            $('#demanddoc').prop('disabled', false);
        }
    }
    

 	function docDownload(filesPath) {
 	    var encodedFilePath = encodeURIComponent(filesPath);

 	    var encodedFilesPath = btoa(encodedFilePath); 

 	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
 	}
 	$('.printMe').on('click', function () {
		 window.print();
		 });
 	

</script>
 <script>
function confirmFileUpload() {
    var fileInput = document.getElementById('demanddoc');
    var fileName = fileInput.value.split('\\').pop();
    var confirmation = confirm('You have selected "' + fileName + '". Are you sure? Please confirm. Once uploaded, the file cannot be changed.');

    //var confirmation = confirm('You have selected "' + fileName + '". Are you sure this is the correct file?');
    if (!confirmation) {
        fileInput.value = ''; // Reset the file input
    }
}
</script>