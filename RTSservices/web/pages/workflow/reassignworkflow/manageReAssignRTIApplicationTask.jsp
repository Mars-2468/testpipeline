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
	    <c:choose>
		   	<c:when test="${not empty rtiApplication.isRTIAppealApplication && rtiApplication.isRTIAppealApplication==1}">
		   		<fmt:message key="rtiApplication.manage.pagetitle.appeal"/> 
		   	</c:when>
		   	<c:otherwise>
		   		RTI Application 	
		   	</c:otherwise>
	    </c:choose>
	       Re-Assign Task 
		 
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
	
	
	<%-- <div>
		<%@include file="/pages/core-pages/filecreation/fileCreationActions.jsp"%>
	</div> --%>
	<br />


</div>

		<c:choose>
		
			<c:when test="${not empty actionOnFile && actionOnFile eq 'email'}">
							<%@include file="/pages/core-pages/rtiapplication/sendEmail.jsp"%>
			</c:when>
			<c:when test="${not empty actionOnFile && actionOnFile eq 'sms'}">
						<%@include file="/pages/core-pages/rtiapplication/sendMessage.jsp"%>	
			</c:when>
		
			<c:when test="${not empty actionOnFile && actionOnFile eq 'park'}">
			
				<table width="80%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
					<tr>
						<td width="15%"><span class="ClsLabel">Parking Remarks</span>
								<span class="ClsRequiredFields">*</span>
						</td>
						<td width="30%">
							 <textarea class="ClsTextarea" id="parkedRemarks"  rows="4" style="width: 260px;"
								name="parkedRemarks"></textarea>
						</td>	
						<td width="13%"> 
							 Reminder Date<span class="ClsRequiredFields">*</span>
						</td>
						<td width="15%"> 
							<input type="text" class="ClsTextboxDate" readonly="readonly"  id="reminderDate" name="reminderDate" />
						</td>
						<td> 
							
										<input type="button" class="ClsButton" id="save" name="save"
								value="Park File" onclick="javascript:parkFile(this.form);">
										 
						</td>		
					</tr>					
				</table>			
			</c:when>
			<c:when test="${not empty actionOnFile && actionOnFile eq 'unPark'}">
				<table width="75%" border="0" cellpadding="2" cellspacing="2" class="dataForm" align="center">
					 <tr>
						<td width="25%"><span class="ClsLabel">Remarks to Activate Parked File</span>
								<span class="ClsRequiredFields">*</span>
						</td>
						<td width="35%">
							 <textarea class="ClsTextarea" id="unParkedRemarks"  rows="4" style="width: 260px;"
								name="unParkedRemarks"></textarea>
						</td>						
						<td> 
							<input type="button" class="ClsButton" id="save" name="save"
										value="Activate Parked File" onclick="javascript:activateParkedFile(this.form);">
						</td>		
					</tr>
					<tr>
						<td colspan="3">
								<%@include file="/pages/common-pages/dms/manageDmsAttachments.jsp"%> 								
						</td>
					</tr>
			
				</table>	
			</c:when>
			<c:otherwise>
			 <table width="99%" border="0" cellpadding="2" cellspacing="2" class="dataForm">			
					<tr>
						<td >
								<%@include file="/pages/workflow/taskIncludeReAssignRTIApplication.jsp"%>						
						</td>									
					</tr>
			 </table>
			</c:otherwise>		
		</c:choose>



<%-- <br />
	<div id="listFileCreationAction">
		<%@include file="/pages/core-pages/filecreation/fileCreationActions.jsp"%>
	</div>
	<br />
	<hr/><br/>

	<br />

	<%@include file="/pages/common-pages/dms/manageDmsAttachments.jsp"%>
	
	<br /><br /> --%>



<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/>
<input type="hidden" id="tenancyId" name="tenancyId" value="${rtiApplication.tenancy.tenancyId}" />

<input type="hidden" id="rtiApplicationDetailsId" name=rtiApplicationDetailsId value="${rtiApplicationDetails.rtiApplicationDetailsId}" />
<input type="hidden" id="rtiApplicationDetailsWF_Level" name="rtiApplicationDetailsWF_Level" value="${rtiApplicationDetails.workflowLevel}" />
<input  type="hidden" id="isAssignedToOther" name="isAssignedToOther" value="0" >
<input  type="hidden" id="sendToReAssign" name="sendToReAssign" value="0" >


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


	function assignTaskToUser(frm){	
		var userId=document.getElementById("userId").value;
		if( userId==null || userId == '' ||  userId==0){
			alert('Please Select User to Assign Task...');
		}else{
			//document.getElementById("isAssignedToOther").value='1';
			document.getElementById("sendToReAssign").value='1';
			navigate(frm,'<c:out value="${contextRoot}"/>/rtiApplicationVerification/saveRTIApplicationAction.do');
		}	
	}
	
	function parkFile(frm)
	{		
		var parkedRemarks=document.getElementById("parkedRemarks").value;
		var reminderDate=document.getElementById("reminderDate").value;
		if(parkedRemarks == null || parkedRemarks == '' ){
			alert('Please Enter Remarks to Park File');
			return false;
		}
		else if(reminderDate == null || reminderDate == '' ){
			alert('Please Enter Reminder Date to Park File');
			return false;
		}else{
			navigate(frm,'<c:out value="${contextRoot}"/>/filecreation/parkFile.do'); 
		}
	}
	
	function activateParkedFile(frm){
		var unParkedRemarks=document.getElementById("unParkedRemarks").value;
		if(unParkedRemarks == null || unParkedRemarks == '' ){
			alert('Please Enter Remarks to Activate Parked File');
			return false;
		}
		else{
			navigate(frm,'<c:out value="${contextRoot}"/>/filecreation/activateParkedFile.do'); 
		}
	}
 
 

</script>
	


