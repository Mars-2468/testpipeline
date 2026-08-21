<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<script type="text/javascript">
function editWard(id)
{
	document.getElementById('wardId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/ward/editWard.do');
}
function searchWard()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/ward/listWard.do');
}
</script>
<div class="mainHdr">
	<h3> <%-- <a href="<c:out value="${contextRoot}"/>/ward/editWard.do">
			<fmt:message key="ward.manage.pagetitle.new" /> 
		</a> --%>
		<fmt:message key="ward.list.pagetitle.list" />
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
					<fmt:message key="ward.list.label.name" />
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchName" maxlength="50" size="50" 
						style="width:150px" name="searchName" 
						value="<c:out value="${SearchWard.name}"/>" />
					&nbsp;
				</td>
			 	<td>
				<span class="ClsLabel"><fmt:message key="ward.manage.label.city" />
				</span>
			    </td>
				<td>				
					<select name="searchCityId" id="searchCityId">
						<option value=""><--- Select ---></option>
						<c:forEach var="city" items="${requestScope.cityList}">
							<c:choose>
								<c:when test="${SearchWard.cityId==city.cityId}">
									<option value="${city.cityId}" selected="selected">
										<c:out value="${city.name}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${city.cityId}">
										<c:out value="${city.name}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				
			</td>
				<td colspan="2">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchWard()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchWard()" />
				</td>
			</tr>
		</table>
		<c:if test="${SearchWard.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>	

<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
<thead>
<tr>
<td onclick="javascript:resort('upper(name)')" style="cursor:pointer" wrap>
<fmt:message key="ward.list.label.name"/>
<span id="upper(name)"></span></td>
<td onclick="javascript:resort('upper(code)')" style="cursor:pointer" wrap>
<fmt:message key="ward.list.label.code"/>
<span id="upper(code)"></span></td>
<td onclick="javascript:resort('upper(city.name)')" style="cursor:pointer" wrap>
<fmt:message key="ward.list.label.city"/>
<span id="upper(city.name)"></span></td>
<td onclick="javascript:resort('fasBranchCode')" style="cursor:pointer" wrap>
FAS Branch Code
<span id="fasBranchCode"></span></td>
</tr>
</thead>
<tbody>
<c:set var="hasRows" value="false" /><c:forEach var="WardList" items="${requestScope.WardList}" varStatus="rowNumber">
<c:set var="hasRows" value="true" />
<tr>
<td><%-- <a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editWard('${WardList.wardId}');">
<c:out value="${WardList.name}"/></a> --%>
<c:out value="${WardList.name}"/>
</td>
<td><c:out value="${WardList.code}"/></td>
<td><c:out value="${WardList.city.name}"/></td>
<td><c:out value="${WardList.fasBranchCode}"/></td>
</tr>
</c:forEach>
<c:if test="${hasRows == false}">
<tr>
<td colspan=4  class="clsNoRecords" align="center">
<fmt:message key="list.label.norecords"/></td></tr></c:if>
</tbody>
<tfoot>
<tr>
<td colspan="4">
<c:if test="${requestScope.WardList != null && requestScope.totalCount>0}">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</c:if>
</td>
</tr>
</tfoot>
</table>
<input type="hidden" id="wardId" name="wardId" value="<c:out value="${ward.wardId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>