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
//birth
pageContext.setAttribute("LABEL_HOSPITAL_NAME_YASH", CoreConstants.LABEL_HOSPITAL_NAME_YASH);
pageContext.setAttribute("LABEL_HOSPITAL_NAME_MEDI", CoreConstants.LABEL_HOSPITAL_NAME_MEDI);

pageContext.setAttribute("HOSPITAL_NAME_YASH", CoreConstants.HOSPITAL_NAME_YASH);
pageContext.setAttribute("HOSPITAL_NAME_MEDI", CoreConstants.HOSPITAL_NAME_MEDI);

pageContext.setAttribute("LABEL_CHILD_GENDER_MALE", CoreConstants.LABEL_CHILD_GENDER_MALE);
pageContext.setAttribute("LABEL_CHILD_GENDER_FEMALE", CoreConstants.LABEL_CHILD_GENDER_FEMALE);
pageContext.setAttribute("LABEL_CHILD_GENDER_TRANSGENDER", CoreConstants.LABEL_CHILD_GENDER_TRANSGENDER);

pageContext.setAttribute("CHILD_GENDER_MALE", CoreConstants.CHILD_GENDER_MALE);
pageContext.setAttribute("CHILD_GENDER_FEMALE", CoreConstants.CHILD_GENDER_FEMALE);
pageContext.setAttribute("CHILD_GENDER_TRANSGENDER", CoreConstants.CHILD_GENDER_TRANSGENDER);

pageContext.setAttribute("LABEL_ZONE_NUMBER_HARS", CoreConstants.LABEL_ZONE_NUMBER_HARS);
pageContext.setAttribute("LABEL_ZONE_NUMBER_EKTA", CoreConstants.LABEL_ZONE_NUMBER_EKTA);

pageContext.setAttribute("ZONE_NUMBER_HARS", CoreConstants.ZONE_NUMBER_HARS);
pageContext.setAttribute("ZONE_NUMBER_EKTA", CoreConstants.ZONE_NUMBER_EKTA);

pageContext.setAttribute("STATUS_YES_LABEL", CoreConstants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO_LABEL", CoreConstants.STATUS_NO_LABEL);

pageContext.setAttribute("STATUS_YES", CoreConstants.STATUS_YES);
pageContext.setAttribute("STATUS_NO", CoreConstants.STATUS_NO);

pageContext.setAttribute("LABEL_BLOOD_GROUP_ONE", CoreConstants.LABEL_BLOOD_GROUP_ONE);
pageContext.setAttribute("LABEL_BLOOD_GROUP_TWO", CoreConstants.LABEL_BLOOD_GROUP_TWO);
pageContext.setAttribute("LABEL_BLOOD_GROUP_THREE", CoreConstants.LABEL_BLOOD_GROUP_THREE);
pageContext.setAttribute("LABEL_BLOOD_GROUP_FOUR", CoreConstants.LABEL_BLOOD_GROUP_FOUR);
pageContext.setAttribute("LABEL_BLOOD_GROUP_FIVE", CoreConstants.LABEL_BLOOD_GROUP_FIVE);
pageContext.setAttribute("LABEL_BLOOD_GROUP_SIX", CoreConstants.LABEL_BLOOD_GROUP_SIX);
pageContext.setAttribute("LABEL_BLOOD_GROUP_SEVEN", CoreConstants.LABEL_BLOOD_GROUP_SEVEN);
pageContext.setAttribute("LABEL_BLOOD_GROUP_EIGHT", CoreConstants.LABEL_BLOOD_GROUP_EIGHT);

pageContext.setAttribute("BLOOD_GROUP_ONE", CoreConstants.BLOOD_GROUP_ONE);
pageContext.setAttribute("BLOOD_GROUP_TWO", CoreConstants.BLOOD_GROUP_TWO);
pageContext.setAttribute("BLOOD_GROUP_THREE", CoreConstants.BLOOD_GROUP_THREE);
pageContext.setAttribute("BLOOD_GROUP_FOUR", CoreConstants.BLOOD_GROUP_FOUR);
pageContext.setAttribute("BLOOD_GROUP_FIVE", CoreConstants.BLOOD_GROUP_FIVE);
pageContext.setAttribute("BLOOD_GROUP_SIX", CoreConstants.BLOOD_GROUP_SIX);
pageContext.setAttribute("BLOOD_GROUP_SEVEN", CoreConstants.BLOOD_GROUP_SEVEN);
pageContext.setAttribute("BLOOD_GROUP_EIGHT", CoreConstants.BLOOD_GROUP_EIGHT);

pageContext.setAttribute("LABEL_RADIO_HOME", CoreConstants.LABEL_RADIO_HOME);
pageContext.setAttribute("LABEL_RADIO_HOSPITAL", CoreConstants.LABEL_RADIO_HOSPITAL);

pageContext.setAttribute("RADIO_HOME", CoreConstants.RADIO_HOME);
pageContext.setAttribute("RADIO_HOSPITAL", CoreConstants.RADIO_HOSPITAL);

pageContext.setAttribute("BLOOD_RELATION_ONE", CoreConstants.BLOOD_RELATION_ONE);
pageContext.setAttribute("BLOOD_RELATION_TWO", CoreConstants.BLOOD_RELATION_TWO);

pageContext.setAttribute("LABEL_BLOOD_RELATION_ONE", CoreConstants.LABEL_BLOOD_RELATION_ONE);
pageContext.setAttribute("LABEL_BLOOD_RELATION_TWO", CoreConstants.LABEL_BLOOD_RELATION_TWO);

pageContext.setAttribute("LABEL_RADIO_SAME_DAY", CoreConstants.LABEL_RADIO_SAME_DAY);
pageContext.setAttribute("LABEL_RADIO_TILL_THIRD_DAY", CoreConstants.LABEL_RADIO_TILL_THIRD_DAY);

pageContext.setAttribute("RADIO_SAME_DAY", CoreConstants.LABEL_RADIO_HOME);
pageContext.setAttribute("RADIO_TILL_THIRD_DAY", CoreConstants.RADIO_TILL_THIRD_DAY);

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

 .ClsLabel{
 font-style:normal;
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


.action{
width:100px;
height:32px;

}

.generateaction{
width:155px;
height:32px;
}

#table1{
 padding: 7px;
    font-size: 11px;
    width: 100%;
}

#table2{
 padding: 5px;
    font-size: 11px;
    width: 100%;
}

