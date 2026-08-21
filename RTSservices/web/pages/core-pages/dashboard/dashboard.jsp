<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants"/>

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

<jsp:directive.page import="com.mars.common.utils.Constants,com.mars.common.utils.CommonUtils,com.mars.rti.utils.CoreConstants" />
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.mars.common.utils.SessionUser"%>
<%@ page import="com.mars.common.model.User"%> <%
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
<%
HttpSession session1 = request.getSession();
SessionUser sessionUser = (SessionUser) session1.getAttribute("SessionUser");
String firstname = (String) sessionUser.getFirstName();
String lastname = (String) sessionUser.getLastName();
Long departmentId = (Long) sessionUser.getDepartmentId();
String departmentname = "";
if(departmentId == 1){
	//departmentname = "Admin Department";
}else if (departmentId == 2) {
	departmentname = "Health Department";
} else if (departmentId == 3) {
	departmentname = "Solid Waste Management Department";
} else if (departmentId == 4) {
	departmentname = "Tax Department";
} else if (departmentId == 5) {
	departmentname = "Town Planning Department";
} else if (departmentId == 6) {
	departmentname = "Water Department";
} else if (departmentId == 7) {
	departmentname = "Fire Department";
} else if (departmentId == 8) {
	departmentname = "Estate Department";
} else if (departmentId == 9) {
	departmentname = "Market Department";
}else if (departmentId == 10) {
	departmentname = "Garden Department";
}else if (departmentId == 11) {
	departmentname = "HOD Department";
}else if (departmentId == 12) {
	departmentname = "Fire Department";
}


%>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<script src="https://code.highcharts.com/highcharts-3d.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {

    var loggedDepartment = "<%= departmentname %>";

    // 👉 If admin has NO department, show ALL options (do nothing)
    if (loggedDepartment === null || loggedDepartment.trim() === "") {
        console.log("Admin detected — showing all departments");
        return; 
    }

    // 👉 For normal users, show only their department
    $("#departments option").each(function () {
        var optText = $.trim($(this).text());

        if (optText !== "" && optText !== "-Select Department-") {

            if (optText !== loggedDepartment) {
                $(this).prop("disabled", true);  
                $(this).hide();  
            } else {
                $(this).prop("disabled", false); 
                $(this).show();   
            }
        }
    });

});
</script>

   <script>
   
     
        function getRTIApplicationDetails(){
            onPageSubmit('<c:out value="${contextRoot}"/>/ws/nmc/dashboard/getApplicationDetails.do');
       
         } 
           
        </script>
<script>
    $(document).ready(function() {
        // Check if any of the fields are not empty
        if (<c:if test="${not empty registrationFromDate or not empty registrationToDate or not empty departments or not empty services}">true</c:if>) {
        	$('#yearLabel').hide();
        	$('#yearSelect').hide();
        }
    });
</script>
	<script type="text/javascript">
	  
	 function search1()
	 {
	        var isValid = true;
		 $('#dashData').show();
	 $('#container').show();
	 $('#container1').show();
	 var departments = document.getElementById("departments").value;
	 var services = document.getElementById("services").value;

	 var fromDateInput = document.getElementById("registrationFromDate");
	    var toDateInput = document.getElementById("registrationToDate");
	    
     

     // Check if both date inputs are empty or both are filled
     if (!((fromDateInput.value === "" && toDateInput.value === "") || (fromDateInput.value !== "" && toDateInput.value !== ""))) {
         alert("Please select both 'From Date' and 'To Date' or leave both empty to search.");
         isValid = false;
     }
     if (isValid) {
	 	onPageSubmit('<c:out value="${contextRoot}"/>/dashBoard/openDashBoard.do');
     }
	 }
	 
</script>
<script type="text/javascript">

function getSelectedYear() {
    var yearSelect = document.getElementById("yearSelect");
    var selectedYear = yearSelect.options[yearSelect.selectedIndex].value;
    document.getElementById("yearSelectHidden").value = selectedYear;
    search1();

}
</script>
  
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Add some CSS for modal styling (if not already included) -->
<style>
    .modal {
        display: none; /* Hidden by default */
        position: fixed; /* Stay in place */
        z-index: 1; /* Sit on top */
        left: 0;
        top: 0;
        width: 100%; /* Full width */
        height: 100%; /* Full height */
        overflow: auto; /* Enable scroll if needed */
        background-color: rgb(0,0,0); /* Fallback color */
        background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    }
    .modal-content {
        background-color: #fefefe;
        margin: 15% auto; /* 15% from the top and centered */
        padding: 20px;
        border: 1px solid #888;
        width: 80%; /* Could be more or less, depending on screen size */
    }
    .close-button {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }
    .close-button:hover,
    .close-button:focus {
        color: black;
        text-decoration: none;
        cursor: pointer;
    }
</style>
<style>

.priceestate .greyestate {
  background-color: #eee;
  font-size: 17px;
}
.columnsestate-department-style {
    float: left;
    width: 11%;
    padding: 5px;
}

.priceestate .headerestate {
    background-color: #111;
    color: white;
    font-size: 16px;
    }
    
    .ClsSearch {
    margin-top: 5px;
    margin-bottom: 5px;
    margin-right: 5px;
    padding-bottom: 5px;
    padding-top: 5px;
    overflow: auto;
    background-color: #e6e6e6;
    font-size: 11px;
    color: black;
    font-weight: bold;
    vertical-align: AbsMiddle;
    width: 100%;
        font-family: sans-serif;
    
    }
    #head {
    margin: 0;
    padding: 0;
    font-size: 25px;
    margin-top:5px;
}
  .custom-container {
      max-width: 400px;
      margin: 0 auto;
      padding: 20px;
    }
  
* {
  box-sizing: border-box;
}

.columns {
  float: left;
  width: 16%;
  padding: 8px;
}

.priceestate {
  z-index: 0; /* Sit on top */
 position:relative;

  list-style-type: none;
  border: 1px solid #eee;
  margin: 0;
  padding: 0;
  -webkit-transition: 0.3s;
  transition: 0.3s;
}

.priceestate:hover {
  box-shadow: 0 8px 12px 0 rgba(0,0,0,0.2)
}



