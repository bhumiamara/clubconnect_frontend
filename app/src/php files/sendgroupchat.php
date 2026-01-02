<?php
include __DIR__ . '/config.php';

$input = json_decode(file_get_contents('php://input'), true);

$club_id   = $input['club_id'] ?? null;
$member_id = $input['member_id'] ?? null;
$message   = $input['message'] ?? null;

if (!$club_id || !$member_id || !$message) {
    echo json_encode(["error" => "club_id, member_id, and message are required"]);
    exit;
}

$sql = "INSERT INTO club_chats (club_id, member_id, message) VALUES (
    '".mysqli_real_escape_string($conn, $club_id)."',
    '".mysqli_real_escape_string($conn, $member_id)."',
    '".mysqli_real_escape_string($conn, $message)."'
)";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode([
        "success" => "Message sent to club successfully",
        "chat_id" => mysqli_insert_id($conn)
    ]);
} else {
    echo json_encode(["error" => "Query failed: " . mysqli_error($conn)]);
}

$conn->close();
?>
