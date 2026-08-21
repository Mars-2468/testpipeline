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
<%@ page import="org.json.JSONArray" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import="com.mars.rti.model.TreeCuting" %>
<jsp:directive.include file="/pages/common/include.jsp" />
 <meta name="viewport" content="width=device-width, initial-scale=1.0">

<c:if test="${not empty sessionScope.workflowActionError}">
<script type="text/javascript">
    alert('<c:out value="${sessionScope.workflowActionError}"/>');
</script>
</c:if>
<%
    session.removeAttribute("workflowActionError");
%>

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
<%
HttpSession session1 = request.getSession();
SessionUser sessionUser = (SessionUser) session1.getAttribute("SessionUser");
Long userId = sessionUser.getUserId();
request.setAttribute("requestScope.forLogin", userId);
%>

<%
    TreeCuting treeCutingObj = (TreeCuting) pageContext.findAttribute("treeCuting");
    String missingDocsJson = (treeCutingObj != null) ? treeCutingObj.getMissingDocs() : null;
    java.util.List<java.util.Map<String,String>> missingDocsList = new java.util.ArrayList<>();
    if (missingDocsJson != null && !missingDocsJson.trim().isEmpty()) {
        try {
            JSONArray arr = new JSONArray(missingDocsJson);
            for (int mdIdx = 0; mdIdx < arr.length(); mdIdx++) {
                JSONObject entry = arr.getJSONObject(mdIdx);
                java.util.Map<String,String> m = new java.util.HashMap<>();
                m.put("label", entry.optString("label", "Document"));
                m.put("path", entry.optString("path", ""));
                missingDocsList.add(m);
            }
        } catch (Exception ex) {
            // malformed JSON - skip rendering rather than break the page
        }
    }
    pageContext.setAttribute("missingDocsList", missingDocsList);
%>

<script type="text/javascript"
	src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.ajaxfileupload.js"></script>
	
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script type="text/javascript">
	function saveEntity() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createTreeCutingWork.do');
	}
</script>
<script type="text/javascript">
	function editRTIApplicationdog() {
		//document.getElementById('rtiApplicationId').value = id;
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editTreeCuting.do');
	}

	function saveMandapCertificates() {

		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveTreeCuting.do');
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
	function downloads1(id,url) {

		document.getElementById('rtiApplicationRefId').value = id;
		
		alert("Certificate has been generated successfully.");
		
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);

	}
	function downloads2(id,url) {

		document.getElementById('rtiApplicationRefId').value = id;
		
		alert("Certificate has been generated successfully.");
		
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);

	}
	function downloads3(id,url) {

		document.getElementById('rtiApplicationRefId').value = id;
		
		alert("Certificate has been generated successfully.");
		
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);

	}
</script>
   <script>
    function validateFees(input) {

        var value = input.value.trim();

        // Empty
        if (value === "") {
            return;
        }

        // Only digits
        if (!/^\d+$/.test(value)) {
            alert("Only positive whole numbers are allowed.");
            input.value = "";
            return;
        }

        var fee = parseInt(value, 10);

        if (fee <= 0) {
            alert("Fee must be greater than zero.");
            input.value = "";
            return;
        }

        // Maximum 8 digits
        if (value.length > 8) {
            alert("Fee cannot exceed 8 digits.");
            input.value = "";
            return;
        }

        // Maximum allowed value
        if (fee > 99999999) {
            alert("Maximum allowed fee is 99999999.");
            input.value = "";
            return;
        }
    }
    </script>
<style>
.upload-container{
    display:flex;
    align-items:center;
    gap:10px;
}

.disabledLabel{
    pointer-events:none;
    opacity:.5;
}

.enabledLabel{
    pointer-events:auto;
    opacity:1;
}
.container {
    width: 100%;
    border-collapse: collapse;
}

.container td,
.container th {
    border: 1px solid #dee2e6;
    padding: 8px;
}