.priceestate li {
  border-bottom: 1px solid #eee;
  padding: 15px;
  text-align: center;
}




    .custom-container {
      max-width: 400px;
      margin: 0 auto;
      padding: 20px;
    }
  
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
  font-size: 17px;
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
.form-label {
  display: block;
  font-size: 14px;
  font-weight: bold;
  color: #333;
  margin-bottom: 8px;
  letter-spacing: 0px;
  background-color: #f2f2f2;
  padding: 10px 15px;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  width: 350px;
}






body {font-family: Arial, Helvetica, sans-serif;}

/* The Modal (background) */
.modal {
margin-left:280px;
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 99; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width:10%;/* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  
}

/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}

/* The Close Button */
.close {
margin-left:1080px;
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}

.mydatacontent {
  background-color: #fff;
  width: 1150px;
  max-height: 800px;
  padding: 20px;
  overflow: auto;
}

.pricewater .greywater {
  background-color: #eee;
  font-size: 18px;  
  
}
.columnswater-department-style {
       
     float: left;
  width: 14%;
  padding: 8px;
}

.pricewater .headerwater {
    background-color: #111;
    color: white;
    font-size: 17px;    
    }
    
    .pricewater {
  z-index: 0; /* Sit on top */
 position:relative;

  list-style-type: none;
  border: 1px solid #eee;
  margin: 0;
  padding: 0;
  -webkit-transition: 0.3s;
  transition: 0.3s;
}

.pricewater:hover {
  box-shadow: 0 8px 12px 0 rgba(0,0,0,0.2)
}



.pricewater li {
  border-bottom: 1px solid #eee;
  padding: 20px;
  text-align: center;
}
#container {
    width: 615px;
}
#container1 {
    width: 527px;
}
</style>
<%
    int currentYear = java.time.Year.now().getValue();
    int startYear = 2023; // Start from the year 2023
    String hiddenYear = request.getParameter("year"); // Get the hidden field value
    String department = request.getParameter("departments");
    String toDate = request.getParameter("registrationFromDate");
    int selectedYear = (hiddenYear != null && !hiddenYear.isEmpty()) ? Integer.parseInt(hiddenYear) : currentYear;
%>
<div class="mainHdr d-flex justify-content-between align-items-center">
    <h3 class="mb-0">Dashboard</h3>
  
    <div class="d-flex align-items-center ms-2">
        <h6 id="yearLabel" class="mb-0 me-2">Year:</h6>
        <select id="yearSelect" name="year" class="form-select mb-0" onchange="getSelectedYear()">
            <% 
                for (int year = currentYear; year >= startYear; year--) {
                    String selected = (year == selectedYear) ? "selected" : "";
            %>
                    <option value="<%= year %>" <%= selected %>><%= year %></option>
            <% 
                }
            %>
        </select>
        <input type="hidden" id="yearSelectHidden" name="year" value="<%= selectedYear %>"/>
    </div>
</div>

<div id="SearchDivId" class="ClsSearch">
		<div class="ClsSearchTitle">
		
			<img src="<c:out value="${contextRoot}"/>/images/closed.gif" id="searchToggleImage" onclick="javascript:dashboardToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');" />
			<fmt:message key="search.label.heading" />
		</div>
<table id="SearchTable" class="searchForm" style="display:none; width: 98%; margin-top: 30px;">
<tr style="">
<%
// Retrieve hidden field values for departments, services, and dates
String selectedDepartment = request.getParameter("departments");
String selectedService = request.getParameter("services");
String registrationFromDate = request.getParameter("registrationFromDate");
String registrationToDate = request.getParameter("registrationToDate");
%>
    <td style="width: 150px;  padding-left: 25px;">
        <div class="form-group">
        
<label for="departments" class="form-label">Departments:</label>
        <select id="departments" class="form-control custom-select" name="departments" required>
            <option value="" <%= (selectedDepartment == null || selectedDepartment.isEmpty()) ? "selected" : "" %>>-Select Department-</option>
            <option value="HEALTH-DEPARTMENT" <%= "HEALTH-DEPARTMENT".equals(selectedDepartment) ? "selected" : "" %>>Health Department</option>
            <option value="SOLIDWASTE-DEPARTMENT" <%= "SOLIDWASTE-DEPARTMENT".equals(selectedDepartment) ? "selected" : "" %>>Solid Waste Management Department</option>
            <option value="TAX-DEPARTMENT" <%= "TAX-DEPARTMENT".equals(selectedDepartment) ? "selected" : "" %>>Tax Department</option>
            <option value="TOWN-PLANNING-DEPARTMENT" <%= "TOWN-PLANNING-DEPARTMENT".equals(selectedDepartment) ? "selected" : "" %>>Town Planning Department</option>
            <option value="WATER-DEPARTMENT" <%= "WATER-DEPARTMENT".equals(selectedDepartment) ? "selected" : "" %>>Water Department</option>
            <option value="FIRE-DEPARTMENT" <%= "FIRE-DEPARTMENT".equals(selectedDepartment) ? "selected" : "" %>>Fire Department</option>
            <option value="ESTATE-DEPARTMENT" <%= "ESTATE-DEPARTMENT".equals(selectedDepartment) ? "selected" : "" %>>Estate Department</option>
            <option value="GARDEN-DEPARTMENT" <%= "GARDEN-DEPARTMENT".equals(selectedDepartment) ? "selected" : "" %>>Garden Department</option>
        </select>
        </div>
    </td>
 <td style="width: 150px; padding-left: 25px;">
    <div class="form-group" id="servicesContainer" style="display: <%= (selectedDepartment != null && !selectedDepartment.isEmpty()) ? "block" : "none" %>;">
        <label for="services" class="form-label">Services:</label>
        <select id="services" class="form-control custom-select" name="services" required>
            <option value="" <%= (selectedService == null || selectedService.isEmpty()) ? "selected" : "" %>>-Select Services-</option>
            <!-- Add options for services dynamically based on selected department -->
        </select>
    </div>
