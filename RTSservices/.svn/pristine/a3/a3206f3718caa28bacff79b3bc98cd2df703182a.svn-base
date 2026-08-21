<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:directive.include file="/pages/common/include.jsp" />
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
<script>
function downloads(id,url,type_change) {

	document.getElementById('rtiApplicationRefId').value = id;
	
	alert("Certificate has been generated successfully.");
	
	onPageSubmit('<c:out value="${contextRoot}"/>/rtsApplicationReport/'+url+"?type_change="+type_change);

}

</script>
<div class="mainHdr">
	<h3 style="
    height: 30px;
        font-size: 15px;color:#01293d">
		<fmt:message key="Change In Number Of Beds Application " />
		<c:if test="${requestScope.rtiApplication != null}"> 				
				<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
				</c:if>
	</h3>
</div>
<div class="form" valign="top" id="SetFormHeight">
<input type="hidden" name="id"
		value="${nursingHomeChangesApplication.nhcaId}">
	<table width="98%" border="0" cellpadding="4" cellspacing="2" align="center"
		class="dataForm">
		
		
		<c:if test="${not empty nursingHomeChangesApplication.name}">
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Name (नाव)" />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 180px"
				id="nursingHomeOwner" maxlength="50" name="nursingHomeOwner"
				value="<c:out value="${nursingHomeChangesApplication.name}"/>" /></td>


			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Email Id
							(ईमेल आयडी )" />:</span></td>
			<td colspan="2"><input type="text" class="ClsTextbox" style="width: 180px"
				id="nursingHomeRegNumber" maxlength="50" name="nursingHomeRegNumber"
				value="<c:out value="${nursingHomeChangesApplication.emailId}"/>" /></td>

		</tr>
		
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Mobile No.(मोबाईल क्र.)" />:</span></td>
				<td><input type="text" class="form-control" style="width: 250px;"
				id="ownerName" maxlength="50" name="ownerName"
				value="<c:out value="${nursingHomeChangesApplication.address}"/>" /></td>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Address
							For Correspondence (पत्रव्यवहारासाठी पत्ता)" /><span class="ClsRequiredFields"></span>: </td>
		

<td><textarea class="form-control" style="width: 250px;"
					id="ownerAddress" maxlength="200" name="ownerAddress" rows="2">${nursingHomeChangesApplication.address}</textarea></td>
		</tr>
		
		</c:if>
		
		
		
		
		
		
		<tr>

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Nursing Home Registration Number (नर्सिंग होम नोंदणी क्रमांक)" />:</span></td>
			<td><input type="text" class="ClsTextbox" style="width: 180px"
				id="nursingHomeOwner" maxlength="50" name="nursingHomeOwner"
				value="<c:out value="${nursingHomeChangesApplication.nursingHomeRegNumber}"/>" /></td>


			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Zone No(झोन क्र.)" />:</span></td>
			<td colspan="2"><input type="text" class="ClsTextbox" style="width: 180px"
				id="nursingHomeRegNumber" maxlength="50" name="nursingHomeRegNumber"
				value="<c:out value="${nursingHomeChangesApplication.zoneNo}"/>" /></td>

		</tr>
		<tr>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Place where the nursing home is situated (नर्सिंग होम स्थित असलेले ठिकाण)" />:</span></td>
		<td colspan=""><input type="text" class="ClsTextbox" style="width: 180px"
				id="nursingHomeRegNumber" maxlength="50" name="nursingHomeRegNumber"
				value="<c:out value="${nursingHomeChangesApplication.place}"/>" /></td>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Fees Applicable (शुल्क लागू)" />:</span></td>
		<td colspan="2"><input type="text" class="ClsTextbox" style="width: 180px"
				id="nursingHomeRegNumber" maxlength="50" name="nursingHomeRegNumber"
				value="<c:out value="${nursingHomeChangesApplication.totalFees}"/>" /></td>

</tr>
		
		  <tr>
                       <td colspan="6">