.download{
font-size:13px;
}
</style>

<div class="mainHdr">
<h3 style="
    height: 30px;
        font-size: 15px;color:#01293d">
 <c:if test="${propertyTaxTransferRegistration.myDropdown eq 3}">
		<fmt:message key="Property Transfer Registration Certificate" /></c:if>
		 <c:if test="${propertyTaxTransferRegistration.myDropdown eq 4}">
		<fmt:message key="Inheritance Rights Property Registration Certificate" /></c:if>		:
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>

	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<input type="hidden" name="id"
		value="${propertyTaxTransferRegistration.propertyTransferRegistrationId}">
	<c:set var="doc"
		value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
	<table width="100%" border="0" cellpadding="2" cellspacing="2">
		<tr>
		<tr>


			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="tax.label.applicantName" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 180px" id="applicantLastName" maxlength="50"
				name="applicantLastName"
				value="<c:out value="${propertyTaxTransferRegistration.name}"/>" disabled />
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="tax.label.appllicantEmaailId" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 250px" id="ph_no" maxlength="50" name="ph_no"
				value="<c:out value="${propertyTaxTransferRegistration.emailid}"/>" disabled />
			</td>
		</tr>
		<tr>
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="tax.label.applicantMobileNo" /></span><span class="ClsRequiredFields"></span></td>
			<td colspan="2"><input type="text" class="form-control"
				id="email" style="width: 230px" name="email"
				value="<c:out value="${propertyTaxTransferRegistration.mobileNo}"/>" disabled />
			</td>
		
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Name of Property
							Holders/Occupants (मालमत्ताधारक/ भोगवटादारांचे नाव)" /></span><span
				class="ClsRequiredFields"></span></td>
			<td colspan="2"><input type="text" class="form-control" id="dob"
				style="width: 250px" name="dob"
				value="<c:out value="${propertyTaxTransferRegistration.propertyHolderName}"/>"
				disabled /></td>

