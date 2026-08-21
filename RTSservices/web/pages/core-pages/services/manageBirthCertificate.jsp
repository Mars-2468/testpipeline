<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
</script>
<style type="text/css">
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
</style>

<div class="mainHdr">
	<h3 style="height: 30px; font-size: 15px; color: #01293d">

		<fmt:message key="Application form for Birth Certificate" />
		:
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>

	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<input type="hidden" name="id"
		value="${birthCertificate.birthRegistrationId}">
	<c:set var="doc"
		value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
	<table width="100%" border="0" cellpadding="" cellspacing=""
		class="dataForm">

		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.nocTrade.title" />:</span><span class="ClsRequiredFields"></span></td>

			<td><input type="text" class="form-control" style="width: 270px"
				id="applicantLastName" maxlength="50" name="applicantLastName"
				value="<c:out value="${birthCertificate.applicantTitle}"/>" /></td>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.name" />:</span><span class="ClsRequiredFields"></span></td>

			<td><input type="text" class="form-control" style="width: 270px"
				id="applicantLastName" maxlength="50" name="applicantLastName"
				value="<c:out value="${birthCertificate.applicantFirstName}"/>" />
			</td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.fathername" />:</span><span class="ClsRequiredFields"></span></td>
			<td>
				<%--    <spring:bind path="birthRegistration.address">
                                <input type="text" class="ClsTextbox" style="width:170px" id="address" maxlength="30" name="address" value="<c:out value="${birthRegistration.address}"/>" />
                         </spring:bind>--%> <input type="text"
				class="form-control" style="width: 270px" id="applicantLastName"
				maxlength="50" name="applicantLastName"
				value="<c:out value="${birthCertificate.applicantMiddleName}"/>" />
			</td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.surnname" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 270px;" id="applicantTitle"
				="50" name="applicantTitle"
				value="<c:out value="${birthCertificate.applicantLastName}"/>" /></td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.marriage.fullname" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 270px;" id="label.nocTrade.fullName"
				="50" name="applicantTitle"
				value="<c:out value="${birthCertificate.applicantFullName}"/>" /></td>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.plotno" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 270px;" id="label.nocTrade.fullName"
				="50" name="applicantTitle"
				value="<c:out value="${birthCertificate.applicantPlotNo}"/>" /></td>

		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Name of the Building (इमारतीचे नाव)" />:</span> &nbsp;</td>
			<td><input type="text" class="form-control"
				style="width: 270px;" id="label.nocTrade.fullName"
				="50" name="applicantTitle"
				value="<c:out value="${birthCertificate.applicantBuildingName}"/>" />
			</td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Name of the Street
							(रस्त्याचे नाव)" />:</span> &nbsp;</td>
			<td><input type="text" class="form-control"
				style="width: 270px;" id="label.nocTrade.fullName"
				name="applicantTitle"
				value="<c:out value="${birthCertificate.applicantStreetName}"/>" />
			</td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Name of the Area
							(क्षेत्राचे नाव)" />:</span> &nbsp;</td>
			<td><input type="text" class="form-control"
				style="width: 270px;" id="label.nocTrade.fullName"
				="50" name="applicantTitle"
				value="<c:out value="${birthCertificate.applicantAreaName}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Near by Landmark (जवळील
							लँडमार्क)" />:</span> &nbsp;</td>
			<td><input type="text" class="form-control"
				style="width: 270px;" id="label.nocTrade.fullName"
				name="applicantTitle"
				value="<c:out value="${birthCertificate.applicantNearbyLandmark}"/>" />
			</td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="City Name (शहराचे नाव)" />:</span> &nbsp;</td>
			<td><input type="text" class="form-control"
				style="width: 270px;" id="label.nocTrade.fullName"
				="50" name="applicantTitle"
				value="<c:out value="${birthCertificate.applicantcity}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Pin Code (पिन कोड)" />:</span> &nbsp;</td>
			<td><input type="text" class="form-control"
				style="width: 270px;" id="label.nocTrade.fullName"
				="50" name="applicantTitle"
				value="<c:out value="${birthCertificate.applicantPinCode}"/>" /></td>

		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Aadhaar No. (आधार क्र.)" />:</span> &nbsp;</td>
			<td><input type="text" class="form-control"
				style="width: 270px;" id="label.nocTrade.fullName"
				="50" name="applicantTitle"
				value="<c:out value="${birthCertificate.aadhaarNo}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Email (ईमेल आयडी )" /></span><span class="ClsRequiredFields"></span></td>
			<td><spring:bind path="birthCertificate.email">
					<input type="text" class="form-control" id="email"
						style="width: 270px" name="email"
						value="<c:out value="${birthCertificate.email}"/>" />
				</spring:bind></td>

		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Mobile Number (मोबाईल क्र.)" />:</span></td>
			<td><spring:bind path="birthCertificate.ph_no">
					<input type="text" class="form-control" style="width: 270px"
						id="ph_no" maxlength="50" name="ph_no"
						value="<c:out value="${birthCertificate.ph_no}"/>" />
				</spring:bind> &nbsp;</td>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Relationship of Applicant (अर्जदाराचे नाते)" />:</span></td>
			<td><spring:bind path="birthCertificate.ph_no">
					<input type="text" class="form-control" style="width: 270px"
						id="ph_no" maxlength="50" name="ph_no"
						value="<c:out value="${birthCertificate.applicantRelationship}"/>" />
				</spring:bind> &nbsp;</td>



		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key=" Address For Correspondence  (पत्रव्यवहारासाठी पत्ता) " />:</span><span
				class="ClsRequiredFields"></span></td>
			<td>
				<%--    <spring:bind path="birthRegistration.address">
                                <input type="text" class="ClsTextbox" style="width:170px" id="address" maxlength="30" name="address" value="<c:out value="${birthRegistration.address}"/>" />
                         </spring:bind>--%> <textarea
					class="form-control" style="width: 270px" id="address"
					maxlength="30" name="address">${birthCertificate.address}</textarea>
			</td>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key=" Name Of Child  (बाळाचे नाव)" />:</span></td>
			<td><spring:bind path="birthCertificate.childeName">

					<input type="text" class="form-control" style="width: 270px"
						id="childeName" maxlength="45" tabindex="3" name="childeName"
						value="<c:out value="${birthCertificate.childeName}"/>" />
				</spring:bind></td>

		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Date of Birth of Child (बाळाची जन्मतारीख)" /></span><span
				class="ClsRequiredFields"></span></td>
			<td><spring:bind path="birthCertificate.dob">
					<input type="text" class="form-control" id="dob"
						style="width: 270px" name="dob"
						value="<c:out value="${birthCertificate.dob}"/>" />
				</spring:bind></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Gender (बाळाचे लिंग) " />:</span></td>
			<td><spring:bind path="birthCertificate.gender">
					<input type="text" class="form-control" id="gender"
						style="width: 270px" name="gender"
						value="<c:out value="${birthCertificate.gender}"/>" />
				</spring:bind></td>
		</tr>
		<tr>


			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Father Full Name (वडिलांचे पूर्ण नाव)" /></span><span
				class="ClsRequiredFields">:</span></td>
			<td><spring:bind path="birthCertificate.fatherName">
					<input type="text" class="form-control" style="width: 270px"
						id="fatherName" maxlength="45" tabindex="4" name="fatherName"
						value="<c:out value="${birthCertificate.fatherName}"/>" />
				</spring:bind></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Mother Full Name (आईचे पूर्ण नाव) " /></span><span
				class="ClsRequiredFields"></span>:</td>
			<td><input type="text" class="form-control" style="width: 270px"
				id="motherName" tabindex="5" maxlength="45" name="motherName"
				value="<c:out value="${birthCertificate.motherName}"/>" /></td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Blood Group (रक्त गट)" />:</span></td>
			<td><spring:bind path="birthCertificate.bloodGroup">
					<input type="text" class="form-control" style="width: 270px"
						id="bloodGroup" tabindex="5" maxlength="45" name="bloodGroup"
						value="<c:out value="${birthCertificate.bloodGroup}"/>" />
				</spring:bind></td>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Blood Relation (रक्ताचे नाते)" />:</span></td>
			<td><input type="text" class="form-control" style="width: 270px"
				id="bloodRelation" tabindex="5" maxlength="45" name="bloodRelation"
				value="<c:out value="${birthCertificate.bloodRelation}"/>" /></td>
		</tr>
		<tr>


			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.marriage.zone" />:</span></td>
			<td><input type="text" class="form-control" style="width: 270px"
				id="applicantLastName" maxlength="50" name="applicantLastName"
				value="<c:out value="${birthCertificate.zone}"/>" /></td>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Place of Birth (जन्मस्थान)" />:</span></td>
			<td><spring:bind path="birthCertificate.placeofbirth">

					<input type="text" class="form-control" style="width: 270px"
						id="placeofbirth" tabindex="5" maxlength="45" name="placeofbirth"
						value="<c:out value="${birthCertificate.placeofbirth}"/>" />
				</spring:bind></td>
		</tr>
		<tr>
			<c:if test="${not empty birthCertificate.countryName}">

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Country Name (देशाचे नाव)" />:</span></td>
				<td><spring:bind path="birthCertificate.countryName">
						<input type="text" class="form-control" style="width: 270px"
							id="countryName" tabindex="5" maxlength="45" name="countryName"
							value="<c:out value="${birthCertificate.countryName}"/>" />
					</spring:bind></td>
			</c:if>
			<c:if test="${not empty birthCertificate.homeAddress}">

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Home Address (जन्माच्या वेळीचा घर पत्ता) " />:</span></td>
				<td><spring:bind path="birthCertificate.homeAddress">
						<input type="text" class="form-control" style="width: 270px"
							id="homeAddress" tabindex="5" maxlength="45" name="homeAddress"
							value="<c:out value="${birthCertificate.homeAddress}"/>" />
					</spring:bind></td>
			</c:if>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Reason For Certificate" /></span><span class="ClsRequiredFields"></span>:
			</td>
			<td><spring:bind path="birthCertificate.reasonForCertificate">

					<input type="text" class="form-control" style="width: 270px"
						id="reasonForCertificate" tabindex="5" maxlength="45"
						name="reasonForCertificate"
						value="<c:out value="${birthCertificate.reasonForCertificate}"/>" />
				</spring:bind></td>
			<c:if test="${not empty birthCertificate.hospitalName}">

				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Hospital Name and Registration No (रुग्णालयाचे नाव आणि नोंदणी क्र.)" />:</span></td>
				<td><input type="text" class="form-control"
					style="width: 270px;" id="iOperation" maxlength="50"
					name="hospitalName"
					value="<c:out value="${birthCertificate.hospitalName}"/>" /></td>
			</c:if>

		</tr>





		<tr>
			<td colspan="4" style="background-color: white;"><span
				class="ClsLabel"
				style="height: 37px; padding: 7px 10px 11px; font-size: 17px; color: #01293d"><fmt:message
						key="Certificates And Fees Details (प्रमाणपत्रे आणि फी तपशील)" />:</span>
		</tr>
		<tr>
			<td colspan=""><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Certificate Expected In Days (दिवसात प्रमाणपत्र अपेक्षित आहे)" /></span><span
				class="ClsRequiredFields"></span></td>

			<td><input type="text" class="form-control"
				id="certificateExpectedInDays" maxlength="10"
				name="certificateExpectedInDays"
				value="<c:out value="${birthCertificate.certificateExpectedInDays}"/>" />
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="No Of Certificate Copies (प्रमाणपत्राच्या प्रतींची संख्या)" />:</span></td>
			<td><input type="text" class="form-control"
				id="noOfCertificateCopies" maxlength="10"
				name="noOfCertificateCopies"
				value="<c:out value="${birthCertificate.noOfCertificateCopies}"/>" />
			</td>
		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Fees Applicable (फी लागू (स्वयंचलित नुसार गणना करा दिवस आणि प्रतींच्या संख्येवर आधारित)" />:</span></td>
			<td><input type="text" class="form-control" id="feesApplicable"
				maxlength="10" name="feesApplicable"
				value="<c:out value="${birthCertificate.feesApplicable}"/>" /></td>



			<td colspan=""><span class="ClsLabel" style="font-size: 14px">
					Current Status:</span></td>
			<td><span class="ClsLabel" style="font-size:14px;color:forestgreen;"> <c:if
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
		</tr>
		<tr>

			<td colspan=""><span class="ClsLabel" style="font-size: 14px">Certificate
					Upload: </span></td>
			<td><input type="file" class="imagefile" name="idProof"
				id="idProof" style="width: 220px" /></td>
			<td><c:if
					test="${ empty requestScope.rtiApplication.pdfFilesSavedPath}">

					<a class="bg-button btn btn-primary bd-highlight"
						style="color: white" id="birthupload" type="button"
						target="_blank"
						onclick="birthupload(${birthCertificate.rti_ref_id}); return false;"><span
						class="download" style="align-items: center">Upload</span></a>


				</c:if> <c:if
					test="${ not empty requestScope.rtiApplication.pdfFilesSavedPath}">
						
						                           <a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${requestScope.rtiApplication.pdfFilesSavedPath}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
				</c:if></td>
		<tr>

			<%--<td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Birth Place" />:</span>
                        </td>
                         <td> <span class="ClsLabel" style="font-size:14px"><fmt:message key="Remark" />:</span></td>
                        <td >
                            
                                <input type="text" class="ClsTextbox_mr" style="width:180px" id="Remark" maxlength="12" name="Remark" value=""  />
                            
                        </td>
                         --%>
		</tr>

		<tr>


			<td colspan="6"
				style="background-color: white; background-color: #c5ddfe;"><span
				class="ClsLabel"
				style="height: 37px; padding: 7px 10px 11px; font-size: 17px; color: #01293d; font-style: italic;"><fmt:message
						key="List of Documents (Attachment) दस्तऐवजांची यादी (संलग्नक)" />:</span></td>

			<%--<tr>
                     <td colspan="2">
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="Hospital Certificate" />:</span> 
                     <c:if test="${requestScope.downloadCount>0}">
                    <a target="_blank" href="<c:out value="${requestScope.downloadPath[0]}"/>" id="download1"> 
                    </c:if>
                    <c:if test="${requestScope.downloadCount==0}">
                    <a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/Hospital.pdf">
                    </c:if>
                    <input type="button" class="ClsButton" id="download11" name="uploaded[]" class="imagefile downloadFile" value="Download" ></a>
                     <br/>
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="Father Aadhaar Card " />:</span> 
                    <c:if test="${requestScope.downloadCount>0}">
                    <a target="_blank" href="<c:out value="${requestScope.downloadPath[1]}"/>" id="download2"> 
                    </c:if>
                    <c:if test="${requestScope.downloadCount==0}">
                   <a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/Father.pdf">
                    </c:if>
                     <input type="button" class="ClsButton" id="download22" name="uploaded[]" class="imagefile downloadFile1" value="Download"   ></a>
                     <br/>
                     <span class="ClsLabel" style="font-size:14px"><fmt:message key="Mother Aadhaar Card" />:</span> 
                     <c:if test="${requestScope.downloadCount>0}">
                    <a target="_blank" href="<c:out value="${requestScope.downloadPath[2]}"/>" id="download3"> 
                    </c:if>
                    <c:if test="${requestScope.downloadCount==0}">
                  <a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/Mother.pdf">
                    </c:if>
                     <input type="button" class="ClsButton" id=download33 name="uploaded[]" class="imagefile downloadFile2" value="Download"  ></a>
                     </td>
                     </tr>--%>


			<c:if test="${doc[0] != 'null'}">
				<tr>
					<td colspan="3.5"><span class="ClsLabel"
						style="font-size: 14px"><fmt:message
								key="Hospital Certificate (रुग्णालयाचे प्रमाणपत्र)" />:</span> <c:if
							test="${requestScope.downloadCount>0}">
							<a target="_blank"
								href="<c:out value="${requestScope.downloadPath[0]}"/>"
								id="download1">
						</c:if> <c:if test="${requestScope.downloadCount==0}">
							<a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/">
						</c:if></td>
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
								key="Attachment regarding Permanent Settelment in India (भारतातील कायमस्वरूपी सेटलमेंटबाबत संलग्नक)" />:</span>
						<c:if test="${requestScope.downloadCount>0}">
							<a target="_blank"
								href="<c:out value="${requestScope.downloadPath[0]}"/>"
								id="download1">
						</c:if> <c:if test="${requestScope.downloadCount==0}">
							<a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/">
						</c:if></td>
					<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[1]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
			</tr>
		</c:if>
		
		<tr>
			<td colspan="3.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Father's/Mother's ID Proof(Aadhaar/Pan/Voting Card/T.C/etc) (वडिलांचा/आईचा ओळखपत्र पुरावा (आधार/पॅन/मतदान कार्ड/टी.सी/इ.) प्रमाणपत्र)" />:</span>
				<c:if test="${requestScope.downloadCount>0}">
					<a target="_blank"
						href="<c:out value="${requestScope.downloadPath[1]}"/>"
						id="download2">
				</c:if> <c:if test="${requestScope.downloadCount==0}">
					<a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/">
				</c:if></td>
			<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[2]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
		</tr>
		<tr>
			<td colspan="3.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Applicant's ID
									Proof(Aadhaar/Pan/Voting Card/T.C/etc)(अर्जदाराचा ओळखपत्र पुरावा (आधार/पॅन/मतदान कार्ड/टी.सी./इ.)" />:</span>
				<c:if test="${requestScope.downloadCount>0}">
					<a target="_blank"
						href="<c:out value="${requestScope.downloadPath[2]}"/>"
						id="download2">
				</c:if> <c:if test="${requestScope.downloadCount==0}">
					<a target="_blank"
						href="http://175.101.6.10:8085/RTS/UploadDoc/Hospital.pdf">
				</c:if></td>
			<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[3]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
		</tr>
		

		<c:if test="${doc[4] != 'null'}">
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="Certificate issued by
									Correspondent(ward member) (बातमीदाराने जारी केलेले प्रमाणपत्र(वॉर्ड सदस्य)" />:</span>
					<c:if test="${requestScope.downloadCount>0}">
						<a target="_blank"
							href="<c:out value="${requestScope.downloadPath[3]}"/>"
							id="download2">
					</c:if> <c:if test="${requestScope.downloadCount==0}">
						<a target="_blank"
							href="http://175.101.6.10:8085/RTS/UploadDoc/Hospital.pdf">
					</c:if></td>
				<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[4]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
			</tr>
		</c:if>

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
	</table>

	<input type="hidden" class="ClsTextbox_mr" style="width: 180px"
		id="birthRegistrationId" maxlength="12" name="birthRegistrationId"
		value="<c:out value="${birthCertificate.birthRegistrationId}"/>" /> <input
		type="hidden" class="ClsTextbox_mr" style="width: 180px"
		id="rtiApplicationRefId" maxlength="12" name="rtiApplicationRefId"
		value="<c:out value="${requestScope.rtiApplication.rtiApplicationId}"/>" />
	<input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${birthCertificate.rti_ref_id}" />
		<input type="hidden" id="responseData" name="responseData"
								value="" />
	

	</table>
	<%@include file="/pages/workflow/taskInclude.jsp"%>
</div>
</div>
<script type="text/javascript">


	function saveEntity() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createBirthCertificateWork.do');
	}
	
	</script>
	
	<script type="text/javascript">
	
	function birthupload(id) {
		  
 	    var data = new FormData();
 	   var idProofFileInput = $("#idProof");
 	 	 
 	 	if (idProofFileInput.val() === '') {
 	 	    alert("Please select the document!!");
 	 	    return false;
 	 	}
 	    alert("Are you sure you want to Upload Certificate?");
 	    
 	  document.getElementById('rtiApplicationRefIds').value = id;
 	 

 	if (idProofFileInput.length > 0 && idProofFileInput.get(0).files.length > 0) {
 	    data.append('idProof1', idProofFileInput.get(0).files[0]);

 	   
 	} else {
 	    console.error("No file selected");
 	}

 	 var apptype=1;
	  $.ajax({
		  url: "<c:out value='${contextRoot}'/>/mobileapp/rtsapplication/getHealthDSC.do?id="+apptype,
 		 type: 'POST',
         data: data,
         cache: false,
	      dataType: 'xml',
         processData: false,
         contentType: false,
         async: false, 
 	        success: function(response) {

 	        	 console.log(response);
 		     
 		       
 		            var status = $(response).find("fileName").text();
 		            console.log("Status"+status);
 		       
 		     
 		        $.ajax({
 			        url: "http://127.0.0.1:1620",
 			        type: 'POST',
 			        data: status,
 			     
 			        processData: false, // Don't process the files
 			        contentType: 'application/xml', // Set content type to false as jQuery will tell the server its a query string request
 			     
 				      
 				      
 			       
 			        success: function(status) {
 				       
 			            console.log("Successd"+status);
 			         
 			            document.getElementById('responseData').value = status;
 			            console.log("After @@@"+status);
 			      	  //onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveBirthCertificate.do');
 			      	 $.ajax({
 	                    url: '<c:out value="${contextRoot}"/>/rtsapplication/saveBirthUpload.do?refId='+id,
 	                    type: 'POST',
 	                   async: false, 
 	                   data: {
 	 			        	status : status
 	 			        	
 	 			        },
 	                   
 	                	  success: function(data, textStatus, jqXHR) {
 	                		    console.log("Data:", data);

 	                		    var parsedData = JSON.parse(data);
 	                		    var finalstatus = parsedData.status;

 	                		    console.log("finalstatus:", finalstatus);

 	                		    if (finalstatus === true) {
 	                		        alert("Upload has been done successfully!");
 	                		        window.location.reload(); 
 	                		    } else {
 	                		        alert("Upload has been failed!!");
 	                		    }
 	                		},
 	                    error: function (xhr) {
	      	        		    alert("Upload has been failed !");
 	                        console.log(xhr.responseText);
 	                    }
 	                });
 	            },
 			        error: function(xhr) {
 			        	  alert("failed POST");
 			        	  console.log("failed"+status);
 			            console.log(xhr.responseText);
 			        }
 			    });
 		        
 	         
 		      /*    } else {
 			            console.log("No <fileName> elements found ");
 			          }
 			        } else {
 			          console.log("No <request> elements found in XML");
 			        }*/
 			        
 		    
 	    },
 	        error: function(xhr) {
 	        	  alert("failed GET");
 	            console.log(xhr.responseText);
 	        }
 	    });

 	
 	  
 	//  onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);
 return false;

 	}

 	
 	function docDownload(filesPath) {
 	    var encodedFilePath = encodeURIComponent(filesPath);

 	    var encodedFilesPath = btoa(encodedFilePath); 

 	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
 	}
</script>