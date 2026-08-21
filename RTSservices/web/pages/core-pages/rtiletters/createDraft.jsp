<%@page import="com.mars.common.utils.Constants"%>
<%@page import="com.mars.rti.utils.CoreConstants"%> 
<jsp:directive.include file="/pages/common/include.jsp" /> 
<%@include file="/pages/common/includeTransliterateJS.jsp"%>
<%@ taglib prefix="crt" uri="http://java.sun.com/jstl/core_rt" %>

 
<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT); 
pageContext.setAttribute("SESSION_TOKEN_KEY",	Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("DELIVERY_MODE_FIELD_TEXT",	Constants.DELIVERY_MODE_FIELD_TEXT);
pageContext.setAttribute("DELIVERY_MODE_FIELD_TEXT_AREA",	Constants.DELIVERY_MODE_FIELD_TEXT_AREA);
pageContext.setAttribute("DELIVERY_MODE_DATA_TYPE_NUMBER",	Constants.DELIVERY_MODE_DATA_TYPE_NUMBER);


%>
  
  <!--   <meta charset="utf-8">   -->
    
    <link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/scripts/docs/css/site.css" > </link>  
    <link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/scripts/docs/richtext.min.css" ></link>   
	<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/docs/jquery.richtext.js"></script>    
     
    <script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
 
 
<div class="mainHdr">
	<h3>
		Create Draft
	</h3>
</div> 
 
<div valign="top" id="SetFormHeight" style="height: 100%"> 
	<c:if test="${not empty draft && draft.draftId >0 }">
	<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm"> 
		<tr> 
			<td><span class="ClsLabel">	  Draft Number: ${draft.draftNumber} </span> </td>			 		
		</tr>	
	</table>
	</c:if>	 
	<div  style="width: 100%">
		<div style="float:left; width: 45%">
			<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
			
			    <tr>	
					<td>
					 	<span class="ClsLabel">Draft Type</span> <span class="ClsRequiredFields">*</span> : 
						<select class="ClsSelect" name="draftType" id=draftType >
							<option value=""><--- Select ---></option> 
							<c:forEach var="draftType" items="${draftTypeList}">
								<c:choose>
									<c:when test="${draft.draftType.draftTypeId==draftType.draftTypeId}">
										<option value="${draftType.draftTypeId}" selected="selected">
											<c:out value="${draftType.draftTypeName}" /></option>
									</c:when>
									<c:otherwise>
										<option value="${draftType.draftTypeId}">${draftType.draftTypeName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>															 
						</select> 
					</td>			 			
				</tr> 
				
				<tr>	
					<td> <span class="ClsLabel">Select Draft/Letter Dispatch Mode</span> <span class="ClsRequiredFields">*</span> </td>			 			
				</tr> 
				<c:forEach items="${deliveryModeList}" var="draftMode" >
					<c:choose>
						<c:when test="${draftMode.deliveryModeName eq 'email' || draftMode.deliveryModeName eq 'E Mail' || draftMode.deliveryModeName eq 'E-Mail'  }">
							<tr>
								<td> 
									<span class="ClsLabel">
									    <input type="checkbox" id="email" name="draftModeNameEmail" value="${draftMode.deliveryModeId}"  > E-Mail					
									</span>  
									
									<div style="width: 100%; display: none;" id="viewEmailMode"  >
									<br>
										<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
											<tr>	 
												 <td width="20%"> <span class="ClsLabel">To</span> <span class="ClsRequiredFields">*</span> </td>
												 <td> 
													<input type="text" class="ClsTextboxEmail" style="width: 96%" value="${rtiApplication.email}" id="to"  maxlength="100" name="to" />	
												 </td>
											</tr>
											<tr>	 
												 <td width="20%"> <span class="ClsLabel">CC</span> </td>
												 <td> 
													<input type="text" class="ClsTextboxEmail"  style="width: 96%" id="cc"  maxlength="100"   name="cc" />	
												 </td>
											</tr>
											<tr>	 
												 <td width="20%"> <span class="ClsLabel">Subject</span> <span class="ClsRequiredFields">*</span> </td>
												 <td> 
													<input type="text" class="ClsTextboxEmail"  style="width: 96%" id="subject"  maxlength="150"   name="subject" />	
												 </td>
											</tr>
											<tr>	 
												 <td width="20%"> <span class="ClsLabel">Content</span> <span class="ClsRequiredFields">*</span> </td>
												 <td> 
													<textarea rows="10" class="ClsTextAreaEmail"  style="width: 96%; height:auto" id="content"   name="content" /></textarea>	
												 </td>
											</tr>
										</table> 
									</div>	
								</td>
							</tr>	
							<tr>
								<td>
								  <hr>  	
								</td>
							</tr>
						</c:when>
						<c:when test="${draftMode.deliveryModeName eq 'sms' ||  draftMode.deliveryModeName eq 'SMS'}">
							<tr>
								<td> 
									<span class="ClsLabel">
									    <input type="checkbox" id="sms" name="draftModeNameSMS" value="${draftMode.deliveryModeId}" > SMS	 				
									</span>  
									<div style="width: 100%;  display: none;" id="viewSmsMode"  >
										<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm"> 
											<tr>	 
												 <td width="02%"> <span class="ClsLabel">Mobile Number</span> <span class="ClsRequiredFields">*</span> </td>
												 <td> 
													<input type="text" class="ClsTextboxEmail" value="${rtiApplication.mobileNumber}" style="width: 96%" id="mobileNumber"  maxlength="10"   name="mobileNumber" />	
												 </td>
											</tr>      
											<tr>	 
												 <td width="20%"> <span class="ClsLabel">Text</span> <span class="ClsRequiredFields">*</span> </td>
												 <td> 
												 
												 	<textarea rows="7" class="ClsTextAreaEmail"  style="width: 96%; height:auto" id="textMessage"   name="textMessage" /></textarea>	
												 </td>
											</tr>
										</table> 
									</div>	
								</td>
							</tr>	
							<tr>
								<td>
								  <hr>  	
								</td>
							</tr>
						</c:when>
						<c:when test="${draftMode.deliveryModeName eq 'post' || draftMode.deliveryModeName eq 'Post' }">
							<tr>
								<td> 
									<span class="ClsLabel">
									    <input type="checkbox" id="post" name="draftModeNamePost" value="${draftMode.deliveryModeId}"  > Post					
									</span>  
									<div style="width: 100%; display: none;"  id="viewPostMode"  >
										<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm">  
											<tr>	 
												 <td width="20%"> <span class="ClsLabel">Address</span><span class="ClsRequiredFields">*</span>  </td>
												 <td> 
												 	<c:set var="addrss" value="${rtiApplication.applicantName} ${rtiApplication.addressLine1} ${rtiApplication.addressLine2} ${rtiApplication.district} ${rtiApplication.state}-${rtiApplication.pincode} ${rtiApplication.mobileNumber} "/>													
<textarea rows="10"  class="ClsTextAreaEmail"  style="width: 96%; height:auto" id="postalAddress"   name="postalAddress" >Name- ${rtiApplication.applicantName}
${rtiApplication.addressLine1} ${rtiApplication.addressLine2} ${rtiApplication.district} ${rtiApplication.state}-${rtiApplication.pincode} 
${rtiApplication.mobileNumber}</textarea>	
												 </td>
											</tr>
										</table>								
									</div>	
								</td>
							</tr>
							<tr>
								<td>
								  <hr>  	
								</td>
							</tr>	
						</c:when>
					</c:choose>		
				</c:forEach>		  		    
			</table>
		</div>
		<div style="width: 55%;float: right;" >
			<table width="98%" border="0" cellpadding="2" cellspacing="2" class="dataForm" align="center" style="height: 300px">
				<tr>
					<td>
					<div class="page-wrapper box-content" style="padding: 5px;width: 98%">	
					   <textarea class="content" name="createDraft" id="createDraft">${draft.draftContent}</textarea>
					</div>
					</td>
				</tr>
				<tr>
					<td> 
			 			<input type="button"  style="vertical-align:bottom;" class="ClsButton" id="saveDraft" name="saveDraft" value="Save Draft" onclick="javascript:draftSaveButton('0', this.form);">
			 			<input type="button"  style="vertical-align:bottom;" class="ClsButton" id="sentDraft" name="sentDraft" value="Send Draft" onclick="javascript:draftSaveButton('1', this.form);">
			 		</td>
				</tr>
			</table> 
		</div>	
	</div> 		 
</div> 
  	    
  	     
	<%-- <spring:bind path="draft.draftContent">
	 	<input type="hidden" id="draftContent" name="draftContent">  
	</spring:bind> --%>
	 	
	<input type="hidden" id="draftContent" name="draftContent">  
	<input type="hidden" id="sentOrGenerateOnly" name="sentOrGenerateOnly">  
	<input type="hidden" id="manageRTIApplicationId" name="manageRTIApplicationId" value="${manageRTIApplicationId}"> 
	<c:if test="${not empty draft && draft.draftId >0 }">
		<spring:bind path="draft.draftId">
			<input type="hidden" id="draftId" name="draftId">   
		</spring:bind>
	</c:if> 	
	<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/>
 		
	
<script>
    $(document).ready(function() {
        $('.content').richText();        
        $('.richText-editor').css("height","550px");
        $('.main').css("height","auto");
        
        if($("#email").prop('checked') == true){
        	document.getElementById('viewEmailMode').style.display='block'; 
        }
		if($("#sms").prop('checked') == true){
			document.getElementById('viewSmsMode').style.display='block'; 
        }
		if($("#post").prop('checked') == true){
			document.getElementById('viewPostMode').style.display='block'; 
        }
		
		
		$("#email").click(function() { 
			if($("#email").prop('checked') == true){
				document.getElementById('viewEmailMode').style.display='block'; 
	        }else{
	        	document.getElementById('viewEmailMode').style.display='none'; 
	        } 
        }); 
		
		$("#sms").click(function() { 
			if($("#sms").prop('checked') == true){
				document.getElementById('viewSmsMode').style.display='block'; 
	        }else{
	        	document.getElementById('viewSmsMode').style.display='none'; 
	        } 
        }); 
		
		$("#post").click(function() { 
			if($("#post").prop('checked') == true){
				document.getElementById('viewPostMode').style.display='block'; 
	        }else{
	        	document.getElementById('viewPostMode').style.display='none'; 
	        } 
        }); 
		
    });
    
   
    
    /*  function viewCommunicationFields(checkedId){
    	var isModeChecked = document.getElementById('draftModeName'+checkedId);
    	if(isModeChecked.checked){
    		document.getElementById('viewCommunicationFields'+checkedId).style.display='block'
    	}else{
    		document.getElementById('viewCommunicationFields'+checkedId).style.display='none'
    	}
    }
      */
   
    
    function draftSaveButton( saveButtonId, frm)
    {
    	var draftType = document.getElementById("draftType").value;
    	if(draftType == null || draftType == ''){
    		alert('Please Select Draft Type');
    		return false;
    	}
    	if(saveButtonId == '0'){
    		document.getElementById("sentOrGenerateOnly").value=0 ;
    		createDraft(frm);
    	}else if(saveButtonId == '1'){
    		document.getElementById("sentOrGenerateOnly").value=1 ;
    		createAndSendDraft(frm);
    	}else{ 
    		return false;
    	}
    	
    }
    
    function createDraft(frm){
		var draftText = document.getElementsByClassName("richText-editor")[0].innerHTML;  		
    	if(draftText == null || draftText =='' || draftText == '<br/>' || draftText == '<br>'   ){
    		alert('Please Enter the Draft Detail');
    		return false;
    	}   	 
    	document.getElementById("draftContent").value= draftText;
    	navigate(frm,'<c:out value="${contextRoot}"/>/draft/saveDraft.do');  
    }
    
    function createAndSendDraft(frm){    	
    	var eMailChecked = document.getElementById('email');
    	var smsChecked = document.getElementById('sms');
    	var postChecked = document.getElementById('post');
    	if (eMailChecked.checked) {
    		var validEmail=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    		var to = document.getElementById('to').value; 
    		var cc = document.getElementById('cc').value; 
    	 	var subject = document.getElementById('subject').value;
    	 	var content = document.getElementById('content').value;
    	 	if(to==''){
    	 		alert('Please Enter  Email Id - To');
    	 		return false;
    	 	}
    	 	if(!(to.match(validEmail))){
    	 		alert('Please Enter Valid Email Id - To ');
    	 		return false;
    	 	}
    	 	if(cc!='' && 
    	 			!(cc.match(validEmail))){
    	 		alert('Please Enter Valid Email Id - CC');
    	 		return false;
    	 	}
    	 	if(subject==''){
    	 		alert('Please Enter  Email  Subject');
    	 		return false;
    	 	}
    	 	if(content==''){
    	 		alert('Please Enter  Email  Content');
    	 		return false;
    	 	}
    	}
    	if (smsChecked.checked) {    		 
    		var mobileNumber = document.getElementById('mobileNumber').value; 
    		var textMessage = document.getElementById('textMessage').value;    			 
    		if(mobileNumber=='' || mobileNumber.length!=10){
    	 		alert('Please Enter  Valid 10 digit Mobile Number');
    	 		return false;
    	 	}
    		if(!isNumberArray(new Array('mobileNumber'), new Array('Please enter Valid Mobile Number')))
   			{
   				return false;
   			}    		
    	 	if(textMessage==''){
    	 		alert('Please Enter Message');
    	 		return false;
    	 	}    	 	
    	}
    	if (postChecked.checked) {    		 
    		var postalAddress = document.getElementById('postalAddress').value;  			 
    		if(postalAddress==''){
    	 		alert('Please Enter  Valid Postal Address');
    	 		return false;
    	 	}
    	}	
    	
    	var draftText = document.getElementsByClassName("richText-editor")[0].innerHTML;  		
    	if(draftText == null || draftText =='' || draftText == '<br/>' || draftText == '<br>'   ){
    		alert('Please Enter the Draft Detail');
    		return false;
    	}   	 
    	document.getElementById("draftContent").value= draftText;
    	navigate(frm,'<c:out value="${contextRoot}"/>/draft/saveDraft.do');  
    	 
    }
    
    
    
    /* function createAndSendDraft(frm){  	
		 
		var communicationModesChecked = document.getElementsByName('draftModeName');			 
	  	for (var i=0; i<communicationModesChecked.length; i++) { 
	  		//alert(i);alert(communicationModesChecked[i].checked);
	    	 if (communicationModesChecked[i].checked) {
	    		 var communicationModesCkeckedValues = communicationModesChecked[i].value
	    		
	    		 //Check is Required Fileds
	    		 var requiredMode=  document.getElementById('isRequiredFields'+communicationModesCkeckedValues).value;  	    		 
	    		 var arrElements= requiredMode.split(',');  
	    		 if(requiredMode!=null && requiredMode!=''){
		    		 if(checkMandatoryMsg(arrElements, "Please fill all the required fields which are marked with asterix (*)")) { 	    			
		    		 } else{
		    			 return false;
		    		 }
	    		 }
	    		 //Check is Long Fields
	    		 var isLongFields = document.getElementById('isLongFields'+communicationModesCkeckedValues).value; 
    			 var isLongFieldNames = document.getElementById('isLongFieldNames'+communicationModesCkeckedValues).value;     			 
    			 var arrIsLongFields = isLongFields.split(',');  
    			 var arrIsLongFieldsMsg = isLongFieldNames.split(','); 
    			 if(isLongFields !=null && isLongFields!=''){
	    			 if(isNumberArray(arrIsLongFields,arrIsLongFieldsMsg)){
	    				 
	    			 }else{
		    			 return false;
		    		 }	  
    			 }
	    	 }
	  	} 		
    	var draftText = document.getElementsByClassName("richText-editor")[0].innerHTML;  		
    	if(draftText == null || draftText =='' || draftText == '<br/>' || draftText == '<br>'   ){
    		alert('Please Enter the Draft Detail');
    		return false;
    	}   	 
    	document.getElementById("draftContent").value= draftText;
    	navigate(frm,'<c:out value="${contextRoot}"/>/draft/saveDraft.do');  		
    } */
 
	
    
   
</script>	

 