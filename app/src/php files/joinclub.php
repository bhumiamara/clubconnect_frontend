<?php
include __DIR__ . '/config.php';

// Get JSON input
$input = json_decode(file_get_contents('php://input'), true);

$user_id = $input['user_id'] ?? null;
$name    = $input['name'] ?? null;
$regno   = $input['regno'] ?? null;
$club_id = $input['club_id'] ?? null;

if (!$user_id || !$name || !$regno || !$club_id) {
    echo json_encode(["error" => "All fields (user_id, name, regno, club_id) are required"]);
    exit;
}

// Insert into club_members
$sql = "INSERT INTO club_members (user_id, name, regno, club_id, joined_at)
        VALUES (
            '".mysqli_real_escape_string($conn, $user_id)."',
            '".mysqli_real_escape_string($conn, $name)."',
            '".mysqli_real_escape_string($conn, $regno)."',
            '".mysqli_real_escape_string($conn, $club_id)."',
            NOW()
        )";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode(["success" => "User joined club successfully", "member_id" => mysqli_insert_id($conn)]);
} else {
    echo json_encode(["error" => "Query failed: " . mysqli_error($conn)]);
}

$conn->close();
?>
