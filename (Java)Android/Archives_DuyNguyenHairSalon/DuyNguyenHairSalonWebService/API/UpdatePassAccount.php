<?php
require "../Connection/dbCon.php";
header('Content_Type: applicatuion/json');

$username = $_POST['UserName'];
$password = $_POST['Password'];


$query = "UPDATE `account` SET `Password`= '$password' WHERE UserName = '$username'";

if (mysqli_query($connect, $query)) {
    echo "successful";
} else {
    echo "errror";
}
