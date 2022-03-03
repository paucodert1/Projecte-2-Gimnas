<?php

    function con() {
    $connexio = new mysqli ("localhost", "root", "", "gimnas");
    return $connexio;
    }

    function inicdesessio() {
        if (isset($_POST['submit'])) {
            $sql = "SELECT * FROM clients WHERE DNI = '" . $_POST['DNI'] ."' AND passwd = '" . md5($_POST['passwd']) . "'";
            $result = con()->query($sql);

            if ($result->num_rows > 0) {
                while ($row = $result->fetch_assoc()) {
                    $_SESSION['DNI'] = $row['DNI'];
                    $_SESSION['nom'] = $row['nom'];
                    $_SESSION['cognom'] = $row['cognom'];
                    $_SESSION['telefon'] = $row['telefon'];
                    $_SESSION['email'] = $row['email'];
                    $_SESSION['sexe'] = $row['sexe'];
                    $_SESSION['data_naix'] = $row['data_neixement'];
                    $_SESSION['usuari'] = $row['usuari'];
                    $_SESSION['compte_bancari'] = $row['compte_bancari'];
                    $_SESSION['condicio'] = $row['condicio'];
                    $_SESSION['com_comercial'] = $row['comunicacio_comercial'];
                    $_SESSION['data_alta'] = $row['data_alta'];
                    header("Location: benvinguda.php");
                }
            }
            else {
                $_SESSION['error'] = "DNI o contrasenya incorrectes";
            }
        }
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

    function obtenirActivitatsLliures(){
        $sql = "SELECT A.id_act, M.nom as nom_monitor,A.nom as nom_act,S.aforament,A.hora_inici,A.dia,A.imatge, S.id_sala, S.descripcio
        FROM Activitat A, Monitor M, Sala S , Activitat_lliure AL
        WHERE A.id_sala=S.id_sala AND 
        S.DNI_monitor=M.DNI_monitor AND
        A.id_act=AL.id_act AND dia IN (4,5)";
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

    function modificarDadesPerfil(){
        if(isset($_POST['submit'])){
            $sql = "UPDATE clients set telefon='".$_POST['telefon']."'WHERE DNI='".$_SESSION['DNI']."'";
            $result = con()->query($sql);
            

        } else{
            $_SESSION['error2'] = "No funciona el login";
        }
    }

    function obtenirTotesReserves(){
            $DNI = $_SESSION['DNI'];
            $sql = "SELECT * FROM Realitzacio, Activitat
            WHERE Realitzacio.id_act=Activitat.id_act
            AND data is not null 
            AND DNI = '" . $DNI . "'";
            $result = con()->query($sql);

            if ($result->num_rows > 0) {
                    while($row=$result->fetch_assoc()){
                return $result;

            }
        }
    }
    
    
    
   
?>