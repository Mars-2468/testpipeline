<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%@include file="/pages/common/includeTransliterateJS.jsp"%>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);%>
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${district.districtId==0}"><fmt:message key="district.manage.pagetitle.new" /> </c:when>
			<c:otherwise><fmt:message key="district.manage.pagetitle.edit" /></c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top"  id="SetFormHeight">
<table border="0" cellpadding="2" cellspacing="2" class="dataForm">
<tr>
<td colspan="2">
<spring:bind path="district.districtId">
<input type="hidden" id="districtId" name="districtId" value="<c:out value="${district.districtId}"/>" />
</spring:bind>
</td>
</tr>

<tr>
<td>
<span class="ClsLabel"><fmt:message key="district.manage.label.name"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="district.name">
<input type="text" class="ClsTextbox" id="name" maxlength="45" name="name" value="<c:out value="${district.name}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="district.manage.label.code"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="district.code">
<input type="text" class="ClsTextbox" id="code" maxlength="2" name="code" value="<c:out value="${district.code}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="district.manage.label.state"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="district.state.stateId">
<select name="stateId" id="stateId"  style="width:240px" class="ClsTextbox">
<option value=""> <--- Select ---> </option>
<c:forEach var="state" items="${requestScope.stateList}">
<c:choose>
<c:when test="${district.state.stateId==state.stateId}">
<option value="${state.stateId}" selected="selected">
<c:out value="${state.name}"/>
</option>
</c:when>
<c:otherwise>
<option value="${state.stateId}">
<c:out value="${state.name}"/>
</option>
</c:otherwise>
</c:choose>
</c:forEach>
</select>
</spring:bind>
</td>
</tr>
<tr>
<td>
<spring:bind path="district.status">
<input type="hidden" id="status" maxlength="1" name="status" value="<c:out value="${district.status}"/>" />
</spring:bind>
</td>
</tr>
<tr><td  colspan="2" style="padding-top:5px"></td></tr>
<tr><td></td>
<td>
<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveDistrict(this.form);">
<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
<c:if test="${district.districtId!=0}">
<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteDistrict(this.form);">
</c:if>
</tr>
</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/><script type="text/javascript">
function saveDistrict(frm)
{
	var arrRequiredElements=new Array('name','code','stateId');
	var arrRequiredElementsMessages=new Array('<fmt:message key="district.manage.label.name"/>','<fmt:message key="district.manage.label.code"/>','<fmt:message key="district.manage.label.state"/>');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
		{	
			var arrAlphaElements=new Array('name','code');
			var arrAlphaElementsMessages=new Array('<fmt:message key="district.manage.label.name"/>','<fmt:message key="district.manage.label.code"/>');
			if(isAlphaAray(new Array('name'),new Array('<fmt:message key="district.manage.label.name"/>'))){		
				if(isAlphanum(new Array('code'),new Array('<fmt:message key="district.manage.label.code"/>'))){
					navigate(frm,'<c:out value="${contextRoot}"/>/district/saveDistrict.do');
				}
			}
		}
}
</script><script type="text/javascript">
function deleteDistrict(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/district/deleteDistrict.do');
}
}
</script>