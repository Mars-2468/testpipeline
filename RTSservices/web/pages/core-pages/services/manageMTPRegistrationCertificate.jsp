<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<%@ taglib prefix="mytag" uri="/WEB-INF/tlds/c.tld"%>
<%@ page import="java.io.PrintWriter" %>
<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.ajaxfileupload.js"></script>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("DATE_TIME_DB_FORMAT",
			Constants.DATE_TIME_DB_FORMAT);
	

	
	pageContext.setAttribute("STATUS_YES_LABEL", CoreConstants.STATUS_YES_LABEL);
    pageContext.setAttribute("STATUS_NO_LABEL", CoreConstants.STATUS_NO_LABEL);
    
    pageContext.setAttribute("STATUS_YES",  CoreConstants.STATUS_YES);
    pageContext.setAttribute("STATUS_NO",  CoreConstants.STATUS_NO);
    


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
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editMTPRegistrationCertificate.do');
	}

	function savemTPRegistrationCertificate() {

		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveMTPRegistrationCertificate.do');
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

    function getOutwardNumber() {
var outwardNumber = document.getElementById("outwardNo").value;
if (outwardNumber != "") {
alert("outward number is already generated , The current outward number is " + outwardNumber);
event.preventDefault();
return false;
}
onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/generateoutwardNoMtp.do');

} 
    function downloads(id, url) {
		document.getElementById('rtiApplicationRefId').value = id;

		alert("Certificate has been generated successfully.");

		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'
				+ url);

	}
</script>

<style type="text/css">
<style type="text/css">
input[type="text"],
textarea {
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

 .ClsLabels {
    font-style: normal;
    font-family: inherit;
    font-size: 14px;
    font-weight: 520 !important;
}
</style>

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


#table1{
 padding: 5px;
    font-size: 11px;
    width: 100%;
}

#table2{
 padding: 5px;
    font-size: 11px;
    width: 100%;
}

</style>
<style>
.custom-note-point {
    display: flex;
    align-items: center;
    font-size: large;
    font-family: cursive;
}


.custom-note-point p{
    display: flex;
    align-items: center;
    font-size: large;
    font-family: cursive;
}

.custom-note-point-icon {
    margin-right: 10px;
    color: #4CAF50; /* Green icon color */
}

.custom-note-point-text {
    font-size: 16px;
    color: #333; /* Dark grey text color */
    line-height: 1.6; /* Line height */
}
/* Note Point Styles */
.note-point {
  display: flex;
  align-items: center;
      height: 40px;
  
  max-width: 1200px;
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  padding: 20px;
  background-color: palegreen;
    font-style: italic;
}

.note-point-circle {
  width: 20px;
  height: 20px;
  border-radius: 50%;
  background-color: darkred;
  margin-right: 20px;
}

.note-point-content h2 {
  margin-top: 0;
}

.note-point-content p {
  margin-bottom: 0;
}
.btn-custom-sizess {
    padding: 0.15rem 0.2rem; /* Adjust the padding as needed */
    font-size: 0.775rem; /* Adjust the font size as needed */
    
}

</style>
<div class="mainHdr">
	<h3>

		<fmt:message key="Application Form For Medical Termination Of Pregnancy Hospital Registration :" />
<c:if test="${requestScope.rtiApplication != null}"> 				
				<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
				</c:if>	

	</h3>
</div>
<div class="form" valign="top" id="">
<input type="hidden" name="id"
		value="${mTPRegistrationCertificate.mtpId}">
	<table width="98%" border="0" cellpadding="2" cellspacing="2" align="center"
		class="dataForm">
		<tr style="background-color: gainsboro;">
				<td colspan="4">
				<Strong><label Style="display: inline-block;
    color: brown;
    font-size: 14px;">Applicant Details</label></Strong>
				</td>
				</tr>
		<tr>
		  <td>
                                <span class="ClsLabel" style="font-size:14px"><fmt:message key="Name" />:</span><span class="ClsRequiredFields"></span>
                            </td>
                    <td><input type="text" class="ClsTextbox" style="width: 270px"
				id="full_name" maxlength="50" name="title"
				value="<c:out value="${mTPRegistrationCertificate.full_name}"/>" readonly/></td>
			<td><span
				class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Mobile No." />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 270px"
				id="phoneNumber" maxlength="50" name="phoneNumber"
				value="<c:out value="${mTPRegistrationCertificate.phoneNumber}"/>" readonly/></td>
				</tr>
				
				<tr>
				  <td>
                                <span class="ClsLabel" style="font-size:14px"><fmt:message key="Email Id" />:</span><span class="ClsRequiredFields"></span>
                            </td>
                            
                       <td><input type="text" class="ClsTextbox" style="width: 270px"
				id="email" maxlength="50" name="email"
				value="<c:out value="${mTPRegistrationCertificate.email}"/>" readonly/></td>
						
				 <td><span
				class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Full Address" />:</span></td>
			<td>
			 <textarea
					class="form-control" style="width: 270px" id="address"
					maxlength="30" name="address" readonly>${mTPRegistrationCertificate.current_address}</textarea>
			</td>
			</tr>
				<tr style="background-color: gainsboro;">
				<td colspan="4">
				<Strong><label Style="display: inline-block;
    color: brown;
    font-size: 14px;">Hospital's Information</label></Strong>
				</td>
				</tr>
				<tr>
							
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Category of Approved Place" />:</span></td>
				<td><input type="radio"
					id="upTo12Weeks"
					name="pregnancy_termination" value="3" readonly
					<c:if test="${mTPRegistrationCertificate.pregnancy_termination=='upTo12Weeks'}">checked="checked"</c:if> />
				<c:out value="Up To 12 Weeks" /> 
				<input type="radio"
					id="upTo24Weeks"
					name="pregnancy_termination" value="4" readonly
					<c:if test="${mTPRegistrationCertificate.pregnancy_termination=='upTo24Weeks'}">checked="checked"</c:if> />
				<c:out value="Up To 20 Weeks" />
				</td>
				
					
				
