/**********************************/
/*create proc dtb (@mahs nvarchar(5), @dtb float output)
as begin
	select @dtb = (toan*2+ van*2 + hoa + ly)/6 from DIEM where MAHS = @mahs
end

declare @tb float
exec dtb '00020',@tb output
print @tb
*/
create proc dtn (@mahs nvarchar(5), @dtn float output)
as begin
	declare @toan float, @van float, @hoa float, @ly float
	select @toan = toan, @van = van, @hoa = hoa, @ly = van from DIEM where MAHS = @mahs
	set @dtn = @toan
	if @dtn > @hoa set @dtn = @hoa
	if @dtn > @van set @dtn = @van
	if @dtn > @ly set @dtn = @ly
end

declare @tn float
exec dtn'00020',@tn output
print @tn

--bài 1
alter table DSHS
add Ghi_chu nvarchar(100);

create proc add_chu_thich (@mahs nvarchar(5)) as 
begin 
	update DSHS set Ghi_chu = N' Chuyển trường từ ngày 5/9/2016' where @mahs = MAHS
end

exec add_chu_thich '00001'


--bài 2
create proc si_so (@mslop nvarchar(4), @s int out) as
begin
	select @s = COUNT(MAHS) from DSHS where @mslop = LOP
end

declare @res int 
exec si_so '10A5', @res out
print @res

--bài 4
create procedure lopgv(@mahs nvarchar(5), @lop nvarchar(4) out, @gv nvarchar(25) out) as
begin
select @lop = LOP.LOP,@gv = GVCN from DSHS, LOP
where LOP.LOP = DSHS.LOP and MAHS =@lop
end 

declare @lophs nvarchar(4), @gvcn nvarchar(25)
exec lopgv '00211', @lophs output, @gvcn out 
print @lophs + ' ' + @gvcn