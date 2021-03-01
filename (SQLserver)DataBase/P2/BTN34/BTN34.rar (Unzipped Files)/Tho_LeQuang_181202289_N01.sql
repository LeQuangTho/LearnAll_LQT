---------------------bài tập 3-----------------------------------
USE [BT3]

GO
/*
1. Tạo cơ sở dữ liệu trên, với các khóa chính như sau:
ChiTietVanTai là MaVT, TrongTai là MaTrongTai, LoTrinh là MaLoTrinh 
*/

ALTER TABLE ChiTietVanTai
 ADD CONSTRAINT MaVT_pk PRIMARY KEY (MaVT);
 
 Go

 ALTER TABLE TrongTai
 ADD CONSTRAINT MaTrongTai_pk PRIMARY KEY (MaTrongTai);

Go

 ALTER TABLE LoTrinh
 ADD CONSTRAINT MaLoTrinh_pk PRIMARY KEY (MaLoTrinh);

 GO
/*
	2. Tạo view gồm các trường SoXe, MaLoTrinh, SoLuongVT, NgayDi, NgayDen,
ThoiGianVT, CuocPhi, Thuong. Trong đó:
• ThoiGianVT: là 1 nếu vận chuyển trong ngày, là (NgayDen-NgayDi) trong trường hợp
ngược lại.
• CuocPhi: là SoLuongVT x DonGia x 105% nếu SoLuongVT nhiều hơn TrongTaiQD, là
SoLuongVT x DonGia trong trường hợp ngược lại.
• Thuong: là 5% của CuocPhi nếu ThoiGianVT vuot ThoiGianQD, là 0 trong trường hợp
ngược lại.
*/ 
CREATE VIEW CAU2 
AS
SELECT CTVT.SoXe,CTVT.MaLoTrinh, CTVT.SoLuongVT,CTVT.NgayDi, CTVT.NgayDen,
		IIF(DATEDIFF(DAY, NgayDi, NgayDen) = 0, 1, DATEDIFF(DAY, NgayDi, NgayDen)) AS ThoiGianVT,
		IIF(SoLuongVT > TT.TrongTaiQD, CTVT.SoLuongVT * LT.DonGia * 1.05, CTVT.SoLuongVT * LT.DonGia) AS CuocPhi,
		IIF(DATEDIFF(DAY, NgayDi, NgayDen) > LT.ThoiGianQD, IIF(SoLuongVT > TT.TrongTaiQD, CTVT.SoLuongVT * LT.DonGia * 1.05, CTVT.SoLuongVT * LT.DonGia)*0.05, 0) AS Thuong
FROM ChiTietVanTai CTVT INNER JOIN LoTrinh LT ON CTVT.MaLoTrinh = LT.MaLoTrinh
						INNER JOIN TrongTai TT ON CTVT.MaTrongTai = TT.MaTrongTai
 GO
 --test
--select *from CAU2
/*
3. Tạo view để lập bảng cước phí gồm các trường SoXe, TenLoTrinh, SoLuongVT, NgayDi,
NgayDen, CuocPhi.
*/
CREATE VIEW CUOCPHI 
AS
SELECT SoXe, TenLoTrinh, SoLuongVT,NgayDi, NgayDen, CuocPhi
FROM CAU2 C2 INNER JOIN LoTrinh LT ON C2.MaLoTrinh = LT.MaLoTrinh
 GO

 
--test
--select *from CUOCPHI
/*
4. Tạo view danh sách các xe có có SoLuongVT vượt trọng tải qui định, gồm các trường
SoXe, TenLoTrinh, SoLuongVT, TronTaiQD, NgayDi, NgayDen.
*/
CREATE VIEW VUOTTRONGTAI 
AS
SELECT CTVT.SoXe,LT.TenLoTrinh, CTVT.SoLuongVT,TT.TrongTaiQD, CTVT.NgayDi, CTVT.NgayDen
FROM ChiTietVanTai CTVT INNER JOIN LoTrinh LT ON CTVT.MaLoTrinh = LT.MaLoTrinh
						INNER JOIN TrongTai TT ON CTVT.MaTrongTai = TT.MaTrongTai
WHERE CTVT.SoLuongVT > TT.TrongTaiQD

 GO

 --test
