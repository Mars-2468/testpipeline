<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page	import="com.mars.common.utils.Constants" />
<jsp:directive.page	import="com.mars.common.utils.CommonUtils" />
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

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

<script type="text/javascript">
		function editRTIApplication(id) {
		
		document.getElementById('rtiApplicationRefId').value = id;
		onPageSubmit('<c:out value="${contextRoot}"/>//rtiapplication/editPropertyTaxAssessment.do');
	}
	function searchRTIApplication() {
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/listRTIApplication.do');
	}
	function refreshTax(){
		$('#url').val(window.location.href.split('/RTSservices')[1]);
		onPageSubmit('<c:out value="${contextRoot}"/>/rtsApplication/getPropertyApplicationStatus.do?serviceId=${requestScope.serviceId}');

	}
	function taxUpdate(id){
		$('#url').val(window.location.href.split('/RTSservices')[1]);
		onPageSubmit('<c:out value="${contextRoot}"/>/rtsApplication/getPropertyApplicationStatus.do?id='+id);
	}
</script>
<style>
        .refresh-icon {
            color: blue; 
        }
        .disabled {
            pointer-events: none;
            opacity: 0.5;
            color: grey;
        }
    </style>

<div class="mainHdr">
<!-- <h3>
<div class="status reverifyOn"	id="workflowssync" title="Re-deploy the Workflows"
				style="cursor:pointer;float: right" onclick="refreshTax();">
			</div> </h3> -->
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
value="<c:out value="${SearchOptions.searchrtiApplnNumber}"/>" /> &nbsp;
</td>

<td><span class="ClsLabel"><fmt:message
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
</select></td>
</tr>
<tr>

<td><span class="ClsLabel"><fmt:message
key="rtiApplication.manage.label.appdate" /> <fmt:message
key="search.label.between" /></span></td>
<td><input type="text" class="ClsTextboxDate" id="fromDate"
maxlength="10" name="fromDate"
value="<c:out value="${SearchOptions.fromDate}"/>" /> <span
class="ClsLabel">-</span> <input type="text" class="ClsTextboxDate"
id="toDate" maxlength="10" name="toDate"
value="<c:out value="${SearchOptions.toDate}"/>" /></td>
</tr>

<tr>
<td colspan="5">
<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchRTIApplication()" /> &nbsp;

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

<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
<thead>
<tr>
<td onclick="javascript:resort('upper(rtiApplnNumber)');"
style="cursor: pointer" wrap><fmt:message
key="rtiApplication.list.label.rtiApplnNumber" /> <span
id="upper(rtiApplnNumber)"></span>
</td>
<td onclick="javascript:resort('upper(createdDate)');"
style="cursor: pointer" wrap><fmt:message
key="rtiApplication.manage.label.createdDate" /> <span
id="upper(createdDate)"></span>
</td>
<td onclick="javascript:resort('upper(name)');"
style="cursor: pointer" wrap><fmt:message
key="rtiApplication.manage.label.name" /> <span
id="upper(name)"></span>
</td>
  <td onclick="javascript:resort('workflowStatus');"
style="cursor: pointer" wrap><fmt:message
key="feeMaster.manage.label.status" /> <span
id="status"></span>
</td>
 <td 
style="cursor: pointer" wrap><fmt:message
key="Update Status" /> <span
id="status"></span>
</td>
</tr>
</thead>
<tbody>

<c:set var="hasRows" value="false" />
<c:choose>
    <c:when test="${not empty requestScope.rtiapplicationList}">
   <c:forEach var="rtiApplnList"
items="${requestScope.rtiapplicationList}" varStatus="rowNumber">
<c:set var="hasRows" value="true" />
<tr>
<td><a title="<fmt:message key="list.link.EditOrViewLink"/>"
href="javascript:editRTIApplication('${rtiApplnList.rtiApplicationRefId}');">
<c:out value="${rtiApplnList.rtiApplnNumber}" />
</a></td>
<td><c:out value="${rtiApplnList.registrationDate}" /></td>
<td><c:out value="${rtiApplnList.applicantName}" /></td>
<td>
<c:if test="${rtiApplnList.workFlowStatus==0}">
In Progress
</c:if>
                <c:if test="${rtiApplnList.workFlowStatus==3}">
Citizen Payment Pending.
</c:if>
 <c:if test="${rtiApplnList.workFlowStatus == 2}">