</td>
</tr>
<input type="hidden" id="departmentsHidden" value="<c:out value="${departments}"/>"/>
<input type="hidden" id="servicesHidden" value="<c:out value="${services}"/>"/>
<input type="hidden" id="registrationFromDateHidden" value="<c:out value="${registrationFromDate}"/>"/>
<input type="hidden" id="registrationToDateHidden" value="<c:out value="${registrationToDate}"/>"/>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
        var selectedDepartment = $('#departmentsHidden').val();
        var selectedService = $('#servicesHidden').val();
        var servicesSelect = $('#services');

        // Populate services dropdown based on selected department on page load
        populateServices(selectedDepartment, selectedService);

        $('#departments').on('change', function () {
            var selectedValue = $(this).val();
            populateServices(selectedValue, "");
        });

        function populateServices(department, selectedService) {
            servicesSelect.empty();
            if (department === 'HEALTH-DEPARTMENT') {
                servicesSelect.append('<option value="">Select Service</option>');
                servicesSelect.append('<option value="1">Birth Certificate</option>');
                servicesSelect.append('<option value="2">Death Certificate</option>');
                servicesSelect.append('<option value="11">Marriage Certificate</option>');
                
                servicesSelect.append('<option value="94">Nursing Home Registration</option>');
                servicesSelect.append('<option value="95">Renewal of Nursing Home Registration </option>');
                servicesSelect.append('<option value="96">Change In No. Of Beds/Usage</option>');
                servicesSelect.append('<option value="97">MTP Registration Certificate</option>');
                servicesSelect.append('<option value="101">Bio Medical Waste Disposal</option>');

            } else if (department === 'SOLIDWASTE-DEPARTMENT') {
                servicesSelect.append('<option value="">Select Service</option>');
                servicesSelect.append('<option value="3">Dog License</option>');
                servicesSelect.append('<option value="102">Dog License Renewal</option>');
            } else if (department === 'TAX-DEPARTMENT') {
                servicesSelect.append('<option value="">Select Service</option>');
                servicesSelect.append('<option value="55">Property Tax Utara</option>');
                servicesSelect.append('<option value="54">Property Tax No Due Certificate</option>');
                servicesSelect.append('<option value="104">Property Transfer Registration Certificate/Inheritance Right</option>');
                servicesSelect.append('<option value="103">New Assesment of Tax/Mutation</option>');
                servicesSelect.append('<option value="58">Property Tax Re-Assessment</option>');
                servicesSelect.append('<option value="72">Property Tax Demand</option>');
                servicesSelect.append('<option value="71">Property Tax Exemption</option>');
                
            } else if (department === 'TOWN-PLANNING-DEPARTMENT') {
                servicesSelect.append('<option value="">Select Service</option>');
                servicesSelect.append('<option value="5">Zone Certificate</option>');
                servicesSelect.append('<option value="28">Part Map Certificate</option>');
            } else if (department === 'WATER-DEPARTMENT') {
                servicesSelect.append('<option value="">Select Service</option>');
                servicesSelect.append('<option value="48">New Water Connection</option>');
                servicesSelect.append('<option value="6">Permanent Disconnection</option>');
                servicesSelect.append('<option value="49">Change Of Ownership</option>');
                servicesSelect.append('<option value="47">Change Of Tap Size</option>');
                servicesSelect.append('<option value="50">Water Reconnection</option>');
                servicesSelect.append('<option value="51">Change Of Category</option>');
                servicesSelect.append('<option value="68">Water Connection No Dues</option>');
              
            
	    } else if (department === 'FIRE-DEPARTMENT') {
                servicesSelect.append('<option value="">Select Service</option>');
           
                servicesSelect.append('<option value="93">Temporary Fireworks License NOC</option>');
                servicesSelect.append('<option value="69">Temporary Fire NOC</option>');
                servicesSelect.append('<option value="70">Final Fire NOC</option>');


            } else if (department === 'ESTATE-DEPARTMENT') {
                servicesSelect.append('<option value="">Select Service</option>');
                servicesSelect.append('<option value="23">Mandap Certificate</option>');
                servicesSelect.append('<option value="90">Ganesh Mandap Permission</option>');
                servicesSelect.append('<option value="91">Durga Utsav/Garba Mandap Permission</option>');
                servicesSelect.append('<option value="92">Diksha Bhumi Mandap Permission</option>');
            } else if (department === 'MARKET-DEPARTMENT') {
                servicesSelect.append('<option value="">Select Service</option>');
                servicesSelect.append('<option value="32">NOC For Business/Trade/Godown</option>');
                servicesSelect.append('<option value="41">Trade License Duplication</option>');
                servicesSelect.append('<option value="33">Trade License Renewal</option>');
                servicesSelect.append('<option value="38">Trade License Transfer</option>');
                servicesSelect.append('<option value="44">Trade License New</option>');
                servicesSelect.append('<option value="34">Trade License Name Change</option>');
                servicesSelect.append('<option value="35">Trade License Type Change</option>');
                servicesSelect.append('<option value="36">Trade License Owner/Partner Change</option>');
                servicesSelect.append('<option value="39">License Partner Count Update</option>');
                servicesSelect.append('<option value="42">Trade License Outdated Renewal Notice</option>');
                servicesSelect.append('<option value="40">Trade License Cancellation</option>');
            } else if (department === 'GARDEN-DEPARTMENT') {
                servicesSelect.append('<option value="">Select Service</option>');
                servicesSelect.append('<option value="73">Tree Cutting</option>');
                servicesSelect.append('<option value="75">Tree Trimming</option>');
            } else {
                $('#servicesContainer').hide();
                return;
            }

            if (selectedService) {
                servicesSelect.val(selectedService);
            }

            $('#servicesContainer').show();
        }
    });
</script>
    

 
			
			<tr>
				<td style="width: 150px; padding-left: 25px;"><span class="ClsLabel form-label">Application Date Period:</span></td>
<td style="width: 370px; padding-left: 25px;">
    <input type="date" class="ClsTextboxDate" id="registrationFromDate" style="font-size: 14px;width:158px;height:38px;" name="registrationFromDate" value="<%= registrationFromDate != null ? registrationFromDate : "" %>" /> -
    <input type="date" class="ClsTextboxDate" id="registrationToDate" style="font-size: 14px;width:158px;height:38px;" name="registrationToDate" value="<%= registrationToDate != null ? registrationToDate : "" %>" />