.container tr {
    border-bottom: 1px solid #dee2e6;
}
#documentViewer {
    display: none;
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); /* corrected box-shadow syntax */
    z-index: 10000;
    width: 800px;
    height: 550px;
    overflow: auto; /* Add this line */
}

    /* The modal (background) */
    .modal {
        display: none; /* Hidden by default */
        position: fixed; /* Stay in place */
        z-index: 9999; /* Sit on top */
        left: 0;
        top: 0;
        width: 800px;
        height: 550px;
    
        overflow: auto; /* Enable scroll if needed */
    }

    /* Modal Content/Box */
    .modal-content {
        background-color: #fefefe;
        margin: auto; /* Center the modal */
        padding: 20px;
        border: 1px solid #888;
width: 800px;
        height: 550px;
        position: relative;
        top: 50%;
        transform: translateY(-50%);
    }

    /* Close Button */
    .close {
        color: #aaaaaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }

    .close:hover,
    .close:focus {
        color: #000;
        text-decoration: none;
        cursor: pointer;
    }
</style>



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

</style>
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
.row-style {
    width: 150px;
    height: 30px;
    background-color: white;
    border-radius: 3px;
    border-color: grey;
}

#overlay {
    display: none;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    z-index: 9999;
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

.custom-note-box {
    border: 2px solid #4CAF50; /* Green border color */
    background-color: #f3f3f3; /* Light grey background color */
    padding: 20px;
    border-radius: 10px;
    margin-bottom: 20px;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; /* Font family */
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Box shadow */
        height: 65px;
}

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


</style>
<style>

.fire-docs-table {
    width: 100%;
    border-collapse: collapse;
    border: 1px solid #d9e2ec;
    border-radius: 8px;
    overflow: hidden;
    background: #fff;
    margin-top: 8px;
}

.fire-docs-table tr {
    border-bottom: 1px solid #edf2f7;
}

.fire-docs-table tr:last-child {
    border-bottom: none;
}

.fire-docs-table td {
    padding: 12px 16px;
    font-size: 14px;
    color: #2d3748;
    vertical-align: middle;
    line-height: 1.45;
}

.fire-docs-table td:first-child {
    width: 65%;
    font-weight: 600;
    color: #1f2d3d;
}

.fire-docs-table td:last-child {
    width: 35%;
    text-align: center;
}

.fire-docs-table .ClsLabel {
    font-size: 14px !important;
    font-weight: 600;
    color: #243447;
}

.fire-docs-table .ClsButton,
.fire-docs-table .bg-button,
.fire-docs-table .action {
    display: inline-block;
    min-width: 105px;
    padding: 8px 16px;
    font-size: 14px;
    font-weight: 600;
    color: #fff !important;
    text-decoration: none;
    text-align: center;
    border: none;
    border-radius: 6px;
    background: linear-gradient(180deg, #3f8de8, #1f6fcb);
    box-shadow: 0 2px 6px rgba(31, 111, 203, 0.2);
    transition: all 0.2s ease;
    cursor: pointer;
    vertical-align: middle;
}

.fire-docs-table .ClsButton:hover,
.fire-docs-table .bg-button:hover,
.fire-docs-table .action:hover {
    background: linear-gradient(180deg, #2f7fda, #155fb8);
    box-shadow: 0 3px 8px rgba(31, 111, 203, 0.3);
}

.fire-docs-table input[type="file"] {
    width: 220px;
    max-width: 100%;
    font-size: 13px;
    padding: 5px 8px;
    border: 1px solid #cbd5e0;
    border-radius: 6px;
    background: #fff;
    color: #2d3748;
    vertical-align: middle;
}

/* upload rows - full width layout */
.fire-docs-table tr td[colspan="2"] {
    padding: 14px 16px;
}

.fire-docs-table tr td[colspan="2"] input[type="file"] {
    margin-right: 12px;
}

.fire-docs-table tr td[colspan="2"] .bg-button {
    min-width: 100px;
}


.fire-docs-table tr.spacer td {
    padding: 0 !important;
    height: 4px !important;
    line-height: 0 !important;
    font-size: 0 !important;
    border: none !important;
    background: transparent !important;
}
/* heading */
.fire-docs-heading {
    background: #dce2e8;
    padding: 10px 14px;
    border-left: 4px solid #2f80ed;
    border-radius: 6px;
    color: #1f2d3d;
    font-size: 15px;
    font-weight: 700;
    margin-bottom: 8px;
}

/* mobile */
@media (max-width: 768px) {
    .fire-docs-table,
    .fire-docs-table tbody,
    .fire-docs-table tr,
    .fire-docs-table td {
        display: block;
        width: 100%;
    }

 
    .fire-docs-table td {
    padding: 10px;
    vertical-align: middle;
}

    .fire-docs-table td:first-child,
    .fire-docs-table td:last-child {
        width: 100%;
    }

    .fire-docs-table input[type="file"] {
        width: 100%;
        margin-bottom: 8px;
        margin-right: 0;
    }

    .fire-docs-table td[colspan="2"] input[type="file"] + .bg-button {
        margin-left: 0;
        margin-top: 6px;
    }
}

</style>
<div class = "row print-container">
<div class="container">
	<h3 style="font-size: 18px; font-weight: bold;">

		<fmt:message key="Application form for Tree Cutting" />
		:
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>


	</h3>
</div>
<div valign="top" id="">
	<input type="hidden" name="id"
		value="${treeCuting.treecutingId}">
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		
		<tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Name (नाव)" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 300px;" id="ownerName" maxlength="50" name="ownerName"
				readonly value="<c:out value="${treeCuting.firstName}"/>" readonly/></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Father's Name (वडिलांचे नाव)" />:</span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				readonly value="<c:out value="${treeCuting.middlename}"/>" readonly /></td>

			</td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Surname (आडनाव)" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 300px;" id="ownerName" maxlength="50" name="ownerName"
				readonly value="<c:out value="${treeCuting.lastname}"/>" readonly/></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Full Name (संपूर्ण नाव)" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td>
<input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				readonly value="<c:out value="${treeCuting.fullName}"/>" readonly/>
			</td>
		</tr>
		
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Mobile No.(मोबाईल क्र.)" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeCuting.mobileNo}"/>" readonly/></td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Landmark (लँडमार्क)" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeCuting.landmark}"/>" readonly/></td>
		</tr>
		
		
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Email Id (ईमेल आयडी )" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				readonly value="<c:out value="${treeCuting.email}"/>" readonly/></td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Plot/ Flat No.(प्लॉट/फ्लॅट क्र.)" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				readonly value="<c:out value="${treeCuting.applicantPlotNo}"/>" readonly/></td>
		</tr>
		
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Name of the Building (इमारतीचे नाव)" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				readonly value="<c:out value="${treeCuting.applicantBuildingName}"/>" readonly/></td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Name of the Street (रस्त्याचे नाव)" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				readonly value="<c:out value="${treeCuting.applicantStreetName}"/>" readonly/></td>
		</tr>
		
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Pin Code (पिन कोड)" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				readonly value="<c:out value="${treeCuting.pincode}"/>" readonly/></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="City Name (शहराचे नाव)" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				readonly value="<c:out value="${treeCuting.applicantcity}"/>" readonly/></td>

		</tr>
		<tr>
		<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.area" />:</span><span class="ClsRequiredFields"></span></td>
						
		<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				readonly value="<c:out value="${treeCuting.areaName}"/>" readonly/></td>
				
				
			

<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.aadhaar" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				readonly value="<c:out value="${treeCuting.aadharNo}"/>" readonly/></td>
				
				
		</tr>
			
		<tr>
		
				
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterDisconnection.address" /><span class="ClsRequiredFields"></span>: </td>
						
					<td><textarea class="form-control" style="width: 300px"
					readonly id="ownerAddress" maxlength="200" rows="2" name="ownerAddress" readonly>${treeCuting.address}</textarea></td>
			
		
				

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mandap.zoneno" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				readonly value="<c:out value="${treeCuting.zoneNo}"/>" readonly/></td>

			

		</tr>
		
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Location of Tree (वृक्षाचे स्थान)" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				readonly value="<c:out value="${treeCuting.locationofTree}"/>" readonly/></td>
				
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Detailed Address Of Tree(वृक्षाचा तपशीलवार पत्ता)" /><span class="ClsRequiredFields"></span>: </td>
						
				<td><textarea class="form-control" style="width: 300px"
					readonly id="ownerAddress" maxlength="200" rows="2" name="ownerAddress" readonly>${treeCuting.treeAddress}</textarea>
					
	
		
				
		</tr>
		
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Reason For Tree Cutting (वृक्ष तोडण्याचे कारण)" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				readonly value="<c:out value="${treeCuting.resonetreecuting}"/>" readonly/></td>
			
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Number of tree cutting (वृक्ष तोडण्याची संख्या)" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="numberOfTree" maxlength="50" name="numberOfTree"
				 value="<c:out value="${treeCuting.numberoftreecuting}"/>" readonly/></td>
				 
				 </tr>
				 <tr>
				 
				 <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Ownership of the Tree (वृक्षाची मालकी) "/><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				readonly value="<c:out value="${treeCuting.ownership}"/>" readonly/></td>
			
				 
        <td>
            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Actual Required Number of Tree to be cut (वृक्ष तोडण्याची वास्तविक आवश्यक संख्या)" />:</span>
        </td>
        <td>
            <c:choose>
                <c:when test="${empty treeCuting.actualNumberoftreetrimming}">
                    <input type="number" class="form-control" id="actualNumberoftreetrimming" maxlength="5" style="width: 300px" name="actualNumberoftreetrimming" value="<c:out value="${treeCuting.actualNumberoftreetrimming}"/>" oninput="validateInput(this);" />
                </c:when>
                <c:otherwise>
                    <input type="number" class="form-control" id="actualNumberoftreetrimming" maxlength="5" style="width: 300px" name="actualNumberoftreetrimming" readonly value="<c:out value="${treeCuting.actualNumberoftreetrimming}"/>" oninput="restrictInput(this);">
                </c:otherwise>
            </c:choose>
        </td>
    </tr>

				 
			
			
					
					
	</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="container">

<tr>
			<td colspan="4"><span class="ClsLabel"
				style="font-size: 15px; font-weight: bold;"><fmt:message
						key="List of Documents (Attachment) For Tree Cutting" />:</span></td></tr>
			<c:if test="${doc[0] != 'null'}">
						
		<tr>
			<td style="width: 600px; height: 10px">
			<span class="ClsLabel"
				style="font-size: 14px;"><fmt:message
						key="Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)" />:</span></td>

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
			<div id="documentViewer" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeDocumentViewer()">&times;</span>
        <iframe id="pdfViewer" width="100%" height="400px" frameborder="0"></iframe>
    </div>
</div>
		<tr>
		
		<!--<c:if test="${doc[1] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Current Year Property Tax Paid Receipt(चालू वर्षाचा मालमत्ता कर भरलेली पावती)" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[1]}"/>"><span style="align-items: center">Download</span></a>				
	</td>
	</c:if>	-->

		  <!--<c:if test="${doc[3] != 'null'}">
		
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Building Permission (बांधकाम परवानगी)" />:</span></td>
<td style="text-align: center"> <a class="ClsButton" type="button" target="_blank" href="<c:out value="${doc[3]}"/>"><span style="align-items: center">Download</span></a>		
	</td>	

		</tr>
		</c:if>-->
		 <c:if test="${doc[2] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Photograph of tree(वृक्षाचे छायाचित्र)" />:</span></td>
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
						key="No Objection Certificate (ना हरकत प्रमाणपत्र)" />:</span></td>
<td style="text-align: center"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[3]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>	
	</td>	

		</tr></c:if>
			
		 <c:if test="${doc[5] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Approved Building Plan" />:</span></td>
<td style="text-align: center"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[5]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>	

		</tr></c:if>
		
		 <c:if test="${doc[6] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Property Tax receipt" />:</span></td>
<td style="text-align: center"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[6]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>	

		</tr></c:if>
		
		 <c:if test="${doc[7] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Property Record" />:</span></td>
<td style="text-align: center"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[7]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>	

		</tr></c:if>
		
		 <c:if test="${doc[8] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Administrative Approval" />:</span></td>
<td style="text-align: center"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[8]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>	

		</tr></c:if>
		
			 <c:if test="${doc[9] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Work Order" />:</span></td>
<td style="text-align: center"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[9]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>	

		</tr></c:if>
		
			 <c:if test="${doc[10] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Fund Sanction Letter" />:</span></td>
<td style="text-align: center"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[10]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>	

		</tr></c:if>
		
		<tr>
	    <c:if test="${doc[1] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Sanctioned plan with marking of Tree to be cut (कापल्या जाणाऱ्या वृक्षाचे चिन्हासह मंजूर आराखडा)" />:</span></td>
<td style="text-align: center"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[1]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>		
	
	</td>	

		</tr>
		</c:if>	
		<tr>
			 <c:if test="${doc[4] != 'null'}">
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Any Other Supporting document (इतर कोणतेही सहाय्यक दस्तावेज)" />:</span></td>
<td style="text-align: center"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[4]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>	

		</tr></c:if>
</tr>
</table>

		
<c:if test="${empty missingDocsList}">

<tr><td colspan="4">
  <span class="ClsLabel" style="font-size:15px;font-weight:bold;">Missing / Additional Documents Required from Citizen:</span>
</td></tr>
<tr><td colspan="4">
  <table id="missingDocsTable" width="100%" border="0" cellpadding="4" cellspacing="4">
    <tbody>
      <tr class="dyn-doc-row">
        <td style="width:40%;"><input type="text" class="form-control" name="missingDocLabel" placeholder="Document name e.g. Ownership Proof" style="width:300px;"/></td>
        <td style="width:35%;"><input type="file" class="form-control missingDocFile" name="missingDocFile" accept=".pdf" style="width:250px;"/></td>
        <td style="width:25%;">
          <button type="button" class="btn btn-sm btn-success" onclick="addMissingDocRow()">+</button>
          <button type="button" class="btn btn-sm btn-danger" onclick="deleteMissingDocRow(this)">-</button>
        </td>
      </tr>
    </tbody>
  </table>
  <input type="button" class="btn btn-primary" value="Upload Documents" onclick="uploadMissingDocs();"/>
</td></tr>
</c:if>


<c:if test="${not empty missingDocsList}">
    <table width="100%" border="0" cellpadding="4" cellspacing="4" style="margin-bottom:10px;">
        <tr>
            <td colspan="2"><strong>Already Uploaded Documents:</strong></td>
        </tr>
        <c:forEach items="${missingDocsList}" var="mdoc">
            <tr>
                <td style="width:60%;">${mdoc.label}</td>
                <td>
                    <a class="bg-button btn btn-success bd-highlight" type="button" target="_blank"
                       onclick="docDownload('${mdoc.path}');" href="javascript:void(0);">
                       <span style="color:white;">Download</span>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<script>
function addMissingDocRow() {
    var table = document.getElementById("missingDocsTable").getElementsByTagName('tbody')[0];
    var row = table.rows[0].cloneNode(true);
    row.querySelectorAll('input[type="text"], input[type="file"]').forEach(i => i.value = "");
    table.appendChild(row);
}

function deleteMissingDocRow(btn) {
    var row = btn.parentNode.parentNode, table = row.parentNode;
    if (table.rows.length > 1) table.removeChild(row);
    else alert("At least one row is required.");
}

function uploadMissingDocs() {
    var rows = document.querySelectorAll("#missingDocsTable tbody tr");
    var uid1 = document.getElementById('treecutingId').value;
    var data = new FormData();
    var labels = [], count = 0, hasInvalidFile = false;

    rows.forEach(function(row, idx) {
        var labelInput = row.querySelector('input[name="missingDocLabel"]');
        var fileInput = row.querySelector('input[name="missingDocFile"]');
        var file = fileInput && fileInput.files.length > 0 ? fileInput.files[0] : null;
        if (!file) return; // blank rows are fine - lets the user add extra rows freely

        var ext = file.name.split('.').pop().toLowerCase();
        if (ext !== 'pdf') { alert("Please attach a PDF file for: " + (labelInput.value || ("Document " + (idx+1)))); hasInvalidFile = true; return; }
        if (file.size >= 2000000) { alert("File for '" + (labelInput.value || ("Document " + (idx+1))) + "' is greater than 2MB."); hasInvalidFile = true; return; }

        count++;
        data.append('idProofMissing' + count, file);
        labels.push(labelInput.value || ("Document " + count));
    });

    if (hasInvalidFile) return;
    if (count === 0) { alert("Please attach at least one document before uploading."); return; }

    data.append('missingDocCount', count);
    data.append('missingDocLabels', labels.join('|'));

    $.ajax({
        url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadsmanagetreecutting.do?appType=6&UID=" + uid1,
        type: 'POST', data: data, cache: false, dataType: 'json', processData: false, contentType: false
    }).done(function (resp) {
        if (resp.status == true || resp.status == 'true') { alert(count + " document(s) uploaded successfully"); window.location.reload(); }
        else { alert("Document upload failed!!"); }
    }).fail(function(jqXHR, textStatus, errorThrown) {
        console.error("uploadMissingDocs failed:", jqXHR.status, jqXHR.responseText, textStatus, errorThrown);
        alert("Upload request failed (HTTP " + jqXHR.status + "). Check that appType=6 is handled on the server. See console for details.");
    });
}
function buildDocUrl(filesPath) {
    var encodedFilePath = encodeURIComponent(filesPath);
    var encodedFilesPath = btoa(encodedFilePath);
    return '<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodeURIComponent(encodedFilesPath);
}
function uploadSingleTreeImage(fileInput) {
    var file = fileInput.files[0];
    if (!file) return;

    var row = fileInput.closest('tr');
    var previewDiv = row.querySelector('.treeImagePreview');
    var hiddenInput = row.querySelector('.treeImagePathHidden');
    var rowIndex = Array.prototype.indexOf.call(
        document.querySelectorAll('#tree_details tbody tr'), row
    );

    var ext = file.name.split('.').pop().toLowerCase();
    if (['jpg','jpeg','png','gif','webp'].indexOf(ext) === -1) {
        alert("Please select a valid image file (jpg, jpeg, png, gif, webp).");
        fileInput.value = "";
        return;
    }
    if (file.size >= 5000000) {
        alert("Image size must be less than 5MB.");
        fileInput.value = "";
        return;
    }

    var uid1 = document.getElementById('treecutingId').value;

    var reader = new FileReader();
    reader.onload = function(e) {
        var dataUrl = e.target.result; // "data:image/jpeg;base64,...."
        previewDiv.innerHTML = '<img src="' + dataUrl + '" style="max-width:80px;max-height:80px;border:1px solid #ccc;border-radius:4px;">';

        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadTreeImages.do",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                UID: uid1,
                rowIndex: rowIndex,
                fileName: file.name,
                data: dataUrl
            }),
            dataType: 'json'
        }).done(function (resp) {
            console.log("uploadSingleTreeImage response:", resp);
            if ((resp.status === true || resp.status === 'true') && resp.path) {
                hiddenInput.value = resp.path;
                console.log("Row " + rowIndex + " tree image path set to: " + hiddenInput.value);
            } else {
                alert("Tree photo upload failed. " + (resp.message || ""));
                previewDiv.innerHTML = "";
                hiddenInput.value = "";
                fileInput.value = "";
            }
        }).fail(function (jqXHR, textStatus, errorThrown) {
            console.error("uploadSingleTreeImage failed:", jqXHR.status, jqXHR.responseText, textStatus, errorThrown);
            alert("Tree photo upload failed (HTTP " + jqXHR.status + "). Please try again.");
            previewDiv.innerHTML = "";
            hiddenInput.value = "";
            fileInput.value = "";
        });
    };
    reader.readAsDataURL(file);
}


