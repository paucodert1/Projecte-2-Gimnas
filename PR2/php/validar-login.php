<?php
$mysqli = new mysqli("localhost:3306","root","Fat/3232","gimnas");

    $DNI=$_POST['DNI'];
    $PASSWORD=$_POST['passwd'];

// Check connection
if ($mysqli -> connect_errno){
  echo "Failed to connect to MySQL: " . $mysqli -> connect_error;
  exit();
}

// Perform query
if ($result = $mysqli -> query("SELECT * FROM usuari_web where $DNI = '$DNI' and passwd='$PASSWORD'")) {
  echo "Returned rows are: " . $result -> num_rows;
  header("location: activitats.php");
  
} else {
  echo '
  <script>
  alert("El DNI o el Usuari son invalids");
  location.href = "../php/login.php";
  </script>
  '; 
}

header("location: activitats.php");

// Free result set
  
$result -> free_result();
$mysqli -> close();

?>