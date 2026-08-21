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


pageContext.setAttribute("LABEL_RADIO_OCCUPANCY",  CoreConstants.LABEL_RADIO_OCCUPANCY);
pageContext.setAttribute("LABEL_RADIO_BUILDING",  CoreConstants.LABEL_RADIO_BUILDING);
pageContext.setAttribute("LABEL_RADIO_SANCTION",  CoreConstants.LABEL_RADIO_SANCTION);


pageContext.setAttribute("RADIO_OCCUPANCY",  CoreConstants.RADIO_OCCUPANCY);
pageContext.setAttribute("RADIO_BUILDING",  CoreConstants.RADIO_BUILDING);
pageContext.setAttribute("RADIO_SANCTION",  CoreConstants.RADIO_SANCTION);

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
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIMobileTower.do');
	}

	function saveMandapCertificates() {

		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveMobileTower.do');
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
<div class="container">
	<h3 style="font-size: 18px; font-weight: bold;">

		<fmt:message key="Application form for Mobile Tower" />
		:
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>


	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<input type="hidden" name="id"
		value="${mobileTower.mobileTowerId}">
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		<tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.name" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 180px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mobileTower.name}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.address" />:</span><span class="ClsRequiredFields"></span></td>
			<td><textarea class="form-control" style="width: 350px;"
					id="ownerAddress" maxlength="200" name="ownerAddress" rows="2">${mobileTower.address}</textarea></td>

			</td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.ownerName" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 180px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mobileTower.ownerName}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.ownerAddress" />:</span><span
				class="ClsRequiredFields"></span></td>
	<td><textarea class="form-control" style="width: 350px;"
					id="ownerAddress" maxlength="200" name="ownerAddress" rows="2">${mobileTower.ownerAddress}</textarea></td>
			</td>
		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.plotno" />:</span></td>
			<td><input type="text" class="form-control" style="width: 100px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mobileTower.plotNo}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.area" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 350px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mobileTower.area}"/>" /></td>

		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.street" />:</span></td>
			<td><input type="text" class="form-control" style="width: 100px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${mobileTower.streetName}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.mauza" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 150px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mobileTower.applicantMouza}"/>" /></td>

		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.pincode" />:</span></td>
			<td><input type="text" class="form-control" style="width: 100px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${mobileTower.pincode}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.aadhaar" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 150px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mobileTower.aadhaarNo}"/>" /></td>

		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.email" />:</span></td>
			<td><input type="text" class="form-control" style="width: 280px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mobileTower.email}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.mobile" />:</span><span class="ClsRequiredFields"></span></td>
			<td><textarea class="form-control" style="width: 350px"
					id="ownerAddress" maxlength="200" rows="2" name="ownerAddress">${mobileTower.mobileNo}</textarea>

			</td>
		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.appplicantaddress" />:</span></td>
				<td><textarea class="form-control" style="width: 350px;"
					id="ownerAddress" maxlength="200" name="ownerAddress" rows="2">${mobileTower.currentAddress}</textarea></td>>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.mouza" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 200px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mobileTower.mouza}"/>" /></td>

		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.sheet" />:</span></td>
			<td><input type="text" class="form-control" style="width: 100px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mobileTower.sheetNo}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.survey" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 100px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mobileTower.citySurveyNo}"/>" /></td>

		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.zone" />:</span></td>
			<td><input type="text" class="form-control" style="width: 100px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${mobileTower.zoneNo}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.ward" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 100px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mobileTower.wardNo}"/>" /></td>

		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.municipal" />:</span></td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${mobileTower.municipalMouza}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.upin" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mobileTower.upin}"/>" /></td>

		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.layout" />:</span></td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${mobileTower.societyName}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.buildingOwner" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mobileTower.buildingOwner}"/>" /></td>

		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.siteaddress" />:</span></td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${mobileTower.siteAddress}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.tower" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mobileTower.mobileTowerCompanyName}"/>" /></td>

		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.towertype" />:</span></td>
			<td><input type="text" class="form-control" style="width: 180px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${mobileTower.towerType}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.toweruse" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="date" class="form-control" style="width: 180px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${mobileTower.startedDate}"/>" /></td>

		</tr>
