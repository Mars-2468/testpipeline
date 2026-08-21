<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>

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
%>
<script type="text/javascript">
function editRTIApplication(id) {
	document.getElementById('manageRTIApplicationId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/reassignworkflow/manageReAssignRTIApplicationTask.do');
}
function  searchRTIApplication() {
	onPageSubmit('<c:out value="${contextRoot}"/>/reassignworkflow/getAllUserTask.do');
}
</script>

<div class="mainHdr">
	<h3>
		<c:out value="${pageHeading}" /></h3>
</div>

<div valign="top" id="SetFormHeight">
<div id="tabs">
  <ul>
	<li>
		<a linkindex="1" href="#tabs-1" onclick="Javascript:getPendingTasks();">Re-Assign Pending Tasks</a>
	</li>
	<!-- <li>
		<a linkindex="2" href="#tabs-2" onclick="Javascript:getCompletedTasks();">Completed Tasks</a>
	</li> -->
	
   </ul>

   <div id="tabs-1">
	<c:if test="${not empty displaymode and displaymode eq 'inbox' }">
		
		<div id="SearchDivId" class="ClsSearch">
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			Search Users Task
		</div>
		<br>
		<table id="SearchTable" class="searchForm" border="0" cellpadding="2" cellspacing="1" width="100%" >
			<tr>
				<td width="17%">
					Application Number
				</td>
				<td width="15%">
					<input type="text" onkeyup="javascript:regNoAutoComplete(event,this.value)" maxlength="30" name="rtiApplicationNumber" class="ClsTextbox"  id="rtiApplicationNumber" value="<c:out value="${SearchOptions.rtiApplicationNumber}"/>" />
				</td>				
				<td width="17%">
					Application  Ref No.
				</td>
				<td width="15%">
                   <input type="text" class="ClsTextbox"  id="receivedFileRefNo" maxlength="30" name="receivedFileRefNo" value="<c:out value="${SearchOptions.receivedFileRefNo}"/>" tabindex="1" /> 				 
				</td>
				<%-- <td width="17%">
					Received File Name
				</td>
				<td width="15%">
                   <input type="text" class="ClsTextbox"  id="receivedFileName" maxlength="30" name="receivedFileName" value="<c:out value="${SearchOptions.receivedFileName}"/>" tabindex="1" /> 				 
				</td> --%>
			</tr>
	 
			<tr>
				<td><span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.department" /></span>
				</td>
				<td>
					<select class="ClsTextbox" name="assignedDepartment" id="assignedDepartment"
						onchange="getToSectionsOnDepartment(this.value);">
						<option value=""><--- Select ---></option>
							<c:forEach var="department" items="${requestScope.departmentList}">
								<option value="${department.departmentId}">
									<c:out value="${department.name}" /></option>							
							</c:forEach>
						</select>			
				</td>	
				<td><span class="ClsLabel"><fmt:message	key="rtiApplication.manage.label.section" /> </span></td>
				<td><select name="assignedSection" id="assignedSection" class="ClsTextbox" onchange="getUsersOnSection(this.value);">
							<option value=""><--- Select Section ---></option>							
					</select>
				</td>	
				<td><span class="ClsLabel"><fmt:message	key="rtiApplication.manage.label.user" /> </span></td>
				<td><select name="assignedUser" id="assignedUser" class="ClsTextbox">
					<option value=""><--- Select User ---></option>					
					</select>
				</td>		
			</tr>
			
			<tr>
				<td width="15%">
					Registration <fmt:message key="search.label.between" />
				</td>
				<td width="25%">
					<input type="text" class="ClsTextboxDate" id="creationFromDate"   maxlength="10" name="creationFromDate" readonly value="${SearchOptions.creationFromDate}" />

					&nbsp;&nbsp;<c:out value="-"/>&nbsp;&nbsp;
					<input type="text" class="ClsTextboxDate" id="creationToDate"    maxlength="10" name="creationToDate" readonly  value="${SearchOptions.creationToDate}"  />
				</td>        	
			</tr>
			
			<tr>
				<td colspan="4" align="center">
					<input type="button" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchRTIApplication()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');javascript:searchRTIApplication()" />

				</td>
			</tr>
		</table>
		<c:if test="${SearchOptions.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>
		
		
		
		
		<table cellpadding="0" cellspacing="0" border="1" width="98%"
			class="dataGrid">
			<thead>
				<tr>
					<td width="2%">
						
					</td>
					<td width="70px">
						Computer Number
					</td>
					<td width="150px">
						RTI Application Number
					</td>
					<td width="150px">
						Registration  Date
					</td>					
					<td width="150px">
						Assigned Date
					</td>
					<td width="55px">
						Pending (In days)
					</td>
					<td >
						Subject
					</td>
				</tr>
			</thead>
			<tbody>
			<c:choose>
					<c:when test="${not empty requestScope.PersonalTasksList}">
						<c:forEach var="personalTasksList"
							items="${requestScope.PersonalTasksList}" varStatus="rowNumber">
							<tr>
								<td align="center">
									<c:choose>
										<c:when
											test="${pageScope.WORKFLOW_PRIORITY_LOW eq personalTasksList.task.priority}">
											<img
												src="<c:out value="${contextRoot}"/>/images/orangeflag.gif"
												alt="Low Priority" title="Low Priority" />
										</c:when>
										<c:when
											test="${pageScope.WORKFLOW_PRIORITY_HIGH eq personalTasksList.task.priority}">
											<img src="<c:out value="${contextRoot}"/>/images/redflag.gif"
												alt="High Priority" title="High Priority" />
										</c:when>
										<c:when
											test="${pageScope.WORKFLOW_PRIORITY_MEDIUM eq personalTasksList.task.priority}">
											<img src="<c:out value="${contextRoot}"/>/images/greenflag.gif"
												alt="Medium Priority" title="Medium Priority"/>
										</c:when>
										<c:otherwise>
											
										</c:otherwise>
									</c:choose><%-- ${personalTasksList.task.priority } --%>
								</td>
								<td>
									
									
									<c:choose>
										 <c:when test="${not empty  personalTasksList.rtiApplication.assignedDepartment.departmentId  
										 						&& personalTasksList.rtiApplication.assignedDepartment.departmentId == user.department.departmentId}">
										 	<a href="javascript:void(0)" onclick="javascript:editRTIApplication('${personalTasksList.rtiApplication.rtiApplicationId}' )">
												 <%-- ${personalTasksList.task.name} --%>
												 ${personalTasksList.rtiApplication.rtiApplicationId}
											</a>
										 </c:when>
										 <c:otherwise>
										 	 ${personalTasksList.rtiApplication.rtiApplicationId}
										 </c:otherwise>
									 </c:choose>
									 
								</td>
								<td>
									${personalTasksList.rtiApplication.rtiApplnNumber}
								</td>
								<td>
									${personalTasksList.rtiApplication.registrationDate}
								</td>						
								<td nowrap="nowrap">
									<%-- <fmt:formatDate var="fmtPersonalTaskStartDate"
										value="${personalTasksList.task.createTime}" type="both"
										dateStyle="full" timeStyle="short"
										pattern="${pageScope.DATE_TIME_FORMAT}" />
									<c:out value="${fmtPersonalTaskStartDate}" /> --%>
									${personalTasksList.rtiApplicationDetails.assignedStartDate}
								</td>
								
								 <td>
									<fmt:formatDate var="fmtPersonalPendingSince"
										value="${personalTasksList.task.createTime}" 
										pattern="${pageScope.DATE_TIME_DB_FORMAT}" />
									
									<%
									 String personalPending=(String)pageContext.getAttribute("fmtPersonalPendingSince");							
									 long pendingDays=0;                           
									 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
									 if((personalPending!=null || personalPending=="")){
										 java.util.Date sd= formatter.parse(personalPending);								 
										 pendingDays = (new java.util.Date().getTime()-sd.getTime())/(24 * 60 * 60 * 1000);	
										 
									 }
							 		%>							
									<%=pendingDays%>	
								</td>
								
								<td>
									<%-- <c:out value="${personalTasksList.task.description}" /> --%>
									${personalTasksList.rtiApplication.subject}
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
					    <tr>
							<td colspan="9"  class="clsNoRecords" >
								No Pending Task To  Re-Assign
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
						
			</tbody>
			<tfoot>
				<tr>
					<td colspan="7">
						<c:if test="${requestScope.PersonalTasksList != null }">
							<span><%@include file="/pages/common/pagination.jsp"%></span>
						</c:if>
					</td>
				</tr>
			</tfoot>
		</table>
	</c:if>
	</div>
	
	<input type="hidden" name="tenancyId" id="tenancyId" value="${tenancyId}">
	<input type="hidden" name="manageRTIApplicationId" id="manageRTIApplicationId">
	
