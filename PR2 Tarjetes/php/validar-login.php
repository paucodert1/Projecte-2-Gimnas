<?php
$DNI=$_POST['DNI'];
$passwd=$_POST['passwd'];
session_start();
$_SESSION['DNI']=$DNI;

$conn=mysqli_connect("localhost","root","Fat/3232","gimnas");

$consulta="SELECT * FROM Usuari_web U, Clients C WHERE U.DNI='$DNI' AND U.passwd=md5('$passwd')";
$resultado=mysqli_query($conn,$consulta);

$filas=mysqli_num_rows($resultado);

if($filas){
  while($row=$resultado->fetch_assoc()){
    
    $_SESSION['DNI'] = $row['DNI'];
    $_SESSION['nom'] = $row['nom'];
    $_SESSION['cognom1'] = $row['cognom1'];
    $_SESSION['cognom2'] = $row['cognom2'];
    $_SESSION['email'] = $row['email'];
    $_SESSION['sexe'] = $row['sexe'];
    $_SESSION['telefon'] = $row['telefon'];
    $_SESSION['datanaixement'] = $row['datanaixement'];
    $_SESSION['usuari'] = $row['username'];
    $_SESSION['ccc'] = $row['ccc'];
    $_SESSION['comunicaciocomercial'] = $row['comunicaciocomercial'];
    $_SESSION['passwd'] = $row['passwd'];



    
  }
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
