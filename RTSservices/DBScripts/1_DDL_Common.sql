-- DDL Re-generated on JUly 21 2011

/*
alter table BANK_BRANCH drop constraint FK1C1FDD059DC9B4D6;
alter table BANK_BRANCH drop constraint FK1C1FDD05E0B23276;
alter table CITY drop constraint FK1F916BAE902C21;
alter table CITY drop constraint FK1F916B859F9BD6;
alter table DISTRICT drop constraint FK3FDF238ED9C1B2FE;
alter table NODE_MASTER drop constraint FK4AC70F3FF4EB4CD6;
alter table PLOT drop constraint FK2584E1B1D27596;
alter table PLOT drop constraint FK2584E114E8E939;
alter table SECTOR drop constraint FK918E4B662F017F18;
alter table TALUKA drop constraint FK930EE08C4B5C2D96;
alter table WARD drop constraint FK288A7CE0B23276;
alter table WARD_SECTOR drop constraint FKE9183A89B1D27596;
alter table WARD_SECTOR drop constraint FKE9183A89F4EB4CD6;

drop table BANK;
drop table BANK_BRANCH;
drop table CITY;
drop table CITY_CATEGORY;
drop table DISTRICT;
drop table NODE_MASTER;
drop table PLOT;
drop table PLOT_TYPE;
drop table SECTOR;
drop table STATE;
drop table TALUKA;
drop table WARD;
drop table WARD_SECTOR;


drop sequence BANK_BRANCH_SEQ;
drop sequence BANK_SEQ;
drop sequence CITY_CATEGORY_SEQ;
drop sequence CITY_SEQ;
drop sequence DISTRICT_SEQ;
drop sequence NODE_MASTER_SEQ;
drop sequence PLOT_SEQ;
drop sequence PLOT_TYPE_SEQ;
drop sequence SECTOR_SEQ;
drop sequence STATE_SEQ;
drop sequence TALUKA_SEQ;
drop sequence WARD_SECTOR_SEQ;
drop sequence WARD_SEQ;
*/

create table BANK (BANK_ID int8 not null, BANK_NAME varchar(100) not null, STATUS int4, BANK_NAME_MR varchar(50), WEBSITE varchar(50), primary key (BANK_ID));
create table BANK_BRANCH (BANK_BRANCH_ID int8 not null, BRANCH_NAME varchar(100) not null, BRANCH_CODE varchar(10), STATUS int4, BANK_ID int8 not null, CITY_ID int8, BRANCH_NAME_MAR varchar(50), ADDRESS1 varchar(50), ADDRESS2 varchar(50), ADDRESS3 varchar(50), PIN varchar(6), PHONE varchar(50), FAX varchar(50), E_MAIL varchar(50), CONTACT_PERSON varchar(50), primary key (BANK_BRANCH_ID));
create table CITY (CITY_ID int8 not null, NAME varchar(45) not null, CODE varchar(10) not null, STATUS int4, TALUKA_ID int8, NAME_MR varchar(45), CODE_MR varchar(10), IS_TRIBAL int4, IS_HILL int4, IS_REMOTE int4, IS_BORDER int4, IS_ISLAND int4, IS_BADCLIMATE int4, CATEGORY_ID int8, primary key (CITY_ID));
create table CITY_CATEGORY (CATEGORY_ID int8 not null, NAME varchar(10), NAME_MAR varchar(10), "VALID" varchar(1), primary key (CATEGORY_ID));
create table DISTRICT (DISTRICT_ID int8 not null, NAME varchar(45) not null, CODE varchar(2) not null, STATUS int4, STATE_ID int8 not null, NAME_MR varchar(45), CODE_MR varchar(2), primary key (DISTRICT_ID));
create table NODE_MASTER (NODE_MASTER_ID int8 not null, NAME varchar(50) not null, CODE varchar(10) not null, STATUS int4, WARD_ID int8 not null, NAME_MR varchar(50), CODE_MR varchar(10), primary key (NODE_MASTER_ID));
create table PLOT (PLOT_ID int8 not null, PLOT_NUMBER varchar(100), STATUS int4, PLOT_TYPE_ID int8, SECTOR_ID int8, primary key (PLOT_ID));
create table PLOT_TYPE (PLOT_TYPE_ID int8 not null, DESCRIPTION varchar(50) not null, STATUS int4, primary key (PLOT_TYPE_ID));
create table SECTOR (SECTOR_ID int8 not null, NAME varchar(50) not null, STATUS int4, NODE_ID int8 not null, NAME_MR varchar(50), primary key (SECTOR_ID));
create table STATE (STATE_ID int8 not null, NAME varchar(45) not null, CODE varchar(2) not null, STATUS int4, NAME_MR varchar(45), CODE_MR varchar(10), REGION int4, primary key (STATE_ID));
create table TALUKA (TALUKA_ID int8 not null, NAME varchar(45) not null, CODE varchar(4) not null, STATUS int4, DISTRICT_ID int8 not null, NAME_MR varchar(45), CODE_MR varchar(4), primary key (TALUKA_ID));
create table WARD (WARD_ID int8 not null, NAME varchar(50) not null, CODE varchar(10) not null, ADDRESSLINE1 varchar(100), ADDRESSLINE2 varchar(100), ADDRESSLINE3 varchar(100), STATUS int4, CITY_ID int8 not null, NAME_MR varchar(50), CODE_MR varchar(10), primary key (WARD_ID));
create table WARD_SECTOR (WARD_SECTOR_ID int8 not null, WARD_ID int8 not null, SECTOR_ID int8, primary key (WARD_SECTOR_ID));

