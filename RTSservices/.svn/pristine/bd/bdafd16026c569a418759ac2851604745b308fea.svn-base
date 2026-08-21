<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);%>
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${plotType.plotTypeId==0}"><fmt:message key="plotType.manage.pagetitle.new" /></c:when>
			<c:otherwise><fmt:message key="plotType.manage.pagetitle.edit" /></c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top"  id="SetFormHeight">
<table border="0" cellpadding="2" cellspacing="2" class="dataForm">
<tr>
<td colspan="2">
<spring:bind path="plotType.plotTypeId">
<input type="hidden" id="plotTypeId" name="plotTypeId" value="<c:out value="${plotType.plotTypeId}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="plotType.manage.label.description"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="plotType.description">
<input type="text" class="ClsTextbox" id="description" maxlength="50" name="description" 
value="<c:out value="${plotType.description}"/>" style="width:250px;"/>
</spring:bind>
</td>
</tr>
<tr>
</tr>
<tr>
<!--<td><span class="ClsLabel"><fmt:message key="plotType.manage.label.status"/></span></td>-->
<td>
<spring:bind path="plotType.status">
<input type="hidden" id="status" maxlength="1" name="status" value="<c:out value="${plotType.status}"/>" />
</spring:bind>
</td>
</tr>
<tr><td  colspan="2" style="padding-top:5px"></td></tr>
<tr><td></td>
<td>
<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:savePlotType(this.form);">
<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
<c:if test="${plotType.plotTypeId!=0}">
<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deletePlotType(this.form);">
</c:if>
</tr>
</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/><script type="text/javascript">
function savePlotType(frm)
{
	var arrRequiredElements=new Array('description');
	var arrRequiredElementsMessages=new Array('<fmt:message key="plotType.manage.label.description"/>');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
		{	
		var arrAlphaElements=new Array('description');
		var arrAlphaElementsMessages=new Array('<fmt:message key="plotType.manage.label.description"/>');
		if(isAlphaAray(arrAlphaElements,arrAlphaElementsMessages))
		{		
			navigate(frm,'<c:out value="${contextRoot}"/>/plottype/savePlotType.do');
		}
		}
}
</script><script type="text/javascript">
function deletePlotType(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/plottype/deletePlotType.do');
}
}
</script>