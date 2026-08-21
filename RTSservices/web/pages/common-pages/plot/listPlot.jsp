<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants;"/>
<script src="<c:out value="${contextRoot}"/>/dwr/interface/gisMastersList.js"></script>
<script src="<c:out value="${contextRoot}"/>/dwr/interface/sectorList.js"></script>
<%pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);%>
<script type="text/javascript">
function editPlot(id)
{
	document.getElementById('plotId').value=id;
	onPageSubmit('<c:out value="${contextRoot}"/>/plot/editPlot.do');
}
function searchPlot()
{
	onPageSubmit('<c:out value="${contextRoot}"/>/plot/listPlot.do');
}
</script>
<div class="mainHdr">
	<h3> <%-- <a href="<c:out value="${contextRoot}"/>/plot/editPlot.do">
			<fmt:message key="plot.manage.pagetitle.new" /> 
		</a> --%>
		<fmt:message key="plot.list.pagetitle.list" />
	</h3>
</div>
<div valign="top"  id="SetFormHeight">

<div id="SearchDivId" class="ClsSearch">
		<div class="ClsSearchTitle">
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>')" />
			<fmt:message key="search.label.heading" />
		</div>
		<table id="SearchTable" class="searchForm" style="display:none;" cellpadding="4">
		
		<tr>
		
		    <td><fmt:message key="node.list.label.ward"/></td>
			<td>
			<select name="searchWardId" id="searchWardId" onchange="getNodeOnWard();">
				<option value=""><--- Select ---></option>
				<c:forEach var="searchWard" items="${requestScope.wardList}">
					<option value="${searchWard.wardId}" <c:if test="${SearchPlot.wardId==searchWard.wardId}"> selected="selected" </c:if>>
						<c:out value="${searchWard.name}" />
					</option>
				</c:forEach>
			</select>
			</td>
		
			<td><fmt:message key="sector.list.label.Node"/></td>
			<td>
			<select name="searchNodeMasterId" id="searchNodeMasterId" onchange="getSectorOnWardAndNode();">
				<option value=""><--- Select ---></option>
				<c:forEach var="searchNodeMaster" items="${requestScope.nodeList}">
					<option value="${searchNodeMaster.nodeMasterId}" <c:if test="${SearchPlot.nodeMasterId==searchNodeMaster.nodeMasterId}"> selected="selected" </c:if>>
						<c:out value="${searchNodeMaster.name}" />
					</option>
				</c:forEach>
			</select>
			</td>
		</tr>
		
			<tr>
				<td>
				<span class="ClsLabel"><fmt:message key="plot.manage.label.sector" />
				</span>
			    </td>
				<td>				
					<select name="searchSectorId" id="searchSectorId">
                     <option value=""> <fmt:message key="common.label.defaultOption"/></option>
                      <c:forEach var="sector" items="${requestScope.sectorList}" varStatus="sectorCount">
		                 <c:choose>
			                   <c:when test="${sectorCount.index==0}">
			                     <optgroup LABEL="<c:out value="${sector.nodeMaster.name}"/>">
			                       <c:set var="optionGroup" value="${sector.nodeMaster.name}" />
			                  </c:when>
			      			  <c:when test="${optionGroup ne sector.nodeMaster.name}">
			                    </optgroup>
			                    <optgroup LABEL="<c:out value="${sector.nodeMaster.name}"/>">
			                     <c:set var="optionGroup" value="${sector.nodeMaster.name}" />
			                 </c:when>
		                </c:choose>
						<c:if test="${sector.nodeMaster.name eq optionGroup}">
							<c:choose>
								<c:when test="${SearchPlot.sectorId==sector.sectorId}">
									<option value="<c:out value="${sector.sectorId}"/>" selected="selected">
										<c:out value="${sector.name}" />
									</option>
								</c:when>
		                       <c:otherwise>
			                       <option value="<c:out value="${sector.sectorId}"/>">
			                         <c:out value="${sector.name}" />
			                       </option>
		                       </c:otherwise>
		                   </c:choose>
		               </c:if>
                   </c:forEach>
                  <c:if test="${not empty requestScope.sectorList}">
                </optgroup>
               </c:if>
             </select>			
			     </td>
		 	     
		 	     <td>
			       <span class="ClsLabel"><fmt:message key="plot.manage.label.plotType" />
			       </span>
		         </td>
			     <td>				
					<select name="searchPlotTypeId" id="searchPlotTypeId">
						<option value=""><--- Select ---></option>
						<c:forEach var="plotType" items="${requestScope.plotTypeList}">
							<c:choose>
								<c:when test="${SearchPlot.plotTypeId==plotType.plotTypeId}">
									<option value="${plotType.plotTypeId}" selected="selected">
										<c:out value="${plotType.description}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${plotType.plotTypeId}">
										<c:out value="${plotType.description}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>				
		          </td>
		      </tr>
			
			  <tr>
			     <td>
				   <fmt:message key="plot.list.label.number" />
				 </td>
				 <td>
					<input type="text" class="ClsTextbox" id="searchNumber" maxlength="100" 
						style="width:150px" name="searchNumber" 
						value="<c:out value="${SearchPlot.number}"/>" />
					&nbsp;
				 </td>
			
				<td colspan="2">
					<input type="submit" class="ClsButton" id="search" name="search" value="<fmt:message key="common.button.search"/>" onclick="javascript:searchPlot()" />
					&nbsp;
					<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearFields('SearchTable');searchPlot()" />
				</td>
			</tr>
		</table>
		<c:if test="${SearchPlot.searchParamSet == true}">
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>


