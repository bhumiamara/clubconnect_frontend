<?php
include __DIR__ . '/config.php';

// Get JSON input
$input = json_decode(file_get_contents('php://input'), true);
$club_id = $input['club_id'] ?? null;

if (!$club_id) {
    echo json_encode(["error" => "club_id is required"]);
    exit;
}

// SQL query to delete club
$sql = "DELETE FROM clubs WHERE club_id = '".mysqli_real_escape_string($conn, $club_id)."'";

$result = mysqli_query($conn, $sql);

if ($result) {
    if (mysqli_affected_rows($conn) > 0) {
        echo json_encode(["success" => "Club deleted successfully"]);
    } else {
        echo json_encode(["error" => "Club not found"]);
    }
} else {
    echo json_encode(["error" => "Query failed: " . mysqli_error($conn)]);
}

$conn->close();
?>
