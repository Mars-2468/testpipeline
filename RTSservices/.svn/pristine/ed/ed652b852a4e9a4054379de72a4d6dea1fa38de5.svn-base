 
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%> 
<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("DATE_TIME_DB_FORMAT", Constants.DATE_TIME_DB_FORMAT);
	pageContext.setAttribute("DATE_TIME_FORMAT", WorkflowConstants.WORKFLOW_DATE_FORMAT);
	
 %>
 
 <script type="text/javascript">
	function viewNoting() { 
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/viewNoting.do');
	} 
</script>	

<div class="mainHdr">
	<h3>
		View Noting
	</h3>
</div>

<div valign="top" id="SetFormHeight">
	<div class="ClsSearch">
		<table id="SearchTable" class="searchForm" border="0" cellpadding="2" cellspacing="1" width="100%" >	 
			<tr>
				<td>
					Computer Number
				</td>
				<td>
					<input type="text"  maxlength="10" name="rtiApplicationId" class="ClsTextbox"  id="rtiApplicationId"  />
				</td>				
				<td>
					 <button type="button" class="btn btn-primary btn-xs" onclick="viewNoting()"  >View Noting</button> 
				</td>
			</tr>
			<tr>	
				<td colspan="2"><hr></td>
			</tr>
				
			<tr>	
				<td colspan="2">
					
				</td>
			</tr>	 
		</table>
	</div>  
</div> 
  	

