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
//birth
pageContext.setAttribute("LABEL_HOSPITAL_NAME_YASH", CoreConstants.LABEL_HOSPITAL_NAME_YASH);
pageContext.setAttribute("LABEL_HOSPITAL_NAME_MEDI", CoreConstants.LABEL_HOSPITAL_NAME_MEDI);

pageContext.setAttribute("HOSPITAL_NAME_YASH", CoreConstants.HOSPITAL_NAME_YASH);
pageContext.setAttribute("HOSPITAL_NAME_MEDI", CoreConstants.HOSPITAL_NAME_MEDI);

pageContext.setAttribute("LABEL_CHILD_GENDER_MALE", CoreConstants.LABEL_CHILD_GENDER_MALE);
pageContext.setAttribute("LABEL_CHILD_GENDER_FEMALE", CoreConstants.LABEL_CHILD_GENDER_FEMALE);
pageContext.setAttribute("LABEL_CHILD_GENDER_TRANSGENDER", CoreConstants.LABEL_CHILD_GENDER_TRANSGENDER);

pageContext.setAttribute("CHILD_GENDER_MALE", CoreConstants.CHILD_GENDER_MALE);
pageContext.setAttribute("CHILD_GENDER_FEMALE", CoreConstants.CHILD_GENDER_FEMALE);
pageContext.setAttribute("CHILD_GENDER_TRANSGENDER", CoreConstants.CHILD_GENDER_TRANSGENDER);

pageContext.setAttribute("LABEL_ZONE_NUMBER_HARS", CoreConstants.LABEL_ZONE_NUMBER_HARS);
pageContext.setAttribute("LABEL_ZONE_NUMBER_EKTA", CoreConstants.LABEL_ZONE_NUMBER_EKTA);

pageContext.setAttribute("ZONE_NUMBER_HARS", CoreConstants.ZONE_NUMBER_HARS);
pageContext.setAttribute("ZONE_NUMBER_EKTA", CoreConstants.ZONE_NUMBER_EKTA);

pageContext.setAttribute("STATUS_YES_LABEL", CoreConstants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO_LABEL", CoreConstants.STATUS_NO_LABEL);

pageContext.setAttribute("STATUS_YES", CoreConstants.STATUS_YES);
pageContext.setAttribute("STATUS_NO", CoreConstants.STATUS_NO);

pageContext.setAttribute("LABEL_BLOOD_GROUP_ONE", CoreConstants.LABEL_BLOOD_GROUP_ONE);
pageContext.setAttribute("LABEL_BLOOD_GROUP_TWO", CoreConstants.LABEL_BLOOD_GROUP_TWO);
pageContext.setAttribute("LABEL_BLOOD_GROUP_THREE", CoreConstants.LABEL_BLOOD_GROUP_THREE);
pageContext.setAttribute("LABEL_BLOOD_GROUP_FOUR", CoreConstants.LABEL_BLOOD_GROUP_FOUR);
pageContext.setAttribute("LABEL_BLOOD_GROUP_FIVE", CoreConstants.LABEL_BLOOD_GROUP_FIVE);
pageContext.setAttribute("LABEL_BLOOD_GROUP_SIX", CoreConstants.LABEL_BLOOD_GROUP_SIX);
pageContext.setAttribute("LABEL_BLOOD_GROUP_SEVEN", CoreConstants.LABEL_BLOOD_GROUP_SEVEN);
pageContext.setAttribute("LABEL_BLOOD_GROUP_EIGHT", CoreConstants.LABEL_BLOOD_GROUP_EIGHT);

pageContext.setAttribute("BLOOD_GROUP_ONE", CoreConstants.BLOOD_GROUP_ONE);
pageContext.setAttribute("BLOOD_GROUP_TWO", CoreConstants.BLOOD_GROUP_TWO);
pageContext.setAttribute("BLOOD_GROUP_THREE", CoreConstants.BLOOD_GROUP_THREE);
pageContext.setAttribute("BLOOD_GROUP_FOUR", CoreConstants.BLOOD_GROUP_FOUR);
pageContext.setAttribute("BLOOD_GROUP_FIVE", CoreConstants.BLOOD_GROUP_FIVE);
pageContext.setAttribute("BLOOD_GROUP_SIX", CoreConstants.BLOOD_GROUP_SIX);
pageContext.setAttribute("BLOOD_GROUP_SEVEN", CoreConstants.BLOOD_GROUP_SEVEN);
pageContext.setAttribute("BLOOD_GROUP_EIGHT", CoreConstants.BLOOD_GROUP_EIGHT);

pageContext.setAttribute("LABEL_RADIO_HOME", CoreConstants.LABEL_RADIO_HOME);
pageContext.setAttribute("LABEL_RADIO_HOSPITAL", CoreConstants.LABEL_RADIO_HOSPITAL);

pageContext.setAttribute("RADIO_HOME", CoreConstants.RADIO_HOME);
pageContext.setAttribute("RADIO_HOSPITAL", CoreConstants.RADIO_HOSPITAL);

pageContext.setAttribute("BLOOD_RELATION_ONE", CoreConstants.BLOOD_RELATION_ONE);
pageContext.setAttribute("BLOOD_RELATION_TWO", CoreConstants.BLOOD_RELATION_TWO);

pageContext.setAttribute("LABEL_BLOOD_RELATION_ONE", CoreConstants.LABEL_BLOOD_RELATION_ONE);
pageContext.setAttribute("LABEL_BLOOD_RELATION_TWO", CoreConstants.LABEL_BLOOD_RELATION_TWO);

pageContext.setAttribute("LABEL_RADIO_SAME_DAY", CoreConstants.LABEL_RADIO_SAME_DAY);
pageContext.setAttribute("LABEL_RADIO_TILL_THIRD_DAY", CoreConstants.LABEL_RADIO_TILL_THIRD_DAY);

pageContext.setAttribute("RADIO_SAME_DAY", CoreConstants.LABEL_RADIO_HOME);
pageContext.setAttribute("RADIO_TILL_THIRD_DAY", CoreConstants.RADIO_TILL_THIRD_DAY);

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
	function editRTIApplication() {
		//document.getElementById('rtiApplicationId').value = id;
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplication.do');
	}

	function saveBirthRegistrationCertificate() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveBirthRegistrationCertificate.do');
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
	function downloads(id,url) {

		document.getElementById('rtiApplicationRefId').value = id;
		
		alert("Certificate has been generated successfully.");
		
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);

	}
	
	function policedownload(id,url) {

		document.getElementById('rtiApplicationRefId').value = id;
		
		alert("Certificate has been generated successfully.");
		
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);

	}
	
	function trafficdownload(id,url) {

		document.getElementById('rtiApplicationRefId').value = id;
		
		alert("Certificate has been generated successfully.");
		
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);

	}
	function firedownload(id,url) {

		document.getElementById('rtiApplicationRefId').value = id;
		
		alert("Certificate has been generated successfully.");
		
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);

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

