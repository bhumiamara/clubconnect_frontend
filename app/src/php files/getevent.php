<?php
include __DIR__ . '/config.php';

$sql = "SELECT e.event_id, e.event_name, e.description, e.event_date, e.location, c.club_name
        FROM events e
        JOIN clubs c ON e.club_id = c.club_id
        ORDER BY e.event_date ASC";

$result = mysqli_query($conn, $sql);

$events = [];

if ($result) {
    while ($row = mysqli_fetch_assoc($result)) {
        $events[] = $row;
    }
    echo json_encode(["events" => $events], JSON_PRETTY_PRINT);
} else {
    echo json_encode(["error" => "Query failed: " . mysqli_error($conn)]);
}

$conn->close();
?>
