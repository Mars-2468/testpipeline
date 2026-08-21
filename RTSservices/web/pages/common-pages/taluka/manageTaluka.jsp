<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%@include file="/pages/common/includeTransliterateJS.jsp"%>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);%>
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${taluka.talukaId==0}"><fmt:message key="taluka.manage.pagetitle.new" /></c:when>
			<c:otherwise><fmt:message key="taluka.manage.pagetitle.edit" /></c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top"  id="SetFormHeight"><table border="0" cellpadding="2" cellspacing="2" class="dataForm">
<tr>
<td colspan="2">
<spring:bind path="taluka.talukaId">
<input type="hidden" id="talukaId" name="talukaId" value="<c:out value="${taluka.talukaId}"/>" />
</spring:bind>
</td>
</tr>

<td>
<span class="ClsLabel"><fmt:message key="taluka.manage.label.name"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="taluka.name">
<input type="text" class="ClsTextbox" id="name" maxlength="45" name="name" value="<c:out value="${taluka.name}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="taluka.manage.label.code"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="taluka.code">
<input type="text" class="ClsTextbox" id="code" maxlength="4" name="code" value="<c:out value="${taluka.code}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="taluka.manage.label.district"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="taluka.district.districtId">
<select name="districtId" id="districtId" class="ClsTextbox"  style="width:240px" >
<option value=""> <--- Select ---> </option>
<c:forEach var="district" items="${requestScope.districtList}">
<c:choose>
<c:when test="${taluka.district.districtId==district.districtId}">
<option value="${district.districtId}" selected="selected">
<c:out value="${district.name}"/>
</option>
</c:when>
<c:otherwise>
<option value="${district.districtId}">
<c:out value="${district.name}"/>
</option>
</c:otherwise>
</c:choose>
</c:forEach>
</select>
</spring:bind>
</td>
</tr>
<tr>
<!--<td><span class="ClsLabel"><fmt:message key="taluka.manage.label.status"/></span></td>-->
<td>
<spring:bind path="taluka.status">
<input type="hidden" id="status" maxlength="1" name="status" value="<c:out value="${taluka.status}"/>" />
</spring:bind>
</td>
</tr>
<tr><td  colspan="2" style="padding-top:5px"></td></tr>
<tr><td></td>
<td>
<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveTaluka(this.form);">
<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
<c:if test="${taluka.talukaId!=0}">
<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteTaluka(this.form);">
</c:if>
</tr>
</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/><script type="text/javascript">
function saveTaluka(frm)
{
	var arrRequiredElements=new Array('name','code','districtId');
	var arrRequiredElementsMessages=new Array('<fmt:message key="taluka.manage.label.name"/>','<fmt:message key="taluka.manage.label.code"/>','<fmt:message key="taluka.manage.label.district"/>');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
		{	
			var arrAlphaElements=new Array('name','code');
			var arrAlphaElementsMessages=new Array('<fmt:message key="taluka.manage.label.name"/>','<fmt:message key="taluka.manage.label.code"/>');
			if(isAlphaAray(new Array('name'),new Array('<fmt:message key="taluka.manage.label.name"/>'))){		
				if(isAlphanum(new Array('code'),new Array('<fmt:message key="taluka.manage.label.code"/>'))){		
					navigate(frm,'<c:out value="${contextRoot}"/>/taluka/saveTaluka.do');
				}
			}
		}
}
</script><script type="text/javascript">
function deleteTaluka(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/taluka/deleteTaluka.do');
}
}
</script>