.input-align {
	align-items: center;
}
</style>
<style type="text/css">
input[type="text"], textarea {
	background-color: #e9ecef;

	color: #333;
}


.ClsLabel {
	font-style: normal;
	font-family: inherit;
	font-size: 10px;
	font-weight: 520 !important;
}
</style>

<div class="mainHdr">
	<h3 style="height: 30px; font-size: 15px; color: #01293d">

		<fmt:message key="Application form for Durga Utsav/Garba Mandap Permission" />
		:
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>

	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<input type="hidden" name="id"
		value="${mandapPermission.durgaUtsavMandapPermissionId}">
	<c:set var="doc"
		value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
	<table width="100%" border="0" cellpadding="2" cellspacing="2">
		<tr>
		<tr>

			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Title (शीर्षक) " />:</span></td>
			<td colspan="2">

					<input type="text" class="form-control" style="width: 180px;"
						id="applicantTitle" ="50" name="applicantTitle"
						value="<c:out value="${mandapPermission.title}"/>" disabled/>
			</td>

			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Name(नाव)" />:</span><span class="ClsRequiredFields"></span></td>
			<td colspan="2">
                         <input type="text" class="form-control" style="width: 180px"
						id="applicantLastName" maxlength="50" name="firstName"
						value="<c:out value="${mandapPermission.firstName}"/>" disabled/>
			</td>
		</tr>
		<tr>
		<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Father Name (वडिलांचे नाव)" />:</span></td>
			<td colspan="2">

					<input type="text" class="form-control" style="width: 180px;"
						id="applicantTitle" ="50" name="applicantTitle"
						value="<c:out value="${mandapPermission.middleName}"/>" disabled/>
				</td>
<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Surname (आडनाव)" />:</span></td>
			<td colspan="2">

					<input type="text" class="form-control" style="width: 180px"
						id="applicantLastName" maxlength="50" name="applicantLastName"
						value="<c:out value="${mandapPermission.lastName}"/>" disabled/>
			</td>

		</tr>
		<tr>

