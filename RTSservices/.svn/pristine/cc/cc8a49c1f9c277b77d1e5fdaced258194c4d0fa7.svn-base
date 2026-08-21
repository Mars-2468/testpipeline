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
	pageContext.setAttribute("WORKFLOW_PRIORITY_MEDIUM_LABEL",
			WorkflowConstants.WORKFLOW_PRIORITY_MEDIUM_LABEL);
	pageContext.setAttribute("WORKFLOW_PRIORITY_HIGH", WorkflowConstants.WORKFLOW_PRIORITY_HIGH);
	pageContext.setAttribute("WORKFLOW_PRIORITY_HIGH_LABEL", WorkflowConstants.WORKFLOW_PRIORITY_HIGH_LABEL);
	pageContext.setAttribute("WORKFLOW_PROCESSDESCRIPTION", WorkflowConstants.WORKFLOW_PROCESSDESCRIPTION);
	pageContext.setAttribute("WORKFLOW_TRANSITION", WorkflowConstants.WORKFLOW_TRANSITION);
	pageContext.setAttribute("WORKFLOW_NAME", WorkflowConstants.WORKFLOW_NAME);
	pageContext.setAttribute("WORKFLOW_ACTION", WorkflowConstants.WORKFLOW_ACTION);
	pageContext.setAttribute("WORKFLOW_ACTION_COMPLETE_TASK", WorkflowConstants.WORKFLOW_ACTION_COMPLETE_TASK);
	pageContext.setAttribute("WORKFLOW_ACTION_CREATE_PROCESS",
			WorkflowConstants.WORKFLOW_ACTION_CREATE_PROCESS);
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
</style>
<div class = "row print-container">

<div class="container">
	<h3 style="font-size: 18px; font-weight: bold;">

		<fmt:message key="Application form for New Water Connection" />
		:
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>


	</h3>
</div>
<div valign="top" id="">
	<input type="hidden" name="id"
		value="${newWaterConnection.newWaterConnectionId}">
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		<tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.title" />:</span></td>
			<td>
			    <input type="text" class="form-control" size="30" id="ownerName" maxlength="50" name="ownerName" value="<c:out value="${newWaterConnection.title}"/>" readonly/>
			
			</td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.firstName" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${newWaterConnection.firstName}"/>" readonly/></td>

		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.fathername"  />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 300px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${newWaterConnection.middleName}"/>" readonly/></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.lastName" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${newWaterConnection.lastName}"/>" readonly/></td>
		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.fullName" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${newWaterConnection.fullName}"/>" readonly/></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.pincode" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${newWaterConnection.pinCode}"/>" readonly/></td>

		</tr>
		<tr>

			<!-- <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.aadhaarNo" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${newWaterConnection.aadhaarNo}"/>" /></td>
-->
			
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.MobileNo" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${newWaterConnection.mobileNo}"/>" readonly/></td>

			<!-- <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.address" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><textarea class="form-control" style="width: 300px"
					id="ownerAddress" maxlength="200" rows="2" name="ownerAddress">${newWaterConnection.address}</textarea></td>

		</tr>-->
		<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.emailId" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${newWaterConnection.email}"/>" readonly/></td>

		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.houseNo" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="plotNo" maxlength="30"
				name="plotNo"
				value="<c:out value="${newWaterConnection.plotNo}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.nameOfBuilding" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="buildingName" maxlength="30"
				name="buildingName"
				value="<c:out value="${newWaterConnection.buildingName}"/>" /></td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.nameOfLayout" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="layoutName" maxlength="30"
				name="layoutName"
				value="<c:out value="${newWaterConnection.layoutName}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.nameOfRoad" /><span
					class="ClsRequiredFields"></span>: </td>


			<td><input type="text" class="form-control" style="width: 300px"
				id="roadName" maxlength="50" name="roadName"
				value="<c:out value="${newWaterConnection.roadName}"/>" /></td>

		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.landmark" /><span
					class="ClsRequiredFields"></span>: </td>

			<td><input type="text" class="form-control" style="width: 300px"
				id="landmark" maxlength="30"
				name="landmark"
				value="<c:out value="${newWaterConnection.landmark}"/>" /></td>

			
		
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.zoneno" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${newWaterConnection.zoneNo}"/>" readonly/></td>
			</tr>
			<tr>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.city" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${newWaterConnection.city}"/>" readonly/></td>
			
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Full Address (संपूर्ण पत्ता)" /><span
					class="ClsRequiredFields"></span>: </td>
					<td><textarea class="form-control" style="width: 300px"
					id="address" maxlength="200" rows="2" name="address" >${newWaterConnection.address}</textarea>
		
		

		</tr>
		<tr>
		<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.altermobileNo" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${newWaterConnection.alterMobileNo}"/>" readonly/></td>
					
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.purposeOfWater" /><span
					class="ClsRequiredFields"></span>: </td>
			<td>
			
		
				
								<select id="purposeOfWater" class="form-control" style="width: 300px; height: 35px; background-image: none;" name="purposeOfWater">

									<option value="${newWaterConnection.purposeOfWater}" selected >${newWaterConnection.purposeOfWater}</option>
									
									<c:forEach var="purposeOfWater" items="${requestScope.purposeOfWater}">
										<option value="${purposeOfWater.purposeName}">
											<c:out value="${purposeOfWater.purposeName}" />
										</option>
									</c:forEach>
								</select>
				
				</td>
				
		</tr>
		
		<tr>
			<c:if test="${not empty newWaterConnection.residential}">
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="label.newWaterConnection.residential" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 300px" id="residential" maxlength="50" name="residential"
					value="<c:out value="${newWaterConnection.residential}"/>"/></td>
			</c:if>
			<c:if test="${not empty newWaterConnection.slum}">

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Slum" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 300px" id="ownerName" maxlength="50" name="ownerName"
					value="<c:out value="${newWaterConnection.slum}"/>"/></td>
			</c:if>
