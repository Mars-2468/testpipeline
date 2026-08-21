<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Garden QR Code Reader</title>
    <!-- Kendo UI CSS -->
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2022.1.301/styles/kendo.default-v2.min.css">
    <!-- jQuery CDN -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Kendo UI JavaScript -->
    <script src="https://kendo.cdn.telerik.com/2022.1.301/js/kendo.all.min.js"></script>
    
    <style>
 .container {
     position: relative;
    height: 450px;
    width: 465px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    margin-top: 150px;
    margin-left: 580px;
    background-color: white; /* Set the background color of the container */
    z-index: 2; /* Ensure the container is above the overlay */
}

.container-fluid {
    width: 620px;
        position: relative;
    
    padding-left: 40px;
    padding-top:40px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    margin-left: 510px;
    margin-top: 10px;
        background-color: white; /* Set the background color of the container */
    z-index: 2;
}

body::before {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5); /* Black with 50% opacity */
    z-index: 1; /* Ensure the overlay is below the content */
}

body {
    margin: 0;
    padding: 0;
    background-image: url('/RTS/images/garden_background.jpg');
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
}
label {
	font-weight: 600;
}

        .btn-container {
            display: flex;
            justify-content: flex-end;
            margin-top: 20px;
        }
        .submit-btn {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            background-color: blue;
            color: white;
            cursor: pointer;
            outline: none;
                        font-size: 12px; 
            
        }
        .clear-btn {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            background-color: red;
            color: white;
            cursor: pointer;
            outline: none;
            font-size: 12px; 
        }
        .k-picker {
    border-color: rgba(0, 0, 0, .08);
    color: #424242;
    background-color: #f5f5f5;
    background-image: linear-gradient(rgba(0, 0, 0, 0), rgba(0, 0, 0, .02));
    margin-top: 10px;
}
.btn-container {
    display: flex;
    justify-content: center;
    align-items: center;
}


#container_33 {
    display: flex;
    
    flex-direction: column;
    align-items: center;
        width: 661px;
    margin-left: 480px;
}

.btn-container{
   display: flex;
        position: relative;
 z-index: 2;

}
#qrCodeImage {
    margin-top: 10px;
}
@media print {
  #print  {
    display: none;
  }
  #goBack  {
    display: none;
  }
  #main * {
    display: none;
  }
  
  #container_33 {
    margin: 0 auto; 
  }
  #qrCodeImage {
    margin-top: 10px;
}

a[href]:after {
    content: none !important;
  }
  
  time {
    display: none !important;
  }
  
  title {
    display: none !important;
  }
   @page {
    size: auto;  
    margin: 0; 
     size: legal landscape; 
  }
  
   @page :footer {
        display: none
    }

    @page :header {
        display: none
    }
}

.dropdown-container {
        margin: 0 auto;
        text-align: center;
        margin-top: 17px;
        
    }
    

    </style>
</head>
<body>
 <form id="myForm">
 <div id="main">
 
 <c:if test="${status!=1}">
     <div class="container">
      <img src="<c:out value="${contextRoot}"/>/images/nagpur-logo.png" style="display: block; margin: 0 auto;" id="qrCodeImage" onclick="javascript:dashboardToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');" />
     <hr>
       <h2 style="font-size: 22px;margin-top: 30px;margin-left:15px;">Please Select Below Details to Generate QR Code</h2>
      
      <div class="dropdown-container">
    <input id="zoneDropdown" name="zone" style="width: 400px; height: 40px;font-size: 15px;font-weight: 500" required data-error-msg="Please select a zone." />
</div>
<div class="dropdown-container">
    <input id="gardenDropdown" name="garden" style="width: 400px; height: 40px;font-size: 15px;font-weight: 500" required data-error-msg="Please select a garden." />
