<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%@include file="/pages/common/includeTransliterateJS.jsp"%>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);%>
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${sector.sectorId==0}"><fmt:message key="sector.manage.pagetitle.new" /></c:when>
			<c:otherwise><fmt:message key="sector.manage.pagetitle.edit" /></c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top"  id="SetFormHeight">
<table border="0" cellpadding="2" cellspacing="2" class="dataForm">
<tr>
<td colspan="2">
<spring:bind path="sector.sectorId">
<input type="hidden" id="sectorId" name="sectorId" value="<c:out value="${sector.sectorId}"/>" />
</spring:bind>
</td>
</tr>
		
<tr>
<td>
<span class="ClsLabel"><fmt:message key="sector.manage.label.name"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="sector.name">
<input type="text" class="ClsTextbox" id="name" maxlength="50" name="name" value="<c:out value="${sector.name}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="sector.manage.label.Node"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="sector.nodeMaster.nodeMasterId">
<select name="nodeMasterId" id="nodeMasterId" style="width:240px" class="ClsTextbox">
<option value=""> <--- Select ---> </option>
<c:forEach var="Node" items="${requestScope.nodeList}">
<c:choose>
<c:when test="${sector.nodeMaster.nodeMasterId==Node.nodeMasterId}">
<option value="${Node.nodeMasterId}" selected="selected">
<c:out value="${Node.name}"/>
</option>
</c:when>
<c:otherwise>
<option value="${Node.nodeMasterId}">
<c:out value="${Node.name}"/>
</option>
</c:otherwise>
</c:choose>
</c:forEach>
</select>
</spring:bind>
</td>
</tr>
<tr>
<!--<td><span class="ClsLabel"><fmt:message key="sector.manage.label.status"/></span></td>-->
<td>
<spring:bind path="sector.status">
<input type="hidden" id="status" maxlength="1" name="status" value="<c:out value="${sector.status}"/>" />
</spring:bind>
</td>
</tr>
<tr><td  colspan="2" style="padding-top:5px"></td></tr>
<tr><td></td>
<td>
<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveSector(this.form);">
<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
<c:if test="${sector.sectorId!=0}">
<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteSector(this.form);">
</c:if>
</tr>
</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/><script type="text/javascript">
function saveSector(frm)
{
	var arrRequiredElements=new Array('name','nodeMasterId');
	var arrRequiredElementsMessages=new Array('<fmt:message key="sector.manage.label.name"/>','<fmt:message key="sector.manage.label.Node"/>');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
		{	
		var arrAlphaElements=new Array('name');
		var arrAlphaElementsMessages=new Array('<fmt:message key="sector.manage.label.name"/>');
		if(isAlphaNumericSpecial(arrAlphaElements,arrAlphaElementsMessages, '. -,_'))
		{		
			navigate(frm,'<c:out value="${contextRoot}"/>/sector/saveSector.do');
		}
		}
}
</script><script type="text/javascript">
function deleteSector(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/sector/deleteSector.do');
}
}
</script>