---------------------------------------------------bài 1--------------------------------------------

/*
	1.Viết một Trigger gắn với bảng DIEM dựa trên sự kiện Insert,
	Update bản ghi để chỉ cho phép nhập giá trị trong khoảng từ 0 đến 10
*/
use BT1_BTN12
GO
create trigger checkDiem on DIEM  for insert ,update
as 
begin
	declare @toan float, @ly float, @hoa float, @van float
	select @toan = TOAN, @ly = LY, @hoa = HOA, @van = VAN from inserted
	if(@toan>10 or @toan<0) rollback
	if(@ly>10 or @ly<0) rollback
	if(@hoa>10 or @hoa<0) rollback
	if(@van>10 or @van<0) rollback
end 

--select * from DIEM
--update DIEM set TOAN = 11 where MAHS = '00001'

/*
	2.Viết một Trigger gắn với bảng DIEM dựa trên sự kiện Insert, 
	Update để tự động cập nhật điểm trung bình của học sinh khi
	thêm mới hay cập nhật bảng điểm Điểm trung bình= ((Toán +Văn)*2+Lý+Hóa)/6
*/
GO
create trigger leverUP on DIEM  for insert ,update
as 
begin
	declare @masv nvarchar(5), @toan float, @ly float, @hoa float, @van float 
	select @masv = MAHS, @toan = TOAN, @ly = LY, @hoa = HOA, @van = VAN from inserted

	update DIEM set DTB = ROUND(((@toan + @van)*2 + @ly + @hoa)/6,2) where @masv = MAHS
end


--select * from DIEM
--update DIEM set TOAN = 10 where MAHS = '00001'
--select * from DIEM



/*
	3.Viết một Trigger gắn với bảng DIEM dựa trên sự kiện Insert,
	Update để tự động xếp loại học sinh, cách thức xếp loại như sau
	-Nếu Điểm trung bình>=5 là lên lớp, ngược lại là lưu ban
*/
create trigger xeploai on DIEM  for insert ,update
as 
begin
	declare @masv nvarchar(5), @toan float, @ly float, @hoa float, @van float 
	select @masv = MAHS, @toan = TOAN, @ly = LY, @hoa = HOA, @van = VAN from inserted

	if ROUND(((@toan + @van)*2 + @ly + @hoa)/6,2) >= 5
		update DIEM set XepLoai = N'Lên Lớp' where @masv = MAHS
	else update DIEM set XepLoai = N'Lưu Ban' where @masv = MAHS
end

--select * from DIEM
--update DIEM set TOAN = 10 where MAHS = '00001'
--select * from DIEM

/*
	4.Viết một Trigger gắn với bảng DIEM dựa trên sự kiện Insert,
	Update để tự động xếp loại học sinh, cách thức xếp loại như sau
-Xét điểm thấp nhất (DTN) của các 4 môn
-Nếu DTB>=5 và DTN>=4 là “Lên Lớp”, ngược lại là lưu ban
*/
create trigger xeploai2 on DIEM  for insert ,update
as 
begin
	declare @masv nvarchar(5), @toan float, @ly float, @hoa float, @van float, @dtn float
	select @masv = MAHS, @toan = TOAN, @ly = LY, @hoa = HOA, @van = VAN from inserted
	if(@toan <= @ly and @toan <= @hoa and  @toan <= @van) set @dtn = @toan
	if(@ly <= @toan and @ly <= @hoa and  @ly <= @van) set @dtn = @ly
	if(@hoa <= @toan and @hoa <= @ly and  @hoa <= @van) set @dtn = @hoa
	if(@van <= @toan and @van <= @hoa and  @van <= @ly) set @dtn = @van

	if ROUND(((@toan + @van)*2 + @ly + @hoa)/6,2) >= 5 and @dtn >= 4
		update DIEM set XepLoai = N'Lên Lớp' where @masv = MAHS
	else update DIEM set XepLoai = N'Lưu Ban' where @masv = MAHS
