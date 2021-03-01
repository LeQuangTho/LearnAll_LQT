alter trigger autochuyentruong on DSHS 
instead of delete as
begin
declare @mahs nvarchar(5)
select @mahs = MAHS from deleted
update DSHS set Ghichu = N'Chuyển trường ' + CONVERT(nvarchar,GETDATE()) where MAHS = @mahs
end 

select * from DSHS

delete from DSHS where MAHS = '00001'