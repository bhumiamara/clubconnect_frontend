<?php
header("Content-Type: application/json");
include 'config.php';

$sql = "SELECT * FROM announcements ORDER BY created_at DESC";
$result = mysqli_query($conn, $sql);

$announcements = [];

while ($row = mysqli_fetch_assoc($result)) {
    $announcements[] = $row;
}

echo json_encode(["announcements" => $announcements], JSON_PRETTY_PRINT);
?>
