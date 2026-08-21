<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.include file="/pages/core-pages/nmc_user/dashboard/header.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils" />



<head>
    <title>Nagpur Municipal Corporation</title>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="csrf-token" content="L1tBXJBCG7Qg3zc8hd8zkv3US8Yq8R7ihDGuzHIc" />
    <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="jquery-3.6.1.min.js"></script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
crossorigin="anonymous"></script>
<script src="Vjdog.js"></script>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
 <script type="text/javascript"
	src="<c:out value=" ${contextRoot}" />/scripts/jquery/jquery.ajaxfileupload.js"></script>
	<link rel="stylesheet" href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<c:out value='${contextRoot}'/>/pages/core-pages/nmc_user/css/style2.css" /> 
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
///pageContext.setAttribute("statusList", CommonUtils.getStatus());
%>


<style>
label {
	font-weight: 600;
}

h3 {
	font-weight: 500;
}
@page {
  size: legal landscape; /* Landscape orientation for Legal size */
}
@media print {
  body {
    transform: scale(0.9); /* Adjust the scale factor as needed */
    transform-origin: center center;
  }

}

 @page {
     size: auto ;
     }
</style>



</head>


<body class="">
    <div class="container mt-3">
        <div class="row">
            <h3 style="text-align:center ;" class=" rounded-2"><strong> Application for Existing Building to obtain compliance certificate
                (Please type or write legibly)
                
                </strong></h3>

            <form style="margin-right: 35px;" name="RenewDogLicese" method="POST" class="needs-validation" novalidate>

                
                <strong >To,</strong> 
                <br>  
                <strong>Chief Fire Officer</strong>  
                <br> 
                <strong>N.M.C. Nagpur.</strong>   
                <br>
                
                Sir,<br>
                Kindly issue compliance certificate to the building sanction vide building permit No. <strong><h7 class="input" id="permitno">.......</h7></strong> .date. <strong><h7 class="input" id="date1">.......</h7></strong> & fire recommendation letter No. <strong><h7 class="input" id="letterno">.......</h7></strong>. date <strong><h7 class="input" id="date2">.......</h7></strong>. I have paid the necessary fees applicable having receipt No.<strong> <h7 class="input" id="receiptno">.......</h7></strong>.dated.<strong><h7 class="input" id="date3">.......</h7> </strong> I have enclosed all the necessary documents & certificates. The other building details are as under.
            </h5>



                <div class="row">

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label  ">Permit No<span class="mand_error" style="color: red;"">*</span>
                             </label>
                         <input type="text" oninput="permitno(this)" class="form-control" style="background-image: none;"  id="" placeholder="" name="permit_no" value="" required>
                         <div class="invalid-feedback">
                            Please Enter Valid Permit No .
                        </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label">Date <span class="text-danger"
                                style="color: red;">*</span> </label>
                            <input type="date"  oninput="date1(this)" class="form-control" style="background-image: none;" id="" placeholder=" " name="permitno_date" required>
                            <div class="invalid-feedback">
                                Please Enter Valid Date  .
                            </div>
                        </div>
                    </div>

                    
                  
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label  ">Fire Recommendation Letter No<span class="mand_error" style="color: red;"">*</span>
                             </label>
                         <input type="text" class="form-control" style="background-image: none;" oninput="letterno(this)" id="" placeholder="" name="fire_recommendation_no" value="" required>
                         <div class="invalid-feedback">
                            Please Enter Valid Fire Recommendation Letter No.
                        </div>
                        </div>
                    </div>
        
                    
    
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label">Date <span class="text-danger"
                                style="color: red;">*</span> </label>
                            <input type="date" class="form-control" style="background-image: none;"  oninput="date2(this)" id="" placeholder=" " name="fire_recommendationno_date" required>
                            <div class="invalid-feedback">
                                Please Enter Valid Date.
                            </div>
                        </div>
                    </div>
                    </div>
            
                    <div class="row">
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label  ">Receipt No<span class="mand_error" style="color: red;"">*</span>
                    </label>
                    <input type="number" oninput="reciptno(this)"  oninput="date3(this)" class="form-control" style="background-image: none;" id="" placeholder="" name="receipt_no" value="" required>
                    <div class="invalid-feedback">
                        Please Enter Valid Receipt No.
                    </div>
                        </div>
                    </div>
                          
        
                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label">Date <span class="text-danger"
                                style="color: red;">*</span> </label>
                            <input type="date" class="form-control" style="background-image: none;" oninput="date3(this)" id="" placeholder=" " name="receipt_no_date" required>
                            <div class="invalid-feedback">
                                Please Enter Valid Date.
                            </div>
                        </div>
                    </div>
        </div>


       


                
            <div class="row">
                    <div class="col-md-3">
                        <div class="mb-3 mt-5">
                            <label for="" class="form-label  ">1.Name of Building<span class="text-danger" style="color: red;"">*</span>
                    </label>
                    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="building_name" value="" required>
                    <div class="invalid-feedback">
                        Please Enter Valid Name of Building.
                    </div>

                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-5">
                            <label for="" class="form-label ">2.Address of Building </label>
                            <input type="text" class="form-control" style="background-image: none;" id="" placeholder="" name="address_building" value="">
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-5">
                            <label for="" class="form-label ">3.Name & Address of Building /promoter<span class="text-danger" style="color: red;"">*</span> </label>
                    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="name_address" value="" required>
                    <div class="invalid-feedback">
                        Please Enter Valid Name & Address of Building /promoter.
                    </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="mb-3 mt-0">
                            <label for="" class="form-label ">4.Name & Address of Building/Promoter/Owner/Occupiers of individual flats<span class="text-danger" style="color: red;"">*</span> </label>
                    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="name_address" value="" required>
                    <div class="invalid-feedback">
                        Please Enter Valid Name & Address of Building/Promoter/Owner/Occupiers of individual flats.
                    </div>
                        </div>
                    </div>

                    


                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">5.Type of occupancy 
                                <span class="text-danger" style="color: red;"">*</span> </label>
                    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="type_of_occupancy" value="" required>
                    <div class="invalid-feedback">
                        Please Enter Valid Type of occupancy .
                    </div>
                        </div>
                    </div>


                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">	6.Plot area
                                <span class="text-danger" style="color: red;"">*</span> </label>
                    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="plot_area" value="" required>
                    <div class="invalid-feedback">
                        Please Enter Valid Plot area.
                    </div>
                        </div>
                    </div>
        

                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">		7.Total Built up area 
                                <span class="text-danger" style="color: red;"">*</span> </label>
                    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="total_built_up_area" value="" required>
                    <div class="invalid-feedback">
                        Please Enter Valid Total Built up area .
                    </div>
                        </div>
                    </div>


                    <div class="col-md-3">
                        <div class="mb-3 mt-3">
                            <label for="" class="form-label ">8.Height of building 
                                <span class="text-danger" style="color: red;"">*</span> </label>
                    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="height_of_building" value="" required>
                    <div class="invalid-feedback">
                        Please Enter Valid Height of building .
                    </div>
                        </div>
                    </div>
                    
                    

                 <strong><h5> 9.Side marginal space</h5></strong>
                 <div class="col-md-3">
                    <div class="mb-3 mt-3" > <label>a.Front </label>	 		
                            <span class="text-danger" style="color: red;"">*</span> </label>
                <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="front" value="" required>
                <div class="invalid-feedback">
                    Please Enter Valid Front .
                </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-3"> <label>b.Rear </label>	 		
                            <span class="text-danger" style="color: red;"">*</span> </label>
                <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="rear" value="" required>
                <div class="invalid-feedback">
                    Please Enter Valid Rear .
                </div>

                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-3"> <label>c.Side 1 </label>	 		
                            <span class="text-danger" style="color: red;"">*</span> </label>
                <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="side1" value="" required>
                <div class="invalid-feedback">
                    Please Enter Valid Side 1 .
                </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-3"> <label>d.Side 2 </label>	 		
                            <span class="text-danger" style="color: red;"">*</span> </label>
                <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="side2" value="" required>
                <div class="invalid-feedback">
                    Please Enter Valid Side 2 .
                </div>

                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-4">
                        <label for="" class="form-label ">10.Width of approach road to the building premises
                            <span class="text-danger" style="color: red;"">*</span> </label>
                <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="width_of_approach" value="" required>
                <div class="invalid-feedback">
                    Please Enter Valid Width of approach road to the building premises.
                </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-5">
                        <label for="" class="form-label ">11.Width of entrance gate
                            <span class="text-danger" style="color: red;"">*</span> </label>
                <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="width_of_entrance" value="" required>
                <div class="invalid-feedback">
                    Please Enter Valid Width of entrance gate.
                </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-5">
                        <label for="" class="form-label ">12.Vertical clearance of entrance gate
                            <span class="text-danger" style="color: red;"">*</span> </label>
                <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="vertical_clearance" value="" required>
                <div class="invalid-feedback">
                    Please Enter Valid Vertical clearance of entrance gate.
                </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-4 mt-4">
                        <label for="" class="form-label ">
                            	13.Date of sanctioning of building 			: 
                                  plan by N.M.C./N.I.T
                            
                            <span class="text-danger" style="color: red;"">*</span> </label>
                         <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="date_of_sanctioning" value="" required>
                         <div class="invalid-feedback">
                            Please Enter Valid Date of sanctioning of building 			: 
                            plan by N.M.C./N.I.T.
                        </div>
                    </div>
                    
                </div>
                <!-- <div>
                    <div class="form-check ms-3"> -->
                <div class="row">
                        <label>14.Whether completion certificate has been obtain 
                            for this building from the competent authority ? 
                            If yes, please attaché the copy of the same :
                            </label>
                    <div class="form-check ms-3">


                        <input type="radio" name="test" value="value1"> Yes<br>
                        <input type="radio" name="test" value="value2"> No<br>
                        <input type="radio" name="test" value="value3"> Not Applicable 
                       
                     </div>

                     <div class="invalid-feedback">
                        Please Select Valid Option    
                    </div>
                </div>



                <div class="row">
                     <label>15.	Whether occupancy certificate has been obtain for 
                        this building from the competent authority ? 
                        If yes, please attaché the copy of the same: </label>
                    <div class="form-check ms-3">
                    
                       
                        <input type="radio" name="test" value="value1"> Yes<br>
                        <input type="radio" name="test" value="value2"> No<br>
                        <input type="radio" name="test" value="value3"> Not Applicable 
                    </div>    
                        <div class="invalid-feedback">
                            Please Select Valid Option    
                        </div>
                    </div> 
                </div>       
                        
                        
                        <div class="row">
                      <div class="col-md-3">
                    <div class="mb-3 mt-5">
                        <label for="" class="form-label ">16.Number of basements				:
                            <span class="text-danger" style="color: red;"">*</span> </label>
                <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="number_of_basements" value="" required>
                <div class="invalid-feedback">
                    Please Enter Valid Number of basements 
                    
                </div>
                    </div>
                </div>
             
              

                <div class="col-md-3">
                    <div class="mb-3" style="margin-top: 25px;">
                        <label for="" class="form-label ">17.Number of floors(including ground floor):<span class="text-danger" style="color: red;"">*</span> </label>
                <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="number_of_floors" value="" required>
                <div class="invalid-feedback">
                    Please Enter Valid Number of floors(including ground floor)
                    
                </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-5">
                        <label for="" class="form-label ">	18.Area of basement							:
                            <span class="text-danger" style="color: red;"">*</span> </label>
                <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="area_of_basement" value="" required>
                <div class="invalid-feedback">
                    Please Enter Valid Area of basement	
                    
                </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-5">
                        <label for="" class="form-label ">	19.Covered area of typical floor.								:
                            <span class="text-danger" style="color: red;"">*</span> </label>
                <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="covered_area" value="" required>
                <div class="invalid-feedback">
                    Please Enter Valid Covered area of typical floor
                    
                </div>
                    </div>
                </div>


                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label ">20.If basement extends beyond the building line, 	:
                            please indicate the load bearing strength 
                            of the roof of basement:<span class="text-danger" style="color: red;"">*</span> </label>
                <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="basement_extends" value="" required>
                <div class="invalid-feedback">
                    Please Enter Valid If basement extends beyond the building line, 	:
                    please indicate the load bearing strength 
                    
                </div>
                    </div>
                </div>

                
                
				
                <label>21.Exposure hazards(Please give Details)</label>
                <br><br>
               <table>
                <thead>
                  <th>Compass direction in relation to the building</th>
                  <th>Type of property / features</th>
                  <th></th>
                </thead>
                <tbody>
                    
                <tr>
                  <td>NORTH</td>
                  
                    <td> 	 		        
                        <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="type1" value="">  
                    </td>
                    <td>
                        <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="t1" value="">
                    </td>
                </tr>

                <tr>  
                  <td>EAST</td>
                  <td>
                    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="type2" value="">
                  </td>
                  <td>
                    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="t2" value="">
                  </td>
                </tr>

                <tr>
                  <td>SOUTH</td>
                    <td>
                         <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="type3" value="">
                    </td>

                    <td>
                        <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="t3" value="">
                   </td>
                 
                </tr>

                <tr>
                    <td>WEST</td>
                        <td>
                            <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="type4" value="">
                       </td>
                       <td>
                            <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="t4" value="">
                       </td>
                </tr>
               </tbody>
              </table>
              <br><br><br>
			<div class="row">
               <h5>22.Please give details of water supply available 
                exclusively for fire fighting.</h5>
            <div class="col-md-3">
               <div class="mb-2 mt-2" > <label>a)Capacity of U/G tank</label>	 		
                       <span class="text-danger" style="color: red;"">*</span> </label>
           <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="capacity_of_U/G" value="" required>
           <div class="invalid-feedback">
            Please Enter Valid Capacity of U/G tank 
            
        </div>
           
               </div>
           </div>

           <div class="col-md-3">
               <div class="mb-2 mt-2"> <label>b)Capacity of Terrace tank</label>	 		
                       <span class="text-danger" style="color: red;"">*</span> </label>
           <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="capacity_of_terrace" value="" required>
           <div class="invalid-feedback">
            Please Enter Valid Capacity of Terrace tank
            
        </div>
               </div>
           </div>
           </div>
           <div class="row">
           <div class="col-md-3">
            <div class="mb-3 mt-0"> <label> 23.	Has wet riser (s) been provided If  so, please
                indicate the number if risers and internal dia. 
                each.<span class="text-danger" style="color: red;"">*</span> </label>
        <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="wet_riser" value="" required>
        <div class="invalid-feedback">
            Please Enter Valid Has wet riser (s) been provided If  so, please
            indicate the number if risers and internal dia
            
        </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="mb-3 mt-4"> <label> 24.	Has any dry riser/down comer been provided , 
                give details.<span class="text-danger" style="color: red;"">*</span> </label>
        <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="dry_riser" value="" required>
        <div class="invalid-feedback">
            Please Enter Valid 	Has any dry riser/down comer been provided 
            give details
            
        </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="mb-3 mt-0"> <label>25.	Has any down comer been provided ? Terrace.	:
                If so, please give details.<span class="text-danger" style="color: red;"">*</span> </label>
        <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="down_comer" value="" required>
        <div class="invalid-feedback">
            Please Enter Valid 	Has any down comer been provided ? Terrace
          
            
        </div>
            </div>
        </div>
        
        <div class="col-md-3">
            <div class="mb-3 mt-0"> <label> 26.Please indicate the present arrangement for 
                replacement of water for firefighting 		:<span class="text-danger" style="color: red;"">*</span> </label>
        <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="present_arrangement" value="" required>
        <div class="invalid-feedback">
            Please Enter Valid 	Please indicate the present arrangement for 
            replacement of water for firefighting 
          
            
        </div>
            </div>
        </div>
          </div>
          <br><br>

           <h5> 27.	Have internal hydrant been provided ? 
            If so, please indicate </h5>
        <div class="col-md-3">
           <div class="mb-2 mt-2" > <label>a)No. of hydrant on each floor including 
            basement (S)<span class="text-danger" style="color: red;"">*</span> </label>
       <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="hydrant_on_floor" value="" required>
       <div class="invalid-feedback">
        Please Enter Valid No. of hydrant on each floor including basement
      
        
    </div>
           </div>
       </div>

       <div class="col-md-3">
           <div class="mb-2 mt-2"> <label>b)Have these hydrant single or twin outlets<span class="text-danger" style="color: red;"">*</span> </label>
       <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="hydrant_single" value="" required>
       <div class="invalid-feedback">
        Please Enter Valid Have these hydrant single or twin outlets
      
        
    </div>
           </div>
       </div><br><br>
       

       <h5>28.Have first aid hose reel been provided ?
        If so, please indicate 	
