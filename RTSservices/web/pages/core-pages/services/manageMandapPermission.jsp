<%@page contentType="text/html" pageEncoding="UTF-8"%>
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


pageContext.setAttribute("LABEL_RADIO_COMMERICAL",  CoreConstants.LABEL_RADIO_COMMERICAL);
pageContext.setAttribute("LABEL_RADIO_CHARITABLE",  CoreConstants.LABEL_RADIO_CHARITABLE);
pageContext.setAttribute("LABEL_RADIO_GOVERNMENT",  CoreConstants.LABEL_RADIO_GOVERNMENT);


pageContext.setAttribute("RADIO_COMMERICAL",  CoreConstants.RADIO_COMMERICAL);
pageContext.setAttribute("RADIO_CHARITABLE",  CoreConstants.RADIO_CHARITABLE);
pageContext.setAttribute("RADIO_GOVERNMENT",  CoreConstants.RADIO_GOVERNMENT);

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

</style>
<div class="mainHdr">
	<h3 style="font-size: 18px; font-weight: bold;">

		<fmt:message key="Application form for Mandap Permission" />
		:
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>


	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<input type="hidden" name="id"
		value="${mandapPermission.mandapPermissionId}">
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		<tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.name" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 250px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mandapPermission.firstName}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.fathername" />:</span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 250px;"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mandapPermission.middleName}"/>" /></td>

			</td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.surnname" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 250px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mandapPermission.lastName}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.fullname" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td>
<input type="text" class="form-control" style="width: 250px;"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mandapPermission.fullName}"/>" />
			</td>
		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.address" />:</span></td>
			<td><textarea class="form-control" style="width: 250px;"
					id="ownerAddress" maxlength="200" name="ownerAddress" rows="2">${mandapPermission.address}</textarea></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.emailid" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 250px;"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mandapPermission.email}"/>" /></td>

		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.pincode" />:</span></td>
			<td><input type="text" class="form-control" style="width: 250px;"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${mandapPermission.pinCode}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.aadhaarNo" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 250px;"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mandapPermission.aadharNo}"/>" /></td>

		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.zoneno" />:</span></td>
			<td><input type="text" class="form-control" style="width: 250px;"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${mandapPermission.zoneNo}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.ward" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 250px;"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mandapPermission.wardNo}"/>" /></td>

		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.dateofevent" />:</span></td>
			<td><input type="date" class="form-control" style="width: 250px;"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mandapPermission.eventDate}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.reason" />:</span><span class="ClsRequiredFields"></span></td>
			<td><textarea class="form-control" style="width: 250px;"
					id="ownerAddress" maxlength="200" rows="2" name="ownerAddress">${mandapPermission.reasonForCertificate}</textarea>

			</td>
		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.length" />:</span></td>
			<td><input type="text" class="form-control" style="width: 250px;"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${mandapPermission.pavilionLength}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.breadth" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 250px;"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mandapPermission.pavilionBreadth}"/>" /></td>

		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.fromdate" />:</span></td>
			<td><input type="date" class="form-control" style="width: 250px;"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${mandapPermission.pavilionStartDate}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.todate" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="date" class="form-control" style="width: 250px;"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mandapPermission.pavilionEndDate}"/>" /></td>

		</tr>
