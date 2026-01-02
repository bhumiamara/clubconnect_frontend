<?php
header('Content-Type: application/json');

$host = "localhost";
$user = "root";
$pass = "";
$dbname = "clubconnect";

// Connect to MySQL
$conn = mysqli_connect($host, $user, $pass, $dbname);
if (!$conn) {
    echo json_encode(["error" => "Connection failed: " . mysqli_connect_error()]);
    exit;
}

// Fetch all club locations
$sql = "SELECT * FROM club_locations";
$result = mysqli_query($conn, $sql);

if (!$result) {
    echo json_encode(["error" => mysqli_error($conn)]);
    exit;
}

// Prepare JSON output
$clubs = [];
while ($row = mysqli_fetch_assoc($result)) {
    $clubs[] = $row;
}

echo json_encode(["events" => $clubs], JSON_PRETTY_PRINT);
?>