<td>
<span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Institute Type" />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 270px"
				id="institute_type" maxlength="50" name="institute_type"
				value="<c:out value="${mTPRegistrationCertificate.institute_type}"/>" readonly/></td>
				</tr>
				<tr>
				<td>
<span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Zone No" />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 270px"
				id="zoneNo" maxlength="50" name="zoneNo"
				value="<c:out value="${mTPRegistrationCertificate.zoneNo}"/>" readonly/></td>
			
				<td>
<span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Hospital Owner Name" />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 270px"
				id="ownername" maxlength="50" name="ownername"
				value="<c:out value="${mTPRegistrationCertificate.ownername}"/>" readonly/></td>
			</tr>
			<tr>	
	<td>
<span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Mobile No." />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 270px"
				id="place_full_adrresss" maxlength="50" name="place_phonee"
				value="<c:out value="${mTPRegistrationCertificate.place_phonee}"/>" readonly/></td>
		
	<td>
	
<span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Email Id " />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 270px"
				id="place_email_id" maxlength="50" name="place_email_id"
				value="<c:out value="${mTPRegistrationCertificate.place_email_id}"/>" readonly/></td>
			</tr>
			<tr>

		<td><span
				class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Hospital Address" />:</span></td>
			<td>
			 <textarea
					class="form-control" style="width: 270px" id="address"
					maxlength="30" name="address" readonly>${mTPRegistrationCertificate.place_full_adrresss}</textarea>
			
			<!-- Hospital's Information Form -->
			
			
	<td>
<span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Hospital Name" />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 270px"
				id="applicantName" maxlength="50" name="last_name"
				value="<c:out value="${mTPRegistrationCertificate.name_place}"/>" readonly/></td>
				</tr>
				<tr>
					<td>
<span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Nursing Home/Hospital Registration Number" />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 270px"
				id="applicantName" maxlength="50" name="last_name"
				value="<c:out value="${mTPRegistrationCertificate.nmcregnumber}"/>" readonly/></td>
				
				
						<td>
<span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Total No of Beds " />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 270px"
				id="total_no_beds" maxlength="50" name="total_no_beds"
				value="<c:out value="${mTPRegistrationCertificate.total_no_beds}"/>" readonly/></td>
			</tr>
			<tr>
	<td>
<span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="i) Maternity Bed/Beds" />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 270px"
				id="obscticals" maxlength="50" name="obscticals"
				value="<c:out value="${mTPRegistrationCertificate.obscticals}"/>" readonly/></td>
					
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="ii) Other Bed/Beds" />:</span></td>
				
					<td><input type="text" class="ClsTextbox" style="width: 270px"
				id="obscticals" maxlength="50" name="obscticals"
				value="<c:out value="${mTPRegistrationCertificate.gyn_case}"/>" readonly/></td>
			</tr>
				<tr>	
				
				
				
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Number of Deliveries During Previous 12 Months" /></span><span class="ClsRequiredFields"></span></td>
			<td >
				
			
				
				<input type="text" class="ClsTextbox" style="width: 270px"
				id="no_of_deliveries " maxlength="50" name="no_of_deliveries"
				value="<c:out value="${mTPRegistrationCertificate.no_of_deliveries}"/>" readonly/>
				</td>
					
				
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Number of Dilation and Curettage during Previous 12 month" /></span><span class="ClsRequiredFields"></span></td>
			<td>
				
			
				
				<input type="text" class="ClsTextbox" style="width: 270px"
				id="dilatation " maxlength="50" name="dilatation"
				value="<c:out value="${mTPRegistrationCertificate.dilatation}"/>" readonly/>
				</td>
				
				</tr>
				<tr>	
				
				<td><span
				class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Number of Abdominal Operations During Previous 12 Months" />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 270px"
				id="abdominal" maxlength="50" name="abdominal"
				value="<c:out value="${mTPRegistrationCertificate.abdominal}"/>" readonly/></td>
				
		
				
				</tr>
				<tr>
				<td colspan="4">
					<label for="" class="form-label" Style="display: inline-block;
    color: brown;
    font-size: 14px;">State, if the following
						facilities are available at the place </label>