<tr>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.mobileno" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 250px;"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mandapPermission.mobileNo}"/>" /></td>





      <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="Purpose" />:</span>
                        </td>
                         <td>
                            <input type="text" class="form-control" id="" style="width: 250px;" maxlength="10" name="label.mandap.Purpose" value="<c:out value="${mandapPermission.purpose}"/>"/>
                          </td>
                          </tr>
                          
                          <tr>
                            <c:if test="${not empty mandapPermission.exhibitions}">
  
                          <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.mandap.exhibitions" />:</span> 
                        </td> 
                        <td>
                          <input type="radio" id="Commercial<c:out value="${pageScope.LABEL_RADIO_COMMERICAL}"/>" name="exhibitions" value="1" <c:if test="${mandapPermission.exhibitions==1}">checked="checked"</c:if> /><c:out value="Commercial"/>
                          <input type="radio" id="Charitable<c:out value="${pageScope.LABEL_RADIO_CHARITABLE}"/>" name="exhibitions" value="2" <c:if test="${mandapPermission.exhibitions==2}">checked="checked"</c:if> /><c:out value="Charitable"/>
                          <input type="radio" id="Government<c:out value="${pageScope.LABEL_RADIO_GOVERNMENT}"/>" name="exhibitions" value="3" <c:if test="${mandapPermission.exhibitions==3}">checked="checked"</c:if> /><c:out value="Government"/>
                        </td>
                        
                        </c:if>
                        
      <%--   <tr>
                            <td colspan="5">
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.mandap.fees" />:</span>
                        </td>
            </tr> --%>
               <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.mandap.size"/>:</span>
                        </td>
                           <td>
                            <input type="text" class="form-control" id="" style="width: 250px;" maxlength="10" name="" value="<c:out value="${mandapPermission.totalSize}"/>"/>
                          </td>
                                   </tr>
                         <tr>
                             <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.mandap.feesapplicable" />:</span>
                        </td>
                           <td>
                            <input type="text" class="form-control" id="" maxlength="10" style="width: 250px;" name="" value="<c:out value="${mandapPermission.fees}"/>"/>
                          </td>
                         
    <td>
        <span class="ClsLabel" style="font-size:14px;width: 400px"><fmt:message key="label.mandap.addFee" />:</span>
    </td>
    <td>
        <input type="number" class="form-control" id="feesApplicable" maxlength="4" style="width:250px" name="feesDemand" value="<c:out value="${mandapPermission.feesDemand}"/>"
               oninput="validateInput(this);" />
    </td>
                         
                     <!--<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">

<tr>
	       <td colspan="6" align="center">
                      <a target="_blank" href="" id="genCerBtn">
                      
                      <button class="ClsButton clsButtonUpload" onclick="download(${mandapPermission.rti_ref_id},'mandapCertificateReport.do')">GENERATE CERTIFICATE</button>
                   
                     </a>
                    
           </td> 
           </tr>
</c:if>-->

<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">

<tr>
	<td colspan="6" align="center"><a
		class="bg-button btn btn-success bd-highlight generateaction"
		id="genCerBtn" style="color: white"
		onclick="downloads('${mandapPermission.rti_ref_id}', 'mandapCertificateReport.do');"
		type="button" target="_blank"> <span class="download"
			style="display: flex; align-items: center;width: 160px;">Generate
				Certificate</span>
	</a><a class="bg-button btn btn-success bd-highlight action"
							style="color: white" id="dsc" type="button" target="_blank"
							onclick="download1(${mandapPermission.rti_ref_id});return false;"><span
								class="download" style="align-items: center">Apply
									DSC</span></a></td>
</tr>
</c:if>



	</table>
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px">
					Current Status:</span></td>
			<td style="width: 285px; height: 30px    color: forestgreen;"><strong><span class="ClsLabel" style="font-size:14px;color:forestgreen;"> <c:if
						test="${requestScope.rtiApplication.workFlowStatus==0}">
						<b>Citizen Form Submitted. </b>
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
						<b>Citizen Payment Pending. </b>
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
						<b>Citizen Payment Completed</b>
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						<b>Completed and File Uploaded for Citizen</b>
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						<b>Rejected</b>
					</c:if></span></strong></td>
					
					     
      <%--  <td colspan="6" align="center">
                   	<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
                      <a target="_blank" href="" id="genCerBtn">
                      
                      <button name="rtiApplicationRefId" class="ClsButton clsButtonUpload" onclick="download(${zoneCertificates.rti_ref_id},'zoneCertificateReport.do')">GENERATE CERTIFICATE</button>
                     </a>
                 
	   </td>  --%>
	   
			
                <c:if test="${requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus==1}">
              <td><span class="ClsLabel" style="font-size:14px">Certificate Upload: </span> </td>
     <%@include file="/pages/common-pages/dms/fileUpload.jsp"%>    
                     </c:if>
     
     </tr>
     
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
			<td colspan="4"><span class="ClsLabel"
				style="font-size: 15px; font-weight: bold;"><fmt:message
						key="List of Documents (Attachment) For Mandap Permission" />:</span></td></tr>
								<c:if test="${doc[0] != 'null'}">
						
		<tr>
			<td style="width: 600px; height: 30px"><span class="ClsLabel"
				style="font-size: 14px;"><fmt:message
						key="label.mandap.nocpolice" />:</span></td>

			<td style="text-align: center">
                    <c:set var="doc" value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>		</td>
		</tr>
		</c:if>
				<c:if test="${doc[1] != 'null'}">
		
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.noctraffic" />:</span></td>
<td style="text-align: center"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[1]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>	
	</td>	

		</tr>
		</c:if>
				<c:if test="${doc[2] != 'null'}">
		
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.nocfire" />:</span></td>
<td style="text-align: center"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[2]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>				
	</td>	
	</tr>
	</c:if>
		<tr>


