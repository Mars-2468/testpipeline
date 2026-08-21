<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.common.utils.CommonUtils"%>

<%
	pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
	pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
	pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
	pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
	pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
	pageContext.setAttribute("APPLICATION_ID", Constants.APPLICATION_ID);
%>

<style type="text/css">
.btn-success { -
	-bs-btn-color: #fff; -
	-bs-btn-bg: #00a659; -
	-bs-btn-border-color: #198754; -
	-bs-btn-hover-color: #fff; -
	-bs-btn-hover-bg: #168b54;
	border: none;
	border-radius: 5px;
	min-height: 30px;
	min-width: 120px;
}

.btn-danger { -
	-bs-btn-color: #fff; -
	-bs-btn-bg: #e61f2c; -
	-bs-btn-border-color: #df2d2d; -
	-bs-btn-hover-color: #fff; -
	-bs-btn-hover-bg: #ee1717;
	border: none;
	border-radius: 5px;
	min-height: 30px;
	min-width: 120px;
}

.ClsTRHeaderList {
	background: #678dc5;
	font-weight: bold;
	color: white;
}

.form-control {
	width: 180px;
	height: 30px;
}

.btn-success {
	width: 50px;
	height: 30px;
	font-size: 10px;
}
.ui-datepicker {
width:300px;
    
    padding: .2em .2em 0;
}
.ui-datepicker .ui-datepicker-prev {
    left: -10px;
}
.ui-datepicker table{
margin-left:-8px;
}

.ui-datepicker th {
    padding: 0.7em em 0em 2em;
    text-align: center;
    font-weight: bold;
    border: 0;
}
a {
    margin-left: 10px;
}
.ClsTextboxDate{
font-size: 15px;
width:130px;
height:30px;
}
</style>
<div class="mainHdr">
	<h4 style="font-weight: 100px">
		<c:choose>
			<c:when test="${user.userId==0}">
				<fmt:message key="user.manage.pagetitle.new" />
			</c:when>
			<c:otherwise>
				<fmt:message key="user.manage.pagetitle.edit" />
			</c:otherwise>
		</c:choose>
	</h4>
