drop sequence designation_seq;
drop sequence department_seq;
drop sequence employee_seq;
drop sequence role_seq;
drop sequence user_seq;
drop sequence user_role_seq;
drop sequence permission_seq;
drop sequence permission_group_seq;
drop sequence role_permission_seq;

delete from role_permission;
delete from permissions;
delete from permission_group;
delete from user_role;
delete from users;
delete from role;
delete from employee;
delete from department;
delete from designation;

create sequence designation_seq;
create sequence department_seq;
create sequence employee_seq;
create sequence role_seq;
create sequence user_seq;
create sequence user_role_seq;
create sequence permission_seq;
create sequence permission_group_seq;
create sequence role_permission_seq;

INSERT INTO designation(designation_id,name,description,status) VALUES ( nextval('designation_seq'),'Admin','Admin', NULL);

INSERT INTO department(department_id,name,description,status) VALUES ( nextval('department_seq'),'Admin Department','Admin Department', NULL);
INSERT INTO department(department_id,name,description,status) VALUES ( nextval('department_seq'),'Birth & Death Department','Birth & Death Department', NULL);
INSERT INTO department(department_id,name,description,status) VALUES ( nextval('department_seq'),'Property Department','Property Department', NULL);
INSERT INTO department(department_id,name,description,status) VALUES ( nextval('department_seq'),'Water Department','Water Department', NULL);
INSERT INTO department(department_id,name,description,status) VALUES ( nextval('department_seq'),'Trade Licenses','Trade Licenses', NULL);
INSERT INTO department(department_id,name,description,status) VALUES ( nextval('department_seq'),'Works Department','Works Department', NULL);
INSERT INTO department(department_id,name,description,status) VALUES ( nextval('department_seq'),'Accounts Deaprtment','Accounts Deaprtment', NULL);

INSERT INTO   employee(  employee_id, first_name,  middle_name,  last_name,  status,  designation_id,  department_id,  superior_id,email) 
VALUES (  nextval('employee_seq'),  'Purva',  '',  'Patil',  NULL,  1,  1,  NULL,'abc@def.com');

Insert into ROLE (ROLE_ID,ROLE_NAME) values (nextval('role_seq'),'Admin');

Insert into USERS (USER_ID,USER_NAME,PASSWORD,EMPLOYEE_ID) values (nextval('user_seq'),'admin','5f4dcc3b5aa765d61d8327deb882cf99',1);

Insert into USER_ROLE (USER_ROLE_ID,USER_ROLE_ST_DATE,USER_ROLE_END_DATE,IS_DEFAULT,USER_ID,ROLE_ID) values (nextval('user_role_seq'),'01/01/2009','31/12/2099',1,1,1);


-- ------------------------------------
-- GIS Masters (16-26 27-30)
-- ------------------------------------

Insert into PERMISSION_GROUP (PERMISSION_GROUP_ID,NAME) values (nextval('permission_group_seq'),'GIS-Master');

Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (16,'State','/state/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (17,'District','/district/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (18,'Taluka','/taluka/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (19,'City','/city/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (20,'Ward','/ward/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (21,'Node Master','/nodemaster/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (22,'Sector','/sector/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (23,'Plot','/plot/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (24,'Plot Type','/plottype/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (25,'Bank','/bank/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (26,'Bank Branch','/bankbranch/*',currval('permission_group_seq'));

Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,16);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,17);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,18);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,19);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,20);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,21);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,22);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,23);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,24);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,25);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,26);

-- ------------------------------------
-- User Admin (31-38) (39-45)
-- ------------------------------------

Insert into PERMISSION_GROUP (PERMISSION_GROUP_ID,NAME) values (nextval('permission_group_seq'),'User-Admin');

Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (31,'User','/user/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (32,'Role','/role/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (33,'Employee','/employee/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (34,'Department','/department/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (35,'Designation','/designation/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (36,'Permission','/permission/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (37,'Permission Group','/permissiongroup/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (38,'Salutation','/salutation/*',currval('permission_group_seq'));
Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (39,'Application','/application/*',currval('permission_group_seq'));


Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,31);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,32);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,33);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,34);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,35);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,36);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,37);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,38);
Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,39);


-- ------------------------------------
-- Reports  (100)
-- ------------------------------------

Insert into PERMISSION_GROUP (PERMISSION_GROUP_ID,NAME) values (nextval('permission_group_seq'),'Reports');

Insert into PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (101,'Audit Reports','/reports/*',currval('permission_group_seq'));

Insert into ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (nextval('role_permission_seq'),1,101);

-- Recreate sequences
-------------------------------------

drop sequence permission_seq;
create sequence permission_seq INCREMENT 1 MINVALUE 1  MAXVALUE 9223372036854775807 START 110  CACHE 1;