<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Full Name (पूर्ण नाव)" />:</span></td>
			<td colspan="2">

					<input type="text" class="form-control" style="width: 180px"
						id="applicantLastName" maxlength="50" name="applicantLastName"
						value="<c:out value="${mandapPermission.fullName}"/>" disabled/>
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Pin Code (पिन कोड)" />:</span></td>
			<td colspan="2">

					<input type="text" class="form-control" style="width: 180px"
						id="applicantLastName" maxlength="50" name="applicantLastName"
						value="<c:out value="${mandapPermission.pinCode}"/>" disabled/>
			</td>
			</tr>
			<tr>
			
			

			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key=" Address For Correspondence  (पत्रव्यवहारासाठी पत्ता) " />:</span><span
				class="ClsRequiredFields"></span></td>
			<td colspan="2">
				<%--    <spring:bind path="birthRegistration.address">
                                <input type="text" class="ClsTextbox" style="width:170px" id="address" maxlength="30" name="address" value="<c:out value="${birthRegistration.address}"/>" />
                         </spring:bind>--%> <textarea
					class="form-control" style="width: 300px" id="address"
					maxlength="30" name="address" disabled>${mandapPermission.address}</textarea>
			</td>
			
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key=" Aadhaar No.(आधार क्र.)" />:</span></td>
			<td colspan="2">

					<input type="text" class="form-control" style="width: 180px"
						id="applicantLastName" maxlength="50" name="applicantLastName"
						value="<c:out value="${mandapPermission.aadharNo}"/>" disabled/>
			</td>
			
			
		</tr>
		<tr>

			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Mobile Number (मोबाईल क्र.)" />:</span></td>
			<td colspan="2">
					<input type="text" class="form-control" style="width: 180px"
						id="ph_no" maxlength="50" name="ph_no"
						value="<c:out value="${mandapPermission.mobileNo}"/>" disabled/>
				</td>

			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Email (ईमेल आयडी )" /></span><span class="ClsRequiredFields"></span></td>
			<td colspan="2">
					<input type="text" class="form-control" id="email"
						style="width: 230px" name="email"
						value="<c:out value="${mandapPermission.email}"/>" disabled/>
				</td>
		</tr>
		<tr>
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Name and Address of the Institution / Board(संस्था / मंडळाचे नाव आणि पत्ता)" /></span><span class="ClsRequiredFields"></span>
			</td>
			<td colspan="2">
					<input type="text" class="form-control" id="dob"
						style="width: 180px" name="dob"
						value="<c:out value="${mandapPermission.addressforInstitution}"/>" disabled/>
				</td>

			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Venue / Address of the event(कार्यक्रमाचे ठिकाण / पत्ता)" />:</span></td>
			<td colspan="2">
					<input type="text" class="form-control" id="gender"
						style="width: 180px" name="venueAddress"
						value="<c:out value="${mandapPermission.venueAddress}"/>" disabled/>
			</td>
		</tr>
		<tr>

			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Registration No. if the organization/Board is registered(संस्था/मंडळ नोंदणीकृत असल्यास नोंदणी क्र)" />:</span></td>
			<td colspan="2">

					<input type="text" class="form-control" style="width: 180px"
						id="childeName" maxlength="45" tabindex="3" name="childeName"
						value="<c:out value="${mandapPermission.registrationNo}"/>" disabled/>
			</td>

			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Zone No. (झोन
							क्र.)" /></span><span class="ClsRequiredFields">:</span>
			</td>
			<td colspan="2">
					<input type="text" class="form-control" style="width: 180px"
						id="fatherName" maxlength="45" tabindex="4" name="fatherName"
						value="<c:out value="${mandapPermission.zoneNo}"/>" disabled/>
				</td>

		</tr>
		<tr>


			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Ward No. (प्रभाग क्र.)" /></span><span class="ClsRequiredFields"></span>:
			</td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 180px" id="motherName" tabindex="5" maxlength="45"
				name="motherName"
				value="<c:out value="${mandapPermission.wardNo}"/>" disabled/></td>

			<%-- <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Date of Event/Program
							(कार्यक्रम/कार्यक्रमाची तारीख)" />:</span></td>
			<td colspan="2"><input type="date" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mandapPermission.eventDate}"/>" disabled/></td> --%>

		</tr>
		
		
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.fromdate" />:</span></td>
			<td colspan="2"><input type="date" class="form-control" style="width: 180px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${mandapPermission.pavilionStartDate}"/>" disabled/></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.todate" /><span class="ClsRequiredFields"></span>:
			</td>
			<td colspan="2"><input type="date" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mandapPermission.pavilionEndDate}"/>" disabled/></td>

		</tr>
		

		<tr>
				<td colspan="1.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message key="The total number of devotees who can be present in the mandap at a time(
एकावेळी मंडपात उपस्थित राहू शकणार्‍या एकूण भाविकांची संख्या)" />:</span>
				</td>
				<td colspan="2">
						<input type="text" class="form-control" style="width: 180px"
							id="countryName" tabindex="5" maxlength="45" name="countryName"
							value="<c:out value="${mandapPermission.noOfDevotes}"/>"  disabled/>
					</td>
			
				<td colspan=""><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Height(उंची))" />:</span></td>
				<td colspan="2">
						<input type="text" class="form-control" style="width: 180px"
							id="homeAddress" tabindex="5" maxlength="45" name="height"
							value="<c:out value="${mandapPermission.height}"/>" disabled/>
                </td>
		
		</tr>
		
		<tr>
			<td colspan="7"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Area/Size of Pavilion
							(मंडपचे क्षेत्रफळ/आकार)" /><span
					class="ClsRequiredFields"></span>:</span></td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Length (लांबी)" />:</span></td>
			<td><input type="text" class="form-control"
				id="certificateExpectedInDays" maxlength="10"
				name="certificateExpectedInDays"
				value="<c:out value="${mandapPermission.pavilionLength} ft"/>" disabled/>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Breadth (रुंदी)" />:</span></td>
			<td><input type="text" class="form-control"
				id="noOfCertificateCopies" maxlength="10"
				name="noOfCertificateCopies"
				value="<c:out value="${mandapPermission.pavilionBreadth} ft"/>" disabled/>
			</td>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Total Size (एकूण आकार)" />:</span></td>
			<td><input type="text" class="form-control" id=""
				maxlength="10" name=""
				value="<c:out value="${mandapPermission.totalSize}"/>" disabled/></td>
				
				
		</tr>
	
	
			<tr>
			<td colspan="7"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Entry Gate Size (प्रवेशद्वार आकार)" /><span
					class="ClsRequiredFields"></span>:</span></td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Length (लांबी)" />:</span></td>
			<td><input type="text" class="form-control"
				id="certificateExpectedInDays" maxlength="10"
				name="certificateExpectedInDays"
				value="<c:out value="${mandapPermission.gateLength} ft"/>" disabled/>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Breadth (रुंदी)" />:</span></td>
			<td><input type="text" class="form-control"
				id="noOfCertificateCopies" maxlength="10"
				name="noOfCertificateCopies"
				value="<c:out value="${mandapPermission.gateBreadth} ft"/>" disabled/>
			</td>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Total Size (एकूण आकार)" />:</span></td>
			<td><input type="text" class="form-control" id=""
				maxlength="10" name=""
				value="<c:out value="${mandapPermission.gatetotalSize}"/>" disabled/></td>
				
				
		</tr>
	
	
	
				<tr>
			<td colspan="7"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Advertisement Size(जाहिरात आकार)" /><span
					class="ClsRequiredFields"></span>:</span></td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Length (लांबी)" />:</span></td>
			<td><input type="text" class="form-control"
				id="certificateExpectedInDays" maxlength="10"
				name="certificateExpectedInDays"
				value="<c:out value="${mandapPermission.advLength} ft"/>" disabled/>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Breadth (रुंदी)" />:</span></td>
			<td><input type="text" class="form-control"
				id="noOfCertificateCopies" maxlength="10"
				name="noOfCertificateCopies"
				value="<c:out value="${mandapPermission.advBreadth} ft"/>" disabled/>
			</td>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Total Size (एकूण आकार)" />:</span></td>
			<td><input type="text" class="form-control" id=""
				maxlength="10" name=""
				value="<c:out value="${mandapPermission.advtotalSize}"/>" disabled/></td>
				
				
		</tr>
		
		<tr>
		
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Entry gate fees (प्रवेश द्वाराचे शुल्क)" />:</span></td>
			<td><input type="text" class="form-control"
				id="feesApplicable" maxlength="10"
				name="fees"
				value="<c:out value="${mandapPermission.fees}"/>" disabled/>
				</td>
				
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Cleaning charges (सफाई शुल्क)" />:</span></td>
			<td><input type="text" class="form-control"
				id="feesApplicable" maxlength="10"
				name="fees"
				value="<c:out value="${mandapPermission.cleaningfees}"/>" disabled/>
				</td>
				
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Total Fees (एकूण शुल्क)" />:</span></td>
			<td><input type="text" class="form-control" id=""
				maxlength="10" name=""
				value="<c:out value="${totalfees}"/>" disabled/></td>
				
		</tr>
		
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Date of Durga immersion (दुर्गा विसर्जनाची तारीख)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				id="" maxlength="10"
				name=""
				value="<c:out value="${mandapPermission.durgaUtsavImmersion}"/>" disabled/></td>
				
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Rout of Visarjan / (मिरवणुकीचा प्रस्तावित मार्ग)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				id="" maxlength="10"
				name=""
				value="<c:out value="${mandapPermission.route}"/>" disabled/></td>
			
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Concerned Police Station (संबंधित पोलीस स्टेशन)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				id="" maxlength="10"
				name=""
				value="<c:out value="${mandapPermission.policeStation}"/>" disabled/></td>
				
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Place of Durga Visarjan (दुर्गा विसर्जनाचे ठिकाण)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				id="noOfCertificateCopies" maxlength="10"
				name="noOfCertificateCopies"
				value="<c:out value="${mandapPermission.durgaUtsavVisarjan}"/>" disabled/>
			</td>
			
		</tr>
		<tr>
		<td colspan="4"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Duration of Sounding Permit
							(ध्वनीक्षेपणाच्या परवानगीचा कालावधी)" /><span
					class="ClsRequiredFields"></span>:</span></td>
		</tr>
		
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="From Date (या तारखेपासून)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				id="" maxlength="10"
				name=""
				value="<c:out value="${mandapPermission.fromdate}"/>" disabled/></td>
				
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="To Date (या तारीखेपर्यंत)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				id="noOfCertificateCopies" maxlength="10"
				name="noOfCertificateCopies"
				value="<c:out value="${mandapPermission.todate}"/>" disabled/>
			</td>
			
		</tr>
		
		
			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Where to get power supply / alternative power supply measures (विदुत पुरवठा कुठून घेणार  / पर्यायी विदुत पुरवठ्याची उपाययोजना)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				id="" maxlength="10"
				name=""
				value="<c:out value="${mandapPermission.powersupply}"/>" disabled/></td>
				
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Durga idol is made of which material (गणेशमूर्ती कुठल्या प्रकारची आहे)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				id="noOfCertificateCopies" maxlength="10"
				name="noOfCertificateCopies"
				value="<c:out value="${mandapPermission.metal}"/>" disabled/>
			</td>
			
		</tr>
		
		
	<tr>
			<td colspan="7"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Requirements for No Objection Certificate of Fire Department (अग्निशमन विभागाच्या ना हरकत प्रमाणपत्राची आवश्यकता)" /><span
					class="ClsRequiredFields"></span>:</span></td>
		</tr>
	
	<td colspan="7">
				<table>
            <tr>
                       <td>
							<span class="ClsLabel"><fmt:message key="Is the height of the idol to be installed more than 4 feet?" /> </span>
		                   							<span class="ClsLabel"><fmt:message key="स्थापन करण्यात येणाऱ्या मूर्तीची उंची ४ फूट पेक्षा जास्त आहे काय ?" /> </span></td>
		                   				<td>${mandapPermission.idol}</td>
						
						</tr>
						
							<tr>
						<td>
							<span class="ClsLabel"><fmt:message key="Is there a minimum 9 meter wide path for fire fighting vehicles to reach the pavilion?" /> </span>
							<span class="ClsLabel">मंडपात पोहचण्यास अग्निशमन वाहनाकरिता किमान ९ मीटर रुंदीचा मार्ग उपलब्ध आहे काय ?</span>
						 <td>${mandapPermission.vehicle}</td>
						</tr>
						
						<tr>
						<td>
							<span class="ClsLabel"><fmt:message key="Will there be at least 4.50 meters free space around the mandap so that the fire does not spread in the surrounding buildings?" /> </span>
							<span class="ClsLabel">आसपासच्या इमारती मध्ये आग पसरणार नाही याकरिता मंडपाच्या भोवताल किमान ४.५० मीटर मोकळी जागा येणार आहे काय ?</span></td>
						<td>${mandapPermission.building}</td>
						</tr>
						
						<tr>
						<td>
							<span class="ClsLabel"><fmt:message key="Is there 3 meter wide gates/ways/doors available in opposite directions for safe evacuation of citizens in case of emergency?" /> </span>
						<span class="ClsLabel"><fmt:message key="आपत्कालीन परिस्थितीत नागरिकांना सुरक्षित बाहेर पाडण्याकरिता परस्पर विरुद्ध दिशेला ३ मीटर रुंदीचे गेट/मार्ग/दरवाजे उपलब्ध आहेत काय ?" /> </span></td>
						<td>${mandapPermission.evacuation}</td>
						
						</tr>
						
						<tr>
						<td>
							<span class="ClsLabel"><fmt:message key="Is there going to be a kitchen and firecrackers for fuel prasad in the mandap?" /> </span>
							<span class="ClsLabel">मंडपात इंधन प्रसादाकरिता स्वयंपाक घर तसेस फटाक्यांचा साथ करण्यात येणार आहे काय ?</span></td>
						<td>${mandapPermission.firecrackers}</td>
						</tr>
						
						<tr>
						<td>
							<span class="ClsLabel"><fmt:message key="Will the members of committee be trained for First-aid,  fire fighting equipment and safe evacuation of people in emergency situations?" /> </span>
							<span class="ClsLabel">मंडपात इंधन प्रसादाकरिता स्वयंपाक घर तसेस फटाक्यांचा साथ करण्यात येणार आहे काय ?</span></td>
						<td>${mandapPermission.wiring}</td>
						
						</tr>
						
						<tr>
						<td>
							<span class="ClsLabel"><fmt:message key="Will alternate power arrangements be made available in the form of emergency generators?" /> </span>
							<span class="ClsLabel">आपत्कालीन जनरेटरच्या स्वरूपात पर्यायी वीज व्यवस्था उपलब्ध करून दिली जाईल का?</span></td>
						<td>${mandapPermission.generators}</td>
						
						</tr>
						
						<tr>
						<td>
							<span class="ClsLabel"><fmt:message key="2 Units of 5 kg capacity A B C type fire extinguishers and 200 liter capacity water drum will be kept in the pavilion for fire fighting?" /> </span>
							<span class="ClsLabel">अग्निशमनासाठी 5 किलो क्षमतेची A B C प्रकारची अग्निशामक यंत्रे आणि 200 लिटर क्षमतेचे पाण्याचे ड्रम पॅव्हेलियनमध्ये ठेवण्यात येणार आहेत?</span></td>
						<td>${mandapPermission.extinguisher}</td>
						
						</tr>
						
						<tr>
						<td>
							<span class="ClsLabel"><fmt:message key="Will the workers in the board be trained in first aid use of fire fighting equipment and safe evacuation of people in emergency situations?" /> </span>
							<span class="ClsLabel">मंडळातील कामगारांना अग्निशमन उपकरणांचा प्रथमोपचार आणि आपत्कालीन परिस्थितीत लोकांना सुरक्षितपणे बाहेर काढण्याचे प्रशिक्षण दिले जाईल का?</span></td>
						<td>${mandapPermission.trained}</td>
						
						</tr>
						
						<tr>
						<td>
							<span class="ClsLabel"><fmt:message key="Will 2 Units of 5 kg fire extinguisher and 200 liter capacity water drum be kept in the mandap for fire fighting?" /> </span>
							<span class="ClsLabel">आग विझवण्यासाठी 5 किलोचे अग्निशामक यंत्र आणि 200 लिटर क्षमतेचे पाण्याचे ड्रम मंडपात 2 युनिट्स अग्निशमनासाठी ठेवल्या जातील का?</span></td>
						<td>${mandapPermission.pavilionfighting}</td>
						
						</tr>
						
						<tr>
						<td>
							<span class="ClsLabel"><fmt:message key="Is permission taken for loudspeakers?" /> </span>
							<span class="ClsLabel">लाऊड स्पीकर ची परवानगी घेतली आहे काय ?</span></td>
						<td>${mandapPermission.loudspeaker}</td>
						
						</tr>

    </table>
	
	
	
	
	
	  <c:if test="${requestScope.rtiApplication.workFlowStatus==2 && empty requestScope.rtiApplication.pdfFilesSavedPath}">