alter table BANK_BRANCH add constraint FK1C1FDD059DC9B4D6 foreign key (BANK_ID) references BANK;
alter table BANK_BRANCH add constraint FK1C1FDD05E0B23276 foreign key (CITY_ID) references CITY;
alter table CITY add constraint FK1F916BAE902C21 foreign key (CATEGORY_ID) references CITY_CATEGORY;
alter table CITY add constraint FK1F916B859F9BD6 foreign key (TALUKA_ID) references TALUKA;
alter table DISTRICT add constraint FK3FDF238ED9C1B2FE foreign key (STATE_ID) references STATE;
alter table NODE_MASTER add constraint FK4AC70F3FF4EB4CD6 foreign key (WARD_ID) references WARD;
alter table PLOT add constraint FK2584E1B1D27596 foreign key (SECTOR_ID) references SECTOR;
alter table PLOT add constraint FK2584E114E8E939 foreign key (PLOT_TYPE_ID) references PLOT_TYPE;
alter table SECTOR add constraint FK918E4B662F017F18 foreign key (NODE_ID) references NODE_MASTER;
alter table TALUKA add constraint FK930EE08C4B5C2D96 foreign key (DISTRICT_ID) references DISTRICT;
alter table WARD add constraint FK288A7CE0B23276 foreign key (CITY_ID) references CITY;
alter table WARD_SECTOR add constraint FKE9183A89B1D27596 foreign key (SECTOR_ID) references SECTOR;
alter table WARD_SECTOR add constraint FKE9183A89F4EB4CD6 foreign key (WARD_ID) references WARD;

create sequence BANK_BRANCH_SEQ;
create sequence BANK_SEQ;
create sequence CITY_CATEGORY_SEQ;
create sequence CITY_SEQ;
create sequence DISTRICT_SEQ;
create sequence NODE_MASTER_SEQ;
create sequence PLOT_SEQ;
create sequence PLOT_TYPE_SEQ;
create sequence SECTOR_SEQ;
create sequence STATE_SEQ;
create sequence TALUKA_SEQ;
create sequence WARD_SECTOR_SEQ;
create sequence WARD_SEQ;


ALTER TABLE state ADD COLUMN region integer;

