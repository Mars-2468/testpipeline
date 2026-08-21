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

pageContext.setAttribute("UPLOAD_PATH", CoreConstants.UPLOAD_PATH);
%>
<%
HttpSession session1 = request.getSession();
SessionUser sessionUser = (SessionUser) session1.getAttribute("SessionUser");
Long userId = sessionUser.getUserId();
request.setAttribute("userId", userId);
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
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editWaterDueCertificate.do');
	}

	function saveMandapCertificates() {

		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/saveWaterCertificates.do');
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
<div class = "row print-container">
<div class="container">
	<h3 style="font-size: 18px; font-weight: bold;">

		<fmt:message key="Application form for Water No Due Certificate" />
		:
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>


	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<input type="hidden" name="id"
		value="${waterConnection.waterConnectionId}"> 
		<table width="100%" border="0" cellpadding="2" cellspacing="2"
		class="container">
		<tr>
		<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterConnection.cinNo" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				readonly value="<c:out value="${waterConnection.cinNo}"/>" />
				&nbsp;</td>
				

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterConnection.zoneNo" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				readonly value="<c:out value="${waterConnection.zoneNo}"/>" /></td>

		</tr>
				
				<tr>
			<td><span
				class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterConnection.consumerName" />:</span></td>
		<td><textarea class="form-control" style="width: 300px"
					 readonly id="ownerAddress" maxlength="200" name="ownerAddress">${waterConnection.consumerName}</textarea>
				

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterConnection.consumerAddress" />:</span><span class="ClsRequiredFields"></span></td>
			<td><textarea class="form-control" style="width: 300px"
					id="ownerAddress" maxlength="200" name="ownerAddress" readonly>${waterConnection.consumerAddress}</textarea>

			</td>
</tr>
			<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterConnection.meterNo" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName"
				readonly value="<c:out value="${waterConnection.meterNo}"/>" /></td>

			

	

<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.waterDisconnection.meterTapSize" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
	id="ownerName" maxlength="50" name="ownerName" readonly
	value="<c:out value="${waterConnection.tap_size}"/>" /></td>
	</tr>	
		
		<tr>

<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.category" /><span
		class="ClsRequiredFields"></span>: </td>
<td><input type="text" class="form-control" style="width: 300px"
	id="ownerName" maxlength="50" name="ownerName" readonly
	value="<c:out value="${waterConnection.category}"/>" /></td>


<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.waterDisconnection.balance_arrears" />:</span></td>

			<td><input type="text" class="form-control" style="width: 300px"
	id="ownerName" maxlength="50" name="ownerName" readonly
	value="<c:out value="${waterConnection.balance_arrears}"/>" /></td>

	</tr>	
	
		<tr>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
			key="label.cut_off_date" /><span
		class="ClsRequiredFields"></span>: </td>
<td><input type="text" class="form-control" style="width: 300px"
	id="ownerName" maxlength="50" name="ownerName" readonly
	value="<c:out value="${waterConnection.cut_off_date}"/>" /></td>
	
	<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="ESR" />:</span><span class="ClsRequiredFields"></span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName" readonly
				value="<c:out value="${waterConnection.existingEsr}"/>" /></td>
           
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterConnection.emailid" />:</span></td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress" readonly
				value="<c:out value="${waterConnection.emailId}"/>" />
				&nbsp;</td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.waterConnection.mobileno" /><span class="ClsRequiredFields"></span>:
			</td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName" readonly
				value="<c:out value="${waterConnection.mobileNo}"/>" /></td>
</tr><tr>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="label.changeInOwnershipType.altermobileNo" /><span
					class="ClsRequiredFields"></span>: </td>
			<td><input type="text" class="form-control" style="width: 300px"
				id="ownerName" maxlength="50" name="ownerName" readonly
				value="<c:out value="${waterConnection.alterMobileNo}"/>" /></td>	
		
		
				
			 <td><span class="ClsLabel" style="font-size:14px"> Current Status:</span></td>
     <td> <span class="ClsLabel" style="font-size:14px;color:forestgreen;">
     <c:if test="${requestScope.rtiApplication.workFlowStatus==0}">
						<b>Citizen Form Submitted. </b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
<b>In Progress.</b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
<b>In Progress.</b>
					</c:if>
											
					<c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						<b>Completed and File Uploaded for Citizen</b>
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						<b>Rejected</b>
					</c:if></span>
        
  </td>   
		</tr>
		
		<c:if test="${(requestScope.rtiApplication.workFlowStatus == 0) 
    && empty requestScope.rtiApplication.pdfFilesSavedPath
    && requestScope.forLogin eq 'L2'}">
    <tr>
        <td colspan="6" align="center">
            <a class="bg-button btn btn-success bd-highlight generateaction"
                id="genCerBtn" style="color: white"
                onclick="downloads('${waterConnection.rti_ref_id}', 'waterNoDuesCertificateReport.do');"
                type="button" target="_blank">
                <span class="download" style="display: flex; align-items: center; width: 160px;">
                    Generate Certificate
                </span>
            </a>
            <a class="bg-button btn btn-success bd-highlight action"
                style="color: white" id="dsc" type="button" target="_blank"
                onclick="download2(${waterConnection.rti_ref_id});return false;">
                <span class="download" style="align-items: center">Apply DSC</span>
            </a>
        </td>
    </tr>
</c:if>

<tr>
    <td colspan="2">
        <span class="ClsLabel" style="font-size: 14px">Certificate Upload:</span>
    </td>
    <c:if test="${(requestScope.rtiApplication.workFlowStatus == 0) 
        && empty requestScope.rtiApplication.pdfFilesSavedPath
        && requestScope.forLogin eq 'L2' }">
        <td>
            <input type="file" class="imagefile" name="idProof" id="idProof" style="width: 220px" />
        </td>
        <td>
            <a class="bg-button btn btn-primary bd-highlight"
                style="color: white" id="birthupload" type="button"
                target="_blank"
                onclick="birthupload(${waterConnection.rti_ref_id}); return false;">
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
		
	<tr>
<td colspan="4" align="center">
<button type="button" class="btn btn-danger  btn_sm printMe">
             View and Print
            
        </button>
        </td>
</tr>	
</table>
	<br>
</div>
<input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${waterConnection.rti_ref_id}" />

<input type="hidden" class="ClsTextbox" id="waterConnectionId"
	style="width: 180px" name="waterConnectionId"
	value="<c:out value="${waterConnection.waterConnectionId}"/>" />
<input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId"
	value="<c:out value="${requestScope.rtiApplication.rtiApplicationId}"/>" />
<input type="hidden" id="responseData" name="responseData"
								value="" />	
	<!-- %@include file="/pages/workflow/taskInclude.jsp"%>-->
	



<script type="text/javascript">
	function saveEntity() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createWaterConnectionNoDuesWork.do');
	}
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
	
	$('.printMe').on('click', function () {
	   	 window.print();
	   	 });
	</script>
	
 