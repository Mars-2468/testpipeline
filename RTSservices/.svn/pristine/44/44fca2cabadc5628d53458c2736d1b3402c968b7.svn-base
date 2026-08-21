package com.mars.common.controller;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.mars.common.model.ReportParameters;
import com.mars.common.model.Reports;
import com.mars.common.model.User;
import com.mars.common.model.Zone;
import com.mars.common.model.ZoneMaster;
import com.mars.common.search.UserSearch;
import com.mars.common.service.NodeMasterService;
import com.mars.common.service.PlotService;
import com.mars.common.service.PlotTypeService;
import com.mars.common.service.ReportsService;
import com.mars.common.service.SectorService;
import com.mars.common.service.StageService;
import com.mars.common.service.TenancyService;
import com.mars.common.service.UserService;
import com.mars.common.service.WardMasterService;
import com.mars.common.service.WardService;
import com.mars.common.service.ZoneMasterService;
import com.mars.common.utils.AuditTrail;
import com.mars.common.utils.CommonRequestUtils;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.ReportsCoreEntitiesBean;
import com.mars.common.utils.SessionUser;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterConfiguration;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import net.sf.jasperreports.web.util.WebHtmlResourceHandler;

/**
 * <p>Title: ReportsController.java </p>

 * <p>Description: This is a  Reports controller class for controlling Reports related actions</p>

 * @see com.egov.BND.model.Reports

 * Copyright (c) 2014 for NMMC

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 *
 */
@Controller
public class ReportsController extends MultiActionController implements InitializingBean
{

    private static Log log = LogFactory.getLog(ReportsController.class);

	private String jasperExtension = ".jasper";

    private static String const_OrderBy = "OrderBy";

    private static String const_SortBy = "SortBy";
    
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ReportsCoreEntitiesBean reportsCoreEntitiesBean;

    @Autowired
    private ReportsService reportsService;


    @Autowired
	private WardService wardService;

    @Autowired
	private SectorService sectorService;

    @Autowired
	private NodeMasterService nodeMasterService;


    @Autowired
	private PlotTypeService plotTypeService;

    @Autowired
	private PlotService plotService;

    @Autowired
	private StageService stageService;

    @Autowired
	private UserService userService;
    
    @Autowired
   	private TenancyService tenancyService;
    
    @Autowired
    private ZoneMasterService zoneMasterService;
    
    @Autowired
    private WardMasterService wardMasterService;
    


	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @return the plotTypeService
	 */
	public PlotTypeService getPlotTypeService() {
		return plotTypeService;
	}

	/**
	 * @param plotTypeService the plotTypeService to set
	 */
	public void setPlotTypeService(PlotTypeService plotTypeService) {
		this.plotTypeService = plotTypeService;
	}

	/**
	 * @return the plotService
	 */
	public PlotService getPlotService() {
		return plotService;
	}

	/**
	 * @param plotService the plotService to set
	 */
	public void setPlotService(PlotService plotService) {
		this.plotService = plotService;
	}

	public void setStageService(StageService stageService) {
		this.stageService = stageService;
	}

	public void setNodeMasterService(NodeMasterService nodeMasterService) {
		this.nodeMasterService = nodeMasterService;
	}

	public void setSectorService(SectorService sectorService) {
		this.sectorService = sectorService;
	}

	public void setWardService(WardService wardService) {
		this.wardService = wardService;
	}
	
	
	

	public void setTenancyService(TenancyService tenancyService) {
		this.tenancyService = tenancyService;
	}
	
	

	public void setWardMasterService(WardMasterService wardMasterService) {
		this.wardMasterService = wardMasterService;
	}
	
	

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @param reportsCoreEntitiesBean the reportsCoreEntitiesBean to set
	 */
	public void setReportsCoreEntitiesBean(
			ReportsCoreEntitiesBean reportsCoreEntitiesBean) {
		this.reportsCoreEntitiesBean = reportsCoreEntitiesBean;
	}

	
	

	/**
     * @param reportsService
     *            sets the ReportsService object.
     */
    public void setReportsService(ReportsService reportsService)
    {
	this.reportsService = reportsService;
    }

    public void afterPropertiesSet() throws Exception
    {

    }


	/**
	 * @return the sectionService
	 */




	

	public void setZoneMasterService(ZoneMasterService zoneMasterService) {
		this.zoneMasterService = zoneMasterService;
	}

	/**
     * This method is to bind the date objects in the specifed format.
     *
     */
    /** protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception
    {
	SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
	df.setLenient(true);
	binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(df, true));
    }

    /**
     *
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for saving
     *         Reports entries to the database.
     */
	@RequestMapping("/reports/saveReports.do")
    public ModelAndView saveReports(HttpServletRequest request, HttpServletResponse response, Reports reports) throws ServletException,Exception
    {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		
		 User user=userService.get(sessionUser.getUserId());    String deleteReportParametersIds = request.getParameter("deleteReportParametersDetails");

	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveReports");
	}
	if (reports != null)
	{
	    reports.setReportParameters(getReportParameterDetails(request, reports));
//	    if(user.getTenancy()!=null){
//	    reports.setTenancyid(user.getTenancy().getTenancyId());
//	    }

	    reportsService.save(reports,deleteReportParametersIds);
	    session.setAttribute("message", "Report Details Saved Successfully");
		request.setAttribute("rowsize",reports.getReportParameters().size());
	}

