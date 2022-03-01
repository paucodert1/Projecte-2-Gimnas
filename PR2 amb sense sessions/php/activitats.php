<?php

$connexio = new mysqli ("localhost", "root", "Fat/323", "gimnas");

if($connexio->connect_errno){

        die("No s'ha pogut fer la connexió");
        } else{
        
                $sql = ";
                $result = $connexio->query($sql);

        }

?>