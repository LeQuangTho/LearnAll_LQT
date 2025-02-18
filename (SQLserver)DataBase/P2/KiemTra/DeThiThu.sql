USE [master]
GO

CREATE DATABASE [QLBanDienThoai_LeQuangTho_181202289]
GO
USE [QLBanDienThoai_LeQuangTho_181202289]
GO
CREATE TABLE [dbo].[ChiTietHD](
	[MaHD] [nvarchar](5) NOT NULL,
	[MaSP] [nvarchar](5) NOT NULL,
	[SlBan] [int] NULL,
 CONSTRAINT [PK_ChiTietHD] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC,
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChiTietHDN]    Script Date: 07/10/2017 7:29:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHDN](
	[MaHDN] [nvarchar](5) NOT NULL,
	[MaSP] [nvarchar](5) NOT NULL,
	[GiaNhapVao] [int] NULL,
	[SLN] [int] NULL,
 CONSTRAINT [PK_ChiTietHDN] PRIMARY KEY CLUSTERED 
(
	[MaHDN] ASC,
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Hoadon]    Script Date: 07/10/2017 7:29:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hoadon](
	[MaHD] [nvarchar](5) NOT NULL,
	[MaKH] [nvarchar](5) NULL,
	[MaNV] [nvarchar](5) NULL,
	[Ngayban] [datetime] NULL,
 CONSTRAINT [PK_Hoadon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDonNhap]    Script Date: 07/10/2017 7:29:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonNhap](
	[MaHDN] [nvarchar](5) NOT NULL,
	[MaNV] [nvarchar](5) NULL,
	[NgayNhap] [datetime] NULL,
 CONSTRAINT [PK_HoaDonNhap] PRIMARY KEY CLUSTERED 
(
	[MaHDN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 07/10/2017 7:29:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nvarchar](5) NOT NULL,
	[TenKH] [nvarchar](100) NULL,
	[DiaChi] [nvarchar](150) NULL,
	[SDT] [nvarchar](15) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 07/10/2017 7:29:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](5) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[Diachi] [nvarchar](150) NULL,
	[GioiTinh] [nvarchar](5) NULL,
	[SDT] [nvarchar](15) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 07/10/2017 7:29:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSP] [nvarchar](5) NOT NULL,
	[HangSanxuat] [nvarchar](100) NULL,
	[TenSP] [nvarchar](100) NULL,
	[GiaSP] [bigint] NULL,
	[Thongso] [nvarchar](200) NULL,
	[BaoHanh] [nvarchar](25) NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0003', N'0001', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0003', N'0003', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0004', N'0012', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0004', N'0015', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0006', N'0007', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0006', N'0009', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0007', N'0005', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0008', N'0011', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0009', N'0003', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0009', N'0015', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0010', N'0014', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0011', N'0008', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0011', N'0011', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0012', N'0005', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0012', N'0009', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0012', N'0012', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0015', N'0015', 2)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0016', N'0011', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0017', N'0010', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0018', N'0011', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0018', N'0015', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0020', N'0013', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0021', N'0015', 2)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0022', N'0004', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0023', N'0012', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0024', N'0013', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0025', N'0002', 2)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0026', N'0003', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0026', N'0011', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0027', N'0002', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0028', N'0006', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0029', N'0007', 2)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0030', N'0009', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0031', N'0010', 1)