<td colspan="4" align="center"><input type="button"
				class="btn btn-primary"
				style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745;"
				id="savefees" name="savefees"
				value="<fmt:message key="common.button.save"/>"
				onclick="javascript:saveFees(this.form);">
</td>
</tr>


	</table>
	<br>
</div>

 <input type="hidden" class="ClsTextbox" id="mandapPermissionId" style="width:180px"  name="mandapPermissionId" value="<c:out value="${mandapPermission.mandapPermissionId}"/>" />
    <input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="" />
    			  			  <input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${mandapPermission.rti_ref_id}" />
								<input type="hidden" id="responseData" name="responseData"
								value="" />
     <%@include file="/pages/workflow/taskInclude.jsp"%>

<script type="text/javascript">
	function saveEntity() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createMandapPermissionWork.do');
	}
	function saveFees() {
	    var feeId = $('#feesApplicable').val();

	    if (feeId === '') {
	        if (confirm("Are you sure you want to proceed with submitting the request without fees? Please note that once saved, modifications will not be possible.")) {
	            $('input[name="feesDemand"]').val('0.0'); // Set value to 0.0 for feesDemand
	            var uid = $('#rtiApplicationRefIds').val();
	            onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveMandapAddFee.do?UID=' + uid);
	            // Disable the button after confirmation
	        } else {
	            return false;
	        }
	    } else {
	        if (confirm("Do you want to save the additional charges?")) {
	            var uid = $('#rtiApplicationRefIds').val();
	            onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveMandapAddFee.do?UID=' + uid);
	            // Disable the button after confirmation
	        } else {
	            return false;
	        }
	    }
	}

	
	$(document).ready(function () {
        var feeId = $('#feesApplicable').val();
        $("#feesApplicable").prop('disabled', false);
        $("#savefees").prop('disabled', false);

        // If feeId is not empty, disable the button on document ready
        if (feeId !== "") {
            $("#feesApplicable").prop('disabled', true);
            $("#savefees").prop('disabled', true);
        }
    });
	
	 $(document).ready(function () {
	    	
	    	var fees = '${mandapPermission.sendDemandStatus}';
	    	if(fees==1){
	            $("#feesApplicable").prop('disabled', true);
	            $("#savefees").hide();

	    	}
	    	
	    });

	    //
	     $(document).ready(function () {
        
        var feesApplicable = $('#feesApplicable').val();
        
        if (feesApplicable === '') {
            var elements = document.getElementsByClassName("tab")[0];
            elements.innerHTML = "Please Save Additional Charges.".fontcolor("blue");
            $('#commentsDisable *').attr('disabled', true);
            $('#CreateWorkflow').attr('disabled', true);
            $('#RejectCreateWorkflow').attr('disabled', true);
            $('#WORKFLOW_COMMENTS').attr('disabled', true);
        }
    });

</script>
<script>
    function validateInput(inputElement) {
        // Ensure non-negative values
        if (inputElement.value < 0) {
            inputElement.value = "";
            alert("Please enter a non-negative value.");
        }

        // Limit to four digits
        if (inputElement.value.length > 5) {
            inputElement.value = inputElement.value.slice(0, 4);
            alert("Please enter a value with a maximum of four digits.");
        }

        // Ensure non-zero values
        if (inputElement.value == 0) {
            inputElement.value = "";
            alert("Please enter a non-zero value.");
        }
    }
    

 	function docDownload(filesPath) {
 	    var encodedFilePath = encodeURIComponent(filesPath);

 	    var encodedFilesPath = btoa(encodedFilePath); 

 	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
 	}
</script>