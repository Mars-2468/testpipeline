<script type="text/javascript" src="<c:out value="${contextRoot}"/>/scripts/jquery/jquery.ajaxfileupload.js"></script>
<script type="text/javascript">
<%@page import="com.mars.common.utils.Constants"%>
<% 
pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);

%>
$( document ).ready(function() {
	
	 (function($) {
		    $.fn.ajaxfileupload = function(options) {
		        var settings = {
		          params: {},
		          action: '',
		          onStart: function() { },
		          onComplete: function(response) { },
		          onCancel: function() { },
		          validate_extensions : true,
		          valid_extensions : ['pdf','PDF'],
		          submit_button : null
		        };

		        var uploading_file = false;

		        if ( options ) { 
		          $.extend( settings, options );
		        }


		        // 'this' is a jQuery collection of one or more (hopefully) 
		        //  file elements, but doesn't check for this yet
		        return this.each(function() {
		          var $element = $(this);

		          // Skip elements that are already setup. May replace this 
		          //  with uninit() later, to allow updating that settings
		          if($element.data('ajaxUploader-setup') === true) return;

		          $element.change(function()
		          {
		            // since a new image was selected, reset the marker
		            uploading_file = false;

		            // only update the file from here if we haven't assigned a submit button
		            if (settings.submit_button == null)
		            {
		              upload_file();
		            }
		          });

		          if (settings.submit_button == null)
		          {
		            // do nothing
		          } else
		          {
		            settings.submit_button.click(function(e)
		            {
		              // Prevent non-AJAXy submit
		              e.preventDefault();
		              
		              // only attempt to upload file if we're not uploading
		              if (!uploading_file)
		              {
		                upload_file();
		              }
		            });
		          }

		          var upload_file = function()
		          {
		            if($element.val() == '') return settings.onCancel.apply($element, [settings.params]);

		            // make sure extension is valid
		            var ext = $element.val().split('.').pop().toLowerCase();
		            var uid = document.getElementById('applicantAddress.mobileNumber').value;
		            if(uid=""){
		            	settings.onComplete.apply($element, [{status: false, message: 'Please enter the Mobile Number to upload the documents.'}, settings.params]);
		            } else if(true === settings.validate_extensions && $.inArray(ext, settings.valid_extensions) == -1){
		            	 // Pass back to the user
			              settings.onComplete.apply($element, [{status: false, message: 'The select file type is invalid. File must be ' + settings.valid_extensions.join(', ') + '.'}, settings.params]);
					}else
		            { 
		              uploading_file = true;

		              // Creates the form, extra inputs and iframe used to 
		              //  submit / upload the file
		              wrapElement($element);

		              // Call user-supplied (or default) onStart(), setting
		              //  it's this context to the file DOM element
		              var ret = settings.onStart.apply($element, [settings.params]);

		              // let onStart have the option to cancel the upload
		              if(ret !== false)
		              {
		                $element.parent('form').submit(function(e) { e.stopPropagation(); }).submit();
		              } else {
		                uploading_file = false;
		              }
		            }
		          };

		          // Mark this element as setup
		          $element.data('ajaxUploader-setup', true);

		          /*
		          // Internal handler that tries to parse the response 
		          //  and clean up after ourselves. 
		          */
		          var handleResponse = function(loadedFrame, element) {
		            var response, responseStr = $(loadedFrame).contents().text();
		            try {
		              //response = $.parseJSON($.trim(responseStr));
		              response = JSON.parse(responseStr);
		            } catch(e) {
		              response = responseStr;
		            }

		            // Tear-down the wrapper form
		            element.siblings().remove();
		            element.unwrap();

		            uploading_file = false;

		            // Pass back to the user
		            settings.onComplete.apply(element, [response, settings.params]);
		          };

		          /*
		          // Wraps element in a <form> tag, and inserts hidden inputs for each
		          //  key:value pair in settings.params so they can be sent along with
		          //  the upload. Then, creates an iframe that the whole thing is 
		          //  uploaded through. 
		          */
		          var wrapElement = function(element) {
		            // Create an iframe to submit through, using a semi-unique ID
		            var frame_id = 'ajaxUploader-iframe-' + Math.round(new Date().getTime() / 1000)
		            $('body').after('<iframe width="0" height="0" style="display:none;" name="'+frame_id+'" id="'+frame_id+'"/>');
		            $('#'+frame_id).get(0).onload = function() {
		              handleResponse(this, element);
		            };

		            // Wrap it in a form
		            element.wrap(function() {
		              return '<form action="' + settings.action + '" method="POST" enctype="multipart/form-data" target="'+frame_id+'" />'
		            })
		            // Insert <input type='hidden'>'s for each param
		            .before(function() {
		              var key, html = '';
		              for(key in settings.params) {
		                var paramVal = settings.params[key];
		                if (typeof paramVal === 'function') {
		                  paramVal = paramVal();
		                }
		                html += '<input type="hidden" name="' + key + '" value="' + paramVal + '" />';
		              }
		              return html;
		            });
		          }
		        });
		      }
		})( jQuery )
});