<table cellpadding="0" cellspacing="1" width="98%" class="dataGrid">
<thead>
<tr>
<td onclick="javascript:resort('upper(number)');" style="cursor: pointer" wrap>
	<fmt:message key="plot.list.label.number" /> <span id="upper(number)"></span>
</td>
<td onclick="javascript:resort('upper(plotType.description)');" style="cursor: pointer" wrap>
	<fmt:message key="plot.list.label.plotType" /> <span id="upper(plotType.description)"></span>
</td>
<td onclick="javascript:resort('upper(sector.name)');" style="cursor: pointer" wrap>
	<fmt:message key="plot.list.label.sector" /> <span id="upper(sector.name)"></span>
</td>
<td onclick="javascript:resort('upper(sector.nodeMaster.name)');" style="cursor: pointer" wrap>
	<fmt:message key="sector.list.label.Node" /> <span id="upper(sector.nodeMaster.name)"></span>
</td>
<td onclick="javascript:resort('upper(sector.nodeMaster.ward.name)');" style="cursor: pointer" wrap>
	<fmt:message key="node.list.label.ward" /> <span id="upper(sector.nodeMaster.ward.name)"></span>
</td>
</tr>
</thead>
<tbody>
<c:set var="hasRows" value="false" />
<c:forEach var="PlotList" items="${requestScope.PlotList}" varStatus="rowNumber">
<c:set var="hasRows" value="true" />
<tr>
<td><%-- <a title="<fmt:message key="list.link.EditOrViewLink"/>" href="javascript:editPlot('${PlotList.plotId}');">
<c:out value="${PlotList.number}"/></a> --%>
<c:out value="${PlotList.number}"/>
</td>
<td><c:out value="${PlotList.plotType.description}"/></td>
<td><c:out value="${PlotList.sector.name}"/></td>
<td><c:out value="${PlotList.sector.nodeMaster.name}"/></td>
<td><c:out value="${PlotList.sector.nodeMaster.ward.name}"/></td>
</tr>
</c:forEach>
<c:if test="${hasRows == false}">
<tr>
<td colspan=5  class="clsNoRecords" align="center">
<fmt:message key="list.label.norecords"/></td></tr></c:if>
</tbody>
<tfoot>
<tr>
<td colspan="5">
<c:if test="${requestScope.PlotList != null && requestScope.totalCount>0}">
<span><%@include file="/pages/common/pagination.jsp"%></span>
</c:if>
</td>
</tr>
</tfoot>
</table>
<input type="hidden" id="plotId" name="plotId" value="<c:out value="${plot.plotId}"/>" />

<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" /><script type="text/javascript">
insert_image('${contextRoot}');

