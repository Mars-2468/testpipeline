<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.mars.common.utils.SessionUser"%>
<%@ page import="com.mars.common.model.User"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

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
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script type="text/javascript">
	function editRTIApplicationdog() {
		//document.getElementById('rtiApplicationId').value = id;
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editTreeTrimming.do');
	}

	function saveMandapCertificates() {

		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveTreeTrimming.do');
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
<style>
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
<div class = "row print-container">

<div class="container">
	<h3 style="font-size: 18px; font-weight: bold;">

		<fmt:message key="Application form for Tree Trimming" />
		:
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>


	</h3>
</div>
<div valign="top" id="">
	<input type="hidden" name="id"
		value="${treeTrimming.treeTrimmingId}">
	<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		<tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.name" />:</span></td>
			<td><input type="text" class="form-control"
				style="width: 300px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.firstName}"/>" readonly/></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.fathername" />:</span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width:  300px;"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.middlename}"/>" readonly/></td>

			</td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.surnname" />:</span></td>
			<td><input type="text" class="form-control"
				style="width:  300px;" id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.lastname}"/>" readonly/></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.treeTrimming.fullName" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td>
<input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.fullName}"/>" readonly/>
			</td>
		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.treeTrimming.email" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.email}"/>" readonly/></td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.treeTrimming.plotNo" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.applicantPlotNo}"/>" readonly/></td>
		</tr>
		
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Mobile No.(मोबाईल क्र.)" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.mobileNo}"/>" readonly/></td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Landmark (लँडमार्क)" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.landmark}"/>" readonly/></td>
		</tr>
		
		
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.treeTrimming.nameOfBuilding" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.applicantBuildingName}"/>" readonly/></td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.treeTrimming.nameofstreet" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.applicantStreetName}"/>" readonly/></td>
		</tr>
		
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.treeTrimming.pincode" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${treeTrimming.pincode}"/>" readonly/></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.treeTrimming.nameofCity" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.nameOfCity}"/>" readonly/></td>

		</tr>
			<tr>

			
		
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.mobile.area" />:</span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.areaName}"/>" readonly/></td>
				
			
				
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.treeTrimming.adreess" /><span class="ClsRequiredFields"></span>: </td>
			<td>
			<textarea class="form-control" style="width: 300px"
					id="ownerAddress" maxlength="200" rows="2" name="ownerAddress" readonly>${treeTrimming.address}</textarea>
		
			
			</td>
		</tr>
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.treeTrimming.zoneNo" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${treeTrimming.zoneNo}"/>" readonly/></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Aadhaar No.(आधार क्र.)" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.aadharNo}"/>" readonly/></td>

		</tr>
		<tr>
	
		<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Location of Tree (वृक्षाचे स्थान)" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.locationofTree}"/>"readonly /></td>
				
		<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Detailed Address Of Tree(वृक्षाचा तपशीलवार पत्ता)" />:</span><span class="ClsRequiredFields"></span></td>
			<td><textarea class="form-control" style="width: 300px"
					id="ownerAddress" maxlength="200" rows="2" name="ownerAddress" readonly>${treeTrimming.treeAddress}</textarea>
		</tr>
		<tr>

			<!-- <td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.treeTrimming.typeofTree" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.treeType}"/>" /></td>-->
				
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Reason For Tree Trimming (वृक्षांच्या फांद्या छाटण्यासाठी कारण)" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.resonetreetrimming}"/>" readonly/></td>

		
			
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Number of Tree Trimming (वृक्ष छाटणीची संख्या)" /><span class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="numberOfTree" maxlength="50" name="ownerName"
				value="<c:out value="${treeTrimming.numberoftreetrimming}"/>" readonly/></td>
			
    <!--  <tr>
         <td>
                           <span class="ClsLabel" style="font-size:14px"><fmt:message key="label.treecutting.feesgst" />:</span>
                        </td>
                           <td>
                            <input type="text" class="form-control" id="feesApplicable" maxlength="10" style="width: 100px" name="fees" value="<c:out value="${treeTrimming.totalFeesWithGST}"/>"/>
                          </td>
     
     
     </tr>-->
     
       
     
     </tr>
     <tr>
				 
        <td>
            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Actual Required Number of Tree for Trimming (छाटणीसाठी वृक्षांची वास्तविक आवश्यक संख्या)" />:</span>
        </td>
        <td>
            <c:choose>
                <c:when test="${empty treeTrimming.actualNumberoftreetrimming}">
                    <input type="number" class="form-control" id="actualNumberoftreetrimming" maxlength="5" style="width: 300px" name="actualNumberoftreetrimming" value="<c:out value="${treeTrimming.actualNumberoftreetrimming}"/>" oninput="validateInput(this);" />
                </c:when>
                <c:otherwise>
                    <input type="number" class="form-control" id="actualNumberoftreetrimming" maxlength="5" style="width: 300px" name="actualNumberoftreetrimming" readonly value="<c:out value="${treeTrimming.actualNumberoftreetrimming}"/>" oninput="restrictInput(this);">
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
     
  




	</table>

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="container" style="margin-top: -50px;">