</tr>
		<tr>
			<c:if test="${not empty newWaterConnection.groupHousingApartment}">

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="label.newWaterConnection.groupHosingApartmentWithOneGroupConnectionWithmixed" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 130px" id="groupHousingApartment" maxlength="50" name="groupHousingApartment"
					value="<c:out value="${newWaterConnection.groupHousingApartment}"/>" /></td>
			</c:if>
			<c:if test="${not empty newWaterConnection.totalPlotNo}">

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="label.newWaterConnection.noOfFlats" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 300px" id="totalPlotNo" maxlength="50" name="totalPlotNo"
					value="<c:out value="${newWaterConnection.totalPlotNo}"/>" /></td>
			</c:if>

		</tr>
		<c:if test="${not empty newWaterConnection.groupHousingApartment}">

			<tr>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="label.newWaterConnection.totalNoOfResenditialFlatTenementDwellingUnit" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 130px" id="ownerName" maxlength="50" name="ownerName"
					value="<c:out value="${newWaterConnection.totalNumberOfResidentialFlats}"/>" readonly/></td>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="label.newWaterConnection.noOfResentialFlatText" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 300px" id="ownerName" maxlength="50" name="ownerName"
					value="<c:out value="${newWaterConnection.totalNoResidentialUnitsNotUsed}"/>" readonly/></td>


			</tr>
		</c:if>
		
						<c:if test="${not empty newWaterConnection.totalNoResidentialUnitsUsed}">
		
		<tr>
		
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.noOfNonResendtialFlatNotUsedForBusinessText" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${newWaterConnection.totalNoResidentialUnitsUsed}"/>" readonly/></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.newWaterConnection.noOfNonResendtialFlatUsedForBusinessText" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${newWaterConnection.total_no_residential_units}"/>" readonly/></td>

		</tr></c:if>
		
		<tr>
		<c:if test="${not empty newWaterConnection.instCategory}">
		
		
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Proposed Category for Institutional" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${newWaterConnection.instCategory}"/>" readonly/></td>

		</c:if>
			<c:if test="${not empty newWaterConnection.commCategory}">
		
		
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Proposed Category for Commercial" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${newWaterConnection.commCategory}"/>" readonly/></td>

		</c:if>
				
		
	
		</tr>
		<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterDisconnection.meterTapSize" /><span
					class="ClsRequiredFields"></span>: </td>
			<td>
			
		
				
								<select id="tapSize" class="form-control" style="width: 300px; height: 35px; background-image: none;" name="tapSize">

									<option value="${newWaterConnection.tapSize}" selected >${newWaterConnection.tapSize}</option>
									
									<c:forEach var="tapSize" items="${requestScope.tapSize}">
										<option value="${tapSize.tapSizeNameValue}">
											<c:out value="${tapSize.tapSizeNameValue}" />
										</option>
									</c:forEach>
								</select>
				
				</td>
				
		</tr>
			

		
	
		
			 <td><span class="ClsLabel" style="font-size:14px"> Current Status:</span></td>
     <td> <span class="ClsLabel" style="font-size:14px;color:forestgreen;">
     <c:if test="${requestScope.rtiApplication.workFlowStatus==0}">
						<b>Citizen Form Submitted. </b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
						<b>Citizen Payment Pending.</b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
						<b>Citizen Payment Completed.</b>
					</c:if>
											
					<c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						<b>Completed and File Uploaded for Citizen.</b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						<b>Rejected.</b>
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


			<%--  <td colspan="6" align="center">
                   	<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
                      <a target="_blank" href="" id="genCerBtn">
                      
                      <button name="rtiApplicationRefId" class="ClsButton clsButtonUpload" onclick="download(${zoneCertificates.rti_ref_id},'zoneCertificateReport.do')">GENERATE CERTIFICATE</button>
                     </a>
                 
	   </td>  --%>

			<%-- 
                <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
              <td><span class="ClsLabel" style="font-size:14px">Certificate Upload: </span> </td>
                </c:if>
     <%@include file="/pages/common-pages/dms/fileUpload.jsp"%>    
     </tr> --%>

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
						key="List of Documents (Attachment) For New Water Connection" />:</span></td>

		</tr>
								<c:if test="${doc[0] != 'null'}">

				<tr>
					<td style="width: 600px; height: 30px"><span class="ClsLabel"
						style="font-size: 14px;"><fmt:message
								key="Self-Attested Applicant's ID Proof(Aadhaar/PAN/Driving License/Passport) (स्वयं-साक्षांकित अर्जदाराचा ओळखपत्र पुरावा (आधार/पॅन/ड्रायव्हिंग लायसन्स/पासपोर्ट))" />:</span></td>

					<td style="text-align: center">
						<c:set var="doc" value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
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
								key="Photographs(Passport
									Size)(छायाचित्रे (पासपोर्ट आकार))" />:</span></td>
					<td style="text-align: center"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[1]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

				</tr>
			</c:if>
								<c:if test="${doc[2] != 'null'}">
				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="Copy Of Tax Receipt/Rent Agreement/Consent Letter of Owner(कर पावती/भाडे करार/मालकाच्या संमती पत्राची प्रत)" />:</span></td>
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
								key="Registry/Sale/Lease Deed(नोंदणी/विक्री/लीज करारपत्र)" />:</span></td>
					<td style="text-align: center"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[3]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

				</tr>
			</c:if>
								<c:if test="${doc[4] != 'null'}">
				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="Slum Certificate Slum Photo Pass/Kabja Patra(Possession Certificate)(झोपडपट्टी प्रमाणपत्र झोपडपट्टी फोटो पास/कबजा पत्र (ताबा प्रमाणपत्र))" />:</span></td>
					<td style="text-align: center"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[4]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

				</tr>
			</c:if>
								<c:if test="${doc[5] != 'null'}">

				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="Copy Of Tax Receipt (कर पावतीची प्रत)" />:</span></td>
					<td style="text-align: center"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[5]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

				</tr>
			</c:if>
								<c:if test="${doc[6] != 'null'}">

				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="Registry/Sale Deed
									(नोंदणी/विक्री करार)" />:</span></td>
					<td style="text-align: center"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[6]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

				</tr>
			</c:if>
								<c:if test="${doc[7] != 'null'}">

				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="Consent Letter From Flat Owners/Builder Application(Details of Flats)(फ्लॅट मालकांचे संमती पत्र)" />:</span></td>
					<td style="text-align: center"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[7]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

				</tr>
			</c:if>
								<c:if test="${doc[8] != 'null'}">

				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="DOD Deed Of
									Declaration (डीओडी डीड ऑफ डिक्लेरेशन)" />:</span></td>
					<td style="text-align: center"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[8]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

				</tr>
			</c:if>
								<c:if test="${doc[9] != 'null'}">

				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="NMC/NIT Building
									Sanction Plan (NMC/NIT इमारत मंजुरी योजना)" />:</span></td>
					<td style="text-align: center"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[9]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

				</tr>
			</c:if>
								<c:if test="${doc[10] != 'null'}">

				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="Architect Completion
									Certificate (आर्किटेक्ट पूर्णत्व प्रमाणपत्र)" />:</span></td>
					<td style="text-align: center"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[10]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

				</tr>
			</c:if>
								<c:if test="${doc[11] != 'null'}">

				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="Registry/Sale Deed/Agreement of Rent/Consent Letter of Owner(नोंदणी/विक्री करार/मालकाच्या संमती पत्राची प्रत)" />:</span></td>
					<td style="text-align: center"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[11]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

				</tr>
			</c:if>
								<c:if test="${doc[12] != 'null'}">

				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
								key="Gumasta
									License/Licenses For Running Business (गुमास्ता परवाना/व्यवसाय
									चालवण्यासाठी परवाने)" />:</span></td>
					<td style="text-align: center"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[12]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

				</tr>
			</c:if>
								
	<!-- Add on -->
	<!--<tr>
    <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="Tap Size (टॅप आकार)" />:</span>
    </td>
    <c:choose>
        <c:when test="${empty newWaterConnection.tapSize && (userId == 3950 || userId == 4150 || userId == 4151 || userId == 4152 || userId == 4153 || userId == 4154 || userId == 4155 || userId == 4156 || userId == 4157 || userId == 4158 || userId == 1 || userId == 4550)}">
            <td style="text-align: center;">
                <select class="form-select waterRequired" style="background-image: none;width: 200px;margin-left: 192px;" id="tapSize" name="tapSize" required>
                    <option value="">-Select-</option>
                    <option value="15mm.">15mm.</option>
                    <option value="20mm.">20mm.</option>
                    <option value="25mm.">25mm.</option>
                    <option value="40mm.">40mm.</option>
                    <option value="50mm.">50mm.</option>
                    <option value="80mm.">80mm.</option>
                    <option value="150mm.">150mm.</option>
                    <option value="100mm.">100mm.</option>
                    <option value="200mm.">200mm.</option>
                    <option value="250mm.">250mm.</option>
                    <option value="300mm.">300mm.</option>
                </select>
            </td>
        </c:when>
        <c:otherwise>
            <td style="text-align: center;">
                <input type="text" class="form-control" id="tapSize" style="background-image: none;width: 200px;margin-left: 192px;" name="tapSize" readonly
                    value="<c:out value="${newWaterConnection.tapSize}"/>">
            </td>
        </c:otherwise>
    </c:choose>
