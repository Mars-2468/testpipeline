<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("BOOLEAN_TRUE_LABEL",
			Constants.BOOLEAN_TRUE_LABEL);
	pageContext.setAttribute("BOOLEAN_FALSE_LABEL",
			Constants.BOOLEAN_FALSE_LABEL);
	pageContext.setAttribute("SESSION_TOKEN_KEY",
			Constants.SESSION_TOKEN_KEY);
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
    background: #496da3;
    font-weight: bold;
    color: white;
}


.btn-secondary {
    color: #ffffff;
    background: #9b9b9b;
}
.btn-secondary:hover {
    color: #ffffff;
    background: #8c8c8c;
}
.btn-secondary:focus, .btn-secondary.focus {
    box-shadow: 0 0 0 0.2rem rgba(194, 194, 194, 0.25);
    background: #8c8c8c;
}
.btn-secondary.disabled, .btn-secondary:disabled {
    color: #ffffff;
    background-color: #adadad;
}
.btn-secondary:not(:disabled):not(.disabled):active, .btn-secondary:not(:disabled):not(.disabled).active {
    color: #ffffff;
    background: #adadad;
}
.show > .btn-secondary.dropdown-toggle {
    color: #ffffff;
    background: #adadad;
}
</style>
<div class="mainHdr">
	<h3>
		<c:choose>
			<c:when
				test="${workflowTemplateUserMapping.workflowTemplateUserMappingId==0}">
				<fmt:message key="workflowTemplateUserMapping.manage.pagetitle.new" />
			</c:when>
			<c:otherwise>
				<fmt:message key="workflowTemplateUserMapping.manage.pagetitle.edit" />
			</c:otherwise>
		</c:choose>
	</h3>
</div>

<div valign="top" id="SetFormHeight" class="boxshadowBorder">
	<table border="0" cellpadding="2" cellspacing="2" class="dataForm" width="100%">
		<tr style="display: none;">
			<td colspan="2"><spring:bind
					path="workflowTemplateUserMapping.workflowTemplateUserMappingId">
					<input type="hidden" id="workflowTemplateUserMappingId"
						name="workflowTemplateUserMappingId"
						value="<c:out value="${workflowTemplateUserMapping.workflowTemplateUserMappingId}"/>" />
				</spring:bind></td>
		</tr>
		<tr>
			<td><span class="form-label"
				style="font-weight: bold; font-size: 13px;"><fmt:message
						key="workflowTemplateUserMapping.manage.label.workflowTemplate" />:</span><span
				class="ClsRequiredFields">*</span></td>
			<td><spring:bind
					path="workflowTemplateUserMapping.workflowTemplate.workflowTemplateId">
					<select name="workflowTemplateId" id="workflowTemplateId"
						style="width: 280px" class="form-select">
						<option value="">-Select-</option>
						<c:forEach var="workflowTemplate"
							items="${requestScope.workflowTemplateList}">
							<c:choose>
								<c:when
									test="${workflowTemplateUserMapping.workflowTemplate.workflowTemplateId==workflowTemplate.workflowTemplateId}">
									<option value="${workflowTemplate.workflowTemplateId}"
										selected="selected">
										<c:out value="${workflowTemplate.workflowTemplateName}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${workflowTemplate.workflowTemplateId}">
										<c:out value="${workflowTemplate.workflowTemplateName}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</spring:bind></td>
		</tr>
		<tr>
			<td><span class="form-label"
				style="font-weight: bold; font-size: 13px;"><fmt:message
						key="workflowTemplateUserMapping.manage.label.area" />:</span><span
				class="ClsRequiredFields">*</span></td>
			<td><spring:bind path="workflowTemplateUserMapping.area.areaId">
					<select name="areaId" id="areaId" style="width: 280px"
						class="form-select">
						<option value="">-Select-</option>
						<c:forEach var="area" items="${requestScope.areaList}">
							<c:choose>
								<c:when
									test="${workflowTemplateUserMapping.area.areaId==area.areaId}">
									<option value="${area.areaId}" selected="selected">
										<c:out value="${area.name}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${area.areaId}">
										<c:out value="${area.name}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</spring:bind></td>
		</tr>