<tr>
			<td colspan="4"><span class="ClsLabel"
				style="font-size: 15px; font-weight: bold;"><fmt:message
						key="List of Documents (Attachment) For Tree Trimming" />:</span></td></tr>
		<c:if test="${doc[0] != 'null'}">				
		<tr>
			<td style="width: 600px; height: 30px"><span class="ClsLabel"
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
					 <%-- <a class="ViewButton" href="#" onclick="viewDocument('${doc[0]}')">
        &#x1F4C4; <!-- Unicode character for file icon -->
        <span>View Document</span>
    </a> --%>
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
	</tr></c:if>-->
	<c:if test="${doc[1] != 'null'}">		
	<tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Sanctioned plan of construction(बांधकामाचा आराखडा मंजूर)" />:</span></td>
<td style="text-align: center"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[1]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>		
			<%--  <a class="ViewButton" href="#" onclick="viewDocument('${doc[1]}')">
        &#x1F4C4; <!-- Unicode character for file icon -->
        <span>View Document</span>
    </a> --%></td>	

		</tr>
  	</c:if>
		<tr>
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
<td style="text-align: center"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[2]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>	
<%-- <a class="ViewButton" href="#" onclick="viewDocument('${doc[2]}')">
        &#x1F4C4; <!-- Unicode character for file icon -->
        <span>View Document</span>
    </a> --%></td>	

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
		<%--  <a class="ViewButton" href="#" onclick="viewDocument('${doc[3]}')">
        &#x1F4C4; <!-- Unicode character for file icon -->
        <span>View Document</span>
    </a> --%></td>	

		</tr></c:if>
		
			<c:if test="${doc[4] != 'null'}">	
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Any Other Supporting document (इतर कोणतेही सहाय्यक दस्तावेज)" />:</span></td>
<td style="text-align: center"> <a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[4]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>		
		 <%-- <a class="ViewButton" href="#" onclick="viewDocument('${doc[4]}')">
        &#x1F4C4; <!-- Unicode character for file icon -->
        <span>View Document</span>
    </a> --%></td>	

		</tr></c:if>
		
	    
	
     
			
		
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
                        <th>Age Of Tree(Years)</th>
                        <th>Girth Of Tree(Inches)</th>
                        <th>Remark</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <c:choose>
                <c:when test="${ empty requestScope.treeTrimmingDetails}">
                
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
                            <select style="width: 150px; height: 30px; background-color: white;border-radius: 3px;border-color: grey" onchange="validateAge(this.parentNode.parentNode)" name="typeOfTree" required>
                                <option value="" selected><--select--></option>                    
                                <option value="Heritage">Heritage</option>
                                <option value="Non-heritage">Non-heritage</option>
                            </select>
                        </td>
                        
                        <td><input type="number"  style="width: 100px; height: 30px; background-color: white;border-color: grey;border-radius: 3px;" name="ageOfTree"   pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==3) return false;"  oninput="validateAge(this.parentNode.parentNode)"  value="${nocInspectionDetais.ageOfTree}" required>
                            <div id="ageErrorMessage" class="ageErrorMessage" style="color: red;"></div>
                        </td>
                        <td><input type="number" class="" name="girthOfTree" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==4) return false;"  style="width: 100px; height: 30px; border-radius: 3px;background-color: white;border-color: grey"" value="${nocInspectionDetais.girthOfTree}" required></td>
                        <td><input type="text" class="" name="remarks"  style="width: 180px; height: 30px; background-color: white;border-color: grey;border-radius: 3px;" value="${nocInspectionDetais.remark}" required></td>
                        <td>
                            <button type="button" class="btn btn-sm btn-success" onclick="addRow()">+</button>
                            <button type="button" class="btn btn-sm btn-danger" onclick="deleteRow(this)">-</button>
                        </td>
                    </tr>
                </tbody>
                </c:when>
                
                <c:otherwise>
                <c:forEach items="${requestScope.treeTrimmingDetails}" var="nocInspectionDetais" >
                <tbody>
                    <tr>
                        <td class="sr-no">1</td>