</h6>
    <div class="col-md-3">
       <div class="mb-2 mt-4" > <label>	a)No. of hose reels on each floors.<span class="text-danger" style="color: red;"">*</span> </label>
   <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="no_hose_reels" value="" required>
   <div class="invalid-feedback">
    Please Enter Valid No. of hose reels on each floors
  
    
</div>
       </div>
   </div>

   <div class="col-md-3">
       <div class="mb-2 mt-2"> <label> b)Bore and length of Hose reel tubing 
        on each reel.<span class="text-danger" style="color: red;"">*</span> </label>
   <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="hose_reel_tubing" value="" required>
   <div class="invalid-feedback">
    Please Enter Valid Bore and length of Hose reel tubing on each reel
  
    
</div>
       </div>
   </div>

   <div class="col-md-3">
    <div class="mb-2 mt-2"> <label> 	c)Size (Bore) and type Nozzle fitted to on each reel.<span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="size(bore)" value="" required>
<div class="invalid-feedback">
    Please Enter Valid Size (Bore) and type Nozzle fitted to on each reel
  
    
</div>
    </div>
</div>
 

<div class="col-md-3">
    <div class="mb-2 mt-2"> <label> d)Is the hose reel connected directly to the 
        riser or to the hydrant outlet<span class="text-danger" style="color: red;">*</span> </label>
        <div class="form-check ms-3">
            <input type="radio" class="form-check-input"  id="" name="yes1" value="" required>Yes
         </div>
         <div class="form-check ms-3">
            <input type="radio" class="form-check-input"  id="" name="yes1" value="" required>No
         </div>
         <div class="invalid-feedback">
            Please Select Valid Button
          
            
        </div>

    </div>
