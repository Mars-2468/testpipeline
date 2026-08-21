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
			<c:when test="${bankBranch.bankBranchId==0}">
				<fmt:message key="bankBranch.manage.pagetitle.new" />
			</c:when>
			<c:otherwise>	
				<fmt:message key="bankBranch.manage.pagetitle.edit" />
			</c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
		<tr>
			<td colspan="2">
				<spring:bind path="bankBranch.bankBranchId">
					<input type="hidden" id="bankBranchId" name="bankBranchId" value="<c:out value="${bankBranch.bankBranchId}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="bankBranch.manage.label.branchName" />
				</span><span class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="bankBranch.branchName">
					<input type="text" class="ClsTextbox" id="branchName" maxlength="100" name="branchName" value="<c:out value="${bankBranch.branchName}"/>" />
				</spring:bind>
			</td>
		
			<td>
				<span class="ClsLabel"><fmt:message key="bankBranch.manage.label.branchCode" />
				</span>
			</td>
			<td>
				<spring:bind path="bankBranch.branchCode">
					<input type="text" class="ClsTextbox" id="branchCode" maxlength="10" name="branchCode" value="<c:out value="${bankBranch.branchCode}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="bankBranch.manage.label.bank" />
				</span><span class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="bankBranch.bank.bankId">
					<select name="bankId" id="bankId" style="width:240px" class="ClsTextbox">
						<option value=""><--- Select ---></option>
						<c:forEach var="bank" items="${requestScope.bankList}">
							<c:choose>
								<c:when test="${bankBranch.bank.bankId==bank.bankId}">
									<option value="${bank.bankId}" selected="selected">
										<c:out value="${bank.bankName}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${bank.bankId}">
										<c:out value="${bank.bankName}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</spring:bind>
			</td>

				<td>
					<span class="ClsLabel"><fmt:message key="bankBranch.manage.label.city"/></span></td>
				<td>
						<select name="cityId" id="cityId" style="width:240px" class="ClsTextbox">
								<option value=""> <--- Select city ---> </option>
									<c:forEach var="city" items="${requestScope.cityList}">
									<c:choose>
										<c:when test="${bankBranch.city.cityId==city.cityId}">
										<option value="${city.cityId}" selected="selected">
											<c:out value="${city.name}"/>
										</option>
									</c:when>
									<c:otherwise>
										<option value="${city.cityId}">
											<c:out value="${city.name}"/>
										</option>
									</c:otherwise>
								</c:choose>
							  </c:forEach>
						</select>
				</td>
			</tr>		
		<tr>
				<td>
					<span class="ClsLabel"><fmt:message key="bankBranch.manage.label.address1"/></span><span class="ClsRequiredFields">*</span></td>
				<td>
					<spring:bind path="bankBranch.address1">
						<input type="text" class="ClsTextbox" id="address1" maxlength="50" name="address1" value="<c:out value="${bankBranch.address1}"/>" />
					</spring:bind>
				</td>

				<td>
					<span class="ClsLabel"><fmt:message key="bankBranch.manage.label.address2"/></span></td>
				<td>
					<spring:bind path="bankBranch.address2">
						<input type="text" class="ClsTextbox" id="address2" maxlength="50" name="address2" value="<c:out value="${bankBranch.address2}"/>" />
					</spring:bind>
				</td>
			</tr>
			<tr>
				<td>
					<span class="ClsLabel"><fmt:message key="bankBranch.manage.label.address3"/></span></td>
				<td>
					<spring:bind path="bankBranch.address3">
						<input type="text" class="ClsTextbox" id="address3" maxlength="50" name="address3" value="<c:out value="${bankBranch.address3}"/>" />
					</spring:bind>
				</td>

				<td>
					<span class="ClsLabel"><fmt:message key="bankBranch.manage.label.pin"/></span></td>
				<td>
					<spring:bind path="bankBranch.pin">
						<input type="text" class="ClsTextbox" id="pin" maxlength="6" name="pin" value="<c:out value="${bankBranch.pin}"/>" />
					</spring:bind>
				</td>
			</tr>
			<tr>
				<td>
					<span class="ClsLabel"><fmt:message key="bankBranch.manage.label.phone"/></span></td>
				<td>
					<spring:bind path="bankBranch.phone">
						<input type="text" class="ClsTextbox" id="phone" maxlength="50" name="phone" value="<c:out value="${bankBranch.phone}"/>" />
					</spring:bind>
				</td>
	
				<td>
					<span class="ClsLabel"><fmt:message key="bankBranch.manage.label.fax"/></span></td>
				<td>
					<spring:bind path="bankBranch.fax">
						<input type="text" class="ClsTextbox" id="fax" maxlength="50" name="fax" value="<c:out value="${bankBranch.fax}"/>" />
					</spring:bind>
				</td>
			</tr>
			<tr>
				<td>
					<span class="ClsLabel"><fmt:message key="bankBranch.manage.label.eMail"/></span></td>
				<td>
					<spring:bind path="bankBranch.email">
						<input type="text" class="ClsTextbox" id="email" maxlength="50" name="email" value="<c:out value="${bankBranch.email}"/>" />
					</spring:bind>
				</td>

				<td>
					<span class="ClsLabel"><fmt:message key="bankBranch.manage.label.contactPerson"/></span></td>
				<td>
					<spring:bind path="bankBranch.contactPerson">
						<input type="text" class="ClsTextbox" id="contactPerson" maxlength="50" name="contactPerson" value="<c:out value="${bankBranch.contactPerson}"/>" />
					</spring:bind>
				</td>
			</tr>
		
					<tr>
					<td>
						<span class="ClsLabel"><fmt:message key="bankBranch.manage.label.valid"/></span><span class="ClsRequiredFields">*</span></td>
					<td>
					<spring:bind path="bankBranch.status">
						<select name="status" id="status" style="width:240px" class="ClsTextbox">
							<option value="<c:out value="${pageScope.ACTIVE}"/>" <c:if test='${(bankBranch.status eq pageScope.ACTIVE) || (bankBranch.status eq "")}'>selected="selected"</c:if>><c:out value="${pageScope.ACTIVE_LABEL}"/></option>
							<option value="<c:out value="${pageScope.INACTIVE}"/>" <c:if test='${bankBranch.status eq pageScope.INACTIVE}'>selected="selected"</c:if>><c:out value="${pageScope.INACTIVE_LABEL}"/></option>
						</select> 
					</spring:bind>
					</td>
			</tr>
		
		<tr>
			<td colspan="2" style="padding-top:5px"></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveBankBranch(this.form);">
				<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
				<c:if test="${bankBranch.bankBranchId!=0}">
					<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteBankBranch(this.form);">
				</c:if>
		</tr>
	</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>" />
<script type="text/javascript">
function saveBankBranch(frm)
{
	var arrRequiredElements=new Array('branchName','bankId','cityId','address1','status');
	var arrRequiredElementsMessages=new Array('<fmt:message key="bankBranch.manage.label.branchName"/>', 
			'<fmt:message key="bankBranch.manage.label.bank"/>',
			'<fmt:message key="bankBranch.manage.label.city"/>',
			'<fmt:message key="bankBranch.manage.label.address1"/>',
			'<fmt:message key="bankBranch.manage.label.valid"/>'
			);

	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages)){	
		if(isAlphaNumericSpecial(new Array('branchName'),new Array('<fmt:message key="bankBranch.manage.label.branchName"/>'), '() &-_')){		
			if(isAlphanum(new Array('branchCode'),new Array('<fmt:message key="bankBranch.manage.label.branchCode"/>'))){
				navigate(frm,'<c:out value="${contextRoot}"/>/bankbranch/saveBankBranch.do');
			}
		}
	}
}
</script>
<script type="text/javascript">
function deleteBankBranch(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/bankbranch/deleteBankBranch.do');
}
}
</script>