Citizen Payment Completed.
</c:if>
<c:if test="${rtiApplnList.workFlowStatus==1}">
Completed
</c:if>
<c:if test="${rtiApplnList.workFlowStatus==5}">
Rejected
</c:if>

</td>
	<td>
<c:choose>
    <c:when test="${rtiApplnList.workFlowStatus==1 && not empty rtiApplnList.pdfFilesSavedPath}">
    
    <a style="text-decoration: none;color: #0d7439;"
							target="_blank" href="<c:out value="${rtiApplnList.pdfFilesSavedPath}"/>" > <i class="fa fa-download" style="cursor: pointer;color: #0d7439;"></i> Download</a>


    </c:when>
      <c:when test="${rtiApplnList.workFlowStatus==1 && empty rtiApplnList.pdfFilesSavedPath}">
   Not available
    </c:when>
    <c:otherwise>
    <a href="#" onclick="taxUpdate('${rtiApplnList.rtiApplicationId}');" style="text-decoration: none;">
        <i class="fas fa-sync-alt refresh-icon" style="cursor: pointer;"></i> Refresh
    </a>
    </c:otherwise>
    </c:choose>
        
    </td>
<input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="<c:out value="${rtiApplnList.rtiApplicationRefId}" />" />
<input type="hidden" id="url" name="url" value="" />

</tr>
</c:forEach>
   
    </c:when>
    <c:otherwise>
   <c:forEach var="rtiApplnList"
items="${requestScope.rtiApplicationList}" varStatus="rowNumber">
<c:set var="hasRows" value="true" />
<tr>
<td><a title="<fmt:message key="list.link.EditOrViewLink"/>"
href="javascript:editRTIApplication('${rtiApplnList.rtiApplicationRefId}');">
<c:out value="${rtiApplnList.rtiApplnNumber}" />
</a></td>
<td><c:out value="${rtiApplnList.registrationDate}" /></td>
<td><c:out value="${rtiApplnList.applicantName}" /></td>
<td>
<c:if test="${rtiApplnList.workFlowStatus==0}">
In Progress
</c:if>
                <c:if test="${rtiApplnList.workFlowStatus==3}">
Citizen Payment Pending.
</c:if>
 <c:if test="${rtiApplnList.workFlowStatus == 2}">
Citizen Payment Completed.
</c:if>
<c:if test="${rtiApplnList.workFlowStatus==1}">
Completed
</c:if>
<c:if test="${rtiApplnList.workFlowStatus==5}">
Rejected
</c:if>

</td>
	<td>
<c:choose>
    <c:when test="${rtiApplnList.workFlowStatus==1 && not empty rtiApplnList.pdfFilesSavedPath}">
    
    <a style="text-decoration: none;color: #0d7439;"
							target="_blank" href="<c:out value="${rtiApplnList.pdfFilesSavedPath}"/>" > <i class="fa fa-download" style="cursor: pointer;color: #0d7439;"></i> Download</a>


    </c:when>
      <c:when test="${rtiApplnList.workFlowStatus==1 && empty rtiApplnList.pdfFilesSavedPath}">
   Not available
    </c:when>
    <c:otherwise>
    <a href="#" onclick="taxUpdate('${rtiApplnList.rtiApplicationId}');" style="text-decoration: none;">
        <i class="fas fa-sync-alt refresh-icon" style="cursor: pointer;"></i> Refresh
    </a>
    </c:otherwise>
    </c:choose>
    </td>
<input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="<c:out value="${rtiApplnList.rtiApplicationRefId}" />" />
<input type="hidden" id="url" name="url" value="" />

</tr>
</c:forEach>
   
    </c:otherwise>
  </c:choose>



<%-- <c:forEach var="rtiApplnList"
items="${requestScope.rtiApplicationList}" varStatus="rowNumber">
<c:set var="hasRows" value="true" />
<tr>
<td><a title="<fmt:message key="list.link.EditOrViewLink"/>"
href="javascript:editRTIApplication('${rtiApplnList.rtiApplicationRefId}');">
<c:out value="${rtiApplnList.rtiApplnNumber}" />
</a></td>
<td><c:out value="${rtiApplnList.registrationDate}" /></td>
<td><c:out value="${rtiApplnList.applicantName}" /></td>
<td>
<c:if test="${rtiApplnList.workFlowStatus==0}">
In Progress
</c:if>
                <c:if test="${rtiApplnList.workFlowStatus==3}">
