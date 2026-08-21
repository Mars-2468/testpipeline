<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils" /> 
<jsp:directive.page import="com.mars.rti.utils.CoreConstants" />
<%pageContext.setAttribute("RTI_STATUS_PENDING", CoreConstants.RTI_STATUS_PENDING);%>
<%pageContext.setAttribute("RTI_STATUS_ACTIVE", CoreConstants.RTI_STATUS_ACTIVE);%>
<%pageContext.setAttribute("RTI_STATUS_FORWARD", CoreConstants.RTI_STATUS_FORWARD);%>
<%pageContext.setAttribute("RTI_STATUS_VERIFIED", CoreConstants.RTI_STATUS_VERIFIED);%>
<%pageContext.setAttribute("RTI_STATUS_ACCEPTED", CoreConstants.RTI_STATUS_ACCEPTED);%>

<div style="padding: 10px;">
	<span class="ClsSubmenuTitle"><fmt:message key="rtiApplication.manage.label.forwardingActions"/></span>
	<table class="formTable" border="0" width="40%">
	</table>
</div>

	<table>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.department"/></span><span class="ClsRequiredFields">*</span>
			</td>
			<td>
				<select name="forwardingDepartmentId" id="forwardingDepartmentId" class="ClsTextbox" onchange="getusersOnDepartment(this.value);">
				<option value=""> <--- Select ---> </option>
					<c:forEach var="department" items="${requestScope.departmentList}">
					<c:choose>
						<c:when test="${rtiApplication.forwardingDepartment.departmentId==department.departmentId}">
							<option value="${department.departmentId}" selected="selected">
							<c:out value="${department.name}"/>
							</option>
						</c:when>
						<c:otherwise>
							<option value="${department.departmentId}">
							<c:out value="${department.name}"/>
							</option>
						</c:otherwise>
					</c:choose>
					</c:forEach>
				</select>
			</td>
			
			<td>
				<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.user"/></span><span class="ClsRequiredFields">*</span></td>
			<td>
				<select name="forwardingUserId" id="forwardingUserId" class="ClsTextbox">
					<option value=""> <--- Select ---> </option>
						<c:forEach var="user" items="${requestScope.userList}">
						<c:choose>
							<c:when test="${rtiApplication.forwardingUser.userId==user.userId}">
								<option value="${user.userId}" selected="selected">
								<c:out value="${user.userName}"/>
								</option>
							</c:when>
							<c:otherwise>
								<option value="${user.userId}">
								<c:out value="${user.userName}"/>
								</option>
							</c:otherwise>
						</c:choose>
						</c:forEach>
					</select>
			</td>
		</tr>


		<tr>
			<td></td>
			<td><input type="button" class="ClsButton" id="forward" name="forward" value="forward" onclick="javascript:forwardApplication('${rtiApplication.rtiApplicationId}');">
				<input type="button" class="ClsButton" id="verify" name="verify" value="verify" onclick="javascript:verifyApplication('${rtiApplication.rtiApplicationId}');">
		</tr>

	</table>
	 
	
	<table border="0" width="100%" class="dataGrid" style="table-layout: fixed">
		<thead>
			<tr class="ClsTRHeaderList">
				<td>
					<span class="ClsLabel"><fmt:message key="rtiApplication.list.label.rtiApplnNumber"/></span>
				</td>
				<td>
					<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.Action"/></span>
				</td>
				<td>
					<span class="ClsLabel"><fmt:message key="rtiApplication.manage.label.user"/></span>
				</td>
				<td>
					<span class="ClsLabel"><fmt:message key="rtiApplication.list.label.dateOfAction"/></span>
				</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="applctnHistory" items="${requestScope.applicationHistory}" >
		<tr>
	       <td>
				<c:out value="${applctnHistory.rtiApplication.rtiApplnNumber}" />
		   </td>
	    
			<td>
				<c:if test="${applctnHistory.status == pageScope.RTI_STATUS_ACTIVE}">
					<c:out value="Created" />
				</c:if>
				<c:if test="${applctnHistory.status == pageScope.RTI_STATUS_FORWARD}">
					<c:out value="Forwarded" />
				</c:if>
			    <c:if test="${applctnHistory.status == pageScope.RTI_STATUS_PENDING}">
					<c:out value="Pending" />
				</c:if>
				<c:if test="${applctnHistory.status == pageScope.RTI_STATUS_ACCEPTED}">
					<c:out value="Accepted" />
				</c:if>
				<c:if test="${applctnHistory.status == pageScope.RTI_STATUS_VERIFIED}">
					<c:out value="Verified" />
				</c:if>
			</td>
		
			<td>
				<c:out value="${applctnHistory.userId}" />
			</td>
			
			<td>
				<c:out value="${applctnHistory.date}" />
			</td>
		
			<%-- <td>
				<c:out value="${applctnHistory.comments}" />
			</td> --%>
		</tr>
	</c:forEach>

	</tbody>
</table>

<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}"	value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>" />


<script type="text/javascript">

function getusersOnDepartment(departmentId){
	CommonServiceDWR.getUsersOnDepartment(departmentId, usersOnDepartment);
}

function usersOnDepartment(dataList){

	var selectElement = document.getElementById("forwardingUserId");
	removeAllOptions(selectElement);
	for(var i=1;i<=dataList.length;i++){
		
		var optn = document.createElement("OPTION");
		optn.text = dataList[i-1].firstName +" "+dataList[i-1].lastName;
		optn.value = dataList[i-1].userId ;
		selectElement.options.add(optn);
	}
} 


function forwardApplication(id) {

	var arrElements = new Array('forwardingDepartmentId','forwardingUserId');

	var arrElementNames = new Array('<fmt:message key="rtiApplication.manage.label.department"/>',
			'<fmt:message key="rtiApplication.manage.label.user"/>');
	 
	 if(checkMandatoryDetailed(arrElements, arrElementNames)){
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/forwardApplication.do');
	 }
}

function verifyApplication(id) {
	onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/verifyApplication.do');
}

</script>


