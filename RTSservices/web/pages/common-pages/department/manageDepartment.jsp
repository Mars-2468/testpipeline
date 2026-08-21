<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants, com.mars.common.utils.CommonUtils" />
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);
	pageContext.setAttribute("ACTIVE", Constants.ACTIVE);
	pageContext.setAttribute("INACTIVE", Constants.INACTIVE);
	pageContext.setAttribute("ACTIVE_LABEL", Constants.ACTIVE_LABEL);
	pageContext.setAttribute("INACTIVE_LABEL", Constants.INACTIVE_LABEL);
	pageContext.setAttribute("statusList", CommonUtils.getStatus());
%>
<div class="mainHdr">
	<h3>
		<c:choose>
			<c:when test="${department.departmentId==0}">
				<fmt:message key="department.manage.pagetitle.new" />
			</c:when>
			<c:otherwise>
				<fmt:message key="department.manage.pagetitle.edit" />
			</c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<table border="0" cellpadding="2" cellspacing="2" class="dataForm">
		<tr>
			<td colspan="2">
				<spring:bind path="department.departmentId">
					<input type="hidden" id="departmentId" name="departmentId"
						value="<c:out value="${department.departmentId}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td><span class="ClsLabel"><fmt:message
						key="department.manage.label.name" /></span><span
				class="ClsRequiredFields">*</span></td>
			<td><spring:bind path="department.name">
					<input type="hidden" class="ClsTextbox" id="name" maxlength="50"
						name="name" value="<c:out value="${department.name}"/>"
						style="width: 250px;" />
					<c:out value="${department.name}" />
				</spring:bind></td>
		</tr>

		<tr>
			<td><span class="ClsLabel"><fmt:message
						key="department.manage.label.code" /></span></td>
			<td><spring:bind path="department.code">
					<input type="hidden" class="ClsTextbox" id="code" maxlength="200"
						name="code" style="width: 250px;" <c:out value="${department.code}"/>"/>
					<c:out value="${department.code}" />
				</spring:bind></td>
		</tr>
		<tr>
			<td><span class="ClsLabel"><fmt:message
						key="department.manage.label.description" /></span></td>
			<td><spring:bind path="department.description">
					<input type="hidden" class="ClsTextbox" id="description"
						maxlength="200" name="description" style="width: 250px;" <c:out value="${department.description}"/>"/>
					<c:out value="${department.description}" />
				</spring:bind></td>
		</tr>
		<tr>
			<td><span class="ClsLabel"><fmt:message
						key="department.manage.label.status" /></span></td>
			<td><spring:bind path="department.status">
					<input type="hidden" id="status" maxlength="1" name="status"
						value="<c:out value="${department.status}"/>" />
					<%-- <select name="status" id="status" 
							class="validate[required] ClsTextbox" style="width: 95%">
								<option value=""><-- Select Status --></option>
							<c:forEach items="${pageScope.statusList}" var="statusList">
								<option value="${statusList[0]}"
								<c:if test="${department.status == statusList[0]}">selected = "selected" </c:if>>
								<c:out value="${statusList[1]}" />
							    </option>
							</c:forEach>
					</select> --%>
					<c:out value="${department.status}" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="padding-top: 5px"></td>
		</tr>
		<tr>
			<td colspan="3" align="center">
						<%-- <input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveDepartment(this.form);">
		<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
		<c:if test="${department.departmentId!=0}">
		<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteDepartment(this.form);">
		</c:if> --%>
		</tr>
	</table>
</div>

<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}"
	value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>" />
	
<script type="text/javascript">
	function saveDepartment(frm) {
		var arrRequiredElements = new Array('name');
		var arrRequiredElementsMessages = new Array('<fmt:message key="department.manage.label.name"/>');
		if (checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages)) {
			var arrAlphaElements = new Array('name');
			var arrAlphaElementsMessages = new Array('<fmt:message key="department.manage.label.name"/>');
			if (isAlphaAray(arrAlphaElements, arrAlphaElementsMessages)) {
				navigate(frm,'<c:out value="${contextRoot}"/>/department/saveDepartment.do');
			}
		}
	}
</script>
<script type="text/javascript">
	function deleteDepartment(id) {
		if (confirmDelete()) {
			onPageSubmit('<c:out value="${contextRoot}"/>/department/deleteDepartment.do');
		}
	}
</script>