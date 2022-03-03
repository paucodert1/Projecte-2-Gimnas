<?php
// session_start();

    function con() {
    $connexio = new mysqli ("localhost", "root", "Fat/3232", "gimnas");
    return $connexio;
    }

    function obtenirActivitatsColectives(){
        $sql = "SELECT A.id_act, M.nom as nom_monitor,A.nom as nom_act,S.aforament,A.hora_inici,A.dia,A.imatge, S.id_sala, S.descripcio
        FROM Activitat A, Monitor M, Sala S , Activitat_colectiva AC
        WHERE A.id_sala=S.id_sala AND 
        S.DNI_monitor=M.DNI_monitor AND
        A.id_act=AC.id_act AND dia IN (4,5)";
        $result = con()->query($sql);
        return $result;
    }
    
    

    function obtenirInfoClient(){
            // $DNI = $_SESSION['DNI'];
            $sql = "SELECT DNI,nom,cognom1,cognom2,datanaixement,email,telefon,ccc FROM clients WHERE DNI=$DNI";
            $result = con()->query($sql);

            if ($result->num_rows > 0) {
                    while($row=$result->fetch_assoc()){
                return $result;

            }
        }
    }

    // $data = date("Y-m-d");
    // $hora = date("H:i:s");
    // function insertReservaActivitat(){
    //     $sql = "INSERT INTO Realitzacio ($data, $hora, id_act, id_sala, dni) VALUES ('date(Y-M-D)', '13:30:00', '1', 1, '00046319C')";
    //     $result = con()->query($sql);
    // }
    
   
?>