</div>
<div valign="top" id="SetFormHeight">
	<table border="0" cellpadding="2" cellspacing="2" width="98%"
		class="dataForm">
		<c:set var="isDsble" value=""></c:set>
		<c:set var="isRdOnly" value=""></c:set>
		<%--  <c:choose>
		<c:when test="${pageScope.APPLICATION_ID eq requestScope.applicationId}">
		<c:set var="isDsble" value=""></c:set>
		<c:set var="isRdOnly" value=""></c:set>
		<c:out value="${isDsble}"></c:out>
		</c:when>
		<c:otherwise>
		<c:set var="isDsble" value="disabled"></c:set>
		<c:set var="isRdOnly" value="readOnly"></c:set>
		</c:otherwise>
		</c:choose>
		--%>
		<tr style="display: none;">
			<td colspan="2"><spring:bind path="user.userId">
					<input type="hidden" id="userId" name="userId"
						value="<c:out value="${user.userId}"/>" />
				</spring:bind></td>
		</tr>
		<tr>
			<td><span class="ClsLabel"><fmt:message
						key="user.label.userName" /> </span><span class="ClsRequiredFields">*</span>
			</td>
			<td><spring:bind path="user.userName">
					<input type="text" class="form-control" id="userName"
						name="userName" value="<c:out value="${user.userName}"/>">
				</spring:bind></td>
		</tr>
		<tr>
			<td><span class="ClsLabel"><fmt:message
						key="user.label.password" /></span><span class="ClsRequiredFields">*</span>
			</td>
			<td><spring:bind path="user.password">
					<input type="password" class="form-control" id="password"
						name="password" value="<c:out value="${user.password}"/>">
				</spring:bind></td>
		</tr>
		<!--
		
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="user.label.employee" /> </span><span class="ClsRequiredFields">*</span>
			</td>
			<td>
				<c:out value="${user.firstName}" />&nbsp;<c:out value="${user.lastName}" />
				<spring:bind path="user.firstName">
				<input type="text" class="ClsTextbox"  id="firstName" ${isRdOnly} maxlength="255" name="firstName" value="<c:out value="${user.firstName}"/>" />
				</spring:bind>
				<spring:bind path="user.lastName">
				<input type="text" class="ClsTextbox"  id="lastName" ${isRdOnly} maxlength="255" name="lastName" value="<c:out value="${user.lastName}"/>" />
				</spring:bind>
			</td>
		</tr>
		-->
		<tr>
			<td><span class="ClsLabel"><fmt:message
						key="employee.manage.label.firstName" /> </span><span
				class="ClsRequiredFields">*</span></td>
			<td><spring:bind path="user.firstName">
					<input type="text" class="form-control" id="firstName"
						name="firstName" value="<c:out value="${user.firstName}"/>">
				</spring:bind></td>
		</tr>
		<tr>
			<td><span class="ClsLabel"><fmt:message
						key="employee.manage.label.middleName" /></td>
			<td><spring:bind path="user.middleName">
					<input type="text" class="form-control" id="middleName"
						name="middleName" value="<c:out value="${user.middleName}"/>">
				</spring:bind></td>
		</tr>
		<tr>
			<td><span class="ClsLabel"><fmt:message
						key="employee.manage.label.lastName" /> </span><span
				class="ClsRequiredFields">*</span></td>
			<td><spring:bind path="user.lastName">
					<input type="text" class="form-control" id="lastName"
						name="lastName" value="<c:out value="${user.lastName}"/>">
				</spring:bind></td>
		</tr>
		
		<tr>
			<td><span class="ClsLabel"><fmt:message
						key="Mobile Number" /> </span><span
				class="ClsRequiredFields">*</span></td>
			<td><spring:bind path="user.mobileNumber">
					<input type="text" class="form-control" id="mobileNumber"
						name="mobileNumber" value="<c:out value="${user.mobileNumber}"/>">
				</spring:bind></td>
		</tr>
		
		<tr style="display: none;">
			<td><span class="ClsLabel"><fmt:message
						key="user.label.email" /></span></td>
			<td><spring:bind path="user.email">
					<input type="text" class="form-control" id="email" name="email"
						value="<c:out value="${user.email}"/>">
				</spring:bind></td>
		</tr>
		<tr>
			<td><span class="ClsLabel"><fmt:message
						key="employee.list.label.employeeId" /> </span><span
				class="ClsRequiredFields">*</span></td>
			<td><spring:bind path="user.employeeId">
					<input type="text" class="form-control" id="employeeId"
						name="employeeId" value="<c:out value="${user.employeeId}"/>">
				</spring:bind></td>
		</tr>



		<%-- <tr style="display: none;">
			<td style="display: none;"><span class="ClsLabel"><fmt:message
						key="employee.manage.label.designation" /></span></td>
			<td><spring:bind path="user.designation">
					<input type="hidden" class="form-control" id="designationId"
						name="designationId"
						value="<c:out value="${user.designation.designationId}"/>">
				</spring:bind></td>

		</tr> --%>
		<tr>
			<td><span class="ClsLabel"><fmt:message key="Zone No." /></span></td>
			<td><spring:bind path="user.zone">
					<input type="number" class="form-control" pattern="[1-9]{1}"
						id="zone" name="zone" value="<c:out value="${user.zone}"/>">
				</spring:bind></td>

		</tr>
		
		<tr>
			<td><span class="ClsLabel"><fmt:message key="user.user.level" /></span></td>
			<td><spring:bind path="user.userLevel">
			
		<select id="userLevel" name="userLevel" class="form-control" style="font-size: 12px !important;font-weight: 100;">

						 <option value="" selected> --Select Level-- </option>
			
			 <c:forEach var="departmentLevel" items="${requestScope.departmentLevel}">