</td>
				</tr>
				<tr style="background-color: gainsboro;">
				<td colspan="4">
				<Strong><label Style="display: inline-block;
    color: brown;
    font-size: 14px;">Category A</label></Strong>
				</td>
				</tr>	
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Gynaecological examination/labour" />:</span></td>
				<td><input type="radio"
					id="Yes"
					name="gynaecological" value="3" readonly
					<c:if test="${mTPRegistrationCertificate.gynaecological=='Yes'}">checked="checked"</c:if> />
				<c:out value="Yes" /> 
				<input type="radio"
					id="No"
					name="gynaecological" value="4" readonly
					<c:if test="${mTPRegistrationCertificate.gynaecological=='No'}">checked="checked"</c:if> />
				<c:out value="No" />
				</td>
				</tr>
				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Resuscitation equipment" />:</span></td>
				<td><input type="radio"
					id="Yes"
					name="resuscitation" value="3" readonly
					<c:if test="${mTPRegistrationCertificate.resuscitation=='Yes'}">checked="checked"</c:if> />
				<c:out value="Yes" /> 
				<input type="radio"
					id="No"
					name="resuscitation" value="4" readonly
					<c:if test="${mTPRegistrationCertificate.resuscitation=='No'}">checked="checked"</c:if> />
				<c:out value="No" />
				</td>
				
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Sterilization equipment" />:</span></td>
				<td><input type="radio"
					id="Yes"
					name="sterilization" value="3" readonly
					<c:if test="${mTPRegistrationCertificate.sterilization=='Yes'}">checked="checked"</c:if> />
				<c:out value="Yes" /> 
				<input type="radio"
					id="No"
					name="sterilization" value="4" readonly
					<c:if test="${mTPRegistrationCertificate.sterilization=='No'}">checked="checked"</c:if> />
				<c:out value="No" />
				</td>
				</tr>
				<tr>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Facilities for treatment of shock, including emergency drugs" />:</span></td>
				<td><input type="radio"
					id="Yes"
					name="emergency" value="3" readonly
					<c:if test="${mTPRegistrationCertificate.emergency=='Yes'}">checked="checked"</c:if> />
				<c:out value="Yes" /> 
				<input type="radio"
					id="No"
					name="emergency" value="4" readonly
					<c:if test="${mTPRegistrationCertificate.emergency=='No'}">checked="checked"</c:if> />
				<c:out value="No" />
				</td>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Facilities for transportation, if required" />:</span></td>
				<td><input type="radio"
					id="Yes"
					name="transportation" value="3" readonly
					<c:if test="${mTPRegistrationCertificate.transportation=='Yes'}">checked="checked"</c:if> />
				<c:out value="Yes" /> 
				<input type="radio"
					id="No"
					name="transportation" value="4" readonly
					<c:if test="${mTPRegistrationCertificate.transportation=='No'}">checked="checked"</c:if> />
				<c:out value="No" />
				</td>
				</tr>
				<tr style="background-color: gainsboro;">
				<td colspan="4">
				<Strong><label Style="display: inline-block;
    color: brown;
    font-size: 14px;">Category B</label></Strong>
				</td>
				</tr>	
				<tr>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="An operation table and instruments for performing abdominal or gynaecological surgery" />:</span></td>
				<td><input type="radio"
					id="Yes"
					name="gynaecologicalsurgery" value="3" readonly
					<c:if test="${mTPRegistrationCertificate.gynaecologicalsurgery=='Yes'}">checked="checked"</c:if> />
				<c:out value="Yes" /> 
				<input type="radio"
					id="No"
					name="gynaecologicalsurgery" value="4" readonly
					<c:if test="${mTPRegistrationCertificate.gynaecologicalsurgery=='No'}">checked="checked"</c:if> />
				<c:out value="No" />
				</td>
				
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key="Drugs and parental fluid in sufficient supply for emergency cases" />:</span></td>
				<td><input type="radio"
					id="Yes"
					name="drugsparental" value="3" readonly
					<c:if test="${mTPRegistrationCertificate.drugsparental=='Yes'}">checked="checked"</c:if> />
				<c:out value="Yes" /> 
				<input type="radio"
					id="No"
					name="drugsparental" value="4" readonly
					<c:if test="${mTPRegistrationCertificate.drugsparental=='No'}">checked="checked"</c:if> />
				<c:out value="No" />
				</td>
				</tr>
				<tr>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
							key=" Anaesthetic equipment, resuscitation equipment and sterilization equipment" />:</span></td>
				<td><input type="radio"
					id="Yes"
					name="resuscitationequipment" value="3" readonly
					<c:if test="${mTPRegistrationCertificate.resuscitationequipment=='Yes'}">checked="checked"</c:if> />
				<c:out value="Yes" /> 
				<input type="radio"
					id="No"
					name="resuscitationequipment" value="4" readonly
					<c:if test="${mTPRegistrationCertificate.resuscitationequipment=='No'}">checked="checked"</c:if> />
				<c:out value="No" />
				</td>
				</tr>
				
				
<tr>
    <td colspan="4">
        <strong>
            <label style="display: inline-block; color: brown; font-size: 14px;">
                Name of Registered Medical Practitioner, Employed in the place and their Qualification and Experience in Gynecology and obstetries
            </label>
        </strong>
    </td>
</tr>

