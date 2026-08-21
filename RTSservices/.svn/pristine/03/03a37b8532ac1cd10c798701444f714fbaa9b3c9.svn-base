<jsp:directive.page import="com.mars.common.utils.Constants" />

<%
	pageContext.setAttribute("DATE_UI_FORMAT", "dd/mm/yy");
%>

<!-- Add DWR JS -->
<script src="<c:out value="${contextRoot}"/>/dwr/engine.js"></script>
<script src="<c:out value="${contextRoot}"/>/dwr/util.js"></script>
<script type="text/javascript"
	src="<c:out value="${contextRoot}"/>/dwr/interface/CommonServiceDWR.js"></script>

<!-- Add Jquery JS -->
<%-- <script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery-ui-1.8.2.custom.min.js"></script>

<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.uploadify.v2.1.0.min.js"></script>
<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/swfobject.js"></script>

<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.datepicker.css" />
<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/demos.css" />
<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.core.css" />
<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.theme.css" />
<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.tabs.css" />
<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.dialog.css" />
<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.autocomplete.css" />
 --%>
  <script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery-ui-1.8.2.custom.min.js"></script>

<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.core.css" />
<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.theme.css" />


<!-- Add Jquery JS -->
<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery-1.12.js"></script>
<%-- <script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery-ui-1.11.4.js"></script> --%>
<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery-ui-1.12.0.js"></script>

<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.uploadify.v2.1.0.min.js"></script>
<%-- <script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/swfobject.js"></script> --%>

<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.datepicker.css" />
<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/demos.css" />
<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/jquery-ui.theme.css" />
<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.tabs.css" />
<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.dialog.css" />
<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/jquery/ui.autocomplete.css" />



<style type="text/css">
	.ui-autocomplete-loading { background: white url('<c:out value="${contextRoot}"/>/styles/jquery/images/ui-anim_basic_16x16.gif') right center no-repeat; }
</style>

<script type="text/javascript">

$(function() {
	setContextRoot('<c:out value="${contextRoot}"/>');
	setDateFormat('${pageScope.DATE_UI_FORMAT}');	
	$("input.ClsTextboxDate").datepicker({
	showOn: 'button', 
	buttonImage: '<c:out value="${contextRoot}"/>/styles/jquery/images/calendar.gif', 
	buttonImageOnly: true,
	dateFormat: '<c:out value="${pageScope.DATE_UI_FORMAT}"/>',
	changeMonth: true,
	changeYear: true});
});

</script>