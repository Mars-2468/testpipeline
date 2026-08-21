<%@include file="/pages/common/include.jsp"%>
<script type="text/javascript">
function editPermissionGroup(id)
{
	document.getElementById('permissionGroupId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/permissiongroup/editPermissionGroup.do');
}
function searchPermissionGroup() {
	thisForm = document.forms["frmPage"];
	thisForm.SearchClicked.value='true';convertSearchDate();
	onPageSubmit('<c:out value="${contextRoot}"/>/permissiongroup/listPermissionGroupBySearch.do');
	}
</script>
<div class="mainHdr">
	<h3> 
		<a href="<c:out value="${contextRoot}"/>/permissiongroup/editPermissionGroup.do">
			<fmt:message key="permissionGroup.list.label.create" /> 
		</a>
		<fmt:message key="permissionGroup.list.pagetitle.list" />
	</h3>
</div>
<div valign="top"  id="SetFormHeight">
	<div id="SearchDivId" class="ClsSearch">
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			<fmt:message key="search.label.heading" />
		</div>
		<table id="SearchTable" class="searchForm" style="display:none;">
		<tr>
		<td>
			<fmt:message key="permissionGroup.list.label.name" />
		</td>
			<td>
				<input type="text" class="ClsTextbox" id="searchName" maxlength="100" 
					style="width:250px;" name="searchName" value="<c:out value="${searchOptions.name}"/>" />
				&nbsp;
			</td>
		<td colspan="2">
					<input type="submit" class="ClsButton" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchPermissionGroup()" />
					&nbsp;
					<input type="submit" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchPermissionGroup()">
				</td>
				</tr>
				</table>
				<c:if test="${searchOptions.searchParamSet == true}">
					<script>
						ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
					</script>
				</c:if>	
				</div>			

<div valign="top"  id="SetFormHeight">
	<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
	<thead>
		<tr>
			<!-- <td><fmt:message key="permissionGroup.list.label.permissionGroupId"/></td>  -->
			<td onclick="javascript:resort('upper(name)')" style="cursor:pointer" wrap>
				<fmt:message key="permissionGroup.list.label.name" />
				<span id="upper(name)"></span>
			</td>
			<td>
				Permissions
			</td>
		</tr>
	</thead>	
	<tbody>	
		<c:forEach var="PermissionGroupList" items="${requestScope.PermissionGroupList}" varStatus="rowNumber">
			
			<c:if test="${ rowNumber.count % 2 == 0 }">
				<c:set var="rowStyle" value="ClsTRContentListGrey" />
			</c:if>
			<tr class="<c:out value="${rowStyle}"/>">
				<!-- <td><a href="javascript:editPermissionGroup('${PermissionGroupList.permissionGroupId}');"><c:out value="${PermissionGroupList.permissionGroupId}"/></a></td> -->
				<td>
					<a href="javascript:editPermissionGroup('<c:out value="${PermissionGroupList.permissionGroupId}"/>');"><c:out value="${PermissionGroupList.name}" /> </a>&nbsp;
				</td>
				<td>
					<c:if test="${not empty PermissionGroupList.permissionSet}">
						<c:forEach var="permissions" items="${PermissionGroupList.permissionSet}">
							<c:out value="${permissions.linkName}" /><br/>
						</c:forEach>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2">
				<c:if test="${requestScope.PermissionGroupList != null}">
					<span><%@include file="/pages/common/pagination.jsp"%> </span>
				</c:if>
			</td>
		</tr>
	</tfoot>
	</table>
	<input type="hidden" id="permissionGroupId" name="permissionGroupId" value="<c:out value="${permissionGroup.permissionGroupId}"/>" />

	<input type="hidden" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
	<input type="hidden" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" />
	 <input type="hidden" name="SearchClicked" id="SearchClicked" />
	<script type="text/javascript">
insert_image('<c:out value="${contextRoot}"/>');
</script>
</div>
