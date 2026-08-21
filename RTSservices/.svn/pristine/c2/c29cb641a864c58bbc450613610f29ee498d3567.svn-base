/****************************************** Variable Declarations ******************************************/
var dateSeparator = '/';
var dbDateSeparator = '-';
var contextRoot = '';
var jsdateFormat = '';
var currentDate = '';  

/************************************** Generic Functionality Functions **************************************/
/***
 *  Function: setContextRoot
 *  Arguments: String
 *  Return:
 *  Purpose: Sets Context Root.
***/
function setContextRoot(cr){
	contextRoot = cr;
}

function setCurrentDate(cd){
	currentDate = cd;
}

function getCurrentDate(){
	var curDateObject = null;
	var localCurrentDateStr = currentDate;
	
	date = localCurrentDateStr.substring(0,localCurrentDateStr.indexOf(dateSeparator));
	localCurrentDateStr = localCurrentDateStr.substring(localCurrentDateStr.indexOf(dateSeparator)+1);
	month = localCurrentDateStr.substring(0,localCurrentDateStr.indexOf(dateSeparator));
	year = localCurrentDateStr.substring(localCurrentDateStr.indexOf(dateSeparator)+1);

	curDateObject = new Date(year,month-1,date);

	return curDateObject;
}


/***
 *  Function: getContextRoot
 *  Arguments: String
 *  Return: String
 *  Purpose: Returns Context Root.
***/
function getContextRoot(){
	return contextRoot;
}

/***
 *  Function: setDateFormat
 *  Arguments: String
 *  Return:
 *  Purpose: Sets Date Format.
***/
function setDateFormat(df){
	jsdateFormat = df;
}

/***
 *  Function: getDateFormat
 *  Arguments: String
 *  Return: String
 *  Purpose: Returns Date Format.
***/
function getDateFormat(){
	return jsdateFormat;
}

/***
 *  Function: Trim
 *  Arguments: String
 *  Return: String
 *  Purpose: Removes empty spaces from left and right hand side of the string.
 *  		 Internally calls LTRIm and RTrim functions.
***/
function Trim(pString){
	return RTrim(LTrim(pString));
}

/***
 * Function: LTrim
 * Arguments: String
 * Return: String
 * Purpose: Function to remove empty spaces from left hand side of the string
***/
function LTrim(pString){
	var whitespace = new String(" \t\n\r");
    var oString = new String(pString);
    if (whitespace.indexOf(oString.charAt(0)) != -1){
		var jCount = 0;
		var iCount = oString.length;
		while (jCount < iCount && whitespace.indexOf(oString.charAt(jCount)) != -1)
		   jCount++;
		oString = oString.substring(jCount, iCount);
    }
    return oString;
}

/***
 * Function: RTrim
 * Arguments: String
 * Return: String
 * Purpose: Function to remove empty spaces to the right hand side of the string
***/
function RTrim(pString){
	var whitespace = new String(" \t\n\r");
    var oString = new String(pString);
    if (whitespace.indexOf(oString.charAt(oString.length-1)) != -1){
		var iCount = oString.length-1;
		while (iCount >= 0 && whitespace.indexOf(oString.charAt(iCount)) != -1)
		   iCount--;
		oString = oString.substring(0, iCount+1);
    }
    return oString;
}

/***
 * Function: truncateString
 * Arguments: Name of the control, Length of the field value to be restricted
 * Return: String
 * Purpose: This function truncates the value of a given string value to the restricted number and
 * 			sets the same back to the control before save.
***/
function truncateString( fieldName, truncateByLength ) {
	var fieldValue = document.frmPage[fieldName].value;
	if( fieldValue.length > truncateByLength ) {
		document.frmPage[fieldName].value = fieldValue.substring( 0, truncateByLength-1 );
	}
}

/***
 * Function: displayError
 * Arguments: String - Error message
 * Return:
 * Purpose: Sets the error message to a error DIV
***/
function displayError(psErrMsg){
	var objIdErrorBox;
	if(document.getElementById('idErrorBox')){
		objIdErrorBox = document.getElementById('idErrorBox');
	} else if(parent.document.getElementById('idErrorBox')) {
		objIdErrorBox = parent.document.getElementById('idErrorBox');
	}
	if(objIdErrorBox != null){
		objIdErrorBox.innerHTML="";
		if(psErrMsg != "") {
			if(document.getElementById('idErrorBox').style.display=='none')
				document.getElementById('idErrorBox').style.display='';
			objIdErrorBox.innerHTML="<div class=\"clsErrorInformation\">"+Trim(psErrMsg)+"</div>";
		}
	}
	if(psErrMsg != null && Trim(psErrMsg).length > 0)
		alert(psErrMsg);
}

/***
 * Function: showDiv
 * Arguments: element divId
 * Return:
 * Purpose:Displays Division.
***/
function showDiv(divId){
   var mydiv = document.getElementById(divId);
   if (mydiv != null){
	   //div found
	   mydiv.style.display="block";
   }
}

/***
 * Function: hideDiv
 * Arguments: element divId
 * Return:
 * Purpose: Hides display of Division.
***/
function hideDiv(divId){
   var mydiv = document.getElementById(divId);
   if (mydiv != null){
	   //div found
	   mydiv.style.display="none";
   }
}

/***
 * Function: onPageSubmit
 * Arguments: String Page Name
 * Return:
 * Purpose: Submits current page
***/
function onPageSubmit(pageName){
	var objForm = document.forms[0];
	objForm.action=pageName;
	objForm.submit();
}

/***
 * Function: navigate
 * Arguments: Form: form, String: Page Name
 * Return:
 * Purpose: Navigates to given page
***/
function navigate(form,pageName){
	//Checking the upload status of mandatory Docs in Document Check List
	//TODO Commenting out temporarily o help Developement.
	//if(	checkMandatoryDocs())
		onPageSubmit(pageName);
}

//This function is required here to check the mandatory Documents in Check list
function checkMandatoryDocs()
{
	var desc = document.getElementsByName("documentMasterDesc");
	var duid = document.getElementsByName("docDmsUuid");

	if(desc!=null && desc.length>0)
	{
		for(var i=0;i<desc.length;i++)
		{
			if(duid[i].value== 0){
				displayError("In Document CheckList '"+ desc[i].value+ "' is Mandatory.");
				return false;
			}
		}
	}
	return true;
}

/***
 * Function: clearContorls
 * Arguments:
 * Return:
 * Purpose: Navigates to given page
***/
function clearContorls(){
	document.forms[0].reset();
	displayError("");
	document.getElementById('idErrorBox').style.display='none';
}

/***
 * Function: Toggle
 * Arguments: Element: checkbox, Element Group Id: checkboxGroupId
 * Return:
 * Purpose: Checks or Unchecks all the check boxes
***/
function Toggle(checkbox, checkboxGroupId){
	checkboxGroupId = document.getElementById(checkboxGroupId);
	checkboxGroupId.checked = checkbox.checked?AllChecked(checkbox.name):false;
}

/***
 * Function: ToggleByName
 * Arguments: Element Name: childName, Element Group Id: checkboxGroupId,
 * Return:
 * Purpose: Checks or Unchecks all the check boxes
***/
function ToggleByName(childName, checkboxGroupId, checked){
	checkboxGroupId = document.getElementById(checkboxGroupId);
	checkboxGroupId.checked=checked?AllChecked(childName):false;
}

/***
 * Function: ToggleAll
 * Arguments: Element: checkbox, Child Id: childName,
 * Return:
 * Purpose: Checks or Unchecks all the check boxes
***/
function ToggleAll(checkbox, childName){
	if(checkbox.checked) CheckAll(checkbox, childName);
	else ClearAll(checkbox,childName);
}

/***
 * Function: CheckAll
 * Arguments: Element: checkbox, Child Id: childName
 * Return:
 * Purpose: Checks all the check boxes
***/
function CheckAll(checkbox, childName){
	for (var i = 0; i <document.frmPage.elements.length; i++){
    	var ele = document.frmPage.elements[i];
    	if (ele.name == childName)
			ele.checked=true;
	}
	checkbox.checked = true;
}

/***
 * Function: ClearAll
 * Arguments: Element: checkbox, Child Id: childName,
 * Return:
 * Purpose: Unchecks all the check boxes
***/
function ClearAll(checkbox, childName){
	for (var i = 0; i <document.frmPage.elements.length; i++){
	    var ele = document.frmPage.elements[i];
	    if (ele.name == childName)
			ele.checked=false;
	}
	checkbox.checked = false;
}

/***
 * Function: AllChecked
 * Arguments: Element name: name
 * Return: Boolean
 * Purpose: Verifies if all the check boxes are selected
***/
function AllChecked(name){
	ml = document.frmPage;
	for(var i = 0 ; i < document.frmPage.elements.length ; i++){
	    if (ml.elements[i].name == name && !ml.elements[i].checked)
			return false;
	}
	return true;
}

/***
 * Function: CheckAllById
 * Arguments: Element: checkbox, Child Id: childId
 * Return:
 * Purpose: Checks all the check boxes
***/
function CheckAllById(checkbox, childId){
	for (var i = 0; i <document.frmPage.elements.length; i++){
    	var ele = document.frmPage.elements[i];
    	if (ele.id == childId )	ele.checked=true;
	}
	checkbox.checked = true;
}

/***
 * Function: ClearAllById
 * Arguments: Element: checkbox, Child Id: childId
 * Return:
 * Purpose: Unchecks all the check boxes
***/
function ClearAllById(checkbox, childId){
	for (var i = 0; i <document.frmPage.elements.length; i++){
	    var ele = document.frmPage.elements[i];
	    if (ele.id == childId) ele.checked=false;
	}
	childId.checked = false;
}

/***
 * Function: AllCheckedById
 * Arguments: Element Id: id
 * Return: Boolean
 * Purpose: Verifies if all the check boxes are selected
***/
function AllCheckedById(id){
	ml = document.frmPage;
	for(var i = 0 ; i < document.frmPage.elements.length ; i++){
	    if (ml.elements[i].id == id && !ml.elements[i].checked)
			return false;
	}
	return true;
}

/***
 * Function: ToggleById
 * Arguments: Element Id: selfId, Element Group Id: parentId,
 * Return:
 * Purpose: Checks or Unchecks the check boxe
***/
function ToggleById(selfId, parentId){
	var parent = document.getElementById(parentId);
	var ele = document.getElementById(selfId);
	parent.checked=ele.checked?AllCheckedById(ele.id):false;
}

/***
 * Function: ToggleAllById
 * Arguments: Element Id: selfId, Child Id: childId,
 * Return:
 * Purpose: Checks or Unchecks all the check boxes
***/
function ToggleAllById(selfId, childId){
	var ele = document.getElementById(selfId);
	if(ele.checked) CheckAllById(ele, childId);
	else ClearAllById(ele, childId);
}

/***
 * Function: resort
 * Arguments:
 * Return:
 * Purpose: Sort entries in list page
***/
function resort(id){
	var strSortby = document.frmPage.SortBy.value;
	var strOrderby = document.frmPage.OrderBy.value;

	if(strOrderby==id){
		if(strSortby=="desc"){
			document.frmPage.SortBy.value="asc";
		}else{
			document.frmPage.SortBy.value="desc";
		}
	}else{
		document.frmPage.SortBy.value="asc";
	}
	document.frmPage.OrderBy.value=id;
	document.frmPage.submit();
}

/***
 * Function: resortDate
 * Arguments:
 * Return:
 * Purpose: Sort Date entries in list page
***/
function resortDate(id){
	var strSortby = document.frmPage.SortBy.value;
	var strOrderby = document.frmPage.OrderBy.value;

	if(strOrderby==id || strOrderby=="to_date("+id+",'dd-mm-yyyy')"){
		if(strSortby=="desc"){
			document.frmPage.SortBy.value="asc";
		}else{
			document.frmPage.SortBy.value="desc";
		}
	}else{
		document.frmPage.SortBy.value="asc";
	}
	document.frmPage.OrderBy.value="to_date("+id+",'dd-mm-yyyy')";
	document.frmPage.submit();
}

/***
 * Function: doLoginOnEnterClick
 * Arguments:
 * Return:
 * Purpose: Allows User Login on enter key
***/
function doLoginOnEnterClick(e){
	var key;
	if(window.event)
          key = window.event.keyCode;     //IE
     else
          key = e.which;     //firefox

    if (key == 13){
        //Get the button the user wants to have clicked
        var btn = document.getElementById('login');
        if (btn != null){ //If we find the button click it
            btn.click();
            e.keyCode = 0
        }
    }
}

/***
 * Function: doSaveOnEnterClick
 * Arguments:
 * Return:
 * Purpose: Allows User Save on enter key
***/
function doSaveOnEnterClick(e){
	var key;
	if(window.event)
          key = window.event.keyCode;     //IE
     else
          key = e.which;     //firefox

    if (key == 13){
        //Get the button the user wants to have clicked
        var btn = document.getElementById('save');
        if (btn != null){ //If we find the button click it
            btn.click();
            event.keyCode = 0
        }
    }
}

/***
 * Function: disableAllControls
 * Arguments:
 * Return:
 * Purpose: Disables all controls in a page except Help
***/
function disableAllControls(){
	var objArray = document.frmPage.elements;
	for(i=0;i<objArray.length;i++){
		objArray[i].disabled=true;
	}

	//Making help Text enable
	if(document.getElementById('helpFieldSet') != null)
		document.getElementById('helpFieldSet').disabled=false;
}

/***
 * Function: disableAllControlsInTable
 * Arguments: table Id
 * Purpose: Disables all controls in a specified table.
***/
function disableAllControlsInTable(tabId, status){
	var table = document.getElementById(tabId);
	var len = table.rows.length;
	var itemval;
	if (navigator.appName == "Microsoft Internet Explorer")
		itemval=0; // IE
	else
		itemval=1; // Firefox

	for(var rowno=0;rowno<len;rowno++){
		for (var i=0;i<=table.rows[rowno].cells.length;i++){
			if(table.rows[rowno].cells[i] != null){
				var elemSize = table.rows[rowno].cells[i].childNodes.length;
				for (var j=itemval; j<elemSize; j++){
					var objElement = table.rows[rowno].cells[i].childNodes.item(j);
					if(objElement.type == "text" || objElement.type == "select-one" ||
							objElement.type == "radio"	|| objElement.type == "_moz" ||
							objElement.type == "textarea" || objElement.type == "checkbox" ||
							objElement.type == "option" ){
						objElement.disabled = status;
					}
				}
			}
		}
	}
}

/***
 * Function: enableAllControls
 * Arguments: table Id
 * Purpose: Enables all controls in a page.
***/
function enableAllControls(){
	var objArray = document.frmPage.elements;
	for(i=0;i<objArray.length;i++){
		objArray[i].disabled=false;
	}
}

/***
 * Function: confirmDelete
 * Return:
 * Purpose: Confirms before Deletion of a record
***/
function confirmDelete(){
	if(confirm(" Do you really want to delete this record ? ")){
		return true;
	}else{
		return false;
	}
}

/***
 * Function: disableButtons
 * Arguments: form name
 * Return: true/false
 * Purpose: Disables all the buttons in a form
***/
function disableButtons(frm) {
	eleLen = document.forms[0].elements.length;
	for(i=0; i<eleLen; i++){
		var element = document.forms[0].elements[i];
		if(element.type=='button' || element.type=='submit')
			element.disabled =true;
	}
}

/***
 * Function: clearSearchFields
 * Arguments: array of elements to be cleared
 * Return: true/false
 * Purpose: This function clears all the given search fields.
***/
function clearSearchFields(fieldsArray) {
	for(var i=0; i<fieldsArray.length; i++) {
		document.getElementById(fieldsArray[i]).value = "";
	}
}

/***
 * Function: clearFields
 * Arguments: table-id
 * Return:
 * Purpose: Clears all the data from the text-box and select-box fields under the given table.
***/
function clearFields(tableId) {
	var tableBody = document.getElementById(tableId).tBodies[0];
	var trChild = null;
	var tdChild = null;
	var element = null;

	for(var i=0; i<tableBody.childNodes.length; i++) {
		trChild = tableBody.childNodes[i];
		for(var j=0; j<trChild.childNodes.length; j++) {
			tdChild =  trChild.childNodes[j];

			for(k=0; k<tdChild.childNodes.length; k++) {
				element = tdChild.childNodes[k];

				if(element.type == "text" || element.nodeName == "SELECT" || element.type == "textarea") {
					element.value = "";
				}
			}
		}
	}
	displayError("");
	document.getElementById('idErrorBox').style.display='none';
}

