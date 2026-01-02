<?php
header("Content-Type: application/json");
include "db.php";

// Accept club_name from GET or POST
$club_name = $_REQUEST['club_name'] ?? '';

if (empty($club_name)) {
    echo json_encode(["error" => "club_name is required"]);
    exit;
}

$sql = "SELECT * FROM volunteers WHERE club_name = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("s", $club_name);
$stmt->execute();
$result = $stmt->get_result();

$volunteers = [];

while ($row = $result->fetch_assoc()) {
    $volunteers[] = $row;
}

if (count($volunteers) === 0) {
    echo json_encode(["message" => "No volunteers found"]);
} else {
    echo json_encode(["volunteers" => $volunteers]);
}
?>
