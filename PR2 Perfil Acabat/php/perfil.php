<?php
include 'consultes.php'; 
session_start();
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
                    <a href="#">Fitxa</a>
                    <a href="#">Reserves</a>
                    <a href="pagact.php">Activitats</a>
                    <a href="login.php">Veure Reserves<a>
                </div>
            </div>
            <section class="textes-header">
            </section>
        </div>
            <div class="main">
                <section class="contenedor sobre-nosotros">
                        <div class="contenedor-sobre-nosotros">
            <form class="form">
                        <h2>DADES PERSONALS</h2>
                        <p type="DNI:"><input value="<?php echo $_SESSION['DNI'] ?>"></input></p>
                        <p type="Nom:"><input value="<?php echo $_SESSION['nom'] ?>"></input></p>
                        <p type="Cognom1:"><input value="<?php echo $_SESSION['cognom1'] ?>"></input></p>
                        <p type="Cognom2:"><input value="<?php echo $_SESSION['cognom2'] ?>"></input></p>
                        <p type="Sexe:"><input value="<?php echo $_SESSION['sexe'] ?>"></input></p>
                        <p type="Data de naixement:"><input value="<?php echo $_SESSION['datanaixement'] ?>"></input></p>
                        <h2>DADES D' ACCÉS</h2>
                        <p type="Usuari:"><input value="<?php echo $_SESSION['usuari'] ?>"></input></p>
                        <p type="Contrasenya:"><input value="<?php echo $_SESSION['passwd'] ?>"></input></p>
                        <h2>DADES DE CONTACTE</h2>
                        <p type="Mobil:"><input value="<?php echo $_SESSION['telefon'] ?>"></input></p>
                        <p type="Correu:"><input value="<?php echo $_SESSION['email'] ?>"></input></p>
                        <h2>COMUNICACIO COMERCIAL</h2>
                        <p type="Comunicacio comercial:"><input value="<?php echo $_SESSION['comunicaciocomercial'] ?>"></input></p>
                        <h2>COMPTE BANCARI</h2>
                        <p type="CCC:"><input value="<?php echo $_SESSION['ccc'] ?>"></input></p>
                <div>
            </div>
        </form>
    </body>
</html>
