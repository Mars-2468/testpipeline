<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);%>
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${tenant.tenantId==0}"><fmt:message key="tenant.manage.pagetitle.new" /></c:when>
			<c:otherwise><fmt:message key="tenant.manage.pagetitle.edit" /></c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top"  id="SetFormHeight"><table border="0" cellpadding="2" cellspacing="2" class="dataForm">
<tr>
<td colspan="2">
<spring:bind path="tenant.tenantId">
<input type="hidden" id="tenantId" name="tenantId" value="<c:out value="${tenant.tenantId}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="tenant.manage.label.tenantName"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="tenant.tenantName">
<input type="text" class="ClsTextbox" id="tenantName" maxlength="20" name="tenantName" value="<c:out value="${tenant.tenantName}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="tenant.manage.label.website"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="tenant.website">
<input type="text" class="ClsTextbox" id="website" maxlength="50" name="website" value="<c:out value="${tenant.website}"/>" />
</spring:bind>
</td>
</tr>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="tenant.manage.label.address"/></span><span class="ClsRequiredFields">*</span></td>
<td><spring:bind path="tenant.address">
			<textarea class="ClsTextarea" id="address"
		 	name="address" cols="50" rows="5" maxlength="500" ><c:out value="${tenant.address}"/></textarea>
		</spring:bind>
</td>
</tr>
<tr><td  colspan="2" style="padding-top:5px"></td></tr>
<tr><td></td>
<td>
<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveTenant(this.form);">
<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
<c:if test="${tenant.tenantId!=0}">
<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteTenant(this.form);">
</c:if>
</tr>
</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/><script type="text/javascript">
function saveTenant(frm)
{
	var arrRequiredElements=new Array('tenantName','website','address');
	var arrRequiredElementsMessages=new Array('<fmt:message key="tenant.manage.label.tenantName"/>','<fmt:message key="tenant.manage.label.website"/>','<fmt:message key="tenant.manage.label.address"/>');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
		{	var arrAlphaElements=new Array('tenantName','website','address');
		var arrAlphaElementsMessages=new Array('<fmt:message key="tenant.manage.label.tenantName"/>','<fmt:message key="tenant.manage.label.website"/>','<fmt:message key="tenant.manage.label.address"/>');
		if(isAlphaAray(arrAlphaElements,arrAlphaElementsMessages))
		{		navigate(frm,'<c:out value="${contextRoot}"/>/tenant/saveTenant.do');
		}
		}
}
</script><script type="text/javascript">
function deleteTenant(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/tenant/deleteTenant.do');
}
}
</script>