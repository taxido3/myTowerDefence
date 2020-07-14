<?php

$param1 = $_GET['param1']; 
$param2 = $_GET['param2']; 
/******************** -- POST DATA -- **************************/

//******************** -- DB CONNECT -- **************************/
    $servername = "127.0.0.1";
    $username = "root";
    $password = "";
    $dbname = "towerdefence";
    // Create connection
    $conn = new mysqli($servername, $username, $password, $dbname);
    // Break connection
    mysqli_set_charset($conn,"utf8");
    //**************************************
    if ($conn->connect_error) {
       die("Connection failed: " . $conn->connect_error);
    }

/************************************************************************/
//Datenbankanfrage zusammenstellen

$sql = "INSERT INTO highscore(Tag, Wellen) VALUES ('".$param1."','".$param2."')";


//Datenbankanfrage abschicken und Ergebnis in $result speichern
$result = $conn->query($sql);

?>
