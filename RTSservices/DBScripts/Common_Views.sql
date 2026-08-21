CREATE OR REPLACE VIEW "nmmccommon"."department_view" (
    department_id,
    department_name,
    department_name_mar,
    status)
AS
SELECT department_master.department_id, department_master.department_name,
    department_master.department_name_mar, 
    CASE WHEN department_master."VALID" = 'Y' THEN 1 ELSE 0 END AS status
FROM nmmcpis.department_master
ORDER BY department_master.department_id;
 
CREATE OR REPLACE VIEW "nmmccommon"."designation_view" (
    designation_id,
    designation_name,
    designation_name_mar,
    hierarchy_no,
    cadre_id,
    group_id,
    status,
    promotion_opportunity,
    payband_id,
    grade_pay)
AS
SELECT designation_master.designation_id, designation_master.designation_name,
    designation_master.designation_name_mar, designation_master.hierarchy_no,
    designation_master.cadre_id, designation_master.group_id,
    CASE WHEN designation_master."VALID" = 'Y' THEN 1 ELSE 0 END AS status,
    designation_master.promotion_opportunity, designation_master.payband_id,
    designation_master.grade_pay
FROM nmmcpis.designation_master
ORDER BY designation_master.designation_id;


CREATE OR REPLACE VIEW nmmccommon.ddo_location AS
select ddo_location_id,ddo_id,location_id from nmmcpis.ddo_location;

CREATE OR REPLACE VIEW nmmccommon.ddo_master AS
select ddo_id as ddo_mast_no,ddo_name as department,department_id as department_id,sub_department_id,"VALID",hod,ddo_name_mar,
calendar_type,branch_code as book_code
from nmmcpis.ddo_master;

CREATE OR REPLACE VIEW nmmccommon.department_master_pis AS
select department_id as department_mast_no,department_name as department,department_name_mar,"VALID" from nmmcpis.department_master;

CREATE OR REPLACE VIEW nmmccommon.location_master AS
select location_id,location_name,location_name_mar,address1,address2,address3,city_id,pin,phone,fax,"VALID" from nmmcpis.location_master;

CREATE OR REPLACE VIEW nmmccommon.pis_designation_master AS
select designation_id,designation_name as designation from nmmcpis.designation_master;

CREATE OR REPLACE VIEW nmmccommon.pis_post_master AS
select post_id,creation_id,post_title,post_title_mar,location_id,address,phone,extension,e_mail,
reporting_to,reporting_to_cr,reviewed_by_cr,leave_recommended_by,leave_approved_by,remarks,"VALID" from nmmcpis.post_master;


CREATE OR REPLACE VIEW nmmccommon.post_creation_master AS
select creation_id,ddo_id,designation_id,post_type,sanctioned_post,sanction_date,circualar_no,start_date,end_date,bill_no,
post_nominated,post_general,post_sc,post_st,post_obc,post_other from nmmcpis.post_creation_master;


CREATE OR REPLACE VIEW nmmccommon.post_transaction AS
select post_transaction_id,post_id,employee_id,transaction_no,from_date,to_date,method_id,reference_no from nmmcpis.post_transaction;

CREATE OR REPLACE VIEW nmmccommon.employee_master AS
select employee_id,employee_id_old,title_id,first_name,first_name_mar,middle_name,middle_name_mar,last_name,last_name_mar,full_name,full_name_mar from nmmcpis.employee_master;



CREATE OR REPLACE VIEW nmmccommon.v_department_master AS 
 SELECT ddo_master.ddo_mast_no AS department_mast_no, ddo_master.department, ddo_master.department_id, ddo_master.sub_department_id, ddo_master.hod
   FROM nmmccommon.ddo_master;


CREATE OR REPLACE VIEW nmmccommon.warehouse_master AS 
 SELECT location_master.location_id AS warehouse_mast_no, location_master.location_name AS warehouse_name, 0 AS geo_id, (COALESCE(location_master.address1, ''::character varying)::text || COALESCE(location_master.address2, ''::character varying)::text) || COALESCE(location_master.address3, ''::character varying)::text AS warehouse_address, location_master.phone AS telephone_number, location_master.fax AS fax_no
   FROM nmmccommon.location_master;


CREATE OR REPLACE VIEW nmmccommon.v_warehouse_department AS 
 SELECT a.ddo_id AS department_mast_no, c.department, a.location_id AS warehouse_mast_no, b.warehouse_name, b.geo_id, b.warehouse_address, b.telephone_number, b.fax_no, a.ddo_location_id
   FROM nmmccommon.ddo_location a, nmmccommon.warehouse_master b, nmmccommon.v_department_master c
  WHERE a.location_id = b.warehouse_mast_no AND a.ddo_id = c.department_mast_no;


CREATE OR REPLACE VIEW nmmccommon.v_post_department AS 
 SELECT a.department, a.department_mast_no, b.department AS sub_department, d.post_title, d.post_id AS post_mast_no, f.employee_id, (((COALESCE(f.first_name, ''::character varying)::text || ' '::text) || COALESCE(f.middle_name, ''::character varying)::text) || ''::text) || COALESCE(f.last_name, ''::character varying)::text AS employee_name
   FROM nmmccommon.department_master_pis a, nmmccommon.v_department_master b, nmmccommon.post_creation_master c, nmmccommon.pis_post_master d, nmmccommon.post_transaction e, nmmccommon.employee_master f
  WHERE a.department_mast_no = b.department_id AND b.department_mast_no = c.ddo_id AND c.creation_id = d.creation_id AND d.post_id = e.post_id AND e.employee_id = f.employee_id;

CREATE OR REPLACE VIEW nmmccommon.v_post_transaction AS 
 SELECT post_transaction.post_transaction_id, post_transaction.post_id, post_transaction.employee_id, post_transaction.transaction_no, post_transaction.from_date, COALESCE(post_transaction.to_date, 'now'::text::timestamp without time zone) AS to_date, post_transaction.method_id, post_transaction.reference_no
   FROM nmmccommon.post_transaction;