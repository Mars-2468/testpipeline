<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.workflow.utils.WorkflowConstants"%>

<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("DATE_TIME_DB_FORMAT", Constants.DATE_TIME_DB_FORMAT);

	pageContext.setAttribute("DATE_TIME_FORMAT", WorkflowConstants.WORKFLOW_DATE_FORMAT);
 
 
%>
<script type="text/javascript">
function editDraft(id) { 
	document.getElementById('draftId').value = id;  
	onPageSubmit('<c:out value="${contextRoot}"/>/draft/viewDraft.do');
}  
function searchDraft() { 
	onPageSubmit('<c:out value="${contextRoot}"/>/draft/listDraft.do');
}
</script>

<div class="mainHdr">
	<h3>
		Drafts List
	</h3>
</div>

<div valign="top" id="SetFormHeight">
<div id="tabs">
  <ul>
	<li>
		<a linkindex="1" href="#tabs-1" onclick="Javascript:getPendingTasks();">Draft List</a>
	</li>
	<!-- <li>
		<a linkindex="2" href="#tabs-2" onclick="Javascript:getCompletedTasks();">Completed Tasks</a>
	</li> -->
	
   </ul>

   <div id="tabs-1">
	 
		
		<div id="SearchDivId" class="ClsSearch">
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			Search Drafts 
		</div>
		<br>
		<table id="SearchTable" class="searchForm" border="0" cellpadding="2" cellspacing="1" width="100%" >
			<tr>
				<td width="17%">
					Draft Number
				</td>
				<td width="15%">
					<input type="text" onkeyup="javascript:regNoAutoComplete(event,this.value)" maxlength="50" name="draftNumber" class="ClsTextbox"  id="draftNumber"
					 value="${SearchOptions.draftNumber}"/>
				</td>
				<td width="17%">
					Draft Date
				</td>
				<td width="15%">
                   <input type="text" class="ClsTextboxDate"   id="creationDate" maxlength="30" name="creationDate" value="${SearchOptions.creationDate}"  /> 				 
				</td>
				<td width="17%">
					Application number
				</td>
				<td width="15%">
                   <input type="text" class="ClsTextbox"   id="applicationNumber" maxlength="30" name="applicationNumber" value="${SearchOptions.applicationNumber}"   /> 				 
				</td>
			</tr>    		 
			
			<%-- <tr> 
				<td width="17%">
					Sent Status
				</td>
				<td width="15%">
                   <select class="ClsTextbox" name="sentStatus" id="sentStatus"  >
                   
                   		<option value="">Select</option>
                   		
						<option value="0" <c:if test="${not empty SearchOptions.sentStatus && SearchOptions.sentStatus==0}">selected</c:if> >Created</option>
							
						<option value="1" <c:if test="${not empty SearchOptions.sentStatus && SearchOptions.sentStatus==1}">selected</c:if> >Sent</option>
						 																							
					</select>
				</td>
				<td width="17%">
					Subject
				</td>
				<td colspan="3">
                   <input type="text" class="ClsTextbox"   id="subject" maxlength="30" name="subject" value="${SearchOptions.subject}"   /> 				 
				</td>
				
			</tr> --%>
			
			
			<tr>
				<td colspan="6" align="center">
					<input type="button" class="ClsButton" id="search" name="search" value=" Search Draft " onclick="searchDraft()" />
					<%-- &nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchFileCreation()" />
 					--%>
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
					<td width="70px">
						Draft Number
					</td>
					<td width="70px">
						Computer Number
					</td> 
					<td width="150px">
						Created Date
					</td>					
					<!-- <td width="150px">
						sent Date
					</td> -->
					<td width="55px">
						Send Through
					</td>					 
				</tr>
			</thead>
			<tbody>
			
				<c:choose>
					<c:when test="${not empty requestScope.draftList}">
						<c:forEach var="draft"	items="${requestScope.draftList}" varStatus="rowNumber">
							<tr> 
								<td> 
									<a href="#" onclick="editDraft('${draft.draftId}')">
										 ${draft.draftNumber}	 
									</a> 
								</td>
								<td>
									 ${draft.rtiApplication.rtiApplicationId}
								</td> 			 
								
								<td>
									 ${draft.creationDate}	
								</td>
								<%-- <td>
									${draft.sentDate} 
								</td> --%>
								<td>
									<c:if test="${not empty draft.draftsSentThroughList}">
									  <c:forEach var="draftSentThrough"	items="${draft.draftsSentThroughList}" >
									  	${draftSentThrough.deliveryMode.deliveryModeName},
									  </c:forEach>
									</c:if>
								</td>
								 
							</tr>
						</c:forEach>
				     </c:when>
					<c:otherwise>
					    <tr>
							<td colspan="6"  class="clsNoRecords" >
								No Records Found
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">
						<c:if test="${requestScope.draftList != null }">
						 <span><%@include file="/pages/common/pagination.jsp"%></span>							 
						</c:if>
					</td>
				</tr>
			</tfoot>
		</table>
 
	</div>
	
	<input type="hidden" name="tenancyId" id="tenancyId" value="${tenancyId}">
	<input type="hidden" name="draftId" id="draftId"> 
	<input type="hidden" name="actionTaken" id="actionTaken">
	
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
