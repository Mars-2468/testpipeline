<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>RTS Services</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

  <!-- Custom CSS -->
  <style>
    @import url('https://fonts.googleapis.com/css2?family=Google+Sans&display=swap');

    body {
      margin: 0;
      padding: 0;
      background-image: url('/Garden/images/garden_background.jpg');
      background-size: cover;
      background-position: center;
      background-repeat: no-repeat;
      font-family: 'Google Sans', sans-serif !important;
      height: 100%;
      position: relative;
    }

    body::before {
      content: "";
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background: linear-gradient(rgba(0, 0, 0, 0.85), rgba(0, 0, 0, 0.85));
      z-index: 2;
    }

    .container-fluid {
      position: relative;
      z-index: 3;
      padding-top: 10px;
      padding-bottom: 10px;
    }

    .form-container {
      background-color: #ffffff;
      border-radius: 10px;
      padding: 20px 30px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      margin-top: 5px;
    }

    .form-header {
      text-align: center;
      margin-bottom: 20px;
      font-size: 24px;
      font-weight: bold;
      color: #2e93e6;
    }

    .form-group label {
      font-weight: bold;
      color: darkcyan;
      text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.1);
    }

    .form-control {
      border-radius: 5px;
      border: 1px solid #f8f5f5;
      background-color: #f8f5f5;
      box-shadow: inset 1px 1px 2px rgba(0, 0, 0, 0.1);
    }

    .btn-primary {
      background-color: black;
      border: none;
      border-radius: 5px;
      margin-top: 20px;
    }

    .btn-primary:hover {
      background-color: #0056b3;
    }

    @media only screen and (max-width: 600px) {
      .custom-switch .custom-control-label::after {
        top: calc(0.25rem + 2px);
        left: calc(-2.25rem + 7px);
        width: calc(1rem - 4px);
        height: calc(1rem - 4px);
        background-color: #adb5bd;
        border-radius: 0.5rem;
        transition: transform 0.15s ease-in-out, background-color 0.15s ease-in-out;
      }

      .custom-switch .custom-control-label::before {
        left: -34px;
        width: 35px;
        border-radius: 0.6rem;
        height: 20px;
        top: 2px;
      }
    }
  </style>
</head>
<body>
  <form>
    <div id="overlay">
      <div class="cv-spinner">
        <span class="spinner"></span>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <div class="form-container">
            <div class="form-header">Application Details</div>
            <hr>

            <div class="form-horizontal">
              <div class="form-group row align-items-center mb-3">
                <label for="ownership" class="col-sm-4 col-form-label text-right"><b>Application Number:</b></label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="ownership" name="ownership" value="${rtiApplication.rtiApplnNumber}" readonly>
                </div>
              </div>

              <div class="form-group row align-items-center mb-3">
                <label for="parkName" class="col-sm-4 col-form-label text-right"><b>Name Of Applicant:</b></label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="parkname" name="parkname" value="${rtiApplication.applicantName}" readonly>
                </div>
              </div>

              <div class="form-group row align-items-center mb-3">
                <label for="area" class="col-sm-4 col-form-label text-right"><b>Mobile No. Of Applicant:</b></label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="area" name="area" value="${rtiApplication.phoneNumber}" readonly>
                </div>
              </div>

              <div class="form-group row align-items-center">
                <label for="authority" class="col-sm-4 col-form-label text-right"><b>Application Date:</b></label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="authority" name="authority" value="${rtiApplication.createdDate}" readonly>
                </div>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
  </form>
</body>
</html>
