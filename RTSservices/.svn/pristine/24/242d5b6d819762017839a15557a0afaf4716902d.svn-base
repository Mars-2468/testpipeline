<html>
<head>

<%
	pageContext.setAttribute("contextRoot", request.getContextPath());
	pageContext.setAttribute("SERVER_BASE", "http://172.16.25.60:9090");
	//pageContext.setAttribute("SERVER_BASE", "http://119.226.93.115:9090");
%>
<script type="text/javascript" src="${contextRoot}/scripts/jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${SERVER_BASE}/igis/igis-ui/lib/js/embed.js"></script>
<link rel="stylesheet" href="${SERVER_BASE}/igis/igis-ui/lib/css/igis-theme/jquery-ui-1.8.10.custom.css" type="text/css" media="all" />

<script type="text/javascript">

//Globals
server_base = "${SERVER_BASE}/";
geoserver_base = server_base+"geoserver"; 

// Example declaration of proxy
 var proxyHostUrl = "${contextRoot}/gisProxy";
 
var cf = function(g){
  alert("Selected GIS ID ="+g);
  parent.jsGISId = g;
};

var gCallback = function(g){
	  parent.jsGISData = JSONstring.make(g);
	  alert("grievance data(parent.jsGISData): "+parent.jsGISData);
}

var servVal = "";
var obj = parent.document.getElementById('serviceMasterId');
if(obj != null) {
	var sIndex = obj.selectedIndex; 
	servVal = obj.options[sIndex].text.toLowerCase();
	if(servVal.indexOf('(') > 0)
		servVal = servVal.substring(servVal.indexOf('(')+1,servVal.length-1);
}

var wardElem = parent.document.getElementById('grievanceAddress.wardId');
var wardId = "";
if(wardElem != null)
	wardId=wardElem.value;

var nodeElem = parent.document.getElementById('grievanceAddress.nodeMasterId');
var nodeId = "";
if(nodeElem != null)
	nodeId=nodeElem.value;

var sectorElem = parent.document.getElementById('grievanceAddress.sectorId');
var sectorId = "";
if(sectorElem != null)
	sectorId=sectorElem.value;

var plotElem = parent.document.getElementById('grievanceAddress.plotId');
var plotId = "";
if(plotElem != null)
	plotId=plotElem.value;

var gid = "";
if(parent.document.getElementById('gisId') != null)
	gid = parent.document.getElementById('gisId').value; 

var gData = "";
if(parent.document.getElementById('gisData') != null)
	gData = parent.document.getElementById('gisData').value; 

//var opts = {"showMap": true, "callback": cf, "gCallback": gCallback,"guid" : gid,"grievance":gData,"service": servVal,"presets" : {"ward":wardId,"node":nodeId,"sector": sectorId,"plot":plotId}};
var opts= {
	    "showMap": true,
	    "callback": cf,
	    "gCallback": gCallback,
	    "guid" : gid,
	    "grievance": gData,
	    "service": servVal,
	    "presets" : {
	        "ward": wardId,
	        "node": nodeId,
	        "sector": sectorId,
	        "plot": plotId
	    }
	};

mapInit(opts);

</script>
</head>
<body>
<div id="ui" style="width:100%"></div>
</body>
</html>