/***
 * Function: ToggleSearch
 * Arguments: Search Table Id, Image, application context
 * Return:
 * Purpose: Toggles search table display. Opens and Close table.
***/
function ToggleSearch(searchTable,searchToggleImage,applicatinContext){
	if(document.getElementById(searchTable).style.display=='none'){
		document.getElementById(searchTable).style.display='';
		document.getElementById(searchToggleImage).src=applicatinContext+"/images/open.gif";
	} else {
		document.getElementById(searchTable).style.display='none';
		document.getElementById(searchToggleImage).src=applicatinContext+"/images/closed.gif";
	}
}

/***
 * Function: disableEnterKey
 * Arguments: Event
 * Return:
 * Purpose: Disables keyboard's enter key. For Firefox.
***/
function disableEnterKey(e){
	var key;
	if(window.event)
		key = window.event.keyCode; //IE
	else
		key = e.which; //firefox

	if(key == 13)
		return false;
	else
		return true;
}

/***
 * Function: disableEnterKeyForTextBox
 * Arguments: Event
 * Return:
 * Purpose: Disables keyboard's enter key for Textbox.
***/
function disableEnterKeyForTextBox(){
	var strControlArray = document.getElementsByTagName('input');
	var strTexBoxArray = new Array();
	for(i=0;i<strControlArray.length;i++){
		if(strControlArray[i].type=='text'){
			strTexBoxArray[strTexBoxArray.length]=strControlArray[i];
		}
	}

	//Enabling enter click for List page with single text box and whose name is "currentPage".
	//Doing check based on text box name
	if(strTexBoxArray.length==1 && strTexBoxArray[0].name != 'currentPage'){
	  if (navigator.appName == "Microsoft Internet Explorer"){
		  strTexBoxArray[0].onkeypress=function(){return disableEnterKey(window.event)};
	  }else{
		  strTexBoxArray[0].setAttribute('onkeypress','javascript:return disableEnterKey(event)');
	  }
	}
}

/***
 * Function: changeImage
 * Arguments: applicatinContext, imgId
 * Return:
 * Purpose: Changes images.
***/
function changeImage(applicatinContext, imgId) {
	var openImg = new Image();
	openImg.src = applicatinContext+"/images/open.gif";
	var closedImg = new Image();
	closedImg.src = applicatinContext+"/images/closed.gif";

	objImg = document.getElementById(imgId);
	if(objImg.src.indexOf('closed.gif')>-1)
		objImg.src = openImg.src;
	else
		objImg.src = closedImg.src;

}

/***
 * Function: insert_image
 * Arguments: applicatinContext
 * Return:
 * Purpose: Changes images.
***/
function insert_image(applicatinContext){
	var strSortby = document.frmPage.SortBy.value;
	var strOrderby = document.frmPage.OrderBy.value;

	if(strOrderby==""){
		if(document.getElementById('name')){
			var objName = document.getElementById('name');
			var strContent = objName.innerHTML;
			var strImage = 	"&nbsp;<img src=\""+applicatinContext+"/images/Ico_DownArrow.gif\"/>";
			strContent = strContent+strImage;
			objName = strContent;
		}
	}else{
		if(document.getElementById(strOrderby))	{
			var objOrderBy = document.getElementById(strOrderby);
			if(objOrderBy.type!='hidden'){
				var strContent = objOrderBy.innerHTML;
				var strImage="";
				if(strSortby=="asc"){
					strImage = 	"&nbsp;<img src=\""+applicatinContext+"/images/Ico_UpArrow.gif\"/>";
				}else{
					strImage = 	"&nbsp;<img src=\""+applicatinContext+"/images/Ico_DownArrow.gif\"/>";
				}
				strContent= strContent+strImage;
				objOrderBy.innerHTML = strImage;
			}
		}
	}
}

/***
 * Function: DaysInMonth
 * Arguments:year ,month
 * Return:
 * Purpose: This function is used while calculating difference in dates
***/
function DaysInMonth(year, month) {
    with (new Date(year, month, 1, 12)) {
        setDate(0);
        return getDate();
    }
}

/***
 * Function: dateDifference
 * Arguments: date1, date2
 * Return:
 * Purpose: This function is used in calculated differences in dates
***/
function dateDifference(date1, date2) {
    var year1 = date1.getFullYear(), month1 = date1.getMonth(), dt1 = date1.getDate(),
 	 year2 = date2.getFullYear(), month2 = date2.getMonth(), dt2 = date2.getDate();

     if (dt1 < dt2) {
    	 month1--;
         dt1 += DaysInMonth(year2, month2);
     }
     if (month1 < month2) {
    	 year1--;
         month1 += 12;
     }
     return [year1 - year2, month1 - month2, dt1 - dt2];
}

/***
 * Function: roundNumber
 * Arguments: number, decimal places to rounded
 * Return: Integer
 * Purpose: Function to round a Number
***/
function roundNumber(num, dec) {
	return Math.round(num*Math.pow(10,dec))/Math.pow(10,dec);
}

/***
 * Function: getSelectedValue
 * Arguments: Element Name: pName
 * Return: String
 * Purpose: Returns value of Element given.
***/
function getSelectedValue(pName){
	var sValue="";
	var objFormElement = document.frmPage[pName];

	if(objFormElement!= null && objFormElement!= "") {
		if(isNaN(objFormElement.length))
		{
			if(objFormElement.checked)
			{
				sValue = objFormElement.value;
				return sValue;
			}
		}else{
			if(objFormElement.item(0).type=="checkbox"){
				for(var i=0;i<objFormElement.length;i++){
					if(objFormElement[i].checked){
						if(sValue == "") sValue = objFormElement[i].value;
						else sValue = sValue + "," + objFormElement[i].value;
					}
				}
				return sValue;
			}else if(objFormElement.item(0).type=="radio"){
				for(var i=0;i<objFormElement.length;i++){
					if(objFormElement[i].checked){
						return objFormElement[i].value
					}
				}
			}
		}
	}
	return sValue;
}

/***
 * Function: getSelectedValue
 * Arguments: Element Name: pName
 * Return: String
 * Purpose: Returns unselected Element(Checkbox) value.
***/
function getUnselectedValue(pName){
	var sValue="";
	var objFormElement = document.frmPage[pName];

	if(isNaN(objFormElement.length) && !objFormElement.checked){
			return objFormElement.value;
	}else{
		if(objFormElement.item(0).type == "checkbox"){
			for(var i=0;i<objFormElement.length;i++){
				if(!objFormElement[i].checked){
					if(sValue == "") sValue = objFormElement[i].value;
					else sValue = sValue + "," + objFormElement[i].value;
				}
			}
			return sValue;
		}
	}
	return sValue;
}

/***
 * Function: removeAllOptions
 * Arguments: selectBox
 * Purpose: Function to remove All Options of selectbox
***/
function removeAllOptions(selectbox){
	while (selectbox.hasChildNodes()) {
		selectbox.removeChild(selectbox.firstChild);
	}
	var defoptn = document.createElement("OPTION");
	defoptn.text = "<-- Select -->";
	defoptn.value = "";
	selectbox.appendChild(defoptn);
}

function removeAllOptions_mr(selectbox,msg_mr){
	while (selectbox.hasChildNodes()) {
		selectbox.removeChild(selectbox.firstChild);
	}
	var defoptn = document.createElement("OPTION");
	defoptn.text = msg_mr;
	defoptn.value = "";
	selectbox.appendChild(defoptn);
}

/***
 * Function: showChildren
 * Arguments: branchId
 * Purpose: Displays or hides children under Tree Control Based on branch selected.
***/
function showChildren(branchId) {
  var objBranch = document.getElementById(branchId).style;

  if(objBranch.display=="block") objBranch.display="none";
  else objBranch.display="block";
}

/***
 * Function: hasOptions
 * Arguments: List box object: obj
 * Return:
 * Purpose:  Checks if a drop-down has values.
***/
function hasOptions(obj) {
	if(obj.options.length==1){
		if(obj.options[0].value=="") return false;
		else return true;
	}else{
		return true;
	}
}//end of function

/*****************************************************
Function: convertDateArrayToUIFormat
Arguments: dateArray
Return: dateArray
Purpose:This is function used to convert date to "dd/mm/yyyy" format.
Notes:
*****************************************************/
function convertDateArrayToUIFormat(dateArray){
	for(var i=0;i<dateArray.length;i++){
	val =Trim(document.getElementById(dateArray[i]).value);
	if(val != null && val.length > 0)
		document.getElementById(dateArray[i]).value = val.replace('-','/').replace('-','/');
	}
}

/***
 * Function: convertDateArrayToDBFormat
 * Arguments: dateArray
 * Return: dateArray
 * Purpose:This is function used to convert date to "dd-mm-yyyy" format.
***/
function convertDateArrayToDBFormat(dateArray){
	for(var i=0;i<dateArray.length;i++){
	val =Trim(document.getElementById(dateArray[i]).value);
	if(val != null && val.length > 0)
		document.getElementById(dateArray[i]).value = val.replace('/','-').replace('/','-');
	}
}

/***
 * Function: convertSearchDate
 * Arguments: dateArray
 * Return: dateArray
 * Purpose:This is function used to convert date to "dd-mm-yyyy" format.
***/
function convertSearchDate(){
	var eleArr = document.getElementById('SearchDivId').getElementsByTagName('input')
	for(var i=0;i<eleArr.length;i++){
		var eleValue = eleArr[i].value;
		if(eleArr[i].type == 'text' && eleValue.length == 10)
		{
			if(eleValue.indexOf('/')==2 && eleValue.indexOf('/',3)==5)
			{
				document.getElementById(eleArr[i].id).value = eleValue.replace('/','-').replace('/','-');
			}
		}
	}
}

/************************************************ VALIDATIONS  ************************************************/
/************************************** Generic Validation Functions **************************************/
/***
 * Function: isValid
 * Arguments: element:parm, validation value:val, Error Message:pMsg
 * Return: true/false
 * Purpose:This is a generic function used to check whether the given element value is within the limits of
 * 			the validation value & returns false if it violates the validation value.
***/
function isValid(parm,val,pMsg) {
	if (parm.length==0) return true;
	for (var i=0; i<parm.length; i++) {
		if (val.indexOf(parm.charAt(i),0) == -1) {
			displayError(pMsg);
			return false;
		}
	}
	return true;
}

/***
 * Function: checkRadio
 * Arguments: Element Name: rbGroupName, Element Label: pMsg
 * Return: true/false
 * Purpose: Checks whether the given radio button is selected or not.
***/
function checkRadio(rbGroupName, pMsg) {

	var radios = document.getElementsByName(rbGroupName);
	 for (var i=0; i<radios.length; i++) {
		 if (radios[i].checked) return true;
	 }
	 displayError("Please select a "+pMsg+".");
	 return false;
}

/***
 * Function: checkDropDown
 * Arguments: Array of Element Ids: objArray, Array of Element Labels: pMsgArray
 * Return: true/false
 * Purpose: Checks whether the given dropdown is selected or not.
***/
function checkDropDown(objArray, pMsgArray){
	var StrName= null;
	for(var i=0;i<objArray.length;i++){
		StrName = Trim(document.getElementById(objArray[i]));
		if(StrName == null || StrName.length == 0){
			displayError("Please select a "+pMsgArray[i]+".");
			return false;
		}
	}
	return true;
}

/***
 * Function: checkMandatoryDetailed
 * Arguments: Array of element Ids:objArray, Array of Element Labels: objArrayNames
 * Return: Boolean
 * Purpose: Checks for all mandatory fields in the form.
***/
function checkMandatoryDetailed(objArray, objArrayNames){
	for(var i=0;i<objArray.length;i++){
		var strContent = document.getElementById(objArray[i]);
		var strContentValue = Trim(strContent.value);
		if(!isNotEmpty(strContentValue)){
			if(objArrayNames[i] != null && objArrayNames.length > 0)
				displayError(objArrayNames[i]+ " is Mandatory.");
			return false;
		}else{
			strContent.value = strContentValue;
		}
	}
	return true;
}

/*****************************************************
Function: checkMandatoryMsg
Arguments: arralist of mandatory elements, string - error message
Return: String
Purpose: Function checks for all mandatory fileds in the form and return true if all are valid otherwise displays error message
Notes:
*****************************************************/
function checkMandatoryMsg(objArray,strMandatoryMessage)
{
	for(var i=0;i<objArray.length;i++)
	{
		var strContent = document.getElementById(objArray[i]);
		var strContentValue = Trim(strContent.value);
		if(!isEmpty(strContentValue))
		{
			if(strMandatoryMessage != null && strMandatoryMessage.length > 0)
				displayError(strMandatoryMessage);
			return false;
		}
		else
		{
			strContent.value = strContentValue;
		}
	}
	return true;
}


/*****************************************************
Function: isEmpty
Arguments: String
Return: Boolean
Purpose: Function to check if the string is empty or contains space as first character
Notes: This Function only works for IE and any other browsers
*****************************************************/
function isEmpty(StrName)
{
	StrName = Trim(StrName);

	if(StrName == null || StrName.length == 0){
		return false;
	}
	//check for space as first char
	var  c = StrName.charAt(0) ;
	if (c==" "){
		return false ;
	}
		return true;
}

function isEmptyWithMsg(obj,pMsg)
{
	var Str = document.getElementById(obj);
	var StrName = Trim(Str.value);
	if(StrName == null || StrName.length == 0){
		displayError(pMsg);
		 return false;
	}
	//check for space as first char
	var  c = StrName.charAt(0) ;
	if (c==" "){
		displayError(pMsg);
		return false;
		}
		return true;
}

/***
 * Function: appearOnceInArray
 * Arguments: Array of Elements: arr , Value to check with: val
 * Return: true/false
 * Purpose: Checks whether the given value is appearing only once in the given array.
***/
function appearOnceInArray(arr,val) {
    var cnt = 0;
	for(i=0;i<a.length;i++){
		if(arr[i] == val) cnt = cnt +1;
		 if(cnt > 1) return false;
	}
	return true;
}

/***
 * Function: appearOnceInNamedElements
 * Arguments: Element Name: elename , Value to check with: val
 * Return: true/false
 * Purpose: Checks whether the given value is appearing only once in the given Array of named values.
***/
function appearOnceInNamedElements(elename,val) {
    var cnt = 0;
	var arr = document.getElementsByName(elename)
	for(i=0;i<arr.length;i++){
		if(arr[i].value == val) cnt = cnt +1;
		if(cnt > 1) return false;
	}
	return true;
}

/***
 * Function: checkAgeLimit
 * Arguments: Element Name: ageLimitField , Age to check with: minAge, maxAge
 * Return: true/false
 * Purpose: Checks whether the given value is appearing only once in the given Array of named values.
***/
function checkAgeLimit(ageLimitField, minAge, maxAge){
	var age = document.getElementById(ageLimitField).value-0;
	if( age < Math.round(minAge) || age > Math.round(maxAge)){
		displayError('Age Limit must be between ' + minAge + ' and ' + maxAge);
		return false;
	}
	return true;
}

/************************************** String Validation Functions **************************************/
/***
 * Function: isEmpty
 * Arguments: String
 * Return: Boolean
 * Purpose: Checks if given string is empty.
***/
function isNotEmpty(StrName){
	var strNameVal = Trim(StrName);
	return (!(strNameVal == null || strNameVal.length == 0));
}

/***
 * Function: isNotEmptyWithMsg
 * Arguments: Element Id: objId, Element Label: pMsg
 * Return: Boolean
 * Purpose: Checks if given string is empty.
***/
function isNotEmptyWithMsg(objId, pMsg){
	var StrName = Trim(document.getElementById(objId));

	if(!isNotEmpty(StrName)){
		displayError(pMsg);
		 return false;
	}
	return true;
}

/***
 * Function: isLower
 * Arguments: Element Id-parm, Element Label-pMsg
 * Return: true/false
 * Purpose:Checks whether the given element is in alphabetic lowercase or not.
***/
function isLower(parm,pMsg) {
	var lowerCaseRegEx = /[^a-z ]/g;
	var val =Trim(document.getElementById(parm).value);
	if (lowerCaseRegEx.test(val)){
		displayError(" Invalid " + pMsg + ". Valid " + pMsg + " contains only Lower case Alphabets (a-z).");
		return false;
	}
	return true;
}

