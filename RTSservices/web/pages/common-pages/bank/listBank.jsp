<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
%>
<script type="text/javascript">
function editBank(id)
{
	document.getElementById('bankId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/bank/editBank.do');
}
function searchBank(){
	onPageSubmit('<c:out value="${contextRoot}"/>/bank/listBank.do');
}
</script>
<div class="mainHdr">
	<h3> <a href="<c:out value="${contextRoot}"/>/bank/editBank.do">
			<fmt:message key="bank.manage.pagetitle.new" /> 
		</a>
		<fmt:message key="bank.list.pagetitle.list" />
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
					<fmt:message key="bank.list.label.bankName" />
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchBankName" maxlength="100" size="50" 
						style="width:180px" name="searchBankName" 
						value="<c:out value="${SearchBank.bankName}"/>" />
					&nbsp;
				</td>
				<td colspan="2" align="right">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchBank()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchBank()" />
				</td>
			</tr>
		</table>
		<c:if test="${SearchBank.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>	
	<table class="dataGrid" cellpadding="0" cellspacing="1" width="98%">
		<thead>
				<tr>
					<td onclick="javascript:resort('upper(bankName)');" style="cursor: pointer" wrap>
					<fmt:message key="bank.list.label.bankName" /> <span id="upper(bankName)"></span></td>
				</tr>
		</thead>
		<tbody>
			<c:set var="hasRows" value="false" />
			<c:set var="hasRows" value="false" />
			<c:forEach var="BankList" items="${requestScope.BankList}" varStatus="rowNumber">
				<c:set var="hasRows" value="true" />
				<c:if test="${ rowNumber.count % 2 == 0 }">
					<c:set var="rowStyle" value="ClsTRContentListGrey" />
				</c:if>
				<tr>
					<td><a title="<fmt:message key="list.link.EditOrViewLink"/>"
						href="javascript:editBank('${BankList.bankId}');">
						 <c:out value="${BankList.bankName}" /></a>
					</td>
				</tr>
			</c:forEach>
			<c:if test="${hasRows == false}">
				<tr>
					<td colspan=2 class="clsNoRecords" align="center">
						<fmt:message key="list.label.norecords" />
					</td>
				</tr>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<c:if test="${requestScope.BankList != null && requestScope.totalCount>0}">
						<span><%@include file="/pages/common/pagination.jsp"%></span>
					</c:if>
				</td>
			</tr>
		</tfoot>
	</table>
	<input type="hidden" id="bankId" name="bankId" value="<c:out value="${bank.bankId}"/>" />
	<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
	<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" />
	<script type="text/javascript">
	insert_image('${contextRoot}');
	</script>
</div>