<!-- TABLES_______________________________________________________________________________________________TABLES -->
<tr>
    <td colspan="4">
        <table border="0" cellpadding="2" cellspacing="2" id="table1">
            <tr class="ClsTRHeaderList">
                <td><span class="ClsLabels"><fmt:message key="Sr.No" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="Name of Registered Medical Practitioner" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="Qualification" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="Full-time/Part-time" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="Experience(In Years)" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="M.B.B.S Certificate" /></span></td>
                 <td><span class="ClsLabels"><fmt:message key="P.G Certificate" /></span></td>
                 <td><span class="ClsLabels"><fmt:message key="M.M.C Certificate" /></span></td>
             <td><span class="ClsLabels"><fmt:message key="Marriage Certificate/Govt. Gazette(If change in name)" /></span></td>
                
            </tr>
            <c:forEach var="mTPDetailsList" items="${requestScope.mTPDetailsList}" varStatus="iCount">
                <tr class="ClsTRContentListWhite">
                    <td><c:out value="${iCount.index+1}" /></td>
                    <td>${mTPDetailsList.medical_practitoner_name}</td>
                    <td>${mTPDetailsList.medical_practitoner_qualification}</td>
                    <td>${mTPDetailsList.medical_practitoner_fullparttime}</td>
                    <td>${mTPDetailsList.medical_practitoner_experience}</td>
				<td>
							
							
    <a class="bg-button btn btn-primary bd-highlight action btn-custom-sizes"
   type="button"
   target="_blank"
    onclick="docDownload('${mTPDetailsList.mbbs}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>    

	<td>
							
							
    <a class="bg-button btn btn-primary bd-highlight action btn-custom-sizes"
   type="button"
   target="_blank"
    onclick="docDownload('${mTPDetailsList.pg}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>   

	<td>
							
							
    <a class="bg-button btn btn-primary bd-highlight action btn-custom-sizes"
   type="button"
   target="_blank"
   onclick="docDownload('${mTPDetailsList.mmc}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>   
	<td>
							
							
    <a class="bg-button btn btn-primary bd-highlight action btn-custom-sizes"
   type="button"
   target="_blank"
    onclick="docDownload('${mTPDetailsList.marriageCertificate}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>   
            </tr>
            </c:forEach>
        </table>
    </td>
</tr>

<tr>
    <td colspan="4">
        <strong>
            <label style="display: inline-block; color: brown; font-size: 14px;">
                Assistant Gynaecology Details :
            </label>
        </strong>
    </td>
</tr>
<tr>
    <td colspan="4">
        <table border="0" cellpadding="2" cellspacing="2" id="table1">
            <tr class="ClsTRHeaderList">
                <td><span class="ClsLabels"><fmt:message key="Sr.No" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="Name of Assistant" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="Qualification" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="Full-time/Part-time" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="Experience(In Years)" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="M.B.B.S Certificate" /></span></td>
                 <td><span class="ClsLabels"><fmt:message key="P.G Certificate" /></span></td>
                 <td><span class="ClsLabels"><fmt:message key="M.M.C Certificate" /></span></td>
                
            </tr>
            <c:forEach var="mTPAssistantDetails" items="${requestScope.mTPAssistantDetails}" varStatus="iCount">
                <tr class="ClsTRContentListWhite">
                    <td><c:out value="${iCount.index+1}" /></td>
                    <td>${mTPAssistantDetails.assistantName}</td>
                    <td>${mTPAssistantDetails.assistantQualification}</td>
                    <td>${mTPAssistantDetails.assistantFullparttime}</td>
                    <td>${mTPAssistantDetails.assistantExperience}</td>
				<td>
							
							
   <a class="bg-button btn btn-primary bd-highlight action btn-custom-sizes"
   type="button"
   target="_blank"
    onclick="docDownload('${mTPAssistantDetails.mbbsCertificate}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>    

	<td>
							
							
   <a class="bg-button btn btn-primary bd-highlight action btn-custom-sizes"
   type="button"
   target="_blank"
    onclick="docDownload('${mTPAssistantDetails.pgCertificate}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>   

	<td>
							
							
   <a class="bg-button btn btn-primary bd-highlight action btn-custom-sizes"
   type="button"
   target="_blank"
    onclick="docDownload('${mTPAssistantDetails.mmcCertificate}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>   
  
            </tr>
            </c:forEach>
        </table>
    </td>
</tr>
<tr>
    <td colspan="4">
        <strong>
            <label style="display: inline-block; color: brown; font-size: 14px;">
               Anesthetist Details
            </label>
        </strong>
    </td>
</tr>

<tr>
    <td colspan="4">
        <table border="0" cellpadding="2" cellspacing="2" id="table1">
            <tr class="ClsTRHeaderList">
                <td><span class="ClsLabels"><fmt:message key="Sr.No." /></span></td>
                <td><span class="ClsLabels"><fmt:message key="Name of Anaesthetist" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="M.B.B.S Certificate" /></span></td>
                                <td><span class="ClsLabels"><fmt:message key="P.G Certificate" /></span></td>
                                <td><span class="ClsLabels"><fmt:message key="M.M.C Certificate" /></span></td>
            </tr>
            <c:forEach var="anaesthetistDetails" items="${requestScope.anaesthetistDetails}" varStatus="iCount">
                <tr class="ClsTRContentListWhite">
                    <td><c:out value="${iCount.index+1}" /></td>
                    <td>${anaesthetistDetails.ancName}</td>
				<td>
							
							
     <a class="bg-button btn btn-primary bd-highlight action btn-custom-sizes"
   type="button"
   target="_blank"
    onclick="docDownload('${anaesthetistDetails.anesthetistMbbs}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>                    
				<td>
							
							
     <a class="bg-button btn btn-primary bd-highlight action btn-custom-sizes"
   type="button"
   target="_blank"
    onclick="docDownload('${anaesthetistDetails.anesthetistPG}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>

				<td>
							
							
     <a class="bg-button btn btn-primary bd-highlight action btn-custom-sizes"
   type="button"
   target="_blank"
    onclick="docDownload('${anaesthetistDetails.anesthetistMMC}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>                    
               </tr>
            </c:forEach>
        </table>
    </td>
