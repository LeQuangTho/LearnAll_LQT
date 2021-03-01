/*Declare hs cursor for select mahs from DSHS
Open hs
Declare @mahs nvarchar(5), @dtb float
Fetch next from hs into @mahs
While (@@FETCH_STATUS = 0)
begin 
select @dtb = ROUND((toan*2+van*2+hoa + hoa)/6,2) from DIEM where 
MAHS = @mahs
update DSHS set dtbc = @dtb where MAHS = @mahs
Fetch next from hs into @mahs
end
Close hs; Deallocate hs

select * from DSHS
 thêm trường xếp loại học sinh nếu điểm Tb >=8 & >6.5
>7 &>5 khá
còn lại là trung bình 




-------------------xếp loại học lực

Declare hs cursor for select mahs from DSHS
open hs
Declare @mahs nvarchar(5), @dtb float, @dtn float
Fetch next from hs into @mahs
While (@@FETCH_STATUS = 0)
begin 
declare @toan float, @van float, @hoa float, @ly float
	select @toan = toan, @van = van, @hoa = hoa, @ly = van from DIEM where MAHS = @mahs
	set @dtn = @toan
	if @dtn > @hoa set @dtn = @hoa
	if @dtn > @van set @dtn = @van
	if @dtn > @ly set @dtn = @ly
select @dtb = dtbc from DSHS where MAHS = @mahs
if @dtb >= 8 and @dtn >=6.5
Update DSHS set XEPLOAI = N'Giỏi' where MAHS = @mahs
else if @dtb >= 7 and @dtn >=5
Update DSHS set XEPLOAI = N'Khá' where MAHS = @mahs
else Update DSHS set XEPLOAI = N'Trung Bình' where MAHS = @mahs
Fetch next from hs into @mahs
end
Close hs; Deallocate hs

select * from DSHS

*/




-------------giáo viên chủ nhiệm
--alter table DSHS
--add GVCN nvarchar(50)
Declare hs cursor for select MAHS,LOP from DSHS
open hs
Declare @lop nvarchar(4), @gvcn nvarchar(25),@mahs nvarchar(5)
Fetch next from hs into @mahs,@lop
While (@@FETCH_STATUS = 0)
begin
	select @gvcn = GVCN from LOP where LOP = @lop
	Update DSHS set GVCN = @gvcn where MAHS = @mahs
	Fetch next from hs into @mahs,@lop
end
Close hs; Deallocate hs
select * from DSHS