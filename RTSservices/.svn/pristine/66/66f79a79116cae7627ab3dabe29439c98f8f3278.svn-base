<c:when test="${reportParameters.internalEntityName=='RBD_YEAR'}">
	<select style="width: 110px" id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>" name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>">
		<option value="">
			<-- Select -->
		</option>
		<c:forEach items="${requestScope.RBDRegistrationYearList}" var="rbdYear">
			<option value="<c:out value="${rbdYear}"/>~<c:out value="${rbdYear}"/>">
				<c:out value="${rbdYear}" />
			</option>
		</c:forEach>
	</select>
</c:when>
<c:when test="${reportParameters.internalEntityName=='RBD_REG_UNIT'}">
	<select id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
		name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>" >
			<option value="">
			<-- Select -->
			</option>
			<c:forEach items="${requestScope.RBDRegistrationUnitsList}" var="rbdRegUnit">
				<option value="<c:out value="${rbdRegUnit.registrationUnitId}"/>~<c:out value="${rbdRegUnit.name}"/>">
					<c:out value="${rbdRegUnit.name}"/>
					</option>
				</c:forEach>
		</select>
</c:when>
<c:when test="${reportParameters.internalEntityName=='RBD_CHART_TYPE'}">
	<select style="width: 350px" id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>" name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>">
		<option value="">
			<-- Select -->
		</option>
		<c:forEach items="${requestScope.rbdChartTypeList}" var="rbdChartType">
			<option value="<c:out value="${rbdChartType[0]}"/>~<c:out value="${rbdChartType[1]}" />">
				<c:out value="${rbdChartType[1]}" />
			</option>
		</c:forEach>
	</select>
</c:when>
<c:when test="${reportParameters.internalEntityName=='RBD_BIRTHS_CHART_TYPE'}">
	<select style="width: 250px" id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>" name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>">
		<option value="">
			<-- Select -->
		</option>
		<c:forEach items="${requestScope.rbdBirthsChartTypeList}" var="rbdBirthsChartType">
			<option value="<c:out value="${rbdBirthsChartType[0]}"/>~<c:out value="${rbdBirthsChartType[1]}" />">
				<c:out value="${rbdBirthsChartType[1]}" />
			</option>
		</c:forEach>
	</select>
</c:when>
<c:when test="${reportParameters.internalEntityName=='RBD_DEATHS_CHART_TYPE'}">
	<select style="width: 250px" id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>" name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>">
		<option value="">
			<-- Select -->
		</option>
		<c:forEach items="${requestScope.rbdDeathsChartTypeList}" var="rbdDeathsChartType">
			<option value="<c:out value="${rbdDeathsChartType[0]}"/>~<c:out value="${rbdDeathsChartType[1]}" />">
				<c:out value="${rbdDeathsChartType[1]}" />
			</option>
		</c:forEach>
	</select>
</c:when>
<c:when test="${reportParameters.internalEntityName=='RBD_STILLBIRTHS_CHART_TYPE'}">
	<select style="width: 250px" id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>" name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>">
		<option value="">
			<-- Select -->
		</option>
		<c:forEach items="${requestScope.rbdStillbirthsChartTypeList}" var="rbdStillbirthsChartType">
			<option value="<c:out value="${rbdStillbirthsChartType[0]}"/>~<c:out value="${rbdStillbirthsChartType[1]}" />">
				<c:out value="${rbdStillbirthsChartType[1]}" />
			</option>
		</c:forEach>
	</select>
</c:when>

<c:when test="${reportParameters.internalEntityName=='RBD_QUARTER'}">
	<select style="width: 110px" id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>" name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>">
		<option value="">
			<-- Select -->
		</option>
		<c:forEach items="${requestScope.quarterList}" var="quarter">
			<option value="<c:out value="${quarter[0]}"/>~<c:out value="${quarter[1]}" />">
				<c:out value="${quarter[1]}" />
			</option>
		</c:forEach>
	</select>
</c:when>