end


--select * from DIEM
--update DIEM set TOAN = 10 where MAHS = '00001'
--update DIEM set TOAN = 3, LY = 10, HOA = 10, VAN = 10 where MAHS = '00001'
--select * from DIEM

/*
	5.Viết một trigger xóa tự động bản ghi về điểm học sinh
	khi xóa dữ liệu học sinh đó trong DSHS
*/
create trigger delHS on DSHS  for delete
as 
begin
	declare @masv nvarchar(5)
	select @masv = MAHS from deleted	
	delete from Diem where @masv = MAHS
end
--select * from DIEM
--select * from DSHS
--delete from DSHS where MAHS = '00007'
--select * from DIEM
--select * from DSHS

/*
	6.Viết nội thủ tục (Stored Procedure) cập nhật phần ghi 
	chú là “Chuyển trường từ ngày 5/9/2016” cho học sinh có 
	mã nhập vào trong bảng danh sách học sinh.
*/
create proc chuyentruong as
begin
	update DSHS set Ghichu = N'Chuyển trường từ ngày 5/9/2016'
end 

go
exec chuyentruong

--select *from DSHS
/*
	7.Tạo View báo cáo Kết thúc năm học gồm các thông tin: Mã học sinh,
	Họ và tên, Ngày sinh, Giới tính, Điểm Toán, Lý, Hóa, Văn, Điểm Trung bình, Xếp loại
*/
create function xeploai(@mahs nvarchar(5))
returns nvarchar(10) as
begin 
	declare @toan float, @ly float, @hoa float, @van float, @xl nvarchar(10), @dtb float
	select @toan = TOAN, @ly = LY, @hoa = HOA, @van = VAN from DIEM where MAHS = @mahs
	set @dtb = ROUND(((@toan + @van)*2 + @ly + @hoa)/6,2)
	
	if(@dtb <6.5) set @xl = 'Trung Binh'
	else if(@dtb >=6.5 and @dtb < 8) set @xl = 'Kha'
	else if(@dtb > 8) set @xl = 'Gioi'
	return @xl
end

create view report
as 
	select 
	DS.MAHS, DS.HO +' '+ DS.TEN as HoTen,
	DS.NGAYSINH as NamSinh, iif(DS.NU = 0,'Nam','Nu') as N'Giơi Tính', D.TOAN, D.LY, D.HOA, D.VAN,
	ROUND(((D.TOAN+D.VAN)*2 + D.LY + D.HOA)/6,2) as DTB,
	dbo.xeploai(D.MAHS) as N'Xếp Loại'
	from LOP as L inner join DSHS as DS on L.LOP = DS.LOP
					inner join DIEM as D on D.MAHS = DS.MAHS

--select * from report

/*
	8.Tạo trường điểm thấp nhất trong bảng Điểm, tạo thủ tục cập nhật
	điểm thấp nhất cho trường này của tất cả các bản ghi đã có (dùng con trỏ)
*/
declare a cursor for select MAHS from DSHS
open a
declare @mahs nvarchar(5)
FETCH NEXT FROM a INTO @mahs
WHILE @@FETCH_STATUS = 0
	BEGIN
		DECLARE @toan float, @hoa float, @van float, @ly float, @dtn float
		SET @dtn=@toan
		SELECT @toan=TOAN, @ly=LY, @hoa=HOA, @van=VAN FROM DIEM WHERE @mahs=MAHS

		IF @dtn<@hoa
			SET @dtn=@hoa
		IF @dtn<@ly	
			SET @dtn=@ly
		IF @dtn<@van
			SET @dtn=@van

		UPDATE DIEM SET DiemThapNhat =@dtn WHERE @mahs = MAHS

		FETCH NEXT FROM a INTO @mahs
	END

CLOSE a
DEALLOCATE a

--select *from Diem