	ModelAndView modelandView = new ModelAndView("manageReports");
	modelandView.addObject("reports", reports);
	return modelandView;
    }

    /**
     *
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response. This method is for
     *         editing/creating Reports entries
     */
	@RequestMapping("/rtsapplication/editReports.do")
    public ModelAndView editReports(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking editReports");
		}

		Reports reports = null;
		String reportsId = request.getParameter("reportsId");
		if (reportsId != null && reportsId.length() > 0)
		{
		    reports = reportsService.get(Long.parseLong(reportsId));
		} else
		{
		    reports = new Reports();
		}
		request.setAttribute("rowsize",reports.getReportParameters().size());

		return new ModelAndView("manageReports", "reports", reports);
    }

    /**
     *
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method will display
     *         list of Reports
     */
	@RequestMapping("/reports/listReports.do")
    public ModelAndView listReports(HttpServletRequest request, HttpServletResponse response) throws ServletException,Exception
    {
		if (log.isDebugEnabled())
		{
		    log.debug("Invoking listReports");
		}

	
			Reports searchOptions = new Reports();
			setSearchParameters(searchOptions, request);

			//List<Reports> ReportsList = reportsService.getReportsList(longCurrentPage, orderBy, sortBy);
			List<Reports> ReportsList = reportsService.getReportsListBySearch(searchOptions);

			long totalCount = reportsService.getReportsCountBySearch(searchOptions);
			request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
			request.setAttribute("totalCount", totalCount);


			//Check if the ReportsList is null
			if (ReportsList == null)
			    ReportsList = new ArrayList<Reports>();

			request.setAttribute("currentPage", searchOptions.getCurrentPage());
			request.setAttribute(const_OrderBy, searchOptions.getOrderBy());
			request.setAttribute(const_SortBy, searchOptions.getSortBy());
			request.setAttribute("searchOptions", searchOptions);

			return new ModelAndView("listReports", "ReportsList", ReportsList);
	
    }

	@RequestMapping("/rtsapplication/listAuditReports.do")
    public ModelAndView listAuditReports(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking listAuditReports");
	}
	List ReportsList = reportsService.getReportListByCategory("summary");
	request.setAttribute("PAGE_HEADING", "Audit - ");
	request.setAttribute("REPORTS_LIST_PAGE_URL", "/rtsapplication/listAuditReports.do");
	return new ModelAndView("listFormattedReports", "ReportsList", ReportsList);
    }


    private void setSearchParameters(Reports searchOptions, HttpServletRequest request)throws Exception {
    	long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
		String orderBy = request.getParameter(const_OrderBy);
		String sortBy = request.getParameter(const_SortBy);

    	// setting default order by on userName
    	if (orderBy == null || orderBy.length() < 1) {
    		orderBy = "reportDisplayName";
    	    sortBy = "asc";
    	}

    
			searchOptions.setCurrentPage(longCurrentPage);
			searchOptions.setOrderBy(orderBy);
			searchOptions.setSortBy(sortBy);

			searchOptions.setReportName(request.getParameter("searchReportName"));
			searchOptions.setReportDisplayName(request.getParameter("searchReportDisplayName"));
			searchOptions.setReportPath(request.getParameter("searchReportPath"));
			searchOptions.setReportType(request.getParameter("searchReportType"));

	
    }

    /**
     *
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a Reports
     *         entry from database
     * @throws Exception 
     */
    @RequestMapping("/reports/deleteReports.do")
    public ModelAndView deleteReports(HttpServletRequest request, HttpServletResponse response) throws ServletException,Exception
    {
	HttpSession session = request.getSession();
	if (log.isDebugEnabled())
	{
	    log.debug("Invoking saveReports");
	}
	String reportsId = request.getParameter("reportsId");
	if (reportsId != null && reportsId.length() > 0)
	{
	    Reports reports = reportsService.get(Long.parseLong(reportsId));
	    if (reports != null)
	    {
		reportsService.delete(Long.parseLong(reportsId));
		session.setAttribute("message", "Report Details Deleted Successfully");
	    }
	}
	return listReports(request, response);
    }

    private Set<ReportParameters> getReportParameterDetails(HttpServletRequest request, Reports reports)throws Exception
    {

	Set<ReportParameters> reportParameterSet = null;
	String strDeleteIds[] = null;

	    String deleteReportParametersDetails = request.getParameter("deleteReportParametersDetails");
	    if (deleteReportParametersDetails != null && deleteReportParametersDetails.length() > 0)
	    {
		strDeleteIds = deleteReportParametersDetails.split(",");
	    }

	    long[] reportParametersId = CommonRequestUtils.getLongParameters(request, "reports.reportParameters.reportParametersId");
	    String[] reportParameterNames = CommonRequestUtils.getStringParameters(request, "reports.reportParameters.name");
	    String[] reportParameterDispNames = CommonRequestUtils.getStringParameters(request, "reports.reportParameters.displayName");
	    String[] reportParameterDataTypes = CommonRequestUtils.getStringParameters(request, "reports.reportParameters.dataType");
	    String[] reportParameterEntityNames = CommonRequestUtils.getStringParameters(request, "reports.reportParameters.internalEntityName");
	    int[] reportParameterRequired = CommonRequestUtils.getIntParameters(request, "reports.reportParameters.reportParameterRequired");
	    String[] reportParameterDefaultValues = CommonRequestUtils.getStringParameters(request, "reports.reportParameters.defaultValue");
	    int[] reportParameterSize = CommonRequestUtils.getIntParameters(request, "reports.reportParameters.size");


	    if (reportParametersId != null && reportParametersId.length > 0)
	    {
			int arrayLength = reportParametersId.length;
			reportParameterSet = new HashSet<ReportParameters>();
			for (int i = 0; i < arrayLength; i++)
			{
				if(reportParameterNames[i] != null && reportParameterNames[i].length() > 0)
				{
				    boolean blndeletedId = false;
				    if (strDeleteIds != null && strDeleteIds.length > 0)
				    {
						for (String deleteId : strDeleteIds)
						{
						    if (Long.parseLong(deleteId) == reportParametersId[i])
							blndeletedId = true;
						}
				    }
				    if (!blndeletedId)
				    {
						ReportParameters parameters = new ReportParameters();
						parameters.setName(reportParameterNames[i]);
						parameters.setDisplayName(reportParameterDispNames[i]);
						parameters.setReportParametersId(reportParametersId[i]);
						parameters.setDataType(reportParameterDataTypes[i]);
						parameters.setDefaultValue(reportParameterDefaultValues[i]);
						parameters.setInternalEntityName(reportParameterEntityNames[i]);
						parameters.setSize(reportParameterSize[i]);
						parameters.setReports(reports);
//						parameters.setReportParameterRequired(reportParameterRequired[i]);
//					parameters.setReportParameterRequired(Boolean.FALSE);
//						if (reportParameterRequired[i] == Constants.STATUS_YES.intValue())
//						    parameters.setReportParameterRequired(Boolean.TRUE);

						reportParameterSet.add(parameters);
				    }
				}
			}
	    }

	return reportParameterSet;
    }

    /**
     *
     * @param request
     *            current HTTP request
     * @param response
     *            current HTTP response
     * @return a ModelAndView to render the response This method deletes a Reports
     *         entry from database
     * @throws Exception 
     */
    @RequestMapping("/rtsapplication/setReportParameters.do")
    public ModelAndView setReportParameters(HttpServletRequest request, HttpServletResponse response) throws ServletException,Exception
    {
        if (log.isDebugEnabled()) {
            log.debug("Invoking saveReports");
          }
          
//          long tenancyId = sessionUser.getTenancyId();
//          Tenancy tenancy = this.tenancyService.get(tenancyId);
          String reportsId = request.getParameter("reportsId");
          
          UserSearch searchOptions = new UserSearch();
//          searchOptions.setTenancyId(tenancyId);
          if ((reportsId != null) && (reportsId.length() > 0))
          {
            Reports reports = this.reportsService.get(Long.parseLong(reportsId));
            if (reports != null)
            {
              request.setAttribute("Report", reports);
              getRecentGenReportsByName(request, reports.getReportName());
            }
            TreeSet<ReportParameters> sortedReportParameters = new TreeSet();
            for (ReportParameters paramTest : reports.getReportParameters()) {
              sortedReportParameters.add(paramTest);
            }
            
            List<ZoneMaster> zoneMaster = zoneMasterService.getAll();
            request.setAttribute("zoneMaster", zoneMaster);

            request.setAttribute("ReportParameters", sortedReportParameters);
            
            Long zoneid = Long.valueOf(0L);
            Long categoryId = Long.valueOf(0L);
            for (ReportParameters param : sortedReportParameters) {
              if ((param.getInternalEntityName() != null) && (param.getInternalEntityName().length() > 0))
              {
                if ((param.getInternalEntityName().equals("Zone")) && 
                  (request.getParameterMap().containsKey("report.reportParameters.id" + param.getReportParametersId()))) {
                  zoneid = Long.valueOf(Long.parseLong(request.getParameter("report.reportParameters.id" + param.getReportParametersId())));
                }
                if ((param.getInternalEntityName().equals("Category")) && 
                  (request.getParameterMap().containsKey("report.reportParameters.id" + param.getReportParametersId()))) {
                  categoryId = Long.valueOf(Long.parseLong(request.getParameter("report.reportParameters.id" + param.getReportParametersId())));
                }
              }
            }
            for (ReportParameters param : sortedReportParameters) {
              if ((param.getInternalEntityName() != null) && (param.getInternalEntityName().length() > 0)) {
                if (param.getInternalEntityName().equals("FinancialYear")) {
//                  request.setAttribute("financialYearList", this.financialYearService.getAll());
                } else if (param.getInternalEntityName().equals("Ward"))
                {
                  if ((zoneid != null) && (zoneid.longValue() > 0L)) {
                    request.setAttribute("wardList", this.wardMasterService.getWardMasterListBasedOnZoneId(zoneid.longValue()));
                  } else if (zoneid.longValue() == -1L) {
                    request.setAttribute("wardList", this.wardMasterService.getAll());
                  } else {
                    request.setAttribute("wardList", null);
                  }
                }
//                else if (param.getInternalEntityName().equals("Category")) {
//                  request.setAttribute("licenseCategoryList", this.licenseCategoryService.getAll());
//                } else if (param.getInternalEntityName().equals("SubCategory"))
//                {
//                  if ((categoryId != null) && (categoryId.longValue() > 0L)) {
//                    request.setAttribute("licenseSubCategoryList", this.licenseSubCategoryService.getLicenseSubCategoryListByCategoryIdAndTenancyBased(categoryId.longValue(), tenancyId));
//                  } else {
//                    request.setAttribute("licenseSubCategoryList", null);
//                  }
//                }
//                else if (param.getInternalEntityName().equals("Month")) {
//                  request.setAttribute("monthList", CommonUtils.getReportMonths());
//                }
                else if (param.getInternalEntityName().equals("Stage")) {
                  request.setAttribute("stageList", this.stageService.getAll());
                } else if (param.getInternalEntityName().equals("User")) {
                  request.setAttribute("userList", this.userService.getUserByType(searchOptions));
                } else if (param.getInternalEntityName().equals("AUDIT_ENTITY_NAME")) {
                  request.setAttribute("entityList", this.reportsService.getAuditTrailEntityList());
                } else if (param.getInternalEntityName().equals("AUDIT_PROPERTY_NAME")) {
                  request.setAttribute("entityPropertyList", this.reportsService.getAuditTrailEntityPropertyList(""));
                } else if (param.getInternalEntityName().equals("tenancy")) {
                  request.setAttribute("tenancyList", this.tenancyService.getAll());
                } else if (param.getInternalEntityName().equals("Zone")) {
                  request.setAttribute("zoneList", this.zoneMasterService.findByProperty("city.cityId", 1));
                } else if (param.getInternalEntityName().equals("ULB")) {
                  request.setAttribute("ulbList", this.tenancyService.findByProperty("tenancyId", Long.valueOf(1)));
                }
                else if (param.getInternalEntityName().equals("PaymentMode")) {
                    request.setAttribute("PaymentMode", this.tenancyService.findByProperty("tenancyId", Long.valueOf(1)));
                  }else {
                  this.reportsCoreEntitiesBean.setEntities(request, param.getInternalEntityName());
                }
              }
            }
          }
          
//          List<User> userList = userService.getUsersListByDepartment(53);
//          request.setAttribute("userList", userList);
          
          
          
          String isGenReportPage = request.getParameter("isGenReportPage");
          if ((isGenReportPage != null) && (isGenReportPage.equalsIgnoreCase("Yes"))) {
            generateReport(request, response);
          }
          CommonTokenUtils.setNewToken(request);
          request.setAttribute("REPORTS_LIST_PAGE_URL", request.getParameter("REPORTS_LIST_PAGE_URL"));
          return new ModelAndView("manageReportParameters");
        }

    public void generateReport(HttpServletRequest request, HttpServletResponse response) throws ServletException,Exception {
		String contentType = null;
		String fileExtension = ".pdf";
		boolean flagStatus = false;
		String requestURL = request.getRequestURL().toString();
		String ctx = request.getContextPath();
		String serverHost =  requestURL.substring(0,requestURL.indexOf(ctx));
		HttpSession session=request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
//		long tenancyid=sessionUser.getTenancyId();
		
		int isMultilingual = Constants.STATUS_NO.intValue();
		String strReportId = request.getParameter("reportsId");
		Reports reports1 = null;
    	String strReportName = null;
    	String strReportPath = null;
		
    	if(strReportId != null && strReportId.length() > 0){
			long strReportId1 =  Long.parseLong(strReportId); 
			reports1=reportsService.get(strReportId1);
			strReportName = reports1.getReportName();
			strReportPath = reports1.getReportPath();
			strReportPath = strReportPath;
		}
    	
//    	if(tenancyid==1 && Integer.parseInt(strReportId) !=9 && Integer.parseInt(strReportId) !=10 && Integer.parseInt(strReportId) !=7){
//    		if(strReportName !="CollectionWiseReport" && strReportName !="ApplicationWiseReport" && strReportName !="License_DuplicateReport"){
//    		//strReportName="License_Certificate_Ajmer";
//    		}
//    	}
			if (strReportId != null && strReportId.trim().length() > 0) {
			if (strReportPath != null && strReportPath.length() > 0) {
				if (!strReportPath.endsWith("/")) {
					strReportPath = strReportPath + "/" + strReportName + jasperExtension;
				} else {
					strReportPath = strReportPath + strReportName + jasperExtension;
				}
			} else {
				strReportPath = "/reports/" + strReportName + jasperExtension;
			}
			
//			if(tenancyid==32){
//				if(strReportName.equalsIgnoreCase("License_Certificate")){
//					strReportPath = "/reports/license/"+ "License_Certificate_32" + jasperExtension;
//				}else if(strReportName.equalsIgnoreCase("License_Renew_Certificate")){
//					strReportPath = "/reports/license/"+ "License_Renew_Certificate_32" + jasperExtension;
//				}
//			}

			if (strReportName != null && strReportName.length() > 0) {
				contentType = request.getParameter("reportAs");
				contentType = contentType;
				if (contentType == null) {
					contentType = Constants.CONTENT_TYPE_PDF;
				}
				String reportPath = request.getParameter("reportPath");
				HashMap<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(reportPath +"/"));
				System.out.println("-- SUBREPORT_DIR = " + getServletContext().getRealPath(reportPath+"/"));
				parameters.put("REPORT_TITLE1", Constants.REPORT_TITLE1);
				parameters.put("REPORT_TITLE2", Constants.REPORT_TITLE2);
				parameters.put("REPORT_LOGO_PATH", serverHost + request.getContextPath() + "/reports/Logo.gif");
				parameters.put("REPORT_NMMC_LOGO_PATH", serverHost + request.getContextPath() + "/reports/NMMC-Logo.jpg");
				parameters.put("REPORT_INDIA_LOGO_PATH", serverHost + request.getContextPath() + "/reports/India-Logo.jpg");
				/*parameters.put("Image_Logo_path", serverHost + request.getContextPath() + "/reports/Logo.jpg");*/
				parameters.put("Image_Logo_path_ulb", getServletContext().getRealPath("/reports")+"/image"+1+".jpg");
				parameters.put("Image_Logo_path",getServletContext().getRealPath("/reports"));
				parameters.put("unEmp",7);
				parameters.put("amc_logo",
						getServletContext().getRealPath("/images/amclogodash.jpeg"));
			
				Locale locale = RequestContextUtils.getLocale(request);
				if(locale.getCountry()!=null && locale.getCountry().equalsIgnoreCase("us")){
					locale = new Locale("");
				}

				parameters.put(JRParameter.REPORT_LOCALE, locale);
				Connection connection = null;
				ClassLoader cl = Thread.currentThread().getContextClassLoader();
				try {
//					if (CommonTokenUtils.allowFormSubmit(request))
//				    {
					HashMap<String, String> requestReportParams = new HashMap<String, String>();

					connection = sessionFactory.getCurrentSession().connection();

					Reports reports = reportsService.get(Long.parseLong(strReportId));

					if(reports.getIsMultilingual() != null)
						isMultilingual = reports.getIsMultilingual().intValue();

					//Storing the selected values to default them back in jsp page
					Set<ReportParameters> reportParametersSet = reports.getReportParameters();
					requestReportParams.put("reportAs",contentType);

					long zoneid = 0;
					long wardid = 0;
					long categoryid=0;
					long subcategoryid=0;
					long typeoflicense=0;
					

					
					for (ReportParameters reportParameters : reportParametersSet) {
						String strKey = reportParameters.getName();
						String strValue = request.getParameter("report.reportParameters.id" + reportParameters.getReportParametersId());
						strValue = strValue;
						requestReportParams.put("report.reportParameters.id" + reportParameters.getReportParametersId(),strValue);
						
						if(strKey.equals("ZONE_ID")){
							zoneid=Long.parseLong(strValue);
						}
						if(strKey.equals("WARD_ID")){
							wardid=Long.parseLong(strValue);
						}
						if(strKey.equals("category_id")){
							categoryid=Long.parseLong(strValue);
						}
						if(strKey.equals("license_subcategory_id")){
							subcategoryid=Long.parseLong(strValue);
						}
						if(strKey.equals("license_type")){
							typeoflicense=Long.parseLong(strValue);
						}
						
						
						if (strValue == null || strValue.trim().length() == 0) {
							strValue = reportParameters.getDefaultValue();
						}
						if (strValue != null && strValue.trim().length() > 0) {
						
							try {
								// Handle financial year differently
								if (reportParameters.getInternalEntityName() != null && (reportParameters.getInternalEntityName().equals("FinancialYear"))) {
									StringTokenizer stk = new StringTokenizer(strValue, "~");
									parameters.put(strKey, stk.nextToken());
									parameters.put(strKey + "_START_LABEL", stk.nextToken());
									parameters.put(strKey + "_END_LABEL", stk.nextToken());
									if(stk.hasMoreTokens())
										parameters.put(strKey + "_LABEL", stk.nextToken());

								} 
								if (reportParameters.getInternalEntityName() != null && (reportParameters.getInternalEntityName().equals("SECTION_ID"))) {
									
									Integer sectionId = Integer.parseInt(strValue);
									parameters.put(strKey , sectionId);
								}	
								else {
								
									// Tokenize the strValue to separate out the
									// ID and name
									StringTokenizer stk = new StringTokenizer(strValue, "~");
									parameters.put(strKey, stk.nextToken());
									parameters.put(strKey + "_LABEL", stk.nextToken());
								}
							} catch (NoSuchElementException ne) {
							}
							
							
						}
					}
					
					parameters.put("ZONE_ID", zoneid);
					parameters.put("WARD_ID", wardid);
					parameters.put("category_id", categoryid);
					parameters.put("license_subcategory_id", subcategoryid);
					parameters.put("unEmp", 7);
					parameters.put("license_type", typeoflicense);
					request.setAttribute("requestReportParams", requestReportParams);
					Thread.currentThread().setContextClassLoader(JasperDesign.class.getClassLoader());
					InputStream reportStream = getServletContext().getResourceAsStream(strReportPath);
					System.out.println("ReportsController :: generateReport() :: JasperFillManager.fillReport() method : Start ");
					String  reportFilePath = getServletContext().getRealPath(strReportPath);
					
					//Calling Report Download
					sendReportDownload(request, response, reportFilePath, strReportName, parameters);
					
//					System.out.println("ReportsController :: generateReport() :: JasperFillManager.fillReport() method : end ");
//					String BaseDir = getServletContext().getRealPath(request.getContextPath()) + "/uploads/reports/";
//					BaseDir = BaseDir + request.getSession().getId() + "/";
//					File reportsDir = new File(BaseDir);
//					reportsDir.mkdirs();
//					reportsDir.deleteOnExit();
//
//					if (contentType.equals(Constants.CONTENT_TYPE_PDF)) {
//						File reportFile = new File(BaseDir + strReportName+".pdf");
//							exportToPdf(jasperPrint,reportFile);
//							fileExtension = ".pdf";
//					} else if (contentType.equals(Constants.CONTENT_TYPE_EXCEL)){
//						if(strReportId.equalsIgnoreCase("11") || strReportId.equalsIgnoreCase("12")){
//							File reportFile = new File(BaseDir + strReportName+".xls");
//							exportToExcelIndividual(request,reportFile);
//							fileExtension = ".xls";
//						}else{
//							File reportFile = new File(BaseDir + strReportName+".xlsx");
//							exportToExcel(jasperPrint,reportFile);
//							fileExtension = ".xlsx";
//						}
//						
//					} else if (contentType.equals(Constants.CONTENT_TYPE_TEXT_HTML)) {
//						File reportFile = new File(BaseDir + strReportName+".html");
//						exportToHtml(jasperPrint,reportFile,request);
//						fileExtension = ".html";
//					} else if (contentType.equals(Constants.CONTENT_TYPE_WORD)) {
//							File reportFile = new File(BaseDir + strReportName+".docx");
//						exportToDocx(jasperPrint, reportFile);
//						fileExtension = ".docx";
//					}
//					String iff = request.getSession().getId();
//					System.out.println("======================================>>>  "+iff);
//					System.out.println("ReportsController :: generateReport() :: Report Generated successfully for : " + strReportName);
//					String statusMessage = "Report Generated successfully. Please ";
//					statusMessage = statusMessage + "<a href='"+request.getContextPath()+request.getContextPath()+"/uploads/reports/" + request.getSession().getId()+"/"+ strReportName + fileExtension
//					+ "' target='popup'> Click Here </a> &nbsp; to download. ";
//
//				//this urlLink attribute is used in manageReportParameters page to show teh report contents directly in iFrame in same page
//					String urlLink=request.getContextPath()+request.getContextPath()+"/uploads/reports/" + request.getSession().getId()+"/"+ strReportName + fileExtension;
//					request.setAttribute("urlLink", urlLink);
//					
//					request.setAttribute("reportMessage", statusMessage);
//				}
				}
				catch (Exception ex) {
					System.out.println("ReportsController :: generateReport() :: Report Generation Failed  for : " + strReportName);
					ex.printStackTrace();
					String statusMessage = "Report Generation Failed , Please contact administrator ";
					flagStatus = true;
					/*String formatMessage = "Please entered the correct format";
					statusMessage = statusMessage + "<BR>" + ex.getMessage() +"<BR>"+formatMessage;
					if(ex.getCause() != null)
						statusMessage = statusMessage + "<BR>" + ex.getCause().getMessage();*/
					request.setAttribute("flagStatus", flagStatus);
					request.setAttribute("reportMessage", statusMessage);
					 PrintWriter pw = new PrintWriter(new File("/root/Desktop/LicenseReportExceptionTxt.txt"));
					  ex.printStackTrace(pw);
					  pw.close();        
					ex.printStackTrace();
				} finally{

					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					Thread.currentThread().setContextClassLoader(cl);
				}
			}
		}

	}


	@RequestMapping("/reports/recentlyGeneratedReports.do")
	public ModelAndView recentlyGeneratedReports(HttpServletRequest request, HttpServletResponse response) throws ServletException,Exception
    {
		HttpSession httpSession = request.getSession();
		String reportsPath = getServletContext().getRealPath(request.getContextPath()+"/uploads/reports/"+ httpSession.getId());

		File folder = new File(reportsPath);

		List reportFileDescriptionList = new ArrayList();

	     File[] files = folder.listFiles();
	     if(files !=null && files.length >0)
	     {
	    	 for (File file : files) 
	    	 {
					reportFileDescriptionList.add(file.getName());
			}
	    	 httpSession.setAttribute("generatedReportMessage", "");
	     }
	     else
	    	 httpSession.setAttribute("generatedReportMessage", "Reports are not yet generated in this session");

	    request.setAttribute("reportFileDescriptionList", reportFileDescriptionList);
		return new ModelAndView("manageRecentlyGeneratedReports");
    }

	private void exportToPdf(JasperPrint jasperPrint, File file) throws Exception,JRException{
	
			
			net.sf.jasperreports.engine.export.JRPdfExporter pdfExporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
			
			pdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file));
			//SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
			pdfExporter.exportReport();

	
	}

	/*private void exportMultiLingualToPdf(JasperPrint jasperPrint, File file) throws Exception{
		try {
			ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
			in.cdac.ilcg.jasperreports.pdfexporter.JRPdfExporter pdfExporter = new in.cdac.ilcg.jasperreports.pdfexporter.JRPdfExporter();

			pdfExporter.setParameter(JRExporterParameter.CHARACTER_ENCODING,"UTF-8");
			pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);

			pdfExporter.setParameter(JRExporterParameter.OUTPUT_FILE, file);

			pdfExporter.exportReport();

			if(pdfExporter.getParameter(JRExporterParameter.OUTPUT_STREAM)!=null)
				FileUtils.writeByteArrayToFile(file, arrayOutputStream.toByteArray());

		} catch (JRException exception) {
			exception.printStackTrace();
			log.error("error while executing exportToPdf method :", exception);
			throw exception;
		} catch(Exception e){
			e.printStackTrace();
			log.error("Other exception  :", e);
			throw e;
		}
	}*/
	private void exportToExcel(JasperPrint jasperPrint, File file) throws Exception{
		JRXlsxExporter excelExporter = new JRXlsxExporter();
		excelExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		excelExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file));			
		excelExporter.exportReport();
	}
	private void exportToExcelIndividual(HttpServletRequest request, File file) throws Exception{
	
		String strReportId = request.getParameter("reportsId");
	    Reports reports1 = null;
	    String strReportName = null;
	    String strReportPath = null;
	    if ((strReportId != null) && (strReportId.length() > 0))
	    {
	      long strReportId1 = Long.parseLong(strReportId);
	      reports1 = this.reportsService.get(strReportId1);
	      strReportName = reports1.getReportName();
	    }
	    Reports reports = this.reportsService.get(Long.parseLong(strReportId));
	    String fromDate = "";
	    String toDate = "";
	    String ULB = "";
	    

	    Set<ReportParameters> reportParametersSet = reports.getReportParameters();
	    HashMap<String, String> requestReportParams = new HashMap();
	    for (ReportParameters reportParameters : reportParametersSet)
	    {
	      String strKey = reportParameters.getName();
	      String strValue = request.getParameter("report.reportParameters.id" + reportParameters.getReportParametersId());
	      requestReportParams.put("report.reportParameters.id" + reportParameters.getReportParametersId(), strValue);
	      if ((strValue == null) || (strValue.trim().length() == 0)) {
	        strValue = reportParameters.getDefaultValue();
	      }
	      if (strKey.equals("FROM_DATE")) {
	        fromDate = strValue;
	      }
	      if (strKey.equals("TO_DATE")) {
	        toDate = strValue;
	      }
	      if (strKey.equals("ULB")) {
	    	 ULB = strValue;
	      }
	    }
	    String ULBCondition=null;
	    if(ULB!=null && ULB.length()>0){
	    	ULBCondition=ULB;
	    }else{
	    	ULBCondition ="COALESCE(to_number(NULLIF("+ULB+",''),'9999999999'), ten.tenancyid)";
	    }
	   
	    HSSFWorkbook workbook = new HSSFWorkbook();
	    String sql=null;
	    String SheetName=null;
	    if(strReportId.equalsIgnoreCase("11")){
	     sql= "select DISTINCT on (app_form.application_number) app_form.application_number,app_form.application_date,trim(COALESCE(app_form.first_name, '') || ' ' || COALESCE(app_form.last_name, '')), app_form.business_name , addr.addressline1 , (CASE trad.type_of_license WHEN 1 THEN 'Renewal' ELSE 'New' END) , lics.name as lname, licsub.name as lsname, app_form.final_status , (CASE coll.payment_mode WHEN 'Cash' THEN 'OCC' WHEN 'Cheque' THEN 'OCC' WHEN 'DD' THEN 'OCC' ELSE 'Online' END) as paymentmode , coll.amount , coll.collection_date, (CASE coll.payment_mode WHEN 'Cash'  THEN coll.receipt_number WHEN 'Cheque' THEN coll.receipt_number WHEN 'DD' THEN coll.receipt_number ELSE coll.transaction_num END) , ten.name as tname, zone.name as zname , ward.name as wname,app_form.license_issue_date,app_form.license_no from egovlicense.application_form  app_form , egovlicense.license_period  lic , egovlicense.collection coll , egovlicense.trade_and_storage trad , egovlicense.trade_and_storage_commodities trco , egovlicense.license_sub_category licsub , egovlicense.license_category lics, egovlicense.address_details addr , egovcommon.tenancy ten, egovcommon.ward_master ward , egovcommon.zone_master zone where app_form.application_form_id = lic.application_form_id and trad.application_form_id = app_form.application_form_id and coll.collection_id = lic.collection_id and trad.trade_and_storage_id = trco.trade_and_storage_id and trco.license_sub_category_id =  licsub.license_sub_category_id and trad.license_category_id = lics.license_category_id and licsub.license_sub_category_id = trco.license_sub_category_id and ten.tenancyid = app_form.tenancyid and addr.address_details_id = app_form.business_address_details_id and ward.ward_id= addr.ward_id and zone.zone_id = addr.zone_id and coll.transaction_status='success' and "
	    		+ "ten.tenancyid= "+ULBCondition +" and to_date(coll.collection_date,'dd/mm/yyyy') between to_date('" + fromDate + "','dd/mm/yyyy') and to_date('" + toDate + "','dd/mm/yyyy') order by app_form.application_number";
	     SheetName="License Application Wise Transactions List";
	    }
	    if(strReportId.equalsIgnoreCase("12")){
	     sql = "select temp.tname as tenancyName,temp.type as applicationType,temp.zname as zoneName,sum(totalApplinReceived) as totalApplReceived,sum(departmentLevelCount) as deptLevel,sum(citizenLevelCount) as citizenLevel,sum(LOIIssued_count) as loiIssued,sum(LicenseIssued_count) as licenseIssued,sum(lic_numberNot_gen_count) as licNumberNotGenerated,sum(occAmount) as occAmt,sum(onlineAmount) as onlineAmt from ((select ten.name as tname,app_form.application_type as type ,zone.name as zname,count(*) as totalApplinReceived,sum(case when app_form.final_status not in('LOI Issued','License Issued','Create') then 1 else 0 end) departmentLevelCount,sum(case when app_form.final_status = 'Create' then 1 else 0 end) citizenLevelCount,sum(case when app_form.final_status = 'LOI Issued' then 1 else 0 end) LOIIssued_count,sum(case when (app_form.final_status = 'License Issued' and app_form.license_no IS NOT NULL) then 1 else 0 end) LicenseIssued_count,sum(case when (app_form.final_status = 'License Issued' and app_form.license_no IS NULL) then 1 else 0 end) lic_numberNot_gen_count,0 as occAmount,0 as onlineAmount  from egovlicense.application_form app_form,egovcommon.tenancy ten,egovlicense.address_details addr ,"
	    		+ " egovcommon.zone_master zone where ten.tenancyid = app_form.tenancyid and ten.tenancyid= "+ULBCondition +" and addr.address_details_id = app_form.business_address_details_id and zone.zone_id = addr.zone_id and to_date(app_form.application_date,'dd/mm/yyyy') between to_date('" + fromDate + "','dd/mm/yyyy') and to_date('" + toDate + "','dd/mm/yyyy') group by app_form.application_type,ten.name,zone.name order by zone.name) "
	    				+ " UNION ALL (select ten1.name as tname,insideform.application_type as type,zone.name as zname,0 as dummy1,0 as dummy1,0 as dummy1,0 as dummy1,0 as dummy1,0 as dummy1,sum(case when coll.payment_mode in('Cash','Cheque','DD') then coll.amount else 0 end) occAmount,sum(case when coll.payment_mode not in('Cash','Cheque','DD') then coll.amount else 0 end) onlineAmount from egovlicense.application_form  insideform,egovlicense.license_period  lic ,egovlicense.collection coll, egovcommon.tenancy ten1,egovlicense.address_details addr ,egovcommon.zone_master zone where"
	    				+ " insideform.application_form_id = lic.application_form_id and coll.collection_id = lic.collection_id and ten1.tenancyid = insideform.tenancyid and addr.address_details_id = insideform.business_address_details_id and zone.zone_id = addr.zone_id and coll.transaction_status='success' and coll.status = 1"
	    				+ " and to_date(coll.collection_date,'dd/mm/yyyy') between to_date('" + fromDate + "','dd/mm/yyyy') and to_date('" + toDate + "','dd/mm/yyyy') and ten1.tenancyid="+ULBCondition +" group by insideform.application_type,ten1.name,zone.name order by zone.name)) as temp group by temp.tname,temp.type,temp.zname order by temp.zname";
	     SheetName="License Zone Wise Summary Report";
	    }
//	    List<ArrayList> GrievanceList = this.licenseCategoryService.getListBySQLQuery(sql, null);
//	    if(GrievanceList!=null && GrievanceList.size()>0){
//	   
//	      HSSFSheet spreadsheet = workbook.createSheet(SheetName);
//	      HSSFRow row;
//	      Map<Integer, Object[]> empinfo = new TreeMap(Collections.reverseOrder());
//	      
//	      if(strReportId.equalsIgnoreCase("11")){
//	    	  empinfo.put(Integer.valueOf(1), new Object[] {
//	    		  "TradeLicense Application Wise Report", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
//	    	  empinfo.put(Integer.valueOf(2), new Object[] {
//	    		  "From Date:", "", "", fromDate, "", "", "ToDate:", "", "", toDate, "", "", "", "", "", "", "" });
//	    	  
//	      empinfo.put(Integer.valueOf(3), new Object[] {
//	        "Slno", "Application Number", "Applicant Apply Date", "Applicant Name", "Business Name", "Business Address", "License Type", "License Category", "License Sub Category", "Status", "License Number","License Issue Date","Payment Mode", "Amount", "Collection Date", "Transaction/Receipt No", "ULB", "Zone", "Ward" });
//	      spreadsheet.addMergedRegion(CellRangeAddress.valueOf("A1:Q1"));
//	      for (int i = 0; i < GrievanceList.size(); i++)
//	      {
//	        String WardName = "";
//	        String SectorName = "";
//	       
//	        if (((ArrayList)GrievanceList.get(i)).get(15) != null) {
//	          WardName = ((ArrayList)GrievanceList.get(i)).get(15).toString();
//	        } else {
//	          WardName = "NA";
//	        }
//	        if (((ArrayList)GrievanceList.get(i)).get(14) != null) {
//	          SectorName = ((ArrayList)GrievanceList.get(i)).get(14).toString();
//	        } else {
//	          SectorName = "NA";
//	        }
//	        empinfo.put(Integer.valueOf(i + 4), new Object[] {
//	          Integer.valueOf(i + 1), ((ArrayList)GrievanceList.get(i)).get(0).toString(), ((ArrayList)GrievanceList.get(i)).get(1).toString(), ((ArrayList)GrievanceList.get(i)).get(2).toString(), ((ArrayList)GrievanceList.get(i)).get(3).toString(), ((ArrayList)GrievanceList.get(i)).get(4).toString(), 
//	          ((ArrayList)GrievanceList.get(i)).get(5).toString(), ((ArrayList)GrievanceList.get(i)).get(6).toString(), ((ArrayList)GrievanceList.get(i)).get(7).toString(), ((ArrayList)GrievanceList.get(i)).get(8).toString(), ((ArrayList)GrievanceList.get(i)).get(17).toString(),((ArrayList)GrievanceList.get(i)).get(16).toString(),((ArrayList)GrievanceList.get(i)).get(9).toString(), ((ArrayList)GrievanceList.get(i)).get(10).toString(), ((ArrayList)GrievanceList.get(i)).get(11).toString(), ((ArrayList)GrievanceList.get(i)).get(12).toString(), ((ArrayList)GrievanceList.get(i)).get(13).toString(), SectorName, WardName });
//	      	}
//	      }
//	      if(strReportId.equalsIgnoreCase("12")){
//	    	  empinfo.put(Integer.valueOf(1), new Object[] {
//	    		  "TradeLicense Summary Report", "", "", "", "", "", "", "", "", "", "", "", ""});
//	    	  empinfo.put(Integer.valueOf(2), new Object[] {
//	    		  "From Date:", "", "", fromDate, "", "", "ToDate:", "", "", toDate, "", "", ""});
//		     
//		      empinfo.put(Integer.valueOf(3), new Object[] {
//		        "Slno", "Category Name", "Zone Name", "No.Of Appl'n Received", "No.Of Appl'n at Department Level", "No.Of Appl'n at Citizen Level", "No.Of Appl'n LOI Issued", "No.Of Appl'n License Issued", "License Issued But Number Not Generated", "ULB", "OCC Amount", "Online Amount", "Total Amount"});
//		      spreadsheet.addMergedRegion(CellRangeAddress.valueOf("A1:M1"));
//		      for (int i = 0; i < GrievanceList.size(); i++)
//		      {
//		        String WardName = "";
//		        String SectorName = "";
//		        Double totalAmt=0.0;
//		       
//		        if (((ArrayList)GrievanceList.get(i)).get(0) != null) {
//		          WardName = ((ArrayList)GrievanceList.get(i)).get(0).toString();
//		        } else {
//		          WardName = "NA";
//		        }
//		        if (((ArrayList)GrievanceList.get(i)).get(2) != null) {
//		          SectorName = ((ArrayList)GrievanceList.get(i)).get(2).toString();
//		        } else {
//		          SectorName = "NA";
//		        }
//		        
//		        if (((ArrayList)GrievanceList.get(i)).get(9) != null || ((ArrayList)GrievanceList.get(i)).get(10) != null) {
//		        	String occamt=((ArrayList)GrievanceList.get(i)).get(9).toString();
//		        	String onlineamt=((ArrayList)GrievanceList.get(i)).get(10).toString();
//		        	totalAmt=Double.parseDouble(occamt)+Double.parseDouble(onlineamt);
//			        } else {
//			        	totalAmt =0.0;
//			        }
//		        
//		       // [Ajmer, Mutton Shop, Ajmer Headquarter , 4, 1, 0, 3, 0, 0, 2410.00, 2.00]
//		        empinfo.put(Integer.valueOf(i + 4), new Object[] {
//		          Integer.valueOf(i + 1), ((ArrayList)GrievanceList.get(i)).get(1).toString(), SectorName,((ArrayList)GrievanceList.get(i)).get(3).toString(),((ArrayList)GrievanceList.get(i)).get(4).toString(), 
//		          ((ArrayList)GrievanceList.get(i)).get(5).toString(), ((ArrayList)GrievanceList.get(i)).get(6).toString(), ((ArrayList)GrievanceList.get(i)).get(7).toString(), ((ArrayList)GrievanceList.get(i)).get(8).toString(), WardName, ((ArrayList)GrievanceList.get(i)).get(9).toString(), ((ArrayList)GrievanceList.get(i)).get(10).toString(),totalAmt});
//		      	}
//		      }
//	      
//	      Set< Integer > keyid = empinfo.keySet();
//	      TreeSet<Integer> orderset = new TreeSet<Integer>(keyid);
//	       int rowid = 0;
//	       
//	       spreadsheet.addMergedRegion(CellRangeAddress.valueOf("A2:C2"));
//	       spreadsheet.addMergedRegion(CellRangeAddress.valueOf("D2:F2"));
//	       spreadsheet.addMergedRegion(CellRangeAddress.valueOf("G2:I2"));
//	       spreadsheet.addMergedRegion(CellRangeAddress.valueOf("J2:L2"));
//	       final Font font = spreadsheet.getWorkbook ().createFont ();
//	       font.setFontName ( "Arial" );
//	       //font.setBoldweight ( Font.BOLDWEIGHT_BOLD );
//
//	       final CellStyle style = spreadsheet.getWorkbook ().createCellStyle ();
//	       style.setFont (font);
//	       style.setAlignment(CellStyle.ALIGN_CENTER);
//	       
//	      for (Integer key : orderset)
//	      {
//	         row = spreadsheet.createRow(rowid++);
//	         Object [] objectArr = empinfo.get(key);
//	         int cellid = 0;
//	         for (Object obj : objectArr)
//	         {
//	            Cell cell = row.createCell(cellid++);
//	            cell.setCellValue(obj.toString());
//	            cell.setCellStyle(style);
//	         }
//	      }
//	      FileOutputStream fileOut = new FileOutputStream(file);
//	        workbook.write(fileOut);
//	        fileOut.close();
//	    }
	
	}

	/*private void exportToRtf(JasperPrint jasperPrint, File file) throws Exception{
		try {
			JRRtfExporter rtfExporter = new JRRtfExporter();
			rtfExporter.setParameter(JRExporterParameter.CHARACTER_ENCODING,"UTF-8");
			rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			rtfExporter.setParameter(JRExporterParameter.OUTPUT_FILE, file);
			rtfExporter.exportReport();
		} catch (JRException exception) {
			log.error("error while executing exportToRtf method :", exception);
			throw exception;
		}catch(Exception e){
			log.error("Other exception  :", e);
			throw e;
		}
	}*/
	
	private void exportToDocx(JasperPrint jasperPrint, File file) throws Exception{
			
						
			JRDocxExporter docxExporter = new JRDocxExporter();
			docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			docxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput (file));
			
			//SimpleDocxReportConfiguration configuration = new SimpleDocxReportConfiguration();
			//docxExporter.setConfiguration(configuration);
			
			docxExporter.exportReport();
			
	
	}

	private void exportToHtml(JasperPrint jasperPrint, File file,HttpServletRequest request) throws Exception{
	
			ServletContext context = request.getSession().getServletContext();			
			request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
			String requestURL = request.getRequestURL().toString();
			String ctx = request.getContextPath();
			String serverHost =  requestURL.substring(0,requestURL.indexOf(ctx));

			SimpleHtmlExporterOutput exporterOutput = new SimpleHtmlExporterOutput(file, "UTF-8");
			exporterOutput.setImageHandler(new WebHtmlResourceHandler(serverHost + request.getContextPath() +"/image?"+ "time=" + System.currentTimeMillis() + "&image="));
			
			net.sf.jasperreports.engine.export.HtmlExporter htmlExporter = new net.sf.jasperreports.engine.export.HtmlExporter();
			htmlExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			htmlExporter.setExporterOutput(exporterOutput);
			
			SimpleHtmlExporterConfiguration configuration = new SimpleHtmlExporterConfiguration();
			configuration.setFlushOutput(true);
			htmlExporter.setConfiguration(configuration);
			
			htmlExporter.exportReport();
	
	}	

	  public List<AuditTrail>  getAuditTrailEntityPropertyList(String entityName) {
		  return reportsService.getAuditTrailEntityPropertyList(entityName);
	  }
	  
	private void getRecentGenReportsByName(HttpServletRequest request,String reportName) throws ServletException
	{
			HttpSession httpSession = request.getSession();
			String reportsPath = getServletContext().getRealPath(request.getContextPath()+"/uploads/reports/"+ httpSession.getId());
			
			File folder = new File(reportsPath);

			List reportFileDescriptionList = new ArrayList();

		     File[] files = folder.listFiles();
		     if(files !=null && files.length >0)
		     {
		    	 for (File file : files) 
		    	 {
		    		 if(file.getName().startsWith(reportName))
					{
						reportFileDescriptionList.add(file.getName());
					}
				}

		     }

		    request.setAttribute("recentGenreportsWithSameName", reportFileDescriptionList);
	    }
	
	
	public void sendReportDownload(HttpServletRequest request, HttpServletResponse response,String reportPath,String reportName,HashMap<String, Object> parameters) {
		try (Connection connnection = sessionFactory.getCurrentSession().connection();) {
			String rtiapplrefid =request.getParameter("rtiApplicationRefId");//"1268";
					
			parameters.put("rtiapplrefid", rtiapplrefid);
			String requestURL = request.getRequestURL().toString();
			String ctx = request.getContextPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parameters, connnection);
			byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

			response.setHeader("Content-Disposition", "attachoment; filename=" + reportName + ".pdf");
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