INSERT [dbo].[ChiTietHD] ([MaHD], [MaSP], [SlBan]) VALUES (N'0031', N'0011', 1)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'1', N'0001', 20000000, 10)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'1', N'0002', 19000000, 5)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'1', N'0003', 16000000, 10)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'1', N'0004', 11000000, 10)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'1', N'0005', 14000000, 10)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'10', N'0016', 3000000, 20)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'2', N'0006', 11000000, 10)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'2', N'0007', 10000000, 5)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'2', N'0008', 10000000, 5)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'2', N'0009', 7500000, 5)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'3', N'0010', 7000000, 10)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'3', N'0011', 8000000, 10)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'3', N'0012', 7500000, 10)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'3', N'0013', 5500000, 10)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'4', N'0001', 19500000, 5)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'4', N'0002', 20000000, 5)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'4', N'0003', 16000000, 10)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'4', N'0014', 5000000, 10)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'4', N'0015', 4900000, 5)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'5', N'0004', 11000000, 10)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'5', N'0005', 13800000, 10)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'5', N'0011', 8000000, 5)
INSERT [dbo].[ChiTietHDN] ([MaHDN], [MaSP], [GiaNhapVao], [SLN]) VALUES (N'9', N'0015', 4900000, 20)
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0003', N'0003', N'0001', CAST(N'2015-03-16T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0004', N'0004', N'0001', CAST(N'2015-03-17T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0006', N'0002', N'0001', CAST(N'2015-03-18T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0007', N'0004', N'0003', CAST(N'2015-03-19T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0008', N'0005', N'0002', CAST(N'2015-03-20T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0009', N'0006', N'0003', CAST(N'2015-03-21T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0010', N'0007', N'0004', CAST(N'2015-03-21T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0011', N'0005', N'0004', CAST(N'2015-03-22T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0012', N'0002', N'0003', CAST(N'2015-03-22T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0015', N'0003', N'0002', CAST(N'2015-03-22T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0016', N'0008', N'0003', CAST(N'2015-03-23T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0017', N'0009', N'0002', CAST(N'2015-03-23T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0018', N'0010', N'0001', CAST(N'2015-03-24T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0020', N'0002', N'0003', CAST(N'2015-03-24T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0021', N'0004', N'0002', CAST(N'2015-03-24T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0022', N'0011', N'0002', CAST(N'2015-03-25T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0023', N'0012', N'0001', CAST(N'2015-03-26T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0024', N'0013', N'0003', CAST(N'2015-03-27T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0025', N'0014', N'0004', CAST(N'2015-03-28T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0026', N'0015', N'0001', CAST(N'2015-03-29T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0027', N'0016', N'0004', CAST(N'2015-03-30T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0028', N'0017', N'0003', CAST(N'2015-03-31T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0029', N'0018', N'0002', CAST(N'2015-04-01T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0030', N'0019', N'0004', CAST(N'2015-04-02T00:00:00.000' AS DateTime))
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [Ngayban]) VALUES (N'0031', N'0020', N'0002', CAST(N'2015-04-03T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNV], [NgayNhap]) VALUES (N'1', N'0002', CAST(N'2015-03-01T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNV], [NgayNhap]) VALUES (N'10', N'0003', CAST(N'2015-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNV], [NgayNhap]) VALUES (N'11', N'0004', CAST(N'2015-05-31T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNV], [NgayNhap]) VALUES (N'2', N'0001', CAST(N'2015-03-02T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNV], [NgayNhap]) VALUES (N'3', N'0003', CAST(N'2015-03-04T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNV], [NgayNhap]) VALUES (N'4', N'0004', CAST(N'2015-03-05T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNV], [NgayNhap]) VALUES (N'5', N'0001', CAST(N'2015-03-06T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNV], [NgayNhap]) VALUES (N'6', N'0003', CAST(N'2015-03-06T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNV], [NgayNhap]) VALUES (N'7', N'0002', CAST(N'2015-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNV], [NgayNhap]) VALUES (N'8', N'0004', CAST(N'2015-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNV], [NgayNhap]) VALUES (N'9', N'0003', CAST(N'2015-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0001', N'Nguyễn Văn Hùng', N'Cầu Giấy - Hà Nội', N'0978965195')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0002', N'Bùi Minh Chí', N'Hà Đông', N'0978965236')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0003', N'Trần Chí Kiên', N'Tây Hồ - Hà Nội', N'0912559654')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0004', N'Nguyễn Hữu Minh', N'Bắc Từ Liêm - Hà Nội', N'01658256325')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0005', N'Trần Lan Anh', N'Hà Đông', N'0985621531')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0006', N'Lê Thị Quỳnh', N'Ba Vì - Hà Nội', N'0912565842')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0007', N'Nguyễn Tuấn Anh', N'Nam Từ Liêm - Hà Nội', N'0925632514')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0008', N'Lê Kim Anh', N'Hà Đông', N'01625632512')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0009', N'Trần Trung Đức', N'Cầu Giấy - Hà Nội', N'0921235236')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0010', N'Nguyễn Xuân Huy', N'Cầu Giấy - Hà Nội', N'0912584633')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0011', N'Bùi Duy Khánh', N'Cầu Giấy - HN', N'0978563256')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0012', N'Chương Văn Tài', N'Hà Đông', N'0985623652')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0013', N'Nguyễn Văn An', N'Vĩnh Phúc', N'0985632563')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0014', N'Lê Thị Hoa', N'Nam Từ Liêm - Hà Nội', N'0912355658')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0015', N'Bùi Thị Trang', N'Tây Hồ - Hà Nội', N'0912365896')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0016', N'Lê Huyền Trang', N'Nam Từ Liêm - Hà Nội', N'0987562632')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0017', N'Tăng Thanh Hà', N'Tây Hồ - Hà Nội', N'0912563259')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0018', N'Hồ Ngọc Hà', N'Tây Hồ - Hà Nội', N'0986523625')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0019', N'Bùi Minh Hằng', N'Nam Từ Liêm - Hà Nội', N'0986523652')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'0020', N'Đàm Vĩnh Hưng', N'Tây Hồ - Hà Nội', N'0985623652')
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [Diachi], [GioiTinh], [SDT]) VALUES (N'0001', N'Tăng Thanh Hà', N'Số 3, Ngõ 165,Cầu Giấy - Hà Nội', N'Nữ', N'0978652365')
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [Diachi], [GioiTinh], [SDT]) VALUES (N'0002', N'Nguyễn Văn Hùng', N'Số 69, Ngách 24, ngõ 23, Từ Liêm - Hà Nội', N'Nam', N'0912563215')
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [Diachi], [GioiTinh], [SDT]) VALUES (N'0003', N'Tạ Quang Huy', N'Số 25, Ngõ 196, Cầu Giấy -  Hà Nội', N'Nam', N'016502256523')
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [Diachi], [GioiTinh], [SDT]) VALUES (N'0004', N'Nguyễn Thị Ngọc Anh', N'Số 27, Ngách 49, Ngõ 165, Cầu Giấy - Hà Nội', N'Nữ', N'0978563254')
INSERT [dbo].[SanPham] ([MaSP], [HangSanxuat], [TenSP], [GiaSP], [Thongso], [BaoHanh]) VALUES (N'0001', N'Samsung', N'Galaxy note Edge', 20990000, NULL, N'1 Nam')
INSERT [dbo].[SanPham] ([MaSP], [HangSanxuat], [TenSP], [GiaSP], [Thongso], [BaoHanh]) VALUES (N'0002', N'Apple', N'Iphone 6 Plus 16GB', 19590000, NULL, N'1 Nam')
INSERT [dbo].[SanPham] ([MaSP], [HangSanxuat], [TenSP], [GiaSP], [Thongso], [BaoHanh]) VALUES (N'0003', N'HTC', N'One M9', 16990000, NULL, N'1 Nam')
INSERT [dbo].[SanPham] ([MaSP], [HangSanxuat], [TenSP], [GiaSP], [Thongso], [BaoHanh]) VALUES (N'0004', N'Sony', N'Z2', 11990000, NULL, N'1 Nam')
INSERT [dbo].[SanPham] ([MaSP], [HangSanxuat], [TenSP], [GiaSP], [Thongso], [BaoHanh]) VALUES (N'0005', N'Sony', N'Z3', 14990000, NULL, N'1 Nam')
INSERT [dbo].[SanPham] ([MaSP], [HangSanxuat], [TenSP], [GiaSP], [Thongso], [BaoHanh]) VALUES (N'0006', N'Sony', N'Z3 Compact', 11990000, NULL, N'1 Nam')
INSERT [dbo].[SanPham] ([MaSP], [HangSanxuat], [TenSP], [GiaSP], [Thongso], [BaoHanh]) VALUES (N'0007', N'Nokia', N'Lumia 930', 10990000, NULL, N'1 Nam')
INSERT [dbo].[SanPham] ([MaSP], [HangSanxuat], [TenSP], [GiaSP], [Thongso], [BaoHanh]) VALUES (N'0008', N'Oppo', N'R5', 10000000, NULL, N'12Thang')
INSERT [dbo].[SanPham] ([MaSP], [HangSanxuat], [TenSP], [GiaSP], [Thongso], [BaoHanh]) VALUES (N'0009', N'Oppo', N'N1 Mini', 8490000, NULL, N'12 Thang')
INSERT [dbo].[SanPham] ([MaSP], [HangSanxuat], [TenSP], [GiaSP], [Thongso], [BaoHanh]) VALUES (N'0010', N'Oppo', N'R1K R8001', 7990000, NULL, N'12Thang')
INSERT [dbo].[SanPham] ([MaSP], [HangSanxuat], [TenSP], [GiaSP], [Thongso], [BaoHanh]) VALUES (N'0011', N'HTC', N'Desire 826', 8690000, NULL, N'1 Nam')
INSERT [dbo].[SanPham] ([MaSP], [HangSanxuat], [TenSP], [GiaSP], [Thongso], [BaoHanh]) VALUES (N'0012', N'Pantech', N'Vega iron 2 A910S', 8200000, NULL, N'1 Nam')
INSERT [dbo].[SanPham] ([MaSP], [HangSanxuat], [TenSP], [GiaSP], [Thongso], [BaoHanh]) VALUES (N'0013', N'Sony', N'C3', 6000000, NULL, N'1 Nam')
INSERT [dbo].[SanPham] ([MaSP], [HangSanxuat], [TenSP], [GiaSP], [Thongso], [BaoHanh]) VALUES (N'0014', N'Asus', N'Zenfone 6', 5500000, NULL, N'1Nam')
INSERT [dbo].[SanPham] ([MaSP], [HangSanxuat], [TenSP], [GiaSP], [Thongso], [BaoHanh]) VALUES (N'0015', N'Lenovo', N'P70', 5400000, NULL, N'1 Nam')
INSERT [dbo].[SanPham] ([MaSP], [HangSanxuat], [TenSP], [GiaSP], [Thongso], [BaoHanh]) VALUES (N'0016', N'Sony', N'C3', 3500000, NULL, N'1 Năm')
ALTER TABLE [dbo].[ChiTietHD]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHD_Hoadon] FOREIGN KEY([MaHD])
REFERENCES [dbo].[Hoadon] ([MaHD])
GO
ALTER TABLE [dbo].[ChiTietHD] CHECK CONSTRAINT [FK_ChiTietHD_Hoadon]
GO
ALTER TABLE [dbo].[ChiTietHD]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHD_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[ChiTietHD] CHECK CONSTRAINT [FK_ChiTietHD_SanPham]
GO
ALTER TABLE [dbo].[ChiTietHDN]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHDN_HoaDonNhap] FOREIGN KEY([MaHDN])
REFERENCES [dbo].[HoaDonNhap] ([MaHDN])
GO
ALTER TABLE [dbo].[ChiTietHDN] CHECK CONSTRAINT [FK_ChiTietHDN_HoaDonNhap]
GO
ALTER TABLE [dbo].[ChiTietHDN]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHDN_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[ChiTietHDN] CHECK CONSTRAINT [FK_ChiTietHDN_SanPham]
GO
ALTER TABLE [dbo].[Hoadon]  WITH CHECK ADD  CONSTRAINT [FK_Hoadon_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[Hoadon] CHECK CONSTRAINT [FK_Hoadon_KhachHang]
GO
ALTER TABLE [dbo].[Hoadon]  WITH CHECK ADD  CONSTRAINT [FK_Hoadon_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[Hoadon] CHECK CONSTRAINT [FK_Hoadon_NhanVien]
GO