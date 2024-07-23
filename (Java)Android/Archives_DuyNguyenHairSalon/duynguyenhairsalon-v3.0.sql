-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 07, 2021 lúc 01:19 PM
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
('+84829764659', '141220'),
('+84973271208', '141220'),
('+84974174629', '141220');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `ID_Bill` varchar(15) NOT NULL,
  `Date_Bill` datetime NOT NULL,
  `Sum_Money_Bill` int(11) NOT NULL,
  `Shipping_Fee` int(11) NOT NULL,
  `Delivery_Address` varchar(250) NOT NULL,
  `Specific_Delivery_Address` int(250) NOT NULL,
  `Fast_Delivery` tinyint(1) NOT NULL,
  `Is_Succsessful` tinyint(1) NOT NULL,
  `ID_User` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `descriptionbill`
--

CREATE TABLE `descriptionbill` (
  `ID_Bill` varchar(15) NOT NULL,
  `ID_Product` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `descriptioncart`
--

CREATE TABLE `descriptioncart` (
  `Amount` int(11) NOT NULL,
  `ID_User` int(11) NOT NULL,
  `ID_Product` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `descriptiontask`
--

CREATE TABLE `descriptiontask` (
  `ID_Task` varchar(15) NOT NULL,
  `ID_Service` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `descriptiontask`
--

INSERT INTO `descriptiontask` (`ID_Task`, `ID_Service`) VALUES
('21611058100', 9),
('21611058100', 12),
('21611058100', 15),
('2161112560', 3),
('2161112560', 8),
('2161112560', 3),
('2161112560', 8),
('21611111550', 13),
('21611111550', 17),
('21611111550', 16),
('21611111550', 15),
('21611111550', 18),
('21611111550', 12),
('21611111550', 6),
('21611111550', 3),
('2161111730', 2),
('21611117410', 3),
('21611117410', 6),
('21611117410', 12),
('21611117410', 13),
('21611117410', 14),
('21611117410', 15),
('21611117410', 16),
('21611117410', 17),
('21611117410', 18),
('21611119230', 3),
('21611119230', 6),
('21611119230', 12),
('21611119230', 13),
('21611119230', 14),
('21611119230', 15),
('21611119230', 16),
('21611119230', 17),
('21611119230', 18),
('2162837350', 3),
('2166102810', 1);

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
('Orzen', 'Orzen', 'Hàn Quốc'),
('Paul Mitchell', 'Paul Mitchell', 'Hàn Quốc'),
('TIGI', 'TIGI', 'Mỹ');

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
(1, 'Dầu Gội Làm Sạch Và Điều Tiết Bã Nhờn Etiaxil Deo-Douche 24H 150ML', 308000, 100, 'Sản phẩm mới Etiaxil Deo-Shampoo nhẹ nhàng làm sạch da đầu và điều tiết bã nhờn bằng cách sử dụng muối kẽm, cân bằng lại hệ vi sinh vật trên da, khử mùi hôi.', 'Công Dụng:\r\n- Detox & cân bằng hệ sinh thái da đầu, ngăn ngừa tình trạng bết - nhờn - dính\r\n- Tiêu diệt vi khuẩn, mảng bám trên da, cải thiện mùi hôi da đầu.\r\n- Ngừa nấm da đầu & cải thiện tình trạng rụng tóc\r\nCông dụng lên đến 24h\r\n\r\nThành Phần:\r\n- Muối Zinc PCA: có công dụng kháng khuẩn, giảm tiết bã nhờn và trung hòa mùi cơ thể.\r\n- Phức hợp probiotic: có chứa Lactococcus Lactis-một loại lợi khuẩn cho da; giúp cải thiện hàng rào bảo vệ, kết nối giữa các tế bào, ức chế hại khuẩn gây mùi...\r\n- Chiết xuất dầu dừa: cấp ẩm cho da, tăng mức kháng khuẩn, làm mềm mịn và sạch da.\r\n- Phức hợp Fluidipure TM: là hỗn hợp đường và Glycerin Biovector tác động lên các vi khuẩn chịu trách nhiệm về mùi hôi và bã nhờn, cân bằng hệ khuẩn trên da đầu, chống mẩn ngứa, đỏ tấy. Bảo vệ acid thiên nhiên trên da đầu và các vi sinh vật trên da.', 'HDSD: Làm ướt tóc và da đầu, lấy 1 lượng vừa đủ ra tay và thoa đều khắp đầu tạo bọt, massage nhẹ nhàng. Gội sạch lại với nước.\r\nDùng 2-3 lần/ tuần', NULL, 1, 'Etiaxil'),
(2, 'Xịt Dưỡng Tóc Davines Nourishing Keratin Sealer 100ml', 462000, 100, 'Dung dịch đóng chặt biểu bì dành cho tóc khô và tóc hư tổn.', 'NOURISHING KERATIN SEALER\r\nDung dịch đóng chặt biểu bì dành cho tóc khô và tóc hư tổn.\r\nDung dịch xả khô nuôi dưỡng bảo vệ giúp đóng chặt biểu bì, tăng cường độ bóng sáng và mềm mượt.\r\nTăng cường cấu trúc tóc, chống việc hình thành chẻ ngọn.\r\n\r\nCông thức vô cùng nhẹ, giàu Keratin Thực vật và amino axit, giúp khoá chặt các dưỡng chất (kể cả từ các bước trị liệu trước đó) ở bên trong sợi tóc lâu dài, cũng như đảm bảo độ bóng và mềm tối đa mà không làm nặng tóc.', 'Xịt đều lên tóc đã gội sạch & thấm khô bằng khăn bông, có thể dùng lược để phân bổ sản phẩm đều lên tóc. Tiếp tục các bước tạo kiểu tiếp theo.', NULL, 1, 'Davines');

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
(1, 'Chăm sóc tóc', '1'),
(2, 'Chăm sóc da', '1'),
(3, 'Nước hoa', '1'),
(4, 'Tạo kiểu tóc', '1'),
(5, 'Phụ kiện', '1'),
(6, 'Chăm sóc cơ thể', '1');

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
  `ID_Task` varchar(15) NOT NULL,
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
('21611058100', '2021-06-02 13:30:00', 672000, 1, 1, 1, '[\"Hỏi kĩ trong khi cắt\",\"Tư vấn cắt tóc mới\",\"Cắt - giũa móng tay\",\"Hướng dẫn vuôt sáp tại nhà\",\"Da dễ kích ứng\",\"Bỏ bớt thời gian gội, cắt sớm\"]', 5),
('21611111550', '2021-06-01 17:30:00', 992000, 1, 1, 1, '[\"Bỏ bớt thời gian gội, cắt sớm\",\"Da dễ kích ứng\",\"Hỏi kĩ trong khi cắt\",\"Hướng dẫn vuôt sáp tại nhà\",\"Tư vấn cắt tóc mới\",\"Cắt - giũa móng tay\"]', 6),
('2161111730', '2021-06-01 15:30:00', 70000, 1, 1, 0, '[\"Hướng dẫn vuôt sáp tại nhà\"]', 6),
('21611117410', '2021-06-01 15:00:00', 992000, 0, 0, 0, '[\"Bỏ bớt thời gian gội, cắt sớm\",\"Da dễ kích ứng\",\"Hỏi kĩ trong khi cắt\",\"Hướng dẫn vuôt sáp tại nhà\",\"Tư vấn cắt tóc mới\",\"Cắt - giũa móng tay\"]', 6),
('21611119230', '2021-06-03 15:30:00', 992000, 1, 1, 1, '[\"Bỏ bớt thời gian gội, cắt sớm\",\"Da dễ kích ứng\",\"Hỏi kĩ trong khi cắt\",\"Hướng dẫn vuôt sáp tại nhà\",\"Tư vấn cắt tóc mới\",\"Cắt - giũa móng tay\"]', 5),
('2161112560', '2021-06-03 12:00:00', 318000, 0, 1, 1, '[\"Bỏ bớt thời gian gội, cắt sớm\",\"Hướng dẫn vuôt sáp tại nhà\",\"Tư vấn cắt tóc mới\",\"Da dễ kích ứng\",\"Cắt - giũa móng tay\"]', 5),
('2161118250', '2021-06-01 12:30:00', 80000, 1, 1, 1, '[\"Bỏ bớt thời gian gội, cắt sớm\",\"Da dễ kích ứng\",\"Hỏi kĩ trong khi cắt\",\"Hướng dẫn vuôt sáp tại nhà\",\"Tư vấn cắt tóc mới\",\"Cắt - giũa móng tay\"]', 6),
('2162837350', '2021-06-03 13:30:00', 199000, 1, 1, 1, '[\"Bỏ bớt thời gian gội, cắt sớm\",\"Hỏi kĩ trong khi cắt\",\"Da dễ kích ứng\",\"Hướng dẫn vuôt sáp tại nhà\",\"Tư vấn cắt tóc mới\",\"Cắt - giũa móng tay\"]', 5),
('2166102810', '2021-06-06 11:30:00', 80000, 1, 1, 1, '[]', 5);

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
(6, 'Lê Quang Thọ', '+84829764659', NULL, '+84829764659');

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
  MODIFY `ID_Product` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
  MODIFY `ID_User` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

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
