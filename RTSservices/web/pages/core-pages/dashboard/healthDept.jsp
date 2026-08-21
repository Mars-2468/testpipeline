<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants"/>
<jsp:directive.page
	import="com.mars.common.utils.Constants,com.mars.common.utils.CommonUtils,com.mars.rti.utils.CoreConstants" />
	 <%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
///pageContext.setAttribute("statusList", CommonUtils.getStatus());
String name=(String)session.getAttribute("name"); 

String url="/RTS/pages/core-pages/nmc_user/";

%>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<script src="https://code.highcharts.com/highcharts-3d.js"></script>	

 

<style>

* {
  box-sizing: border-box;
}

.columns {
  float: left;
  width: 16%;
  padding: 8px;
}

.price {
z-index: 0; /* Sit on top */
 position:relative;
  list-style-type: none;
  border: 1px solid #eee;
  margin: 0;
  padding: 0;
  -webkit-transition: 0.3s;
  transition: 0.3s;
}

.price:hover {
  box-shadow: 0 8px 12px 0 rgba(0,0,0,0.2)
}

.price .header {
  background-color: #111;
  color: white;
  font-size: 25px;
}

.price li {
  border-bottom: 1px solid #eee;
  padding: 20px;
  text-align: center;
}

.price .grey {
  background-color: #eee;
  font-size: 20px;
}

.highcharts-figure, .highcharts-data-table table {
    min-width: 320px; 
    max-width: 660px;
    margin: 1em auto;
}

.highcharts-data-table table {
	font-family: Verdana, sans-serif;
	border-collapse: collapse;
	border: 1px solid #EBEBEB;
	margin: 10px auto;
	text-align: center;
	width: 100%;
	max-width: 500px;
}
.highcharts-data-table caption {
    padding: 1em 0;
    font-size: 1.2em;
    color: #555;
}
.highcharts-data-table th {
	font-weight: 600;
    padding: 0.5em;
}
.highcharts-data-table td, .highcharts-data-table th, .highcharts-data-table caption {
    padding: 0.5em;
}
.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even) {
    background: #f8f8f8;
}
.highcharts-data-table tr:hover {
    background: #f1f7ff;
}


</style>

     <%--    <div class="row">

    	                 <a class="card" style="width: 263px" href='<c:out value="${contextRoot}"/>/ws/rtsapplication/birthdeathmarriage.do'>
                    <div class="card-body d-flex align-items-top justify-content-between">                    			 
                                  <span class="title-width platform-title"> <p class="h5 m-0">Birth And<br>Death Department</p></span>
                                                                 
                              </div>
                </a>
           
                 <a class="card" style="width: 263px" href='<c:out value="${contextRoot}"/>/ws/rtsapplication/marriage.do'>
                
                    <div class="card-body d-flex align-items-top justify-content-between">                    			 
                                  <span class="title-width platform-title"><p class="h5 m-0">Marriage<br>Department</p></span>
                                                                  
                              </div>
                </a>
            </div>          


<div class="mainHdr">
	
</div> --%>


			
			    <%-- <td style="width: 100px">
					<fmt:message key="rtiApplication.manage.label.category" />
				</td> 
				
				<td>
					<input type="radio"
						id="category<c:out value="${pageScope.LABEL_RADIO_FEE_CATEGORY_BPL}"/>"
						name="category"
						value="<c:out value="${pageScope.FEE_CATEGORY_BPL}"/>"
						<c:if test="${category eq pageScope.FEE_CATEGORY_BPL}">checked="checked"</c:if> />
					<label
						for="category<c:out value="${pageScope.LABEL_RADIO_FEE_CATEGORY_BPL}"/>"><c:out
							value="${pageScope.LABEL_RADIO_FEE_CATEGORY_BPL}" /></label>
					<input type="radio"
						id="category<c:out value="${pageScope.LABEL_RADIO_FEE_CATEGORY_NON_BPL}"/>"
						name="category"
						value="<c:out value="${pageScope.FEE_CATEGORY_NON_BPL}"/>"
						<c:if test="${category eq pageScope.FEE_CATEGORY_NON_BPL}">checked="checked"</c:if> />
					<label
						for="category<c:out value="${pageScope.LABEL_RADIO_FEE_CATEGORY_NON_BPL}"/>"><c:out
							value="${pageScope.LABEL_RADIO_FEE_CATEGORY_NON_BPL}" /></label>
				</td> --%>
						


	<h2 style="text-align:center">	Health Department Applications Data </h2>
	

<div class="row">
				<div class="col-md-3">
					<div class="mb-3 mt-3">
						<label for="" class="form-label" style="background-image:none;">Services:
	
						</label><select class="form-select" style="width: 230px;height:30px;margin-top:-30px;margin-left: 70px;font-size: 13px;border-radius: 2px" onchange="if (this.value) window.location.href=this.value;">
  <option value="">- Select -</option>
  <option value="<c:out value="${contextRoot}"/>/dashBoard/birth.do">Birth Certificate</option>
  <option value="<c:out value="${contextRoot}"/>/dashBoard/death.do">Death Certificate</option>
  <option value="<c:out value="${contextRoot}"/>/dashBoard/marriage.do">Marriage Certificate</option>