</tr>-->

		
		
		<tr>	
	    <td>
                           <span class="ClsLabel" style="font-size:14px;width: 400px"><fmt:message key="Fees for the Request" />:</span>
                        </td>
                         <c:choose>
        <c:when test="${empty newWaterConnection.demandfees}">
        
                           <td style="text-align: center">
                            <input type="number" class="form-control" id="feesApplicable" maxlength="5"  style="margin-left: 192px;width:200px" name="demandfees" value="<c:out value="${newWaterConnection.demandfees}"/>" oninput="validateInput(this);"/>
                          </td>
     	 </c:when>
        <c:otherwise>
            <td style="text-align: center">
                            <!-- <input type="number" class="form-control" id="feesApplicable" maxlength="5" style="margin-left: 192px;width:200px" name="demandfees" readonly value="<c:out value="${waterDisconnection.demandfees}"/>"/>-->
                            <input type="number" class="form-control" id="feesApplicable" maxlength="5" style="margin-left: 192px; width:200px" name="demandfees" 
    value="<c:out value="${newWaterConnection.demandfees}"/>" oninput="validateInput(this);" readonly>
                            
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
        <c:when test="${empty newWaterConnection.approvalRemark}">
            <td style="text-align: center;">
            <textarea class="form-control" style="width: 310px;margin-left: 182px;"
					id="approvalRemark" maxlength="200" name="approvalRemark" rows="2">${newWaterConnection.approvalRemark}</textarea></td>
            
               
        </c:when>
        <c:otherwise>
            <td style="text-align: center;">
               <textarea class="form-control" style="width: 310px;margin-left: 182px;"
					id="approvalRemark" maxlength="200" name="approvalRemark" rows="2" readonly>${newWaterConnection.approvalRemark}</textarea></td>
            
        </c:otherwise>
    </c:choose>