/*
	9.Tạo trigger cập nhật điểm thấp nhất mỗi khi insert, update một bản ghi vào bảng điểm.
*/
create trigger diemthapnhat on DIEM  for insert ,update
as 
begin
	declare @masv nvarchar(5), @toan float, @ly float, @hoa float, @van float, @dtn float
	select @masv = MAHS, @toan = TOAN, @ly = LY, @hoa = HOA, @van = VAN from inserted
	if(@toan <= @ly and @toan <= @hoa and  @toan <= @van) set @dtn = @toan
	if(@ly <= @toan and @ly <= @hoa and  @ly <= @van) set @dtn = @ly
	if(@hoa <= @toan and @hoa <= @ly and  @hoa <= @van) set @dtn = @hoa
	if(@van <= @toan and @van <= @hoa and  @van <= @ly) set @dtn = @van
	update DIEM set DiemThapNhat = @dtn where @masv = MAHS
end



/*
	10.Tạo View danh sách HOC SINH XUAT SAC bao gồm các học sinh 
	có DTB>=8.5 và DTN>=8 với các trường: Lop, Mahs, Hoten, 
	Namsinh (năm sinh), Nu, Toan, Ly, Hoa, Van, DTN, DTB (
	không dùng trường thấp nhất đã làm ở câu 7)
*/
create function dtn(@mahs nvarchar(5))
returns float as
begin 
	declare @toan float, @ly float, @hoa float, @van float, @dtn float
	select @toan = TOAN, @ly = LY, @hoa = HOA, @van = VAN from DIEM where MAHS = @mahs
	if(@toan <= @ly and @toan <= @hoa and  @toan <= @van) set @dtn = @toan
	if(@ly <= @toan and @ly <= @hoa and  @ly <= @van) set @dtn = @ly
	if(@hoa <= @toan and @hoa <= @ly and  @hoa <= @van) set @dtn = @hoa
	if(@van <= @toan and @van <= @hoa and  @van <= @ly) set @dtn = @van
	return @dtn
end

create view SX1
as 
	select 
	L.LOP, DS.MAHS, DS.HO +' '+ DS.TEN as HoTen,
	YEAR(DS.NGAYSINH) as NamSinh, DS.NU, D.TOAN, D.LY, D.HOA, D.VAN,
	ROUND(((D.TOAN+D.VAN)*2 + D.LY + D.HOA)/6,2) as DTB,
	dbo.dtn(D.MAHS) as DTN
	from LOP as L inner join DSHS as DS on L.LOP = DS.LOP
						inner join DIEM as D on D.MAHS = DS.MAHS
	where ROUND(((D.TOAN+D.VAN)*2 + D.LY + D.HOA)/6,2) >= 8.5 and
		dbo.dtn(D.MAHS) >=8

--select * from SX1

/*
	11.Tạo View danh sách HOC SINH DAT THU KHOA KY THI bao gồm 
	các học sinh xuất sắc có DTB lớn nhất với các trường:
	Lop, Mahs, Hoten, Namsinh, Nu, Toan, Ly, Hoa, Van, DTB
*/
Go
create function dtb()
returns Table 
as
	return (
		select TOP(1) ROUND(((TOAN+VAN)*2 + LY + HOA)/6,2) as DTB from DIEM
		Order by DTB DESC
	)

Go

create view SX
as 
	select 
	L.LOP, DS.MAHS, DS.HO +' '+ DS.TEN as HoTen,
	DS.NGAYSINH, DS.NU, D.TOAN, D.LY, D.HOA, D.VAN,
	ROUND(((D.TOAN+D.VAN)*2 + D.LY + D.HOA)/6,2) as DTB
	from LOP as L inner join DSHS as DS on L.LOP = DS.LOP
						inner join DIEM as D on D.MAHS = DS.MAHS, dtb()
	where dtb.DTB = ROUND(((D.TOAN+D.VAN)*2 + D.LY + D.HOA)/6,2).

--select * from SX