</tr>

<tr>
    <td colspan="4">
        <strong>
            <label style="display: inline-block; color: brown; font-size: 14px;">
                Full time trained nurse working at the place with details
            </label>
        </strong>
    </td>
</tr>

<tr>
    <td colspan="4">
        <table border="0" cellpadding="2" cellspacing="2" id="table1">
            <tr class="ClsTRHeaderList">
                <td><span class="ClsLabels"><fmt:message key="Sr.No." /></span></td>
                <td><span class="ClsLabels"><fmt:message key="Name" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="Diploma Certificate"/></span></td>
                <td><span class="ClsLabels"><fmt:message key="Valid Certificate" /></span></td>
            </tr>
            <c:forEach var="mTPNurseDetails" items="${requestScope.mTPNurseDetails}" varStatus="iCount">
                <tr class="ClsTRContentListWhite">
                    <td><c:out value="${iCount.index+1}" /></td>
                    <td>${mTPNurseDetails.nursename}</td>
                   
				<td>
							
							
    <a class="bg-button btn btn-primary bd-highlight action btn-custom-sizes"
   type="button"
   target="_blank"
    onclick="docDownload('${mTPNurseDetails.diplomaCerti}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>   
           
				<td>
							
							
   <a class="bg-button btn btn-primary bd-highlight action btn-custom-sizes"
   type="button"
   target="_blank"
    onclick="docDownload('${mTPNurseDetails.validCerti}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td> 
             </tr>
            </c:forEach>
        </table>
    </td>
</tr>

<tr>
    <td colspan="4">
        <strong>
            <label style="display: inline-block; color: brown; font-size: 14px;">
                Undertaking of blood Bank
            </label>
        </strong>
    </td>
</tr>

<tr>
    <td colspan="4">
        <table border="0" cellpadding="2" cellspacing="2" id="table1">
            <tr class="ClsTRHeaderList">
                <td><span class="ClsLabels"><fmt:message key="Sr.No" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="Name of Blood Bank" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="Registration Number" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="Validity of Registration" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="Distance From Approved Place (in km.)" /></span></td>
                <td><span class="ClsLabels"><fmt:message key="Mobile Number" /></span></td>
                                <td><span class="ClsLabels"><fmt:message key="Blood Bank Undertaking Certificate" /></span></td>
                
            </tr>
            <c:forEach var="mTPBloodBankDetails" items="${requestScope.mTPBloodBankDetails}" varStatus="iCount">
                <tr class="ClsTRContentListWhite">
                    <td><c:out value="${iCount.index+1}" /></td>
                    <td>${mTPBloodBankDetails.bloodbankName}</td>
                    <td>${mTPBloodBankDetails.bloodbregistrationNumber}</td>
                    <td>${mTPBloodBankDetails.bloodbregistrationValidity}</td>
                    <td>${mTPBloodBankDetails.bloodbdistanceFromApprovedPlace}</td>
                    <td>${mTPBloodBankDetails.bloodbmobilenum}</td>
                    <td>
							
							
  <a class="bg-button btn btn-primary bd-highlight action btn-custom-sizes"
   type="button"
   target="_blank"
    onclick="docDownload('${mTPBloodBankDetails.undertaking}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td> 
                </tr>
            </c:forEach>
        </table>
    </td>
</tr>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		<table colspan="" border="0" cellpadding="2" cellspacing="2"
				id="table1" class="" >
			 <tr>
     <td><span class="ClsLabel" style="font-size:14px"> Current Status:</span></td>
     <td colspan="4"> <span class="ClsLabel" style="font-size:14px;color:forestgreen;">
     <c:if test="${requestScope.rtiApplication.workFlowStatus==0}">
						<b>Citizen Form Submitted. </b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
						<b>In Progress.  </b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
						<b>Citizen Form Approved.</b>
					</c:if>
											
					<c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						<b>Completed and File Uploaded for Citizen</b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						<b>Rejected</b>
					</c:if>	
					
					
					</span>        
  </td>  
  </tr>    
		   
		
		<tr>
			  <td colspan="6">
<div 
			style="background-color:#FFEFD6; height:40px; padding:10px 10px 10px; font-style: italic ; ">
			<h6>List of Documents (Attachment) For MTP Registration</h6>
			</div>
			</td>

		                    <c:set var="doc" value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
		
	<tr>
				<c:if test="${doc[0] != 'null'}">

			 <td>
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="Owner's PG degree Certificate and Valid M.M.C Certificate" />:</span>
                   </td>
                    
                         <td> 
    <a class="bg-button btn btn-primary bd-highlight action"
       type="button"
       target="_blank"
       onclick="docDownload('${doc[0]}');">
       <span class="download" style="align-items: center;color:white;">Download</span>
    </a>
