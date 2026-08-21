<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<script src="<c:out value="${contextRoot}"/>/dwr/interface/gisMastersList.js"></script>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<script type="text/javascript">
function editSector(id)
{
	document.getElementById('sectorId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/sector/editSector.do');
}
function searchSector()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/sector/listSector.do');
}
</script>
<div class="mainHdr">
	<h3> <%-- <a href="<c:out value="${contextRoot}"/>/sector/editSector.do">
			<fmt:message key="sector.manage.pagetitle.new" /> 
		</a> --%>
		<fmt:message key="sector.list.pagetitle.list" />
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
		      <td><fmt:message key="node.list.label.ward"/></td>
			<td>
			<select name="searchWardId" id="searchWardId" onchange="getNodeOnWard();">
				<option value=""><--- Select ---></option>
				<c:forEach var="searchWard" items="${requestScope.wardList}">
					<option value="${searchWard.wardId}" <c:if test="${SearchSector.wardId==searchWard.wardId}"> selected="selected" </c:if>>
						<c:out value="${searchWard.name}" />
					</option>
				</c:forEach>
			</select>
			</td>
			
			<td>
				<span class="ClsLabel"><fmt:message key="sector.manage.label.Node" />
				</span>
			    </td>
				<td>				
					<select name="searchNodeMasterId" id="searchNodeMasterId">
						<option value=""><--- Select ---></option>
						<c:forEach var="node" items="${requestScope.nodeList}">
							<c:choose>
								<c:when test="${SearchSector.nodeMasterId==node.nodeMasterId}">
									<option value="${node.nodeMasterId}" selected="selected">
										<c:out value="${node.name}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${node.nodeMasterId}">
										<c:out value="${node.name}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>				
			</td>
		    </tr>
		    
			<tr>
				<td>
					<fmt:message key="sector.list.label.name" />
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchName" maxlength="50" size="50" 
						style="width:150px" name="searchName" 
						value="<c:out value="${SearchSector.name}"/>" />
					&nbsp;
				</td>
			 	
				<td colspan="2">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchSector()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchSector()" />
				</td>
			</tr>
		</table>
		<c:if test="${SearchSector.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>

<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
<thead>
<tr>
<td onclick="javascript:resort('upper(name)')" style="cursor:pointer" wrap>
<fmt:message key="sector.list.label.name"/>
<span id="upper(name)"></span></td>
<td onclick="javascript:resort('upper(nodeMaster.name)')" style="cursor:pointer" wrap>
<fmt:message key="sector.list.label.Node"/>
<span id="upper(nodeMaster.name)"></span></td>
</tr>
</thead>
<tbody>
<c:set var="hasRows" value="false" />
<c:forEach var="SectorList" items="${requestScope.SectorList}" varStatus="rowNumber">
<c:set var="hasRows" value="true" />
<tr>
<td><%-- <a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editSector('${SectorList.sectorId}');">
<c:out value="${SectorList.name}"/></a> --%>
<c:out value="${SectorList.name}"/>
</td>
<td><c:out value="${SectorList.nodeMaster.name}"/></td>
</tr>
</c:forEach>
<c:if test="${hasRows == false}">
<tr>
<td colspan=3  class="clsNoRecords" align="center">
<fmt:message key="list.label.norecords"/></td></tr></c:if>
</tbody>
<tfoot>
<tr>
<td colspan="3">
<c:if test="${requestScope.SectorList != null && requestScope.totalCount>0}">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</c:if>
</td>
</tr>
</tfoot>
</table>
<input type="hidden" id="sectorId" name="sectorId" value="<c:out value="${sector.sectorId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
function getNodeOnWard()
{
	var wardId=document.getElementById("searchWardId").value;
    
    if(wardId != null && wardId > 0)
    {
	  gisMastersList.getNodesOnWard(wardId,setNodeOnWard);
    }else
    {
       var selectElement1 = document.getElementById("searchNodeMasterId");
  		removeAllOptions(selectElement1);
    }
}

function setNodeOnWard(dataList)
{	
	var selectElement = document.getElementById("searchNodeMasterId");
	removeAllOptions(selectElement);
	
	for(var i=1;i<=dataList.length;i++)
	{
		var optn = document.createElement("OPTION");
		optn.text = dataList[i-1].name;
		optn.value = dataList[i-1].nodeMasterId;
		if("${SearchSector.nodeMasterId}" == optn.value)
			optn.selected = true;
		selectElement.options.add(optn);
    }
}
getNodeOnWard();
</script>
</div>