<tr>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.towerCategory" /><span class="ClsRequiredFields"></span>:
			</td>
			<td colspan="5">
                          <input type="radio" id="occupancy<c:out value="${pageScope.LABEL_RADIO_OCCUPANCY}"/>" name="pob" value="1" <c:if test="${mobileTower.pob==1}">checked="checked"</c:if> /><c:out value="Building With Occupancy certificate"/>
                          <input type="radio" id="building<c:out value="${pageScope.LABEL_RADIO_BUILDING}"/>" name="pob" value="2" <c:if test="${mobileTower.pob==2}">checked="checked"</c:if> /><c:out value="Building Plan approved  but  Occupancy Certificate Not Available"/>
                          <input type="radio" id="sanction<c:out value="${pageScope.LABEL_RADIO_SANCTION}"/>" name="pob" value="3" <c:if test="${mobileTower.pob==3}">checked="checked"</c:if> /><c:out value="Building  With no sanction plan with occupancy certificate"/>
                        </td>
                        
			
                        
                        </tr>
                     
                        
      <%--   <tr>
                            <td colspan="5">
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.mandap.fees" />:</span>
                        </td>
            </tr> --%>
           <tr>
               <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.mobile.manoraarea"/>:</span>
                        </td>
                           <td>
                            <input type="text" class="form-control" id="feesApplicable" style="width: 100px" maxlength="10" name="feesApplicable" value="<c:out value="${mobileTower.manoraArea}"/>"/>
                          </td>
                         
                             <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.mobile.dieselsector" />:</span>
                        </td>
                           <td>
                            <input type="text" class="form-control" id="feesApplicable" maxlength="10" style="width: 100px" name="feesApplicable" value="<c:out value="${mobileTower.dieselGeneratorSector}"/>"/>
                          </td>
                         
     </tr>
                    
    <tr>
               <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.mobile.panelControl"/>:</span>
                        </td>
                           <td>
                            <input type="text" class="form-control" id="feesApplicable" style="width: 100px" maxlength="10" name="feesApplicable" value="<c:out value="${mobileTower.panelControlRoomArea}"/>"/>
                          </td>
                         
                             <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.mobile.totalArea" />:</span>
                        </td>
                           <td>
                            <input type="text" class="form-control" id="feesApplicable" maxlength="10" style="width: 100px" name="feesApplicable" value="<c:out value="${mobileTower.totalArea}"/>"/>
                          </td>
                         
     </tr>
 <tr>
               <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.mobile.scrutinyFees"/>:</span>
                        </td>
                           <td>
                            <input type="text" class="form-control" id="feesApplicable" style="width: 100px" maxlength="10" name="feesApplicable" value="<c:out value="${mobileTower.scrutinyFees}"/>"/>
                          </td>
                         
                             <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.mobile.totalFees" />:</span>
                        </td>
                           <td>
                            <input type="text" class="form-control" id="feesApplicable" maxlength="10" style="width: 100px" name="feesApplicable" value="<c:out value="${mobileTower.totalFees}"/>"/>
                          </td>
                         
     </tr> <tr>
               <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.mobile.height"/>:</span>
                        </td>
                           <td>
                            <input type="text" class="form-control" id="feesApplicable" style="width: 100px" maxlength="10" name="feesApplicable" value="<c:out value="${mobileTower.existingHeight}"/>"/>
                          </td>
                         
                             <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.mobile.totalHeight" />:</span>
                        </td>
                           <td>
                            <input type="text" class="form-control" id="feesApplicable" maxlength="10" style="width: 100px" name="feesApplicable" value="<c:out value="${mobileTower.totalHeight}"/>"/>
                          </td>
                         
     </tr> 

                     <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">

<tr>
	       <td colspan="6" align="center">
                      <a target="_blank" href="" id="genCerBtn">
                      
                      <button class="ClsButton clsButtonUpload" onclick="download(${mobileTower.rti_ref_id},'mobileTowerReport.do')">GENERATE CERTIFICATE</button>
                   
                     </a>
                    
           </td> 
           </tr>
</c:if>
	</table>
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px">
					Current Status:</span></td>
			<td style="width: 230px; height: 30px"><span class="ClsLabel"
				style="font-size: 14px"> <c:if
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
					
					     
      <%--  <td colspan="6" align="center">
                   	<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
                      <a target="_blank" href="" id="genCerBtn">
                      
                      <button name="rtiApplicationRefId" class="ClsButton clsButtonUpload" onclick="download(${zoneCertificates.rti_ref_id},'zoneCertificateReport.do')">GENERATE CERTIFICATE</button>
                     </a>
                 
	   </td>  --%>
	   
			
                <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
              <td><span class="ClsLabel" style="font-size:14px">Certificate Upload: </span> </td>
                </c:if>
     <%@include file="/pages/common-pages/dms/fileUpload.jsp"%>    
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
			<td colspan="5"><span class="ClsLabel"
				style="font-size: 15px; font-weight: bold;"><fmt:message
						key="List of Documents (Attachment) For Mobile Tower" />:</span></td>
		<tr>
			<td style="width: 600px; height: 30px"><span class="ClsLabel"
				style="font-size: 14px;"><fmt:message
						key="label.mobile.uploadLatitudeAndLongitude" />:</span></td>

			<td style="text-align: center">
                    <c:set var="doc" value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
<a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[0]}"/>"><span style="align-items: center">Download</span></a>		
		</td>
		
		<tr>
		
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.ownershipdoc" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[1]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.occupancydoc" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[2]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.sitePlandoc" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[3]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.stabilitydoc" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[4]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.nocdoc" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[5]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.taxdoc" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[6]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.houseScoietydoc" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[7]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.araidoc" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[8]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.clearencedoc" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[9]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.encroachmentdoc" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[10]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.exemptiondoc" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[11]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.termcelldoc" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[12]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.erecteddoc" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[13]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.advisorydoc" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[14]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.guranteedoc" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[15]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
			<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.bpmsdoc" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[16]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
	
		


	</table>
	<br>
</div>

 <input type="hidden" class="ClsTextbox" id="mobileTowerId" style="width:180px"  name="mobileTowerId" value="<c:out value="${mobileTower.mobileTowerId}"/>" />
    <input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="<c:out value=""/>" />
     <%@include file="/pages/workflow/taskInclude.jsp"%>

<script type="text/javascript">
	function saveEntity() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createMobileTower.do');
	}
</script>
