o--------------------------------------------Bài tập 1------------------------------------------------------------------------

/*1.	Tạo view SachGD đưa ra danh sách các sách với các thông tin 
		MaSach,TenSach, tên thể loại, tổng số lượng nhập, tổng số lượng bán, 
		số lượng tồn do Nhà xuất bản Giáo Dục xuất bản.
*/
USE [BT1]
Go
create function tongBan()
returns	TABLE 
as 
	return(
		select HDB.MaSach, SUM(HDB.SLBan) as TBan from tChiTietHDB HDB, tNhaXuatBan NXB
		where NXB.MaNXB = 'NXB05'
		GROUP BY HDB.MaSach
		)
GO
create function tongNhap()
returns	TABLE 
as 
	return(
		select HDN.MaSach, SUM(HDN.SLNhap) as TNhap from tChiTietHDN HDN, tNhaXuatBan NXB
		where NXB.MaNXB = 'NXB05'
		GROUP BY HDN.MaSach
		)
GO
create function tongNhapBan()
returns	TABLE 
as 
	return(
		select TB.MaSach MS, TN.TNhap, TB.TBan from tongBan() TB left  join tongNhap() TN on TB.MaSach = TN.MaSach
		where TB.MaSach IS NOT NULL 
		)
GO

create view SachGD
as
select S.MaSach, S.TenSach, S.MaNXB, NXB.TenNXB, ISNULL(TNB.TNhap,0) as Nhap, ISNULL(TNB.TBan,0) as Ban, S.SoLuong
from tSach S, tNhaXuatBan NXB , tongNhapBan() TNB
where S.MaNXB = 'NXB05' and  NXB.MaNXB = S.MaNXB and TNB.MS = S.MaSach
Go
select * from SachGD
/*
	2.	Tạo view KhachVip đưa ra khách hàng gồm thông tin MaKH, 
		TenKH, địa chỉ, điện thoại cho những khách hàng đã mua hàng 
		với tổng tất cả các trị giá hóa đơn trong năm hiện tại lớn hơn 30.000.000
*/
Go
create view KhachVip
as
select KH.MaKH, KH.TenKH, KH.DiaChi, KH.DienThoai from tKhachHang KH, tHoaDonBan HDB, tChiTietHDB CTHDB, tSach S
where YEAR(NgayBan) = YEAR(GETDATE()) and S.MaSach = CTHDB.MaSach and HDB.SoHDB = CTHDB.SoHDB
	and HDB.MaKH = KH.MaKH
GROUP BY KH.MaKH, KH.TenKH, KH.DiaChi, KH.DienThoai
Having (SUM(CTHDB.SLBan * S.DonGiaBan) > 30000000)


/*
	3.	Tạo view đưa ra số hóa đơn, trị giá các hóa đơn và tổng toàn bộ trị giá 
		của các hoa đơn do nhân viên có tên “Trần Huy” lập trong tháng hiện tại
*/
Go
create view HDTranHuy
as
select HDB.SoHDB, SUM(CTHDB.SLBan * S.DonGiaBan) as N'Tổng Tiền' from tKhachHang KH, tHoaDonBan HDB, tChiTietHDB CTHDB, tSach S, tNhanVien NV
where NV.TenNV = N'Trần Huy' and S.MaSach = CTHDB.MaSach and HDB.SoHDB = CTHDB.SoHDB and HDB.MaKH = KH.MaKH and HDB.MaNV = NV.MaNV
GROUP BY HDB.SoHDB


/*
	4.	Tạo view đưa thông tin các các sách còn tồn
*/
Go
create view SachTon
as
select * from tSach S
where S.SoLuong > 0


/*
	5.	Tạo view đưa ra danh sách các sách không bán được trong năm 2014.
*/
Go
Create view KhongBan2014
as
select * from tSach S
where S.MaSach not in (select S.MaSach as MaSach from tHoaDonBan HDB, tChiTietHDB CTHDB, tSach S
		where HDB.SoHDB = CTHDB.SoHDB and CTHDB.MaSach = S.MaSach and YEAR(HDB.NgayBan) = 2014) 

