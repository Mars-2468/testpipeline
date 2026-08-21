<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;" />
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);
%>
<div class="mainHdr">
	<h3>
		<c:choose>
			<c:when test="${salutation.salutationId==0}">
				<fmt:message key="salutation.manage.pagetitle.new" />
			</c:when>
			<c:otherwise>
				<fmt:message key="salutation.manage.pagetitle.edit" />
			</c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<table border="0" cellpadding="2" cellspacing="2" class="dataForm">
		<tr>
			<td colspan="2"><spring:bind path="salutation.salutationId">
					<input type="hidden" id="salutationId" name="salutationId"
						value="<c:out value="${salutation.salutationId}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td><span class="ClsLabel"><fmt:message
						key="salutation.manage.label.SalutationName" /></span><span
				class="ClsRequiredFields">*</span>
			</td>
			<td><spring:bind path="salutation.salutationName">
					<input type="text" class="ClsTextbox" id="salutationName"
						maxlength="5" name="salutationName"
						value="<c:out value="${salutation.salutationName}"/>" />
				</spring:bind>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" style="padding-top: 5px"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="button" class="ClsButton" id="save" name="save"
				value="Save" onclick="javascript:saveSalutation(this.form);">
				<input type="button" class="ClsButton" id="clear" name="clear"
				value="Clear" onclick="javascript:clearContorls();"> <c:if
					test="${salutation.salutationId!=0}">
					<input type="button" class="ClsButton" id="delete" name="delete"
						value="Delete" onclick="javascript:deleteSalutation(this.form);">
				</c:if>
		</tr>
	</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}"
	value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>" />
<script type="text/javascript">
	function saveSalutation(frm) {
		var arrRequiredElements = new Array('salutationName');
		var arrRequiredElementsMessages = new Array('<fmt:message key="salutation.manage.label.SalutationName"/>');
		if (checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages)) {
			var arrAlphaElements = new Array('salutationName');
			var arrAlphaElementsMessages = new Array('<fmt:message key="salutation.manage.label.SalutationName"/>');
			if (isAlphaSpaceOnly(arrAlphaElements, arrAlphaElementsMessages)) {
				//if(isAlphaSpace(new Array('salutationName'),new Array('<fmt:message key="salutation.manage.label.SalutationName"/>'))){		
				navigate(frm,'<c:out value="${contextRoot}"/>/salutation/saveSalutation.do');
				//}
			}
		}
	}
</script>
<script type="text/javascript">
	function deleteSalutation(id) {
		if (confirmDelete()) {
			onPageSubmit('<c:out value="${contextRoot}"/>/salutation/deleteSalutation.do');
		}
	}
</script>