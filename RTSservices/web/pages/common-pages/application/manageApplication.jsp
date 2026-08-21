<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("APPLICATION_ID", Constants.APPLICATION_ID);
%>
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${application.applicationId==0}"><fmt:message key="application.manage.pagetitle.new"/></c:when>
			<c:otherwise><fmt:message key="application.manage.pagetitle.edit"/></c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top" id="SetFormHeight">
<table border="0" cellpadding="2" cellspacing="2" class="dataForm">
<tr>
<td colspan="2">
<spring:bind path="application.applicationId">
<input type="hidden" id="applicationId" name="applicationId" value="<c:out value="${application.applicationId}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="application.manage.label.name"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="application.name">
<input type="text" class="ClsTextbox" id="name" maxlength="50" name="name" 
value="<c:out value="${application.name}"/>" style="width:240px;"/>
</spring:bind>
</td>
</tr>

<tr>
<td>
<!-- <span class="ClsLabel"><fmt:message key="application.manage.label.status"/></span><span class="ClsRequiredFields">*</span>  --> 
</td>
<td>
<spring:bind path="application.status">
<input type="hidden" id="status" maxlength="1" name="status" value="<c:out value="${application.status}"/>" />
</spring:bind>
</td>
</tr>

<tr>
<td>
<span class="ClsLabel"><fmt:message key="application.manage.label.description"/></span><span class="ClsRequiredFields">*</span> 
</td>
<td>
<spring:bind path="application.description">
<input type="text" id="description" class="ClsTextbox"  style="width:240px" size="50" maxlength="200" name="description" value="<c:out value="${application.description}"/>" />
</spring:bind>
</td>
</tr>

<tr>
<td>
<span class="ClsLabel"><fmt:message key="application.manage.label.imageUrl"/></span><span class="ClsRequiredFields">*</span> 
</td>
<td>
<spring:bind path="application.imageUrl">
<input type="text" id="imageUrl" class="ClsTextbox" size="50" style="width:240px"  maxlength="50" name="imageUrl" value="<c:out value="${application.imageUrl}"/>" />
</spring:bind>
</td>
</tr>

<tr>
<td>
<span class="ClsLabel"><fmt:message key="application.manage.label.applicationUrl"/></span><span class="ClsRequiredFields">*</span> 
</td>
<td>
<spring:bind path="application.applicationUrl">
<input type="text" id="applicationUrl" class="ClsTextbox" size="50"  style="width:240px" maxlength="50" name="applicationUrl" value="<c:out value="${application.applicationUrl}"/>" />
</spring:bind>
</td>
</tr>

<tr><td  colspan="2" style="padding-top:5px"></td></tr>
<tr><td></td>
<td>
<c:choose>
<c:when test="true">
	<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveApplication(this.form);">
	<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
	<c:if test="${application.applicationId!=0}">
	<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteApplication(this.form);">
	</c:if>
</c:when>
<c:otherwise>
	<fmt:message key="page.edit.permissions"/>
</c:otherwise>
</c:choose>
</tr>
</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/><script type="text/javascript">
function saveApplication(frm)
{
	var arrRequiredElements=new Array('name','description','imageUrl','applicationUrl');
	var arrRequiredElementsMessages=new Array('<fmt:message key="application.manage.label.name"/>','<fmt:message key="application.manage.label.description"/>','<fmt:message key="application.manage.label.imageUrl"/>','<fmt:message key="application.manage.label.applicationUrl"/>');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
		{	var arrAlphaElements=new Array('name');
		var arrAlphaElementsMessages=new Array('<fmt:message key="application.manage.label.name"/>');
		if(isAlphaAray(arrAlphaElements,arrAlphaElementsMessages))
		{		
			navigate(frm,'<c:out value="${contextRoot}"/>/application/saveApplication.do');
		}
		}
}
</script><script type="text/javascript">
function deleteApplication(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/application/deleteApplication.do');
}
}
</script>