</div>
<script type="text/javascript">


	function getToSectionsOnDepartment(departmentId){
		
		CommonServiceDWR.getSectionsOnDepartment(departmentId, setToSectionsOnDepartment);
		getUsersOnDepartment(departmentId);
	}
	
	function setToSectionsOnDepartment(dataList){
		
		var selectElement = document.getElementById("assignedSection");
		removeAllOptions(selectElement);
		for(var i=1;i<=dataList.length;i++){
			
			var optn = document.createElement("OPTION");
			optn.text = dataList[i-1].name ;
			optn.value = dataList[i-1].sectionId ;
			selectElement.options.add(optn);
		}
	} 
	
	function getUsersOnSection(toSectionId){
		var tenancyId =  document.getElementById("tenancyId").value;
		CommonServiceDWR.getUsersOnSection(toSectionId, tenancyId, setUsersOnSection);
	}
	
	function setUsersOnSection(dataList){
		var selectElement = document.getElementById("assignedUser");
		removeAllOptions(selectElement);
		for(var i=1;i<=dataList.length;i++){
			
			var optn = document.createElement("OPTION");
			optn.text = dataList[i-1].firstName +" "+dataList[i-1].lastName+" - "+dataList[i-1].userName;
			optn.value = dataList[i-1].userId ;
			selectElement.options.add(optn);
		}
	}
	
	
	function getUsersOnDepartment(departmentId){
		var tenancyId =  document.getElementById("tenancyId").value;
		CommonServiceDWR.getUsersOnDepartment(departmentId, tenancyId, setUsersOnDepartment);
	}
	
	function setUsersOnDepartment(dataList){
		var selectElement = document.getElementById("assignedUser");
		removeAllOptions(selectElement);
		for(var i=1;i<=dataList.length;i++){
			
			var optn = document.createElement("OPTION");
			optn.text = dataList[i-1].firstName +" "+dataList[i-1].lastName+" - "+dataList[i-1].userName;
			optn.value = dataList[i-1].userId ;
			selectElement.options.add(optn);
		}
	}	

	
	</script>		
</div>
