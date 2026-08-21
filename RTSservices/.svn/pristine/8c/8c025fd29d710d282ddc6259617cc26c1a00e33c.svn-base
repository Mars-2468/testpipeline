<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%@include file="/pages/common/includeTransliterateJS.jsp"%>
<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);

pageContext.setAttribute("REGION_NORTH_LABEL",   Constants.REGION_NORTH_LABEL);
pageContext.setAttribute("REGION_WESTERN_LABEL" , Constants.REGION_WESTERN_LABEL);
pageContext.setAttribute("REGION_EASTERN_LABEL",  Constants.REGION_EASTERN_LABEL);
pageContext.setAttribute("REGION_CENTRAL_LABEL" ,  Constants.REGION_CENTRAL_LABEL);
pageContext.setAttribute("REGION_SOUTHERN_LABEL" ,  Constants.REGION_SOUTHERN_LABEL);

pageContext.setAttribute("REGION_NORTH_VALUE",   Constants.REGION_NORTH_VALUE);
pageContext.setAttribute("REGION_WESTERN_VALUE" , Constants.REGION_WESTERN_VALUE);
pageContext.setAttribute("REGION_EASTERN_VALUE",  Constants.REGION_EASTERN_VALUE);
pageContext.setAttribute("REGION_CENTRAL_VALUE" ,  Constants.REGION_CENTRAL_VALUE);
pageContext.setAttribute("REGION_SOUTHERN_VALUE" ,  Constants.REGION_SOUTHERN_VALUE);
%>
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${state.stateId==0}"><fmt:message key="state.manage.pagetitle.new" /></c:when>
			<c:otherwise><fmt:message key="state.manage.pagetitle.edit" /></c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top"  id="SetFormHeight">
<table width="50%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
<tr>
<td colspan="2">
<spring:bind path="state.stateId">
<input type="hidden" id="stateId" name="stateId" value="<c:out value="${state.stateId}"/>" />
</spring:bind>
</td>
</tr>

<tr>
<td>
<span class="ClsLabel"><fmt:message key="state.manage.label.name"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="state.name">
<input type="text" class="ClsTextbox" id="name" maxlength="45" name="name" value="<c:out value="${state.name}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="state.manage.label.code"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="state.code">
<input type="text" class="ClsTextbox" id="code" maxlength="2" name="code" value="<c:out value="${state.code}"/>" />
</spring:bind>
</td>
</tr>
<tr>

<tr>
		<td>
				<span class="ClsLabel"><fmt:message key="state.manage.label.region"/></span><span class="ClsRequiredFields">*</span></td>
		<td>
					<spring:bind path="state.region" >
						<select name="region" id="region" style="width:240px" class="ClsTextbox">
							<option value=""> <-- Select Region --> </option>
							<option value="<c:out value="${pageScope.REGION_NORTH_VALUE}"/>" <c:if test='${state.region eq pageScope.REGION_NORTH_VALUE || state.region eq ""}'>selected="selected"</c:if>><c:out value="${pageScope.REGION_NORTH_LABEL}"/></option>
							<option value="<c:out value="${pageScope.REGION_WESTERN_VALUE}"/>" <c:if test='${state.region eq pageScope.REGION_WESTERN_VALUE || state.region eq ""}'>selected="selected"</c:if>><c:out value="${pageScope.REGION_WESTERN_LABEL}"/></option>
							<option value="<c:out value="${pageScope.REGION_EASTERN_VALUE}"/>" <c:if test='${state.region eq pageScope.REGION_EASTERN_VALUE || state.region eq ""}'>selected="selected"</c:if>><c:out value="${pageScope.REGION_EASTERN_LABEL}"/></option>
							<option value="<c:out value="${pageScope.REGION_CENTRAL_VALUE}"/>" <c:if test='${state.region eq pageScope.REGION_CENTRAL_VALUE || state.region eq ""}'>selected="selected"</c:if>><c:out value="${pageScope.REGION_CENTRAL_LABEL}"/></option>
							<option value="<c:out value="${pageScope.REGION_SOUTHERN_VALUE}"/>" <c:if test='${state.region eq pageScope.REGION_SOUTHERN_VALUE || state.region eq ""}'>selected="selected"</c:if>><c:out value="${pageScope.REGION_SOUTHERN_LABEL}"/></option>
						</select> 
					</spring:bind>
				</td>
</tr>

<tr>
<!--<td><span class="ClsLabel"><fmt:message key="state.manage.label.status"/></span></td>-->
<td>
<spring:bind path="state.status">
<input type="hidden" id="status" maxlength="1" name="status" value="<c:out value="${state.status}"/>" />
</spring:bind>
</td>
</tr>
<tr><td  colspan="2" style="padding-top:5px"></td></tr>
<tr><td></td>
<td>
<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveState(this.form);">
<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
<c:if test="${state.stateId!=0}">
<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteState(this.form);">
</c:if>
</tr>
</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/><script type="text/javascript">
function saveState(frm)
{
	var arrRequiredElements=new Array('name','code','region');
	var arrRequiredElementsMessages=new Array('<fmt:message key="state.manage.label.name"/>','<fmt:message key="state.manage.label.code"/>','<fmt:message key="state.manage.label.region"/>');

	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
		{	
		var arrAlphaElements=new Array('name','code');
		var arrAlphaElementsMessages=new Array('<fmt:message key="state.manage.label.name"/>','<fmt:message key="state.manage.label.code"/>');
		if(isAlphaAray(new Array('name'),new Array('<fmt:message key="state.manage.label.name"/>'))){		
			if(isAlphanum(new Array('code'),new Array('<fmt:message key="state.manage.label.code"/>'))){
				navigate(frm,'<c:out value="${contextRoot}"/>/state/saveState.do');
			}
		}
		}
}
</script><script type="text/javascript">
function deleteState(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/state/deleteState.do');
}
}
</script>