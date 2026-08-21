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
		File Acknowledge/Dispatch  Mode
	</h3>
</div>
<div valign="top" id="SetFormHeight">
<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
	<tr>
		<td colspan="2">
		<spring:bind path="deliveryMode.deliveryModeId">
			<input type="hidden" id="deliveryModeId" name="deliveryModeId" value="<c:out value="${deliveryMode.deliveryModeId}"/>" />
		</spring:bind>
		</td>
	</tr>
	
	<tr>
		<td width="20%"><span class="ClsLabel">Received Mode Name</span><span class="ClsRequiredFields">*</span></td>
		<td>
			<spring:bind path="deliveryMode.deliveryModeName">
				<input type="text" class="ClsTextbox" id="deliveryModeName" maxlength="50" name="deliveryModeName" value="${deliveryMode.deliveryModeName}" />
			</spring:bind>
		</td>	
		<!-- <td > 		
			<input type="button" class="ClsButton" id="save" name="save" value="Add Field" onclick="javascript:addFields();"> 
			<input type="button" class="ClsButton" id="save" name="save" value="Remove Field" onclick="javascript:removeFields();"> 
		</td> -->
			
	</tr>
	 
	
	<!-- <tr>
		<td colspan="2">
		    <input type="button"
						class="ClsButton" style="height: 20px; width: 20px; border: 0px" id="add" name="Add" value="+"
						onclick="addPreviousRowToTable('communicationFileds');" /> 
						<input type="button"		class="ClsButton" style="height: 20px; width: 20px; border: 0px"
						id="remove" name="Remove" value="-"	onclick="removeNewRowFromTable('communicationFileds',1);" />
			<span class="ClsLabel"style="padding-left: 20px">Delivery Fields </span><br>			 
			<table width="98%"  border="1"  cellpadding="0" cellspacing="1"  class="dataGrid" id="communicationFileds">
				<tr>
					<td>#</td>
					<td width="40%"><span class="ClsLabel">Field Name</span><span class="ClsRequiredFields">*</span></td>
					<td>
						<span class="ClsLabel"> Field Type</span><span class="ClsRequiredFields">*</span>
					</td>
					<td>
						<span class="ClsLabel">Field Data Type</span><span class="ClsRequiredFields">*</span>
					</td>	
					<td>
						<span class="ClsLabel"> Is Required Field</span><span class="ClsRequiredFields">*</span>
					</td>						
				</tr>	
				<tr>
				    <td> 1 </td>
					<td> 
						 <input type="text"  id="fieldLabel" name="fieldLabel" class="ClsTextbox" style="width:70%" />
					</td>
					<td>
						 <select    id="fieldType" name="fieldType"  class="ClsTextbox"  style="width:250px">
						 	<option value=""> Select Field Type</option>
						 	<option value="text">Text Field</option>
						 	<option value="textArea">Text Area</option>  
						 </select>
					</td>
					<td class="ClsLabel">	
					
						<select    id="fieldDataType" name="fieldDataType"  class="ClsTextbox"  style="width:250px">
						 	<option value=""> Select Data Type</option>
						 	<option value="string">String</option> 
						 	<option value="number">Number</option> 
						 </select>					 
						 <input type="radio" id="string" name="fieldDataType" value="string">String 
						 <input type="radio" id="number" name="fieldDataType" value="number">Number  				
					</td>
					<td class="ClsLabel">	
						 <input type="checkbox" id="yes" name="fieldRequired" value="1">Yes					 
						 <input type="radio" id="no" name="fieldRequired" value="0">No						 				
					</td>	
				</tr>		 
			</table>
		</td>	 
	</tr>
	
	 -->
	
	<tr><td  colspan="2" style="padding-top:5px"></td></tr>
	<tr><td></td>
		<td>
			<input type="button" class="ClsButton" id="save" name="save" value="Save" onclick="javascript:saveDeliveryMode(this.form);">
			<!-- <input type="button" class="ClsButton" id="clear" name="clear" value="Clear" onclick="javascript:clearContorls();">	 -->		
	</tr>	
	
</table>
</div>
<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/>

<script type="text/javascript">

  /*  var ctr = 1;
    function addFields(){           
       var fieldLabel = "fieldLabel" + ctr;
       var fieldType = "fieldType" + ctr; 
       var newTr = '<tr><td><input type="text"  class="ClsTextbox" id='+fieldLabel+' name="fieldLabel" style="width:80%" /></td><td>'+
      		 '<select name="fieldType" id='+fieldType+' name="fieldType" class="ClsTextbox"  style="width:250px"><option value="1">Text Field</option><option value="2">Drop Down</option></select> </td></tr>';
       $('#communicationFileds').append(newTr);	
       ctr++;
   }  
      
   function removeFields(){      
	   if(ctr>1){
		   $('#communicationFileds tr:last').remove();
	       ctr--;
	   }
   } */
   
   
	function saveDeliveryMode(frm)	{
	   //alert(123);
		var fileCommunicationModeName = document.getElementById("deliveryModeName").value;
		if(fileCommunicationModeName == null || fileCommunicationModeName==''){
			alert('Please Enter Delivery Mode Name ')
			return false;			
		} 
		/* var validStatus = false;
		if(checkMandatoryDetailed(new Array('fieldLabel','fieldType', 'fieldDataType' ),  new Array('Field Name', 'Field Type' ,'Data Type'))){	 
			var totalFields = $('[id][name=fieldLabel]').length;	
			validStatus = true;
			for(var i=2 ; i<=totalFields ; i++){
				if(checkMandatoryDetailed(new Array('fieldLabel'+i, 'fieldType'+i, 'fieldDataType'+i),  new Array('Field Name', 'Field Type', 'Data Type'))){
					validStatus = true;
				}		
				else{
					validStatus = false;
					return false;
				}	
			}										  
		} */	
		alert(validStatus);
		if(validStatus){
			navigate(frm,'<c:out value="${contextRoot}"/>/deliveryMode/saveDeliveryMode.do');
		}
		
		
		
		
		/* for(i=i ; i<ctr ; i++){ 	
			var  fieldLabelVal = document.getElementById("fieldLabel"+i).value;
			var  fieldTypeVal = document.getElementById("fieldType"+i).value;
			if(fieldLabelVal == null ||  fieldLabelVal =='' ){
				alert('Please Enter Filed Lebel Value'); 
				return false;
			}	
			else if( fieldTypeVal == null || fieldTypeVal==''){
				alert('Please Select Filed Type'); 
				return false;
			}		 				 
		} */
		
		
	} 
	
</script>