<%-- <!-- Start of +/- DIv -->

		<tr>
			<td colspan="4">
				&nbsp;
				<span class="ClsSubmenuTitle"> <input type="button" class="ClsButton" style="height:20px;width:20px;border:0px" id="add" name="Add" value="+" onclick="addPreviousRowToTable('dtls');">
					<input type="button" class="ClsButton" style="height:20px;width:20px;border:0px" id="remove" name="Remove" value="-" onclick="removeNewRowFromTable('dtls',<c:out value="${requestScope.rowsize}"/>);">&nbsp;
			</td>
		</tr> --%>
		<c:if
			test="${workflowTemplateUserMapping.workflowTemplateUserMappingId!=0}">

			<tr>
				<td colspan="4"
				style="padding-top: 5px; font-size: 18px; font-weight: bold;"
				height="10px"><span class="form-lable"><fmt:message
							key="workflowtemplateusermapping.manage.pagetitle.deatils" /> </span></td>
			</tr>
			
			<tr>
				<td colspan="4">
					<table border="1" bordercolordark="white" cellpadding="2"
						cellspacing="2" width="98%" id="dtls" class="dataGrid">
						<thead>
							<tr class="ClsTRHeaderList">
								<td style="width: 10%"><span class="form-label"
				style="font-weight: bold; font-size: 13px;">
									<fmt:message key="workflowTemplateTask.list.label.level" />
								</span></td>
								<td style="width: 30%"><span class="form-label"
				style="font-weight: bold; font-size: 13px;">
									<fmt:message key="workflowTemplateTask.manage.label.assigneePlaceHolder" />
								</span></td>
								<%-- <td style="width: 30%" >
									<span class="ClsLabel"><fmt:message key="employee.manage.label.Tenancy" /> </span>							
								</td> --%>								
								<td style="width: 30%"><span class="form-label"
				style="font-weight: bold; font-size: 13px;">
									<fmt:message key="workflowTemplateUserMappingDetails.manage.label.user"/>
								</span> <span class="ClsRequiredFields">*</span></td>
							</tr>
						</thead>
						<tbody id="tbodyName" name="tbodyName">
							<c:forEach var="workflowTemplateTask" items="${workflowTemplateUserMapping.workflowTemplate.workflowTemplateTaskSet}" varStatus="iCount">
								<c:if test="${workflowTemplateTask.tenancy != null}">
									<tr class="ClsTRContentListWhite">
										<td><c:out value="${workflowTemplateTask.level}" /></td>
										<td><c:out value="${workflowTemplateTask.assigneePlaceHolder}" /></td>
