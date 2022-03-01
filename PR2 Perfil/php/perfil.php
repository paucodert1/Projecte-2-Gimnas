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
    <link rel="stylesheet" href="../css/login.css">
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
                <a href="#">Info Compte</a>
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
            <h2 class="titol">El teu perfil</h2>
            <form>
            
                <input type="text" value="<?php echo $_SESSION['nom'] ?>">
                <input type="text" value="<?php echo $_SESSION['DNI'] ?>">
                <input type="text" value="<?php echo $_SESSION['cognom1'] ?>">
                <input type="text" value="<?php echo $_SESSION['cognom2'] ?>">
                <input type="text" value="<?php echo $_SESSION['email'] ?>">
                <input type="text" value="<?php echo $_SESSION['sexe'] ?>">
                <input type="text" value="<?php echo $_SESSION['telefon'] ?>">
                <input type="text" value="<?php echo $_SESSION['datanaixement'] ?>">
                <input type="text" value="<?php echo $_SESSION['usuari'] ?>">
                <input type="text" value="<?php echo $_SESSION['ccc'] ?>">
                <input type="text" value="<?php echo $_SESSION['comunicaciocomercial'] ?>">

                <div class="contenedor-sobre-nosotros">
   
            </form>
                <div class="contenido-textos">
            </div>
        </section>
    <div class="footer">
        <div class="contenidor-footer">
            <div class="content-foo">
                <h4>Phone</h4>
                <p>666666666</p>
            </div>
            <div class="content-foo">
                <h4>Email</h4>
                <p>mangogym@gmail.com</p>
            </div>
            <div class="content-foo">
                <h4>Location</h4>
                <p>Carrer de la Vall d'Aran, 13</p>
            </div>
    </div>
        <h2 class="titol-final">&copy;Pau Rubio | Bruno Tome</h2>
</div>
</body>

</html>
