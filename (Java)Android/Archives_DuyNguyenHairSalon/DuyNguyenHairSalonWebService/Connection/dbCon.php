<?php
//tạo connect
$connect = mysqli_connect("localhost", "root", "", "duynguyenhairsalon");

//cái này để có tiếng việt
mysqli_query($connect, "SET NAMES 'utf8'");