</tr>


    <!-- Add on -->
    <tr>
    <c:choose>
    <c:when test="${requestScope.for2remarks eq 'show'}">
        <td>
            <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="Remark for Higher Approval Authority" />:</span>
        </td>
      <td style="text-align: center;">
                    <textarea class="form-control" style="width: 310px;margin-left: 182px;"
                        id="higherapprovalRemark" maxlength="200" name="higherapprovalRemark" rows="2">${newWaterConnection.higherapprovalRemark}</textarea>
	  </td>
    </c:when>
    <c:otherwise>
    
    </c:otherwise>
    
    </c:choose>
    
      
        
    </tr>
	

					<!-- Demand Upload old -->
		
   	<tr id="demandZero">
    <td>
        <span class="" style="font-size: 14px">
            <fmt:message key="Upload Demand" />:
        </span>
    </td>
    <c:choose>
        <c:when test="${empty newWaterConnection.uploadedDemand}">
                <td style="text-align: center">
                    <input type="file" name="demanddoc" id="demanddoc" style="width: 220px" onchange="confirmFileUpload()"/>
                    
               
               
                </td>
        </c:when>
        <c:otherwise>
            <c:if test="${not empty newWaterConnection.uploadedDemand}">
                <td style="text-align: center">
                   							
<a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${newWaterConnection.uploadedDemand}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                </td>
            </c:if>
        </c:otherwise>
    </c:choose>
