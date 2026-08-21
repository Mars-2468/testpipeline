<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


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


<script type="text/javascript"
	src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.ajaxfileupload.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script type="text/javascript">
	function editRTIApplicationdog() {
		//document.getElementById('rtiApplicationId').value = id;
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIPartMap.do');
	}

	function saveMandapCertificates() {

		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/savePartMap.do');
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

		<fmt:message key="Application form for Part Map" />
		:
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>


	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<input type="hidden" name="id"
		value="${partMap.partMapId}">
<c:set var="doc" value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		<tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.name" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 300px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${partMap.firstName}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.fathername" />:</span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${partMap.middleName}"/>" /></td>

			</td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.surnname" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 300px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${partMap.lastName}"/>" /></td>

<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.partmap.fullname" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 300px;" id="fullName" maxlength="50" name="ownerName"
				value="<c:out value="${partMap.fullName}"/>" /></td>
				
			

			</td>
		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.partmap.aadhaar" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${partMap.aadharNo}"/>" /></td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.partmap.address" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td><textarea class="form-control" style="width: 300px;"
					id="ownerAddress" maxlength="200" name="ownerAddress" rows="2">${partMap.fullAddress}</textarea>
			
		</tr>
		<tr>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.partmap.email" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${partMap.email}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.partmap.mobileno" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${partMap.mobileNo}"/>" /></td>

			

		</tr>
		<tr>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.partmap.pincode" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${partMap.pinCode}"/>" /></td>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.partmap.khasarano" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${partMap.khasaraNo}"/>" /></td>

		
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.partmap.mouje" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${partMap.mouje}"/>" /></td>
					<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.partmap.surveyno" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${partMap.citySurveyNo}"/>" /></td>
				
			
		</tr>
				<tr>
		<c:if test="${not empty partMap.zoneNo}">
		<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.treeTrimming.zoneNo" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${partMap.zoneNo}"/>" /></td>
				</c:if>

	   <!--  <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">

<tr>
	       <td colspan="6" align="center">
                      <a target="_blank" href="" id="genCerBtn">
                      
                      <button class="ClsButton clsButtonUpload" onclick="download(${partMap.rti_ref_id},'partMapReport.do')">GENERATE CERTIFICATE</button>
                   
                     </a>
                    
           </td> 
           </tr>
</c:if>-->
	<%-- <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">

									<tr>
										<td colspan="6" align="center"><a
											class="bg-button btn btn-success bd-highlight generateaction"
											id="genCerBtn" style="color: white"
											onclick="downloads('${partMap.rti_ref_id}', 'partMapReport.do');"
											type="button" target="_blank"> <span class="download"
												style="display: flex; align-items: center;">Generate
													Certificate</span>
										</a> <a class="bg-button btn btn-success bd-highlight action"
											style="color: white" id="dsc" type="button" target="_blank"
											onclick="download1(${partMap.rti_ref_id});return false;"><span
												class="download" style="align-items: center">Apply
													DSC</span></a></td>


									</tr>
								</c:if> --%>





			<td><span class="ClsLabel" style="font-size: 14px">
					Current Status:</span></td>
			<td style="width: 230px; height: 30px"><span class="ClsLabel"
				style="font-size: 14px;color:forestgreen;"> <c:if
						test="${requestScope.rtiApplication.workFlowStatus==0}">
						<b>Citizen Form Submitted. </b>
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
					<b>In progress</b>
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
						<b>In progress</b>
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						<b>Completed and File Uploaded for Citizen</b>
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						<b>Rejected</b>
					</c:if></span></td>
							</tr>
					
					     
      <%--  <td colspan="6" align="center">
                   	<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
                      <a target="_blank" href="" id="genCerBtn">
                      
                      <button name="rtiApplicationRefId" class="ClsButton clsButtonUpload" onclick="download(${zoneCertificates.rti_ref_id},'zoneCertificateReport.do')">GENERATE CERTIFICATE</button>
                     </a>
                 
	   </td>  --%>
	   
	     
     <tr>
    <td colspan="2">
        <span class="ClsLabel" style="font-size: 14px">Certificate Upload:</span>
    </td>
        <c:if test="${ empty requestScope.rtiApplication.pdfFilesSavedPath}">
    
        <td>
            <input type="file" class="imagefile" name="idProof" id="idProof" style="width: 220px" />
        </td>
        <td>
            <a class="bg-button btn btn-primary bd-highlight"
                style="color: white" id="birthupload" type="button"
                target="_blank"
                onclick="birthupload(${partMap.rti_ref_id}); return false;">
                <span class="download" style="align-items: center">Upload</span>
            </a>
        </td>
        </c:if>
    <c:if test="${not empty requestScope.rtiApplication.pdfFilesSavedPath}">
        <td>
            
            
            						                           <a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${requestScope.rtiApplication.pdfFilesSavedPath}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
        </td>
    </c:if>
</tr>
     
       
	</table>
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		
<tr>
	
						
						<td colspan="6"
										style="background-color: white; background-color: #c5ddfe;"><span
										class="ClsLabel"
										style="height: 37px; padding: 7px 10px 11px; font-size: 17px; color: #01293d; font-style: italic;"><fmt:message
												key="List of Documents (Attachment) For Partmap Certificate" />:</span></td>
              				<c:if test="${doc[0] != 'null'}">       
		<tr>
			<td style="width: 600px; height: 30px"><span class="ClsLabel"
				style="font-size: 14px;"><fmt:message
						key="City Survey/ 7/12 /Property Card (शहर सर्वेक्षण उतारा/ ७/१२ उतारा /मालमत्ता दस्तऐवज)" />:</span></td>

			<td>
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
				<c:if test="${doc[1] != 'null'}">
		
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Khasara Map (खसरा नकाशा)" />:</span></td>
<td>
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[1]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>	</td>	

		</tr>
		</c:if>
				<c:if test="${doc[2] != 'null'}">
		
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)" />:</span></td>
						<td>
