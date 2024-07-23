<?php
require "../Connection/dbCon.php";

$idtask = $_POST['ID_Task'];

$query = "UPDATE `task` SET `Is_Successful_Task`= 1 WHERE ID_Task = '$idtask'";

if(mysqli_query($connect,$query)){
    echo "success";
}else{
    echo "error";
}