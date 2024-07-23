<?php
require "../Connection/dbCon.php";
require "../Model/Task.php";
header('Content-Type: application/json');

$day = $_GET['DayTask'];

class Service
{
    function __construct($id_service, $name_service, $price_service)
    {
        $this->ID_Service = $id_service;
        $this->Name_Service = $name_service;
        $this->Price_Service = $price_service;
    }
}

$query = "SELECT * FROM task AS t LEFT JOIN user AS u ON t.ID_User = u.ID_User WHERE DATE(t.Date_Task) = DATE(DATE_ADD(NOW(),INTERVAL $day DAY))";

//lấy dữ liệu ra
$data = mysqli_query($connect, $query);

//tạo mảng
$array_task = array();

//đọc từ data
while ($row = mysqli_fetch_assoc($data)) {
    $array_service = array();
    $query2 = "SELECT * FROM `descriptiontask` AS d LEFT JOIN `service` AS s ON d.ID_Service = s.ID_Service WHERE d.ID_Task = '"
        .$row['ID_Task']."';";

    $data2 = mysqli_query($connect, $query2);
    while ($row2 = mysqli_fetch_assoc($data2)) {
        array_push($array_service, new Service($row2['ID_Service'], $row2['Name_Service'], $row2['Price_Service']));
    }
    
    array_push($array_task, new Task(
        $row['ID_Task'],
        $row['Date_Task'],
        $row['Sum_Money_Task'],
        $row['Is_Save_Photo'],
        $row['Is_Consulting'],
        $row['Is_Successful_Task'],
        $row['Service_Free'],
        $row['ID_User'],
        $row['Name_User'],
        $row['Phone_Number_User'],
        $array_service
    ));
}

echo json_encode($array_task);
