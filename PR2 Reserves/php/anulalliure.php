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
    $aforament = $_GET['aforamentact'];


    $conexion = new mysqli($servidor, $nom, $password, $db);

    if($conexion->connect_error){
        die("Conexion fallida: " . $conexion->connect_error);
    } else{

        $sql = "SELECT * FROM Realitzacio WHERE DNI = '" .  $DNI ."' AND ($id_act IN (SELECT AL.id_act FROM Activitat_lliure AL)) AND data = '" .  $data ."' AND id_act = '" .  $id_act . "'";
        $resultado=mysqli_query($conexion,$sql);
    
        $filas=mysqli_num_rows($resultado);
    
        if($filas){
            $sql = "UPDATE Realitzacio 
                    SET data=null
                    WHERE DNI = '" .  $DNI ."' AND id_act = '" .  $id_act ."' AND data = '" .  $data . "'";
            
                if($conexion->query($sql) === true){
                    echo 'Reserva anulada';
                } else{
                    die("Error en anular la reserva" . $conexion->error);
                }
        } else{
            echo 'No es pot anu·lar perquè no has reservat la activitat.';
        }
        
        
    }



?>