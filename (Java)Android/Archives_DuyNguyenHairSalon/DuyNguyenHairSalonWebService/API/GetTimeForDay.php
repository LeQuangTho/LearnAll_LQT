<?php
require "../Connection/dbCon.php";
require "../Model/Time.php";
header('Content-Type: application/json');

$mDay = $_GET['Day'];



$query = "SELECT HOUR(Date_Task) AS HOUR, 
MINUTE(Date_Task) AS MINUTE FROM task WHERE DATE(Date_Task) = DATE(DATE_ADD(NOW(),INTERVAL $mDay DAY))";

//lấy dữ liệu ra
$data = mysqli_query($connect, $query);

//tạo mảng
$array_task = array();

//đọc từ data
while ($row = mysqli_fetch_assoc($data)) {
    array_push(
        $array_task,
        new Time(
            $row['HOUR'],
            $row['MINUTE']
        )
    );
}

echo json_encode($array_task);
