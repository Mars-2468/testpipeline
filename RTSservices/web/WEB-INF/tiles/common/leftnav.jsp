<%@ include file="/pages/common/include.jsp"%>
<html lang="en">
	
 
<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Meta -->
		<meta name="description" content="e-Governance @AMC">
		<meta name="author" content="e-Governance @AMC">
<!--		<link rel="shortcut icon" href="img/fav.png" /> -->

		<!-- Title -->
		<title>e-Governance @NMC</title>


		<!-- *************
			************ Common Css Files *************
		************ -->
		<!-- Bootstrap css -->
		<link rel="stylesheet" href="<c:out value="${contextRoot}"/>/styles/dashboard/css/bootstrap.min.css">
		<!-- Icomoon Font Icons css -->
		<link rel="stylesheet" href="<c:out value="${contextRoot}"/>/styles/dashboard/fonts/style.css">
		<!-- Main css -->
		<link rel="stylesheet" href="<c:out value="${contextRoot}"/>/styles/dashboard/css/main.css">
		<!-- Chat css -->
		<link rel="stylesheet" href="<c:out value="${contextRoot}"/>/styles/dashboard/css/chat.css">

		<!-- *************
			************ Vendor Css Files *************
		************ -->
<!--		
<script type="text/javascript">
 $(function(){
         $('#menu ul li').hide();  
       //  $('#menu ul:first li').show();  
         $('#menu li a').click(function() {                              
                 $('#menu li a').removeClass("opened");  
                 $('#menu ul li').hide();  
                 $(this).next().children("li").slideDown();
                 $(this).addClass("opened");
                 
         }); 
         $('#menu #<c:out value="${requestScope.parentMenu}"/> li').show(); 
         $('#menu #<c:out value="${requestScope.parentMenu}"/> a:first').addClass("opened");
         $('#menu #<c:out value="${requestScope.selectedMenu}"/> a:first').addClass("selected-item");
         
         $('.dataGrid tbody tr:odd').css("background-color", "#f5f5f5");            
         $('.dataGrid tfoot tr').css("background-color", "#e6e6e6");

         $('.dataGrid tbody tr').hover(function(){
									             $(this).css("color","#f60");
									             $(this).find('a').css("color","#f60");
									             },
									function(){
								                 $(this).css("color","black");
								                 $(this).find('a').css("color","blue");
										      });
 });
</script>
-->
<style>

.main-container {
background-color: #f6f6f6;
}
.ui-datepicker {
    width: 0em;
    padding: .2em .2em 0;
}

#sidebar1 {
    height: 600px;
    width: 260px;
    overflow-x: hidden;
    overflow-y: auto;
    background-color: #f1f1f154;
    
}


.sidebar-content{
margin-right: 70px;
font-size: 15px;
}
.sidebar-menu{
font-size: 20px;


}
.page-wrapper .sidebar-wrapper .sidebar-menu ul li.active .sidebar-submenu {
    overflow-x: scroll;
}

.sidebar1{
font-size: 20px;
}
.sidebar-dropdown{
font-size: 100px;

}
.sidebar-submenu{
margin-right: 30px;
    background-size:100%;
    width:300px;
margin-left:10px;
}
.header
{
/* background-color:#678dc5; */
background-color:#678dc5;
}
.page-wrapper .sidebar-wrapper .sidebar-brand .logo
{
/* background-color:#678dc5;
 */
 background-color:#678dc5;
 
 }

::after{
margin-top:-4px;

}
.page-wrapper .sidebar-wrapper .sidebar-user-details {
    display: flex;
    justify-content: center;
    padding: 20px 5px 20px 5px;
    margin: 0 0 20px 0;
    flex-direction: column;
    align-items: center;
    background: none;
}
.page-wrapper .sidebar-wrapper .sidebar-menu .sidebar-dropdown .sidebar-submenu ul li a:before {
    font-family: "icomoon";
    font-weight: 700;
    content: "\e9d3";
    margin: 0 10px 0 0;
    font-size: .7rem;
    margin-left:25px;
}
.page-wrapper .sidebar-wrapper .sidebar-menu .active > a:before {
    content: '';
    position: absolute;
    right: -1px;
    top: 1px;
    background: url(../img/menu-arrow-white.svg);
    background-size: 100%;
    width: 20px;
    right:210px;
    height: 0px;
    display: inline-block;
    position: absolute;
    
}

