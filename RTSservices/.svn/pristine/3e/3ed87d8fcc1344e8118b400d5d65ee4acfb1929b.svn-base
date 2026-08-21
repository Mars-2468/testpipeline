<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants,com.mars.common.utils.CommonUtils,com.mars.rti.utils.CoreConstants"/>
<div class="mainHdr">
	<h3> 
		RTI Application Appeal
	</h3>
</div>

<div valign="top" id="SetFormHeight">
	<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
		 <tr>
			<td width="220px">
				<span class="ClsLabel"> RTI Application Reference No.</span>
			</td>
			<td width="200px">			 
				  <input type="text" class="ClsTextbox"  id="rtiApplicationRefNumber" name="rtiApplicationRefNumber"   />
	 		</td>
	 		<td width="200px">
	 			<input type="button" class="ClsButton" id="save" name="save" value="Get RTI Application Details" onclick="javascript:getRTIApplication(this.form);">
	 		</td>
	 		<td>
				<span class="ClsLabel"> &nbsp;</span>
			</td>
		</tr>	 	
	
	</table> 	 
</div>  

<script type="text/javascript">

function getRTIApplication(frm)
{
	 if(document.getElementById("rtiApplicationRefNumber").value != ''){
		 navigate(frm,'<c:out value="${contextRoot}"/>/rtiapplicationAppeal/viewRTIApplicationAppeal.do'); 
	 }else{
		 displayError("Please Enter RTI Application Reference No.");
	 }
} 

 
</script>