</select>

					
				</div>
</div>
<hr>


<div class="columns" id="All" onclick="getListOnCategory(this.id)">
  <ul class="price">
    <li class="header" style="background-color:#2CD370" >All Applications</li>
    <li class="grey">${allReciepts}</li>
    
  </ul>
</div>
<div class="columns" id="Approved" onclick="getListOnCategory(this.id)">
  <ul class="price">
    <li class="header" style="background-color:#17DF68" >Approved</li>
    <li class="grey">${approvedReiepts}</li>
    
  </ul>
</div>
<div class="columns" id="Closed" onclick="getListOnCategory(this.id)">
  <ul class="price">
    <li class="header" style="background-color:#33B7FF" >Closed</li>
    <li class="grey">${closedReciepts}</li>
    
  </ul>
</div>
<div class="columns" id="Pending" onclick="getListOnCategory(this.id)">
  <ul class="price">
    <li class="header" style="background-color:#FFC133" >Pending</li>
    <li class="grey">${pendingReiepts}</li>
    
  </ul>
</div>
<div class="columns" id="Rejected" onclick="getListOnCategory(this.id)">
  <ul class="price">
    <li class="header" style="background-color:#FFC133" >Rejected</li>
    <li class="grey">${rejectedCount}</li>
    
  </ul>
</div>
<div class="columns" id="Totalfees" onclick="getListOnCategory(this.id)">
  <ul class="price">
    <li class="header" style="background-color:#4CAF50">Total Fees</li>
    <li class="grey">${Totalfees}</li>
    
  </ul>
</div>


<div>
<table align="center">
<tr>
<td><div id="container"></div></td>
<td><div id="container1"></div></td>
</tr>

</table>

</div>

<div>



<c:if test="${requestScope.rtiList!=null}">
<div class="mainHdr">
	<h3>
	
	<c:choose>
	<c:when test="${empty receiptSatus}">All-Records</c:when>
	<c:otherwise>${receiptSatus}-Records</c:otherwise>
	
	
	</c:choose>
		
	</h3>
</div>
<a href="#" onclick="excel()">Download</a>		

<table id = "excelTable" cellpadding="0" cellspacing="1" width="100%" class="dataGrid">
			<thead>
				<tr>
					
					<td style="width: 140px" onclick="javascript:resort('upper(rtiApplicationId)');"
						style="cursor: pointer" wrap>Computer Number <span
						id="upper(rtiApplicationId)"></span>
					</td>
					<td  style="width: 150px" onclick="javascript:resort('upper(rtiApplnNumber)');"
						style="cursor: pointer" wrap><fmt:message
							key="rtiApplication.list.label.rtiApplnNumber" /> <span
						id="upper(rtiApplnNumber)"></span>
					</td>
					
					<td  style="width: 150px" onclick="javascript:resort('upper(registrationDate)');"
						style="cursor: pointer" wrap>Registration Date <span
						id="upper(registrationDate)"></span>
					</td>
					<td  style="width: 170px" onclick="javascript:resort('upper(applicantName)');"
						style="cursor: pointer" wrap>Applicant Name <span
						id="upper(applicantName)"></span>
					</td>
					<td onclick="javascript:resort('subject');"
						style="cursor: pointer" wrap>Subject <span
						id="upper(subject)"></span>
					</td>
										</tr>
			</thead>
			<tbody>
				<c:set var="hasRows" value="false" />
				<c:forEach var="rtiApplnList"
					items="${requestScope.rtiList}" varStatus="rowNumber">
					<c:set var="hasRows" value="true" />
					<tr>
						
						<td> 
							<c:out value="${rtiApplnList.rtiApplicationId}" />
						</td>
						<td><a title="<fmt:message key="list.link.EditOrViewLink"/>"
						href="javascript:editRTIApplication('${rtiApplnList.rtiApplicationRefId}','${rtiApplnList.rtiApplicationId}');">
							<c:out value="${rtiApplnList.rtiApplnNumber}" />
					</a></td>
						<td><c:out value="${rtiApplnList.registrationDate}" /></td>
						<td><c:out value="${rtiApplnList.applicantName}" /></td>
						<td><c:out value="${rtiApplnList.subject}" /></td>
						
					</tr>
				</c:forEach>
	
				<c:if test="${hasRows == false}">
					<tr>
						<td colspan="5" class="clsNoRecords" align="center"><fmt:message
								key="list.label.norecords" /></td>
					</tr>
				</c:if>
			</tbody>

		<tfoot>
			<tr>
				<td colspan="5"><c:if test="${requestScope.rtiList != null && requestScope.totalCount>0}">
						<span><%@include file="/pages/common/pagination.jsp"%></span>
					</c:if></td>
			</tr>
		</tfoot>
	</table>

</c:if>	

</div>
     
	<input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="" /> 
	<input type="hidden" id="rtiApplicationId" name="rtiApplicationId" value="" />
