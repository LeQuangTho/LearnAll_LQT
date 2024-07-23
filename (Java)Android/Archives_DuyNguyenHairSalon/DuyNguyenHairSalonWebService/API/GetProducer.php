<?php
require "../Connection/dbCon.php";
require "../Model/Producer.php";
header('Content-Type: application/json');

$id_producer = $_GET['ID_Producer'];

$query = "SELECT * FROM `producer` WHERE ID_Producer = '$id_producer' LIMIT 1";

$data = mysqli_query($connect, $query);

$array_producer = array();

while ($row = mysqli_fetch_assoc($data)) {
    array_push($array_producer, new Producer(
        $row['ID_Producer'],
        $row['Name_Brand'],
        $row['Origin']
    ));
}

echo json_encode($array_producer);