$(document).ready(function() {
    $('.treeImageThumb').each(function() {
        var path = $(this).data('path');
        if (path) {
            $(this).attr('src', buildDocUrl(path));
        }
    });

    $(document).on('click', '.treeImageViewLink', function() {
        var path = $(this).data('path');
        if (path) {
            docDownload(path);
        }
    });
});
</script>

		
            <table width="100%" border="0" cellpadding="2" cellspacing="2" class="table" id="">
			 
	<tr>	
<td colspan="4"><span class="ClsLabel"
				style="font-size: 18px; font-weight: bold;"><fmt:message
						key="Tree Inspection Details" />:</span></td></tr>
  <div class="container mt-5">
        <div class="row print-container">
            <table width="100%" border="0" cellpadding="2" cellspacing="2" class="table" id="tree_details">
                <thead>
                    <tr>
                        <th><strong>Sr.No.</strong></th>
                        <th>Tree Name</th>
                        <th>Tree Type</th>
                                                <th>Girth Of Tree(Inches)</th>
                        
                        <th>Age Of Tree(Years)</th>
                        <th>Remark</th>
                            <th>Tree Photo</th>
                            
                            <c:choose>
    <c:when test="${empty requestScope.treestype}">
        <th>Action</th>
    </c:when>
    <c:otherwise>
        <c:if test="${not empty nocInspectionDetais.treeImage}">
        </c:if>
    </c:otherwise>
</c:choose>

                                      
                    </tr>
                </thead>
                <c:choose>
                <c:when test="${ empty requestScope.treestype}">
                
                <tbody>
                    <tr>
                        <td class="sr-no">1</td>
<td>
<select style="width: 150px; height: 30px; background-color: white;border-radius: 3px;border-color: grey" name="nameOfTree" required>
                                <option value="" selected><--select--></option>                    
                                <option value="Mango (आंबा)">Mango (आंबा)</option>
                                <option value="Pipal (पिंपळ)">Pipal (पिंपळ)               </option>
                                                                <option value="Banyan (वड)">Banyan (वड)                  </option>
                                                                <option value="Shevga (शेवगा)">Shevga (शेवगा)                </option>
                                                                <option value="Mohgani (मोहागणी)">Mohgani (मोहागणी)        </option>
                                                                <option value="Teak (साग)">Teak (साग)                   </option>
                                                                <option value="Cessia (केशिया)">Cessia (केशिया)</option>
                                                                <option value="Peltrafarm (पेल्ट्राफार्म)">Peltrafarm (पेल्ट्राफार्म)        </option>
                                                                <option value="Jamun (जांभूळ)">Jamun (जांभूळ)              </option>
                                                                <option value="A.Tamarind (चिचबिलाई)">A.Tamarind (चिचबिलाई)   </option>
                                                                <option value="Sisam (सिसम)">Sisam (सिसम)                    </option>
                                                                <option value="Tamarind (चिंच)">Tamarind (चिंच)                 </option>
                                                                <option value="Bor (बोर)"> Bor (बोर)                       </option>
                                                                <option value="Subabhul (सुबाभूळ)">Subabhul (सुबाभूळ)         </option>
                                                                <option value="Babul (बाभूळ)">Babul (बाभूळ)                  </option>
                                                                <option value="Anjan (अंजन)">Anjan (अंजन)                     </option>
                                                                <option value="Bahuniya (आपटा)"> Bahuniya (आपटा)               </option>
                                                                <option value="Neem (कडूनिम)">Neem (कडूनिम)               </option>
                                                                <option value="Oak (अशोका)">Oak (अशोका)</option>
                                                                <option value="Sisoo (सिसू)">Sisoo (सिसू)</option>
                                                                <option value="Saptparni (सप्तपर्णी)">Saptparni (सप्तपर्णी)</option>
                                                                <option value="Bakul (बकुळ)">Bakul (बकुळ)</option>
                                                                <option value="Chichva (चिचवा)">Chichva (चिचवा) </option>
                                                                <option value="Palm (पाम)">Palm (पाम)</option>
                                                                <option value="Maharukh (महारुख)">Maharukh (महारुख)</option>
                                                                <option value="Katsavr (काटसावर)">Katsavr (काटसावर)</option>
                                                                <option value="Shemal (शेमल)">Shemal (शेमल) </option>
                                                                <option value="Kadanmba (कदंब)">Kadanmba (कदंब)</option>
                                                                <option value="Bahuniyaa (कांचन)">Bahuniyaa (कांचन) </option>
                                                                <option value="Gulmohar (गुलमोहर)">Gulmohar (गुलमोहर) </option>
                                                                <option value="Almond (बदाम)">Almond (बदाम)</option>
                                                                <option value="Raintree (रेनट्री)">Raintree (रेनट्री) </option>
                                                                <option value="Karnji (करंज)">Karnji (करंज)</option>
                                                                <option value="Umbar (उंबर)">Umbar (उंबर)</option>
                                                                <option value="Beal (बेल)">Beal (बेल)</option>
                                                                <option value="Chafa (चाफा)">Chafa (चाफा)</option>
                    
                            </select>
                            
<!-- <input type="text" name="nameOfTree" style="width: 150px; height: 30px; background-color: white;border-color: grey" value="${nocInspectionDetais.nameOfTree}" required>-->
</td>
          
    <td>
    <select id="typeOfTree" style="width: 150px; height: 30px; background-color: white; border-radius: 3px; border-color: grey" name="typeOfTree" onchange="validateAge(this.parentNode.parentNode)" required>
        <option value="" selected>--select--</option>
        <option value="Heritage">Heritage</option>
        <option value="Non-heritage">Non-heritage</option>
    </select>
</td>
<td><input id="girthInput" type="number" name="girthOfTree" step="any" oninput="calcAge(this.parentNode.parentNode)" style="width: 100px; height: 30px; border-radius: 3px;background-color: white;border-color: grey"" value="${nocInspectionDetais.girthOfTree}" required></td>

                       <!--  <td><input type="number" class="" name="girthOfTree"  pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==4) return false;"  style="width: 100px; height: 30px; border-radius: 3px;background-color: white;border-color: grey"" value="${nocInspectionDetais.girthOfTree}" required></td>-->