<td><input type="text" name="nameOfTree" style="width: 150px; height: 30px; background-color: white;border-color: grey" value="${nocInspectionDetais.nameOfTree}" required></td>
                        <td>
                           <%--  <select style="width: 150px; height: 30px; background-color: white;border-radius: 3px;border-color: grey" name="typeOfTree" required>
                                <option value="" selected><--select--></option>                    
                              <c:if test="${nocInspectionDetais.typeOfTree == 'Heritage' || nocInspectionDetais.typeOfTree == 'Non-heritage'}">
        <option value="Heritage" <c:if test="${nocInspectionDetais.typeOfTree == 'Heritage'}">selected</c:if>>Heritage</option>
        <option value="Non-heritage" <c:if test="${nocInspectionDetais.typeOfTree == 'Non-heritage'}">selected</c:if>>Non-heritage</option>
            
        </c:if>
                            </select> --%>
                            
                            <input type="text" name="typeOfTree" style="width: 150px; height: 30px; background-color: white;border-color: grey" value="${nocInspectionDetais.typeOfTree}" required>
                            
                        </td>
                        
                        <td><input type="number"  style="width: 100px; height: 30px; background-color: white;border-color: grey;border-radius: 3px;" name="ageOfTree" value="${nocInspectionDetais.ageOfTree}" required></td>
                        <td><input type="number" class="" name="girthOfTree"  style="width: 100px; height: 30px; border-radius: 3px;background-color: white;border-color: grey"" value="${nocInspectionDetais.girthOfTree}" required></td>
                        <td><input type="text" class="" name="remarks"  style="width: 180px; height: 30px; background-color: white;border-color: grey;border-radius: 3px;" value="${nocInspectionDetais.remarks}" required></td>
                        <td>
                       -
                        </td>
                    </tr>
                </tbody>
                
                
                </c:forEach>
                
                </c:otherwise>
                                </c:choose>
                                
                
            </table>
            
        </div>
    
        
    </div>
 
   
                <table width="100%" border="0" cellpadding="2" cellspacing="2" class="" id="">
                        <c:if test="${ not empty requestScope.treeTrimmingDetails}">
                
     <tr>
        <td colspan="2">
            <div id="totals" class="mt-3">
                <div class="totals-container">
                    <label for="heritageInput" class="form-label">Total Heritage:</label>
                    <input type="number" id="heritageInput" name="totalHeritage" value="${requestScope.treeType_heritage}" style="width: 100px; height: 30px; background-color: white; border: 1px solid #ccc; border-radius: 3px; margin-left: 10px;" min="0" value="0" readonly>
                    &nbsp; &nbsp; &nbsp; &nbsp;
                    <label for="nonHeritageInput" class="form-label">Total Non-heritage:</label>
                    <input type="number" id="nonHeritageInput" name="totalNonHeritage" value="${requestScope.treeType_Non_heritage}" style="width: 100px; height: 30px; background-color: white; border: 1px solid #ccc; border-radius: 3px; margin-left: 10px;" min="0" value="0" readonly>
                </div>
            </div>
        </td>
    </tr>


    
  
    

    <tr>
        <td>
            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Fees Applicable For Tree Trimming(वृक्ष छाटणीसाठी शुल्क लागू)" />:</span>
        </td>
        <td>
    <c:if test="${ not empty requestScope.treeTrimmingDetails}">
            <c:choose>
                <c:when test="${empty treeTrimming.totalFeesWithGST}">
                    <input type="number" class="form-control" id="feesApplicable" maxlength="5" style="width: 300px" name="fees" value="<c:out value="${treeTrimming.totalFeesWithGST}"/>" />
                </c:when>
                <c:otherwise>
                    <input type="number" class="form-control" id="feesApplicable" maxlength="5" style="width: 300px" name="fees" readonly value="<c:out value="${treeTrimming.totalFeesWithGST}"/>"/>
                </c:otherwise>
            </c:choose>
            </c:if>
        </td>
    </tr>
    </c:if>
    <tr>
    <td colspan="2" style="text-align: center;">
     <c:if test="${ not empty requestScope.treeTrimmingDetails && not empty treeTrimming.totalFeesWithGST}">
                                            <button type="button" class="btn btn-primary" style="background-color: darkgreen;" onclick="printPDF('${treeTrimming.treeTrimmingId}', 'treeTrimmingDetailsReport.do');">Generate PDF</button><br>

    </c:if>
    </td>
    </tr>
        <c:if test="${ not empty treeTrimming.totalFeesWithGST}">
    
           
<!-- Files Uploading -->  
    <%--    <c:if test="${requestScope.rtiApplication.workFlowStatus==0 &&  requestScope.forLogin != 'L2' && empty treeTrimming.plantationletter}">


</c:if> --%>

  <table width="100%" border="0" cellpadding="2" cellspacing="2" class="" id="">


        <c:if test="${not empty requestScope.treeTrimmingDetails &&  not empty treeTrimming.totalFeesWithGST}">

<tr>
           
    <td>
        <span class="ClsLabel" style="font-size:14px"><fmt:message key="Ownership of the tree" />:</span>
    </td>
    <td>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="radio" id="private" name="ownership" value="Private" <c:if test="${treeTrimming.ownership == 'Private'}">checked disabled</c:if> >
        <label for="private">Private</label>
    
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" id="municipal" name="ownership" value="Municipal" <c:if test="${treeTrimming.ownership == 'Municipal'}">checked disabled</c:if> >
    
        <label for="municipal">Municipal</label>
   
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id="governmental" name="ownership" value="Governmental" <c:if test="${treeTrimming.ownership == 'Governmental'}">checked disabled</c:if> >
        <label for="governmental">Governmental</label>
    </td>
</tr>
<tr>
	<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Tree Inspection Remarks" /><span class="ClsRequiredFields"></span>: </td>
						
					<td>
					<textarea class="form-control" style="width: 600px"
					 id="treeRemark" maxlength="200" rows="2" name="treeRemark">${treeTrimming.treeRemark}</textarea></td>
