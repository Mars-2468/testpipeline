<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants"/>
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
%>
<script type="text/javascript">
function editWorkflowTemplateUserMapping(id)
{
	document.getElementById('workflowTemplateUserMappingId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/workflowtemplateusermapping/editWorkflowTemplateUserMapping.do');
}
function searchWorkflowTemplateUserMapping()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/workflowtemplateusermapping/listWorkflowTemplateUserMapping.do');
}
</script>
<style>

.ClsTRHeaderList {
    background: #678dc5;
    font-weight: bold;
    color: white;
}
</style>
<div class="mainHdr">
	<h3> <a href="<c:out value="${contextRoot}"/>/workflowtemplateusermapping/editWorkflowTemplateUserMapping.do">
			<fmt:message key="workflowtemplateusermapping.manage.pagetitle.create"/>
		</a>
		<fmt:message key="workflowtemplateusermapping.list.pagetitle.list"/>
	</h3>
</div>

<div valign="top" class="ClsBlueGradientStrip" id="SetFormHeight">
<div id="SearchDivId" class="ClsSearch boxshadow">
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			<fmt:message key="search.label.heading" />
		</div>
<table id="SearchTable" class="searchForm" style="display:none;">
	<tr>
		<td colspan="2" style="padding-top: 5px"></td>
	</tr>
	<tr>
		<td width="150px">
			<span class="ClsLabel"><fmt:message key="workflowTemplateUserMapping.manage.label.workflowTemplate"/></span>
		</td>
		 <td width="200px">
				<select name="searchWorkflowTemplateId" id="searchWorkflowTemplateId" style="width:210px" class="ClsSelect">
					<option value=""> <--- Select workflowTemplate ---> </option>
					<c:forEach var="workflowTemplate" items="${requestScope.workflowTemplateList}">
						<option value="<c:out value="${workflowTemplate.workflowTemplateId}"/>" 
							<c:if test="${searchWorkflowTemplateUserMapping.workflowTemplateId==workflowTemplate.workflowTemplateId}">selected="selected"</c:if>>
							<c:out value="${workflowTemplate.workflowTemplateName}"/>
						</option>
					</c:forEach>
				</select>
		</td> 
		
		<td width="10px">
		</td>
		<td width="80px">
			<span class="ClsLabel"><fmt:message key="workflowTemplateUserMapping.manage.label.area"/></span>
		</td>
		<td>
			<select name="searchAreaId" id="searchAreaId" style="width:150px" class="ClsSelect">
				<option value=""> <--- Select area ---> </option>
					<c:forEach var="area" items="${requestScope.areaList}">
								<option value="<c:out value="${area.areaId}" />" 
									<c:if test="${searchWorkflowTemplateUserMapping.areaId==area.areaId}">selected="selected"</c:if>>
									<c:out value="${area.name}"/>
								</option>
					</c:forEach>
			</select>
		</td>
	</tr>
    <tr>
        <td colspan="5" align="center">
			<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchWorkflowTemplateUserMapping()" />
			&nbsp;
			<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');" />
		</td>
	</tr>
</table>
		<c:if test="${searchWorkflowTemplateUserMapping.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>

<table class="dataGrid"  class="dataGrid boxshadow" cellpadding="0" cellspacing="1" width="98%">
<thead>
	<tr class="ClsTRHeaderList">
	
 <!-- <td onclick="javascript:resort('workflowTemplateUserMappingId')" style="cursor:pointer" wrap>
	<fmt:message key="workflowTemplateUserMapping.list.label.workflowTemplateUserMappingId"/>
	<span id="workflowTemplateUserMappingId"></span></td>
	 -->
	
	<td><fmt:message key="workflowTemplateUserMapping.list.label.workflowTemplateUserMappingId"/></td>
	
	<td onclick="javascript:resort('workflowTemplate.workflowTemplateName')" style="cursor:pointer" wrap>
	<fmt:message key="workflowTemplateUserMapping.list.label.workflowTemplate"/>
	<span id="workflowTemplate.workflowTemplateName"></span></td>
	
	<td onclick="javascript:resort('area.name')" style="cursor:pointer" wrap>
	<fmt:message key="workflowTemplateUserMapping.list.label.area"/>
	<span id="area.name"></span></td>
	</tr>
</thead>
<tbody>
	<c:set var="hasRows" value="false" /><c:set var="rowStyle" value="" />
	<c:forEach var="WorkflowTemplateUserMappingList" items="${requestScope.WorkflowTemplateUserMappingList}" varStatus="rowNumber">
	<c:set var="rowStyle" value="ClsTRContentListWhite" /><c:set var="hasRows" value="true" />
	<c:if test="${ rowNumber.count % 2 == 0 }">
	<c:set var="rowStyle" value="ClsTRContentListGrey" /></c:if>
	<tr class="${rowStyle}">
	<td style="width: 125px"><a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editWorkflowTemplateUserMapping('${WorkflowTemplateUserMappingList.workflowTemplateUserMappingId}');">
	<c:out value="${WorkflowTemplateUserMappingList.workflowTemplateUserMappingId}"/></a></td>
	<td><c:out value="${WorkflowTemplateUserMappingList.workflowTemplate.workflowTemplateName}"/></td>
	<td><c:out value="${WorkflowTemplateUserMappingList.area.name}"/></td>
	</tr>
	</c:forEach>
	<c:if test="${hasRows == false}">
	<tr class="${rowStyle}">
	<td colspan=3  class="clsNoRecords" align="center">
	<fmt:message key="list.label.norecords"/></td></tr></c:if>
</tbody>
<tfoot>		
	<tr class="ClsTRHeaderList">
	<td colspan="3">
	<c:if test="${requestScope.WorkflowTemplateUserMappingList != null}">
	<span><%@include file="/pages/common/pagination.jsp"%></span>
	</c:if>
	</td>
	</tr>
</tfoot>
</table>
<input type="hidden" id="workflowTemplateUserMappingId" name="workflowTemplateUserMappingId" value="<c:out value="${workflowTemplateUserMapping.workflowTemplateUserMappingId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>