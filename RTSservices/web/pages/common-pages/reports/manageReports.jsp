<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.common.utils.Constants"%>
<%
	    pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	    pageContext.setAttribute("BOOLEAN_TRUE_LABEL", Constants.BOOLEAN_TRUE_LABEL);
	    pageContext.setAttribute("BOOLEAN_FALSE_LABEL", Constants.BOOLEAN_FALSE_LABEL);
	    //pageContext.setAttribute("REPORT_CATEGORY_LIST", CommonUtils.getReportsCategory());
	    //pageContext.setAttribute("REPORT_DATATYPE_LIST", CommonUtils.getReportDataTypes());
	    pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
	    pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
	    pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
	    pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
	    pageContext.setAttribute("NO", Constants.NO);
	    pageContext.setAttribute("YES", Constants.YES);
	    //pageContext.setAttribute("INTERNAL_ENTITY_NAME_LIST", CommonUtils.getInternalEntityNames());
%>
<div id="PageTitleHeight">
	<table cellpadding="0" cellspacing="0" width="98%">
		<tr>
			<td colspan="2">
				<div class="ClsPageTitle">
					<c:choose>
						<c:when test="${reports.reportsId==0}">
							<fmt:message key="reports.manage.pagetitle.new" />
						</c:when>
						<c:otherwise>
							<fmt:message key="reports.manage.pagetitle.edit" />
						</c:otherwise>
					</c:choose>
				</div>
			</td>
		</tr>
	</table>
