<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
%>


<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.ajaxfileupload.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script> 
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script type="text/javascript">
function editRTIApplication() {
	//document.getElementById('rtiApplicationId').value = id;
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplication.do');
} 


function saveBirthRegistrationCertificate() {

	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/savezoneCertificate.do');
} 




function rtiApplicationSearch() { 
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/listRTIApplicationReports.do');
}

function viewNoting() { 
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/viewNoting.do');
} 

function viewDrafts(){
	//document.getElementById('manageRTIApplicationId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/viewDrafts.do');
}

function downloadRTIApplicationList(){
	//document.getElementById('manageRTIApplicationId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/downloadRTIApplicationList.do');
}


function listRTIApplicationReports()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/listRTIApplicationReports.do');	
}

function sendEmail()
{
	//document.getElementById('manageRTIApplicationId').value=id;
	document.getElementById('actionTaken').value='email'; 
	onPageSubmit('<c:out value="${contextRoot}"/>/emailsms/emailSMS.do');
}

function sendSMS()
{
	//document.getElementById('manageRTIApplicationId').value=id;
	document.getElementById('actionTaken').value='sms';
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
		
				<fmt:message key="Application form for Occupancy Certificate"/> :			
				<c:if test="${requestScope.rtiApplication != null}"> 				
				<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
				</c:if>
			
	</h3>
</div>
<div valign="top" id="SetFormHeight">
<input type="hidden" name="id"
		value="${occupancyCertificate.occupancyCertificateId}">
	<table width="98%" border="0" cellpadding="2" cellspacing="2"
		class="dataForm">
		<tr>
		<tr>
			<td><span
				class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.name" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.firstName}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Father's Name (वडिलांचे नाव)" />:</span><span class="ClsRequiredFields"></span></td>
	<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.middleName}"/>" /></td>

			</td>
		</tr>
				<tr>
			<td><span
				class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.surnname" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.lastName}"/>" /></td>
				
				<td><span
				class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.marriage.fullname" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.fullName}"/>" /></td>
				
	</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Address For Correspondence (पत्रव्यवहारासाठी पत्ता)" />:</span><span class="ClsRequiredFields"></span></td>
			<td><textarea class="form-control" style="width: 300px"
					id="ownerAddress" maxlength="200" name="ownerAddress">${occupancyCertificate.address}</textarea>

			</td>
		

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenseNameChange.mobileno" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${occupancyCertificate.mobileNo}"/>" />
				&nbsp;</td>
</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenseTypeChange.emailid" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.email}"/>" /></td>

		
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenseCancellation.pincode" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${occupancyCertificate.pinCode}"/>" />
				&nbsp;</td>
</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenseDuplicateCopy.aadhaarno" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${occupancyCertificate.aadharNo}"/>" />
				&nbsp;</td>
			
			
			
		

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterDisconnection.buildingName" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${occupancyCertificate.buildingNo}"/>" />
				&nbsp;</td>
</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterDisconnection.plotNo" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.plotNo}"/>" /></td>

		
			<td><span
				class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.zone.gatno" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.gatNo}"/>" /></td>
</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Khasara No" />:</span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.khasaraNo}"/>" /></td>
			</td>
		

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.fire.citysurveyno" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${occupancyCertificate.citySurveyNo}"/>" />
				&nbsp;</td>
</tr>
			 <tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Final Plot No (अंतिम प्लॉट क्र)" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.finalPlotNo}"/>" /></td>


			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Mouza (मौजा)" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${occupancyCertificate.mouje}"/>" />
				&nbsp;</td>
</tr>
			 <tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Architect Name (
आर्किटेक्टचे नाव)" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.architectName}"/>" /></td>

		
		<%-- 	<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="StructuralLicenseNo" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="ClsTextbox" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.structuralLicenseNo}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="OccupancyCertificate" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="ClsTextbox" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.occupancyCertificate}"/>" /></td>

		</tr>
			<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Area" />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 170px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${occupancyCertificate.area}"/>" />
				&nbsp;</td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="FeesApplicable" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="ClsTextbox" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.feesApplicable}"/>" /></td>

		</tr> --%>
		
		

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Structural License No. (स्ट्रक्चरल परवाना क्र)" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${occupancyCertificate.structuralLicenseNo}"/>" />
				&nbsp;</td>
</tr>
			 <tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Occupancy Certificate(भोगवटा प्रमाणपत्र)" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.occupancyCertificate}"/>" /></td>

		

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.area" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${occupancyCertificate.area}"/>" />
				&nbsp;</td>
