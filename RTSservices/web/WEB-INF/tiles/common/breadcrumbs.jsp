<%@ include file="/pages/common/include.jsp"%>
<c:set var="breadCrumbCount" value="0"></c:set>
<c:forEach items="${requestScope.breadcrumbsList}" var="breadCrumb">
	<c:choose>
		<c:when test="${breadCrumbCount != 0}">
			<c:choose>
				<c:when test="${breadCrumb.link eq '#'}">
					&nbsp;&gt;&gt;&nbsp;<a href="#"> <fmt:message key="${breadCrumb.value}" /> </a>
				</c:when>
				<c:otherwise>
					&nbsp;&gt;&gt;&nbsp;<a href="<c:out value="${contextRoot}${breadCrumb.link}"/>"> <fmt:message key="${breadCrumb.value}" /> </a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${breadCrumb.link eq 
				'#'}">
					<a href="#"><fmt:message key="${breadCrumb.value}" /> </a>
				</c:when>
				<c:otherwise>
					<a href="<c:out value="${contextRoot}${breadCrumb.link}"/>"> <fmt:message key="${breadCrumb.value}" /> </a>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	<c:set var="breadCrumbCount" value="${breadCrumbCount+1}"></c:set>
</c:forEach>