</div>

  <div class="col-md-3">
                    <div class="mb-3 mt-4">
                        <label for="" class="form-label ">29.Has any yard hydrant been provided from the 
Building’s fire pump:<span class="text-danger" style="color: red;"">*</span> </label>
<div class="form-check ms-3">
    <input type="radio" class="form-check-input" id="" name="no1" value="" required>Yes
 </div>
 <div class="form-check ms-3">
    <input type="radio" class="form-check-input"  id="" name="no1" value="" required>No
 </div>
 <div class="invalid-feedback">
    Please Select Valid Button
  
    
</div>
                
                    </div>
                </div>

                <h5> 30.Has fire hose been provided near each hydrant? 
                    If so, please indicate 
                    </h5>
                <div class="col-md-3">
                   <div class="mb-3 mt-4" > <label>a)The type of hoses  </label>	 		
                           <span class="text-danger" style="color: red;"">*</span> </label>
               <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="type_of_hoses" value="" required>
               <div class="invalid-feedback">
                Please Enter Valid The type of hoses 
              
                
            </div>
               
                   </div>
               </div>

               <div class="col-md-3">
                   <div class="mb-3 mt-4"> <label>b)The size (Bore) of Hoses </label>	 		
                           <span class="text-danger" style="color: red;"">*</span> </label>
               <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="size_of_hoses" value="" required>
               <div class="invalid-feedback">
                Please Enter Valid The size (Bore) of Hoses 
              
                
            </div>
                   </div>
               </div>

               <div class="col-md-3">
                   <div class="mb-3 mt-4"> <label>c)The length of each hose</label>	 		
                           <span class="text-danger" style="color: red;"">*</span> </label>
               <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="length_of_each_hose" value="" required>
               <div class="invalid-feedback">
                Please Enter Valid The length of each hose
                
            </div>
                   </div>
               </div>

               <div class="col-md-3">
                <div class="mb-3 mt-0"> <label>d)Total Number of hoses provided  
                 near each hydrant.<span class="text-danger" style="color: red;"">*</span> </label>
            <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="total_no_hoses" value="" required>
            <div class="invalid-feedback">
             Please Enter Valid Total Number of hoses provided  
             
            </div>
                </div>
            </div>

              <h5><b>31.Have branch pipes been provided ?		:-If so, please indicate
        </b></h5>

        <div class="col-md-3">
            <div class="mb-2 mt-4"> <label>a)The type of branch pipes.<span class="text-danger" style="color: red;"">*</span> </label>
        <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="type_of_branch" value="" required>
        <div class="invalid-feedback">
            Please Enter Valid The type of branch pipes 
            
           </div>
            </div>
        </div>
              

              <div class="col-md-3">
                  <div class="mb-2 mt-4"> <label>b)Size of nozzle fitted to each branch.<span class="text-danger" style="color: red;"">*</span> </label>
              <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="size_of_nozzle" value="" required>
              <div class="invalid-feedback">
                Please Enter Valid Size of nozzle fitted to each branch
                
               </div>
                  </div>
              </div>

              <div class="row">
              <div class="col-md-3">
                <div class="mb-3 mt-0">
                    <label for="" class="form-label ">	
                        
                       32.If the basement is used for car parking 
                            or storage, 	has it been sprinklered 

                        
                                                
                        <span class="text-danger" style="color: red;"">*</span> </label>
            <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="car_parking" value="" required>
            <div class="invalid-feedback">
                Please Enter Valid If the basement is used for car parking 
                or storage, 	has it been sprinklered 
                
               </div>
                </div>
            </div>

            <div class="col-md-3">
                <div class="mb-3 mt-4">
                    <label for="" class="form-label ">	33.Sprinkler system is provided on all floor	
                        
                       
                        
                                                
                        <span class="text-danger" style="color: red;"">*</span> </label>
            <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="sprinkler_system" value="" required>
            <div class="invalid-feedback">
                Please Enter Valid Sprinkler system is provided on all floor 
                
               </div>
                </div>
            </div>
            </div>


            <h5> 34.Have any stationery fire pump (s) been installed 
                for pressuring the down comer. If so, please indicate
               </h5>
            <div class="col-md-3">
               <div class="mb-2 mt-5"> <label>a)The number of pump. </label>	 		
                       <span class="text-danger" style="color: red;"">*</span> </label>
           <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="no_of_pump" value="" required>
           <div class="invalid-feedback">
            Please Enter Valid Sprinkler system is provided on all floor 
            
           </div>
               </div>
           </div>

           <div class="col-md-3">
               <div class="mb-2 mt-4"> <label>	b)The size of suction and delivery connections 
                of each pump.<span class="text-danger" style="color: red;"">*</span> </label>
           <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="size_of_suction" value="" required>
           <div class="invalid-feedback">
            Please Enter Valid The size of suction and delivery connections  
            
           </div>
               </div>
           </div>

           <div class="col-md-3">
               <div class="mb-2 mt-0"> <label>c)The maximum head against which the pump 
                can operate at the output mentioned at (c)<span class="text-danger" style="color: red;"">*</span> </label>
           <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="max_head" value="" required>
           <div class="invalid-feedback">
            Please Enter Valid The size of suction and delivery connections  
            
           </div>

               </div>
           </div>

           <div class="col-md-3">
               <div class="mb-2 mt-5"> <label>d)Output of each pump</label>	 		
                       <span class="text-danger" style="color: red;"">*</span> </label>
           <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="output_of_each" value="" required>
           <div class="invalid-feedback">
            Please Enter Valid TOutput of each pump
            
           </div>
               </div>
           </div>

           <div class="col-md-3">
            <div class="mb-2 mt-2"> <label>e)Is the pump automatic in action ?<span class="text-danger" style="color: red;"">*</span> </label>
        <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="pump_automatic" value="" required>
        <div class="invalid-feedback">
            Please Enter Valid Is the pump automatic in action ?
            
           </div>
            </div>
        </div><br>


        <h5>35.Is the building equipped with automatic fire 
            detection and alarm system ?
            
            </h5>
        <div class="col-md-3">
           <div class="mb-3 mt-4" > <label>a)The type of detectors used<span class="text-danger" style="color: red;"">*</span> </label>
       <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="type_of_detectors" value="" required>
       <div class="invalid-feedback">
        Please Enter Valid The type of detectors used
        
       </div>
           </div>
       </div>

       <div class="col-md-3">
           <div class="mb-3 mt-0"> <label>b)The standard to which the detection confirm<span class="text-danger" style="color: red;"">*</span> </label>
       <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="detection_confirm" value="" required>
       <div class="invalid-feedback">
        Please Enter Valid The standard to which the detection confirm
        
       </div>
           </div>
       </div>

       
       <div class="col-md-3">
        <div class="mb-3 mt-0"> <label>c)The code to which the installation confirm<span class="text-danger" style="color: red;"">*</span> </label>
    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="installation_confirm" value="" required>
    <div class="invalid-feedback">
        Please Enter Valid  The code to which the installation confirm
        
       </div>

        </div>
    </div>

    <div class="col-md-3">
        <div class="mb-3 mt-0"> <label> Have manual call boxes been installed in the 
            building for raising an alarm in the event of 
            any outbreak of fire ? If so, please give details.<span class="text-danger" style="color: red;">*</span> </label>
            <div class="form-check ms-3">
                <input type="radio" class="form-check-input"  id="" name="yes1" value="" required>Yes
             </div>
             <div class="form-check ms-3">
                <input type="radio" class="form-check-input"  id="" name="yes1" value="" required>No
             </div>
             <div class="form-check ms-3">
                <input type="radio" class="form-check-input"  id="" name="yes1" value="" required>Not Applicable
             </div>

             <div class="invalid-feedback">
                Please Select Valid Button
              
                
            </div>
    
        </div>
    </div>

	<div class="row">
    <div class="col-md-3">
        <div class="mb-3 mt-4"> <label>	36.Has a public address system been installed in 
            the building with loudspeakers on each floor<span class="text-danger" style="color: red;"">*</span> </label>
    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="public_address" value="" required>
    <div class="invalid-feedback">
        Please Enter  Valid  Has a public address system been installed in the building with loudspeakers on each floor
        
       </div>
        </div>
    </div>
    <div class="col-md-3">
        <div class="mb-3 mt-0"> <label>37.Has an intercom system been provided between 
            the various floors and the fire control room in 
            the entrance lobby ?	:
            <span class="text-danger" style="color: red;"">*</span> </label>
    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="intercom_system" value="" required>
    <div class="invalid-feedback">
        Please Enter  Valid  Has an intercom system been provided between 
        the various floors and the fire control room in 
        the entrance lobby ?
        
       </div>
        </div>
    </div>
  

    

    <div class="col-md-3">
        <div class="mb-3 mt-5"> <label>38.Whether fire dampers are provided 
            in A/c ducts give detail.
            <span class="text-danger" style="color: red;"">*</span> </label>
    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="a/c_ducts" value="" required>
    <div class="invalid-feedback">
        Please Enter  Valid Whether fire dampers are provided 
        in A/c ducts give detail
        
       </div>
        </div>
    </div>
	
    <div class="col-md-3">
        <div class="mb-3 mt-4" > <label>39.Has a fire control room been provided in the 
            entrance lobby of the building<span class="text-danger" style="color: red;"">*</span> </label>
    <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="fire_control_room" value="" required>
    <div class="invalid-feedback">
        Please Enter  Valid Has a fire control room been provided in the ntrance lobby of the building
        
       </div>
        </div>
    </div>
	</div>
    <h5>40.How many staircase have been provided in 
        the building ? Please intimate in each case.	
        </h5>
		<div class="row">
    <div class="col-md-3">
       <div class="mb-2 mt-2" > <label>a)The width of the stairway</label>	 		
               <span class="text-danger" style="color: red;">*</span> </label>
   <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="width_of_stairway" value="" required>
   <div class="invalid-feedback">
    Please Enter  Valid The width of the stairway
    
   </div>
       </div>
   </div>
   <div class="row">
   <div class="col-md-3">
    <div class="mb-3 mt-0"> <label>41.	Is the external staircase been provided accessible form all floors : 
    <span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="fire_control_room" value="" required>