</td>
</c:if>
				<c:if test="${doc[1] != 'null'}">

                     <td>
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="Nursing Home Certificate" />:</span> 
                   </td>
                   <td>
                    <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[1]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                     </td>
                     </c:if>
                     </tr>
                     <tr>
                     				<c:if test="${doc[2] != 'null'}">
                     
                      <td>
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="Undertaking form owner for 24 hrs. blood supply availability & Not Doing MTP till Registration" />:</span>
                    </td>
                    <td> 
                 <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[2]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                     </td>
                     </c:if>
                     				<c:if test="${doc[3] != 'null'}">
                     
                     
                          <td>
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="Biomedical Certificate" />:</span> 
                   </td>
                   <td>
                    <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[3]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                     </td>
                     </c:if>
                     </tr>
                     <tr>
                     				<c:if test="${doc[4] != 'null'}">
                     
                      <td>
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="Maharastra Pollution Control Board Certificate" />:</span>
                    </td>
                    <td> 
                    <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[4]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                     </td>
                     </c:if>
                     				<c:if test="${doc[5] != 'null'}">
                     
                     <td>
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="Fire NOC" />:</span> 
                   </td>
                   <td>
                   <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[5]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                     </td>
                     </c:if>
                     </tr>
                     
                     
                     
                  
                     <tr>
                     				<c:if test="${doc[6] != 'null'}">
                     
                      <td>
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="Affidavit with notary(applicable only if renewal or any change in MTP Certificate)" />:</span>
                    </td>
                    <td> 
                   <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[6]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                     </td>
                    </c:if>
                   
                    
                    
                     </tr>
                        
                    
      </table>





		 	<table colspan="" border="0" cellpadding="2" cellspacing="2"
				id="table1" class="">
				  <!-- Add on -->
				  
    
        <c:if test="${empty mTPRegistrationCertificate.nodaltocellRemark && requestScope.login eq 'L1'}">
       	<tr>
       
        <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="Nodal Officer Remark to PCPNDT Cell" />:</span>
    </td>
            <td colspan ="3" style="text-align: center;">
            <textarea class="form-control" style="width: 500px;margin-left: 182px;"
					id="nodaltocellRemark" maxlength="200" name="nodaltocellRemark" rows="2">${mTPRegistrationCertificate.nodaltocellRemark}</textarea></td>
            </tr>
       </c:if> 
               <c:if test="${not empty mTPRegistrationCertificate.nodaltocellRemark}">
                 
                 <tr> <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="Nodal Officer Remark to PCPNDT Cell" />:</span>
    </td>
            <td colspan ="3" style="text-align: center;">
            <textarea class="form-control" style="width: 500px;margin-left: 182px;"
					id="nodaltocellRemark" maxlength="200" name="nodaltocellRemark" rows="2">${mTPRegistrationCertificate.nodaltocellRemark}</textarea></td>
 	</tr>
 
               </c:if>
       
       

    
        <c:if test="${not empty mTPRegistrationCertificate.nodaltocellRemark && empty mTPRegistrationCertificate.cellRemark  && requestScope.login eq 'L2'}">
        	<tr>
        
        <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="PCPNDT Cell Remark" />:</span>
    </td>
            <td colspan ="3" style="text-align: center;">
            <textarea class="form-control" style="width: 500px;margin-left: 182px;"
					id="cellRemark" maxlength="200" name="cellRemark" rows="2">${mTPRegistrationCertificate.cellRemark}</textarea></td>
          </tr>  
       </c:if> 
          <c:if test="${not empty mTPRegistrationCertificate.cellRemark && not empty mTPRegistrationCertificate.nodaltocellRemark}">
       <tr>
        <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="PCPNDT Cell Remark" />:</span>
    </td>
            <td colspan ="3" style="text-align: center;">
            <textarea class="form-control" style="width: 500px;margin-left: 182px;"
					id="cellRemark" maxlength="200" name="cellRemark" rows="2">${mTPRegistrationCertificate.cellRemark}</textarea></td>
           </tr> 
       </c:if> 





   <!-- Add on -->
   
        <c:if test="${requestScope.login eq 'L3' && empty mTPRegistrationCertificate.mhoRemark && not empty mTPRegistrationCertificate.cellRemark && not empty mTPRegistrationCertificate.nodaltocellRemark}">
        	<tr>
        
         <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="MHO Remark to ZMO for inspection" />:</span>
    </td>
            <td colspan ="3"  style="text-align: center;">
            <textarea class="form-control" style="width: 500px;margin-left: 182px;"
					id="mhoRemark" maxlength="200" name="mhoRemark" rows="2">${mTPRegistrationCertificate.mhoRemark}</textarea></td>
            
           </tr>    
       </c:if>

<c:if test="${not empty mTPRegistrationCertificate.mhoRemark && not empty mTPRegistrationCertificate.cellRemark && not empty mTPRegistrationCertificate.nodaltocellRemark}">
        	<tr>
        
         <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="MHO Remark to ZMO for inspection" />:</span>
    </td>
            <td colspan ="3"  style="text-align: center;">
            <textarea class="form-control" style="width: 500px;margin-left: 182px;"
					id="mhoRemark" maxlength="200" name="mhoRemark" rows="2">${mTPRegistrationCertificate.mhoRemark}</textarea></td>
            
           </tr>    
       </c:if>





       	<tr>
       	 <c:choose>
       	 <c:when test="${empty mTPRegistrationCertificate.uploadedDemand && requestScope.login eq 'L4' && not empty mTPRegistrationCertificate.mhoRemark && not empty mTPRegistrationCertificate.cellRemark && not empty mTPRegistrationCertificate.nodaltocellRemark}">
       	 
          
    <td>
        <span class="" style="font-size: 14px">
            <fmt:message key="Upload Inspection Report" />:
        </span>
    </td>
        <td colspan ="3" style="text-align: center">
                    <input type="file" name="demanddoc" id="demanddoc" style="width: 220px" /></td>
                 <td> <input type="button" class="ClsButton clsButtonUpload" id="demandUpload" name="demandUpload" value="Upload" onclick="uploadPoliceNoc1();">
               
                </td>
        </c:when>
        <c:otherwise>
            <c:if test="${not empty mTPRegistrationCertificate.uploadedDemand}">
               <td>
        <span class="" style="font-size: 14px">
            <fmt:message key="Inspection Report" />:
        </span>
    </td>
                <td colspan ="3" style="text-align: center">
                   
                    
                      <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${mTPRegistrationCertificate.uploadedDemand}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                </td>
                
                
                
            </c:if>
        </c:otherwise>
    </c:choose>