<td>
       <input id="ageInput" type="number" style="width: 100px; height: 30px; background-color: white; border: 1px solid grey; border-radius: 3px;" name="ageOfTree" value="" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==3) return false;"  oninput="validateAge(this.parentNode.parentNode)" required readonly>
       
           <div id="ageErrorMessage" class="ageErrorMessage" style="color: red;"></div>
</td>

      
              
                        <td><input type="text" class="" name="remarks"  style="width: 180px; height: 30px; background-color: white;border-color: grey;border-radius: 3px;" value="${nocInspectionDetais.remark}" required></td>
                     <td>
    <input type="file" class="form-control treeImageInput" name="treeImage" accept="image/*" style="width: 160px;" onchange="uploadSingleTreeImage(this);">
    <input type="hidden" class="treeImagePathHidden" name="treeImagePath" value="">
    <div class="treeImagePreview" style="margin-top:5px;"></div>
</td>
                        <td>
                            <button type="button" class="btn btn-sm btn-success" onclick="addRow()">+</button>
                            <button type="button" class="btn btn-sm btn-danger" onclick="deleteRow(this)">-</button>
                        </td>
                    </tr>
                </tbody>
                </c:when>
                
                <c:otherwise>
               <c:forEach items="${requestScope.treestype}" var="nocInspectionDetais" varStatus="loop">
    <tbody>
        <tr>
            <td class="sr-no">${loop.index + 1}</td>
<td><input type="text" name="nameOfTree" style="width: 150px; height: 30px; background-color: white;border-color: grey" value="${nocInspectionDetais.nameOfTree}" required></td>
                        <td>
                          
                            
                            <input type="text" name="typeOfTree" style="width: 150px; height: 30px; background-color: white;border-color: grey" value="${nocInspectionDetais.typeOfTree}" required>
                            
                        </td>
                        <td><input id="girthInput" type="number" name="girthOfTree" step="any" oninput="calcAge(this.parentNode.parentNode)" style="width: 100px; height: 30px; border-radius: 3px;background-color: white;border-color: grey"" value="${nocInspectionDetais.girthOfTree}" required></td>
                        
                                                <!-- <td><input type="number" class=""  name="girthOfTree"  style="width: 100px; height: 30px; border-radius: 3px;background-color: white;border-color: grey"" value="${nocInspectionDetais.girthOfTree}" required></td>-->
                        
                        <td><input type="number" id="ageInput" style="width: 100px; height: 30px; background-color: white;border-color: grey;border-radius: 3px;" name="ageOfTree" value="${nocInspectionDetais.ageOfTree}" required readonly></td>
                        <td><input type="text" class="" name="remarks"  style="width: 180px; height: 30px; background-color: white;border-color: grey;border-radius: 3px;" value="${nocInspectionDetais.remarks}" required></td>
                        <td>
    <c:choose>
  <c:when test="${not empty nocInspectionDetais.treeImage}">
    <div>
        <img src="" class="treeImageThumb" data-path="${nocInspectionDetais.treeImage}"
             style="max-width:80px;max-height:80px;border:1px solid #ccc;border-radius:4px;display:block;margin-bottom:4px;">
        <a class="bg-button btn btn-success bd-highlight treeImageViewLink" type="button" target="_blank"
           data-path="${nocInspectionDetais.treeImage}" href="javascript:void(0);">
           <span style="color:white;">View</span>
        </a>
    </div>
    <input type="hidden" name="treeImagePath" value="${nocInspectionDetais.treeImage}">
</c:when>
      <c:otherwise>
    <input type="file" class="form-control treeImageInput" name="treeImage" accept="image/*" style="width: 160px;" onchange="uploadSingleTreeImage(this);">
    <input type="hidden" class="treeImagePathHidden" name="treeImagePath" value="">
    <div class="treeImagePreview" style="margin-top:5px;"></div>
</c:otherwise>
    </c:choose>
</td>

                    </tr>
                </tbody>
                
                
                </c:forEach>
                
                </c:otherwise>
                                </c:choose>
                                
                
            </table>
            
        </div>
    
        
    </div>
    </table>
<table width="100%" cellpadding="5" cellspacing="0" class="container table-bordered">    
    
 			 
		

 
   			 
		

                       <c:if test="${not empty requestScope.treestype}">
<tr>

    <td colspan="2">

        <label>Total Heritage :</label>

        <input type="number"
        name="totalHeritage" 
               id="heritageInput"
               readonly
               value="${requestScope.treeType_heritage}"
               style="width:100px;"/>

        &nbsp;&nbsp;&nbsp;

        <label>Total Non-Heritage :</label>

        <input type="number"
               id="nonHeritageInput"
               name="totalNonHeritage"
               readonly
               value="${requestScope.treeType_Non_heritage}"
               style="width:100px;"/>

    </td>
          <c:if test="${ not empty requestScope.treestype}">
 
    <td colspan="2" style="text-align: center;">
                                            <button type="button" class="btn btn-primary" style="background-color: darkgreen;" onclick="printPDF('${treeCuting.treecutingId}', 'treeCuttingDetailsReport.do');">Generate PDF</button>
                                            <br>

    </td>
        </c:if>
    

</tr>
</c:if>
    
    

    
      <c:if test="${(requestScope.rtiApplication.workFlowStatus == 9 || requestScope.rtiApplication.workFlowStatus == 2 || requestScope.rtiApplication.workFlowStatus == 3 || requestScope.rtiApplication.workFlowStatus == 1 || requestScope.rtiApplication.workFlowStatus == 11) && requestScope.rtiApplication.finalStatus == 'L2' && requestScope.forLogin == 'L2' && not empty treeCuting.pachanamaletter && not empty requestScope.treestype && not empty treeCuting.treeRemark }">
    <tr>
        <td colspan="2">
            <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.treecutting.feesgst" />:</span>
        </td>
        <td colspan="2">
                <div style="display:flex; justify-content:center;">
        
            <c:choose>
                <c:when test="${empty treeCuting.totalFeesWithGST}">
                <input type="number"
       class="form-control"
       id="feesApplicable"
       name="fees"
       style="width:200px;"
         maxlength="8"
       min="1"
       max="99999999"
       step="1"
       onkeydown="return blockInvalidKeys(event);"
       oninput="validateFees(this);"
       value="<c:out value='${treeCuting.totalFeesWithGST}'/>">
       
                   <!--  <input type="number" class="form-control" id="feesApplicable" maxlength="5" style="width: 300px" name="fees" value="<c:out value="${treeCuting.totalFeesWithGST}"/>" oninput="validateInput(this);" />-->
                </c:when>
                <c:otherwise>
                <input type="number"
       class="form-control"
       maxlength="5" style="width: 200px"
       id="feesApplicable"
       name="fees"
       readonly
       value="<c:out value='${treeCuting.totalFeesWithGST}'/>">
       
                  <!--   <input type="number" class="form-control" id="feesApplicable" maxlength="5" style="width: 300px" name="fees" readonly value="<c:out value="${treeCuting.totalFeesWithGST}"/>" oninput="restrictInput(this);">-->
                </c:otherwise>
            </c:choose>
            </div>
        </td>
    </tr>
    </c:if>
    
  


  <tr>

    <td width="20%">
        <span class="ClsLabel" style="font-size:14px;">
            <fmt:message key="Panchanama Report"/>
        </span>
    </td>

    <td width="30%">

        <c:choose>

            <c:when test="${empty treeCuting.pachanamaletter}">
                <input type="file"
                       id="doc4"
                       name="idProof"
                       class="imagefile"/>
            </c:when>

            <c:otherwise>

                <a class="btn btn-success"
                   target="_blank"
                   style="color:white;"
                   onclick="docDownload('${treeCuting.pachanamaletter}')">
                    Download
                </a>

            </c:otherwise>

        </c:choose>

    </td>


    <td width="20%">
        <span class="ClsLabel" style="font-size:14px;">
            <fmt:message key="Tree Inspection Remarks"/>
        </span>
    </td>

    <td width="30%">
        <textarea
            id="treeRemark"
            name="treeRemark"
            class="form-control"
            rows="2"
            maxlength="200">${treeCuting.treeRemark}</textarea>
    </td>

</tr>



           
           

<tr>


   <c:if test="${requestScope.rtiApplication.workFlowStatus == 2 || requestScope.rtiApplication.workFlowStatus == 1}">

    <td style="width:243px;">
        <span class="ClsLabel" style="font-size: 14px;"><fmt:message key="Demand Receipt Letter" />:</span></td>
        <c:choose>
            <c:when test="${empty treeCuting.demandletter && requestScope.rtiApplication.workFlowStatus == 2 && requestScope.forLogin == 'L2'}">
                <td style="width: 922px;">
                
                    
                <a class="bg-button btn btn-success bd-highlight generateaction" id="genCerBtn" onclick="downloads1('${treeCuting.rti_ref_id}', 'treeCuttingDemandCertificateReport.do');" type="button" target="_blank">
                    <span class="download" style="display: flex;color: white;align-items: center;width: 142px;">Generate Demand</span>
                </a>
                <a class="bg-button btn btn-success bd-highlight action" id="dsc" type="button" target="_blank" onclick="download1(${treeCuting.rti_ref_id});return false;">
                    <span class="download" style="align-items: center;color: white;">Apply DSC</span>
                </a>
                                   &nbsp;  &nbsp;  &nbsp;  &nbsp; <input type="file" name="idProof" id="doc1" class="imagefile" style="width: 168px;">
                
               
            &nbsp;  &nbsp;  &nbsp;  &nbsp;   <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="upload1"  type="button" target="_blank" onclick="javascript:uploadPoliceNoc(this);"><span
							class="download" style="align-items: center">Upload</span></a>
                </td>
            </c:when>
            <c:when test="${not empty treeCuting.demandletter}">
                <td>
   <a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${treeCuting.demandletter}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>

                          
                </td>
            </c:when>
        </c:choose>
