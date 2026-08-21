<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<script type="text/javascript">
function editCity(id)
{
	document.getElementById('cityId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/city/editCity.do');
}
function searchCity()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/city/listCity.do');
}
</script>
<div class="mainHdr">
	<h3> <%-- <a href="<c:out value="${contextRoot}"/>/city/editCity.do">
			<fmt:message key="city.manage.pagetitle.new"/> 
		</a> --%>
		<fmt:message key="city.list.pagetitle.list"/>
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
					<fmt:message key="city.list.label.name" />
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchName" maxlength="45" 
						style="width:150px" name="searchName" 
						value="<c:out value="${SearchCity.name}"/>" />
					&nbsp;
				</td>
			 	<td>
				<span class="ClsLabel"><fmt:message key="city.manage.label.taluka" />
				</span>
			    </td>
				<td>				
					<select name="searchTalukaId" id="searchTalukaId">
						<option value=""><--- Select ---></option>
						<c:forEach var="taluka" items="${requestScope.talukaList}">
							<c:choose>
								<c:when test="${SearchCity.talukaId==taluka.talukaId}">
									<option value="${taluka.talukaId}" selected="selected">
										<c:out value="${taluka.name}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${taluka.talukaId}">
										<c:out value="${taluka.name}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				
			</td>
				<td colspan="2">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchCity()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchCity()" />
				</td>
			</tr>
		</table>
		<c:if test="${SearchCity.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>	

<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
	<thead>
	<tr>
		<td onclick="javascript:resort('upper(name)')" style="cursor:pointer" wrap>
		<fmt:message key="city.list.label.name"/>
		<span id="upper(name)"></span></td>
		<td onclick="javascript:resort('upper(code)')" style="cursor:pointer" wrap>
		<fmt:message key="city.list.label.code"/>
		<span id="upper(code)"></span></td>
		<td onclick="javascript:resort('upper(taluka.name)')" style="cursor:pointer" wrap>
		<fmt:message key="city.list.label.taluka"/>
		<span id="upper(taluka.name)"></span></td>
	</tr>
	</thead>
	<tbody>
	<c:set var="hasRows" value="false" />
	<c:forEach var="CityList" items="${requestScope.CityList}" varStatus="rowNumber">
	<c:set var="hasRows" value="true" />	
	<tr>
		<td><%-- <a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editCity('${CityList.cityId}');">
		<c:out value="${CityList.name}"/></a> --%>
		<c:out value="${CityList.name}"/>
		</td>
		<td><c:out value="${CityList.code}"/></td>
		<td><c:out value="${CityList.taluka.name}"/></td>
	</tr>
	</c:forEach>
	<c:if test="${hasRows == false}">
	<tr>
		<td colspan=3  class="clsNoRecords" align="center">
		<fmt:message key="list.label.norecords"/></td>
	</tr></c:if>
	</tbody>
	<tfoot>
	<tr>
		<td colspan="3">
		<c:if test="${requestScope.CityList != null && requestScope.totalCount>0}">
		<span><%@include file="/pages/common/pagination.jsp"%></span>
		</c:if>
		</td>
	</tr>
	</tfoot>
</table>
<input type="hidden" id="cityId" name="cityId" value="<c:out value="${city.cityId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>