<div 
			style="background-color: #f1f1f1;
    height: 37px;
    padding: 7px 10px 11px;
    font-style: italic;  font-size: 17px;color:#01293d"">
			<h6>Number of beds sanctioned to the hospital (रूग्णालयासाठी मंजूर खाटांची संख्या)</h6>
			</div>
			</td>

                     </tr>
		<tr>
		<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="For Maternity Patients (प्रसूती रुग्णांसाठी)" />:</span><span
				class="ClsRequiredFields"></span></td>
			
				<td ><input type="text" class="ClsTextbox" style="width: 180px"
				id="sanctionedBedMaternity" maxlength="50"
				name="sanctionedBedMaternity"
				value="<c:out value="${nursingHomeChangesApplication.sanctionedBedMaternity}"/>" />
				&nbsp;</td>

			<td width="25%"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="For Nursing Patients (नर्सिंग रुग्णांसाठी)" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td  colspan="2"><input type="text" class="ClsTextbox" style="width: 180px"
				id="sanctionedBedOther" maxlength="50" name="sanctionedBedOther"
				value="<c:out value="${nursingHomeChangesApplication.sanctionedBedOther}"/>" />
				&nbsp;</td>

			
		</tr>
		
		
		<c:if test="${nursingHomeChangesApplication.myDropdown eq '3'}">
		
		
		    <tr>
			<td colspan="4" style="background-color:  #fcfdfe;"><span
				class="ClsLabel"
				style="height: 37px; font-size: 17px; color: #01293d;font-style: italic;"><fmt:message
						key="Change in Owner/Addition of owner details (मालकामध्ये बदल/मालक तपशील जोडणे)" />:</span>
		</tr>
		
				<c:if test="${nursingHomeChangesApplication.myDropdown1 eq '5'}">
		  <tr>
			<td colspan="4" style="background-color:  #fcfdfe;"><span
				class="ClsLabel"
				style="height: 37px; font-size: 17px; color: #01293d;font-style: italic;"><fmt:message
						key="Existing Owner details (विद्यमान मालक तपशील)" />:</span>
		</tr>
		

	<tr>

			<table colspan="" border="0" cellpadding="2" cellspacing="2"
				id="table1" class="" >
				<tr class="ClsTRHeaderList">
					<td><span class="ClsLabel"><fmt:message key="Sno" /> </span></td>
					<td><span class="ClsLabel"><fmt:message key="Name of Nursing Home Owner" />
					</span></td>
					<td><span class="ClsLabel"><fmt:message
								key="Full Address" /> </span> 
					</td>
					<td><span class="ClsLabel"><fmt:message key="Mobile Number" />
					</span> </td>
					<td><span class="ClsLabel"><fmt:message key="Email Id" />
					</span></td>
					
				</tr>
				
				<c:forEach var="ndc" items="${requestScope.ndc}"
					varStatus="iCount">
					
					<tr class="ClsTRContentListWhite">
						<td><c:out value="${iCount.index+1}" /></td>

						<td>${ndc.changeOwnerName}</td>
						<td>${ndc.changeAddress}</td>
						<td>${ndc.changeMobileNo}</td>
						<td>${ndc.changeEmail}</td>

						
						
					</tr>
				</c:forEach>

				</tr>
		</c:if>
		
						<c:if test="${nursingHomeChangesApplication.myDropdown1 eq '6'}">
		
		  <tr>
			<td colspan="4" style="background-color:  #fcfdfe;"><span
				class="ClsLabel"
				style="height: 37px; font-size: 17px; color: #01293d;font-style: italic;"><fmt:message
						key="Addition of Owner  Details (मालक तपशील जोडणे)" />:</span>
		</tr>
		
		<tr>

			<table colspan="" border="0" cellpadding="2" cellspacing="2"
				id="table1" class="" >
				<tr class="ClsTRHeaderList">
					<td><span class="ClsLabel"><fmt:message key="Sno" /> </span></td>
					<td><span class="ClsLabel"><fmt:message key="Name of Nursing Home Owner" />
					</span></td>
					<td><span class="ClsLabel"><fmt:message
								key="Full Address" /> </span> 
					</td>
					<td><span class="ClsLabel"><fmt:message key="Mobile Number" />
					</span> </td>
					<td><span class="ClsLabel"><fmt:message key="Email Id" />
					</span></td>
					
				</tr>
				
				<c:forEach var="nod" items="${requestScope.nod}"
					varStatus="iCount">
					
					<tr class="ClsTRContentListWhite">
						<td><c:out value="${iCount.index+1}" /></td>

						<td>${nod.additionOwnerName}</td>
						<td>${nod.additionAddress}</td>
						<td>${nod.additionMobileNo}</td>
						<td>${nod.email}</td>

						
						
					</tr>
				</c:forEach>

				</tr>
		
		
		
		
		</c:if>
		</c:if>
		
		
		
		
		
		<c:if test="${nursingHomeChangesApplication.myDropdown eq '4'}">
		 <tr>
                       <td colspan="6">
