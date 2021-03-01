--Câu 2: (1 điểm) Tạo thủ tục có đầu vào là ngày hóa đơn, đầu ra là số mặt hàng bán trong ngày đó

create proc cau2 @ngay int, @thang int, @nam int, @soluong int output as
begin
	select @soluong = COUNT(*) from Hoadon HD 
	inner join ChiTietHD CT on CT.MaHD = HD.MaHD
	inner join SanPham SP on SP.MaSP = CT.MaSP where DAY(HD.Ngayban) = @ngay and MONTH(HD.Ngayban) = @thang and YEAR (HD.Ngayban) = @nam 
end

GO 

declare @soluong int 
exec cau2 '22','3','2015', @soluong out 

print @soluong

Go 



--Câu 3: (1 điểm) Tạo hàm có đầu vào là mã khách hàng, năm, đầu ra là danh sách các hóa đơn khách hàng mua trong năm
create function cau3 (@makh nvarchar(10), @nam int) 
returns table 
as
return(
	select KH.MaKH as N'Mã KH', HD.MaHD as N'Mã hóa đơn', HD.Ngayban as N'Ngày bán', SUM(CT.SlBan * SP.GiaSP) as N'Tổng tiền' from Hoadon HD 
	inner join KhachHang KH on KH.MaKH = HD.MaKH
	inner join ChiTietHD CT on CT.MaHD = HD.MaHD
	inner join SanPham SP on SP.MaSP = CT.MaSP
	where HD.MaKH =  @makh and @nam = YEAR(HD.Ngayban)
	Group By KH.MaKH,HD.MaHD,HD.Ngayban
)

select * from cau3('0002',2015)


Go

--Câu 4: (1 điểm) Tạo View thống kê hàng tồn dựa trên số lượng nhập và bán trong năm 2015
create view cau4 
as
	select SP.MaSP as N'Mã hàng', SP.TenSP as N'Tên hàng', SUM(CTN.SLN) as N'Số lượng nhập', SUM(CT.SlBan) as N'Số lượng bán', (SUM(CTN.SLN) - SUM(CT.SlBan)) as N'Tồn Kho'
	from SanPham SP 
	inner join ChiTietHDN CTN on SP.MaSP = CTN.MaSP
	inner join HoaDonNhap HDN on CTN.MaHDN = HDN.MaHDN
	inner join ChiTietHD CT on CT.MaSP = SP.MaSP 
	inner join Hoadon HD on HD.MaHD = Ct.MaHD
	where YEAR(HD.Ngayban) = 2015
	group by SP.MaSP, SP.TenSP
GO
select * from cau4

Go

--Câu 5: (1 điểm) Thêm các trường Số lượng hàng mua vào Hóa đơn. Tạo Trigger cập nhật tự động cho trường này. (tính tổng số lượng bán của toàn bộ hàng trong mỗi hóa đơn)

alter table HoaDon add SoLuongMua int 
Go

create trigger cau5 on ChitietHD for insert, update 
as
begin 
	declare @soluong int, @mahd nvarchar(10)
	select @mahd = MaHD from inserted
	select @soluong = SUM(CT.SlBan) from ChiTietHD CT where CT.MaHD = @mahd
	Update HoaDon set SoLuongMua = @soluong where @mahd = Hoadon.MaHD
end

Update ChiTietHD set SlBan = 2 where MaHD = '0011'
select * from Hoadon
select * from ChiTietHD where MaHD = '0011'


Go

--Câu 6: (1 điểm) Tạo hai login A và B, gán quyền Select, Insert, Update cho A trên bảng Hóa đơn và chi tiết hóa đơn, cho phép A được phép gán những quyền này cho người khác A gán quyền cho B, hãy đăng nhập dưới tài khoản B để kiểm tra



exec sp_addlogin 'A', '1234'
GO
exec sp_adduser 'A', 'A'
GO

Grant Select, Insert, Update on Hoadon to A with grant option

Go
exec sp_addlogin 'B', '1234'
GO
exec sp_adduser 'B', 'B'
