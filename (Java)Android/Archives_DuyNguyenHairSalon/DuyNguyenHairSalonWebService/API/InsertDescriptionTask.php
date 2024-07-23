<?php
require "../Connection/dbCon.php";
header('Content-Type: application/json');

$id_task = $_POST['ID_Task'];
$id_service = $_POST['ID_Service'];

$query = "INSERT INTO descriptiontask VALUES('$id_task'
    ,'$id_service')";
$queryFix = "DELETE FROM `descriptiontask` WHERE ID_Task = '$id_task';
            DELETE FROM `task` WHERE ID_Task = '$id_task';";

if (mysqli_query($connect, $query)) {
    echo "successful";

} else {
    mysqli_query($connect, $queryFix);
    echo "error";
}