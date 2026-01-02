<?php
include __DIR__ . '/config.php';

$input = json_decode(file_get_contents('php://input'), true);

$club_id     = $input['club_id'] ?? null;
$club_name   = $input['club_name'] ?? null;
$description = $input['description'] ?? null;
$mentor      = $input['mentor'] ?? null;
$logo        = $input['logo'] ?? null;

if (!$club_id) {
    echo json_encode(["error" => "club_id is required"]);
    exit;
}

$sql = "UPDATE clubs SET 
            club_name = '".mysqli_real_escape_string($conn, $club_name)."',
            description = '".mysqli_real_escape_string($conn, $description)."',
            mentor = '".mysqli_real_escape_string($conn, $mentor)."',
            logo = '".mysqli_real_escape_string($conn, $logo)."'
        WHERE club_id = '".mysqli_real_escape_string($conn, $club_id)."'";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode(["success" => "Club updated successfully"]);
} else {
    echo json_encode(["error" => "Query failed: " . mysqli_error($conn)]);
}

$conn->close();
?>
