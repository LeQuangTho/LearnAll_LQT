<?php
require "../Connection/dbCon.php";
$amount = $_POST['Amount'];
$idbill = $_POST['ID_Bill'];
$idproduct = $_POST['ID_Product'];
$iduser = $_POST['ID_User'];

$queryInsert = "INSERT INTO descriptionbill VALUES ('$amount', '$idbill','$idproduct')";
$queryDelete = "DELETE FROM descriptioncart WHERE ID_Product = '$idproduct' AND ID_User = '$iduser'";
$queryFix = "DELETE FROM descriptionbill WHERE ID_Bill = '$idbill';
            DELETE FROM bill WHERE ID_Bill = '$idbill';";
            
if (mysqli_query($connect, $queryInsert)) {
    if (mysqli_query($connect, $queryDelete)) {
        echo "successful";
    } else {
        mysqli_query($connect, $queryFix);
        echo "error";
    }
} else {
    mysqli_query($connect, $queryFix);
    echo "error";
}
