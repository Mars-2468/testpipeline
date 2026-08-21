<%@include file="/pages/common/include.jsp"%>
<%@page import="com.mars.common.utils.Constants"%>


<style>
   .branch{
      display: none;
   }
 </style>
 <div class="mainHdr">
	<h3> 
		Assign Sectors
	</h3>
</div>
<div valign="top"  id="SetFormHeight">
	<table border="0" cellpadding="1" cellspacing="1" width="98%" class="dataForm">
		<tr>
			<td>
				<span class="ClsLabel"><fmt:message key="Menu.GIS.masters.Ward" /> <fmt:message key="ward.manage.label.name" />:</span>
				<c:out value="${ward.name}"/>
				<br />
				<input type="hidden" name="wardId" id="wardId" value="<c:out value="${ward.wardId}"/>">
			</td>
		</tr>

		<tr>
			<td colspan="4" style="padding-top:5px" height="10px"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" class="ClsButton" id="save" name="save" value="<fmt:message key="common.button.save"/>" onclick="javascript:assignSectors(this.form);">
				<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearContorls();">
				<input type="button" class="ClsButton" id="Back" name="Back" value="Back" onclick="javascript:editWard('${ward.wardId}');">
			</td>
		</tr>
		<!-- Start of +/- DIv -->
		<tr>
			<td colspan="4">
				<p>
					<span class="ClsLabel"> <fmt:message key="sector.list.pagetitle.list" />: </span>
					<br />
					<br />
				</p>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<table border="0" cellpadding="1" cellspacing="1" width="100%">
					<tr>
						<td valign="top" width="25%" wrap>
							<c:if test="${not empty requestScope.nodeMasterList1}">
								<a href="javascript:expandOrCollapseChildren('groupTreeId1','expand');">Expand All </a> &nbsp;&nbsp;&nbsp;
								<a href="javascript:expandOrCollapseChildren('groupTreeId1','collapse');">Collpase All </a>
								<BR>
								<div id="groupTreeId1">
									<c:forEach var="nodeMaster" items="${requestScope.nodeMasterList1}" varStatus="gCount">
										<c:if test="${not empty nodeMaster.sectorSet}">
											<img src="<c:out value="${contextRoot}"/>/images/closed.gif" border="0" id="nodeMasterImage1<c:out value="${gCount.index+1}"/>"
												onClick="showChildren('sectorBranch1<c:out value="${gCount.index+1}"/>');changeImage('<c:out value="${contextRoot}"/>','nodeMasterImage1<c:out value="${gCount.index+1}"/>')">
											<c:choose>
												<c:when test="${nodeMaster.checked == true}">
													<input type="checkBox" name="nodeMasterCheck1<c:out value="${gCount.index+1}"/>" id="nodeMasterCheck1<c:out value="${gCount.index+1}"/>"
														onclick="ToggleAllById('nodeMasterCheck1<c:out value="${gCount.index+1}"/>','sectorCheck1<c:out value="${gCount.index+1}"/>');" checked />
													Node::<c:out value="${nodeMaster.name}" />
												</c:when>
												<c:otherwise>
													<input type="checkBox" name="nodeMasterCheck1<c:out value="${gCount.index+1}"/>" id="nodeMasterCheck1<c:out value="${gCount.index+1}"/>"
														onclick="ToggleAllById('nodeMasterCheck1<c:out value="${gCount.index+1}"/>','sectorCheck1<c:out value="${gCount.index+1}"/>');" />
													Node::<c:out value="${nodeMaster.name}" />
													<sup>
														#
													</sup>
												</c:otherwise>
											</c:choose>
											<br>
											<span class="branch" id="sectorBranch1<c:out value="${gCount.index+1}"/>" style="display : none;padding-left:35px"> 
											<c:forEach var="sector" items="${nodeMaster.sectorSet}">
												<input type="hidden" id="wardSectorId" name="wardSectorId" value="<c:out value="${sector.assignedWardSectorId}"/>" />
												<input type="hidden" id="sectorId" name="sectorId" value="<c:out value="${sector.sectorId}"/>" />
												<c:choose>
													<c:when test="${sector.assignedWardSectorId > 0}">
														<input type="checkBox" name="sectorCheck" id="sectorCheck1<c:out value="${gCount.index+1}"/>" value="<c:out value="${sector.sectorId}"/>"
															onclick="ToggleById('sectorCheck1<c:out value="${gCount.index+1}"/>','nodeMasterCheck1<c:out value="${gCount.index+1}"/>');" checked />
													</c:when>
													<c:otherwise>
														<input type="checkBox" name="sectorCheck" id="sectorCheck1<c:out value="${gCount.index+1}"/>" value="<c:out value="${sector.sectorId}"/>"
															onclick="ToggleById('sectorCheck1<c:out value="${gCount.index+1}"/>','nodeMasterCheck1<c:out value="${gCount.index+1}"/>');" />
													</c:otherwise>
												</c:choose>
												<c:out value="${sector.name}" />
												<br>
											</c:forEach> </span>
										</c:if>
									</c:forEach>
								</div>
							</c:if>
						</td>
						
						<td valign="top" width="25%" wrap>
							<c:if test="${not empty requestScope.nodeMasterList2}">
								<a href="javascript:expandOrCollapseChildren('groupTreeId2','expand');">Expand All </a> &nbsp;&nbsp;&nbsp;
								<a href="javascript:expandOrCollapseChildren('groupTreeId2','collapse');">Collpase All </a>
								<BR>
								<div id="groupTreeId2">
									<c:forEach var="nodeMaster" items="${requestScope.nodeMasterList2}" varStatus="gCount">
										<c:if test="${not empty nodeMaster.sectorSet}">
											<img src="<c:out value="${contextRoot}"/>/images/closed.gif" border="0" id="nodeMasterImage2<c:out value="${gCount.index+1}"/>"
												onClick="showChildren('sectorBranch2<c:out value="${gCount.index+1}"/>');changeImage('<c:out value="${contextRoot}"/>','nodeMasterImage2<c:out value="${gCount.index+1}"/>')">
											<c:choose>
												<c:when test="${nodeMaster.checked == true}">
													<input type="checkBox" name="nodeMasterCheck2<c:out value="${gCount.index+1}"/>" id="nodeMasterCheck2<c:out value="${gCount.index+1}"/>"
														onclick="ToggleAllById('nodeMasterCheck2<c:out value="${gCount.index+1}"/>','sectorCheck2<c:out value="${gCount.index+1}"/>');" checked />
													Node::<c:out value="${nodeMaster.name}" />
												</c:when>
												<c:otherwise>
													<input type="checkBox" name="nodeMasterCheck2<c:out value="${gCount.index+1}"/>" id="nodeMasterCheck2<c:out value="${gCount.index+1}"/>"
														onclick="ToggleAllById('nodeMasterCheck2<c:out value="${gCount.index+1}"/>','sectorCheck2<c:out value="${gCount.index+1}"/>');" />
													Node::<c:out value="${nodeMaster.name}" />
													<sup>
														#
													</sup>
												</c:otherwise>
											</c:choose>
											<br>
											<span class="branch" id="sectorBranch2<c:out value="${gCount.index+1}"/>" style="display : none;padding-left:35px"> 
											<c:forEach var="sector" items="${nodeMaster.sectorSet}">
												<input type="hidden" id="wardSectorId" name="wardSectorId" value="<c:out value="${sector.assignedWardSectorId}"/>" />
												<input type="hidden" id="sectorId" name="sectorId" value="<c:out value="${sector.sectorId}"/>" />
												<c:choose>
													<c:when test="${sector.assignedWardSectorId > 0}">
														<input type="checkBox" name="sectorCheck" id="sectorCheck2<c:out value="${gCount.index+1}"/>" value="<c:out value="${sector.sectorId}"/>"
															onclick="ToggleById('sectorCheck2<c:out value="${gCount.index+1}"/>','nodeMasterCheck2<c:out value="${gCount.index+1}"/>');" checked />
													</c:when>
													<c:otherwise>
														<input type="checkBox" name="sectorCheck" id="sectorCheck2<c:out value="${gCount.index+1}"/>" value="<c:out value="${sector.sectorId}"/>"
															onclick="ToggleById('sectorCheck2<c:out value="${gCount.index+1}"/>','nodeMasterCheck2<c:out value="${gCount.index+1}"/>');" />
													</c:otherwise>
												</c:choose>
												<c:out value="${sector.name}" />
												<br>
											</c:forEach> </span>
										</c:if>
									</c:forEach>
								</div>
							</c:if>
						</td>
						
						<td valign="top" width="25%" wrap>
							<c:if test="${not empty requestScope.nodeMasterList3}">
								<a href="javascript:expandOrCollapseChildren('groupTreeId3','expand');">Expand All </a> &nbsp;&nbsp;&nbsp;
								<a href="javascript:expandOrCollapseChildren('groupTreeId3','collapse');">Collpase All </a>
								<BR>
								<div id="groupTreeId3">
									<c:forEach var="nodeMaster" items="${requestScope.nodeMasterList3}" varStatus="gCount">
										<c:if test="${not empty nodeMaster.sectorSet}">
											<img src="<c:out value="${contextRoot}"/>/images/closed.gif" border="0" id="nodeMasterImage3<c:out value="${gCount.index+1}"/>"
												onClick="showChildren('sectorBranch3<c:out value="${gCount.index+1}"/>');changeImage('<c:out value="${contextRoot}"/>','nodeMasterImage3<c:out value="${gCount.index+1}"/>')">
											<c:choose>
												<c:when test="${nodeMaster.checked == true}">
													<input type="checkBox" name="nodeMasterCheck3<c:out value="${gCount.index+1}"/>" id="nodeMasterCheck3<c:out value="${gCount.index+1}"/>"
														onclick="ToggleAllById('nodeMasterCheck3<c:out value="${gCount.index+1}"/>','sectorCheck3<c:out value="${gCount.index+1}"/>');" checked />
													Node::<c:out value="${nodeMaster.name}" />
												</c:when>
												<c:otherwise>
													<input type="checkBox" name="nodeMasterCheck3<c:out value="${gCount.index+1}"/>" id="nodeMasterCheck3<c:out value="${gCount.index+1}"/>"
														onclick="ToggleAllById('nodeMasterCheck3<c:out value="${gCount.index+1}"/>','sectorCheck3<c:out value="${gCount.index+1}"/>');" />
													Node::<c:out value="${nodeMaster.name}" />
													<sup>
														#
													</sup>
												</c:otherwise>
											</c:choose>
											<br>
											<span class="branch" id="sectorBranch3<c:out value="${gCount.index+1}"/>" style="display : none;padding-left:35px"> 
											<c:forEach var="sector" items="${nodeMaster.sectorSet}">
												<input type="hidden" id="wardSectorId" name="wardSectorId" value="<c:out value="${sector.assignedWardSectorId}"/>" />
												<input type="hidden" id="sectorId" name="sectorId" value="<c:out value="${sector.sectorId}"/>" />
												<c:choose>
													<c:when test="${sector.assignedWardSectorId > 0}">
														<input type="checkBox" name="sectorCheck" id="sectorCheck3<c:out value="${gCount.index+1}"/>" value="<c:out value="${sector.sectorId}"/>"
															onclick="ToggleById('sectorCheck3<c:out value="${gCount.index+1}"/>','nodeMasterCheck3<c:out value="${gCount.index+1}"/>');" checked />
													</c:when>
													<c:otherwise>
														<input type="checkBox" name="sectorCheck" id="sectorCheck3<c:out value="${gCount.index+1}"/>" value="<c:out value="${sector.sectorId}"/>"
															onclick="ToggleById('sectorCheck3<c:out value="${gCount.index+1}"/>','nodeMasterCheck3<c:out value="${gCount.index+1}"/>');" />
													</c:otherwise>
												</c:choose>
												<c:out value="${sector.name}" />
												<br>
											</c:forEach> </span>
										</c:if>
									</c:forEach>
								</div>
							</c:if>
						</td>

					</tr>
				</table>
			</td>
		</tr>

		<!-- End of +/- DIv -->
		<tr>
			<td colspan="4" style="padding-top:5px" height="10px"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" class="ClsButton" id="save" name="save" value="<fmt:message key="common.button.save"/>" onclick="javascript:assignSectors(this.form);">
				<input type="button" class="ClsButton" id="clear" name="clear" value="<fmt:message key="common.button.clear"/>" onclick="javascript:clearContorls();">
				<input type="button" class="ClsButton" id="Back" name="Back" value="Back" onclick="javascript:editWard('${ward.wardId}');">
			</td>
		</tr>
	</table>