</tr>
<!-- Agreement Upload old -->
		<c:choose>
    <c:when test="${requestScope.for2ndSave eq 'show'}">
    <tr>
    <td colspan="4" align="center">
        <input type="button"
               class="btn btn-primary"
               style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745;margin-left:50px;"
               id="savefees" name="savefees"
               value="<fmt:message key="Save"/>"
               onclick="javascript:saveFees(this.form);">
    </td>
</tr>
    </c:when>
</c:choose>
   	<tr>
    <td>
        <span class="" style="font-size: 14px">
            <fmt:message key="Water Supply Agreement" />:
        </span>
    </td>
    <c:choose>
        <c:when test="${empty newWaterConnection.supportingdoc}">
                <td>
                    <input type="file" name="agreementdoc" id="agreementdoc" style="width: 220px" />
               
                        <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="agreementUpload" name="agreementUpload" type="button" target="_blank" onclick="uploadAgreement();"><span
							class="download" style="align-items: center">Upload</span></a>
 </td>
        </c:when>
        <c:otherwise>
            <c:if test="${not empty newWaterConnection.supportingdoc}">
                <td style="text-align: center">
                                                                 <a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${newWaterConnection.supportingdoc}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                   
                </td>
            </c:if>
        </c:otherwise>
    </c:choose>
</tr>
   	
<c:choose>
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
       <c:if test="${newWaterConnection.paymentStatus=='Paid'}">checked="checked" disabled="true"</c:if> />
       


                &nbsp;&nbsp;&nbsp; Paid&nbsp;&nbsp;&nbsp;
            </label>
        </td>
    </tr>
 </c:when>
    <c:otherwise>
        <!-- You can add content here for the otherwise case if needed -->
    </c:otherwise>
</c:choose>





		<!-- acknowledgement upload -->
		<c:if test="${requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus == 1}">
		
			<tr>
    <td colspan="1">
        <span class="" style="font-size: 14px">
            <fmt:message key="Acknowledgement Report" />:
        </span>
    </td>
    <c:choose>
        <c:when test="${empty newWaterConnection.acknowledgement}">
        		<c:if test="${( requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus == 1 || requestScope.rtiApplication.workFlowStatus == 5)}">
        
                <td>
                    <input type="file" name="acknowledgementdoc" id="acknowledgementdoc" style="width: 220px" />
                
                
                  <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="acknowledgementUpload"  type="button" target="_blank" onclick="uploadFireNoc();"><span
							class="download" style="align-items: center">Upload</span></a>
                </td>
                         </c:if>
                
        </c:when>
        <c:otherwise>
            <c:if test="${not empty newWaterConnection.acknowledgement}">
            <td style="text-align: center">
                                                 <a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${newWaterConnection.acknowledgement}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                </td>
            </c:if>
        </c:otherwise>
    </c:choose>
</tr>           
</c:if>


<c:if test="${requestScope.saveFees eq 'show'}">

<tr id="paymentid">
    <td colspan="4" align="center" id="paymentids">
        <input type="button" class="btn btn-primary" style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745; margin-left:50px;" id="savePayment" name="savePayment" value="Save" 
                       onclick="javascript:savePaymentStatus(this.form);">
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


      
		</table>

	<br>
</div>
<input type="hidden" class="ClsTextbox" id="newWaterConnectionId" style="width:180px"  name="newWaterConnectionId" value="<c:out value="${newWaterConnection.newWaterConnectionId}"/>" />
    <input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId"
	value="<c:out value="${requestScope.rtiApplication.rtiApplicationId}"/>" />