</td>

				
				 
			
			    
				<td>
					<input type="button" style="width:115px;height:38px;margin-top:2px;" class="ClsButton" id="search" name="search" value="   <fmt:message key="common.button.search"/>   " onclick="javascript:search1()" />
					
				</td>			
			</tr>
			
		</table>
		<c:if test="${not empty registrationFromDate or not empty registrationToDate or not empty departments or not empty services}">
		
			<script>
				ToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');
			</script>
		</c:if>
	</div>	



			
<c:choose>
<c:when test="${services ne 23 and not empty services and not empty departments and departments eq 'ESTATE-DEPARTMENT'}">
    
    
			    						
<div id="dashData">
<h2 style="text-align:center">RTS Applications</h2>


<div id="myBtn">
<div>
<div class="columnsestate-department-style" id="All" onclick="getListOnCategory(this.id)">
  <ul class="priceestate">
    <li class="headerestate" style="background-color:#E404FA" ><br>Applications Received</li>
    <li class="greyestate">${allReciepts}</li>
    
  </ul>
</div>
</div>
<div>
<div class="columnsestate-department-style" id="All" onclick="getListOnCategory(this.id)">
  <ul class="priceestate">
    <li class="headerestate" style="background-color:rebeccapurple" ><br>Applications In-Process</li>
    <li class="greyestate">${newReciepts}</li>
    
  </ul>
</div>
</div>
<div id="myBtn">
<div class="columnsestate-department-style" id="Closed" onclick="getListOnCategory(this.id)">
  <ul class="priceestate">
    <li class="headerestate" style="background-color:#33B7FF" > <br>Applications Completed </li>
    <li class="greyestate">${closedReciepts}</li>
    
  </ul>
</div>
</div>

<div id="myBtn">
<div class="columnsestate-department-style" id="PoliceNoc" onclick="getListOnCategory(this.id)">
  <ul class="priceestate">
    <li class="headerestate" style="background-color:#5f7081" >Police<br> NOC Issued</li>
    <li class="greyestate">${policenoc}</li>
    
  </ul>
</div>
</div>

<div id="myBtn">
<div class="columnsestate-department-style" id="TrafficNoc" onclick="getListOnCategory(this.id)">
  <ul class="priceestate">
    <li class="headerestate" style="background-color:#e12771" >Traffic <br>NOC Issued</li>
    <li class="greyestate">${trafficnoc}</li>
    
  </ul>
</div>
</div>
<div id="myBtn">
<div class="columnsestate-department-style" id="FireNoc" onclick="getListOnCategory(this.id)">
  <ul class="priceestate">
    <li class="headerestate" style="background-color:color(a98-rgb 0.37 0.53 0.83)" > &nbsp;&nbsp;Fire &nbsp;&nbsp; NOC Issued</li>
    <li class="greyestate">${firenoc}</li>
    
  </ul>
</div>
</div>
<div id="myBtn">
<div class="columnsestate-department-style" id="Pending" onclick="getListOnCategory(this.id)">
  <ul class="priceestate">
    <li class="headerestate" style="background-color:#FFC133" >Pending for payment</li>
    <li class="greyestate">${pendingReiepts}</li>
    
  </ul>
</div>
</div>
<div id="myBtn">
<div class="columnsestate-department-style" id="Approved" onclick="getListOnCategory(this.id)">
  <ul class="priceestate">
    <li class="headerestate" style="background-color:#17DF68" ><br>Payment Completed</li>
    <li class="greyestate">${approvedReiepts}</li>
    
  </ul>
</div>
</div>



<div id="myBtn">
<div class="columnsestate-department-style" id="Rejected" onclick="getListOnCategory(this.id)">
  <ul class="priceestate">
    <li class="headerestate" style="background-color:#E62C04" ><br>Applications Rejected </li>
    <li class="greyestate">${rejectedCount}</li>
    
  </ul>
</div>
</div>
<div id="myBtn">
<div class="columnsestate-department-style" id="Totalfees" onclick="getListOnCategory(this.id)">
  <ul class="priceestate">
    <li class="headerestate" style="background-color:#4CAF50">Total <br>Fees<br>(In Rs.)</li>
        <li class="greyestate"><c:set var="tfEstate" value="${Totalfees}"/><%= fmtIndianAmount(pageContext.getAttribute("tfEstate")) %></li>
    
    
  </ul>
</div>
</div>
</div>
</div>
 </div>
    </c:when>
        <c:otherwise>
    
   
    					     <div class="default-style">
        <!-- Water Department -->
            <div id="dashData">
<h2 style="text-align:center">RTS Applications</h2>

<div id="myBtn">
<div>

<div class="columnswater-department-style" id="All" onclick="getListOnCategory(this.id)">
  <ul class="pricewater">
  
    <li class="headerwater" style="background-color:#E404FA" > Applications Received</li>
    <li class="greywater">${allReciepts}</li>
    
  </ul>
</div>
</div>

<div id="myBtn">
<div>
<div class="columnswater-department-style" id="Received" onclick="getListOnCategory(this.id)">
  <ul class="pricewater">
  
<li class="headerwater" style="background-color: rebeccapurple;">
    <span style="margin-top: 20px;">Applications In-Process</span>
</li>    <li class="greywater">${newReciepts}</li>
    
  </ul>
</div>
</div>
<div id="myBtn">
<div class="columnswater-department-style" id="Closed" onclick="getListOnCategory(this.id)">
  <ul class="pricewater">

           <li class="headerwater" style="background-color:#33B7FF" >Applications Completed  </li>
    
    
    <li class="greywater">${closedReciepts}</li>
    
  </ul>
</div>
</div>
<div id="myBtn">
<div class="columnswater-department-style" id="Pending" onclick="getListOnCategory(this.id)">
  <ul class="pricewater">
  
          <li class="headerwater" style="background-color:#FFC133" >Pending for Payment</li>
    
    <li class="greywater">${pendingReiepts}</li>
    
  </ul>