/***
 * Function: isUpper
 * Arguments: Element Id-parm, Element Label-pMsg
 * Return: true/false
 * Purpose: Checks whether the given element is in alphabetic uppercase or not.
***/
function isUpper(parm,pMsg){
	var lowerCaseRegEx = /[^A-Z ]/g;
	var val =Trim(document.getElementById(parm).value);
	if (lowerCaseRegEx.test(val)){
		displayError(" Invalid " + pMsg + ". Valid " + pMsg + " contains only Upper case Alphabets (A-Z).");
		return false;
	}
	return true;
}

/**
 * Function: isAlpha
 * Arguments: Element Id:parm, Element Label:pMsg
 * Return: true/false
 * Purpose: Checks whether the given element is alpha or not. Accepts only space other than Alphabets.
***/

function isAlpha(parm,pMsg){
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar=' '+'_-/,.()[]&@\'';
	var val =Trim(document.getElementById(parm).value);
	return isValid(val,lwr+upr+spChar," Invalid " + pMsg + ". Valid " + pMsg + " contains only Alphabets (a-z)(A-Z), Special Characters "+spChar+" and Spaces.");
}

function isAlphaSpaceSlash(parm,pMsg){
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar=' '+'*/';
	var val =Trim(document.getElementById(parm).value);
	return isValid(val,lwr+upr+spChar," Invalid " + pMsg + ". Valid " + pMsg + " contains only Alphabets (a-z)(A-Z), Special Characters "+spChar+" and Spaces.");
}


function isAlphaUndrsc(parm,pMsg){
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar=' '+'_';
	var val =Trim(document.getElementById(parm).value);
	return isValid(val,lwr+upr+spChar," Invalid " + pMsg + ". Valid " + pMsg + " contains only Alphabets (a-z)(A-Z), Special Characters "+spChar+" and Spaces.");
}

function isAlphaSpace(parm,pMsg){
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar=' '+'-';
	var val =Trim(document.getElementById(parm).value);
	return isValid(val,lwr+upr+spChar," Invalid " + pMsg + ". Valid " + pMsg + " contains only Alphabets (a-z)(A-Z), Special Characters "+spChar+" and Spaces.");
}



function isAlphaSpaceOnly(parm,pMsg){
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar=' ';
	var val =Trim(document.getElementById(parm).value);
	return isValid(val,lwr+upr+spChar," Invalid " + pMsg + ". Valid " + pMsg + " contains only Alphabets (a-z)(A-Z) and Spaces.");
}

/**
 * Function: isAlphaAray
 * Arguments: Element Id's array: objArray, Element Label's Array:pMsgArray
 * Return: true/false
 * Purpose: Checks whether the given array of elements are alpha or not. Accepts only space other than Alphabets.
***/
function isAlphaAray(objArray,pMsgArray){
	for(var i=0;i<objArray.length;i++){
		if(!isAlpha(objArray[i], pMsgArray[i])){
			return false;
		}
	}
	return true;
}

/***
 * Function: isAlphanum
 * Arguments: Array of Element Ids: objArray, Array of Element Labels:pMsgArray
 * Return: true/false
 * Purpose:Checks whether the given array of elements are alphaNumeric or not. Validates each element in loop.
***/
function isAlphanum(objArray,pMsgArray){
	var numb = '0123456789';
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar=' '+'_-/,.()[]&@\'';
	var str = lwr+upr+numb+spChar;
	var val=null;
	for(var i=0;i<objArray.length;i++){
		val =Trim(document.getElementById(objArray[i]).value);
		if(!isValid(val,str," Invalid " + pMsgArray[i] + ". Valid " + pMsgArray[i] + " contains only Alphabets (a-z)(A-Z), Numbers (0-9), Special Characters "+spChar+" and Spaces."))
			return false;
	}

	return true;
}

/**
 * @param date
 * @return
 */
function getAge(date){
	var val = document.getElementById(date).value;
	var dob = val.split("/");

	if(dob!=null && dob.length<2)
		dob = val.split("-");
	var bday=parseInt(dob[0]);
	var bmo=(parseInt(dob[1]-1));
	var byr=parseInt(dob[2]);
	var byear;
	  var now = getCurrentDate();
	  tday=now.getDate();
	  tmo=(now.getMonth());
	  tyr=(now.getFullYear());

	  if((tmo > bmo)||(tmo==bmo & tday>=bday))
	  {byear=byr}
	  else
	  {byear=byr+1}
	  var age= (parseInt(tyr)-parseInt(byear));
	  return parseInt(age);
}

/**
 * @param date
 * @param validAge
 * @param msg
 * @return
 */
function isValidAge(date,validAge,msg){
	var age=getAge(date);
	if(!(age >= validAge)){
		displayError("Invalid "+msg+" Age, "+msg+" Age must be greater than or equal to "+validAge+".");
		return false;
	}
	return true;
}

/***
 * Function: isAlphaSpecial
 * Arguments: Array of element Ids: objArray, Array of element msgs :pMsgArray, String: splChars
 * Return: true/false
 * Purpose:Checks whether the given array of elements contains aplanumeric and given special characters.
 * 			Validates each element in loop.
***/
function isAlphaSpecial(objArray, pMsgArray, splChars) {
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var str = lwr+upr+ Trim(splChars);
	var val = null;

	for(var i=0;i<objArray.length;i++) {
		val =Trim(document.getElementById(objArray[i]).value);
		if(!isValid(val, str, " Invalid " + pMsgArray[i] + ". Valid " + pMsgArray[i] + " contains only Alphabets (a-z)(A-Z), Special Characters "+splChars+" and Spaces.")) {
			return false;
		}
	}
	return true;
}


/***
 * Function: isAlphaNumericSpecial
 * Arguments: Array of Elements: objArray, Array of Element Label: pMsgArray, String: splChars
 * Return: true/false
 * Purpose: Checks whether the given element is alphaNumeric or contains the only specified special characters.the element.
***/
function isAlphaNumericSpecial(objArray,pMsgArray,splChars){
	var numb = '0123456789';
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar = Trim(splChars);
	var str = lwr+upr+numb+' '+spChar;
	var val=null;
	for(var i=0;i<objArray.length;i++){
		val =Trim(document.getElementById(objArray[i]).value);
		if(!isValid(val,str," Invalid " + pMsgArray[i] + ". Valid " + pMsgArray[i] + " contains only Alphabets (a-z)(A-Z), Numbers (0-9) and Special Characters (" +spChar+ ").")){
			return false;
		}
	}
	return true;
}


function isNumeric(StrName)
{
var letter = "0123456789";
// var i ;
for(var i = 0 ; i < StrName.length ; i++)
{
var Char = StrName.charAt(i) ;
if (letter.indexOf(Char) == -1)
{
return false ;
}
}
return true ;
}


/***
 * Function: isValidEmail
 * Arguments: String: psEmail, Error Label: errMsg
 * Return: Boolean
 * Purpose: Validates email address entered.
***/
function isValidEmail(psEmail,errMsg){
	psEmail = Trim(psEmail);
	var regExp = /^[a-zA-Z0-9]+[.a-zA-Z0-9_-]+@[a-zA-Z0_.-]+\.[a-zA-Z]+$/;
	var regExp1 = /^[a-zA-Z]+@[a-zA-Z0_.-]+\.[a-zA-Z]+$/;
	var temp = new String(psEmail);
	if(isNotEmpty(psEmail)){
		if((regExp.test(psEmail)) || (regExp1.test(psEmail))){
			if((temp.charAt(temp.length-1)!='.') && (!isNumeric(temp.charAt(temp.length-1)))){
				return true;
			}else{
				displayError("Invalid "+errMsg+". Please Enter Valid Email Id.");
				return false;
			}
		}else{
			displayError("Invalid "+errMsg+". Please Enter Valid Email Id.");
		    return false;
		}
	}
	return true;
}

/***
 * Function: checkTextAreaMaxlength
 * Arguments: Array of Elements: objArray, Array of Integer: maxLenArray, Array of Element Labels: pMsgArray
 * Return: true/false
 * Purpose: Checks whether the length of value in textarea is less than maxLen given.
***/
function checkTextAreaMaxlength(objArray, maxLenArray, pMsgArray){
	for(var i=0; i<objArray.length; i++){
		val =Trim(document.getElementById(objArray[i]).value);
		if(val!= null && val.length > 0 && val.length > maxLenArray[i]){
			displayError(" Length of value in " +pMsgArray[i]+" should not exceed "+maxLenArray[i]+" Characters.");
			return false;
		}
	}
	return true;
}


/***
 * Function: validatePassword
 * Arguments: New Password String:StrNewPwd, Confirm Password: StrRetPwd, Error Msg:strErrorMessage
 * 	Return: Boolean
 * 	Purpose: Compares new password and confirm password.
***/
function validatePassword(StrNewPwd, StrRetPwd, strErrorMessage){
	var invalid = " "; // Invalid character is a space
	if (StrNewPwd.indexOf(invalid) > -1){		// check for spaces
		displayError(strErrorMessage);
		return false;
	}else{
		if (StrNewPwd != StrRetPwd){			// compare the passwords
			displayError (strErrorMessage);
			return false;
		}else{
			return true;
	    }
	}
}

function validatePasswordLength(pwd){

	return validatePasswordLengthWithLabel(pwd,'Password')
}

function validatePasswordLengthWithLabel(pwd,label){

	var ck_password =  /^(?=.*[A-Za-z])(?=.{8,30})*/;
	//var ck_password =  /^(?=.*[A-Za-z])(?=.*[!@#$%^&*()_])(?=.{8,30})*/;
	var password = document.getElementById(pwd).value;
	 if(password.length >= 8)
	 {
		 if (ck_password.test(password))
		 {
			return true;
		 }
		 else
		 {
			 displayError ("Inavlid" + label+". \n * Valid " +  label + "Contains atleast one uppercase(A-Z) letter or \n * atleast one lowercase(a-z) letter and \n * atleast one special character !@#$%^&*()_");
			 return false;
		 }
	}
	else
	{
		displayError (label + " Length must be atleast 8 characters");
		 return false;
	}
}

/************************************** Number Validation Functions **************************************/
/***
 * Function: isNumber
 * Arguments: Element Id-elemId, error message-pMsg
 * Return: true/false
 * Purpose:Basic number validation to check whether the given element value is number (valid examples: 9, 9.9, 09)
 * 		or not. This function directly or indirectly should be called by all other Number validation functions.
***/
function isNumber(parm,pMsg) {
	var numb = '0123456789';
	var val =Trim(document.getElementById(parm).value);

	if(!isValid(val,numb," Invalid " + pMsg + ". Valid " + pMsg + " contains only Numbers (0-9)")){
		return false;
	}

	if (val.length > 1 && val.charAt(0)==0) {
		displayError(" Invalid " + pMsg + ".Valid " + pMsg + " should not start with Zero.");
		return false;
	}
	return true;
}

/***
 * Function: isNumberArray
 * Arguments: Array of Elements: objArray, Array of Labels: pMsgArray
 * Return: true/false
 * Purpose:Check whether the given element is number. Validates each element value in loop.
***/
function isNumberArray(objArray,pMsgArray) {
	for(var i=0;i<objArray.length;i++){
		if(!isNumber(objArray[i] , pMsgArray[i])){
			return false;
		}
	}
	return true;
}

/***
 * Function: isFirstDigitNonZeroNumber
 * Arguments: Element Id-elemId, error message-pMsg
 * Return: true/false
 * Purpose: Checks whether the given element value is number and doesn't start with zero.
***/
function isFirstDigitNonZeroNumber(elemId, pMsg) {

	if(isNumber(elemId, pMsg)){
		var val =Trim(document.getElementById(elemId).value);
		if (val.length==0) return true;

		if (val.length > 1 && parseInt(val.charAt(0))==0) {
			displayError(" Invalid " + pMsg + ".Valid " + pMsg + " should not start with Zero.");
			return false;
		}else
			return true;
	}
	return false;
}

/***
 * Function: isNonZeroNumber
 * Arguments: element Id-elemId, error message-pMsg
 * Return: true/false
 * Purpose:Check if the given element is a non-zero number.
***/
function isNonZeroNumber(elemId,pMsg) {

	if(isNumber(elemId, pMsg)){
		var val =Trim(document.getElementById(elemId).value);
		if(val == "0" || parseInt(val) == 0){
			displayError(" Invalid " + pMsg + ". " + pMsg + " should not be Zero.");
			return false;
		}else
			return true;
	}
	return false;
}

/***
 * Function: isFloat
 * Arguments: Array of Element Ids: objArray, Array of Element Labels: pMsgArray
 * Return: true/false
 * Purpose: Checks whether the given element is a valid Float. Validates each element in loop.
***/
function isFloat(objArray,pMsgArray) {
	var reFloat =/^((\d+(\.\d*)?)|((\d*\.)?\d+))$/;
	var val = null;
	for(var i=0;i<objArray.length;i++){
		val=Trim(document.getElementById(objArray[i]).value);
		if(val.length>0){
			if(!reFloat.test(val)){
				displayError(" Invalid " + pMsgArray[i] + ". Valid " + pMsgArray[i] + " contains only Numbers (0-9) and only one decimal (.).");
				return false;
			}
		}
	}
	return true;
}

/***
 * Function: isNonZeroFloat
 * Arguments: Array of Element Ids: parmArray, Array of Element Labels: pMsgArray
 * Return: true/false
 * Purpose: Checks whether the given array of float elements are non-zero or not.
***/
function isNonZeroFloat(parmArray, pMsgArray) {

	if(isFloat(parmArray, pMsgArray)){
		for(var i=0; i<parmArray.length; i++) {
			val = Trim(document.getElementById(parmArray[i]).value);
			if(Math.round(val)==0) {
				displayError(" Invalid " + pMsgArray[i] + ". " + pMsgArray[i] + " should not be Zero.");
				return false;
			}
		}
	}else return false;
	return true;
}

/***
 * Function: isValidPercentage
 * Arguments: Element: objId, Element Label: label
 * Return: true/false
 * Purpose:Validates Percentage.
***/
function isValidPercentage(objId,label){

	var amountRegExp = /^\d{1,3}(\.\d{1,2})?$/;
	var val=document.getElementById(objId).value;

	if(val > 100.00){
		displayError(" Invalid " + label + ". Valid percentile should not be greater than 100.");
		return false;
	}
	if(val != null && val!="" && val.length>0 ){
		if(!(amountRegExp.test(val))){
			displayError(" Invalid " + label + ". Valid percentile contains only numbers and '.'.");
		    return false;
		}
	}


	return true;
}

/***
 * Function: checkNumberLength
 * Arguments: Element:obj, Element Label: pMsg, Element Length: len
 * Return: true/false
 * Purpose: Checks the length of the given element's number value with given length.
***/
function checkNumberLength(obj, pMsg, len){

	if(isFirstDigitNonZeroNumber(obj,pMsg)){
		var parm = Trim(document.getElementById(obj).value);
		if (parm.length == len){
			return true;
		}else{
			displayError(" Length of " + pMsg+" should be "+len+" digits.");
		}
	}
	return false;
}

/*****************************************************
Function: isLong
Arguments: element Value-parm, error message-pMsg
Return: true/false
Purpose:This is function used to check whether the given element is Long or not, this function internally calls
 the generic isValid function passing number argument as validation range, which returns true/false for the given element.
Notes:

*****************************************************/
function isLong(parm,pMsg) {
	var numb = '0123456789';
	var val =Trim(document.getElementById(parm).value);

	if(!isValid(val,numb," Invalid " + pMsg + ". Valid " + pMsg + " contains only Numbers (0-9)")){
		return false;
	}

	if(val <= 0 || (val.length > 1 && val.charAt(0)==0) ) {
		displayError(" Invalid " + pMsg + ". Valid " + pMsg + " should be greater than zero and should not start with a zero.");
		return false;
	}

	return true;
}

/***
 * Function: isLongArray
 * Arguments: Array of Element Ids: parmArr, Array of Element Labels: pMsgArr
 * Return: true/false
 * Purpose: Checks whether the given array of long elements are non-zero or not.
***/

function isLongArray(parmArr,pMsgArr) {
	var numb = '0123456789';
	for(i=0;i<parmArr.length;i++)
	{
		if(! isLong(parmArr[i],pMsgArr[i]))
			return false;
	}

	return true;
}

/***
 * Function: checkFinancialYear
 * Arguments: Array of Element id: objArray, Array of Element Labels: msgArray, Length of Element: len
 * Return: true/false
 * Purpose: Validates financial year
***/
function checkFinancialYear(objArray, msgArray, len){
	var parm = null;
	for(var i=0;i<objArray.length;i++){
		if (!checkNumberLength(objArray[i], msgArray[i], len))
			return false;
	}

	parm = Trim(document.getElementById(objArray[0]).value);
	var parm1= Trim(document.getElementById(objArray[1]).value);
	if((parseInt(parm)+parseInt(1))==parseInt(parm1)){
		return true;
	}

	displayError(msgArray[1]+" should be greater than "+msgArray[0] +" by only One.");
	return false;
}