</tr>
		<tr>

			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Zone No. (झोन
							क्र.)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 230px" id="childeName" maxlength="45" tabindex="3"
				name="childeName"
				value="<c:out value="${propertyTaxTransferRegistration.zoneNo}"/>" disabled /></td>
		

			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="UPIN No. (UPIN क्र.)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 180px" id="fatherName" maxlength="45" tabindex="4"
				name="fatherName"
				value="<c:out value="${propertyTaxTransferRegistration.upinNo}"/>" disabled /></td>
		</tr>
		<tr>
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Pincode (पिन कोड)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 180px" id="childeName" maxlength="45" tabindex="3"
				name="childeName"
				value="<c:out value="${propertyTaxTransferRegistration.taxPincode}"/>" disabled />
			</td>


			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Index No. (निर्देशांक क्र.)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 180px" id="childeName" maxlength="45" tabindex="3"
				name="childeName"
				value="<c:out value="${propertyTaxTransferRegistration.indexNo}"/>" disabled />
			</td>
		</tr>
		<tr>


			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Address(पत्ता)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 180px" id="childeName" maxlength="45" tabindex="3"
				name="childeName"
				value="<c:out value="${propertyTaxTransferRegistration.address}"/>" disabled />
			</td>

			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Ward No. (प्रभाग क्र.)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 180px" id="fatherName" maxlength="45" tabindex="4"
				name="fatherName"
				value="<c:out value="${propertyTaxTransferRegistration.blockNo}"/>" disabled />
			</td>

</tr>
		<tr>

<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Ward Name (प्रभाग नाव)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 180px" id="childeName" maxlength="45" tabindex="3"
				name="childeName"
				value="<c:out value="${propertyTaxTransferRegistration.blockName}"/>" disabled />
			</td>
	
		
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Owner Name (मालकाचे नाव)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 180px" id="childeName" maxlength="45" tabindex="3"
				name="childeName"
				value="<c:out value="${propertyTaxTransferRegistration.ownerName}"/>" disabled />
			</td>
			</tr>
		<tr>
		
<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Areas Pending Status (क्षेत्रे प्रलंबित स्थिती)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 180px" id="childeName" maxlength="45" tabindex="3"
				name="childeName"
				value="<c:out value="${propertyTaxTransferRegistration.areasPendingStatus}"/>"
				disabled /></td>



			

			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Registered Mobile Number (नोंदणीकृत मोबाईल क्रमांक)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 180px" id="childeName" maxlength="45" tabindex="3"
				name="childeName"
				value="<c:out value="${propertyTaxTransferRegistration.taxMobileNo}"/>" disabled />
			</td>
		
</tr>
		<tr>



			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Arrears (थकबाकी)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 180px" id="childeName" maxlength="45" tabindex="3"
				name="childeName"
				value="<c:out value="${propertyTaxTransferRegistration.areasPending}"/>"
				disabled /></td>
				
				<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Arrears Status (थकबाकी स्थिती)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 180px" id="childeName" maxlength="45" tabindex="3"
				name="childeName"
				value="<c:out value="${propertyTaxTransferRegistration.areasPendingStatus}"/>"
				disabled /></td>
				

			
				
				</tr>


		<tr>
		<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Pending Dues (प्रलंबित थकबाकी)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 180px" id="childeName" maxlength="45" tabindex="3"
				name="childeName"
				value="<c:out value="${propertyTaxTransferRegistration.duesAmt}"/>"
				disabled /></td>
				
				<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Applicable Fees(लागू शुल्क)" />:</span></td>
			<td colspan="2"><input type="text" class="form-control"
				style="width: 180px" id="feesApplicable" maxlength="45" tabindex="3"
				name="fees"
				value="<c:out value="${rtiApplication.applicationCost}"/>"
				disabled /></td>
</tr>
<%-- 
 <c:if test="${requestScope.rtiApplication.workFlowStatus==3 ||requestScope.rtiApplication.workFlowStatus==2 || requestScope.rtiApplication.workFlowStatus==1}">
     <tr >
              <td><span class="ClsLabel" id="payment" style="font-size:14px">Payment Receipt Upload: </span> </td>
                <td>
                      
			<input type="file" class="imagefile" name="paymentReceiptidProof" id="paymentReceiptidProof" style="width: 220px" />

			</td>
                   <td>   
                      <c:if test="${ empty propertyTaxTransferRegistration.paymentReceipt}">   
               
                <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="paymentReceiptdocupload" type="button" target="_blank" onclick="paymentReceiptupload(${propertyTaxTransferRegistration.rti_ref_id}); return false;"><span
							class="download" style="align-items: center">Upload</span></a>
               
                </c:if>
              <c:if test="${ not empty propertyTaxTransferRegistration.paymentReceipt}">
              
               <a class="bg-button btn btn-success bd-highlight action" style="color:white" id="paymentReceiptdownload"  class="imagefile" type="button" target="_blank" href="<c:out value="${propertyTaxTransferRegistration.paymentReceipt}"/>"><span
							class="download" style="align-items: center">Download</span></a>
               </c:if>