--select * from KhongBan2014



/*
	6.	Tạo view đưa ra danh sách các sách của NXB Giáo Dục không bán được trong năm 2014.
*/
Go
Create view KhongBan2014_NXB05
as
select S.MaSach, S.TenSach from tSach S,tNhaXuatBan NXB
where S.MaSach not in (select S.MaSach as MaSach from tHoaDonBan HDB, tChiTietHDB CTHDB, tSach S
		where HDB.SoHDB = CTHDB.SoHDB and CTHDB.MaSach = S.MaSach and YEAR(HDB.NgayBan) = 2014) 
		and NXB.MaNXB = S.MaNXB and S.MaNXB = 'NXB05'

--		select * from tSach S, tNhaXuatBan NXB where S.MaNXB = NXB.MaNXB and NXB.MaNXB = 'NXB05'


/*
	7.	Tạo view đưa ra các thông tin về sách và số lượng từng sách được bán ra trong năm 2014.
*/
Go
Create view ban2014
as
select S.MaSach as N'Mã Sách', S.TenSach, S.DonGiaBan, S.DonGiaNhap,
		SUM(CTHDB.SLBan) as N'Số Lượng Bán'
from tHoaDonBan HDB, tChiTietHDB CTHDB, tSach S
		where HDB.SoHDB = CTHDB.SoHDB and CTHDB.MaSach = S.MaSach and YEAR(HDB.NgayBan) = 2014
		Group By S.MaSach, S.TenSach, S.DonGiaBan, S.DonGiaNhap



/*
	8.	Tạo view đưa ra họ tên khách hàng đã mua hóa đơn có trị giá cao nhất trong năm 2014.
*/
Go
Create view HDCaoNhat
as
select Top(1) KH.MaKH, KH.TenKH, (CTHDB.SLBan*S.DonGiaBan) as N'Giá Trị HĐ', HDB.NgayBan
from tChiTietHDB CTHDB, tHoaDonBan HDB, tKhachHang KH, tSach S
	where CTHDB.SoHDB = HDB.SoHDB and KH.MaKH = HDB.MaKH and S.MaSach = CTHDB.MaSach and YEAR(HDB.NgayBan) = 2014
	Group by KH.MaKH, KH.TenKH,(CTHDB.SLBan*S.DonGiaBan) ,HDB.NgayBan
	ORDER BY (CTHDB.SLBan*S.DonGiaBan) DESC
/*
	9.	Tạo view đưa ra danh sách 3 nhân viên (MaNV, TenNV) có doanh số cao nhất của năm hiện tại.
*/
Go
Create View Top3DoanhThu
as
select Top(3) NV.MaNV, NV.TenNV, SUM(S.DonGiaBan* CTHDB.SLBan) as N'Tổng Tiền' from tNhanVien NV, tHoaDonBan HDB, tChiTietHDB CTHDB, tSach S
where NV.MaNV = HDB.MaNV and CTHDB.SoHDB = HDB.SoHDB and  S.MaSach = CTHDB.MaSach
Group by  NV.MaNV, NV.TenNV 



/*
	10.	Tạo view đưa ra danh sách sách và số lượng nhập của mỗi nhà xuất bản trong năm hiện tại
*/
Go
Create view soluongtonNhapNow
as
select S.MaSach, S.SoLuong, iif(SUM(HDN.SLNhap)>0,SUM(HDN.SLNhap),0) as SoLuongNhap, NXB.MaNXB 
from tSach S left join tHoaDonNhap N on YEAR(GETDATE()) = YEAR(N.NgayNhap)
			left join tChiTietHDN HDN on HDN.MaSach = S.MaSach and YEAR(GETDATE()) = YEAR(N.NgayNhap)
			left join tNhaXuatBan NXB on S.MaNXB = NXB.MaNXB 
Group By S.MaSach, S.SoLuong, NXB.MaNXB 