</tr>
</c:if>
</c:if>

   <c:if test="${requestScope.rtiApplication.workFlowStatus == 2 || requestScope.rtiApplication.workFlowStatus == 1}">
<tr>
    <td style="width: 243px;">
        <span class="ClsLabel" style="font-size: 14px;"><fmt:message key="Demand Receipt Letter" />:</span>
        <c:choose>
            <c:when test="${empty treeTrimming.demandletter  && requestScope.rtiApplication.workFlowStatus == 2 && requestScope.forLogin == 'L2'}">
                <td style="text-align: center;width: 522px;">
                
                    
                <a class="bg-button btn btn-success bd-highlight generateaction" id="genCerBtn" style="color: white" onclick="downloads1('${treeTrimming.rti_ref_id}', 'treeTrimmingDemandCertificateReport.do');" type="button" target="_blank">
                    <span class="download" style="display: flex; align-items: center;width: 122px;">Generate Demand</span>
                </a>
                <a class="bg-button btn btn-success bd-highlight action" style="color: white" id="dsc" type="button" target="_blank" onclick="download1(${treeTrimming.rti_ref_id});return false;">
                    <span class="download" style="align-items: center">Apply DSC</span>
                </a>
                                   &nbsp;  &nbsp;  &nbsp;  &nbsp; <input type="file" name="idProof" id="doc1" class="imagefile" style="width: 168px;"><br>
                
               </td>
                <td>
<a class="bg-button btn btn-primary bd-highlight" style="color:white" id="upload1"  type="button" target="_blank" onclick="javascript:uploadPoliceNoc(this);"><span
							class="download" style="align-items: center">Upload</span></a>                </td>
            </c:when>
            <c:when test="${not empty treeTrimming.demandletter}">
                <td>
                              <a class="bg-button btn btn-success bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${treeTrimming.demandletter}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
 
                </td>
            </c:when>
        </c:choose>
    </td>
</tr>
</c:if>
 <tr>
    <td colspan=""><span class="ClsLabel" style="font-size: 14px">
					Current Status:</span></td>
			<td style="width: 760px; height: 30px"><span class="ClsLabel"
				style="font-size: 14px;color:forestgreen;"><c:if
						test="${requestScope.rtiApplication.workFlowStatus==0}">
						<b>Citizen Form Submitted. </b>
					</c:if>
						<c:if
						test="${requestScope.rtiApplication.workFlowStatus==9}">
						<b>Application has been sent to higher approving authority. </b>
					</c:if> 
					<c:if
						test="${requestScope.rtiApplication.workFlowStatus==10}">
						<b>Higher Authority Approval Completed </b>
					</c:if>  <c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
						<b>Citizen Payment Pending. </b>
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
						<b>Citizen Payment Completed</b>
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						<b>Completed and File Uploaded for Citizen</b>
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						<b>Rejected</b>
					</c:if></span></td>
					</tr>
	
					
<c:if test="${requestScope.rtiApplication.workFlowStatus==2 &&  requestScope.forLogin == 'L2' && empty requestScope.rtiApplication.pdfFilesSavedPath}">


<tr>
	<td colspan="6" align="center"><a
		class="bg-button btn btn-success bd-highlight generateaction"
		id="genCerBtn" style="color: white"
		onclick="downloads('${treeTrimming.rti_ref_id}', 'treeTrimingCertificateReport.do');"
		type="button" target="_blank"> <span class="download"
			style="display: flex; align-items: center;width: 160px;">Generate
				Certificate</span>
	</a><a class="bg-button btn btn-success bd-highlight action"
							style="color: white" id="dsc" type="button" target="_blank"
							onclick="download1(${treeTrimming.rti_ref_id});return false;"><span
								class="download" style="align-items: center">Apply
									DSC</span></a></td>
</tr>
</c:if>
			<tr>
			
         <c:if test="${(requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus==1) }">
                 					              <td style=""><span class="ClsLabel" style="font-size:14px">Certificate Upload: </span> </td>
                 					              <c:if
					test="${ empty requestScope.rtiApplication.pdfFilesSavedPath}">
                 <td><input type="file" class="imagefile" name="idProof"
				id="idProof" style="width: 220px" /></td></c:if>
			<td><c:if
					test="${ empty requestScope.rtiApplication.pdfFilesSavedPath && requestScope.forLogin != 'L1'}">
 
					<a class="bg-button btn btn-primary bd-highlight"
						style="color: white" id="birthupload" type="button"
						target="_blank"
						onclick="gardenUpload(${treeTrimming.rti_ref_id}); return false;"><span
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

    
   
      </table>
       <c:if test="${requestScope.rtiApplication.workFlowStatus != 5}">
    
<tr>

 <c:if test="${(empty requestScope.treeTrimmingDetails ||  empty treeTrimming.totalFeesWithGST ||  empty treeTrimming.treeRemark) && requestScope.forLogin != 'L2'}">