Citizen Payment Pending.
</c:if>
<c:if test="${rtiApplnList.workFlowStatus==2}">
Citizen Payment Completed
</c:if>
<c:if test="${rtiApplnList.workFlowStatus==1}">
Completed
</c:if>
<c:if test="${rtiApplnList.workFlowStatus==5}">
Rejected
</c:if>

</td>
<input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="<c:out value="${rtiApplnList.rtiApplicationRefId}" />" />
</tr>
</c:forEach> --%>

<c:if test="${hasRows == false}">
<tr>
<td colspan=5 class="clsNoRecords" align="center"><fmt:message
key="list.label.norecords" /></td>
</tr>
</c:if>
</tbody>

<tfoot>
<tr>
<td colspan="5"><c:if test="${requestScope.rtiApplicationList != null || requestScope.rtiapplicationList !=null && requestScope.totalCount>0}">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</c:if></td>
</tr>
</tfoot>
</table>
<input type="hidden" id="rtiApplicationId" name="rtiApplicationId" value="" />
  <input type="hidden" id="responseData" name="responseData"
								value="" />
<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>"/>
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" />
<script type="text/javascript">
insert_image('${contextRoot}');
</script>
</div>


<!-- <script type="text/javascript">
	
	function birthupload(id) {
		  
 	    var data = new FormData();
 	   var idProofFileInput = $("#uploadCer");
 	  
 		
 	 	if (idProofFileInput.val() === '') {
 	 	    alert("Please select the document!!");
 	 	    return false;
 	 	}
 	    alert("Are you sure you want to Upload Certificate?");
 	    
 	 

 	if (idProofFileInput.length > 0 && idProofFileInput.get(0).files.length > 0) {
 	    data.append('idProof1', idProofFileInput.get(0).files[0]);

 	   
 	} else {
 	    console.error("No file selected");
 	}

 	 var apptype=1;
 	 
 	 
 	 
	  $.ajax({
         url: '<c:out value="${contextRoot}"/>/rtsApplication/getTaxDSC.do?serviceId=${requestScope.serviceId}&refId='+id,
 		 type: 'POST',
         data: data,
         cache: false,
	      dataType: 'json',
         processData: false,
         contentType: false,
         async: false, 
 	        success: function(response) {

 	        	 console.log(response);
 		     
 		       
 		            var status = response.certificatePath;
 		            console.log("Status"+status);
 		       
 		     
 		        $.ajax({
 			        url: "http://127.0.0.1:1620",
 			        type: 'POST',
 			        data: status,
 			     
 			        processData: false, // Don't process the files
 			        contentType: 'application/xml', // Set content type to false as jQuery will tell the server its a query string request
 			     
 				      
 				      
 			       
 			        success: function(status) {
 				       
 			            console.log("Successd"+status);
 			         
 			            document.getElementById('responseData').value = status;
 			            console.log("After @@@"+status);
 			      	 $.ajax({
 	                    url: '<c:out value="${contextRoot}"/>/rtsapplication/savePropertyTaxUpload.do?refId='+id,
 	                    type: 'POST',
 	                   async: false, 
 	                   data: {
 	 			        	status : status
 	 			        	
 	 			        },
 	                   
 	                	  success: function(data, textStatus, jqXHR) {
 	                		    console.log("Data:", data);

 	                		    var parsedData = JSON.parse(data);
 	                		    var finalstatus = parsedData.status;

 	                		    console.log("finalstatus:", finalstatus);

 	                		    if (finalstatus === true) {
 	                		        alert("Upload has been done successfully!");
 	                		        window.location.reload(); 
 	                		    } else {
 	                		        alert("Upload has been failed!!");
 	                		    }
 	                		},
 	                    error: function (xhr) {
	      	        		    alert("Upload has been failed !");
 	                        console.log(xhr.responseText);
 	                    }
 	                });
 	            },
 			        error: function(xhr) {
 			        	  alert("failed POST");
 			        	  console.log("failed"+status);
 			            console.log(xhr.responseText);
 			        }
 			    });
 		        
 	         
 		      /*    } else {
 			            console.log("No <fileName> elements found ");
 			          }
 			        } else {
 			          console.log("No <request> elements found in XML");
 			        }*/
 			        
 		    
 	    },
 	        error: function(xhr) {
 	        	  alert("failed GET");
 	            console.log(xhr.responseText);
 	        }
 	    });

 	
 	  
 	//  onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);
 return false;

 	}


</script> -->
