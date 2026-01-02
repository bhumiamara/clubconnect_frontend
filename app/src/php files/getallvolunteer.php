<?php
header("Content-Type: application/json");
include 'config.php';

$sql = "SELECT * FROM volunteers ORDER BY joined_at DESC";
$result = mysqli_query($conn, $sql);

$volunteers = [];

while ($row = mysqli_fetch_assoc($result)) {
    $volunteers[] = [
        "volunteer_id" => (int)$row["volunteer_id"],
        "member_id" => (int)$row["member_id"],
        "name" => $row["name"],
        "regno" => $row["regno"],
        "club_id" => (int)$row["club_id"],
        "club_name" => $row["club_name"],
        "task" => $row["task"],
        "event_name" => $row["event_name"],
        "event_date" => $row["event_date"],
        "joined_at" => $row["joined_at"]
    ];
}

echo json_encode($volunteers, JSON_PRETTY_PRINT);
?>