<td colspan="4" align="center"><input type="button"
				class="btn btn-primary"
				style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745;"
				id="savefees" name="savefees"
				value="<fmt:message key="common.button.save"/>"
				onclick="javascript:saveFees(this.form);">
</td>
</c:if>
</tr>
</c:if>
<tr>
<!-- <td colspan="4" align="center">
<button type="button" class="btn btn-danger  btn_sm printMe">
             View and Print
            
        </button>
        </td> -->
        <tr>
</table>
<%-- 	 <c:if test="${not empty requestScope.treeTrimmingDetails && not empty treeTrimming.totalFeesWithGST && not empty treeTrimming.treeRemark && requestScope.forLogin != 'L2' }">

   <div class="note-point">
    <div class="note-point-circle"></div>
    <div class="note-point-content">
      <h6>Application has been sent to higher approving authority.</h6>
    </div>
  </div>   
      </c:if>
      
 <c:if test="${(  empty requestScope.treeTrimmingDetails ||  empty treeTrimming.totalFeesWithGST ||  empty treeTrimming.treeRemark )&& requestScope.forLogin != 'L2'}">
      
      <div class="custom-note-box">
    <div class="custom-note-point">
        <div class="custom-note-point-icon">
            <i class="fas fa-check-circle"></i>
        </div>
        <div class="custom-note-point-text">
            <p>Please save the tree inspection details and other details.</p>
        </div>
    </div>
</div>
  </c:if>  --%>	
		


 <input type="hidden" class="ClsTextbox" id="treeTrimmingId" style="width:180px"  name="treeTrimmingId" value="<c:out value="${treeTrimming.treeTrimmingId}"/>" />
    <input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="" />
	<input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${treeTrimming.rti_ref_id}" />
<input type="hidden" id="responseData" name="responseData" value="" />
        <c:if test="${ requestScope.forLogin == 'L2' || requestScope.forLogin == 'L1'}">
    
     <%@include file="/pages/workflow/taskInclude.jsp"%>
     </c:if>
   
</div>

<script>
$('.printMe').on('click', function () {
	 window.print();
	 });
	 
$(document).ready(function() {
	   var treeremark = "${treeTrimming.treeRemark}";
	   
	   if(treeremark !== ''){
		   $('#treeRemark').prop('readonly', true);
	   }
	});
	
    function validateInput(inputElement) {
        var actualNumberoftree = parseInt('${treeTrimming.numberoftreetrimming}');

        // Ensure non-negative values
        if (inputElement.value < 0) {
            inputElement.value = "";
            alert("Please enter a non-negative value.");
            return; // Added return to prevent further checks if this condition is met
        }

        // Limit to the value of actualNumberoftree
        if (parseInt(inputElement.value) > actualNumberoftree) {
            inputElement.value = "";
            alert("You cannot enter a number of trees more than the citizen requested number of trees.");
            return; // Added return to prevent further checks if this condition is met
        }

        // Ensure non-zero values
        if (inputElement.value == 0) {
            inputElement.value = "";
            alert("Please enter a non-zero value.");
            return; // Added return to prevent further checks if this condition is met
        }
    }
</script>


     <script>

$(document).ready(function() {
	  var workflowstatus = "${requestScope.rtiApplication.workFlowStatus}";
	  if (workflowstatus ==5) {
			var elements = document.getElementsByClassName("tab")[0];
		    elements.innerHTML = "RTS Application is Rejected".fontcolor("red");
		    $('#commentsDisable *').attr('disabled', true);
		    $('#CreateWorkflow').attr('disabled', true);
		    $('#RejectCreateWorkflow').attr('disabled', true);
		    $('#WORKFLOW_COMMENTS').attr('disabled', true);

	  }
	});
   