<div class="invalid-feedback">
    Please Enter  Valid Is the external staircase been provided accessible form all floors
    
   </div>
    </div>
</div>




<div class="col-md-3">
    <div class="mb-3 mt-4"> <label>42.	Refuge area details. 
    <span class="text-danger" style="color: red;"">*</span> </label>
        <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="fire_control_room" value="" required>

<div class="invalid-feedback">
    Please Enter  Valid Refuge area details
    
   </div>

    </div>
</div>
  </div>



   <h5>43.How many lifts have been installed in the 
    Building? Please indicate in each case	
        
    </h5>
<div class="row">
<div class="col-md-3">
   <div class="mb-3 mt-0" > <label>a)The floors between which the lift runs<span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="floors_lift_runs" value="" required>
<div class="invalid-feedback">
    Please Enter  Valid The floors between which the lift runs
    
   </div>
   </div>
</div>

<div class="col-md-3">
    <div class="mb-3 mt-0" > <label>b)The type of doors fitted to the lift runs<span class="text-danger" style="color: red;"">*</span> </label>
 <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="doors_lift_runs" value="" required>
 <div class="invalid-feedback">
    Please Enter  Valid The floors between which the lift runs
    
   </div>
    </div>
 </div>

 


<div class="col-md-3">
            <div class="mb-3 mt-4" > <label> c)Floor area of the lift car<span class="text-danger" style="color: red;"">*</span> </label>
 <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="lift_car" value="" required>
 <div class="invalid-feedback">
    Please Enter  Valid Floor area of the lift car
    
   </div>
    </div>
 </div>

 