<div 
			style="background-color: #f1f1f1;
    height: 37px;
    padding: 7px 10px 11px;
    font-style: italic;  font-size: 17px;color:#01293d"">
			<h6>Total Modified Number of Beds (बेडची एकूण सुधारित संख्या)</h6>
			</div>
			</td>

                     </tr>
		<tr>


<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="For Maternity Patients (प्रसूती रुग्णांसाठी)" />:</span><span
				class="ClsRequiredFields"></span></td>
			
			<td><input type="text" class="ClsTextbox" style="width: 180px"
				id="changeBedMaternity" maxlength="50" name="changeBedMaternity"
				value="<c:out value="${nursingHomeChangesApplication.changeBedMaternity}"/>" />
				&nbsp;</td>
			
			

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="For Nursing Patients (नर्सिंग रुग्णांसाठी)" />:</span><span
				class="ClsRequiredFields"></span></td>
			<td colspan="2"><input type="text" class="ClsTextbox" style="width: 180px"
				id="changeBedOther" maxlength="50" name="changeBedOther"
				value="<c:out value="${nursingHomeChangesApplication.changeBedOther}"/>" />
				&nbsp;</td>

		</tr>
		
		
		</c:if>
		
		
		
		
		
		
			<c:if test="${requestScope.rtiApplication.workFlowStatus==2}">

									<tr>
										<td colspan="4" align="center"><a
											class="bg-button btn btn-success bd-highlight generateaction"
											id="genCerBtn" style="color: white"
											onclick="downloads('${nursingHomeChangesApplication.rti_ref_id}', 'nurisngHomeChangeInApplication.do','${nursingHomeChangesApplication.myDropdown}');"
											type="button" target="_blank"> <span class="download"
												style="display: flex; align-items: center;">Generate
													Certificate</span>
										</a> <a class="bg-button btn btn-success bd-highlight action"
											style="color: white" id="dsc" type="button" target="_blank"
											onclick="download1(${nursingHomeChangesApplication.rti_ref_id});return false;"><span
												class="download" style="align-items: center">Apply
													DSC</span></a></td>


									</tr>
								</c:if>
		
		
		
		
		
	
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
		
		 <tr><td colspan="6"></td></tr>       
                        
                   <tr>

                        <td colspan="6" style="background-color: white;background-color: #c5ddfe;"><span class="ClsLabel"
				style="
    height: 37px;
    padding: 7px 10px 11px;
       font-size: 17px;color:#01293d;font-style: italic;"><fmt:message
						key="List of Documents (Attachment) For Change In Beds (बेडमधील बदलासाठी कागदपत्रांची यादी (संलग्नक))" />:</span></td>
			                    <c:set var="doc" value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
		
		
		                                        <c:if test="${doc[0] != 'null'}">
		
                        <tr>
                        
                        <td colspan="2">
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Degree Certificate (पदवी प्रमाणपत्र)" />:</span>
                        </td>
                       
                        <td colspan="4">
                           
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[0]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>                   </td>
                        </tr>
                        </c:if>
                        
            <c:if test="${doc[1] != 'null'}">
                        
                   <tr>
                        
                      <td colspan="2">
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Additional Qualification Certificate (अतिरिक्त पात्रता प्रमाणपत्र)" />:</span>
                        </td>
                        
                        <td colspan="4">
                           
<a class="bg-button btn btn-primary bd-highlight action"
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
                             <td colspan="2">
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="M.M.C Certificate (M.M.C प्रमाणपत्र)" />:</span>
                        </td>
                        
                        <td colspan="4">
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[2]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                            
                        </td>
                         </tr>
                         
                        </c:if>
                        
                        
                      <c:if test="${doc[3] != 'null'}">
                         <tr>
                        <td colspan="2">
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Aadhaar Card (आधार कार्ड)" />:</span>
                        </td>
                      
                      
                        <td colspan="4">
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[3]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                            
                        </td>
                        </tr>
                        
                      </c:if>
                      
                      
                       <c:if test="${doc[4] != 'null'}">
                   <tr>
                        
                      <td colspan="2">
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="PAN Card (पॅन कार्ड)" />:</span>
                        </td>
                        
                        <td colspan="4">
                           
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[4]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>                       
                        </td>
                        </tr>
                        
                      </c:if>
                      
                    <c:if test="${doc[5] != 'null'}">
                        <tr>
                             <td colspan="2">
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Appointment Letter (नियुक्ती पत्र)" />:</span>
                        </td>
                        
                        <td colspan="4">
                           
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[5]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                        </td>
                        
      </tr>
      </c:if>
      
       <c:if test="${doc[6] != 'null'}">
      
       <tr>
                             <td colspan="2">
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Affidavit (प्रतिज्ञापत्र)" />:</span>
                        </td>
                        
                        <td colspan="4">
                           
