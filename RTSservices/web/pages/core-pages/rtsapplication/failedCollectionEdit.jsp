<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page	import="com.mars.common.utils.Constants" />
<jsp:directive.page	import="com.mars.common.utils.CommonUtils" />

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


<%
	pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
	pageContext.setAttribute("SESSION_TOKEN_KEY",
			Constants.SESSION_TOKEN_KEY);
	pageContext.setAttribute("STATUS_NO_LABEL",
			Constants.STATUS_NO_LABEL);
	pageContext.setAttribute("STATUS_YES_LABEL",
			Constants.STATUS_YES_LABEL);
	pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
	pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
	///pageContext.setAttribute("statusList", CommonUtils.getStatus());
%>
		<script type="text/javascript" language="javascript" src="/RTS/web/scripts/utils.js"></script>

<script type="text/javascript">
	function searchRTIApplication() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/failedCollectionEdit.do');
	}
</script>
<script type="text/javascript">



function searchReferenceNumber()
{	
    //var code = Trim(document.getElementById('searchCode').value);
    var receiptno = Trim(document.getElementById('receiptno').value);
    
     /* alert('code'+code.length);
    alert('code '+code);
    alert('receiptno'+receiptno.length);
    alert('receiptno '+receiptno);  */

    if(receiptno.length>0 )
    {
	  onPageSubmit('<c:out value="${contextRoot}"/>/failedcollectionlist/getFaileCollectionList.do');
	  
	
	}else 
	  {
	  		displayError("Please Enter atlest one field!!");

	    return false;
	  } 
}



 	/*  function searchCollection() {
		var arrRequiredElements = new Array('fromDate', 'toDate');
		var arrRequiredElementsMessages = new Array('From Date', 'To Date');
		if (checkMandatoryDetailed(arrRequiredElements,
				arrRequiredElementsMessages)) {
			onPageSubmit('<c:out value="${contextRoot}"/>/failedcollectionlist/getFaileCollectionList.do'); */
		//}/* else{
											//displayError("From And To date are mandatory");
										//} */
	//}  
	
	function synchEntries()
	{
		document.getElementById("collectionbufferid").value=getSelectedValue("checkcollectionBufferId");
		if(Trim(document.getElementById("collectionbufferid").value).length>0){
			onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/updateCollectionList.do');
			showWorkInProgressImage();
		}else{
			displayError("Please Select atleast 1 Record for Sync.");	
		}
	}
	function showWorkInProgressImage()
	{
		document.getElementById("workInProgressImageId").style.display="";
		disableButtons(document.forms[0]);
	}
	
</script>
<style type="text/css">

.clsButtonUpload {
	background-color: #198754;
	border: none;
	border-radius: 5px;
	min-height: 30px;
	min-width: 120px;
}

.clsButtonUpload:hover {
	background: rgb(8, 105, 15);
	color: white;
}

a {
	text-decoration: none !important;
}

.input-align {
	align-items: center;
}
</style>
<style type="text/css">
.btn-success { -
	-bs-btn-color: #fff; -
	-bs-btn-bg: #00a659; -
	-bs-btn-border-color: #198754; -
	-bs-btn-hover-color: #fff; -
	-bs-btn-hover-bg: #168b54;
	border: none;
	border-radius: 5px;
	min-height: 30px;
	min-width: 120px;
}

.btn-danger { -
	-bs-btn-color: #fff; -
	-bs-btn-bg: #e61f2c; -
	-bs-btn-border-color: #df2d2d; -
	-bs-btn-hover-color: #fff; -
	-bs-btn-hover-bg: #ee1717;
	border: none;
	border-radius: 5px;
	min-height: 30px;
	min-width: 120px;
}

.ClsTRHeaderList {
	background: #678dc5;
	font-weight: bold;
	color: white;
}

.form-control {
	width: 180px;
	height: 30px;
}

.btn-success {
	width: 50px;
	height: 30px;
	font-size: 10px;
}
.ui-datepicker {
width:300px;
    
    padding: .2em .2em 0;
}
.ui-datepicker .ui-datepicker-prev {
    left: -10px;
}
.ui-datepicker table{
margin-left:-8px;
}

.ui-datepicker th {
    padding: 0.7em em 0em 2em;
    text-align: center;
    font-weight: bold;
    border: 0;
}
a {
    margin-left: 10px;
}
.ClsTextboxDate{
font-size: 15px;
width:130px;
height:20px;
}
</style>

<form>
<div class="mainHdr">
         <%-- <h3>
<a
href="<c:out value="${contextRoot}"/>/rtiapplication/newRTIBirthApplication.do">
New Birth Certificate
</a>
<fmt:message key="rtiApplication.list.pagetitle.list" />
</h3>--%>
</div>
<div valign="top" id="SetFormHeight">

<div id="SearchDivId" class="ClsSearch">
<div class="ClsSearchTitle">
<img src="<c:out value="${contextRoot}"/>/images/closed.gif"
id="searchToggleImage"
onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
<fmt:message key="search.label.heading" />
</div>
<table id="SearchTable" class="searchForm" style="display: none;">
<tr>
<td><fmt:message key="rtiApplication.list.label.rtiApplnNumber" />
</td>
<td><input type="text" class="ClsTextbox"
id="searchrtiApplnNumber" maxlength="45" style="width: 150px"
name="searchrtiApplnNumber"
value="<c:out value="${SearchOptions.rtiApplicationNumber}"/>" /> &nbsp;
</td>

