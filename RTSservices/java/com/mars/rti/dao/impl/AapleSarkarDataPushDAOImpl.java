package com.mars.rti.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.AapleSarkarDataPushDAO;
import com.mars.rti.ws.model.PushDepartmentDTO;

@Repository("aapleSarkarDataPushDAO")
public class AapleSarkarDataPushDAOImpl extends HibernateDaoSupport implements AapleSarkarDataPushDAO{

	private static final Log log = LogFactory.getLog(AapleSarkarDataPushDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@SuppressWarnings("unchecked")
	public List<PushDepartmentDTO> getPushDepartmentData() {
//
//	    String sql =
//	        "SELECT " +
//	        " s.department_name AS department_name, " +
//	        " s.aaplesarkar_service_id AS service_id, " +
//
//	        " COUNT(CASE WHEN a.workflow_status = 1 THEN 1 END) AS approved, " +
//	        " COUNT(CASE WHEN a.workflow_status IN (0,2,3,4,9,10,11) THEN 1 END) AS pending, " +
//	        " COUNT(CASE WHEN a.workflow_status = 5 THEN 1 END) AS rejected " +
//
//	        "FROM egovrti.rti_application a " +
//	        "JOIN egovrti.rts_aaplesarkar_services s " +
//	        "  ON a.aaple_service_id = s.aaplesarkar_service_id " +
//	        "WHERE a.isaplesarkarapp = 1 " +
//	        "GROUP BY s.department_name, s.aaplesarkar_service_id " +
//	        "ORDER BY s.department_name, s.aaplesarkar_service_id";
		
		String sql =
			    "SELECT " +
//			    " s.department_name, " +
//			    " s.aaplesarkar_service_id, " +
			    "s.department_name AS department_name,"+
			    "s.aaplesarkar_service_id AS service_id,"+

			    " COUNT(CASE WHEN a.workflow_status = 1 THEN 1 END) approved, " +

			    " COUNT(CASE WHEN a.workflow_status IN (0,2,3,4,9,10,11) THEN 1 END) pending, " +

			    " COUNT(CASE WHEN a.workflow_status = 5 THEN 1 END) rejected, " +

			    " COUNT(CASE " +
			    "       WHEN a.workflow_status IN (0,2,3,4,9,10,11) " +
			    "        AND CURRENT_DATE <= " +
			    "            (CAST(a.created_date AS DATE) + CAST(s.sla_period AS INTEGER)) " +
			    "       THEN 1 END) pending_within_sla, " +

			    " COUNT(CASE " +
			    "       WHEN a.workflow_status IN (0,2,3,4,9,10,11) " +
			    "        AND CURRENT_DATE > " +
			    "            (CAST(a.created_date AS DATE) + CAST(s.sla_period AS INTEGER)) " +
			    "       THEN 1 END) pending_after_sla, " +

			    " COUNT(CASE " +
			    "       WHEN a.workflow_status = 1 " +
			    "        AND jt.end_ IS NOT NULL " +
			    "        AND jt.end_::DATE <= " +
			    "            (CAST(a.created_date AS DATE) + CAST(s.sla_period AS INTEGER)) " +
			    "       THEN 1 END) on_time_delivery, " +

			    " COUNT(CASE " +
			    "       WHEN a.workflow_status = 1 " +
			    "        AND jt.end_ IS NOT NULL " +
			    "        AND jt.end_::DATE > " +
			    "            (CAST(a.created_date AS DATE) + CAST(s.sla_period AS INTEGER)) " +
			    "       THEN 1 END) not_on_time_delivery " +

			    "FROM egovrti.rti_application a " +

			    "JOIN egovrti.rts_aaplesarkar_services s " +
			    "  ON a.aaple_service_id = s.aaplesarkar_service_id " +

			    "LEFT JOIN egovrti.workflow_process_details wpd " +
			    "  ON wpd.entity_id = a.rti_application_id " +

			    "LEFT JOIN ( " +
			    "     SELECT execution_, MAX(end_) end_ " +
			    "     FROM egovrti.jbpm4_hist_task " +
			    "     GROUP BY execution_ " +
			    ") jt " +
			    "  ON jt.execution_ = wpd.process_id " +

			    "WHERE a.isaplesarkarapp = 1 " +

			    "GROUP BY s.department_name, s.aaplesarkar_service_id " +

			    "ORDER BY s.department_name, s.aaplesarkar_service_id";

	    SQLQuery query = getSession().createSQLQuery(sql);

	    query.addScalar("department_name", Hibernate.STRING);
	    query.addScalar("service_id", Hibernate.INTEGER);
	    query.addScalar("approved", Hibernate.INTEGER);
	    query.addScalar("pending", Hibernate.INTEGER);
	    query.addScalar("rejected", Hibernate.INTEGER);
	    query.addScalar("pending_within_sla", Hibernate.INTEGER);
	    query.addScalar("pending_after_sla", Hibernate.INTEGER);
	    query.addScalar("on_time_delivery", Hibernate.INTEGER);
	    query.addScalar("not_on_time_delivery", Hibernate.INTEGER);

	    List<Object[]> rows = query.list();

	    List<PushDepartmentDTO> result = new ArrayList<PushDepartmentDTO>();

	    for (Object[] row : rows) {

	        PushDepartmentDTO dto = new PushDepartmentDTO();

	        dto.setDepartment("NGMCN");
	        dto.setService((Integer) row[1]);
	        //new
	        dto.setApproved(
	        	    row[2] == null ? 0 : ((Number) row[2]).intValue());

	        	dto.setPendingAtUser(
	        	    row[3] == null ? 0 : ((Number) row[3]).intValue());

	        	dto.setRejected(
	        	    row[4] == null ? 0 : ((Number) row[4]).intValue());

	        	dto.setPendingatDepartmentWithinSLA(
	        	    row[5] == null ? 0 : ((Number) row[5]).intValue());

	        	dto.setPendingatDepartmentAfterSLA(
	        	    row[6] == null ? 0 : ((Number) row[6]).intValue());

	        	dto.setOnTimeDelivery(
	        	    row[7] == null ? 0 : ((Number) row[7]).intValue());

	        	dto.setNotOnTimeDelivery(
	        	    row[8] == null ? 0 : ((Number) row[8]).intValue());

	        //old
//	        dto.setApproved((Integer) row[2]);
//	        dto.setPendingAtUser((Integer) row[3]);
//	    //    dto.setPendingAtDepartment((Integer) row[3]);
//	        dto.setRejected((Integer) row[4]);
//
//	       dto.setPendingatDepartmentWithinSLA();// application count whose sla period(egovrti.rts_aaplesarkar_services.sla_period(in days) not yet completed since application submitted(egovrti.rti_application.created_date) date and application not yet completed/pending to complete
//	       dto.setPendingatDepartmentAfterSLA();// application count whose sla period(egovrti.rts_aaplesarkar_services.sla_period(in days) completed since application submitted(egovrti.rti_application.created_date) date and application not yet completed/pending to complete
//
//	        dto.setOnTimeDelivery();    // applications count which arre completed within sla period(egovrti.rts_aaplesarkar_services.sla_period (in days)) 
//	        dto.setNotOnTimeDelivery(14); // applications count which arre completed after sla period (egovrti.rts_aaplesarkar_services.sla_period(in days)
//	       

	        result.add(dto);
	    }

	    return result;
	}
}