<div class="col-md-3">
    <div class="mb-3 mt-0" > <label>d)Fire resistance rating of lift car and 
        Landing doors, if known.<span class="text-danger" style="color: red;"">*</span> </label>
 <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="fire_resistance" value="" required>
 <div class="invalid-feedback">
    Please Enter  Valid Fire resistance rating of lift car and 
    Landing doors, if known
    
   </div>
    </div>
 </div>
 
 <div class="col-md-3">
    <div class="mb-3 mt-4" > <label>e)Has communication system been installed 
        in the lift car<span class="text-danger" style="color: red;"">*</span> </label>
 <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="communication_system" value="" required>
 <div class="invalid-feedback">
    Please Enter  Valid Has communication system been installed 
    in the lift car
    
   </div>
    </div>
 </div>
 <div class="col-md-3">
    <div class="mb-3 mt-0" > <label> f)Has a fireman’s switch been installed in 
        the lift for grounding it in the event of a fire<span class="text-danger" style="color: red;"">*</span> </label>
 <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="communication_system" value="" required>
 <div class="invalid-feedback">
    Has a fireman’s switch been installed in 
        the lift for grounding it in the event of a fire
    
    
   </div>
    </div>
 </div>

 <h5> 
    44.Has a standby source of power supply been provided 
    If it is through a generator, please indicate
    
        
   </h5>
	<div class="row">
