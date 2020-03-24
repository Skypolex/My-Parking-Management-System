create table ADMINS(
	ADMIN_ID NUMBER(10) primary key,
	ADMIN_NAME VARCHAR2(50) not null,
	ADMIN_PASSWORD  VARCHAR2(50) not null,
	IS_SUPER   VARCHAR2(5) not null
)segment creation immediate;

create sequence 	admins_id
        increment by 1
        start with 1
        maxvalue 2000
        order 
        nocycle
        cache 10;
commit;


create table PARK
(
  PARK_ID   NUMBER(10) primary key,
  PARK_NAME VARCHAR2(50) not null,
  MAX_CAR_VALUE  NUMBER(10) not null,
  CAR_VALUE  NUMBER(10),
  PRICE_PRE_HOUR  NUMBER(10,2) not null,
  PRICE_DAY NUMBER(10,2) not null
)segment creation immediate;

create sequence 	parks_id
        increment by 1
        start with 1
        maxvalue 2000
        order 
        nocycle
        cache 5;
commit;

create sequence 	cars_value
        increment by 1
        start with 1
        maxvalue 20000
        order 
        nocycle
        cache 10;
commit;

create table MEMBERCAR
(
  MEMBER_CAR_ID   NUMBER(10) primary key,
  CAR_NUMBER VARCHAR2(50) not null,
  CAR_DESCRIBE VARCHAR2(100),
  ADMIN_ID NUMBER(10) REFERENCES ADMINS(ADMIN_ID)
)segment creation immediate;

create sequence 	members_car_id
        increment by 1
        start with 1
        maxvalue 20000
        order 
        nocycle
        cache 10;
commit;

create table CAR
(
  CAR_ID NUMBER(10) primary key,
  CAR_NUMBER VARCHAR2(50) not null,
  PARK_ID   NUMBER(10) REFERENCES PARK(PARK_ID),
  CAR_IN_TIME DATE,
  IS_MEMBER_CAR VARCHAR2(5),
  CAR_DESCRIBE VARCHAR2(100),
  ADMIN_ID NUMBER(10) REFERENCES ADMINS(ADMIN_ID)
  
)segment creation immediate;

create sequence 	cars_id
        increment by 1
        start with 1
        maxvalue 40000
        order 
        nocycle
        cache 10;
commit;

insert into ADMINS values (admins_id.nextval,'admin','admin','1');
insert into PARK values (parks_id.nextval,'地面停车场','50','0','3','50');
commit;
