<?php
$servername = "localhost:3306";
$username = "root";
$password = "Fat/3232";
$database = "gimnas";

// Create connection
$conn = new mysqli($servername, $username, $password,$database);

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}
echo "Connectat de forma correcta";
?>