<a class="bg-button btn btn-primary bd-highlight action"
   type="button"
   target="_blank"
   onclick="docDownload('${doc[6]}');">
   <span class="download" style="align-items: center;color:white;">Download</span>
</a>
                        </td>
                        
      </tr>
      		 	<table colspan="" border="0" cellpadding="2" cellspacing="2"
				id="table1" class="">
				<tr>
		<c:if test="${requestScope.rtiApplication.workFlowStatus!=5}">
				
    
    <c:choose>
                <c:when test="${empty nursingHomeChangesApplication.mhoRemark and requestScope.forLogin eq 'L3' and not empty nursingHomeChangesApplication.hqdoc}">
        <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="Remark for Approval HQ Report  (मंजुरीसाठी टीप HQ अहवाल)" />:</span>
    </td>
            <td style="text-align: center;">
            <textarea class="form-control" style="width: 310px;margin-left: 182px;"
					id="approvalRemark" maxlength="200" name="approvalRemark" rows="2">${nursingHomeChangesApplication.mhoRemark}</textarea></td>
            
               
        </c:when>
        <c:when test="${not empty nursingHomeChangesApplication.mhoRemark}">
        <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="Remark for Approval HQ Report  (मंजुरीसाठी टीप HQ अहवाल)" />:</span>
    </td>
            <td style="text-align: center;">
               <textarea class="form-control" style="width: 310px;margin-left: 182px;"
					id="approvalRemark" maxlength="200" name="approvalRemark" rows="2" readonly>${nursingHomeChangesApplication.mhoRemark}</textarea></td>
            
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>
</tr>




<tr>
				
    
    <c:choose>
                <c:when test="${empty nursingHomeChangesApplication.hQRemark and requestScope.forLogin eq 'L3' and not empty nursingHomeChangesApplication.hqdoc and not empty nursingHomeChangesApplication.zmodoc}">
        <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="Remark for Approval ZMO Report (मंजुरीसाठी टीप ZMO अहवाल)" />:</span>
    </td>
            <td style="text-align: center;">
            <textarea class="form-control" style="width: 310px;margin-left: 182px;"
					id="approvalRemark1" maxlength="200" name="approvalRemark1" rows="2">${nursingHomeChangesApplication.hQRemark}</textarea></td>
            
               
        </c:when>
        <c:when test="${not empty nursingHomeChangesApplication.hQRemark}">
        <td>
        <span class="ClsLabel" style="font-size: 14px; width: 400px;"><fmt:message key="Remark for Approval ZMO Report (मंजुरीसाठी टीप ZMO अहवाल)" />:</span>
    </td>
            <td style="text-align: center;">
               <textarea class="form-control" style="width: 310px;margin-left: 182px;"
					id="approvalRemark1" maxlength="200" name="approvalRemark1" rows="2" readonly>${nursingHomeChangesApplication.hQRemark}</textarea></td>
            
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>
</tr>
      
</c:if>
	<table colspan="" border="0" cellpadding="2" cellspacing="2"
				id="table1" class="">
				
				<tr>
			<td colspan="10" style="background-color: white;background-color: #c5ddfe;"><span class="ClsLabel"
				style="
    height: 27px;
    padding: 7px 10px 11px;
       font-size: 17px;color:#01293d;font-style: italic;"><fmt:message
						key="Reports (अहवाल)" />:</span></td>
			</tr>
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px;"><fmt:message
							key="HQ Report (
HQ अहवाल)" />:</span> 
				<td style="text-align: center" colspan="3.5">
					<input type="file" class="imagefile" name="idProof" id="hquploadfile" style="width: 220px" />
			</td>
                   <td>   
                      <c:if test="${ empty nursingHomeChangesApplication.hqdoc}">   
               
                <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="hqupload" type="button" target="_blank" onclick="javascript:hqUpload(this);"><span
							class="download" style="align-items: center">Upload</span></a>
               
                </c:if>
              <c:if test="${ not empty nursingHomeChangesApplication.hqdoc}">
              
             
							<a class="bg-button btn btn-success bd-highlight action"
type="button"
target="_blank"
onclick="docDownload('${nursingHomeChangesApplication.hqdoc}');">
<span class="download" style="align-items: center;color:white;">Download</span>
</a>
               </c:if>