</c:if>

     
  
     <td style=""><span class="ClsLabel" style="font-size: 14px">
					Current Status:</span></td>
			<td style="height: 30px"><span class="ClsLabel"
				style="font-size: 14px;color:forestgreen;"><c:if
						test="${requestScope.rtiApplication.workFlowStatus==0}">
						<b>Citizen Form Submitted. </b>
					</c:if> 
					<c:if test="${requestScope.rtiApplication.workFlowStatus==9 && requestScope.rtiApplication.finalStatus != 'L2'}">

						<b>At L2 level</b>
					</c:if> 
					<c:if test="${requestScope.rtiApplication.workFlowStatus==9 && requestScope.rtiApplication.finalStatus == 'L2'}">

						<b>Reverted to L2 level</b>
					</c:if> 
					<c:if test="${requestScope.rtiApplication.workFlowStatus==10}">
						<b>At L3 level</b>
					</c:if> 
					<c:if test="${requestScope.rtiApplication.workFlowStatus==11}">
						<b>At L4 level</b>
					</c:if> 
					<c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
						<b>Citizen Payment Pending. </b>
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
						<b>Citizen Payment Completed</b>
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						<b>Completed and File Uploaded for Citizen</b>
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						<b>Rejected</b>
					</c:if></span>
					</td>
					  
            </tr>
    
					<tr>
					
         <c:if test="${(requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus==1) }">
                  					              <td style=""><span class="ClsLabel" style="font-size:14px">Certificate Upload: </span> </td>
                  					              <!--  <c:if test="${requestScope.rtiApplication.workFlowStatus==2 &&  requestScope.forLogin == 'L2' && empty requestScope.rtiApplication.pdfFilesSavedPath}">
            <td colspan="6" align="center">
                <a class="bg-button btn btn-success bd-highlight generateaction" id="genCerBtn" style="color: white" onclick="downloads('${treeCuting.rti_ref_id}', 'treeCuttingCertificateReport.do');" type="button" target="_blank">
                    <span class="download" style="display: flex; align-items: center;">Generate Certificate</span>
                </a>
                <a class="bg-button btn btn-success bd-highlight action" style="color: white" id="dsc" type="button" target="_blank" onclick="download1(${treeCuting.rti_ref_id});return false;">
                    <span class="download" style="align-items: center">Apply DSC</span>
                </a>
            </td>
            
    </c:if>-->
                  					              <c:if test="${ empty requestScope.rtiApplication.pdfFilesSavedPath &&  requestScope.forLogin == 'L2'}">
                  					               <td><a class="bg-button btn btn-success bd-highlight generateaction" id="genCerBtn" style="color: white" onclick="downloads('${treeCuting.rti_ref_id}', 'treeCuttingCertificateReport.do');" type="button" target="_blank">
                    <span class="download" style="display: flex; align-items: center;">Generate Certificate</span>
                </a>
                <a class="bg-button btn btn-success bd-highlight action" style="color: white" id="dsc" type="button" target="_blank" onclick="download1(${treeCuting.rti_ref_id});return false;">
                    <span class="download" style="align-items: center">Apply DSC</span>
                </a>
                </td>
                <td>
               <input type="file" class="imagefile" name="idProof"
				id="idProof" style="width: 220px" />
							</td>
				
				</c:if>
			<td>
			<c:if
					test="${ empty requestScope.rtiApplication.pdfFilesSavedPath && requestScope.forLogin != 'L1'}">

					<a class="bg-button btn btn-primary bd-highlight"
						style="color: white" id="birthupload" type="button"
						target="_blank"
						onclick="gardenUpload(${treeCuting.rti_ref_id}); return false;"><span
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
		
                </c:if>
      </tr>
     

          <c:if test="${requestScope.rtiApplication.workFlowStatus != 5}">
     
<tr>

 <c:if test="${(empty treeCuting.pachanamaletter ||  empty requestScope.treestype ||  empty treeCuting.treeRemark) }">

<td colspan="4" align="center"><input type="button"
				class="btn btn-primary"
				style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745;"
				id="savefees" name="savefees"
				value="<fmt:message key="common.button.save"/>"
				onclick="javascript:saveFees(this.form);">
</td>
</c:if>


 <c:if test="${(requestScope.rtiApplication.workFlowStatus==9 && requestScope.rtiApplication.finalStatus == 'L2' &&  requestScope.forLogin == 'L2' && empty treeCuting.totalFeesWithGST) }">

<td colspan="4" align="center"><input type="button"
				class="btn btn-primary"
				style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745;"
				id="savefeesonly" name="savefeesonly"
				value="<fmt:message key="common.button.save"/>"
				onclick="javascript:saveFeesOnly(this.form);">
</td>
</c:if>
</tr>
</c:if>

</table>

      <c:if test="${requestScope.forLogin eq 'L2'}">
  
     <table width="100%" border="1" cellpadding="2" cellspacing="2" class="container fire-docs-table">

    <!-- 🔹 SCRUTINY REPORT -->
    

        <c:choose>
            <c:when test="${empty treeCuting.plantationletter 
                   or treeCuting.plantationletter == 'null'
                   or fn:trim(treeCuting.plantationletter) == ''}">
            
                <c:if test="${requestScope.rtiApplication.workFlowStatus == 9 && requestScope.rtiApplication.finalStatus == 'L2'}">
                    <tr>
        <td>
            <span style="font-size: 14px">
                <fmt:message key="Plantation Letter" />:
            </span>
        </td>
        <td>

<div class="upload-container">

    <button type="button"
            class="btn btn-info"
            onclick="enableUpload('plantationdoc','plantationUploadBtn','plantationLabel')">
        Enable
    </button>

    <label id="plantationLabel"
           for="plantationdoc"
           class="btn btn-secondary disabledLabel">
        Select PDF
    </label>

    <input type="file"
           id="plantationdoc"
           accept="application/pdf"
           disabled
           style="display:none;"
           onchange="showFileName(this,'plantationFileName')">

    <span id="plantationFileName">No file selected</span>

    <button type="button"
            id="plantationUploadBtn"
            class="btn btn-primary"
            disabled
            onclick="uploadTreeDocs('plantationdoc',1,'Plantation Letter')">
        Upload
    </button>

</div>

</td>
</tr>
                </c:if>
            </c:when>

            <c:otherwise>
            <tr>
        <td>
            <span style="font-size: 14px">
                <fmt:message key="Plantation Letter" />:
            </span>
        </td>
                <td style="text-align:center">
                    <a class="btn btn-success"
                       style="color:white"
                       onclick="docDownload('${treeCuting.plantationletter}')">
                        Download
                    </a>
                    
                     <c:if test="${requestScope.rtiApplication.workFlowStatus != 1 and requestScope.rtiApplication.workFlowStatus != 5}">
                    <br/><br/>
                    <input type="file" id="plantationdocReupload" accept="application/pdf" style="width:220px"/>
                    <a class="btn btn-warning" style="color:white"
                       onclick="uploadTreeDocs('plantationdocReupload',1,'Plantation Letter')">Re-upload</a>
                </c:if>
                </td>
                </tr>
            </c:otherwise>
        </c:choose>


    <!-- 🔹 INSPECTION REPORT -->
 

        <c:choose>
                        <c:when test="${empty treeCuting.siteVisit 
                   or treeCuting.siteVisit == 'null'
                   or fn:trim(treeCuting.siteVisit) == ''}">
                 <c:if test="${requestScope.rtiApplication.workFlowStatus == 9 && requestScope.rtiApplication.finalStatus == 'L2'}">
                     <tr>
        <td>
            <span style="font-size: 14px">
                <fmt:message key="Site Visit Report" />:
            </span>
        </td>
         <td>

<div class="upload-container">

    <button type="button"
            class="btn btn-info"
            onclick="enableUpload('siteVisitdoc','siteVisitUploadBtn','siteVisitLabel')">
        Enable
    </button>

    <label id="siteVisitLabel"
           for="siteVisitdoc"
           class="btn btn-secondary disabledLabel">
        Select PDF
    </label>

    <input type="file"
           id="siteVisitdoc"
           accept="application/pdf"
           disabled
           style="display:none;"
           onchange="showFileName(this,'siteVisitFileName')">

    <span id="siteVisitFileName">No file selected</span>

    <button type="button"
            id="siteVisitUploadBtn"
            class="btn btn-primary"
            disabled
            onclick="uploadTreeDocs('siteVisitdoc',2,'Site Visit Report')">
        Upload
    </button>

</div>

</td>
</tr>
                </c:if>
            </c:when>

            <c:otherwise>
               <tr>
        <td>
            <span style="font-size: 14px">
                <fmt:message key="Site Visit Report" />:
            </span>
        </td>
                <td style="text-align:center">
                    <a class="btn btn-success"
                       style="color:white"
                       onclick="docDownload('${treeCuting.siteVisit}')">
                        Download
                    </a>
                       <c:if test="${requestScope.rtiApplication.workFlowStatus != 1 and requestScope.rtiApplication.workFlowStatus != 5}">
                    <br/><br/>
                    <input type="file" id="siteVisitdocReupload" accept="application/pdf" style="width:220px"/>
                    <a class="btn btn-warning" style="color:white"
                       onclick="uploadTreeDocs('siteVisitdocReupload',2,'Site Visit Report')">Re-upload</a>
                </c:if>
                </td>
                </tr>
            </c:otherwise>
        </c:choose>


    <!-- 🔹 CFO NOC -->
  

        <c:choose>
             <c:when test="${empty treeCuting.hearingNotice 
                   or treeCuting.hearingNotice == 'null'
                   or fn:trim(treeCuting.hearingNotice) == ''}">
 <c:if test="${requestScope.rtiApplication.workFlowStatus == 9 && requestScope.rtiApplication.finalStatus == 'L2'}">
                     <tr>
        <td>
            <span style="font-size: 14px">
                <fmt:message key="Hearing Notice" />:
            </span>
        </td>
         <td>

