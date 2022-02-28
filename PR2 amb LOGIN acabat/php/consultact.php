<?php

    function con() {
    $connexio = new mysqli ("localhost", "root", "1234", "gimnas");

    function obtenirActivitatsLLiures(){
    $sql = "SELECT nom,hora_inici FROM activitat";
    $result = con()->query($sql);

    return $result;

    }

?>