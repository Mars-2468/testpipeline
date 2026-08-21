<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@page import="com.mars.common.utils.Constants"%> 
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<jsp:directive.include file="/pages/common/include.jsp" /> 
<%@include file="/pages/common/includeTransliterateJS.jsp"%>
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_UI_FORMAT);
	pageContext.setAttribute("SESSION_TOKEN_KEY",	Constants.SESSION_TOKEN_KEY);
	pageContext.setAttribute("STATUS_NO_LABEL",	Constants.STATUS_NO_LABEL);
	pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
	pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
	pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
	
	
	pageContext.setAttribute("WORKFLOW_ACTION",			WorkflowConstants.WORKFLOW_ACTION);
	pageContext.setAttribute("WORKFLOW_ACTION_CREATE_PROCESS",		WorkflowConstants.WORKFLOW_ACTION_CREATE_PROCESS);

	pageContext.setAttribute("WORKFLOW_TRANSISTION",			WorkflowConstants.WORKFLOW_TRANSISTION);
	pageContext.setAttribute("WORKFLOW_ENTITYNAME",			WorkflowConstants.WORKFLOW_ENTITYNAME);
	pageContext.setAttribute("WORKFLOW_ENTITYID",			WorkflowConstants.WORKFLOW_ENTITYID);

	pageContext.setAttribute("WORKFLOW_JOB_ID",			WorkflowConstants.WORKFLOW_JOB_ID);
	pageContext.setAttribute("WORKFLOW_TASK_ID",			WorkflowConstants.WORKFLOW_TASK_ID);
	pageContext.setAttribute("WORKFLOW_COMMENTS",			WorkflowConstants.WORKFLOW_COMMENTS);
	pageContext.setAttribute("WORKFLOW_DUE_DATE",			WorkflowConstants.WORKFLOW_DUE_DATE);
	pageContext.setAttribute("WORKFLOW_NAME",			WorkflowConstants.WORKFLOW_NAME);
			
	pageContext.setAttribute("APPL_STATUS_NEW",CoreConstants.APPL_STATUS_NEW);
	pageContext.setAttribute("APPL_STATUS_CLOSED",CoreConstants.APPL_STATUS_CLOSED);
	 
	pageContext.setAttribute("APPL_ACCEPT_LEVEL",CoreConstants.APPL_ACCEPT_LEVEL);
	pageContext.setAttribute("APPL_VERIFICATION_LEVEL",CoreConstants.APPL_VERIFICATION_LEVEL);
	pageContext.setAttribute("APPL_APPROVAL_LEVEL",CoreConstants.APPL_APPROVAL_LEVEL); 
	
	pageContext.setAttribute("APPL_ACCEPT_TRANSITION",CoreConstants.APPL_ACCEPT_TRANSITION);	
	pageContext.setAttribute("APPL_REVERIFY_TRANSITION",CoreConstants.APPL_REVERIFY_TRANSITION);
	pageContext.setAttribute("APPL_VERIFICATION_TRANSITION",CoreConstants.APPL_VERIFICATION_TRANSITION);
	pageContext.setAttribute("APPL_APPROVAL_TRANSITION",CoreConstants.APPL_APPROVAL_TRANSITION);
	pageContext.setAttribute("APPL_APPROVE_TRANSITION",CoreConstants.APPL_APPROVE_TRANSITION);
	pageContext.setAttribute("APPL_CLOSE_APPLICATION_TRANSITION",CoreConstants.APPL_CLOSE_APPLICATION_TRANSITION);
	pageContext.setAttribute("APPL_DISCARD_APPLICATION",CoreConstants.APPL_DISCARD_APPLICATION);
	
	
%>

<script>
function sendEmail(id)
{
	document.getElementById('manageRTIApplicationId').value=id;
	document.getElementById('actionTaken').value='email'; 
	onPageSubmit('<c:out value="${contextRoot}"/>/emailsms/emailSMS.do');
}

function sendSMS(id)
{
	document.getElementById('manageRTIApplicationId').value=id;
	document.getElementById('actionTaken').value='sms';
	onPageSubmit('<c:out value="${contextRoot}"/>/emailsms/emailSMS.do'); 
}

