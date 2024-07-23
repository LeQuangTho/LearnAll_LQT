<?php
require "../Connection/dbCon.php";
$change = $_POST['Change'];
$id_user = $_POST['ID_User'];
$id_product = $_POST['ID_Product'];

$queryCheckProduct = "SELECT * FROM `descriptioncart` WHERE ID_User = '$id_user' AND ID_Product = '$id_product' limit 1";
$dataCheckProduct = mysqli_query($connect, $queryCheckProduct);
$rowCheckProduct = mysqli_fetch_assoc($dataCheckProduct);
if ($change == 'up') {
    $amount = $rowCheckProduct['Amount'] + 1;
    $queryUpdate = "UPDATE `descriptioncart` SET `Amount`= '$amount' WHERE ID_User = '$id_user' AND ID_Product = '$id_product'";
    if (mysqli_query($connect, $queryUpdate)) {
        echo "successful";
    } else {
        echo "error";
    }
} else if ($change == 'down') {
    $amount = $rowCheckProduct['Amount'] - 1;
    $queryUpdate = "UPDATE `descriptioncart` SET `Amount`= '$amount' WHERE ID_User = '$id_user' AND ID_Product = '$id_product'";
    if (mysqli_query($connect, $queryUpdate)) {
        echo "successful";
    } else {
        echo "error";
    }
} else {
    $queryUpdate = "DELETE FROM `descriptioncart` WHERE ID_User = '$id_user' AND ID_Product = '$id_product'";
    if (mysqli_query($connect, $queryUpdate)) {
        echo "successful";
    } else {
        echo "error";
    }
}