--------------------------------------------Bài tập 2------------------------------------------------------------------------

/*
	1.	Tạo View danh sách sinh viên, gồm các thông tin sau: Mã sinh viên,
	Họ sinh viên, Tên sinh viên, Học bổng.
*/
Go
create view HB
as
Select SV.MaSV N'Mã Sinh Viên', SV.HoSV N'Họ Sinh Viên', SV.TenSV N'Tên Snh Viên', SV.HocBong N'Học Bổng' 
from DSSinhVien SV


/*
	2.	Tạo view Liệt kê các sinh viên có học bổng từ 150,000 
	trở lên và sinh ở Hà Nội, gồm các thông tin: Họ tên sinh viên,
	Mã khoa, Nơi sinh, Học bổng.
*/
Go
create view HBSVHN
as
Select SV.HoSV +' '+ SV.TenSV N'Họ Tên Snh Viên',SV.MaKhoa N'Mã Khoa', SV.NoiSinh N'Nơi Sinh', iif(SV.HocBong >0 ,SV.HocBong,0) N'Học Bổng' 
from DSSinhVien SV
where SV.HocBong >= 150000 and  SV.NoiSinh = N'Hà Nội'



/*
	3.	Tạo view liệt kê những sinh viên nam của khoa Anh văn và khoa tin học,
	gồm các thông tin: Mã sinh viên, Họ tên sinh viên, tên khoa, Phái.
*/
Go
create view NamAVTH 
as
select SV.MaSV N'Mã Sinh Viên', SV.HoSV + ' ' + SV.TenSV N'Họ Tên Sinh Viên', KH.TenKhoa N'Tên Khoa', SV.Phai N'Phái'
from DMKhoa KH, DSSinhVien SV
where SV.MaKhoa = KH.MaKhoa and SV.Phai = 'Nam' and (SV.MaKhoa ='AV' or SV.MaKhoa ='TH')



/*
	4.	Tạo view gồm những sinh viên có tuổi từ 20 đến 25, thông tin gồm:
	Họ tên sinh viên, Tuổi, Tên khoa.
*/
Go
create view tuoi2025
as
select SV.MaSV N'Mã Sinh Viên', SV.HoSV + ' ' + SV.TenSV N'Họ Tên Sinh Viên',DATEDIFF(YEAR,NgaySinh,GETDATE()) N'Tuổi', KH.TenKhoa N'Tên Khoa'
from DSSinhVien SV inner join DMKhoa KH on SV.MaKhoa = KH.MaKhoa
where DATEDIFF(YEAR,NgaySinh,GETDATE()) >= 20 and DATEDIFF(YEAR,NgaySinh,GETDATE()) <= 25


/*
	5.	Tạo view cho biết thông  tin về mức học bổng của các sinh viên, gồm: Mã sinh viên, 
	Phái,  Mã khoa, Mức học bổng. Trong đó, mức học bổng sẽ hiển thị là “Học bổng cao” nếu
	giá trị của field học bổng lớn hơn 500,000 và ngược lại hiển thị là “Mức trung bình”
*/
Go
create view xeploaiHB
as
select SV.MaSV N'Mã Sinh Viên', SV.Phai N'Phái', SV.MaKhoa N'Mã Khoa', iif(SV.HocBong > 500000,N'Học Bổng Cao', N'Mức Trung Bình') 'Mức Học Bổng'
from DSSinhVien SV



/*
	6.	Tạo view đưa ra thông tin những sinh viên có học bổng lớn hơn bất kỳ học bổng của sinh viên học khóa anh văn
*/
Go
create view HBcaoAV
as
select MaSV as N'Mã sinh viên', HoSV + ' ' +TenSV as N'Họ tên', Phai as N'Giới tính', DMKhoa.MaKhoa as N'Mã Khoa' 
from DSSinhVien inner join DMKhoa on DMKhoa.MaKhoa = DSSinhVien.MaKhoa 
where DMKhoa.MaKhoa not like 'AV' and HocBong > (select MIN(HocBong) from DSSinhVien 
													inner join DMKhoa on DMKhoa.MaKhoa =DSSinhVien.MaKhoa 
													where DMKHoa.TenKhoa like N'Anh Văn')


