 <jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_UPLOAD_TOKEN_KEY", Constants.SESSION_UPLOAD_TOKEN_KEY);
%>
 
 
    <meta charset="utf-8"> 
    <!-- <link rel="stylesheet" href="css/site.css"> -->
   <!--  <link rel="stylesheet" href="../src/richtext.min.css"> -->
    <!-- <script src="../src/jquery.richtext.js"></script> -->
    
    <link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/scripts/docs/css/site.css" />  
    <link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/scripts/docs/richtext.min.css" />   
	<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/docs/jquery.richtext.js"></script>
    
    
    <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>     -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>

 

 
<div valign="top" id="SetFormHeightNoting"> 
	 <div class="page-wrapper box-content" style="padding: 5px">	
	    <textarea class="content" name="example"></textarea>
	 </div>	 
</div>
<div align="center">

<input type="button"  style="vertical-align:bottom;" class="ClsButton" id="save" name="save" value="Save Noting" onclick="javascript:saveRTIApplicationNoting(this.form);">
<input type="hidden" id="notingText" name="notingText">
  
 
 <input type="hidden" id="rtiApplicationId" name="rtiApplicationId" 	value="${sessionScope.rtiApplicationIdNoting}" />	
 <input type="hidden" id="rtiApplicationDetailsId" name="rtiApplicationDetailsId" value="${sessionScope.rtiApplicationDetailsIdNoting}" />	
 	
</div>			
<script>
    $(document).ready(function() {
        $('.content').richText();
    });
	
    function saveRTIApplicationNoting(frm)
    {
    	var rtiApplicationId = document.getElementById("rtiApplicationId").value;
    	var rtiApplicationDetailsId = document.getElementById("rtiApplicationDetailsId").value;
    	var notingTexts = document.getElementsByClassName("richText-editor")[0].innerHTML; 
    	var notingId =  '';
    	//alert('========'+notingTexts+'=========');
    	if(notingTexts == null || notingTexts =='' || notingTexts == '<br/>' || notingTexts == '<br>'   ){
    		alert('Please Enter the Noting');
    		return false;
    	}
    	///document.getElementById("notingText").value = 	notingTexts;    	
    	CommonServiceDWR.saveRTIApplicationNoting(rtiApplicationId, rtiApplicationDetailsId, notingTexts, notingId, setNotingMessage);
    	//navigate(frm,'<c:out value="${contextRoot}"/>/filecreationVerification/saveFileNoting.do');
    }
    function setNotingMessage(notingMessage)
    {    	
    	if(notingMessage!=null){
    		
    		if(notingMessage == "N")
			{
    			alert('Error: Something went Wrong'  );
    			//$("#message").html("<font color='red'>"+ JSON.stringify('Error: Something went Wrong') +" </font>");
			}	
    		else if(notingMessage == "E")
			{
    			alert(   'Error: Please Enter Noting'  );
			}
    		else if(notingMessage == "Y")
			{
				//$("#message").html("<font color='green'>"+ JSON.stringify(response.message) +" </font>");
				$("#message").html( parent.closeDialogNoting(JSON.stringify('Noting Saved Successfully')) );
			}	
    	}else{
    		$("#message").html("<font color='red'>"+ JSON.stringify('Error: Something went Wrong') +" </font>");
    	}
    }
</script>	

 