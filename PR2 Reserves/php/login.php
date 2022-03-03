<?php 
include 'consultes.php';
session_start();
inicdesessio();

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="../css/loginanimat.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<form class="login" action="" method="POST">
  <input type="text" placeholder="DNI" name="DNI">
  <input type="password" placeholder="Contrasenya" name="passwd">
  <input type="submit" name="submit">
</form>

</body>
</html>