ALTER TABLE city  ADD COLUMN is_tribal integer DEFAULT 0;
ALTER TABLE city  ADD COLUMN is_hill integer DEFAULT 0;
ALTER TABLE city  ADD COLUMN is_remote integer DEFAULT 0;
ALTER TABLE city  ADD COLUMN is_border integer DEFAULT 0;
ALTER TABLE city  ADD COLUMN is_island integer DEFAULT 0;
ALTER TABLE city  ADD COLUMN is_badclimate integer DEFAULT 0;
ALTER TABLE city  ADD COLUMN category_id integer DEFAULT 0;

CREATE TABLE city_category
(
  category_id smallint NOT NULL,
  "name" character varying(10),
  name_mar character varying(10),
  "VALID" character(1),
  CONSTRAINT city_category_pkey PRIMARY KEY (category_id)
);

create sequence city_category_seq;

delete from city_category;
INSERT INTO city_category(
            category_id, "name", name_mar, "VALID")
    VALUES
	(1,'A1','v','1'),
	(2,'A','v','1'),
	(3,'B1','C','1'),
	(4,'B2','C','1'),
	(5,'C','d','1'),
	(6,'T','T','1');

	
-- Audit Trail and Dictiionary Related Tables

create table AUDIT_TRAIL (AUDIT_TRAIL_ID int8 not null, ENTITY_ID varchar(50) not null, ENTITY_NAME varchar(50) not null, ENTITY_PROPERTY varchar(100) not null, ENTITY_PROPERTY_OLD_VALUE varchar(4000) not null, ENTITY_PROPERTY_NEW_VALUE varchar(4000) not null, OPERATION_TYPE varchar(50) not null, ACTOR_NAME varchar(100) not null, TRANSACTION_DATE varchar(10) not null, TRANSACTION_TIME varchar(8) not null, primary key (AUDIT_TRAIL_ID));
create sequence AUDIT_TRAIL_SEQ;

create table DICTIONARY (DICTIONARY_ID int8 not null, KEY varchar(255) not null, VALUE varchar(255) not null, primary key (DICTIONARY_ID));
create sequence DICTIONARY_SEQ;

-- User Admin related Tables

create sequence DESIGNATION_SEQ;
create sequence DEPARTMENT_SEQ;
create sequence EMPLOYEE_SEQ;
create sequence PERMISSION_GROUP_SEQ;
create sequence PERMISSION_SEQ;
create sequence ROLE_SEQ;
create sequence ROLE_PERMISSION_SEQ;
create sequence USER_SEQ;
create sequence USER_ROLE_SEQ;
create sequence SALUTATION_SEQ;


create table DESIGNATION (DESIGNATION_ID int8 not null, NAME varchar(50) not null, DESCRIPTION varchar(200), STATUS int4, primary key (DESIGNATION_ID));
create table DEPARTMENT (DEPARTMENT_ID int8 not null, NAME varchar(50) not null, DESCRIPTION varchar(200), STATUS int4, primary key (DEPARTMENT_ID));
create table EMPLOYEE (EMPLOYEE_ID int8 not null, FIRST_NAME varchar(25) not null, MIDDLE_NAME varchar(25), LAST_NAME varchar(25), STATUS int4, DESIGNATION_ID int8 not null, DEPARTMENT_ID int8 not null, SUPERIOR_ID int8, primary key (EMPLOYEE_ID));
create table PERMISSIONS (PERMISSION_ID int8 not null, LINK_NAME varchar(255) not null, LINK_URL varchar(255) not null, PERMISSION_GROUP_ID int8 not null, primary key (PERMISSION_ID));
create table PERMISSION_GROUP (PERMISSION_GROUP_ID int8 not null, NAME varchar(255), primary key (PERMISSION_GROUP_ID));
create table ROLE (ROLE_ID int8 not null, ROLE_NAME varchar(50) not null, primary key (ROLE_ID));
create table ROLE_PERMISSION (ROLE_PERMISSION int8 not null, ROLE_ID int8 not null, PERMISSION_ID int8 not null, primary key (ROLE_PERMISSION));
create table USERS (USER_ID int8 not null, USER_NAME varchar(255) not null, PASSWORD varchar(255) not null, EMPLOYEE_ID int8 not null, primary key (USER_ID));
create table USER_ROLE (USER_ROLE_ID int8 not null, USER_ROLE_ST_DATE varchar(10), USER_ROLE_END_DATE varchar(10), IS_DEFAULT int4, USER_ID int8 not null, ROLE_ID int8 not null, primary key (USER_ROLE_ID));
create table SALUTATION (SALUTATION_ID int8 not null, SALUTATION_NAME varchar(5) not null, STATUS int4, primary key (SALUTATION_ID));

