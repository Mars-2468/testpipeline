<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;" />
<%@include file="/pages/common/includeTransliterateJS.jsp"%>
<%
	    pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	    pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
	    
	    pageContext.setAttribute("INACTIVE_LABEL", Constants.INACTIVE_LABEL);
	    pageContext.setAttribute("ACTIVE_LABEL", Constants.ACTIVE_LABEL);
	    
	    pageContext.setAttribute("INACTIVE", Constants.INACTIVE);
	    pageContext.setAttribute("ACTIVE", Constants.ACTIVE);
%>
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${bank.bankId==0}"><fmt:message key="bank.manage.pagetitle.new" /></c:when>
			<c:otherwise><fmt:message key="bank.manage.pagetitle.edit" /></c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<table border="0" cellpadding="2" cellspacing="2" class="dataForm">
		<tr>
			<td colspan="2">
				<spring:bind path="bank.bankId">
					<input type="hidden" id="bankId" name="bankId" value="<c:out value="${bank.bankId}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="bank.manage.label.bankName" />
				</span><span class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="bank.bankName">
					<input type="text" class="ClsTextbox" id="bankName"  style="width:240px" maxlength="100" name="bankName" value="<c:out value="${bank.bankName}"/>" style="width:240px;"  />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="bank.manage.label.website"/></span></td>
				<td>
					<spring:bind path="bank.website">
					<input type="text" class="ClsTextbox" style="width:240px" id="website" maxlength="50" name="website" value="<c:out value="${bank.website}"/>" />
					</spring:bind>
			</td>
		</tr>
		
		
		<tr>
			<td>
			<span class="ClsLabel"><fmt:message key="bank.manage.label.valid"/></span><span class="ClsRequiredFields">*</span></td>
			<td>
			<spring:bind path="bank.status">
			<select name="status" id="status" style="width:240px" class="ClsTextbox">
				<option value=""><-- Select --></option> 
				<option value="<c:out value="${pageScope.ACTIVE}"/>" <c:if test='${(bank.status eq pageScope.ACTIVE) || (bank.status eq "")}'>selected="selected"</c:if>><c:out value="${pageScope.ACTIVE_LABEL}"/></option>
				<option value="<c:out value="${pageScope.INACTIVE}"/>" <c:if test='${bank.status eq pageScope.INACTIVE}'>selected="selected"</c:if>><c:out value="${pageScope.INACTIVE_LABEL}"/></option>
			</select> 
			</spring:bind>
			</td>
		</tr>

		<tr>
			<td colspan="2" style="padding-top:5px"></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveBank(this.form);">
				<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
				<c:if test="${bank.bankId!=0}">
					<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteBank(this.form);">
				</c:if>
		</tr>
	</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>" />
<script type="text/javascript">
function saveBank(frm)
{
	var arrRequiredElements=new Array('bankName','status');
	var arrRequiredElementsMessages=new Array('<fmt:message key="bank.manage.label.bankName"/>','<fmt:message key="bank.manage.label.valid"/>');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
		{	var arrAlphaElements=new Array('bankName');
		var arrAlphaElementsMessages=new Array('<fmt:message key="bank.manage.label.bankName"/>');
		if(isAlphaAray(arrAlphaElements,arrAlphaElementsMessages))
		{		navigate(frm,'<c:out value="${contextRoot}"/>/bank/saveBank.do');
		}
		}
}
</script>
<script type="text/javascript">
function deleteBank(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/bank/deleteBank.do');
}
}
</script>