/*
	7.	Tạo view đưa ra thông tin những sinh viên đạt điểm cao nhất trong từng môn.
*/
Go
create view diemcaoMH
as
select DMMonHoc.TenMH as 'Ten mon hoc', DSSinhVien.HoSV + ' ' + DSSinhVien.TenSV as 'Ho va ten', KetQua.Diem as 'Diem' 
from DMMonHoc inner join KetQua on KetQua.MaMH = DMMonHoc.MaMH 
			  inner join DSSinhVien on DSSinhVien.MaSV = KetQua.MaSV 
			  inner join (select MAX(Diem) as 'Diem', (select b.MaMH from DMMonHoc b where b.MaMH = DMMonHoc.MaMH) as 'Ma mon hoc' 
						  from KetQua inner join DMMonHoc on DMMonHoc.MaMH = KetQua.MaMH 
						  group by DMMonHoc.MaMH ) as a ON a.[Ma mon hoc] = DMMonHoc.MaMH
						  where KetQua.Diem = a.Diem



/*
	8.	Tạo view đưa ra những sinh viên chưa thi môn cơ sở dữ liệu.
*/
Go
create function KQ1()
returns TABLE 
as
return(
		select KQ.MaSV as DATHI from KetQua KQ
		where KQ.MaMH = '01'
		group by KQ.MaSV
	)

Go
create view bothi
as
select SV.MaSV, SV.HoSV, SV.TenSV from DSSinhVien SV left join KQ1() KQ on SV.MaSV = KQ.DATHI
where KQ.DATHI is null

			

/*
	9.	Tạo view đưa ra thông tin những sinh viên không trượt môn nào.
*/
Go
create view khongtruot
as
select b.HoSV + ' ' + b.TenSV as N'Họ Tên' 
from DSSinhVien b left join (select c.MaSV from DSSinhVien c inner join KetQua on KetQua.MaSV = c.MaSV where KetQua.Diem <5) as a on a.MaSV = b.MaSV where a.MaSV is null



/*
	10.	Tạo view danh sách sinh viên không bi rớt môn nào
*/
Go
create view thirot  
as
select SV.HoSV +' '+SV.TenSV as N'Họ tên' from DSSinhVien SV left join (select c.MaSV from DSSinhVien c inner join KetQua on KetQua.MaSV = c.MaSV WHERE KetQua.Diem <5
) as a on a.MaSV = SV.MaSV WHERE a.MaSV is null






--------------------------------------------Bài tập 3------------------------------------------------------------------------
/*
	1.	Tạo login Login1, tạo User1 cho Login1
*/
Go
--Tạo Login1
exec sp_addlogin
	'Login1', '12345' , 'BT2'

--Tạo User1
exec sp_adduser
	'Login1', 'User1'



/*
	2.	Phân quyền Select trên bảng DSSinhVien cho User1
*/
Go
Use BT2
Grant select on DSSinhVien to User1

--đăng nhập rồi chạy đoạn dưới để thử
Go
select * from DSSinhVien



/*
	4.	Tạo login Login2, tạo User2 cho Login2
*/
Go
exec sp_addlogin Login2,'12345'
exec sp_adduser Login2, User2


/*
	5.	Phân quyền Update trên bảng DSSinhVien cho User2, người này có thể cho phép người khác sử dụng quyền này
*/
Go

Grant UPDATE on DSSinhVien to User2 WITH GRANT OPTION



/*
	6.	Đăng nhập dưới Login2 và trao quyền Update trên bảng DSSinhVien cho User 1
*/
Go
GRANT UPDATE ON DSSinhVien to User1

--đăng nhập vào User1 và test

UPDATE DSSinhVien SET TenSV = N'Thọ' WHERE MaSV LIKE 'B01'

select * from DSSinhVien where MaSV like 'B01'