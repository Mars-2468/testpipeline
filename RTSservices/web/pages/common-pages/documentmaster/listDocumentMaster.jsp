<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("DOCUMENT_TYPE_GENERAL", Constants.DOCUMENT_TYPE_GENERAL);
pageContext.setAttribute("DOCUMENT_TYPE_FIELD_VERIFICATION", Constants.DOCUMENT_TYPE_FIELD_VERIFICATION);
pageContext.setAttribute("DOCUMENT_TYPE_GENERAL_LABEL",Constants.DOCUMENT_TYPE_GENERAL_LABEL);
pageContext.setAttribute("DOCUMENT_TYPE_FIELD_VERIFICATION_LABEL",Constants.DOCUMENT_TYPE_FIELD_VERIFICATION_LABEL);
%>
<script type="text/javascript">
function editDocumentMaster(id)
{
	document.getElementById('documentMasterId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/documentmaster/editDocumentMaster.do');
}
function searchDocumentMaster()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/documentmaster/listDocumentMaster.do');
}
</script>
<div class="mainHdr">
	<h3> <a href="<c:out value="${contextRoot}"/>/documentmaster/editDocumentMaster.do">
			<fmt:message key="documentMaster.manage.pagetitle.new" /> 
		</a>
		<fmt:message key="documentMaster.list.pagetitle.list" />
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
					<fmt:message key="documentMaster.list.label.description" />
				</td>
				<td>
						<input type="text" class="ClsTextbox" id="searchDescription" maxlength="100" 
						     style="width:250px;" name="searchDescription" 
                               value="<c:out value="${SearchDocumentMaster.description}"/>" />
					&nbsp;
				</td>
				
				<td>
                  <span class="ClsLabel"><fmt:message key="documentMaster.manage.label.stage"/></span>
                </td>
                <td>
                  <select name="searchStageId" id="searchStageId" class="ClsTextbox" style="width:240px">
                     <option value=""> <--- Select ---> </option>
                      <c:forEach var="stage" items="${requestScope.stageList}">
                        <c:choose>
                          <c:when test="${SearchDocumentMaster.stageId==stage.stageId}">
                            <option value="${stage.stageId}" selected="selected">
                              <c:out value="${stage.description}"/>
                            </option>
                          </c:when>
                          <c:otherwise>
                            <option value="${stage.stageId}">
                               <c:out value="${stage.description}"/>
                            </option>
                          </c:otherwise>
                       </c:choose> 
                     </c:forEach>
                 </select>
              </td>
  
				<td align="right">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchDocumentMaster()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchDocumentMaster()" />
				</td>
			</tr>
		</table>
		<c:if test="${SearchDocumentMaster.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>	

<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
<thead>
<tr>
<td onclick="javascript:resort('upper(description)')" style="cursor:pointer" wrap>
<fmt:message key="documentMaster.list.label.description"/>
<span id="upper(description)"></span></td>
<td onclick="javascript:resort('upper(stage.description)')" style="cursor:pointer" wrap>
<fmt:message key="documentMaster.list.label.stage"/>
<span id="upper(stage.description)"></span></td>
<td onclick="javascript:resort('documentType')" style="cursor:pointer" wrap>
<fmt:message key="documentMaster.manage.label.documentType"/>
<span id="documentType"></span></td>
</tr>
</thead>
<tbody>
<c:set var="hasRows" value="false" />
<c:forEach var="DocumentMasterList" items="${requestScope.DocumentMasterList}" varStatus="rowNumber">
<c:set var="hasRows" value="true" />
<tr>
<td><a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editDocumentMaster('${DocumentMasterList.documentMasterId}');">
<c:out value="${DocumentMasterList.description}"/></a></td>
<td><c:out value="${DocumentMasterList.stage.description}"/></td>
<td>
<c:choose>
<c:when test="${DocumentMasterList.documentType==pageScope.DOCUMENT_TYPE_GENERAL}">
 <c:out value="${pageScope.DOCUMENT_TYPE_GENERAL_LABEL}"/>
</c:when>
<c:otherwise>
 <c:out value="${pageScope.DOCUMENT_TYPE_FIELD_VERIFICATION_LABEL}"/>
</c:otherwise> 
 </c:choose>

</td>
</tr>
</c:forEach>
<c:if test="${hasRows == false}">
<tr>
<td colspan="3"  class="clsNoRecords" align="center">
<fmt:message key="list.label.norecords"/></td></tr></c:if>
</tbody>
<tfoot>
<tr>
<td colspan="3">
<c:if test="${requestScope.DocumentMasterList != null && requestScope.totalCount>0}">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</c:if>
</td>
</tr>
</tfoot>
</table>
<input type="hidden" id="documentMasterId" name="documentMasterId" value="<c:out value="${documentMaster.documentMasterId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>