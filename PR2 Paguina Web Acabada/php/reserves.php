<?php include 'consultes.php';
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
</head>
<body>
    <div class="header">
        <div class="nav">
            <div class="left">
                <h1><strong>Mango Gym</strong></h1>
            </div>
            <div class="right">
                <a href="index.php">Inici</a>
                <a href="perfil.php">Info Compte</a>
                <a href="../XML Projecte/curses.xml">Curses</a>
                <a href="reserves.php">Veure Reserves</a>
                <a href="pagact.php">Activitats</a>
                <a href="index.php">Tanca Sessio</a>
            </div>      
        </div>
        <section class="textes-header">
        </section>
    </div>
    <div class="main">
        <div id="historial">
            <h3>Historial d'activitats resrvades</h3>
            <div class="contenidor-tarjetes">
                <ul>
                <?php $result = obtenirTotesReserves();
                    while($row = $result->fetch_assoc()){
                    $DNI = $_SESSION['DNI'];
                    ?>
                        <li>
                            <div class="tarjeta">
                                <div class="inforeserves">
                                    <p><strong>Nom: </strong><?php echo $row['nom'] ?></p>
                                    <p><strong>Data: </strong><?php echo $row['data'] ?></p>
                                    <p><strong>Hora d'inici: </strong><?php echo $row['hora_inici'] ?></p>
                                    <p><strong>Hora final: </strong><?php echo $row['hora_final'] ?></p>
                                </div>
                            </div>
                        </li>
                        <?php } ?>
                </ul>

            </div>
        </div>
    
    </div>
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