</td>


			</tr>
			
			
			<tr>
				<td colspan="3.5"><span class="ClsLabel"
					style="font-size: 14px"><fmt:message
							key="ZMO Report (
ZMO अहवाल)" />:</span> 
				<td style="text-align: center" colspan="3.5">
					<input type="file" class="imagefile" name="idProof" id="zmouploadfile" style="width: 220px" />
			</td>
                   <td>   
                      <c:if test="${ empty nursingHomeChangesApplication.zmodoc}">   
               
                <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="zmoupload" type="button" target="_blank" onclick="javascript:zmoUpload(this);"><span
							class="download" style="align-items: center">Upload</span></a>
               
                </c:if>
              <c:if test="${ not empty nursingHomeChangesApplication.zmodoc}">
       
              
              				<a class="bg-button btn btn-success bd-highlight action"
type="button"
target="_blank"
onclick="docDownload('${nursingHomeChangesApplication.zmodoc}');">
<span class="download" style="align-items: center;color:white;">Download</span>
</a>
               </c:if>
</td>


			</tr>		
					<c:if test="${requestScope.forLogin eq 'L3'}"		>

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
			</table>
			</c:if>
      </table>
   </div>

<input type="hidden" class="ClsTextbox" id="nhcaId"
	style="width: 180px" name="nhcaId"
	value="<c:out value="${nursingHomeChangesApplication.nhcaId}"/>" />
<input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId"
	value="" />
<input type="hidden" id="rtiApplicationRefIds"
	name="rtiApplicationRefIds" value="${nursingHomeChangesApplication.rti_ref_id}" />
	<input type="hidden" id="responseData" name="responseData"
								value="" />
<%@include file="/pages/workflow/taskInclude.jsp"%>

<script type="text/javascript">
function saveEntity()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/createNursingHomeChanges.do');
}


function saveFees() {
    var approvalRemark = $('#approvalRemark').val();
    var approvalRemark1 = $('#approvalRemark1').val();
	var mhoRemark='${nursingHomes.mhoRemark}';
    if (approvalRemark !== '') {
 
	    if(mhoRemark!==""){
	    	if(approvalRemark1 === ''){
	    	
	    		alert("Please enter remarks!!.");
	            return false;
	    	}
	    }
      if (confirm('Are you sure you want to save?')) {

          onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveChangeInBedsMhoRemark.do');
        } else {
            return false;
        }
    } else {
        alert("Please enter remarks!!.");
        return false;
    }
}
</script>

<script type="text/javascript">
    
    
    function hqUpload() {
        console.log("@@upoading@@");
      
        var data = new FormData();
        var idProofFile = $("#hquploadfile").get(0).files[0];
        if (!idProofFile) {
            alert("Please upload the HQ document.");
            return; 
        }
        var fileName = idProofFile.name;
        var fileExtension = fileName.split('.').pop().toLowerCase();

        if (fileExtension !== 'pdf') {
            alert("Please select a PDF file.");
            return;
        }
        data.append('idProof1', $("#hquploadfile").get(0).files[0]);

        var appType = 2;
        var uid1 = document.getElementById('nhcaId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadnursingdoc.do?appType="+appType+"&UID="+uid1,
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

        });
    </script>
    
    	<script type="text/javascript">
    function hqUpload() {
        console.log("@@upoading@@");

        var data = new FormData();
        var idProofFile = $("#hquploadfile").get(0).files[0];
        if (!idProofFile) {
            alert("Please upload the Report.");
            return;
        }
        var fileName = idProofFile.name;
        var fileExtension = fileName.split('.').pop().toLowerCase();

        if (fileExtension !== 'pdf') {
            alert("Please select a valid PDF file.");
            return;
        }
        data.append('idProof1', $("#hquploadfile").get(0).files[0]);

        var appType = 2;
        var uid1 = document.getElementById('nhcaId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadchangenursingdoc.do?appType=" + appType + "&UID=" + uid1,
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
                    alert("Upload has been failed!");
                }
            }
        });
    }