<div class="upload-container">

    <button type="button"
            class="btn btn-info"
            onclick="enableUpload('hearingNoticedoc','hearingUploadBtn','hearingLabel')">
        Enable
    </button>

    <label id="hearingLabel"
           for="hearingNoticedoc"
           class="btn btn-secondary disabledLabel">
        Select PDF
    </label>

    <input type="file"
           id="hearingNoticedoc"
           accept="application/pdf"
           disabled
           style="display:none;"
           onchange="showFileName(this,'hearingFileName')">

    <span id="hearingFileName">No file selected</span>

    <button type="button"
            id="hearingUploadBtn"
            class="btn btn-primary"
            disabled
            onclick="uploadTreeDocs('hearingNoticedoc',3,'Hearing Notice')">
        Upload
    </button>

</div>

</td>
</tr>
                </c:if>
            </c:when>

            <c:otherwise>
              <tr>
        <td>
            <span style="font-size: 14px">
                <fmt:message key="Hearing Notice" />:
            </span>
        </td>
                <td style="text-align:center">
                    <a class="btn btn-success"
                       style="color:white"
                       onclick="docDownload('${treeCuting.hearingNotice}')">
                        Download
                    </a>
                      <c:if test="${requestScope.rtiApplication.workFlowStatus != 1 and requestScope.rtiApplication.workFlowStatus != 5}">
                    <br/><br/>
                    <input type="file" id="hearingNoticedocReupload" accept="application/pdf" style="width:220px"/>
                    <a class="btn btn-warning" style="color:white"
                       onclick="uploadTreeDocs('hearingNoticedocReupload',3,'Hearing Notice')">Re-upload</a>
                </c:if>
                </td>
                </tr>
            </c:otherwise>
        </c:choose>
        <!-- 🔹 FIRE NOC -->

            
    

        <c:choose>
             <c:when test="${empty treeCuting.publicNotice 
                   or treeCuting.publicNotice == 'null'
                   or fn:trim(treeCuting.publicNotice) == ''}">
 <c:if test="${requestScope.rtiApplication.workFlowStatus == 9 && requestScope.rtiApplication.finalStatus == 'L2'}">
                    <tr>
        <td>
            <span style="font-size: 14px">
                <fmt:message key="Public Notice" />:
            </span>
        </td>
         <td>

<div class="upload-container">

    <button type="button"
            class="btn btn-info"
            onclick="enableUpload('publicNoticedoc','publicUploadBtn','publicLabel')">
        Enable
    </button>

    <label id="publicLabel"
           for="publicNoticedoc"
           class="btn btn-secondary disabledLabel">
        Select PDF
    </label>

    <input type="file"
           id="publicNoticedoc"
           accept="application/pdf"
           disabled
           style="display:none;"
           onchange="showFileName(this,'publicFileName')">

    <span id="publicFileName">No file selected</span>

    <button type="button"
            id="publicUploadBtn"
            class="btn btn-primary"
            disabled
            onclick="uploadDoc('publicNoticedoc',1,'Public Notice')">
        Upload
    </button>

</div>

</td>
</tr>
                    </c:if>
            </c:when>

            <c:otherwise>
              <tr>
        <td>
            <span style="font-size: 14px">
                <fmt:message key="Public Notice" />:
            </span>
        </td>
                <td style="text-align:center">
                    <a class="btn btn-success"
                       style="color:white"
                       onclick="docDownload('${treeCuting.publicNotice}')">
                        Download
                    </a>
                      <c:if test="${requestScope.rtiApplication.workFlowStatus != 1 and requestScope.rtiApplication.workFlowStatus != 5}">
                    <br/><br/>
                    <input type="file" id="publicNoticedocReupload" accept="application/pdf" style="width:220px"/>
                    <a class="btn btn-warning" style="color:white"
                       onclick="uploadDoc('publicNoticedocReupload',1,'Public Notice')">Re-upload</a>
                </c:if>
                </td>
                </tr>
            </c:otherwise>
        </c:choose>
     

        <c:choose>
             <c:when test="${empty treeCuting.advertisementNotice 
                   or treeCuting.advertisementNotice == 'null'
                   or fn:trim(treeCuting.advertisementNotice) == ''}">
 <c:if test="${requestScope.rtiApplication.workFlowStatus == 9 && requestScope.rtiApplication.finalStatus == 'L2'}">
                               <tr>
        <td>
            <span style="font-size: 14px">
                <fmt:message key="Advertisement Notice" />:
            </span>
        </td>
         <td>

<div class="upload-container">

    <button type="button"
            class="btn btn-info"
            onclick="enableUpload('advertisementNoticedoc','advertisementUploadBtn','advertisementLabel')">
        Enable
    </button>

    <label id="advertisementLabel"
           for="advertisementNoticedoc"
           class="btn btn-secondary disabledLabel">
        Select PDF
    </label>

    <input type="file"
           id="advertisementNoticedoc"
           accept="application/pdf"
           disabled
           style="display:none;"
           onchange="showFileName(this,'advertisementFileName')">

    <span id="advertisementFileName">No file selected</span>

    <button type="button"
            id="advertisementUploadBtn"
            class="btn btn-primary"
            disabled
            onclick="uploadDoc('advertisementNoticedoc',2,'Advertisement Notice')">
        Upload
    </button>

</div>

</td>
</tr>
                    </c:if>
            </c:when>

            <c:otherwise>
             <tr>
        <td>
            <span style="font-size: 14px">
                <fmt:message key="Advertisement Notice" />:
            </span>
        </td>
                <td style="text-align:center">
                    <a class="btn btn-success"
                       style="color:white"
                       onclick="docDownload('${treeCuting.advertisementNotice}')">
                        Download
                    </a>
                     <c:if test="${requestScope.rtiApplication.workFlowStatus != 1 and requestScope.rtiApplication.workFlowStatus != 5}">
                    <br/><br/>
                    <input type="file" id="advertisementNoticedocReupload" accept="application/pdf" style="width:220px"/>
                    <a class="btn btn-warning" style="color:white"
                       onclick="uploadDoc('advertisementNoticedocReupload',2,'Advertisement Notice')">Re-upload</a>
                </c:if>
                </td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
    </c:if>
    
  

 <input type="hidden" class="ClsTextbox" id="treecutingId" style="width:180px"  name="treecutingId" value="<c:out value="${treeCuting.treecutingId}"/>" />
    <input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="" />
	<input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${treeCuting.rti_ref_id}" />

    <input type="hidden" id="responseData" name="responseData" value="" />
    
     <%@include file="/pages/workflow/gardenTaskInclude.jsp"%>
     
     


<script>
$('.printMe').on('click', function () {
	 window.print();
	 });

function validateAge(row) {
    var typeOfTreeEl = row.querySelector('select[name="typeOfTree"], input[name="typeOfTree"]');
    var ageField = row.querySelector('input[name="ageOfTree"]');
    var errorMessageCell = row.querySelector('.ageErrorMessage');
    if (!typeOfTreeEl || !ageField || !errorMessageCell) { return; }

    var typeOfTree = typeOfTreeEl.value;
    var age = parseFloat(ageField.value);

    errorMessageCell.textContent = '';
    if (typeOfTree === 'Heritage' && age < 50) {
        errorMessageCell.textContent = "For Heritage trees, age should be greater than 50.";
    } else if (typeOfTree === 'Non-heritage' && age >= 50) {
        errorMessageCell.textContent = "For Non-heritage trees, age should be less than 50.";
    }
}

function calcAge(row) {
    var girthField = row.querySelector('input[name="girthOfTree"]');
    var ageField = row.querySelector('input[name="ageOfTree"]');
    if (!girthField || !ageField) { return; }

    var girth = parseFloat(girthField.value);
    ageField.value = (isNaN(girth) || girth <= 0) ? "" : Math.round((girth * 3.14 * 3.03) * 100) / 100;
    validateAge(row);
}

</script>




     
<script>
function toggleUploadDetails(value) {
    var uploadDetails = document.getElementById("uploadDetails");
    var yesRadio = document.getElementById("Yes");

    if (value === 'Yes') {
        uploadDetails.style.display = 'table-row'; // Display the upload details section
    } else {
        uploadDetails.style.display = 'none'; // Hide the upload details section
    }
}

function toggleUploadRejectDetails(value) {
    var rejectionUploadDetails = document.getElementById("rejectionUploadDetails");
    var yesRadio = document.getElementById("Yes");

    if (value === 'Yes') {
    	rejectionUploadDetails.style.display = 'table-row1'; // Display the upload details section
    } else {
    	rejectionUploadDetails.style.display = 'none'; // Hide the upload details section
    }
}

</script>



