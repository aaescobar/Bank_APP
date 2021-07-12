drop table BANKACC;
drop table USERS;

create table USERS (
	id			serial primary key,
	first_name  varchar(25),
	last_name 	varchar(30),
	email 		varchar(50),
	password	varchar(50),
	
);


create table BANKACC (
	BANKACC_ID			serial primary key,
	BANCACC_USERID		int references BANKACC_USERID(BANKACC_ID) on delete set null,
	BANKACC_NAME		varchar(50),
	BANKACC_TYPE 		varchar(50),
	BANCACC_BALANCE		numeric(12,2)
	
insert into USERS (first_name, last_name, email, password, id) values ('Henriette', 'Preedy', 'hpreedy0@t.co', 'ayWP97', 6789);
insert into USERS (first_name, last_name, email, password) values ('Wye', 'Oller', 'woller1@java.com', 'aY77Kap5w1l2', 7898);
insert into USERS (first_name, last_name, email, password) values ('Freddy', 'Franceschelli', 'ffranceschelli2@bloomberg.com', 'XtyvDls5l', 6789);	
