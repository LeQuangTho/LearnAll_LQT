USE [master]
GO

CREATE DATABASE [My_IPOS]

USE [My_IPOS]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 11/14/2020 1:48:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[SoLuong] [int] NOT NULL,
	[ID_HoaDon] [nvarchar](50) NOT NULL,
	[ID_Mon] [nvarchar](50) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/14/2020 1:48:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[ID_HoaDon] [nvarchar](50) NOT NULL,
	[NgayBan] [datetime] NULL,
	[TongTien] [int] NOT NULL,
	[ID_KhachHang] [nvarchar](10) NOT NULL,
	[ID_Voucher] [nvarchar](10) NOT NULL,
	[UserName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK__HoaDon__14AFCFC58FB7E7FB] PRIMARY KEY CLUSTERED 
(
	[ID_HoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/14/2020 1:48:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[ID_KhachHang] [nvarchar](10) NOT NULL,
	[TenKhachHang] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [nvarchar](5) NOT NULL,
	[LienHe] [nvarchar](10) NOT NULL,
	[Diem] [int] NOT NULL,
 CONSTRAINT [PK__KhachHan__263C4E854D691BA1] PRIMARY KEY CLUSTERED 
(
	[ID_KhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Login]    Script Date: 11/14/2020 1:48:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Login](
	[UserName] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Login] PRIMARY KEY CLUSTERED 
(
	[UserName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Mon]    Script Date: 11/14/2020 1:48:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Mon](
	[ID_Mon] [nvarchar](50) NOT NULL,
	[TenMon] [nvarchar](50) NOT NULL,
	[DonGiaMon] [int] NOT NULL,
 CONSTRAINT [PK__TraSua__7A6728E2286B8903] PRIMARY KEY CLUSTERED 
(
	[ID_Mon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Voucher]    Script Date: 11/14/2020 1:48:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Voucher](
	[ID_Voucher] [nvarchar](10) NOT NULL,
	[MaGiamGia] [nvarchar](16) NOT NULL,
	[TenVoucher] [nvarchar](50) NOT NULL,
	[PhanTram] [float] NOT NULL,
	[SoLuong] [int] NOT NULL,
 CONSTRAINT [PK__Voucher__7D975E3E44F518CE] PRIMARY KEY CLUSTERED 
(
	[ID_Voucher] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'1_4112020', N'TX_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'1_9112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_9112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'1_7112020', N'TX_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (3, N'2_7112020', N'TX_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_7112020', N'TXXoai_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'3_7112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'4_7112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'5_7112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'6_7112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'7_7112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'8_7112020', N'TXDauTamPhaLeTuyet_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'8_7112020', N'TXDuaHongHac_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'9_7112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'10_7112020', N'TX_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (3, N'2_9112020', N'TXXoai_L')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'3_9112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'11_7112020', N'TX_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'4_9112020', N'TX_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'1_6112020', N'TX_L')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (3, N'2_6112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (15, N'3_6112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (2, N'4_6112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'5_6112020', N'TX_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (3, N'5_6112020', N'TXXoai_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'1_10112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'1_10112020', N'TX_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (3, N'2_10112020', N'TX_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_10112020', N'TXXoai_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'1_11112020', N'TX_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (3, N'1_12112020', N'TX_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (100, N'1_12112020', N'TXXoai_L')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_12112020', N'TXXoai_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_12112020', N'TXDauTamPhaLeTuyet_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'3_12112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'6_12112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'8_12112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'8_12112020', N'TXDauTamPhaLeTuyet_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'1_13112020', N'TX_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'1_13112020', N'TXXoai_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_13112020', N'TXXoai_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'6_12112020', N'TPTranChauQQ')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'7_12112020', N'TPTranChauQQ')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'1_13112020', N'TPTranChauQQ')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_13112020', N'TPTranChauQQ')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'1_14112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_14112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_14112020', N'TX_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_14112020', N'TX_L')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_14112020', N'TXKiwiChanhLeo_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_14112020', N'TXKiwiChanhLeo_L')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_14112020', N'TXXoai_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_14112020', N'TXXoai_L')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_14112020', N'TXChanhLeo_L')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_14112020', N'TXDauTamPhaLeTuyet_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_14112020', N'TXDauTamPhaLeTuyet_L')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_14112020', N'TXDuaNhietDoi_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_14112020', N'TXDuaNhietDoi_L')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_14112020', N'TXDuaHongHac_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_14112020', N'TXDuaHongHac_L')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_14112020', N'TXHongLongPhaLeTuyet_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'2_14112020', N'TXHongLongPhaLeTuyet_L')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'4_12112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'5_12112020', N'TS_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'7_12112020', N'TX_M')
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [ID_HoaDon], [ID_Mon]) VALUES (1, N'7_12112020', N'TXXoai_M')
GO
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'1_10112020', CAST(N'2020-11-10T10:10:47.000' AS DateTime), 37200, N'TA01', N'GF50', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'1_11112020', CAST(N'2020-11-11T11:58:38.000' AS DateTime), 32200, N'TA01', N'GF50', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'1_12112020', CAST(N'2020-11-12T15:02:44.000' AS DateTime), 2663000, N'TA01', N'GF50', N'LeQuangTho')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'1_13112020', CAST(N'2020-11-13T12:04:26.000' AS DateTime), 74000, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'1_14112020', CAST(N'2020-11-14T13:04:07.000' AS DateTime), 32400, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'1_4112020', CAST(N'2020-11-04T23:54:13.000' AS DateTime), 32000, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'1_6112020', CAST(N'2020-11-06T00:00:17.000' AS DateTime), 16000, N'TA01', N'GF50', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'1_7112020', CAST(N'2020-11-07T07:22:02.000' AS DateTime), 16000, N'TA01', N'GF50', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'1_9112020', CAST(N'2020-11-09T08:17:57.000' AS DateTime), 32400, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'10_7112020', CAST(N'2020-11-07T14:37:36.000' AS DateTime), 32000, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'11_7112020', CAST(N'2020-11-07T23:29:50.000' AS DateTime), 32000, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'2_10112020', CAST(N'2020-11-10T10:46:08.000' AS DateTime), 69000, N'TA01', N'GF50', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'2_12112020', CAST(N'2020-11-12T15:05:21.000' AS DateTime), 32000, N'TA01', N'GF50', N'LeQuangTho')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'2_13112020', CAST(N'2020-11-13T13:25:20.000' AS DateTime), 21000, N'TA01', N'GF50', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'2_14112020', CAST(N'2020-11-14T13:18:19.000' AS DateTime), 287600, N'TA01', N'GF50', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'2_6112020', CAST(N'2020-11-06T00:04:24.000' AS DateTime), 48000, N'TA01', N'GF50', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'2_7112020', CAST(N'2020-11-07T07:25:15.000' AS DateTime), 64000, N'TA01', N'GF50', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'2_9112020', CAST(N'2020-11-09T09:29:29.000' AS DateTime), 64200, N'TA01', N'GF50', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'3_12112020', CAST(N'2020-11-12T15:14:50.000' AS DateTime), 32400, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'3_6112020', CAST(N'2020-11-06T00:05:34.000' AS DateTime), 240000, N'TA01', N'GF50', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'3_7112020', CAST(N'2020-11-07T07:26:52.000' AS DateTime), 32000, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'3_9112020', CAST(N'2020-11-09T16:19:20.000' AS DateTime), 42400, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'4_12112020', CAST(N'2020-11-12T15:15:20.000' AS DateTime), 16200, N'TA01', N'gf50', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'4_6112020', CAST(N'2020-11-06T00:11:09.000' AS DateTime), 32000, N'TA01', N'GF50', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'4_7112020', CAST(N'2020-11-07T07:33:32.000' AS DateTime), 32000, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'4_9112020', CAST(N'2020-11-09T16:32:33.000' AS DateTime), 42000, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'5_12112020', CAST(N'2020-11-12T15:42:37.000' AS DateTime), 32400, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'5_6112020', CAST(N'2020-11-06T00:41:07.000' AS DateTime), 64000, N'TA01', N'GF50', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'5_7112020', CAST(N'2020-11-07T07:35:35.000' AS DateTime), 32000, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'6_12112020', CAST(N'2020-11-12T15:53:59.000' AS DateTime), 21200, N'TA01', N'GF50', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'6_7112020', CAST(N'2020-11-07T07:37:09.000' AS DateTime), 32000, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'7_12112020', CAST(N'2020-11-12T15:59:09.000' AS DateTime), 74000, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'7_7112020', CAST(N'2020-11-07T07:42:22.000' AS DateTime), 32000, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'8_12112020', CAST(N'2020-11-12T16:03:45.000' AS DateTime), 64400, N'TA01', N'None', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'8_7112020', CAST(N'2020-11-07T14:31:42.000' AS DateTime), 32000, N'TA01', N'GF50', N'admin')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [NgayBan], [TongTien], [ID_KhachHang], [ID_Voucher], [UserName]) VALUES (N'9_7112020', CAST(N'2020-11-07T14:36:09.000' AS DateTime), 32000, N'TA01', N'None', N'admin')
GO
INSERT [dbo].[KhachHang] ([ID_KhachHang], [TenKhachHang], [NgaySinh], [GioiTinh], [LienHe], [Diem]) VALUES (N'0973271208', N'Lê Quang Thọ', CAST(N'2000-12-14' AS Date), N'Nữ', N'0973271208', 8)
INSERT [dbo].[KhachHang] ([ID_KhachHang], [TenKhachHang], [NgaySinh], [GioiTinh], [LienHe], [Diem]) VALUES (N'GF01', N'Grab Food', CAST(N'2000-12-14' AS Date), N'Nam', N'19008198', 1000)
INSERT [dbo].[KhachHang] ([ID_KhachHang], [TenKhachHang], [NgaySinh], [GioiTinh], [LienHe], [Diem]) VALUES (N'TA01', N'Take Away ', CAST(N'2000-12-14' AS Date), N'Nam', N'0973271208', 4)
GO
INSERT [dbo].[Login] ([UserName], [Password]) VALUES (N'admin', N'admin')
INSERT [dbo].[Login] ([UserName], [Password]) VALUES (N'LeQuangTho', N'123')
GO
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TPTranChauQQ', N'Trân Châu QQ Đường Đen', 10000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TS_M', N'Trà Sữa (M)', 35000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TX_L', N'Trà Xanh (L)', 35000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TX_M', N'Trà Xanh (M)', 29000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TXChanhLeo_L', N'Trà Xanh Chanh Leo (L)', 41000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TXChanhLeo_M', N'Trà Xanh Chanh Leo (M)', 36000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TXDauTamPhaLeTuyet_L', N'Trà Dâu Tằm Pha Lê Tuyết (L)', 44000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TXDauTamPhaLeTuyet_M', N'Trà Dâu Tằm Pha Lê Tuyết (M)', 38000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TXDuaHongHac_L', N'Trà Dứa Hồng Hạc (L)', 36000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TXDuaHongHac_M', N'Trà Dứa Hồng Hạc (M)', 40000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TXDuaNhietDoi_L', N'Trà Dứa Nhiệt Đới (L)', 44000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TXDuaNhietDoi_M', N'Trà Dứa Nhiệt Đới (M)', 44000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TXHongLongPhaLeTuyet_L', N'Hồng Long Pha Lê Tuyết (L)', 48000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TXHongLongPhaLeTuyet_M', N'Hồng Long Pha Lê Tuyết (M)', 44000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TXKiwiChanhLeo_L', N'Trà Xanh Kiwi Chanh Leo (L)', 46000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TXKiwiChanhLeo_M', N'Trà Xanh Kiwi Chanh Leo (M)', 40000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TXXoai_L', N'Trà Xanh Xoai (L)', 44000)
INSERT [dbo].[Mon] ([ID_Mon], [TenMon], [DonGiaMon]) VALUES (N'TXXoai_M', N'Trà Xanh Xoai (M)', 38000)
GO
INSERT [dbo].[Voucher] ([ID_Voucher], [MaGiamGia], [TenVoucher], [PhanTram], [SoLuong]) VALUES (N'GF50', N'GF50', N'Grab Food', 0.5, 10000)
INSERT [dbo].[Voucher] ([ID_Voucher], [MaGiamGia], [TenVoucher], [PhanTram], [SoLuong]) VALUES (N'None', N'TakeAway', N'TakeAway', 0, 1000000)
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK__ChiTietHo__ID_Tr__4222D4EF] FOREIGN KEY([ID_Mon])
REFERENCES [dbo].[Mon] ([ID_Mon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK__ChiTietHo__ID_Tr__4222D4EF]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([ID_HoaDon])
REFERENCES [dbo].[HoaDon] ([ID_HoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__ID_Khach__3E52440B] FOREIGN KEY([ID_KhachHang])
REFERENCES [dbo].[KhachHang] ([ID_KhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__ID_Khach__3E52440B]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__ID_Vouch__3F466844] FOREIGN KEY([ID_Voucher])
REFERENCES [dbo].[Voucher] ([ID_Voucher])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__ID_Vouch__3F466844]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_Login] FOREIGN KEY([UserName])
REFERENCES [dbo].[Login] ([UserName])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_Login]
GO
USE [master]
GO
ALTER DATABASE [My_IPOS] SET  READ_WRITE 
GO