</div>
<input type="hidden" name="addSectorIds" id="addSectorIds" value="">

<script type="text/javascript">
function assignSectors(frm)
{
	document.getElementById('addSectorIds').value=getSelectedValue('sectorCheck');
	navigate(frm,'<c:out value="${contextRoot}"/>/ward/saveWardSectors.do');
}

function editWard(id)
{
	onPageSubmit('<c:out value="${contextRoot}"/>/ward/editWard.do');
}

function expandOrCollapseChildren(groupId,status)
{
	if(document.getElementById(groupId))
	{
		var spantags=document.getElementById(groupId).getElementsByTagName("span");
		for (var i=0; i < spantags.length; i++)
		{
			if(status=='expand')
			{
				spantags[i].style.display="block";
			}
			else if (status=='collapse')
			{
				spantags[i].style.display="none";
			}
		}
		var imgtags=document.getElementById(groupId).getElementsByTagName("img");
		for (var j=0; j<imgtags.length; j++)
		{
			if(status=='expand')
			{
				imgtags[j].src="<c:out value="${contextRoot}"/>/images/open.gif";	
			}
			else if (status=='collapse')
			{
				imgtags[j].src="<c:out value="${contextRoot}"/>/images/closed.gif";
			}
		}
	}
}

expandOrCollapseChildren('groupTreeId1','expand');
expandOrCollapseChildren('groupTreeId2','expand');
expandOrCollapseChildren('groupTreeId3','expand');

</script>