</td>
</tr>
</c:if> --%>

		<tr>
		<%--<tr>
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px">
					Current Status:</span></td>
			<td style="width: 230px; height: 30px"><span class="ClsLabel"
				style="font-size: 14px"><c:if
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

		     

			 <td colspan=""><span class="ClsLabel" style="font-size: 14px">Certificate
					Upload: </span></td>
			<td><input type="file" class="imagefile" name="idProof"
				id="idProof" style="width: 220px" /></td>
			<td><c:if
					test="${ empty requestScope.rtiApplication.pdfFilesSavedPath}">

					<a class="bg-button btn btn-primary bd-highlight"
						style="color: white" id="birthupload" type="button"
						target="_blank"
						onclick="birthupload(${propertyTaxTransferRegistration.rti_ref_id}); return false;"><span
						class="download" style="align-items: center">Upload</span></a>


				</c:if> <c:if
					test="${ not empty requestScope.rtiApplication.pdfFilesSavedPath}">

					<a class="bg-button btn btn-success bd-highlight action"
						style="color: white" id="birthdownload" class="imagefile"
						type="button" target="_blank"
						href="<c:out value="${requestScope.rtiApplication.pdfFilesSavedPath}"/>"><span
						class="download" style="align-items: center">Download</span></a>
				</c:if></td>
				</tr>
		
		 <tr><td colspan="6"></td></tr>  --%>      
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px">
					Current Status:</span></td>
			<td style="width: 230px; height: 30px"><span class="ClsLabel" style="font-size:14px;color:forestgreen;"><c:if
						test="${requestScope.rtiApplication.workFlowStatus==0}">
						Citizen Form Submitted. 
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==3}">
						Citizen Payment Pending. 
					</c:if>
					<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">
						Citizen Payment Completed. 
					</c:if>
					 <c:if test="${requestScope.rtiApplication.workFlowStatus==1}">
						Completed and File Uploaded for Citizen
					</c:if> <c:if test="${requestScope.rtiApplication.workFlowStatus==5}">
						Rejected
					</c:if></span></td>

		     
<%-- <c:if
					test="${ empty requestScope.rtiApplication.pdfFilesSavedPath}">
		 	<td colspan=""><span class="ClsLabel" style="font-size: 14px">Certificate
					Upload: </span></td>
			<td><input type="file" class="imagefile" name="idProof"
				id="idProof" style="width: 220px" /></td>
			<td> 
					<a class="bg-button btn btn-primary bd-highlight"
						style="color: white" id="birthupload" type="button"
						target="_blank"
						onclick="birthupload(${partitionOfProperty.rti_ref_id}); return false;"><span
						class="download" style="align-items: center">Upload</span></a>


				 
				</c:if> --%>
				                 <c:if test="${not empty requestScope.rtiApplication.pdfFilesSavedPath}">
				
				<td>
		
					<a class="bg-button btn btn-success bd-highlight action"
						style="color: white" id="birthdownload" class="imagefile"
						type="button" target="_blank"
						href="<c:out value="${requestScope.rtiApplication.pdfFilesSavedPath}"/>"><span
						class="download" style="align-items: center">Download</span></a>
				</td>
										</c:if>
				
				</tr>
		
		</tr>
		
	</table>
	<table width="100%" border="0" cellpadding="2" cellspacing="2">

		<tr>
		
						
						       <td colspan="6" style="background-color: white;background-color: #c5ddfe;"><span class="ClsLabel"
				style="
    height: 37px;
    padding: 7px 10px 11px;
       font-size: 17px;color:#01293d;font-style: italic;"><fmt:message
						key="List of Documents (Attachment) दस्तऐवजांची यादी (संलग्नक)" />:</span></td>
		</tr>


