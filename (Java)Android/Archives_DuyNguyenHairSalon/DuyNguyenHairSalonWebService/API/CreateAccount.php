<?php
require "../Connection/dbCon.php";
header('Content_Type: applicatuion/json');

$username = $_POST['UserName'];
$password = $_POST['Password'];

$phonenumber = $username;

$query = "INSERT INTO `account`(`UserName`, `Password`) VALUES ('$username','$password')";

$query2 = "INSERT INTO `user`(`ID_User`, `Name_User`, `Phone_Number_User`, `Avatar_User`, `UserName`) 
    VALUES (null,'Chưa có tên','$phonenumber',null,'$username')";

$queryDelAccount = "DELETE FROM `account` WHERE UserName = '$username'";

if (mysqli_query($connect, $query)) {
    if (mysqli_query($connect, $query2)) {
        echo "successful";
    } else {
        mysqli_query($connect, $queryDelAccount);
        echo "errror";
    }
}else{
    echo "errror";
}
