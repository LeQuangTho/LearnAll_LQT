SELECT        HD.TongTien, HD.ID_HoaDon, TS.TenTraSua, CTHD.SoLuong, TS.DonGiaTraSua,
				(CTHD.SoLuong * TS.DonGiaTraSua) * (1 - V.PhanTram) AS ThanhTien,
				KH.TenKhachHang, HD.UserName, HD.TongTien / (1 - V.PhanTram) AS NguyenGia, 
				V.TenVoucher, TP.TenTopping, TTP.SoLuong AS SLTP, TP.DonGiaTopping, 
				(TTP.SoLuong * TP.DonGiaTopping) * (1 - V.PhanTram) AS ThanhTienTP
FROM            HoaDon AS HD INNER JOIN
                         ChiTietHoaDon AS CTHD ON CTHD.ID_HoaDon = HD.ID_HoaDon INNER JOIN
                         TraSua AS TS ON CTHD.ID_TraSua = TS.ID_TraSua INNER JOIN
                         KhachHang AS KH ON KH.ID_KhachHang = HD.ID_KhachHang INNER JOIN
                         Voucher AS V ON V.ID_Voucher = HD.ID_Voucher RIGHT JOIN
                         ThemTopping AS TTP ON TTP.ID_HoaDon = HD.ID_HoaDon RIGHT JOIN
                         Topping AS TP ON TP.ID_Topping = TTP.ID_Topping
WHERE        (HD.ID_HoaDon = '1_13112020')