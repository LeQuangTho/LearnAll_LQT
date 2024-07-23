<?php
require "../Connection/dbCon.php";
header('Content_Type: applicatuion/json');

$id_bill = $_POST['ID_Bill'];
$date_bill = $_POST['Date_Bill'];
$sum_money_bill = $_POST['Sum_Money_Bill'];
$shipping_fee = $_POST['Shipping_Fee'];
$delivery_address = $_POST['Delivery_Address'];
$specific_delivery_address = $_POST['Specific_Delivery_Address'];
$fast_delivery = $_POST['Fast_Delivery'];
$is_successful = $_POST['Is_Successful'];
$id_user = $_POST['ID_User'];

$query = "INSERT INTO `bill`(`ID_Bill`, `Date_Bill`, `Sum_Money_Bill`, `Shipping_Fee`, `Delivery_Address`, `Specific_Delivery_Address`, `Fast_Delivery`, `Is_Successful`, `ID_User`) VALUES ('$id_bill','$date_bill','$sum_money_bill','$shipping_fee','$delivery_address','$specific_delivery_address','$fast_delivery','$is_successful','$id_user')";

if (mysqli_query($connect, $query)) {
    echo "successful";
} else {
    echo "error";
}