<%--  <c:if test="${propertyTaxTransferRegistration.myDropdown eq 3}">
		<c:if test="${doc[0] != 'null'}">
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="Copy of Registered Sale Deed,Transfer Deed(नोंदणीकृत विक्री कराराची प्रत,हस्तांतरण पत्र)" />:</span>
				<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
			</tr>
		</c:if>
		</c:if> --%>

		<c:if test="${doc[0] != 'null'}">
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="Self Attested Applicant's Id Proof (स्वत: प्रमाणित अर्जदाराचा आयडी पुरावा)" />:</span>
				<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
			</tr>
		</c:if>


	<c:if test="${doc[1] != 'null'}">
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="Akhiv Patrika of City Survey Department (नगर भूमापन  विभागाची आखिव पत्रिका)" />:</span>
				<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[1]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
			</tr>
		</c:if>
		
			<c:if test="${doc[2] != 'null'}">
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="Any Other Supporting document (इतर कोणतेही सहाय्यक दस्तावेज)" />:</span>
				<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[2]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
			</tr>
		</c:if>
		
			<c:if test="${doc[3] != 'null'}">
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="Gift Deed, Will Deed, Death Certificate, Partition Deed, 
     Inheritance Document, NIT/Nazul/Lease of Municipal 
     Corporation Document (बक्षीस पत्र, इच्छा पत्र /मृत्यू पत्र, मृत्यू प्रमाणपत्र, पार्टीशन डीड, वारसा दस्तऐवज, एनआयटी/नझुल/महापालिकेचे लीज दस्तऐवज)" />:</span>
				<td style="text-align: center" colspan="3.5"><a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[3]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a></td>
			</tr>
		</c:if>
		
		<c:set var="taxUpload" value="${fn:split(requestScope.rtiApplication.taxOtherCitizenDocumentUpload, ',')}" />

<c:if test="${not empty requestScope.rtiApplication.taxOtherCitizenDocumentUpload}">
    <tr>
        <td colspan="3.5">
            <span class="ClsLabel" style="font-size: 14px">
                <fmt:message key="Document Reassignment (दस्तऐवज पुनर्नियुक्ती)" />:
            </span>
        </td>
        <td style="text-align: center" colspan="3.5">
            <c:forEach var="taxDocument" items="${taxUpload}" varStatus="loop">
            <c:if test="${taxDocument !='null'}">
            
                <a class="bg-button btn btn-primary bd-highlight action" type="button" target="_blank" onclick="docDownload('${taxDocument}');">
                    <span class="download" style="align-items: center;color:white;">Download</span>
                </a>
                </c:if>
                <!-- Add spacing between buttons except for the last one -->
                <c:if test="${not loop.last}">&nbsp;&nbsp;</c:if>
            </c:forEach>
        </td>
    </tr>
    </c:if>

		
		
			
<%-- 
		<c:if test="${propertyTaxTransferRegistration.fees == 0.0}">
<tr>

<td colspan="4" align="center"><input type="button"
				class="btn btn-primary"
				style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745;"
				id="savefees" name="savefees"
				value="<fmt:message key="common.button.save"/>"
				onclick="javascript:saveFees(this.form);">
</td>
</tr>
</c:if> --%>

	</table>

	<input type="hidden" class="ClsTextbox_mr" style="width: 180px"
		id="propertyAssessmentID" maxlength="12" name="propertyAssessmentID"
		value="<c:out value="${propertyTaxTransferRegistration.propertyTransferRegistrationId}"/>" />

	<input type="hidden" id="rtiApplicationRefId"
		name="rtiApplicationRefId" value="" /> <input type="hidden"
		id="rtiApplicationRefIds" name="rtiApplicationRefIds"
		value="${propertyTaxTransferRegistration.rti_ref_id}" />
		<input type="hidden" id="responseData" name="responseData"
								value="" />


	</table>
<%-- 	<%@include file="/pages/workflow/taskInclude.jsp"%> 
 --%>
</div>
</div>

<script type="text/javascript">
	function saveEntity() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/createPropertyTaxTransferRegistrationWork.do');
	}
	
	
	function saveFees(){
		var refId= $('#propertyAssessmentID').val();
		if($('#feesApplicable').val().trim() >0){
		if(confirm("Are you sure you want to save Fees!!")){
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/savePropertyTaxtransferRegistrationFees.do?id='+refId);
		}else{
			return false;
		}
		}else{
			alert("Please enter the fees");
			return false;
		}

	}
	
