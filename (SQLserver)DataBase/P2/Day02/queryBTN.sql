-- câu 7

create view BaoCao as
select dshs.MAHS, HO+' '+TEN as hoten, NGAYSINH, iif(nu=1, N'Nữ', 'Nam') as GioiTinh, toan, ly, hoa, van, round((toan*2+van*2+ly+hoa)/6,1) as DTB, iif((toan*2+van*2+ly+hoa)/6>5, N'Lên lớp', N'Lưu ban') as XepLoai
from DSHS, DIEM
where DSHS.MAHS=DIEM.MAHS

select * from BaoCao

--Câu 10 tạo view danh sách học sinh xuất sắc

create view HSXS as
select DSHS.MAHS, HO+' '+TEN as hoten, year(NGAYSINH) as NamSinh, iif(nu=1, N'Nữ') as GioiTinh, toan, ly, hoa, van, round((toan*2+van*2+ly+hoa)/6,1) as DTB,
case 
when TOAN<LY and TOAN<HOA and TOAN< VAN then TOAN
when LY<TOAN and LY<HOA and LY< VAN then LY
when HOA<LY and HOA<TOAN and HOA< VAN then HOA
when VAN<LY and VAN<TOAN and VAN< HOA then VAN
end as DTN
from DSHS, DIEM
where DSHS.MAHS=DIEM.MAHS


select * from HSXS 