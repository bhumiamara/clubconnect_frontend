<?php
header("Content-Type: application/json");
include 'config.php';

$data = json_decode(file_get_contents("php://input"), true);

if (!$data) {
    echo json_encode(["error" => "Invalid JSON"]);
    exit;
}

$event_name = $data["event_name"];
$club_name = $data["club_name"];
$campus_block = $data["campus_block"];
$room_or_area = $data["room_or_area"];
$description = $data["description"];
$event_date = $data["event_date"];
$start_time = $data["start_time"];
$end_time = $data["end_time"];

$sql = "INSERT INTO event_locations (event_name, club_name, campus_block, room_or_area, description, event_date, start_time, end_time)
        VALUES ('$event_name', '$club_name', '$campus_block', '$room_or_area', '$description', '$event_date', '$start_time', '$end_time')";

if (mysqli_query($conn, $sql)) {
    echo json_encode(["status" => "success", "message" => "Event added"]);
} else {
    echo json_encode(["status" => "error", "message" => mysqli_error($conn)]);
}
?>