--select *from VUOTTRONGTAI
/*
5. Tạo hàm có đầu vào là lộ trình, đầu ra là số xe, mã trọng tải, số lượng vận tải, ngày đi, ngày
đến (SoXe, MaTrongTai, SoLuongVT, NgayDi, NgayDen.)
*/
CREATE FUNCTION CAU5 (@lotrinh nvarchar(255))
returns TABLE
as
	return(
	SELECT CTVT.SoXe, TT.MaTrongTai, CTVT.SoLuongVT, CTVT.NgayDi, CTVT.NgayDen
	FROM ChiTietVanTai CTVT INNER JOIN LoTrinh LT ON CTVT.MaLoTrinh = LT.MaLoTrinh
						INNER JOIN TrongTai TT ON CTVT.MaTrongTai = TT.MaTrongTai
						WHERE LT.MaLoTrinh = @lotrinh
	)

 GO
 
--test
 --SELECT * FROM dbo.CAU5('HN')
/*
6. Thiết lập hàm có đầu vào là số xe, đầu ra là thông tin về lộ trình
*/
CREATE FUNCTION CAU6 (@soxe nvarchar(255))
returns TABLE
as
	return(
	SELECT LT.MaLoTrinh, LT.TenLoTrinh, LT.DonGia, LT.ThoiGianQD FROM ChiTietVanTai CTVT INNER JOIN LoTrinh LT ON CTVT.MaLoTrinh = LT.MaLoTrinh
	WHERE CTVT.SoXe = @soxe	
	)

--test
--SELECT * FROM dbo.CAU6('333')
 GO
/*
7. Thêm trường Thành tiền vào bảng chi tiết vận tải và tạo trigger điền dữ liệu cho trường này
biết:
Thành tiền = là SoLuongVT x DonGia x 105% nếu SoLuongVT nhiều hơn TrongTaiQD, là
SoLuongVT x DonGia trong trường hợp ngược lại

*/
ALTER TABLE ChiTietVanTai ADD ThanhTien INT;

GO

CREATE TRIGGER tt ON ChiTietVanTai  for insert, update
as
begin
declare @soluongvt int, @trongtaiqd int,@dongia int, @cuoc int, @mavt nvarchar(255), @matt nvarchar(255),@malt nvarchar(255)
select @mavt = MaVT from inserted
select @matt = MaTrongTai from inserted
select @malt = MaLoTrinh from inserted
select @soluongvt = SoLuongVT from inserted
select @trongtaiqd = TrongTaiQD from TrongTai where MaTrongTai = @matt 
select @dongia = DonGia from LoTrinh where MaLoTrinh = @malt
	if (@soluongvt> @trongtaiqd)  set @cuoc = @soluongvt * @dongia * 1.05
	else set @cuoc = @soluongvt * @dongia

	update ChiTietVanTai set ThanhTien = @cuoc where MaVT = @mavt
end

--test
--insert into ChiTietVanTai values('11','333','50','PK','5','11-28-2020','11-29-2020','')
--select *from ChiTietVanTai
GO

/*
8. Tạo thủ tục có đầu vào là mã lộ trình, năm vận tải, đầu ra là số tiền theo mã lộ trình đó
*/
create proc tien @malt nvarchar(255), @namvt int, @cuoc int output
as
begin 
	declare t cursor for select MaVT,MaTrongTai,MaLoTrinh,NgayDi from ChiTietVanTai
	open t 
	declare @mavt nvarchar(255), @nam datetime, @matt nvarchar(255),@malt2 nvarchar(255)
	Fetch next from t into @mavt, @matt, @malt2 ,@nam
	while(@@FETCH_STATUS = 0)
	begin
		declare @soluongvt int, @trongtaiqd int,@dongia int
		select @soluongvt = SoLuongVT from ChiTietVanTai where MaVT = @mavt
		select @trongtaiqd = TrongTaiQD from TrongTai tt inner join ChiTietVanTai ct on tt.MaTrongTai = ct.MaTrongTai 
		where ct.MaTrongTai = @matt 
		select @dongia = DonGia from LoTrinh lt inner join ChiTietVanTai ct on lt.MaLoTrinh = ct.MaLoTrinh
		where lt.MaLoTrinh = @malt2
		if (YEAR(@nam) = @namvt and @malt = @malt2)
			if (@soluongvt> @trongtaiqd)  set @cuoc =@cuoc + @soluongvt * @dongia * 1.05
			else set @cuoc =@cuoc + @soluongvt * @dongia
		--print @malt 
		Fetch next from t into @mavt, @matt, @malt2 ,@nam
	end 
	CLOSE t      
	DEALLOCATE t 
end

--test
--declare @tien int 
--set @tien =0
--exec tien 'HN','2014', @tien output
--print @tien

