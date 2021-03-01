use BT1_loginView

GO

alter trigger dgb on tChiTietHDB for insert,update as
begin 
	declare @masach nvarchar(10), @giaban money, @slban int, @khuyenmai int
	select @masach = MaSach, @slban = SLBan, @khuyenmai = KhuyenMai from inserted
	select @giaban = DonGiaBan from tSach 
	update tChiTietHDB set GiaBan = (select DonGiaBan from tSach where MaSach = @masach) 

end

update tChiTietHDB set GiaBan = 100000 where MaSach = 'S01'
select * from tSach
select * from tChiTietHDB