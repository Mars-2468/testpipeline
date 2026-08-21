<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%@include file="/pages/common/includeTransliterateJS.jsp"%>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
%>
<div class="mainHdr">
	<h3> 
		 Received  Mode
	</h3>
</div>
<div valign="top" id="SetFormHeight">
<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
	<tr>
		<td colspan="2">
		<spring:bind path="receivedMode.receivedModeId">
			<input type="hidden" id="receivedModeId" name="receivedModeId" value="<c:out value="${receivedMode.receivedModeId}"/>" />
		</spring:bind>
		</td>
	</tr>
	
	<tr>
		<td><span class="ClsLabel">Received Mode Name</span><span class="ClsRequiredFields">*</span></td>
		<td>
			<spring:bind path="receivedMode.receivedModeName">
				<input type="text" class="ClsTextbox" id="receivedModeName" maxlength="50" name="receivedModeName" value="${receivedMode.receivedModeName}" />
			</spring:bind>
		</td>
	</tr>

	
	<tr><td  colspan="2" style="padding-top:5px"></td></tr>
	<tr><td></td>
		<td>
			<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveReceivedMode(this.form);">
			<input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">			
	</tr>
</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/>

<script type="text/javascript">

	function saveReceivedMode(frm)	{	
		var receivedModeName = document.getElementById("receivedModeName").value;
		if(receivedModeName == null || receivedModeName==''){
			alert('Please Enter File Received Mode')
			return false;			
		}
		navigate(frm,'<c:out value="${contextRoot}"/>/receivedMode/saveReceivedMode.do');
		
	} 
	
</script>