<?php
    session_start();

    $DNI = $_SESSION['DNI'];
    $id_act=$_GET['idact'];
    $id_sala = $_GET['idsala'];
    $servidor = "localhost";
    $nom = "root";
    $password = "Fat/3232";
    $db = "gimnas";
    $data = date("Y-m-d");
    $hora = date("H:i:s");


    $conexion = new mysqli($servidor, $nom, $password, $db);

    if($conexion->connect_error){
        die("Conexion fallida: " . $conexion->connect_error);
    }

    $sql = "INSERT INTO Realitzacio (data, hora, id_act, id_sala, DNI) VALUES ('$data', '$hora', '$id_act', '$id_sala', '$DNI')";

    if($conexion->query($sql) === true){
        echo 'Hola';
    } else{
        die("Error" . $conexion->error);
    }


?>


<!-- <?php



    function con() {
    $connexio = new mysqli ("localhost", "root", "Fat/3232", "gimnas");
    return $connexio;
    }

    $data = date("Y-m-d");
    $hora = date("H:i:s");
    function insertReservaActivitat(){
        $sql = "INSERT INTO Realitzacio (data, hora, id_act, id_sala, DNI) VALUES ('$data', '$hora', '$id_act', '$id_sala', '$DNI')";
        $result = con()->query($sql);
    }


    
require "pagact.php";
    
?> -->