<input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${newWaterConnection.rti_ref_id}" />
	
	
	
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
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createWaterNewConnectionWork.do');
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
</script>
<script type="text/javascript">
    function saveFees() {
        var feeId = $('#feesApplicable').val();
        var tapSize = $('#tapSize').val();
        var purposeOfWater = $('#purposeOfWater').val();
        var demandupload = "${newWaterConnection.uploadedDemand}";
 		var workflowStatus="${requestScope.rtiApplication.workFlowStatus}";

        var approvalRemark = $('#approvalRemark').val(); // Added .val() to retrieve value
        var higherapprovalRemark = $('#higherapprovalRemark').val(); // Get the value

// Debugging output
        console.log("feeId:", feeId);
        console.log("approvalRemark:", approvalRemark);
        console.log("higherapprovalRemark:", higherapprovalRemark);
        // Check if higherapprovalRemark is not undefined and not empty
      if ((higherapprovalRemark !== undefined && higherapprovalRemark !== '') && workflowStatus==='9'){// Check if value is not empty or undefined
            onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveNewConnectionWater.do');
        } else if (feeId !== '' && purposeOfWater !== '' && tapSize !== '' && approvalRemark !== '' && workflowStatus==='0' && (higherapprovalRemark === '' ||higherapprovalRemark === undefined)) { 
            // Corrected tapSize.val() and added .val() to approvalRemark
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
                uploadPoliceNoc1();
                onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveNewConnectionWater.do');
                $('#feesApplicable').prop('disabled', true);
                $('#tapSize').prop('disabled', true);
            } else {
                return false;
            }
        } else {
            alert("Please enter required details.");
            return false;
        }
    }

    // Attach click event listener to demandUpload button
    $('#demandUpload').click(function() {
        // Set a flag to indicate that the button has been clicked
        $(this).prop('clicked', true);
    });

    $(document).ready(function() {
        var higherapprovalRemark = "${newWaterConnection.higherapprovalRemark}";
        if (higherapprovalRemark !== '') {
            $('#higherapprovalRemark').attr('readonly', true);
        }

        // Ensure demand document input is disabled if the initial fee is zero
        var initialFee = $('#feesApplicable').val();
        if (initialFee == 0 || initialFee < 0) {
            $('#demanddoc').prop('disabled', true);
        }
    });
</script>





<script>
    function savePaymentStatus() {
        var payment = $('#payment');
      //  var acknowledgementdoc = $('#acknowledgementdoc');
      //  var acknowledgementUpload = $('#acknowledgementUpload');

        if (payment.prop('checked') ) {
            if (confirm('Are you sure you want to save?')) {
				var uid = $('#rtiApplicationRefIds').val();
            
            // Assuming onPageSubmit is a function that handles form submission
            onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveNewConnectionWaterPayment.do');

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
                filesPath = filesPath + basePath + "NewWaterConnection/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 1;
        var uid1 = document.getElementById('newWaterConnectionId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadManageWaterNewConnection.do?appType="+appType+"&UID="+uid1,
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
                filesPath = filesPath + basePath + "NewWaterConnection/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 2;
        var uid1 = document.getElementById('newWaterConnectionId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadManageWaterNewConnection.do?appType="+appType+"&UID="+uid1,
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
    


	function docDownload(filesPath) {
 	    var encodedFilePath = encodeURIComponent(filesPath);

 	    var encodedFilesPath = btoa(encodedFilePath); 

 	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
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
                filesPath = filesPath + basePath + "NewWaterConnection/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 3;
        var uid1 = document.getElementById('newWaterConnectionId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadManageWaterNewConnection.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false 
        }).done(function (data) {
        	if(data.status==true || data.status=='true'){
            	  
                alert("Upload has been done successfully!");
                window.location.reload(); 
          	}else{
                alert("Upload failed!!");

          	}
        });

        var a = filesPath.substring(0, filesPath.lastIndexOf(","));
        filesPath = filesPath.replace(/\s/g, "");
        $("#filesPath").val(filesPath);
        console.log(filesPath);


    }
    $('.printMe').on('click', function () {
		 window.print();
		 });
    
    $(document).ready(function() {
 	    var demandfees = "${newWaterConnection.demandfees}";
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
    var confirmation = confirm('You have selected "' + fileName + '". Are you sure? Please confirm. Once uploaded, the file cannot be changed.');

    //var confirmation = confirm('You have selected "' + fileName + '". Are you sure this is the correct file?');
    if (!confirmation) {
        fileInput.value = ''; // Reset the file input
    }
}
</script>