select * from ChiTietVanTai
GO
/*
9. Tạo thủ tục có đầu vào là số xe, năm vận tải, đầu ra là số tiền theo mã lộ trình đó
*/
alter proc tien2 @sx nvarchar(255), @namvt int, @cuoc int output
as
begin 
	declare t cursor for select MaVT, SoXe,MaTrongTai,MaLoTrinh,NgayDi from ChiTietVanTai
	open t 
	declare @sx2 nvarchar(255), @mavt nvarchar(255), @nam datetime, @matt nvarchar(255),@malt2 nvarchar(255)
	Fetch next from t into @mavt, @sx2, @matt, @malt2 ,@nam
	while(@@FETCH_STATUS = 0)
	begin
		declare @soluongvt int, @trongtaiqd int,@dongia int
		select @soluongvt = SoLuongVT from ChiTietVanTai where MaVT = @mavt
		select @trongtaiqd = TrongTaiQD from TrongTai tt inner join ChiTietVanTai ct on tt.MaTrongTai = ct.MaTrongTai
		where ct.MaTrongTai = @matt 
		select @dongia = DonGia from LoTrinh lt inner join ChiTietVanTai ct on lt.MaLoTrinh = ct.MaLoTrinh
		where lt.MaLoTrinh = @malt2
		if (YEAR(@nam) = @namvt and @sx = @sx2)
			if (@soluongvt> @trongtaiqd)  set @cuoc =@cuoc + @soluongvt * @dongia * 1.05
			else set @cuoc =@cuoc + @soluongvt * @dongia
		--print @malt 
		Fetch next from t into @mavt,@sx2, @matt, @malt2 ,@nam
	end 
	CLOSE t      
	DEALLOCATE t 
end

--test
--declare @tien int 
--set @tien =0
--exec tien2 '333','2014', @tien output
--print @tien



--------------------------------------Bài Tập 4-----------------------------------
GO

USE [BT4]

GO
/*
1.	Tạo view KET QUA chứa kết quả thi của từng học sinh bao gồm các thông tin: SoBD, HoTen, Phai, Tuoi, Toan, Van, AnhVan, TongDiem, XepLoai, DTDuThi
Biết rằng: TongDiem = Toan + Van + AnhVan + DiemUT XepLoai học sinh như sau:
*	Giỏi nếu TongDiem>=24 và tất cả các môn >=7
*	Khá nếu TongDiem>=21 và tất cả các môn >=6
*	Trung Bình nếu TongDiem>=15 và tất cả các môn >=4
*	Trượt nếu ngược lại
*/

GO
CREATE VIEW KET_QUA
AS
select DS.SoBD, CONCAT(DS.Ho,' ', DS.Ten) as HoTen, DS.Phai, DATEDIFF(YEAR, DS.NTNS, GETDATE()) as Tuoi,
		DT.Toan, DT.Van, DT.AnhVan,
		(DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT ) as TongDiem,
		IIF(DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT >= 24, 
		IIF(DT.Toan >= 7 and DT.Van >=7 and DT.AnhVan >= 7,N'Giỏi',N'Khá'),
		IIF(DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT >= 21,
		IIF(DT.Toan >= 6 and DT.Van >=6 and DT.AnhVan >= 6,N'Khá',N'Trung Bình'), 
		IIF(DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT >= 15,
		IIF(DT.Toan >= 6 and DT.Van >=6 and DT.AnhVan >= 6,
		N'Trung Bình',N'Trượt'),N'Trượt'))) AS XepLoai,
		DS.DTDuThi
from 
ChiTietDT CT inner join DanhSach DS on DS.DTDuThi = CT.DTDuThi
			inner join DiemThi DT on DT.SoBD = DS.SoBD

GO


--test
--select * from KET_QUA
/*
2.	Tạo view GIOI TOAN – VAN – ANH VAN bao gồm các học sinh có ít nhất 1 môn 10 và có TongDiem>=25 bao gồm các thông tin: SoBD, HoTen, Toan, Van, AnhVan, TongDiem, DienGiaiDT
*/

CREATE VIEW GIOI
AS
select DS.SoBD, CONCAT(DS.Ho,' ', DS.Ten) as HoTen,
		DT.Toan, DT.Van, DT.AnhVan, (DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT ) as TongDiem,
		CT.DienGiaiDT
from 
ChiTietDT CT inner join DanhSach DS on DS.DTDuThi = CT.DTDuThi
			inner join DiemThi DT on DT.SoBD = DS.SoBD
where (DT.Toan =10 or DT.Van = 10 or DT.AnhVan = 10) and (DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT ) >= 25


