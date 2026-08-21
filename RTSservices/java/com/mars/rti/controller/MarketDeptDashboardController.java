package com.mars.rti.controller;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.utils.CommonRequestUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.DashBoardLabelSearch;
import com.mars.rti.service.MarketDeptDashboardService;
import com.mars.rti.utils.CoreConstants;

@Controller
public class MarketDeptDashboardController extends MultiActionController implements
	InitializingBean {



			private static String const_OrderBy = "OrderBy";

			private static String const_SortBy = "SortBy";

			private static Log log = LogFactory.getLog(MarketDeptDashboardController.class);

			@Autowired
			private MarketDeptDashboardService marketDeptDashboardService;

			public void afterPropertiesSet() throws Exception {

			}

			@InitBinder
			protected void initBinder(HttpServletRequest request,
					ServletRequestDataBinder binder) throws Exception {
				SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
				df.setLenient(true);
				binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(
						df, true));
			}

			private void commonDashBoardLogic(HttpServletRequest request,
					ModelAndView modelAndView) {

				long newReciepts = 0l;
				long rejectedCount = 0l;
				long closedReciepts = 0l;
				long approvedReiepts = 0l;
				long pendingReiepts = 0l;
				long allReciepts = 0l;
				double Totalfees = 0l;

				
				String registrationFromDate = request
						.getParameter("registrationFromDate");
				String registrationToDate = request.getParameter("registrationToDate");
				String category = request.getParameter("category");

				// checking for search result
				if (((registrationFromDate != null && registrationFromDate.length() > 0) && (registrationToDate != null && registrationToDate
						.length() > 0)) || (category != null && category != "")) {
					List<BigInteger> receiptsCountList = marketDeptDashboardService
							.getPieChartOrBarChartBasedOnSearch(registrationFromDate,
									registrationToDate, category);

					if (receiptsCountList != null && !receiptsCountList.isEmpty()) {
						newReciepts = receiptsCountList.get(0).longValue();
						rejectedCount = receiptsCountList.get(1).longValue();
						closedReciepts = receiptsCountList.get(2).longValue();
						approvedReiepts = receiptsCountList.get(3).longValue();
						pendingReiepts = receiptsCountList.get(4).longValue();
						allReciepts = receiptsCountList.get(5).longValue();
						Totalfees = receiptsCountList.get(6).longValue();

					}

				} else {
					allReciepts = marketDeptDashboardService.getPieChartOrBarChartData();
					newReciepts = marketDeptDashboardService
							.getPieChartOrBarChartData(CoreConstants.RTI_FINALSTATUS_NEW);
					closedReciepts = marketDeptDashboardService
							.getPieChartOrBarChartData(CoreConstants.RTI_FINALSTATUS_CLOSED);
					approvedReiepts = marketDeptDashboardService
							.getPieChartOrBarChartData(CoreConstants.RTI_FINALSTATUS_APPROVED);
					rejectedCount = marketDeptDashboardService
							.getPieChartOrBarChartData(CoreConstants.RTI_FINALSTATUS_REJECTED);
					Totalfees = marketDeptDashboardService
							.getPieChartOrBarChartDatas();
					pendingReiepts = marketDeptDashboardService.getPieChartOrBarChartData(
							CoreConstants.RTI_FINALSTATUS_APPROVED,
							CoreConstants.RTI_FINALSTATUS_CLOSED,
							CoreConstants.RTI_FINALSTATUS_REJECTED);

				}

				// Pie chart Series and data template
				String str = "[    ['Pending', " + pendingReiepts + "],['New',"
						+ newReciepts + "], ['Approved', " + approvedReiepts
						+ "],['Closed', " + closedReciepts + " ],['Rejected', " + rejectedCount
						+ " ],['Totalfees', " + Totalfees + " ] ]";
				
				// Bar chart series and data
				Map<String, Long> map = new HashMap<String, Long>();
				map.put("'Pending'", pendingReiepts);
				map.put("'New'", newReciepts);
				map.put("'Approved'", approvedReiepts);
				map.put("'Closed'", closedReciepts);
				map.put("'Rejected'", rejectedCount);
				map.put("'Totalfees'", (long) Totalfees);

				modelAndView.addObject("newReciepts", newReciepts);
				modelAndView.addObject("closedReciepts", closedReciepts);
				modelAndView.addObject("approvedReiepts", approvedReiepts);
				modelAndView.addObject("pendingReiepts", pendingReiepts);
				modelAndView.addObject("rejectedCount", rejectedCount);
				modelAndView.addObject("Totalfees", Totalfees);
				modelAndView.addObject("allReciepts", allReciepts);
				modelAndView.addObject("data", str);
				modelAndView.addObject("map", map);
				modelAndView.addObject("registrationFromDate", registrationFromDate);
				modelAndView.addObject("registrationToDate", registrationToDate);
				modelAndView.addObject("category", category);
				modelAndView.setViewName("marketDept");

			}

			@RequestMapping("/pages/core-pages/dashboard/marketDept.do")//NICE URL
			public ModelAndView marketDept(HttpServletRequest request,
					HttpServletResponse response) throws Exception {

				ModelAndView modelAndView = new ModelAndView("marketDept");
				commonDashBoardLogic(request, modelAndView);
				return modelAndView;
			}

			@RequestMapping("/dashBoard/getListOnCategoryMarketDept.do")
			public ModelAndView getListOnCategoryMarketDept(HttpServletRequest request,
					HttpServletResponse response) {

				String receiptSatus = request.getParameter("receiptSatus");
				ModelAndView modelAndView = new ModelAndView();
				commonDashBoardLogic(request, modelAndView);

				DashBoardLabelSearch dashBoardLabelSearch = new DashBoardLabelSearch();
				setSearchParameters(dashBoardLabelSearch, request);

				List<RTIApplication> rtiList = marketDeptDashboardService
						.getRTIApplicationListByLabel(dashBoardLabelSearch);
				try {
					long totalCount = marketDeptDashboardService
							.getRTIApplicationCountByLabel(dashBoardLabelSearch);
					request.setAttribute("maximumPages",
							new Long(CommonUtils.getMaxPage(totalCount)));
					request.setAttribute("totalCount", totalCount);
				} catch (Exception e) {
					log.error(e.getMessage());
				}

				// Check if the FeeMasterList is null
				if (rtiList == null)
					rtiList = new ArrayList<RTIApplication>();

				request.setAttribute("currentPage",
						dashBoardLabelSearch.getCurrentPage());
				request.setAttribute(const_OrderBy, dashBoardLabelSearch.getOrderBy());
				request.setAttribute(const_SortBy, dashBoardLabelSearch.getSortBy());
				request.setAttribute("rtiList", rtiList);
				modelAndView.addObject("receiptSatus", receiptSatus);

				return modelAndView;
			}

			private void setSearchParameters(DashBoardLabelSearch dashBoardLabelSearch,
					HttpServletRequest request) {
				if (log.isDebugEnabled()) {
					log.debug("setSearchParameters Method is called");
				}

				try {
					long longCurrentPage = CommonUtils
							.checkPaginationAttributes(request);
					String orderBy = request.getParameter(const_OrderBy);
					String sortBy = request.getParameter(const_SortBy);

					// setting default order by on feeMasterId
					if (orderBy == null || orderBy.length() < 1) {
						orderBy = "r.registrationDate";
						sortBy = "desc";
					}

					dashBoardLabelSearch.setCurrentPage(longCurrentPage);
					dashBoardLabelSearch.setOrderBy(orderBy);
					dashBoardLabelSearch.setSortBy(sortBy);

					String category = request.getParameter("category");
					if (StringUtils.isNotEmpty(category)) {
						dashBoardLabelSearch.setCategory(category);
					}

					String receiptSatus = request.getParameter("receiptSatus");
					if (StringUtils.isNotEmpty(receiptSatus)) {
						dashBoardLabelSearch.setReceiptSatus(receiptSatus);
					}

					String fromDate = CommonRequestUtils.getStringParameter(request,
							"registrationFromDate");
					String toDate = CommonRequestUtils.getStringParameter(request,
							"registrationToDate");

					if ((fromDate != null && fromDate.length() > 0)) {
						dashBoardLabelSearch.setRegistrationFromDate(fromDate);
					}

					if ((toDate != null && toDate.length() > 0)) {
						dashBoardLabelSearch.setRegistrationToDate(toDate);
					}

				} catch (Exception err) {
					log.error(err.getMessage());
				}
			}

		



}
