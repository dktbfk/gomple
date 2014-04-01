DROP TABLE accounts;

create table accounts(
id VARCHAR2(20) PRIMARY KEY,
NAME VARCHAR2(20) ,
ACCOUNT VARCHAR2(50),
pw  VARCHAR2(50),
amount  VARCHAR2(50),
tel  VARCHAR2(50),
addr VARCHAR2(50),
regdate DATE DEFAULT sysdate
);

