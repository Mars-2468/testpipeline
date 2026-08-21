<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants,com.mars.common.utils.CommonUtils" %>
<%
	    pageContext.setAttribute("CONTENT_TYPE_TEXT_HTML", Constants.CONTENT_TYPE_TEXT_HTML);
	    pageContext.setAttribute("CONTENT_TYPE_PDF", Constants.CONTENT_TYPE_PDF);
	    pageContext.setAttribute("CONTENT_TYPE_WORD", Constants.CONTENT_TYPE_WORD);
	    pageContext.setAttribute("CONTENT_TYPE_EXCEL", Constants.CONTENT_TYPE_EXCEL);
	    pageContext.setAttribute("CURRENT_FINANCIAL_YEAR_START_DATE", CommonUtils.getFinancialYearStartDate());
	    pageContext.setAttribute("CURRENT_DATE", CommonUtils.getCurrentStringDate());
	    pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);

%>
<script src="<c:out value="${contextRoot}"/>/dwr/interface/sectorList.js"></script>
<script src="<c:out value="${contextRoot}"/>/dwr/interface/nodeSectorList.js"></script>
<script src="<c:out value="${contextRoot}"/>/dwr/interface/collectionCenter.js"></script>
<script src="<c:out value="${contextRoot}"/>/dwr/interface/reports.js"></script>
<script src="<c:out value="${contextRoot}"/>/dwr/interface/gisMastersList.js"></script>
<script src="<c:out value="${contextRoot}"/>/dwr/interface/plotList.js"></script>

<script language="javaScript">
var jsWardParamId='';
var jsSectorParamId='';
var jsNodeMasterParamId ='';
var jsPlotTypeParamId ='';
var jsPlotParamId = '';
var jsCollectionCenterId= '';
var jsAuditEntityId='';
var jsAuditEntityPropertyId='';
</script>
<%@include file="/pages/core-pages/core-reports/reportsCoreJS.jsp"%>
<style type="text/css">
.btn-success { -
	-bs-btn-color: #fff; -
	-bs-btn-bg: #00a659; -
	-bs-btn-border-color: #198754; -
	-bs-btn-hover-color: #fff; -
	-bs-btn-hover-bg: #168b54;
	border: none;
	border-radius: 5px;
	min-height: 30px;
	min-width: 120px;
}

.btn-danger { -
	-bs-btn-color: #fff; -
	-bs-btn-bg: #e61f2c; -
	-bs-btn-border-color: #df2d2d; -
	-bs-btn-hover-color: #fff; -
	-bs-btn-hover-bg: #ee1717;
	border: none;
	border-radius: 5px;
	min-height: 30px;
	min-width: 120px;
}

.ClsTRHeaderList {
	background: #678dc5;
	font-weight: bold;
	color: white;
}

.form-control {
	width: 180px;
	height: 30px;
}

.btn-success {
	width: 50px;
	height: 30px;
	font-size: 10px;
}
.ui-datepicker {
width:300px;
    
    padding: .2em .2em 0;
}
.ui-datepicker .ui-datepicker-prev {
    left: -10px;
}
.ui-datepicker table{
margin-left:-8px;
}

.ui-datepicker th {
    padding: 0.7em em 0em 2em;
    text-align: center;
    font-weight: bold;
    border: 0;
}
a {
    margin-left: 10px;
}
.ClsTextboxDate{
font-size: 15px;
width:130px;
height:30px;
}
</style>
<input type="hidden" name="REPORTS_LIST_PAGE_URL" id="REPORTS_LIST_PAGE_URL" value="<c:out value="${REPORTS_LIST_PAGE_URL}"/>">
	<table id="BreadCrumbsHeight" cellpadding="2" cellspacing="2" border="0">
		<tr>
			<td height="20px">
				<a href="javascript:sendToReportsListPage()"> Reports List</a>
			</td>
		</tr>
	</table>
<div class="mainHdr">
	<h3 style="height: 50px">
				Set Report Parameters - <c:out value="${Report.reportDisplayName}"/>
	</h3>
