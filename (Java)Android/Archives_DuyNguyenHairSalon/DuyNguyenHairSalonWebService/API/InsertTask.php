<?php
require "../Connection/dbCon.php";
header('Content-Type: application/json');

$id_task = $_POST['ID_Task'];
$date_task = $_POST['Date_Task'];
$sum_money_task = $_POST['Sum_Money_Task'];
$is_save_photo = $_POST['Is_Save_Photo'];
$is_consulting = $_POST['Is_Consulting'];
$is_successful_task = 0;
$service_free = $_POST['Service_Free'];
$id_user = $_POST['ID_User'];

$query = "INSERT INTO task VALUES('$id_task'
    , '$date_task'
    ,'$sum_money_task'
    ,'$is_save_photo'
    ,'$is_consulting'
    ,'$is_successful_task'
    ,'$service_free'
    ,'$id_user')";

if (mysqli_query($connect, $query)) {
    echo "successful";
} else {
    echo "error";
}
