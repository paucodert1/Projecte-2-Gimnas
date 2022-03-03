<?php
    session_start();

    $DNI = $_SESSION['DNI'];
    $id_act=$_GET['idact'];
    $id_sala = $_GET['idsala'];
    $servidor = "localhost";
    $nom = "root";
    $password = "";
    $db = "gimnas";
    $data = date("Y-m-d");
    $hora = date("H:i:s");
    $aforament = $_GET['aforamentact'];


    $conexion = new mysqli($servidor, $nom, $password, $db);

    if($conexion->connect_error){
        die("Conexion fallida: " . $conexion->connect_error);
    } else{

        $sql = "SELECT * FROM Realitzacio WHERE DNI = '" .  $DNI ."' AND id_act IN (SELECT AL.id_act FROM Activitat_lliure AL) AND data = '" .  $data . "'";
        $resultado=mysqli_query($conexion,$sql);
    
        $filas=mysqli_num_rows($resultado);
    
        if($filas){
            echo 'No pots reservar més de una activitat lliure al dia';
        } else{
            if($aforament>=1){
                
                $sql = "INSERT INTO Realitzacio (data, hora, id_act, id_sala, DNI) VALUES ('$data', '$hora', '$id_act', '$id_sala', '$DNI')";
            
                if($conexion->query($sql) === true){
                    echo 'Hola';
                } else{
                    die("Error en fer la reserva" . $conexion->error);
                }
            }
            
        }
        
        
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