</script>
    <script>
    $(document).ready(function() {
        var userId = <%= request.getAttribute("userId") %>;
        var feesApplicable = '${treeTrimming.totalFeesWithGST}';
        var treeTrimmingDetails = '${requestScope.treeTrimmingDetails}';
        var demandletter = '${treeTrimming.demandletter}';
        var ownership = '${treeTrimming.ownership}';
        var treeRemark = '${treeTrimming.treeRemark}';
        var forLogin = '${requestScope.forLogin}';
        var workflowStatus = "${requestScope.rtiApplication.workFlowStatus}";
        var noc = '${treeTrimming.noc}';
        var elements = document.getElementsByClassName("tab")[0];

        // Check if either treeTrimmingDetails or feesApplicable is empty or null
        if (workflowStatus !== '5') {
            if (((!treeTrimmingDetails || treeTrimmingDetails === '') || 
                 (!feesApplicable || feesApplicable === '') || 
                 (!ownership || ownership === '')) && 
                 forLogin !== 'L2') {
                 
                // Case 1
                elements.innerHTML = "Please save the tree inspection details, fees, and upload the plantation report, or reject the application.";
                elements.style.color = "red";
                elements.style.fontSize = "22px";
                $('#commentsDisable *').attr('disabled', true);
                $('#CreateWorkflow').attr('disabled', true).hide();
                $('#RejectCreateWorkflow').attr('disabled', false);
                $('#WORKFLOW_COMMENTS').attr('disabled', false);
                $('#genCerBtn, #dsc').hide();
                $('#commentsDisable *, #descriptionDisabled *').addClass("not-active").attr('disabled', true);
                $('.mainHdr a').attr("onclick", "javascript:void(0)");
                <c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
                    document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick", "javascript:void(0);").removeAttribute("style");
                </c:forEach>
                document.getElementById('KillWorkflow').setAttribute("onclick", "javascript:void(0);").removeAttribute("style");
            } else if ((feesApplicable !== '' && feesApplicable !== null) && 
                       workflowStatus == '9' && 
                       forLogin !== 'L2') {
                
                // Case 2
                elements.innerHTML = "Application has been sent to higher authority.";
                elements.style.color = "red";
                $('#commentsDisable *').attr('disabled', true);
                $('#CreateWorkflow, #RejectCreateWorkflow, #WORKFLOW_COMMENTS').attr('disabled', true);
                $('#genCerBtn, #dsc').hide();
                $('#commentsDisable *, #descriptionDisabled *').addClass("not-active").attr('disabled', true);
                $('.mainHdr a').attr("onclick", "javascript:void(0)");
                <c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
                    document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick", "javascript:void(0);").removeAttribute("style");
                </c:forEach>
                document.getElementById('KillWorkflow').setAttribute("onclick", "javascript:void(0);").removeAttribute("style");
            } else if (((!treeTrimmingDetails || treeTrimmingDetails === '') || 
                        (!feesApplicable || feesApplicable === '') || 
                        (!treeRemark || treeRemark === '')) && 
                        forLogin === 'L2') {
                        
                // Case 3
                elements.innerHTML = "Inspection report is not yet done.";
                elements.style.color = "red";
                $('#commentsDisable *').attr('disabled', true);
                $('#CreateWorkflow, #RejectCreateWorkflow, #WORKFLOW_COMMENTS').attr('disabled', true);
                $('#genCerBtn, #dsc').hide();
                $('#commentsDisable *, #descriptionDisabled *').addClass("not-active").attr('disabled', true);
                $('.mainHdr a').attr("onclick", "javascript:void(0)");
                <c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
                    document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick", "javascript:void(0);").removeAttribute("style");
                </c:forEach>
                document.getElementById('KillWorkflow').setAttribute("onclick", "javascript:void(0);").removeAttribute("style");
            
            } else if ((workflowStatus === '3' || workflowStatus === '2') && 
                       forLogin !== 'L2') {
                    
                // Case 4
                elements.innerHTML = "Application has been sent to higher authority.";
                elements.style.color = "red";
                $('#commentsDisable *').attr('disabled', true);
                $('#CreateWorkflow, #RejectCreateWorkflow, #WORKFLOW_COMMENTS').attr('disabled', true);
                $('#genCerBtn, #dsc').hide();
                $('#commentsDisable *, #descriptionDisabled *').addClass("not-active").attr('disabled', true);
                $('#genCerBtn').hide();
         	    $('#dsc').hide();
         	    $('#commentsDisable *').addClass("not-active");
         	    $('#descriptionDisabled *').attr('disabled', true);
         	    $('#descriptionDisabled *').addClass("not-active");
         	    $('#uuid').removeAttr('disabled');
         	    $('.mainHdr a').attr("onclick", "javascript:void(0)");

         	    <c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
         	        document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick", "javascript:void(0);");
         	        document.getElementById('workflow_tras_${taskTransitionName}').removeAttribute("style");
         	    </c:forEach>

         	    document.getElementById('KillWorkflow').setAttribute("onclick", "javascript:void(0);");
         	    document.getElementById('KillWorkflow').removeAttribute("style");

                
            } 
        } else {
            elements.innerHTML = "Application has been Rejected";
            elements.style.color = "red";
            $('#commentsDisable *').attr('disabled', true);
            $('#CreateWorkflow, #RejectCreateWorkflow, #WORKFLOW_COMMENTS').attr('disabled', true);
        }
    });
</script>

     
     




<script type="text/javascript">
	function saveEntity() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createTreeTrimmingWork.do');
	}
	
	
	// Add an event listener to the typeOfTree dropdown menu
	document.getElementById('typeOfTree').addEventListener('change', function() {
	    var typeOfTree = this.value; // Get the selected value

	    if (typeOfTree === 'Heritage') {
	        // If heritage is selected, set the minimum age to 51
	        document.getElementById('ageInput').setAttribute('min', '51');
	    } else if (typeOfTree === 'Non-heritage') {
	        // If non-heritage is selected, set the maximum age to 49
	        document.getElementById('ageInput').setAttribute('max', '49');
	    } else {
	        // Reset age input attributes if no option is selected
	        document.getElementById('ageInput').removeAttribute('min');
	        document.getElementById('ageInput').removeAttribute('max');
	    }
	});

	// Add an event listener to the age input to reset attributes if the value changes
	document.getElementById('ageInput').addEventListener('input', function() {
	    // Reset age input attributes if the value changes
	    document.getElementById('ageInput').removeAttribute('min');
	    document.getElementById('ageInput').removeAttribute('max');
	});

	
	
	
