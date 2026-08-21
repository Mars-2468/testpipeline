<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;" />
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
%>
<div class="mainHdr">
	<h3>
		<c:choose>
			<c:when test="${designation.designationId==0}">
				<fmt:message key="designation.manage.pagetitle.new" />
			</c:when>
			<c:otherwise>
				<fmt:message key="designation.manage.pagetitle.edit" />
			</c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<table border="0" cellpadding="2" cellspacing="2" class="dataForm">
		<tr>
			<td colspan="2">
				<spring:bind path="designation.designationId">
					<input type="hidden" id="designationId" name="designationId"
						value="<c:out value="${designation.designationId}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="designation.manage.label.name" /></span><span class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="designation.name">
					<input type="hidden" class="ClsTextbox" id="name" maxlength="50"
						name="name" value="<c:out value="${designation.name}"/>"
						style="width: 250px;" />
					<c:out value="${designation.name}" />
				</spring:bind>
			</td>
		</tr>
		<%--<tr>
		<td>
		<span class="ClsLabel"><fmt:message key="designation.manage.label.description"/></span></td>
		<td>
		<spring:bind path="designation.description">
		<input type="text" class="ClsTextbox" id="description" maxlength="200" name="description" 
		value="<c:out value="${designation.description}"/>" style="width:250px;"/>
		</spring:bind>
		</td>
		</tr>--%>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="designation.manage.label.status" /></span>
			</td>
			<td>
				<spring:bind path="designation.status">
					<input type="hidden" id="status" maxlength="1" name="status"
						value="<c:out value="${designation.status}"/>" />
					<c:out value="${designation.status}" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="padding-top: 5px"></td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<%-- <input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveDesignation(this.form);">
				<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
				<c:if test="${designation.designationId!=0}">
				<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteDesignation(this.form);">
				</c:if> --%>
		</tr>
	</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>" />
<script type="text/javascript">
	function saveDesignation(frm) {
		var arrRequiredElements = new Array('name');
		var arrRequiredElementsMessages = new Array('<fmt:message key="designation.manage.label.name"/>');
		if (checkMandatoryDetailed(arrRequiredElements, arrRequiredElementsMessages)) {
			var arrAlphaElements = new Array('name');
			var arrAlphaElementsMessages = new Array('<fmt:message key="designation.manage.label.name"/>');
			if (isAlphaAray(arrAlphaElements, arrAlphaElementsMessages)) {
				navigate(frm,'<c:out value="${contextRoot}"/>/designation/saveDesignation.do');
			}
		}
	}
</script>
<script type="text/javascript">
	function deleteDesignation(id) {
		if (confirmDelete()) {
			onPageSubmit('<c:out value="${contextRoot}"/>/designation/deleteDesignation.do');
		}
	}
</script>