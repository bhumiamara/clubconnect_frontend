<?php
header("Content-Type: application/json");
include 'config.php';

// Read JSON input
$data = json_decode(file_get_contents("php://input"), true);

$club_name = $data["club_name"] ?? "";
$announcement_title = $data["announcement_title"] ?? "";
$announcement_text = $data["announcement_text"] ?? "";
$event_date = $data["event_date"] ?? null;
$campus_block = $data["campus_block"] ?? null;
$room_or_area = $data["room_or_area"] ?? null;

$sql = "INSERT INTO announcements (club_name, announcement_title, announcement_text, event_date, campus_block, room_or_area)
        VALUES ('$club_name', '$announcement_title', '$announcement_text', '$event_date', '$campus_block', '$room_or_area')";

if (mysqli_query($conn, $sql)) {
    echo json_encode(["status" => "success", "message" => "Announcement added successfully"]);
} else {
    echo json_encode(["status" => "error", "message" => mysqli_error($conn)]);
}
?>