/* 	$(document).ready(function() {
		  var feeId = $('#feesApplicable').val();
		    $("#feesApplicable").prop('disabled',false);
		    $("#savefees").prop('disabled',false);
			  var feeId = $('#feesApplicable').val();
		    if(feeId==='0.0'){
				  var elements = document.getElementsByClassName("tab")[0];
					elements.innerHTML = "Please save the Fees".fontcolor("red");
					document.getElementById("feesApplicable").style.backgroundColor = "white";
			    	$('#commentsDisable *').attr('disabled', true);
			    	$('#CreateWorkflow').attr('disabled', true);
			    	$('#RejectCreateWorkflow').attr('disabled', true);
			    	$('#WORKFLOW_COMMENTS').attr('disabled', true);
			  }
		});
	$(document).ready(function() {
		  var feeId = $('#feesApplicable').val();
		  if (feeId >0) {
		    $("#feesApplicable").prop('disabled', true);
		    $("#savefees").prop('disabled',true);

		  }
		  
		
		}); */
	</script> 
	
	
	<script type="text/javascript">
	
	function birthupload(id) {
		  
 	    var data = new FormData();
 	   var idProofFileInput = $("#idProof");
 	  var receipt = "${propertyTaxTransferRegistration.paymentReceipt}";
 	  
		if (receipt === '') {
	 	    alert("Please upload the payment receipt!!");
	 	    return false;
	 	}
 	 	if (idProofFileInput.val() === '') {
 	 	    alert("Please select the document!!");
 	 	    return false;
 	 	}
 	    alert("Are you sure you want to Upload Certificate?");
 	    
 	  document.getElementById('rtiApplicationRefIds').value=id;
 	 

 	if (idProofFileInput.length > 0 && idProofFileInput.get(0).files.length > 0) {
 	    data.append('idProof1', idProofFileInput.get(0).files[0]);

 	   
 	} else {
 	    console.error("No file selected");
 	}

 	 var apptype=4;
	  $.ajax({
		  url: "<c:out value='${contextRoot}'/>/mobileapp/rtsapplication/getHealthDSC.do?id="+apptype,
 		 type: 'POST',
         data: data,
         cache: false,
	      dataType: 'xml',
         processData: false,
         contentType: false,
         async: false, 
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
 			      	  //onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveBirthCertificate.do');
 			      	 $.ajax({
 	                    url: '<c:out value="${contextRoot}"/>/rtsapplication/savePropertyTaxUpload.do?refId='+id,
 	                    type: 'POST',
 	                   async: false, 
 	                   data: {
 	 			        	status : status
 	 			        	
 	 			        },
 	                   
 	                	  success: function(data, textStatus, jqXHR) {
 	                		    console.log("Data:", data);

 	                		    var parsedData = JSON.parse(data);
 	                		    var finalstatus = parsedData.status;

 	                		    console.log("finalstatus:", finalstatus);

 	                		    if (finalstatus === true) {
 	                		        alert("Upload has been done successfully!");
 	                		        window.location.reload(); 
 	                		    } else {
 	                		        alert("Upload has been failed!!");
 	                		    }
 	                		},
 	                    error: function (xhr) {
	      	        		    alert("Upload has been failed !");
 	                        console.log(xhr.responseText);
 	                    }
 	                });
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

 	function paymentReceiptupload(id) {
 		// $('#SetFormHeight *').removeAttr('disabled');
 		document.getElementById("rtiApplicationRefIds").value=id;
 		
 		 
 		    $f1 = $("#paymentReceiptidProof");
 		    
 		    var data = new FormData();
 		    if($f1.val()){
 		    	if(confirm("Are you sure you want to Upload Certificate?")){
 		    	if($f1.get(0).files.length>0){
 				    for(i=0;i<$f1.get(0).files.length;i++){
 				    	data.append('idProof', $f1.get(0).files[i]);
 						    }
 					    }
 		    	}else{
		        	   return false;
 		    	}
 		           }else{
 		        	   alert("Please select valid document!!");
 		        	   return false;
 		           }
 		 
 		    var propertyId=2;		
 		    $.ajax({
 		        url: "<c:out value='${contextRoot}'/>/rtsapplication/savePropertyPaymentReceiptupload.do?id="+id+"&propertyId="+propertyId,
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
	function docDownload(filesPath) {
 	    var encodedFilePath = encodeURIComponent(filesPath);

 	    var encodedFilesPath = btoa(encodedFilePath); 

 	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
 	}
/*  	
 	$(document).ready(function() {
 	    var paymentReceipt = '${propertyTaxTransferRegistration.paymentReceipt}';
 	  


 	    if (paymentReceipt !== "") {
 			$('#paymentReceiptidProof').attr('disabled', true);
 	    } else {
 			$('#paymentReceiptidProof').attr('disabled', false);
 	    }
 	    
 	    
 	}); */

</script>
