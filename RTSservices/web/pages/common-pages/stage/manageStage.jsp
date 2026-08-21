<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);%>
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${stage.stageId==0}"><fmt:message key="stage.manage.pagetitle.new" /></c:when>
			<c:otherwise><fmt:message key="stage.manage.pagetitle.edit" /></c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top"  id="SetFormHeight">
<table border="0" cellpadding="2" cellspacing="2" class="dataForm">
<tr>
<td colspan="2">
<spring:bind path="stage.stageId">
<input type="hidden" id="stageId" name="stageId" value="<c:out value="${stage.stageId}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="stage.manage.label.description"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="stage.description">
<input type="text" class="ClsTextbox" id="description" maxlength="100" name="description" 
value="<c:out value="${stage.description}"/>" style="width:250px;"/>
</spring:bind>
</td>
</tr>
<tr>
<!--<td><span class="ClsLabel"><fmt:message key="stage.manage.label.status"/></span></td>-->
<td>
<spring:bind path="stage.status">
<input type="hidden" id="status" maxlength="1" name="status" value="<c:out value="${stage.status}"/>" />
</spring:bind>
</td>
</tr>
<tr><td  colspan="2" style="padding-top:5px"></td></tr>
<tr><td></td>
<td>
<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveStage(this.form);">
<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
<c:if test="${stage.stageId!=0}">
<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteStage(this.form);">
</c:if>
</tr>
</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/><script type="text/javascript">
function saveStage(frm)
{	
	var arrRequiredElements=new Array('description');
	var arrRequiredElementsMessages=new Array('<fmt:message key="stage.manage.label.description"/>');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
	{	
		if(isAlphanum(arrRequiredElements,arrRequiredElementsMessages))
		{	
			if(isAlphaUndrsc(new Array('description'),new Array('<fmt:message key="stage.manage.label.description"/>'))){		
			navigate(frm,'<c:out value="${contextRoot}"/>/stage/saveStage.do');
			}
		}
	}
}
</script><script type="text/javascript">
function deleteStage(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/stage/deleteStage.do');
}
}
</script>