<script type="text/javascript">
function saveFees() {
    var feeId = $('#feesApplicable');
    var fees = $("#feesApplicable").val();
    var totalNonHeritage = $("#totalNonHeritage").val();
    var totalHeritage = $("#totalHeritage").val();
    var ownership = $("input[name='ownership']:checked").val();
    //var approvalStatus = $('input[name="saveApproval"]:checked').val();
        var treeRemark = $("#treeRemark").val();
var plantupload=false;
    var approvalStatusElement = $('input[name="saveApproval"]:checked');
    var approvalStatus = approvalStatusElement.length > 0 ? approvalStatusElement.val() : '';

    
    var treeTypeList = '${requestScope.treestype}';
    var workflowStatus = '${requestScope.rtiApplication.workFlowStatus}';

    var status = false;
    var appType;

    var table = document.getElementById("tree_details");
    var noOftrees = parseInt($("#actualNumberoftreetrimming").val());


    if (treeTypeList === '') {
        // Checking if number of trees matches the table rows
        if ((table && table.rows.length - 1) === noOftrees) {
            if (table && table.rows.length > 1) {
                for (var i = 1; i < table.rows.length; i++) {
                    var row = table.rows[i];
                    for (var j = 0; j < row.cells.length - 1; j++) {
                        var cellData;
                        var cell = row.cells[j];
                        var input = cell.querySelector('input');
                        if (input) {
                            cellData = input.value.trim();
                        } else {
                            cellData = cell.innerText.trim();
                        }
                        if (!cellData) {
                            alert("Please fill in all fields in the table.");
                            return false;
                        } else {
                            status = true;
                            appType = 1;
                        }
                    }
                }
            } else {
                alert("Tree details are empty. Please add at least one row before saving.");
                return false;
            }
        } else {
            alert("Invalid input: The number of trees specified does not match the details of trees.");
            return false;
        }
    }else {
        // Checking fees and ownership
//if ((fees === '' || ownership === '' || totalNonHeritage === '' || totalHeritage === '' || treeRemark === '') || !$("input[name='ownership']").is(':checked')){

	if ((fees === '' || totalNonHeritage === '' || totalHeritage === '' || treeRemark === '') ){

	//alert("Please save ownership and remarks.");
            status = false;
            return false;
        } else {
        	var idProofFile = $("#doc4").get(0).files[0];

        	  if (!idProofFile) {
        	        alert("Please upload the Panchnama Report.");
        	        return false; 
        	    }
        	    
        	    var fileName = idProofFile.name;
        	    var fileExtension = fileName.split('.').pop().toLowerCase();

        	    if (fileExtension !== 'pdf') {
        	        alert("Please select a PDF file.");
        	        return false;
        	    }
            status = true;
            appType = 2;
            plantupload =true;
            
        	

        }

       
            
        
    }


    if (status) {
        if (confirm('Are you sure you want to save?')) {
            if (plantupload) {
                uploadPlantation();
            }
            onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveTree.do?appType=' + appType);
            feeId.prop('readonly', true);
            return true;
        } else {
            status = false;
            return false;
        }
    }
    

  //  if (status) {
   //     if (confirm('Are you sure you want to save?')) {
   //     	if(plantupload){
   //     	uploadPlantation();
    //    	}
     //       onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveTree.do?appType=' + appType);
     //       feeId.prop('readonly', true);
    //        return true;
    //    } else {
    //        status = false;
    //        return false;
    //    }
  //  }
}

// Attach click event listener to demandUpload button
$('#demandUpload').click(function() {
    // Set a flag to indicate that the button has been clicked
    $(this).prop('clicked', true);
});



</script>


<script>
    function validateInput(inputElement) {
        var actualNumberoftree = parseInt('${treeCuting.numberoftreecuting}');

        // Ensure non-negative values
        if (inputElement.value < 0) {
            inputElement.value = "";
            alert("Please enter a non-negative value.");
            return; // Added return to prevent further checks if this condition is met
        }

        // Limit to the value of actualNumberoftree
        //if (parseInt(inputElement.value) > actualNumberoftree) {
        //    inputElement.value = "";
       //     alert("You cannot enter a number of trees more than the citizen requested number of trees.");
       //     return; // Added return to prevent further checks if this condition is met
       // }

        // Ensure non-zero values
        if (inputElement.value == 0) {
            inputElement.value = "";
            alert("Please enter a non-zero value.");
            return; // Added return to prevent further checks if this condition is met
        }
    }
</script>




 

  <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
<script>
    var rowCount = 1;
    var heritageCount = 0;
    var nonHeritageCount = 0;
    
    var actualNumberoftreetrimming = '${treeCuting.actualNumberoftreetrimming}';

    function addRow() {
        var table = document.getElementById("tree_details");
        var currentRowCount = table.rows.length - 1;
        var maxRowCount = parseInt(document.getElementById("actualNumberoftreetrimming").value);

        if (currentRowCount < maxRowCount) {
            var row = table.insertRow(-1);
            row.innerHTML = table.rows[1].innerHTML;
            row.cells[0].innerText = currentRowCount + 1;

            var lastCell = row.cells[row.cells.length - 1];
            lastCell.innerHTML = '<button type="button" class="btn btn-sm btn-danger" onclick="deleteRow(this)">-</button>';

            var inputs = row.querySelectorAll('input[type="text"], input[type="number"]');
            inputs.forEach(function(input) {
                input.value = "";
            });

            // Clear tree-image state that got copied from the cloned row
            var clonedPreview = row.querySelector('.treeImagePreview');
            if (clonedPreview) clonedPreview.innerHTML = "";
            var clonedHidden = row.querySelector('.treeImagePathHidden');
            if (clonedHidden) clonedHidden.value = "";
            var clonedFileInput = row.querySelector('.treeImageInput');
            if (clonedFileInput) clonedFileInput.value = "";
        } else {
            alert("Cannot add more rows as these many trees only there.");
        }
    }

    function deleteRow(btn) {
        var row = btn.parentNode.parentNode;
        var rowCount = row.parentNode.rows.length;
        if (rowCount > 2) {
            row.parentNode.removeChild(row);
            updateRowCount(); // Update Sr.No. after deletion
            updateCounts(); // Update heritage and non-heritage counts
        } else {
            alert("Cannot remove the first row or only row present.");
        }
    }

    function updateRowCount() {
        var rows = document.querySelectorAll("#tree_details tbody tr");
        for (var i = 0; i < rows.length; i++) {
            rows[i].cells[0].innerText = i + 1; // Update Sr.No.
        }
    }

    function updateCounts() {
        var heritageCount = 0;
        var nonHeritageCount = 0;
        var rows = document.querySelectorAll("#tree_details tbody tr");
        rows.forEach(function(row) {
            var treeTypeEl = row.cells[2].querySelector("select[name='typeOfTree'], input[name='typeOfTree']");
            var treeType = treeTypeEl ? treeTypeEl.value : '';
            if (treeType === "Heritage") {
                heritageCount++;
            } else if (treeType === "Non-heritage") {
                nonHeritageCount++;
            }
        });
        
        document.getElementById("heritageInput").value = heritageCount;
        document.getElementById("nonHeritageInput").value = nonHeritageCount;
    }

    function updateFees() {
        var updateFees = 0;
        var nameOfTree = document.getElementById("nameOfTree").value; 

        if (nameOfTree === "Teak (साग)" || nameOfTree === "Sisam (सिसम)") { // Changed && to ||
            updateFees = parseInt(document.getElementById('actualNumberoftreetrimming').value) * 2000; 
        } else {
            updateFees = parseInt(document.getElementById('actualNumberoftreetrimming').value) * 1000; 
        }

        document.getElementById("feesApplicable").value = updateFees;
    }

    function printPDF(id,url) {
        document.getElementById('rtiApplicationRefId').value = id;
        alert("Certificate has been generated successfully.");
        onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);
    }
</script>


<script>
$(document).ready(function() {
    var treesType = '${requestScope.treestype}';
    if (treesType.trim() !== '') {
        $('#tree_details input').prop('readonly', true);
    }
});

