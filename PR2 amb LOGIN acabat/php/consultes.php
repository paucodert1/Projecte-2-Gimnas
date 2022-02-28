<?php

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

    
?>