/***
 * Function: checkFiveYears
 * Arguments: Array of Element id: objArray, Array of Element Labels: msgArray, Length of Element: len
 * Return: true/false
 * Purpose: Validates Five years
***/
function checkFiveYear(objArray,msgArray,len){

	var parm = null;
	for(var i=0;i<objArray.length;i++){
		if (checkNumberLength(objArray[i], msgArray[i], len))
			return false;
	}

	parm = Trim(document.getElementById(objArray[0]).value);
	var parm1= Trim(document.getElementById(objArray[1]).value);
	if((parseInt(parm)+parseInt(5))==parseInt(parm1)){
		return true;
	}
	displayError(msgArray[1]+" should be greater than "+msgArray[0] +" by only Five.");
	return false;
}

/***
 * Function: checkPhoneNumber
 * Arguments: Array of elements: objArray, Array of Element Labels: pMsgArray
 * Return: true/false
 * Purpose: Checks whether the given element is a valid phone number or not.
***/
function checkPhoneNumber(objArray, pMsgArray) {
	var numb = '0123456789-';
	var phoneRegex = /^\d{11}$/;
	var val= null;
    
	for(var i=0;i<objArray.length;i++) {
		val =Trim(document.getElementById(objArray[i]).value);
		
	 if(val!="" && val.length > 0)
	 {	
		if(val=="00000000000")
		{
			displayError(" Invalid " + pMsgArray[i]+ ". Valid " + pMsgArray[i] + " should not contain all zeros." );
			return false;
		}
		
		if(!(phoneRegex.test(val)))
		{
			displayError(" Invalid " + pMsgArray[i] );
		    return false;
		}else{
		
		if(val.length > 0){
			if(val.length >= 11 && val.length <=12){
				if(!isValid(val,numb," Invalid " + pMsgArray[i] + ". Valid " + pMsgArray[i] + " contains only Numbers (0-9) and (-).")) {
					return false;
				}
			} else {
				displayError(pMsgArray[i] + " is Invalid. Valid "+pMsgArray[i]+" should be Eleven digits.");
				return false;
			}
		}
		}
	 }
	}
	return true;
}

/***
 * Function: checkPhoneMobileNumber
 * Arguments: Element Id: obj, Element Label: pMsg
 * Return: true/false
 * Purpose: Checks whether the given element is a valid phone number or mobile number or not.
***/
function checkPhoneMobileNumber(obj, pMsg) {
	var numb = '0123456789';
	var val= null;

	val =Trim(document.getElementById(obj).value);
	if(val.length > 0){
		if(val.length >= 10 && val.length <=11){
			if(!isValid(val,numb," Invalid " + pMsg + ". Valid " + pMsg + " contains only Numbers (0-9).")){
				return false;
			}
			if(val.length ==10)	{
				if (val.charAt(0)== 0) {
					displayError(pMsg + " is Invalid, 10 digit " + pMsg +" should not start with 0");
					return false;
				} else {
					return true;
				}
			}else if(val.length==11){
				if(val.charAt(0)== 0){
					return true;
				}else{
					displayError(pMsg + " is Invalid. 11 digit "+pMsg+" should Start with '0'.");
					return false;
				}
			}
		} else {
			displayError(pMsg + " is Invalid. Valid "+pMsg+" should be of either Ten or Eleven digits.");
			return false;
		}
	}
	return true;
}


/***
 * Function: isValidAmount
 * Arguments: Array of Element Ids: elemIdArray, Array of Element Labels: elemLabelArray
 * Return: true/false
 * Purpose: Checks whether the given element's value is in valid Amount format or not.
 * Notes: Precision : 15 Scale: 2 Valid Examples : 100.00 or 100 Invalid :100.000 or .00
***/
function isValidAmount(elemIdArray,elemLabelArray) {
	var amountRegExp = /^\d{1,13}(\.\d{1,2})?$/;
	var val=null;
	if(!isFloat(elemIdArray, elemLabelArray)){
		return false;
	}
	for(var i=0;i<elemIdArray.length;i++){
		val = Trim(document.getElementById(elemIdArray[i]).value);
		if(val!="" && val.length>0){
			if(!(amountRegExp.test(val))){
				displayError(" Invalid amount in " + elemLabelArray[i] + ". Valid amount needs to be in the format xxx.xx. Max allowed precison is 15 and scale is 2");
			    return false;
			}
		}
	}
	return true;
}

/***
 * Function: isValidDistanceOrArea
 * Arguments: Array of Element Ids: elemIdArray, Array of Element Labels: elemLabelArray
 * Return: true/false
 * Purpose: Checks whether the given element's value is in valid Distance or Area format or not.
 * Notes: Precision : 12 Scale: 3 Valid Examples : 100.00 or 100 Invalid :100.000 or .00
***/
function isValidDistanceOrArea(elemIdArray,elemLabelArray) {
	var amountRegExp = /^\d{1,9}(\.\d{1,3})?$/;
	var val = null;
	if(!isFloat(elemIdArray, elemLabelArray)) return false;

	for(var i=0;i<elemIdArray.length;i++){
		val = Trim(document.getElementById(elemIdArray[i]).value);
		if(val!="" && val.length>0){
			if(!(amountRegExp.test(val))){
				displayError(" Invalid value in " + elemLabelArray[i] + ". Valid value needs to be in the format xxx.xxx. Max allowed precison is 12 and scale is 3");
				return false;
			}
		}
	}
	return true;
}

/************************************** Date Validation Functions **************************************/

/***
 * Function: isValidDate
 * Arguments: String: strDate
 * Return: Boolean
 * Purpose: Function to validate date and date format
***/
function isValidDate(strDate){

	var validformat = /\b\d{4}[\/-]\d{2}[\/-]\d{2}\b/;
	if (!validformat.test(strDate)){
		alert("Invalid Date Format. Please correct and submit again.");
		return false;
	}else{ //Detailed check for valid date ranges
		var yearfield=strDate.split(dateSeparator)[0];
		var monthfield=strDate.split(dateSeparator)[1];
		var dayfield=strDate.split(dateSeparator)[2];
		var dayobj = new Date(yearfield, monthfield-1, dayfield);
		if ((dayobj.getMonth()+1!=monthfield)||(dayobj.getDate()!=dayfield)||(dayobj.getFullYear()!=yearfield)){
			alert("Invalid Date! Please correct and submit again.");
			return false;
		}else{
			return true;
		}
	}
}

/***
 * Function: isValidTime
 * Arguments: String: timeStr
 * Return: Boolean
 * Purpose: Validates Time Entered is in the "HH:MM:SS" pattern. Seconds are optional
***/
function isValidTime(timeStr){

	var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?$/;
	var matchArray = timeStr.match(timePat);

	if (matchArray == null){
		return false;
	}

	hour = matchArray[1];
	minute = matchArray[2];
	second = matchArray[4];

	if(second=="") second = null;
	if(hour < 0  || hour > 23) return false;
	if(minute<0 || minute > 59) return false;
	if(second != null && (second < 0 || second > 59)) return false;

	return true;
}

/***
 * Function: checkDates
 * Arguments: String: fromDate, String: toDate, From Date Label: fromDateMsg, To Date Label: toDateMsg
 * Return: Boolean
 * Purpose: checks if ToDate is greater than FromDate.
***/
function checkDates(fromDate, toDate, fromDateMsg, toDateMsg)
{

	//Getting the Start Date and split in to pieces by giving "-" symbol
	var str1 = new String(fromDate);
	//Getting the End Date and split in to pieces by giving "-" symbol
	var str2 = new String(toDate);

	if(str1!="" && str2!="")
	{
		str1 = str1.split("/");


		str2 = str2.split("/");


		if (str2[2] > str1[2]){
			return true;

		}else if (str2[2] == str1[2]){

			if(str2[1] == str1[1]){
				if (str2[0] >= str1[0]){
					return true;
				}else{
					displayError(fromDateMsg+" should not be greater than "+toDateMsg+".");
					return false;
				}
			}else if (str2[1] > str1[1]){

				return true;
			}
			else{
				displayError(fromDateMsg+" should not be greater than "+toDateMsg+".");
				return false;
			}
		}
		else{
			displayError(fromDateMsg+" should not be greater than "+toDateMsg+".");
			return false;
		}
	}
	return true;
}

/***
 * Function: checkDateWithToday
 * Arguments: String: fromDate, String:fromDateLabel
 * Return: Boolean
 * Purpose: Check if give date is before current date.
***/
function checkDateWithToday(fromDate, fromDateLabel){
	return checkDates(fromDate, currentDate, fromDateLabel, "Today")
}

/************************** PENDING FUNCTIONS (Need to be removed if not used in NMC) **************************/
/*********************************** Generic Functions ***********************************/
/***
 * Function: checkBloodGroup
 * Return:
 * Purpose: Checks the validity of the entered Blood Group
***/
function checkBloodGroup(param) {
	var bloodGroup = Trim(document.getElementById(param).value);

	if(bloodGroup == "A+" || bloodGroup == "A-" || bloodGroup == "B+" ||
			bloodGroup == "B-" || bloodGroup == "AB+" || bloodGroup == "AB-" ||
			bloodGroup == "O+" || bloodGroup == "O-") {
		displayError("");
		return true;
	}

	displayError(bloodGroup + " is Invalid. Please enter a valid Blood Group.");
	return false;
}

/***
 * Function: selectAllOptions
 * Arguments: List box objects
 * Return:
 * Purpose: This function is used to select all options in a given combo box
***/
function selectAllOptions(obj) {
	var val = '';
	if(!hasOptions(obj)) { return;}

	for (var i=0; i<obj.options.length; i++) {
		if(!(Trim(obj.options[i].value)=="")){
			if(val == ''){
				val = Trim(obj.options[i].value);
			}else{
				val = Trim(val) + "," + Trim(obj.options[i].value);
			}
		}else{
			obj.options[i].selected = false;
		}
	}//end of for
	return val;
} //end of function

/***
 * Function: moveData
 * Arguments: List box objects
 * Return:
 * Purpose: Function to move selected option from combobox to a listbox and to move selected options
 * 		from listbox to combobox
***/
function moveData(objList1, objList2){
     var arrobjList1 = new Array();
     var arrobjList2 = new Array();
     var arrLookup = new Array();
     var i;

	 for(i=0; i<objList2.options.length; i++)
	 {
          arrLookup[objList2.options[i].text] = objList2.options[i].value;
          arrobjList2[i] = objList2.options[i].text;
     }

	 var iList1Length = 0;
     var iList2Length = arrobjList2.length

     for(i=0; i<objList1.options.length; i++)
	 {
          arrLookup[objList1.options[i].text] = objList1.options[i].value;
          if(objList1.options[i].selected && objList1.options[i].value != "")
		  {
               arrobjList2[iList2Length] = objList1.options[i].text;
               iList2Length++;
          }
		  else
		  {
               arrobjList1[iList1Length] = objList1.options[i].text;
               iList1Length++;
          }
     }

     arrobjList1.sort();
     arrobjList2.sort();
     objList1.length = 0;
     objList2.length = 0;
     var c;

     for(c=0; c<arrobjList1.length; c++){
          var no = new Option();
          no.value = arrLookup[arrobjList1[c]];
          no.text = arrobjList1[c];
          objList1[c] = no;
     }

     for(c=0; c<arrobjList2.length; c++){
     	var no = new Option();
     	no.value = arrLookup[arrobjList2[c]];
     	no.text = arrobjList2[c];
     	objList2[c] = no;
     }
}

/***
 * Function: calcTotal
 * Arguments: first element Id,second element Id,total Id, table Id,pageTotal Id
 * Purpose: Function to calculate a Total
***/
function calcTotal(eleId1,eleId2,totalId,tableId,grandTotalId){
	firstArr = document.getElementsByName(eleId1);
	secondArr = document.getElementsByName(eleId2);
	totalArr = document.getElementsByName(totalId);

	var table = document.getElementById(tableId);
	var noOfRows = table.tBodies[0].rows.length;
	grandTotal = 0;
	for(var rowno=0;rowno<noOfRows-1;rowno++)
	{
		val1= firstArr[rowno].value;
		val2= secondArr[rowno].value;
		total = val1 * val2;
		if(isNaN (total) && totalId != '')
			totalArr[rowno].value="";
		else
		{
			if(totalId != '')
				totalArr[rowno].value = (roundNumber(total,2)).toFixed(2);
			grandTotal = eval(grandTotal + roundNumber(total,2)) ;
		}
	}
	grandTotalEle = document.getElementById(grandTotalId);
	if(grandTotalEle !=null)
	{
		grandTotalEle.value = grandTotal.toFixed(2);
	}
}

/***
 * Function: calcQuantity
 * Arguments: first element Id,second element Id,total Id, table Id
 * Purpose: Function to calculate Quantity
***/
function calcQuantity(eleId1,eleId2,totalId,tableId){
	firstArr = document.getElementsByName(eleId1);
	secondArr = document.getElementsByName(eleId2);
	totalArr = document.getElementsByName(totalId);

	var table = document.getElementById(tableId);
	var noOfRows = table.tBodies[0].rows.length;
	for(var rowno=0;rowno<noOfRows-1;rowno++)
	{
		val1= firstArr[rowno].value;
		val2= secondArr[rowno].value;
		total = val1 * val2;
		if(isNaN (total))
			totalArr[rowno].value="";
		else
		{
			totalArr[rowno].value = roundNumber(total,2);
		}
	}
}

/***
 * Function: checkAge
 * Arguments: date of birth
 * Return: true/false
 * Purpose:This function checks whether the age of the candidate is between 25 * 58.
***/
function checkAge(dateOfBirth) {
	var dobStr = null;
	var date = null;
	var month = null;
	var year = null;
	var dobObject = null;
	var curDateObject = null;

	dobStr = document.getElementById(dateOfBirth).value;

	date = dobStr.substring(0,dobStr.indexOf(dateSeparator));
	dobStr = dobStr.substring(dobStr.indexOf(dateSeparator)+1);
	month = dobStr.substring(0,dobStr.indexOf(dateSeparator));
	year = dobStr.substring(dobStr.indexOf(dateSeparator)+1);

	dobObject = new Date(year,month-1,date);
	curDateObject = getCurrentDate();

	var diffYears = (curDateObject-dobObject) / (1000*60*60*24*365);
	if(Math.floor(diffYears)<25 || Math.floor(diffYears) > 58) {
		displayError("Age not applicable. Please check the Date of Birth of the Candidate.");
		return false;
	}

	displayError("");
	return true;
}

/***
 * Function: checkValidDate
 * Arguments: FromDate as String and ToDate as String,fromDateMsg,toDateMsg
 * Return: Boolean
 * Purpose: This function calls the existing checkdate function and replaces the error msg thrown there in other way.
***/
function checkValidDate(fromDate, toDate, fromDateMsg, toDateMsg){
	var bool = checkDates(fromDate, toDate, fromDateMsg, toDateMsg);
	if(bool == false){
		displayError(toDateMsg+" should not be less than "+fromDateMsg+".");
		return false;
	}
	return true;
}


/***
 * Function: moveAllData
 * Arguments: List box objects
 * Return:
 * Purpose: Function to move All options from combobox to a listbox and vice versa
***/
function moveAllData(objList1, objList2){
     var arrobjList1 = new Array();
     var arrobjList2 = new Array();
     var arrLookup = new Array();
     var i;

	 for(i=0; i<objList2.options.length; i++){
          arrLookup[objList2.options[i].text] = objList2.options[i].value;
          arrobjList2[i] = objList2.options[i].text;
     }

	 var iList1Length = 0;
     var iList2Length = arrobjList2.length

     for(i=0; i<objList1.options.length; i++){
          arrLookup[objList1.options[i].text] = objList1.options[i].value;
          arrobjList2[iList2Length] = objList1.options[i].text;
          iList2Length++;
     }

     arrobjList1.sort();
     arrobjList2.sort();
     objList1.length = 0;
     objList2.length = 0;
     var c;

     for(c=0; c<arrobjList1.length; c++){
          var no = new Option();
          no.value = arrLookup[arrobjList1[c]];
          no.text = arrobjList1[c];
          objList1[c] = no;
     }

     for(c=0; c<arrobjList2.length; c++){
     	var no = new Option();
     	no.value = arrLookup[arrobjList2[c]];
     	no.text = arrobjList2[c];
     	objList2[c] = no;
     }
}