</script>
	
	

<script type="text/javascript">
function saveFees() {
    var feeId = $('#feesApplicable');
    var fees = $("#feesApplicable").val();
    var totalNonHeritage = $("#totalNonHeritage").val();
    var totalHeritage = $("#totalHeritage").val();
    var ownership = $("input[name='ownership']:checked").val();
    var treeRemark = $("#treeRemark").val();

 var approvalStatusElement = $('input[name="saveApproval"]:checked');
    var approvalStatus = approvalStatusElement.length > 0 ? approvalStatusElement.val() : '';

    var treeTypeList = '${requestScope.treeTrimmingDetails}'; 
 var workflowStatus = '${requestScope.rtiApplication.workFlowStatus}';
    var status = false;
    var appType;
    var table = document.getElementById("tree_details");
    //var noOftrees = parseInt($("#numberOfTree").val());
    var noOftrees = parseInt($("#actualNumberoftreetrimming").val());

    if(treeTypeList===''){
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
                }else{
                	status=true;
                	appType=1;
                }
            }
        }
    } else {
        alert("Tree details are empty. Please add at least one row before saving.");
        
        return false;
    }
    }else{
        alert("Invalid input: The number of trees specified does not match the details of trees.");
        
        return false;
    }
    
    }else {
  
    	if ((fees === '' || ownership === '' || totalNonHeritage === '' || totalHeritage === '' || treeRemark === '') || !$("input[name='ownership']").is(':checked')){
    		
    		alert("Please save ownership and remarks.");
    	            status = false;
    	            return false;
    	        } else {
    	            status = true;
    	            appType = 2;
    	        	

    	        }

    	       
    	            
    	        
    	    }

      if (status) {
        if (confirm('Are you sure you want to save?')) {
            onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveTreeFees.do?appType='+appType);
            feeId.prop('readonly', true);
            return true;
        } else {
        	 status=false;
            return false;
        }
    }
}






// Attach click event listener to demandUpload button
$('#demandUpload').click(function() {
    // Set a flag to indicate that the button has been clicked
    $(this).prop('clicked', true);
});


	
function validateAge(row) {
    var typeOfTree = row.cells[2].querySelector('select').value;
    var age = row.cells[3].querySelector('input').value;
    var errorMessageCell = row.querySelector('.ageErrorMessage');
    // Clear any previous error message
    //document.getElementById('ageErrorMessage').textContent = '';

    if (typeOfTree === 'Heritage' && parseInt(age) < 50) {
        errorMessageCell.textContent = "For Heritage trees, age should be greater than 50.";
        
    } else if (typeOfTree === 'Non-heritage' && parseInt(age) >= 50) {
        errorMessageCell.textContent = "For Non-heritage trees, age should be less than 50.";
        
    }else{
        errorMessageCell.textContent = "";

    }
}

</script>








 

  <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
<script>
    var rowCount = 1;
    var heritageCount = 0;
    var nonHeritageCount = 0;
var actualNumberoftreetrimming = '${treeTrimming.actualNumberoftreetrimming}';

    function addRow() {
        var table = document.getElementById("tree_details");
        var currentRowCount = table.rows.length - 1; // Exclude header row
        var maxRowCount = parseInt(document.getElementById("actualNumberoftreetrimming").value);

        if (currentRowCount < maxRowCount) {
            var row = table.insertRow(-1); // Insert row at the end
            row.innerHTML = table.rows[1].innerHTML; // Clone the second row
            row.cells[0].innerText = currentRowCount + 1; // Update Sr.No.

            // Remove "+" button and add "-" button
            var lastCell = row.cells[row.cells.length - 1];
            lastCell.innerHTML = '<button type="button" class="btn btn-sm btn-danger" onclick="deleteRow(this)">-</button>';

            // Clear input values in the new row
            var inputs = row.querySelectorAll('input[type="text"], input[type="number"]');
            inputs.forEach(function(input) {
                input.value = "";
            });
            var typeOfTree = row.querySelector('.typeOfTree');
            var ageInput = row.querySelector('.ageInput');
            var errorMessage = row.querySelector('.ageErrorMessage');

            typeOfTree.addEventListener('change', function() {
                validateRow(row);
            });

            ageInput.addEventListener('input', function() {
                validateRow(row);
            });
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
            updateFees(); // Update heritage and non-heritage counts

        } else {
            alert("Cannot remove the first row or only row present.");
        }
    }

    function updateRowCount() {
        var rows = document.querySelectorAll("#dataTable tbody tr");
        for (var i = 0; i < rows.length; i++) {
            rows[i].cells[0].innerText = i + 1; // Update Sr.No.
        }
    }

    function updateCounts() {
        var heritageCount = 0;
        var nonHeritageCount = 0;
        var updateFees = 0;
        var nameOfTree = document.getElementById("nameOfTree").value; 
        var actualNumberoftreetrimming = parseInt(document.getElementById("actualNumberoftreetrimming").value);

        var rows = document.querySelectorAll("#tree_details tbody tr");
        rows.forEach(function(row) {
            var treeType = row.cells[2].querySelector("input[name='typeOfTree']").value;
            if (treeType === "Heritage") {
                heritageCount++;
            } else if (treeType === "Non-heritage") {
                nonHeritageCount++;
            }
        });
        
        document.getElementById("heritageInput").value = heritageCount;
        document.getElementById("nonHeritageInput").value = nonHeritageCount;
    }

    function validateRow(row) {
        var typeOfTree = row.querySelector('.typeOfTree').value;
        var age = parseInt(row.querySelector('.ageInput').value);
        var errorMessage = row.querySelector('.ageErrorMessage');

        errorMessage.textContent = '';

        if (typeOfTree === 'Heritage' && age <= 50) {
            errorMessage.textContent = "For Heritage trees, age should be greater than 50.";
        } else if (typeOfTree === 'Non-heritage' && age >= 50) {
            errorMessage.textContent = "For Non-heritage trees, age should be less than 50.";
        }
    }

        

      
   



    function printPDF(id,url) {

    		document.getElementById('rtiApplicationRefId').value = id;
    		
    		alert("Certificate has been generated successfully.");
    		
    		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);

    	
    }
