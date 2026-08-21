package com.mars.common.controller;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.mars.common.model.Reports;
import com.mars.common.service.ReportsService;
import com.mars.common.utils.Constants;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRRtfExporter;

@Controller
public class ReportController extends MultiActionController implements InitializingBean {
	
	@Autowired
	private ReportsService reportsService;

	private String jasperExtension = ".jasper";
	
	@Autowired
	private SessionFactory sessionFactory;

	private static Log log = LogFactory.getLog(ReportController.class);

	public void afterPropertiesSet() throws Exception {

	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
 
 
	@RequestMapping("/report/generateReportFromScreen.do")
	public void generateReportFromScreen(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String contentType = null;
		String strReportName = (String) request.getAttribute("strReportName");
		String strReportPath = (String) request.getAttribute("strReportPath");
		contentType = (String) request.getAttribute("reportAs");
 
		Reports reports = reportsService.getReportOnName(strReportName);
		int isMultilingual = Constants.STATUS_NO.intValue(); 
			
		if(reports.getIsMultilingual() != null)
			isMultilingual = reports.getIsMultilingual().intValue(); 
		
		String requestURL = request.getRequestURL().toString();
		String ctx = request.getContextPath();
		String serverHost =  requestURL.substring(0,requestURL.indexOf(ctx));

		HashMap<String, Object> parameters = (HashMap) request.getAttribute("reportParams");

		if (strReportName != null && strReportName.trim().length() > 0) {
			if (strReportPath != null && strReportPath.length() > 0) {
				if (!strReportPath.endsWith("/")) {
					strReportPath = strReportPath + "/" + strReportName + jasperExtension;
				} else {
					strReportPath = strReportPath + strReportName + jasperExtension;
				}
			} else {

				strReportPath = "/reports/" + strReportName + jasperExtension;
			}

			if (strReportName != null && strReportName.length() > 0) {

				if (contentType == null) {
					contentType = Constants.CONTENT_TYPE_PDF;
				}

				parameters.put("SUBREPORT_DIR", getServletContext().getRealPath((String)request.getAttribute("strReportPath"))+"/");
				System.out.println("-- SUBREPORT_DIR = " + getServletContext().getRealPath((String)request.getAttribute("strReportPath"))+"/");
				
				parameters.put("REPORT_TITLE1", Constants.REPORT_TITLE1);
				parameters.put("REPORT_TITLE2", Constants.REPORT_TITLE2);
				parameters.put("REPORT_LOGO_PATH", serverHost + request.getContextPath() + "/reports/Logo.gif");
				parameters.put("REPORT_NMMC_LOGO_PATH", serverHost + request.getContextPath() + "/reports/NMMC-Logo.jpg");
				parameters.put("REPORT_INDIA_LOGO_PATH", serverHost + request.getContextPath() + "/reports/India-Logo.jpg");

				Locale locale = RequestContextUtils.getLocale(request);
				if(locale.getCountry()!=null && locale.getCountry().equalsIgnoreCase("us")){
					locale = new Locale("");
				}

				parameters.put(JRParameter.REPORT_LOCALE, locale);

				Connection connection = sessionFactory.getCurrentSession().connection();
				ServletOutputStream servletOutputStream = response.getOutputStream();

			
					ClassLoader cl = Thread.currentThread().getContextClassLoader();
					JasperPrint jasperPrint = null;

					try {
						Thread.currentThread().setContextClassLoader(JasperDesign.class.getClassLoader());
						InputStream reportStream = getServletContext().getResourceAsStream(strReportPath);
						//jasperPrint = JasperFillManager.fillReport(reportStream, parameters, connection);

						String  reportFilePath = getServletContext().getRealPath(strReportPath);
						jasperPrint = JasperFillManager.fillReport(reportFilePath, parameters, connection);
						
						if (contentType.equals(Constants.CONTENT_TYPE_PDF)) {
							response.setContentType(contentType);
							response.setHeader("Content-disposition", "attachment;filename=" + strReportName + ".pdf");
							//if(Integer.valueOf(isMultilingual)==Integer.valueOf(Constants.STATUS_NO))
								exportToPdf(jasperPrint,servletOutputStream);
							/*else
								exportMultiLingualToPdf(jasperPrint,servletOutputStream);*/
						} else if (contentType.equals(Constants.CONTENT_TYPE_EXCEL)) {
							response.setContentType(contentType);
							response.setHeader("Content-disposition", "attachment;filename=" + strReportName + ".xls");
							exportToExcel(jasperPrint, servletOutputStream);
						} else if (contentType.equals(Constants.CONTENT_TYPE_TEXT_HTML)) {
							response.setContentType(contentType);
							response.setHeader("Content-disposition", "attachment;filename=" + strReportName + ".html");
							exportToHtml(jasperPrint, servletOutputStream, request);
						} else if (contentType.equals(Constants.CONTENT_TYPE_WORD)) {
							response.setContentType(contentType);
							response.setHeader("Content-disposition", "attachment;filename=" + strReportName + ".doc");
							exportToRtf(jasperPrint, servletOutputStream);
						}
					} finally {
						Thread.currentThread().setContextClassLoader(cl);
					}
				
				connection.close();
				servletOutputStream.flush();
				servletOutputStream.close();
			}
		}
	}

	private void exportToPdf(JasperPrint jasperPrint, ServletOutputStream servletOutputStream)throws JRException {
	
			net.sf.jasperreports.engine.export.JRPdfExporter pdfExporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
			pdfExporter.setParameter(JRExporterParameter.CHARACTER_ENCODING,"UTF-8");
			pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			pdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
			pdfExporter.exportReport();
		
	}
	/*private void exportMultiLingualToPdf(JasperPrint jasperPrint, ServletOutputStream servletOutputStream) {
		try {
			in.cdac.ilcg.jasperreports.pdfexporter.JRPdfExporter pdfExporter = new in.cdac.ilcg.jasperreports.pdfexporter.JRPdfExporter();
			pdfExporter.setParameter(JRExporterParameter.CHARACTER_ENCODING,"UTF-8");
			pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			pdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
			pdfExporter.exportReport();
		} catch (JRException exception) {
			log.error("error while executing exportToPdf method :", exception);
		}
	}*/



	private void exportToExcel(JasperPrint jasperPrint, ServletOutputStream servletOutputStream)throws JRException {
	
			JExcelApiExporter excelExporter = new JExcelApiExporter();
			excelExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			excelExporter.setParameter(JRExporterParameter.CHARACTER_ENCODING,"UTF-8");
			excelExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
			excelExporter.exportReport();
		
	}

	private void exportToRtf(JasperPrint jasperPrint, ServletOutputStream servletOutputStream)throws JRException {
	
			JRRtfExporter rtfExporter = new JRRtfExporter();
			rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			rtfExporter.setParameter(JRExporterParameter.CHARACTER_ENCODING,"UTF-8");
			rtfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
			rtfExporter.exportReport();
	
	}

	private void exportToHtml(JasperPrint jasperPrint, ServletOutputStream servletOutputStream, HttpServletRequest request)throws JRException {
	
			JRHtmlExporter htmlExporter = new JRHtmlExporter();
			htmlExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			htmlExporter.setParameter(JRExporterParameter.CHARACTER_ENCODING,"UTF-8");
			htmlExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
			htmlExporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, new Boolean(false));

			ServletContext context = request.getSession().getServletContext();
			htmlExporter.setParameter(JRHtmlExporterParameter.IS_OUTPUT_IMAGES_TO_DIR, Boolean.TRUE);
			htmlExporter.setParameter(JRHtmlExporterParameter.IMAGES_DIR_NAME, context.getRealPath("/images/report/"));

			String requestURL = request.getRequestURL().toString();
			String ctx = request.getContextPath();
			String serverHost =  requestURL.substring(0,requestURL.indexOf(ctx));

			htmlExporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, serverHost + request.getContextPath() + "/images/report/");

			htmlExporter.exportReport();
	
	}

	public void setReportsService(ReportsService reportsService) {
		this.reportsService = reportsService;
	}
}