alter table EMPLOYEE add constraint FK75C8D6AEDFDDB016 foreign key (DEPARTMENT_ID) references DEPARTMENT;
alter table EMPLOYEE add constraint FK75C8D6AEBE8A763E foreign key (DESIGNATION_ID) references DESIGNATION;
alter table EMPLOYEE add constraint FK75C8D6AEDBC6EAB3 foreign key (SUPERIOR_ID) references EMPLOYEE;
alter table ROLE_PERMISSION add constraint FK9C6EC938FFCF42F6 foreign key (PERMISSION_ID) references PERMISSIONS;
alter table ROLE_PERMISSION add constraint FK9C6EC9383F9D296 foreign key (ROLE_ID) references ROLE;
alter table USERS add constraint FK4D495E86829D996 foreign key (EMPLOYEE_ID) references EMPLOYEE;
alter table USER_ROLE add constraint FKBC16F46AA9249676 foreign key (USER_ID) references USERS;
alter table USER_ROLE add constraint FKBC16F46A3F9D296 foreign key (ROLE_ID) references ROLE;
alter table PERMISSIONS add constraint FKC3E6886436450F1F foreign key (PERMISSION_GROUP_ID) references PERMISSION_GROUP;

ALTER TABLE "employee" ADD COLUMN "email" VARCHAR(50);
UPDATE employee set email='ramesh.badam@mars-india.com';
ALTER TABLE "employee" ALTER COLUMN "email" SET NOT NULL;

-- Creating public Synonyms

DROP PUBLIC SYNONYM BANK_BRANCH_SEQ;
DROP PUBLIC SYNONYM BANK_SEQ;
DROP PUBLIC SYNONYM CITY_CATEGORY_SEQ;
DROP PUBLIC SYNONYM CITY_SEQ;
DROP PUBLIC SYNONYM DISTRICT_SEQ;
DROP PUBLIC SYNONYM NODE_MASTER_SEQ;
DROP PUBLIC SYNONYM PLOT_SEQ;
DROP PUBLIC SYNONYM PLOT_TYPE_SEQ;
DROP PUBLIC SYNONYM SECTOR_SEQ;
DROP PUBLIC SYNONYM STATE_SEQ;
DROP PUBLIC SYNONYM TALUKA_SEQ;
DROP PUBLIC SYNONYM WARD_SECTOR_SEQ;
DROP PUBLIC SYNONYM WARD_SEQ;

DROP PUBLIC SYNONYM BANK;
DROP PUBLIC SYNONYM BANK_BRANCH;
DROP PUBLIC SYNONYM CITY;
DROP PUBLIC SYNONYM CITY_CATEGORY;
DROP PUBLIC SYNONYM DISTRICT;
DROP PUBLIC SYNONYM NODE_MASTER;
DROP PUBLIC SYNONYM PLOT;
DROP PUBLIC SYNONYM PLOT_TYPE;
DROP PUBLIC SYNONYM SECTOR;
DROP PUBLIC SYNONYM STATE;
DROP PUBLIC SYNONYM TALUKA;
DROP PUBLIC SYNONYM WARD;
DROP PUBLIC SYNONYM WARD_SECTOR;


