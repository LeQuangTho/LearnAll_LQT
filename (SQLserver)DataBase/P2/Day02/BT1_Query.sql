create view KHVip as
select a.MaKH, TenKH, DiaChi, DienThoai from tKhachHang a
inner join tHoaDonBan b on a.MaKH = b.SoHDB
inner join tChiTietHDB c on b.SoHDB = c.SoHDB
inner join tSach d on c.MaSach = d.MaSach
group by a.MaKH, TenKH, DiaChi, DienThoai
having SUM(SLBan*DonGiaBan) >= 2000000

select * from KHVip


/* tạo view cho doanh thu năm  tháng 5/2014 */

create view doanhthuthanh5
as
select sum(tSach.DonGiaBan*tChiTietHDB.SLBan)  as doanhthu from tSach
inner join tChiTietHDB on tSach.MaSach = tChiTietHDB.MaSach
inner join tHoaDonBan on tChiTietHDB.SoHDB = tHoaDonBan.SoHDB
where month(tHoaDonBan.NgayBan) = 5 and year(tHoaDonBan.NgayBan) = 2014

select * from doanhthuthanh5

/* tạo view cho doanh thu năm  tháng cho từng tháng trong năm 2014*/
-- bài của duy
create view DoanhThu_2014 as
select MONTH(c.NgayBan), sum(a.SLBan*b.DonGiaBan) as doanhthu from dbo.tChiTietHDB a 
inner join dbo.tSach b on a.MaSach=b.MaSach 
inner join dbo.tHoaDonBan c on a.SoHDB = c.SoHDB
where YEAR(c.NgayBan) = 2014 group by MONTH(c.NgayBan)

-- thử select case
select MaSach, TenSach,
case
when SoTrang >=100 then N'Sách Dày'
when SoTrang <100 then N'Sách Mỏng'
end as phanloai
from tSach

create view doanhthu as
select
isnull(sum(case month (NgayBan) when 1 then (SLBan*DonGiaBan) end),0) as Thang1,
isnull(sum(case month (NgayBan) when 2 then (SLBan*DonGiaBan) end),0) as Thang2,
isnull(sum(case month (NgayBan) when 3 then (SLBan*DonGiaBan) end),0) as Thang3,
isnull(sum(case month (NgayBan) when 4 then (SLBan*DonGiaBan) end),0) as Thang4,
isnull(sum(case month (NgayBan) when 5 then (SLBan*DonGiaBan) end),0) as Thang5,
isnull(sum(case month (NgayBan) when 6 then (SLBan*DonGiaBan) end),0) as Thang6,
isnull(sum(case month (NgayBan) when 7 then (SLBan*DonGiaBan) end),0) as Thang7,
isnull(sum(case month (NgayBan) when 8 then (SLBan*DonGiaBan) end),0) as Thang8,
isnull(sum(case month (NgayBan) when 9 then (SLBan*DonGiaBan) end),0) as Thang9,
isnull(sum(case month (NgayBan) when 10 then (SLBan*DonGiaBan) end),0) as Thang10,
isnull(sum(case month (NgayBan) when 11 then (SLBan*DonGiaBan) end),0) as Thang11,
isnull(sum(case month (NgayBan) when 12 then (SLBan*DonGiaBan) end),0) as Thang12,
isnull(sum(SLBan*DonGiaBan),0) as Canam
from tChiTietHDB as ct
join tHoaDonBan as hd on hd.SoHDB=ct.SoHDB join tSach as s on s.MaSach=ct.MaSach
where year(hd.NgayBan)=2014

select *from doanhthu