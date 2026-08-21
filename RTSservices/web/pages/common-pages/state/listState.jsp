<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<script type="text/javascript">
function editState(id)
{
	document.getElementById('stateId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/state/editState.do');
}
function searchState(){
	onPageSubmit('<c:out value="${contextRoot}"/>/state/listState.do');
}
</script>
<div class="mainHdr">
	<h3> <%-- <a href="<c:out value="${contextRoot}"/>/state/editState.do">
			<fmt:message key="state.manage.pagetitle.new" /> 
		</a> --%>
		<fmt:message key="state.list.pagetitle.list" />
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
					<fmt:message key="state.list.label.name" />
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchName" maxlength="45" size="50" 
						style="width:150px" name="searchName" 
						value="<c:out value="${SearchState.name}"/>" />
					&nbsp;
				</td>
				<td colspan="2">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchState()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchState()" />
				</td>
			</tr>
		</table>
		<c:if test="${SearchState.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>	

<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
<thead>
<tr>
<td onclick="javascript:resort('upper(name)')" style="cursor:pointer" wrap>
<fmt:message key="state.list.label.name"/>
<span id="upper(name)"></span></td>
<td onclick="javascript:resort('upper(code)')" style="cursor:pointer" wrap>
<fmt:message key="state.list.label.code"/>
<span id="upper(code)"></span></td>
</tr>
</thead>
<tbody>
<c:set var="hasRows" value="false" />
<c:forEach var="StateList" items="${requestScope.StateList}" varStatus="rowNumber">
<c:set var="hasRows" value="true" />
<tr>
<td><%-- <a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editState('${StateList.stateId}');">
<c:out value="${StateList.name}"/></a> --%>
<c:out value="${StateList.name}"/>
</td>
<td><c:out value="${StateList.code}"/></td>
</tr>
</c:forEach>
<c:if test="${hasRows == false}">
<tr>
<td colspan=3  class="clsNoRecords" align="center">
<fmt:message key="list.label.norecords"/></td></tr>
</c:if>
</tbody>
<tfoot>
<tr>
<td colspan="3">
<c:if test="${requestScope.StateList != null && requestScope.totalCount>0}">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</c:if>
</td>
</tr>
</tfoot>
</table>
<input type="hidden" id="stateId" name="stateId" value="<c:out value="${state.stateId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>