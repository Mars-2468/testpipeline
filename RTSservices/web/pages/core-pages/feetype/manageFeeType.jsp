<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants,com.mars.common.utils.CommonUtils"/>
<%@include file="/pages/common/includeTransliterateJS.jsp"%>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
pageContext.setAttribute("statusList", CommonUtils.getStatus());
%>
<div class="mainHdr">
	<h3> 
		<c:choose>
			<c:when test="${feeType.feeTypeId==0}">
				<fmt:message key="feeType.manage.pagetitle.new"/>
			</c:when>
			<c:otherwise>	
				<fmt:message key="feeType.manage.pagetitle.edit"/>
			</c:otherwise>
		</c:choose>
	</h3>
</div>
<div valign="top" id="SetFormHeight">
<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
	<tr>
		<td colspan="2">
			<spring:bind path="feeType.feeTypeId">
			<input type="hidden" id="feeTypeId" name="feeTypeId" value="<c:out value="${feeType.feeTypeId}"/>" />
			</spring:bind>
		</td>
	</tr>
	
	
	<tr>
		<td>
			<span class="ClsLabel"><fmt:message key="feeType.manage.label.feeTypeName"/></span><span class="ClsRequiredFields">*</span>
		</td>
		<td>
			<spring:bind path="feeType.name">
			<input type="text" class="ClsTextbox" id="name" maxlength="45" name="name" value="<c:out value="${feeType.name}"/>" />
			</spring:bind>
		</td>
	</tr>
	
	
	<tr><td  colspan="2" style="padding-top:5px"></td></tr>
	<tr><td></td>
		<td>
			<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveFeeType(this.form);">
			<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">
			<c:if test="${feeType.feeTypeId!=0}">
				<input type="button" class="ClsButton" id="delete" name="delete" value="Delete" onclick="javascript:deleteFeeType(this.form);">
			</c:if>
		</td>
	</tr>
	
</table>

</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/>


<script type="text/javascript">
function saveFeeType(frm)
{
	var arrRequiredElements=new Array('name');
	var arrRequiredElementsMessages=new Array('<fmt:message key="feeType.manage.label.fileTypeName"/>');
	if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages)){
		if(isAlphaUndrsc(new Array('name'),new Array('<fmt:message key="feeType.manage.label.fileTypeName"/>'))){	
				
				navigate(frm,'<c:out value="${contextRoot}"/>/feeType/saveFeeType.do');		
			}
		}
}
function deleteFeeType(id)
{
	if(confirmDelete()){
		onPageSubmit('<c:out value="${contextRoot}"/>/feeType/deleteFeeType.do');
	}
}

	<c:if test="${feeType.feeTypeId ==1 || feeType.feeTypeId ==2}">
		disableAllControls();
		hideButtons();
	</c:if>
</script>