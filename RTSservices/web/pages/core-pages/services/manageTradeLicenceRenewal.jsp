<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
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
	
function downloads(id,url) {

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
<div class="mainHdr">
	<h3> 
		
				<fmt:message key="Application form for Trade Licence Renewal"/> 				
				<c:if test="${requestScope.rtiApplication != null}"> 				
				<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
				</c:if>
			
	</h3>
</div>

			<div valign="top" id="SetFormHeight">
<input type="hidden" name="id"
		value="${tradeLicenceRenewal.tradeRenewalId}">
	<table width="98%" border="0" cellpadding="2" cellspacing="2"
		class="dataForm">
		<tr>
		<tr>
			<td><span
				class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.name" />:</span></td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${tradeLicenceRenewal.firstName}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.fathername" />:</span><span class="ClsRequiredFields"></span></td>
	<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${tradeLicenceRenewal.middleName}"/>" /></td>

			</td>
		</tr>
				<tr>
			<td><span
				class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.surnname" />:</span></td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${tradeLicenceRenewal.lastName}"/>" /></td>
				
				
				<td><span
				class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.fullname" />:</span></td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${tradeLicenceRenewal.fullName}"/>" /></td>
				

		</tr>
		<tr>
		
		<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.pincode" />:</span></td>
			<td><input type="text" class="form-control" style="width: 170px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${tradeLicenceRenewal.pinCode}"/>" />
				&nbsp;</td>
		
		
		<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.aadhaarNo" />:</span></td>
			<td><input type="text" class="form-control" style="width: 170px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${tradeLicenceRenewal.aadhaarNo}"/>" />
				&nbsp;</td>
				
				</tr>
				

			
                 <tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.emailid" />:</span></td>
		
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${tradeLicenceRenewal.email}"/>" /></td>

         <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.mobileno" />:</span></td>
			<td><input type="text" class="form-control" style="width: 170px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${tradeLicenceRenewal.mobileNo}"/>" />
				&nbsp;</td>
		
		
		</tr>
		
			<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.address" />:</span></td>
			<td><input type="text" class="form-control" style="width: 170px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${tradeLicenceRenewal.address}"/>" />
				&nbsp;</td>

			<%-- <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.applicationFor" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${tradeLicenceRenewal.applicationFor}"/>" /></td> --%>
<td><span
				class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.business" />:</span></td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${tradeLicenceRenewal.nameOfBusiness}"/>" /></td>
		</tr>
		<tr>
			

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.businessdetail" />:</span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${tradeLicenceRenewal.businessDetails}"/>" /></td>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.businessEstimated" />:</span></td>
			<td><input type="text" class="form-control" style="width: 170px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${tradeLicenceRenewal.businesDoneDate}"/>" />
				&nbsp;</td>
		</tr>
		
		<tr>

			

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.spaceType" />:</span></td>
			
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${tradeLicenceRenewal.spaceType}"/>" /></td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.length" />:</span></td>
			<td><input type="text" class="form-control" style="width: 170px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${tradeLicenceRenewal.length}"/>" />
				&nbsp;</td>
		</tr>			
					<tr>

			

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.height" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${tradeLicenceRenewal.height}"/>" /></td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.width" />:</span></td>
			<td><input type="text" class="form-control" style="width: 170px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${tradeLicenceRenewal.width}"/>" />
				&nbsp;</td>
		</tr>	
		
		<tr>

			

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.zoneno" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${tradeLicenceRenewal.zoneNo}"/>" /></td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.wardno" />:</span></td>
			<td><input type="text" class="form-control" style="width: 170px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${tradeLicenceRenewal.wardNo}"/>" />
				&nbsp;</td>
		</tr>		
		
		<tr>

			

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.area" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${tradeLicenceRenewal.areaName}"/>" /></td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.tradelicense" />:</span></td>
			<td><input type="text" class="form-control" style="width: 170px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${tradeLicenceRenewal.tradeLicenseNo}"/>" />
				&nbsp;</td>
		</tr>			
		
		<tr>

			

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.address" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${tradeLicenceRenewal.businessUsagePlace}"/>" /></td>
	<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.updatedtradetype" />:</span></td>
			<td><input type="text" class="form-control" style="width: 170px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${tradeLicenceRenewal.updatedTradeType}"/>" />
				&nbsp;</td>
		</tr>			
		
		<tr>

		

            <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.tradeLicenserenewal.fees" />:</span></td>
			<td><input type="text" class="form-control" style="width: 170px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${tradeLicenceRenewal.fees}"/>" />
				&nbsp;</td>
			

		</tr>		
		 
		
		 
		 
			<%--  <tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="CitySurveyNo" />:</span></td>
			<td><input type="text" class="form-control" style="width: 170px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${occupancyCertificate.citySurveyNo}"/>" />
				&nbsp;</td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="FinalPlotNo" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.finalPlotNo}"/>" /></td>

		</tr>			 --%>
				<%-- 	<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Mouje" />:</span></td>
			<td><input type="text" class="form-control" style="width: 170px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${occupancyCertificate.mouje}"/>" />
				&nbsp;</td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="ArchitectName" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.architectName}"/>" /></td>

		</tr>	   --%>
		
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
		
		
			<%-- <tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="StructuralLicenseNo" />:</span></td>
			<td><input type="text" class="form-control" style="width: 170px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${occupancyCertificate.structuralLicenseNo}"/>" />
				&nbsp;</td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="OccupancyCertificate" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.occupancyCertificate}"/>" /></td>

		</tr>
		 --%>
		 
		 
		<%-- <tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Area" />:</span></td>
			<td><input type="text" class="form-control" style="width: 170px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${occupancyCertificate.area}"/>" />
				&nbsp;</td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="FeesApplicable" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${occupancyCertificate.feesApplicable}"/>" /></td>

		</tr> --%>
		<!--<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">

