ALTER TABLE nmmccommon.users ADD UNIQUE (user_name);
ALTER TABLE nmmccommon.users ADD COLUMN middle_name VARCHAR(25);

ALTER TABLE "nmmcadmin"."user_role"
  DROP CONSTRAINT "fkbc16f46aa9249676" RESTRICT;

ALTER TABLE "nmmcadmin"."user_role"
  ADD CONSTRAINT "fkbc16f46aa9249676" FOREIGN KEY ("user_id")
    REFERENCES "nmmccommon"."users"("user_id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;

CREATE TABLE "nmmcadmin"."tenant" (
  "tenant_id" BIGINT NOT NULL, 
  "tenant_name" VARCHAR(50) NOT NULL, 
  "address" varchar(500),
  "website" varchar(50) ,
  CONSTRAINT "tenant_pkey" PRIMARY KEY("tenant_id")
) WITHOUT OIDS;

Insert into nmmcadmin.PERMISSIONS (PERMISSION_ID,LINK_NAME,LINK_URL,PERMISSION_GROUP_ID) values (40,'Tenant','/tenant/*',2);
Insert into nmmcadmin.ROLE_PERMISSION (ROLE_PERMISSION,ROLE_ID,PERMISSION_ID) values (22,1,40);

CREATE SEQUENCE "nmmcadmin"."tenant_seq"
  INCREMENT 1 MINVALUE 1
  MAXVALUE 9223372036854775807 START 1
  CACHE 1;