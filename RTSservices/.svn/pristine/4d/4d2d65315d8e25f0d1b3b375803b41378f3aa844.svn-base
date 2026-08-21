<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<script src="<c:out value="${contextRoot}"/>/dwr/interface/bankBranch.js"></script>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<script type="text/javascript">
function editBankBranch(id)
{
	document.getElementById('bankBranchId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/bankbranch/editBankBranch.do');
}
function searchBankBranch()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/bankbranch/listBankBranch.do');
}
</script>
<div class="mainHdr">
	<h3> <a href="<c:out value="${contextRoot}"/>/bankbranch/editBankBranch.do">
			<fmt:message key="bankBranch.manage.pagetitle.new"/> 
		</a>
		<fmt:message key="bankBranch.list.pagetitle.list"/>
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
					<fmt:message key="bankBranch.list.label.branchName" />
				</td>
				<td>
					<input type="text" class="ClsAutoTextbox" id="searchBranchName" maxlength="100" size="50" 
						style="width:150px" name="searchBranchName" onkeyup="javascript:autoComplete(event,this.value)"
						value="<c:out value="${SearchBankBranch.branchName}"/>" />
					&nbsp;
				</td>
			 	<td>
				<span class="ClsLabel"><fmt:message key="bankBranch.manage.label.bank" />
				</span>
			    </td>
				<td>
				
					<select name="searchBankId" id="searchBankId">
						<option value="">
							<--- Select --->
						</option>
						<c:forEach var="bank" items="${requestScope.bankList}">
							<c:choose>
								<c:when test="${SearchBankBranch.bankId==bank.bankId}">
									<option value="${bank.bankId}" selected="selected">
										<c:out value="${bank.bankName}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${bank.bankId}">
										<c:out value="${bank.bankName}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				
			</td>
				<td colspan="2">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchBankBranch()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchBankBranch()" />
				</td>
			</tr>
		</table>
		<c:if test="${SearchBankBranch.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>	
 
<table class="dataGrid" cellpadding="0" cellspacing="1" width="98%">
<thead>
<tr>
<td onclick="javascript:resort('upper(branchName)')" style="cursor:pointer" wrap>
<fmt:message key="bankBranch.list.label.branchName"/>
<span id="upper(branchName)"></span></td>
<td onclick="javascript:resort('upper(bank.bankName)')" style="cursor:pointer" wrap>
<fmt:message key="bankBranch.list.label.bank"/>
<span id="upper(bank.bankName)"></span></td>
</tr>
</thead>
<tbody>
<c:set var="hasRows" value="false" />
<c:forEach var="BankBranchList" items="${requestScope.BankBranchList}" varStatus="rowNumber">
<c:set var="hasRows" value="true" />
<tr>
<td><a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editBankBranch('${BankBranchList.bankBranchId}');">
<c:out value="${BankBranchList.branchName}"/></a></td>
<td><c:out value="${BankBranchList.bank.bankName}"/></td>
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
<c:if test="${requestScope.BankBranchList != null && requestScope.totalCount>0}">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</c:if>
</td>
</tr>
</tfoot>
</table>
<input type="hidden" id="bankBranchId" name="bankBranchId" value="<c:out value="${bankBranch.bankBranchId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" />
<script type="text/javascript">
insert_image('${contextRoot}');

function autoComplete(eve, branchName){
	var keyPressCode=eve.charCode? eve.charCode : eve.keyCode;
	
	if(keyPressCode>48 && branchName.length>1){
		bankBranch.getBankBranchList(branchName, updateList);
	}
}

function updateList(data){
	var arrContents = new Array();
	if(data!=null && data.length > 1){
		for(i=0;i<data.length;i++){			
			arrContents[i]=data[i].branchName;
		}
	}
	$("#searchBranchName").autocomplete({
		minLength: 1,
		source: arrContents
	});
}
</script>
</div>