<tr>
	       	<td colspan="6" align="center"><a
						class="bg-button btn btn-success bd-highlight generateaction"
						id="genCerBtn" style="color: white"
						onclick="downloads('${mandapPermission.rti_ref_id}', 'durgaUtsavMandapCertificateReport.do');"
						type="button" target="_blank"> <span class="download"
							style="display: flex; align-items: center;width: 135px;">Generate
								Certificate</span>
					</a>
					<a class="bg-button btn btn-success bd-highlight action"
											style="color: white" id="dsc" type="button" target="_blank"
											onclick="download1(${mandapPermission.rti_ref_id});return false;"><span
												class="download" style="align-items: center">Apply
													DSC</span></a></td>
                    
                    
           </td> 
           </tr>
</c:if>
	
		<tr>
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px">
					Current Status:</span></td>
			<td style="width: 230px; height: 30px"><span class="ClsLabel" style="font-size:14px;color:forestgreen;"> <c:if
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
										<c:if test="${requestScope.forLogin eq 'L4'}">
					
					<c:if test="${requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus==1}">
			<td colspan="2"><span class="ClsLabel" style="font-size: 14px">Certificate
					Upload: </span></td>
			<%@include file="/pages/common-pages/dms/fileUpload.jsp"%>
</c:if>
</c:if>
			<%--<td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Birth Place" />:</span>
                        </td>
                         <td> <span class="ClsLabel" style="font-size:14px"><fmt:message key="Remark" />:</span></td>
                        <td >
                            
                                <input type="text" class="ClsTextbox_mr" style="width:180px" id="Remark" maxlength="12" name="Remark" value=""  />
                            
                        </td>
                         --%>
		</tr>
		</table>
	<table width="100%" border="0" cellpadding="2" cellspacing="2">

		<tr>
			<td colspan="7"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="List of Documents (Attachment) दस्तऐवजांची यादी (संलग्नक)" />:</span></td>
		</tr>

