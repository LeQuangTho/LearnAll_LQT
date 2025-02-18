USE [master]
GO
/****** Object:  Database [QuanLyKho]    Script Date: 2021-05-09 2:01:16 PM ******/
CREATE DATABASE [QuanLyKho]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyKho', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLyKho.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyKho_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLyKho_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QuanLyKho] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyKho].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyKho] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyKho] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyKho] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyKho] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyKho] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyKho] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QuanLyKho] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyKho] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyKho] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyKho] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyKho] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyKho] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyKho] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyKho] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyKho] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyKho] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyKho] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyKho] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyKho] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyKho] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyKho] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyKho] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyKho] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyKho] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyKho] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyKho] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyKho] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyKho] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyKho] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyKho] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLyKho] SET QUERY_STORE = OFF
GO
USE [QuanLyKho]
GO
/****** Object:  Table [dbo].[ClipboardDetailBill]    Script Date: 2021-05-09 2:01:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ClipboardDetailBill](
	[IdProductList] [bigint] NOT NULL,
	[Amount] [int] NULL,
	[Price] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdProductList] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DeliveryBill]    Script Date: 2021-05-09 2:01:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DeliveryBill](
	[IdDeliveryBill] [nvarchar](50) NOT NULL,
	[IdUser] [nvarchar](20) NOT NULL,
	[DateCreate] [date] NOT NULL,
	[Total] [bigint] NULL,
	[Note] [nvarchar](max) NULL,
 CONSTRAINT [PK__Delivery__624164CC4FB9EAC8] PRIMARY KEY CLUSTERED 
(
	[IdDeliveryBill] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DetailDelivery]    Script Date: 2021-05-09 2:01:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetailDelivery](
	[IdDetailDelivery] [int] IDENTITY(1,1) NOT NULL,
	[IdDeliveryBill] [nvarchar](50) NOT NULL,
	[IdProductList] [bigint] NOT NULL,
	[DeliveryCount] [int] NOT NULL,
 CONSTRAINT [PK__DetailDe__0330C48FF98D6A98] PRIMARY KEY CLUSTERED 
(
	[IdDetailDelivery] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DetailReceipt]    Script Date: 2021-05-09 2:01:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetailReceipt](
	[IdDetailReceipt] [int] IDENTITY(1,1) NOT NULL,
	[IdReceiptBill] [nvarchar](50) NOT NULL,
	[IdProductList] [bigint] NOT NULL,
	[ReceiptCount] [int] NOT NULL,
	[Price] [bigint] NULL,
 CONSTRAINT [PK__DetailRe__20D3785DFEF849CE] PRIMARY KEY CLUSTERED 
(
	[IdDetailReceipt] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 2021-05-09 2:01:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[IdProduct] [nvarchar](20) NOT NULL,
	[ProductName] [nvarchar](max) NOT NULL,
	[ProductStatus] [nvarchar](10) NULL,
	[Img] [nvarchar](max) NULL,
	[IdProductList] [bigint] NULL,
 CONSTRAINT [PK__Product__2E8946D44A8B0C2B] PRIMARY KEY CLUSTERED 
(
	[IdProduct] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductCategory]    Script Date: 2021-05-09 2:01:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductCategory](
	[IdProductCategory] [bigint] IDENTITY(1,1) NOT NULL,
	[CategoryName] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK__ProductC__94B65A425D8C7C12] PRIMARY KEY CLUSTERED 
(
	[IdProductCategory] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductList]    Script Date: 2021-05-09 2:01:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductList](
	[IdProductList] [bigint] IDENTITY(1,1) NOT NULL,
	[ProductName] [nvarchar](max) NOT NULL,
	[Detail] [nvarchar](max) NULL,
	[ProductCount] [int] NULL,
	[Unit] [nvarchar](10) NULL,
	[IdProductCategory] [bigint] NOT NULL,
 CONSTRAINT [PK__ProductL__621BF117D804E030] PRIMARY KEY CLUSTERED 
(
	[IdProductList] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ReceiptBill]    Script Date: 2021-05-09 2:01:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReceiptBill](
	[IdReceiptBill] [nvarchar](50) NOT NULL,
	[IdUser] [nvarchar](20) NOT NULL,
	[IdSupplier] [int] NULL,
	[DateCreate] [date] NOT NULL,
	[Total] [bigint] NULL,
	[Note] [nvarchar](max) NULL,
 CONSTRAINT [PK__ReceiptB__9112B3EF95926E81] PRIMARY KEY CLUSTERED 
(
	[IdReceiptBill] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RoleUser]    Script Date: 2021-05-09 2:01:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RoleUser](
	[IdRoleUser] [int] NOT NULL,
	[Detail] [nvarchar](max) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRoleUser] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Supplier]    Script Date: 2021-05-09 2:01:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Supplier](
	[IdSupplier] [int] IDENTITY(1,1) NOT NULL,
	[NameSupplier] [nvarchar](max) NOT NULL,
	[Email] [nvarchar](max) NULL,
	[PhoneNumber] [nvarchar](10) NULL,
 CONSTRAINT [PK__Supplier__F2C105E8E0E1DEA9] PRIMARY KEY CLUSTERED 
(
	[IdSupplier] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 2021-05-09 2:01:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[IdUser] [nvarchar](20) NOT NULL,
	[NameUser] [nvarchar](max) NOT NULL,
	[Email] [nvarchar](max) NOT NULL,
	[PasswordUser] [nvarchar](20) NOT NULL,
	[PhoneNumber] [nvarchar](10) NULL,
	[IdRoleUser] [int] NOT NULL,
	[UserStatus] [nvarchar](50) NULL,
	[Gender] [bit] NULL,
	[Img] [nvarchar](max) NULL,
	[Place] [nvarchar](max) NULL,
 CONSTRAINT [PK__Users__B7C926380493DAD9] PRIMARY KEY CLUSTERED 
(
	[IdUser] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

Go
SET IDENTITY_INSERT [dbo].[ProductCategory] ON 
INSERT [dbo].[ProductCategory] ([IdProductCategory], [CategoryName]) VALUES (1, N'TiVi')
INSERT [dbo].[ProductCategory] ([IdProductCategory], [CategoryName]) VALUES (2, N'Máy tính')
INSERT [dbo].[ProductCategory] ([IdProductCategory], [CategoryName]) VALUES (3, N'Điện thoại')
GO
INSERT [dbo].[RoleUser] ([IdRoleUser], [Detail]) VALUES (0, N'Nhân Viên')
INSERT [dbo].[RoleUser] ([IdRoleUser], [Detail]) VALUES (1, N'Admin')
GO
SET IDENTITY_INSERT [dbo].[Supplier] ON 

INSERT [dbo].[Supplier] ([IdSupplier], [NameSupplier], [Email], [PhoneNumber]) VALUES (3, N'Sony', N'sony@gmail.com', N'0000000')
INSERT [dbo].[Supplier] ([IdSupplier], [NameSupplier], [Email], [PhoneNumber]) VALUES (4, N'SamSung', N'samsung@gmail.com', N'0000000')
INSERT [dbo].[Supplier] ([IdSupplier], [NameSupplier], [Email], [PhoneNumber]) VALUES (6, N'Panasonic', N'panasonic@gmail.com', N'0000000')
SET IDENTITY_INSERT [dbo].[Supplier] OFF
GO
INSERT [dbo].[Users] ([IdUser], [NameUser], [Email], [PasswordUser], [PhoneNumber], [IdRoleUser], [UserStatus], [Gender], [Img], [Place]) VALUES (N'An01', N'An Nguyen', N'akjzakj@gmail.com', N'1f4HDhFNkEI=', N'0987191143', 1, N'New', 1, N'1.png', N'Ninh Bình')
GO
ALTER TABLE [dbo].[Product] ADD  CONSTRAINT [DF__Product__Product__2B3F6F97]  DEFAULT ('SU DUNG') FOR [ProductStatus]
GO
ALTER TABLE [dbo].[Users] ADD  CONSTRAINT [DF__Users__UserStatu__300424B4]  DEFAULT ('HD') FOR [UserStatus]
GO
ALTER TABLE [dbo].[ClipboardDetailBill]  WITH CHECK ADD  CONSTRAINT [FK_ClipboardDetailBill_idProduct] FOREIGN KEY([IdProductList])
REFERENCES [dbo].[ProductList] ([IdProductList])
GO
ALTER TABLE [dbo].[ClipboardDetailBill] CHECK CONSTRAINT [FK_ClipboardDetailBill_idProduct]
GO
ALTER TABLE [dbo].[DeliveryBill]  WITH CHECK ADD  CONSTRAINT [FK__DeliveryB__IdUse__3C69FB99] FOREIGN KEY([IdUser])
REFERENCES [dbo].[Users] ([IdUser])
GO
ALTER TABLE [dbo].[DeliveryBill] CHECK CONSTRAINT [FK__DeliveryB__IdUse__3C69FB99]
GO
ALTER TABLE [dbo].[DetailDelivery]  WITH CHECK ADD  CONSTRAINT [FK__DetailDel__IdDel__3F466844] FOREIGN KEY([IdDeliveryBill])
REFERENCES [dbo].[DeliveryBill] ([IdDeliveryBill])
GO
ALTER TABLE [dbo].[DetailDelivery] CHECK CONSTRAINT [FK__DetailDel__IdDel__3F466844]
GO
ALTER TABLE [dbo].[DetailDelivery]  WITH CHECK ADD  CONSTRAINT [FK__DetailDel__IdPro__403A8C7D] FOREIGN KEY([IdProductList])
REFERENCES [dbo].[ProductList] ([IdProductList])
GO
ALTER TABLE [dbo].[DetailDelivery] CHECK CONSTRAINT [FK__DetailDel__IdPro__403A8C7D]
GO
ALTER TABLE [dbo].[DetailReceipt]  WITH CHECK ADD  CONSTRAINT [FK__DetailRec__IdPro__398D8EEE] FOREIGN KEY([IdProductList])
REFERENCES [dbo].[ProductList] ([IdProductList])
GO
ALTER TABLE [dbo].[DetailReceipt] CHECK CONSTRAINT [FK__DetailRec__IdPro__398D8EEE]
GO
ALTER TABLE [dbo].[DetailReceipt]  WITH CHECK ADD  CONSTRAINT [FK__DetailRec__IdRec__38996AB5] FOREIGN KEY([IdReceiptBill])
REFERENCES [dbo].[ReceiptBill] ([IdReceiptBill])
GO
ALTER TABLE [dbo].[DetailReceipt] CHECK CONSTRAINT [FK__DetailRec__IdRec__38996AB5]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK__Product__IdProdu__2C3393D0] FOREIGN KEY([IdProductList])
REFERENCES [dbo].[ProductList] ([IdProductList])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK__Product__IdProdu__2C3393D0]
GO
ALTER TABLE [dbo].[ProductList]  WITH CHECK ADD  CONSTRAINT [FK__ProductLi__IdPro__267ABA7A] FOREIGN KEY([IdProductCategory])
REFERENCES [dbo].[ProductCategory] ([IdProductCategory])
GO
ALTER TABLE [dbo].[ProductList] CHECK CONSTRAINT [FK__ProductLi__IdPro__267ABA7A]
GO
ALTER TABLE [dbo].[ReceiptBill]  WITH CHECK ADD  CONSTRAINT [FK__ReceiptBi__IdSup__35BCFE0A] FOREIGN KEY([IdSupplier])
REFERENCES [dbo].[Supplier] ([IdSupplier])
GO
ALTER TABLE [dbo].[ReceiptBill] CHECK CONSTRAINT [FK__ReceiptBi__IdSup__35BCFE0A]
GO
ALTER TABLE [dbo].[ReceiptBill]  WITH CHECK ADD  CONSTRAINT [FK__ReceiptBi__IdUse__34C8D9D1] FOREIGN KEY([IdUser])
REFERENCES [dbo].[Users] ([IdUser])
GO
ALTER TABLE [dbo].[ReceiptBill] CHECK CONSTRAINT [FK__ReceiptBi__IdUse__34C8D9D1]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK__Users__IdRoleUse__2F10007B] FOREIGN KEY([IdRoleUser])
REFERENCES [dbo].[RoleUser] ([IdRoleUser])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK__Users__IdRoleUse__2F10007B]
GO
USE [master]
GO
ALTER DATABASE [QuanLyKho] SET  READ_WRITE 
GO

CREATE TRIGGER UPDATERECEIPTBILL ON DetailReceipt FOR INSERT,UPDATE AS --1--
BEGIN
     DECLARE @TOTAL BIGINT,@IDBILL NVARCHAR(20), @slc INT
     SELECT @slc = ReceiptCount from deleted
     SELECT @IDBILL=IdReceiptBill from inserted
     SELECT @TOTAL=SUM(Price*ReceiptCount) FROM DetailReceipt WHERE @IDBILL=IdReceiptBill
     UPDATE ReceiptBill SET Total=@TOTAL WHERE @IDBILL=IdReceiptBill
     update ProductList set ProductCount  = isnull(ProductCount,0)-isnull(@slc,0)+(Select ReceiptCount from inserted) 
    where ProductList.IdProductList = (Select IdProductList from inserted ) 
END

 

GO

 

CREATE TRIGGER UPDATERECEIPTBILL1 ON DetailReceipt FOR DELETE AS --2--
BEGIN
     DECLARE @TOTAL BIGINT,@IDBILL NVARCHAR(20)
     SELECT @IDBILL=IdReceiptBill from deleted
     SELECT @TOTAL=SUM(Price*ReceiptCount) FROM DetailReceipt WHERE @IDBILL=IdReceiptBill
     UPDATE ReceiptBill SET Total=@TOTAL WHERE @IDBILL=IdReceiptBill
     update ProductList set ProductCount  = isnull(ProductCount,0)-(Select ReceiptCount from deleted) 
     where ProductList.IdProductList = (Select IdProductList from deleted )
END
GO
CREATE TRIGGER UPDATEPRODUCTLIST ON DetailDelivery FOR INSERT,UPDATE AS --3--
BEGIN
     DECLARE @slc INT
     SELECT @slc = DeliveryCount from deleted
     update ProductList set ProductCount  = isnull(ProductCount,0)+isnull(@slc,0)-(Select DeliveryCount from inserted) 
    where ProductList.IdProductList = (Select IdProductList from inserted ) 
END

 

GO

 

CREATE TRIGGER UPDATEPRODUCTLIST1 ON DetailDelivery FOR DELETE AS --4--
BEGIN
     update ProductList set ProductCount  = isnull(ProductCount,0)+(Select DeliveryCount from deleted) 
     where ProductList.IdProductList = (Select IdProductList from deleted )
END
GO