<%@include file="/pages/common/include.jsp"%>
<%@ page import="com.mars.common.utils.Constants"%>
<%
	    pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
%>
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${permission.permissionId==0}"><fmt:message key="permission.manage.pagetitle.new" /></c:when>
			<c:otherwise><fmt:message key="permission.manage.pagetitle.edit" /></c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top"  id="SetFormHeight">
	<table border="0" cellpadding="2" cellspacing="2" class="dataForm">
		<tr>
			<td colspan="2">
				<spring:bind path="permission.permissionId">
					<input type="hidden" id="permissionId" name="permissionId" value="<c:out value="${permission.permissionId}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td width="100px">
				<span class="ClsLabel"><fmt:message key="permission.label.linkName" /> </span><span class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="permission.linkName">
					<input type="text" style="width:300px" class="ClsTextbox" id="linkName" maxlength="255" name="linkName" value="<c:out value="${permission.linkName}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td width="100px">
				<span class="ClsLabel"><fmt:message key="permission.label.linkUrl" /> </span><span class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="permission.linkUrl">
					<input type="text" style="width:300px" class="ClsTextbox" id="linkUrl" maxlength="255" name="linkUrl" value="<c:out value="${permission.linkUrl}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td width="100px">
				<span class="ClsLabel"><fmt:message key="permission.label.permissionGroup" /> </span><span class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="permission.permissionGroup.permissionGroupId">
					<select name="permissionGroupId" id="permissionGroupId" style="width:310px" class="ClsTextbox">
						<option value="">
							<-- Select -->
						</option>
						<c:forEach var="permissionGroup" items="${requestScope.permissionGroupList}">
							<c:choose>
								<c:when test="${permission.permissionGroup.permissionGroupId==permissionGroup.permissionGroupId}">
									<option value="<c:out value="${permissionGroup.permissionGroupId}"/>" selected="selected">
										<c:out value="${permissionGroup.name}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="<c:out value="${permissionGroup.permissionGroupId}"/>">
										<c:out value="${permissionGroup.name}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="padding-top:5px" height="10px"></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="button" class="ClsButton" id="save" name="save" value="<fmt:message key="common.button.save"/>" onclick="javascript:savePermission();">
				<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearContorls();">
				<c:if test="${permission.permissionId!=0}">
					<input type="button" class="ClsButton" id="delete" name="delete" value="<fmt:message key="common.button.delete"/>" onclick="javascript:deletePermission(this.form);">
				</c:if>
		</tr>
	</table>
</div>
 <script type="text/javascript">
 /* function savePermission()
 {
		onPageSubmit('<c:out value="${contextRoot}"/>/permission/savePermission.do');

 } */
 
 function isAlphabet(inputElements, messages) {
	    for (var i = 0; i < inputElements.length; i++) {
	        var elementValue = document.getElementById(inputElements[i]).value;
	        var pattern = /^[a-zA-Z\s]+$/;
	        if (!pattern.test(elementValue)) {
	            alert(messages[i] + ' should contain only alphabets.');
	            return false;
	        }
	    }
	    return true;
	}
 
 function savePermission(frm)
 {
 	var arrElements=new Array('linkName','linkUrl','permissionGroupId');
 	var arrElementNames=new Array('<fmt:message key="permission.label.linkName"/>','<fmt:message key="permission.label.linkUrl"/>','<fmt:message key="permission.label.permissionGroup"/>');
 	var alphaArrayElements = new Array('linkName');
 	var msgArrayElements = new Array('<fmt:message key="permission.label.linkName"/>');
 	
 	if(checkMandatoryDetailed(arrElements,arrElementNames)) {
 		if(isAlphanum(alphaArrayElements,msgArrayElements))		
 			
 			if(isAlphabet(new Array('linkName'),new Array('<fmt:message key="permission.label.linkName"/>'))){
				if(isAlphaSpaceSlash(new Array('linkUrl'),new Array('<fmt:message key="permission.label.linkUrl"/>'))){	
 			navigate(frm,'<c:out value="${contextRoot}"/>/permission/savePermission.do');
 				}
 			}
     	}
 	} 
 
/* function savePermission(frm)
{
	var arrElements=new Array('linkName','linkUrl','permissionGroupId');
	var arrElementNames=new Array('<fmt:message key="permission.label.linkName"/>','<fmt:message key="permission.label.linkUrl"/>','<fmt:message key="permission.label.permissionGroup"/>');
	var alphaArrayElements = new Array('linkName');
	var msgArrayElements = new Array('<fmt:message key="permission.label.linkName"/>');
	
	if(checkMandatoryDetailed(arrElements,arrElementNames)) {
		if(isAlphanum(alphaArrayElements,msgArrayElements))	{	
			
			if(isAlphabet(new Array('linkName'),new Array('<fmt:message key="permission.label.linkName"/>'))){
				if(isAlphaArrayForTabs(new Array('linkUrl'),new Array('<fmt:message key="permission.label.linkUrl"/>'))){	
			navigate(frm,'<c:out value="${contextRoot}"/>/permission/savePermission.do');
				}
			}
		}
	}
} */
</script>
<script type="text/javascript">
function deletePermission(id)
{
	if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/permission/deletePermission.do');
	}
}
</script>