function getNodeOnWard()
{
	var wardId=document.getElementById("searchWardId").value;
    
    if(wardId != null && wardId > 0)
    {
	  gisMastersList.getNodesOnWard(wardId,setNodeOnWard);
    }else
    {
       var selectElement1 = document.getElementById("searchNodeMasterId");
  	   var selectElement2 = document.getElementById("searchSectorId");
  		removeAllOptions(selectElement1);
  	    removeAllOptions(selectElement2);
    }
}

function setNodeOnWard(dataList)
{	
	var selectElement = document.getElementById("searchNodeMasterId");
	removeAllOptions(selectElement);
	
	for(var i=1;i<=dataList.length;i++)
	{
		var optn = document.createElement("OPTION");
		optn.text = dataList[i-1].name;
		optn.value = dataList[i-1].nodeMasterId;
		if("${SearchPlot.nodeMasterId}" == optn.value)
			optn.selected = true;
		selectElement.options.add(optn);
    }
	getSectorOnWard();
}

function getSectorOnWard()
{
	var wardId = document.getElementById('searchWardId').value;
	
	if(wardId!=null && wardId>0)
	{	
	  sectorList.getSectorsOnWard(wardId, setSectorsOnWard);
	}else
	{
		var selectElement1 = document.getElementById("searchSectorId");
		removeAllOptions(selectElement1);
	}
}

function setSectorsOnWard(dataList)
{
	var selectElement = document.getElementById("searchSectorId");
	removeAllOptions(selectElement);

	var optGroupName = "";
	var optngroup ;
	for(var i=1;i<=dataList.length;i++)
	{
		if (i==1) 
		{
			optGroupName = dataList[i-1].nodeMaster.name;
			optngroup = document.createElement("optgroup");
			optngroup.label=optGroupName;
		}
	
		if(optGroupName != dataList[i-1].nodeMaster.name)
		{
			selectElement.appendChild(optngroup);
			optGroupName = dataList[i-1].nodeMaster.name;
			optngroup = document.createElement("optgroup");
			optngroup.label=dataList[i-1].nodeMaster.name;
		}
	
		var optn = document.createElement("OPTION");
		//optn.text = dataList[i-1].name;
		optn.appendChild(document.createTextNode(dataList[i-1].name));
		optn.value = dataList[i-1].sectorId;
		optngroup.appendChild(optn);
	
		if (i==dataList.length) 
		{
		 selectElement.appendChild(optngroup);
		}
     }
} 

function getSectorOnWardAndNode()
{
	var wardId = document.getElementById('searchWardId').value;
	var nodeId = document.getElementById('searchNodeMasterId').value;
    
	if(wardId!=null && wardId>0 && nodeId!=null && nodeId>0)
	{	
		gisMastersList.getSectorsOnWardAndNode(wardId, nodeId, setSectorsOnWardAndNode);
	}else
	{
		var selectElement1 = document.getElementById("searchSectorId");
		removeAllOptions(selectElement1);
	}
}

function setSectorsOnWardAndNode(dataList)
{
	var selectElement = document.getElementById("searchSectorId");
	removeAllOptions(selectElement);

	var optGroupName = "";
	var optngroup ;
	for(var i=1;i<=dataList.length;i++)
	{
		if (i==1) 
		{
			optGroupName = dataList[i-1].nodeMaster.name;
			optngroup = document.createElement("optgroup");
			optngroup.label=optGroupName;
		}
	
		if(optGroupName != dataList[i-1].nodeMaster.name)
		{
			selectElement.appendChild(optngroup);
			optGroupName = dataList[i-1].nodeMaster.name;
			optngroup = document.createElement("optgroup");
			optngroup.label=dataList[i-1].nodeMaster.name;
		}
	
		var optn = document.createElement("OPTION");
		//optn.text = dataList[i-1].name;
		optn.appendChild(document.createTextNode(dataList[i-1].name));
		optn.value = dataList[i-1].sectorId;
		optngroup.appendChild(optn);
	
		if (i==dataList.length) 
		{
		 selectElement.appendChild(optngroup);
		}
     }
}
//getNodeOnWard();
</script>
</div>