function createLetter(id){
	document.getElementById('manageRTIApplicationId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/draft/editDraft.do');
} 

function activateParkedRTIApplication(id){
	document.getElementById('manageRTIApplicationId').value=id;
	document.getElementById('actionTaken').value='unPark';
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplicationPark.do');
}

function parkRTIApplication(id){
	document.getElementById('manageRTIApplicationId').value=id;
	document.getElementById('actionTaken').value='park';
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editRTIApplicationPark.do');
}


</script>

<div class="mainHdr">
	<h3>  
	   <c:choose>
	   	<c:when test="${not empty rtiApplication.isRTIAppealApplication && rtiApplication.isRTIAppealApplication==1}">
	   		<fmt:message key="rtiApplication.manage.pagetitle.appeal"/>  -  ${requestScope.workFlowTask.name}
	   	</c:when>
	   	<c:otherwise>
	   		RTI Application-  ${requestScope.workFlowTask.name}	   	
	   	</c:otherwise>
	   </c:choose>	 	   			
	</h3>
</div>
<div>
	<input type="hidden" id="rtiApplicationId" name="rtiApplicationId" 	value="${rtiApplication.rtiApplicationId}" />				
</div>
<input type="hidden" class="ClsTextbox"  id="actionTaken" name="actionTaken" />
<input type="hidden" class="ClsTextbox"  id="manageRTIApplicationId" name="manageRTIApplicationId" />
 
 
 <div id="actionMenuId" style="background-color: #ffffff">		 
		<button type="button" class="btn btn-primary btn-xs" onclick="sendEmail('${rtiApplication.rtiApplicationId}')"  >Send eMail</button>
		<button type="button" class="btn btn-primary btn-xs" onclick="sendSMS('${rtiApplication.rtiApplicationId}')" >Send SMS</button>
		<c:if test="${requestScope.workFlowTask.name eq pageScope.APPL_ACCEPT_LEVEL}">
			<button type="button" class="btn btn-primary btn-xs" onclick="createLetter('${rtiApplication.rtiApplicationId}')"  >Create Draft</button>
		</c:if>
		<c:choose>
			<c:when test="${not empty rtiApplication.isApplicationParked &&  rtiApplication.isApplicationParked == 1}">
				<button type="button" class="btn btn-primary btn-xs" onclick="activateParkedRTIApplication('${rtiApplication.rtiApplicationId}')"  >Activate  Application</button>	
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-primary btn-xs" onclick="parkRTIApplication('${rtiApplication.rtiApplicationId}')"  >Park Application</button>						
			</c:otherwise>
		</c:choose>	
		
		<%-- 	<button type="button" class="btn btn-primary btn-xs"  onclick="generateDraft('${rtiApplication.rtiApplicationId}')"  >Create Draft</button> 
		<c:if test="${fileCreation.finalStatus eq pageScope.APPL_STATUS_CLOSED}">
			<button type="button" class="btn btn-primary btn-xs" onclick="dispatch('${rtiApplication.rtiApplicationId}')"  >Dispatch</button> 
		</c:if>		
		--%>
		<hr>			 
</div>
 
<div valign="top" id="SetFormHeight">
	<div id="SearchDivId" class="ClsSearch">
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			File Details<br>
		</div>
				
		<%@include file="/pages/core-pages/rtiapplication/rtiApplicationDetails.jsp"%>
		
		<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
		</script>
	</div>
</div>
	 
		<hr/><br />
		<div id="listFileCreationAction">
			<%@include file="/pages/core-pages/rtiapplication/rtiApplicationActions.jsp"%>
		</div>
		<br /><hr/> 
	
 
 
 


<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/>
<input type="hidden" id="tenancyId" name="tenancyId" value="${rtiApplication.tenancy.tenancyId}"  />

<input type="hidden" id="inspectionTransactionName" name="inspectionTransactionName" value=" " />
<input type="hidden" id="inspectionFinalStatus" name="inspectionFinalStatus" value=" " />
<input type="hidden" name="isAccepted" id="isAccepted" value="False">
<input type="hidden" id="uuid" name="uuid" value="" />

