<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants, com.mars.common.utils.CommonUtils"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("ACTIVE", Constants.ACTIVE);
pageContext.setAttribute("INACTIVE", Constants.INACTIVE);
pageContext.setAttribute("ACTIVE_LABEL", Constants.ACTIVE_LABEL);
pageContext.setAttribute("INACTIVE_LABEL", Constants.INACTIVE_LABEL);
/*  pageContext.setAttribute("statusList",CommonUtils.getStatus()); 
 */ 
 pageContext.setAttribute("DEFAULT_ROWS_PER_PAGE",Constants.DEFAULT_ROWS_PER_PAGE);%>
<script type="text/javascript">
function editDepartment(id)
{
	document.getElementById('departmentId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/department/editDepartment.do');
}

function searchDepartment(){
	onPageSubmit('<c:out value="${contextRoot}"/>/department/listDepartment.do');
}
</script>
<div class="mainHdr">
	<h3> 
		<fmt:message key="department.list.pagetitle.list"/>
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
					<fmt:message key="department.list.label.name" />
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchName" maxlength="100" size="50" 
						style="width:180px" name="searchName" 
						value="<c:out value="${SearchOptions.name}"/>" />
					&nbsp;
				</td>
				
				<td>
					<fmt:message key="department.manage.label.status" />
				</td>
				<td> 
				
					
					<select name="searchStatus" id="searchStatus" 
					class="validate[required] ClsTextbox" style="width: 95%">
						<option value=""><-- Select Status --></option>
					<c:forEach items="${pageScope.statusList}" var="statusList">
						<option value="${statusList[0]}"
						<c:if test="${SearchOptions.status == statusList[0]}">selected = "selected" </c:if>>
						<c:out value="${statusList[1]}" />
					    </option>
					</c:forEach>
                   </select>
					
					
					</td>
				
				<td colspan="2" align="right">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchDepartment()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchDepartment()" />
				</td>
			</tr>
		</table>
		<c:if test="${SearchOptions.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>	

	<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
		<thead>
			<tr>
				<td onclick="javascript:resort('upper(name)')" style="cursor:pointer" wrap>
				<fmt:message key="department.list.label.name"/>
				<span id="upper(name)"></span>
				</td>
				
				<%-- <td onclick="javascript:resort('(status)')" style="cursor:pointer" wrap>
				<fmt:message key="department.manage.label.status"/>
				<span id="upper(status)"></span>
				</td> --%>
			</tr>
		</thead>
		<tbody>
			<c:set var="hasRows" value="false" />
			<c:forEach var="departmentList" items="${requestScope.DepartmentList}" varStatus="rowNumber">
			<c:set var="hasRows" value="true" />
				<tr>
					<td><a title="<fmt:message key="list.link.EditOrViewLink"/>" 
					href="javascript:editDepartment('${departmentList.departmentId}');">
					<c:out value="${departmentList.name}"/> </a>
					</td>
				
					<%-- <td> 
						 <c:choose>
							<c:when test="${departmentList.status==pageScope.ACTIVE}">
								<c:out value="${pageScope.ACTIVE_LABEL }"></c:out>
							</c:when>
							<c:otherwise>
								<c:out value="${pageScope.INACTIVE_LABEL }"></c:out>
							</c:otherwise>
						</c:choose> 
					</td> --%>
				</tr>
			</c:forEach> 
			
			<c:if test="${hasRows == false}">
				<tr>
					<td colspan=2  class="clsNoRecords" align="center"><fmt:message key="list.label.norecords"/></td>
				</tr>
			</c:if>
		</tbody>
		
		<tfoot>
			<tr>
				<td colspan="2">
					<c:if test="${requestScope.DepartmentList != null}">
					<span><%@include file="/pages/common/pagination.jsp"%></span>
					</c:if>
				</td>
			</tr>
		</tfoot>
	</table>
<input type="hidden" id="departmentId" name="departmentId" value="<c:out value="${department.departmentId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
$(".viewTd").each(function () {
    $(this).html($(this).text());
});
</script>
</div>