</div>

        <div class="btn-container">
            <button type="submit" class="submit-btn k-button" style="font-size: 13px;font-weight: 400" onclick="submitQrcode()">Submit</button> &nbsp;&nbsp;&nbsp;
            <button type="button" id="clearBtn" style="font-size: 13px;font-weight: 400" class="clear-btn k-button">Clear</button>
        </div>
    </div>
    </c:if>
    </div>
    <c:if test="${status==1}">
       <div id="container_33" class="container-fluid" >
    <h2>Do you have a QR Code Reader on your smartphone?</h2>
    <br>
    <h2>Scan this QR code to access more information.</h2>
<img src="<c:out value="${contextRoot}"/>/images/QrCode.png" style="display: block; margin: 0 auto;" id="qrCodeImage" onclick="javascript:dashboardToggleSearch('SearchTable','searchToggleImage','<c:out value="${contextRoot}"/>');" />
</div>

        
          <div class="btn-container">
                   
    <input type="button" class="btn btn-success" style="font-size: 13pt; width: 90px; margin-left: 100px;" id="print" name="print" value="Print" onclick="window.print()"/>
    <input type="button" class="btn btn-primary" style="font-size: 13pt; width: 90px; margin-left: 20px;" id="goBack" name="goBack" value="Go Back" onclick="generateQrCode()"/>
       </div>
    </c:if>
</form>
</body>

