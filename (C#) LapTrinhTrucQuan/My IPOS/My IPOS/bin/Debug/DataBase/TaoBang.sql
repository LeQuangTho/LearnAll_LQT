USE [master]
GO

CREATE DATABASE MY_IPOS
Go
USE MY_IPOS
Go 

CREATE TABLE TraSua
(
  ID_TraSua NVARCHAR(50) NOT NULL,
  TenTraSua NVARCHAR(50) NOT NULL,
  DonGiaTraSua INT NOT NULL,
  PRIMARY KEY (ID_TraSua)
);

CREATE TABLE KhachHang
(
  ID_KhachHang NVARCHAR(10) NOT NULL,
  GioiTinh BIT NOT NULL,
  NgaySinh DATE NOT NULL,
  TenKhachHang NVARCHAR(50) NOT NULL,
  LienHe INT NOT NULL,
  PRIMARY KEY (ID_KhachHang)
);

CREATE TABLE Topping
(
  ID_Topping NVARCHAR(50) NOT NULL,
  TenTopping NVARCHAR(50) NOT NULL,
  DonGiaTopping INT NOT NULL,
  PRIMARY KEY (ID_Topping)
);

CREATE TABLE Voucher
(
  ID_Voucher NVARCHAR(10) NOT NULL,
  MaGiamGia NVARCHAR(16) NOT NULL,
  TenVoucher NVARCHAR(50) NOT NULL,
  PhanTram INT NOT NULL,
  SoLuong INT NOT NULL,
  PRIMARY KEY (ID_Voucher)
);

CREATE TABLE HoaDon
(
  ID_HoaDon NVARCHAR(10) NOT NULL,
  TongTien FLOAT NOT NULL,
  ID_KhachHang NVARCHAR(10) NOT NULL,
  ID_Voucher NVARCHAR(10) NOT NULL,
  PRIMARY KEY (ID_HoaDon),
  FOREIGN KEY (ID_KhachHang) REFERENCES KhachHang(ID_KhachHang),
  FOREIGN KEY (ID_Voucher) REFERENCES Voucher(ID_Voucher)
);

CREATE TABLE ChiTietHoaDon
(
  SoLuong INT NOT NULL,
  ID_HoaDon NVARCHAR(10) NOT NULL,
  ID_TraSua NVARCHAR(50) NOT NULL,
  FOREIGN KEY (ID_HoaDon) REFERENCES HoaDon(ID_HoaDon),
  FOREIGN KEY (ID_TraSua) REFERENCES TraSua(ID_TraSua)
);

CREATE TABLE ThemTopping
(
  SoLuong INT NOT NULL,
  ID_Topping NVARCHAR(50) NOT NULL,
  ID_HoaDon NVARCHAR(10) NOT NULL,
  FOREIGN KEY (ID_Topping) REFERENCES Topping(ID_Topping),
  FOREIGN KEY (ID_HoaDon) REFERENCES HoaDon(ID_HoaDon)
);

INSERT [KhachHang] ([ID_KhachHang], [GioiTinh], [NgaySinh], [TenKhachHang], [LienHe]) VALUES (N'GF01', 1, CAST(N'2000-12-14' AS Date), N'Grab Food', N'19008198')
INSERT [KhachHang] ([ID_KhachHang], [GioiTinh], [NgaySinh], [TenKhachHang], [LienHe]) VALUES (N'TA01', 1, CAST(N'2000-12-14' AS Date), N'Take Away ', N'973271208')
GO
INSERT [Topping] ([ID_Topping], [TenTopping], [DonGiaTopping]) VALUES (N'TPTranChauQQ', N'Trân Châu QQ Đường Đen', 10000)
GO
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TS_M', N' Trà Sữa (M)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TX_L', N'Trà Xanh (L)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TX_M', N'Trà Xanh (M)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TXChanh_M', N'Trà Xanh Chanh Leo (M)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TXChanhLeo_L', N'Trà Xanh Chanh Leo (L)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TXChanhLeo_M', N'Trà Xanh Chanh Leo (M)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TXDauTamPhaLeTuyet_L', N'Trà Dâu Tằm Pha Lê Tuyết (L)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TXDauTamPhaLeTuyet_M', N'Trà Dâu Tằm Pha Lê Tuyết (M)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TXDuaHongHac_L', N'Trà Dứa Hồng Hạc (L)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TXDuaHongHac_M', N'Trà Dứa Hồng Hạc (M)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TXDuaNhietDoi_L', N'Trà Dứa Nhiệt Đới (L)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TXDuaNhietDoi_M', N'Trà Dứa Nhiệt Đới (M)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TXHongLongPhaLeTuyet_L', N'Hồng Long Pha Lê Tuyết (L)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TXHongLongPhaLeTuyet_M', N'Hồng Long Pha Lê Tuyết (M)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TXKiwiChanhLeo_L', N'Trà Xanh Kiwi Chanh Leo (L)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TXKiwiChanhLeo_M', N'Trà Xanh Kiwi Chanh Leo (M)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TXXoai_L', N'Trà Xanh Xoai (L)', 32000)
INSERT [TraSua] ([ID_TraSua], [TenTraSua], [DonGiaTraSua]) VALUES (N'TXXoai_M', N'Trà Xanh Xoai (M)', 32000)
GO
INSERT [Voucher] ([ID_Voucher], [MaGiamGia], [TenVoucher], [PhanTram], [SoLuong]) VALUES (N'GF50', N'GF50', N'Grab Food', 50, 10000)
INSERT [Voucher] ([ID_Voucher], [MaGiamGia], [TenVoucher], [PhanTram], [SoLuong]) VALUES (N'None', N'TakeAway', N'TakeAway', 0, 1000000)