--test
--select * from GIOI
GO
/*
3.	Tạo view DANH SACH DAU (ĐẬU) gồm các học sinh có XepLoai là Giỏi, Khá hoặc Trung Bình với các field: SoBD, HoTen, Phai, Tuoi, Toan, Van, AnhVan, TongDiem, XepLoai, DTDuThi
*/
CREATE VIEW DAU
AS
select DS.SoBD, CONCAT(DS.Ho,' ', DS.Ten) as HoTen, DS.Phai, DATEDIFF(YEAR, DS.NTNS, GETDATE()) as Tuoi,
		DT.Toan, DT.Van, DT.AnhVan,
		(DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT ) as TongDiem,
		IIF(DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT >= 24, 
		IIF(DT.Toan >= 7 and DT.Van >=7 and DT.AnhVan >= 7,N'Giỏi',N'Khá'),
		IIF(DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT >= 21,
		IIF(DT.Toan >= 6 and DT.Van >=6 and DT.AnhVan >= 6,N'Khá',N'Trung Bình'), 
		IIF(DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT >= 15,
		IIF(DT.Toan >= 6 and DT.Van >=6 and DT.AnhVan >= 6,
		N'Trung Bình',N'Trượt'),N'Trượt'))) AS XepLoai,
		DS.DTDuThi
from 
ChiTietDT CT inner join DanhSach DS on DS.DTDuThi = CT.DTDuThi
			inner join DiemThi DT on DT.SoBD = DS.SoBD
where (DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT ) >= 15 and(DT.Toan >= 6 and DT.Van >=6 and DT.AnhVan >= 6)

--test
--select * from DAU


GO
/*
4.	Tạo view HOC SINH DAT THU KHOA KY THI bao gồm các học sinh “ĐẬU” có TongDiem lớn nhất với các field: SoBD, HoTen, Phai, Tuoi, Toan, Van, AnhVan, TongDiem, DienGiaiDT
*/
Go
CREATE FUNCTION mymax() returns table 
AS
return( 
	select top(1) (DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT ) as TongDiem
	from 
		ChiTietDT CT inner join DanhSach DS on DS.DTDuThi = CT.DTDuThi
		inner join DiemThi DT on DT.SoBD = DS.SoBD
		where (DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT ) >= 15 and(DT.Toan >= 6 and DT.Van >=6 and DT.AnhVan >= 6)
		ORDER BY TongDiem DESC
		)

GO
CREATE VIEW THU_KHOA
as
select DS.SoBD, CONCAT(DS.Ho,' ', DS.Ten) as HoTen, DS.Phai, DATEDIFF(YEAR, DS.NTNS, GETDATE()) as Tuoi,
		DT.Toan, DT.Van, DT.AnhVan,
		(DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT ) as TongDiem,
		IIF(DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT >= 24, 
		IIF(DT.Toan >= 7 and DT.Van >=7 and DT.AnhVan >= 7,N'Giỏi',N'Khá'),
		IIF(DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT >= 21,
		IIF(DT.Toan >= 6 and DT.Van >=6 and DT.AnhVan >= 6,N'Khá',N'Trung Bình'), 
		IIF(DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT >= 15,
		IIF(DT.Toan >= 6 and DT.Van >=6 and DT.AnhVan >= 6,
		N'Trung Bình',N'Trượt'),N'Trượt'))) AS XepLoai,
		DS.DTDuThi
from 
ChiTietDT CT inner join DanhSach DS on DS.DTDuThi = CT.DTDuThi
			inner join DiemThi DT on DT.SoBD = DS.SoBD, dbo.mymax() m
where (DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT ) >= 15 and(DT.Toan >= 6 and DT.Van >=6 and DT.AnhVan >= 6) and m.TongDiem = (DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT )

--test
--select * from THU_KHOA
GO
/*
5.	Tạo thủ tục có đầu vào là số báo danh, đầu ra là các điểm thi, điểm ưu tiên và tổng điểm
*/
alter proc CAU5 @sbd int, @toan float, @van float, @anhvan float, @dut int,@tong float output
as
begin
	select @toan = DT.Toan from ChiTietDT CT inner join DanhSach DS on DS.DTDuThi = CT.DTDuThi
			inner join DiemThi DT on DT.SoBD = DS.SoBD 
	where @sbd = DS.SoBD
	select @van = DT.Van from ChiTietDT CT inner join DanhSach DS on DS.DTDuThi = CT.DTDuThi
			inner join DiemThi DT on DT.SoBD = DS.SoBD 
	where @sbd = DS.SoBD
	select @anhvan = DT.AnhVan from ChiTietDT CT inner join DanhSach DS on DS.DTDuThi = CT.DTDuThi
			inner join DiemThi DT on DT.SoBD = DS.SoBD 
	where @sbd = DS.SoBD
	select @dut = CT.DiemUT from ChiTietDT CT inner join DanhSach DS on DS.DTDuThi = CT.DTDuThi
			inner join DiemThi DT on DT.SoBD = DS.SoBD 
	where @sbd = DS.SoBD
	select @tong = (DT.Toan + DT.Van + DT.AnhVan + CT.DiemUT )
	from ChiTietDT CT inner join DanhSach DS on DS.DTDuThi = CT.DTDuThi
			inner join DiemThi DT on DT.SoBD = DS.SoBD 
	where @sbd = DS.SoBD
