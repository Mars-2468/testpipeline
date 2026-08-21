<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<script type="text/javascript">
function editPlotType(id)
{
	document.getElementById('plotTypeId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/plottype/editPlotType.do');
}
function searchPlotType()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/plottype/listPlotType.do');
}
</script>
<div class="mainHdr">
	<h3> <%-- <a href="<c:out value="${contextRoot}"/>/plottype/editPlotType.do">
			<fmt:message key="plotType.manage.pagetitle.new" /> 
		</a> --%>
		<fmt:message key="plotType.list.pagetitle.list" />
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
					<fmt:message key="plotType.list.label.description" />
				</td>
				<td>
					
						<input type="text" class="ClsTextbox" id="searchDescription" maxlength="50" 
						       style="width:150px;" name="searchDescription" 
                               value="<c:out value="${SearchPlotType.description}"/>" />
					&nbsp;
				</td>
				<td colspan="2">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchPlotType()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchPlotType()" />
				</td>
			</tr>
		</table>
		<c:if test="${SearchPlotType.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>	

<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
<thead>
<tr>
<td onclick="javascript:resort('upper(description)');" style="cursor: pointer" wrap>
	<fmt:message key="plotType.list.label.description" /> <span id="upper(description)"></span>
</td>
</tr>
</thead>
<tbody>
<c:set var="hasRows" value="false" />
<c:forEach var="PlotTypeList" items="${requestScope.PlotTypeList}" varStatus="rowNumber">
<c:set var="hasRows" value="true" />
<tr>
<td><%-- <a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editPlotType('${PlotTypeList.plotTypeId}');">
<c:out value="${PlotTypeList.description}"/></a> --%>
<c:out value="${PlotTypeList.description}"/></a>
</td>
</tr>
</c:forEach>
<c:if test="${hasRows == false}">
<tr>
<td colspan=1  class="clsNoRecords" align="center">
<fmt:message key="list.label.norecords"/></td></tr></c:if>
</tbody>
<tfoot>
<tr>
<td colspan="1">
<c:if test="${requestScope.PlotTypeList != null && requestScope.totalCount>0}">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</c:if>
</td>
</tr>
</tfoot>
</table>
<input type="hidden" id="plotTypeId" name="plotTypeId" value="<c:out value="${plotType.plotTypeId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>