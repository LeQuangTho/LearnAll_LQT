<?php
require "../Connection/dbCon.php";
header('Content-Type: application/json');

$id_user = $_POST['ID_User'];
$id_product = $_POST['ID_Product'];

//Kiểm tra xem sản phẩm này đã có trong cart chưa nếu rồi thì update amount++ còn chưa có thì insert
$queryCheckProduct = "SELECT * FROM `descriptioncart` WHERE ID_User = '$id_user' AND ID_Product = '$id_product' limit 1";
$dataCheckProduct = mysqli_query($connect, $queryCheckProduct);
$rowCheckProduct = mysqli_fetch_assoc($dataCheckProduct);

if(!empty($rowCheckProduct)){
    $amount = $rowCheckProduct['Amount'] + 1;
    $queryUpdate = "UPDATE `descriptioncart` SET `Amount`= '$amount' WHERE ID_User = '$id_user' AND ID_Product = '$id_product'";
    if(mysqli_query($connect, $queryUpdate)){
        echo "successful";
    }else{
        echo "error";
    }
}else{
    $queryUpdate = "INSERT INTO `descriptioncart`(`Amount`, `ID_User`, `ID_Product`) VALUES ('1','$id_user','$id_product')";
    if(mysqli_query($connect, $queryUpdate)){
        echo "successful";
    }else{
        echo "error";
    }
}