<script>
$(document).ready(function () {
    var zoneDropdown = $("#zoneDropdown").kendoDropDownList({
        dataSource: [
            { text: "Zone No.1 - Laxmi Nagar", value: "1" },
            { text: "Zone No.2 - Dharmpeth", value: "2" },
            { text: "Zone No.3 - Hanuman Nagar", value: "3" },
            { text: "Zone No.4 - Dhantoli", value: "4" },
            { text: "Zone No.5 - Nehru Nagar", value: "5" },
            { text: "Zone No.6 - Gandhibag", value: "6" },
            { text: "Zone No.7 - Satranjipura", value: "7" },
            { text: "Zone No.8 - Lakadganj", value: "8" },
            { text: "Zone No.9 - Aashi Nagar", value: "9" },
            { text: "Zone No.10 - Mangalwari", value: "10" }
        ],
        optionLabel: "Select Zone",
        filter: "contains",
        dataTextField: "text",
        dataValueField: "value",
        valuePrimitive: true,
        change: function(e) {
            var value = this.value();
            if (value === "1") {
                gardenDropdown.dataSource.filter({ 
                    logic: "or",
                    filters: [
                        { field: "value", operator: "eq", value: "1" },
                        { field: "value", operator: "eq", value: "2" }
                    ]
                });
            } else if (value === "2") {
                gardenDropdown.dataSource.filter({ 
                    logic: "or",
                    filters: [
                        { field: "value", operator: "eq", value: "3" },
                        { field: "value", operator: "eq", value: "4" }
                    ]
                });
            } else if (value === "3") {
                gardenDropdown.dataSource.filter({ 
                    logic: "or",
                    filters: [
                        { field: "value", operator: "eq", value: "5" },
                        { field: "value", operator: "eq", value: "6" }
                    ]
                });
            } else if (value === "4") {
                gardenDropdown.dataSource.filter({ 
                    logic: "or",
                    filters: [
                        { field: "value", operator: "eq", value: "7" },
                        { field: "value", operator: "eq", value: "8" }
                    ]
                });
            } else if (value === "5") {
                gardenDropdown.dataSource.filter({ 
                    logic: "or",
                    filters: [
                        { field: "value", operator: "eq", value: "9" },
                        { field: "value", operator: "eq", value: "10" }
                    ]
                });
            } else if (value === "6") {
                gardenDropdown.dataSource.filter({ 
                    logic: "or",
                    filters: [
                        { field: "value", operator: "eq", value: "10" },
                        { field: "value", operator: "eq", value: "12" }
                    ]
                });
            } else if (value === "7") {
                gardenDropdown.dataSource.filter({ 
                    logic: "or",
                    filters: [
                        { field: "value", operator: "eq", value: "13" },
                        { field: "value", operator: "eq", value: "14" }
                    ]
                });
            } else if (value === "8") {
                gardenDropdown.dataSource.filter({ 
                    logic: "or",
                    filters: [
                        { field: "value", operator: "eq", value: "15" },
                        { field: "value", operator: "eq", value: "16" }
                    ]
                });
            
            } else if (value === "9") {
                gardenDropdown.dataSource.filter({ 
                    logic: "or",
                    filters: [
                        { field: "value", operator: "eq", value: "17" },
                        { field: "value", operator: "eq", value: "18" }
                    ]
                });
            
            } else if (value === "10") {
                gardenDropdown.dataSource.filter({ 
                    logic: "or",
                    filters: [
                        { field: "value", operator: "eq", value: "19" },
                        { field: "value", operator: "eq", value: "20" }
                    ]
                });
            
            
            } else {
                gardenDropdown.dataSource.filter({});
            }
            gardenDropdown.value(""); 
            gardenDropdown.enable();
        }
    }).data("kendoDropDownList");

    var gardenDropdown = $("#gardenDropdown").kendoDropDownList({
        dataSource: [
            { text: "Bajaj Nagar Park", value: "1" },
            { text: "LIC colony, Surendra Nagar Park", value: "2" },
            { text: "Civil Office Park", value: "3" },
            { text: "Traffic Park", value: "4" },
            { text: "Mahatma Gandhi Park, Hanuman Nagar", value: "5" },
            { text: "Ramabai Ambedkar Park, Chandan Nagar", value: "6" },
            { text: "Balbhawan Park, Shubhas Road", value: "7" },
            { text: "Bhauji Panje Park", value: "8" },
            { text: "Tritabde Park, Old Nandanvan", value: "9" },
            { text: "Neharu Nagar Park, Near Zone Office", value: "10" },
            { text: "Old Bagadganj Par", value: "11" },
            { text: "Gandhibagh Park", value: "12" },
            { text: "Bhantinagar Housing Board Colony Park, Bhandti Nagar", value: "13" },
            { text: "Bhantinagar Park Old", value: "14" },
            { text: "Bharatmata & Dr. Babasaheb Ambedkar Park, Garoba Ground", value: "15" },
            { text: "Vaishno Devi Park", value: "16" },
            { text: "Kapil Nagar Park, Nari ring road", value: "17" },
            { text: "Ramabai Park, Nari ring road", value: "18" },
            { text: "Green Park, Rajnagar", value: "19" },
            { text: "Ganga Kaveri, Raj nagar park", value: "20" },
        ],
        optionLabel: "Select Garden",
        filter: "contains",
        dataTextField: "text",
        dataValueField: "value",
        valuePrimitive: true,
        enable: false 
    }).data("kendoDropDownList");
});

function submitQrcode() {
    var zone = $('#zoneDropdown').val();
    var garden =  $('#gardenDropdown').val();
    var flag;

    if (zone === '') {
        alert("Please select Zone!!");
        flag = false;
        return false;
    } else if (garden === '') {
        alert("Please select garden!!");
        flag = false;
        return true;
    } else {
        flag = true;
    }

    if (flag) {
    	onSubmit();
    }
}
function clearForm() {
    $("#zoneDropdown").data("kendoDropDownList").value('');
    $("#gardenDropdown").data("kendoDropDownList").value('');
}

$("#clearBtn").click(function() {
    clearForm();
});

$("#myForm").submit(function(e) {
    e.preventDefault();
});

function onSubmit(){
    onPageSubmit('<c:out value="${contextRoot}"/>/garden/saveGardernQrGenerator.do');

}

$('.printMe').on('click', function () {

    window.print();
});

function generateQrCode(){
	
    onPageSubmit('<c:out value="${contextRoot}"/>/ws/garden/generateGardenQrCode.do');

}

</script>


</html>