</div>
</div>
<div id="myBtn">
<div class="columnswater-department-style" id="Approved" onclick="getListOnCategory(this.id)">
  <ul class="pricewater">
 
            <li class="headerwater" style="background-color:#17DF68" >Payment Completed</li>
        
      
        <li class="greywater">${approvedReiepts}</li>
    
  </ul>
</div>
</div>



<div id="myBtn">
<div class="columnswater-department-style" id="Rejected" onclick="getListOnCategory(this.id)">
  <ul class="pricewater">
  
              <li class="headerwater" style="background-color:#E62C04" >Applications Rejected </li>
              
    <li class="greywater">${rejectedCount}</li>
    
  </ul>
</div>
</div>
<div id="myBtn">
<div class="columnswater-department-style" id="Totalfees" onclick="getListOnCategory(this.id)">
  <ul class="pricewater">
    <li class="headerwater" style="background-color:#4CAF50">Total Fees<br>(In Rs.)</li>
    <li class="greywater">${Totalfees}</li>
    
  </ul>
</div>
</div>
</div>
</div>
<div>
        </div>
      </c:otherwise>
</c:choose>
     


<table align="center">
<tr>

<td><div id="container"></div></td>
<td><div id="container1"></div></td>
</tr>

</table>

</div>

<div id="myModal" class="modal" style="display: ${not empty requestScope.rtiList ? 'block' : 'none'};">
 <div class="modal-content">

    <span class="close">&times;</span>
    
   <div class="search-container" style="display: flex; align-items: center; justify-content: flex-start; gap: 15px;">
    <label for="searchrtiApplnNumber" style="font-weight: bold;
    margin-right: 5px;
    font-family: 'icomoon';
    font-size: 16px;">
        <fmt:message key="rtiApplication.list.label.rtiApplnNumber" />:
    </label>
    <input type="text" class="ClsTextbox" id="searchrtiApplnNumber" maxlength="60" 
           style="padding: 5px; width: 200px; border-radius: 4px; border: 1px solid #ccc;height: 32px;" 
           name="searchrtiApplnNumber" placeholder="Search by Application Number" onblur="this.value = this.value.trim();" />
    
    <input type="button" style="padding: 8px 15px; margin-top:10px; height: auto; border-radius: 4px; background-color: #007bff; color: white; border: none; cursor: pointer;" 
           class="ClsButton" value="<fmt:message key='common.button.search'/>" 
           onclick="getListOnCategory(this.id)" />
</div>

    
        
    <a href='<c:out value="${contextRoot}"/>/exportToExcel.do?receiptStatus=${receiptSatus}' class="excel-button">
       <i class="fa fa-file-excel-o" style="font-size:38px;color:green;margin-left:1000px;margin-top:-45px;"></i>
    </a>
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

<div id="popup" class="mydata">
<div class="mydatacontent">


<table id = "excelTable" cellpadding="0" cellspacing="1" width="120%"  class="dataGrid">
			<thead>
				<tr>
					
					<td style="width: 60px" onclick="javascript:resort('upper(rtiApplicationId)');"
						style="cursor: pointer" wrap>Sr.No.<span
						id="upper(rtiApplicationId)"></span>
					</td>
					
					<td  style="width: 60px" onclick="javascript:resort('upper(rtiApplnNumber)');"
						style="cursor: pointer" wrap><fmt:message
							key="rtiApplication.list.label.rtiApplnNumber" /> <span
						id="upper(rtiApplnNumber)"></span>
					</td>
					
					<td  style="width: 90px" onclick="javascript:resort('upper(createdDate)');"
						style="cursor: pointer" wrap>Application Date <span
						id="upper(createdDate)"></span>
					</td>
					<td  style="width: 130px" onclick="javascript:resort('upper(applicantName)');"
						style="cursor: pointer" wrap>Applicant Name <span
						id="upper(applicantName)"></span>
					</td>
					<td onclick="javascript:resort('subject');"
						style="cursor: pointer" wrap>Service Name <span
						id="upper(subject)"></span>
					</td>
					<td style="width: 70px" onclick="javascript:resort('mobileNumber');"
						style="cursor: pointer" wrap>Applicant Contact No. <span
						id="upper(mobileNumber)"></span>
					</td>
					
					<td style="width: 85px" onclick="javascript:resort('zone');"
						style="cursor: pointer" wrap>Zone No.<span
						id="upper(Zone)"></span>
					</td>
					<!-- <td style="width: 85px" onclick="javascript:resort('inWardNumber');"
						style="cursor: pointer" wrap>Ward No.<span
						id="upper(Ward)"></span>
					</td>-->
					<td style="width: 70px" onclick="javascript:resort('inWardNumber');"
						style="cursor: pointer" wrap>Payment Status<span
						id="upper(inWardNumber)"></span>
					</td>
					<td style="width: 70px" onclick="javascript:resort('inWardNumber');"
						style="cursor: pointer" wrap>Amount (₹)<span
						id="upper(inWardNumber)"></span>
					</td>
					<td style="width: 90px" onclick="javascript:resort('inWardNumber');"
						style="cursor: pointer" wrap>Application Status<span
						id="upper(inWardNumber)"></span>
					</td>
					
						
					
					<c:if test="${not empty departments and departments eq 'ESTATE-DEPARTMENT' and services ne 23 and not empty services}">
				
            <td style="width: 20%;" onclick="javascript:resort('inWardNumber');">
                Police NOC<span id="upper(inWardNumber)"></span>
            </td>
            </c:if>
					<c:if test="${not empty departments and departments eq 'ESTATE-DEPARTMENT' and services ne 23 and not empty services}">
            
            <td style="width: 20%;" onclick="javascript:resort('inWardNumber');">
                Traffic NOC<span id="upper(inWardNumber)"></span>
            </td>
            </c:if>
					<c:if test="${not empty departments and departments eq 'ESTATE-DEPARTMENT' and services ne 23 and not empty services}">
            
            <td style="width: 20%;" onclick="javascript:resort('inWardNumber');">
                Fire NOC<span id="upper(inWardNumber)"></span>
            </td>
            </c:if>
            <td style="width: 20%;" onclick="javascript:resort('inWardNumber');">
                Final Certificate<span id="upper(inWardNumber)"></span>
            </td>
        	<td style="width: 500px" onclick="javascript:resort('inWardNumber');"
						style="cursor: pointer" wrap>Remark<span
						id="upper(inWardNumber)"></span>
					</td>
					
				</tr>
			</thead>
			 <tbody id="rtiList1">
				<c:set var="hasRows" value="false" />
				<c:forEach var="rtiApplnList"
					items="${requestScope.rtiList}" varStatus="rowNumber">
					<c:set var="hasRows" value="true" />
				      <tr class="rti-item" data-appln-number="${rtiApplnList.rtiApplnNumber}">
						
						
				<td class="value" >${rtiApplnList.rowNumber}</td>    
					
						<td><a title="<fmt:message key="list.link.EditOrViewLink"/>"
						href="javascript:editRTIApplication('${rtiApplnList.rtiApplicationRefId}','${rtiApplnList.rtiApplicationId}');">
							<c:out value="${rtiApplnList.rtiApplnNumber}" />
					</a></td>
						<td><c:out value="${rtiApplnList.createdDate}" /></td>
						<td><c:out value="${rtiApplnList.applicantName}" /></td>
						<td><c:out value="${rtiApplnList.subject}" /></td>
						<td><c:out value="${rtiApplnList.mobileNumber}" /></td>
						<td><c:out value="${rtiApplnList.zone}" /></td>
						<!-- <td><c:out value="${rtiApplnList.inWardNumber}" /></td>-->
						<td>
						<c:out value="${requestScope.rtiApplication}" />
    <c:if test="${rtiApplnList.workFlowStatus == 0}">
        Pending.
    </c:if>
      <c:if test="${rtiApplnList.workFlowStatus == 9}">
        Pending.
    </c:if>
      <c:if test="${rtiApplnList.workFlowStatus == 10}">
        Pending.
    </c:if>
      <c:if test="${rtiApplnList.workFlowStatus == 11}">
        Pending.
    </c:if>
    <c:if test="${rtiApplnList.workFlowStatus == 3}">
        Pending.
    </c:if>
    <c:if test="${rtiApplnList.workFlowStatus == 2}">
        Completed.
    </c:if>
    <c:if test="${rtiApplnList.workFlowStatus == 1}">
        Completed.
    </c:if>
       <c:if test="${rtiApplnList.workFlowStatus == 5}">
        Pending.
    </c:if>
    
 </td>
 <td>
