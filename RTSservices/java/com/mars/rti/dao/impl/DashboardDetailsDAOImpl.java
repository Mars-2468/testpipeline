package com.mars.rti.dao.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.DashboardDetailsDAO;
import com.mars.rti.ws.model.DashboardStatsDTO;
import com.mars.rti.ws.model.DashboardStatsDetailsDTO;

@Repository
public class DashboardDetailsDAOImpl extends HibernateDaoSupport implements DashboardDetailsDAO {

	private static final Log log = LogFactory.getLog(CitizenMyApplicationDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public DashboardStatsDTO getDashboardStats(String startDateStr, String endDateStr) {
	    try {
	    	String sql = "SELECT "
	    	        + "COUNT(*) FILTER (WHERE r.workflow_status IN (0,1,2,3,5,9,10,11) "
	    	        + "AND r.rti_application_number IS NOT NULL "
	    	        + "AND r.rti_application_number <> '') AS total_applications, \n"

	    	        + "COALESCE(SUM(r.application_cost) FILTER ("
	    	        + "WHERE r.workflow_status IN (1,2) "
	    	        + "AND r.rti_application_number IS NOT NULL "
	    	        + "AND r.rti_application_number <> ''"
	    	        + "), 0) AS total_cost, \n"

	    	        + "COUNT(*) FILTER ("
	    	        + "WHERE r.workflow_status = 1 "
	    	        + "AND r.rti_application_number IS NOT NULL "
	    	        + "AND r.rti_application_number <> ''"
	    	        + ") AS completed_applications, \n"

	    	        + "ROUND( (CAST( COUNT(*) FILTER ("
	    	        + "WHERE r.workflow_status = 1 "
	    	        + "AND r.rti_application_number IS NOT NULL "
	    	        + "AND r.rti_application_number <> ''"
	    	        + ") AS decimal) "
	    	        + "/ NULLIF( COUNT(*) FILTER ("
	    	        + "WHERE r.workflow_status IN (0,1,2,3,5,9,10,11) "
	    	        + "AND r.rti_application_number IS NOT NULL "
	    	        + "AND r.rti_application_number <> ''"
	    	        + "), 0) ) * 100, 2) AS completion_percentage \n"

	    	        + "FROM egovrti.rti_application r \n"
	    	        + "WHERE DATE_TRUNC('day', "
	    	        + "CAST(COALESCE( "
	    	        + "TO_TIMESTAMP(NULLIF(r.created_date,''), 'DD/MM/YYYY HH24:MI:SS'), "
	    	        + "TO_TIMESTAMP(NULLIF(r.created_date,''), 'YYYY-MM-DD HH24:MI:SS'), "
	    	        + "TO_TIMESTAMP(NULLIF(r.created_date,''), 'DD-MON-YYYY HH24:MI:SS'), "
	    	        + "TO_TIMESTAMP(NULLIF(r.created_date,''), 'DD/MM/YYYY') "
	    	        + ") AS DATE) ) "
	    	        + "BETWEEN TO_DATE(:startDate, 'DD/MM/YYYY') "
	    	        + "AND TO_DATE(:endDate, 'DD/MM/YYYY')";

	    	Object[] result = (Object[]) getSession()
	                .createSQLQuery(sql)
	                .setParameter("startDate", startDateStr)
	                .setParameter("endDate", endDateStr)
	                .uniqueResult();

	        DashboardStatsDTO dto = new DashboardStatsDTO();

	        dto.setTotalApplications(((Number) result[0]).intValue());
	        dto.setTotalCost(((Number) result[1]).doubleValue());
	        dto.setCompletedApplications(((Number) result[2]).intValue());
	        dto.setCompletionPercentage(((Number) result[3]).doubleValue());

	        return dto;
	    } catch (Exception exception) {
	        log.error("Error in getDashboardStats()", exception);
	        exception.printStackTrace();
	    }
	    return null;
	}

	@Override
	public List<DashboardStatsDetailsDTO> getRTSDashboardDetailsServiceWise(String startDateStr, String endDateStr) {

	    List<DashboardStatsDetailsDTO> list = new ArrayList<>();

	    try {

	    	String sql =
	    			"SELECT " +
	    			" r.department, " +
	    			" r.rti_service_id, " +

	    			" COUNT(*) FILTER (WHERE r.workflow_status IN (0,1,2,3,5,9,10,11) " +
	    			" AND r.rti_application_number IS NOT NULL AND r.rti_application_number <> '') AS received, " +
	    			
					" COUNT(*) FILTER (WHERE r.workflow_status IN (0,9,10,11) " +
					" AND r.rti_application_number IS NOT NULL AND r.rti_application_number <> '') AS in_progress, " +


	    			" COUNT(*) FILTER (WHERE r.workflow_status = 3 " +
	    			" AND r.rti_application_number IS NOT NULL AND r.rti_application_number <> '') AS payment_pending, " +

	    			" COUNT(*) FILTER (WHERE r.workflow_status = 2 " +
	    			" AND r.rti_application_number IS NOT NULL AND r.rti_application_number <> '') AS payment_completed, " +

	    			" COUNT(*) FILTER (WHERE r.workflow_status = 1 " +
	    			" AND r.rti_application_number IS NOT NULL AND r.rti_application_number <> '') AS completed, " +

	    			" COUNT(*) FILTER (WHERE r.workflow_status = 5 " +
	    			" AND r.rti_application_number IS NOT NULL AND r.rti_application_number <> '') AS rejected " +

	    			"FROM egovrti.rti_application r " +

	    			"WHERE DATE_TRUNC('day', CAST(COALESCE( " +
	    			" TO_TIMESTAMP(NULLIF(r.created_date,''), 'DD/MM/YYYY HH24:MI:SS'), " +
	    			" TO_TIMESTAMP(NULLIF(r.created_date,''), 'YYYY-MM-DD HH24:MI:SS'), " +
	    			" TO_TIMESTAMP(NULLIF(r.created_date,''), 'DD-MON-YYYY HH24:MI:SS'), " +
	    			" TO_TIMESTAMP(NULLIF(r.created_date,''), 'DD/MM/YYYY') " +
	    			") AS DATE)) " +
	    			" BETWEEN TO_DATE(:startDate, 'DD/MM/YYYY') AND TO_DATE(:endDate, 'DD/MM/YYYY') " +

	    			"GROUP BY r.department, r.rti_service_id " +
	    			"ORDER BY r.department, r.rti_service_id";

	        List<Object[]> results = getSession()
	                .createSQLQuery(sql)
	                .setParameter("startDate", startDateStr)
	                .setParameter("endDate", endDateStr)
	                .list();

	        for (Object[] row : results) {

	            DashboardStatsDetailsDTO dto = new DashboardStatsDetailsDTO();

	            dto.setDepartment(row[0] != null ? row[0].toString() : "");
	            dto.setServiceId(row[1] != null ? ((Number) row[1]).intValue() : 0);

	            dto.setServiceName(getServiceName(dto.getServiceId()));

	            dto.setApplicationsReceived(((Number) row[2]).intValue());
	            dto.setApplicationsInProgress(((Number) row[3]).intValue());
	            dto.setApplicationsPendingForPayment(((Number) row[4]).intValue());
	            dto.setApplicationsPaymentCompleted(((Number) row[5]).intValue());
	            dto.setApplicationsCompleted(((Number) row[6]).intValue());
	            dto.setApplicationsRejected(((Number) row[7]).intValue());


	            list.add(dto);
	        }

	    } catch (Exception e) {
	        log.error("Error in getRTSDashboardDetailsServiceWise()", e);
	        e.printStackTrace();
	    }

	    return list;
	}

	private String getServiceName(long serviceId) {

	    switch ((int) serviceId) {

	        // HEALTH-DEPARTMENT
	        case 1:  return "Birth Certificate";
	        case 2:  return "Death Certificate";
	        case 11: return "Marriage Certificate";
	        case 94: return "Nursing Home Registration";
	        case 95: return "Renewal of Nursing Home Registration";
	        case 96: return "Change In No. Of Beds / Usage";
	        case 97: return "MTP Registration Certificate";
	        case 101:return "Bio Medical Waste Disposal";

	        // SOLIDWASTE-DEPARTMENT
	        case 3:  return "Dog License";
	        case 102:return "Dog License Renewal";

	        // TAX-DEPARTMENT
	        case 55: return "Property Tax Utara";
	        case 54: return "Property Tax No Due Certificate";
	        case 104:return "Property Transfer Registration Certificate";
	        case 103:return "New Assessment of Tax / Mutation";
	        case 58: return "Property Tax Re-Assessment";
	        case 72: return "Property Tax Demand";
	        case 71: return "Property Tax Exemption";

	        // TOWN-PLANNING-DEPARTMENT
	        case 5:  return "Zone Certificate";
	        case 28: return "Part Map Certificate";

	        // WATER-DEPARTMENT
	        case 48: return "New Water Connection";
	        case 6:  return "Permanent Disconnection";
	        case 49: return "Change Of Ownership";
	        case 47: return "Change Of Tap Size";
	        case 50: return "Water Reconnection";
	        case 51: return "Change Of Category";
	        case 68: return "Water Connection No Dues";

	        // FIRE-DEPARTMENT
	        case 93: return "Temporary Fireworks License NOC";

	        // ESTATE-DEPARTMENT
	        case 23: return "Mandap Certificate";
	        case 90: return "Ganesh Mandap Permission";
	        case 91: return "Durga Utsav / Garba Mandap Permission";
	        case 92: return "Diksha Bhumi Mandap Permission";

	        // MARKET-DEPARTMENT
	        case 32: return "NOC For Business / Trade / Godown";
	        case 41: return "Trade License Duplication";
	        case 33: return "Trade License Renewal";
	        case 38: return "Trade License Transfer";
	        case 44: return "Trade License New";
	        case 34: return "Trade License Name Change";
	        case 35: return "Trade License Type Change";
	        case 36: return "Trade License Owner / Partner Change";
	        case 39: return "License Partner Count Update";
	        case 42: return "Trade License Outdated Renewal Notice";
	        case 40: return "Trade License Cancellation";

	        // GARDEN-DEPARTMENT
	        case 73: return "Tree Cutting";
	        case 75: return "Tree Trimming";

	        default: return "Unknown Service";
	    }
	}


}
