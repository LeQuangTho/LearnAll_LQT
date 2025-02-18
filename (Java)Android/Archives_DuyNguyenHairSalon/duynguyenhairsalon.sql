-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 01, 2021 lúc 06:10 AM
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
('2161112560', 8);

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
('2161112560', '2021-06-03 12:00:00', 318000, 0, 1, 1, '[\"Bỏ bớt thời gian gội, cắt sớm\",\"Hướng dẫn vuôt sáp tại nhà\",\"Tư vấn cắt tóc mới\",\"Da dễ kích ứng\",\"Cắt - giũa móng tay\"]', 5),
('2161118250', '2021-06-01 12:30:00', 80000, 1, 1, 1, '[\"Bỏ bớt thời gian gội, cắt sớm\",\"Da dễ kích ứng\",\"Hỏi kĩ trong khi cắt\",\"Hướng dẫn vuôt sáp tại nhà\",\"Tư vấn cắt tóc mới\",\"Cắt - giũa móng tay\"]', 6);

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
-- Chỉ mục cho bảng `descriptiontask`
--
ALTER TABLE `descriptiontask`
  ADD KEY `fk_task_descriptionservice` (`ID_Task`),
  ADD KEY `fk_service_descriptionservice` (`ID_Service`);

--
-- Chỉ mục cho bảng `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`ID_Service`),
  ADD KEY `fk_species_service` (`ID_Species`);

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
-- AUTO_INCREMENT cho bảng `service`
--
ALTER TABLE `service`
  MODIFY `ID_Service` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

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
-- Các ràng buộc cho bảng `descriptiontask`
--
ALTER TABLE `descriptiontask`
  ADD CONSTRAINT `fk_service_descriptionservice` FOREIGN KEY (`ID_Service`) REFERENCES `service` (`ID_Service`),
  ADD CONSTRAINT `fk_task_descriptionservice` FOREIGN KEY (`ID_Task`) REFERENCES `task` (`ID_Task`);

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