</div>
<div valign="top" class="ClsBlueGradientStrip" id="SetFormHeight">
	<table border="0" cellpadding="2" cellspacing="2">
		<tr>
			<td colspan="2">
				<spring:bind path="reports.reportsId">
					<input type="hidden" id="reportsId" name="reportsId"
						value="<c:out value="${reports.reportsId}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message
						key="reports.manage.label.reportName" /> </span><span
					class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="reports.reportName">
					<input type="text" class="ClsTextbox" id="reportName"
						maxlength="255" name="reportName"
						style="width:350px"
						value="<c:out value="${reports.reportName}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message
						key="reports.manage.label.reportDisplayName" /> </span><span
					class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="reports.reportDisplayName">
					<input type="text" class="ClsTextbox" id="reportDisplayName"
						maxlength="255" name="reportDisplayName"
						style="width:350px"
						value="<c:out value="${reports.reportDisplayName}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message
						key="reports.manage.label.reportPath" /> </span><span
					class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="reports.reportPath">
					<input type="text" class="ClsTextbox" id="reportPath"
						maxlength="255" name="reportPath"
						style="width:350px"
						value="<c:out value="${reports.reportPath}"/>" />
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message
						key="reports.manage.label.reportType" /> </span><span
					class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="reports.reportType">
					<select name="reportType" id="reportType" style="width:350px">
						<option value="">
							<- Select ->
						</option>
						<c:forEach items="${pageScope.REPORT_CATEGORY_LIST}"
							var="reportType">
							<c:choose>
								<c:when test="${reports.reportType eq reportType}">
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
			<td>
				<span class="ClsLabel"><fmt:message
						key="reports.manage.label.isMultilingual" /> </span><span
					class="ClsRequiredFields">*</span>
			</td>
			<td>
				<spring:bind path="reports.isMultilingual">
					<select name="isMultilingual" id="isMultilingual" style="width:350px">
						<option value="" >
							<- Select ->
						</option>
						<option value="<c:out value="${pageScope.YES}"/>">
							<c:out value="${pageScope.STATUS_YES_LABEL}"/>
						</option>
						<option value="<c:out value="${pageScope.NO}"/>">
							<c:out value="${pageScope.STATUS_NO_LABEL}"/>
						</option>
					</select>
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="padding-top:10px">
				<br />
			</td>
		</tr>
		<tr>
			<td>
				<p>
				<span class="ClsSubmenuTitle">
					<input type="button" class="ClsButton"
						style="height: 20px; width: 20px; border: 0px" id="add" name="Add"
						value="+" onclick="addPreviousRowToTable('dtls');"
						style="height:20px;width:20px;border:0px">
					<input type="button" class="ClsButton"
						style="height: 20px; width: 20px; border: 0px" id="remove"
						name="Remove" value="-" onclick="removeNewRowFromTable('dtls',<c:out value="${requestScope.rowsize}"/>);"
						style="height:20px;width:20px;border:0px">
					&nbsp;
					Report Parameters</span>
				</p>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<table border="0"  cellpadding="2" cellspacing="2" width="100%" id="dtls">
				<tr class="ClsTRHeaderList">
						<td>
							<span class="ClsLabel"><fmt:message
									key="common.manage.label.sNo" /> </span>
						</td>
						<td>
							<span class="ClsLabel"><fmt:message
									key="reports.reportParameters.manage.label.name" /> </span>
							<span class="ClsRequiredFields">*</span>
						</td>
						<td>
							<span class="ClsLabel"><fmt:message
									key="reports.reportParameters.manage.label.displayname" /> </span>
							<span class="ClsRequiredFields">*</span>
						</td>
						<td>
							<span class="ClsLabel"><fmt:message
									key="reports.reportParameters.manage.label.dataType" /> </span>
							<span class="ClsRequiredFields">*</span>
						</td>
						<td>
							<span class="ClsLabel"><fmt:message
									key="reports.reportParameters.manage.label.defaultValue" /> </span>
						</td>
						<td>
							<span class="ClsLabel"><fmt:message
									key="reports.reportParameters.manage.label.entityname" /> </span>
						</td>
						<td>
							<span class="ClsLabel"><fmt:message
									key="reports.reportParameters.manage.label.size" /> </span>
						</td>
						<td>
							<span class="ClsLabel"><fmt:message
									key="reports.reportParameters.manage.label.reportParameterRequired" />
							</span>
						</td>
						<td style="display:none">
							&nbsp;
						</td>
						<c:if test="${requestScope.rowsize!=null && requestScope.rowsize>0}">
						<td width="3%" nowrap>
							<input type="checkbox" name="selectReportParameters"
								id="selectReportParameters"
								onclick="ToggleAll(this,'reportParametersCheck');" />
							<span class="ClsLabel"><fmt:message
									key="label.record.delete" />
						</td>
						</c:if>
					</tr>
					<c:choose>
						<c:when test="${requestScope.rowsize!=null && requestScope.rowsize>0}">
							<c:forEach var="reportParameters"
								items="${reports.reportParameters}" varStatus="iCount">
								<tr class="ClsTRContentListWhite">
									<td>
										<c:out value="${iCount.index+1}" />
									</td>
									<td>
										<input type="text" class="ClsTextbox"
											id="reports.reportParameters.name" maxlength="50"
											name="reports.reportParameters.name"
											value="<c:out value="${reportParameters.name}"/>" />
									</td>
									<td>
										<input type="text" class="ClsTextbox"
											id="reports.reportParameters.displayName" maxlength="50"
											name="reports.reportParameters.displayName"
											value="<c:out value="${reportParameters.displayName}"/>" />
									</td>
									<td>
										<select name="reports.reportParameters.dataType"
											id="reports.reportParameters.dataType" style="width:100px">
											<option value="">
											<- Select ->
											</option>
											<c:forEach items="${pageScope.REPORT_DATATYPE_LIST}"
												var="reportDataType">
												<c:choose>
													<c:when
														test="${reportParameters.dataType eq reportDataType}">
														<option value="<c:out value="${reportDataType}"/>" selected="selected">
															<c:out value="${reportDataType}"/>
														</option>
													</c:when>
													<c:otherwise>
														<option value="<c:out value="${reportDataType}"/>">
															<c:out value="${reportDataType}"/>
														</option>
													</c:otherwise>
												</c:choose>

											</c:forEach>
										</select>
									</td>
									<td>
										<input type="text" class="ClsTextbox"
											id="reports.reportParameters.defaultValue"
											name="reports.reportParameters.defaultValue" maxlength="20"
											value="<c:out value="${reportParameters.defaultValue}"/>" />
									</td>
									<td>
										<select name="reports.reportParameters.internalEntityName"
											id="reports.reportParameters.internalEntityName" style="width:250px">
											<option value="" >
											<- Select ->
											</option>
											<c:forEach items="${pageScope.INTERNAL_ENTITY_NAME_LIST}" var="internalEntityName">
												<c:choose>
													<c:when
														test="${reportParameters.internalEntityName eq internalEntityName}">
														<option value="<c:out value="${internalEntityName}"/>" selected="selected">
															<c:out value="${internalEntityName}"/>
														</option>
													</c:when>
													<c:otherwise>
														<option value="<c:out value="${internalEntityName}"/>">
															<c:out value="${internalEntityName}"/>
														</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
									</td>
									<td>
									<input type="text" class="ClsTextbox"
										id="reports.reportParameters.size"
										name="reports.reportParameters.size" maxlength="3"
										value="<c:out value="${reportParameters.size}"/>"  style="width:50px;"/>
									</td>
									<td>
										<select
											name="reports.reportParameters.reportParameterRequired"
											id="reports.reportParameters.reportParameterRequired"
											style="width:100px">
											<option value="" >
												<- Select ->
											</option>
											<option value="<c:out value="${pageScope.STATUS_YES}"/>">
												<c:out value="${pageScope.STATUS_YES_LABEL}"/>
											</option>
											<option value="<c:out value="${pageScope.STATUS_NO}"/>">
												<c:out value="${pageScope.STATUS_NO_LABEL}"/>
											</option>
										</select>
										<c:choose>
											<c:when test="${reportParameters.reportParameterRequired == pageScope.STATUS_YES}">
												<script type="text/javascript">
													document.getElementsByName("reports.reportParameters.reportParameterRequired")[<c:out value="${iCount.index}"/>].value="<c:out value="${pageScope.STATUS_YES}"/>";
												</script>
											</c:when>
											<c:otherwise>
												<script type="text/javascript">
													document.getElementsByName("reports.reportParameters.reportParameterRequired")[<c:out value="${iCount.index}"/>].value="<c:out value="${pageScope.STATUS_NO}"/>";
												</script>
											</c:otherwise>
										</c:choose>
									</td>
									<td style="display:none">
										<input type="hidden"
											id="reports.reportParameters.reportParametersId"
											name="reports.reportParameters.reportParametersId"
											value="<c:out value="${reportParameters.reportParametersId}"/>" />
									</td>
									<td>
										<input type="checkbox" name="reportParametersCheck"
											id="reportParametersCheck"
											value="<c:out value="${reportParameters.reportParametersId}"/>"
											onclick="Toggle(this,'selectReportParameters');" />
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td>
									<c:out value="${iCount.index+1}" />
								</td>
								<td>
									<input type="text" class="ClsTextbox"
										id="reports.reportParameters.name" maxlength="50"
										name="reports.reportParameters.name" value="" />
								</td>
								<td>
									<input type="text" class="ClsTextbox"
										id="reports.reportParameters.displayName" maxlength="50"
										name="reports.reportParameters.displayName"
										value="" />
								</td>
								<td>
									<select name="reports.reportParameters.dataType"
										id="reports.reportParameters.dataType" style="width:100px">
										<option value="">
											<- Select ->
										</option>
										<c:forEach items="${pageScope.REPORT_DATATYPE_LIST}"
											var="reportDataType">
											<c:choose>
												<c:when
													test="${reportParameters.dataType eq reportDataType}">
													<option value="<c:out value="${reportDataType}"/>" selected="selected">
														<c:out value="${reportDataType}"/>
													</option>
												</c:when>
												<c:otherwise>
													<option value="<c:out value="${reportDataType}"/>">
														<c:out value="${reportDataType}"/>
													</option>
												</c:otherwise>
											</c:choose>

										</c:forEach>
									</select>
								</td>
								<td>
									<input type="text" class="ClsTextbox"
										id="reports.reportParameters.defaultValue"
										name="reports.reportParameters.defaultValue" maxlength="20"
										value="" />
								</td>
								<td>
									<select name="reports.reportParameters.internalEntityName"
										id="reports.reportParameters.internalEntityName" style="width:250px">
										<option value="">
										<- Select ->
										</option>
										<c:forEach items="${pageScope.INTERNAL_ENTITY_NAME_LIST}" var="internalEntityName">
											<c:choose>
												<c:when
													test="${reportParameters.internalEntityName eq internalEntityName}">
													<option value="<c:out value="${internalEntityName}"/>" selected="selected">
														<c:out value="${internalEntityName}"/>
													</option>
												</c:when>
												<c:otherwise>
													<option value="<c:out value="${internalEntityName}"/>">
														<c:out value="${internalEntityName}"/>
													</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</td>
								<td>
									<input type="text" class="ClsTextbox"
										id="reports.reportParameters.size"
										name="reports.reportParameters.size" maxlength="3"
										value=""  style="width:50px;"/>
								</td>
								<td>
									<select name="reports.reportParameters.reportParameterRequired"
										id="reports.reportParameters.reportParameterRequired"
										style="width:100px">
										<option value="" >
										<- Select ->
										</option>
										<option value="<c:out value="${pageScope.STATUS_YES}"/>">
											<c:out value="${pageScope.STATUS_YES_LABEL}"/>
										</option>
										<option value="<c:out value="${pageScope.STATUS_NO}"/>">
											<c:out value="${pageScope.STATUS_NO_LABEL}"/>
										</option>
									</select>
								</td>
								<td style="display:none">
									<input type="hidden"
										id="reports.reportParameters.reportParametersId"
										name="reports.reportParameters.reportParametersId" value="0" />
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="button" value="Back"
					onclick="javascript:listReports(this.form)" class="ClsButton" />
				<input type="button" class="ClsButton" id="save" name="save"
					value="Save" onclick="javascript:saveReports(this.form);">
				<input type="button" class="ClsButton" id="clear" name="clear"
					value="Clear" onclick="javascript:clearContorls();">
				<c:if test="${reports.reportsId!=0}">
					<input type="button" class="ClsButton" id="delete" name="delete"
						value="Delete" onclick="javascript:deleteReports(this.form);">
				</c:if>
		</tr>
	</table>
