create proc cau2 @ngay int, @thang int, @nam int, @soluong int output as
begin
	select @soluong = COUNT(*) from Hoadon HD inner join ChiTietHD Ct on HD.MaHD = Ct.MaHD
							inner join SanPham SP on Ct.MaSP = SP.MaSP
							where @ngay = DAY(HD.Ngayban) and @thang = MONTH(HD.Ngayban) and @nam = YEAR(HD.Ngayban)
end

Go
declare @soluong int
exec cau2 '22','3','2015',@soluong OUT
print(@soluong)

Go

-----------Câu 3----------
 create function cau3 (@makh nvarchar(10), @nam int) 
 returns table 
 as
	return(
		select KH.MaKH as N'Mã KH',
		HD.MaHD as N'Mã Hóa Đơn',
		HD.Ngayban as N'Ngày Bán',
		SUM(CT.SlBan * SP.GiaSP) as 'Tổng Tiền'
		from Hoadon HD 
		inner join ChiTietHD CT on HD.MaHD = CT.MaHD
		inner join KhachHang KH on KH.MaKH = HD.MaKH
		inner join SanPham SP on CT.MaSP = SP.MaSP
		where KH.MaKH = @makh and YEAR(HD.Ngayban) = @nam
		Group by KH.MaKH, HD.MaHD, HD.Ngayban
	)

Go

select * from cau3('0002',2015)

----------câu 4 -----------
Go
create view cau4
as
	select SP.MaSP, SUM(CTN.SLN) as N'Số Lượng Nhập', SUM(CT.SlBan) as N'Số Lượng Bán', (SUM(CTN.SLN) -SUM(CT.SlBan)) as N'Tồn Kho' from SanPham SP 
				inner join ChiTietHD CT on CT.MaSP = SP.MaSP
				inner join Hoadon HD on HD.MaHD = CT.MaHD
				inner join ChiTietHDN CTN on CTN.MaSP = SP.MaSP
				inner join HoaDonNhap HDN on CTN.MaHDN = HDN.MaHDN
		where YEAR(HDN.NgayNhap) = 2015 and YEAR(HD.Ngayban) = 2015
	Group by SP.MaSP

Go
select * from cau4

--------------cau 5----------
Go
alter table Hoadon add SoLuongMua int

Go
alter trigger cau5 on ChiTietHD for insert, update as
begin
	declare @soluong int, @ma  nvarchar(10)
	select @ma = MaHD from inserted
	select @soluong = Sum(S.SlBan) from inserted S inner join ChiTietHD HD on HD.MaHD = S.MaHD
	Update Hoadon set SoLuongMua = @soluong where Hoadon.MaHD = @ma
end

select * from Hoadon

exec sp_addlogin 'A', '1234'
GO
exec sp_adduser 'A', 'A'
GO
Grant select,update,insert on Hoadon to A with grant option

exec sp_addlogin 'B', '1234'
GO
exec sp_adduser 'B', 'B'
GO