<input type="hidden"
	name="<c:out value="${pageScope.WORKFLOW_TRANSISTION}"/>"
	id="<c:out value="${pageScope.WORKFLOW_TRANSISTION}"/>" value="citizen" />
<input type="hidden"
	name="<c:out value="${pageScope.WORKFLOW_COMMENTS}"/>"
	id="<c:out value="${pageScope.WORKFLOW_COMMENTS}"/>"
	value="created by citizen" />

<input type="hidden"
	name="<c:out value="${pageScope.WORKFLOW_ACTION}"/>"
	id="<c:out value="${pageScope.WORKFLOW_ACTION}"/>" value="" />

<%-- <input type="hidden"
	name="<c:out value="${pageScope.WORKFLOW_DUE_DATE}"/>"
	id="<c:out value="${pageScope.WORKFLOW_DUE_DATE}"/>" value="${workflowDueDate}" /> --%>		

<input type="hidden" name="<c:out value="${pageScope.WORKFLOW_NAME}"/>"
	id="<c:out value="${pageScope.WORKFLOW_NAME}"/>"
	value="<c:out value="${requestScope.WORKFLOW_NAME}"/>" />

<input type="hidden"
	name="<c:out value="${pageScope.WORKFLOW_ENTITYNAME}"/>"
	id="<c:out value="${pageScope.WORKFLOW_ENTITYNAME}"/>"
	value="<c:out value="${requestScope.WORKFLOW_ENTITYNAME}"/>" />

<input type="hidden"
	name="<c:out value="${pageScope.WORKFLOW_ENTITYID}"/>"
	id="<c:out value="${pageScope.WORKFLOW_ENTITYID}"/>"
	value="<c:out value="${requestScope.WORKFLOW_ENTITYID}"/>" />

<input type="hidden"
	name="<c:out value="${pageScope.WORKFLOW_JOB_ID}" />"
	id="<c:out value="${pageScope.WORKFLOW_JOB_ID}"/>"
	value="<c:out value="${requestScope.WORKFLOW_JOB_ID}"/>" />

<input type="hidden"
	name="<c:out value="${pageScope.WORKFLOW_TASK_ID}"/>"
	id="<c:out value="${pageScope.WORKFLOW_TASK_ID}"/>"
	value="<c:out value="${requestScope.WORKFLOW_TASK_ID}"/>" />


<script> 
		  
$(document).ready(function(){
   $('#dmsUPloadedContent').attr('src', '${contextRoot}/fileupload/showFile.do?uuid='+document.getElementById("viewFirstUploadedFile").value);
});

function viewUploadedFile(dmsDocId)
{
	//alert(1213);
	 $('#dmsUPloadedContent').attr('src', '${contextRoot}/fileupload/showFile.do?uuid='+dmsDocId);
}
</script>

<script>
 
 
function saveFileCreationAndAssignToUser(frm){
	document.getElementById("isAssignedToOther").value='1';
	/* navigate(frm,'<c:out value="${contextRoot}"/>/filecreationVerification/saveFileCreationAction.do'); */
}

function showNoting(noting){
	alert(noting);
}


</script>

<script type="text/javascript">

