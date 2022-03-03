<?php
// session_start();

    function con() {
    $connexio = new mysqli ("localhost", "root", "Fat/3232", "gimnas");
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
                    $_SESSION['cognom1'] = $row['cognom1'];
                    $_SESSION['cognom2'] = $row['cognom2'];
                    $_SESSION['sexe'] = $row['sexe'];
                    $_SESSION['datanaixement'] = $row['datanaixement'];
                    $_SESSION['username'] = $row['username'];
                    $_SESSION['passwd'] = $row['passwd'];
                    $_SESSION['telefon'] = $row['telefon'];
                    $_SESSION['email'] = $row['email'];
                    $_SESSION['condicio'] = $row['condicio'];
                    $_SESSION['comunicaciocomercial'] = $row['comunicaciocomercial'];
                    $_SESSION['ccc'] = $row['ccc'];
                    header("Location: benvinguda.php");
                }
            }
            else {
                $_SESSION['error'] = "DNI o contrasenya incorrectes";
            }
        }
    }



    function obtenirActivitatsColectives(){
        $sql = "SELECT M.nom as nom_monitor,A.nom as nom_act,S.aforament,A.hora_inici,A.dia,S.descripcio
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

    function modificarDadesPerfil(){
        if(isset($_POST['submit'])){
            $sql = "UPDATE clients set telefon='".$_POST['telefon']."'WHERE DNI='".$_SESSION['DNI']."'";
            $result = con()->query($sql);
            

        } else{
            $_SESSION['error2'] = "No funciona el update";
        }
    }
    
    
   
?>