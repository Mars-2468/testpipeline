
<%-- <%@page import="com.mars.common.utils.Constants"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%> --%>
	<table border="0" class="dataGrid" cellpadding="0" cellspacing="1" width="98%">
		<thead>
		<tr class="ClsTRHeaderList">
			<td class="ClsTDHeaderList"   wrap>
				Remarks
			</td>
			<td class="ClsTDHeaderList"   wrap>
				Start Date
			</td>
			<td class="ClsTDHeaderList"  nowrap>
				End Date
			</td>
			<td class="ClsTDHeaderList"  wrap>
				Action By
			</td>
			<td class="ClsTDHeaderList"   wrap>
				Forward to
			</td>
			<td class="ClsTDHeaderList"  wrap>
				Status
			</td>			
		</tr>
		</thead>
		<tbody>
		
		<c:forEach var="rtiDetails" items="${requestScope.rtiApplication.rtiApplicationDetails}" varStatus="rowNumber">
			<tr>
				<td>
					${rtiDetails.comments}		
				</td>
				<td>
					${rtiDetails.assignedStartDate}
				</td>
			     <td>
						<c:out value="${rtiDetails.assignedEndDate}" />
				</td>
				<td>
						<c:out value="${rtiDetails.user.firstName}" />
				</td>
				<td>
						<c:if test="${rtiDetails.assignToStatus == 1}">
							<c:out value="${rtiDetails.toUser.firstName}" />
						</c:if>					
				</td>
				<td>
						<c:if test="${rtiDetails.status == 1}">
							Active with ${rtiDetails.user.firstName}
						</c:if>
						<c:if test="${rtiDetails.status == 2}">
							Forward to ${rtiDetails.toUser.firstName}
						</c:if>
						<c:if test="${rtiDetails.status == 3}">
							Rejected by ${rtiDetails.user.firstName}
						</c:if>
						<c:if test="${rtiDetails.status == 6}">
							Approved by ${rtiDetails.user.firstName}
						</c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>	