</tr>
<c:if test="${requestScope.rtiApplication.workFlowStatus==2 && requestScope.login eq 'L1'}">

				<tr>
					<td colspan="6" align="center"><a
						class="bg-button btn btn-success bd-highlight generateaction"
						id="genCerBtn" style="color: white"
						onclick="downloads('${mTPRegistrationCertificate.rti_ref_id}', 'mtpCertificateReport.do');"
						type="button" target="_blank"> <span class="download"
							style="display: flex; align-items: center;width: 135px;">Generate
								Certificate</span>
					</a><a class="bg-button btn btn-success bd-highlight action"
											style="color: white" id="dsc" type="button" target="_blank"
											onclick="download1(${mTPRegistrationCertificate.rti_ref_id});return false;"><span
												class="download" style="align-items: center">Apply
													DSC</span></a></td>
				</tr>
			
<tr>
  <td><span class="ClsLabel" style="font-size:14px">Certificate Upload: </span> </td>
     <%@include file="/pages/common-pages/dms/fileUpload.jsp"%> 
     </tr>
     </c:if>
     
     <c:if test="${empty mTPRegistrationCertificate.mhoRemark ||  empty mTPRegistrationCertificate.cellRemark ||  empty mTPRegistrationCertificate.nodaltocellRemark}">
     
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
		
      </table>
   </div>
<input type="hidden" class="ClsTextbox" id="servicemtpId"
	style="width: 180px" name="servicemtpId"
	value="<c:out value="${requestScope.rtiApplication.rtiserviceid}"/>" />

<input type="hidden" class="ClsTextbox" id="mtpId"
	style="width: 180px" name="mtpId"
	value="<c:out value="${mTPRegistrationCertificate.mtpId}"/>" />

<input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId"
	value="<c:out value="${mTPRegistrationCertificate.rti_ref_id}"/>"/>
	
	
	
<input type="hidden" id="rtiApplicationRefIds"
	name="rtiApplicationRefIds" value="${mTPRegistrationCertificate.rti_ref_id}" />
	<input type="hidden" id="responseData" name="responseData"
								value="" />
<c:choose>
    <c:when test="${requestScope.login eq 'L3'}">
           <c:if test="${empty mTPRegistrationCertificate.mhoRemark && not empty mTPRegistrationCertificate.cellRemark}">
   
    <div class="note-point">
    <div class="note-point-circle"></div>
    <div class="note-point-content">
      <h6>Verification completed by PCPNDT Cell. Kindly proceed further to either approve by saving remarks and send for inspection, or reject.</h6>
     
    </div>
  </div> 
  </c:if>
      </c:when>
   
   
    <c:otherwise>
    </c:otherwise>
</c:choose>

<c:if test="${empty mTPRegistrationCertificate.nodaltocellRemark  && requestScope.rtiApplication.workFlowStatus==0 && (requestScope.login eq 'L3' || requestScope.login eq 'L1')}">
   
    <div class="note-point">
    <div class="note-point-circle"></div>
    <div class="note-point-content">
      <h6>Please save the remark to proceed with the application or you can reject the application.</h6>
     
    </div>
  </div> 
  </c:if>

              <c:if test="${not empty mTPRegistrationCertificate.nodaltocellRemark && empty mTPRegistrationCertificate.cellRemark  && requestScope.login eq 'L2'}">
<div class="note-point">
    <div class="note-point-circle"></div>
    <div class="note-point-content">
      <h6>PCPNDT Cell: Please verify the application and provide your remarks.

</h6>
    </div>
  </div>   
</c:if>
  
       	 <c:if test="${empty mTPRegistrationCertificate.uploadedDemand && requestScope.login eq 'L4' && not empty mTPRegistrationCertificate.mhoRemark && not empty mTPRegistrationCertificate.cellRemark && not empty mTPRegistrationCertificate.nodaltocellRemark}">
<div class="note-point">
    <div class="note-point-circle"></div>
    <div class="note-point-content">
      <h6>Kindly Upload Inspection Report.</h6>
    </div>
  </div>   
</c:if>
    <c:if test="${requestScope.login eq 'L3'}">

        <%@include file="/pages/workflow/taskInclude.jsp"%>
        </c:if>
          <c:if test="${(requestScope.login eq 'L1' && not empty mTPRegistrationCertificate.uploadedDemand) || (requestScope.login eq 'L1' && (requestScope.rtiApplication.workFlowStatus==0 || requestScope.rtiApplication.workFlowStatus==2 ||requestScope.rtiApplication.workFlowStatus==1 || requestScope.rtiApplication.workFlowStatus==5))}">

        <%@include file="/pages/workflow/taskInclude.jsp"%>
        </c:if>
        <c:if test="${(requestScope.login eq 'L1' && requestScope.rtiApplication.workFlowStatus==0 && not empty mTPRegistrationCertificate.uploadedDemand && not empty mTPRegistrationCertificate.nodaltocellRemark )}">
        
        </c:if>

