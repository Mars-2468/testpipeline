<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);%>
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${plot.plotId==0}"><fmt:message key="plot.manage.pagetitle.new" /></c:when>
			<c:otherwise><fmt:message key="plot.manage.pagetitle.edit" /></c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top"  id="SetFormHeight">
<table border="0" cellpadding="2" cellspacing="2" class="dataForm">
<tr>
<td colspan="2">
<spring:bind path="plot.plotId">
<input type="hidden" id="plotId" name="plotId" value="<c:out value="${plot.plotId}"/>" />
</spring:bind>
</td>
<td>
<spring:bind path="plot.status">
<input type="hidden" id="status" maxlength="1" name="status" value="<c:out value="${plot.status}"/>" />
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="plot.manage.label.number"/></span><span class="ClsRequiredFields">*</span>
</td>
<td>
<spring:bind path="plot.number">
<input type="text" class="ClsTextbox" id="number" maxlength="100" name="number" 
value="<c:out value="${plot.number}"/>" style="width:220px;"/>
</spring:bind>
</td>
</tr>
<tr>
<td>
<span class="ClsLabel"><fmt:message key="plot.manage.label.plotType"/></span><span class="ClsRequiredFields">*</span></td>
<td>
	<spring:bind path="plot.plotType.plotTypeId">
		<select name="plotTypeId" id="plotTypeId" class="ClsTextbox">
			<option value=""><-- Select --></option>
			<c:forEach var="plotType" items="${requestScope.plotTypeList}">	
					
					<c:choose>
						<c:when test="${plot.plotType.plotTypeId==plotType.plotTypeId}">
							<option value="${plotType.plotTypeId}" selected="selected">
							<c:out value="${plotType.description}" /></option>
						</c:when>
						<c:otherwise>
							<option value="${plotType.plotTypeId}"><c:out
								value="${plotType.description}" /></option>
						</c:otherwise>
					</c:choose>
			</c:forEach>
		</select>
	</spring:bind>
</td>
</tr>
	<tr>
		<td><span class="ClsLabel"><fmt:message
			key="plot.manage.label.sector" /></span><span class="ClsRequiredFields">*</span>
		</td>
		<td><spring:bind path="plot.sector.sectorId">
			<select name="sectorId" id="sectorId" class="ClsTextbox">
				<option value=""><-- Select --></option>
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
						<c:choose>
						<c:when test="${plot.sector.sectorId==sector.sectorId}">
							<option value="<c:out value="${sector.sectorId}"/>" selected="selected">
								<c:out value="${sector.name}" /> 
							</option>
						</c:when>
						<c:otherwise>
							<option value="<c:out value="${sector.sectorId}"/>">
								<c:out value="${sector.name}" />
							</option>
						</c:otherwise>
						</c:choose>
					</c:if>
					</c:forEach>
					<c:if test="${not empty requestScope.sectorList}">
						</optgroup>
					</c:if>
			</select>
			
		</spring:bind></td>
	</tr>
	<tr><td  colspan="2" style="padding-top:5px"></td></tr>
<tr><td></td>
<td>
<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:savePlot(this.form);">
<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
<c:if test="${plot.plotId!=0}">
<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deletePlot(this.form);">
</c:if>
</tr>
</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/><script type="text/javascript">
function savePlot(frm)
{
	var arrRequiredElements=new Array('number','plotTypeId','sectorId');
	var arrRequiredElementsMessages=new Array('<fmt:message key="plot.manage.label.number"/>',
			'<fmt:message key="plot.manage.label.plotType"/>',
			'<fmt:message key="plot.manage.label.sector"/>');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages))
		{	
		var arrAlphaNumericSpecialElements=new Array('number');
		var arrAlphaNumericSpecialElementsMessages=new Array('<fmt:message key="plot.manage.label.number"/>');
		if(isAlphaNumericSpecial(arrAlphaNumericSpecialElements,arrAlphaNumericSpecialElementsMessages,'-/'))
		{		
			navigate(frm,'<c:out value="${contextRoot}"/>/plot/savePlot.do');
		}
		}
	
}
</script><script type="text/javascript">
function deletePlot(id)
{
if(confirmDelete()){
	onPageSubmit('<c:out value="${contextRoot}"/>/plot/deletePlot.do');
}
}
</script>