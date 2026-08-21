package com.mars.rti.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.rti.model.FireFeesMasterUpdated;
import com.mars.rti.model.FireFloorName;
import com.mars.rti.model.SubTypeOfbuilding;
import com.mars.rti.service.FireFeesMainService;
import com.mars.rti.service.FireFeesMasterUpdatedService;
import com.mars.rti.service.FireFloorNameService;
import com.mars.rti.service.FireFloorTypesService;
import com.mars.rti.service.FireTypeOfConstructionService;
import com.mars.rti.service.SubTypeOfbuildingService;

@SuppressWarnings("serial")
@Controller
public class FireFeesAjaxController extends HttpServlet {
	 @Autowired
	 private FireTypeOfConstructionService fireTypeOfConstructionService;
	 
	 @Autowired
	 private FireFeesMainService fireFeesMainService;
	 
	 @Autowired
	 private FireFloorTypesService fireFloorTypesService;
	 
	 @Autowired
	 private FireFloorNameService fireFloorNameService;
	 
	 @Autowired
	 private FireFeesMasterUpdatedService fireFeesMasterUpdatedService;
	 
	 @Autowired
	 private SubTypeOfbuildingService subTypeOfbuildingService;
	 double totalFees = 0.0;
	 double scrutinyFees = 0.0;
	 double mainFeesOfFire = 0.0;
	 
	  
  public void setFireTypeOfConstructionService(FireTypeOfConstructionService fireTypeOfConstructionService) {
		this.fireTypeOfConstructionService = fireTypeOfConstructionService;
	}
  
  public void setFireFeesMainService(FireFeesMainService fireFeesMainService) {
		this.fireFeesMainService = fireFeesMainService;
	}

