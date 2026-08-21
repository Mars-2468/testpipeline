<%@include file="/pages/common/include.jsp"%>
<script type="text/javascript">
function searchPermission() {
	convertSearchDate();
	onPageSubmit('<c:out value="${contextRoot}"/>/permission/listPermission.do');
}

function editPermission(id)
{
	document.getElementById('permissionId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/permission/editPermission.do');
}
</script>
<div class="mainHdr">
	<h3> <a href="<c:out value="${contextRoot}"/>/permission/editPermission.do">
			<fmt:message key="permission.manage.pagetitle.new" /> 
		</a>
		<fmt:message key="permission.list.pagetitle.list" />
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
				<fmt:message key="permission.label.linkName" />
			</td>
			<td>
				<input type="text" class="ClsTextbox" id="searchPermissionName"
					maxlength="50" size="50" style="width:300px" name="searchPermissionName"
					value="<c:out value="${SearchOptions.name}"/>" />&nbsp;
			</td>
			<td>			
				<fmt:message key="permission.label.linkUrl" />
			</td>
			<td>
				<input type="text" class="ClsTextbox" id="searchPermissionUrl"
					maxlength="50" size="50" style="width:300px" name="searchPermissionUrl"
					value="<c:out value="${SearchOptions.url}"/>" />&nbsp;
			</td>
		</tr>
		<tr>			
			<td>		
				<fmt:message key="permission.label.permissionGroup" />
			</td>
			<td>		
				<spring:bind path="SearchOptions.groupId">
					<select name="searchPermissionGroupId" id="searchPermissionGroupId" style="width:300px">
						<option value=""> <-- Select --> </option>
						<c:forEach var="permissionGroup" items="${requestScope.permissionGroupList}">
							<c:choose>
								<c:when test="${SearchOptions.groupId==permissionGroup.permissionGroupId}">
									<option value="<c:out value="${permissionGroup.permissionGroupId}"/>" selected="selected">
										<c:out value="${permissionGroup.name}"/>
									</option>
								</c:when>
								<c:otherwise>
									<option value="<c:out value="${permissionGroup.permissionGroupId}"/>">
										<c:out value="${permissionGroup.name}"/>
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</spring:bind>&nbsp;
			</td>			
			<td colspan="2">
				<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchPermission()"/>&nbsp;			
				<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchPermission()"/>		
			</td>					
		</tr>
	</table>
	<c:if test="${SearchOptions.searchParamSet == true}">
		<script>
			ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
		</script>
	</c:if>	
</div> 
<table border="0" cellpadding="0" cellspacing="0" width="98%" class="dataGrid" >
<thead>
<tr>
<td onclick="javascript:resort('upper(linkName)')" style="cursor:pointer" wrap><fmt:message key="permission.label.linkName"/><span id="upper(linkName)"></span></td>
<td onclick="javascript:resort('upper(linkUrl)')" style="cursor:pointer" wrap><fmt:message key="permission.label.linkUrl"/><span id="upper(linkUrl)"></span></td>
<td onclick="javascript:resort('(permissionGroup)')" style="cursor:pointer" wrap><fmt:message key="permission.label.permissionGroup"/><span id="upper(permissionGroup)"></span></td>
</tr>
</thead>
<tbody>
<c:forEach var="PermissionList" items="${requestScope.PermissionList}" varStatus="rowNumber">
<tr class="<c:out value="${rowStyle}"/>">
<td><a href="javascript:editPermission('<c:out value="${PermissionList.permissionId}"/>');"><c:out value="${PermissionList.linkName}"/></a>&nbsp;</td>
<td><c:out value="${PermissionList.linkUrl}"/>&nbsp;</td>
<td><c:out value="${PermissionList.permissionGroup.name}"/>&nbsp;</td>
</tr>
</c:forEach>
</tbody>
<tfoot>
<tr>
<td colspan="4">
<c:if test="${requestScope.PermissionList != null}">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</c:if>
</td>
</tr>
</tfoot>
</table>
<input type="hidden" id="permissionId" name="permissionId" value="<c:out value="${permission.permissionId}"/>" />
<input type="hidden" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('<c:out value="${contextRoot}"/>');
</script>
</div>