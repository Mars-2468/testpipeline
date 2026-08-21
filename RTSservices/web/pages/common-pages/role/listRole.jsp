<%@include file="/pages/common/include.jsp"%>
<script type="text/javascript">
function searchRole() {
	convertSearchDate();
	onPageSubmit('<c:out value="${contextRoot}"/>/role/listRole.do');
}

function editRole(id)
{
	document.getElementById('roleId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/role/editRole.do');
}
</script>
<div class="mainHdr">
	<h3> <a href="<c:out value="${contextRoot}"/>/role/editRole.do">
			<fmt:message key="role.manage.pagetitle.new" /> 
		</a>
		<fmt:message key="role.list.pagetitle.list" />
	</h3>
</div>
<div valign="top"  id="SetFormHeight">
<div id="SearchDivId" class="ClsSearch">
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			<fmt:message key="search.label.heading" />
		</div>
		<table id="SearchTable" cellpadding="2" cellspacing="1" border="0" style="display:none;padding-left:5px;">
		<tr>
			<td>			
				<fmt:message key="role.label.role_name" />
			</td>
			<td>
				<input type="text" class="ClsTextbox" id="searchRoleName"
					maxlength="50" size="50" style="width:120px" name="searchRoleName"
					value="<c:out value="${SearchOptions.roleName}"/>" />&nbsp;
			</td>	
			<td colspan="2">
				<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchRole()"/>&nbsp;			
				<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchRole()"/>		
			</td>					
		</tr>
	</table>
	<c:if test="${SearchOptions.searchParamSet == true}">
		<script>
			ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
		</script>
	</c:if>
</div>

<table cellpadding="0" cellspacing="0" width="98%" class="dataGrid">
	<thead>
		<tr>
			<td onclick="javascript:resort('upper(role_name)')" style="cursor:pointer" wrap>
			<fmt:message key="role.label.role_name"/><span id="upper(role_name)"></span>
			</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="RoleList" items="${requestScope.RoleList}" varStatus="rowNumber">
		<tr class="<c:out value="${rowStyle}"/>">
		<td><a href="javascript:editRole('<c:out value="${RoleList.roleId}"/>');"><c:out value="${RoleList.role_name}"/></a>&nbsp;</td>
		</tr>
		</c:forEach>
	</tbody>
	
	<tfoot>
		<tr>
			<td colspan="2">
				<c:if test="${requestScope.RoleList != null}">
					<span><%@include file="/pages/common/pagination.jsp"%></span>
				</c:if>
			</td>
		</tr>
	</tfoot>
</table>
<input type="hidden" id="roleId" name="roleId" value="<c:out value="${role.roleId}"/>" />

<input type="hidden" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('<c:out value="${contextRoot}"/>');
</script>
</div>