<option value="${departmentLevel.userDepartmentLevel}" ${user.userLevel == departmentLevel.userDepartmentLevel ? 'selected' : ''}>
    <c:out value="${departmentLevel.userDepartmentLevel}"></c:out>
</option>
			 </c:forEach>
			 </select>
					
				</spring:bind></td>

		</tr>
		
		<tr>
			<td><span class="ClsLabel"><fmt:message
						key="employee.manage.label.department" /> </span></td>
			<td><spring:bind path="user.department">
					<input type="number" class="form-control" pattern="[1-9]{1}"
						id="departmentId" name="departmentId"
						value="<c:out value="${user.department.departmentId}"/>">
				</spring:bind></td>
		</tr>

		<tr style="display: none;">
			<td><span class="ClsLabel"><fmt:message key="Tenancy Id" />
			</span></td>
			<td><spring:bind path="user.tenancy">
					<input type="hidden" class="form-control" id="tenancyId"
						name="tenancyId" value="1">
				</spring:bind></td>
		</tr>

		<tr style="display: none;">
			<td colspan="2" style="padding-top: 3px"></td>
		</tr>

		<tr>
			<td colspan="2">

				<table border="1" bordercolordark="white" cellpadding="2"
					cellspacing="2" width="100%" class="dataGrid">
					<thead>
						<tr>
							<td><span class="ClsLabel"><fmt:message
										key="application.manage.label.application" /></span></td>
							<%-- <td>
								<span class="ClsLabel"><fmt:message key="application.manage.label.assigned" /></span>
							</td> --%>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="applicationList"
							items="${requestScope.applicationList}">
							<c:set var="selectedAppl" value="" />
							<c:set var="userApplicationId" value="0" />
							<c:forEach var="userApplication"
								items="${user.userApplicationSet}">
								<c:choose>
									<c:when
										test="${userApplication.application.applicationId eq applicationList.applicationId}">
										<c:set var="selectedAppl" value="checked" />
										<c:set var="userApplicationId"
											value="${userApplication.userApplicationId}" />
										<tr>
											<td><input type="text" name="userApplicationId"
												id="userApplicationId"
												value="<c:out value="${userApplicationId}"/>" /> <input
												type="text" name="applicationId" id="applicationId"
												value="<c:out value="${applicationList.applicationId}"/>" />
												<c:out value="${applicationList.name}"></c:out></td>
											<td><input type="checkbox" style="display: none"
												id="applicationIdCheck" ${isDsble} name="applicationIdCheck"
												${selectedAppl} value="${applicationList.applicationId}">
											</td>
										</tr>

									</c:when>
								</c:choose>
							</c:forEach>

						</c:forEach>
					</tbody>
				</table> <%-- <table border="1" bordercolordark="white" cellpadding="2" cellspacing="2" width="100%"  class="dataGrid">
				<thead>
					<tr>
						<td><span class="ClsLabel"><fmt:message key="application.manage.label.application" /></span></td>					
					</tr>
				</thead>
				<tbody>					
					<c:forEach var="applicationList" items="${requestScope.applicationList}">
						<c:set var="userApplicationId" value="0" />
						<c:forEach var="userApplication" items="${user.userApplicationSet}">
							  <c:if test="${userApplication.application.applicationId eq applicationList.applicationId}">
								  <c:set var="userApplicationId" value="${userApplication.userApplicationId}" />
								  <tr>
									<td>
										<input type="hidden" name="userApplicationId" id="userApplicationId" value="<c:out value="${userApplicationId}"/>"/>
										<input type="hidden" name="applicationId" id="applicationId" value="<c:out value="${applicationList.applicationId}"/>"/>
										<c:out value="${applicationList.name}"></c:out>
										
										<input type="hidden" name="userRoleCheck" id="userRoleCheck" value="<c:out value="${userRoleList.userRoleId}"/>" onclick="Toggle(this,'selectUserRoles');" />
										<input type="hidden" id="user.userRoleSet.userRoleId" name="user.userRoleSet.userRoleId" value="<c:out value="${userRoleList.userRoleId}"/>" />
										<input type="hidden" id="applicationIdCheck" name="applicationIdCheck" value="${applicationList.applicationId}">
										
									</td>
									
									
										
																
								</tr>
							  </c:if>
						 </c:forEach>					
					</c:forEach>
				</tbody>
			</table> --%>
			</td>
		</tr>
		<!-- Start of +/- DIv -->
		<tr>
			<td colspan="4">&nbsp; <span class="ClsSubmenuTitle"> <input
					type="button" class="btn btn-success"
					style="min-height: 30px; min-width: 80px; color: white; border: none; outline: none;"
					class="ClsButton" style="height:20px;width:20px;border:0px"
					id="add" name="Add" value="ADD"
					onclick="addPreviousRowToTable('dtls');"> <input
					type="button" class="btn btn-danger"
					style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #dc3545; width: 50px; height: 30px; font-size: 10px;"
					class="ClsButton" style="height:20px;width:20px;border:0px"
					id="remove" name="Remove" value="Remove"
					onclick="removeNewRowFromTable('dtls',<c:out value="${requestScope.rowsize}"/>);">&nbsp;
			</span>
			</td>


		</tr>
		<tr>

			<td colspan="4" style="padding-top: 5px" height="10px"><h4>
					<fmt:message key="user.manage.label.roles" />
				</h4></td>

		</tr>
		<tr>

			<td colspan="4">
				<table border="1" bordercolordark="white" cellpadding="2"
					cellspacing="2" width="100%" id="dtls" class="dataGrid">
					<tr class="ClsTRHeaderList">
						<td><span class="ClsLabel"><fmt:message key="Sr No." />
						</span></td>
						<td><span class="ClsLabel"><fmt:message
									key="user.manage.label.rolename" /> </span> <span
							class="ClsRequiredFields">*</span></td>
						<td><span class="ClsLabel"><fmt:message
									key="user.manage.label.startdate" /> </span> <span
							class="ClsRequiredFields">*</span></td>
						<%--	<td >
							<span class="ClsLabel"><fmt:message key="user.manage.label.enddate" /> </span>
						</td> --%>
						<td style="display: none"></td>
						<td style="display: none"><span class="ClsLabel"><fmt:message
									key="user.manage.label.isdefault" /> </span> <span
							class="ClsRequiredFields">*</span></td>
						<c:if
							test="${requestScope.rowsize!=null && requestScope.rowsize>0}">
							<td width="3%" nowrap style="display: none;"><span
								class="ClsLabel"> <input type="checkbox"
									name="selectUserRoles" id="selectUserRoles"
									onclick="ToggleAll(this,'userRoleCheck');" /> <fmt:message
										key="user.manage.label.delete" />
							</span></td>
						</c:if>
					</tr>

					<c:choose>
						<c:when
							test="${requestScope.rowsize!=null && requestScope.rowsize>0}">
							<c:forEach var="userRoleList" items="${user.userRoleSet}"
								varStatus="iCount">
								<tr class="ClsTRContentListWhite">
									<td><c:out value="${iCount.index+1}" /></td>

									<td><select class="form-select" id="user.userRoleSet.role"
										name="user.userRoleSet.role"
										style="width: 300px; overflow: auto;">
											<option value="">-Select-</option>
											<c:forEach var="roleList" items="${requestScope.roleList}">
												<c:choose>
													<c:when test="${userRoleList.role.roleId==roleList.roleId}">
														<option value="<c:out value="${roleList.roleId}"/>"
															selected="selected">
															<c:out value="${roleList.role_name}" />
														</option>
													</c:when>
													<c:otherwise>
														<option value="<c:out value="${roleList.roleId}"/>">
															<c:out value="${roleList.role_name}" />
														</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
									</select></td>

									<td><input type="text" class="ClsTextboxDate"
										id="user.userRoleSet.userRoleStDate<c:out value="${iCount.index+1}"/>"
										maxlength="10"
										name="user.userRoleSet.userRoleStDate<c:out value="${iCount.index+1}"/>"
										commonName="user.userRoleSet.userRoleStDate" 
										value="<c:out value="${userRoleList.userRoleStDate}"/>"
										isDateControl="true" readonly
										/> </span>
										</div></td>
									


	




									<td style="display: none"><input type="hidden"
										id="user.userRoleSet.userRoleEndDate<c:out value="${iCount.index+1}"/>"
										maxlength="10"
										name="user.userRoleSet.userRoleEndDate<c:out value="${iCount.index+1}"/>"
										commonName="user.userRoleSet.userRoleEndDate"
										value="<c:out value="${userRoleList.userRoleEndDate}"/>"
										isDateControl="true" readonly style="width: 70px" /></td>

									<%-- <td style="display:none">
										<select style="width: 80px" name="user.userRoleSet.isDefault" id="user.userRoleSet.isDefault" class="ClsSelect">
											<c:choose>
												<c:when test="${userRoleList.isDefault==pageScope.STATUS_NO}">
													<option value="<c:out value="${pageScope.STATUS_NO}"/>" selected>
														<c:out value="${pageScope.STATUS_NO_LABEL}" />
													</option>
													<option value="<c:out value="${pageScope.STATUS_YES}"/>">
														<c:out value="${pageScope.STATUS_YES_LABEL}" />
													</option>

												</c:when>
												<c:otherwise>
													<option value="<c:out value="${pageScope.STATUS_NO}"/>">
														<c:out value="${pageScope.STATUS_NO_LABEL}" />
													</option>
													<option value="<c:out value="${pageScope.STATUS_YES}"/>" selected>
														<c:out value="${pageScope.STATUS_YES_LABEL}" />
													</option>
												</c:otherwise>
											</c:choose>
										</select>
									</td> --%>
									<td style="display: none;"><input type="checkBox"
										name="userRoleCheck" id="userRoleCheck"
										value="<c:out value="${userRoleList.userRoleId}"/>"
										onclick="Toggle(this,'selectUserRoles');" /></td>
									<td style="display: none"><input type="hidden"
										id="user.userRoleSet.userRoleId"
										name="user.userRoleSet.userRoleId"
										value="<c:out value="${userRoleList.userRoleId}"/>" /></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td><c:out value="${iCount.index+1}" /></td>
								<td><select id="user.userRoleSet.role"
									name="user.userRoleSet.role" style="width: 300px"
									class="form-select">
										<option value="">-Select-</option>
										<c:forEach var="roleList" items="${requestScope.roleList}">
											<option value="<c:out value="${roleList.roleId}"/>">
												<c:out value="${roleList.role_name}" />
											</option>
										</c:forEach>
								</select></td>
								<td><input type="text" class="ClsTextboxDate"
									id="user.userRoleSet.userRoleStDate1" maxlength="10"
									name="user.userRoleSet.userRoleStDate1"
									commonName="user.userRoleSet.userRoleStDate" value=""
									isDateControl="true" style="width: 150px" /></td>
							
								<td style="display: none"><input type="hidden"
									id="user.userRoleSet.userRoleEndDate1" maxlength="10"
									name="user.userRoleSet.userRoleEndDate1"
									commonName="user.userRoleSet.userRoleEndDate"
									value="<c:out value="${fmtEndDate}"/>" isDateControl="true"
									readonly style="width: 150px" /></td>


								<td style="display: none"><select style="width: 80px"
									name="user.userRoleSet.isDefault"
									id="user.userRoleSet.isDefault" class="ClsTextbox">
										<option value="<c:out value="${pageScope.STATUS_NO}"/>">
											<c:out value="${pageScope.STATUS_NO_LABEL}" />
										</option>
										<option value="<c:out value="${pageScope.STATUS_YES}"/>"
											selected>
											<c:out value="${pageScope.STATUS_YES_LABEL}" />
										</option>
								</select></td>
								<td style="display: none"><input type="hidden"
									id="user.userRoleSet.userRoleId"
									name="user.userRoleSet.userRoleId" value="0" /></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</td>
		</tr>
		<!-- End of +/- DIv -->
		<tr style="display: none;">
			<td colspan="2" style="padding-top: 5px" height="10px"></td>
		</tr>
		<tr>
			<td style="display: none;"></td>
			<td colspan="4" align="center"><input type="button"
				class="btn btn-primary"
				style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #28a745;"
				id="save" name="save"
				value="<fmt:message key="common.button.save"/>"
				onclick="javascript:saveUser(this.form);"> <%-- 				<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearChilds();">
 --%> 
 <!--<c:if test="${user.userId!=0}">
					<input type="button" class="btn btn-danger"
						style="min-height: 30px; min-width: 80px; color: white; border: none; outline: #dc3545;"
						id="delete" name="delete"
						value="<fmt:message key="common.button.delete"/>"
						onclick="javascript:deleteUser(this.form);">
				</c:if>-->
		</tr>
	</table>