CREATE OR REPLACE PUBLIC SYNONYM BANK_BRANCH_SEQ FOR  nmmccommon.BANK_BRANCH_SEQ;
CREATE OR REPLACE PUBLIC SYNONYM BANK_SEQ FOR  nmmccommon.BANK_SEQ;
CREATE OR REPLACE PUBLIC SYNONYM CITY_CATEGORY_SEQ FOR  nmmccommon.CITY_CATEGORY_SEQ;
CREATE OR REPLACE PUBLIC SYNONYM CITY_SEQ FOR  nmmccommon.CITY_SEQ;
CREATE OR REPLACE PUBLIC SYNONYM DISTRICT_SEQ FOR  nmmccommon.DISTRICT_SEQ;
CREATE OR REPLACE PUBLIC SYNONYM NODE_MASTER_SEQ FOR  nmmccommon.NODE_MASTER_SEQ;
CREATE OR REPLACE PUBLIC SYNONYM PLOT_SEQ FOR  nmmccommon.PLOT_SEQ;
CREATE OR REPLACE PUBLIC SYNONYM PLOT_TYPE_SEQ FOR  nmmccommon.PLOT_TYPE_SEQ;
CREATE OR REPLACE PUBLIC SYNONYM SECTOR_SEQ FOR  nmmccommon.SECTOR_SEQ;
CREATE OR REPLACE PUBLIC SYNONYM STATE_SEQ FOR  nmmccommon.STATE_SEQ;
CREATE OR REPLACE PUBLIC SYNONYM TALUKA_SEQ FOR  nmmccommon.TALUKA_SEQ;
CREATE OR REPLACE PUBLIC SYNONYM WARD_SECTOR_SEQ FOR  nmmccommon.WARD_SECTOR_SEQ;
CREATE OR REPLACE PUBLIC SYNONYM WARD_SEQ FOR  nmmccommon.WARD_SEQ;

CREATE OR REPLACE PUBLIC SYNONYM BANK  FOR nmmccommon.BANK;
CREATE OR REPLACE PUBLIC SYNONYM BANK_BRANCH  FOR nmmccommon.BANK_BRANCH;
CREATE OR REPLACE PUBLIC SYNONYM CITY  FOR nmmccommon.CITY;
CREATE OR REPLACE PUBLIC SYNONYM CITY_CATEGORY  FOR nmmccommon.CITY_CATEGORY;
CREATE OR REPLACE PUBLIC SYNONYM DISTRICT  FOR nmmccommon.DISTRICT;
CREATE OR REPLACE PUBLIC SYNONYM NODE_MASTER  FOR nmmccommon.NODE_MASTER;
CREATE OR REPLACE PUBLIC SYNONYM PLOT  FOR nmmccommon.PLOT;
CREATE OR REPLACE PUBLIC SYNONYM PLOT_TYPE  FOR nmmccommon.PLOT_TYPE;
CREATE OR REPLACE PUBLIC SYNONYM SECTOR  FOR nmmccommon.SECTOR;
CREATE OR REPLACE PUBLIC SYNONYM STATE  FOR nmmccommon.STATE;
CREATE OR REPLACE PUBLIC SYNONYM TALUKA  FOR nmmccommon.TALUKA;
CREATE OR REPLACE PUBLIC SYNONYM WARD  FOR nmmccommon.WARD;
CREATE OR REPLACE PUBLIC SYNONYM WARD_SECTOR  FOR nmmccommon.WARD_SECTOR;

CREATE TABLE books
(
  bookcode bigint,
  "name" character varying(50),
  Bookalpha  character(1)
  );

insert into books values(4070100010000,'Cash In Hand','C');
insert into books values(4070100010001,'Bank Book','B');

CREATE OR REPLACE PUBLIC SYNONYM books FOR  nmmccommon.books;


 CREATE OR REPLACE VIEW nmmccommon.department_view AS  
 SELECT department_master.department_id, department_master.department_name, department_master.department_name_mar, department_master."VALID" as Status
 FROM nmmcpis.department_master
 ORDER BY department_master.department_id;
 
 CREATE OR REPLACE VIEW nmmccommon.designation_view AS 
 SELECT designation_master.designation_id, designation_master.designation_name, designation_master.designation_name_mar, designation_master.hierarchy_no, designation_master.cadre_id, designation_master.group_id, designation_master."VALID" as Status, designation_master.promotion_opportunity, designation_master.payband_id, designation_master.grade_pay
   FROM nmmcpis.designation_master
  ORDER BY designation_master.designation_id;  
  