---------------------------------------------------bài 2--------------------------------------------
/*
	1.	Tạo View gồm các field sau: MaDK, LoaiKH, TenKH,NgaySinh,
	Phai, DiaChi, DienThoai, SoPhong, LoaiPhong, NgayVao, SoNgayO.
	Trong đó Số Ngày ở = Ngày Ra – Ngày Vao

*/
USE BT2_BTN12
Go
Create view tracuuKH
as
select CTK.MaDK, CTK.LoaiKH, CTK.TenKH, CTK.NgaySinh,
	CTK.Phai, CTK.DiaChi, CTK.DienThoai, DK.SoPhong,
	DK.LoaiPhong, DK.NgayVao, DATEDIFF(DD,DK.NgayVao, DK.NgayRa) as NgayO 
from tChiTietKH CTK inner join tDangKy DK on CTK.MaDK = DK.MaDK 


--select *from tracuuKH



/*
	2.	Viết hàm có mã nhập vào là ngày vào trong năm 1999 
	và thông tin đưa ra như câu 1
*/
Go
create function nhucau1(@ngay datetime)
returns table 
as
	return(
		select CTK.MaDK, CTK.LoaiKH, CTK.TenKH, CTK.NgaySinh,
	CTK.Phai, CTK.DiaChi, CTK.DienThoai, DK.SoPhong,
	DK.LoaiPhong, DK.NgayVao, DATEDIFF(DD,DK.NgayVao, DK.NgayRa) as NgayO 
from tChiTietKH CTK inner join tDangKy DK on CTK.MaDK = DK.MaDK where DK.NgayVao = @ngay
		)

Go
--select *from dbo.nhucau1('07/01/1999')



/*
	3.Viết truy vấn tạo bảng doanh thu (tDoanhThu) gồm các trường 
*/
Go
create TABLE tDoanhThu(
	[MaDK] [nvarchar](3) PRIMARY KEY NOT NULL,
	[LoaiPhong] [nvarchar](2) NULL,
	[SoNgayO] [int] NULL,
	[ThucThu] [money] NULL
)


/*
	4.	Tạo Trigger tính tiền và điền tự động vào bảng tDoanhThu như sau: 
	Các trường lấy thông tin từ các bảng và các thông tin sau:
Trong đó:
(a)	Số Ngày Ở= Ngày Ra – Ngày Vào
(b)	ThucThu: Tính theo yêu cầu sau:
Nếu Số Ngày ở <10 Thành tiền = Đơn Giá * Số ngày ở
Nếu 10 <=Số Ngày ở <30 Thành Tiền = Đơn Giá* Số Ngày ở * 0.95 (Giảm5%) 
Nếu Số ngày ở >= 30 Thành Tiền = Đơn Giá* Số Ngày ở * 0.9 (Giảm10%)
*/
Go
alter trigger dienDoanThu on tDangKy for insert, update 
as
begin
	declare @madk nvarchar(3), @ngayo float, @thanhtien float
	select @ngayo=DATEDIFF(DD,NgayVao,NgayRa), @madk=MaDK from inserted
   
	if @ngayo<10 
		select @thanhtien=DonGia*@ngayo from 
		tLoaiPhong inner join inserted on tLoaiPhong.LoaiPhong =inserted.LoaiPhong
	else if 10 <= @ngayo and @ngayo < 30  
		select @thanhtien=DonGia*@ngayo*0.95 from 
		tLoaiPhong inner join inserted on tLoaiPhong.LoaiPhong=inserted.LoaiPhong
	else 
		select @thanhtien=DonGia*@ngayo*0.9 from 
		tLoaiPhong inner join inserted ON tLoaiPhong.LoaiPhong=inserted.LoaiPhong
	
	UPDATE tDoanhThu SET SoNgayO=@ngayo, ThucThu=@thanhtien where MaDK=@madk
end


--select*from tDoanhThu
--select*from tDangKy
--update tDangKy set LoaiPhong = 'B' where MaDK = '002' select*from tDangKy  select*from tDoanhThu



--LeQuangThor_Cntt1_K59