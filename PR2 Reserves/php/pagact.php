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
                <a href="reserves.php">Veure Reserves<a>
                <a href="pagact.php">Activitats</a>
                <a href="index.php">Tanca Sessio<a>
            </div>      
        </div>
        <section class="textes-header">
        </section>
    </div>
    <div class="main">
        <div id="colectives">
            <h3>ACTIVITATS COL·LECTIVES</h3>
            <div class="contenidor-tarjetes">
                <ul>
                <?php $result = obtenirActivitatsColectives();
                    while($row = $result->fetch_assoc()){
                    $DNI = $_SESSION['DNI'];
                    ?>
                        <li>
                            <div class="tarjeta">
                                <div class="info">
                                    <?php
                                    $id_act = $row["id_act"];
                                    $id_sala = $row["id_sala"];
                                    $aforament = $row["aforament"];
                                    $horainici = $row['hora_inici'];
                                    ?>
                                    
                                    <p>Nom: <?php echo $row['nom_act'] ?></p>
                                    <p>Aforament lliure: <?php echo $row['aforament'] ?> /40</p>
                                    <p>Hora d'inici: <?php echo $row['hora_inici'] ?></p>
                                    <p>Nom del monitor: <?php echo $row['nom_monitor'] ?></p>
                                    <p>Sala: <?php echo $row['descripcio'] ?></p>
                                </div>
                                <div class="imatgeact">
                                    <img src="../img/1.png" alt="imatge_gym">
                                </div>
                                    <?php
                                    echo "<a href='reservaActColectiva.php?idact=$id_act&idsala=$id_sala&aforamentact=$aforament&horainici=$horainici'>Fer reserva</a>";
                                    ?>
                                    <?php
                                    echo "<a href='anulacolectiva.php?idact=$id_act&idsala=$id_sala&aforamentact=$aforament'>Anul·lar la reserva</a>";
                                    ?>
                            </div>
                        </li>
                        <?php } ?>
                </ul>



            </div>
        </div>
        <div id="lliures">
            <h3>ACTIVITATS LLIURES</h3>
            <div class="contenidor-tarjetes">
                <ul>
                <?php $result = obtenirActivitatsLliures();
                    while($row = $result->fetch_assoc()){
                    $DNI = $_SESSION['DNI'];
                    ?>
                        <li>
                            <div class="tarjeta">
                                <div class="info">
                                    <?php
                                    $id_act = $row["id_act"];
                                    $id_sala = $row["id_sala"];
                                    $aforament = $row["aforament"];
                                    ?>
                                    
                                    <p>Nom: <?php echo $row['nom_act'] ?></p>
                                    <p>Aforament lliure: <?php echo $row['aforament'] ?> /40</p>
                                    <p>Hora d'inici: <?php echo $row['hora_inici'] ?></p>
                                    <p>Nom del monitor: <?php echo $row['nom_monitor'] ?></p>
                                    <p>Sala: <?php echo $row['descripcio'] ?></p>
                                </div>
                                <div class="imatgeact">
                                    <img src="../img/1.png" alt="imatge_gym">
                                </div>
                                    <?php
                                    echo "<a href='reservaActLliure.php?idact=$id_act&idsala=$id_sala&aforamentact=$aforament'>Fer reserva</a>";
                                    ?>
                                    <?php
                                    echo "<a href='anulalliure.php?idact=$id_act&idsala=$id_sala&aforamentact=$aforament'>Anul·lar la reserva</a>";
                                    ?>
                            </div>
                        </li>
                        <?php } ?>
                </ul>



            </div>
        </div>













    </div>
</div>
<script src="funcions.js"></script>
</body>

</html>