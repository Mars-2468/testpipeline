<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants,com.mars.common.utils.CommonUtils" %>

<table cellpadding="2" cellspacing="2" border="0" class="dataForm" width="100%">
	<div class="mainHdr">
				<h3>Recently Generated Reports:</h3>
	</div>
	<tr>
	<td>
		<table border="1" cellpadding="2" cellspacing="2" width="100%" class="dataGrid">
			<thead>

			<tr>
				<td width="8%"><span class="ClsLabel"><fmt:message key="common.manage.label.sNo" /></span></td>
				<td><span class="ClsLabel"><fmt:message key="dmsattachment.manage.label.fileName" /> </span></td>

				<td width="20%">
					<span class="ClsLabel"><fmt:message key="dmsattachment.manage.label.operations" /> </span>
				</td>
			</tr>
			</thead>
			<tbody id="dmsDocsCheckListBodyId">
			<c:if test="${not empty reportFileDescriptionList}">
				<c:forEach var="reportFileDescriptionList" items="${reportFileDescriptionList}"  varStatus="iCount">
					<tr>
						<td>
							<c:out value="${iCount.index+1}"/>
						</td>

						<td>
							${reportFileDescriptionList}
						</td>

						<td nowrap="nowrap">
							<a href='${contextRoot}<%=request.getContextPath()%>/uploads/reports/<%=session.getId()%>/<c:out value="${reportFileDescriptionList}" />' target='popup' alt="File Download"/>
										<img src="<c:out value="${contextRoot}"/>/images/file_download.png" alt="File Download"/>
							</a>

						</td>
					</tr>
				</c:forEach>
			</c:if>

			</tbody>
		</table>
		</td>
		</tr>
		<tr >
		<td class="clsNoRecords">
			<c:if test="${not empty generatedReportMessage}">
					<div id="reportMessageDiv" class="ClsLabel" style="margin-left: 250px;" >
						<c:out escapeXml="false" value="${generatedReportMessage}"/>
					</div>
			</c:if>
		</td>
		</tr>
</table>
