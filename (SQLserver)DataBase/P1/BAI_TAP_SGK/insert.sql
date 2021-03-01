use DULICH
insert CHUYENDI
(MACD, TENCD, NGAYKH, NGAYKT, KHDK)
values 
	(1, N'Du Lịch Châu Âu','2020-03-04','2020-03-07',5),
	(2, N'Du Lịch Châu Á','2020-04-04','2020-04-08',20),
	(3, N'Du Lịch Châu Mỹ','2020-05-04','2020-05-09',10),
	(4, N'Du Lịch Châu Phi','2020-06-04','2020-06-10',6)
GO

select * from CHUYENDI

 insert KHACH
(MAKH, MACD, HTKH, TUOI, DCKH, DTKH)
values 
	(1, 1, N'Thọ', 20, N'Hưng Yên', '0973271208'),
	(2, 2, N'Linh', 20,N'Thanh Hóa', '0313518191'),
	(3, 3, N'Hiếu', 1, N'Mù Căng Chải', '0313618191'),
	(4, 4, N'Phương', 10, N'Hưng Yên', '0313528191')
GO

select * from KHACH

insert XE
(BIENSO , KHTD)
values 
	('CD123', 10),
	('CD121', 40)
GO

select * from XE

insert XEPV
(MACD, BIENSO)
values 
	(1, 'CD123'),
	(2, 'CD121'),
	(3, 'CD123'),
	(4, 'CD121')
GO

select * from XEPV

insert DIADIEM
(MADD, TENDD)
values 
	(1, N'Paris'),
	(2, N'Paris'),
	(3, N'Hưng Yên'),
	(4, N'Hưng Yên')
GO

select * from DIADIEM

insert CTIETCD
(MACD, MADD, SNLUU)
values 
	(1, 1, 5),
	(2, 2, 5),
	(3, 3, 1),
	(4, 4, 2)
GO

select * from CTIETCD

insert HUONGDV
(MAHDV, HTHDV, DCHDV)
values 
	(1, N'Minh', N'Thái Bình'),
	(2, N'Đức', N'Hà Nội')
GO

select * from HUONGDV

insert HUONGDAN
(MACD, MAHDV)
values 
	(1, 1),
	(2, 2),
	(3, 2),
	(4, 1)
GO

select * from HUONGDAN