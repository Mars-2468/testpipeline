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

		<fmt:message key="Application form for Property Tax Utara" />
		:
		<c:if test="${requestScope.rtiApplication != null}">
			<c:out value="${requestScope.rtiApplication.rtiApplnNumber}"></c:out>
		</c:if>

	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<input type="hidden" name="id"
		value="${propertyTaxAssessment.propertyTaxUtaraId}">
	<c:set var="doc"
		value="${fn:split(rtiApplication.pdfUploadFromPortal, ',')}" />
	<table width="100%" border="0" cellpadding="2" cellspacing="2">
		<tr>
		<tr>

			

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Name(नाव)" />:</span><span class="ClsRequiredFields"></span></td>
			<td colspan="2">
                         <input type="text" class="form-control" style="width: 300px"
						id="applicantLastName" maxlength="50" name="firstName"
						value="<c:out value="${propertyTaxAssessment.firstName}"/>" disabled/>
						
			</td>
			
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Mobile Number (मोबाईल क्र.)" />:</span></td>
			<td colspan="2">
					<input type="text" class="form-control" style="width: 300px"
						id="ph_no" maxlength="50" name="ph_no"
						value="<c:out value="${propertyTaxAssessment.mobileNo}"/>" disabled/>
				</td>
		</tr>
		


			
			


		<tr>

		

			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Email Id(ईमेल आयडी)" /></span><span class="ClsRequiredFields"></span></td>
			<td colspan="2">
					<input type="text" class="form-control" id="email"
						style="width: 300px" name="email"
						value="<c:out value="${propertyTaxAssessment.email}"/>" disabled/>
				</td>
				<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Name of Property
							Holders/Occupants (मालमत्ताधारक/ भोगवटादारांचे नाव)" /><span class="ClsRequiredFields"></span>:
			</td>
			<td colspan="2"><input type="text" class="form-control" style="width: 300px"
				id="changedHospitalNameAndAddress" maxlength="30"
				name="changedHospitalNameAndAddress"
				value="<c:out value="${propertyTaxAssessment.holdersName}"/>" disabled/></td>
		</tr>
		<tr>
			<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="UPIN No. (UPIN क्र.)" /></span><span class="ClsRequiredFields"></span>
			</td>
			<td colspan="2">
					<input type="text" class="form-control" id="dob"
						style="width: 300px" name="dob"
						value="<c:out value="${propertyTaxAssessment.upinNo}"/>" disabled/>
				</td>
<td><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Index No.
							(निर्देशांक क्र.)" />:</span></td>
			<td colspan="2">

					<input type="text" class="form-control" style="width: 300px"
						id="childeName" maxlength="45" tabindex="3" name="childeName"
						value="<c:out value="${propertyTaxAssessment.indexNo}"/>" disabled/>
			</td>
			
		</tr>
		<!-- <tr>

			

			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Zone No. (झोन
							क्र.)" /></span><span class="ClsRequiredFields">:</span>
			</td>
			<td colspan="2">
					<input type="text" class="form-control" style="width: 180px"
						id="fatherName" maxlength="45" tabindex="4" name="fatherName"
						value="<c:out value="${propertyTaxAssessment.zoneNo}"/>" disabled/>
				</td>
<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="Ward No. (प्रभाग क्र.)" />:</span></td>
			<td colspan="2">

					<input type="text" class="form-control" style="width: 180px"
						id="childeName" maxlength="45" tabindex="3" name="childeName"
						value="<c:out value="${propertyTaxAssessment.wardNo}"/>" disabled/>
			</td>
		</tr>
		-->
			
		
		
		
		<tr>
			<td colspan="1.5"><span class="ClsLabel" style="font-size: 14px">
					Current Status:</span></td>
			<td style="width: 230px; height: 30px"><span class="ClsLabel" style="font-size:14px;color:forestgreen;"><c:if
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
					
			<%--<td>
                            <span class="ClsLabel" style="font-size:14px"><fmt:message key="Birth Place" />:</span>
                        </td>
                         <td> <span class="ClsLabel" style="font-size:14px"><fmt:message key="Remark" />:</span></td>
                        <td >
                            
                                <input type="text" class="ClsTextbox_mr" style="width:180px" id="Remark" maxlength="12" name="Remark" value=""  />
                            
                        </td>
                         --%>
		</tr>
		</table>
	<table width="100%" border="0" cellpadding="2" cellspacing="2">

		<tr>
			<td colspan="7"><span class="ClsLabel" style="font-size: 14px"><fmt:message
						key="List of Documents (Attachment) दस्तऐवजांची यादी (संलग्नक)" />:</span></td>
		</tr>
<td colspan="6"
										style="background-color: white; background-color: #c5ddfe;"><span
										class="ClsLabel"
										style="height: 37px; padding: 7px 10px 11px; font-size: 17px; color: #01293d; font-style: italic;"><fmt:message
												key="List of Documents (Attachment) For Property Tax Utara" />:</span></td>



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
		
	

	</table>

	<input type="hidden" class="ClsTextbox_mr" style="width: 180px"
		id="propertyAssessmentID" maxlength="12" name="propertyAssessmentID"
		value="<c:out value="${propertyTaxAssessment.propertyTaxUtaraId}"/>" /> 

			  <input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="" />
			  			  <input type="hidden" id="rtiApplicationRefIds" name="rtiApplicationRefIds" value="${propertyTaxAssessment.rti_ref_id}" />
			  

</table>
	<%-- <%@include file="/pages/workflow/taskInclude.jsp"%> --%>

</div>
</div>

<!-- <script type="text/javascript">
	function saveEntity() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/createPropertyTaxAssessment.do');
	}
	</script> -->
	<script>
	function docDownload(filesPath) {
 	    var encodedFilePath = encodeURIComponent(filesPath);

 	    var encodedFilesPath = btoa(encodedFilePath); 

 	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
 	}
	</script>