<%-- <td><span class="ClsLabel"><fmt:message
key="rtiApplication.manage.label.department" /></span><span
class="ClsRequiredFields"></span></td>
<td><select name="searchDepartmentId" id="searchDepartmentId">
<option value=""><--- Select ---></option>
<c:forEach var="department" items="${requestScope.departmentList}">
<c:choose>
<c:when
test="${SearchOptions.searchdepartment==department.departmentId}">
<option value="${department.departmentId}" selected="selected">
<c:out value="${department.name}" />
</option>
</c:when>
<c:otherwise>
<option value="${department.departmentId}">
<c:out value="${department.name}" />
</option>
</c:otherwise>
</c:choose>
</c:forEach>
</select></td> --%>
<td><span class="ClsLabel"><fmt:message
key="rtiApplication.manage.label.appdate" /> <fmt:message
key="search.label.between" /></span></td>
<td><input type="text" class="ClsTextboxDate" id="fromDate"
maxlength="10" name="fromDate"
value="<c:out value="${SearchOptions.creationFromDate}"/>" /> <span
class="ClsLabel">-</span> <input type="text" class="ClsTextboxDate"
id="toDate" maxlength="10" name="toDate"
value="<c:out value="${SearchOptions.creationToDate}"/>" /></td>
</tr>


<tr>
<td colspan="5" align="center">
<input type="submit"  class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchRTIApplication()" /> &nbsp;

<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>"
onclick="javascript:clearFields('SearchTable');searchRTIApplication()" />
</td>
</tr>

</table>
<c:if test="${SearchOptions.searchParamSet == true}">
<script>
ToggleSearch('SearchTable', 'searchToggleImage',
'<c:out value="${contextRoot}"/>');
</script>
</c:if>
</div>

<table cellpadding="0" cellspacing="1" width="100%" class="dataGrid">
<thead>
<tr>
<td>
		<input type="checkbox" class="parent" id="checkAll" name="checkAll" value="" onclick="ToggleAll(this,'checkcollectionBufferId');"/>		

</td>
<td onclick="javascript:resort('upper(rtiApplnNumber)');"
style="cursor: pointer" wrap><fmt:message
key="Application Number" /> <span
id="upper(rtiApplnNumber)"></span>
</td>
<td onclick="javascript:resort('upper(createdDate)');"
style="cursor: pointer" wrap><fmt:message
key="Full Name" /> <span
id="upper(createdDate)"></span>
</td>

  <td onclick="javascript:resort('workflowStatus');"
style="cursor: pointer" wrap><fmt:message
key="Transaction Number" /> <span
id="status"></span>
</td>
 <td onclick="javascript:resort('workflowStatus');"
style="cursor: pointer" wrap><fmt:message
key="Receipt Number" /> <span
id="status"></span>
</td>
 <td onclick="javascript:resort('workflowStatus');"
style="cursor: pointer" wrap><fmt:message
key="Amount" /> <span
id="status"></span>
</td>
</tr>
</thead>
<tbody>

<c:set var="hasRows" value="false"/>
	<c:forEach items="${list}" var="ob">
	<c:set var="hasRows" value="true" />
	
	<tr>
	 <td>
	 <input type="checkbox" class="childs" id="checkcollectionBufferId" name="checkcollectionBufferId" value="<c:out value="${ob.collectionBufferId}"/>" onclick="Toggle(this,'checkAll');" />
	</td>
	<td> 
		 <input id="rtiApplnNumber" name="rtiApplnNumber" value="<c:out value="${ob.rTIApplication.rtiApplnNumber}"/>"  disabled/>
	</td>
		<td> 
		
				 <input id="applicantName" name="applicantName" value="<c:out value="${ob.rTIApplication.applicantName}"/>" disabled/>
	
	<td>
	
			 
			 				 <input id="UniqPgid" name="UniqPgid" value="<c:out value="${ob.uniqPgid}"/>" disabled/>
			 
	 </td>
	<td>
	 <input id="receiptNumber" name="receiptNumber" value="<c:out value="${ob.receiptNumber}"/>" disabled/>
	
	</td>
	
	
<td>
    <c:set var="rawAmt" value="${ob.amount}" />
    <input
        id="amount"
        name="amount"
        value="<%= fmtIndianAmount(pageContext.getAttribute("rawAmt")) %>"
        disabled="disabled" />
</td>	
		<!-- <td>
	 <input id="amount" name="amount" value="<c:out value="${ob.amount}"/>" disabled/>
	 </td>-->
	
	</tr>
	
	
</c:forEach>
	 

<c:if test="${hasRows == false}">
<tr>
<td colspan=7 class="clsNoRecords" align="center"><fmt:message
key="No Failed Collection  available" /></td>
</tr>
</c:if>

<c:if test="${not empty list}">
<tr >
	 	<td colspan="7" align="center">
					<input type="button" class="ClsButton clsButtonUpload" id="synch"
					 name="synch" value="Update Entries" onclick="javascript:synchEntries()" />
				</td>
	
	 
	 
	 </tr></c:if>
</tbody>

<tfoot>
<tr>
<td colspan="7">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</td>
</tr>
</tfoot>
</table>
<input type="hidden" id=collectionbufferid name="collectionbufferid" value="" />
 
<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>"/>
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" />
<script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>
</form>

