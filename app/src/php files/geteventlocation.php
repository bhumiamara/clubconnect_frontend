<?php
header("Content-Type: application/json");
include 'config.php';

$sql = "SELECT * FROM event_locations";
$result = mysqli_query($conn, $sql);

$events = [];

while ($row = mysqli_fetch_assoc($result)) {
    $events[] = $row;
}

echo json_encode(["events" => $events]);
?>
