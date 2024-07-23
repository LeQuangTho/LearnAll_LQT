<?php
require "../Connection/dbCon.php";
require "../Model/User.php";
header('Content_Type: applicatuion/json');

$username = $_GET['UserName'];

$query = "SELECT ID_User FROM user WHERE UserName = '+$username' limit 1";

$data = mysqli_query($connect, $query);

$array = array();
while ($row = mysqli_fetch_assoc($data)) {
    array_push($array, new user($row['ID_User'], null, null, null, null));
}

echo json_encode($array);