<c:set var="rawAmt" value="${rtiApplnList.applicationCost}"/><%= fmtIndianAmount(pageContext.getAttribute("rawAmt")) %>

 </td>
 						<td><c:out value="${requestScope.rtiApplication}" />
    <c:if test="${rtiApplnList.workFlowStatus == 0}">
        Citizen Form Submitted.
    </c:if>
    <c:if test="${rtiApplnList.workFlowStatus == 3}">
        Pending.
    </c:if>
    <c:if test="${rtiApplnList.workFlowStatus == 2}">
        Approved
    </c:if>
    <c:if test="${rtiApplnList.workFlowStatus == 1}">
        Completed
    </c:if>
    <c:if test="${rtiApplnList.workFlowStatus == 5}">
        Rejected
    </c:if>
     <c:if test="${rtiApplnList.workFlowStatus == 9}">
        Under Approval Authority
    </c:if>
     <c:if test="${rtiApplnList.workFlowStatus == 10}">
           Under Higher Approval Authority        
    </c:if>
     <c:if test="${rtiApplnList.workFlowStatus == 11}">
        MTP Inspection completed.
    </c:if>
</td>


					<c:if test="${not empty departments and departments eq 'ESTATE-DEPARTMENT' and services ne 23 and not empty services}">

<td>
  <c:choose>
    <c:when test="${not empty rtiApplnList.policeNoc}">
      <c:out value="Yes" />
    </c:when>
    <c:otherwise>
      <c:out value="No" />
    </c:otherwise>
  </c:choose>
</td>
</c:if>
					<c:if test="${not empty departments and departments eq 'ESTATE-DEPARTMENT' and services ne 23 and not empty services}">

<td>
  <c:choose>
    <c:when test="${not empty rtiApplnList.trafficNoc}">
      <c:out value="Yes" />
    </c:when>
    <c:otherwise>
      <c:out value="No" />
    </c:otherwise>
  </c:choose>
</td>
</c:if>
					<c:if test="${not empty departments and departments eq 'ESTATE-DEPARTMENT' and services ne 23 and not empty services}">

<td>
  <c:choose>
    <c:when test="${not empty rtiApplnList.fireNoc}">
      <c:out value="Yes" />
    </c:when>
    <c:otherwise>
      <c:out value="No" />
    </c:otherwise>
  </c:choose>
</td>
</c:if>
<td>
  <c:choose>
    <c:when test="${not empty rtiApplnList.pdfFilesSavedPath}">
      <c:out value="Yes" />
    </c:when>
    <c:otherwise>
      <c:out value="No" />
    </c:otherwise>
  </c:choose>
</td>
          						
               				<td><c:out value="${rtiApplnList.workflowComments}" /></td>
           

					</tr>
				</c:forEach>
				 <c:if test="${hasRows == false}">
                    <tr>
                        <td colspan="10" class="clsNoRecords" align="center">
                            <fmt:message key="list.label.norecords" />
                        </td>
                    </tr>
                </c:if>
	
				
			</tbody>

		<tfoot>
			<tr>
				<td colspan="15"><c:if test="${requestScope.rtiList != null && requestScope.totalCount>0}">
						<span><%@include file="/pages/common/dashboardpagination.jsp"%></span>
					</c:if></td>
			</tr>
		</tfoot>
	</table>


</c:if>	
<div id="noRecordsModal" class="modal" style="display: ${empty requestScope.rtiList ? 'block' : 'none'};">
    <div class="modal-content">
        <span class="close-button" onclick="document.getElementById('noRecordsModal').style.display='none'">&times;</span>
        <c:if test="${empty requestScope.rtiList}">
            <p class="no-records">No records found.</p>
        </c:if>
    </div>
</div>


