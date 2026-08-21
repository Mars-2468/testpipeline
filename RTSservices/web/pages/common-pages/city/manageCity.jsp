<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%@include file="/pages/common/includeTransliterateJS.jsp"%>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
%>
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${city.cityId==0}">
				<fmt:message key="city.manage.pagetitle.new"/>
			</c:when>
			<c:otherwise>	
				<fmt:message key="city.manage.pagetitle.edit"/>
			</c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top" id="SetFormHeight">
<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
	<tr>
	<td colspan="2">
	<spring:bind path="city.cityId">
	<input type="hidden" id="cityId" name="cityId" value="<c:out value="${city.cityId}"/>" />
	</spring:bind>
	</td>
	</tr>
	
	<tr>
	<td>
	<span class="ClsLabel"><fmt:message key="city.manage.label.name"/></span><span class="ClsRequiredFields">*</span></td>
	<td>
	<spring:bind path="city.name">
	<input type="text" class="ClsTextbox" id="name" maxlength="45" name="name" value="<c:out value="${city.name}"/>" />
	</spring:bind>
	</td>
	<td>
	<span class="ClsLabel"><fmt:message key="city.manage.label.code"/></span><span class="ClsRequiredFields">*</span></td>
	<td>
	<spring:bind path="city.code">
	<input type="text" class="ClsTextbox" id="code" maxlength="10" name="code" value="<c:out value="${city.code}"/>" />
	</spring:bind>
	</td>
	</tr>
	<tr>
	<td>
	<span class="ClsLabel"><fmt:message key="city.manage.label.taluka"/></span><span class="ClsRequiredFields">*</span></td>
	<td>
	<spring:bind path="city.taluka.talukaId">
	<select name="talukaId" id="talukaId" style="width:240px" class="ClsTextbox">
	<option value=""> <--- Select ---> </option>
	<c:forEach var="taluka" items="${requestScope.talukaList}">
	<c:choose>
	<c:when test="${city.taluka.talukaId==taluka.talukaId}">
	<option value="${taluka.talukaId}" selected="selected">
	<c:out value="${taluka.name}"/>
	</option>
	</c:when>
	<c:otherwise>
	<option value="${taluka.talukaId}">
	<c:out value="${taluka.name}"/>
	</option>
	</c:otherwise>
	</c:choose>
	</c:forEach>
	</select>
	</spring:bind>
	</td>

	<td>
			<span class="ClsLabel"><fmt:message key="city.manage.label.category"/></span><span class="ClsRequiredFields">*</span>
	</td>
	<td>
			<spring:bind path="city.category.cityCategoryId">
				<select name="categoryId" id="categoryId"  style="width:240px" class="ClsTextbox">
					<option value=""> <-- Select Category --> </option>
						<c:forEach var="category" items="${requestScope.cityCategoryList}">
							<c:choose>
								<c:when test="${city.category.cityCategoryId==category.cityCategoryId}">
									<option value="${category.cityCategoryId}" selected="selected">
										<c:out value="${category.name}"/>
									</option>
								</c:when>
								<c:otherwise>
									<option value="${category.cityCategoryId}">
										<c:out value="${category.name}"/>
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
<span class="ClsLabel"><fmt:message key="city.manage.label.isTribal"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="city.isTribal">
<select name="isTribal" id="isTribal" style="width:240px" class="ClsTextbox">
	<option value=""><-- Select --></option> 
	<option value="<c:out value="${pageScope.STATUS_YES}"/>" <c:if test='${city.isTribal eq pageScope.STATUS_YES}'>selected="selected"</c:if>><c:out value="${pageScope.STATUS_YES_LABEL}"/></option>
	<option value="<c:out value="${pageScope.STATUS_NO}"/>" <c:if test='${city.isTribal eq pageScope.STATUS_NO}'>selected="selected"</c:if>><c:out value="${pageScope.STATUS_NO_LABEL}"/></option>
</select> 
</spring:bind>
</td>

<td>
<span class="ClsLabel"><fmt:message key="city.manage.label.isHill"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="city.isHill">
<select name="isHill" id="isHill" style="width:240px" class="ClsTextbox">
	<option value=""><-- Select --></option> 
	<option value="<c:out value="${pageScope.STATUS_YES}"/>" <c:if test='${city.isHill eq pageScope.STATUS_YES}'>selected="selected"</c:if>><c:out value="${pageScope.STATUS_YES_LABEL}"/></option>
	<option value="<c:out value="${pageScope.STATUS_NO}"/>" <c:if test='${city.isHill eq pageScope.STATUS_NO}'>selected="selected"</c:if>><c:out value="${pageScope.STATUS_NO_LABEL}"/></option>
