<?php
include __DIR__ . '/config.php';

$input = json_decode(file_get_contents("php://input"), true);

$club_id_1   = $input['club_id_1'] ?? null;
$club_id_2   = $input['club_id_2'] ?? null;
$title       = $input['title'] ?? null;
$description = $input['description'] ?? null;
$collab_date = $input['collab_date'] ?? null;
$location    = $input['location'] ?? null;

if (!$club_id_1 || !$club_id_2 || !$title || !$collab_date) {
    echo json_encode(["error" => "club_id_1, club_id_2, title, and collab_date are required"]);
    exit;
}

$sql = "INSERT INTO collaborations (club_id_1, club_id_2, title, description, collab_date, location)
        VALUES (
            '".mysqli_real_escape_string($conn, $club_id_1)."',
            '".mysqli_real_escape_string($conn, $club_id_2)."',
            '".mysqli_real_escape_string($conn, $title)."',
            '".mysqli_real_escape_string($conn, $description)."',
            '".mysqli_real_escape_string($conn, $collab_date)."',
            '".mysqli_real_escape_string($conn, $location)."'
        )";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode([
        "success" => "Collaboration added successfully",
        "collab_id" => mysqli_insert_id($conn)
    ]);
} else {
    echo json_encode(["error" => "Query failed: " . mysqli_error($conn)]);
}

$conn->close();
?>
