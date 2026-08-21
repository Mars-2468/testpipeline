<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);%>
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${node.nodeId==0}"><fmt:message key="node.manage.pagetitle.new" /></c:when>
			<c:otherwise><fmt:message key="node.manage.pagetitle.edit" /></c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top"  id="SetFormHeight">
<table border="0" cellpadding="2" cellspacing="2" class="dataForm">
<tr>
<td colspan="2">
<spring:bind path="node.nodeId">
<input type="hidden" id="nodeId" name="nodeId" value="<c:out value="${node.nodeId}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="node.manage.label.name"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="node.name">
<input type="text" class="ClsTextbox" id="name" maxlength="50" name="name" value="<c:out value="${node.name}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="node.manage.label.code"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="node.code">
<input type="text" class="ClsTextbox" id="code" maxlength="10" name="code" value="<c:out value="${node.code}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="node.manage.label.ward"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="node.ward.wardId">
<select name="wardId" id="wardId" class="ClsTextbox">
<option value="" > <--- Select ---> </option>
<c:forEach var="ward" items="${requestScope.wardList}">
<c:choose>
<c:when test="${node.ward.wardId==ward.wardId}">
<option value="${ward.wardId}" selected="selected">
<c:out value="${ward.name}"/>
</option>
</c:when>
<c:otherwise>
<option value="${ward.wardId}">
<c:out value="${ward.name}"/>
</option>
</c:otherwise>
</c:choose>
</c:forEach>
</select>
</spring:bind>
</td>
</tr>
<tr>
<!--<td><span class="ClsLabel"><fmt:message key="node.manage.label.status"/></span></td>-->
<td>
<spring:bind path="node.status">
<input type="hidden" id="status" maxlength="1" name="status" value="<c:out value="${node.status}"/>" />
</spring:bind>
</td>
</tr>
<tr><td  colspan="2" style="padding-top:5px"></td></tr>
<tr><td></td>
<td>
<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveNode(this.form);">
<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
<c:if test="${node.nodeId!=0}">
<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteNode(this.form);">
</c:if>
</tr>
</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/><script type="text/javascript">
function saveNode(frm)
{
	var arrRequiredElements=new Array('name','code','wardId');
	var arrRequiredElementsMessages=new Array('<fmt:message key="node.manage.label.name"/>','<fmt:message key="node.manage.label.code"/>','<fmt:message key="node.manage.label.ward"/>');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
		{	
		var arrAlphaElements=new Array('name','code');
		var arrAlphaElementsMessages=new Array('<fmt:message key="node.manage.label.name"/>','<fmt:message key="node.manage.label.code"/>');
		if(isAlphaAray(arrAlphaElements,arrAlphaElementsMessages))
		{		
			navigate(frm,'<c:out value="${contextRoot}"/>/node/saveNode.do');
		}
		}
}
</script><script type="text/javascript">
function deleteNode(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/node/deleteNode.do');
}
}
</script>