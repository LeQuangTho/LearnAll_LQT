<?php
require "../Connection/dbCon.php";
require "../Model/Product.php";
header('Content-Type: application/json');

$id_product = $_GET['ID_Product'];

$query = "SELECT * FROM `product` WHERE ID_Product = '$id_product' LIMIT 1";

$data = mysqli_query($connect, $query);

$array_product = array();

while ($row = mysqli_fetch_assoc($data)) {
    array_push($array_product, new Product(
        $row['ID_Product'],
        $row['Name_Product'],
        $row['Price_Product'],
        $row['Amount_Product'],
        $row['Info_Product'],
        $row['Description_Product'],
        $row['Using_Product'],
        $row['Image_Product'],
        $row['ID_SpeciesProduct'],
        $row['ID_Producer']
    ));
}

echo json_encode($array_product);