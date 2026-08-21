/*
// jQuery Ajax File Uploader
//
// @author: Jordan Feldstein <jfeldstein.com>
//
//  - Ajaxifies an individual <input type="file">
//  - Files are sandboxed. Doesn't matter how many, or where they are, on the page.
//  - Allows for extra parameters to be included with the file
//  - onStart callback can cancel the upload by returning false
*/


(function($) {
    $.fn.ajaxfileupload = function(options) {
        var settings = {
          params: {},
          action: '',
          onStart: function() { console.log('starting upload'); console.log(this); },
          onComplete: function(response) { console.log('got response: '); console.log(response); console.log(this); },
          onCancel: function() { console.log('cancelling: '); console.log(this); },
          validateForm:function(){ if($("textarea#filekeyword").val()==""){	displayError("File Keyword is Mandatory.");	return false; }
          						 else if($("#documentType").val()==""){	displayError("Document Type is Mandatory."); return false; 	}
          						 else if($("textarea#comments").val()==""){ displayError("Comments is Mandatory."); return false; }
          						 else { var result =  isAlphanum(new Array('filekeyword','comments'),new Array('File Keyword','Comments'));
          						 return result;	} },
          validate_extensions : true,
          valid_extensions : ['png','jpg','pdf'],
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
            settings.submit_button.click(function()
            {
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
            var fileName = $element.val();
            if(settings.validateForm()==false){
                     settings.onComplete.apply($element, [{status: false, message:'Enter manadatory Fileds'}, settings.params])
                    
            }else if(true === settings.validate_extensions && $.inArray(ext, settings.valid_extensions) == -1)
            {
              settings.onComplete.apply($element, [{status: false, message: 'The select file type is invalid. File must be ' + settings.valid_extensions.join(', ') + '.'}, settings.params]);
            } else if(fileName.indexOf('[') > -1 || fileName.indexOf(']') > -1)
            {
                settings.onComplete.apply($element, [{status: false, message: 'The file Name should not contain [ , ] .Please Modify the file Name.'}, settings.params]);
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
            var response, responseStr = loadedFrame.contentWindow.document.body.innerHTML.replace(/(<\/?(pre|span)[\s\S]*?>)|((style|class|id|lang|) ?\= ?['"][\s\S]*?['"])/gi, "").trim();
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
            
           /* settings.onComplete.apply(element, [{status: true, message: 'Your file has been uploaded!'} , settings.params]);*/
            
            if(response.length == 36)
        	{
        	 settings.onComplete.apply(element, [{status: true, message: 'Your file has been uploaded!'} , settings.params]);
        	}
        
        else
        	{
        	settings.onComplete.apply(element, [{status: false, message: 'File upload failed please try again after some time....'} , settings.params]);
        	}
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
            $('#'+frame_id).on("load", function() {
              handleResponse(this, element);
            });

            // Wrap it in a form
            element.wrap(function() {
              return '<form action="' + settings.action + '" method="POST" enctype="multipart/form-data" target="'+frame_id+'" />'
            })
            // Insert <input type='hidden'>'s for each param
            .before(function() {
              var key, html = '';
              for(key in settings.params) {
                var paramVal = settings.params[key]	;
                if(key == 'jcr:keywords')
                	if(paramVal == null){
                  	paramVal = settings.params[key]=$("textarea#filekeyword").val()	;
                	}
                  if(key == 'jcr:comments')
                	  if(paramVal == null){
                  	paramVal = settings.params[key]=$("textarea#comments").val();
                	  }
                  if(key == 'jcr:marsType')
                    	paramVal = settings.params[key]=$("#documentType").val();
                  if(key == 'jcr:isPrivate')
                    paramVal = settings.params[key]=$("input:radio:checked").val();
                  if(key == '_synchronizerUploadToken')
                      paramVal = settings.params[key];
                if (typeof paramVal === 'function') {
                  paramVal = paramVal();
                }
                html += '<input type="hidden" id="' + key + '"  name="' + key + '" value="' + paramVal + '" />';
              }
              return html;
            });
          }

          
          var addParams=function (key,paramVal) {
        	  if(key == 'keyword')
              	paramVal = settings.params[key]=$("textarea#filekeyword").val()	;
              if(key == 'comments')
              	paramVal = settings.params[key]=$("textarea#comments").val();
          };


        });
      }
})( jQuery )
