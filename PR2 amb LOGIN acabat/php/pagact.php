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
                <a href="#">Info Compte</a>
                <a href="#">Fitxa</a>
                <a href="#">Reserves</a>
                <a href="paguinaActivitats.php">Activitats</a>
                <a href="login.php">Veure Reserves<a>
            </div>
            
        </div>
        <section class="textes-header">
        </section>
        <div class="ola" style="height: 150px; overflow: hidden;"><svg viewBox="0 0 500 150" preserveAspectRatio="none"
                style="height: 100%; width: 100%;">
                <path d="M0.00,49.99 C150.00,150.00 349.21,-49.99 500.00,49.99 L500.00,150.00 L0.00,150.00 Z"
                    style="stroke: none; fill: white;"></path>
            </svg>
        </div>
    </div>
    <div class="main">
        <section class="contenedor sobre-nosotros">
            <h2 class="titol">ACTIVITATS</h2>

            <table>

                <tr id="first">
                    <td>NOM</td>
                    <td>HORA INCI</td>
                    <td>AFORAMENT</td>
                    <td>MATERIAL</td>
                    <td>ESTOC</td>
                </tr>
                
                <?php foreach($result as $registre ): ?>
        
                <tr>
                    <td><?php echo $registre['nom']; ?></td>
                    <td><?php echo $registre['hora_inici']; ?></td>
                </tr>
        
                <?php endforeach; ?>
	
	        </table>
            <div class="contenedor-sobre-nosotros">
                <div class="contenido-textos">
                </div>
        </section>
    <div class="footer">
        <div class="contenidor-footer">
            <div class="content-foo">
                <h4>Phone</h4>
                <p>69694538282</p>
            </div>
            <div class="content-foo">
                <h4>Email</h4>
                <p>mangogym</p>
            </div>
            <div class="content-foo">
                <h4>Location</h4>
                <p>69694538282</p>
            </div>
    </div>
        <h2 class="titol-final">&copy;Pau Rubio | Bruno Tome</h2>
</div>
<script src="funcions.js"></script>
</body>

</html>