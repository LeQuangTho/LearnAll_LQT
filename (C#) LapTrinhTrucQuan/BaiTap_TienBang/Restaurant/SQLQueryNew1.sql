USE [master]
GO
/****** Object:  Database [Restaurant]    Script Date: 11/25/2020 2:24:02 PM ******/
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
/****** Object:  User [userR2]    Script Date: 11/25/2020 2:24:02 PM ******/
CREATE USER [userR2] FOR LOGIN [loginR2] WITH DEFAULT_SCHEMA=[userR2]
GO
/****** Object:  User [userR1]    Script Date: 11/25/2020 2:24:02 PM ******/
CREATE USER [userR1] FOR LOGIN [loginR1] WITH DEFAULT_SCHEMA=[userR1]
GO
/****** Object:  Schema [userR1]    Script Date: 11/25/2020 2:24:02 PM ******/
CREATE SCHEMA [userR1]
GO
/****** Object:  Schema [userR2]    Script Date: 11/25/2020 2:24:02 PM ******/
CREATE SCHEMA [userR2]
GO
/****** Object:  UserDefinedFunction [dbo].[AutoIDKhachHang]    Script Date: 11/25/2020 2:24:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE function [dbo].[AutoIDKhachHang]() returns nvarchar(10) As
Begin
declare @max int
select
@max = max(cast(substring(MaKH,4,4) as int)) + 1
from KhachHang
declare @s char(8)
set @s = '00' + rtrim(cast(@max as char(4)))
set @s = 'KH' + right(@s,8)
return @s
end
GO
/****** Object:  UserDefinedFunction [dbo].[AutoIDPhieuDatBan]    Script Date: 11/25/2020 2:24:02 PM ******/
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
/****** Object:  UserDefinedFunction [dbo].[XemTheoMon]    Script Date: 11/25/2020 2:24:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create function [dbo].[XemTheoMon](@MaMonAn nvarchar(10))
returns int
as
begin
	declare @sl int
	select @sl=sum(SoLuong) from ChiTietPhieuDB where MaMonAn=@MaMonAn
	return @sl
end
GO
/****** Object:  Table [dbo].[MonAn]    Script Date: 11/25/2020 2:24:02 PM ******/
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
/****** Object:  Table [dbo].[NguyenLieu]    Script Date: 11/25/2020 2:24:02 PM ******/
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
	[SoLuong] [float] NOT NULL,
 CONSTRAINT [PK__NguyenLi__C7519355E4BF8E23] PRIMARY KEY CLUSTERED 
(
	[MaNguyenLieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiNguyenLieu]    Script Date: 11/25/2020 2:24:02 PM ******/
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
/****** Object:  Table [dbo].[PhieuCheBien]    Script Date: 11/25/2020 2:24:02 PM ******/
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
/****** Object:  UserDefinedFunction [dbo].[XuatTheoLoai]    Script Date: 11/25/2020 2:24:02 PM ******/
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
/****** Object:  View [dbo].[ThongTinMonAn]    Script Date: 11/25/2020 2:24:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[ThongTinMonAn] as
select MaMonAn,TenMonAn,Dongia,AnhMonAn from MonAn
GO
/****** Object:  UserDefinedFunction [dbo].[XuatTheoMon]    Script Date: 11/25/2020 2:24:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create function [dbo].[XuatTheoMon](@MaMonAn nvarchar(10))
returns table
as
	return select * from MonAn where MaMonAn=@MaMonAn
GO
/****** Object:  Table [dbo].[ChiTietPhieuDB]    Script Date: 11/25/2020 2:24:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuDB](
	[MaPhieu] [nvarchar](10) NOT NULL,
	[MaMonAn] [nvarchar](10) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[TongTien] [int] NOT NULL,
	[DonGia] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhieu] ASC,
	[MaMonAn] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuDatBan]    Script Date: 11/25/2020 2:24:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDatBan](
	[MaPhieu] [nvarchar](10) NOT NULL,
	[MaKH] [nvarchar](10) NOT NULL,
	[MaNV] [nvarchar](10) NULL,
	[HoTenNV] [nvarchar](50) NULL,
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
/****** Object:  UserDefinedFunction [dbo].[ThongKeMonAn]    Script Date: 11/25/2020 2:24:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create function [dbo].[ThongKeMonAn](@nam int)
returns table
as
 return (select ChiTietPhieuDB.MaMonAn , TenMonAn,
    SUM(IIF(MONTH(NgayKetThuc) = 1 , ChiTietPhieuDB.Soluong , 0)) as Thang1,
    SUM(IIF(MONTH(NgayKetThuc) = 2 , ChiTietPhieuDB.Soluong , 0)) as Thang2,
    SUM(IIF(MONTH(NgayKetThuc) = 3 , ChiTietPhieuDB.Soluong , 0)) as Thang3,
    SUM(IIF(MONTH(NgayKetThuc) = 4 , ChiTietPhieuDB.Soluong , 0)) as Thang4,
    SUM(IIF(MONTH(NgayKetThuc) = 5 , ChiTietPhieuDB.Soluong , 0)) as Thang5,
    SUM(IIF(MONTH(NgayKetThuc) = 6 , ChiTietPhieuDB.Soluong , 0)) as Thang6,
    SUM(IIF(MONTH(NgayKetThuc) = 7 , ChiTietPhieuDB.Soluong , 0)) as Thang7,
    SUM(IIF(MONTH(NgayKetThuc) = 8 , ChiTietPhieuDB.Soluong , 0)) as Thang8,
    SUM(IIF(MONTH(NgayKetThuc) = 9 , ChiTietPhieuDB.Soluong , 0)) as Thang9,
    SUM(IIF(MONTH(NgayKetThuc) = 10 , ChiTietPhieuDB.Soluong , 0)) as Thang10,
    SUM(IIF(MONTH(NgayKetThuc) = 11 , ChiTietPhieuDB.Soluong , 0)) as Thang11,
    SUM(IIF(MONTH(NgayKetThuc) = 12 , ChiTietPhieuDB.Soluong , 0)) as Thang12,
    SUM(ChiTietPhieuDB.Soluong) as N'Cả năm'
from PhieuDatBan
join ChiTietPhieuDB on PhieuDatBan.MaPhieu = ChiTietPhieuDB.MaPhieu
join MonAn on MonAn.MaMonAn = ChiTietPhieuDB.MaMonAn
where YEAR(NgayKetThuc) = @nam
group by ChiTietPhieuDB.MaMonAn , TenMonAn)
GO
/****** Object:  UserDefinedFunction [dbo].[DangNhap]    Script Date: 11/25/2020 2:24:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE function [dbo].[DangNhap](@TenTaiKhoan nvarchar(MAX),@MatKhau nvarchar(MAX))
returns Table
as

	return select * from TaiKhoan where TenTaiKhoan = @TenTaiKhoan and MatKhau like (SELECT CONVERT(NVARCHAR(32),HashBytes('MD5', @MatKhau),2))

GO
/****** Object:  Table [dbo].[ChiTietHDN]    Script Date: 11/25/2020 2:24:02 PM ******/
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
/****** Object:  Table [dbo].[HoaDonNhap]    Script Date: 11/25/2020 2:24:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonNhap](
	[MaHDN] [nvarchar](10) NOT NULL,
	[MaNV] [nvarchar](10) NOT NULL,
	[HoTenNV] [nvarchar](50) NOT NULL,
	[MaNCC] [nvarchar](10) NOT NULL,
	[NgayNhap] [date] NOT NULL,
	[KhuyenMai] [int] NULL,
	[DVKM] [nvarchar](10) NULL,
	[ThanhTien] [int] NOT NULL,
 CONSTRAINT [PK__HoaDonNh__3C90E8C68B4C4AA6] PRIMARY KEY CLUSTERED 
(
	[MaHDN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/25/2020 2:24:02 PM ******/
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
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 11/25/2020 2:24:02 PM ******/
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
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 11/25/2020 2:24:02 PM ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/25/2020 2:24:02 PM ******/
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
	[MatKhau] [nvarchar](max) NOT NULL,
	[Quyen] [bit] NULL,
 CONSTRAINT [PK__NhanVien__2725D70A4C549481] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 11/25/2020 2:24:02 PM ******/
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
/****** Object:  Table [dbo].[ThongTinBan]    Script Date: 11/25/2020 2:24:02 PM ******/
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
INSERT [dbo].[ChiTietPhieuDB] ([MaPhieu], [MaMonAn], [SoLuong], [TongTien], [DonGia]) VALUES (N'HDB0001', N'MonAn001', 1, 50000, 50000)
GO
INSERT [dbo].[ChiTietPhieuDB] ([MaPhieu], [MaMonAn], [SoLuong], [TongTien], [DonGia]) VALUES (N'HDB0001', N'MonAn003', 2, 40000, 20000)
GO
INSERT [dbo].[ChiTietPhieuDB] ([MaPhieu], [MaMonAn], [SoLuong], [TongTien], [DonGia]) VALUES (N'HDB0001', N'MonAn004', 2, 40000, NULL)
GO
INSERT [dbo].[ChiTietPhieuDB] ([MaPhieu], [MaMonAn], [SoLuong], [TongTien], [DonGia]) VALUES (N'HDB0001', N'MonAn005', 1, 20000, NULL)
GO
INSERT [dbo].[KhachHang] ([MaKH], [HoTenKH], [GioiTinh], [SDT], [QuanHe]) VALUES (N'KH001', N'Nguyễn Hải Nam', 0, N'0964321028', N'Bình thường')
GO
INSERT [dbo].[KhachHang] ([MaKH], [HoTenKH], [GioiTinh], [SDT], [QuanHe]) VALUES (N'KH002', N'Nguyễn Thị Xuân', NULL, N'0928312731', N'Bình thường')
GO
INSERT [dbo].[KhachHang] ([MaKH], [HoTenKH], [GioiTinh], [SDT], [QuanHe]) VALUES (N'KH003', N'Nguyễn Thị Tuyết', NULL, N'0928312732', N'Bình thường')
GO
INSERT [dbo].[KhachHang] ([MaKH], [HoTenKH], [GioiTinh], [SDT], [QuanHe]) VALUES (N'KH004   ', N'Nguyễn Hải Đăng', NULL, N'0964321029', N'Bình thường')
GO
INSERT [dbo].[KhachHang] ([MaKH], [HoTenKH], [GioiTinh], [SDT], [QuanHe]) VALUES (N'KH005   ', N'Nguyễn Hải Long', NULL, N'0964321030', N'Bình thường')
GO
INSERT [dbo].[KhachHang] ([MaKH], [HoTenKH], [GioiTinh], [SDT], [QuanHe]) VALUES (N'KH006   ', N'Nguyễn Hải Vân', NULL, N'0964321031', N'Bình thường')
GO
INSERT [dbo].[KhachHang] ([MaKH], [HoTenKH], [GioiTinh], [SDT], [QuanHe]) VALUES (N'KH007   ', N'Nguyễn Thị Quyên', NULL, N'0928312740', N'Bình thường')
GO
INSERT [dbo].[KhachHang] ([MaKH], [HoTenKH], [GioiTinh], [SDT], [QuanHe]) VALUES (N'KH008   ', N'Nguyễn Hải Long', NULL, N'0219382938', N'Bình thường')
GO
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [Chitiet], [NgayBatDau], [NgayKetThuc], [GiaTriKM], [DVKM], [GiaTriBatDau], [GiaTriKetThuc]) VALUES (N'KM001', N'0', N'Không khuyến mãi', CAST(N'2020-01-01' AS Date), CAST(N'2099-01-01' AS Date), 0, N'VND', 0, 1000000000)
GO
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [Chitiet], [NgayBatDau], [NgayKetThuc], [GiaTriKM], [DVKM], [GiaTriBatDau], [GiaTriKetThuc]) VALUES (N'KM002', N'Giảm 5%', N'Giảm 5% cho hóa đơn trên 500000', CAST(N'2020-01-10' AS Date), CAST(N'2020-12-12' AS Date), 5, N'%', 500000, 999000)
GO
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [Chitiet], [NgayBatDau], [NgayKetThuc], [GiaTriKM], [DVKM], [GiaTriBatDau], [GiaTriKetThuc]) VALUES (N'KM003', N'Giảm 10%', N'Giảm 10% cho hóa đơn trên 1500000', CAST(N'2020-01-10' AS Date), CAST(N'2020-12-12' AS Date), 10, N'%', 1500000, 5000000)
GO
INSERT [dbo].[LoaiNguyenLieu] ([MaLoai], [TenLoai]) VALUES (N'Loai01', N'Thịt')
GO
INSERT [dbo].[LoaiNguyenLieu] ([MaLoai], [TenLoai]) VALUES (N'Loai02', N'Hải sản')
GO
INSERT [dbo].[LoaiNguyenLieu] ([MaLoai], [TenLoai]) VALUES (N'Loai03', N'Rau quả')
GO
INSERT [dbo].[LoaiNguyenLieu] ([MaLoai], [TenLoai]) VALUES (N'Loai04', N'Đồ uống')
GO
INSERT [dbo].[LoaiNguyenLieu] ([MaLoai], [TenLoai]) VALUES (N'Loai05', N'Mì và Bánh')
GO
INSERT [dbo].[LoaiNguyenLieu] ([MaLoai], [TenLoai]) VALUES (N'Loai06', N'Trứng')
GO
INSERT [dbo].[LoaiNguyenLieu] ([MaLoai], [TenLoai]) VALUES (N'Loai07', N'Gia vị')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn001  ', N'Rượu Soju', 50000, N'MonAn1.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn002  ', N'Bia', 25000, N'MonAn2.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn003  ', N'Trà Đào Cam Sả', 20000, N'MonAn3.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn004  ', N'Trà Chanh Bạc Hà', 20000, N'MonAn4.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn005  ', N'Trà Hoa Cúc', 20000, N'MonAn5.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn006  ', N'Nước Ép Dưa Hấu', 15000, N'MonAn6.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn007  ', N'Hamburger', 15000, N'MonAn7.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn008  ', N'Phở Bò', 25000, N'MonAn8.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn009  ', N'Gỏi Cuốn Tôm', 25000, N'MonAn9.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn010  ', N'Cua Hấp', 75000, N'MonAn10.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn011  ', N'Trà Chanh Nóng', 15000, N'MonAn11.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn012  ', N'Nước Chanh Leo', 25000, N'MonAn12.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn013  ', N'Bánh Tráng Nướng', 30000, N'MonAn13.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn014  ', N'Bún Chả', 30000, N'MonAn14.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn015  ', N'Trà Sữa', 40000, N'MonAn15.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn016  ', N'Bánh Tôm', 35000, N'MonAn16.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn017  ', N'Salad Trứng', 25000, N'MonAn17.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn018  ', N'Salad Dứa', 25000, N'MonAn18.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn019  ', N'Salad Bơ', 35000, N'MonAn19.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn020  ', N'Salad Cá Hồi', 55000, N'MonAn20.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn021  ', N'Mì Trộn Salad', 35000, N'MonAn21.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn022  ', N'Nộm Bò Khô', 15000, N'MonAn22.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn023  ', N'Nộm Sứa', 23000, N'MonAn23.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn024  ', N'Nộm Ngó Sen', 45000, N'MonAn24.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn025  ', N'Bánh Mì', 20000, N'MonAn25.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn026  ', N'Mì Ý', 25000, N'MonAn26.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn027  ', N'Mì Udon', 25000, N'MonAn27.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn028  ', N'Mì Cay', 25000, N'MonAn28.jpg')
GO
INSERT [dbo].[MonAn] ([MaMonAn], [TenMonAn], [DonGia], [AnhMonAn]) VALUES (N'MonAn29   ', N'Sườn Xào Chua Ngọt', 25000, N'MonAn29.jpg')
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL001', N'Sườn Heo', N'kg', N'Loai01', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL002', N'Dưa Hấu', N'kg', N'Loai03', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL003', N'Thịt Heo', N'kg', N'Loai01', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL004', N'Cà Chua', N'kg', N'Loai03', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL005', N'Xà lách', N'kg', N'Loai03', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL006', N'Vỏ Bánh Mì', N'kg', N'Loai05', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL007', N'Mì Udon', N'kg', N'Loai05', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL008', N'Mì Ống', N'kg', N'Loai05', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL009', N'Búp Chuối', N'kg', N'Loai03', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL010', N'Đu Đủ', N'kg', N'Loai03', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL011', N'Sữa', N'lít', N'Loai04', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL012', N'Cá Hồi', N'kg', N'Loai02', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL013', N'Xúc Xích', N'kg', N'Loai01', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL014', N'Tôm', N'kg', N'Loai02', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL015', N'Nước Mắm', N'lít', N'Loai07', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL016', N'Rượu', N'lít', N'Loai04', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL017', N'Bia', N'lít', N'Loai04', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL018', N'Trứng gà', N'kg', N'Loai06', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL019', N'Muối', N'g', N'Loai07', NULL, 50)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL020', N'Rượu Soju', N'lít', N'Loai04', NULL, 49.5)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL021', N'Trà', N'kg', N'Loai04', NULL, 49.7)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL022', N'Cam', N'kg', N'Loai03', NULL, 49)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL023', N'Chanh', N'kg', N'Loai03', NULL, 49)
GO
INSERT [dbo].[NguyenLieu] ([MaNguyenLieu], [TenNguyenLieu], [DVT], [MaLoai], [GhiChu], [SoLuong]) VALUES (N'NL024', N'Trân châu', N'g', N'Loai04', NULL, 50)
GO
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT], [MaSoThue]) VALUES (N'NCC001', N'Vinmart', N'HaNoi', 123092309, 213123213)
GO
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT], [MaSoThue]) VALUES (N'NCC002', N'Meatdeli', N'HaNoi', 231231231, 213123122)
GO
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT], [MaSoThue]) VALUES (N'NCC003', N'Now', N'Sài Gòn', 9876567, 123432343)
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [CMT], [SDT], [NgaySinh], [DiaChi], [QueQuan], [AnhNV], [NgayBatDau], [NgayKetThuc], [TinhTrang], [MatKhau], [Quyen]) VALUES (N'NV001', N'Nguyễn Thị Nguyệt', 1, N'013680357', N'0345789201', CAST(N'2000-08-25' AS Date), N'Hà Nội', N'Hà Nội', N'NV001.jpg', CAST(N'2018-04-11' AS Date), NULL, N'Đang làm', N'202CB962AC59075B964B07152D234B70', 1)
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [CMT], [SDT], [NgaySinh], [DiaChi], [QueQuan], [AnhNV], [NgayBatDau], [NgayKetThuc], [TinhTrang], [MatKhau], [Quyen]) VALUES (N'NV002', N'Nguyễn Văn Hiếu', 0, N'012498273', N'0987261728', CAST(N'1999-06-02' AS Date), N'Ô Chợ Dừa, Hà Nội', N'Hà Nội', N'NV002.jpg', CAST(N'2019-06-25' AS Date), NULL, N'Đang làm', N'202CB962AC59075B964B07152D234B70', 0)
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [CMT], [SDT], [NgaySinh], [DiaChi], [QueQuan], [AnhNV], [NgayBatDau], [NgayKetThuc], [TinhTrang], [MatKhau], [Quyen]) VALUES (N'NV003', N'sadasd', 1, N'213123   ', N'12312312  ', CAST(N'2020-11-24' AS Date), N'213123', N'3213123', N'NV021.jpg', CAST(N'2020-11-24' AS Date), NULL, N'Đang làm', N'202CB962AC59075B964B07152D234B70', 0)
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [CMT], [SDT], [NgaySinh], [DiaChi], [QueQuan], [AnhNV], [NgayBatDau], [NgayKetThuc], [TinhTrang], [MatKhau], [Quyen]) VALUES (N'NV004', N'Vũ Thị Đào', 1, N'028361521', N'0381726372', CAST(N'1994-07-02' AS Date), N'Hà Nội', N'Hà Nội', N'NV007.jpg', CAST(N'2020-01-01' AS Date), CAST(N'2020-11-25' AS Date), N'Thôi việc', N'202CB962AC59075B964B07152D234B70', 0)
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [CMT], [SDT], [NgaySinh], [DiaChi], [QueQuan], [AnhNV], [NgayBatDau], [NgayKetThuc], [TinhTrang], [MatKhau], [Quyen]) VALUES (N'NV005', N'Nguyễn Thị Xuân', 1, N'019273615', N'0293715243', CAST(N'1996-09-10' AS Date), N'Quảng Ninh', N'Quảng Ninh', N'NV005.jpg', CAST(N'2019-01-01' AS Date), NULL, N'Đang làm', N'202CB962AC59075B964B07152D234B70', 0)
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [CMT], [SDT], [NgaySinh], [DiaChi], [QueQuan], [AnhNV], [NgayBatDau], [NgayKetThuc], [TinhTrang], [MatKhau], [Quyen]) VALUES (N'NV006', N'Cao Thị Duyên', 1, N'029183612', N'0192735172', CAST(N'1996-09-10' AS Date), N'Đà Nẵng', N'Đà Nẵng', N'NV006.jpg', CAST(N'2019-01-01' AS Date), CAST(N'2020-11-25' AS Date), N'Thôi việc', N'202CB962AC59075B964B07152D234B70', 0)
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [CMT], [SDT], [NgaySinh], [DiaChi], [QueQuan], [AnhNV], [NgayBatDau], [NgayKetThuc], [TinhTrang], [MatKhau], [Quyen]) VALUES (N'NV007', N'Nguyễn Thu Huyền', 1, N'019273512', N'1231231234', CAST(N'1999-11-23' AS Date), N'Hà Nội', N'Hà Nội', N'NV010.jpg', CAST(N'2019-11-23' AS Date), NULL, N'Đang làm', N'202CB962AC59075B964B07152D234B70', 0)
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [CMT], [SDT], [NgaySinh], [DiaChi], [QueQuan], [AnhNV], [NgayBatDau], [NgayKetThuc], [TinhTrang], [MatKhau], [Quyen]) VALUES (N'NV008', N'Cao Xuân Tuyền', 1, N'029137516', N'0293712541', CAST(N'1998-01-01' AS Date), N'Hà Nội', N'Lạng Sơn', N'NV008.jpg', CAST(N'2020-01-01' AS Date), NULL, N'Đang làm', N'202CB962AC59075B964B07152D234B70', 0)
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [CMT], [SDT], [NgaySinh], [DiaChi], [QueQuan], [AnhNV], [NgayBatDau], [NgayKetThuc], [TinhTrang], [MatKhau], [Quyen]) VALUES (N'NV009', N'Lương Xuân Phương', 1, N'018263514', N'0293715241', CAST(N'1996-09-10' AS Date), N'Hà Nội', N'Hải Dương', N'NV009.jpg', CAST(N'2020-01-01' AS Date), NULL, N'Đang làm', N'202CB962AC59075B964B07152D234B70', 0)
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [CMT], [SDT], [NgaySinh], [DiaChi], [QueQuan], [AnhNV], [NgayBatDau], [NgayKetThuc], [TinhTrang], [MatKhau], [Quyen]) VALUES (N'NV010', N'Nguyễn Thu Uyên', 1, N'019273524', N'9273615242', CAST(N'1992-01-28' AS Date), N'Hà Nội', N'Hải Dương', N'NV010.jpg', CAST(N'2020-01-01' AS Date), CAST(N'2020-01-09' AS Date), N'Thôi việc', N'123', NULL)
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [CMT], [SDT], [NgaySinh], [DiaChi], [QueQuan], [AnhNV], [NgayBatDau], [NgayKetThuc], [TinhTrang], [MatKhau], [Quyen]) VALUES (N'NV011', N'Nguyễn Thu Phương', 1, N'029371525', N'0283615241', CAST(N'1992-02-28' AS Date), N'Hà Nội', N'Hải Dương', N'NV011.jpg', CAST(N'2020-01-01' AS Date), CAST(N'2020-01-09' AS Date), N'Thôi việc', N'123', NULL)
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [CMT], [SDT], [NgaySinh], [DiaChi], [QueQuan], [AnhNV], [NgayBatDau], [NgayKetThuc], [TinhTrang], [MatKhau], [Quyen]) VALUES (N'NV012', N'Nguyễn Anh Tuấn', 0, N'203816253', N'8231426312', CAST(N'1992-09-29' AS Date), N'Hà Nội', N'Hải Dương', N'NV012.jpg', CAST(N'2020-01-01' AS Date), CAST(N'2019-11-23' AS Date), N'Thôi việc', N'202CB962AC59075B964B07152D234B70', 0)
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [CMT], [SDT], [NgaySinh], [DiaChi], [QueQuan], [AnhNV], [NgayBatDau], [NgayKetThuc], [TinhTrang], [MatKhau], [Quyen]) VALUES (N'NV013', N'Nguyễn Xuân Hoài', 1, N'021812389', N'1238123798', CAST(N'2020-11-24' AS Date), N'Hà Nội', N'Hà Nội', N'NV013.jpg', CAST(N'2020-11-23' AS Date), CAST(N'2020-11-23' AS Date), N'Thôi việc', N'BCDFAB4C3172519BB92EB15AC89DF132', 0)
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [CMT], [SDT], [NgaySinh], [DiaChi], [QueQuan], [AnhNV], [NgayBatDau], [NgayKetThuc], [TinhTrang], [MatKhau], [Quyen]) VALUES (N'NV014', N'Nguyễn Xuân Hoài', 1, N'321312   ', N'123123    ', CAST(N'2020-11-25' AS Date), N'123123', N'123123', N'NV014.jpg', CAST(N'2020-11-24' AS Date), NULL, N'Đang làm', N'9C360143E503888FC1F497A1E5DCC1B4', 0)
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [CMT], [SDT], [NgaySinh], [DiaChi], [QueQuan], [AnhNV], [NgayBatDau], [NgayKetThuc], [TinhTrang], [MatKhau], [Quyen]) VALUES (N'NV015', N'Nguyễn Thu Hoài', 1, N'213123123', N'2123123213', CAST(N'2020-08-24' AS Date), N'123123', N'213123', N'NV015.jpg', CAST(N'2020-11-24' AS Date), NULL, N'Đang làm', N'86E8652E3D8B011ACA952D9CBD8043F8', 0)
GO
INSERT [dbo].[PhieuCheBien] ([MaMonAn], [MaNguyenLieu], [SoLuong]) VALUES (N'MonAn001', N'NL020', 0.5)
GO
INSERT [dbo].[PhieuCheBien] ([MaMonAn], [MaNguyenLieu], [SoLuong]) VALUES (N'MonAn002', N'NL017', 0.25)
GO
INSERT [dbo].[PhieuCheBien] ([MaMonAn], [MaNguyenLieu], [SoLuong]) VALUES (N'MonAn003', N'NL021', 0.1)
GO
INSERT [dbo].[PhieuCheBien] ([MaMonAn], [MaNguyenLieu], [SoLuong]) VALUES (N'MonAn003', N'NL022', 0.5)
GO
INSERT [dbo].[PhieuCheBien] ([MaMonAn], [MaNguyenLieu], [SoLuong]) VALUES (N'MonAn004', N'NL021', 0.1)
GO
INSERT [dbo].[PhieuCheBien] ([MaMonAn], [MaNguyenLieu], [SoLuong]) VALUES (N'MonAn004', N'NL023', 0.5)
GO
INSERT [dbo].[PhieuCheBien] ([MaMonAn], [MaNguyenLieu], [SoLuong]) VALUES (N'MonAn005', N'NL021', 0.3)
GO
INSERT [dbo].[PhieuCheBien] ([MaMonAn], [MaNguyenLieu], [SoLuong]) VALUES (N'MonAn006', N'NL002', 0.3)
GO
INSERT [dbo].[PhieuCheBien] ([MaMonAn], [MaNguyenLieu], [SoLuong]) VALUES (N'MonAn007', N'NL006', 0.2)
GO
INSERT [dbo].[PhieuCheBien] ([MaMonAn], [MaNguyenLieu], [SoLuong]) VALUES (N'MonAn008', N'NL008', 0.5)
GO
INSERT [dbo].[PhieuCheBien] ([MaMonAn], [MaNguyenLieu], [SoLuong]) VALUES (N'MonAn018', N'NL005', 0.2)
GO
INSERT [dbo].[PhieuDatBan] ([MaPhieu], [MaKH], [MaNV], [HoTenNV], [MaKM], [Chitiet], [GiaTriKM], [DVKM], [MaBan], [NgayDat], [NgayDung], [NgayKetThuc], [ThanhTien]) VALUES (N'HDB0001', N'KH001', N'NV003', NULL, N'KM001', NULL, NULL, NULL, N'Ban101', CAST(N'2020-11-10T00:00:00.000' AS DateTime), CAST(N'2020-11-14T00:00:00.000' AS DateTime), CAST(N'2020-11-14T01:00:00.000' AS DateTime), 150000)
GO
INSERT [dbo].[PhieuDatBan] ([MaPhieu], [MaKH], [MaNV], [HoTenNV], [MaKM], [Chitiet], [GiaTriKM], [DVKM], [MaBan], [NgayDat], [NgayDung], [NgayKetThuc], [ThanhTien]) VALUES (N'HDB0002', N'KH002', N'NV002', N'Nguyễn Văn Hiếu', N'KM001', NULL, NULL, NULL, N'Ban201', CAST(N'2020-11-10T00:00:00.000' AS DateTime), CAST(N'2020-11-14T00:00:00.000' AS DateTime), CAST(N'2020-11-14T00:00:00.000' AS DateTime), 0)
GO
INSERT [dbo].[PhieuDatBan] ([MaPhieu], [MaKH], [MaNV], [HoTenNV], [MaKM], [Chitiet], [GiaTriKM], [DVKM], [MaBan], [NgayDat], [NgayDung], [NgayKetThuc], [ThanhTien]) VALUES (N'HDB0003 ', N'KH001', N'NV002', N'Nguyễn Văn Hiếu', NULL, NULL, NULL, NULL, N'Ban102', CAST(N'2020-11-25T00:00:00.000' AS DateTime), CAST(N'2020-11-25T00:00:00.000' AS DateTime), NULL, NULL)
GO
INSERT [dbo].[PhieuDatBan] ([MaPhieu], [MaKH], [MaNV], [HoTenNV], [MaKM], [Chitiet], [GiaTriKM], [DVKM], [MaBan], [NgayDat], [NgayDung], [NgayKetThuc], [ThanhTien]) VALUES (N'HDB0004 ', N'KH003', N'NV001', N'Nguyễn Thị Nguyệt', NULL, NULL, NULL, NULL, N'Ban103', CAST(N'2020-11-25T00:00:00.000' AS DateTime), CAST(N'2020-11-25T00:00:00.000' AS DateTime), NULL, NULL)
GO
INSERT [dbo].[PhieuDatBan] ([MaPhieu], [MaKH], [MaNV], [HoTenNV], [MaKM], [Chitiet], [GiaTriKM], [DVKM], [MaBan], [NgayDat], [NgayDung], [NgayKetThuc], [ThanhTien]) VALUES (N'HDB0005 ', N'KH001', N'NV002', N'Nguyễn Văn Hiếu', NULL, NULL, NULL, NULL, N'Ban106', CAST(N'2020-11-25T00:00:00.000' AS DateTime), CAST(N'2020-11-25T00:00:00.000' AS DateTime), NULL, NULL)
GO
INSERT [dbo].[PhieuDatBan] ([MaPhieu], [MaKH], [MaNV], [HoTenNV], [MaKM], [Chitiet], [GiaTriKM], [DVKM], [MaBan], [NgayDat], [NgayDung], [NgayKetThuc], [ThanhTien]) VALUES (N'HDB0006 ', N'KH001', N'NV002', N'Nguyễn Văn Hiếu', NULL, NULL, NULL, NULL, N'Ban107', CAST(N'2020-11-25T00:00:00.000' AS DateTime), CAST(N'2020-11-25T00:00:00.000' AS DateTime), NULL, NULL)
GO
INSERT [dbo].[Phong] ([MaPhong], [TenPhong]) VALUES (N'Phong1', N'A')
GO
INSERT [dbo].[Phong] ([MaPhong], [TenPhong]) VALUES (N'Phong2', N'B')
GO
INSERT [dbo].[Phong] ([MaPhong], [TenPhong]) VALUES (N'Phong3', N'C')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban101', N'Phong1', N'1')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban102', N'Phong1', N'2')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban103', N'Phong1', N'3')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban104', N'Phong1', N'4')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban105', N'Phong1', N'5')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban106', N'Phong1', N'6')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban107', N'Phong1', N'7')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban108', N'Phong1', N'8')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban109', N'Phong1', N'9')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban110', N'Phong1', N'10')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban111', N'Phong1', N'11')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban112', N'Phong1', N'12')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban113', N'Phong1', N'13')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban114', N'Phong1', N'14')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban115', N'Phong1', N'15')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban116', N'Phong1', N'16')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban117', N'Phong1', N'17')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban118', N'Phong1', N'18')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban119', N'Phong1', N'19')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban120', N'Phong1', N'20')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban201', N'Phong2', N'1')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban202', N'Phong2', N'2')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban203', N'Phong2', N'3')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban204', N'Phong2', N'4')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban205', N'Phong2', N'5')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban206', N'Phong2', N'6')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban207', N'Phong2', N'7')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban208', N'Phong2', N'8')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban209', N'Phong2', N'9')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban210', N'Phong2', N'10')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban211', N'Phong2', N'11')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban212', N'Phong2', N'12')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban213', N'Phong2', N'13')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban214', N'Phong2', N'14')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban215', N'Phong2', N'15')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban216', N'Phong2', N'16')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban217', N'Phong2', N'17')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban218', N'Phong2', N'18')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban301', N'Phong3', N'1')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban302', N'Phong3', N'2')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban303', N'Phong3', N'3')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban304', N'Phong3', N'4')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban305', N'Phong3', N'5')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban306', N'Phong3', N'6')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban307', N'Phong3', N'7')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban308', N'Phong3', N'8')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban309', N'Phong3', N'9')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban310', N'Phong3', N'10')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban311', N'Phong3', N'11')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban312', N'Phong3', N'12')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban313', N'Phong3', N'13')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban314', N'Phong3', N'14')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban315', N'Phong3', N'15')
GO
INSERT [dbo].[ThongTinBan] ([MaBan], [MaPhong], [SoBan]) VALUES (N'Ban316', N'Phong3', N'16')
GO
ALTER TABLE [dbo].[KhachHang] ADD  CONSTRAINT [DF_KhachHang_QuanHe]  DEFAULT (N'Bình thường') FOR [QuanHe]
GO
ALTER TABLE [dbo].[NguyenLieu] ADD  CONSTRAINT [DF_NguyenLieu_SoLuong]  DEFAULT ((0)) FOR [SoLuong]
GO
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [DF__NhanVien__TinhTr__3B75D760]  DEFAULT (N'Đang làm') FOR [TinhTrang]
GO
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [DF_NhanVien_MatKhau]  DEFAULT ((123)) FOR [MatKhau]
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
/****** Object:  StoredProcedure [dbo].[DoanhThuTheoThang]    Script Date: 11/25/2020 2:24:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[DoanhThuTheoThang] @Thang int,@ThanhTien int output
as
begin
	select @ThanhTien=SUM(SoLuong*DonGia) from PhieuDatBan join ChiTietPhieuDB on PhieuDatBan.MaPhieu=ChiTietPhieuDB.MaPhieu
	where MONTH(NgayDung)=@Thang
end 
GO
/****** Object:  StoredProcedure [dbo].[DoiMatKhau]    Script Date: 11/25/2020 2:24:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[DoiMatKhau] @MaNV nvarchar(10),@MatKhauCu nvarchar(MAX),@MatKhauMoi nvarchar(MAX),@NhapLaiMatKhau nvarchar(MAX)
as
begin
	declare @XNMK nvarchar(MAX)
	select @XNMK=MatKhau from NhanVien where MaNV=@MaNV
	if(@MatKhauMoi=@NhapLaiMatKhau and CONVERT(NVARCHAR(32),HashBytes('MD5',@MatKhauCu),2) like @XNMK and @MatKhauMoi!='')
	begin
		update NhanVien set MatKhau=CONVERT(NVARCHAR(32),HashBytes('MD5',@MatKhauMoi),2) where MaNV=@MaNV
	end
end
GO
/****** Object:  StoredProcedure [dbo].[KiemTraDangNhap]    Script Date: 11/25/2020 2:24:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[KiemTraDangNhap] @TaiKhoan nvarchar(10),@MatKhau nvarchar(MAX),@ISTRUE int output
as
begin
	declare @XNMK nvarchar(MAX)
	select @XNMK=MatKhau from NhanVien where MaNV=@TaiKhoan
	if(@XNMK=CONVERT(NVARCHAR(32),HashBytes('MD5',TRIM(CAST(@MatKhau as nvarchar(MAX)))),2))
	set @ISTRUE=1
	else set @ISTRUE=0
end
GO
/****** Object:  StoredProcedure [dbo].[SoTienKH]    Script Date: 11/25/2020 2:24:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[SoTienKH] @MAKH nvarchar(10),@ThanhTien int output
as
begin
	select @ThanhTien=SUM(SoLuong*DonGia) from PhieuDatBan join ChiTietPhieuDB on PhieuDatBan.MaPhieu=ChiTietPhieuDB.MaPhieu
	where MaKH=@MAKH
end
GO
USE [master]
GO
ALTER DATABASE [Restaurant] SET  READ_WRITE 
GO