end

GO
declare @toan float, @van float, @anhvan float, @dut int,@tong float
exec CAU5 '1',@toan ,@van, @anhvan, @dut, @tong output
print @toan 
print @van 
print @anhvan 
print @dut 
print @tong 

GO
/*
6.	Tạo trigger kiểm tra xem việc nhập mã đối tượng dự thi trong bảng danh sách có đúng với bảng đối tượng dự thi không
*/
CREATE TRIGGER CAU6 ON DanhSach INSTEAD OF UPDATE, INSERT AS
BEGIN
	DECLARE @sobd int, @var int, @dtduthi tinyint, @isUpdate int
	SELECT @dtduthi = DTDuThi, @sobd = SoBD FROM inserted
	SELECT @isUpdate = COUNT(SoBD) FROM DanhSach WHERE @sobd = SoBD
	SELECT @var = COUNT(DTDuThi) FROM ChiTietDT WHERE @dtduthi = DTDuThi
	IF(@var = 0)
		BEGIN
			DECLARE @ErrorMessage VARCHAR(2000)
			SELECT @ErrorMessage = 'DTDuThi ko có trong ChiTietDT'
			RAISERROR(@ErrorMessage, 16, 1)
		END
	ELSE
		BEGIN
			DECLARE @ho nvarchar(15), @ten nvarchar(7) , @phai bit, @ntns datetime
			SELECT @ho = Ho, @ten = Ten, @phai = Phai, @ntns = NTNS, @dtduthi = DTDuThi FROM inserted
			IF(@isUpdate = 1)
				BEGIN
					UPDATE DanhSach SET  Ho = @ho, Ten = @ten, Phai = @phai, NTNS = @ntns, DTDuThi = @dtduthi WHERE SoBD = @sobd
				END
			ELSE
				BEGIN
					INSERT [dbo].[DanhSach] ([SoBD], [Ho], [Ten], [Phai], [NTNS], [DTDuThi]) VALUES (@sobd, @ho, @ten, 1, CAST(@ntns AS DateTime), @dtduthi)
				END
		END
END



GO
/*
7.	Thêm trường điểm ưu tiên và tổng điểm vào bảng Điểm thi. Tạo trigger cập nhật tự động trường ưu tiên và tổng điểm mỗi khi nhập hay chỉnh sửa
*/
alter table DiemThi 
add DiemUT tinyint
alter table DiemThi
add TongDiem float

GO
CREATE TRIGGER CAU7 ON DiemThi FOR insert, update 
as
begin
	declare @sbd int, @toan float, @van float, @av float, @dut int
	select @sbd = SoBD FROM inserted
	select @toan =  Toan FROM inserted
	select @van =  Toan FROM inserted
	select @av =  Toan FROM inserted
	select @dut = DiemUT from ChiTietDT CT inner join DanhSach DS on CT.DTDuThi = DS.DTDuThi WHERE SoBD = @sbd
	
	Update DiemThi set DiemUT = @dut where SoBD = @sbd
	Update DiemThi set TongDiem = (@toan + @van + @av + @dut) where SoBD = @sbd
end

--test
--update DiemThi set Toan = 10 where SoBD = 1


GO
/*
8.	Tạo trigger xóa tự động bản ghi tương ứng ở bảng điểm khi xóa bản ghi ở danh sách
*/
Create TRIGGER CAU8 ON DanhSach INSTEAD OF DELETE AS
BEGIN
	declare @sobd int
	select @sobd = SoBD from deleted
	DELETE DiemThi WHERE SoBD = @sobd
	DELETE DanhSach WHERE SoBD = @sobd
END

--test
--insert into DanhSach values ('157','a','a','True','1-1-2000','1')
--insert into DiemThi values ('157','1','1','1')
--delete DanhSach where SoBD = '157'