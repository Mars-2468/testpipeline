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
		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/editBioMedicalWaste.do');
	}

	function saveMandapCertificates() {

		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveBiologicalWasteDisposal.do');
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

		<fmt:message key="Bio Medical Waste Disposal(BMWD)(जैव वैद्यकीय कचरा विल्हेवाट)" />
		:
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>


	</h3>
</div>
<div valign="top" id="">
	<input type="hidden" name="id"
		value="${biologicalWasteDisposal.bwdId}">
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		<tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Title (शीर्षक)" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 350px;" id="title" name="title"
				value="<c:out value="${biologicalWasteDisposal.title}"/>" readonly/></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Name (नाव)" />:</span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 350px"
				id="firstName"  name="firstName"
				value="<c:out value="${biologicalWasteDisposal.firstName}"/>" readonly/></td>

		
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Father's Name(वडीलांचे नाव)" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 350px;" id="middleName"  name="middleName"
				value="<c:out value="${biologicalWasteDisposal.middleName}"/>" readonly/></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Surname (आडनाव)" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td>
<input type="text" class="form-control" style="width: 350px"
				id="lastName"  name="lastName"
				value="<c:out value="${biologicalWasteDisposal.lastName}"/>" readonly/>
			</td>
		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Full Name (संपूर्ण नाव)" /></span><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 350px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${biologicalWasteDisposal.fullName}"/>" readonly/></td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Email Id (ई	- मेल आयडी)" /></span><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 350px"
				id="email"  name="email"
				value="<c:out value="${biologicalWasteDisposal.email}"/>" readonly/></td>
		</tr>
		
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Mobile No.(मोबाईल क्र.)" /></span><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 350px"
				id="mobileNumber" maxlength="50" name="mobileNumber"
				value="<c:out value="${biologicalWasteDisposal.mobileNumber}"/>" readonly/></td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Zone No(झोन क्र.)" /></span><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 350px"
				id="ownerName"  name="ownerName"
				value="<c:out value="${biologicalWasteDisposal.zoneNo}"/>" readonly/></td>
		</tr>
		
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Educational Qualification (शैक्षणिक पात्रता)" />:</span></td>
			<td><input type="text" class="form-control" style="width: 350px"
				id="education"
				name="education"
				value="<c:out value="${biologicalWasteDisposal.education}"/>" readonly/></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Other degree (इतर पदवी)"/></span><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 350px"
				id="otherDegree"  name="otherDegree"
				value="<c:out value="${biologicalWasteDisposal.otherDegree}"/>" readonly/></td>

		</tr>
			<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Name of Hospital/Clinic/Office (रुग्णालय/क्लिनिक/कार्यालयाचे नाव)" /></span><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 350px"
				id="hospitalName" maxlength="50" name="hospitalName"
				value="<c:out value="${biologicalWasteDisposal.hospitalName}"/>" readonly/></td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Address of Hospital/Clinic (हॉस्पिटल/क्लिनिकचा पत्ता)" /></span><span class="ClsRequiredFields"></span>: </td>
			<td>
			<textarea
					class="form-control" style="width: 350px" id="address"
					 name="address" readonly>${biologicalWasteDisposal.hospitalAddress}</textarea>
			</td>
			
					</tr>
		<tr>
             <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Type of Medical Profession(वैद्यकीय व्यवसायाचा प्रकाराचे नाव)"/>:</span></td>
			<td><input type="text" class="form-control" style="width: 350px"
				id="medicalProfessionType" 
				name="medicalProfessionType"
				value="<c:out value="${biologicalWasteDisposal.medicalProfessionType}"/>" readonly/></td>
             
             
             
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Number of beds available (उपलब्ध खाटांची संख्या)" />:</span></td>
			<td><input type="text" class="form-control" style="width: 350px"
				id="numberOfBeds" 
				name="numberOfBeds"
				value="<c:out value="${biologicalWasteDisposal.numberOfBeds}"/>" readonly/></td>

			
		</tr>
			
					<tr>
		     
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Medical Council Registration No.(मेडिकल कौन्सिलचा नोंदणी क्र.)" />:</span></td>
			<td><input type="text" class="form-control" style="width: 350px"
				id="medicalCouncilRegNumber" 
				name="medicalCouncilRegNumber"
				value="<c:out value="${biologicalWasteDisposal.medicalCouncilRegNumber}"/>" readonly/></td>

			
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Full details of other professionals if any (इतर व्यवसाय असल्यास त्यांची संपूर्ण माहिती)" />:</span></td>
			<td><input type="text" class="form-control" style="width: 350px"
				id="otherProfessionalsDetails" 
				name="otherProfessionalsDetails"
				value="<c:out value="${biologicalWasteDisposal.otherProfessionalsDetails}"/>" readonly/></td>

			</tr>
			
			
					<tr>
		     
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Description of BioMedical Waste(जैविककचऱ्याचे विवरण)" />:</span></td>
				<td>
			<textarea
					class="form-control" style="width: 350px" id="biologicalWasteDescription"
					 name="biologicalWasteDescription" readonly>${biologicalWasteDisposal.biologicalWasteDescription}</textarea>
			</td>
		
		
  
	    <td>
                           <span class="ClsLabel" style="font-size:14px;width: 400px"><fmt:message key="Fees Applicable (शुल्क लागू)" />:</span>
                        </td>
                         <c:choose>
        <c:when test="${empty biologicalWasteDisposal.demandfees}">
        
                           <td style="text-align: center">
                            <input type="number" class="form-control" id="feesApplicable" maxlength="5"  style="width:350px" name="demandfees" value="<c:out value="${biologicalWasteDisposal.demandfees}"/>" oninput="validateInput(this);"/>
                          </td>
     	 </c:when>
        <c:otherwise>
            <td style="text-align: center">
                            <!-- <input type="number" class="form-control" id="feesApplicable" maxlength="5" style="margin-left: 192px;width:200px" name="demandfees" readonly value="<c:out value="${waterDisconnection.demandfees}"/>"/>-->
                            <input type="number" class="form-control" id="feesApplicable" maxlength="5" style="width:350px" name="demandfees" 
    value="<c:out value="${biologicalWasteDisposal.demandfees}"/>" oninput="validateInput(this);" readonly>
                            
            </td>
        </c:otherwise>
    </c:choose>
</tr>
 <tr> <input type="hidden" name="UID" value="${biologicalWasteDisposal.rti_ref_id}" />

		
			<td><span class="ClsLabel" style="font-size:14px;">
					<b>Current Status:</b></span></td>
			<td style="width: 230px; height: 30px;color:forestgreen;"><span class="ClsLabel"
				style="font-size: 14px"> <c:if
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
					</c:if></span></td>
					
					</tr>
					<tr>     
       
			
                <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
              <td colspan='2'><span class="ClsLabel" style="font-size:14px">Certificate Upload: </span> </td>
              
     <%@include file="/pages/common-pages/dms/fileUpload.jsp"%>   
    
                     </c:if>
      
     </tr>
     <tr>	
       
	</table>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="container">

<tr>
			<td colspan="4"><span class="ClsLabel"
				style="font-size: 15px; font-weight: bold;"><fmt:message
						key="List of Documents (with attachment)" />:</span></td></tr>
			<c:if test="${doc[0] != 'null'}">
						
		<tr>
			<td style="width: 600px; height: 10px">
			<span class="ClsLabel"
				style="font-size: 14px;"><fmt:message
						key="Degree Certificate (पदवी प्रमाणपत्र)" />:</span></td>

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

		
	    <c:if test="${doc[1] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Council Registration Certificate (कौन्सिल नोंदणी प्रमाणपत्र)" />:</span></td>
<td style="text-align: center"><a class="bg-button btn btn-primary bd-highlight action"
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
						key="Aadhaar Card(आधार कार्ड)" />:</span></td>
<td style="text-align: center"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[2]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>		
	</td>	

		</tr></c:if>
		<c:if test="${doc[3] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Current year receipt of property tax (मालमत्ता कराची चालू वर्षाची पावती)" />:</span></td>
<td style="text-align: center"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[3]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>	
	</td>	

		</tr></c:if>
			 <c:if test="${doc[4] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Property document or rent agreement(If
            rented)(मालमत्ता दस्तऐवज किंवा भाडे करार (भाड्याने
            घेतल्यास))" />:</span></td>
