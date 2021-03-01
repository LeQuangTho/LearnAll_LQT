use tea00

-- INSERT INTO Employee VALUES 
-- -- 	(1,392301017,'Le Quang Duy',DATE('2000-02-03'),0,'Tech Lead','Ninh Binh','urlDuy');
-- 	(5,392301017,'Pham Thi thu Hien ',DATE('2000-12-22'),0,'Doctor','Ninh Binh','urlHien');

-- INSERT INTO Customer VALUE
-- 	(0,'Obama',0);
-- 	

-- INSERT INTO Voucher
-- VALUES (2,1.1,'010101',1);
set identity_insert Customer on
insert into Customer
(phone,name,level)
VAlUES
(0985346754,'Trinh Thi Thu Thuy',1),
(0883452354,'Pham Duc Manh',0),
(0345263454,'Dinh Thu Hoai',2),
(0462462366,'Chu Nguyen Chuong',1),
(0879465742,'Le Van Hanh',0),
(0346547423,'Cao Quoc Toan',1),
(0769567443,'Tran Thi Thu Trang',3),
(0568769546,'Nguyen Quoc Toan',2),
(0956734652,'Trinh Thi Hien',1),
(0234634732,'Ly Thi Huong',0),
(0234756873,'Le Thi Chien',0),
(0354745683,'Dinh Quang Khang',2),
(0735473456,'Nguyen Thi Huyen',1),
(0345754735,'Can Thi Gio',0),
(0346168754,'Ly Cao Hai',1),
(0901168754,'Pham Thi Thu',2);
set identity_insert Customer off
set identity_insert Employee on
insert into Employee
(id,phone,name,birthday,timeWork,level,address,avatar)
values
(1,0356978432,'Nguyen Thi Huyen Trang','1995-05-17',6,2,'Nam Dinh','urlTrang'),
(2,0125415779,'Dinh Van Hoang','2000-09-11',5,1,'Ninh Binh','urlHoang'),
(3,0257978732,'Tran Dinh Trong','1997-02-15',8,3,'Thai Binh','urlTrong'),
(4,0474362332,'Ly Quoc Khanh','1998-03-09',9,3,'Hai Duong','urlKhanh'),
(5,0558978567,'Trinh Ai Hong','1992-08-26',12,4,'Ha Noi','urlHong'),
(6,0691968432,'Le Thu Thuy','1996-10-10',6,2,'Bac Giang','urlThuy'),
(7,0756956490,'Chau Viet Cuong','1999-12-31',8,2,'Ninh Binh','urlCuong'),
(8,0886324562,'Tran Thi Thu Trang','2000-11-17',6,2,'Ha Nam','urlTrang'),
(9,0979953261,'Trinh Thi Hien','1991-02-22',4,2,'Nam Dinh','urlHien'),
(10,010124126,'Nguyen Van Cuong','1990-05-09',9,2,'Nghe An','urlCuong'),
(11,011625371,'Nguyen Quoc Truong','1994-06-06',10,2,'Phu Tho','urlTruong'),
(12,012625272,'Tran Van Duy','1998-09-12',11,2,'Thai Binh','urlDuy'),
(13,013462760,'Le Minh Hai','1992-05-15',8,2,'Hai Duong','urlHai'),
(14,014095404,'Do Duc Manh','1998-12-25',8,2,'Ninh Binh','urlManh'),
(15,015394620,'Do Thu Quynh','2000-07-19',8,2,'Ha Noi','urlQuynh'),
(16,016385232,'Nguyen Kim Tuyen','1991-11-11',8,2,'Ha Noi','urlTuyen');
set identity_insert Employee off
set identity_insert [Resource] on
insert into [Resource]
(id,date,amount)
values
(1,'2020-04-12',100),
(2,'2020-04-12',100),
(3,'2020-04-12',100),
(4,'2020-04-12',100),
(5,'2020-06-25',50),
(6,'2020-06-25',50),
(7,'2020-07-31',120),
(8,'2020-07-31',120),
(9,'2020-07-31',120),
(10,'2020-09-10',200),
(11,'2020-09-10',200),
(12,'2020-11-12',150),
(13,'2020-11-12',150),
(14,'2020-11-12',150),
(15,'2020-11-22',100),
(16,'2020-11-22',100);
set identity_insert [Resource] off

