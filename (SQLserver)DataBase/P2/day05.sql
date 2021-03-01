alter table [DIEM] add diemthapnhat float

create trigger diemthapnhat1 on Diem for insert , update As
begin 
	declare @dtn float, @mahs nvarchar(5), @toan float, @van float, @hoa float, @ly float
	select @toan = toan, @van = van, @hoa = hoa, @ly = van from inserted
	set @dtn = @toan
	if @dtn > @hoa set @dtn = @hoa
	if @dtn > @van set @dtn = @van
	if @dtn > @ly set @dtn = @ly
	select @mahs = MAHS from inserted 
	update Diem set diemthapnhat = @dtn where MAHS = @mahs
end

update DIEM set TOAN = 9.5 where MAHS = '00980'

select *from DIEM


create function DTB(@mahs nvarchar(5))
returns float 
as
begin
	declare @dtb float
	select @dtb = ROUND((toan*2+van*2+hoa + hoa)/6,2) from DIEM where MAHS = @mahs
	return @dtb
end