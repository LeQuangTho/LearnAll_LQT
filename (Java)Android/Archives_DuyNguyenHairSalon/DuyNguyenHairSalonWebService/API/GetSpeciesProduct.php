<?php
require "../Connection/dbCon.php";
require "../Model/SpeciesProduct.php";
header('Content-Type: application/json');

$query = "SELECT * FROM `speciesproduct`";

$data = mysqli_query($connect, $query);

$array_sp = array();

while ($row = mysqli_fetch_assoc($data)) {
    array_push($array_sp, new SpeciesProduct(
        $row['ID_SpeciesProduct'],
        $row['Name_SpeciesProduct'],
        $row['Image_SpeciesProduct']
    ));
}

echo json_encode($array_sp);
