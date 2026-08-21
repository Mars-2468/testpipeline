<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("BOOLEAN_TRUE_LABEL", Constants.BOOLEAN_TRUE_LABEL);
	pageContext.setAttribute("BOOLEAN_FALSE_LABEL", Constants.BOOLEAN_FALSE_LABEL);
	pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
	pageContext.setAttribute("ACTIVE_LABEL", Constants.ACTIVE_LABEL);
	pageContext.setAttribute("INACTIVE_LABEL", Constants.INACTIVE_LABEL);
	pageContext.setAttribute("ACTIVE", Constants.ACTIVE);
	pageContext.setAttribute("INACTIVE", Constants.INACTIVE);
%>
<style type="text/css">
.btn-success {
    --bs-btn-color: #fff;
    --bs-btn-bg: #00a659;
    --bs-btn-border-color: #198754;
    --bs-btn-hover-color: #fff;
    --bs-btn-hover-bg: #168b54;	border: none;
	border-radius: 5px;
	min-height: 30px;
	min-width: 120px;
}

.btn-danger {
    --bs-btn-color: #fff;
    --bs-btn-bg: #e61f2c;
    --bs-btn-border-color: #df2d2d;
    --bs-btn-hover-color: #fff;
    --bs-btn-hover-bg: #ee1717;	border: none;
	border-radius: 5px;
	min-height: 30px;
	min-width: 120px;
}
.ClsTRHeaderList {
    background: #678dc5;
    font-weight: bold;
    color: white;
}

.btn-success{ 
width:50px;
height:30px;
font-size: 10px;
}
</style>
<script type="text/javascript">
var y=0;
</script>
<script type="text/javascript">
function getUsersList(id){
	if(y>0){
		y=0;
	}
	y=Number(id.parentNode.parentNode.rowIndex);
	CommonServiceDWR.getUsersListBasedOnDept(id.value,updateUsersList);
}

 function updateUsersList(data){
			  	$("#userName"+y).find('option').remove();
			  	if(data!=null && data.length>0){
			  		$("#userName"+y).append('<option value=""><--- Select User ---> </option>');
			  		for(i=0; i < data.length; i++){
              			$("#userName"+y).append('<option value="'+data[i].userName+'">'+data[i].firstName+" "+data[i].lastName +'</option>');
             		}
			  	}else{
			  		alert("No users defined for selected department");
			  		$("#userName"+y).append('<option value=""><--No Records Found--></option>');
			  	}
		  }


</script>

<div class="mainHdr">
	<h3>
		<c:choose>
			<c:when test="${workflowTemplate.workflowTemplateId==0}">
				<fmt:message key="workflowTemplate.manage.pagetitle.new" />
			</c:when>
			<c:otherwise>
				<fmt:message key="workflowTemplate.manage.pagetitle.edit" />
			</c:otherwise>
		</c:choose>
	</h3>
</div>