<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>"/> 
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" />
	<script type="text/javascript">
		insert_image('${contextRoot}');
	</script>
	 <script>

	  function excel() {
	  var tableData = [];
	  var table = document.getElementById("excelTable");
	  var rows = table.getElementsByTagName("tr");
	  for (var i = 0; i < rows.length; i++) {
	    var row = [], cols = rows[i].querySelectorAll("td, th");
	    for (var j = 0; j < cols.length; j++) {
	      row.push(cols[j].innerText);
	    }
	    tableData.push(row.join("\t"));
	  }
	  var csvData = "data:text/csv;charset=utf-8," + encodeURIComponent(tableData.join("\n"));
	  var link = document.createElement("a");
	  link.setAttribute("href", csvData);
	  link.setAttribute("download", "data.xls");
	  document.body.appendChild(link);
	  link.click();
	  document.body.removeChild(link);
	}

</script>
	<script>
	
	
	    
	    Highcharts.setOptions({
	    	
	     colors: ['#FFC133', '#4CAF50', '#17DF68', '#33B7FF', '#64E572']

	    });
	    
	    var chart;

	   

	        chart = new Highcharts.Chart({

	            chart: {

	                renderTo: 'container',

	                plotBackgroundColor: null,

	                plotBorderWidth: null,

	                plotShadow: false

	            },

	            title: {

	                text: 'RTS Received Data'

	            },

	            tooltip: {

	                formatter: function() {

	                    return '<b>'+ this.point.name +'</b>: '+ Highcharts.numberFormat(this.percentage, 2)+' %';

	                }

	            },

	            plotOptions: {

	                pie: {

	                    allowPointSelect: true,

	                    cursor: 'pointer',

	                    dataLabels: {

	                        enabled: true,

	                        color: '#000000',

	                        connectorColor: '#000000',

	                        formatter: function() {

	                            return '<b>'+ this.point.name +'</b>: '+ Highcharts.numberFormat(this.percentage, 2)  +' %';

	                        }

	                    }

	                }

	            },

	          

	               series: [{
	                type: 'pie',
	                name: 'RTI Receipts',
	        		data : ${data}
	                //data: [    ['Pending', 45.0],			['Created', 25.0],            ['Approve', 55.0],			['Reject', 25.0],        ]
	            }]

	        });

	   
	


/*  Highcharts.chart('container', {
    chart: {
        type: 'pie',
        options3d: {
            enabled: true,
            alpha: 45,
            beta: 0
        }
    },
    title: {
        text: 'RTS Receipts Data'
    },
    accessibility: {
        point: {
            valueSuffix: '%'
        }
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            depth: 35,
            dataLabels: {
                enabled: true,
                format: '{point.name}'
            }
        }
    },
    series: [{
        type: 'pie',
        name: 'RTI Receipts',
		data : ${data}
        //data: [    ['Pending', 45.0],			['Created', 25.0],            ['Approve', 55.0],			['Reject', 25.0],        ]
    }]
}); */
 
 var chart1 = Highcharts.chart('container1', {
	 colors: [
'#4CAF50', 
'#17DF68', 
'#FFC133', 
'#33B7FF' 

],
     chart: {
         type: 'column'
     },
     title: {
         text: 'RTS Received Data'
     },
     
     xAxis: {
         categories:${map.keySet()},
         crosshair: true
     },
     yAxis: {
         min: 0,
        
         title: {
             text: 'RTS Application Received Rating'
         }
     },
     tooltip: {
         headerFormat: '<span style="font-size:10px" >{point.key}</span><table>',
         pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
         '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
         footerFormat: '</table>',
         shared: true,
         useHTML: true
     },
    
     plotOptions: {
    	 column: {
        	 colorByPoint: true,
             pointPadding: 0.2,
             borderWidth: 0
         },
         series: {
             cursor: 'pointer',
             point: {
                 events: {
                     click: function () {
                    	 getListOnCategory(this.category);
                     }
                 }
             }
         }
     },
     
     
     series: [{
         name: 'RTS Application Received Category',
         data: ${map.values()}
     }]
 });
 
 chart1.xAxis[0].labelGroup.element.childNodes.forEach(function(label)
		 {
		 	label.style.cursor = "pointer";
		    label.onclick = function(){
		   	getListOnCategory(this.textContent);
		   }
		 });
  
 function search()
 {
 	//onPageSubmit('<c:out value="${contextRoot}"/>/dashBoard/birth.do');
 }
 
 function getListOnCategory(category){
	 
	 
	 document.getElementById("receiptSatus").value=category;
	 
	 onPageSubmit('<c:out value="${contextRoot}"/>/dashBoard/getListOnCategoryhealthDept.do');
	 
 }
 

 
 
	function editRTIApplication(refId,id) {
		document.getElementById('rtiApplicationRefId').value = refId;
		document.getElementById('rtiApplicationId').value = id;
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editAnyRTIApplication.do');
	}
 
</script>

<input type="hidden" name="receiptSatus" id="receiptSatus" value="" />