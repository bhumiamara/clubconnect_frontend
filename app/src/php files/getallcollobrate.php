<?php
include __DIR__ . '/config.php';

$sql = "SELECT 
            col.collab_id,
            col.title,
            col.description,
            col.collab_date,
            col.location,
            c1.club_name AS club_name_1,
            c2.club_name AS club_name_2
        FROM collaborations col
        JOIN clubs c1 ON col.club_id_1 = c1.club_id
        JOIN clubs c2 ON col.club_id_2 = c2.club_id
        ORDER BY col.collab_date ASC";

$result = mysqli_query($conn, $sql);

$collabs = [];

if ($result) {
    while ($row = mysqli_fetch_assoc($result)) {
        $collabs[] = $row;
    }
    echo json_encode(["collaborations" => $collabs], JSON_PRETTY_PRINT);
} else {
    echo json_encode(["error" => "Query failed: " . mysqli_error($conn)]);
}

$conn->close();
?>
