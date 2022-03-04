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
    <link rel="stylesheet" href="../css/estilos.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display&family=Zen+Kaku+Gothic+Antique:wght@300&display=swap" rel="stylesheet">
</head>

<body>
    <div class="header">
        <div class="nav">
                <a href="index.php">Inici</a>
                <a href="perfil.php">Info Compte</a>
                <a href="#">Reserves</a>
                <a href="login.php">Veure Reserves<a>
                <a href="pagact.php">Activitats</a>
                <a href="">Curses<a>
                <a href="tancaSessio.php">Tanca Sessio<a>
        </div>
        <section class="textes-header">
            <h1>Benvingut/da <?php echo $_SESSION['username']?></h1>
            <h1>a mango gym</h1>
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
            <h2 class="titol">Sobre Nosaltres</h2>
            <div class="contenedor-sobre-nosotros">
                <img src="../img/ilustracion2.svg" alt="" class="imagen-about-us">
                <div class="contenido-textos">
                    <h3><span>1</span>Origen</h3>
                    <p>Mango Gym neix a la província de Lleida concretament al municipi de Cervera l'any 2021, producte que a la província no hi havia un gimnàs que pogués suplir les necessitats de les persones que volen entrenar el seu cos sobre la base de l'exercici i el menjar saludable .</p>
                    <h3><span>2</span>Com ho fem?</h3>
                    <p>Perquè ens apassiona el que fem i ens agrada el Fitnes, creem el gimnàs i implementem una Cultura Fisica on podem transmetre als nostres clients la importància de mantenir-se actius i fer exercicis.</p>
                </div>
            </div>
        </section>
        <section class="portafoli">
            <div class="contenidor">
                <h2 class="titol">Activitats</h2>
                <div class="galeria-port">
                    <div class="imatge-port">
                        <img src="../img/img1.jpg" alt="imatge">
                        <div class="hover-galeria">
                            <img src="../img/icono1.png" alt="imatge">
                            <p>El nostre treball</p>
                        </div>
                    </div>
                    <div class="imatge-port">
                        <img src="../img/img2.jpg" alt="imatge">
                        <div class="hover-galeria">
                            <img src="../img/icono1.png" alt="imatge">
                            <p>El nostre treball</p>
                        </div>
                    </div>
                    <div class="imatge-port">
                        <img src="../img/img3.jpg" alt="imatge">
                        <div class="hover-galeria">
                            <img src="../img/icono1.png" alt="imatge">
                            <p>El nostre treball</p>
                        </div>
                    </div>
                    <div class="imatge-port">
                        <img src="../img/img4.jpg" alt="imatge">
                        <div class="hover-galeria">
                            <img src="../img/icono1.png" alt="imatge">
                            <p>El nostre treball</p>
                        </div>
                    </div>
                    <div class="imatge-port">
                        <img src="../img/img4.jpg" alt="imatge">
                        <div class="hover-galeria">
                            <img src="../img/icono1.png" alt="imatge">
                            <p>El nostre treball</p>
                        </div>
                    </div>
                    <div class="imatge-port">
                        <img src="../img/img5.jpg" alt="imatge">
                        <div class="hover-galeria">
                            <img src="../img/icono1.png" alt="imatge">
                            <p>El nostre treball</p>
                        </div>
                    </div>
                    <div class="imatge-port">
                        <img src="../img/img6.jpg" alt="imatge">
                        <div class="hover-galeria">
                            <img src="../img/icono1.png" alt="imatge">
                            <p>El nostre treball</p>
                        </div>
                    </div>
                    <div class="imatge-port">
                        <img src="../img/img7.jpg" alt="imatge">
                        <div class="hover-galeria">
                            <img src="../img/icono1.png" alt="imatge">
                            <p>El nostre treball</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="clients contenidor">
            <h2 class="titol">Que diuen els nostres clients</h2>
            <div class="cards">
                <div class="card">
                    <img src="../img/face1.jpg" alt="imatge">
                    <div class="contingut-texte-card">
                        <h4>Celena</h4>
                        <p>Fa dos anys que entreno al MangoGym durant les meves vacances i estic encantat. Tenen tot el que necessiten per entrenar (sense floritures necessàries) i un munt de classes col·lectives.</p>
                    </div>
                </div>
                <div class="card">
                    <img src="../img/face2.jpg" alt="imatge">
                    <div class="contingut-texte-card">
                        <h4>Maria</h4>
                        <p>Instal·lacions de qualitat i alta professionalitat. És tot un luxe poder comptar amb la direcció i el consell de dos professionals com els que regenten aquest gym per un preu a l'abast de qualsevol butxaca.</p>
                    </div>
                </div>
            </div>
        </section>
        <section class="about-service">
            <div class="contenidor">
                <h2 class="titol">Els nostres serveis</h2>
                <div class="servei-cont">
                    <div class="servei-ind">
                        <img src="../img/ilustracion3.svg" alt="imatge">
                        <h3>Competicions semanals</h3>
                        <p>S' efectuen competicions amb un preu en efectiu per al guayandor de el event setmanal.</p>
                    </div>
                    <div class="servei-ind">
                        <img src="../img/ilustracion2.svg" alt="imatge">
                        <h3>Entrenador Personal</h3>
                        <p>Hi ha fins a 10 entrenador a la disposicio de el clients de dilluns a divendres.</p>
                    </div>
                    <div class="servei-ind">
                        <img src="../img/ilustracion4.svg" alt="imatge">
                        <h3>Ordinador Personal</h3>
                        <p>Lliurem un dispositiu informatic i el client disposa de la opcio per seleccionar SOs.</p>
                    </div>
                </div>
            </div>
        </section>
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