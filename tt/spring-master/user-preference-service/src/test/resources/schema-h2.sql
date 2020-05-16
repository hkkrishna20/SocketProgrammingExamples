DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
  USERNAME VARCHAR(25) NOT NULL,
  PARTNER_ID VARCHAR(50) NOT NULL,
  PRIMARY KEY (USERNAME));
  
DROP TABLE IF EXISTS SERVICES;
CREATE TABLE SERVICES (
  ID INT NOT NULL,
  NAME VARCHAR(25) NOT NULL,
  PRIMARY KEY (ID));

DROP TABLE IF EXISTS USER_PREFS;
CREATE TABLE USER_PREFS (
  NAME VARCHAR(25) NOT NULL,
  VAL VARCHAR(25) NOT NULL,
  SERVICE_ID INT NOT NULL,
  USERNAME VARCHAR(25) NOT NULL,
  PRIMARY KEY (NAME, SERVICE_ID, USERNAME),
  CONSTRAINT USERNAME_FK
    FOREIGN KEY (USERNAME)
    REFERENCES USERS (USERNAME),
  CONSTRAINT SERVICE_ID_FK
    FOREIGN KEY (SERVICE_ID)
    REFERENCES SERVICES (ID));