<input type="hidden" name="filesPath" value=""/>


		<c:if test="${doc[0] != 'null'}">
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="Site Viewer Map with Detailed Information ( तपशीलवार माहितीसह साइट दर्शक नकाशा)" />:</span> 
					
				<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
			</tr>
		</c:if>
		
		<c:if test="${doc[1] != 'null'}">
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="Download and upload signed Affidavit<br>(
स्वाक्षरी केलेले प्रतिज्ञापत्र डाउनलोड आणि अपलोड करा)" />:</span> 
				<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[1]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
			</tr>
		</c:if>
		<c:if test="${doc[2] != 'null'}">
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="Affidavit as per High Court order <br>
(मा. उच्च न्यायालयाच्या नागपुर खडंपीठ आदेशानुसार प्रतिज्ञापत्र) " />:</span> 
				<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[2]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
			</tr>
		</c:if>
		<!-- Files Uploading -->
<c:if test="${requestScope.forLogin eq 'L1' || requestScope.forLogin eq 'L2' ||  requestScope.forLogin eq 'L4' && ( requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus==1 || requestScope.rtiApplication.workFlowStatus==5 || requestScope.rtiApplication.workFlowStatus==3 ||requestScope.rtiApplication.workFlowStatus==0)}">
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="NOC From Police Department (पोलिस विभागाकडून एनओसी)" />:</span> 
				    <c:choose>
        <c:when test="${empty mandapPermission.policeNoc}">
				<td style="text-align: center" colspan="3.5">
			<input type="file" name="idProof" id="doc1" class="imagefile" style="width: 168px" /><br>
			<hr>
<button style="margin-right: 15px; margin-top: 2px;"  onclick="policedownload(${mandapPermission.rti_ref_id},'durgaUtsavpoliceNocCertificateReport.do')">Download Sample NOC</button>
			</td>
                 <td>
             
  <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="upload1"  type="button" target="_blank" onclick="javascript:uploadPoliceNoc(this);"><span
							class="download" style="align-items: center">Upload</span></a>        </c:when>
        <c:when test="${not empty mandapPermission.policeNoc}">
          <td style="text-align: center" colspan="3.5"> 							
<a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${mandapPermission.policeNoc}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
        </c:when>
    </c:choose>
</td>

			</tr>
			</c:if>

<c:if test="${requestScope.forLogin eq 'L1' || requestScope.forLogin eq 'L2' || requestScope.forLogin eq 'L4' && ( requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus==1 || requestScope.rtiApplication.workFlowStatus==5 || requestScope.rtiApplication.workFlowStatus==3 ||requestScope.rtiApplication.workFlowStatus==0)}">
		
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="NOC From Traffic Department (वाहतूक विभागाकडून एनओसी)" />:</span> 
				
				 <c:choose>
        <c:when test="${empty mandapPermission.trafficNoc}">
        <td style="text-align: center" colspan="3.5">
				<input type="file" name="idProof" id="doc3" class="imagefile" style="width: 168px" />
				<hr>
<button style="margin-right: 15px; margin-top: 2px;" onclick="trafficdownload(${mandapPermission.rti_ref_id},'durgaUtsavtrafficNocCertificateReport.do')">Download Traffic NOC</button>
			</td>
            <td>
   
 <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="upload3"  type="button" target="_blank" onclick="javascript:uploadTrafficNoc(this);"><span
							class="download" style="align-items: center">Upload</span></a>        </c:when>
        <c:when test="${not empty mandapPermission.trafficNoc}">
        <td style="text-align: center" colspan="3.5">
            <a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${mandapPermission.trafficNoc}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
        </c:when>
    </c:choose>
</td>

			</tr>
			</c:if>
			
