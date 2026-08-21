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
      padding: 20px 10px;
    }

    .form-container {
      background-color: #ffffff;
      border-radius: 10px;
      padding: 20px 30px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .form-header {
      text-align: center;
      margin-bottom: 20px;
      font-size: 24px;
      font-weight: bold;
      color: #2e93e6;
    }

    table {
      width: 100%;
    }

    th, td {
      padding: 8px 12px;
      text-align: left;
      vertical-align: middle;
    }

    th {
      background-color: #f8f9fa;
      font-weight: bold;
      color: darkcyan;
    }

    td {
      background-color: #ffffff;
      border-bottom: 1px solid #dee2e6;
    }

    @media only screen and (max-width: 600px) {
      .form-container {
        padding: 15px;
      }

      table {
        font-size: 14px;
      }
    }
    .status-approved {
  font-size: 14px;
  font-weight: bold;
  color: #28a745; /* Green color for approval */
  text-transform: uppercase;
  letter-spacing: 1px;
  font-family: 'Georgia', serif; /* A formal serif font */
  position: relative;
  display: inline-block;
}

.status-approved::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  border: 2px solid #28a745; /* Border to look like a stamp */
  border-radius: 8px; /* Rounded corners for the "stamp" feel */
  z-index: -1;
  opacity: 0.3; /* Faint outline for subtlety */
}

.status-approved:hover {
  color: #216f35; /* Darker green on hover */
  text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.2); /* Slight shadow for depth */
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
        <div class="col-md-8">
          <div class="form-container">
            <div class="form-header">Application Details</div>
            <hr>

            <!-- Table for Form Fields -->
            <div class="table-responsive">
              <table class="table table-bordered">
                <tbody>
                  <tr>
                    <th>Application Number</th>
                    <td>${rtiApplication.rtiApplnNumber}</td>
                  </tr>
                  <tr>
                    <th>Name Of Applicant</th>
                    <td>${rtiApplication.applicantName}</td>
                  </tr>
                  <tr>
                    <th>Mobile No. Of Applicant</th>
                    <td>${rtiApplication.phoneNumber}</td>
                  </tr>
                  <tr>
                    <th>Application Date</th>
                    <td>${rtiApplication.createdDate}</td>
                  </tr>
                  <tr>
                    <th>Husband Name</th>
                    <td>${marriageCertificate.husbandFirstName} ${marriageCertificate.husbandFatherName} ${marriageCertificate.husbandLastName}</td>
                  </tr>
                  <tr>
                    <th>Wife Name</th>
                    <td>${marriageCertificate.wifeFirstName} ${marriageCertificate.wifeFatherName} ${marriageCertificate.wifeLastName}</td>
                  </tr>
                  <tr>
                    <th>Marriage Date</th>
                    <td>${marriageCertificate.marriageDate}</td>
                  </tr>
                  <tr>
                    <th>Marriage Place</th>
                    <td>${marriageCertificate.marriagePlace}</td>
                  </tr>
                  <tr>
  <th>Status</th>
  <td><span class="status-approved">Marriage certificate approved.</span></td>
</tr>

                  
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </form>
</body>
</html>
