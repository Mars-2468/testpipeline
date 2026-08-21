
 <jsp:directive.include file="/pages/common/include.jsp" />
<%--<jsp:directive.page import="com.mars.common.utils.Constants;"/> --%>
<%-- <jsp:directive.include file="/pages/core-pages/filecreation/sendEmail.jsp" />
<jsp:directive.include file="/pages/core-pages/filecreation/sendMessage.jsp" /> --%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.ClsTextboxEmail {
	color: #000;
	font: 11px Helvetica, Arial, sans-serif;
	margin-right: 5px;
	padding: 4px;
	float:left;
	/* min-width: 180px;*/	
	width: 550px;
	height:18px;
	
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
.ClsTextAreaEmail {
	color: #000;
	font: 11px Helvetica, Arial, sans-serif;
	margin-right: 5px;
	padding: 4px;
	float:left;
	/* min-width: 180px;*/	
	width: 550px; 
	
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
		Send Mail
	</h3>
</div>
<body>
<table width="80%" border="0" cellpadding="2" cellspacing="2" class="dataForm">
 
	<tr>
	 
	<td width="20%"><div class="ClsLabel">Email Attachments </div></td>
	<td>
	    
		<input type="checkbox" id="noting" name="noting" > <span class="ClsLabel">Add Noting </span> &nbsp; &nbsp; &nbsp; 
		<input type="checkbox" id="parked" name="parked" > <span class="ClsLabel">Add Parked Remarks </span>
		<br>
 	</td>
	
	</tr>

	<tr>
	
	<td width="20%">
		<span class="ClsLabel">To</span>
		<span class="ClsRequiredFields">*</span>
	</td>
	
	<td><input type="text" class="ClsTextboxEmail" id="to" maxlength="70"   name="to" /></td>
	
	</tr>   
	
	<tr>
	<td>
	<span class="ClsLabel">CC</span>
	<!-- <span class="ClsRequiredFields">*</span> -->
	</td>

	<td><input type="text" class="ClsTextboxEmail" id="cc"  name="cc" /></td>
	
	</tr>

      

	<tr>
	
	<td>
	<span class="ClsLabel">Subject</span>
	<span class="ClsRequiredFields">*</span>
	</td>
	
	<td><input type="text" class="ClsTextboxEmail" id="subject"  name="subject" /></td>
	
	</tr>

        
	
	<tr>
	<td>
	<span class="ClsLabel">Email Description</span>
	<span class="ClsRequiredFields">*</span>
	</td>


	<td><textarea rows="10" cols="40" class="ClsTextAreaEmail" id="content"   name="content" /></textarea></td>

	</tr>
   
		<tr><td></td>
			<td> 
			<input type="button" align="center" class="ClsButton" id="Submit" name="Submit" value="    Send    " onclick="javascript:validateEmail();">
		    </td>
	    </tr>
     
     
</table>
</body>
</html>

<script type="text/javascript">
function validateEmail(){
	//alert('validateEmail');
	var to=document.getElementById("to").value;
	   var validTo=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	   
	   if(!(to.match(validTo))){
		   
		   alert('Please Enter a Valid Email id ');
		   return false;
	  	 }
	   
	   var cc=document.getElementById("cc").value;
	   var validCc=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	   
	   if(!(cc.match(validCc))){
		   
		   alert('Please Enter a Valid Email id ');
		   return false;
	  	 }
	
	var subject=document.getElementById('subject').value;
	/*  alert(serviceTypeId); */
	   if(subject == '')
	   {
		   alert('Subject is Mandatory');
		   return false;
	   } 
	
	   var context=document.getElementById('context').value;
		/*  alert(serviceTypeId); */
		   if(context == '')
		   {
			   alert('Email Body is Mandatory');
			   return false;
		   } 
		
		   /* else{
				  // alert('Hi Vijay');
				   
				   navigate(frm,'<c:out value="${contextRoot}"/>/roadcutting/saveRoadCutting.do');
				   
			   } */
	
}
</script>