</script>
				<script type="text/javascript">
	
    function uploadPoliceNoc() {
        console.log("@@upoading@@");
        var url = window.location.href;
        var basePath = '${pageContext.getAttribute("UPLOAD_PATH")}';
        
        var filesPath = "";
        var data = new FormData();
        var idProofFile = $("#doc1").get(0).files[0];
        

        if (!idProofFile) {
            alert("Please upload the Demand Lettter.");
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
                filesPath = filesPath + basePath + "TreeCutingApplication/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 1;
        var uid1 = document.getElementById('treecutingId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadsmanagetreecutting.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false 
            }).done(function (data) {
            	if(data.status==true || data.status=='true'){
                	  
                    alert("Demand Letter uploaded Successfully");
                    window.location.reload(); 
              	}else{
                    alert("Demand Letter upload failed!!");

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
        var idProofFile = $("#doc2").get(0).files[0];
        if (!idProofFile) {
            alert("Please upload the NOC certificate.");
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
                filesPath = filesPath + basePath + "TreeCutingApplication/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 2;
        var uid1 = document.getElementById('treecutingId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadsmanagetreecutting.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false 
        }).done(function (data) {
        	if(data.status==true || data.status=='true'){
          	  
                alert("NOC Certificate uploaded Successfully");
                window.location.reload(); 
          	}else{
                alert("NOC Certificate upload failed!!");

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
        var basePath = '${pageContext.getAttribute("UPLOAD_PATH")}';
        var filesPath = "";
        var data = new FormData();

        var idProofFile = $("#doc3").get(0).files[0];

        if (!idProofFile) {
            alert("Please upload the Rejection Letter.");
            return false; 
        }
        
        var fileName = idProofFile.name;
        var fileExtension = fileName.split('.').pop().toLowerCase();

        if (fileExtension !== 'pdf') {
            alert("Please select a PDF file.");
            return false;
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
                filesPath = filesPath + basePath + "TreeCutingApplication/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 3;
        var uid1 = document.getElementById('treecutingId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadsmanagetreecutting.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false 
        }).done(function (data) {
        	if(data.status==true || data.status=='true'){
            	  
                alert("Rejection Letter uploaded Successfully");
                window.location.reload(); 
          	}else{
                alert("Rejection Letter upload failed!!");

          	}
        });
        var a = filesPath.substring(0, filesPath.lastIndexOf(","));
        filesPath = filesPath.replace(/\s/g, "");
        $("#filesPath").val(filesPath);
        console.log(filesPath);


    }
    //uploadPlantation
    
        function uploadPlantation() {
        console.log("@@upoading@@");
        var url = window.location.href;
        var basePath = '${pageContext.getAttribute("UPLOAD_PATH")}';
        var filesPath = "";
        var data = new FormData();

        var idProofFile = $("#doc4").get(0).files[0];

        if (!idProofFile) {
            alert("Please upload the Panchanama Report.");
            return false; 
        }
        
        var fileName = idProofFile.name;
        var fileExtension = fileName.split('.').pop().toLowerCase();

        if (fileExtension !== 'pdf') {
            alert("Please select a PDF file.");
            return false;
        }
        
        data.append('idProof4', $("#doc4").get(0).files[0]);


        var isFileSelected = false

        var array_element = "";
        var file = $('input[id="doc4"]');
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
                filesPath = filesPath + basePath + "TreeCutingApplication/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 4;
        var uid1 = document.getElementById('treecutingId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadsmanagetreecutting.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false,
            async:false
        }).done(function (data) {
        	if(data.status==true || data.status=='true'){
          	  
                alert("Pachanama Report uploaded Successfully");
                window.location.reload(); 
          	}else{
                alert("Pachanama Report upload failed!!");

          	}
        });
        var a = filesPath.substring(0, filesPath.lastIndexOf(","));
        filesPath = filesPath.replace(/\s/g, "");
        $("#filesPath").val(filesPath);
        console.log(filesPath);


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

  	function viewDocument(filePath) {
     	    var encodedFilePath = encodeURIComponent(filePath);
     	    var encodedFilesPath = btoa(encodedFilePath); 
     	    var url = '<c:out value="${contextRoot}"/>/rtsApplication/viewPdf.do?fp=' + encodedFilesPath;
     	    
     	    document.getElementById("pdfViewer").src = url;
     	    document.getElementById("documentViewer").style.display = "block";
     	}

     	function closeDocumentViewer() {
     	    document.getElementById("documentViewer").style.display = "none";
     	}
     	
     	
     	
     	function gardenUpload(event) {
     		 var licAppliNumber =document.getElementById("rtiApplicationRefIds").value;
     	    if(documentUploadStatus(event)){
     		 
     	    	  var demandLetter ="${treeCuting.demandletter}";
     	    	if(demandLetter===''){
     	            var idProofFile = $("#doc1").get(0).files[0];

     	            if (!idProofFile) {
     	                alert("Please upload the Demand Lettter.");
     	                return false; 
     	            }
     	            
     	            var fileName = idProofFile.name;
     	            var fileExtension = fileName.split('.').pop().toLowerCase();

     	            if (fileExtension !== 'pdf') {
     	                alert("Please select a PDF file.");
     	                return false;
     	            }
     	            
     	            }
     	        
     	    	if(demandLetter!==''){
     	    	 var idProofFile2 = $("#idProof").get(0).files[0];

  	            if (!idProofFile2) {
  	                alert("Please upload the Certificate.");
  	                return false; 
  	            }
  	            
     	    	}else{
     	    		alert("Please upload the Demand Lettter.");
     	    		return false;
     	    	}
  	           
  	            
     		    $f1 = $("#idProof");
     		 
     		    var data = new FormData();
     		    if($f1.val()){
     			    if($f1.get(0).files.length>0){
     				    for(i=0;i<$f1.get(0).files.length;i++){
     				    	data.append('idProof', $f1.get(0).files[i]);
     						    }
     					    }
     		           }
     		  
     		    var uid1;
     		    var appType =1;//document.getElementById("applicationType").value;
     		   uid1 = document.getElementById('rtiApplicationRefIds').value;
     		    if(uid1!=null && uid1 != ""){
     		    	uid1 = document.getElementById('rtiApplicationRefIds').value;
     		    }else{
     		    	uid1 = document.getElementById('applicantAddress.mobileNumber').value;
     			    }
     		    		
     		    $.ajax({
     		        url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadCuttingCertificateDocs.do?appType="+appType+"&UID="+uid1,
     		        type: 'POST',
     		        data: data,
     		        cache: false,
     		        dataType: 'json',
     		        processData: false, // Don't process the files
     		        contentType: false, // Set content type to false as jQuery will tell the server its a query string request
     		        async: false,
     		        success: function(data, textStatus, jqXHR)
     		        { 
     		        	 var status = data.status;
     		        
     		        	 if(status===true){
     		        		    alert("Upload has been done successfully!");
     		        		    window.location.reload(); 
     		        		    }else{
     		        		    alert("Upload has been failed !");
     		        	 }
     		        },
     		        error: function(jqXHR, textStatus, errorThrown)
     		        {
    		            
     		            console.log('ERRORS: ' + textStatus);
     		        }
     		    });
     		   	    	 
     		  
     		    
     		  }
     	}
     	
     	
     	
     	function documentUploadStatus(event){
     		if(event.id == 'idProof'){
     		 var idProofObj = document.getElementById('idProof');
     		 if(((idProofObj.value == null || idProofObj.value == "") && idProofObj.id =='idProof')){
     					       alert("Please Upload Valid Document");
     				               return false;
     				}
     				else if(idProofObj.value != null && idProofObj.value != "" && idProofObj.id =='idProof'){
     						 var ext = idProofObj.value.substring(idProofObj.value.lastIndexOf('.') + 1);
     						 
     				         if(ext =="pdf" || ext=="PDF"){
     				         	return true;
     				         }
     				         else{
     				         	alert("Please attach pdf's only.");
     				             return false;
     				         }
     				}
     		}
     		if(event.id == 'residProof'){
     	    var residProofObj = document.getElementById('residProof');
     		if (((residProofObj.value == null || residProofObj.value == "") && residProofObj.id == 'residProof')) {
     				alert("Please Upload Dog Photo.");
     				return false;
     			} else if (residProofObj.value != null && residProofObj.value != "" && residProofObj.id == 'residProof') {
     				var ext = residProofObj.value.substring(residProofObj.value.lastIndexOf('.') + 1);

     				if (ext == "pdf" || ext == "PDF") {
     					return true;
     				} else {
     					alert("Please attach pdf's only.");
     					return false;
     				}
     			}
     		}
     		
     		if(event.id == 'inspectionreport1'){
     		    var inspectionreport1Obj = document.getElementById('inspectionreport1');
     			if (((inspectionreport1Obj.value == null || inspectionreport1Obj.value == "") && inspectionreport1Obj.id == 'inspectionreport1')) {
     					alert("Please Upload Inspection Report I.");
     					return false;
     				} else if (inspectionreport1Obj.value != null && inspectionreport1Obj.value != "" && inspectionreport1Obj.id == 'inspectionreport1') {
     					var ext = inspectionreport1Obj.value.substring(inspectionreport1Obj.value.lastIndexOf('.') + 1);
     				
     					if (ext == "pdf" || ext == "PDF") {
     						return true;
     					} else {
     						alert("Please attach pdf's only.");
     						return false;
     					}
     				}
     			}
     		return true;

     		}


</script>

   <script>
function uploadTreeDocs(inputId, appType, label) {

    var fileInput = document.getElementById(inputId);
    var file = fileInput.files[0];

    if (!file) {
        alert("Please select file");
        return;
    }

    var fileName = file.name.toLowerCase();

    // ✅ Only PDF
    if (!fileName.endsWith(".pdf")) {
        alert("Only PDF files are allowed");
        return;
    }

    // ✅ Double extension check
    if (fileName.substring(0, fileName.lastIndexOf(".")).includes(".")) {
        alert("Invalid file name (double extension not allowed)");
        return;
    }

    // ✅ Size check (2MB)
    if (file.size > 2 * 1024 * 1024) {
        alert("File size must be less than 2MB");
        return;
    }

    // ✅ UID
    var uid = document.getElementById("treecutingId").value.trim();

    if (!uid) {
        alert("Invalid ID");
        return;
    }

    var data = new FormData();
    data.append("file", file);

    // ✅ AJAX call
    $.ajax({
        url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadsManageTree.do?appType=" 
                + appType + "&UID=" + encodeURIComponent(uid),

        type: "POST",
        data: data,
        processData: false,
        contentType: false,

        success: function (res) {
            if (res.status === true || res.status === "true") {
                alert(label + " uploaded successfully");
                location.reload();
            } else {
                alert(res.message || "Upload failed");
            }
        },

        error: function () {
            alert("Server error occurred");
        }
    });
}
</script>

               <script>
function uploadDoc(inputId, appType, label) {

    var fileInput = document.getElementById(inputId);
    var file = fileInput.files[0];

    if (!file) {
        alert("Please select file");
        return;
    }

    var fileName = file.name.toLowerCase();

    // ✅ Only PDF
    if (!fileName.endsWith(".pdf")) {
        alert("Only PDF files are allowed");
        return;
    }

    // ✅ Double extension check
    if (fileName.substring(0, fileName.lastIndexOf(".")).includes(".")) {
        alert("Invalid file name (double extension not allowed)");
        return;
    }

    // ✅ Size check (2MB)
    if (file.size > 2 * 1024 * 1024) {
        alert("File size must be less than 2MB");
        return;
    }

    // ✅ UID
    var uid = document.getElementById("treecutingId").value.trim();

    if (!uid) {
        alert("Invalid ID");
        return;
    }

    var data = new FormData();
    data.append("file", file);

    // ✅ AJAX call
    $.ajax({
        url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadsManageTreeService.do?appType=" 
                + appType + "&UID=" + encodeURIComponent(uid),

        type: "POST",
        data: data,
        processData: false,
        contentType: false,

        success: function (res) {
            if (res.status === true || res.status === "true") {
                alert(label + " uploaded successfully");
                location.reload();
            } else {
                alert(res.message || "Upload failed");
            }
        },

        error: function () {
            alert("Server error occurred");
        }
    });
}

function saveFeesOnly() {
    var feeId = $('#feesApplicable');
    var fees = $("#feesApplicable").val();
 
    
    // Validate fees and required fields
    if (fees === '') {
        alert("Please fill in fees");
        return false;
    }
    
    if (confirm('Are you sure you want to save fees?')) {
        // Call saveTree with a NEW appType (e.g., 5 for fees-only save)
        onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveTree.do?appType=5');
        feeId.prop('readonly', true);
        return true;
    }
    return false;
}
function enableUpload(fileId, buttonId, labelId){

    document.getElementById(fileId).disabled = false;
    document.getElementById(buttonId).disabled = false;

    document.getElementById(labelId).classList.remove("disabledLabel");
    document.getElementById(labelId).classList.add("enabledLabel");
}

function showFileName(input, spanId){

    if(input.files.length > 0){
        document.getElementById(spanId).innerHTML = input.files[0].name;
    }else{
        document.getElementById(spanId).innerHTML = "No file selected";
    }
}
</script>