<script>
const rtiList = ${requestScope.rtiList}; // Update this based on your logic

        // Example: If rtiList is empty, display the modal
        if (!rtiList || rtiList.length === 0) {
            document.getElementById('noRecordsModal').style.display = 'block';
        } else {
            // Hide the modal if records are found (optional)
            document.getElementById('noRecordsModal').style.display = 'none';
        }
    }

    // Close modal when clicking outside of it
    window.onclick = function(event) {
        var modal = document.getElementById('noRecordsModal');
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
    </script>



</div>
</div> 
</div>    
 </div>        
          	
     
	<input type="hidden" id="rtiApplicationId" name="rtiApplicationId" value="" />
		<input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="" />
	
<input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>"/> 
<input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" />
	<script type="text/javascript">
		insert_image('${contextRoot}');
	</script>
		<script>
		 
// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
var popup = document.getElementById("popup");
popup.style.display = "flex";


// When the user clicks the button, open the modal 
btn.onclick = function() {

 modal.style.display = "block";

  
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";

}

// When the user clicks anywhere outside of the modal, close it

window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";

  }
}
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
    	
    
    	
	     colors: ['rebeccapurple','#33B7FF','#FFC133', '#17DF68',  '#E62C04']

    });
    
    var chart;

   

        chart = new Highcharts.Chart({

            chart: {

            	 renderTo: 'container',
                 plotBackgroundColor: null,
                 plotBorderWidth: null,
                 plotShadow: false,
                 type: 'pie'
            },

            title: {

                text: ''

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
                        style: {
                            fontSize: '12px',
                            textOverflow: 'ellipsis',
                            whiteSpace: 'nowrap !important', 
                        },
                    distance: 7, 
                   
                        color: '#000000',

                        connectorColor: '#000000',

                        formatter: function() {

                            return '<b>'+ this.point.name +'</b>: '+ Highcharts.numberFormat(this.percentage, 2)  +' %';

                        }

                    },
                size: '66%' // Increase the size of the pie chart
   }

            },

          

               series: [{
               
                name: 'RTS Applications Status',
        		data : [
                    ['In-Process', ${newReciepts}],
                    ['Completed', ${closedReciepts}],
                    ['Pending for payment', ${pendingReiepts}],
                    ['Payment Completed', ${approvedReiepts}],
                    ['Rejected', ${rejectedCount}]
                ]
            }],
            credits: {
                enabled: false
            }

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
 
Highcharts.setOptions({
    colors: [ 'rebeccapurple', '#33B7FF','#FFC133', '#17DF68','#E62C04']
});

// JavaScript object to hold the data
var map = {
   // 'Applications Received': 53,  // Replace with actual value
    'Applications In-Process': ${newReciepts}, // Replace with actual value
    'Applications Completed': ${closedReciepts}, // Replace with actual value
    'Pending for Payment': ${pendingReiepts}, // Replace with actual value
    'Payment Completed': ${approvedReiepts}, // Replace with actual value
    'Applications Rejected': ${rejectedCount}  // Replace with actual value
};
var chart1 = Highcharts.chart('container1', {

    chart: {
        type: 'column'
    },
    title: {
        text: ''
    },
    
    xAxis: {
        categories:[
                  // 'Applications Received',
                  'Applications In-Process',
                   'Applications Completed',
                   
                   'Pending for Payment',
                   'Payment Completed',
                   'Applications Rejected'
               ],
		         crosshair: true
    },
    yAxis: {
        min: 0,
       
        title: {
            text: ''
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
        name: 'RTS Applications Status',
         data: [
                   //map['Applications Received'],
                   map['Applications In-Process'],
                   map['Applications Completed'],
                   map['Pending for Payment'],
                   map['Payment Completed'],
                   map['Applications Rejected']
               ]
		     }],
    credits: {
        enabled: false
    }
});