<a class="bg-button btn btn-primary bd-highlight action"
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
						key="City Survey Map (शहर सर्वेक्षण नकाशा)" />:</span></td>
						<td>
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[3]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>		
	</tr>
	</c:if>
		


	</table>
	<br>
</div>

 <input type="hidden" class="ClsTextbox" id="partMapId" style="width:180px"  name="partMapId" value="<c:out value="${partMap.partMapId}"/>" />
    <input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="" />
    			  			  <input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${partMap.rti_ref_id}" />
    
<input type="hidden" id="responseData" name="responseData"
								value="" />
								<input type="hidden" name="files_Path" id="files_Path" value=""/>
     <%@include file="/pages/workflow/taskInclude.jsp"%>

<script type="text/javascript">
	function saveEntity() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createPartMapWork.do');
	}
</script>
<script>


$(document).ready(function() {
	var workflowStatus="${requestScope.rtiApplication.workFlowStatus}";
	if(workflowStatus==='0' || workflowStatus==='3' || workflowStatus==='2'){
	   var elements = document.getElementsByClassName("tab")[0];
	    elements.innerHTML = "If the documents or details are not correct, you can reject the application.".fontcolor("red");
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
		    elements.innerHTML = "Application has been Rejected".fontcolor("red");
		    $('#commentsDisable *').attr('disabled', true);
	       $('#CreateWorkflow').attr('disabled', true);
	       $('#CreateWorkflow').hide();
	       $('#RejectCreateWorkflow').attr('disabled', true);
	       $('#WORKFLOW_COMMENTS').attr('disabled', true);
	}
	
});
</script>
  <script>
 function birthupload(id) {
	    var data = new FormData();
	    var idProofFileInput = $("#idProof");

	    if (idProofFileInput.get(0).files.length === 0) {
	        alert("Please select the document!!");
	        return false;
	    }
	    
	    data.append('idProof', idProofFileInput.get(0).files[0]);

	    if (confirm("Are you sure you want to Upload Certificate?")) {
	        document.getElementById('rtiApplicationRefId').value = id;
	        var uid1 = document.getElementById('rtiApplicationRefIds').value;

	        $.ajax({
	            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadPropertyWaterNoDuesCertificate.do?UID=" + uid1,
	            type: 'POST',
	            data: data,
	            cache: false,
	            dataType: 'json',
	            processData: false, 
	            contentType: false, 
	            async: false,
	            success: function(data, textStatus, jqXHR) {
	                var status = data.status;
	                if (status === true) {
	                    alert("Upload has been done successfully!");
	                    window.location.reload(); 
	                } else {
	                    alert("Upload has been failed !");
	                }
	            },
	            error: function(jqXHR, textStatus, errorThrown) {
	                console.log('ERRORS: ' + textStatus);
	            }
	        });
	    } else {
	        return false;
	    }
	}

 	function download2(id) {
 		  
		
 	    alert("Are you sure you want to issue certificate with DSC ?");
 	  document.getElementById('rtiApplicationRefId').value = id;


 	  $.ajax({
 		  url: "<c:out value='${contextRoot}'/>/mobileapp/rts/DigitalSignRequestString/"+id,
 		
 	        type: 'GET',
 	        dataType: 'xml',
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
 			      	  onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/DigitalSignResponse.do');
 			      	  
 			           
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