.page-wrapper .sidebar-wrapper .sidebar-menu .sidebar-dropdown > a:after {
    font-family: "icomoon";
    font-weight: 100;
    font-size: 1rem;
    content: "\e911";
    display: inline-block;
    position: absolute;
   
    left:210px;
    top: 13px;
    -webkit-transition: -webkit-transform .3s ease;
    transition: -webkit-transform .3s ease;
    transition: transform .3s ease;
    transition: transform .3s ease, -webkit-transform .3s ease;
}
.icon-settings, .icon-home{
  margin-left:50px;
}
.menu-text{
margin-right:50px;

}

#user,#feemaster,#receivedMode,#workflowtemplate,#workflowtemplateusermapping,#corereports {
width:400px;
background-color;

}
li{
  padding-right:20px;
}
ul{
 margin-right:10px;
}
a{

 margin-left: 20px;
 
}

.page-wrapper .sidebar-wrapper .sidebar-menu .sidebar-dropdown .sidebar-submenu ul {
    padding: 0;
    background-color: #ffffff;
    
}
.page-wrapper .sidebar-wrapper .sidebar-menu .sidebar-dropdown .sidebar-submenu ul li a {
    overflow:hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
/*     padding: 11px 35px 11px 50px;
 */    font-size: .8rem;
    background-color: white;
    /* width:2000px; */
}
.page-wrapper .sidebar-wrapper .sidebar-menu .active > a {
    background: #678dc5 !important;
    color: #ffffff !important;
    position: relative;
}
.dataGrid thead {
    background: #678dc5;
    font-weight: bold;
    color: white;
}


.dataGrid tfoot {
      background: #678dc5;
    font-weight: bold;
    color: white;
}


.page-wrapper .sidebar-wrapper .sidebar-menu ul li a:hover {
    background:#f6f6f6;
    color: #678dc5;
}
.page-wrapper .sidebar-wrapper .sidebar-menu ul li a:hover i {
    color: #678dc5;
}
.page-wrapper .sidebar-wrapper .sidebar-menu ul li.active-page-link {
    position: relative;
}
.page-wrapper .sidebar-wrapper .sidebar-menu ul li.active-page-link a {
    background: #678dc5;
    color: #ffffff;
}
.page-wrapper .sidebar-wrapper .sidebar-menu ul li.active-page-link a i {
    color: #678dc5;
}

.page-wrapper .sidebar-wrapper .sidebar-menu ul li.active a.current-page {
    background: transparent !important;
    color: #678dc5;
}

.page-wrapper .sidebar-wrapper .sidebar-menu .active > a {
    background: #678dc5 !important;
    color: #ffffff !important;
    position: relative;
}
.icons span:hover {
    background-color: #678dc5;
    color: #ffffff;
}

.page-wrapper .sidebar-wrapper .sidebar-menu .sidebar-dropdown .sidebar-submenu ul li a:hover {
    background: #f6f6f6;
    color: #678dc5;
}
.header-actions .dropdown-menu {
    -webkit-border-radius: 0px 0px 0px 0px; 
    -moz-border-radius: 0px 0px 0px 0px;
    border-radius: 0px 0px 0px 0px; 
}
.header-profile-actions a {
    padding: 0.3rem;
    display: flex;
    align-items: center;
    font-size: .8rem;
    position: relative;
    text-decoration: none;
    margin-left: 10px;
}

header h1 {
    margin: 0px;
    text-align: center;
    text-transform: ;
    font-weight:100 !important;
    word-spacing: 0px;
    font-size: 3.8vw;
    color: floralwhite;
    font-family: 'Source Sans Pro', sans-serif;
}
.header .toggle-btns #pin-sidebar{

    background: white;
}
.header .toggle-btns #pin-sidebar:hover{
    background: rgb(78 103 194);
    }
    .header .toggle-btns #pin-sidebar i, .header .toggle-btns #toggle-sidebar i {
    font-size: 25px;
    font-weight: 600;
    color: rgb(78 103 194);