</div>
<input type="hidden" name="deleteReportParametersDetails"
	id="deleteReportParametersDetails" value="">

<script type="text/javascript">
function saveReports(frm)
{
	<c:if test="${requestScope.rowsize!=null && requestScope.rowsize>0}">
		document.getElementById('deleteReportParametersDetails').value = getSelectedValue('reportParametersCheck');
	</c:if>
	var arrElements=new Array('reportDisplayName','reportName','reportPath','reportType');
	var paramElements = new Array('reports.reportParameters.name','reports.reportParameters.displayName','reports.reportParameters.dataType');
	var paramElementsNames = new Array('<fmt:message key="reports.reportParameters.manage.label.name"/>','<fmt:message key="reports.reportParameters.manage.label.displayname" />','<fmt:message key="reports.reportParameters.manage.label.dataType" />');
	var nonMandatoryFieldsArray = new Array('reports.reportParameters.defaultValue','reports.reportParameters.internalEntityName','reports.reportParameters.size','reports.reportParameters.reportParameterRequired');

	if(checkMandatoryMsg(arrElements, "Please fill all the required fields which are marked with *"))
	{
		if(checkChildMandatoryAll('dtls',paramElements,paramElementsNames,nonMandatoryFieldsArray,'Report Parameters'))
		{
			navigate(frm,'<c:out value="${contextRoot}"/>/reports/saveReports.do');
		}
	}
}

function listReports(frm)
{
		navigate(frm,'<c:out value="${contextRoot}"/>/reports/listReports.do');
}

function deleteReports(id)
{
	if(confirmDelete()){
		onPageSubmit('<c:out value="${contextRoot}"/>/reports/deleteReports.do');
	}
}
</script>