<c:if test="${requestScope.forLogin eq 'L3' || requestScope.forLogin eq 'L4' && ( requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus==1 || requestScope.rtiApplication.workFlowStatus==5 || requestScope.rtiApplication.workFlowStatus==3 ||requestScope.rtiApplication.workFlowStatus==0)}">
			
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="NOC From Fire Department (
अग्निशमन विभागाकडून एनओसी)" />:</span> 
				<td style="text-align: center" colspan="3.5">
				 <c:choose>
        <c:when test="${empty mandapPermission.fireNoc}">
				<input type="file" name="doc2" id="doc2" class="imagefile" style="width: 168px" />
				<hr>
<button style="margin-right: 15px; margin-top: 2px;" onclick="firedownload(${mandapPermission.rti_ref_id},'durgaUtsavfireNocCertificateReport.do')">Download Fire NOC</button>
			<td style="text-align: center" colspan="3.5">
   
  <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="upload2"  type="button" target="_blank" onclick="javascript:uploadFireNoc(this);"><span
							class="download" style="align-items: center">Upload</span></a>        </c:when>
        <c:when test="${not empty mandapPermission.fireNoc}">
           <a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${mandapPermission.fireNoc}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
        </c:when>
    </c:choose>
</td>


			</tr>
		
			
			</c:if>
			
	<table width="100%" border="0" cellpadding="1" cellspacing="1">
<c:if test="${requestScope.forLogin eq 'L1' || requestScope.forLogin eq 'L2' ||  requestScope.forLogin eq 'L4' && ( requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus==1 || requestScope.rtiApplication.workFlowStatus==5 || requestScope.rtiApplication.workFlowStatus==3 ||requestScope.rtiApplication.workFlowStatus==0)}">
	
			<tr>
			
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Remarks (टिप्पणी)" />:</span></td>
						<td>
		 <textarea
					class="form-control" style="width: 400px" id="ploiceremarks"
					maxlength="30" name="ploiceremarks" maxlength="80" readonly>${mandapPermission.ploiceremarks}</textarea>
			
			</td></tr></c:if>
			
			
<c:if test="${requestScope.forLogin eq 'L3' ||  requestScope.forLogin eq 'L4' && ( requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus==1 || requestScope.rtiApplication.workFlowStatus==5 || requestScope.rtiApplication.workFlowStatus==3 || requestScope.rtiApplication.workFlowStatus==0)}">
			
						<tr>
			
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Fire Remarks (फायर रिमार्क्स)" />:</span></td>
						<td>
		 <textarea
					class="form-control" style="width: 400px" id="fireremarks"
					maxlength="30" name="fireremarks" maxlength="80" readonly>${mandapPermission.fireremarks}</textarea>
			
			</td>
			</tr></c:if>
			
		
		</table>
		
		

		<%--  <tr>
            <td colspan="6" style="padding-top:5px">
                <img src="../images/Transpx.gif" height="15px" />
            </td>
        </tr>
         <tr>
            <td colspan="6" align="center">
                <input type="button" class="ClsButton" id="save" name="save" value="Save"
                       onclick="javascript:saveBirthRegistrationCertificate(this.form);" tabindex="31">
                       <input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>"
							onclick="javascript:clearFields('SearchTable');searchRTIApplication()" /> --%>
							
		<input type="hidden" name="UID" value="${mandapPermission.rti_ref_id}" />
		
	  <c:if test="${requestScope.rtiApplication.workFlowStatus!=1 && (requestScope.forLogin eq 'L1' || requestScope.forLogin eq 'L2' || requestScope.forLogin eq 'L3')}">	  	
<tr>

<td colspan="4" align="center"><input type="button"
				class="btn btn-primary"
				style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745;margin-left:50px;"
				id="saveFeesAmt" name="savefees"
				value="<fmt:message key="Save"/>"
				onclick="javascript:saveFees(this.form);">
</td>
</tr>
</c:if>
			<c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
	<tr>
					<td colspan="4" align="center">
    <a class="btn btn-primary"
       style="min-height: 30px; min-width: 80px; color: white; border: none;"
       onclick="resendDemandPayment('${mandapPermission.fullName}', '${mandapPermission.mobileNo}', '${mandapPermission.rtiapplrefno}', '${mandapPermission.email}')">
       Resend demand
    </a>
</td>

<script>
    function resendDemandPayment(name, mobileNo, applnNo, email) {
        // Use URL-encoded parameters in GET request
        const contextRoot = '<c:out value="${contextRoot}"/>';
        const url = contextRoot + '/rtiApplication/resendDurgaPayment.do'
            + '?name=' + encodeURIComponent(name)
            + '&mobileNo=' + encodeURIComponent(mobileNo)
            + '&applnNo=' + encodeURIComponent(applnNo)
            + '&email=' + encodeURIComponent(email);

        fetch(url)
            .then(response => {
                if (response.ok) {
                    alert('Payment link has been resent successfully.');
                } else {
                    alert('Failed to resend payment link.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Error occurred while resending payment link.');
            });
    }
</script>
							</tr>

			</c:if>

	</table>

	<input type="hidden" class="ClsTextbox_mr" style="width: 180px"
		id="durgaUtsavMandapPermissionId" maxlength="12" name="durgaUtsavMandapPermissionId"
		value="<c:out value="${mandapPermission.durgaUtsavMandapPermissionId}"/>" /> 
		
		<%-- <input
		type="hidden" class="ClsTextbox_mr" style="width: 180px;"
		id="rtiApplicationRefId" maxlength="12" name="rtiApplicationRefId"
		value="<c:out value="${requestScope.rtiApplication.rtiApplicationId}"/>" />
		 --%>
		
</table>
			  <input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="" />
			  			  <input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${mandapPermission.rti_ref_id}" />
			  <input type="hidden" id="responseData" name="responseData"
								value="" />
	
<c:if test="${requestScope.forLogin eq 'L4'}">

	<%@include file="/pages/workflow/taskInclude.jsp"%>
	</c:if>


</div>
</div>

<script type="text/javascript">
	function saveEntity() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/createDurgaUtsavMandapPermissionWork.do');
	}
	</script>
	
		
