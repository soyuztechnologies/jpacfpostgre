REM This script prepares the current shell's environment variables (not permanently)

REM Used for backing services like the PostgreSQL database
SET VCAP_APPLICATION={}
SET VCAP_SERVICES={"postgresql-db":[{"name":"mysql","label":"mysql","credentials":{"dbname":"postgres","hostname":"127.0.0.1","password":"Welcome1","port":"5432",
"uri":"postgres://postgres:Welcome1!@localhost:5432/postgres","username":"postgres"},"tags":["relational","postgresql"],"plan":"free"}]}

REM Used for dependent service call
SET USER_ROUTE=https://anubhavuserservice.cfapps.eu10.hana.ondemand.com

REM Overwrite logging library defaults
SET APPENDER=STDOUT
SET LOG_APP_LEVEL=INFO
