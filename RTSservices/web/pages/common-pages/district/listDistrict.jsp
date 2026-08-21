<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<script type="text/javascript">
function editDistrict(id)
{
	document.getElementById('districtId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/district/editDistrict.do');
}
function searchDistrict(){
	onPageSubmit('<c:out value="${contextRoot}"/>/district/listDistrict.do');
}
</script>
<div class="mainHdr">
	<h3> <%-- <a href="<c:out value="${contextRoot}"/>/district/editDistrict.do">
			<fmt:message key="district.manage.pagetitle.new" /> 
		</a> --%>
		<fmt:message key="district.list.pagetitle.list" />
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
					<fmt:message key="district.list.label.name" />
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchName" maxlength="45" size="50" 
						style="width:150px" name="searchName" 
						value="<c:out value="${SearchDistrict.name}"/>" />
					&nbsp;
				</td>
			 	<td>
				<span class="ClsLabel"><fmt:message key="district.list.label.state" />
				</span>
			    </td>
				<td>
				
					<select name="searchStateId" id="searchStateId">
						<option value="">
							<--- Select --->
						</option>
						<c:forEach var="state" items="${requestScope.stateList}">
							<c:choose>
								<c:when test="${SearchDistrict.stateId==state.stateId}">
									<option value="${state.stateId}" selected="selected">
										<c:out value="${state.name}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${state.stateId}">
										<c:out value="${state.name}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				
			</td>
				<td colspan="2">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchDistrict()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchDistrict()" />
				</td>
			</tr>
		</table>
		<c:if test="${SearchDistrict.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>	
 

<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
<thead>
<tr>
<td onclick="javascript:resort('upper(name)')" style="cursor:pointer" wrap>
<fmt:message key="district.list.label.name"/>
<span id="upper(name)"></span></td>
<td onclick="javascript:resort('upper(code)')" style="cursor:pointer" wrap>
<fmt:message key="district.list.label.code"/>
<span id="upper(code)"></span></td>
<td onclick="javascript:resort('upper(state.name)')" style="cursor:pointer" wrap>
<fmt:message key="district.list.label.state"/>
<span id="upper(state.name)"></span></td>
</tr>
</thead>
<tbody>
<c:set var="hasRows" value="false" />
<c:forEach var="DistrictList" items="${requestScope.DistrictList}" varStatus="rowNumber">
<c:set var="hasRows" value="true" />
<tr>
<td><%-- <a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editDistrict('${DistrictList.districtId}');">
<c:out value="${DistrictList.name}"/></a> --%>
<c:out value="${DistrictList.name}"/>
</td>
<td><c:out value="${DistrictList.code}"/></td>
<td><c:out value="${DistrictList.state.name}"/></td>
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
<c:if test="${requestScope.DistrictList != null && requestScope.totalCount>0}">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</c:if>
</td>
</tr>
</tfoot>
</table>
<input type="hidden" id="districtId" name="districtId" value="<c:out value="${district.districtId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>