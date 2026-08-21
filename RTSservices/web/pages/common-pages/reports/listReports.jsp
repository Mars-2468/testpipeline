<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.CommonUtils"%>

<script type="text/javascript">
function editReports(id)
{
	document.getElementById('reportsId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/reports/editReports.do');
}

function searchReports() {
	onPageSubmit('<c:out value="${contextRoot}"/>/reports/listReports.do');
}

</script>

<%
	    pageContext.setAttribute("REPORT_CATEGORY_LIST", CommonUtils.getReportsCategory());
%>

<div id="PageTitleHeight">
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<div class="ClsPageTitle">
					Reports List
				</div>
			</td>
			<td align="right" style="padding-right:10px">
				<a href="<c:out value="${contextRoot}"/>/reports/editReports.do">
					<b>Create Report</b> </a>
			</td>
		</tr>
	</table>
</div>
<div valign="top" class="ClsBlueGradientStrip" id="SetFormHeight">

	<div id="SearchDivId" class="ClsSearch">
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			<fmt:message key="search.label.heading" />
		</div>
		<table id="SearchTable" cellpadding="2" cellspacing="1" border="0" style="display:none;padding-left:5px;">
			<tr>
				<td>			
					<fmt:message key="reports.list.label.reportDisplayName"/>
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchReportDisplayName"
						maxlength="255" size="50" style="width:250px" name="searchReportDisplayName"
						value="<c:out value="${searchOptions.reportDisplayName}"/>" />
				</td>
				<td>			
					<fmt:message key="reports.list.label.reportName"/>
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchReportName"
						maxlength="255" size="50" style="width:250px" name="searchReportName"
						value="<c:out value="${searchOptions.reportName}"/>" />
				</td>
			</tr>
			<tr>
				<td>			
					<fmt:message key="reports.list.label.reportPath"/>
				</td>
				<td>
					<input type="text" class="ClsTextbox" id="searchReportPath"
						maxlength="255" size="50" style="width:250px" name="searchReportPath"
						value="<c:out value="${searchOptions.reportPath}"/>" />&nbsp;
				</td>			
				<td>		
					<fmt:message key="reports.list.label.reportType"/>
				</td>
				<td>		
					<spring:bind path="searchOptions.reportType">
						<select name="searchReportType" id="searchReportType" style="width:150px">
							<option value="">
								<-- Select -->
							</option>
							<c:forEach items="${pageScope.REPORT_CATEGORY_LIST}"
								var="reportType">
								<c:choose>
									<c:when test="${searchOptions.reportType eq reportType}">
										<option value="<c:out value="${reportType}"/>" selected="selected">
											<c:out value="${reportType}"/>
										</option>
									</c:when>
									<c:otherwise>
										<option value="<c:out value="${reportType}"/>">
											<c:out value="${reportType}"/>
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</spring:bind>
				</td>	
			</tr>
			<tr>		
				<td colspan="4">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchReports()"/>&nbsp;			
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchReports()"/>		
				</td>					
			</tr>
		</table>
		<c:if test="${searchOptions.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>		
	</div>
	
	<table border="0" cellpadding="0"
		cellspacing="1" width="98%">
		<tr class="ClsTRHeaderList">
			<td>
				<fmt:message key="reports.list.label.reportsId" />
			</td>	
			<td onclick="javascript:resort('UPPER(reportDisplayName)')"
				style="cursor:pointer" wrap>
				<fmt:message key="reports.list.label.reportDisplayName" />
				&nbsp;<span id="UPPER(reportDisplayName)"></span>
			</td>
			<td onclick="javascript:resort('UPPER(reportName)')" style="cursor:pointer"
				wrap>
				<fmt:message key="reports.list.label.reportName" />
				&nbsp;<span id="UPPER(reportName)"></span>
			</td>
			<td onclick="javascript:resort('reportPath')" style="cursor:pointer"
				wrap>
				<fmt:message key="reports.list.label.reportPath" />
				&nbsp;<span id="reportPath"></span>
			</td>
			<td onclick="javascript:resort('reportType')" style="cursor:pointer"
				wrap>
				<fmt:message key="reports.list.label.reportType" />
				&nbsp;<span id="reportType"></span>
			</td>
		</tr>
		<c:set var="rowStyle" value="" />
		<c:forEach var="ReportsList" items="${requestScope.ReportsList}"
			varStatus="rowNumber">
			<c:set var="rowStyle" value="ClsTRContentListWhite" />
			<c:if test="${ rowNumber.count % 2 == 0 }">
				<c:set var="rowStyle" value="ClsTRContentListGrey" />
			</c:if>
			<tr class="<c:out value="${rowStyle}"/>">
				<td>
					&nbsp;<a href="javascript:editReports('<c:out value="${ReportsList.reportsId}"/>');"><c:out
							value="${ReportsList.reportsId}" /> </a>
				</td>
				<td>
					&nbsp;<c:out value="${ReportsList.reportDisplayName}" />
				</td>				
				<td>
					&nbsp;<c:out value="${ReportsList.reportName}" />
				</td>
				<td>
					&nbsp;<c:out value="${ReportsList.reportPath}" />
				</td>
				<td>
					&nbsp;<c:out value="${ReportsList.reportType}" />
				</td>
			</tr>
		</c:forEach>
		<tr class="ClsTRHeaderList">
			<td colspan="5">
				<c:if test="${requestScope.ReportsList != null}">
					<span><%@include file="/pages/common/pagination.jsp"%>
					</span>
				</c:if>
			</td>
		</tr>
	</table>
	<input type="hidden" id="reportsId" name="reportsId"
		value="<c:out value="${reports.reportsId}"/>" />

	<input type="hidden" name="SortBy"
		value="<c:out value="${requestScope.SortBy}"/>" />
	<input type="hidden" name="OrderBy"
		value="<c:out value="${requestScope.OrderBy}"/>" />

	<script type="text/javascript">
		insert_image('<c:out value="${contextRoot}"/>');
	</script>
</div>
