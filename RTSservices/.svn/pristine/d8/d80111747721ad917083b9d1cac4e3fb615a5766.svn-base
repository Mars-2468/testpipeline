<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<script type="text/javascript">
function editTaluka(id)
{
	document.getElementById('talukaId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/taluka/editTaluka.do');
}
function searchTaluka()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/taluka/listTaluka.do');
}
</script>
<div class="mainHdr">
	<h3> <%-- <a href="<c:out value="${contextRoot}"/>/taluka/editTaluka.do">
			<fmt:message key="taluka.manage.pagetitle.new" /> 
		</a> --%>
		<fmt:message key="taluka.list.pagetitle.list" />
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
					<fmt:message key="taluka.list.label.name" />
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchName" maxlength="45" size="50" 
						style="width:150px" name="searchName" 
						value="<c:out value="${SearchTaluka.name}"/>" />&nbsp;
				</td>
			 	<td>
				<span class="ClsLabel"><fmt:message key="taluka.manage.label.district" />
				</span>
			    </td>
				<td>
					<select name="searchDistrictId" id="searchDistrictId">
						<option value=""><--- Select ---></option>
						<c:forEach var="district" items="${requestScope.districtList}">
							<c:choose>
								<c:when test="${SearchTaluka.districtId==district.districtId}">
									<option value="${district.districtId}" selected="selected">
										<c:out value="${district.name}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${district.districtId}">
										<c:out value="${district.name}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
			</td>
				<td colspan="2">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchTaluka()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchTaluka()" />
				</td>
			</tr>
		</table>
		<c:if test="${SearchTaluka.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>	

<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
<thead>
	<tr>
		<td onclick="javascript:resort('upper(name)')" style="cursor:pointer" wrap>
			<fmt:message key="taluka.list.label.name"/>
			<span id="upper(name)"></span>
		</td>
		<td onclick="javascript:resort('upper(code)')" style="cursor:pointer" wrap>
			<fmt:message key="taluka.list.label.code"/>
			<span id="upper(code)"></span>
		</td>
		<td onclick="javascript:resort('upper(district.name)')" style="cursor:pointer" wrap>
			<fmt:message key="taluka.list.label.district"/>
			<span id="upper(district.name)"></span>
		</td>
	</tr>
	</thead>
	<tbody>
	<c:set var="hasRows" value="false" />
	<c:forEach var="TalukaList" items="${requestScope.TalukaList}" varStatus="rowNumber">
	<c:set var="hasRows" value="true" />
	
	<tr>
		<td>
			<%-- <a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editTaluka('${TalukaList.talukaId}');">
			<c:out value="${TalukaList.name}"/></a> --%>
			<c:out value="${TalukaList.name}"/>
		</td>
		<td><c:out value="${TalukaList.code}"/></td>
		<td><c:out value="${TalukaList.district.name}"/></td>
	</tr>
	</c:forEach>
	<c:if test="${hasRows == false}">
		<tr>
			<td colspan=4  class="clsNoRecords" align="center">
				<fmt:message key="list.label.norecords"/>
			</td>
		</tr>
	</c:if>
	</tbody>
	<tfoot>
	<tr>
		<td colspan="4">
			<c:if test="${requestScope.TalukaList != null && requestScope.totalCount>0}">
				<span><%@include file="/pages/common/pagination.jsp"%></span>
			</c:if>
		</td>
	</tr>
	</tfoot>
</table>
<input type="hidden" id="talukaId" name="talukaId" value="<c:out value="${taluka.talukaId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>