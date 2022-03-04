<?php
include 'consultes.php'; 
session_start();
modificarDadesPerfil();
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mango Gym</title>
    <link rel="shortcut icon" href="../img/mango.png" type="image/x-icon">
    <link rel="stylesheet" href="../css/perfil.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&family=Zen+Kaku+Gothic+Antique:wght@300&display=swap" rel="stylesheet">
    <link href="ConnectarDB.php">
</head>
    <body>
        <?php
            $conn
        ?>
        <div class="header">
            <div class="nav">
                <div class="left">
                    <h1><strong>Mango Gym</strong></h1>
                </div>
                <div class="right">
                    <a href="index.php">Inici</a>
                    <a href="perfil.php">Info Compte</a>
                    <a href="#">Reserves</a>
                    <a href="login.php">Veure Reserves<a>
                    <a href="pagact.php">Activitats</a>
                    <a href="">Curses<a>
                    <a href="tancaSessio.php">Tanca Sessio<a>
                </div>
            </div>
        </div>
        <div class="main">
                <section class="contenedor sobre-nosotros">
                        <div class="contenedor-sobre-nosotros">
            <form class="form" method="POST">
                        <h2>DADES PERSONALS</h2>
                        <?php if (isset($_POST['submit'])) {
                         echo $_SESSION['error2'];
                        } ?>
                        
                        <p type="DNI:"><input type="text" value="<?php echo $_SESSION['DNI'] ?>" name="DNI"></input></p> 
                        <p type="Nom:"><input type="text" value="<?php echo $_SESSION['nom'] ?>" name="nom"></input></p> 
                        <p type="Cognom1:"><input type="text" value="<?php echo $_SESSION['cognom1'] ?>" name="cogmnom1"></input></p>
                        <p type="Cognom2:"><input type="text" value="<?php echo $_SESSION['cognom1'] ?>" name="cognom2"></input></p>
                        <p type="Sexe:"><input type="text" value="<?php echo $_SESSION['sexe'] ?>" name="sexe"></input></p> Es pot canviar
                        <p type="Data de naixement:"><input type="text" value="<?php echo $_SESSION['datanaixement'] ?>" name="datanaixement"></input></p>
                        <h2>DADES D' ACCÉS</h2>
                        <p type="Usuari:"><input type="text" value="<?php echo $_SESSION['username'] ?>" name="username"></input></p> Es pot canviar
                        <p type="Contrasenya:"><input type="password" value="" name="passwd"></input></p> Es pot canviar
                        <h2>DADES DE CONTACTE</h2>
                        <p type="Mobil:"><input type="text" value="<?php echo $_SESSION['telefon'] ?>" name="telefon"></input></p> Es pot canviar
                        <p type="Correu:"><input type="text" value="<?php echo $_SESSION['email'] ?>" name="email"></input></p> Es pot canviar
                        <h2>COMUNICACIO COMERCIAL</h2>
                        <p type="Comunicacio comercial:"><input type="text" value="<?php echo $_SESSION['comunicaciocomercial'] ?>" name="comunicaciocomercial" ></input></p> Es pot canviar
                        <h2>COMPTE BANCARI</h2>
                        <p type="CCC:"><input value="<?php echo $_SESSION['ccc'] ?> "name="ccc"></input></p>
                        <button type="submit" name="submit">Guardar dades</button>
                    <div>
                </div>
            </form>
        </div>
    </body>
</html>
