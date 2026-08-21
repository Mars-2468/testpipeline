<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;" />
<%@include file="/pages/common/includeTransliterateJS.jsp"%>
<%
	    pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	    pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
%>
<div class="mainHdr">
	<h3>
		<c:choose>
			<c:when test="${ward.wardId==0}">
				<fmt:message key="ward.manage.pagetitle.new" />
			</c:when>
			<c:otherwise>
				<fmt:message key="ward.manage.pagetitle.edit" />
				<a href="#" onclick="editAssignedSectors();">		
					<span class="ClsLabel">Assign Sectors</span>
				</a>	
			</c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<table border="0" cellpadding="2" cellspacing="2" class="dataForm">
		<tr>
			<td colspan="2">
				<spring:bind path="ward.wardId">
					<input type="hidden" id="wardId" name="wardId" value="<c:out value="${ward.wardId}"/>" />
				</spring:bind>
			</td>
		</tr>
		
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="ward.manage.label.name" />
				</span><span class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="ward.name">
					<input type="text" class="ClsTextbox" id="name" maxlength="50" name="name" value="<c:out value="${ward.name}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="ward.manage.label.code" />
				</span><span class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="ward.code">
					<input type="text" class="ClsTextbox" id="code" maxlength="10" name="code" value="<c:out value="${ward.code}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="ward.manage.label.city" />
				</span><span class="ClsRequiredFields">*</span>
			</td>
			<td colspan="2">
				<spring:bind path="ward.city.cityId">
					<select name="cityId" id="cityId" style="width:240px" class="ClsTextbox">
						<option value="">
							<--- Select --->
						</option>
						<c:forEach var="city" items="${requestScope.cityList}">
							<c:choose>
								<c:when test="${ward.city.cityId==city.cityId}">
									<option value="${city.cityId}" selected="selected">
										<c:out value="${city.name}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${city.cityId}">
										<c:out value="${city.name}" />
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
				<span class="ClsLabel">FAS Branch Code
				</span><span class="ClsRequiredFields">*</span>
			</td>
			<td colspan="2">
				<spring:bind path="ward.fasBranchCode">
					<input type="text" class="ClsTextbox" id="fasBranchCode" maxlength="5" size="5" name="fasBranchCode" value="<c:out value="${ward.fasBranchCode}"/>" />
				</spring:bind>
			</td>
		</tr>		
		
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="ward.manage.label.addressLine1" />
				</span>
			</td>
			<td>
				<spring:bind path="ward.addressLine1">
					<input type="text" class="ClsTextbox" id="addressLine1" maxlength="100" name="addressLine1" value="<c:out value="${ward.addressLine1}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="ward.manage.label.addressLine2" />
				</span>
			</td>
			<td>
				<spring:bind path="ward.addressLine2">
					<input type="text" class="ClsTextbox" id="addressLine2" maxlength="100" name="addressLine2" value="<c:out value="${ward.addressLine2}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="ward.manage.label.addressLine3" />
				</span>
			</td>
			<td>
				<spring:bind path="ward.addressLine3">
					<input type="text" class="ClsTextbox" id="addressLine3" maxlength="100" name="addressLine3" value="<c:out value="${ward.addressLine3}"/>" />
				</spring:bind>
			</td>
		</tr>

		<tr>
			<!--<td><span class="ClsLabel"><fmt:message key="ward.manage.label.status"/></span></td>-->
			<td>
				<spring:bind path="ward.status">
					<input type="hidden" id="status" maxlength="1" name="status" value="<c:out value="${ward.status}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="padding-top:5px"></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveWard(this.form);">
				<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
				<c:if test="${ward.wardId!=0}">
					<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteWard(this.form);">
				</c:if>
		</tr>
	</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>" />
<script type="text/javascript">
function saveWard(frm)
{
	var arrRequiredElements=new Array('name','code','cityId','fasBranchCode');
	var arrRequiredElementsMessages=new Array('<fmt:message key="ward.manage.label.name"/>','<fmt:message key="ward.manage.label.code"/>','<fmt:message key="ward.manage.label.city"/>','FAS Branch Code');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
		{	var arrAlphaElements=new Array('name','code');
		var arrAlphaElementsMessages=new Array('<fmt:message key="ward.manage.label.name"/>','<fmt:message key="ward.manage.label.code"/>');
		if(isAlphaAray(new Array('name'),new Array('<fmt:message key="ward.manage.label.name"/>'))){		
			if(isAlphanum(new Array('code'),new Array('<fmt:message key="ward.manage.label.code"/>'))){
				navigate(frm,'<c:out value="${contextRoot}"/>/ward/saveWard.do');
			}			
		}
	}
}
</script>
<script type="text/javascript">
function deleteWard(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/ward/deleteWard.do');
}
}

function editAssignedSectors()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/ward/editAssignedSectors.do');
}
</script>
