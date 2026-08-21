<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants"/>
<jsp:directive.page	import="com.mars.common.utils.CommonUtils"/>
<jsp:directive.page	import="com.mars.rti.utils.CoreConstants"/>

<% 
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("LABEL_RADIO_FEE_CATEGORY_BPL",CoreConstants.LABEL_RADIO_FEE_CATEGORY_BPL);
pageContext.setAttribute("LABEL_RADIO_FEE_CATEGORY_NON_BPL",CoreConstants.LABEL_RADIO_FEE_CATEGORY_NON_BPL);
pageContext.setAttribute("FEE_CATEGORY_BPL",CoreConstants.FEE_CATEGORY_BPL);
pageContext.setAttribute("FEE_CATEGORY_NON_BPL",CoreConstants.FEE_CATEGORY_NON_BPL);
%>

<script type="text/javascript">
function editFeeMaster(id)
{
	document.getElementById('feeMasterId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/feemaster/editFeeMaster.do');
}
function searchFeeMaster()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/feemaster/listFeeMaster.do');
}
</script>

<div class="mainHdr">
	<h3> <a href="<c:out value="${contextRoot}"/>/feemaster/editFeeMaster.do">
			<fmt:message key="feeMaster.manage.pagetitle.new" /> 
		</a>
		<fmt:message key="feemaster.list.pagetitle.list" />
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
					<fmt:message key="feeMaster.manage.label.name" />
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchName" maxlength="45" 
						style="width:150px" name="name" 
						value="<c:out value="${SearchFeeMaster.name}"/>" />
					&nbsp;
				</td>
			 <td>
					<fmt:message key="rtiApplication.manage.label.category" />
				</td>
				
				
				
				<td>
					<input type="radio"
						id="category<c:out value="${pageScope.LABEL_RADIO_FEE_CATEGORY_BPL}"/>"
						name="category"
						value="<c:out value="${pageScope.FEE_CATEGORY_BPL}"/>"
						<c:if test="${SearchFeeMaster.category eq pageScope.FEE_CATEGORY_BPL}">checked="checked"</c:if> />
					<label
						for="category<c:out value="${pageScope.LABEL_RADIO_FEE_CATEGORY_BPL}"/>"><c:out
							value="${pageScope.LABEL_RADIO_FEE_CATEGORY_BPL}" /></label>
					<input type="radio"
						id="category<c:out value="${pageScope.LABEL_RADIO_FEE_CATEGORY_NON_BPL}"/>"
						name="category"
						value="<c:out value="${pageScope.FEE_CATEGORY_NON_BPL}"/>"
						<c:if test="${SearchFeeMaster.category eq pageScope.FEE_CATEGORY_NON_BPL}">checked="checked"</c:if> />
					<label
						for="category<c:out value="${pageScope.LABEL_RADIO_FEE_CATEGORY_NON_BPL}"/>"><c:out
							value="${pageScope.LABEL_RADIO_FEE_CATEGORY_NON_BPL}" /></label>
				</td>
				
				
			</tr>
			
			<tr>
			<td><span class="ClsLabel"><fmt:message
						key="feeMaster.manage.label.fromDate" /></span><span
				class="ClsRequiredFields">*</span></td>
			<td>
					<input type="text" class="ClsTextboxDate" id="fromDate"
						maxlength="10" name="fromDate" tabindex="1"
						value="<c:out value="${SearchFeeMaster.fromDate}"/>" style="width: 70px"
						readonly="readonly" />
				</td>
				<td><span class="ClsLabel"><fmt:message
						key="feeMaster.manage.label.toDate" /></span><span
				class="ClsRequiredFields">*</span></td>
			<td>
					<input type="text" class="ClsTextboxDate" id="toDate"
						maxlength="10" name="toDate" tabindex="1"
						value="<c:out value="${SearchFeeMaster.toDate}"/>" style="width: 70px"
						readonly="readonly" />
				</td>
		</tr>
			
			
			<tr>
			<td colspan="2">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchFeeMaster()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchFeeMaster()" />
				</td>
			
			</tr>
			
		</table>
		<c:if test="${SearchFeeMaster.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>	

<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
	<thead>
		<tr>
			<td onclick="javascript:resort('(name)');" style="cursor: pointer" wrap>
				<fmt:message key="feeMaster.manage.label.name" /> <span id="name"></span>
			</td>
			<td onclick="javascript:resort('(fromDate)');" style="cursor: pointer" wrap>
				<fmt:message key="feeMaster.manage.label.fromDate" /> <span id="fromDate"></span>
			</td>
			<td onclick="javascript:resort('(toDate)');" style="cursor: pointer" wrap>
				<fmt:message key="feeMaster.manage.label.toDate" /> <span id="toDate"></span>
			</td>
			<td onclick="javascript:resort('(amount)');" style="cursor: pointer" wrap>
				<fmt:message key="feeMaster.manage.label.amount" /> <span id="upper(amount)"></span>
			</td>
		</tr>
	</thead>
	<tbody>
		<c:set var="hasRows" value="false" />
			<c:forEach var="feeMasterList" items="${requestScope.feeMasterList}" varStatus="rowNumber">
				<c:set var="hasRows" value="true" />	
					<tr>
						<td><a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editFeeMaster('${feeMasterList.feeMasterId}');">
							<c:out value="${feeMasterList.name}"/></a>
						</td>
						<td><c:out value="${feeMasterList.fromDate}"/></td>
						<td><c:out value="${feeMasterList.toDate}"/></td>
						<td><c:out value="${feeMasterList.amount}"/></td>
					</tr>
			</c:forEach>
			
			<c:if test="${hasRows == false}">
				<tr>
					<td colspan=3  class="clsNoRecords" align="center">
						<fmt:message key="list.label.norecords"/>
					</td>
				</tr>
			</c:if>
	</tbody>
	
	<tfoot>
	<tr>
		<td colspan="4">
			<c:if test="${requestScope.feeMasterList != null && requestScope.totalCount>0}">
				<span><%@include file="/pages/common/pagination.jsp"%></span>
			</c:if>
		</td>
	</tr>
	</tfoot>
</table>
<input type="hidden" id="feeMasterId" name="feeMasterId" value="" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" />
<script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>