-- Oct 18 2011

CREATE TABLE nmmccommon."application" (
"application_id" INTEGER NOT NULL,
"name" VARCHAR(50) NOT NULL,
"status" INTEGER,
CONSTRAINT "application_pkey" PRIMARY KEY("application_id")
) WITHOUT OIDS;

ALTER TABLE  nmmccommon."application"  ADD COLUMN "description" VARCHAR(200);
ALTER TABLE  nmmccommon."application"  ADD COLUMN "image_url" VARCHAR(200) ;
ALTER TABLE  nmmccommon."application"  ADD COLUMN "application_url" VARCHAR(200) ;

ALTER TABLE  nmmccommon."application"   ALTER COLUMN "description" SET NOT NULL;
ALTER TABLE  nmmccommon."application"   ALTER COLUMN "image_url" SET NOT NULL;
ALTER TABLE  nmmccommon."application"   ALTER COLUMN "application_url" SET NOT NULL;

CREATE SEQUENCE  nmmccommon."application_seq"
INCREMENT 1 MINVALUE 1
MAXVALUE 9223372036854775807 START 100
CACHE 1;

CREATE OR REPLACE PUBLIC SYNONYM application_SEQ FOR  nmmccommon.application_SEQ;
CREATE OR REPLACE PUBLIC SYNONYM application FOR  nmmccommon.application;

delete from application;
drop SEQUENCE nmmccommon.application_seq;
CREATE SEQUENCE nmmccommon.application_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE OR REPLACE PUBLIC SYNONYM application_SEQ FOR  nmmccommon.application_SEQ;

insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'Grievance Mangement ','Citizens Grievance Management System','Grievance-icon.png','http://172.16.25.204:8080/Grievance/user/listUser.do',1);
insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'Birth & Death Registration','Birth & Death registrations, Certificate request and corerctions. Marriage Registrations and Certificates','BND-icon.png','http://172.16.25.204:8080/BND/user/listUser.do',1);
insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'Property','Property Tax System','Property-icon.png','http://172.16.25.204:8080/Property/user/listUser.do',1);
insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'Water','Water Tax System','Water-icon.png','http://172.16.25.204:8080/Water/user/listUser.do',1);
insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'Trade Licences','Trade License Management ','Licence-icon.png','http://172.16.25.204:8080/License/user/listUser.do',1);
insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'Citizen Fecilitation Cneter(CFC)','One stop Center for all Citizen Services','CFC-icon.png','http://172.16.25.204:8080/CFC/user/listUser.do',1);
insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'Document Management System (DMS)','Stores and Tarcks Electronic Documents','DMS-icon.png','http://172.16.25.204:8080/DMS-Admin/user/listUser.do',1);
insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'Personnel & Payroll Information System (PIS)','Mnages Complete Payroll processing and Employee Management.','PIS-icon.png','http://172.16.25.204:8080/PIS/user/listUser.do',1);
insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'NMMC Portal','Online Portal with all required information and services for citizens','Portal-icon.png','http://172.16.25.204:8080/CFC/user/listUser.do',1);
insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'Cess Management ','Cess Management','Cess-icon.png','http://172.16.25.204:8080/Cess_Web/user/listUser.do',1);
insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'Solid Waste Management(SWM)','Covers all aspects of Solid Waste Management.','SWM-icon.png','http://172.16.25.204:8080/SWm_Web/user/listUser.do',1);
insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'Inventory Management ','Inventory management','Inventory-icon.png','http://172.16.25.204:8080/Inventory_Web/user/listUser.do',1);
insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'Works Management','Works Plannign & Management','Works-icon.png','http://172.16.25.204:8080/Works_Web/user/listUser.do',1);
insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'Financial and Accounting System (FAS)','Financial and Accounting System ','FAS-icon.png','http://172.16.25.204:8080/jFAS/user/listUser.do',1);
insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'Town Planning - Building Plan Approval','Bulding Permisisons and Town Pllaning','TP-icon.png','http://172.16.25.204:8080/TP/user/listUser.do',1);
insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'GIS','Geographical Information System','GIS-icon.png','http://172.16.25.204:8080/GIS/user/listUser.do',1);
insert into application (application_id,name,description,image_url,application_url,status) values(nextval('application_seq'),'Admin','Manges all Common Masters','default-icon.png','http://172.16.25.204:8080/Admin/user/listUser.do',1);

