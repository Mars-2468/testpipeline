<%@include file="/pages/common/include.jsp"%>
<script type="text/javascript">
function setReportParameters(reportId)
{
	document.getElementById("reportsId").value=reportId;
	onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/setReportParameters.do');
}
</script>
<input type="hidden" name="REPORTS_LIST_PAGE_URL" id="REPORTS_LIST_PAGE_URL" value="<c:out value="${REPORTS_LIST_PAGE_URL}"/>">
<div class="mainHdr">
	<h3> <c:out value="${PAGE_HEADING}"/>Reports List</h3>
</div>
<div valign="top" class="ClsBlueGradientStrip" id="SetFormHeight">
	<table border="0" cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
	<thead>
		<tr>
			<td align="center">
				#
			</td>
			<td align="center">
				&nbsp;Report Name
			</td>
			<td width="10%">
				&nbsp;Actions
			</td>
		</tr>
		</thead>
		<tbody>
		<c:set var="rowStyle" value="" />
		<c:forEach var="ReportsList" items="${requestScope.ReportsList}"
			varStatus="rowNumber">
			<c:set var="rowStyle" value="ClsTRContentListWhite" />
			<c:if test="${ rowNumber.count % 2 == 0 }">
				<c:set var="rowStyle" value="ClsTRContentListGrey" />
			</c:if>
			
			<tr>
				<td width="40px" align="center">
					&nbsp;<c:out value="${rowNumber.index+1}"/>
				</td>
				<td>
					&nbsp;<c:out value="${ReportsList.reportDisplayName}" />
				</td>
				<td>
					<input type="button" class="ClsButton" value="View Report" onclick="javascript:setReportParameters(<c:out value="${ReportsList.reportsId}"/>)"/>
				</td>
			</tr>
			</tbody>
		</c:forEach>
	</table>
	<input type="hidden" id="reportsId" name="reportsId" value="" />
</div>