<div class="col-md-3 mt-4">
   <div class="mb-3" style="margin-top:70px;" > <label>a)The capacity(output)	 		
           <span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="capacity" value="" required>

<div class="invalid-feedback">
    Please Enter  Valid The capacity (output)
    
   </div>
   </div>
</div>
<br>


<div class="col-md-3">
    <div class="mb-3 mt-4"> <label>b)The functions that can be maintained 
        Simultaneously by the use of generator, 
        each as operating lift (s), pump, 
        Emergency lighting, etc.<span class="text-danger" style="color: red;"">*</span> </label>

 <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="functions" value="" required>
 <div class="invalid-feedback">
    Please Enter  Valid The functions that can be maintained 
    Simultaneously by the use of generator, 
    each as operating lift (s), pump, 
    Emergency lighting
    
   </div>
    
   </div>
    </div>

    <div class="col-md-3">
        <div class="mb-3 mt-6" style="margin-top:70px;" > <label>c)Is the generator automatic in action 
            or has to be started manually<span class="text-danger" style="color: red;"">*</span> </label>
    
     <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="functions" value="" required>
     <div class="invalid-feedback">
        Please Enter  Valid c)Is the generator automatic in action 
        or has to be started manually
        
       </div>
        
       </div>
        </div> 



 
<div class="row">
<div class="col-md-3">
    <div class="mb-3 mt-4"> <label>
        	45.Where more than one lifts are installed in 
        a common enclosure, have individual lifts 
        been separated by fire resisting walls 
        of 2 hours fire rating.<span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="firee_rating" value="" required>
<div class="invalid-feedback">
    Please Enter  Valid here more than one lifts are installed in 
    a common enclosure, have individual lifts 
    been separated by fire resisting walls 
    of 2 hours fire rating
    
   </div>
    </div>
</div>


<div class="col-md-3">
    <div class="mb-3" style="margin-top:75px;"> <label>
        46.Has the lift shaft (s) Lift lobby or stairwell 
        been pressurised<span class="text-danger" style="color: red;">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="stairwell" value="" required>
<div class="invalid-feedback">
    Please Enter  Valid Has the lift shaft (s) Lift lobby or stairwell 
    been pressurised
    
   </div>
    </div>
</div>

<div class="col-md-3">
    <div class="mb-3 mt-1" style="margin-top:px;"> <label>47.Please Enter  Valid THave the lift lobbies and staircases been 
        effectively enclosed to prevent fire/smoke 
        entering them from outside at any floor<span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="exists_direction" value="" required>
<div class="invalid-feedback">
    
Please Enter  Valid THave the lift lobbies and staircases been 
effectively enclosed to prevent fire/smoke 
entering them from outside at any floor
    
   </div>
    </div>
</div>


<div class="col-md-3">
    <div class="mb-3" style="margin-top:50px;"> <label>48.Have all exists and direction of travel to such 
        exit been sign – posted with illuminated sigus<span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="exists_direction" value="" required>
<div class="invalid-feedback">
    Please Enter  Valid Have all exists and direction of travel to such 
    exit been sign – posted with illuminated sigus
    
   </div>
    </div>
</div>




<div class="col-md-3">
    <div class="mb-3 mt-3"> <label>49.Has a false ceiling been provided in any portion 
        of the building ? Location and also mention if 
        the material used for the false ceiling is 
        combustible or non – combustible.<span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="false_ceiling" value="" required>
<div class="invalid-feedback">
    Please Enter  Valid Has a false ceiling been provided in any portion 
    of the building ? Location and also mention if 
    the material used for the false ceiling is 
    combustible or non – combustible
    
    
   </div>
    </div>
</div>
</div>
<br>

<h5> 50.Is the building centrally air conditioned ?  
    If  so, please indicate
    </h5>
    <div class="col-md-3">
        <div class="mb-3 mt-4"> <label>a)The material used for construction of ducts 
            and its fittings.
         how the lagging is secured.<span class="text-danger" style="color: red;"">*</span> </label>
     <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="type_of_logging" value="" required>
     <div class="invalid-feedback">
         Please Enter  Valid a)The material used for construction of ducts 
         and its fittings.
         
        </div>
        </div>
     </div>



<div class="col-md-3">
   <div class="mb-3 mt-5"> <label>b)The type off tining used for ducts if any<span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="type_of_tining" value="" required>
<div class="invalid-feedback">
    Please Enter  Valid The type off tining used for ducts if any
    
   </div>
   </div>
</div>

<div class="col-md-3">
   <div class="mb-2 mt-0"> <label>c)Type of logging used, if any for insulating 
    any portion of the duct. Please also indicate 
    how the lagging is secured.<span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="type_of_logging" value="" required>
<div class="invalid-feedback">
    Please Enter  Valid Type of logging used, if any for insulating 
    any portion of the duct. Please also indicate how the lagging is secured
    
   </div>
   </div>
</div>

<div class="col-md-3">
   <div class="mb-2 mt-5"> <label>d)If false ceiling is provided, please give 
	information as at 43 above.<span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="false_ceiling1" value="" required>
<div class="invalid-feedback">
    Please Enter  Valid If false ceiling is provided, please give 
	information as at 43 above
    
   </div>
   </div>
</div>

