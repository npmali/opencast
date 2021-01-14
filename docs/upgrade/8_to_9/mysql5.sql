-- Drop unused tables
drop table oc_job_oc_service_registration;
drop table oc_job_context;

-- Alter oc_assets_asset table
ALTER TABLE oc_assets_asset MODIFY COLUMN mime_type VARCHAR (255);