CREATE TABLE "user_application" (
"user_application_id" BIGINT NOT NULL,
"user_id" BIGINT  NOT NULL,
"application_id" BIGINT  NOT NULL,
CONSTRAINT "table1_pkey" PRIMARY KEY("user_application_id"),
CONSTRAINT "user_application_fk" FOREIGN KEY ("application_id")
REFERENCES "application"("application_id")
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE,
CONSTRAINT "user_application_fk1" FOREIGN KEY ("user_id")
REFERENCES "users"("user_id")
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE
) WITHOUT OIDS;

CREATE SEQUENCE "user_application_seq"
INCREMENT 1 MINVALUE 1
MAXVALUE 9223372036854775807 START 1
CACHE 1;

ALTER TABLE "user_application"
  DROP CONSTRAINT "user_application_fk" RESTRICT;

ALTER TABLE "user_application"
  ADD CONSTRAINT "user_application_fk" FOREIGN KEY ("application_id")
    REFERENCES "nmmccommon"."application"("application_id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;
    
ALTER TABLE "users" ADD COLUMN "first_name" VARCHAR(25);
ALTER TABLE "users" ADD COLUMN "last_name" VARCHAR(25);
ALTER TABLE "users" ADD COLUMN "email" VARCHAR(50);

update users u set 
first_name=(select e.first_name from employee e where e.employee_id=u.employee_id)
,last_name=(select e.last_name from employee e where e.employee_id=u.employee_id)
,email=(select e.email from employee e where e.employee_id=u.employee_id);

ALTER TABLE "users"   ADD COLUMN "designation_id" BIGINT;
ALTER TABLE "users"   ADD COLUMN "department_id" BIGINT;

update users u set 
designation_id=(select d.designation_id from employee e, designation d where e.designation_id = d.designation_id and e.employee_id=u.employee_id),
department_id=(select d.department_id from employee e, department d where e.department_id = d.department_id and e.employee_id=u.employee_id);

    
ALTER TABLE "users" DROP COLUMN "employee_id";
ALTER TABLE "users" ADD COLUMN "employee_id" BIGINT;   
update users set employee_id=user_id;
ALTER TABLE "users" ALTER COLUMN "employee_id" SET NOT NULL;
      
delete from user_application;
drop SEQUENCE user_application_seq;
CREATE SEQUENCE user_application_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 1);
INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 2);
INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 3);
INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 4);
INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 5);
INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 6);
INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 7);
INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 8);
INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 9);
INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 10);
INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 11);
INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 12);
INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 13);
INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 14);
INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 15);
INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 16);
INSERT INTO user_application(user_application_id,user_id,application_id) VALUES (nextval('user_application_seq'),1, 17);
	  
  
CREATE OR REPLACE PUBLIC SYNONYM application_SEQ FOR  nmmccommon.application_SEQ;
CREATE OR REPLACE PUBLIC SYNONYM user_seq FOR  nmmccommon.user_seq;
CREATE OR REPLACE PUBLIC SYNONYM user_application_SEQ FOR  nmmccommon.user_application_SEQ;

CREATE OR REPLACE PUBLIC SYNONYM users FOR  nmmccommon.users;
CREATE OR REPLACE PUBLIC SYNONYM application FOR  nmmccommon.application;
CREATE OR REPLACE PUBLIC SYNONYM user_application FOR  nmmccommon.user_application;