function saveEntity(){
	var transistionName = document.getElementById('<c:out value="${pageScope.WORKFLOW_TRANSISTION}"/>').value;
	var workflowAction = document.getElementById('<c:out value="${pageScope.WORKFLOW_ACTION}"/>').value; 
	var userId = document.getElementById("userId").value;
	//alert(transistionName+" ------ "+workflowAction);
	
	if(workflowAction=='${pageScope.APPL_DISCARD_APPLICATION}'){		
		document.getElementById("isAssignedToOther").value='0';
		document.getElementById("inspectionTransactionName").value='<c:out value="${pageScope.APPL_DISCARD_APPLICATION}"/>';	
		discardApplication(document.forms[0]);	
	}
	
	else if(transistionName=='${pageScope.APPL_REVERIFY_TRANSITION}'){		
		document.getElementById("isAssignedToOther").value='1';
		document.getElementById("inspectionTransactionName").value='<c:out value="${pageScope.APPL_REVERIFY_TRANSITION}"/>';	
		reVerify(document.forms[0]);		
	}	
		
	else if((userId==null || userId=='') && transistionName != '${pageScope.APPL_CLOSE_APPLICATION_TRANSITION}'){
		alert('Please Select User before Assigning for '+transistionName);
		return false;
	}
	 
	/* 
	if(transistionName=='${pageScope.APPL_ACCEPT_TRANSITION}'){
		alert("Accept");
		document.getElementById("isAccepted").value="True"
		document.getElementById("isAssignedToOther").value='1';
		document.getElementById("inspectionTransactionName").value='<c:out value="${pageScope.APPL_ACCEPT_TRANSITION}"/>';
		//assignForVerification(document.forms[0]);
	} */
	
	else if(transistionName== '${pageScope.APPL_VERIFICATION_TRANSITION}'){
		document.getElementById("isAccepted").value="True"
		document.getElementById("isAssignedToOther").value='1';
		document.getElementById("inspectionTransactionName").value='<c:out value="${pageScope.APPL_VERIFICATION_TRANSITION}"/>';
		assignForVerification(document.forms[0]);
	}
	
	else if(transistionName== '${pageScope.APPL_APPROVAL_TRANSITION}'){
		document.getElementById("isAssignedToOther").value='1';
		document.getElementById("inspectionTransactionName").value='<c:out value="${pageScope.APPL_APPROVAL_TRANSITION}"/>';
		assignForApproval(document.forms[0]);
	}		
	
	else if(transistionName=="${pageScope.APPL_APPROVE_TRANSITION}"){	
		document.getElementById("isAssignedToOther").value='1';
		document.getElementById("inspectionTransactionName").value='<c:out value="${pageScope.APPL_APPROVE_TRANSITION}"/>';
		approveFileAndSendForClosing(document.forms[0]);
	}
	
	else if(transistionName=="${pageScope.APPL_CLOSE_APPLICATION_TRANSITION}"){	
		document.getElementById("isAssignedToOther").value='1';
		document.getElementById("inspectionTransactionName").value='<c:out value="${pageScope.APPL_CLOSE_APPLICATION_TRANSITION}"/>';
		closeFile(document.forms[0]);
	}
	
	else if(transistionName=='${pageScope.APPL_REVERIFY_TRANSITION}'){
	
		document.getElementById("isAssignedToOther").value='1';
		document.getElementById("inspectionTransactionName").value='<c:out value="${pageScope.APPL_REVERIFY_TRANSITION}"/>';	
		reVerify(document.forms[0]);		
	}	
	 
	
}

	function reVerify(frm) {
		navigate(frm,'<c:out value="${contextRoot}"/>/rtiApplicationVerification/reVerify.do');
	}
	
	function discardApplication(frm){
		navigate(frm,'<c:out value="${contextRoot}"/>/rtiApplicationVerification/discard.do');
	}
	
	function assignForVerification(frm){
		navigate(frm,'<c:out value="${contextRoot}"/>/rtiApplicationVerification/assignForVerification.do');
	}


	function assignForApproval(frm) {
		navigate(frm,'<c:out value="${contextRoot}"/>/rtiApplicationVerification/assignForApproval.do');
	}
	
	function approveFileAndSendForClosing(frm) {
		navigate(frm,'<c:out value="${contextRoot}"/>/rtiApplicationVerification/approveAndSendForClosing.do');
	}
	 
	function closeFile(frm) {
		navigate(frm,'<c:out value="${contextRoot}"/>/rtiApplicationVerification/closeRTIApplication.do');
	}
	
	function activateParkedApplication(frm){
		var unParkedRemarks=document.getElementById("unParkedRemarks").value;
		if(unParkedRemarks == null || unParkedRemarks == '' ){
			alert('Please Enter Remarks to Activate Parked File');
			return false;
		}
		else{
			navigate(frm,'<c:out value="${contextRoot}"/>/rtiapplication/activateParkedFile.do'); 
		}
	}
 

</script>
	