<div valign="top" id="SetFormHeight">
	<table border="0" cellpadding="2" cellspacing="2" width="100%"
		class="table table-bordered" align="center">

		<tr style="display: none;">
			<td colspan="2"><spring:bind
					path="workflowTemplate.workflowTemplateId">
					<input type="hidden" class="form-control" id="workflowTemplateId"
						name="workflowTemplateId"
						value="<c:out value="${workflowTemplate.workflowTemplateId}"/>" />
				</spring:bind></td>
		</tr>
		<tr>
			<td><span class="form-label"
				style="font-weight: bold; font-size: 13px;"><fmt:message
						key="workflowTemplate.manage.label.templatename" />:<span
					class="ClsRequiredFields">*</span></td>
			<td><spring:bind path="workflowTemplate.workflowTemplateName">
					<input type="text" style="width: 280px" class="form-control"
						id="workflowTemplateName" maxlength="100"
						name="workflowTemplateName"
						value="<c:out value="${workflowTemplate.workflowTemplateName}"/>" />
				</spring:bind></td>
		</tr>
		<tr>
			<td><span class="form-label"
				style="font-weight: bold; font-size: 13px;"><fmt:message
						key="workflowTemplate.manage.label.status" />:</span><span
				class="ClsRequiredFields">*</span></td>
			<td><spring:bind path="workflowTemplate.status">
					<select style="width: 280px" name="status" id="status"
						class="form-select">
						<c:choose>
							<c:when test="${workflowTemplate.status==pageScope.INACTIVE}">
								<option value="<c:out value="${pageScope.INACTIVE}"/>" selected>
									<c:out value="${pageScope.INACTIVE_LABEL}" />
								</option>
								<option value="<c:out value="${pageScope.ACTIVE}"/>">
									<c:out value="${pageScope.ACTIVE_LABEL}" />
								</option>

							</c:when>
							<c:otherwise>
								<option value="<c:out value="${pageScope.INACTIVE}"/>">
									<c:out value="${pageScope.INACTIVE_LABEL}" />
								</option>
								<option value="<c:out value="${pageScope.ACTIVE}"/>" selected>
									<c:out value="${pageScope.ACTIVE_LABEL}" />
								</option>
							</c:otherwise>
						</c:choose>
					</select>
				</spring:bind></td>
		</tr>

		<!-- Start of +/- DIv -->

		<tr>
			<td colspan="4">&nbsp; <span class="ClsSubmenuTitle"> <input
					type="button" class="btn btn-success"
					style="min-height: 30px; min-width: 80px; color: white; border: none; outline: none;"
					id="add" name="Add" value="Add"
					onclick="addPreviousRowToTable('dtls');"> &nbsp;<input
					type="button" class="btn btn-danger"
						style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #dc3545;width:50px;height:30px;font-size: 10px;"
					name="Remove" value="Remove"
					onclick="removeNewRowFromTable('dtls',<c:out value="${requestScope.rowsize}"/>);">&nbsp;
			</span>
			</td>
		</tr>
		<tr>
			<td colspan="4"
				style="padding-top: 5px; font-size: 18px; font-weight: bold;"
				height="10px"><span class="form-lable"> <fmt:message
						key="workflowtemplate.manage.pagetitle.task" />
			</span></td>
		</tr>
		<tr>
			<td colspan="4">
				<table border="1" bordercolordark="white" cellpadding="2"
					cellspacing="2" width="98%" id="dtls" class="dataGrid"
					align="center">

					<tr class="ClsTRHeaderList">
						<td style="width: 15%"><span class="form-label"
							style="font-weight: bold; font-size: 12px;"><fmt:message
									key="workflowTemplateTask.manage.label.level" /> </span></td>
						<td style="width: 30%;"><span class="form-label"
							style="font-weight: bold; font-size: 12px;"><fmt:message
									key="workflowTemplateTask.manage.label.assigneePlaceHolder" />
						</span> <span class="ClsRequiredFields">*</span></td>
						<%-- <td style="width: 30%"><span class="ClsLabel"><fmt:message
									key="workflowTemplateTask.manage.label.durationInDays" /> </span> <span
							class="ClsRequiredFields">*</span></td> --%>
						<%-- <td style="width: 30%" >
							<span class="ClsLabel"><fmt:message key="employee.manage.label.Tenancy" /> </span>							
						</td>	--%>
						<td style="width: 30%"><span class="form-label"
							style="font-weight: bold; font-size: 12px;"><fmt:message
									key="workflowTemplateTask.manage.label.defaultUser" /> </span> <span
							class="ClsRequiredFields">*</span></td>

					</tr>

					<c:choose>
						<c:when
							test="${requestScope.rowsize != null && requestScope.rowsize > 0}">
							<c:forEach var="workflowTemplateTask"
								items="${workflowTemplate.workflowTemplateTaskSet}"
								varStatus="iCount">
								<c:set var="index" value="${iCount.index % 2 + 1}" />
								<tr class="ClsTRContentListWhite row-${index}">
									<td><c:out value="${workflowTemplateTask.level}" /></td>
									<td><select style="width: 200px" class="form-select"
										id="assigneePlaceHolder" name="assigneePlaceHolder">
											<option value="">-Select an Assignee-</option>
											<option value="SendDemand"
												<c:if test="${workflowTemplateTask.assigneePlaceHolder eq 'SendDemand'}">selected</c:if>>SendDemand</option>
											<option value="CloseApplication"
												<c:if test="${workflowTemplateTask.assigneePlaceHolder eq 'CloseApplication'}">selected</c:if>>CloseApplication</option>
									</select></td>
									        <td style="display:none"><input type="text" class="form-control" id="durationInDays" maxlength="2" name="durationInDays" value="0" /></td>
 
									<td><select name="userName" id="userName"
										class="form-select">
											<option value="">-Select User-</option>
											<c:forEach var="user" items="${requestScope.userList}">
												<c:choose>
													<c:when
														test="${workflowTemplateTask.defaultUserName==user.userName}">
														<option value="${user.userName}" selected="selected">
															<c:out value="${user.firstName}" />
															<c:out value="${user.lastName}" />
														</option>
													</c:when>
													<c:otherwise>
														<option value="${user.userName}">
															<c:out value="${user.firstName}" />
															<c:out value="${user.lastName}" />
														</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
									</select></td>
									<td style="display: none"><input type="hidden"
										id="workflowTemplateTaskId" name="workflowTemplateTaskId"
										value="<c:out value="${workflowTemplateTask.workflowTemplateTaskId}"/>" />
										<input type="hidden" id="level" name="level"
										value="<c:out value="${index}"/>" /></td>
								</tr>
							</c:forEach>
						</c:when>


						<c:otherwise>
							<tr>

								<td><c:out value="${iCount.index+1}" /></td>
								<td>
									<%-- <input type="text" style="width: 200px"  class="ClsTextbox" id="assigneePlaceHolder" maxlength="50" name="assigneePlaceHolder"  value=""/>--%>


									<select class="form-select " id="assigneePlaceHolder"
									name="assigneePlaceHolder" style="width: 290px; height: 45px;">

										<option value="">-Select-</option>

										<option value="SendDemand">SendDemand</option>

										<option value="CloseApplication">CloseApplication</option>




								</select>

								</td>
								 <td style="display: none;"><input type="text" class="form-control"
									id="durationInDays" maxlength="2" name="durationInDays"
									value="0" style="width: 150px" /></td>
								<%-- <td>
									<c:out value="${workflowTemplateTask.tenancy.name}" />
								</td>--%>
								<td><select name="userName" id="userName"
									class="form-select" style="width: 300px; height: 45px;">
										<option value="">-Select User-</option>
										<c:forEach var="user" items="${requestScope.userList}">
											<option value="${user.userName}">
												<c:out value="${user.firstName}" />
												<c:out value="${user.lastName}" />
											</option>
										</c:forEach>
								</select></td>
								<td style="display: none"><input type="hidden"
									id="workflowTemplateTaskId" name="workflowTemplateTaskId"
									value="0" /> <input type="hidden" id="level" name="level"
									value="<c:out value="${iCount.index+1}"/>" /></td>
							</tr>
						</c:otherwise>
					</c:choose>

				</table>
			</td>
		</tr>

		<!-- End of +/- DIv -->
		<tr style="display: none;">
			<td colspan="2" style="padding-top: 5px"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button" class="btn btn-primary"
					style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745;" id="save" name="save" value="Save"
				onclick="javascript:saveWorkflowTemplate(this.form);"> <input
				type="button" class="btn btn-danger"
					style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #dc3545;" id="clear" name="clear"
				value="Clear" onclick="javascript:clearContorls();">
		</tr>
	</table>
	<input type="hidden" name="deleteWorkflowTemplateTaskIds"
		id="deleteWorkflowTemplateTaskIds" value=""> <input
		type="hidden" name="${pageScope.SESSION_TOKEN_KEY}"
		value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>" />
