<?php
require "../Connection/dbCon.php";
require "../Model/Product.php";
header('Content-Type: application/json');

$id_user = $_GET['ID_User'];

$query = "SELECT p.ID_Product, p.Name_Product, p.Price_Product, c.Amount, p.Image_Product
FROM `descriptioncart` AS c LEFT JOIN `product` AS p ON c.ID_Product = p.ID_Product 
WHERE ID_User = '$id_user'";

$data = mysqli_query($connect, $query);

$array_product = array();

while ($row = mysqli_fetch_assoc($data)) {
    array_push($array_product, new Product(
        $row['ID_Product'],
        $row['Name_Product'],
        $row['Price_Product'],
        $row['Amount'],
        "",
        "",
        "",
        $row['Image_Product'],
        "",
        ""
    ));
}

echo json_encode($array_product);