set identity_insert Tea on
insert into Tea
(id,name,price,status)
values
(1,'Tra Sua Tran Chau Trang',30000,1),
(2,'Tra Sua Oreo Cake Cream',35000,0),
(3,'Tra Sua Tran Chau Duong Den',30000,0),
(4,'Tra Xoai Kem Cheese',40000,1),
(5,'Tra Sua Khoai Mon',25000,1),
(6,'Tra Sua Matcha Dau Do',30000,1),
(7,'Tra Sua Oreo Chocolate Cream',45000,0),
(8,'Tra Sua Pudding Dau Do',50000,1),
(9,'Tra Sua Tran Chau Den',30000,1),
(10,'Tra Sua Suong Sao',35000,1),
(11,'Tra Sua Earl Grey',40000,0),
(12,'Tra Sua Caramel',35000,1),
(13,'Tra Sua Ca Phe',30000,1),
(14,'Luc Tra Sua',50000,1),
(15,'Tra Sua Chese Milk Foam',40000,1);
set identity_insert Tea off
set identity_insert Topping on
insert into Topping
(id,price,[name])
values
(1,5000,'Tran Chau Baby'),
(2,6000,'Pudding'),
(3,5000,'Suong Sao'),
(4,7000,'Rau Cau Dua'),
(5,8000,'Thach Caffe'),
(6,6000,'Thach Bang Tuyet'),
(7,5000,'Cream Chess'),
(8,8000,'Dau Do'),
(9,5000,'Tran Chau QQ'),
(10,7000,'Khoai Mon'),
(11,7000,'Khoai Lang'),
(12,6000,'Hat Sen'),
(13,5000,'Tran Chau Trang'),
(14,5000,'Y Di'),
(15,5000,'Tran Chau Soi'),
(16,7000,'Tran Chau Hoang Gia');
set identity_insert Topping off
set identity_insert Voucher on
insert into Voucher
(code,[percent],time,phoneNumber)
values
(1,1,'2020-12-22',0234634732),
(3,0.2,'2020-11-22',0234756873),
(4,0.2,'2020-05-19',0345263454),
(5,0.3,'2020-05-30',0345754735),
(7,0.3,'2020-05-08',0346547423),
(8,0.1,'2020-05-19',0354745683),
(9,0.25,'2020-05-19',0462462366),
(10,0.35,'2020-05-19',0568769546);
set identity_insert Voucher off
insert into TeaTopping
(teaId,toppingId)
values
(1,2),
(2,1),
(1,5),
(3,6),
(2,7),
(8,12),
(6,11),
(5,9),
(3,10),
(8,8),
(7,13);
insert into TeaResource
(teaId,resourceId,amount)
values
(1,7,10),
(2,10,5),
(5,12,15),
(4,2,12),
(5,7,8),
(8,9,13),
(6,11,10),
(2,9,5),
(5,6,15),
(9,14,10),
(3,4,10),
(1,3,12);
set identity_insert Bill on
insert into Bill
(id,time,employeeId,customerId,codeVoucher)
values
(1,'2020-05-12',1,0234634732,1),
(2,'2020-05-13',1,0234756873,5),
(3,'2020-05-14',2,345263454,1),
(4,'2020-05-12',5,0345754735,7),
(5,'2020-05-13',8,0346168754,5),
(6,'2020-05-14',9,0346547423,4),
(7,'2020-05-15',7,0354745683,10),
(8,'2020-05-15',5,0462462366,1),
(9,'2020-05-12',4,0568769546,1),
(10,'2020-05-15',9,0735473456,3),
(11,'2020-05-17',7,0769567443,4),
(12,'2020-05-20',8,0879465742,5);
set identity_insert Bill off
insert into TeaBill
(teaId,billId,amount,price)
values
(1,1,3,105000),
(2,3,5,200000),
(4,2,2,80000),
(5,6,1,30000),
(7,5,2,100000),
(8,10,3,90000),
(3,3,4,100000),
(11,3,1,35000),
(5,10,2,60000),
(4,7,5,180000),
(7,12,2,60000),
(15,3,5,250000);
-- ALTER TABLE Topping
-- ADD COLUMN name varchar(50) DEFAULT NULL;


insert into ToppingBill
(toppingId,billId,amount)
values				
(1,1,5),
(2,2,5),
(3,3,5),
(4,4,5),
(5,5,5),
(6,6,5),
(7,7,5),
(8,8,5),
(9,9,5),
(10,10,5),
(11,11,5),
(12,12,5),
(11,6,5);