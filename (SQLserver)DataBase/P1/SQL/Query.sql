use tea00;

SELECT Tea.name,TeaBill.amount,Bill.time FROM Tea Inner JOIN TeaBill ON Tea.id = TeaBill.teaId Inner JOIN Bill ON TeaBill.billId = Bill.id WHERE Bill.time LIKE '2020-05-14' ORDER BY TeaBill.amount DESC OFFSET 1 ROW

-- Đưa ra sản phẩm đắt nhất hay rẻ nhất của cửa hàng.
SELECT * FROM Tea ORDER By price DESC OFFSET 1 ROW
SELECT * FROM Tea ORDER By price DESC OFFSET 1 ROW

-- Đưa ra thông tin chi tiết của một sản phẩm.
SELECT * FROM Tea WHERE name LIKE 'Tra Sua Khoai Mon' OR id = 5;

--Đưa ra sản phẩm bán chạy nhất trong tháng N.
SELECT * FROM Tea Inner JOIN TeaBill ON TeaBill.teaId = Tea.id Inner JOIN Bill ON Bill.id = TeaBill.billId WHERE MONTH(Bill.time) = 5 ORDER BY TeaBill.amount DESC  OFFSET 1 ROW

-- Đưa ra số lượng bán của một sản phẩm cụ thể nào đó.
SELECT SUM(TeaBill.amount) AS AMOUNT FROM Tea Inner JOIN TeaBill ON TeaBill.teaId = Tea.id WHERE Tea.name LIKE 'Tra Sua Khoai Mon';

-- Tính tổng tiền một hóa đơn nào đó.
SELECT Tea.name,TeaBill.amount,TeaBill.amount*Tea.price FROM Bill Inner JOIN TeaBill ON TeaBill.billId = Bill.id Inner JOIN Tea ON Tea.id = TeaBill.teaId WHERE Bill.id = 12;
SELECT ToppingBill.amount*Topping.price FROM Bill Inner JOIN ToppingBill ON ToppingBill.billId = Bill.id Inner JOIN Topping ON Topping.id = ToppingBill.toppingId WHERE ToppingBill.billId = 12;

-- Tổng hợp các thức uống và số lượng bán ra trong khoảng thời gian cụ thể.
SELECT Tea.name,TeaBill.amount,Bill.time FROM Tea Inner JOIN TeaBill ON TeaBill.teaId= Tea.id Inner JOIN Bill ON Bill.id = TeaBill.billId WHERE Bill.time >= '2020-05-14' AND Bill.time <='2020-05-15';

-- Đưa ra danh sách khách hàng có sinh nhật dd/mm
SELECT * FROM Customer WHERE MONTH(birthday) = MONTH('2020-07-19') AND DAY(birthday) = DAY('2020-07-19');

-- Đưa ra đồ uống yêu thích của một khách hàng.
SELECT Customer.name,Tea.name FROM Customer Inner JOIN Bill ON Bill.customerId = Customer.phone Inner JOIN TeaBill ON TeaBill.billId = Bill.id Inner JOIN Tea ON Tea.id = TeaBill.teaId WHERE phone = 345263454 ORDER BY TeaBill.amount DESC  OFFSET 1 ROW

-- Đưa ra danh sách các đồ uống có chứa một topping A nào đó.
SELECT * FROM Tea CROSS JOIN Topping;

-- Lấy ra danh sách các chương trình khuyến mãi trong ngày.
SELECT * FROM Voucher WHERE time <= ('2020-05-19');

-- Tính độ tuổi trung bình của khách hàng.
SELECT ROUND(AVG(timestampdiff(year,birthday,NOW())),0) FROM Customer;

-- Đưa ra sinh nhật của nhân viên trong ngày.
SELECT * FROM Employee WHERE DAY(birthday) = DAY(('2020-07-19')) AND MONTH(birthday) = MONTH(('2020-07-19'));

-- Thống kê doanh thu cửa hàng trong ngày.
SELECT * FROM Bill Inner JOIN TeaBill ON TeaBill.billId = Bill.id Inner JOIN ToppingBill ON ToppingBill.billId = Bill.id WHERE Bill.time = ('2020-05-12');

-- Thông tin của một khách hàng hoặc nhân viên cụ thể.
SELECT * FROM Customer WHERE name LIKE 'Pham Duc Manh';
SELECT * FROM Employee WHERE name LIKE 'Pham Thi thu Hien' OR id = 2;

-- Đưa ra các đồ uống còn bán ở cửa hàng.
SELECT * FROM Tea WHERE status = 1;