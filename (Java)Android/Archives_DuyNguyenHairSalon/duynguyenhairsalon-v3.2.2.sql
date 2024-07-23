-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 13, 2021 lúc 10:23 AM
-- Phiên bản máy phục vụ: 10.4.19-MariaDB
-- Phiên bản PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `duynguyenhairsalon`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `UserName` varchar(15) NOT NULL,
  `Password` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`UserName`, `Password`) VALUES
('+84394684487', '141220'),
('+84829764659', '141220'),
('+84971618116', '618116'),
('+84973271208', '141220'),
('+84974174629', '141220'),
('+84978679717', '141220');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `ID_Bill` varchar(20) NOT NULL,
  `Date_Bill` datetime NOT NULL,
  `Sum_Money_Bill` int(11) NOT NULL,
  `Shipping_Fee` int(11) NOT NULL,
  `Delivery_Address` varchar(250) NOT NULL,
  `Specific_Delivery_Address` int(250) NOT NULL,
  `Fast_Delivery` tinyint(1) NOT NULL,
  `Is_Successful` tinyint(1) NOT NULL,
  `ID_User` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `bill`
--

INSERT INTO `bill` (`ID_Bill`, `Date_Bill`, `Sum_Money_Bill`, `Shipping_Fee`, `Delivery_Address`, `Specific_Delivery_Address`, `Fast_Delivery`, `Is_Successful`, `ID_User`) VALUES
('B2171610128722', '2021-07-16 10:01:28', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 1, 0, 4),
('B21716101738137', '2021-07-16 10:17:38', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 4),
('B21716102836515', '2021-07-16 10:28:36', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 4),
('B21716103329362', '2021-07-16 10:33:29', 616000, 0, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 1, 0, 4),
('B2171695710459', '2021-07-16 09:57:10', 616000, 0, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 1, 0, 4),
('B2172181555326', '2021-07-02 18:15:55', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 1, 0, 7),
('B217294216849', '2021-07-02 09:42:16', 770000, 0, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 7),
('B2174214044695', '2021-07-04 21:40:44', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 1, 0, 7),
('B2182518195326', '2021-08-25 18:19:05', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 4),
('B2182721140778', '2021-08-27 21:14:00', 616000, 0, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 1, 0, 4),
('B21827211839520', '2021-08-27 21:18:39', 1232000, 0, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 1, 0, 4),
('B2199173445826', '2021-09-09 17:34:45', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 4),
('B2199174813733', '2021-09-09 17:48:13', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 4),
('B2199175010864', '2021-09-09 17:50:10', 616000, 0, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 5),
('B2199175315852', '2021-09-09 17:53:15', 616000, 0, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 5),
('B219917576757', '2021-09-09 17:57:06', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 5),
('B219918026581', '2021-09-09 18:00:26', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 5),
('B219918054704', '2021-09-09 18:00:54', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 5),
('B21991805911', '2021-09-09 18:00:05', 924000, 0, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 5),
('B219918324636', '2021-09-09 18:03:24', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 5),
('B2199211127447', '2021-09-09 21:11:27', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 5),
('B2199211236130', '2021-09-09 21:12:36', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 5),
('B2199211950168', '2021-09-09 21:19:50', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 5),
('B2199212046410', '2021-09-09 21:20:46', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 5),
('B2199214513749', '2021-09-09 21:45:13', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 5),
('B2199214540631', '2021-09-09 21:45:40', 338000, 30000, 'Xã Bình Minh, Huyện Khoái Châu, Hưng Yên', 0, 0, 0, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `descriptionbill`
--

CREATE TABLE `descriptionbill` (
  `Amount` int(11) NOT NULL,
  `ID_Bill` varchar(20) NOT NULL,
  `ID_Product` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `descriptionbill`
--

INSERT INTO `descriptionbill` (`Amount`, `ID_Bill`, `ID_Product`) VALUES
(1, 'B219918324636', 1),
(1, 'B2199211127447', 1),
(1, 'B2199211236130', 1),
(1, 'B2199211950168', 1),
(1, 'B2199212046410', 1),
(1, 'B2199214513749', 1),
(1, 'B2199214540631', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `descriptioncart`
--

CREATE TABLE `descriptioncart` (
  `Amount` int(11) NOT NULL,
  `ID_User` int(11) NOT NULL,
  `ID_Product` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `descriptioncart`
--

INSERT INTO `descriptioncart` (`Amount`, `ID_User`, `ID_Product`) VALUES
(4, 6, 1),
(1, 6, 2),
(2, 5, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `descriptiontask`
--

CREATE TABLE `descriptiontask` (
  `ID_Task` varchar(20) NOT NULL,
  `ID_Service` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `descriptiontask`
--

INSERT INTO `descriptiontask` (`ID_Task`, `ID_Service`) VALUES
('T217216222252', 1),
('T2174211647131', 1),
('T2174211647131', 10),
('T2174211647131', 14),
('T2174211647131', 13),
('T2174211647131', 15),
('T2174211647131', 16),
('T2174211647131', 17),
('T2174211647131', 18),
('T2171695545607', 1),
('T2171695545607', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `producer`
--

CREATE TABLE `producer` (
  `ID_Producer` varchar(20) NOT NULL,
  `Name_Brand` varchar(50) NOT NULL,
  `Origin` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `producer`
--

INSERT INTO `producer` (`ID_Producer`, `Name_Brand`, `Origin`) VALUES
('Davines', 'Davines', 'Ý'),
('Dr.Sante', 'Dr.Sante', 'Đông Âu'),
('Etiaxil', 'Etiaxil', 'Pháp'),
('Farcom', 'Farcom', 'Đông Âu'),
('FOGG', 'FOGG', 'Dubai'),
('Orzen', 'Orzen', 'Hàn Quốc'),
('Paul Mitchell', 'Paul Mitchell', 'Hàn Quốc'),
('TIGI', 'TIGI', 'Mỹ'),
('Updating', 'Đang cập nhật', 'Đang cập nhật');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `ID_Product` int(11) NOT NULL,
  `Name_Product` varchar(100) NOT NULL,
  `Price_Product` int(11) NOT NULL,
  `Amount_Product` int(11) NOT NULL,
  `Info_Product` text NOT NULL,
  `Description_Product` text NOT NULL,
  `Using_Product` text NOT NULL,
  `Image_Product` text DEFAULT NULL,
  `ID_SpeciesProduct` int(11) NOT NULL,
  `ID_Producer` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`ID_Product`, `Name_Product`, `Price_Product`, `Amount_Product`, `Info_Product`, `Description_Product`, `Using_Product`, `Image_Product`, `ID_SpeciesProduct`, `ID_Producer`) VALUES
(1, 'Dầu Gội Làm Sạch Và Điều Tiết Bã Nhờn Etiaxil Deo-Douche 24H 150ML', 308000, 100, 'Sản phẩm mới Etiaxil Deo-Shampoo nhẹ nhàng làm sạch da đầu và điều tiết bã nhờn bằng cách sử dụng muối kẽm, cân bằng lại hệ vi sinh vật trên da, khử mùi hôi.', 'Công Dụng:\r\n- Detox & cân bằng hệ sinh thái da đầu, ngăn ngừa tình trạng bết - nhờn - dính\r\n- Tiêu diệt vi khuẩn, mảng bám trên da, cải thiện mùi hôi da đầu.\r\n- Ngừa nấm da đầu & cải thiện tình trạng rụng tóc\r\nCông dụng lên đến 24h\r\n\r\nThành Phần:\r\n- Muối Zinc PCA: có công dụng kháng khuẩn, giảm tiết bã nhờn và trung hòa mùi cơ thể.\r\n- Phức hợp probiotic: có chứa Lactococcus Lactis-một loại lợi khuẩn cho da; giúp cải thiện hàng rào bảo vệ, kết nối giữa các tế bào, ức chế hại khuẩn gây mùi...\r\n- Chiết xuất dầu dừa: cấp ẩm cho da, tăng mức kháng khuẩn, làm mềm mịn và sạch da.\r\n- Phức hợp Fluidipure TM: là hỗn hợp đường và Glycerin Biovector tác động lên các vi khuẩn chịu trách nhiệm về mùi hôi và bã nhờn, cân bằng hệ khuẩn trên da đầu, chống mẩn ngứa, đỏ tấy. Bảo vệ acid thiên nhiên trên da đầu và các vi sinh vật trên da.', 'HDSD: Làm ướt tóc và da đầu, lấy 1 lượng vừa đủ ra tay và thoa đều khắp đầu tạo bọt, massage nhẹ nhàng. Gội sạch lại với nước.\r\nDùng 2-3 lần/ tuần', '[\"dau-goi-lam-sach-va-dieu-tiet-ba-nhon-etiaxil-deo-douche-24h-150ml.png\",\"dau-goi-lam-sach-va-dieu-tiet-ba-nhon-etiaxil-deo-douche-24h-150ml-1.png\",\"dau-goi-lam-sach-va-dieu-tiet-ba-nhon-etiaxil-deo-douche-24h-150ml-2.png\"]', 1, 'Etiaxil'),
(2, 'Xịt Dưỡng Tóc Davines Nourishing Keratin Sealer 100ml', 462000, 100, 'Dung dịch đóng chặt biểu bì dành cho tóc khô và tóc hư tổn.', 'NOURISHING KERATIN SEALER\r\nDung dịch đóng chặt biểu bì dành cho tóc khô và tóc hư tổn.\r\nDung dịch xả khô nuôi dưỡng bảo vệ giúp đóng chặt biểu bì, tăng cường độ bóng sáng và mềm mượt.\r\nTăng cường cấu trúc tóc, chống việc hình thành chẻ ngọn.\r\n\r\nCông thức vô cùng nhẹ, giàu Keratin Thực vật và amino axit, giúp khoá chặt các dưỡng chất (kể cả từ các bước trị liệu trước đó) ở bên trong sợi tóc lâu dài, cũng như đảm bảo độ bóng và mềm tối đa mà không làm nặng tóc.', 'Xịt đều lên tóc đã gội sạch & thấm khô bằng khăn bông, có thể dùng lược để phân bổ sản phẩm đều lên tóc. Tiếp tục các bước tạo kiểu tiếp theo.', '[\"serum-cham-soc-toc-davines-keratin-sealer.png\",\"serum-cham-soc-toc-davines-keratin-sealer-1.png\"]', 1, 'Davines'),
(3, 'Combo 3 Sản Phẩm Làm sạch - Dưỡng Trắng Hiệu Quả Cho Nam Giới', 599000, 100, 'Sữa Dưỡng Da Grinif All In One chính là giải pháp làm đẹp nhanh gọn dành cho phái mạnh, từ người mới bước vào công cuộc chăm sóc da cho đến những người bận rộn, không có nhiều thời gian mà vẫn muốn có một làn da trẻ trung mịn màng, đủ ẩm, trắng sáng. \r\n\r\nSữa rửa mặt than hoạt tính Skin&Dr với thành phần thiên nhiên, công nghệ lên men hiện đại giúp đánh bay mọi bụi bẩn, dưỡng chất thẩm thấu sâu giúp làn da trắng sáng, khoẻ mạnh, không còn dấu hiệu của mụn.\r\n\r\nWhite Truffle HD Turn Over Peeling/ Gel Tẩy Tế Bào Chết là sản phẩm nằm trong Bộ sản phẩm White Truffle HD. Sản phẩm giúp làm sạch sâu da mang lại một làn da sạch hoàn hảo để tiến hành các bước dưỡng tiếp theo. Người dùng sẽ cảm nhận ngay một làn da sạch, sáng, nhẵn mịn thấy rõ chỉ sau 2 phút sử dụng sản phẩm.\r\n\r\n', 'Sữa Dưỡng Da Grinif All In One chính là giải pháp làm đẹp nhanh gọn dành cho phái mạnh, từ người mới bước vào công cuộc chăm sóc da cho đến những người bận rộn, không có nhiều thời gian mà vẫn muốn có một làn da trẻ trung mịn màng, đủ ẩm, trắng sáng. \r\n\r\nSữa rửa mặt than hoạt tính Skin&Dr với thành phần thiên nhiên, công nghệ lên men hiện đại giúp đánh bay mọi bụi bẩn, dưỡng chất thẩm thấu sâu giúp làn da trắng sáng, khoẻ mạnh, không còn dấu hiệu của mụn.\r\n\r\nLoại bỏ tế bào chết hiệu quả: Không chỉ là sữa rửa mặt, Skin&Dr còn có khả năng loại bỏ tế bào chết - nguyên nhân khiến cho da sần sùi và không đều màu, đem lại một làn da mịn màng, trắng sáng\r\nLàm sạch sâu: Với thành phần than hoạt tính, Skin&Dr có khả năng làm sạch sâu, len lỏi đến từng lỗ chân lông lấy đi bụi bẩn, giúp làn da thông thoáng, sạch sẽ. \r\nThẩm thấu dưỡng da sâu: Với công nghệ lên men từ thực vật, sản phẩm có khả năng thẩm thấu sâu, đưa dưỡng chất vào trong da giúp cấp ẩm, giúp da trở nên trắng sáng, mịn màng, ngăn ngừa lão hoá.\r\nKiềm dầu, ngừa mụn: Skin&Dr còn có công dụng kiềm dầu, giúp da luôn sạch thoáng. Ngoài ra còn có khả năng kháng mụn tốt, bảo vệ làn da không bị mụn tấn công. \r\n\r\n\r\nGrinif All In One 4 Gentleman chiết xuất từ 17 thảo dược thiên nhiên, bao gồm dương hồi, cam thảo âu, chanh, hương thảo, cam, đu đủ, wild cherry, gạo, việt quất, trà xanh, lựu, cam chanh Nhật Bản, rượu sake, hoa cúc, cốt khí củ, hoàng cầm và dầu cám gạo. \r\n\r\n- Giảm thiểu sự xuất hiện của các nếp nhăn, chảy xệ mang đến làn da mềm mại, mịn màng.\r\n\r\n- Cung cấp độ ẩm cho da, ngăn chặn tình trạng da khô ráp, thiếu nước, mang đến làn da ẩm mượt.\r\n\r\n- Làm dịu tức thì những vùng bị kích ứng mẩn đỏ và chấm dứt hiện tượng bong tróc, nứt nẻ sau khi cạo râu.\r\n\r\n- Giúp tái sinh và trẻ hóa da hiệu quả, tăng độ đàn hồi và giữ lại nét tươi sáng trên da, đẩy lùi lão hóa.\r\n\r\n- Thúc đẩy quá trình tái tạo tế bào, ngăn ngừa hình thành nếp nhăn, tăng độ săn chắc, cải thiện tình trạng mụn và kích ứng da, loại bỏ sạm nám, xóa mờ các vết thâm do mụn\r\n\r\n- Cân bằng độ pH trên da sau khi dùng sữa rửa mặt, dưỡng ẩm sâu, cung cấp dưỡng chất cho da khỏe mạnh\r\n\r\n\r\n\r\nWhite Truffle HD Turn Over Peeling/ Gel Tẩy Tế Bào Chết\r\n\r\n- Sản phẩm chứa công thức 2 tác động từ Cellulose tự nhiên và hạt mơ giúp làm bong tróc tế bào chết, bụi bẩn trên bề mặt da nhanh chóng & nhẹ nhàng, mang lại một làn da sạch hoàn hảo.\r\n\r\n- Làm bong và lấy sạch đi những tế bào chết, bụi bẩn trên da\r\n\r\n- Kích thích tái tạo tế bào mới giúp da trơn mịn, mềm mại\r\n\r\n- Làm se khít lỗ chân lông, da trắng sáng\r\n\r\n- Chứa 83.02 % tinh chất nhân sâm cùng các thành phần RESMELINtm và INFLAX tm sẽ làm se khít lỗ chân lông, trắng sáng. Kích thích tái tạo tế bào mới giúp da trơn mịn, mềm mại.\r\n\r\n- Bạn sẽ cảm nhận ngay một làn da sạch, sáng, nhẵn mịn thấy rõ sau 2 phút sử dụng sản phẩm.\r\n\r\n- Không chứa 9 thành phần độc hại (Paraben, Ethanol, Pigment, Fragrance tổng hợp, benzophenone,\r\n\r\nDEA, Silicone, Thành phần có nguồn gốc động vật, dầu khoáng và PEG) An toàn cho mọi loại da.', 'Hướng dẫn sử dụng:\r\n\r\nBước 1: Lấy 1 lượng nhỏ sữa rửa mặt ra tay, tạo bọt \r\n\r\nBước 2: Xoa đều lên mặt, mát-xa khoảng 2-3 phút\r\n\r\nBước 3: Rửa sạch mặt với nước\r\n\r\nBước 4: Dùng Gel tẩy da chết 1 - 2 lần / tuần để có làn da đẹp, tránh vùng viền mắt\r\n\r\nBước 5: Xoa bóp làm theo đường vòng tròn ra phía ngoài từ giữa khuôn mặt\r\n\r\nBước 6: Rửa sạch với nước ấm\r\n\r\n\r\n\r\nTrước khi đi ngủ\r\n\r\nBước 1: Thoa một lớp mỏng sữa dưỡng lên da\r\n\r\nBước 2: Massage nhẹ nhàng cho đến khi sản phẩm thấm đều trên da. Có thể dùng đầu ngón tay vỗ đều và nhẹ khắp mặt để sản phẩm hấp thụ nhanh hơn.\r\n\r\nLưu ý: Sử dụng 1-2 lần/ ngày để đạt hiệu quả tốt nhất. Tốt nhất nên sử dụng vào buổi tối trước khi đi ngủ.', '[\"combo-3-san-pham-lam-sach-duong-trang-hieu-qua-cho-nam-gioi.png\"]', 2, 'Updating'),
(4, 'Gel rửa mặt cho nam Detox Carbon Cool Men 150ml', 159000, 100, '- Gel rửa mặt chứa phức hợp detox, dầu tràm trà, than hoạt tính, chiết xuất trà xanh, panthenol, axit salicylic giúp làm sạch da mặt, thải độc, không gây khô da, tạo cảm giác thoải mái và sạch sẽ, và giúp da sáng màu hơn. Sản phẩm phù hợp với da thường, da dễ bị viêm, kích ứng, mẩn đỏ\r\n- Salicylic Acid có đặc tính nổi bật là kháng khuẩn và loại bỏ lớp sừng trên da. Salicylic Acid sẽ thâm nhập sâu vào trong lỗ chân lông, phá vỡ các tế bào chết bị dính vào nhau, đồng thời loại bỏ các bã dầu gây tắc nghẽn lỗ chân lông, từ đó, lớp tế bào chết dễ dàng bong ra khỏi da giúp làn da thông thoáng và mềm mịn hơn. Bằng cách loại bỏ các bã nhờn và tế bào chết làm tắc nghẽn lỗ chân lông, Salicylic Acid giúp loại bỏ và ngăn ngừa mụn hiệu quả.', '- Than hoạt tính hoạt động như một cục nam châm hút sạch bụi bẩn, vi khuẩn và độc tố vô cùng tốt ở sâu bên trong và ngoài da, từ đó “chặn đường lui” của mụn bọc, mụn đầu đen, mụn bã nhờn và các loại mụn khác.', 'Làm ướt mặt, lấy một lượng gel vừa đủ thoa lên da mặt, massage nhẹ nhàng để tạo bọt, sau đó rửa sạch lại với nước.', '[\"gel-rua-mat-cho-nam-detox-carbon-cool-men-150ml.png\",\"gel-rua-mat-cho-nam-detox-carbon-cool-men-150ml-1.png\",\"gel-rua-mat-cho-nam-detox-carbon-cool-men-150ml-2.png\"]', 2, 'Updating'),
(5, 'Tinh Dầu Nước Hoa FOGG - SHASMEEN', 180000, 100, 'Tinh dầu nước hoa Dubai - Fogg\r\n\r\nThương hiệu: FOGG\r\n\r\nDung tích: 10ml\r\n\r\nXuất xứ: DUBAI', 'Fogg Shasmeen 10ml – mang đến cảm giác trầm ấm, mạnh mẽ nhưng cũng rất ngọt ngào, dành cho các chàng ưa thích phong cách mạnh mẽ, ấm áp.\r\n\r\nNhắc đến Dubai là nhắc đến xứ sở của sự xa hoa, giàu có, phóng khoáng, đẳng cấp riêng biệt. Tinh dầu Nước hoa Dubai Fogg là sản phẩm được thiết kế dựa trên công thức pha trộn giữa Trung Đông Huyền thoại và hơi thở Châu Âu hiện đại, dựa trên bảng mùi đã được ưa chuộng của các hãng nổi tiếng trên thế giới nhưng được pha chế theo cách riêng và thành phần chỉ có ở Dubai. Mùi hương đậm chất sang chảnh thượng lưu nhưng giá cả rất hợp lý, dễ phù hợp với phần đông sở thích của mọi lứa tuổi. Bạn sẽ rất khó tìm được sản phẩm Tinh dầu nước hoa Dubai nhập khẩu chính hãng ở Việt Nam, nhưng với Fogg bạn sẽ yên tâm và tin tưởng hoàn toàn về xuất xứ của sản phẩm.\r\n\r\nThiết kế Tinh dầu nước hoa Fogg dạng bi lăn:  Là dòng sản phẩm hướng đến phong cách sống hiện đại, năng động của giới trẻ và những ai thích sự nhỏ gọn tiện lợi. Chai nhỏ 10ml giúp bạn có thể mang theo trong túi xách hoặc túi áo quần, bất kể khi nào và ở đâu bạn có thể ngay lập tức tạo dấu ấn thu hút đối phương.\r\n\r\nDạng bi lăn giúp bạn kiểm soát lượng nước hoa được sử dụng đúng vị trí mà bạn cần gây ấn tượng nhất, khác với nước hoa xịt có thể sẽ khuyếch tán ra những vị trí khác trên cơ thể.\r\n\r\nThành phần không chứa cồn là đặc trưng của Nước hoa Tinh dầu Fogg, giúp cho độ bám hương dài lâu hơn các loại nước hoa có cồn. Chỉ cần xoa nhẹ trên da 1-2 lần/ ngày, mùi hương sẽ theo bạn suốt 24h; nếu bạn xức lên quần áo, mùi hương sẽ lưu lại 2-3 ngày.\r\n\r\nMùi hương của tinh dầu Fogg 10ml được lấy cảm hứng từ thân gỗ và cây cỏ thiên nhiên, hòa quyện với trái cây và hoa, tạo nên các nốt hương hương vừa mạnh mẽ - năng động, vừa lịch lãm – lãng mạn, ngọt ngào, toát lên đầy đủ phẩm chất đàn ông thời nay cần có.', 'Mở nắp chai lăn trên da ở vị trí sau gáy/ cổ/ hoặc cổ tay, cánh tay.\r\n\r\nCó thể lăn trên áo.\r\n\r\nSau khi xức nước hoa thì đợi sau 2 phút mới bắt đầu ngửi thì sẽ cảm nhận dễ chịu.\r\n\r\nBẢO QUẢN : không để chai tinh dầu nước hoa gần lửa, tránh xa tầm tay trẻ em, vết thương hở và mắt , để sản phẩm ở nơi khô mát tránh nhiệt độ cao ', '[\"tinh-dau-nuoc-hoa-fogg-shasmeen.png\",\"tinh-dau-nuoc-hoa-fogg-shasmeen-1.png\",\"tinh-dau-nuoc-hoa-fogg-shasmeen-2.png\",\"tinh-dau-nuoc-hoa-fogg-shasmeen-3.png\",\"tinh-dau-nuoc-hoa-fogg-shasmeen-4.png\"]', 3, 'FOGG'),
(6, 'Nước Hoa Xịt Toàn Thân Unisex Fogg Absolute', 150000, 100, 'Thương hiệu: FOGG\r\n\r\nDung tích: 120ml\r\n\r\nXuất xứ: DUBAI', 'Thế giới nước hoa không chỉ thôi miên bạn bằng hàng ngàn mùi hương mà còn khiến bạn “lạc lối” bởi vô số những công dụng đặc hiệu của nó. Nước hoa xịt toàn thân Nước Hoa Xịt Toàn Thân Unisex Fogg Absolute với chất lượng sẽ khiến bạn phải bất ngờ.\r\n\r\nNước Hoa Xịt Toàn Thân Unisex Fogg Absolute không chỉ dành riêng cho chị em phụ nữ mà các đấng mày râu đều có thể sử dụng được. Đây là loại nước hoa dùng xịt cho cả body của thương hiệu Fogg nổi tiếng, được nhập khẩu từ Dubai và xuất khẩu tới nhiều nước trong khu vực và trên thế giới, trong đó có Việt Nam.\r\n\r\nNước Hoa Xịt Toàn Thân Unisex Fogg Absolute có chứa các thành phần chủ yếu sau: Ethanol, Diethyl Phthalate, Propylene Glycol, Perfume, Triclosan. Đây là các thành phần vừa lành tính vừa có tác dụng tỏa hương thơm thanh khiết giúp khử mùi cơ thể hiệu quả, dưỡng ẩm bảo vệ làn da, mang đến cho bạn cảm giác thoải mái, sảng khoái mỗi lần sử dụng.\r\n\r\nNước Hoa Xịt Toàn Thân Unisex Fogg Absolute phù hợp với những quý ông thích sự cổ điển, huyền bí.', 'Sử dụng nước hoa xịt toàn thân bằng cách giữ chai nước hoa ở khoảng cách 10-15cm và xịt lên da hoặc quần áo ngay sau khi tắm, sẽ giữ được hương thơm bền lâu và lan tỏa hơn trong nhiều giờ.\r\n\r\nBảo quản ở nơi khô ráo, thoáng mát, tránh ánh nắng trực tiếp và nhiệt độ cao. Cần chú ý để xa tầm tay trẻ em. Không nên nên xịt vào những vùng da có mụn hay những vùng da nhạy cảm dễ bị dị ứng.', '[\"nuoc-hoa-xit-toan-than-unisex-fogg-absolute.png\"]', 3, 'FOGG'),
(7, 'Gôm Tigi Bed Head Hard Head', 478000, 100, 'Gôm xịt tóc Tigi Bed Head được sản xuất 100% tại TIGI USA. Hair Spray Tigi Bed Head giữ nếp tốt & kiểm soát kiểu tóc cả ngày, với công nghệ mới làm tóc khô ngay lập tức.', '- Gôm xịt tóc siêu cứng, giữ kiểu lâu bền Tigi Bed Head 385ml giúp giữ nếp và tạo kiểu, đồng thời vẫn giữ được sự tự nhiên cho mái tóc. Đây là loại gôm xịt tóc được sản xuất từ Mỹ được khá nhiều salon và các bạn nam lựa chọn. Cung cấp dinh dưỡng và ngăn biến màu tóc, tóc luôn đc khỏe mạnh. Tạo độ đàn hồi tốt cho tóc. Xịt tạo và hoàn thiện kiểu, giữ tóc cứng liên tục, khô ngay tức thì, không để lại dư chất trên tóc. Gôm xịt tóc Tigi Bed Head với độ giữ nếp cực cao, tạo độ kết dính nhưng vẫn giữ được sự tự nhiên cho mái tóc mỗi khi sử dụng.\r\n\r\n- Gôm Tigi Bed Head phù hợp với mọi chất tóc vì gôm có thể điều chỉnh được độ PH của tóc. Mùi hương dễ chịu mà bạn cảm nhận được mỗi khi sử dụng.\r\n\r\n- Càng xịt nhiều thì khả năng giữ nếp càng tốt do đó nên xịt một lượng vừa đủ. Tóc sẽ cứng và khô ngay sau khi xịt', 'Bước 1: Vuốt, tạo kiểu tóc bằng sáp, đợi cho tóc khô\r\n\r\nBước 2: Xịt gôm lên tóc để cố định nếp tóc\r\n\r\nBước 3: Dùng máy sấy, sấy lại tóc', '[\"gom-xit-toc-tigi-bed-head-hard-head.png\",\"gom-xit-toc-tigi-bed-head-hard-head-1.png\",\"gom-xit-toc-tigi-bed-head-hard-head-2.png\"]', 4, 'TIGI'),
(8, 'XỊT TẠO KIỂU FARCOM SCULPT & FREEZE\r\n', 359000, 100, 'Dung tích: 500ml', 'Xịt tạo kiểu và giúp tóc vào nếp. Duy trì kiểu tóc suốt ngày dài. Sản phẩm lý tưởng cho phép thỏa sức sáng tạo kiểu tóc như mong muốn, kết cấu siêu nhẹ không gây khô cứng tóc. \r\n\r\nThành phần công thức độc đáo cùng dưỡng chất Vitamin B3 và Provitamin B5 chăm sóc sâu cho tóc.', 'Bước 1: Lắc đều chai gôm xịt tóc\r\n\r\nBước 2: Xịt lên tóc cách khoảng 20cm. Có thể xịt gần chân tóc để tạo tóc dụng đứng nếu tóc bạn không lên được. Khi xịt nhiều gôm sẽ có độ bóng, nếu xịt 1 lượng vừa phải sẽ tạo cảm giác rất tự nhiên.', '[\"xit-tao-kieu-sculpt-freeze.png\"]', 4, 'Updating'),
(9, 'Cây Gạt Mụn (Bộ 5 Cây)', 15000, 100, 'Xuất xứ: Việt Nam', 'Cây nặn mụn sử dụng để nặn mụn trứng cá.\r\n\r\nĐây là sản phẩm thông dụng được sử dụng phổ biến và rộng rãi trong tất cả salon của 30shine.\r\n\r\nKhi mụn cám và mụn đầu đen quá nhiều khiến bạn không kiểm soát được thì nên dùng cây nặn mụn này để gột bớt đi mụn cám mụn đầu đen đáng ghét.\r\n\r\nKHÔNG dùng tay trực tiếp nặn mụn sẽ để lại sẹo, bẩn và đỏ rát vùng bị mụn.\r\n\r\n', 'Bước 1: Trước tiên bạn cần làm sạch mũi và dùng một miếng khăn ấm đắp lên trong khoảng 3 phút để lỗ chân lông được mở rộng hơn.\r\n\r\nBước 2: Lấy chiếc cây nặn mụn chuyên dụng có một đầu kim và một đầu có hình tròn mảnh tẩy trùng sạch bằng miếng bông gòn thấm rượu.\r\n\r\nBước 3: Dùng que nặn để đẩy mụn ra theo lỗ chân lông. Nhớ chỉ chọn những nốt mụn đã già và có hướng mở để mụn dễ dàng bị đẩy ra. Đối với phần 2 bên cánh mũi thì đặt que nặn theo hướng đầu nhọn đi xuống dưới khi nặn\r\n\r\nBước 4: Với mụn ở vùng trên mũi thì đặt cây nặn có hướng đầu nhọn chếch lên phía trên.\r\n\r\nBước 5: Sau khi nặn mụn xong thì dùng sữa rửa mặt và làm sạch vùng da vừa nặn xong.', '[\"cay-gat-mun-bo-5-cay.png\"]', 5, 'Updating'),
(10, 'Máy Rửa Mặt Facial Cleansing Brush For Men', 399000, 100, 'Xuất xứ: Trung Quốc\r\n\r\nTrọng lượng: 65g', 'Rung 8.000 lần/ phút làm sạch sâu cho da.\r\nĐầu chải silicone giúp tạo cảm giác mềm mại khi rửa mặt và mát xa.\r\nKhông cần thay thế đầu cọ, không đau, an toàn hơn các loại cọ rửa mặt khác.\r\nThiết kế đầu silicon chống nước an toàn khi sử dụng trong nhà tắm.\r\nThiết kế nhỏ gọn, dễ dàng sử dụng hoặc mang theo khi đi du lịch.\r\nCó 2 mặt cọ thiết kế khác nhau, một mặt để rửa mặt, một mặt để mát xa da.\r\nNhiều mức tốc độ dễ dang tùy chỉnh, phù hợp với các loại da khác nhau.\r\nPhù hợp cho tất cả loại da. Dùng 2 lần 1 ngày cho vùng mặt, cổ, vùng chữ T hoặc body.\r\nSử dụng đèn chống lão hóa khi sử dụng kem dưỡng da, serum nếu muốn.\r\nLợi ích của sản phẩm:\r\n\r\n- Giúp rửa sạch sâu, trắng sáng da và cải thiện làn da.\r\n\r\n- loại bỏ bụi/ dầu, tế bào chết và lớp make up trên da.\r\n\r\n- Cải thiện mụn, thúc đẩy tuần hoàn máu.\r\n\r\n- Thúc đẩy sự thẩm thấu của các sản phẩm chăm sóc da, loại bỏ nếp nhăn.\r\n\r\n- Giúp gương mặt trông tươi trẻ, mềm mịn hơn.\r\n\r\nLưu ý:\r\n\r\nVui lòng đọc kỹ hướng dẫn sử dụng trước khi dùng để đảm bảo an toàn. Chỉ được sử dụng thiết bị theo hướng dẫn.\r\nVui lòng không tháo rời hoặc tự ý sửa chữa.\r\nChỉ được sử dụng thiết bị cho các mục đích được viết ra trong mô tả\r\nKhông để thiết bị hay sử dụng thiết bị ở môi trường nhiệt độ cao hay độ ẩm cao.\r\nTránh xa tầm tay của trẻ em, nếu người sử dụng dưới 18 tuổi cần có sự giám sát của người lớn.\r\nKhông nên sử dụng cho phụ nữ mang thai hoặc người có tiền sử hoặc bệnh về tim mạch và phổi.\r\nĐể tránh các sự cố hoặc hỏa hoạn vui lòng ngưng sử dụng khi thiết bị trở nên nóng bất thường.\r\nTránh rơi, đập hoặc tác động mạnh đến thiết bị.\r\nKhông sử dụng khi dây cáp bị hở hoặc hư hỏng.\r\nKhông sử dụng máy cho người bị bệnh tim, sốt, bệnh truyền nhiễm, ung thư, vết thương hở, có bẹnh ngoài da hoặc cháy nắng.\r\nVui lòng tham khảo ý kiến của bác sỹ trong trường hợp bạn đang điều trị hoặc sử dụng các sản phẩm dưới sự hướng dẫn của bác sỹ.', 'Trong lần sạc đầu tiên vui lòng sạc trong vòng 3 tiếng rưỡi. Để sạc vui lòng cắm đầu USB vào thiết bị và đầu còn lại kết nối với cục sạc vào nguồn điện.\r\nLàm ướt mặt sau đó thoa sửa rữa mặt của bạn lên mặt và cổ…\r\nKhởi động máy và để ở chế độ thấp nhất.\r\nĐiều chỉnh mức tốc đố bằng cách nhấn vào nút nguồn để phù hợp cho việc massage hoặc rửa mặt.\r\nNhấn 1 lần cho tốc độ trung bình.\r\nNhấn thêm 1 lần cho tốc độ nhanh hơn.\r\nNhấn vào nút nguồn thêm 1 lần nữa để tắt máy.\r\nRửa sơ, làm khô mặt và sử dụng sản phẩm dưỡng da.\r\nNhấn lâu khoản 3 giây để tắt mở chế độ đèn chống lão hóa.\r\n\r\n\r\nĐiều kiện bảo hành\r\n\r\nCám ơn bạn đã tin tưởng và sử dụng các sản phẩm của chúng tôi! Sau khi mua hàng quý khách sẽ nhận được chế độ bảo hành trong vòng 01 tháng kể từ ngày mua. Để hỗ trợ bảo trì miễn phí, quý khách vui lòng giữ lại thẻ bảo hành và hóa đơn mua hàng.\r\n\r\nTrong thời gian bảo hành, nếu xuất hiện các lỗi do nhà sản xuất quý khách hàng sẽ được hỗ trợ sửa chữa miễn phí. Tuy nhiên, trong trường hợp xuất hiện lỗi do tác động bên ngoài như rơi, vỡ… chúng tôi xin phép được từ chối bảo hành. Do vậy vui lòng tham khảo các thông tin mua hàng và lưu ý mang thẻ bảo hành khi đến trung tâm bảo hành – bảo trì khi cần sửa chữa sản phẩm.', '[\"may-rua-mat-facial-cleansing-brush-for-men.png\"]', 5, 'Updating'),
(11, 'Lăn Khử Mùi Ngăn Mồ Hôi Chiết Xuất Nha Đam Etiaxil Deodorant Vegetal 24h Roll-On 50ML', 237000, 100, 'Xuất xứ: Pháp\r\nSản xuất: Đan Mạch.\r\nHSD: 3 năm kể từ NSX', '\r\nDÒNG HẰNG NGÀY VỚI CHIẾT XUẤT NHA ĐAM 24H là một bộ sản phẩm hoàn toàn mới và khác biệt với các dòng sản phẩm khác vì thành phần chiếm tới 95% hoạt chất từ thiên nhiên, an toàn, lành tính tuyệt đối có thể sử dụng cho mọi loại da kể cả làn da nhạy cảm nhất.Công dụng phát huy lên đến 24h. Phù hợp với những bạn ít mồ hôi và mùi cơ thể không quá nặng.\r\n\r\nThành Phần:\r\nTrà Xanh\r\nĐất sét trắng\r\nNha đam\r\nLá bạc hà\r\nKHÔNG CỒN, KHÔNG MUỐI NHÔM\r\n\r\nCông Dụng:\r\nTrung hòa mùi cơ thể\r\nĐiều tiết mồ hôi\r\nKhông ố vàng áo\r\nHương thơm tươi mát suốt cả ngày dài.\r\nGiúp da mềm mịn', 'HDSD: Sau khi làm sạch vùng da dưới cánh tay, để khô và lăn 1-2 vòng.\r\nKhông sử dụng cho da đang bị kích ứng.', '[\"lan-khu-mui-ngan-mo-hoi-chiet-xuat-nha-dam-etiaxil-deodorant-vegetal-24h-roll-on-50ml.png\",\"lan-khu-mui-ngan-mo-hoi-chiet-xuat-nha-dam-etiaxil-deodorant-vegetal-24h-roll-on-50ml-1.png\",\"lan-khu-mui-ngan-mo-hoi-chiet-xuat-nha-dam-etiaxil-deodorant-vegetal-24h-roll-on-50ml-2.png\"]', 6, 'Etiaxil'),
(12, 'Xịt Khử Mùi Ngăn Mồ Hôi Chiết Xuất Nha Đam Etiaxil Deodorant Vegetal 24h Spray Sans Gaz 100ML', 237000, 100, 'Xuất xứ: Pháp\r\nSản xuất: Đan Mạch.\r\nHSD: 3 năm kể từ NSX', 'DÒNG HẰNG NGÀY VỚI CHIẾT XUẤT NHA ĐAM 24H là một bộ sản phẩm hoàn toàn mới và khác biệt với các dòng sản phẩm khác vì thành phần chiếm tới 95% hoạt chất từ thiên nhiên, an toàn, lành tính tuyệt đối có thể sử dụng cho mọi loại da kể cả làn da nhạy cảm nhất. Công dụng phát huy lên đến 24h. Phù hợp với những bạn ít mồ hôi và mùi cơ thể không quá nặng.\r\n\r\nThành Phần:\r\nTrà Xanh\r\nĐất sét trắng\r\nNha đam\r\nLá bạc hà\r\nKHÔNG CỒN, KHÔNG MUỐI NHÔM\r\n\r\nCông Dụng:\r\nTrung hòa mùi cơ thể\r\nĐiều tiết mồ hôi\r\nKhông ố vàng áo\r\nHương thơm tươi mát suốt cả ngày dài.\r\nGiúp da mềm mịn', 'HDSD: Sau khi làm sạch vùng da dưới cánh tay, xịt đều lên da.\r\nKhông sử dụng cho da đang bị kích ứng.', '[\"xit-khu-mui-ngan-mo-hoi-chiet-xuat-nha-dam-etiaxil-deodorant-vegetal-24h-spray-sans-gaz-100ml.png\",\"xit-khu-mui-ngan-mo-hoi-chiet-xuat-nha-dam-etiaxil-deodorant-vegetal-24h-spray-sans-gaz-100ml-1.png\",\"xit-khu-mui-ngan-mo-hoi-chiet-xuat-nha-dam-etiaxil-deodorant-vegetal-24h-spray-sans-gaz-100ml-2.png\"]', 6, 'Etiaxil');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `service`
--

CREATE TABLE `service` (
  `ID_Service` int(11) NOT NULL,
  `Name_Service` varchar(100) NOT NULL,
  `Description_Service` varchar(200) NOT NULL,
  `Price_Service` int(11) NOT NULL,
  `ID_Species` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `service`
--

INSERT INTO `service` (`ID_Service`, `Name_Service`, `Description_Service`, `Price_Service`, `ID_Species`) VALUES
(1, 'Combo cắt gội 10 bước', 'Combo Cắt - Gội - Thư giãn 10 bước cơ bản', 80000, 1),
(2, 'Cắt xả', 'Cắt xả nhanh không gội, massage. Tiết kiệm thời gian', 70000, 1),
(3, 'Vip combo cắt gội', 'Combo 10 bước kèm các dịch vụ chăm sóc grooming cao cấp', 199000, 1),
(4, 'Kid combo', 'Combo cắt gội riêng cho bé (mỹ phẩm riêng cho trẻ em)', 70000, 1),
(5, 'Gội massage dưỡng sinh vuốt tạo kiểu', 'Áp dụng Y học cổ truyền, bấm huyệt chữa mỏi vai gáy', 40000, 1),
(6, 'Uốn cao cấp Hàn Quốc', 'Sử dụng thuốc uốn ATS cao cấp từ Hàn Quốc, bổ sung Amino Axit giảm thiểu tối đa tổn thương tóc.', 349000, 2),
(7, 'Uốn tiêu chuẩn', 'Thuốc uốn tiêu chuẩn nhập khẩu Hàn Quốc, tạo sóng tóc căng bóng.', 260000, 2),
(8, 'Hấp dưỡng tiêu chuẩn OLIU', 'Giúp tóc bóng mượt, chắc khỏe từ sâu bên trong.', 119000, 2),
(9, 'Phục hồi nano', 'Hấp dưỡng kết hợp súng tinh chất Nano ngấm sâu giúp tóc chắc khỏe, suôn mượt.', 159000, 2),
(10, 'Nhuộm phủ bạc thảo dược', 'Giúp tóc đen bóng, da đầu chắc khỏe, trẻ trung.', 180000, 3),
(11, 'Nhuộm màu cơ bản', 'Các màu không cần tẩy: tông nâu đỏ, nâu vàng, rượu vang.(Nâu đen, Nâu nhiệt đới, Nâu tự nhiên, Nâu ánh vàng).', 249000, 3),
(12, 'Nhuộm màu thời trang nổi bật', 'Nhuộm các màu sáng, màu khói. có thể cần tẩy tóc (100K/lần tẩy)\r\n(Xanh đen, Nâu rêu trầm, Nâu rêu, Nâu rêu sáng, Khói nhạt, Xám khói trầm, Xám khói, Xám khói sáng).', 289000, 3),
(13, 'Lấy ráy tai', 'Quy trình chuyên nghiệp, an toàn, dụng cụ sử dụng 1 lần.', 30000, 4),
(14, 'Đắp mặt nạ', 'Mặt nạ dưỡng chất làm sáng, sạch da.', 20000, 4),
(15, 'Tẩy da chết sủi bọt', 'Loại bỏ bụi bẩn, bã nhờn sâu bên trong giúp da sáng khỏe.', 25000, 4),
(16, 'Lấy mụ bằng que gạt', 'Sử dụng mĩ phẩm đẩy mụn kết hợp que gạt(sử dụng 1 lần) lấy nhấn mụn.', 30000, 4),
(17, 'Lột mụn than tre', 'Thành phần chính là than tre hoạt tính, lột sạch mụn đầu đen.', 30000, 4),
(18, 'Giường massage Nhật Bản', 'Công nghệ S trank Nhật Bản với 4 trục đấm, bóp, di huyệt thiết kế riêng cho người Châu Á', 20000, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `speciesproduct`
--

CREATE TABLE `speciesproduct` (
  `ID_SpeciesProduct` int(11) NOT NULL,
  `Name_SpeciesProduct` varchar(50) NOT NULL,
  `Image_SpeciesProduct` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `speciesproduct`
--

INSERT INTO `speciesproduct` (`ID_SpeciesProduct`, `Name_SpeciesProduct`, `Image_SpeciesProduct`) VALUES
(1, 'Chăm sóc tóc', 'cham-soc-toc.png'),
(2, 'Chăm sóc da', 'cham-soc-da.png'),
(3, 'Nước hoa', 'nuoc-hoa.png'),
(4, 'Tạo kiểu tóc', 'tao-kieu-toc.png'),
(5, 'Phụ kiện', 'phu-kien.png'),
(6, 'Chăm sóc cơ thể', 'cham-soc-co-the.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `speciesservice`
--

CREATE TABLE `speciesservice` (
  `ID_Species` int(11) NOT NULL,
  `Name_Species` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `speciesservice`
--

INSERT INTO `speciesservice` (`ID_Species`, `Name_Species`) VALUES
(1, 'Cắt Gội Massage'),
(2, 'Uốn'),
(3, 'Nhuộm'),
(4, 'Dịch vụ khác');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `task`
--

CREATE TABLE `task` (
  `ID_Task` varchar(20) NOT NULL,
  `Date_Task` datetime NOT NULL,
  `Sum_Money_Task` int(11) NOT NULL,
  `Is_Save_Photo` tinyint(1) NOT NULL,
  `Is_Consulting` tinyint(1) NOT NULL,
  `Is_Successful_Task` tinyint(1) NOT NULL,
  `Service_Free` text NOT NULL,
  `ID_User` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `task`
--

INSERT INTO `task` (`ID_Task`, `Date_Task`, `Sum_Money_Task`, `Is_Save_Photo`, `Is_Consulting`, `Is_Successful_Task`, `Service_Free`, `ID_User`) VALUES
('T2171695545607', '2021-07-17 08:30:00', 80000, 1, 1, 0, '[\"Bỏ bớt thời gian gội, cắt sớm\",\"Da dễ kích ứng\",\"Hỏi kĩ trong khi cắt\",\"Hướng dẫn vuôt sáp tại nhà\",\"Tư vấn cắt tóc mới\",\"Cắt - giũa móng tay\"]', 4),
('T217216222252', '2021-07-02 17:30:00', 80000, 1, 1, 1, '[\"Bỏ bớt thời gian gội, cắt sớm\",\"Da dễ kích ứng\",\"Hỏi kĩ trong khi cắt\",\"Hướng dẫn vuôt sáp tại nhà\",\"Tư vấn cắt tóc mới\",\"Cắt - giũa móng tay\"]', 7),
('T2174211647131', '2021-07-05 08:30:00', 764000, 1, 1, 1, '[\"Bỏ bớt thời gian gội, cắt sớm\",\"Da dễ kích ứng\",\"Hỏi kĩ trong khi cắt\",\"Hướng dẫn vuôt sáp tại nhà\",\"Tư vấn cắt tóc mới\",\"Cắt - giũa móng tay\"]', 7),
('T2182721122921', '2021-08-28 14:30:00', 30000, 1, 1, 0, '[\"Bỏ bớt thời gian gội, cắt sớm\",\"Hướng dẫn vuôt sáp tại nhà\",\"Tư vấn cắt tóc mới\",\"Hỏi kĩ trong khi cắt\",\"Cắt - giũa móng tay\",\"Da dễ kích ứng\"]', 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `ID_User` int(11) NOT NULL,
  `Name_User` varchar(30) NOT NULL,
  `Phone_Number_User` varchar(12) NOT NULL,
  `Avatar_User` varchar(10) DEFAULT NULL,
  `UserName` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`ID_User`, `Name_User`, `Phone_Number_User`, `Avatar_User`, `UserName`) VALUES
(4, 'Admin', '+84973271208', NULL, '+84973271208'),
(5, 'Chu Thị Bích Thảo', '+84974174629', NULL, '+84974174629'),
(6, 'Lê Quang Thọ', '+84829764659', NULL, '+84829764659'),
(7, 'Chưa có tên', '+84978679717', NULL, '+84978679717'),
(8, 'Chưa có tên', '+84394684487', NULL, '+84394684487'),
(9, 'Chưa có tên', '+84971618116', NULL, '+84971618116');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`UserName`);

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`ID_Bill`),
  ADD KEY `fk_user_bill` (`ID_User`);

--
-- Chỉ mục cho bảng `descriptionbill`
--
ALTER TABLE `descriptionbill`
  ADD KEY `fk_bill_descriptionbill` (`ID_Bill`),
  ADD KEY `fk_product_descriptionbill` (`ID_Product`);

--
-- Chỉ mục cho bảng `descriptioncart`
--
ALTER TABLE `descriptioncart`
  ADD KEY `fk_user_cart` (`ID_User`),
  ADD KEY `fk_product_cart` (`ID_Product`);

--
-- Chỉ mục cho bảng `descriptiontask`
--
ALTER TABLE `descriptiontask`
  ADD KEY `fk_task_descriptionservice` (`ID_Task`),
  ADD KEY `fk_service_descriptionservice` (`ID_Service`);

--
-- Chỉ mục cho bảng `producer`
--
ALTER TABLE `producer`
  ADD PRIMARY KEY (`ID_Producer`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ID_Product`),
  ADD KEY `fk_species_product` (`ID_SpeciesProduct`),
  ADD KEY `fk_product_producer` (`ID_Producer`);

--
-- Chỉ mục cho bảng `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`ID_Service`),
  ADD KEY `fk_species_service` (`ID_Species`);

--
-- Chỉ mục cho bảng `speciesproduct`
--
ALTER TABLE `speciesproduct`
  ADD PRIMARY KEY (`ID_SpeciesProduct`);

--
-- Chỉ mục cho bảng `speciesservice`
--
ALTER TABLE `speciesservice`
  ADD PRIMARY KEY (`ID_Species`);

--
-- Chỉ mục cho bảng `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`ID_Task`),
  ADD KEY `fk_user_task` (`ID_User`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID_User`),
  ADD KEY `fk_user_account` (`UserName`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `ID_Product` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `service`
--
ALTER TABLE `service`
  MODIFY `ID_Service` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `speciesproduct`
--
ALTER TABLE `speciesproduct`
  MODIFY `ID_SpeciesProduct` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `speciesservice`
--
ALTER TABLE `speciesservice`
  MODIFY `ID_Species` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `ID_User` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `fk_user_bill` FOREIGN KEY (`ID_User`) REFERENCES `user` (`ID_User`);

--
-- Các ràng buộc cho bảng `descriptionbill`
--
ALTER TABLE `descriptionbill`
  ADD CONSTRAINT `fk_bill_descriptionbill` FOREIGN KEY (`ID_Bill`) REFERENCES `bill` (`ID_Bill`),
  ADD CONSTRAINT `fk_product_descriptionbill` FOREIGN KEY (`ID_Product`) REFERENCES `product` (`ID_Product`);

--
-- Các ràng buộc cho bảng `descriptioncart`
--
ALTER TABLE `descriptioncart`
  ADD CONSTRAINT `fk_product_cart` FOREIGN KEY (`ID_Product`) REFERENCES `product` (`ID_Product`),
  ADD CONSTRAINT `fk_user_cart` FOREIGN KEY (`ID_User`) REFERENCES `user` (`ID_User`);

--
-- Các ràng buộc cho bảng `descriptiontask`
--
ALTER TABLE `descriptiontask`
  ADD CONSTRAINT `fk_service_descriptionservice` FOREIGN KEY (`ID_Service`) REFERENCES `service` (`ID_Service`),
  ADD CONSTRAINT `fk_task_descriptionservice` FOREIGN KEY (`ID_Task`) REFERENCES `task` (`ID_Task`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `fk_product_producer` FOREIGN KEY (`ID_Producer`) REFERENCES `producer` (`ID_Producer`),
  ADD CONSTRAINT `fk_species_product` FOREIGN KEY (`ID_SpeciesProduct`) REFERENCES `speciesproduct` (`ID_SpeciesProduct`);

--
-- Các ràng buộc cho bảng `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `fk_species_service` FOREIGN KEY (`ID_Species`) REFERENCES `speciesservice` (`ID_Species`);

--
-- Các ràng buộc cho bảng `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `fk_user_task` FOREIGN KEY (`ID_User`) REFERENCES `user` (`ID_User`);

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user_account` FOREIGN KEY (`UserName`) REFERENCES `account` (`UserName`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
