<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<script type="text/javascript">
function editNode(id)
{
	document.getElementById('nodeMasterId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/nodemaster/editNodeMaster.do');
}
function searchNode()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/nodemaster/listNodeMaster.do');
}
</script>
<div class="mainHdr">
	<h3> <%-- <a href="<c:out value="${contextRoot}"/>/nodemaster/editNodeMaster.do">
			<fmt:message key="node.manage.pagetitle.new" /> 
		</a> --%>
		<fmt:message key="node.list.pagetitle.list" />
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
					<fmt:message key="node.list.label.name" />
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchName" maxlength="50" size="50" 
						style="width:150px" name="searchName" 
						value="<c:out value="${SearchNodeMaster.name}"/>" />
					&nbsp;
				</td>
			 	<td>
				<span class="ClsLabel"><fmt:message key="node.manage.label.ward" />
				</span>
			    </td>
				<td>				
					<select name="searchWardId" id="searchWardId">
						<option value="">
							<--- Select --->
						</option>
						<c:forEach var="ward" items="${requestScope.wardList}">
							<c:choose>
								<c:when test="${SearchNodeMaster.wardId==ward.wardId}">
									<option value="${ward.wardId}" selected="selected">
										<c:out value="${ward.name}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${ward.wardId}">
										<c:out value="${ward.name}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				
			</td>
				<td colspan="2">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchNode()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchNode()" />
				</td>
			</tr>
		</table>
		<c:if test="${SearchNodeMaster.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>

<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
<thead>
<tr>
<td onclick="javascript:resort('upper(name)')" style="cursor:pointer" wrap>
<fmt:message key="node.list.label.name"/>
<span id="upper(name)"></span></td>
<td onclick="javascript:resort('upper(code)')" style="cursor:pointer" wrap>
<fmt:message key="node.list.label.code"/>
<span id="upper(code)"></span></td>
<td onclick="javascript:resort('upper(ward.name)')" style="cursor:pointer" wrap>
<fmt:message key="node.list.label.ward"/>
<span id="upper(ward.name)"></span></td>
</tr>
</thead>
<tbody>
<c:set var="hasRows" value="false" />
<c:forEach var="NodeList" items="${requestScope.NodeList}" varStatus="rowNumber">
<c:set var="hasRows" value="true" />
<tr>
<td><%-- <a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editNode('${NodeList.nodeMasterId}');">
<c:out value="${NodeList.name}"/></a> --%>
<c:out value="${NodeList.name}"/>
</td>
<td><c:out value="${NodeList.code}"/></td>
<td><c:out value="${NodeList.ward.name}"/></td>
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
<c:if test="${requestScope.NodeList != null && requestScope.totalCount>0}">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</c:if>
</td>
</tr>
</tfoot>
</table>
<input type="hidden" id="nodeMasterId" name="nodeMasterId" value="<c:out value="${node.nodeMasterId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>