<%@page import="com.mars.common.utils.CommonUtils"%>
<%@page import="com.mars.rti.utils.CoreConstants"%>
<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>
<%@ page import="com.mars.rti.model.RTIApplication" %>
<%@ page import="java.util.Date" %>

<%@ page import="java.util.Arrays" %>
<%!
    /* Format a numeric amount in INDIAN grouping (lakh/crore), ROUNDED to the whole rupee (HALF_UP), no paise.
       e.g. 6432.50 -> 6,433 ; 25284894.70 -> 2,52,84,895 ; 1456789 -> 14,56,789 ; null/blank -> "".
       Java's DecimalFormat can't do Indian grouping via a pattern, so we group manually. */
    private static String fmtIndianAmount(Object raw) {
        if (raw == null) return "";
        String s = String.valueOf(raw).replace(",", "").trim();
        if (s.isEmpty()) return "";
        try {
            java.math.BigDecimal bd = new java.math.BigDecimal(s)
                    .setScale(0, java.math.RoundingMode.HALF_UP);  // round off to whole rupee, drop paise
            boolean neg = bd.signum() < 0;
            String intPart = bd.abs().toPlainString();             // e.g. "6433"
            String grouped;
            if (intPart.length() <= 3) {
                grouped = intPart;
            } else {
                String last3 = intPart.substring(intPart.length() - 3);
                String rest  = intPart.substring(0, intPart.length() - 3);
                StringBuilder sb = new StringBuilder();
                int count = 0;
                for (int i = rest.length() - 1; i >= 0; i--) {
                    sb.append(rest.charAt(i));
                    if (++count % 2 == 0 && i != 0) sb.append(',');
                }
                grouped = sb.reverse().toString() + "," + last3;
            }
            return (neg ? "-" : "") + grouped;
        } catch (NumberFormatException e) {
            return String.valueOf(raw);
        }
    }
%>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">

<html>
<head>
 <title> Nagpur Municipal Corporation</title>
<meta name="viewport" content= " user-scalable=no">
</head>
</html>


<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);

pageContext.setAttribute("SESSION_TOKEN_KEY",Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("CURRENCY_FORMAT",Constants.CURRENCY_FORMAT);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
%>

<style>
 #b{
  border: 2px solid rgb(228, 222, 222);
 background-color: rgba(227, 227, 227, 0.281);
}
hr {
  border: 2px dotted blue;
}

@media print {
  #print {
    display: none;
  }
}
@media print{
  #cancel {
    display: none;
  }
 
}

.timestamp{

    font-size: small;
    font-weight: 500;
    float: right;
}
</style>
<html>
<head>
<div class="container mt-3">
<div id="b">                                      
<table align="center">
 <div class="timestamp">
 <% Date timestamp = new Date(); %>
  <p><%= timestamp %></p>
  </div>
 <br>
<tr>
	<th align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<c:out value="${contextRoot}"/>/images/nmclogo.jpeg" height="60" width="60"  alt="AMC_Logo"/></th>
		
		<tr><th align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font face="Arial" size="3"><b><fmt:message key="Nagpur Municipal Corporation" /></th></tr>
		<tr><th align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font face="Arial" size="2"><b><fmt:message key="Payment Receipt For Online RTS Application" /></th></tr>
<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
</table>
<table class="table table-bordered table-striped" style="font-size:14px;width: 730px;" align="center">

    <tr>
	    <th><fmt:message key="Application No. :" /></th>
	    <th><c:out value="${collection.rTIApplication.rtiApplnNumber}"/> </th>
	    </tr>
	    <tr>
	    <th><fmt:message key="Receipt No. :" /></th>
	    <th><c:out value="${collection.receiptNumber}"/> </th>
	     </tr>
	     
	     <tr>
	    <th><fmt:message key="Receipt Date :" /></th>
	    <th><c:out value="${collection.receiptDate}"/> </th>
	     </tr>
	    
	    
	    
	    <tr>
	    <th><fmt:message key="Name of Service :" /></th>
	   <th><c:out value="${collection.rTIApplication.subject}"/> </th>
	     </tr>
	    
	    
	    
	    <tr>
	    <th><fmt:message key="Payment Mode :" /></th>
	    <th><c:out value="${collection.paymentMode}"/> </th>
	     </tr>
	    
	    
	    
	    <tr>
	    <th><fmt:message key="Bank Name :" /></th>
	   <th>${collection.bankName} </th>
	     </tr>
	    
	    
	    <tr>
	    <th><fmt:message key="Transaction ID :" /></th>
	      <th><c:out value="${collection.uniqPgid}"/> </th>
	     </tr>
	    
	    
	    <tr>
	    <th><fmt:message key="Amount (Rupees) :" /></th>
	    <th>
	    	    <c:set var="rawAmt" value="${collection.amount}"/><%= fmtIndianAmount(pageContext.getAttribute("rawAmt")) %>
	    
	   <!--<fmt:formatNumber var="fmtoutstandingAmount" value="${collection.amount}" type="currency" pattern="${pageScope.CURRENCY_FORMAT}" />
	    
	    <c:out value="${fmtoutstandingAmount}"/> </th>-->
	     </tr>
	    
	    
	    <tr>
	    <th><fmt:message key="Amount in Words :" /></th>
	   <th><!--<fmt:formatNumber var="fmtAmount" value="${collection.amount}" type="currency" pattern="${pageScope.CURRENCY_FORMAT}" />	-->	
			<c:set var="amt" value="${collection.amount}" />
			   <% 
					Double amt = (Double)pageContext.getAttribute("amt"); 
					out.println(com.mars.common.utils.CommonUtils.AmtToWords(new Double(amt)));
				%></th>
        </th>
	     </tr>
	    
	    
	    
	    

    
    
</table>
<br>
<table align="center" >
    <tr>
        
            
            <tr><th>Received from &nbsp;</th><th></th> <th><c:out value="${collection.rTIApplication.applicantName}"/></th>  <th>&nbsp; the following amount as per the details mentioned</th></tr></table>
            
            
           <br></br>
            
           
            
             <div valign="top" id="SetFormHeight"  align="center">
                <table class="table table-bordered" style="font-size:14px;width: 730px;" align="center">
                    <tr style="background-color:#dee2e6;">
            <th><fmt:message key="Particulars" /></th>
            <th><fmt:message key="Amount (Rupees)" /> </th>
            </tr>
           
    
            <tr>
            <th><c:out value="${collection.rTIApplication.subject}"/> </th>
             <th> 
             	    <c:set var="rawAmt" value="${collection.amount}"/><%= fmtIndianAmount(pageContext.getAttribute("rawAmt")) %>
             
             <!--<fmt:formatNumber var="fmtoutstandingAmount" value="${collection.amount}" type="currency" pattern="${pageScope.CURRENCY_FORMAT}" />
            
         <c:out value="${fmtoutstandingAmount}"/> -->
         </th>
            </tr>
            </table>
            </div>
            
         
          <br>
           <table align="center" >
    <tr>
        
        
            <tr><th>**This is an electronically generated acknowledgement and does not require a signature.</th></tr></table>
            
           
         <br>
        <table align="center" ><tr><td>
           <input type="button" class="btn btn-primary" style="font-size: 13pt; width: 90px;" id="print" name="print" value="Print"  onclick="window.print()"/>
         &nbsp;&nbsp;  <input type="button" class="btn btn-danger" style="font-size: 13pt; width: 90px;" id="cancel" name="cancel" value="Cancel" onClick="window.close()"  />
          </td>
        </tr>
        
        </table>	   







<br>
</table>


</div>
<br>