<div class="col-md-3">
    <div class="mb-2 mt-4"> <label>e)If plenum is used as return air passage, 
        has it been protected with fire
         detectors ? please   give details.<span class="text-danger" style="color: red;"">*</span> </label>
 <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="plenum" value="" required>
 <div class="invalid-feedback">
    Please Enter  Valid If plenum is used as return air passage, 
    has it been protected with fire
     detectors ? please   give details
    
   </div>
    </div>
 </div>

 <div class="col-md-3">
    <div class="mb-2 mt-5"> <label>f)Has a separate A H U been  provided 
        for each floor<span class="text-danger" style="color: red;"">*</span> </label>
 <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="A_H_U" value="" required>
 <div class="invalid-feedback">
    Please Enter  Valid Has a separate A H U been  provided 
    
   </div>
    </div>
 </div>

 <div class="col-md-3">
    <div class="mb-2 mt-4"> <label>g)Is the ducting for each floor effectively 
        isolated of is it continuous on more 
        than one floors<span class="text-danger" style="color: red;">*</span> </label>
 <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="one_floors" value="" required>

 <div class="invalid-feedback">
    Please Enter  Valid Is the ducting for each floor effectively 
        isolated of is it continuous on more 
    
   </div>
    </div>
 </div>

 <div class="col-md-3">
    <div class="mb-2 mt-0"> <label>51.Where are the switchgear and transformer 
        located ? If inside the building, please indicate 
        than one floors<span class="text-danger" style="color: red;">*</span> </label>
 <input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="one_floors" value="" required>

 <div class="invalid-feedback">
    Please Enter  Valid 51.Where are the switchgear and transformer 
    located ? If inside the building, please indicate
    
   </div>
    </div>
 </div>

<div class="col-md-3">
    <div class="mb-3 mt-0">
        <label for="" class="form-label ">52.	A) If the switchgear and transformer (s) have 
            been housed in separate compartments, 
            effectively separated from each other and from 
            portion of the buildings by a four hours fire 
            resistive wall ?
            Has partitioning & storage cabinets been provided ? 
            If so indicate whether the material use for 
            partitioning, framing and support is combustible 
            or non combustible. If combustible has approved
            its retardant :composition used on all sides for 
            making it non combustible ?
            b) What precautions have been taken to prevent 
            a possible fire in the transformer (s) from spreading ?
            
            
             
            <span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="transformer" value="">
<div class="invalid-feedback">
    Please Enter  Valid A) If the switchgear and transformer (s) have 
    been housed in separate compartments, 
    effectively separated from each other and from 
    portion of the buildings by a four hours fire 
    resistive wall ?
    Has partitioning & storage cabinets been provided ? 
    If so indicate whether the material use for 
    partitioning, framing and support is combustible 
    or non combustible. If combustible has approved
    its retardant :composition used on all sides for 
    making it non combustible ?
    b) What precautions have been taken to prevent 
    a possible fire in the transformer (s) from spreading ?
    
   </div>
    </div>
</div>
<div class="col-md-3">
    <div class="mb-3" style="margin-top: 260px;" >
        <label for="" class="form-label ">53.Where electric cables, telephone cables 
            dry/Wet riser /down comer pass through a floor 
            or wall, have the spaces (apertures) round the cables
            /pipes been effectively plugged with noncombustible 
            fire resistive materials<span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="resistive_material" value="">
<div class="invalid-feedback">
    Please Enter  Valid Where electric cables, telephone cables 
    dry/Wet riser /down comer pass through a floor 
    or wall, have the spaces (apertures) round the cables
    /pipes been effectively plugged with noncombustible 
    fire resistive materials 
    
   </div>
    </div>
</div>

<div class="col-md-3">
    <div class="mb-3 " style="margin-top: 336px;">
        <label for="" class="form-label ">
            54.Please indicate the number and extinguishers 
            Bearing ISI certification Mark
         
        
             
            <span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="bearing_ISI" value="" required>
<div class="invalid-feedback">
    Please Enter  Valid Please indicate the number and extinguishers 
    Bearing ISI certification Mark
    
   </div>
    </div>
</div>

<div class="col-md-3">
    <div class="mb-3 " style="margin-top: 312px;">
        <label for="" class="form-label ">
            55.Are the occupants of the building systematically
            Trained in fire prevention and emergency procedures? 
            If so, please give details<span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="emergency" value="" required>
<div class="invalid-feedback">
    Please Enter  Valid Does as emergency organization exist in the 
	building ? If so, please give details and append 
	a copy of the emergency (fire) orders
    
   </div>
    </div>
</div>

<div class="col-md-3">
    <div class="mb-3 mt-3">
        <label for="" class="form-label ">
           56.Does as emergency organization exist in the 
	building ? If so, please give details and append 
	a copy of the emergency (fire) orders
 <span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="emergency" value="" required>
<div class="invalid-feedback">
    Please Enter  Valid Does as emergency organization exist in the 
	building ? If so, please give details and append 
	a copy of the emergency (fire) orders
    
   </div>
    </div>
</div>

<div class="col-md-3">
    <div class="mb-3 mt-3">
        <label for="" class="form-label ">
           57.Has a Qualified Fire officer been appointed for 
            the building either individually or jointly 
            With other building
        
 <span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="Qualified_fire_officer" value="" required>
<div class="invalid-feedback">
    Please Enter  Valid Has a Qualified Fire officer been appointed for 
    the building either individually or jointly 
    With other building
    
   </div>
    </div>
</div>
 
<div class="col-md-3">
    <div class="mb-3 mt-3">
        <label for="" class="form-label ">
            58.Has the building been protected against lighting?
            If so, does the lighting protect conform to any code ?
            Please indicate details
        
        
 <span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="lighting_protect" value="" required>
<div class="invalid-feedback">
    Please Enter  Valid Has the building been protected against lighting?
    If so, does the lighting protect conform to any code ?
    Please indicate details
    
   </div>
    </div>
</div>

<div class="col-md-3">
    <div class="mb-3" style="margin-top:62px;">
        <label for="" class="form-label ">
            59.Other information related to fire fighting & life safety arrangement
        
        
 <span class="text-danger" style="color: red;"">*</span> </label>
<input type=" text" class="form-control" style="background-image: none;" id="" placeholder="" name="fire_fighting_life" value="" required>
<div class="invalid-feedback">
    Please Enter  Valid Other information related to fire fighting & life safety arrangement
    
   </div>
    </div>