</div>
<input type="hidden" name="deleteUserRoleIds" id="deleteUserRoleIds"
	value="">
<input type="hidden" id="applicationIds" name="applicationIds" value="">

<script type="text/javascript">
function saveUser(frm)
{
	var arrElements=new Array('userName','password','firstName','lastName','employeeId');
	var arrElementNames=new Array('<fmt:message key="user.label.userName"/>','<fmt:message key="user.label.password" />','<fmt:message key="employee.manage.label.firstName"/>','<fmt:message key="employee.manage.label.lastName"/>','<fmt:message key="employee.list.label.employeeId"/>');
	var alphaArrayElements = new Array('userName','firstName','lastName');
	var msgArrayElements = new Array('<fmt:message key="user.label.userName" />','<fmt:message key="employee.manage.label.firstName"/>','<fmt:message key="employee.manage.label.lastName"/>');
	var fromDateArray = new Array('user.userRoleSet.userRoleStDate');
	var toDateArray = new Array('user.userRoleSet.userRoleEndDate');
	var dropElements = new Array('user.userRoleSet.role','user.userRoleSet.userRoleStDate');
	var dropElementsNames = new Array('<fmt:message key="user.manage.label.rolename"/>','<fmt:message key="user.manage.label.startdate"/>');
	if(checkAtleastOneChild('selectUserRoles', '<fmt:message key="user.manage.label.roles" />')) {
		if(checkMandatoryDetailed(arrElements, arrElementNames)) {
			//if(isAlphanum(alphaArrayElements,msgArrayElements)) {	
				if(isValidEmail(document.getElementById('email').value,"E-Mail")) {
				if(validatePasswordLength('password')){
					if(checkChildMandatoryDetailed('dtls',dropElements,dropElementsNames,'<fmt:message key="user.manage.label.roles"/>')) {
								if(checkChildDuplicate('user.userRoleSet.role','','','',
										new Array('<fmt:message key="user.manage.label.rolename"/>'))) { 
									<c:if test="${requestScope.rowsize!=null && requestScope.rowsize>0}">
									document.getElementById('deleteUserRoleIds').value=getSelectedValue('userRoleCheck');
									</c:if>	
									document.getElementById('applicationIds').value = getSelectedValue('applicationIdCheck');
									enableAllControls();
									navigate(frm,'<c:out value="${contextRoot}"/>/user/saveUser.do');
								}
							}else {
								displayError('<fmt:message key="user.manage.default.error"/>');
							}  
						}
					
					}
				
			//}
		}
	}
}
 



function deleteUser(id)
{
	if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/user/deleteUser.do');
	}
}
function clearChilds()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/user/editUser.do');
}

</script>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}"
	value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>" />