function toggleHideShowField(RbtnValue, targetElementArray, clearElement) {

  	for (var i=0; i<targetElementArray.length; i++)
  	{
  	    if (RbtnValue == 'true')
  	    	document.getElementById(targetElementArray[i]).style.visibility = 'visible';

  	    else{
  	    	document.getElementById(targetElementArray[i]).style.visibility = 'hidden';
  	    	if(i==0)
  	    		document.getElementById(clearElement).value = "";
  	    }
  	}

  	return true;
  }

function getMultiSelectFieldValues(sel) {

  	//For the multiselect dropdownfield, get values and construct a comma separated string
  	//and return the same.

  	var concatString='';
  	var j = 0;

  	if (sel && (sel = sel.options)) {
  	    for (var i = 0, iLen = sel.length; i < iLen; ++i) {
  	        if(sel[i].selected && sel[i].value!= ''){
  	            j++;
  	            if(j==1){
  	            	concatString = sel[i].value;
  	            }
  	            else{
  	            	concatString = concatString + ',' + sel[i].value;
  	            }
  	        }
  	    }
  	}

  	return concatString;
  }

function setMultiSelectFieldValues(concatString, fieldname) {

	//Get values from the comma separated string and set the multiselect dropdownfield options
	var idArray = concatString.split(",");
  	var sel = document.getElementById(fieldname);

  	if (sel && (sel = sel.options)) {
  	    for (var i = 0; i< idArray.length; ++i) {
  	    	for (var j = 0;  j < sel.length; j++) {
  		        if(sel[j].value == idArray[i]){
  		        	sel[j].selected = true;
  		        }
  		    }
  	    }
  	}

  	return true;
  }

function checkRadioDependantMandatory(arrayRadioElements, arrayDependantElements){
  	for (var i=0; i<arrayRadioElements.length; i++)
  	{
  		if(document.getElementById(arrayRadioElements[i]).checked == true){
  			if(document.getElementById(arrayDependantElements[i]).value == "" || document.getElementById(arrayDependantElements[i]).value ==null){
		displayError('Please fill all the required fields which are marked with *');
  				return false;
  			}
  		}
  	}
  	return true;
}

/***
 * Checks for duplicates in sub items/sub table entries
 * @param elements - set of elements (elementId's)
 * @param pMsgArray - set of messages/name
 * @return
 ***/
function checkDuplicates(elements,pMsgArray) {
	for(var ele = 0;ele<elements.length;ele++){
		var elementNodes = document.getElementsByName(elements[ele]);
		var k=0;
		for(var i=0;i<elementNodes.length;i++){
			 k=0;
		 for (var j=i;j<elementNodes.length;j++) {
			   var elementNodesIValue = Trim(elementNodes[i].value).toString();
			   var elementNodesJValue = Trim(elementNodes[j].value).toString();
			   if(elementNodesIValue == elementNodesJValue){
				   k++;
				   if(k>1){
					   displayError("The same "+pMsgArray[ele]+" should not repeat in the sub items list.");
					   return false;
				   }
			   }
		   }
		 }
	 }
	return true;
}

/**************************************************
Function: checkPreviousDate
Arguments: FromDate as String and ToDate as String,fromDateMsg,toDateMsg
Return: Boolean
Purpose: Function to validate ToDate is greater than FromDate and in case of error it shows the relevant error message.
Notes:
*****************************************************/
function checkPreviousDate(fromDate, toDate, toDateMsg, days){

//Getting the Start Date and split in to pieces by giving dateSeparator symbol
var str1 = new String(fromDate);
//Getting the End Date and split in to pieces by giving dateSeparator symbol
var str2 = new String(toDate);

if(str1!="" && str2!=""){
	str1 = str1.split(dateSeparator);
	if(str1.length == 1){
		str1 = str1[0].split(dbDateSeparator);
	}

	str2 = str2.split(dateSeparator);

	if(str2.length == 1){
		str2 = str2[0].split(dbDateSeparator);
	}
	if (str2[2] > str1[2]){
		return true;

	}else if (str2[2] == str1[2]){

		if(str2[1] == str1[1]){
			if (str2[0] >= str1[0]){
				return true;
			}else{
				displayError(toDateMsg+" can atmost be "+days+" Days behind from Current Date");
				return false;
			}
		}else if (str2[1] > str1[1]){

			return true;
		}
		else{
			displayError(toDateMsg+" can atmost be "+days+" Days behind from Current Date");
			return false;
		}
	}
	else{
		displayError(toDateMsg+" can atmost be "+days+" Days behind from Current Date");
			return false;
		}
	}
	return true;
}

/***
 * Function: isAlphaArrayForTabs (where no child rows are present)
 * Arguments: Arraylist of elements to be validated, Arraylist of label msgs of elements to be validated & the tab id
 * Return: boolean
 * Purpose:This is function used to check whether the given elements in the given tab is alphabetic or not, this function internally calls
 *  the generic isValid function passing alphabetic argument as validation range, which returns true/false for the given element.
***/
function isAlphaArrayForTabs(objArray,pMsgArray,headerLabel){
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar=' '+'_-/,.()[]&@\'';

	var val = null;
	for(var i=0;i<objArray.length;i++){
		val =Trim(document.getElementById(objArray[i]).value);
		if(!isValid(val,lwr+upr+spChar, " Invalid " + pMsgArray[i] + " in "+ headerLabel +". Valid " + pMsgArray[i] + " contains only Alphabets (a-z)(A-Z) and special characters(/*).")){
			return false;
		}
	}
	return true;
}





/************************************** Amount Related Functions **************************************/
function checkGreaterAmount(objArray,pMsgArray){
	var amt1=Trim(document.getElementById(objArray[0]).value);
	var amt2=Trim(document.getElementById(objArray[1]).value);

	if (amt1!= "" && amt1 > 0) {
		if (amt2!= "" && amt2 > 0.0) {
			if((amt1-amt2) < 0) {
				displayError(pMsgArray[1]+" should be less than or equal to "+pMsgArray[0]+".");
				return false;
			}
		}
	}
	return true;
}

/***
 * Function: isValidAmountInCrores
 * Arguments: element val Array, elemLabel Array
 * Return: true/false
 * Purpose: Check whether the given element's value is in valid Crores Amount format or not.
 * Notes: Precision : 13 Scale: 7 Valid Examples : 100.00 or 100, Invalid :100.000 or .00
***/
function isValidAmountInCrores(elemValArray,elemLabelArray) {
	var amountRegExp = /^\d{1,6}(\.\d{1,7})?$/;
	var val=null;
	for(var i=0;i<elemValArray.length;i++){
		val = Trim(elemValArray[i]);
		if(val != null && val!="" && val.length>0){
			if(!(amountRegExp.test(val))){
				displayError(" Invalid amount in " + elemLabelArray[i] + ". Valid amount needs to be either N/A or it should be in the format xxx.yyyyy. After decimal max 5 digits are allowed. Max allowed precison is 13 and scale is 7");
				return false;
			}
		}
	}
	return true;
}

/***
 * Function: isValidAmountInLakhs
 * Arguments: element val Array, elemLabel Array
 * Return: true/false
 * Purpose:This function is used to check whether the given element's value is in valid Lakhs Amount format or not.
 * 	Notes: Precision : 13 Scale: 7 Valid Examples : 100.00 or 100, Invalid :100.000 or .00
***/
function isValidAmountInLakhs(elemValArray,elemLabelArray) {
	var amountRegExp = /^\d{1,8}(\.\d{1,5})?$/;
	var val=null;
	for(var i=0;i<elemValArray.length;i++){
		val = Trim(elemValArray[i]);
	 	if(val != null && val!="" && val.length>0){
			if(!(amountRegExp.test(val))){
				displayError(" Invalid amount in " + elemLabelArray[i] + ". Valid amount needs to be either N/A or it should be in the format xxx.yyyyy. After decimal max 5 digits are allowed. Max allowed precison is 13 and scale is 5");
			    return false;
			}
		}
	}
	return true;
}

/***
 * Function: isValidAmountInLakhsWithMsg
 * Arguments: element val Array, elemLabel Array,msg
 * Return: true/false
 * Purpose:This function is used to check whether the given element's value is in valid Lakhs Amount format or not.
 * Notes: Precision : 13 Scale: 7 Valid Examples : 100.00 or 100, Invalid :100.000 or .00
***/
function isValidAmountInLakhsWithMsg(elemValArray,elemLabelArray,msg) {
	var amountRegExp = /^\d{1,8}(\.\d{1,5})?$/;
	var val=null;
	for(var i=0;i<elemValArray.length;i++)
	{
		val = Trim(elemValArray[i]);
	 	if(val != null && val!="" && val.length>0){
			if(!(amountRegExp.test(val))){
				displayError(" Invalid amount in " + elemLabelArray[i] + ". " + msg);
			    return false;
			}
		}
	}
	return true;
}
/***
 * Function: isValidAmountInCroresWithMsg
 * Arguments: element val Array, elemLabel Array,msg
 * Return: true/false
 * Purpose:This function is used to check whether the given element's value is in valid Crores Amount format or not.
 * Notes: Precision : 13 Scale: 7 Valid Examples : 100.00 or 100, Invalid :100.000 or .00
***/
function isValidAmountInCroresWithMsg(elemValArray,elemLabelArray,msg) {
	var amountRegExp = /^\d{1,6}(\.\d{1,7})?$/;
	var val=null;
	for(var i=0;i<elemValArray.length;i++)
	{
		val = Trim(elemValArray[i]);
	 	if(val != null && val!="" && val.length>0){
			if(!(amountRegExp.test(val))){
				displayError(" Invalid amount in " + elemLabelArray[i] + ". " + msg);
			    return false;
			}
		}
	}
	return true;
}

/************************************** Child Related Functions **************************************/

/***
 * Function: checkChildsNameAlphaSpecial
 * Arguments: arralist of elements to be validated, arralist of label msgs of elements to be validated,header label
 * Return: true/false
 * Purpose: Check whether the given element is aplanumeric plus the allowed special characters or not.
***/
function checkChildsNameAlphaSpecial(objArray,pMsgArray,headerLabel) {
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar = ' '+'_-()';
	var str = lwr+upr+spChar;
	var val  =null;
	var childs = null;
	for(var i=0;i<objArray.length;i++){ // outer
		childs = document.getElementsByName(objArray[i]);
		 for (var j=0,k=1;j<childs.length;j++,k++) {
			val=Trim(childs[j].value);
		if(!isValid(val,str," In " + headerLabel + " row "+k+", "+pMsgArray[i]+" is invalid. Valid "+pMsgArray[i]+" contains only Alphabets (a-z)(A-Z), Special Characters (_-()) and Spaces.")) {
			return false;
		}
	}
	}
	return true;
}

function checkChildQualification(objArray,pMsgArray,headerLabel) {
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar = ' '+'().';
	var str = lwr+upr+spChar;
	var val  =null;
	var childs = null;
	for(var i=0;i<objArray.length;i++){ // outer
		childs = document.getElementsByName(objArray[i]);
		 for (var j=0,k=1;j<childs.length;j++,k++) {
			val=Trim(childs[j].value);
			if(!isValid(val,str," In " + headerLabel + " row "+k+", "+pMsgArray[i]+" is invalid. Valid "+pMsgArray[i]+" contains only Alphabets (a-z)(A-Z), Special Characters (.()) and Spaces.")) {
				return false;
			}
		 }return true;
	}
}

/***
 * Function: checkChildAlphanum
 * Arguments: arralist of elements to be validated, arralist of label msgs of elements to be validated
 * Return: true/false
 * Purpose: Checks whether the given elements in the childs is alphaNumeric or not.
***/
function checkChildAlphanum(objArray,pMsgArray) {
	var numb = '0123456789';
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar=' '+'_-/,.()&@';
	var str=lwr+upr+numb+spChar;
	var childs = null;
	var val=null;
	for(var i=0;i<objArray.length;i++){ // outer
	childs = document.getElementsByName(objArray[i]);
	 for (var j=0,k=1;j<childs.length;j++,k++) {
		val=Trim(childs[j].value);
	 if(!isValid(val,str," In row "+k+", " + pMsgArray[i] + " is invalid. Valid " + pMsgArray[i] + " contains only Alphabets (a-z)(A-Z), Numbers (0-9), Special Characters "+spChar+" and Spaces.")){
		 return false;
	 }
	 }
	}
	return true;
}

function checkChildAlphanumDetails(objArray,pMsgArray,headerLabel) {
	var numb = '0123456789';
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar=' '+'_-/,.()&@';
	var str=lwr+upr+numb+spChar;
	var childs = null;
	var val=null;
	for(var i=0;i<objArray.length;i++){ // outer
	childs = document.getElementsByName(objArray[i]);
	 for (var j=0,k=1;j<childs.length;j++,k++) {
		val=Trim(childs[j].value);
	 if(!isValid(val,str, " In " + headerLabel + " row "+k+", "+pMsgArray[i]+" is invalid. Valid "+pMsgArray[i]+" contains only Alphabets (a-z)(A-Z), Numbers (0-9), Special Characters "+spChar+" and Spaces.")){
		 return false;
	 }
	 }
	}
	return true;
}

function checkChildAlphaNumericSpecial(objArray,pMsgArray,splChars,headerLabel){
	var numb = '0123456789';
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar = Trim(splChars);
	var str = lwr+upr+numb+spChar;
	var val=null;
	var element = null;
	for(var i=0;i<objArray.length;i++){
	element = document.getElementsByName(objArray[i]);
	for(var j=0,k=1;j<element.length;j++,k++){
	 val =Trim(element[j].value);
	if(!isValid(val,str," In " + headerLabel + " row "+k+", "+pMsgArray[i]+" is invalid. Valid " + pMsgArray[i] + " contains only Alphabets (a-z)(A-Z), Numbers (0-9) and Special Characters (" +spChar+ ").")){

		return false;
	}
	}
	}
	return true;
}

function checkChildPercentage(maxMarksArray,obtMarksArray,PercentageFieldArray,headLabel) {
	var val = null;
	var val1 = null;
	var totMaxMarks = document.getElementsByName(maxMarksArray);
	var totObtndMarks = document.getElementsByName(obtMarksArray);
	var percentage = document.getElementsByName(PercentageFieldArray);
	var percent = null;
	 for (var j=0,k=1;j<totMaxMarks.length;j++,k++) {
		 val = Trim(totMaxMarks[j].value) - 0 ;
		 val1 = Trim(totObtndMarks[j].value) - 0 ;
		 if(val1>val){
			 displayError(headLabel+" In row "+k+", Marks Obtained should be less than or equal to Max Marks");
			 return false;
		 }else if(val>0 && val1>0){
			percent = (val1/val)*100;
			percentage[j].value = percent.toFixed(2);
		 }else if(val==0 || val1==0){
			 percentage[j].value = 0;
		 }
	 }
	return true;
}

/***
 * Function: checkChildAlpha
 * Arguments: arralist of elements to be validated, arralist of label msgs of elements to be validated
 * Return: true/false
 * Purpose: Check whether the given elements in the childs is alphaetic or not.
***/
function checkChildAlpha(objArray,pMsgArray) {
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar=' '+'_-/,.()&@';
	var str=lwr+upr+spChar;
	var childs = null;
	var val=null;
	for(var i=0;i<objArray.length;i++){ // outer
	childs = document.getElementsByName(objArray[i]);
	 for (var j=0,k=1;j<childs.length;j++,k++) {
		val=Trim(childs[j].value);
	 if(!isValid(val,str," In row "+k+", "+pMsgArray[i]+" is invalid. Valid "+pMsgArray[i]+ " contains only Alphabets (a-z)(A-Z), Special Characters "+spChar+" and Spaces.")){
		 return false;
	 }
	 }
	}
	return true;
}

function checkChildAlphaDetails(objArray,pMsgArray,headerLabel) {
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar=' '+'_-/,.()&@';
	var str=lwr+upr+spChar;
	var childs = null;
	var val=null;
	for(var i=0;i<objArray.length;i++){ // outer
	childs = document.getElementsByName(objArray[i]);
	 for (var j=0,k=1;j<childs.length;j++,k++) {
		val=Trim(childs[j].value);
	 if(!isValid(val,str," In " + headerLabel + " row "+k+", "+pMsgArray[i]+" is invalid. Valid " +pMsgArray[i]+ " contains only Alphabets (a-z)(A-Z), Special Characters "+spChar+" and Spaces.")){
		 return false;
	 }
	 }
	}
	return true;
}