<script>
function saveFees() {
    var nodaltocellRemark = $('#nodaltocellRemark');
    var cellRemark = $('#cellRemark');
    var mhoRemark = $('#mhoRemark');
    var uploadedDemand = $('#uploadedDemand').val(); // Get the value

    if (nodaltocellRemark.val() !== '') {
        if (confirm('Are you sure you want to save?')) {
            var uid = $('#rtiApplicationRefIds').val();
            onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveMTPRemarks.do');
            $("#nodaltocellRemark").prop('disabled', true);
        } else {
            return false;
        }
    } else if (cellRemark.val() !== '') {
        if (confirm('Are you sure you want to save?')) {
            var uid = $('#rtiApplicationRefIds').val();
            onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveMTPRemarks.do');
            $("#cellRemark").prop('disabled', true);
        } else {
            return false;
        }
    } else if (mhoRemark.val() !== '') {
        if (confirm('Are you sure you want to save?')) {
            var uid = $('#rtiApplicationRefIds').val();
            onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveMTPRemarks.do');
            $("#mhoRemark").prop('disabled', true);
        } else {
            return false;
        }
    } else {
        alert("Please enter a remark and save.");
        return false;
    }
}

$('#demandUpload').click(function() {
    $(this).prop('clicked', true);
});

</script>
<script>

$(document).ready(function () {
	var nodaltocellRemark = $('#nodaltocellRemark').val();
    var cellRemark = $('#cellRemark').val();
    var mhoRemark = $('#mhoRemark').val();
	  var workflowstatus = "${requestScope.rtiApplication.workFlowStatus}";

    // If feeId is not empty, disable the button on document ready
    if (nodaltocellRemark !== "" ||  workflowstatus ===5) {
        $("#nodaltocellRemark").prop('disabled', true);


    }
    if (cellRemark !== "" || workflowstatus ===5) {
        $("#cellRemark").prop('disabled', true);


    }
    if (mhoRemark !== "" ||  workflowstatus ===5) {
        $("#mhoRemark").prop('disabled', true);


    }
    
});

</script>

    <script type="text/javascript">
function saveEntity()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/createWorkflowMtpregistration.do');
}

function docDownload(filesPath) {
	    var encodedFilePath = encodeURIComponent(filesPath);

	    var encodedFilesPath = btoa(encodedFilePath); 

	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
	}
/* function download(id, url) {
	  // Check if outward number has been generated
	  var outwardNumber = document.getElementById("outwardNo").value;
	  if (outwardNumber == "") {
	    alert("Please generate outward number first.");
	    event.preventDefault();
	    return false;
	  }

	  // If outward number has been generated, set the RTI application reference ID and submit the form to download the certificate
	  document.getElementById('rtiApplicationRefId').value = id;
	  onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);


	} */

	

</script>
<script type="text/javascript">
$(document).ready(function() {
	  var workflowstatus = "${requestScope.rtiApplication.workFlowStatus}";
	  if (workflowstatus ==5) {
			var elements = document.getElementsByClassName("tab")[0];
		    elements.innerHTML = "RTS Application is Rejected".fontcolor("red");
		    $('#commentsDisable *').attr('disabled', true);
		    $('#CreateWorkflow').attr('disabled', true);
		    $('#RejectCreateWorkflow').attr('disabled', true);
		    $('#WORKFLOW_COMMENTS').attr('disabled', true);
		    $('#mhoRemark').attr('readonly',true);
		    
		    $('#savefees').attr('disabled', true);
		    $('#savefees').hide();


	  }
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
            alert("Please upload the inspection report.");
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
                filesPath = filesPath + basePath + "mTPRegistrationCertificate/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 1;
        var uid1 = document.getElementById('mtpId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadManageMTP.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false 
            }).done(function (data) {
            if(data.status==true || data.status=='true'){
            	  
alert("Inspection Report uploaded Successfully");
                window.location.reload(); 
          	}else{
alert("Inspection Report upload failed!!");

          	}
            

        });

        var a = filesPath.substring(0, filesPath.lastIndexOf(","));
        filesPath = filesPath.replace(/\s/g, "");
        $("#filesPath").val(filesPath);
        console.log(filesPath);

    }
    
    $(document).ready(function() {
       // var uploadedDemand = $('#uploadedDemand').val(); // Get the value
       

 	    var uploadedDemand = "${mTPRegistrationCertificate.uploadedDemand}";
 		var workflowStatus="${requestScope.rtiApplication.workFlowStatus}";
 	    if (workflowStatus==='0' && uploadedDemand ===''){     
 	        var elements = document.getElementsByClassName("tab")[0];
 	        elements.innerHTML = "".fontcolor("red");
 	        $('#commentsDisable *').attr('disabled', true);
 	        $('#CreateWorkflow').attr('disabled', true);
 	        $('#CreateWorkflow').hide();
 	        $('#RejectCreateWorkflow').attr('disabled', false);
 	        $('#WORKFLOW_COMMENTS').attr('disabled', false);
 	        $('#idProof').attr('disabled', false);
 	    }
 	    else if(workflowStatus==='1'){
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