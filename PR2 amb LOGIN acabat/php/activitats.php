<?php

$connexio = new mysqli ("localhost", "root", "Fat/3232", "gimnas");

if($connexio->connect_errno){

        die("No s'ha pogut fer la connexió");
} else{
    
        $sql = "SELECT A.nom, A.hora_inici, A.hora_final, dia FROM Activitat A WHERE dia=5 ORDER BY hora_inici ASC;";
        $result = $connexio->query($sql);

}

require "indexactivitats.php";

?>