/***
 * Function: checkChildFloat
 * Arguments: arralist of elements to be validated, arralist of label msgs of elements to be validated
 * Return: true/false
 * Purpose: Checks whether the given elements in the childs is float or not.
***/
function checkChildFloat(objArray,pMsgArray) {
	var reFloat =/^((\d+(\.\d*)?)|((\d*\.)?\d+))$/;
	var childs = null;
	var test = null;
	for(var i=0;i<objArray.length;i++){ // outer
	childs = document.getElementsByName(objArray[i]);
	 for (var j=0,k=1;j<childs.length;j++,k++) {
	 if ((Trim(childs[j].value)).length>0){
	 test = reFloat.test(childs[j].value);
		if(!test){
		displayError(" In row "+k+", "+pMsgArray[i]+" is invalid. Valid "+pMsgArray[i]+" contains only Numbers (0-9) and a decimal (.).");
		 return false;
	 }
	 }
	 }
	}
	return true;
}

/***
 * Function: checkChildNumericDetailed
 * Arguments: arralist of elements to be validated, arralist of label msgs of elements to be validated, headerlabel
 * Return: true/false
 * Purpose: Check whether the given elements in the child is numeric or not.
***/
function checkChildNumericDetailed(objArray,pMsgArray,headerLabel) {
	 var numb = '0123456789';
	var childs = null;
	var val = null;
	for(var i=0;i<objArray.length;i++){
	 childs = document.getElementsByName(objArray[i]);
	 for (var j=0,k=1;j<childs.length;j++,k++) {
		 val =Trim(childs[j].value);
		 if(!isValid(val,numb," In " + headerLabel + " row "+k+", "+pMsgArray[i]+" is invalid. Valid " +pMsgArray[i]+ " contains only Numbers (0-9).")){
			 return false;
		 }
		 }
	}
	return true;
}

/***
 * Function: checkChildDates
 * Arguments: table id,array list of mandatory elements, array list of corresponding entity names,Child's label
 * Return: true/false
 * Purpose: Checks whether ToDate is greater than FromDate in the child elements.
***/
function checkChildDates(tableId, objArray, pMsgArray, childLabel){
	var table = document.getElementById(tableId);
	var noOfRows = parseInt(table.rows.length)- parseInt(1);
	var fromDate = null;
	var toDate = null;
	var str1 = null;
	var str2 = null;

	for(var rowno=0;rowno<noOfRows;rowno++){
		fromDate = document.getElementById(objArray[0]+(rowno+1));
		toDate = document.getElementById(objArray[1]+(rowno+1));

		str1 = fromDate.value;
		str2 = toDate.value;

		if(str1!="" && str2!=""){

			str1 = str1.split(dateSeparator);
			str2 = str2.split(dateSeparator);

			if(str1.length == 1) str1 = str1[0].split(dbDateSeparator);
			if(str2.length == 1) str2 = str2[0].split(dbDateSeparator);

			if (str2[2] < str1[2]){
				displayError("In " +childLabel+" row "+(rowno+1)+", "+pMsgArray[0]+" should not be greater than "+pMsgArray[1]);
				return false;
			}else if (str2[2] ==  str1[2]){
				if (str2[1] <  str1[1]){
					displayError("In " +childLabel+" row "+(rowno+1)+", "+pMsgArray[0]+" should not be greater than "+pMsgArray[1]);
					return false;
				}else if (str2[1] ==  str1[1]){
					if (str2[0] < str1[0]){
						displayError("In " +childLabel+" row "+(rowno+1)+", "+pMsgArray[0]+" should not be greater than "+pMsgArray[1]);
						return false;
					}
				}
			}
		}
	} // End of For Loop
	return true;
}

/***
 * Function: checkChildFloatDetails
 * Arguments: arralist of elements, arralist of label msgs of elements, headerlabel
 * Return: true/false
 * Purpose: Check whether the given elements in the childs is float or not.
***/
function checkChildFloatDetails(objArray,pMsgArray,headerLabel) {

	var reFloat =/^((\d+(\.\d*)?)|((\d*\.)?\d+))$/;
	var childs = null;
	for(var i=0;i<objArray.length;i++){ // outer
		childs = document.getElementsByName(objArray[i]);
		for (var j=0,k=1;j<childs.length;j++,k++) {
			if ((Trim(childs[j].value)).length>0){
				if(!reFloat.test(childs[j].value)){
					displayError("In " + headerLabel+" row "+k+", "+pMsgArray[i]+" is invalid. Valid " + pMsgArray[i] + " contains only Numbers (0-9) and a decimal (.).");
					return false;
				}
			}
		}
	}
	return true;
}


function isAlphabet(parm,pMsg){
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar=' ';
	var val =Trim(document.getElementById(parm).value);
	return isValid(val,lwr+upr+spChar," Invalid " + pMsg + ". Valid " + pMsg + " contains only Alphabets (a-z)(A-Z), Special Characters "+spChar+" and Spaces.");
}
/***
 * Function: checkChildDropDown
 * Arguments: arralist of elements to be validated, arralist of label msgs of elements to be validated
 * Return: true/false
 * Purpose: Checks whether the given elements in the childs are selected or not.
***/
function checkChildDropDown(objArray,pMsgArray) {
	var childs = null;
	var StrName = null;
	for(var i=0;i<objArray.length;i++){ // outer
		childs = document.getElementsByName(objArray[i]);
		for (var j=0,k=1;j<childs.length;j++,k++) {
			StrName = Trim(childs[j].value);
			if(StrName == null || StrName.length == 0){
				displayError("In row "+k+", Please Select a "+pMsgArray[i]);
				 return false;
			}
		}
	}
	return true;
}

/***
 * Function: checkChildNumeric
 * Arguments: arralist of elements to be validated, arralist of label msgs of elements to be validated
 * Return: true/false
 * Purpose: Checks whether the given elements in the childs is numeric or not
***/
function checkChildNumeric(objArray, pMsgArray) {
	var numb = '0123456789';
	var childs = null;
	var val = null;
	for(var i=0;i<objArray.length;i++){
		childs = document.getElementsByName(objArray[i]);
		for (var j=0,k=1;j<childs.length;j++,k++) {
			val =Trim(childs[j].value);
			if(!isValid(val,numb,"In row "+k+", "+pMsgArray[i]+" is invalid. Valid "+pMsgArray[i]+ " contains only Numbers (0-9).")){
				return false;
			}
		 }
	}
	return true;
}

/***
 * Function: checkChildDuplicateRecords
 * Arguments: elements as arguments ,arraylist of mandatory elements
 * Return: boolean
 * Purpose: Function checks whether the same combination of elements as arguments do not repeat in multiple childs rows.
***/
function checkChildDuplicateRecords(element,pMsglabel,headerlabel) {

	var childs1 = document.getElementsByName(element);
	var len1 = childs1.length;
	var k=0;

	for(var i=0;i<childs1.length;i++){
		 k=0;
		 for (var j=i;j<childs1.length;j++){
			 if( len1>0 ){
				 if((childs1[i].value != '') && (childs1[i].value==childs1[j].value )){
					 k++;
					 if(k>1) {
						 displayError("In "+headerlabel+" the same value of "+pMsglabel+" should not repeat in the child nodes.");
						 return false;
					}
				 }
			 }
		 }  // End of For
	 }  // End of For
	return true;
}

/***
 * Function: checkChildDuplicateRecord
 * Arguments: elements as arguments ,arraylist of mandatory elements
 * Return: boolean
 * Purpose: Function checks whether the same combination of elements as arguments do not repeat in multiple childs rows.
***/
function checkChildDuplicateRecord(element1,element2,pMsgArray,headlabel) {

	var childs1 = document.getElementsByName(element1);
	var childs2 = document.getElementsByName(element2);

	var len1 = childs1.length;
	var len2 = childs2.length;

	 var k=0;
	 for(var i=0;i<childs1.length;i++){
		 k=0;
	 for (var j=i;j<childs1.length;j++) {

	   if( len1>0  && len2>0 )
	   {
		   if((childs1[i].value != '') && (childs1[i].value==childs1[j].value && childs2[i].value==childs2[j].value)){
			   k++;
			   if(k>1){
				   displayError("In "+headlabel+" the same combination of "+pMsgArray[0]+", "+pMsgArray[1]+", should not repeat in the child nodes.");
				   return false;
			   }
		   }
	   } else if (len1>0  && len2>0 ) {
		   if((childs1[i].value != '') && (childs1[i].value==childs1[j].value && childs2[i].value==childs2[j].value)){
			   k++;
			   if(k>1){
				   displayError("In "+headlabel+" the same combination of "+pMsgArray[0]+", "+pMsgArray[1]+" should not repeat in the child nodes.");
				   return false;
			   }
			}
	   } else if (len1>0  && len2>0 ) {
		   if((childs1[i].value != '') && (childs1[i].value==childs1[j].value && childs2[i].value==childs2[j].value )){
			   k++;
			   if(k>1){
				   displayError("In "+headlabel+" the same combination of "+pMsgArray[0]+" and "+pMsgArray[1]+" should not repeat in the child nodes.");
				   return false;
			   }
		   }
	   } else {
		   if( (childs1[i].value != '') && (childs1[i].value==childs1[j].value) ){
			   k++;
			   if(k>1){
				   displayError("In "+headlabel+" the same "+pMsgArray[0]+" should not repeat in the child nodes.");
				   return false;
			   }
		   }
	   }
	 }
	 }

	return true;
	}

/***
 * Function: checkChildDuplicate
 * Arguments: elements as arguments ,arraylist of mandatory elements
 * Return: boolean
 * Purpose: Function checks whether the same combination of elements as arguments do not repeat in multiple childs rows.
***/
function checkChildDuplicate(element1, element2, element3, element4, pMsgArray) {

	var childs1 = document.getElementsByName(element1);
	var childs2 = document.getElementsByName(element2);
	var childs3 = document.getElementsByName(element3);
	var childs4 = document.getElementsByName(element4);

	var len1 = childs1.length;
	var len2 = childs2.length;
	var len3 = childs3.length;
	var len4 = childs4.length;

	 var k=0;
	 for(var i=0;i<childs1.length;i++){
		 k=0;
	 for (var j=i;j<childs1.length;j++) {

	   if( len1>0  && len2>0 && len3>0 && len4>0 )
	   {
		   if((childs1[i].value != '') && (childs1[i].value==childs1[j].value && childs2[i].value==childs2[j].value && childs3[i].value==childs3[j].value && childs4[i].value==childs4[j].value)){
			   k++;
			   if(k>1){
				   displayError("The same combination of "+pMsgArray[0]+", "+pMsgArray[1]+", "+pMsgArray[2]+" and "+pMsgArray[3]+" should not repeat in the child nodes.");
				   return false;
			   }
		   }
	   } else if (len1>0  && len2>0 && len3>0 ) {
		   if((childs1[i].value != '') && (childs1[i].value==childs1[j].value && childs2[i].value==childs2[j].value && 	childs3[i].value==childs3[j].value)){
			   k++;
			   if(k>1){
				   displayError("The same combination of "+pMsgArray[0]+", "+pMsgArray[1]+" and "+pMsgArray[2]+" should not repeat in the child nodes.");
				   return false;
			   }
			}
	   } else if (len1>0  && len2>0 ) {
		   if((childs1[i].value != '') && (childs1[i].value==childs1[j].value && childs2[i].value==childs2[j].value )){
			   k++;
			   if(k>1){
				   displayError("The same combination of "+pMsgArray[0]+" and "+pMsgArray[1]+" should not repeat in the child nodes.");
				   return false;
			   }
		   }
	   } else {
		   if( (childs1[i].value != '') && (childs1[i].value==childs1[j].value) ){
			   k++;
			   if(k>1){
				   displayError("The same "+pMsgArray[0]+" should not repeat in the child nodes.");
				   return false;
			   }
		   }
	   }
	 }
	 }

	return true;
	}
/***
 * Function: checkChildMandatory
 * Arguments: arralist of mandatory elements
 * Return: String
 * Purpose: Checks for all mandatory fields in the child elements.
***/
function checkChildMandatory(objArray){
	var strContent= null;
	var strContentValue = null;
	for(var i=0;i<objArray.length;i++){
		childs = document.getElementsByName(objArray[i]);
		 for (var j=0;j<childs.length;j++) {
			 StrName = Trim(childs[j].value);
				if(StrName == null || StrName.length == 0){
					displayError('Please fill in all the required fields that are marked with *.');
					 return false;
				}
		 }
	}
	return true;
}

/***
 * Function: checkChildMandatoryDetailed
 * Arguments: table id,array list of mandatory elements, array list of corresponding entity names,Child's label
 * Return: Boolean
 * Purpose: Checks for all mandatory fields in the child elements.
***/
function checkChildMandatoryDetailed(tableId,objArray,msgArray,childsLabel){
	var strContent= null;
	var strContentValue = null;

	for(var i=0;i<objArray.length;i++){
		childs = document.getElementsByName(objArray[i]);
		//If no childs found , we can treat it as Date Control in +/- screen
		if(childs.length == 0) {
			var table = document.getElementById(tableId);
			var noOfRows = table.tBodies[0].rows.length;
			for(var rowno=1;rowno<noOfRows;rowno++) {
				var dtVal = document.getElementById(objArray[i]+rowno).value;
				if(dtVal == null || dtVal.length == 0){
					displayError("In " +childsLabel+" row "+rowno+", "+msgArray[i]+" is Mandatory.");
					return false;
				}
			}
		} else {
			 for (var j=0,k=1;j<childs.length;j++,k++) {
				 StrName = Trim(childs[j].value);
					if(StrName == null || StrName.length == 0){
						displayError("In " +childsLabel+" row "+k+", "+msgArray[i]+" is Mandatory.");
						return false;
					}
			 }
		}
	}
	return true;
}

function removeRowFromTable(tableName){
  var tbl = document.getElementById(tableName);
  var lastRow = tbl.rows.length;
  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
  else alert("Cannot delete the last row.");
}

function removeCurrentRowFromTable(tableName,rowwnum){
  var tbl = document.getElementById(tableName);
  var lastRow = tbl.rows.length;
  if (lastRow > 2) tbl.deleteRow(rowwnum-1);
  else alert("Cannot delete the last row.");
}

function removeRowFromTableByRowIndex(tableName,rowwIndex){
	var tbl = document.getElementById(tableName);
  	tbl.deleteRow(rowwIndex);
}

/***
 * Function: removeNewRowFromTable
 * Arguments: tableName,rows
 * Return: Boolean
 * Purpose: Removes rows from a table, it allows deletion of only those rows which have been added in jsp at that point of time.
***/
function removeNewRowFromTable(tableName,rows){
	if(rows == 0) rows=1;
	var tbl = document.getElementById(tableName);
	var lastRow = tbl.rows.length;
	if (lastRow > rows+1) tbl.deleteRow(lastRow - 1);
	else alert("No more newly added rows to Delete");
}