</tr>
			 <tr>
			 
			 <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Building No. (इमारत क्र.)" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${occupancyCertificate.buildingNo}"/>" />
				&nbsp;</td>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Revenue No. (महसूल क्र.)" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${occupancyCertificate.revenueNo}"/>" />
				&nbsp;</td>
				</tr>
				<tr>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Zone No. (झोन क्र.)" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${occupancyCertificate.zoneNo}"/>" />
				&nbsp;</td>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenseTypeChange.feesApplicable" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.feesApplicable}"/>" /></td>

		</tr>
		</table>
		<table width="98%" border="0" cellpadding="2" cellspacing="2"
		class="dataForm">
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
						Citizen Payment Completed
					</c:if>
											
					<c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						Completed and File Uploaded for Citizen
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						Rejected
					</c:if></span>
     </td>      
     <td><span class="ClsLabel" style="font-size:14px">Certificate Upload: </span> </td>
     <%@include file="/pages/common-pages/dms/fileUpload.jsp"%>    
     </tr>
       
               
                     <tr>
                    
                   
                 	<td colspan="6"
										style="background-color: white; background-color: #c5ddfe;"><span
										class="ClsLabel"
										style="height: 37px; padding: 7px 10px 11px; font-size: 17px; color: #01293d; font-style: italic;"><fmt:message
												key="List of Documents (Attachment) For Occupancy Certificate" />:</span></td>
                     
                   
             
                                        								<c:if test="${doc[0] != 'null'}">
                    
                     <tr>
                     <td colspan="3">
                     
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="Construction Starting Date Certificate (बांधकाम सुरू झाल्याची तारीख प्रमाणपत्र)" />:</span>
                     <c:if test="${requestScope.downloadCount>0}">
                    <a target="_blank" href="<c:out value="${requestScope.downloadPath[0]}"/>" id="download1"> 
                    </c:if>
                    <c:if test="${requestScope.downloadCount==0}">
                    <a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/">
                    </c:if></td>
                     <td colspan="3">
                  <c:set var="doc" value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />      
<a
												class="bg-button btn btn-primary bd-highlight action"
												type="button" target="_blank"
												href="<c:out value="${doc[0]}"/>"><span class="download"
													style="align-items: center">Download</span></a>                     </td>
                     
                    
                    </tr>
                    </c:if>
                                        								<c:if test="${doc[1] != 'null'}">
                    
                     <tr>
                     <td colspan="3">
                     
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="Architect Certificate (वास्तुविशारद प्रमाणपत्र)" />:</span>
                     <c:if test="${requestScope.downloadCount>0}">
                    <a target="_blank" href="<c:out value="${requestScope.downloadPath[1]}"/>" id="download2"> 
                    </c:if>
                    <c:if test="${requestScope.downloadCount==0}">
                    <a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/">
                    </c:if></td>
                     <td colspan="3">
<a
												class="bg-button btn btn-primary bd-highlight action"
												type="button" target="_blank"
												href="<c:out value="${doc[1]}"/>"><span class="download"
													style="align-items: center">Download</span></a>                     </td>
                     </tr></c:if>
                                         								<c:if test="${doc[2] != 'null'}">
                     
                     <tr>
                     <td colspan="3">
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="Tax Receipt (कर पावती)" />:</span>
                     <c:if test="${requestScope.downloadCount>0}">
                    <a target="_blank" href="<c:out value="${requestScope.downloadPath[2]}"/>" id="download2"> 
                    </c:if>
                    <c:if test="${requestScope.downloadCount==0}">
                    <a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/Hospital.pdf">
                    </c:if></td>
                     <td colspan="3">
<a
												class="bg-button btn btn-primary bd-highlight action"
												type="button" target="_blank"
												href="<c:out value="${doc[2]}"/>"><span class="download"
													style="align-items: center">Download</span></a>                     </td>
                     </tr></c:if>
                                         						<c:if test="${doc[3] != 'null'}">
                     
                     <tr>
                     <td colspan="3">
                    
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="Construction Permission Certificates (बांधकाम परवानगी प्रमाणपत्रे)" />:</span>
                     <c:if test="${requestScope.downloadCount>0}">
                    <a target="_blank" href="<c:out value="${requestScope.downloadPath[3]}"/>" id="download2"> 
                    </c:if>
                    <c:if test="${requestScope.downloadCount==0}">
                    <a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/Hospital.pdf">
                    </c:if></td>
                     <td colspan="3">
<a
												class="bg-button btn btn-primary bd-highlight action"
												type="button" target="_blank"
												href="<c:out value="${doc[3]}"/>"><span class="download"
													style="align-items: center">Download</span></a>                     </td>
                     </tr> </c:if>
                    
                     
                    
     
<%-- <tr>
			<td colspan="6" align="center"><input type="button"
				class="ClsTextbox_mr" id="save" name="save" value="Save"
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
		
<input type="hidden" class="ClsTextbox" style="width:180px" id="rtiapplrefno" maxlength="12" name="rtiapplrefno" value="<c:out value="${treeTrimming.rtiapplrefno}"/>" /> --%>
                       
        

      </table>
   </div>
     <input type="hidden" class="ClsTextbox" id="occupancyCertificateId" style="width:180px"  name="occupancyCertificateId" value="<c:out value="${occupancyCertificate.occupancyCertificateId}"/>" />
     <input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="" />
             			  			  <input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${occupancyCertificate.rti_ref_id}" />
    

     <%@include file="/pages/workflow/taskInclude.jsp"%>
</div>

<script type="text/javascript">
function saveEntity()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createOccupancyCertificateWork.do');
}
</script>