</script>
<script>
$(document).ready(function() {
    var treeTrimmingDetails = '${requestScope.treeTrimmingDetails}';
    if (treeTrimmingDetails.trim() !== '') {
        $('#tree_details input').prop('readonly', true);
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
		                filesPath = filesPath + basePath + "treeTrimmingApplication/" + i + value + ","
		                isFileSelected = true;
		            }
		        }
		        var appType = 1;
		        var uid1 = document.getElementById('treeTrimmingId').value;
		        $.ajax({
		            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadmanageTreeTrimming.do?appType="+appType+"&UID="+uid1,
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
        var basePath = url.split('${contextRoot}')[0] + '${contextRoot}/';
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
                filesPath = filesPath + basePath + "treeTrimmingApplication/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 2;
        var uid1 = document.getElementById('treeTrimmingId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadmanageTreeTrimming.do?appType="+appType+"&UID="+uid1,
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
        alert("Upload has been done successfully!");

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
            alert("Please upload the Rejection Letter.");
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
                filesPath = filesPath + basePath + "treeTrimmingApplication/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 3;
        var uid1 = document.getElementById('treeTrimmingId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadmanageTreeTrimming.do?appType="+appType+"&UID="+uid1,
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
        alert("Upload has been done successfully!");
        var a = filesPath.substring(0, filesPath.lastIndexOf(","));
        filesPath = filesPath.replace(/\s/g, "");
        $("#filesPath").val(filesPath);
        console.log(filesPath);


    }
    //uploadPlantation
    
        function uploadPlantation() {
        console.log("@@upoading@@");
        var url = window.location.href;
        var basePath = url.split('${contextRoot}')[0] + '${contextRoot}/';
        var filesPath = "";
        var data = new FormData();

        var idProofFile = $("#doc4").get(0).files[0];

        if (!idProofFile) {
            alert("Please upload the Plantation Letter.");
            return; 
        }
        
        var fileName = idProofFile.name;
        var fileExtension = fileName.split('.').pop().toLowerCase();

        if (fileExtension !== 'pdf') {
            alert("Please select a PDF file.");
            return;
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
                filesPath = filesPath + basePath + "treeTrimmingApplication/" + i + value + ","
                isFileSelected = true;
            }
        }
        var appType = 4;
        var uid1 = document.getElementById('treeTrimmingId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadmanageTreeTrimming.do?appType="+appType+"&UID="+uid1,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, 
            contentType: false 
        }).done(function (data) {
        	if(data.status==true || data.status=='true'){
          	  
                alert("Plantation Letter uploaded Successfully");
                window.location.reload(); 
          	}else{
                alert("Plantation Letter upload failed!!");

          	}
        });
        alert("Upload has been done successfully!");
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
</script>
<script>

function gardenUpload(event) {
	 var licAppliNumber =document.getElementById("rtiApplicationRefIds").value;
    if(documentUploadStatus(event)){
	 
    	  var demandLetter ="${treeTrimming.demandletter}";
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
	   // $f2 = $("#residProof");
	   // $f3 = $("#inspectionreport1");
	   
	 //event.stopPropagation(); // Stop stuff happening
	   // event.preventDefault(); // Totally stop stuff happening

	    // START A LOADING SPINNER HERE

	    // Create a formdata object and add the files
	    
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
	        url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadCFCLicenseDocs.do?appType="+appType+"&UID="+uid1,
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
	            // Handle errors here
	            
	            console.log('ERRORS: ' + textStatus);
	            // STOP LOADING SPINNER
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