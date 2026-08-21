
package com.mars.rti.controller;

import java.sql.Connection;
import java.util.Base64;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.rti.model.RTIApplication;
import com.mars.rti.service.RTIApplicationService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class ApplicationPdfGeneration extends MultiActionController implements InitializingBean {

	private static String const_OrderBy = "OrderBy";

	private static String const_SortBy = "SortBy";

	private static Log log = LogFactory.getLog(ApplicationPdfGeneration.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private RTIApplicationService rtiApplicationService;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void afterPropertiesSet() throws Exception {

	}

	@RequestMapping(value = "/rtiapplication/downloadSecurePdf.do", method = RequestMethod.POST)
	public void downloadSecurePdf(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("mobileNo") == null) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

		String sessionMobile = (String) session.getAttribute("mobileNo");

		String secureToken = request.getParameter("secureToken");

		if (secureToken == null || secureToken.trim().isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		try {

			String decoded = new String(Base64.getUrlDecoder().decode(secureToken));

			String[] parts = decoded.split("\\|");

			if (parts.length != 3) {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				return;
			}

			long applicationId = Long.parseLong(parts[0]);
			long serviceId = Long.parseLong(parts[1]);
			String tokenMobile = parts[2];

//			if (!sessionMobile.equals(tokenMobile)) {
//				response.sendError(HttpServletResponse.SC_FORBIDDEN);
//				return;
//			}

			RTIApplication app = rtiApplicationService.findByRTIApplicationNumberId(applicationId);

			if (app == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}

//			if (!app.getMobileNumber().equals(sessionMobile)) {
//				response.sendError(HttpServletResponse.SC_FORBIDDEN);
//				return;
//			}

			if (app.getUserRegistrationDetails() == null ||
				    !sessionMobile.equals(app.getUserRegistrationDetails().getMobileNo())) {

				    response.sendError(HttpServletResponse.SC_FORBIDDEN);
				    return;
				}
			
			response.reset();
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=ApplicationDetails.pdf");
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "no-cache");

			generateReportByService(serviceId, applicationId, request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	private void generateReportByService(long serviceId, long applicationId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		switch ((int) serviceId) {

		case 1:
			sendDownloads(request, response, "BirthApplication", applicationId);
			break;

		case 2:
			sendDownloads(request, response, "DeathApplication", applicationId);
			break;

		case 5:
			sendDownloads(request, response, "ZoneApplication", applicationId);
			break;

		case 11:
			sendDownloads(request, response, "MarriageApplication", applicationId);
			break;

		case 23:
			sendDownloads(request, response, "MandapPermissionApplication", applicationId);
			break;

		case 28:
			sendDownloads(request, response, "PartMapApplication", applicationId);
			break;
			
		case 48:
			sendDownloads(request, response, "NewWaterConnectionApplication", applicationId);
			break;
			
		case 49:
			sendDownloads(request, response, "ChangeInOwnershipApplication", applicationId);
			break;
			
			
		case 47:
			sendDownloads(request, response, "ChangeOfTapSize", applicationId);
			break;
			
		case 6:
			sendDownloads(request, response, "WaterDisconnectionApplication", applicationId);
			break;
		case 50:
			sendDownloads(request, response, "WaterReconnectionApplication", applicationId);
			break;
		case 51:
			sendDownloads(request, response, "ChangeOfCategoryApplication", applicationId);
			break;
			
		case 68:
			sendDownloads(request, response, "WaterConnectionNoDuesApplication", applicationId);
			break;
			
		case 73:
			sendDownloads(request, response, "TreeCuttingApplication", applicationId);
			break;
			
		case 75:
			sendDownloads(request, response, "TreeTrimmingApplication", applicationId);
			break;
			
		case 90:
			sendDownloads(request, response, "GaneshMandapPermissionApplication", applicationId);
			break;

		case 91:
			sendDownloads(request, response, "DurgaUtsavApplication", applicationId);
			break;

		case 92:
			sendDownloads(request, response, "DikshaBhumiApplication", applicationId);
			break;
		case 93:
			sendDownloads(request, response, "FireCrackersApplication", applicationId);
			break;
		case 55:
			sendDownloads(request, response, "TaxUtaraApplication", applicationId);
			break;
			
		case 54:
			sendDownloads(request, response, "TaxNoDuesApplication", applicationId);
			break;
			
		case 104:
			sendDownloads(request, response, "TaxTransferApplication", applicationId);
			break;
		case 103:
			sendDownloads(request, response, "NewTaxAssesmentApplication", applicationId);
			break;
				
		case 58:
			sendDownloads(request, response, "TaxReasessmentApplication", applicationId);
			break;
				
			
		case 72:
			sendDownloads(request, response, "TaxDemandBillApplication", applicationId);
			break;

		case 71:
			sendDownloads(request, response, "TaxExemptionApplication", applicationId);
			break;

		case 3:
			sendDownloads(request, response, "DogLicenseMainApplication", applicationId);
			break;

		case 102:
			sendDownloads(request, response, "DogLicenseReMainApplication", applicationId);
			break;
		case 69:
			sendDownloads(request, response, "FireNoc", applicationId);
			break;

		

		default:
			throw new IllegalArgumentException("Invalid Service ID");
		}
	}

	public void sendDownloads(HttpServletRequest request, HttpServletResponse response, String reportName,
			long applicationId) {

		try (Connection connection = sessionFactory.getCurrentSession().connection()) {

			HashMap<String, Object> parameters = new HashMap<>();
			String applicationIdstr=String.valueOf(applicationId);
			parameters.put("rtiapplrefid", applicationIdstr);

			String requestURL = request.getRequestURL().toString();
			String ctx = request.getContextPath();
			String serverHost = requestURL.substring(0, requestURL.indexOf(ctx));

			parameters.put("serverHost", serverHost);
			parameters.put("ctx", ctx);
			parameters.put("REPORT_NMC_LOGO_PATH", serverHost + ctx + "/images/nmclogo.jpeg");

			String reportFilePath = getServletContext()
					.getRealPath("/reports/rtiApplication/" + reportName + ".jasper");

			JasperPrint jasperPrint = JasperFillManager.fillReport(reportFilePath, parameters, connection);

			byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

			response.setHeader("Content-Disposition", "attachment; filename=" + reportName + ".pdf");
			response.setContentType("application/pdf");
			response.setContentLength(pdf.length);

			response.getOutputStream().write(pdf);
			response.getOutputStream().flush();

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
}
