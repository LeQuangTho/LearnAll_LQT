<?php
require "../Connection/dbCon.php";
require "../Model/Service.php";
header('Content-Type: application/json');

$query = "Select * from service";

//lấy dữ liệu ra
$data = mysqli_query($connect, $query);

//tạo mảng
$array_service = array();
//đọc từ data
while ($row = mysqli_fetch_assoc($data)) {
    array_push($array_service, new Service(
        $row['ID_Service'],
        $row['Name_Service'],
        $row['Description_Service'],
        $row['Price_Service'],
        $row['ID_Species']
    ));
}

echo json_encode($array_service);
