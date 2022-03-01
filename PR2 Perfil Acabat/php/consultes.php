<?php
// session_start();

    function con() {
    $connexio = new mysqli ("localhost", "root", "Fat/3232", "gimnas");
    return $connexio;
    }
    

    function obtenirActivitats(){
    $sql = "SELECT A.nom, A.hora_inici, S.aforament, M.nom as monitor, S.descripcio FROM Activitat A, Monitor M, Sala S WHERE A.id_sala=S.id_sala AND S.DNI_monitor=M.DNI_monitor AND dia=1
    ORDER BY A.hora_inici, A.nom";
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

?>