</div>

<script type="text/javascript">

function saveWorkflowTemplate(frm)
{
	var arrRequiredElements=new Array('workflowTemplateName','status');
	var arrRequiredElementsMessages=new Array('<fmt:message key="workflowTemplate.manage.label.templatename"/>','<fmt:message key="workflowTemplate.manage.label.status"/>');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
	{	
		var dropElements = new Array('assigneePlaceHolder','userName');
		var dropElementsNames = new Array('<fmt:message key="workflowTemplateTask.manage.label.assigneePlaceHolder" />','<fmt:message key="workflowTemplateTask.manage.label.defaultUser"/>');

		if(checkAtleastOneChild('selectWorkflowTemplateTask', '<fmt:message key="workflowtemplate.manage.pagetitle.task" />')){
			if(checkChildMandatoryDetailed('dtls',dropElements,dropElementsNames,'<fmt:message key="workflowtemplate.manage.pagetitle.task"/>')){
				<c:if test="${requestScope.rowsize!=null && requestScope.rowsize>0}">
					document.getElementById('deleteWorkflowTemplateTaskIds').value=getSelectedValue('workflowTemplateTaskCheck');
				</c:if>
				navigate(frm,'<c:out value="${contextRoot}"/>/workflowtemplate/saveWorkflowTemplate.do');
			}
		}
	}
}

function deleteWorkflowTemplate(id)
{
	if(confirmDelete()){
		onPageSubmit('<c:out value="${contextRoot}"/>/workflowtemplate/deleteWorkflowTemplate.do');
	}
}
</script>