</div>
<div valign="top" id="SetFormHeight">
	<c:set var="isRequiredFields" value="" />
	<c:set var="isLongFields" value="" />
	<c:set var="isLongFieldNames" value="" />
	<c:set var="isIntegerFields" value="" />
	<c:set var="isIntegerFieldNames" value="" />
	<c:set var="isFloatFields" value="" />
	<c:set var="isFloatFieldNames" value="" />

	<table cellpadding="2" cellspacing="2" border="0" class="dataForm">
		<c:forEach items="${Report.reportParameters}" var="reportParameters"
			varStatus="reportCount">
			<tr>
				<td>
					<span class="ClsLabel">
					<c:out value="${reportParameters.displayName}" />
					</span>
					<c:if test="${reportParameters.reportParameterRequired ==1}">
						<span class="ClsRequiredFields">*</span>
						<c:choose>
							<c:when test="${isRequiredFields eq ''}">
								<c:set var="isRequiredFields"
									value="'report.reportParameters.id${reportParameters.reportParametersId}'" />
							</c:when>
							<c:otherwise>
								<c:set var="isRequiredFields"
									value="${isRequiredFields},'report.reportParameters.id${reportParameters.reportParametersId}'" />
							</c:otherwise>
						</c:choose>
					</c:if>
				</td>
				<td>
					<c:choose>
						<c:when test="${reportParameters.dataType=='Long'&& (reportParameters.internalEntityName == null || reportParameters.internalEntityName eq '')}">
							<c:choose>
								<c:when test="${isLongFields eq ''}">
									<c:set var="isLongFields"
										value="'report.reportParameters.id${reportParameters.reportParametersId}'" />
									<c:set var="isLongFieldNames"
										value="'${reportParameters.displayName}'" />
								</c:when>
								<c:otherwise>
									<c:set var="isLongFields"
										value="${isLongFields},'report.reportParameters.id${reportParameters.reportParametersId}'" />
									<c:set var="isLongFieldNames"
										value="${isLongFieldNames},'${reportParameters.displayName}'" />
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:when test="${reportParameters.dataType=='Integer' && (reportParameters.internalEntityName == null || reportParameters.internalEntityName eq '')}">
							<c:choose>
								<c:when test="${isIntegerFields eq ''}">
									<c:set var="isIntegerFields"
										value="'report.reportParameters.id${reportParameters.reportParametersId}'" />
									<c:set var="isIntegerFieldNames"
										value="'${reportParameters.displayName}'" />
								</c:when>
								<c:otherwise>
									<c:set var="isIntegerFields"
										value="${isIntegerFields},'report.reportParameters.id${reportParameters.reportParametersId}'" />
									<c:set var="isIntegerFieldNames"
										value="${isIntegerFieldNames},'${reportParameters.displayName}'" />
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:when test="${reportParameters.dataType=='Double'}">
							<c:choose>
								<c:when test="${isFloatFields eq ''}">
									<c:set var="isFloatFields"
										value="'report.reportParameters.id${reportParameters.reportParametersId}'" />
									<c:set var="isFloatFieldNames"
										value="'${reportParameters.displayName}'" />
								</c:when>
								<c:otherwise>
									<c:set var="isFloatFields"
										value="${isFloatFields},'report.reportParameters.id${reportParameters.reportParametersId}'" />
									<c:set var="isFloatFieldNames"
										value="${isFloatFieldNames},'${reportParameters.displayName}'" />
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:when test="${reportParameters.dataType=='Float'}">
							<c:choose>
								<c:when test="${isFloatFields eq ''}">
									<c:set var="isFloatFields"
										value="'report.reportParameters.id${reportParameters.reportParametersId}'" />
									<c:set var="isFloatFieldNames"
										value="'${reportParameters.displayName}'" />
								</c:when>
								<c:otherwise>
									<c:set var="isFloatFields"
										value="${isFloatFields},'report.reportParameters.id${reportParameters.reportParametersId}'" />
									<c:set var="isFloatFieldNames"
										value="${isFloatFieldNames},'${reportParameters.displayName}'" />
								</c:otherwise>
							</c:choose>
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test="${reportParameters.dataType=='Date'}">
							<c:if test="${reportParameters.name=='FROM_DATE'}">
									<input type="text" class="ClsTextboxDate" style="width:250px"
									id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
									maxlength="10" customName='FROM_DATE'
									name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
									value="<c:out value=""/>" readonly />
							</c:if>
							<c:if test="${reportParameters.name=='TO_DATE' || reportParameters.name=='AS_ON_DATE'}">
										<input type="text" class="ClsTextboxDate" style="width:250px"
									id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
									maxlength="10" customName='TO_DATE'
									name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
									value="<c:out value=""/>" readonly />
							</c:if>
						</c:when>
						<c:when test="${reportParameters.internalEntityName=='Month'}">
							<select id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
								name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>" style="width:105px" class="ClsTextbox">
									<option value="">
									<-- Select -->
									</option>
									<c:forEach items="${requestScope.monthList}" var="month">
										<c:choose>
											<c:when test="${reportParameters.defaultValue==month[0]}">
												<option value="<c:out value="${month[0]}"/>~<c:out value="${month[1]}"/>" selected="selected">
													<c:out value="${month[1]}"/>
												</option>
											</c:when>
											<c:otherwise>
												<option value="<c:out value="${month[0]}"/>~<c:out value="${month[1]}"/>">
													<c:out value="${month[1]}"/>
												</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select>
						</c:when>

						<c:when test="${reportParameters.internalEntityName=='NodeMaster'}">
								<script language="javaScript">
								 jsNodeMasterParamId='<c:out value="${reportParameters.reportParametersId}"/>';
								</script>
							<select id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
								name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>" onchange="getSectorListOnNode();">
									<option value="">
									<-- Select -->
									</option>
									<c:forEach items="${requestScope.nodeMasterList}" var="nodeMaster">
										<option value="<c:out value="${nodeMaster.nodeMasterId}"/>~<c:out value="${nodeMaster.name}"/>">
											<c:out value="${nodeMaster.name}"/>
										</option>
									</c:forEach>
							</select>
						</c:when>
						<c:when test="${reportParameters.internalEntityName=='Ward'}">
							<script language="javaScript">
								 jsWardParamId='<c:out value="${reportParameters.reportParametersId}"/>';
							</script>
							<select id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
								name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>" onchange="getSectorsOnWard();getCollectionCentersOnWard();getNodeOnWard();">
									<option value="">
									<-- Select -->
									</option>
									<c:forEach items="${requestScope.wardList}" var="ward">
										<option value="<c:out value="${ward.wardId}"/>~<c:out value="${ward.name}"/>">
											<c:out value="${ward.name}"/>
										</option>
									</c:forEach>
							</select>
						</c:when>
						
							<c:when test="${reportParameters.internalEntityName=='zone'}">
							<script language="javaScript">
								 jsWardParamId='<c:out value="${reportParameters.reportParametersId}"/>';
							</script>
							<select class="ClsTextboxDate" style="width:250px"  id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
								name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>" onchange="getSectorsOnWard();getCollectionCentersOnWard();getNodeOnWard();">
									<option value="">
									<-- Select -->
									</option>
									<c:forEach items="${requestScope.zoneMaster}" var="zoneMaster">
										<option value="<c:out value="${zoneMaster.zoneId}"/>~<c:out value="${ward.name}"/>">
											<c:out value="${zoneMaster.zoneName}"/>
										</option>
									</c:forEach>
							</select>
						</c:when>
						
						<c:when test="${reportParameters.internalEntityName=='Sector'}">
								<script language="javaScript">
								 jsSectorParamId='<c:out value="${reportParameters.reportParametersId}"/>';
							</script>
						 <select id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
								name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>" onchange="getPlotsOnSector();">
									<option value="">
									<-- Select -->
									</option>
								<c:forEach var="sector" items="${requestScope.sectorList}" varStatus="sectorCount">
					               <c:choose>
					                  <c:when test="${sectorCount.index==0}">
						                <optgroup LABEL="<c:out value="${sector.nodeMaster.name}"/>">
						                <c:set var="optionGroup" value="${sector.nodeMaster.name}" />
					                  </c:when>
					                  <c:when test="${optionGroup ne sector.nodeMaster.name}">
						                </optgroup>
						                <optgroup LABEL="<c:out value="${sector.nodeMaster.name}"/>">
						                <c:set var="optionGroup" value="${sector.nodeMaster.name}" />
					                  </c:when>
					              </c:choose>
				 	              <c:if test="${sector.nodeMaster.name eq optionGroup}">
						            <option value="<c:out value="${sector.sectorId}"/>~<c:out value="${sector.name}"/>">
						                <c:out value="${sector.name}"/>
					                </option>
					              </c:if>
					          </c:forEach>
					          <c:if test="${not empty requestScope.sectorList}">
						        </optgroup>
					         </c:if>
				          </select>
						</c:when>
						<c:when test="${reportParameters.internalEntityName=='FinancialYear'}">
							<select style="width: 110px" id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
								name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>">
									<option value="">
									<-- Select -->
									</option>
									<c:forEach items="${requestScope.financialYearList}" var="financialYear">
										<option value="<c:out value="${financialYear.financialYearId}"/>~<c:out value="${financialYear.startYear}"/>~<c:out value="${financialYear.endYear}"/>~<c:out value="${financialYear.startYear}"/>-<c:out value="${financialYear.endYear}"/>">
											<c:out value="${financialYear.startYear}"/>-<c:out value="${financialYear.endYear}"/>
										</option>
									</c:forEach>
							</select>
						</c:when>
						<c:when test="${reportParameters.internalEntityName=='CollectionCenter'}">
								<script language="javaScript">
								 jsCollectionCenterId='<c:out value="${reportParameters.reportParametersId}"/>';
								</script>
							<select name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
							id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>">
								<option value="">All</option>
								<c:forEach var="collectionCenter" items="${requestScope.collectionCenterList}">
								<option value="<c:out value="${collectionCenter.collectionCenterId}"/>~<c:out value="${collectionCenter.description}"/>">
								<c:out value="${collectionCenter.description}"/>
								</option>
								</c:forEach>
							</select>
						</c:when>
						
							<c:when test="${reportParameters.internalEntityName=='zone'}">
								<script language="javaScript">
								 jsCollectionCenterId='<c:out value="${reportParameters.reportParametersId}"/>';
								</script>
							<select name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
							id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>">
								<option value="">--Other--</option>
								<c:forEach var="collectionCenter" items="${requestScope.collectionCenterList}">
								<option value="<c:out value="${collectionCenter.collectionCenterId}"/>~<c:out value="${collectionCenter.description}"/>">
								<c:out value="${collectionCenter.description}"/>
								</option>
								</c:forEach>
							</select>
						</c:when>
						
						<c:when test="${reportParameters.internalEntityName=='Stage'}">
							<select name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
							id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>">
								<option value=""> <--- Select ---> </option>
								<c:forEach var="stage" items="${requestScope.stageList}">
								<option value="${stage.stageId}~<c:out value="${stage.description}"/>">
									<c:out value="${stage.description}"/>
								</option>
								</c:forEach>
							</select>
						</c:when>
						<c:when test="${reportParameters.internalEntityName=='PlotType'}">
							<script language="javaScript">
								jsPlotTypeParamId='<c:out value="${reportParameters.reportParametersId}"/>';
							</script>
							<select name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
							id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>">
							<option value=""><--- Select ---></option>
							<c:forEach var="plotType" items="${requestScope.plotTypeList}">
									<option value="${plotType.plotTypeId}~<c:out value="${plotType.description}"/>">
											<c:out value="${plotType.description}" />
										</option>
							</c:forEach>
							</select>
						</c:when>
						<c:when test="${reportParameters.internalEntityName=='Plot'}">
							<script language="javaScript">
								jsPlotParamId='<c:out value="${reportParameters.reportParametersId}"/>';
							</script>
							<select name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
							id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>">
							<option value=""><--- Select ---></option>
							<c:forEach var="plot" items="${requestScope.plotList}">
									<option value="${plot.plotId}~<c:out value="${plot.number}"/>">
											<c:out value="${plot.number}" />
										</option>
							</c:forEach>
							</select>
						</c:when>
						<c:when test="${reportParameters.internalEntityName=='LastGeneratedFlag'}">
							<select name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
							id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>">
							<option value="">ALL</option>
							<option value="1">Latest</option>
							</select>
						</c:when>
						<c:when test="${reportParameters.internalEntityName=='AUDIT_ENTITY_NAME'}">
							 <script language="javaScript">
								jsAuditEntityId='<c:out value="${reportParameters.reportParametersId}"/>';
							</script>
							<select id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
								name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>" onchange="getPropertiesOnEntity();" class="ClsTextbox">
									<option value="">
									<-- Select -->
									</option>
									<c:forEach items="${requestScope.entityList}" var="entity">
										<option value="<c:out value="${entity.entityName}"/>">
											<c:out value="${entity.entityName}"/>
										</option>
									</c:forEach>
							</select>
						</c:when>
						<c:when test="${reportParameters.internalEntityName=='AUDIT_PROPERTY_NAME'}">
							 <script language="javaScript">
								jsAuditEntityPropertyId='<c:out value="${reportParameters.reportParametersId}"/>';
							</script>
							<select id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
								name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>" class="ClsTextbox">
									<option value="">
									<-- Select -->
									</option>
									<c:forEach items="${requestScope.entityPropertyList}" var="property">
										<option value="<c:out value="${property.propertyName}"/>">
											<c:out value="${property.propertyName}"/>
										</option>
									</c:forEach>
							</select>
						</c:when>
						<c:when test="${reportParameters.internalEntityName=='User'}">
							<select id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>" name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>" class="ClsTextbox">
									<option value=""> <-- Select --> </option>
									<c:forEach items="${requestScope.userList}" var="user">
										<option value="<c:out value="${user.userName}"/>">
											<c:out value="${user.userName}"/>
										</option>
									</c:forEach>
							</select>
						</c:when>
						<c:when test="${reportParameters.internalEntityName=='Hidden'}">
							<input type="hidden"
								id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
								name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
								value="" />
						</c:when>
						<%@include file="/pages/core-pages/core-reports/reportsCoreEntities.jsp"%>
						<c:otherwise>
							<input type="text" class="ClsTextbox"
								id="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
								name="report.reportParameters.id<c:out value="${reportParameters.reportParametersId}"/>"
								maxlength="<c:out value="${reportParameters.size}"/>"
								value="<c:out value="${reportParameters.defaultValue}"/>" />
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<span class="ClsLabel"> Report Format </span>
			</td>
			<td>
				<select name="reportAs" id="reportAs" style="width:100px" class="ClsTextbox">
					<option value="<c:out value="${pageScope.CONTENT_TYPE_PDF}"/>">
						PDF
					</option>
					<%-- <option value="<c:out value="${pageScope.CONTENT_TYPE_TEXT_HTML}"/>">
						HTML
					</option>
					<option value="<c:out value="${pageScope.CONTENT_TYPE_WORD}"/>">
						MS-Word
					</option>
					<option value="<c:out value="${pageScope.CONTENT_TYPE_EXCEL}"/>">
						MS-Excel
					</option> --%>
				</select>
			</td>
		</tr>
		<tr height="10px">
		<td>
		&nbsp;
		</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<input type="button" value="Back"
					onclick="javascript:sendToReportsListPage()" class="ClsButton" />
				<input type="button" value="Generate"
					onclick="javascript:generateReport()" class="ClsButton" />
				<input type="button" value="Clear"
					onclick="javascript:document.frmPage.reset()" class="ClsButton" />
			</td>
		</tr>
		<tr height="10px">
		<td>
		&nbsp;
		</td>
		</tr>
		<tr height="10px">
		<td colspan="2">
			<c:if test="${not empty reportMessage}">
					<div id="reportMessageDiv" class="ClsLabel">
						<c:out escapeXml="false" value="${reportMessage}"/>
					</div>
			</c:if>
		</td>
		</tr>
		<tr height="10px">
		<td>
		&nbsp;
		</td>
		</tr>		
		
					</thead>
					
					</table>
			</td>
		</tr>
	</table>
	<input type="hidden" id="reportName" name="reportName"
		value="<c:out value="${Report.reportName}"/>" />
	<input type="hidden" id="reportPath" name="reportPath"
		value="<c:out value="${Report.reportPath}"/>" />
	<input type="hidden" id="reportsId" name="reportsId"
		value="<c:out value="${Report.reportsId}"/>" />
	<input type="hidden" id="isGenReportPage" name="isGenReportPage"
		value="Yes" />
	<input type="hidden" id="isMultilingual" name="isMultilingual"
		value="<c:out value="${Report.isMultilingual}"/>" />
		
		<c:if test="${not empty urlLink}">
			<iframe id="potentialMatchResults" name="potentialMatchResults" src="${urlLink}" width="100%" height="400px;">
			</iframe>
		</c:if>
