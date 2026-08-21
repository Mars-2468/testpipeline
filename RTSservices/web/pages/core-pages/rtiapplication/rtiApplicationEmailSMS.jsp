 <%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<%-- <jsp:directive.page import="com.mars.common.utils.Constants;"/> --%>
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
	
%>
<div class="mainHdr">
	<h3>		
	    RTI Application
	    <c:choose>			 
			<c:when test="${not empty actionOnFile && actionOnFile eq 'sms'}">
				- SMS
			</c:when>
			<c:when test="${not empty actionOnFile && actionOnFile eq 'email'}">
				-  E-Mail	
			</c:when> 
		</c:choose>	
	</h3>
</div>
<div>
	<input type="hidden" id="rtiApplicationId" name="rtiApplicationId" 	value="${rtiApplication.rtiApplicationId}" />				
</div>


<br>	
<div valign="top" id="SetFormHeight">
	<div id="SearchDivId" class="ClsSearch">
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			RTI Application Details<br>
		</div>
		<br>
		 <%@include file="/pages/core-pages/rtiapplication/rtiApplicationDetails.jsp"%>
		<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
		</script>
	</div>
</div>

		<c:choose>
		
			<c:when test="${not empty actionOnFile && actionOnFile eq 'email'}">
							<%@include file="/pages/core-pages/rtiapplication/sendEmail.jsp"%>
			</c:when>
			<c:when test="${not empty actionOnFile && actionOnFile eq 'sms'}">
						<%@include file="/pages/core-pages/rtiapplication/sendMessage.jsp"%>	
			</c:when>		 		 	
		</c:choose>

 


<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/>
<input type="hidden" id="tenancyId" name="tenancyId" value="${rtiApplication.tenancy.tenancyId}" />

<input type="hidden" id="rtiApplicationDetailsId" name=rtiApplicationDetailsId value="${rtiApplicationDetails.rtiApplicationDetailsId}" />
<input type="hidden" id="rtiApplicationDetailsWF_Level" name="rtiApplicationDetailsWF_Level" value="${rtiApplicationDetails.workflowLevel}" />
<input  type="hidden" id="isAssignedToOther" name="isAssignedToOther" value="0" >
	
<!-- <input type="hidden" id="inspectionTransactionName" name="inspectionTransactionName" value=" " />
<input type="hidden" id="inspectionFinalStatus" name="inspectionFinalStatus" value=" " />
<input type="hidden" name="isAccepted" id="isAccepted" value="False"> -->
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

<script type="text/javascript">
$(document).ready(function() { 
    $('.main').css("height","auto");
});
</script>
<script type="text/javascript">

	 
	
	function sendSMS(frm){
		/* var unParkedRemarks=document.getElementById("unParkedRemarks").value;
		if(unParkedRemarks == null || unParkedRemarks == '' ){
			alert('Please Enter Remarks to Activate Parked File');
			return false;
		}
		else{
			navigate(frm,'<c:out value="${contextRoot}"/>/filecreation/activateParkedFile.do'); 
		} */
	}
 
 

</script>
	