<script type="text/javascript">
function cleanPoliceInput(value) {
    value = value.trim();
    value = value.replace(/(\r\n|\n|\r){2,}/g, '\n');
    $('#ploiceremarks').val(value);
    return value;
}
function cleanFireInput(value) {
    value = value.trim();
    value = value.replace(/(\r\n|\n|\r){2,}/g, '\n');
    $('#fireremarks').val(value);
    return value;
}
function saveFees(){
    var forLogin = "${requestScope.forLogin}";
    var policeRemarks = $('#ploiceremarks').val();
    var fireRemarks = $('#fireremarks').val();
    var flag = false;

	var policeremarks = $('#ploiceremarks').val();
var fireremarks = $('#fireremarks').val();

if(policeRemarks !== null && policeRemarks !== undefined){
	var policeRemarks=cleanPoliceInput(policeremarks);

}

if(fireRemarks !== null && fireRemarks !== undefined){
	var fireRemarks=cleanFireInput(fireremarks);

}



    function hasFiles(inputSelector) {
        var input = $(inputSelector).get(0);
        return input && input.files.length > 0;
    }
  
    
    var policeUpload = '${mandapPermission.policeNoc}';
    var trafficUpload='${mandapPermission.trafficNoc}';
    var fireUpload = '${mandapPermission.fireNoc}';
    
    if (forLogin === 'L1' || forLogin === 'L2') {
        if (policeRemarks !== '') {
            if (policeUpload==='' || trafficUpload==='') {
                if (confirm("Are you sure you want to save without uploading Police/Traffic NOC?")) {
                    flag = true;
                } else {
                    return false;
                }
            } else {
                if (confirm("Are you sure you want to save?")) {
                    flag = true;
                } else {
                    return false;
                }
            }
        } else {
            alert("Please enter Remarks!");
            return false;
        }
    } else if (forLogin === 'L3') {
        if (fireRemarks !== '') {
            if (fireUpload==='') {
                if (confirm("Are you sure you want to save without uploading Fire NOC?")) {
                    flag = true;
                } else {
                    return false;
                }
            } else {
                if (confirm("Are you sure you want to save?")) {
                    flag = true;
                } else {
                    return false;
                }
            }
        } else {
            alert("Please enter Remarks!");
            return false;
        }
    }
    
    if (flag) {
        onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveDurgaUtsavMandap.do');
    }
}
</script>
	<script type="text/javascript">

	$(document).ready(function() {
	    var ploiceremarks = '${mandapPermission.ploiceremarks}';
	    var trafficremarks = '${mandapPermission.trafficremarks}';
	    var fireremarks = '${mandapPermission.fireremarks}';


	    if (durgaUtsavMandapPermissionId && ploiceremarks.trim() !== "") {
	        $("#ploiceremarks").prop('readonly', true);
	    } else {
	        $("#ploiceremarks").prop('readonly', false);
	    }
	    
	    if (durgaUtsavMandapPermissionId && trafficremarks.trim() !== "") {
	        $("#trafficremarks").prop('readonly', true);
	    } else {
	        $("#trafficremarks").prop('readonly', false);
	    }
	    
	    if (durgaUtsavMandapPermissionId && fireremarks.trim() !== "") {
	        $("#fireremarks").prop('readonly', true);
	    } else {
	        $("#fireremarks").prop('readonly', false);
	    }
	});

</script>
<script>
	$(document).ready(function() {
	    var forLogin = "${requestScope.forLogin}"; 
	    var ploiceremarks = '${mandapPermission.ploiceremarks}';
	    var fireremarks = '${mandapPermission.fireremarks}';
	    if (forLogin==='L4') {
	    	 $("#doc1").prop('disabled', true);
		        $("#doc2").prop('disabled', true);
		        $("#doc3").prop('disabled', true);
		        $("#upload1").hide();
		        $("#upload2").hide();
		        $("#upload3").hide();
		        $("#ploiceremarks").attr("disabled", true);
		        $("#trafficremarks").attr("disabled", true);
		        $("#fireremarks").attr("disabled", true);
		        $("#ploiceremarks").attr("disabled", true);
		        $("#policeSampleDoc").attr("disabled", true);
		        $("#trafficSampleDoc").attr("disabled", true);
		        $("#fireSampleDoc").attr("disabled", true);

	    }
	    
	    if(ploiceremarks!==''){
	    /* 	$("#doc1").prop('disabled', true);
	    	$("#doc3").prop('disabled', true);
	        $("#upload1").hide();
	        $("#upload3").hide();
	        $("#ploiceremarks").attr("disabled", true);
	        $("#policeSampleDoc").attr("disabled", true);
	        $("#trafficSampleDoc").attr("disabled", true); */
	        if(forLogin==='L1' || forLogin==='L2'){
		        $('#saveFeesAmt').hide();
	        }
	    }
	    
	    if(fireremarks!==''){
	    	 /* 
		        $("#doc2").prop('disabled', true);

		        $("#upload2").hide();
		        $("#fireremarks").attr("disabled", true);
		        $("#fireSampleDoc").attr("disabled", true); */
		        if(forLogin==='L3'){
			        $('#saveFeesAmt').hide();
		        } 
		        }
	    
	    
	   
	    
	});
	</script>
		<script type="text/javascript">

	$(document).ready(function() {
	    var ploiceremarks = '${mandapPermission.ploiceremarks}';
	    var trafficremarks = '${mandapPermission.ploiceremarks}';
	    var fireremarks = '${mandapPermission.fireremarks}';
	    var forLogin = "${requestScope.forLogin}";  
	    var workflowStatus="${requestScope.rtiApplication.workFlowStatus}";
	    var applicationCost="${requestScope.rtiApplication.applicationCost}";

		
	    if (ploiceremarks.trim() !== "") {
	        $("#ploiceremarks").prop('readonly', true);
	    } else {
	        $("#ploiceremarks").prop('readonly', false);
	    }
	    
	    if (trafficremarks.trim() !== "") {
	        $("#trafficremarks").prop('readonly', true);
	    } else {
	        $("#trafficremarks").prop('readonly', false);
	    }
	    
	    if (fireremarks.trim() !== "") {
	        $("#fireremarks").prop('readonly', true);
	    } else {
	        $("#fireremarks").prop('readonly', false);
	    }
	    
	    if (forLogin==='L1' || forLogin==='L2' || forLogin==='L3') {
        	
	    	var elements = document.getElementsByClassName("tab")[0];

	    	if (elements) { 
	    	    elements.innerHTML = "You don't have permission".fontcolor("red");
	    	    $('#commentsDisable *').attr('disabled', true);
	            $('#CreateWorkflow').attr('disabled', true);
	            $('#RejectCreateWorkflow').attr('disabled', true);
	            $('#WORKFLOW_COMMENTS').attr('disabled', true);
	    	}
		      
        }else if(forLogin==='L4'){
        	$('#saveFeesAmt').hide();
        	if (ploiceremarks.trim() !== "" && trafficremarks.trim() !== "" && fireremarks.trim() !== "") {
        		if(workflowStatus==='1'){
       			 var elements = document.getElementsByClassName("tab")[0];
       	         elements.innerHTML = "Application closed & NOC Uploaded Successfully.".fontcolor("Green");
       	      $('#commentsDisable *').attr('disabled', true);
              $('#CreateWorkflow').attr('disabled', true);
              $('#RejectCreateWorkflow').attr('disabled', true);
              $('#WORKFLOW_COMMENTS').attr('disabled', true);
       		}else if(workflowStatus==='5'){
       			
       			$('#saveFeesAmt').hide();
       		 var elements = document.getElementsByClassName("tab")[0];
       		 elements.innerHTML = "Application is Rejected".fontcolor("red");
       	  $('#commentsDisable *').attr('disabled', true);
          $('#CreateWorkflow').attr('disabled', true);
          $('#RejectCreateWorkflow').attr('disabled', true);
          $('#WORKFLOW_COMMENTS').attr('disabled', true);
        		
        	}else{
        		$('#certificateActive').show();
        		 var elements = document.getElementsByClassName("tab")[0];
                 elements.innerHTML = "Please take necessary actions by clicking on action buttons.".fontcolor("Green");
                 $('#commentsDisable *').attr('disabled', false);
                 $('#CreateWorkflow').attr('disabled', false);
                 $('#RejectCreateWorkflow').attr('disabled', false);
                 $('#WORKFLOW_COMMENTS').attr('disabled', false);
       		}
        	}else{
            	$('#saveFeesAmt').hide();
        		 var elements = document.getElementsByClassName("tab")[0];
        		 elements.innerHTML = "Currently, you don't have permission to work on this task.".fontcolor("red");
        		  $('#commentsDisable *').attr('disabled', true);
                  $('#CreateWorkflow').attr('disabled', true);
                  $('#RejectCreateWorkflow').attr('disabled', true);
                  $('#WORKFLOW_COMMENTS').attr('disabled', true);
        	}
        }else{
        	$('#saveFeesAmt').hide();
   		 var elements = document.getElementsByClassName("tab")[0];
            elements.innerHTML = "You don't have permission.".fontcolor("red");
            $('#commentsDisable *').attr('disabled', true);
            $('#CreateWorkflow').attr('disabled', true);
            $('#RejectCreateWorkflow').attr('disabled', true);
            $('#WORKFLOW_COMMENTS').attr('disabled', true);
   	}
	    
	    if(workflowStatus==='5'){
   			
   			$('#saveFeesAmt').hide();
	    }
	    
	   
	});