<tr>
	       <td colspan="6" align="center">
                      <a target="_blank" href="" id="genCerBtn">
                      
                      <button class="ClsButton clsButtonUpload" onclick="download(${tradeLicenceRenewal.rti_ref_id},'tradeLicenseRenewalCertificateReport.do')">GENERATE CERTIFICATE</button>
                   
                     </a>
                    
           </td> 
           </tr>
</c:if>-->
<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">

				<tr>
					<td colspan="6" align="center"><a
						class="bg-button btn btn-success bd-highlight generateaction"
						id="genCerBtn" style="color: white"
						onclick="downloads('${tradeLicenceRenewal.rti_ref_id}', 'tradeLicenseRenewalCertificateReport.do');"
						type="button" target="_blank"> <span class="download"
							style="display: flex; align-items: center;width: 160px;">Generate
								Certificate</span>
					</a><a class="bg-button btn btn-success bd-highlight action"
											style="color: white" id="dsc" type="button" target="_blank"
											onclick="download1(${tradeLicenceRenewal.rti_ref_id});return false;"><span
												class="download" style="align-items: center">Apply
													DSC</span></a></td>
				</tr>
			</c:if>
</table>
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
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
            <!-- <td colspan="6" style="padding-top:5px">
                <img src="../images/Transpx.gif" height="15px" />
            </td> -->
        </tr>
        	</table>
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
                     <tr>
                     <td colspan="5">
                      <span class="ClsLabel" style="font-size:14px"><fmt:message key="List of Documents (Attachment) For TradeLicence Renewal" />:</span>
                     </td>
                     </tr>
                     
                   
                 
             
                    <c:if test="${doc[0] != 'null'}">
                     <tr>
                      <td> 
                     
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.tradeLicenserenewal.nocdoc" />:</span>
                     <c:if test="${requestScope.downloadCount>0}">
                    <a target="_blank" href="<c:out value="${requestScope.downloadPath[0]}"/>" id="download1"> 
                    </c:if>
                    <c:if test="${requestScope.downloadCount==0}">
                    <a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/">
                    </c:if></td><td>
                  <c:set var="doc" value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />      
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>                     </td>
                    
                    </c:if>
                         <c:if test="${doc[1] != 'null'}">
                     <tr>
                      <td> 
                     
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.tradeLicenserenewal.formerLicensedoc" />:</span>
                     <c:if test="${requestScope.downloadCount>0}">
                    <a target="_blank" href="<c:out value="${requestScope.downloadPath[1]}"/>" id="download2"> 
                    </c:if>
                    <c:if test="${requestScope.downloadCount==0}">
                    <a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/">
                    </c:if></td><td>
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[1]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>                     </td>
                     </tr>
                     </c:if>
                       <c:if test="${doc[2] != 'null'}">
                     <tr>
                     <td>
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.tradeLicenserenewal.noduesodc" />:</span>
                     <c:if test="${requestScope.downloadCount>0}">
                    <a target="_blank" href="<c:out value="${requestScope.downloadPath[2]}"/>" id="download2"> 
                    </c:if>
                    <c:if test="${requestScope.downloadCount==0}">
                    <a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/Hospital.pdf">
                    </c:if></td><td>
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[2]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>                     </td>
                     </tr>
                     </c:if>
                       <c:if test="${doc[3] != 'null'}">
                     <tr>
                      <td>
                    
                    <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.tradeLicenserenewal.buildingAuthorization" />:</span>
                     <c:if test="${requestScope.downloadCount>0}">
                    <a target="_blank" href="<c:out value="${requestScope.downloadPath[3]}"/>" id="download2"> 
                    </c:if>
                    <c:if test="${requestScope.downloadCount==0}">
                    <a target="_blank" href="http://175.101.6.10:8085/RTS/UploadDoc/Hospital.pdf">
                    </c:if></td><td>
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[3]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>                     </td>
                     </tr> 
                     </c:if>
                     </tr>
                     
                    
 
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
    

</div>
 <input type="hidden" class="ClsTextbox" id="tradeRenewalId" style="width:180px"  name="tradeRenewalId" value="<c:out value="${tradeLicenceRenewal.tradeRenewalId}"/>" />
    <input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="" />
	<input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${tradeLicenceRenewal.rti_ref_id}" />

     <%@include file="/pages/workflow/taskInclude.jsp"%>
     <input type="hidden" id="responseData" name="responseData"
								value="" />
<script type="text/javascript">
function saveEntity()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createTradeLicenceRenewalWork.do');
}


	function docDownload(filesPath) {
	    var encodedFilePath = encodeURIComponent(filesPath);

	    var encodedFilesPath = btoa(encodedFilePath); 

	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
	}
</script>