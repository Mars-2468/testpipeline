<%@include file="/pages/common/include.jsp"%>
<%@ page import="com.mars.common.utils.Constants"%>
<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
%>

<div class="mainHdr">
	<h3>
		<c:choose>
			<c:when test="${permissionGroup.permissionGroupId==0}">
				<fmt:message key="permissionGroup.manage.pagetitle.new" />
			</c:when>
			<c:otherwise>
				<fmt:message key="permissionGroup.manage.pagetitle.edit" />
			</c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top"  id="SetFormHeight">
	<table border="0" cellpadding="2" cellspacing="2" class="dataForm">
		<tr>
			<td colspan="2">
				<spring:bind path="permissionGroup.permissionGroupId">
					<input type="hidden" id="permissionGroupId" name="permissionGroupId" value="<c:out value="${permissionGroup.permissionGroupId}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td width="75px">
				<span class="ClsLabel"><fmt:message key="permissionGroup.manage.label.name" />
				</span>
				<span class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="permissionGroup.name">
					<input type="text" class="ClsTextbox" id="name"  maxlength="255" name="name" value="<c:out value="${permissionGroup.name}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="padding-top:5px" height="10px"></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:savePermissionGroup(this.form);">
				<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
				<c:if test="${permissionGroup.permissionGroupId!=0}">
					<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deletePermissionGroup(this.form);">
				</c:if>
		</tr>
	</table>
</div>
<script type="text/javascript">
function savePermissionGroup(frm)
{
	var arrElements=new Array('name');
	var arrElementNames=new Array('<fmt:message key="permissionGroup.manage.label.name"/>');
	var alphaArrayElements = new Array('name');
	var msgArrayElements = new Array('<fmt:message key="permissionGroup.manage.label.name"/>');
	
	if(checkMandatoryDetailed(arrElements,arrElementNames)) {
		if(isAlphanum(alphaArrayElements,msgArrayElements))	
			if(isAlphaUndrsc(new Array('name'),new Array('<fmt:message key="permissionGroup.manage.label.name"/>'))){		
			navigate(frm,'<c:out value="${contextRoot}"/>/permissiongroup/savePermissionGroup.do');
			}
	}	
}
</script>
<script type="text/javascript">
function deletePermissionGroup(id)
{
	if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/permissiongroup/deletePermissionGroup.do');
	}
}
</script>
