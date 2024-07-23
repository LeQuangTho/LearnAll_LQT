<?php
require "../Connection/dbCon.php";
require "../Model/Account.php";

//định dạng trang web hiển thị json
header('Content-Type: application/json');

$username = $_GET['UserName'];

$query = "SELECT * FROM account WHERE UserName = '+$username' LIMIT 1";
$data = mysqli_query($connect, $query);
$array_user = array();



while ($row = mysqli_fetch_assoc($data)) {
    array_push($array_user, new account($row['UserName'], $row['Password']));
}

echo json_encode($array_user);