function addPreviousRowToTable(tableId,fileId,filePath){
	$('input.ClsTextboxDate').datepicker('destroy');
	table = document.getElementById(tableId);
	var newRow = table.tBodies[0].rows[1].cloneNode(true);

	 //modify newRow as appropriate
	table.tBodies[0].appendChild(newRow);
	var len = table.rows.length;
	// For S.No
	newRow.cells[0].innerHTML = len-1;

	var Vfori;
	if (navigator.appName == "Microsoft Internet Explorer") Vfori=0;
	else Vfori=1;

	for (var i=1;i<=newRow.cells.length;i++){
		if(newRow.cells[i] && newRow.cells[i].innerText!=newRow.cells[i].innerHTML){
			var ctrObject = newRow.cells[i].childNodes.item(Vfori);
			if(ctrObject == null){
				ctrObject = newRow.cells[i].childNodes.item(0);
				Vfori = 0;
			}
			if(ctrObject != null){
				if(ctrObject.type=='hidden'){
					ctrObject.value="0";
				} else if (ctrObject.type=='text'){
					if(ctrObject.getAttribute("isDateControl")=="true"){
						var strName = ctrObject.getAttribute("commonName");
						strName = strName+(len-1);
						ctrObject.setAttribute("id",strName);
						ctrObject.setAttribute("name",strName);
					}
					newRow.cells[i].childNodes.item(Vfori).value="";
				} else if (ctrObject.type=='select-one'){
					newRow.cells[i].childNodes.item(Vfori).value="";
				}else if (ctrObject.type=='checkbox'){
					/* Add commonName in JSP only if you require to set Id for the checkbox to fetch value for any event handling */
					var strName = ctrObject.getAttribute("commonName");
					var deleteAllCheck = table.tBodies[0].rows[0].cells[i].childNodes.item(Vfori);

					if(deleteAllCheck != null){
						/* If a new row is added after selecting 'Delete All' checkbox,
						   the 'Delete All' checkbox is unchecked to make sure that its
						   checked only when all the checkboxes are checked. */
						deleteAllCheck.checked=false;
					}
					if(strName != null){
						// If common name attribute is set for Checkbox, a unique ID is set similar to date control.
						strName = strName+(len-1);
						ctrObject.setAttribute("id",strName);
					}
				}else if(ctrObject.tagName == 'DIV' && ctrObject.getAttribute("commonName")== null){
						//ctrObject.innerHTML="<b>"+fileId+"</b>";
						newRow.cells[i].innerHTML="<div><b>"+fileId+"</b>"+
						"<input type='hidden' id='fileName' name='fileName'	value='"+fileId+"' />"+
						"<input type='hidden' id='filePath' name='filePath'	value='"+filePath+"' /></div>";

						newRow.cells[i+1].innerHTML="" +
								"<input type='text' style='width:80px' class='ClsTextbox' id='fileDesc' maxlength='255' " +
								" name='fileDesc' value='' />";
				}else if (ctrObject.type=='button') {

				}else{
					if(newRow.cells[i].childNodes.item(Vfori).type){
						newRow.cells[i].childNodes.item(Vfori).value="";
					}
					var strName = ctrObject.getAttribute("commonName");
					if(strName != null){
						// If common name attribute is set for any child, a unique ID is set to that similar to date control.
						strName = strName+(len-1);
						ctrObject.setAttribute("id",strName);
					}if(ctrObject.tagName == "A" && ctrObject.type=="displayInEdit"){
						ctrObject.style.display = 'none';
					}
				}
			}else{
				newRow.cells[i].innerHTML="&nbsp;";
			}
	 	} else if(newRow.cells[i] && newRow.cells[i].innerText==newRow.cells[i].innerHTML){
			newRow.cells[i].innerHTML="&nbsp;";
	 	}
	}
	setTimeout(
			$("input.ClsTextboxDate").datepicker({
				showOn: 'button',
				buttonImage: getContextRoot()+'/styles/jquery/images/calendar.gif',
				buttonImageOnly: true,
				dateFormat: getDateFormat(),
				changeMonth: true,
				changeYear: true}),500
			);
}

function addRowToTable(tableId,elementsArray,typesArray,valsArray){
	arrayLength = elementsArray.length;
	typeLength = typesArray.length;

	var tabid = document.getElementById(tableId);
	var len = tabid.rows.length;

	var tr = document.createElement("TR");
	tr.setAttribute("class", "ClsTRContentListWhite");
	var td = new Array(arrayLength+1); // includes S.No
	var j=0;

	var td1=document.createElement("TD");
	td1.innerHTML=len;
	tr.appendChild(td1);
	for (var i=0; i<=arrayLength; i++){
			td[i] = document.createElement("TD");
			var elementsArrayValue=elementsArray[i];
			if(typesArray[i]== 'text'){
				td[i].innerHTML= "<input type='text' class='ClsTextbox' style='width:150px;' maxlength='50' id='"
					+elementsArrayValue+"' name='"+elementsArrayValue+"' value='" + valsArray[i] +"'/>&nbsp;";
			}else if(typesArray[i]== 'hidden'){
				td[i].style.display = 'none';
				td[i].innerHTML= "<input type='hidden' class='ClsTextbox' style='width:150px;' id='"
					+elementsArrayValue+"' name='"+elementsArrayValue+"' value='" + valsArray[i] +"'/>&nbsp;";
			}else if(typesArray[i]== 'readonlytext'){
				if(i==0){
					td[i].innerHTML= "<input type='hidden' id='"+elementsArrayValue+"' name='"
					+elementsArrayValue+"' value='" + valsArray[i] +"'/>&nbsp;"
					+"<a href='"+contextRoot+contextRoot+"/uploads"+valsArray[i+1]+"/" + valsArray[i] +
					"' target='popup'>" + valsArray[i] +"</a>&nbsp;";
				}else{
					td[i].innerHTML= "<input type='text' readonly class='ClsTextbox' style='border:none;width:150px;' id='"
						+elementsArrayValue+"' name='"+elementsArrayValue+"' value='" + valsArray[i] +"'/>&nbsp;";
				}
			}
		tr.appendChild(td[i]);
	}
	tabid.tBodies[0].appendChild(tr);
}

/***
 * Function: checkChildFromToDate
 * Arguments: array list of from & to date elements , error message
 * Return: true/false
 * Purpose:This function checks whether the from date is less than to date or not --- +/- screens only.
***/
function checkChildFromToDate(fromDateArray,toDateArray,errorMsg) {
	var count = 1;
	var tempFromDate = null;
	var tempToDate = null;
	var fromDateStr = null;
	var toDateStr = null;
	var fromDate = null;
	var fromMonth = null;
	var fromYear = null;
	var toDate = null;
	var toMonth = null;
	var toYear = null;
	var fromDateObj = null;
	var toDateObj = null;

	for(var i=0; i<fromDateArray.length; i++) {
		while (document.getElementById(fromDateArray[i] + count) != null) {
			tempFromDate = fromDateArray[i] + count;
			tempToDate = toDateArray[i] + count;

			fromDateStr = document.getElementById(tempFromDate).value;
			toDateStr = document.getElementById(tempToDate).value;

			if(toDateStr != "") {
				fromDate = fromDateStr.substring(0,fromDateStr.indexOf(dateSeparator));
				fromDateStr = fromDateStr.substring(fromDateStr.indexOf(dateSeparator)+1);
				fromMonth = fromDateStr.substring(0,fromDateStr.indexOf(dateSeparator));
				fromYear = fromDateStr.substring(fromDateStr.indexOf(dateSeparator)+1);

				toDate = toDateStr.substring(0,toDateStr.indexOf(dateSeparator));
				toDateStr = toDateStr.substring(toDateStr.indexOf(dateSeparator)+1);
				toMonth = toDateStr.substring(0,toDateStr.indexOf(dateSeparator));
				toYear = toDateStr.substring(toDateStr.indexOf(dateSeparator)+1);

				fromDateObj = new Date(fromYear,fromMonth-1,fromDate);
				toDateObj = new Date(toYear,toMonth-1,toDate);

				if(fromDateObj > toDateObj) {
					displayError("In row " + count + ", " + errorMsg);
					return false;
				}
			}
			count++;
		}
	}
	displayError("");
	return true;
}

function checkChildFromToDateDetails(fromDateArray,toDateArray,msgArray,headLabel) {
	var count = 1;
	var tempFromDate = null;
	var tempToDate = null;
	var fromDateStr = null;
	var toDateStr = null;
	var fromDate = null;
	var fromMonth = null;
	var fromYear = null;
	var toDate = null;
	var toMonth = null;
	var toYear = null;
	var fromDateObj = null;
	var toDateObj = null;

	for(var i=0; i<fromDateArray.length; i++) {
		while (document.getElementById(fromDateArray[i] + count) != null) {
			tempFromDate = fromDateArray[i] + count;
			tempToDate = toDateArray[i] + count;

			fromDateStr = document.getElementById(tempFromDate).value;
			toDateStr = document.getElementById(tempToDate).value;

			fromDate = fromDateStr.substring(0,fromDateStr.indexOf(dateSeparator));
			fromDateStr = fromDateStr.substring(fromDateStr.indexOf(dateSeparator)+1);
			fromMonth = fromDateStr.substring(0,fromDateStr.indexOf(dateSeparator));
			fromYear = fromDateStr.substring(fromDateStr.indexOf(dateSeparator)+1);

			toDate = toDateStr.substring(0,toDateStr.indexOf(dateSeparator));
			toDateStr = toDateStr.substring(toDateStr.indexOf(dateSeparator)+1);
			toMonth = toDateStr.substring(0,toDateStr.indexOf(dateSeparator));
			toYear = toDateStr.substring(toDateStr.indexOf(dateSeparator)+1);

			fromDateObj = new Date(fromYear,fromMonth-1,fromDate);
			toDateObj = new Date(toYear,toMonth-1,toDate);

			if(fromDateObj > toDateObj) {
				displayError(headLabel +" In row " + count + ", " + msgArray[0]+" should not be greater than "+msgArray[1]);
				return false;
			}
			count++;
		}
	}
	displayError("");
	return true;
}

/***
 * Function: checkChildTextAreaMaxlength
 * Arguments: objArray-arralist of elements, maxLen, pMsgArray-arralist of mandatory elements Labels
 * Return: true/false
 * Purpose: checkS the maxlength of value in textarea.
***/
function checkChildTextAreaMaxlength(objArray, maxLenArray, pMsgArray, childsLabel){
	for(var i=0;i<objArray.length;i++){
		childs = document.getElementsByName(objArray[i]);
		for (var j=0,k=1;j<childs.length;j++,k++) {
			val=Trim(childs[j].value);

			if(val!= null){
				if(val.length > maxLenArray[i]){
					displayError(" In " + childsLabel + " row "+k+ ", length of "+pMsgArray[i] + " should not exceed " + maxLenArray[i]+" characters.");
					return false;
				}
			}
		}
	}
	return true;
}


/***
 * Function: isChildNonZeroNumber
 * Arguments: element Value-parm, error message-pMsg
 * Return: true/false
 * Purpose: Checks whether the given element is number as well as non-zero or not.
***/
function isChildNonZeroNumber(objArray,pMsgArray,headerLabel) {
	var val = null;
	var childs = null;

	for(var i=0;i<objArray.length;i++) {
	childs = document.getElementsByName(objArray[i]);
	 for (var j=0,k=1;j<childs.length;j++,k++) {
	 val =Trim(childs[j].value);
	 if(val == "0"){
		 displayError("In " +headerLabel+" row "+k+", "+pMsgArray[i]+" should not be Zero.");
		 return false;
	 }
	}
	}
	return true;
}

/***
 * Function: checkChildDateWithPresentDate
 * Arguments: array list of from Date elements,Present Date, error message, header label
 * Return: true/false
 * Purpose: Checks whether the from date is greater than Present Date or not.
***/
function checkChildDateWithPresentDate(fromDateArray,presentDate,msgArray,headLabel) {
	var count = 1;
	var tempFromDate = null;
	var tempToDate = null;
	var fromDateStr = null;
	var toDateStr = null;
	var fromDate = null;
	var fromMonth = null;
	var fromYear = null;
	var toDate = null;
	var toMonth = null;
	var toYear = null;
	var fromDateObj = null;
	var toDateObj = null;

	for(var i=0; i<fromDateArray.length; i++) {
		while (document.getElementById(fromDateArray[i] + count) != null) {
			toDateStr = presentDate;
			tempFromDate = fromDateArray[i] + count;
			fromDateStr = document.getElementById(tempFromDate).value;
			fromDate = fromDateStr.substring(0,fromDateStr.indexOf(dateSeparator));
			fromDateStr = fromDateStr.substring(fromDateStr.indexOf(dateSeparator)+1);
			fromMonth = fromDateStr.substring(0,fromDateStr.indexOf(dateSeparator));
			fromYear = fromDateStr.substring(fromDateStr.indexOf(dateSeparator)+1);

			toDate = toDateStr.substring(0,toDateStr.indexOf(dateSeparator));
			toDateStr = toDateStr.substring(toDateStr.indexOf(dateSeparator)+1);
			toMonth = toDateStr.substring(0,toDateStr.indexOf(dateSeparator));
			toYear = toDateStr.substring(toDateStr.indexOf(dateSeparator)+1);

			fromDateObj = new Date(fromYear,fromMonth-1,fromDate);
			toDateObj = new Date(toYear,toMonth-1,toDate);

			if(fromDateObj > toDateObj) {
				displayError("In "+headLabel +" row " + count + ", " + msgArray[0]+" should not be greater than "+msgArray[1]);
				return false;
			}
			count++;
		}
	}
	displayError("");
	return true;
}

/***
 * Function: checkChildMandatoryAll
 * Arguments: array of mandatory fields, array of mandatory field labels, array of non mandatory fields, childs header label
 * Return: true/false
 * Purpose: Checks whether all the child mandatory fields have being entered if the user enters atleast one field.
        Otherwise the entire child row is not mandatory.
***/
function checkChildMandatoryAll(tableId, mandatoryFieldsArray, mandatoryFieldLabelsArray, nonMandatoryFieldsArray, childsLabel) {
	var mandatoryFields = null;
	var nonMandatoryFields = null;
	var columnCount = 0;
	var i = 0;
	var j = 0;
	var l = 0;
	var mandatoryCount = 0;
	//var rowCount = document.getElementsByName(mandatoryFieldsArray[0]).length;
	var table = document.getElementById(tableId);
	var rowCount = parseInt(table.tBodies[0].rows.length) - parseInt(1);
	var flag = 0;
	var errorString = "";

	for(l=0; l<mandatoryFieldLabelsArray.length; l++) {
		errorString = errorString + ", " + mandatoryFieldLabelsArray[l];
	}
	errorString = errorString.substring(parseInt(errorString.indexOf(",")+1), errorString.length);

	for(var a=0; a<rowCount; a++) {

		for(i=0;i<mandatoryFieldsArray.length;i++) {
			mandatoryFields = document.getElementsByName(mandatoryFieldsArray[i]);

			if(mandatoryFields.length == 0) {
				if(Trim(document.getElementById(mandatoryFieldsArray[i]+parseInt(a+1)).value) != "") {
					mandatoryCount++;
				}
			} else {
				if(Trim(mandatoryFields[j].value) != "") {
					mandatoryCount++;
				}
			}
			columnCount++;

			if(parseInt(columnCount) == parseInt(mandatoryFieldsArray.length)) {
				if(mandatoryCount > 0) {
					if(mandatoryCount != mandatoryFieldsArray.length) {
						displayError("In " + childsLabel + " row " + parseInt(a+1) + ", " + errorString + " are all mandatory to save the record.");
						return false;
					}
					j++;
				} else {
					flag = 1;
				}
			}
		}

		if(flag > 0) {
		for(var k=0; k<nonMandatoryFieldsArray.length; k++) {
			nonMandatoryFields = document.getElementsByName(nonMandatoryFieldsArray[k]);

			if(nonMandatoryFields.length == 0) {
				if(Trim(document.getElementById(nonMandatoryFieldsArray[k]+parseInt(a+1)).value) != "") {
					displayError("In " + childsLabel + " row " + parseInt(a+1) + ", " + errorString + " are all mandatory to save the record.");
					return false;
				}
			} else {
				if(Trim(nonMandatoryFields[j].value) != "") {
					displayError("In " + childsLabel + " row " + parseInt(a+1) + ", " + errorString + " are all mandatory to save the record.");
					return false;
				}
			}
		}
		j++;
	}

	flag = 0;
	columnCount = 0;
	mandatoryCount = 0;
	}
	return true;
}

/***
 * Function: isChildNonZeroFloat
 * Arguments: array of child elements, array of error messages, childs header label
 * Return: true/false
 * Purpose:This is function used to check whether the given child float element is non-zero or not.
***/
function isChildNonZeroFloat(objArray,pMsgArray,headerLabel) {

	var val = null;
	var childs = null;

	for(var i=0; i<objArray.length; i++) {
		childs = document.getElementsByName(objArray[i]);
	 	for (var j=0,k=1; j<childs.length; j++,k++) {
	 		val = Trim(childs[j].value);
	 		if(val.length > 0){
		 		if(val == "0" || val == "0.0" || val == "0.00" || Math.round(val)==0) {
			 		displayError("In " +headerLabel + " row " + k + ", " + pMsgArray[i] + " should not be Zero.");
			 		return false;
		 		}
	 		}
		}
	}
	return true;
}

/***
 * Function: checkAtleastOneChild
 * Arguments: selectAllCheckBoxId - DeleteAll Checkbox Id, childTblMsg - Table Name
 * Return:
 * Purpose: Checks if atleast one child is present while save a record in Edit case.
 * 		This function just verifies if the Delete All checkbox is checked.
***/
function checkAtleastOneChild(selectAllCheckBoxId, childTblMsg) {
	if(document.getElementById(selectAllCheckBoxId) != null){
		if(document.getElementById(selectAllCheckBoxId).checked){
			displayError("Failed to save the record. Atleast one "+childTblMsg +" record is mandatory.");
			return false;
		}
	}
	return true;
}

