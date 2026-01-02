<?php
include __DIR__ . '/config.php';

$input = json_decode(file_get_contents('php://input'), true);

$club_name = $input['club_name'] ?? null;
$description = $input['description'] ?? null;
$mentor = $input['mentor'] ?? null;
$logo = $input['logo'] ?? null;

if (!$club_name) {
    echo json_encode(["error" => "club_name is required"]);
    exit;
}

$sql = "INSERT INTO clubs (club_name, description, mentor, logo, created_at) 
        VALUES ('".mysqli_real_escape_string($conn, $club_name)."', 
                '".mysqli_real_escape_string($conn, $description)."',
                '".mysqli_real_escape_string($conn, $mentor)."',
                '".mysqli_real_escape_string($conn, $logo)."',
                NOW())";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode(["success" => "Club added successfully"]);
} else {
    echo json_encode(["error" => "Query failed: " . mysqli_error($conn)]);
}

$conn->close();
?>
