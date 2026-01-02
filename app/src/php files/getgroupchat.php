<?php
include __DIR__ . '/config.php';

// Accept club_id via GET or POST (JSON body)
$input = json_decode(file_get_contents('php://input'), true);
$club_id = $_GET['club_id'] ?? $input['club_id'] ?? null;

if (!$club_id) {
    echo json_encode(["error" => "club_id is required"]);
    exit;
}

// Fetch all chat messages for this club, including member names
$sql = "SELECT ch.chat_id, ch.member_id, m.name AS member_name, ch.message, ch.sent_at
        FROM club_chats ch
        JOIN club_members m ON ch.member_id = m.id
        WHERE ch.club_id = ?
        ORDER BY ch.sent_at ASC";

$stmt = mysqli_prepare($conn, $sql);
mysqli_stmt_bind_param($stmt, "i", $club_id);
mysqli_stmt_execute($stmt);
$result = mysqli_stmt_get_result($stmt);

$chats = [];
while ($row = mysqli_fetch_assoc($result)) {
    $chats[] = $row;
}

// Get club name
$club_name_result = mysqli_query($conn, "SELECT club_name FROM clubs WHERE club_id = $club_id");
$club_name_row = mysqli_fetch_assoc($club_name_result);
$club_name = $club_name_row['club_name'] ?? "Unknown Club";

// Return JSON
echo json_encode([
    "club_id" => $club_id,
    "club_name" => $club_name,
    "chats" => $chats
], JSON_PRETTY_PRINT);

$conn->close();
?>