</script>
<script type="text/javascript">
    function zmoUpload() {
        console.log("@@upoading@@");
        var data = new FormData();
        var idProofFile = $("#zmouploadfile").get(0).files[0];
        if (!idProofFile) {
            alert("Please upload the Report.");
            return;
        }
        var fileName = idProofFile.name;
        var fileExtension = fileName.split('.').pop().toLowerCase();
        if (fileExtension !== 'pdf') {
            alert("Please select a valid PDF file.");
            return;
        }
        data.append('idProof1', $("#zmouploadfile").get(0).files[0]);
        var appType = 3;
        var uid1 = document.getElementById('nhcaId').value;
        $.ajax({
            url: "<c:out value='${contextRoot}'/>/rtsapplication/uploadchangenursingdoc.do?appType=" + appType + "&UID=" + uid1,
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
                    alert("Upload has been failed!");
                }
            }
        });
    }

    
    $(document).ready(function() {
    	var hqdoc = '${nursingHomeChangesApplication.hqdoc}';
    	var zmodoc = '${nursingHomeChangesApplication.zmodoc}';
    	var mhoRemark='${nursingHomeChangesApplication.mhoRemark}';
    	var hQRemark='${nursingHomeChangesApplication.hQRemark}';
    	var userId = <%= request.getAttribute("userId") %>;
    	var executeSecondIf = true; // Initialize the variable
    	var forLogin = '${requestScope.forLogin}';
	    var workflowStatus="${requestScope.rtiApplication.workFlowStatus}";


	    if(workflowStatus!=='5'){
    	if(mhoRemark!=='' && hQRemark!==''){
    		$('#savefees').hide();

    	}else{
    		$('#approvalRemark').prop('disabled',false);
    		$('#approvalRemark1').prop('disabled',false);
    	    if((hqdoc!=="" && mhoRemark==="") || (zmodoc!=="" && hQRemark==="")) {
    		$('#savefees').prop('disabled',false);
    		}else{
    			$('#savefees').hide();
    		}

    	}
    	if (hqdoc && hqdoc.trim() !== "" && mhoRemark!=='') {
    	    $("#hquploadfile").prop('disabled', true);
    	} else if(forLogin==='L1'  && mhoRemark!==''){
    	    $("#hquploadfile").prop('disabled', false);
    	}else{
    	    $("#hquploadfile").prop('disabled', true);

    	
    	}

    	if (zmodoc && zmodoc.trim() !== "" && mhoRemark!=='') {
    	    $("#zmouploadfile").prop('disabled', true);
    	} else if(forLogin==='L2' && (hqdoc &&hqdoc.trim() !== "" && mhoRemark !=='')){
    	    $("#zmouploadfile").prop('disabled', false);
    	}else{
    	    $("#zmouploadfile").prop('disabled', true);

    	}

        if((hqdoc!=="" || hQRemark==="") && forLogin==='L3'){
    	    var elements = document.getElementsByClassName("tab")[0];

    	    if((hqdoc!=="" && mhoRemark==="") || (zmodoc!=="" && hQRemark==="")) {
    	    	 elements.innerHTML = "You don't have permission to send demand, but you can reject the application.".fontcolor("red");
    	    	    $('#commentsDisable *').attr('disabled', false);
    	    	    $('#CreateWorkflow').attr('disabled', true);
    	    	    $('#RejectCreateWorkflow').attr('disabled', false);
    	    	    $('#WORKFLOW_COMMENTS').attr('disabled', false);
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
    	    	    $('#savefees').hide();
    	    }
    	   
    	}


        if (forLogin == 'L4' && (hqdoc==='' || zmodoc==='') ) {
            $("#hquploadfile").prop('disabled', true);
            if(mhoRemark!=='' && hqdoc &&hqdoc.trim() !== ""){
            $("#zmouploadfile").prop('disabled', false);
            }
            $("#hqupload").prop('disabled', true);
            $("#zmoupload").prop('disabled', false);
            $("#hqupload").attr('disabled', true);
            var elements = document.getElementsByClassName("tab")[0];
            if(hqdoc!=='' && mhoRemark!==""){
    			elements.innerHTML = "Please upload ZMO report".fontcolor("green");

            }else{
    			elements.innerHTML = "You don't have Permission".fontcolor("red");

            }
	    	$('#commentsDisable *').attr('disabled', true);
	    	$('#CreateWorkflow').attr('disabled', true);
	    	$('#RejectCreateWorkflow').attr('disabled', true);
	    	$('#WORKFLOW_COMMENTS').attr('disabled', true);

			$('#genCerBtn').hide();
			$('#dsc').hide();
			$('#commentsDisable *').addClass("not-active");
			$('#descriptionDisabled *').attr('disabled', true);
			$('#descriptionDisabled *').addClass("not-active");
			$('#uuid').removeAttr('disabled');
			//$('#SetFormHeight a').attr("onclick","javascript:void(0)");
			$('.mainHdr a').attr("onclick","javascript:void(0)");
			<c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
				document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick","javascript:void(0);");
				document.getElementById('workflow_tras_${taskTransitionName}').removeAttribute("style");
			</c:forEach>
			//Disable the Discard Workflow icon also if the task is not owned
			document.getElementById('KillWorkflow').setAttribute("onclick","javascript:void(0);");
			document.getElementById('KillWorkflow').removeAttribute("style");
			$('#savefees').hide();


        } else if (forLogin == 'L1' && (hqdoc==='' || zmodoc==='')) {
        	 //if(mhoRemark!==''){
                 $("#hquploadfile").prop('disabled', false);
                 //}
            $("#zmouploadfile").prop('disabled', true);
            $("#hqupload").prop('disabled', false);
            $("#zmoupload").prop('disabled', true);
            $("#zmoupload").attr('disabled', true);
            var elements = document.getElementsByClassName("tab")[0];
     	   
            if(hqdoc!=="" && hQRemark!==""){
            	 elements.innerHTML = "Currently, you don't have permission to send demand.".fontcolor("red");
           	    $('#commentsDisable *').attr('disabled', true);
           	    $('#CreateWorkflow').attr('disabled', true);
           	    $('#RejectCreateWorkflow').attr('disabled', true);
           	    $('#WORKFLOW_COMMENTS').attr('disabled', true);
            }else  if((hqdoc===''|| zmodoc==='') && hQRemark!=='' ){
            	    elements.innerHTML = "Currently, you don't have permission to send demand, but you can reject the application.".fontcolor("red");
              	    $('#commentsDisable *').attr('disabled', false);
              	    $('#CreateWorkflow').attr('disabled', true);
              	    $('#RejectCreateWorkflow').attr('disabled', false);
              	    $('#WORKFLOW_COMMENTS').attr('disabled', false);
            }else if((hqdoc===''|| zmodoc!=='')){
            	 elements.innerHTML = "Currently, you don't have permission to send demand, but you can reject the application.".fontcolor("red");
           	    $('#commentsDisable *').attr('disabled', false);
           	    $('#CreateWorkflow').attr('disabled', true);
           	    $('#RejectCreateWorkflow').attr('disabled', false);
           	    $('#WORKFLOW_COMMENTS').attr('disabled', false);
            }else{
            	elements.innerHTML = "Currently, you don't have permission to send demand.".fontcolor("red");
           	    $('#commentsDisable *').attr('disabled', true);
           	    $('#CreateWorkflow').attr('disabled', true);
           	    $('#RejectCreateWorkflow').attr('disabled', true);
           	    $('#WORKFLOW_COMMENTS').attr('disabled', true);
            }
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
        
        
       
      	
      	if ((forLogin==='L3') && workflowStatus!=='1') {
      		var elements = document.getElementsByClassName("tab")[0];
			elements.innerHTML = "You don't have Permission".fontcolor("red");
  		    $('#commentsDisable *').attr('disabled', true);
  		    $('#CreateWorkflow').attr('disabled', true);
  		    $('#RejectCreateWorkflow').attr('disabled', true);
  		    $('#WORKFLOW_COMMENTS').attr('disabled', true);
  		    $('#mHORemark').attr('readonly',true);
			$('#genCerBtn').hide();
			$('#dsc').hide();
			$('#commentsDisable *').addClass("not-active");
			$('#descriptionDisabled *').attr('disabled', true);
			$('#descriptionDisabled *').addClass("not-active");
			//$('#SetFormHeight a').attr("onclick","javascript:void(0)");
			$('.mainHdr a').attr("onclick","javascript:void(0)");
			<c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
				document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick","javascript:void(0);");
				document.getElementById('workflow_tras_${taskTransitionName}').removeAttribute("style");
			</c:forEach>
			//Disable the Discard Workflow icon also if the task is not owned
			document.getElementById('KillWorkflow').setAttribute("onclick","javascript:void(0);");
			document.getElementById('KillWorkflow').removeAttribute("style");
			$('#savefees').hide();

      		
      	}
      	
      	if(forLogin==='L1' && hQRemark===""){
      		var elements = document.getElementsByClassName("tab")[0];
        	elements.innerHTML = "Currently, you don't have permission to send demand.".fontcolor("red");
  		    $('#commentsDisable *').attr('disabled', true);
  		    $('#CreateWorkflow').attr('disabled', true);
  		    $('#RejectCreateWorkflow').attr('disabled', true);
  		    $('#WORKFLOW_COMMENTS').attr('disabled', true);
  		    $('#mHORemark').attr('readonly',true);

  		  $('#genCerBtn').hide();
			$('#dsc').hide();
			$('#commentsDisable *').addClass("not-active");
			$('#descriptionDisabled *').attr('disabled', true);
			$('#descriptionDisabled *').addClass("not-active");
			//$('#SetFormHeight a').attr("onclick","javascript:void(0)");
			$('.mainHdr a').attr("onclick","javascript:void(0)");
			<c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
				document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick","javascript:void(0);");
				document.getElementById('workflow_tras_${taskTransitionName}').removeAttribute("style");
			</c:forEach>
			//Disable the Discard Workflow icon also if the task is not owned
			document.getElementById('KillWorkflow').setAttribute("onclick","javascript:void(0);");
			document.getElementById('KillWorkflow').removeAttribute("style");
      	}

        if(hqdoc!=="" && hQRemark!=="" && forLogin==='L3' && workflowStatus!=='1' ){
        	var elements = document.getElementsByClassName("tab")[0];
			elements.innerHTML = "You don't have Permission".fontcolor("red");
  		    $('#commentsDisable *').attr('disabled', true);
  		    $('#CreateWorkflow').attr('disabled', true);
  		    $('#RejectCreateWorkflow').attr('disabled', true);
  		    $('#WORKFLOW_COMMENTS').attr('disabled', true);
  		    $('#mHORemark').attr('readonly',true);
  		  $('#genCerBtn').hide();
			$('#dsc').hide();
			$('#commentsDisable *').addClass("not-active");
			$('#descriptionDisabled *').attr('disabled', true);
			$('#descriptionDisabled *').addClass("not-active");
			//$('#SetFormHeight a').attr("onclick","javascript:void(0)");
			$('.mainHdr a').attr("onclick","javascript:void(0)");
			<c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
				document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick","javascript:void(0);");
				document.getElementById('workflow_tras_${taskTransitionName}').removeAttribute("style");
			</c:forEach>
			//Disable the Discard Workflow icon also if the task is not owned
			document.getElementById('KillWorkflow').setAttribute("onclick","javascript:void(0);");
			document.getElementById('KillWorkflow').removeAttribute("style");
        }
        
        if(hqdoc!=="" && zmodoc!=="" && forLogin==='L4' && workflowStatus!=='1' ){
        	var elements = document.getElementsByClassName("tab")[0];
			elements.innerHTML = "You don't have Permission".fontcolor("red");
  		    $('#commentsDisable *').attr('disabled', true);
  		    $('#CreateWorkflow').attr('disabled', true);
  		    $('#RejectCreateWorkflow').attr('disabled', true);
  		    $('#WORKFLOW_COMMENTS').attr('disabled', true);
  		    $('#mHORemark').attr('readonly',true);
  		  $('#genCerBtn').hide();
			$('#dsc').hide();
			$('#commentsDisable *').addClass("not-active");
			$('#descriptionDisabled *').attr('disabled', true);
			$('#descriptionDisabled *').addClass("not-active");
			//$('#SetFormHeight a').attr("onclick","javascript:void(0)");
			$('.mainHdr a').attr("onclick","javascript:void(0)");
			<c:forEach var="taskTransitionName" items="${WORKFLOW_TRANSISTIONS}" varStatus="iCount">
				document.getElementById('workflow_tras_${taskTransitionName}').setAttribute("onclick","javascript:void(0);");
				document.getElementById('workflow_tras_${taskTransitionName}').removeAttribute("style");
			</c:forEach>
			//Disable the Discard Workflow icon also if the task is not owned
			document.getElementById('KillWorkflow').setAttribute("onclick","javascript:void(0);");
			document.getElementById('KillWorkflow').removeAttribute("style");
        }
        
	    }else{
	    	 var elements = document.getElementsByClassName("tab")[0];
			    elements.innerHTML = "Application has been Rejected".fontcolor("red");
			    $('#commentsDisable *').attr('disabled', true);
		       $('#CreateWorkflow').attr('disabled', true);
		       $('#CreateWorkflow').attr('disabled', true);
		       $('#RejectCreateWorkflow').attr('disabled', true);
		       $('#WORKFLOW_COMMENTS').attr('disabled', true);
	    }
    });


 	function docDownload(filesPath) {
 	    var encodedFilePath = encodeURIComponent(filesPath);

 	    var encodedFilesPath = btoa(encodedFilePath); 

 	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
 	}
    
</script>