</div>

<script type="text/javascript">

<c:if test="${not empty requestScope.requestReportParams}">
<c:forEach var="Record" items="${requestScope.requestReportParams}">
	if(document.getElementById("<c:out value="${Record.key}" />"))
	{
		document.getElementById("<c:out value="${Record.key}" />").value="<c:out value="${Record.value}" />";
	}
</c:forEach>
</c:if>

	function generateReport()
	{
		//If report generated message is there hide it
		if(document.getElementById("reportMessageDiv") != null)
			document.getElementById("reportMessageDiv").style.display = 'none';

		var arrElements=new Array(<c:out value="${isRequiredFields}" escapeXml="false"/>);
		var arrLongElements = new Array(<c:out value="${isLongFields}" escapeXml="false"/>);
		var arrLongElementNames = new Array(<c:out value="${isLongFieldNames}" escapeXml="false"/>);
		var arrIntegerElements = new Array(<c:out value="${isIntegerFields}" escapeXml="false"/>);
		var arrIntegerElementNames = new Array(<c:out value="${isIntegerFieldNames}" escapeXml="false"/>);
		var arrFloatElements = new Array(<c:out value="${isFloatFields}" escapeXml="false"/>);
		var arrFloatElementNames = new Array(<c:out value="${isFloatFieldNames}" escapeXml="false"/>);

		if(checkMandatoryMsg(arrElements, "Please fill all the required fields which are marked with asterix (*)"))
		{
			if(isNumberArray(arrLongElements,arrLongElementNames))
			{
				if(isNumberArray(arrIntegerElements,arrIntegerElementNames))
				{
					if(isFloat(arrFloatElements,arrFloatElementNames))
					{
						if(checkReportDates()) {
						    displayError("");
							//onPageSubmit('<c:out value="${contextRoot}"/>/report/generateReport.do');
							onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/setReportParameters.do');
							showWorkInProgressImage();
						}
					}
				}
			}
		}
	}

	function checkReportDates() {
		var fromDate = null;
		var toDate = null;

		var objArray = document.frmPage.elements;
		for(i=0;i<objArray.length;i++)
		{
			if(objArray[i].getAttribute("customName") != null)
			{
				if(objArray[i].getAttribute("customName") == 'FROM_DATE')
					fromDate = objArray[i].value;
				if(objArray[i].getAttribute("customName") == 'TO_DATE')
					toDate = objArray[i].value;
			}
		}

		if(fromDate != null && toDate != null)
		{
			return checkDates(fromDate,toDate,'From Date','To Date');
		}
		else
		{
			return true;
		}
	}

	function sendToReportsListPage() {
		onPageSubmit('<c:out value="${contextRoot}"/><c:out value="${REPORTS_LIST_PAGE_URL}"/>');
	}

	getSectorsOnWard();
	function getSectorsOnWard(){
		var wardVar = document.getElementById('report.reportParameters.id'+jsWardParamId);
		if(wardVar != null)
		{
			var wardId = wardVar.value;
			var val = wardId.split("~");
			var sectorId = document.getElementById('report.reportParameters.id'+jsSectorParamId);
			if(sectorId!=null){
			sectorList.getSectorsOnWard(val[0], setSectorsOnWard);
			}
		}
	}

	function setSectorsOnWard(dataList){
		var selectElement = document.getElementById('report.reportParameters.id'+jsSectorParamId);
		removeAllOptions(selectElement);

		var optGroupName = "";
		var optngroup ;

		for(var i=1;i<=dataList.length;i++){
			if (i==1) {
				optGroupName = 	dataList[i-1].nodeMaster.name;
				optngroup = document.createElement("optgroup");
				optngroup.label=optGroupName;
			}

			if(optGroupName != dataList[i-1].nodeMaster.name){
				selectElement.appendChild(optngroup);
				optGroupName = 	dataList[i-1].nodeMaster.name;
				optngroup = document.createElement("optgroup");
				optngroup.label=dataList[i-1].nodeMaster.name;
			}

			var optn = document.createElement("OPTION");
			//optn.text = dataList[i-1].name;
			optn.appendChild(document.createTextNode(dataList[i-1].name));
			optn.value = dataList[i-1].sectorId+"~"+dataList[i-1].name;
			optngroup.appendChild(optn);

			if (i==dataList.length) {
				selectElement.appendChild(optngroup);
			}
		}

	}

	function getSectorListOnNode(){
		var nodeMasterId = document.getElementById('report.reportParameters.id'+jsNodeMasterParamId).value;
		var wardId = document.getElementById('report.reportParameters.id'+jsWardParamId).value;
		var val = nodeMasterId.split("~");
		var val1 = wardId.split("~");
		var sectorId = document.getElementById('report.reportParameters.id'+jsSectorParamId);
		if(sectorId!=null){
			gisMastersList.getSectorsOnWardAndNode(val1[0], val[0], setSectorListOnNode);
		}
	}

	function setSectorListOnNode(dataList){
		var selectElement = document.getElementById('report.reportParameters.id'+jsSectorParamId);
		removeAllOptions(selectElement);

		for(var i=1;i<=dataList.length;i++){
			var optn = document.createElement("OPTION");
			optn.text = dataList[i-1].name;
			optn.value = dataList[i-1].sectorId+"~"+dataList[i-1].name;
			selectElement.options.add(optn);
		}
	}

	function getCollectionCentersOnWard(){
		var wardId = document.getElementById('report.reportParameters.id'+jsWardParamId).value;
		var val = wardId.split("~");
		var collectionCenterId = document.getElementById('report.reportParameters.id'+jsCollectionCenterId);
		if(collectionCenterId!=null){
			collectionCenter.getCollectionCenterOnWard(val[0], setCollectionCentersOnWard);
		}
	}

	function setCollectionCentersOnWard(dataList){
		var selectElement = document.getElementById('report.reportParameters.id'+jsCollectionCenterId);
		removeAllOptions(selectElement);
		for(var i=1;i<=dataList.length;i++){
			var optn = document.createElement("OPTION");
			optn.text = dataList[i-1].description;
			optn.value = dataList[i-1].collectionCenterId+"~"+dataList[i-1].description;
			selectElement.options.add(optn);
		}
	}

	function getPropertiesOnEntity(){
		var auditEntityName = document.getElementById('report.reportParameters.id'+jsAuditEntityId).value;
		var auditPropertyId = document.getElementById('report.reportParameters.id'+jsAuditEntityPropertyId);
		if(auditPropertyId != null)
			reports.getAuditTrailEntityPropertyList(auditEntityName, setPropertiesOnEntity);
	}

	function setPropertiesOnEntity(dataList){
		var selectElement = document.getElementById('report.reportParameters.id'+jsAuditEntityPropertyId);
		removeAllOptions(selectElement);

		for(var i=1;i<=dataList.length;i++){
			var optn = document.createElement("OPTION");
			optn.text = dataList[i-1].propertyName;
			optn.value = dataList[i-1].propertyName;
			selectElement.options.add(optn);
		}
	}

	function getNodeOnWard()
	{
		var wardId = document.getElementById('report.reportParameters.id'+jsWardParamId).value;
		var val = wardId.split("~");
		var nodeMasterId = document.getElementById('report.reportParameters.id'+jsNodeMasterParamId);
		if(nodeMasterId!=null){
		gisMastersList.getNodesOnWard(val[0],setNodeOnWard);
		}
	}
	function setNodeOnWard(dataList)
	{
		var selectElement = document.getElementById('report.reportParameters.id'+jsNodeMasterParamId);
		removeAllOptions(selectElement);
		for(var i=1;i<=dataList.length;i++){
			var optn = document.createElement("OPTION");
			optn.text = dataList[i-1].name;
			optn.value = dataList[i-1].nodeMasterId+"~"+dataList[i-1].name;
			selectElement.options.add(optn);
	  }
	}

	function getPlotsOnSector()
	{
	  var sectorId=document.getElementById('report.reportParameters.id'+jsSectorParamId).value;
	  var val = sectorId.split("~");
	  var plotId = document.getElementById('report.reportParameters.id'+jsPlotParamId);
	  if(plotId != null)
	  {
	   plotList.getPlotsOnSector(val[0],setPlotsOnSector);
	  }
	}

	function setPlotsOnSector(dataList)
	{
		var selectElement = document.getElementById('report.reportParameters.id'+jsPlotParamId);
		removeAllOptions(selectElement);
		for(var i=1;i<=dataList.length;i++)
		{
			var optn = document.createElement("OPTION");
			optn.text = dataList[i-1].number;
			optn.value = dataList[i-1].plotId;
			selectElement.options.add(optn);
	    }
	}

	function showWorkInProgressImage()
	{
		document.getElementById("workInProgressImageId").style.display="";
		disableButtons(document.forms[0]);
	}

</script>