/***
 * Function: appearOnlyOnceInNamedElements
 * Arguments: Element Name:elename , Value to check with: val, delete CheckBox ID
 * Return: true/false
 * Purpose: Checks whether the given value is appearing only once in the given Array of named values.
 * 		If the value doesn't appear at all or if it appears more than once the function returns false.
 * 		It also take care whether a child is scheduled for delete by verifying whether delete check box is ticked or not
***/
function appearOnlyOnceInNamedElements(elename,val,delCheckId) {
    var cnt = 0;
	var arr = document.getElementsByName(elename)
	var delChecks = document.getElementsByName(delCheckId)
	for(i=0;i<arr.length;i++){
		if(arr[i].value == val){
			if(delChecks.length > 0 && !delChecks[i].checked)
				cnt = cnt +1;
			else if(delChecks.length == 0)
				cnt = cnt +1;
		}
	}
	if(cnt == 1) return true;
	else return false;
}

function isAtleastOneChildNonZeroFloat(objArray,pMsgArray,headerLabel) {

  	var val = null, childs = null, count = 0;

  	for(var i=0; i<objArray.length; i++) {
  		childs = document.getElementsByName(objArray[i]);

  		for (var j=0,k=1; j<childs.length; j++,k++) {
  			val = (Trim(childs[j].value)-0);
  			if(val <= 0 || val <= 0.0 || val <= 0.00) count++;
  			else return true;

  		}
  	}
  	i--;
  	if (count == childs.length) {
  		displayError(pMsgArray[i] + " should be greater than Zero for atleast one Child.");
  		return false;
  	}
}

/***
 * Function: checkChildValidAmount
 * Arguments: element Id Array, elemLabel Array, headerLabel
 * Return: true/false
 * Purpose: Check whether the given element's value is in valid Amount format or not.
 * Notes: Precision : 15 Scale: 2 Valid Examples : 100.00 or 100 Invalid :100.000 or .00
***/
function checkChildValidAmount(elemIdArray,elemLabelArray, headerLabel) {
	var amountRegExp = /^\d{1,13}(\.\d{1,2})?$/;
	var val=null;
	var element=null;
	if(!checkChildFloatDetails(elemIdArray,elemLabelArray, headerLabel)) return false;

	for(var i=0;i<elemIdArray.length;i++){
		element = document.getElementsByName(elemIdArray[i]);
		for(var j=0,k=1;j<element.length;j++,k++){
			val = Trim(element[j].value);
			if(val!="" && val.length>0){
				if(!(amountRegExp.test(val))){
					displayError(headerLabel+" In Row "+k+", Amount in " + elemLabelArray[i] + "is Invalid. Valid amount needs to be in the format xxx.xx. Max allowed precison is 15 and scale is 2");
					return false;
				}
			}
		}
	}
	return true;
}

/*****************************************************
Function: checkChildValidDistanceOrArea
Arguments: element Id Array, elemLabel Array, headerLabel
Return: true/false
Purpose:This function is used to check whether the given element's value is in valid Distance or Area format or not.
Notes: Precision : 12 Scale: 3 Valid Examples : 100.00 or 100 Invalid :100.000 or .00
*****************************************************/

function checkChildValidDistanceOrArea(elemIdArray,elemLabelArray, headerLabel) {
var amountRegExp = /^\d{1,9}(\.\d{1,3})?$/;
var val = null;
var element=null;
if(!checkChildFloatDetails(elemIdArray,elemLabelArray, headerLabel))
{return false;
}
for(var i=0;i<elemIdArray.length;i++)
{
	element = document.getElementsByName(elemIdArray[i]);
	for(var j=0,k=1;j<element.length;j++,k++){
		val = Trim(element[j].value);
	if(!(amountRegExp.test(val))){
		displayError(headerLabel+" In Row "+k+", Value in " + elemLabelArray[i] + "is Invalid. Valid value needs to be in the format xxx.xxx. Max allowed precison is 12 and scale is 3");
	    return false;
	}
	}
}
return true;
}

function addPreviousRowToTableModified(tableId,href,filePath,fileId){
	$('input.ClsTextboxDate').datepicker('destroy');
	table = document.getElementById(tableId);
	var newRow = table.tBodies[0].rows[0].cloneNode(true);

	 //modify newRow as appropriate
	table.tBodies[0].appendChild(newRow);
	var len = table.rows.length;
	// For S.No
	newRow.cells[0].innerHTML = len-1;

	var Vfori;
	if (navigator.appName == "Microsoft Internet Explorer")
		Vfori=0;
	else
		Vfori=1;

	for (var i=1;i<=newRow.cells.length;i++)
	{
		if(newRow.cells[i] && newRow.cells[i].innerText!=newRow.cells[i].innerHTML)
		{
			var ctrObject = newRow.cells[i].childNodes.item(Vfori);
			if(ctrObject.type=='hidden')
			{
				ctrObject.value="0";
			} else if (ctrObject.type=='text')
			{
				if(ctrObject.getAttribute("isDateControl")=="true")
				{

					var strName = ctrObject.getAttribute("commonName");
					strName = strName+(len-1);
					ctrObject.setAttribute("id",strName);
					ctrObject.setAttribute("name",strName);

				}
				newRow.cells[i].childNodes.item(Vfori).value="";
			} else if (ctrObject.type=='select-one')
			{
				newRow.cells[i].childNodes.item(Vfori).value="";
			}
			else if (ctrObject.type=='checkbox')
			{
				/* Add commonName in JSP only if you require to set Id for the checkbox to fetch value for any event handling */
				var strName = ctrObject.getAttribute("commonName");
				var deleteAllCheck = table.tBodies[0].rows[0].cells[i].childNodes.item(Vfori);

				if(deleteAllCheck != null)
				{
					/* If a new row is added after selecting 'Delete All' checkbox,
					   the 'Delete All' checkbox is unchecked to make sure that its
					   checked only when all the checkboxes are checked. */
					deleteAllCheck.checked=false;
				}
				if(strName != null){
					// If common name attribute is set for Checkbox, a unique ID is set similar to date control.
					strName = strName+(len-1);
					ctrObject.setAttribute("id",strName);
				}
			}else if(ctrObject.tagName == 'DIV' && ctrObject.getAttribute("commonName")== null)
			{
					//ctrObject.innerHTML="<b>"+fileId+"</b>";
					newRow.cells[i].innerHTML="<div><b>"+href+"</b>"+
					"<input type='hidden' id='fileName' name='fileName'	value='"+fileId+"' />"+
					"<input type='hidden' id='filePath' name='filePath'	value='"+filePath+"' /></div>";

					newRow.cells[i+1].innerHTML="" +
							"<input type='text' style='width:80px' class='ClsTextbox' id='fileDesc' maxlength='255' " +
							" name='fileDesc' value='' />";
			}else if (ctrObject.type=='button')
			{

			}else
			{
				if(newRow.cells[i].childNodes.item(Vfori).type)
				{
					newRow.cells[i].childNodes.item(Vfori).value="";
				}
				var strName = ctrObject.getAttribute("commonName");
				if(strName != null)
				{
					// If common name attribute is set for any child, a unique ID is set to that similar to date control.
					strName = strName+(len-1);
					ctrObject.setAttribute("id",strName);
				}
				if(ctrObject.tagName == "A" && ctrObject.type=="displayInEdit")
				{
					ctrObject.style.display = 'none';
				}
			}
	 	} else if(newRow.cells[i] && newRow.cells[i].innerText==newRow.cells[i].innerHTML)
	 	{
			newRow.cells[i].innerHTML="&nbsp;";
	 	}
	}
	setTimeout(
			$("input.ClsTextboxDate").datepicker({
				showOn: 'button',
				buttonImage: getContextRoot()+'/styles/jquery/images/calendar.gif',
				buttonImageOnly: true,
				dateFormat: getDateFormat(),
				changeMonth: true,
				changeYear: true}),500
			);
}
/****************************************** Ajax Related Functions ******************************************/
function ajaxResort(id){
	var intIndex = document.getElementById('idTabberIndex').value;
	var url = arrayUrls[intIndex];
	var strOrderby = document.getElementById('OrderBy').value;
	var strSortby = document.getElementById('SortBy').value;

	if(strOrderby==id){
		if(strSortby=="desc") document.getElementById('SortBy').value="asc";
		else document.getElementById('SortBy').value="desc";
	}else{
		document.getElementById('SortBy').value="asc";
	}
	document.getElementById('OrderBy').value=id;
	strOrderby = document.getElementById('OrderBy').value;
	strSortby = document.getElementById('SortBy').value;
	url = url+"&SortBy="+strSortby+"&OrderBy="+strOrderby;
	var strTabName =getTabName();
	var div = document.getElementById(strTabName+"Tab");
	new Ajax.Updater(div,url, {method: 'get',evalScripts:true});
}

function ajaxResortDate(id){
	var intIndex = document.getElementById('idTabberIndex').value;
	var url = arrayUrls[intIndex];
	var strOrderby = document.getElementById('OrderBy').value;
	var strSortby = document.getElementById('SortBy').value;

	if(strOrderby==id || strOrderby=="to_date("+id+",'dd-mm-yyyy')"){
		if(strSortby=="desc") document.getElementById('SortBy').value="asc";
		else document.getElementById('SortBy').value="desc";
	}else{
		document.getElementById('SortBy').value="asc";
	}
	document.getElementById('OrderBy').value="to_date("+id+",'dd-mm-yyyy')";
	strOrderby = document.getElementById('OrderBy').value;
	strSortby = document.getElementById('SortBy').value;
	url = url+"&SortBy="+strSortby+"&OrderBy="+strOrderby;
	var strTabName = getTabName();
	var div = document.getElementById(strTabName+"Tab");
	new Ajax.Updater(div,url, {method: 'get',evalScripts:true});
}

function getTabName(){
	var arrayDivs = document.getElementsByTagName("div");
		for(var i=0;i<arrayDivs.length;i++) {
	 	 if(arrayDivs[i].className=='tabberlive') {
			  var arrNodes = arrayDivs[i].childNodes[0].childNodes;
			  for(var j=0; j<arrNodes.length;j++) {
				  var objNode = arrNodes[j];
				  if(objNode.className=='tabberactive') {
					  var strName = Trim(objNode.childNodes[0].innerHTML);
					  return strName;
				  }
		 	 }
  		}
	}
	return "";
}

function clearRadioButton(tableId) {
	var tableBody = document.getElementById(tableId).tBodies[0];
	var trChild = null;
	var tdChild = null;
	var element = null;

	for(var i=0; i<tableBody.childNodes.length; i++) {
		trChild = tableBody.childNodes[i];
		for(var j=0; j<trChild.childNodes.length; j++) {
			tdChild =  trChild.childNodes[j];

			for(k=0; k<tdChild.childNodes.length; k++) {
				element = tdChild.childNodes[k];

				if(element.type == "radio") {
					element.value = "";
				}
			}
		}
	}
}


/*****************************************************
Function: isNameAlphaSpecial
Arguments: arralist of elements to be validated, arralist of label msgs of elements to be validated
Return: true/false
Purpose:This is function used to check whether the given element is aplanumeric plus the allowed special characters or not, this function internally calls
 the generic isValid function passing alphaNumeric argument as validation range, which returns true/false for the given element.
This functions loops each element in the objArray to validate each element & show an error msg as per label of the element.
Notes:
*****************************************************/
function isNameAlphaSpecial(objArray,pMsgArray) {
	var lwr = 'abcdefghijklmnopqrstuvwxyz';
	var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var spChar=' '+'_-/,.()[]&@\'';
	var str = lwr+upr+spChar;
	var val  =null;

	for(var i=0;i<objArray.length;i++) {
		val =Trim(document.getElementById(objArray[i]).value);
		if(!isValid(val,str," Invalid " + pMsgArray[i] + ". Valid " + pMsgArray[i] + " contains only Alphabets (a-z)(A-Z), Special Characters "+spChar+" and Spaces.")) {
			return false;
		}
	}
	return true;
}

/*****************************************************
Function: checkLongNumber
Arguments: element Value-parm, error message-pMsg
Return: true/false
Purpose:This function used to check whether the given element is Long or not, and also it should not start with
 		  a zero. This function internally calls the generic isValid function passing number argument as validation range,
 		  which returns true/false for the given element.
Notes:
*****************************************************/
function checkLongNumber(parm,pMsg) {
		var numb = '0123456789';
		var val =Trim(document.getElementById(parm).value);
		if(val <= 0) {
			displayError(" Invalid " + pMsg + ". Valid " + pMsg + " should be greater than zero");
			return false;
		}
		else if(val.charAt(0)==0) {
			displayError(pMsg+" should not start with a Zero.");
			return false;
		}
		else
			return isValid(val,numb," Invalid " + pMsg + ". Valid " + pMsg + " contains only Numbers (0-9)");
	}

/*****************************************************
Function: checkNumberExactLength
Arguments: element,label name,length
Return: true/false
Purpose:This is function used to check the length of the given number,
 it returns false if the length is not equal to the length argument passed.
Notes:
*****************************************************/
function checkNumberExactLength(obj,pMsg,len){
	var numb = '0123456789';
	var val =Trim(document.getElementById(obj).value);

	if(!isValid(val,numb," Invalid " + pMsg + ". Valid " + pMsg + " contains only Numbers (0-9)")){
		return false;
	}

	if ((Trim(val)).length==len){
		return true;
	}
	displayError(" Length of " + pMsg+" should be "+len+" digits.");
	return false;
}

/*****************************************************
Function: checkChildValidPercentage
Arguments: ArrayList of elements,label name,Child's label
******************************************************/
function checkChildValidPercentage(objArray,pMsg,childsLabel) {
	var amountRegExp = /^\d{1,3}(\.\d{1,2})?$/;
	var childs = null;
	var test = null;
	for(var i=0;i<objArray.length;i++){ // outer
	childs = document.getElementsByName(objArray[i]);
	 for (var j=0,k=1;j<childs.length;j++,k++) {
	 if ((Trim(childs[j].value)).length>0 && (Trim(childs[j].value))!=null && (Trim(childs[j].value))!=""){
	 test = amountRegExp.test(childs[j].value);
		if(!test){
		displayError(" In "+childsLabel+" row "+k+", "+pMsg+" is invalid. Valid "+pMsg+" contains only numbers and '.'.");
		 return false;
	 }
	 }
	 if((Trim(childs[j].value))>100){
	   displayError(" In "+childsLabel+" row "+k+", "+pMsg+" is invalid. Valid "+pMsg+" should not be greater than 100.");
	   return false;
	 }
	 }
	}
	return true;
}

function replaceAll(txt, replace, with_this) {
	  return txt.replace(new RegExp(replace, 'g'),with_this);
}

function isValidUID(elemId,elemLabel) {
	var uidRegExp = /^\d{12}$/;
	var val=null;
	val = Trim(document.getElementById(elemId).value);
	if(val!="" && val.length > 0)
	{
		if(isNumber(elemId,elemLabel))
		{
			if(!(uidRegExp.test(val))){
				displayError(" Invalid " + elemLabel + ". Valid " + elemLabel + " needs to be a 12 digit number");
			    return false;
			}
		} else {
			return false;
		}
	}

	return true;
}

function isValidPINCode(elemId,elemLabel) {
	var uidRegExp = /^\d{6}$/;
	var val=null;
	val = Trim(document.getElementById(elemId).value);
	if(val!="" && val.length > 0)
	{
		if(isNumber(elemId,elemLabel))
		{
			if(val == "000000")
			{
				displayError(" Invalid " + elemLabel + ". Valid " + elemLabel + " should not contain all zeros.");
				return false;
			}
			if(!(uidRegExp.test(val))){
				displayError(" Invalid " + elemLabel + ". Valid " + elemLabel + " needs to be a 6 digit number");
			    return false;
			}
		} else {
			return false;
		}
	}

	return true;
}

function isValidFASAccountNumber(elemId)
{
	var accountNumberRegExp = /^\d{13}$/;
	if(checkChildMandatory(new Array(elemId))){
		var childs = document.getElementsByName(elemId);
		for (var j=0;j<childs.length;j++) {
			var val = Trim(childs[j].value);
			if(!accountNumberRegExp.test(val)){
				displayError(val + " is an invalid Account Number. Valid Account number needs to be a 13 digit number.");
				return false;
			}
		}
	}else{
		return false;
	}		
	return true;	
}


function confirmSendMail(){
	if(confirm("Are you sure to send mail")){
		return true;
	}else{
		return false;
	}
}
