<?php
$DNI=$_POST['DNI'];
$passwd=$_POST['passwd'];
session_start();
$_SESSION['DNI']=$DNI;

$conn=mysqli_connect("localhost","root","1234","gimnas");

$consulta="SELECT * FROM Usuari_web U WHERE U.DNI='$DNI' AND U.passwd='$passwd'";
$resultado=mysqli_query($conn,$consulta);

$filas=mysqli_num_rows($resultado);

if($filas){
  header("location:indexactivitats.php");
}else{
  ?>
  <?php
  include("login.php");
  ?>
  echo '
  <script>
  alert("El DNI o el nom d'usuari introduïts són invalids");
  location.href = "../php/login.php";
  </script> 
  <?php
}
mysqli_free_result($resultado);
mysqli_close($conn);