chart1.xAxis[0].labelGroup.element.childNodes.forEach(function(label)
		 {
		 	label.style.cursor = "pointer";
		    label.onclick = function(){
		   	getListOnCategory(this.textContent);
		   }
		 });

 function getListOnCategory(category){
	 
	 
	 document.getElementById("receiptSatus").value=category;
	// Get the selected parameters
	    var departments = document.getElementById("departments").value;
	    var services = document.getElementById("services").value;
	    var registrationFromDate = document.getElementById("registrationFromDate").value;
	    var registrationToDate = document.getElementById("registrationToDate").value;
	    var searchrtiApplnNumber = document.getElementById("searchrtiApplnNumber").value;

	 
	 onPageSubmit('<c:out value="${contextRoot}"/>/dashBoard/getListOnCategory.do');
	 
	 return;
	 
	 }
 

 
 
	function editRTIApplication(refId,id) {
		document.getElementById('rtiApplicationRefId').value = refId;
		document.getElementById('rtiApplicationId').value = id;
		onPageSubmit('<c:out value="${contextRoot}"/>/rtiapplication/editAnyRTIApplication.do');
	}
	</script>
	<!-- <script>
 
	  $(document).ready(function() {
		    // Retrieve the stored values from sessionStorage
		   // const selectedDepartments = sessionStorage.getItem('selectedDepartments');
		    const selectedServices = sessionStorage.getItem('selectedServices');
		    const registrationFromDate = sessionStorage.getItem('registrationFromDate');
		    const registrationToDate = sessionStorage.getItem('registrationToDate');

		    // Set the dropdown and date input to the stored values if they exist
		    if (selectedDepartments) {
		      $('#departments').val(selectedDepartments.split(','));
		    }

		    if (selectedServices) {
		      $('#services').val(selectedServices.split(','));
		      $('#servicesContainer').show();

		    }

		    if (registrationFromDate) {
		      $('#registrationFromDate').val(registrationFromDate);
		    }

		    if (registrationToDate) {
		      $('#registrationToDate').val(registrationToDate);
		    }

		    // Add an event listener to the dropdowns
		    $('#departments').change(function() {
		      // Store the selected values in sessionStorage
		      sessionStorage.setItem('selectedDepartments', $('#departments').val());
		    });

		    // Add an event listener to the services dropdown
		    $('#services').change(function() {
		      // Store the selected values in sessionStorage
		      sessionStorage.setItem('selectedServices', $('#services').val());
		    });

		    // Add an event listener to the date inputs
		    $('#registrationFromDate, #registrationToDate').change(function() {
		      // Store the selected values in sessionStorage
		      sessionStorage.setItem('registrationFromDate', $('#registrationFromDate').val());
		      sessionStorage.setItem('registrationToDate', $('#registrationToDate').val());
		    });

		    // Show the services dropdown on page load if a department is already selected
		   
	          if(selectedDepartments.includes('HEALTH-DEPARTMENT')){
	          		$('#hd1').show();
	          		$('#hd2').show();
	          		$('#hd3').show();
	          }else{
	        	  $('#hd1').hide();
	              $('#hd2').hide();
	              $('#hd3').hide(); 
	          }
	          if(selectedDepartments.includes('SOLIDWASTE-DEPARTMENT')){
	              $('#sw1').show();
	              $('#sw2').show();
	              }else{
	            	  $('#sw1').hide();
	                  $('#sw2').hide();
	              }
	          if(selectedDepartments.includes('TAX-DEPARTMENT')){
	              $('#pt1').show();
	              $('#pt2').show();
	              $('#pt3').show();
	              $('#pt4').show();
	              $('#pt5').show();
	              $('#pt6').show();
	              $('#pt7').show();
	              $('#pt8').show();
	              $('#pt9').show();
	              $('#pt10').show();
	              $('#pt11').show();
	              $('#pt12').show();
	              }else{
	                  $('#pt1').hide();
	                  $('#pt2').hide();
	                  $('#pt3').hide();
	                  $('#pt4').hide();
	                  $('#pt5').hide();
	                  $('#pt6').hide();
	                  $('#pt7').hide();
	                  $('#pt8').hide();
	                  $('#pt9').hide();
	                  $('#pt10').hide();
	                  $('#pt11').hide();
	                  $('#pt12').hide();

	              }
	          if(selectedDepartments.includes('TOWN-PLANNING-DEPARTMENT')){
	                  $('#tpd1').show();
	                  $('#tpd2').show();
	                  $('#tpd3').show();

	                  }else{
	                	  $('#tpd1').hide();
	                      $('#tpd2').hide();
	                      $('#tpd3').hide();

	                  }
	          if(selectedDepartments.includes('WATER-DEPARTMENT')){
	              $('#wd1').show();
	              $('#wd2').show();
	              $('#wd3').show();
	              $('#wd4').show();
	              $('#wd5').show();
	              $('#wd6').show();
	              $('#wd7').show();
	              $('#wd8').show();
	              $('#wd9').show();
	              $('#wd10').show();
	              $('#wd11').show();

	              }else{
	            	  $('#wd1').hide();
	                  $('#wd2').hide();
	                  $('#wd3').hide();
	                  $('#wd4').hide();
	                  $('#wd5').hide();
	                  $('#wd6').hide();
	                  $('#wd7').hide();
	                  $('#wd8').hide();
	                  $('#wd9').hide();
	                  $('#wd10').hide();
	                  $('#wd11').hide();

	              }
	          if(selectedDepartments.includes('FIRE-DEPARTMENT')){
	              $('#fd1').show();
	              $('#fd2').show();
	              }else{
	            	  $('#fd1').hide();
	                  $('#fd2').hide();
	              }
	          if(selectedDepartments.includes('ESTATE-DEPARTMENT')){
	              $('#ed1').show();
	              $('#ed2').show();
	              $('#ed3').show();
	              $('#ed4').show();


	              }else{
	            	  $('#ed1').hide();
		              $('#ed2').hide();
		              $('#ed3').hide();
		              $('#ed4').hide();


	              }
	          if(selectedDepartments.includes('MARKET-DEPARTMENT')){
	        	  $('#md1').show();
	              $('#md2').show();
	              $('#md3').show();
	              $('#md4').show();
	              $('#md5').show();
	              $('#md6').show();
	              $('#md7').show();
	              $('#md8').show();
	              $('#md9').show();
	              $('#md10').show();
	              $('#md11').show();
	              }else{
	            	  $('#md1').hide();
	                  $('#md2').hide();
	                  $('#md3').hide();
	                  $('#md4').hide();
	                  $('#md5').hide();
	                  $('#md6').hide();
	                  $('#md7').hide();
	                  $('#md8').hide();
	                  $('#md9').hide();
	                  $('#md10').hide();
	                  $('#md11').hide();
 
		    }

		  
		  });
	  </script>-->

	<script>
       
    function dashboardToggleSearch(searchTable, searchToggleImage, applicatinContext) {
        var tableElement = document.getElementById(searchTable);
        var imageElement = document.getElementById(searchToggleImage);

        if (tableElement.style.display === 'none') {
        	 $('#dashData').hide();
             $('#container').hide();
        	 $('#container1').hide();
        		$('#yearLabel').hide();
            	$('#yearSelect').hide();
            tableElement.style.display = '';
            imageElement.src = applicatinContext + "/images/open.gif";
        } else {
        	$('#dashData').show();
            $('#container').show();
       	 $('#container1').show();
            tableElement.style.display = 'none';
            imageElement.src = applicatinContext + "/images/closed.gif";
        }
    }
</script>
<script>
    var fromDateInput = document.getElementById("registrationFromDate");
    var toDateInput = document.getElementById("registrationToDate");

    var today = new Date();
    fromDateInput.max = getCurrentDate(today); // Set max attribute of fromDateInput to the current date
    toDateInput.max = getCurrentDate(today); // Set max attribute of toDateInput to the current date

    fromDateInput.addEventListener("change", validateDateInputs);
    toDateInput.addEventListener("change", validateDateInputs);

    function getCurrentDate(date) {
        var year = date.getFullYear();
        var month = String(date.getMonth() + 1).padStart(2, '0');
        var day = String(date.getDate()).padStart(2, '0');
        return year + "-" + month + "-" + day;
    }

    function validateDateInputs() {
        var fromDate = new Date(fromDateInput.value);
        var toDate = new Date(toDateInput.value);

        if (toDate < fromDate) {
            alert("The 'to date' must be greater than or equal to the 'from date'.");
            toDateInput.value = ""; // Clear the 'to' date input
        }
    }
</script>

	
<input type="hidden" name="receiptSatus" id="receiptSatus" value="${receiptSatus}" />