</div>
</div>

			<div class="row">
			
                <h6 style="background-color:white; padding:10px;" class="mt-3 rounded-2"><strong> List of Documents (with attachment) </strong></h6>
                
                <div class="alert alert-info mb-0 p-2 mb-4">
                <small><strong>Note: </strong> Upload Below Files only pdf, .jpg, .jpeg, .bmp etc..(Max upto 5MB) </small>
                </div>
               

                  <div class="col-md-3">
                    <div class="mb-3 mt-3 ">
                        <label for="" class="form-label">Fitness certificate from licensing agency<span class="mand_error" style="color: red;" >*</span></label>
                        <input type="file" class="form-control" style="background-image: none;" id="" placeholder="" name="Fitness_certificate _from_licensing_agency" required>
                        <div class="invalid-feedback">
                            File selected is either greater than 5Mb or not of type pdf
                        </div>

                    </div>
                </div>
                

                <div class="col-md-3">
                    <div class="mb-3 mt-5">
                        <label for="" class="form-label">Building Plan,Sections and Elevations<span class="mand_error" style="color: red;" >*</span></label>
                        <input type="file" class="form-control" style="background-image: none;" id="" placeholder="" name="detailed_plan" required>
                        <div class="invalid-feedback">
                            File selected is either greater than 5Mb or not of type pdf
                        </div>

                    </div>
                </div>
				<div class="col-md-3">
                    <div class="mb-3 mt-4">
                        <label for="" class="form-label">Civil Engineer certificate of Structural stability</label>
                        <input type="file" class="form-control" style="background-image: none;" id="" placeholder="" name="civil_Engineer_certificate_of_Structural_stability">

                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-4">
                        <label for="" class="form-label"> Architect certificate for fire water tanks<span class="mand_error" style="color: red;" >*</span></label>
                        <input type="file" class="form-control" style="background-image: none;" id="" placeholder="" name="architect_certificate_for_fire_water_tanks"
                            required>
                            <div class="invalid-feedback">
                                File selected is either greater than 5Mb or not of type pdf
                            </div>
                    </div>
                </div>
				<div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label">
                            Electrical inspector certificate
                            <span class="mand_error" style="color: red;" >*</span></label>
                        <input type="file" class="form-control" style="background-image: none;" id="" placeholder="" name="electrical_inspector_certificate"
                            required>
                            <div class="invalid-feedback">
                                File selected is either greater than 5Mb or not of type pdf
                            </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label"> Sanctioned building plan <span class="mand_error" style="color: red;" >*</span></label>
                        <input type="file" class="form-control" style="background-image: none;" name="sanctioned_building_plan" id="" placeholder=""
                            required >
                            <div class="invalid-feedback">
                                File selected is either greater than 5Mb or not of type pdf
                            </div>
                    </div>
                </div>
				<div class="col-md-3">
                    <div class="mb-3 mt-3">
                        <label for="" class="form-label" > License copy of lift<span class="mand_error" style="color: red;">*</span></label>
                        <input type="file" class="form-control" style="background-image: none;" name="License_copy_of_lift" id="" placeholder=""
                            required >
                            <div class="invalid-feedback">
                                File selected is either greater than 5Mb or not of type pdf
                            </div>
                    </div>
                </div>
            

            <div class="col-md-3">
                <div class="mb-3 mt-3">
                    <label for="" class="form-label" > Signature <span class="mand_error" style="color: red;">*</span></label>
                    <input type="file" class="form-control" style="background-image: none;" name="Signature" id="" placeholder=""
                        required >
                        <div class="invalid-feedback">
                            File selected is either greater than 5Mb or not of type pdf
                        </div>
                </div>
            </div>
        </div>

           

            <div class="col-md-12">
                <div class="mb-5 mt-4 ">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="check11" name="declaration"
                            value="something" required>

                        <label class="form-check-label ms-3 lbleng" style="margin-top: 0px;">
                            <strong>Declaration <span class="text-danger" style="color: red;">*</span>:- </strong>The
                            above mentioned information is true to the best of my knowledge and belief.
                        </label>
                        <div class="invalid-feedback">
                    Please check the declaration.
                </div>
                    </div>
                </div>
            </div>
            <div class="col-md-12 text-start mb-5">
                <div class="text-center">
                    <button type="button" class="btn btn-danger btn_sm printMe"> <i class="fa-solid fa-print"></i>
                        View
                        and Print </button>
                    <button class="btn btn-success btn_sm" type="submit" id="submit"><i class="fa-solid fa-check"></i> Submit
                    </button>
                </div>
            </div>
        </div>
</form>
</body>
</html>

<script type="text/javascript">
$('.printMe').on('click', function () {

    window.print();
});
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.6.1.js"></script>
    <script type="text/javascript">


        $.ajaxSetup({
            beforeSend: function () {
                $("#overlay").fadeIn();
                $('body').css({
                    'cursor': 'progress'
                });

            },
            complete: function () {
                $("#overlay").fadeOut();
                $('body').css({
                    'cursor': 'default'
                });
            }
        });

    
		

        function permitno(pname)
                    {
                        document.getElementById('permitno').innerText=pname.value;
                    }
                    function reciptno(pname2)
                    {
                        document.getElementById('receiptno').innerText=pname2.value;
                    }
                    function letterno(pname3)
                    {
                        document.getElementById('letterno').innerText=pname3.value;
                    }
                    function date1(date11)
                    {
                        document.getElementById('date1').innerText=date11.value;
                    }
                    function date2(date12)
                    {
                        document.getElementById('date2').innerText=date12.value;
                    }
                    function date3(date13)
                    {
                        document.getElementById('date3').innerText=date13.value;
                    }
 </script>

 <script type="text/javascript">
       $(document).ready(function(){
  
  $("#submit").click(function(){
	  

	  $("form:first").addClass("needs-validation");
	  $("form:first").attr("novalidate","");
  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }else{
  		onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/saveZoneCertificates.do');
      }

      form.classList.add('was-validated')
    }, false)
  })});
  
  $('input,select,textarea').on('focusout', function() {
  
  var isFileAllowed=true;
  if(this.getAttribute("type")=== 'file'){
  var name = this.files[0].name;
  if((this.files[0].size <5000000) && (name.endsWith('.pdf'))){
  isFileAllowed = true;
  }else{
  isFileAllowed = false;
  }
  }

  if(this.checkValidity() && isFileAllowed){
  this.classList.remove('is-invalid')
  this.classList.add('is-valid')
  }else{
  this.classList.remove('is-valid')
  this.classList.add('is-invalid')
  }
});
  
 
  
});
</script>