//var $f1, $f2, $f3;
 function readURL(event) {
	// $('#SetFormHeight *').removeAttr('disabled');
	 var licAppliNumber =document.getElementById("rtiApplicationRefIds").value;
	// alert("hiii birthRegistrationId"+birthRegistrationId);
	 /* if(licAppliNumber==0 || licAppliNumber.length == 0 || licAppliNumber==null || licAppliNumber===''){
 		 alert("Please generate the certificate.");
 	 }else  */if(documentUploadStatus(event)){
	 
	    $f1 = $("#idProof");
	   // $f2 = $("#residProof");
	   // $f3 = $("#inspectionreport1");
	   
	 //event.stopPropagation(); // Stop stuff happening
	   // event.preventDefault(); // Totally stop stuff happening

	    // START A LOADING SPINNER HERE

	    // Create a formdata object and add the files
	    
	    var data = new FormData();
	    if($f1.val()){
		    if($f1.get(0).files.length>0){
			    for(i=0;i<$f1.get(0).files.length;i++){
			    	data.append('idProof', $f1.get(0).files[i]);
					    }
				    }
	           }
	  
	    var uid1;
	    var appType =1;//document.getElementById("applicationType").value;
	   uid1 = document.getElementById('rtiApplicationRefIds').value;
	    if(uid1!=null && uid1 != ""){
	    	uid1 = document.getElementById('rtiApplicationRefIds').value;
	    }else{
	    	uid1 = document.getElementById('applicantAddress.mobileNumber').value;
		    }
	    		
	    $.ajax({
	        url: "<c:out value='${contextRoot}'/>/rtiapplication/uploadCFCLicenseDocs.do?appType="+appType+"&UID="+uid1,
	        type: 'POST',
	        data: data,
	        cache: false,
	        dataType: 'json',
	        processData: false, // Don't process the files
	        contentType: false, // Set content type to false as jQuery will tell the server its a query string request
	        async: false,
	        success: function(data, textStatus, jqXHR)
	        { 
	        	 var status = data.status;
	        
	        	 if(status===true){
	        		    alert("Upload has been done successfully!");
	        		    window.location.reload(); 
	        		    }else{
	        		    alert("Upload has been failed !");
	        	 }
	        },
	        error: function(jqXHR, textStatus, errorThrown)
	        {
	            // Handle errors here
	            
	            console.log('ERRORS: ' + textStatus);
	            // STOP LOADING SPINNER
	        }
	    });
	   	    	 
	  
	    
	  }
}
 

