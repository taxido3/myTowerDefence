<?php

//erzeuge leeres array für datenausgabe
$output = [];
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

$sql = "SELECT * FROM highscore order by Wellen desc";
//Datenbankanfrage abschicken und Ergebnis in $result speichern
$result = $conn->query($sql);

//Wenn mindestens ein Datanesatz vorhanden ist ....
if ($result->num_rows > 0) {

   // hole jeden Datensatz einzeln aus dem Anfrageergebnis heraus($result)
   while($row = $result->fetch_assoc()) {
      //füge jede zeile ans ende eines array hinzu
      $output []= $row;
   }

} else {
  echo "no";
}

//GEBE AN GUI / APP / ... zurück
//var_dump($output);
echo json_encode($output);

$conn->close();
?>
