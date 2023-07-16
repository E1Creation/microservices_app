CREATE TABLE if not exists log_activity(
    id int primary key,
    service_name varchar(50),
    event varchar(50),
    before varchar,
    after varchar,
    created_by varchar(50),
    created_date timestamptz not null default now()
);

CREATE TABLE if not exists log_api(
    id int primary key,
    service_name varchar(50),
    request_uri varchar(100),
    request_method varchar(8),
    remote_address varchar(50),
    request varchar,
    response varchar,
    execution_time_in_ms bigint,
    created_by varchar(50),
    created_date timestamptz not null default now()
);

CREATE INDEX if not exists idx_logapiactivity_id_createdby_createddate on log_api_activity (id, created_by, created_date);
CREATE INDEX  if not exists idx_logapi_id_createdby_createddate on log_api(id, created_date,created_by)
