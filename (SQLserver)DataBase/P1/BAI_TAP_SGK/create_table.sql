create database DULICH
go

use DULICH
go

create table DIADIEM
(
	MADD int not null,
	TENDD nvarchar(30) default null
);
GO

create table XE
(
	BIENSO varchar(10) not null,
	KHTD int default 4
);
GO

create table HUONGDV
(
	MAHDV int not null,
	HTHDV nvarchar(30) default N'Name',
	DCHDV nvarchar(30) default N'Dia Chi'
);
GO

create table CHUYENDI
(
	MACD int not null,
	TENCD nvarchar(30),
	NGAYKH date,
	NGAYKT date,
	KHDK int,
);
GO

create table CTIETCD
(
	MACD int not null,
	MADD int not null,
	SNLUU int 
);
GO

create table HUONGDAN
(
	MACD int not null,
	MAHDV int not null
);
GO

create table KHACH
(
	MAKH int not null,
	MACD int not null,
	HTKH nvarchar(30),
	TUOI int,
	DCKH nvarchar(30),
	DTKH varchar(10)
);
GO

create table XEPV
(
	MACD int not null,
	BIENSO varchar(10) not null
);
GO

alter table KHACH add constraint pk_khach primary key (MAKH);
GO

alter table HUONGDV add constraint pk_huongdv primary key (MAHDV);
GO

alter table CHUYENDI add constraint pk_chuyendi primary key (MACD);
GO

alter table DIADIEM add constraint pk_diadiem primary key (MADD);
GO
											  
alter table XE add constraint pk_xe primary key (BIENSO);
GO

alter table KHACH 
add constraint fk_chuyendi_khach foreign key (MACD) references CHUYENDI (MACD);
GO

alter table CTIETCD
add constraint fk_ctietcd_chuyendi foreign key (MACD) references CHUYENDI (MACD)
GO

alter table CTIETCD
add constraint fk_ctietcd_diadiem foreign key (MADD) references DIADIEM (MADD)
GO

alter table HUONGDAN
add constraint fk_huongdan_chuyendi foreign key (MACD) references CHUYENDI (MACD),
	constraint fk_huongdan_huongdv foreign key (MAHDV) references HUONGDV(MAHDV);
GO

alter table XEPV
add constraint fk_xepv_chuyendi foreign key (MACD) references CHUYENDI(MACD),
	constraint fk_xepv_xe foreign key (BIENSO) references XE(BIENSO);
GO
--use master
--DROP database DULICH