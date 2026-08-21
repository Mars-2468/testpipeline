<script type="text/javascript">
var currentPageNumber = '<c:out value="${requestScope.currentPage}" />';
var blnEnterClicked = false;
function checkCurrentPage(currentPage)
{
	if(isNumeric(currentPage))
	{
		if(currentPage > 0)
			return true;
		else
			return false;
	}
	else
		return false;
}

function goNext()
{
	var objMaxRowCount = document.getElementById('maximumPages').value;
	var currentPage = document.getElementById('currentPage').value;
	if(checkCurrentPage(currentPage)){
		if(blnEnterClicked==false){
			if(currentPageNumber==currentPage)
				currentPage =parseInt(currentPage)+1;
			else	
				currentPage = parseInt(currentPageNumber)+1;
		}
		if(parseInt(currentPage) <= parseInt(objMaxRowCount)){
			blnnterClicked = false;
			document.getElementById('currentPage').value = currentPage;
			document.getElementById('isPaginationClicked').value = "yes";
			document.frmPage.submit();
		}
	}	
}
function goPrevious()
{
	var objMaxRowCount = document.getElementById('maximumPages').value;
	var currentPage = document.getElementById('currentPage').value;
	if(checkCurrentPage(currentPage)){	
		if(parseInt(currentPageNumber)==parseInt(currentPage)){
			currentPage =parseInt(currentPage)-1;
		}else{	
			currentPage = parseInt(currentPageNumber)-1;
		}	
		if(parseInt(currentPage)>0 && parseInt(currentPage)<parseInt(objMaxRowCount)){
			document.getElementById('currentPage').value = currentPage;
			document.getElementById('isPaginationClicked').value = "yes";
			document.frmPage.submit();
		}
	}	
}
function goLast()
{
	var objMaxRowCount = document.getElementById('maximumPages').value;
	var currentPage = document.getElementById('currentPage').value;
	if(checkCurrentPage(currentPage)){	
		if(parseInt(currentPage)<parseInt(objMaxRowCount)){
			document.getElementById('currentPage').value = objMaxRowCount;
			document.getElementById('isPaginationClicked').value = "yes";
			document.frmPage.submit();
		}
	}		
}
function goFirst()
{
	document.getElementById('currentPage').value = 1;
	document.getElementById('isPaginationClicked').value = "yes";
	document.frmPage.submit();
}

function doSearchOnEnterClick(e)
{
	//the purpose of this function is to allow the enter key to 
	//point to the correct button to click.
		var key;
		if(window.event)
             key = window.event.keyCode;     //IE
        else
             key = e.which;     //firefox
        
       if (key == 13)
       {
	       blnEnterClicked = true;
           //Get the button the user wants to have clicked
           var btn = document.getElementById('imgNextPage');
           if (btn)
           { //If we find the button click it
			   goNext();
               event.keyCode = 0;
           } else {
           		var btn = document.getElementById('imgPreviousPage');
           		if(btn){
				   	goNext();
	           		event.keyCode = 0;
           		}
           }
       }
}
</script>
<!-- ===== The following code includes the "include.jsp" file which sets the context path and declares the required taglibs===== -->
<%@ include file="/pages/common/include.jsp" %>
<c:if test="${requestScope.maximumPages > 0 && requestScope.currentPage>0}">
	<table border="0" width="100%">
	<tr>
	<td>
	<span style="z-index: 6;height:12px">
	<c:choose>
		<c:when test="${requestScope.currentPage!=1}">
			<img style="cursor:pointer" src="<c:out value="${contextRoot}"/>/images/Ico_ArrowFirst.gif" id="imgFirstPage" alt="Go to first page" onclick="javascript:goFirst();" width="8px"/>
			<img src="<c:out value="${contextRoot}"/>/images/Transpx.gif" width="5" height="1" alt=""/>
			
			<img style="cursor:pointer" src="<c:out value="${contextRoot}"/>/images/Ico_ArrowPrevious.gif" id="imgPreviousPage" alt="Go to previous page" onclick="javascript:goPrevious();"/>
			<img src="<c:out value="${contextRoot}"/>/images/Transpx.gif" width="5" height="1" alt=""/>
			Page&nbsp;&nbsp;<input type="text" name="currentPage" class="ClsPaginationTextbox" maxlength="5" style="width:50px;" id="currentPage" value="<c:out value="${requestScope.currentPage}"/>" onkeypress="javascript:doSearchOnEnterClick(event);"/>&nbsp; of <c:out value="${requestScope.maximumPages}"/>
		</c:when>
		<c:when test="${requestScope.maximumPages!=1}">
			Page&nbsp;&nbsp;<input type="text" name="currentPage" class="ClsPaginationTextbox" maxlength="5" style="width:50px;" id="currentPage" value="<c:out value="${requestScope.currentPage}"/>" onkeypress="javascript:doSearchOnEnterClick(event);"/>&nbsp; of <c:out value="${requestScope.maximumPages}"/>
		</c:when>
		<c:otherwise>
				Page&nbsp;&nbsp;<c:out value="${requestScope.currentPage}"/>&nbsp;of <c:out value="${requestScope.maximumPages}"/>
		</c:otherwise>
	</c:choose>
		<img src="<c:out value="${contextRoot}"/>/images/Transpx.gif" width="5" height="1" alt=""/>
		<c:if test="${requestScope.maximumPages > requestScope.currentPage}">
		<img style="cursor:pointer" src="<c:out value="${contextRoot}"/>/images/Ico_ArrowNext.gif" id="imgNextPage" alt="Go to next page" onclick="javascript:goNext();return false;"/>
		<img src="<c:out value="${contextRoot}"/>/images/Transpx.gif" width="5" height="1" alt=""/>
		
		<img style="cursor:pointer" src="<c:out value="${contextRoot}"/>/images/Ico_ArrowLast.gif" id="imgLastPage" alt="Go to last page" onclick="javascript:goLast();"/>
		</c:if>
	</span>
	</td>
	<!-- For Printing Total records Count in Pagination Bar -->
	<c:if test="${requestScope.totalCount > 0}">
		<td>
			<span  style="z-index: 6;height:12px;vertical-align: AbsMiddle;float: right;" >
				Total Records : <c:out value="${requestScope.totalCount}"/>
			</span>
		</td>
	</c:if>	
	</tr>
	</table>		
</c:if>
<input type="hidden" name="maximumPages" id="maximumPages" value="<c:out value="${requestScope.maximumPages}"/>"/>
<input type="hidden" name="isPaginationClicked" id="isPaginationClicked" value="no"/>
