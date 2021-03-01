USE [master]
GO
/****** Object:  Database [Restaurant]    Script Date: 11/22/2020 4:07:13 PM ******/
CREATE DATABASE [Restaurant]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Restaurant', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Restaurant.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Restaurant_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Restaurant_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Restaurant] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Restaurant].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Restaurant] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Restaurant] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Restaurant] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Restaurant] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Restaurant] SET ARITHABORT OFF 
GO
ALTER DATABASE [Restaurant] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Restaurant] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Restaurant] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Restaurant] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Restaurant] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Restaurant] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Restaurant] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Restaurant] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Restaurant] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Restaurant] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Restaurant] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Restaurant] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Restaurant] SET TRUSTWORTHY OFF 
GO 
ALTER DATABASE [Restaurant] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Restaurant] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Restaurant] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Restaurant] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Restaurant] SET RECOVERY FULL 
GO
ALTER DATABASE [Restaurant] SET  MULTI_USER 
GO
ALTER DATABASE [Restaurant] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Restaurant] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Restaurant] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Restaurant] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Restaurant] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Restaurant', N'ON'
GO
ALTER DATABASE [Restaurant] SET QUERY_STORE = OFF
GO
USE [Restaurant]
GO
/****** Object:  UserDefinedFunction [dbo].[AutoIDPhieuDatBan]    Script Date: 11/22/2020 4:07:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE function [dbo].[AutoIDPhieuDatBan]() returns nvarchar(10) As
Begin
declare @max int
select
@max = max(cast(substring(MaPhieu,4,4) as int)) + 1
from PhieuDatBan
declare @s char(8)
set @s = '000' + rtrim(cast(@max as char(4)))
set @s = 'HDB' + right(@s,8)
return @s
end
GO
/****** Object:  Table [dbo].[MonAn]    Script Date: 11/22/2020 4:07:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MonAn](
	[MaMonAn] [nvarchar](10) NOT NULL,
	[TenMonAn] [nvarchar](50) NOT NULL,
	[DonGia] [int] NOT NULL,
	[AnhMonAn] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaMonAn] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiNguyenLieu]    Script Date: 11/22/2020 4:07:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiNguyenLieu](
	[MaLoai] [nvarchar](10) NOT NULL,
	[TenLoai] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_LoaiNguyenLieu] PRIMARY KEY CLUSTERED 
(
	[MaLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguyenLieu]    Script Date: 11/22/2020 4:07:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguyenLieu](
	[MaNguyenLieu] [nvarchar](10) NOT NULL,
	[TenNguyenLieu] [nvarchar](50) NOT NULL,
	[DVT] [nvarchar](10) NOT NULL,
	[MaLoai] [nvarchar](10) NOT NULL,
	[GhiChu] [ntext] NULL,
 CONSTRAINT [PK__NguyenLi__C7519355E4BF8E23] PRIMARY KEY CLUSTERED 
(
	[MaNguyenLieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuCheBien]    Script Date: 11/22/2020 4:07:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuCheBien](
	[MaMonAn] [nvarchar](10) NOT NULL,
	[MaNguyenLieu] [nvarchar](10) NOT NULL,
	[SoLuong] [float] NOT NULL,
 CONSTRAINT [PK_PhieuCheBien] PRIMARY KEY CLUSTERED 
(
	[MaMonAn] ASC,
	[MaNguyenLieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  UserDefinedFunction [dbo].[XuatTheoLoai]    Script Date: 11/22/2020 4:07:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE function [dbo].[XuatTheoLoai](@loai nvarchar(20))
returns table
as
	return select MonAn.MaMonAn,TenMonAn,DonGia,AnhMonAn from MonAn
	join PhieuCheBien on MonAn.MaMonAn=PhieuCheBien.MaMonAn join NguyenLieu
	on PhieuCheBien.MaNguyenLieu=NguyenLieu.MaNguyenLieu join
	LoaiNguyenLieu on NguyenLieu.MaLoai=LoaiNguyenLieu.MaLoai
	where TenLoai = @loai
GO
/****** Object:  Table [dbo].[ChiTietHDN]    Script Date: 11/22/2020 4:07:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHDN](
	[MaHDN] [nvarchar](10) NOT NULL,
	[MaNguyenLieu] [nvarchar](10) NOT NULL,
	[SoLuong] [float] NOT NULL,
	[DonGia] [int] NOT NULL,
	[ThanhTien] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHDN] ASC,
	[MaNguyenLieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieuDB]    Script Date: 11/22/2020 4:07:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuDB](
	[MaPhieu] [nvarchar](10) NOT NULL,
	[MaMonAn] [nvarchar](10) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[TongTien] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhieu] ASC,
	[MaMonAn] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonNhap]    Script Date: 11/22/2020 4:07:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonNhap](
	[MaHDN] [nvarchar](10) NOT NULL,
	[MaNV] [nvarchar](10) NOT NULL,
	[MaNCC] [nvarchar](10) NOT NULL,
	[NgayNhap] [int] NOT NULL,
	[KhuyenMai] [int] NULL,
	[DVKM] [nvarchar](10) NULL,
	[ThanhTien] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHDN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/22/2020 4:07:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nvarchar](10) NOT NULL,
	[HoTenKH] [nvarchar](50) NOT NULL,
	[GioiTinh] [bit] NULL,
	[SDT] [nvarchar](10) NOT NULL,
	[QuanHe] [nvarchar](20) NULL,
 CONSTRAINT [PK__KhachHan__2725CF1EA15747B6] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 11/22/2020 4:07:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[MaKM] [nvarchar](10) NOT NULL,
	[TenKM] [nvarchar](20) NOT NULL,
	[Chitiet] [nvarchar](100) NULL,
	[NgayBatDau] [date] NOT NULL,
	[NgayKetThuc] [date] NOT NULL,
	[GiaTriKM] [int] NOT NULL,
	[DVKM] [nvarchar](10) NOT NULL,
	[GiaTriBatDau] [int] NOT NULL,
	[GiaTriKetThuc] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 11/22/2020 4:07:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[MaNCC] [nvarchar](10) NOT NULL,
	[TenNCC] [nvarchar](200) NOT NULL,
	[DiaChi] [ntext] NOT NULL,
	[SDT] [int] NOT NULL,
	[MaSoThue] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/22/2020 4:07:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](10) NOT NULL,
	[HoTenNV] [nvarchar](50) NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[CMT] [char](9) NOT NULL,
	[SDT] [char](10) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[DiaChi] [ntext] NOT NULL,
	[QueQuan] [ntext] NOT NULL,
	[AnhNV] [nvarchar](50) NOT NULL,
	[NgayBatDau] [date] NOT NULL,
	[NgayKetThuc] [date] NULL,
	[TinhTrang] [nvarchar](30) NOT NULL,
 CONSTRAINT [PK__NhanVien__2725D70A4C549481] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuDatBan]    Script Date: 11/22/2020 4:07:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDatBan](
	[MaPhieu] [nvarchar](10) NOT NULL,
	[MaKH] [nvarchar](10) NOT NULL,
	[MaNV] [nvarchar](10) NULL,
	[MaKM] [nvarchar](10) NULL,
	[Chitiet] [nvarchar](100) NULL,
	[GiaTriKM] [int] NULL,
	[DVKM] [nvarchar](10) NULL,
	[MaBan] [nvarchar](10) NOT NULL,
	[NgayDat] [datetime] NOT NULL,
	[NgayDung] [datetime] NOT NULL,
	[NgayKetThuc] [datetime] NULL,
	[ThanhTien] [int] NULL,
 CONSTRAINT [PK__PhieuDat__2660BFE0CBAB43B1] PRIMARY KEY CLUSTERED 
(
	[MaPhieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 11/22/2020 4:07:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[MaPhong] [nvarchar](10) NOT NULL,
	[TenPhong] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[MaPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThongTinBan]    Script Date: 11/22/2020 4:07:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThongTinBan](
	[MaBan] [nvarchar](10) NOT NULL,
	[MaPhong] [nvarchar](10) NOT NULL,
	[SoBan] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[KhachHang] ADD  CONSTRAINT [DF_KhachHang_QuanHe]  DEFAULT (N'Bình thường') FOR [QuanHe]
GO
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [DF__NhanVien__TinhTr__3B75D760]  DEFAULT (N'Đang làm') FOR [TinhTrang]
GO
ALTER TABLE [dbo].[ChiTietHDN]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHDN_HoaDonNhap] FOREIGN KEY([MaHDN])
REFERENCES [dbo].[HoaDonNhap] ([MaHDN])
GO
ALTER TABLE [dbo].[ChiTietHDN] CHECK CONSTRAINT [FK_ChiTietHDN_HoaDonNhap]
GO
ALTER TABLE [dbo].[ChiTietHDN]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHDN_NguyenLieu] FOREIGN KEY([MaNguyenLieu])
REFERENCES [dbo].[NguyenLieu] ([MaNguyenLieu])
GO
ALTER TABLE [dbo].[ChiTietHDN] CHECK CONSTRAINT [FK_ChiTietHDN_NguyenLieu]
GO
ALTER TABLE [dbo].[ChiTietPhieuDB]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuDB_MonAn] FOREIGN KEY([MaMonAn])
REFERENCES [dbo].[MonAn] ([MaMonAn])
GO
ALTER TABLE [dbo].[ChiTietPhieuDB] CHECK CONSTRAINT [FK_ChiTietPhieuDB_MonAn]
GO
ALTER TABLE [dbo].[ChiTietPhieuDB]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuDB_PhieuDatBan] FOREIGN KEY([MaPhieu])
REFERENCES [dbo].[PhieuDatBan] ([MaPhieu])
GO
ALTER TABLE [dbo].[ChiTietPhieuDB] CHECK CONSTRAINT [FK_ChiTietPhieuDB_PhieuDatBan]
GO
ALTER TABLE [dbo].[HoaDonNhap]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonNhap_NhaCungCap] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NhaCungCap] ([MaNCC])
GO
ALTER TABLE [dbo].[HoaDonNhap] CHECK CONSTRAINT [FK_HoaDonNhap_NhaCungCap]
GO
ALTER TABLE [dbo].[HoaDonNhap]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonNhap_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HoaDonNhap] CHECK CONSTRAINT [FK_HoaDonNhap_NhanVien]
GO
ALTER TABLE [dbo].[NguyenLieu]  WITH CHECK ADD  CONSTRAINT [FK_NguyenLieu_LoaiNguyenLieu] FOREIGN KEY([MaLoai])
REFERENCES [dbo].[LoaiNguyenLieu] ([MaLoai])
GO
ALTER TABLE [dbo].[NguyenLieu] CHECK CONSTRAINT [FK_NguyenLieu_LoaiNguyenLieu]
GO
ALTER TABLE [dbo].[PhieuCheBien]  WITH CHECK ADD  CONSTRAINT [FK_PhieuCheBien_MonAn] FOREIGN KEY([MaMonAn])
REFERENCES [dbo].[MonAn] ([MaMonAn])
GO
ALTER TABLE [dbo].[PhieuCheBien] CHECK CONSTRAINT [FK_PhieuCheBien_MonAn]
GO
ALTER TABLE [dbo].[PhieuCheBien]  WITH CHECK ADD  CONSTRAINT [FK_PhieuCheBien_NguyenLieu] FOREIGN KEY([MaNguyenLieu])
REFERENCES [dbo].[NguyenLieu] ([MaNguyenLieu])
GO
ALTER TABLE [dbo].[PhieuCheBien] CHECK CONSTRAINT [FK_PhieuCheBien_NguyenLieu]
GO
ALTER TABLE [dbo].[PhieuDatBan]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatBan_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[PhieuDatBan] CHECK CONSTRAINT [FK_PhieuDatBan_KhachHang]
GO
ALTER TABLE [dbo].[PhieuDatBan]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatBan_KhuyenMai] FOREIGN KEY([MaKM])
REFERENCES [dbo].[KhuyenMai] ([MaKM])
GO
ALTER TABLE [dbo].[PhieuDatBan] CHECK CONSTRAINT [FK_PhieuDatBan_KhuyenMai]
GO
ALTER TABLE [dbo].[PhieuDatBan]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatBan_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[PhieuDatBan] CHECK CONSTRAINT [FK_PhieuDatBan_NhanVien]
GO
ALTER TABLE [dbo].[PhieuDatBan]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatBan_ThongTinBan] FOREIGN KEY([MaBan])
REFERENCES [dbo].[ThongTinBan] ([MaBan])
GO
ALTER TABLE [dbo].[PhieuDatBan] CHECK CONSTRAINT [FK_PhieuDatBan_ThongTinBan]
GO
ALTER TABLE [dbo].[ThongTinBan]  WITH CHECK ADD  CONSTRAINT [FK_ThongTinBan_Phong] FOREIGN KEY([MaPhong])
REFERENCES [dbo].[Phong] ([MaPhong])
GO
ALTER TABLE [dbo].[ThongTinBan] CHECK CONSTRAINT [FK_ThongTinBan_Phong]
GO
USE [master]
GO
ALTER DATABASE [Restaurant] SET  READ_WRITE 
GO