</style>
</head>

	<body>
	
		<!-- Page wrapper start -->
		<div class="page-wrapper">
			
			<!-- Sidebar wrapper start -->
			<nav id="sidebar" class="sidebar-wrapper" align="left">

				<!-- Sidebar brand start  -->
				<div class="sidebar-brand">
					<!-- <a href="index.html" class="logo">
						<img src="img/logo.png" alt="Logo" />
					</a> -->
					<!--  <img src="<c:out value="${contextRoot}"/>/styles/dashboard/img/amc_log.png" /> -->
					<h3 class="logo">NMC RTS</h3>
				</div>
				<!-- Sidebar brand end  -->
				
				<!-- User profile start -->
			
				<!-- User profile end -->

				<!-- Sidebar content start -->
			  <div class="sidebar-content">	
			   <div id="sidebar1">
                  <c:if test="${not empty sessionScope.leftNavigationContent}">
		         <c:out value="${sessionScope.leftNavigationContent}" escapeXml="false" />
                </c:if>
				</div>
              </div>
            </nav>
        </div>
		  
	<!-- Page wrapper end -->

		<!--**************************
			**************************
				**************************
							Required JavaScript Files
				**************************
			**************************
		**************************-->
		<!-- Required jQuery first, then Bootstrap Bundle JS -->
		<script src="<c:out value="${contextRoot}"/>/styles/dashboard/js/jquery.min.js"></script>
		<script src="<c:out value="${contextRoot}"/>/styles/dashboard/js/bootstrap.bundle.min.js"></script>
		<script src="<c:out value="${contextRoot}"/>/styles/dashboard/js/moment.js"></script>


		<!-- *************
			************ Vendor Js Files *************
		************* -->
		<!-- Slimscroll JS -->
		
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/styles/dashboard/vendor/slimscroll/slimscroll.min.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/styles/dashboard/vendor/slimscroll/custom-scrollbar.js"></script>
	

		<!-- Polyfill JS -->
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/styles/dashboard/vendor/polyfill/polyfill.min.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/styles/dashboard/vendor/polyfill/class-list.min.js"></script>

		<!-- Apex Charts -->
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/styles/dashboard/vendor/apex/apexcharts.min.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/styles/dashboard/vendor/apex/custom/home/lineRevenueGradientGraph.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/styles/dashboard/vendor/apex/custom/home/radialTasks.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/styles/dashboard/vendor/apex/custom/home/lineNewCustomersGradientGraph.js"></script>
		
		
		<!-- Peity Charts -->
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/styles/dashboard/vendor/peity/peity.min.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/styles/dashboard/vendor/peity/custom-peity.js"></script>
		
		<!-- Circleful Charts -->
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/styles/dashboard/vendor/circliful/circliful.min.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/styles/dashboard/vendor/circliful/circliful.custom.js"></script>
		
		<!-- Main JS -->
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/styles/dashboard/js/main.js"></script>
		
		<!-- Scripts -->
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/utils.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/dmsutilsBackup.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/dmsutils.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/utilsBackup.js"></script>
		
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/aes.js"></script>		
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/CryptoJS.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.ajaxfileupload.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.animate-shadow.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.ui.timepicker.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.uploadify.v2.1.0.min.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery-1.6.1.min.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery-1.12.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery-timepickerjs"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery-ui-1.8.2.custom.min.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery-ui-1.11.4.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery-ui-1.12.0.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/pbkdf2.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/swfobject.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/timePicker.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/uploadify.swf"></script>
		
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/swfupload/fileprogress.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/swfupload/handlers.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/swfupload/swfobject.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/swfupload/swfupload.cookies.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/swfupload/swfupload.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/swfupload/swfupload.proxy.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/swfupload/swfupload.queue.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/swfupload/swfupload.speed.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/swfupload/swfupload.swf"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/swfupload/swfupload.swfobject.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/swfupload/swfuploadbutton.swf"></script>
    </div>	
  
  </body> 
</html>	


