<?php
include __DIR__ . '/config.php';

$sql = "SELECT * FROM clubs ORDER BY club_id ASC";
$result = mysqli_query($conn, $sql);

$clubs = [];

if ($result) {
    while ($row = mysqli_fetch_assoc($result)) {
        $clubs[] = $row;
    }
    echo json_encode(["clubs" => $clubs], JSON_PRETTY_PRINT);
} else {
    echo json_encode(["error" => "Query failed: " . mysqli_error($conn)]);
}

$conn->close();
?>
