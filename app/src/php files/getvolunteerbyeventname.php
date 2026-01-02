<?php
header("Content-Type: application/json");
include 'config.php'; // DB connection

// Check input
if (!isset($_GET['event_name']) || trim($_GET['event_name']) === "") {
    echo json_encode(["error" => "event_name is required"]);
    exit;
}

$event_name = $_GET['event_name'];

// SQL Query
$sql = "SELECT volunteer_id, member_id, name, regno, club_id, club_name, task, event_name, event_date, joined_at
        FROM volunteers
        WHERE event_name = ?";

$stmt = $conn->prepare($sql);
$stmt->bind_param("s", $event_name);
$stmt->execute();
$result = $stmt->get_result();

$volunteers = [];

while ($row = $result->fetch_assoc()) {
    $volunteers[] = $row;
}

// Final JSON Response
$response = [
    "status" => "success",
    "event_name" => $event_name,
    "count" => count($volunteers),
    "volunteers" => $volunteers
];

echo json_encode($response, JSON_PRETTY_PRINT);
?>
