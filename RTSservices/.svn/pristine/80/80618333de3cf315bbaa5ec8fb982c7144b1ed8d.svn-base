<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>

<script type="text/javascript">
function editFeeType(id)
{
	document.getElementById('feeTypeId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/feeType/editFeeType.do');
}
function searchFeeType()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/feeType/listFeeType.do');
}
</script>

<div class="mainHdr">
	<h3> <a href="<c:out value="${contextRoot}"/>/feeType/editFeeType.do">
			<fmt:message key="feeType.manage.pagetitle.new" /> 
		</a>
		<fmt:message key="feeType.list.pagetitle.list" />
	</h3>
</div>
<div valign="top" id="SetFormHeight">

<div id="SearchDivId" class="ClsSearch">
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			<fmt:message key="search.label.heading" />
		</div>
		<table id="SearchTable" class="searchForm" style="display:none;">
			<tr>
				<td>
					<fmt:message key="feeType.manage.label.feeTypeName" />
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchName" maxlength="45" 
						style="width:150px" name="searchName" 
						value="<c:out value="${searchOptions.name}"/>" />
					&nbsp;
				</td>
			 
				
				<td colspan="2">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchFeeType()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchFeeType()" />
				</td>
			</tr>
		</table>
		<c:if test="${SearchFeeType.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>	

<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
	<thead>
		<tr>
			<td onclick="javascript:resort('upper(name)');" style="cursor: pointer" wrap>
				<fmt:message key="feeType.manage.label.feeTypeName" /> <span id="upper(name)"></span>
			</td>
		</tr>
	</thead>
	<tbody>
		<c:set var="hasRows" value="false" />
			<c:forEach var="feeTypeList" items="${requestScope.feeTypeList}" varStatus="rowNumber">
				<c:set var="hasRows" value="true" />	
					<tr>
						<td><a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editFeeType('${feeTypeList.feeTypeId}');">
							<c:out value="${feeTypeList.name}"/></a>
						</td>
					</tr>
			</c:forEach>
			
			<c:if test="${hasRows == false}">
				<tr>
					<td colspan=3  class="clsNoRecords" align="center">
						<fmt:message key="list.label.norecords"/>
					</td>
				</tr>
			</c:if>
	</tbody>
	
	<tfoot>
	<tr>
		<td colspan="3">
			<c:if test="${requestScope.feeTypeList != null && requestScope.totalCount>0}">
				<span><%@include file="/pages/common/pagination.jsp"%></span>
			</c:if>
		</td>
	</tr>
	</tfoot>
</table>
<input type="hidden" id="feeTypeId" name="feeTypeId" value="" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" />
<script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>