  @RequestMapping("/rtiapplication/calculate.do")
  protected void calculate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {						
       //   long typeOfBuilding = Long.parseLong(request.getParameter("typeOfBuilding"));
          long typeOfConstruction = Long.parseLong(request.getParameter("typeOfConstruction"));
          long typeOfHeight = Long.parseLong(request.getParameter("typeOfHeight"));
          long catagory = 1;
          String[] floorNamee = request.getParameterValues("floorNamee[]");
          String[] commAreaa = request.getParameterValues("commAreaa[]");  //industrial
          String[] residAreaa = request.getParameterValues("residAreaa[]");// instututinal
          String[] primumArr = request.getParameterValues("primumArr[]"); //commercial
          String[] otherUsee = request.getParameterValues("otherUsee[]");
          String[] rowWiseTotalFees = request.getParameterValues("rowWiseTotalFees[]");
           FireFeesMasterUpdated fireFeesMasterUpdated = null;
          
           
         double getFeesFromBackend = 0.0;
         double addAreaFromFrontEnd = 0.0;
         double rowWisefees = 0.0;
         double grandTotal=0.0;
         DecimalFormat df = new DecimalFormat("0.00");
        		// new DecimalFormat("#.####");
         double [] rowWiseTotalFeesToBeShown = new double[floorNamee.length];
         
      
   	  double totalResidAreaaD = 0.0;
   	  double totalCommAreaaD = 0.0;
   	  double totalPrimumArrD = 0.0;
   	  double totalOtherUseeD = 0.0;
   	  
//              for (int  i = 0;i<floorNamee.length;i++) {
//            	  long fN = Long.parseLong(floorNamee[i]);
//            	  double commAreaaD = 0.0;
//            	  double residAreaaD = 0.0;
//            	  double primumArrD = 0.0;
//            	  double otherUseeD = 0.0;
//            	  
////            	  fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(typeOfBuilding,typeOfConstruction,typeOfHeight,catagory,Long.parseLong(floorNamee[i]));
////            	  getFeesFromBackend = Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
//            	  if(residAreaa[i].equals(""))
//            	  {
//            		  residAreaaD = 0.0;
//            	  }
//            	  else 
//            	  {
//            		  residAreaaD = Double.parseDouble(residAreaa[i]);
//            		  fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(1,typeOfConstruction,typeOfHeight,catagory,Long.parseLong(floorNamee[i]));
//                	  getFeesFromBackend = Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
//            		  totalResidAreaaD += (residAreaaD * getFeesFromBackend); 
//            	  }
//            	  if(commAreaa[i].equals("") || commAreaa[i] == null)
//            	  {
//            		   commAreaaD = 0.0;
//            	  }
//            	  else 
//            	  {
//            		  commAreaaD = Double.parseDouble(commAreaa[i]);
//            		  fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(3,typeOfConstruction,typeOfHeight,catagory,Long.parseLong(floorNamee[i]));
//                	  getFeesFromBackend = Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
//            		  totalCommAreaaD += (commAreaaD * getFeesFromBackend);
//            	  }
//            	  
//            	  if(primumArr[i].equals(""))
//            	  {
//            		  primumArrD = 0.0;
//            	  }
//            	  else 
//            	  {
//            		  primumArrD = Double.parseDouble(primumArr[i]);
//            		  fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(2,typeOfConstruction,typeOfHeight,catagory,Long.parseLong(floorNamee[i]));
//                	  getFeesFromBackend = Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
//            		  totalPrimumArrD += (primumArrD*getFeesFromBackend);
//            	  }
//            	  if(otherUsee[i].equals(""))
//            	  {
//            		  otherUseeD = 0.0;
//            	  }
//            	  else 
//            	  {
//            		  otherUseeD = Double.parseDouble(otherUsee[i]);
//            		  fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(4,typeOfConstruction,typeOfHeight,catagory,Long.parseLong(floorNamee[i]));
//                	  getFeesFromBackend = Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
//            		  totalOtherUseeD += (otherUseeD*getFeesFromBackend);
//            	  }
//            	  
//            	  
//            	  addAreaFromFrontEnd = totalResidAreaaD + totalCommAreaaD + totalPrimumArrD + totalOtherUseeD;
//            	  
//            	  rowWisefees =  addAreaFromFrontEnd;
//            	
//            	rowWisefees = Double.parseDouble(df.format(rowWisefees));
//            	  rowWiseTotalFeesToBeShown [i] = rowWisefees;
//            	  grandTotal += rowWisefees;
//              }
   	for (int i = 0; i < floorNamee.length; i++) {

   	    double rowTotal = 0.0;   // 

   	    long fN = Long.parseLong(floorNamee[i]);

   	    // Residential
   	    if (!residAreaa[i].equals("")) {
   	        double resid = Double.parseDouble(residAreaa[i]);
   	        fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(1, typeOfConstruction, typeOfHeight, catagory, fN);
   	        rowTotal += resid * Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
   	    }

   	    // Commercial
   	    if (commAreaa[i] != null && !commAreaa[i].equals("")) {
   	        double comm = Double.parseDouble(commAreaa[i]);
   	        fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(3, typeOfConstruction, typeOfHeight, catagory, fN);
   	        rowTotal += comm * Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
   	    }

   	    // Institutional (primumArr)
   	    if (!primumArr[i].equals("")) {
   	        double inst = Double.parseDouble(primumArr[i]);
   	        fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(2, typeOfConstruction, typeOfHeight, catagory, fN);
   	        rowTotal += inst * Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
   	    }

   	    // Industrial (otherUse)
   	    if (!otherUsee[i].equals("")) {
   	        double other = Double.parseDouble(otherUsee[i]);
   	        fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(4, typeOfConstruction, typeOfHeight, catagory, fN);
   	        rowTotal += other * Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
   	    }

   	    rowTotal = Double.parseDouble(df.format(rowTotal));

   	    rowWiseTotalFeesToBeShown[i] = rowTotal;

   	    grandTotal += rowTotal;   // ✅ correct
   	}
   	
   	grandTotal =
   			Double.parseDouble(
   			df.format(grandTotal)
   			);

   			scrutinyFees =
   			Double.parseDouble(
   			df.format((grandTotal*2)/100)
   			);
              //df.format(grandTotal);
        	 // scrutinyFees = Double.parseDouble(df.format((grandTotal*2)/100));             
              JSONObject json = new JSONObject();
              json.put("rowWiseTotalFeesToBeShown", rowWiseTotalFeesToBeShown);
              json.put("grandTotal", grandTotal);
              json.put("scrutinyFees", scrutinyFees);
              response.setContentType("application/json");
              response.setCharacterEncoding("UTF-8");

              PrintWriter out = response.getWriter();
              out.print(json.toString());
              out.flush();
          
      } catch (NumberFormatException e) {
          response.setStatus(HttpServletResponse.SC_BAD_REQUEST); 
          e.printStackTrace();

      } catch (Exception e) {
          response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); 
          e.printStackTrace();
      }
  }

  
  @RequestMapping(value = "/rtiapplication/floorType.do", method = RequestMethod.POST)
  @ResponseBody
  public String floorType(@RequestParam("floorName") String floorNameParam) {

      try {
          if (floorNameParam == null || floorNameParam.trim().isEmpty()) {
              return "{}";
          }

          long typeOfBuilding = Long.parseLong(floorNameParam);

          List<FireFloorName> subTypeOfbuilding = fireFloorNameService.getList(typeOfBuilding);

          JSONArray jsonArray = new JSONArray();

          for (FireFloorName subtype : subTypeOfbuilding) {
              JSONObject obj = new JSONObject();
              obj.put("subTypeOfBuildingId", subtype.getFireFloorNameId());
              obj.put("subTypeOfBuildingName", subtype.getFireFloorNames());
              jsonArray.put(obj);
          }

          JSONObject jsonResponse = new JSONObject();
          jsonResponse.put("subTypeOfbuilding", jsonArray);

          return jsonResponse.toString();

      } catch (Exception e) {
          e.printStackTrace();
          return "{}";
      }
  }
  @RequestMapping("/rtiapplication/fireFloorType.do")
  protected void fireFloorType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
          long floorName = Long.parseLong(request.getParameter("floorName"));
          List<FireFloorName> fireFloorName = fireFloorNameService.getList(floorName);
          
          
          
          JSONArray jsonArray = new JSONArray();
          for (FireFloorName subtype : fireFloorName) {
              JSONObject subtypeJson = new JSONObject();
              subtypeJson.put("fireFloorNameId", subtype.getFireFloorNameId());
              subtypeJson.put("fireFloorNames", subtype.getFireFloorNames());
              jsonArray.put(subtypeJson);
          }
          
          JSONObject jsonResponse = new JSONObject();
          jsonResponse.put("fireFloorName", jsonArray);

          response.setContentType("application/json");

          PrintWriter out = response.getWriter();
          out.print(jsonResponse.toString());
          out.flush();
      } catch (NumberFormatException e) {
          response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
          e.printStackTrace();
      } catch (Exception e) {
          response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
          e.printStackTrace();
      }
  }

}
