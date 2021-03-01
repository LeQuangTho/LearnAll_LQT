--IDENTITY là tự động tăng
--DISTINCT là loại bỏ các dòng bị trùng
--foreign key () là khóa ngoại 
--primany key () là tạo khóa chính
--constraint fk_(pk_) đặt tên cho các khóa
--references là đối chiếu sang bảng nào đó

CREATE DATABASE STUDENT;

GO

use STUDENT;
GO

create table SINHVIEN
(
	MASV varchar(10) NOT NULL,
	HOTEN NVARCHAR(30) NOT NULL,
	GIOITINH NVARCHAR(5) NOT NULL,
	NGAYSINH DATE NOT NULL,
	DIACHI NVARCHAR(100) DEFAULT NULL,
);
GO

create table DIEM
(
  DIEM float not null DEFAULT 0,
  MASV varchar(10) not null,
  MAMH  varchar(10) not null
);
GO

create table MONHOC
(
  MAMH  varchar(10) not null,
  TENMON nvarchar(50) not null,
  SOTC int default 1,
);
GO

alter table SINHVIEN
add constraint pk_sinhvien primary key (MASV);
GO

alter table MONHOC
add constraint pk_monhoc primary key (MAMH)	 ;
GO

alter table DIEM
add constraint fk_diem_sinhvien foreign key (MASV) references SINHVIEN(MASV),
	constraint fk_diem_monhoc foreign key (MAMH) references MONHOC(MAMH) ; 
GO


insert SINHVIEN
(MASV, HOTEN, GIOITINH, NGAYSINH, DIACHI)
values ('1', N'Vinh', N'Nam','1994-01-30', N'Hưng Yên'),
	   ('2', N'Thọ', N'Nam','2000-12-14', N'Hưng Yên'),
       ('3', N'Linh', N'Nữ','2000-09-02', N'Thanh Hóa'),
	   ('4', N'Hương', N'Nữ','1999-09-14', N'Thanh Hóa'),
	   ('5', N'P.Linh', N'Nữ','2000-09-15', N'Nam Định'),
	   ('6', N'T.Anh', N'Nam','2000-1-14', N'Nam Định')
GO

insert MONHOC
(MAMH, TENMON, SOTC)
values ('1', N'Toán', 2),
	   ('2', N'Lý', 2),
	   ('3', N'Hóa', 2)
GO

insert DIEM
(MASV, MAMH, DIEM)
values  ('1','1',9.7),
		('1','2',8.2),
		('1','3',7.3),
		('2','1',10),
		('2','2',9.1),
		('2','3',10),
		('3','1',7.4),
		('3','2',8.9),
		('3','3',9.4),
		('4','1',6.5),
		('4','2',7.3),
		('4','3',8.9),	  
		('5','1',5.6),
		('5','2',6.8),
		('5','3',7.5),
		('6','1',6.9),
		('6','2',7.9),
		('6','3',8.8)
GO
--delete from MONHOC
--delete from SINHVIEN
GO

select * from SINHVIEN
select * from MONHOC
select * from DIEM
GO

--Đưa ra họ tên và địa chỉ của các sinh viên có điểm thi >= 8 giới tính nữ (DISTINCT loại các cái trùng nhau)
select DISTINCT SV.HOTEN, SV.DIACHI from SINHVIEN AS SV inner join DIEM AS D on SV.MASV = D.MASV where DIEM >= 8 and SV.GIOITINH like N'nữ' 
GO

-- Đưa ra tên sinh viên và môn đang học
select DISTINCT SV.HOTEN, MH.TENMON as DANGHOC from SINHVIEN as SV Left join DIEM as D on SV.MASV = D.MASV, MONHOC as MH where D.MAMH = MH.MAMH
GO

--Tìm kiếm gần đúng xuất ra sinh viên trong họ tên có tồn tại chữ i
select HOTEN from SINHVIEN where SINHVIEN.HOTEN like '%i%'
GO

-- nối bảng
-- Đưa ra tên sinh viên và số môn học
select sv.MASV, sv.HOTEN, COUNT(*) as N'Số Môn Học'  from SINHVIEN as sv join DIEM as D
on sv.MASV = D.MASV
group by sv.MASV, sv.HOTEN
GO

--Đưa ra mã môn và tên môn học kèm theo số lượng sinh viên đăng kí học.
select MONHOC.MAMH, MONHOC.TENMON, COUNT(SINHVIEN.HOTEN) as SOSINHVIEN
from SINHVIEN, MONHOC, DIEM
where SINHVIEN.MASV = DIEM.MASV	and MONHOC.MAMH = DIEM.MAMH
Group by MONHOC.MAMH, MONHOC.TENMON
GO

--Đưa ra các sinh viên có điểm trung bình cao nhất
select SINHVIEN.MASV , SINHVIEN.HOTEN , AVG (DIEM.DIEM) as N'Điểm trung bình'
from SINHVIEN join DIEM on SINHVIEN.MASV = DIEM.MASV
group by SINHVIEN.MASV, SINHVIEN.HOTEN
having AVG(DIEM) >= 0--all(select AVG(DIEM) from DIEM group by MASV)
order by  AVG (DIEM.DIEM)
GO

--xóa một dòng trong bảng điểm
delete from DIEM where DIEM.MASV = '3' and DIEM.MAMH = '1'
GO

--đưa ra danh sách dinh viên và điểm trung bình
select TOP(1)sv.MASV as N'Mã Sinh Viên', sv.HOTEN as N'Họ Tên', AVG(D.DIEM) as N'Điểm Trung Bình' 
from SINHVIEN as sv join DIEM as D on sv.MASV = D.MASV
group by  sv.MASV, sv.HOTEN
having AVG(D.DIEM) >= 0--all(select AVG(DIEM) from DIEM group by DIEM.MASV)
order by AVG(D.DIEM) DESC



--use master
--drop database STUDENT