<td style="text-align: center"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[4]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>	

		</tr></c:if>
		
		
        <c:if test="${empty biologicalWasteDisposal.demandfees}">

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
	<br>
</div>

 <input type="hidden" class="ClsTextbox" id="bwdId" style="width:180px"  name="bwdId" value="<c:out value="${biologicalWasteDisposal.bwdId}"/>" />
    <input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="" />
	<input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${biologicalWasteDisposal.rti_ref_id}" />

    
     <%@include file="/pages/workflow/taskInclude.jsp"%>
     
     
     <script type="text/javascript">
	function saveEntity() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createBioMedicalWorkWork.do');
	}
	

	function downloadOrView(event, documentUrl) {
        if (event.ctrlKey || event.metaKey) {
            // Download document
            window.location.href = documentUrl;
        } else {
            // Show document viewer
            var viewer = document.getElementById('documentViewer');
            var iframe = document.createElement('iframe');
            iframe.src = encodeURI(documentUrl); // Ensure URL is properly encoded
            iframe.style.width = '600px'; // Adjust the size as needed
            iframe.style.height = '400px'; // Adjust the size as needed
            iframe.style.border = 'none';
            viewer.innerHTML = ''; // Clear previous content
            viewer.appendChild(iframe);
            document.getElementById('overlay').style.display = 'block';
            viewer.style.display = 'block';
        }
    }

    function closeDocumentViewer() {
        document.getElementById('overlay').style.display = 'none';
        document.getElementById('documentViewer').style.display = 'none';
    }


 	function docDownload(filesPath) {
 	    var encodedFilePath = encodeURIComponent(filesPath);

 	    var encodedFilesPath = btoa(encodedFilePath); 

 	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
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
            inputElement.value = inputElement.value.slice(0, 4);
            alert("Please enter a value with a maximum of 5 digits.");
        }

        // Ensure non-zero values
        if (inputElement.value == 0) {
            inputElement.value = "";
            alert("Please enter a non-zero value.");
        }
    }
</script>
	
<script type="text/javascript">
function saveFees() {
	var feeId = $('#feesApplicable');

  if (feeId.val() !== '' ) {
   
	   if (confirm('Are you sure you want to save?')) {
        var uid = $('#rtiApplicationRefIds').val();

        onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveBioMedical.do');
        feeId.prop('readonly', true);
        } else {
            return false;
        }
    } else {
         alert("Please save fees.");
        return false;
    }
}

</script>
<script>
$(document).ready(function() {
    var sendDemand = document.getElementById("CreateWorkflow");
    var feeId = $('#feesApplicable');

    if (feeId.val() === '') {
        $('#CreateWorkflow').attr('disabled', true);
    }
});
</script>