CREATE TABLE "nmmccommon"."vendor" (
  "code" BIGINT DEFAULT 0 NOT NULL, 
  "name" VARCHAR(150) NOT NULL, 
  "add1" VARCHAR(100), 
  "add2" VARCHAR(100), 
  "add3" VARCHAR(100), 
  "city" VARCHAR(100), 
  "pincode" INTEGER, 
  "salestaxno" VARCHAR(100), 
  "cstno" VARCHAR(100), 
  "itaxno" VARCHAR(100), 
  "panno" VARCHAR(25), 
  "tanno" VARCHAR(25), 
  "exemptioncertino" VARCHAR(25), 
  "favouring" VARCHAR(100), 
  "bankaccountno" VARCHAR(25), 
  "status" SMALLINT, 
  "alphacode" CHAR(1), 
  "contracode" INTEGER, 
  "shortname" VARCHAR(15), 
  "isentry" CHAR(1), 
  "auto" INTEGER, 
  "branch" INTEGER, 
  "acqrbranch" INTEGER, 
  "entereddate" TIMESTAMP WITHOUT TIME ZONE, 
  "enteredby" VARCHAR(20), 
  "modifieddate" TIMESTAMP WITHOUT TIME ZONE, 
  "modifiedby" VARCHAR(20), 
  "authoriseddate" TIMESTAMP WITHOUT TIME ZONE, 
  "authorisedby" VARCHAR(20), 
  "authostatus" SMALLINT, 
  "customernature" SMALLINT, 
  "micrcitycode" INTEGER, 
  "micrbranchcode" INTEGER, 
  "micrbankcode" INTEGER, 
  "micractype" INTEGER, 
  "micrcode" INTEGER, 
  "creditlimit" INTEGER, 
  "pfno" VARCHAR(25), 
  "contactno" VARCHAR(25), 
  "commencement_date" TIMESTAMP WITHOUT TIME ZONE, 
  "company_registration_date" TIMESTAMP WITHOUT TIME ZONE, 
  "company_registration_no" VARCHAR(100), 
  "web_address" VARCHAR(100), 
  "e_mail" VARCHAR(50), 
  "telephone" VARCHAR(20), 
  "fax" VARCHAR(20), 
  "telephone_alternate" VARCHAR(20), 
  "remarks" VARCHAR(50), 
  "vendor_type" INTEGER NOT NULL, 
  "companyid" SMALLINT DEFAULT 11, 
  CONSTRAINT "vendor_pkey" PRIMARY KEY("code")
) WITHOUT OIDS;

CREATE SEQUENCE "nmmccommon"."vendor_seq"
  INCREMENT 1 MINVALUE 1
  MAXVALUE 9223372036854775807 START 100001
  CACHE 1
  
  /*
 	Vendor Type values
     1. Citizen (FAS will create)
	 2. Employee (PIS will create) (PAN is mandatory)
     3.Department (PIS will create) 
     4.Vendor ( e-Tendering/Works module) (PAN and TIN is mandatory)
     5. company (PAN and TIN is mandatory)
 
   */
  
  -- July 20 2012, For CONFIGURING BRANCH CODE FOR WARD
set search_path To "$user",public,nmmccommon;

ALTER TABLE "nmmccommon"."ward" ADD COLUMN "fas_branch_code" INTEGER;
ALTER TABLE "nmmccommon"."ward" ALTER COLUMN "fas_branch_code" SET DEFAULT 999;

update "nmmccommon"."ward" set fas_branch_code=520 where code='A';
update "nmmccommon"."ward" set fas_branch_code=530 where code='B';
update "nmmccommon"."ward" set fas_branch_code=540 where code='C';
update "nmmccommon"."ward" set fas_branch_code=550 where code='D';
update "nmmccommon"."ward" set fas_branch_code=560 where code='E';
update "nmmccommon"."ward" set fas_branch_code=570 where code='F';
update "nmmccommon"."ward" set fas_branch_code=580 where code='G';
update "nmmccommon"."ward" set fas_branch_code=590 where code='H';
update "nmmccommon"."ward" set fas_branch_code=999 where code='I';