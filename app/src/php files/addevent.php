<?php
header("Content-Type: application/json");
header("Access-Control-Allow-Origin: *");

include __DIR__ . '/config.php';

$raw = file_get_contents("php://input");

if (!$raw) {
    echo json_encode(["error" => "No JSON received"]);
    exit;
}

$input = json_decode($raw, true);

if (!$input) {
    echo json_encode(["error" => "Invalid JSON"]);
    exit;
}

$club_id    = $input['club_id'] ?? null;
$event_name = $input['event_name'] ?? null;
$description = $input['description'] ?? "";
$event_date = $input['event_date'] ?? null;
$location   = $input['location'] ?? "";

if (!$club_id || !$event_name || !$event_date) {
    echo json_encode(["error" => "club_id, event_name, and event_date are required"]);
    exit;
}

$sql = "INSERT INTO events (club_id, event_name, description, event_date, location, created_at)
        VALUES (
            '".mysqli_real_escape_string($conn, $club_id)."',
            '".mysqli_real_escape_string($conn, $event_name)."',
            '".mysqli_real_escape_string($conn, $description)."',
            '".mysqli_real_escape_string($conn, $event_date)."',
            '".mysqli_real_escape_string($conn, $location)."',
            NOW()
        )";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode(["success" => "Event added successfully", "event_id" => mysqli_insert_id($conn)]);
} else {
    echo json_encode(["error" => "Query failed: " . mysqli_error($conn)]);
}

$conn->close();
?>
