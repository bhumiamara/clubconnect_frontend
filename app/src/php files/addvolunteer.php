<?php
header("Content-Type: application/json");
include 'db.php'; // use the fixed db.php

// Decode JSON input
$data = json_decode(file_get_contents("php://input"), true);

$member_id  = $data['member_id'] ?? null;
$name       = $data['name'] ?? null;
$regno      = $data['regno'] ?? null;
$club_id    = $data['club_id'] ?? null;
$club_name  = $data['club_name'] ?? null;
$task       = $data['task'] ?? null;
$event_name = $data['event_name'] ?? null;
$event_date = $data['event_date'] ?? null;

// Check required fields
if (!$member_id || !$name || !$regno || !$club_id || !$club_name) {
    echo json_encode(["error" => "Required fields are missing"]);
    exit;
}

// Insert volunteer
$sql = "INSERT INTO volunteers (member_id, name, regno, club_id, club_name, task, event_name, event_date)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
$stmt = mysqli_prepare($conn, $sql);
mysqli_stmt_bind_param($stmt, "ississss", $member_id, $name, $regno, $club_id, $club_name, $task, $event_name, $event_date);

if (mysqli_stmt_execute($stmt)) {
    echo json_encode(["success" => "Volunteer added successfully"]);
} else {
    echo json_encode(["error" => mysqli_error($conn)]);
}

// Close statement and connection
mysqli_stmt_close($stmt);
mysqli_close($conn);
?>