</select> 
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="city.manage.label.isRemote"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="city.isRemote">
<select name="isRemote" id="isRemote" style="width:240px" class="ClsTextbox">
	<option value=""><-- Select --></option> 
	<option value="<c:out value="${pageScope.STATUS_YES}"/>" <c:if test='${city.isRemote eq pageScope.STATUS_YES}'>selected="selected"</c:if>><c:out value="${pageScope.STATUS_YES_LABEL}"/></option>
	<option value="<c:out value="${pageScope.STATUS_NO}"/>" <c:if test='${city.isRemote eq pageScope.STATUS_NO}'>selected="selected"</c:if>><c:out value="${pageScope.STATUS_NO_LABEL}"/></option>
</select> 
</spring:bind>
</td>

<td>
<span class="ClsLabel"><fmt:message key="city.manage.label.isBorder"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="city.isBorder">
<select name="isBorder" id="isBorder" style="width:240px" class="ClsTextbox">
	<option value=""><-- Select --></option> 
	<option value="<c:out value="${pageScope.STATUS_YES}"/>" <c:if test='${city.isBorder eq pageScope.STATUS_YES}'>selected="selected"</c:if>><c:out value="${pageScope.STATUS_YES_LABEL}"/></option>
	<option value="<c:out value="${pageScope.STATUS_NO}"/>" <c:if test='${city.isBorder eq pageScope.STATUS_NO}'>selected="selected"</c:if>><c:out value="${pageScope.STATUS_NO_LABEL}"/></option>
</select> 
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="city.manage.label.isIsland"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="city.isIsland">
<select name="isIsland" id="isIsland" style="width:240px" class="ClsTextbox">
	<option value=""><-- Select --></option> 
	<option value="<c:out value="${pageScope.STATUS_YES}"/>" <c:if test='${city.isIsland eq pageScope.STATUS_YES}'>selected="selected"</c:if>><c:out value="${pageScope.STATUS_YES_LABEL}"/></option>
	<option value="<c:out value="${pageScope.STATUS_NO}"/>" <c:if test='${city.isIsland eq pageScope.STATUS_NO}'>selected="selected"</c:if>><c:out value="${pageScope.STATUS_NO_LABEL}"/></option>
</select> 
</spring:bind>
</td>

<td>
<span class="ClsLabel"><fmt:message key="city.manage.label.isBadclimate"/></span><span class="ClsRequiredFields">*</span></td>
<td>
<spring:bind path="city.isBadclimate">
<select name="isBadclimate" id="isBadclimate" style="width:240px" class="ClsTextbox">
	<option value=""><-- Select --></option> 
	<option value="<c:out value="${pageScope.STATUS_YES}"/>" <c:if test='${city.isBadclimate eq pageScope.STATUS_YES}'>selected="selected"</c:if>><c:out value="${pageScope.STATUS_YES_LABEL}"/></option>
	<option value="<c:out value="${pageScope.STATUS_NO}"/>" <c:if test='${city.isBadclimate eq pageScope.STATUS_NO}'>selected="selected"</c:if>><c:out value="${pageScope.STATUS_NO_LABEL}"/></option>
</select> 
</spring:bind>
</td>
</tr>
	
	<tr>
	<td>
	<spring:bind path="city.status">
	<input type="hidden" id="status" maxlength="1" name="status" value="<c:out value="${city.status}"/>" />
	</spring:bind>
	</td>
	</tr>	
	<tr><td  colspan="2" style="padding-top:5px"></td></tr>
	<tr><td></td>
	<td>
	<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveCity(this.form);">
	<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
	<c:if test="${city.cityId!=0}">
	<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteCity(this.form);">
	</c:if>
	</tr>
</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/><script type="text/javascript">
function saveCity(frm)
{
	var arrRequiredElements=new Array('name','code','talukaId','categoryId','isTribal','isHill','isRemote','isBorder',
										'isIsland','isBadclimate');
	var arrRequiredElementsMessages=new Array('<fmt:message key="city.manage.label.name"/>',
											'<fmt:message key="city.manage.label.code"/>',
											'<fmt:message key="city.manage.label.taluka"/>',
											'<fmt:message key="city.manage.label.category"/>',
											'<fmt:message key="city.manage.label.isTribal"/>',
											'<fmt:message key="city.manage.label.isHill"/>',
											'<fmt:message key="city.manage.label.isRemote"/>',
											'<fmt:message key="city.manage.label.isBorder"/>',
											'<fmt:message key="city.manage.label.isIsland"/>',
											'<fmt:message key="city.manage.label.isBadclimate"/>'											
											);
	
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
		{	
			var arrAlphaElements=new Array('name','code');
			var arrAlphaElementsMessages=new Array('<fmt:message key="city.manage.label.name"/>',
													'<fmt:message key="city.manage.label.code"/>');
			if(isAlphaAray(new Array('name'),new Array('<fmt:message key="city.manage.label.name"/>'))){		
				if(isAlphanum(new Array('code'),new Array('<fmt:message key="city.manage.label.code"/>'))){
					navigate(frm,'<c:out value="${contextRoot}"/>/city/saveCity.do');
				}
			}
		}
}
</script><script type="text/javascript">
function deleteCity(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/city/deleteCity.do');
}
}
</script>