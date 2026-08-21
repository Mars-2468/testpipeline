<%-- <jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/> --%>
<%-- <jsp:directive.include file="/pages/core-pages/filecreation/sendEmail.jsp" />
<jsp:directive.include file="/pages/core-pages/filecreation/sendMessage.jsp" /> --%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.ClsTextAreaEmail {
	color: #000;
	font: 11px Helvetica, Arial, sans-serif;
	margin-right: 5px;
	padding: 4px;
	float:left;
	/* min-width: 180px;*/	
	width: 400px;
	 
	
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	-ms-border-radius: 5px;
	-o-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	-moz-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	-ms-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	-o-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-ms-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;	
	border: 1px solid #c8c8c8;
	-webkit-appearance: none; /* gets rid of default appearance in Webkit browsers*/
    -moz-appearance: none; /* Get rid of default appearance for older Firefox browsers */
   	-ms-appearance: none; /* get rid of default appearance for IE8, 9 and 10*/
    position:relative; 
}
</style>
<div class="mainHdr">
	<h3> 
		Send Message
	</h3>
</div>
<body>
<table width="80%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
            

          
<tr>

  


<tr style=" vertical-align:top;  ">
<td>
<span class="ClsLabel">Mobile Number</span>
<span class="ClsRequiredFields">*</span>
</td>

<td><input type="text" class="ClsTextbox" id="mobileNumber" maxlength="10" name="mobileNumber" /></td>

<td>
<span class="ClsLabel">Message</span>
<span class="ClsRequiredFields">*</span>
</td>

<td>
<textarea rows="5" cols="40" class="ClsTextAreaEmail" id="text"   name="text" /></textarea></td>
	<td  style=" vertical-align: text-top; " align="left"> 
	<input type="button" class="ClsButton" id="Send" name="Send" value="  Send  " onclick="javascript:validateMessage();">
    </td>
</tr>

 
</table>
</body>
</html>
<script type="text/javascript">
function validateMessage(){
	//alert('validateMessage');
	
	var mobileNumber=document.getElementById("mobileNumber").value;
	   //var validMobileNumber=/^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
	     var validMobileNumber= /^[0]?[6789]\d{9}$/;
	   if(!(mobileNumber.match(validMobileNumber))){
		   alert('Please Enter Valid Mobile No');
		   return false;
	   }
	   var text=document.getElementById('text').value;
		/*  alert(serviceTypeId); */
		   if(text == '')
		   {
			   alert('text is Mandatory');
			   return false;
		   } 
		
		   /* else{
				  
				   onpage
				   navigate(frm,'<c:out value="${contextRoot}"/>/roadcutting/saveRoadCutting.do');
				   
			   } */
}
</script>

