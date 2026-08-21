<%@include file="/pages/common/include.jsp"%>
<script type="text/javascript">
function searchUser() {
	convertSearchDate();
	onPageSubmit('<c:out value="${contextRoot}"/>/user/listUser.do');
}

function editUser(id)
{
	document.getElementById('userId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/user/editUser.do');
}
</script>
<div class="mainHdr">
	<h3><a href="<c:out value="${contextRoot}"/>/user/saveAllJBPMUsers.do">
			<!-- <div class="status reverifyOn"
				id="usersync"
				title="Synch users with JBPM"
				style="cursor:pointer;float: left">
			</div>  -->
		</a>
		<a href="<c:out value="${contextRoot}"/>/user/editUser.do">
			<fmt:message key="user.manage.pagetitle.new" /> 
		</a>
		<fmt:message key="user.list.pagetitle.list" />
	</h3>
</div>

<div valign="top"  id="SetFormHeight">
	 <div id="SearchDivId" class="ClsSearch" >
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			<fmt:message key="search.label.heading" />
		</div>
		<table id="SearchTable" width="100%" cellpadding="2" cellspacing="2" border="0" style="display:none;padding-left:5px;">

			<tr>
				<td>			
					<fmt:message key="user.label.firstName" />
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchUserFirstName"
						maxlength="50" size="50" style="width:120px" name="searchUserFirstName"
						value="<c:out value="${SearchOptions.firstName}"/>" />&nbsp;
				</td>	
				<td>			
					<fmt:message key="user.label.lastName" />
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchUserLastName"
						maxlength="50" size="50" style="width:120px" name="searchUserLastName"
						value="<c:out value="${SearchOptions.lastName}"/>" />&nbsp;
				</td>	
			</tr>
			<tr>
				<td>			
					<fmt:message key="user.label.userName" />
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchUsername"
						maxlength="50" size="50" style="width:120px" name="searchUsername"
						value="<c:out value="${SearchOptions.username}"/>" />&nbsp;
				</td>

				<td colspan="2">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchUser()"/>&nbsp;			
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchUser()"/>		
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
		<!-- 	<td><fmt:message key="user.list.label.userId" /></td>  -->
			<td onclick="javascript:resort('upper(user.userName)')" style="cursor:pointer"
				wrap>
				<fmt:message key="user.label.userName" />
				<span id="upper(user.userName)"></span>
			</td>
			<td onclick="javascript:resort('upper(user.firstName)')" style="cursor:pointer"
				wrap>
				<fmt:message key="employee.manage.label.firstName" />
				<span id="upper(user.firstName)"></span>
			</td>
			<td onclick="javascript:resort('upper(user.lastName)')" style="cursor:pointer"
				wrap>
				<fmt:message key="employee.manage.label.lastName" />
				<span id="upper(user.lastName)"></span>
			</td>			
	
		</tr>
		</thead>
		<tbody>		
		<c:set var="hasRows" value="false" /><c:set var="rowStyle" value="" />
		<c:forEach var="UserList" items="${requestScope.UserList}"
			varStatus="rowNumber">	
			<c:set var="hasRows" value="true" />		
			<tr>
				<td>
					<a href="javascript:editUser('<c:out value="${UserList.userId}"/>');"><c:out value="${UserList.userName}" /></a>
				&nbsp;
				</td>
				<td>
					<c:out value="${UserList.firstName}" />
				&nbsp;
				</td>
				<td>
					<c:out value="${UserList.lastName}" />
				&nbsp;
				</td>				
			
			</tr>
		</c:forEach>
		
			<c:if test="${hasRows == false}">
			<tr class="${rowStyle}">
			<td colspan=2  class="clsNoRecords" align="center">
			<fmt:message key="list.label.norecords"/></td>
			</tr></c:if>
	
		</tbody>
		<tfoot>
		<tr>
			<td colspan="6">
				<c:if test="${requestScope.UserList != null}">
					<span><%@include file="/pages/common/pagination.jsp"%>
					</span>
				</c:if>
			</td>
		</tr>
		</tfoot>
	</table>
	<input type="hidden" id="userId" name="userId"
		value="<c:out value="${user.userId}"/>" />

	<input type="hidden" name="SortBy"
		value="<c:out value="${requestScope.SortBy}"/>" />
	<input type="hidden" name="OrderBy"
		value="<c:out value="${requestScope.OrderBy}"/>" />
	<script type="text/javascript">
insert_image('<c:out value="${contextRoot}"/>');
</script>
</div>
