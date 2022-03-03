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
    $aforament = $_GET['aforamentact'];


    $conexion = new mysqli($servidor, $nom, $password, $db);

    if($conexion->connect_error){
        die("Conexion fallida: " . $conexion->connect_error);
    } else{

        $sql = "SELECT * FROM Realitzacio WHERE DNI = '" .  $DNI ."' AND id_act IN (SELECT AL.id_act FROM Activitat_lliure AL) AND data = '" .  $data . "'";
        $resultado=mysqli_query($conexion,$sql);
    
        $filas=mysqli_num_rows($resultado);
    
        if($filas){
            ?>
            <script>
            alert("No s'ha pogut reservar. No et pots inscriure en més d'una activitat lliure al dia");
            location.href = "pagact.php";
            </script>
            <?php
        } else{
            if($aforament>=1){
                
                $sql = "INSERT INTO Realitzacio (data, hora, id_act, id_sala, DNI) VALUES ('$data', '$hora', '$id_act', '$id_sala', '$DNI')";
            
                if($conexion->query($sql) === true){
                    ?>
                    <script>
                    alert("Activitat reservada");
                    location.href = "pagact.php";
                    </script>
                    <?php
                } else{
                    die("Error en fer la reserva" . $conexion->error);
                }
            }
            
        }
        
        
    }



?>


