


function validateEmail() {
    var email = document.getElementById("email").value;
    var emailRegex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if (!emailRegex.test(email)) {
        document.getElementById("emailError").innerHTML = "Please enter a valid email address";
        return false;
    }
    else {
        document.getElementById("emailError").innerHTML = "";
        return true;
    }
}


    function validateMobile() {
        var mobile = document.getElementById("mobile").value;
        var mobileError = document.getElementById("mobileError");
        var mobileRegex = /^\d{10}$/;
        if (!mobileRegex.test(mobile)) {
            mobileError.innerHTML = "Invalid mobile number";
            return false;
        } else {
            mobileError.innerHTML = "";
            return true;
        }
    }

function validateName() {

  var name =  document.getElementById("fname").value;
  var lname =  document.getElementById("lname").value;

   var nameError = document.getElementById("nameError");
     var nameRegex = /^[a-zA-Z ]{2,30}$/;
   
  if (name == "" || lname == "") {
       nameError.innerHTML = "invalid  name ";
    return false;
  }
  else if(!nameRegex.test(name) || !nameRegex.test(lname)) {
     nameError.innerHTML = "invalid  name";
    return false;
  } else{
	     nameError.innerHTML = "";

  return true;
  }
}


function validateOTP() {
  var otpInput = document.getElementById("otp").value;
  var otpError = document.getElementById("otpError");
  var isValid = true;

  if(otpInput.length != 6 ) {
    otpError.innerHTML = "OTP must be a 6-digit number";
    isValid = false;
  }  else {
    otpError.innerHTML = "";
  }

  return isValid;
}
