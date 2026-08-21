<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants"/>
<jsp:directive.page import="com.mars.rti.utils.CoreConstants"/>
<script>
function searchRTIApplicationNumber()
{
	 
	  var code=document.getElementById('searchCode').value;
	  if( (code != null && code != ""))
	  {  
				 onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/listApplicationTransfer.do');
			
	  }else {
			displayError("Invalid Application No.");
			return false;
			}
		
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
<form>
<div class="mainHdr">
	<h3> 
		<span><fmt:message key="Zone Change" /></span>
	</h3>
</div>
<div valign="top" id="SetFormHeight">

<div id="SearchDivId" class="ClsSearch">
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			<fmt:message key="search.label.heading" />
		</div>
		<table id="SearchTable" class="searchForm" style="display:none;">
			<tr>
				<td><fmt:message key="Application Number" /></td>
				<td>
					<input type="text" class="ClsAutoTextbox" id="searchCode" maxlength="20" 
						style="width:180px" name="searchrtiApplnNumber" onkeyup="javascript:autoComplete(event,this.value)"
						value="<c:out value="${SearchOptions.rtiApplicationNumber}"/>" />
					&nbsp;
				</td>	
				
            </tr>    
            <tr> 
                <td colspan="4" align="right">
					<input type="button" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchRTIApplicationNumber()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable')" />
				</td>
			</tr>
		</table>
         <c:if test="${requestScope.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>	
	
	
	<c:if test="${requestScope.data != null}">	
	
	<table cellpadding="0" cellspacing="1" width="100%" class="dataGrid">
<thead>
<tr>
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
key="From ZoneNo." /> <span
id="status"></span>
</td>

  <td onclick="javascript:resort('workflowStatus');"
style="cursor: pointer" wrap><fmt:message
key="To ZoneNo." /> <span
id="status"></span>
</td>


</tr>
</thead>
<tbody>

<c:set var="hasRows" value="false"/>
	<c:set var="hasRows" value="true" />
	
	<tr>
	
	<td> 
		 <input id="rtiApplnNumber" name="rtiApplnNumber" value="<c:out value="${rTIApplication.rtiApplnNumber}"/>"  disabled/>
	</td>
		<td> 
		
				 <input id="applicantName" name="applicantName" value="<c:out value="${rTIApplication.applicantName}"/>" disabled/>
	</td>
	<td> 
		<c:choose>
		<c:when test="${empty requestScope.tempzone}">
		<select class="select" style="background-image: none;"
							id="tempzone" name="tempzone" required disabled>
					<option value="">-Select Zone-</option>
						
			 <c:forEach var="zoneValue" begin="1" end="10">
        <c:set var="selected" value="${rTIApplication.zone == zoneValue ? 'selected' : ''}" />
        <option value="${zoneValue}" ${selected}>Zone No.${zoneValue} - 
            <c:choose>
                <c:when test="${zoneValue == 1}">Laxmi Nagar (लक्ष्मी नगर)</c:when>
                <c:when test="${zoneValue == 2}">Dharmpeth (धरमपेठ)</c:when>
                <c:when test="${zoneValue == 3}">Hanuman Nagar (हनुमान नगर)</c:when>
                <c:when test="${zoneValue == 4}">Dhantoli (धंतोली)</c:when>
                <c:when test="${zoneValue == 5}">Nehru Nagar (नेहरू नगर)</c:when>
                <c:when test="${zoneValue == 6}">Gandhibag (गांधीबाग)</c:when>
                <c:when test="${zoneValue == 7}">Satranjipura (सतरंजीपुरा)</c:when>
                <c:when test="${zoneValue == 8}">Lakadganj (लकडगंज)</c:when>
                <c:when test="${zoneValue == 9}">Aashi Nagar (आशी नगर)</c:when>
                <c:when test="${zoneValue == 10}">Mangalwari (मंगळवारी)</c:when>
            </c:choose>
        </option>
    </c:forEach>	
    </select>
		</c:when>
	<c:when test="${not empty requestScope.tempzone}">
 <select class="select" style="background-image: none;"
							id="tempzone" name="tempzone" required disabled>
					<option value="">-Select Zone-</option>
						
			 <c:forEach var="zoneValue" begin="1" end="10">
        <c:set var="selected" value="${requestScope.tempzone == zoneValue ? 'selected' : ''}" />
        <option value="${zoneValue}" ${selected}>Zone No.${zoneValue} - 
            <c:choose>
                <c:when test="${zoneValue == 1}">Laxmi Nagar (लक्ष्मी नगर)</c:when>
                <c:when test="${zoneValue == 2}">Dharmpeth (धरमपेठ)</c:when>
                <c:when test="${zoneValue == 3}">Hanuman Nagar (हनुमान नगर)</c:when>
                <c:when test="${zoneValue == 4}">Dhantoli (धंतोली)</c:when>
                <c:when test="${zoneValue == 5}">Nehru Nagar (नेहरू नगर)</c:when>
                <c:when test="${zoneValue == 6}">Gandhibag (गांधीबाग)</c:when>
                <c:when test="${zoneValue == 7}">Satranjipura (सतरंजीपुरा)</c:when>
                <c:when test="${zoneValue == 8}">Lakadganj (लकडगंज)</c:when>
                <c:when test="${zoneValue == 9}">Aashi Nagar (आशी नगर)</c:when>
                <c:when test="${zoneValue == 10}">Mangalwari (मंगळवारी)</c:when>
            </c:choose>
        </option>
    </c:forEach>	
    </select>
    </c:when>
    <c:otherwise></c:otherwise>
    </c:choose>
    </td>
	
	<td>
	
			 
			 	 <select class="select" style="background-image: none;"
							id="main-dropdown" name="zone" required>
					<option value="">-Select Zone-</option>
						
			 <c:forEach var="zoneValue" begin="1" end="10">
        <c:set var="selected" value="${requestScope.updatedzone == zoneValue ? 'selected' : ''}" />
        <option value="${zoneValue}" ${selected}>Zone No.${zoneValue} - 
            <c:choose>
                <c:when test="${zoneValue == 1}">Laxmi Nagar (लक्ष्मी नगर)</c:when>
                <c:when test="${zoneValue == 2}">Dharmpeth (धरमपेठ)</c:when>
                <c:when test="${zoneValue == 3}">Hanuman Nagar (हनुमान नगर)</c:when>
                <c:when test="${zoneValue == 4}">Dhantoli (धंतोली)</c:when>
                <c:when test="${zoneValue == 5}">Nehru Nagar (नेहरू नगर)</c:when>
                <c:when test="${zoneValue == 6}">Gandhibag (गांधीबाग)</c:when>
                <c:when test="${zoneValue == 7}">Satranjipura (सतरंजीपुरा)</c:when>
                <c:when test="${zoneValue == 8}">Lakadganj (लकडगंज)</c:when>
                <c:when test="${zoneValue == 9}">Aashi Nagar (आशी नगर)</c:when>
                <c:when test="${zoneValue == 10}">Mangalwari (मंगळवारी)</c:when>
            </c:choose>
        </option>
    </c:forEach>
</select>

			 
			 
	 </td>
	
	</tr>
	
	
	 

<c:if test="${hasRows == false}">
<tr>
<td colspan=7 class="clsNoRecords" align="center"><fmt:message
key="No Failed Collection  available" /></td>
</tr>
</c:if>

<c:if test="${not empty data}">
<tr >
	 	<td colspan="7" align="left">
					<input type="button" class="ClsButton clsButtonUpload" id="synch"
					 name="synch" value="Update Application" onclick="javascript:synchEntries()" />
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
	
	</c:if>
<input type="hidden" id=rtiapplicationId name="rtiapplicationId" value="${rTIApplication.rtiApplicationId}" />
<input type="hidden" id=rtiApplicationRefId name="rtiApplicationRefId" value="${rTIApplication.rtiApplicationRefId}" />
<input type="hidden" id=path name="path" value="" />


 	<input type="hidden" value="${rTIApplication.rtiserviceid}" id="rtiServiceId" name="rtiServiceId" />
<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>"/>
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" />
<script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>
</form>	
<script>

function synchEntries() {
    var zone=document.getElementById('main-dropdown').value;
       
            if (zone !== '') {
                var userResponse = confirm("Are you sure you want to save!!");
                if(userResponse){
                $("#submit").attr("synch", true);
                $("#tempzone").prop("disabled", false);
                onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveApplicationTransfer.do');
                }else{
                	return false;
                }
            }else{
            	alert("Please select Zone!!");
            }
        
    
}


</script>

	
	
	
	
	
	