<%-- 										<td><c:out value="${workflowTemplateTask.defaultUserName}" /></td> 
 --%>											<%-- <td><c:out value="${iCount.index+1}" /></td>
								<td>
									<input type="text" style="width: 200px"  class="ClsTextbox" id="assigneePlaceHolder" maxlength="50" name="assigneePlaceHolder"  value=""/>


									<select class="form-select " id="assigneePlaceHolder"
									name="assigneePlaceHolder" style="width: 290px; height: 45px;">

										<option value="">-Select-</option>

										<option value="SendDemand">SendDemand</option>

										<option value="CloseApplication">CloseApplication</option>




								</select> --%>

								</td>
										<%-- <td>
											<input type="hidden" id="tenancyId" name="tenancyId" value="<c:out value="${workflowTemplateTask.tenancy.tenancyId}" />"/>
											<c:out value="${workflowTemplateTask.tenancy.name}" />
										</td> --%>
										<td><c:set var="flag" value="1" />
											<c:forEach var="workflowTemplateUserMappingDetails"
												items="${requestScope.workflowTemplateUserMapping.workflowTemplateUserMappingDetailsSet}">	
												<c:if test="${workflowTemplateTask.workflowTemplateTaskId eq workflowTemplateUserMappingDetails.workflowTemplateTask.workflowTemplateTaskId}">
													<c:set var="flag" value="0" />
													<select class="form-select" style="width: 280px;margin-left: 2px;" id="userName" name="userName" >
														<option value="">-Select-</option>	
														<c:forEach var="user" items="${requestScope.userList}">
															<c:choose>
																<c:when
																	test="${workflowTemplateUserMappingDetails.userName == user.userName}">
																	<option value="<c:out value="${user.userName}"/>"
																		selected="selected">
																		<%-- <c:out value="${user.firstName}" />
																		<c:out value="${user.lastName}" /> --%>
																		<c:out value="${user.userName}" />
																		
																	</option>
																</c:when>
																<c:otherwise>
																	<option value="<c:out value="${user.userName}"/>">
																	<%-- 	<c:out value="${user.firstName}" />
																		<c:out value="${user.lastName}" /> --%>
																		<c:out value="${user.userName}" />
																	</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
													<input type="hidden" id="workflowTemplateUserMappingDetailsId"
														name="workflowTemplateUserMappingDetailsId"
														value="<c:out value="${workflowTemplateUserMappingDetails.workflowTemplateUserMappingDetailsId}"/>" />
												</c:if>
											</c:forEach> <c:if test="${flag eq 1}">
											<select class="form-select" style="width: 280px;margin-left: 2px;" id="userName" name="userName"
												style="width: 340px">
												<option value="">-Select User-</option>
												<c:forEach var="user" items="${requestScope.userList}">
													<option value="<c:out value="${user.userName}"/>">
														<%-- <c:out value="${user.firstName}" />
														<c:out value="${user.lastName}" /> --%>
														<c:out value="${user.userName}" />
													</option>
												</c:forEach>
											</select>
											<input type="hidden"
												id="workflowTemplateUserMappingDetailsId"
												name="workflowTemplateUserMappingDetailsId" value="0" />
											</c:if>
										</td>		
										<td style="display: none"><input type="hidden"
											id="workflowTemplateTaskId" name="workflowTemplateTaskId"
											style="width: 340px" class="ClsTextbox"
											value="<c:out value="${workflowTemplateTask.workflowTemplateTaskId}"/>" />
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</td>
			</tr>

		</c:if>
		<tr style="display: none">
			<td colspan="2" style="padding-top: 5px"></td>
		</tr>


		<tr align="center">
			
			<td colspan="4"><input type="button" class="btn btn-success"
					style="min-height: 30px; min-width: 80px; color: white; border: none; outline: none;" id="save" name="save"
				value="Save"
				onclick="javascript:saveWorkflowTemplateUserMapping(this.form);">
				<input type="button" class="btn btn-secondary"
					style="min-height: 30px; min-width: 80px;  color: white;border: none; outline: none;" id="clear" name="clear"
				value="Clear" onclick="javascript:clearContorls();"> <c:if
					test="${workflowTemplateUserMapping.workflowTemplateUserMappingId!=0}">
					<input type="button" class="btn btn-danger"
					style="min-height: 30px; min-width: 80px; color: white; border: none; outline: none;" id="delete" name="delete"
						value="Delete"
						onclick="javascript:deleteWorkflowTemplateUserMapping(this.form);">
				</c:if>
		</tr>
	</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}"
	value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>" />
<script type="text/javascript">
	function saveWorkflowTemplateUserMapping(frm) {
		var arrRequiredElements = new Array('workflowTemplateId', 'areaId');
		var arrRequiredElementsMessages = new Array(
				'<fmt:message key="workflowTemplateUserMapping.manage.label.workflowTemplate"/>',
				'<fmt:message key="workflowTemplateUserMapping.manage.label.area"/>');
		if (checkMandatoryDetailed(arrRequiredElements, arrRequiredElementsMessages)) {
			if (validateUsers())
				navigate(frm,'<c:out value="${contextRoot}"/>/workflowtemplateusermapping/saveWorkflowTemplateUserMapping.do');
		}
	}
</script>
<script type="text/javascript">
	function deleteWorkflowTemplateUserMapping(id) {
		if (confirmDelete()) {
			onPageSubmit('<c:out value="${contextRoot}"/>/workflowtemplateusermapping/deleteWorkflowTemplateUserMapping.do');
		}
	}

	function validateUsers() {
		if (navigator.appName == "Microsoft Internet Explorer")
			Vfori = 0;
		else
			Vfori = 1;
		var tableObj = document.getElementById("tbodyName");

		if (tableObj != null) {
			for (var i = 0; i < tableObj.rows.length; i++)
			{
				var user = tableObj.rows[i].cells[2].childNodes[Vfori].value;
				//var headOffUser = tableObj.rows[i].cells[3].childNodes[Vfori].value;
				if (user == null || user == '' || user == ' ' || user.length == 0) {
					displayError("In Level " + (i + 1) + " ,Please Select The User !!!!");
					return false;
				}
			}
		}
		return true;
	}
	
</script>