</script>
		<script type="text/javascript">
	
    function uploadPoliceNoc() {
        console.log("@@upoading@@");
        var url = window.location.href;
        var basePath = url.split('${contextRoot}')[0] + '${contextRoot}/';
        var filesPath = "";
        var data = new FormData();
        var idProofFile = $("#doc1").get(0).files[0];
        

        if (!idProofFile) {
            alert("Please upload the Police NOC certificate.");
            return; 
        }
        
        var fileName = idProofFile.name;
        var fileExtension = fileName.split('.').pop().toLowerCase();

        if (fileExtension !== 'pdf') {
            alert("Please select a PDF file.");
            return;
        }
        
        data.append('idProof1', $("#doc1").get(0).files[0]);


        var isFileSelected = false

        var array_element = "";
        var file = $('input[id="doc1"]');
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
                filesPath = filesPath + basePath + "durgaUtsavPermission/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 1;
        var uid1 = document.getElementById('durgaUtsavMandapPermissionId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadDurgaUtsavMandapNoc.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false 
            }).done(function (data) {
            	if(data.status==true || data.status=='true'){
              	  
                    alert("Police NOC Certificate uploaded Successfully");
                    window.location.reload(); 
              	}else{
                      alert("Police NOC Certificate upload failed!!");

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
        var basePath = url.split('${contextRoot}')[0] + '${contextRoot}/';
        var filesPath = "";
        var data = new FormData();
        var idProofFile = $("#doc2").get(0).files[0];
        if (!idProofFile) {
            alert("Please upload the Fire NOC certificate.");
            return; 
        }
        var fileName = idProofFile.name;
        var fileExtension = fileName.split('.').pop().toLowerCase();

        if (fileExtension !== 'pdf') {
            alert("Please select a PDF file.");
            return;
        }
        data.append('idProof2', $("#doc2").get(0).files[0]);


        var isFileSelected = false

        var array_element = "";
        var file = $('input[id="doc2"]');
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
                filesPath = filesPath + basePath + "durgaUtsavPermission/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 2;
        var uid1 = document.getElementById('durgaUtsavMandapPermissionId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadDurgaUtsavMandapNoc.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false 
        }).done(function (data) {
        	if(data.status==true || data.status=='true'){
            	  
                alert("Fire NOC Certificate uploaded Successfully");
                window.location.reload(); 
          	}else{
                  alert("Fire NOC Certificate upload failed!!");

          	}
        });

        var a = filesPath.substring(0, filesPath.lastIndexOf(","));
        filesPath = filesPath.replace(/\s/g, "");
        $("#filesPath").val(filesPath);
        console.log(filesPath);

    }
    </script>
    
    	<script type="text/javascript">
    
    function uploadTrafficNoc() {
        console.log("@@upoading@@");
        var url = window.location.href;
        var basePath = url.split('${contextRoot}')[0] + '${contextRoot}/';
        var filesPath = "";
        var data = new FormData();

        var idProofFile = $("#doc3").get(0).files[0];

        if (!idProofFile) {
            alert("Please upload the Traffic NOC certificate.");
            return; 
        }
        
        var fileName = idProofFile.name;
        var fileExtension = fileName.split('.').pop().toLowerCase();

        if (fileExtension !== 'pdf') {
            alert("Please select a PDF file.");
            return;
        }
        
        data.append('idProof3', $("#doc3").get(0).files[0]);


        var isFileSelected = false

        var array_element = "";
        var file = $('input[id="doc3"]');
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
                filesPath = filesPath + basePath + "durgaUtsavPermission/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 3;
        var uid1 = document.getElementById('durgaUtsavMandapPermissionId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadDurgaUtsavMandapNoc.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false 
        }).done(function (data) {
        	if(data.status==true || data.status=='true'){
          	  
                alert("Traffic NOC Certificate uploaded Successfully");
                window.location.reload(); 
          	}else{
                alert("Traffic NOC Certificate upload failed!!");

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