<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:directive.include file="/pages/common/include.jsp" />
<html>
	<head>
		<meta http-equiv="PRAGMA" content="NO-CACHE" />
		<meta name="FORMAT" content="text/html" />
		<meta name="CHARSET" content="ISO-8859-1" />
	<!--<link rel="stylesheet" type="text/css" href="<c:out value="${contextRoot}"/>/styles/styles.css" />-->
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/utils.js"></script>
		<script type="text/javascript" language="javascript" src="<c:out value="${contextRoot}"/>/scripts/PagePref.js"></script>
		<jsp:directive.include file="/pages/common/includeJS.jsp" />
	</head>
	<body onload="javascript:displayError('<c:out value="${message}"/>')" style="background-color: white;margin:0px 0px 0px 0p;padding:0px 0px 0px 0px">
		<div class="error" id="idErrorBox" style="display:none">
			<c:out value="${message}" />
		</div>
		<div>
			<form name="frmPage" method="post">
				<tiles:insertAttribute name="content" flush="true" />
			</form>
		</div>                                                                     
		<script>                    
			var strArray = document.getElementsByTagName('textarea');
			if(strArray){             
				for(i=0;i<strArray.length;i++){
					strArray[i].value = Trim(strArray[i].value);
			}
		}
		</script>
		<c:if test="${sessionScope.SessionUser==null}">
			<script type="text/javascript">
				if(parent.document.getElementById('divPopup'))
				{
					parent.hideDiv();
					parent.document.location.href="<c:out value="${contextRoot}"/>/login.do";
				}
			</script>
		</c:if>
	</body>
</html>
