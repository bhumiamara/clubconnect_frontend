<?php
// Database configuration
$host = "localhost";      // Usually localhost in XAMPP
$user = "root";           // Default XAMPP MySQL user
$pass = "";               // Default XAMPP MySQL password is empty
$dbname = "clubconnect";  // Your database name

// Create connection
$conn = mysqli_connect($host, $user, $pass, $dbname);

// Check connection
if (!$conn) {
    die(json_encode([
        "error" => "Database connection failed: " . mysqli_connect_error()
    ]));
}

// Optional: Set character set to UTF-8
mysqli_set_charset($conn, "utf8");
?>