function documentUploadStatus(event){
	if(event.id == 'idProof'){
	 var idProofObj = document.getElementById('idProof');
	 if(((idProofObj.value == null || idProofObj.value == "") && idProofObj.id =='idProof')){
				       alert("Please Upload Valid Document");
			               return false;
			}
			else if(idProofObj.value != null && idProofObj.value != "" && idProofObj.id =='idProof'){
					 var ext = idProofObj.value.substring(idProofObj.value.lastIndexOf('.') + 1);
					 
			         if(ext =="pdf" || ext=="PDF"){
			         	return true;
			         }
			         else{
			         	alert("Please attach pdf's only.");
			             return false;
			         }
			}
	}
	if(event.id == 'residProof'){
    var residProofObj = document.getElementById('residProof');
	if (((residProofObj.value == null || residProofObj.value == "") && residProofObj.id == 'residProof')) {
			alert("Please Upload Dog Photo.");
			return false;
		} else if (residProofObj.value != null && residProofObj.value != "" && residProofObj.id == 'residProof') {
			var ext = residProofObj.value.substring(residProofObj.value.lastIndexOf('.') + 1);

			if (ext == "pdf" || ext == "PDF") {
				return true;
			} else {
				alert("Please attach pdf's only.");
				return false;
			}
		}
	}
	
	if(event.id == 'inspectionreport1'){
	    var inspectionreport1Obj = document.getElementById('inspectionreport1');
		if (((inspectionreport1Obj.value == null || inspectionreport1Obj.value == "") && inspectionreport1Obj.id == 'inspectionreport1')) {
				alert("Please Upload Inspection Report I.");
				return false;
			} else if (inspectionreport1Obj.value != null && inspectionreport1Obj.value != "" && inspectionreport1Obj.id == 'inspectionreport1') {
				var ext = inspectionreport1Obj.value.substring(inspectionreport1Obj.value.lastIndexOf('.') + 1);
			
				if (ext == "pdf" || ext == "PDF") {
					return true;
				} else {
					alert("Please attach pdf's only.");
					return false;
				}
			}
		}
	return true;

	}

 
 function selectLicenseoninspectionupload(frm,id){
		var arrRequiredElements = new Array('searchApplicationNo');
		var arrRequiredElementsMessages = new Array('Application Number');
		var isNewLicenceAppl = document.getElementById('isNewLicenceAppl').value;
		
		if(isNewLicenceAppl=="1"){
			if(id==1){
			if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages)) {
				navigate(frm,'<c:out value="${contextRoot}"/>/wardservice/manageDogLicence.do?uploadflag='+id);
			}
		}else{
			navigate(frm,'<c:out value="${contextRoot}"/>/wardservice/manageDogLicence.do?uploadflag='+id);
			}
		}else{
			if(id==1){
				if(checkMandatoryDetailed(arrRequiredElements,arrRequiredElementsMessages)) {
					navigate(frm,'<c:out value="${contextRoot}"/>/wardservice/manageDogLicenceRenovation.do?uploadflag='+id);
				}
			}else{
				navigate(frm,'<c:out value="${contextRoot}"/>/wardservice/manageDogLicenceRenovation.do?uploadflag='+id);
				}
		}
		}


	
 


 window.onload = function() {
 	<c:if test="${not empty requestScope.docsUploadmessage}">
 		  alert("Upload has been done successfully!");
     </c:if>
 };
 
 
 
 
 function download1(id) {
	  
		
	 	    alert("Are you sure you want to issue certificate with DSC ?");
	 	  document.getElementById('rtiApplicationRefId').value = id;


	 	  $.ajax({
	 		  url: "<c:out value='${contextRoot}'/>/mobileapp/rts/DigitalSignRequestString/"+id,
	 		
	 	        type: 'GET',
	 	        dataType: 'xml',
	 	        success: function(response) {

	 	        	 console.log(response);
	 		     
	 		       
	 		            var status = $(response).find("fileName").text();
	 		            console.log("Status"+status);
	 		       
	 		     
	 		        $.ajax({
	 			        url: "http://127.0.0.1:1620",
	 			        type: 'POST',
	 			        data: status,
	 			     
	 			        processData: false, // Don't process the files
	 			        contentType: 'application/xml', // Set content type to false as jQuery will tell the server its a query string request
	 			     
	 				      
	 				      
	 			       
	 			        success: function(status) {
	 				       
	 			            console.log("Successd"+status);
	 			         
	 			            document.getElementById('responseData').value = status;
	 			            console.log("After @@@"+status);
	 			      	  onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/DigitalSignResponse.do');
	 			      	  
	 			           
	 			        },
	 			        error: function(xhr) {
	 			        	  alert("failed POST");
	 			        	  console.log("failed"+status);
	 			            console.log(xhr.responseText);
	 			        }
	 			    });
	 		        
	 	         
	 		      /*    } else {
	 			            console.log("No <fileName> elements found ");
	 			          }
	 			        } else {
	 			          console.log("No <request> elements found in XML");
	 			        }*/
	 			        
	 		    
	 	    },
	 	        error: function(xhr) {
	 	        	  alert("failed GET");
	 	            console.log(xhr.responseText);
	 	        }
	 	    });

	 	
	 	  
	 	//  onPageSubmit('<c:out value="${contextRoot}"/>/rtiApplicationReport/'+url);
	 return false;

	 	}

	 	function certificateDownload(filesPath) {
	 	    var encodedFilePath = encodeURIComponent(filesPath);

	 	    var encodedFilesPath = btoa(encodedFilePath); 

	 	    window.open('<c:out value="${contextRoot}"/>/rtsApplication/getPdf.do?fp=' + encodedFilesPath, '_blank');
	 	}
</script>

<td>
                      
			<input type="file" class="imagefile" name="idProof" id="idProof" style="width: 220px" />
			</td>
                   <td>   
                      <c:if test="${ empty requestScope.rtiApplication.pdfFilesSavedPath}">   
               
                <a class="bg-button btn btn-primary bd-highlight" style="color:white" id="idProof" type="button" target="_blank" onclick="javascript:readURL(this);"><span
							class="download" style="align-items: center">Upload</span></a>
               
                </c:if>
              <c:if test="${ not empty requestScope.rtiApplication.pdfFilesSavedPath}">
              
               <a class="bg-button btn btn-success bd-highlight action" style="color:white" id="uploadCerBtn" target="_blank" class="imagefile" type="button" target="_blank" onclick="certificateDownload('${requestScope.rtiApplication.pdfFilesSavedPath}');"><span
							class="download" style="align-items: center">Download</span></a>
               </c:if>
              <!--  <c:forEach var="idProof" items="${requestScope.idProofName}">
		    <c:if test="${ not empty idProof}">
		           <c:out value="${idProof}" />
		        
		        <a href="<c:out value="${contextRoot}"/>/rtiapplication/downLoadAttachment.do?serId=1&licAppliNo=<c:out value="${birthRegistration.birthRegistrationId}"/>&id=BirthUpload&attachementName=<c:out value="${idProof}"/>" >Download</a>--> 
			
			 <!-- <a target="_blank" href="../Upload/<c:out value="${requestScope.rtiApplication.rtiApplicationId}"/>/Upload/<c:out value="${idProof}"/>" >Download</a>
			</c:if>
           </c:forEach>-->
                
                </td>
				
			<input type="hidden" name="${pageScope.SESSION_TOKEN_KEY}" value="<%=session.getAttribute(Constants.SESSION_TOKEN_KEY)%>"/>	
			