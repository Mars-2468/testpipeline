package com.mars.rti.controller;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mars.common.utils.SessionUser;
import com.mars.rti.model.MisPurposeWithAmount;
import com.mars.rti.model.MiscellaneousApplication;
import com.mars.rti.service.MiscellaneousApplicationService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class MiscellaneousApplicationController {
	
	private static Log log = LogFactory.getLog(MiscellaneousApplicationController.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private MiscellaneousApplicationService miscellaneousApplicationService;
	
	 //Misc Form
    @RequestMapping("/rtsapplication/miscForm.do")
	public ModelAndView miscForm(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
    			if (log.isDebugEnabled()) {
    				log.debug("miscForm called");
    			}
    			HttpSession session = request.getSession();
    			SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
    			Map<String, Object> model = new HashMap<String, Object>();
    			model.put("sessionUser", sessionUser);
    			List<MisPurposeWithAmount> misPurposeWithAmount = miscellaneousApplicationService.getPurposeWithAmount();
    			request.setAttribute("misPurposeWithAmount", misPurposeWithAmount);

    			
    			
		return new ModelAndView("miscForm");
	}
    
    @RequestMapping("/rtsapplication/saveMiscApplication.do")
    @ResponseBody
    public String saveMiscApplication(
            HttpServletRequest request,
            HttpServletResponse response,
            MiscellaneousApplication miscellaneousApplication)
            throws ServletException {

        try {
            miscellaneousApplication =
                    miscellaneousApplicationService.saveMiscellaneousApplication(miscellaneousApplication);

            return request.getContextPath()
                    + "/ws/rtsapplication/saveMiscApplicationSuccess.do?miscNo="
                    + miscellaneousApplication.getMiscAppId();

        } catch (Exception e) {
            log.error("Error while saving Misc Application", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "ERROR";
        }
    }


	
	@RequestMapping("ws/rtsapplication/saveMiscApplicationSuccess.do")
	public ModelAndView saveMiscApplicationSuccess(HttpServletRequest
	request,HttpServletResponse response) {

	 String miscNo = request.getParameter("miscNo");
	 log.debug("success miscNo"+miscNo);
		
		if (miscNo == null) {
			return new ModelAndView("redirect:/rtiapplication/errorPage.do");
		}
	 ModelAndView model = new ModelAndView("newRTIMiscApplicationSuccess");

	 model.addObject("miscNo",miscNo);
	 return model;


	 } 

	
//	
//	  @RequestMapping("/rtsapplication/downloadMiscReceipt.do") public void
//	  downloadMiscReceipt(@RequestParam("miscId") Long miscId, HttpServletRequest request, HttpServletResponse response) throws Exception {
//	  
//	  MiscellaneousApplication app =
//	  miscellaneousApplicationService.findById(miscId);
//	  
//	  response.setContentType("application/pdf");
//	  response.setHeader("Content-Disposition", "attachment; filename=receipt_" + miscId + ".pdf");
//	  
//	  String realLogoPath = request.getServletContext().getRealPath("/images/nagpur.png");
//	    File logoFile = new File(realLogoPath);
//	    System.out.println("Logo exists? " + logoFile.exists());
//	    System.out.println("Logo path: " + realLogoPath);
//
//	    String logoRelativePath = "nagpur.png"; // use relative name now
//	    String baseUri = new File(request.getServletContext().getRealPath("/images/")).toURI().toString();
//	  
//	  String html = String.format( "<html>" + "<head>" + "<style>" +
//	  "body { font-family: Arial, sans-serif; font-size: 14px; }" +
//	  ".header { background: #0b5394; color: white; padding: 10px; text-align: center; }" + 
//	  ".receipt-box { border: 2px solid #0b5394; border-radius: 8px; padding: 20px; margin-top: 10px; }"  + 
//	  ".section-title { font-weight: bold; text-align: center; margin-bottom: 10px; font-size: 18px; }" + 
//	  "label { font-weight: bold; }" +
//	  "table { width: 100%%; border-collapse: collapse; margin-top: 10px; }" +
//	  "td { padding: 5px; vertical-align: top; }" +
//	  "hr { border: 1px solid #0b5394; }"  +
//	  "</style>" + 
//	  "</head>" + 
//	  "<body>" +
//	  "<div class='header'>" + 
//	  "  <table style='width:100%%; border: none;'>" +
//	  "    <tr>" +
//	  "      <td style='width:60px; text-align:left;'>" +
//	  "        <img src='" + logoRelativePath + "' alt='Logo' style='height:60px;'/>" +
//	  "      </td>" + 
//	  "      <td style='text-align:center;'>" +
//	  "        <h2 style='margin:0;'>Nagpur Municipal Corporation</h2>" +
//	  "        <h4 style='margin:0;'>Miscellaneous Receipt Form</h4>" +
//	  "      </td>" +
//	  "      <td style='width:60px;'>&nbsp;</td>" +
//	  "    </tr>" +
//	  "  </table>" +
//	  "</div>" +
//	  "<div class='receipt-box'>" +
//	  "  <div class='section-title'>MISCELLANEOUS RECEIPT</div>" +
//	  "  <p>Receipt No: NMC/MISC/2025/%s</p>" + 
//	  "  <hr/>" + 
//	  "  <table>" +
//	  "    <tr><td><label>Date:</label> %s</td><td><label>Phone:</label> %s</td></tr>"  +
//	  "    <tr><td><label>Zone:</label> %s</td><td><label>Ward No:</label> %s</td></tr>" +
//	  "    <tr><td><label>Department:</label> %s</td><td><label>Purpose:</label> %s</td></tr>" +
//	  "    <tr><td><label>Received From:</label> %s</td><td><label>Amount:</label> ₹%s</td></tr>" +
//	  "    <tr><td colspan='2'><label>Address:</label> %s</td></tr>" +
//	  "    <tr><td><label>Payment Mode:</label> %s</td><td><label>Received By:</label> %s</td></tr>" +
//	  "    <tr><td colspan='2'><hr/></td></tr>" +
//	  "  <tr><td colspan='2' style='text-align: center;'>This is a computer-generated receipt and does not require a physical signature.</td></tr>" +
//	  "<tr><td colspan='4' style='text-align: center;'> Thankyou for your payment!! </td></tr> " +
//	  "  </table>" + 
//	  "</div>" +
//	  "</body>" + 
//	  "</html>",
//	  
//	  app.getMiscAppId(),
//	  app.getDate(),
//	  app.getPhone(),
//	  app.getZone(),
//	  app.getWard(),
//	  app.getDepartment(),
//	  app.getPurpose(),
//	  app.getReceivedFrom(),
//	  app.getAmount(),
//	  app.getAddress(), 
//	  app.getPaymentMode(), 
//	  app.getReceivedBy()
//	  );
//	  
//	   ITextRenderer renderer = new ITextRenderer();
//	    renderer.setDocumentFromString(html, baseUri);
//	    renderer.layout();
//	    renderer.createPDF(response.getOutputStream());
//	    renderer.finishPDF(); 
//	  
//	  }
//	 

private ServletRequest getServletContext() {
	// TODO Auto-generated method stub
	return null;
}


}
