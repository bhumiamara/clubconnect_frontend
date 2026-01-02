<?php
header("Content-Type: application/json");
include 'config.php'; // make sure $conn (mysqli) is created in config.php

// Read raw JSON body
$input = file_get_contents('php://input');
$data = json_decode($input, true);

// If JSON decode failed, show helpful error
if ($input !== '' && $data === null) {
    echo json_encode(["error" => "Invalid JSON in request body", "body_received" => $input]);
    exit;
}

// required param
$volunteer_id = isset($data['volunteer_id']) ? intval($data['volunteer_id']) : null;
$task = isset($data['task']) ? trim($data['task']) : null;
$status = isset($data['status']) ? trim($data['status']) : null;

if (!$volunteer_id) {
    echo json_encode(["error" => "volunteer_id is required"]);
    exit;
}

// Build dynamic update parts and parameters
$fields = [];
$types = "";
$params = [];

if ($task !== null) {
    $fields[] = "task = ?";
    $types .= "s";
    $params[] = $task;
}
if ($status !== null) {
    $fields[] = "status = ?";
    $types .= "s";
    $params[] = $status;
}

if (count($fields) === 0) {
    echo json_encode(["error" => "Nothing to update. Provide 'task' and/or 'status'."]);
    exit;
}

$fields_sql = implode(", ", $fields);
$sql = "UPDATE volunteers SET {$fields_sql} WHERE volunteer_id = ?";

$stmt = $conn->prepare($sql);
if ($stmt === false) {
    echo json_encode(["error" => "Prepare failed", "mysqli_error" => $conn->error]);
    exit;
}

// bind params (add volunteer_id as last integer param)
$types .= "i";
$params[] = $volunteer_id;

// Create references for bind_param
$bind_names[] = $types;
for ($i = 0; $i < count($params); $i++) {
    $bind_name = 'bind' . $i;
    $$bind_name = $params[$i];
    $bind_names[] = &$$bind_name;
}
// call bind_param with dynamic args
call_user_func_array([$stmt, 'bind_param'], $bind_names);

if (!$stmt->execute()) {
    echo json_encode(["status" => "failed", "message" => "Execute failed", "mysqli_error" => $stmt->error]);
    exit;
}

// Fetch updated row to return
$fetch = $conn->prepare("SELECT volunteer_id, member_id, name, regno, club_id, club_name, task, event_name, event_date, joined_at FROM volunteers WHERE volunteer_id = ?");
$fetch->bind_param("i", $volunteer_id);
$fetch->execute();
$res = $fetch->get_result();
$updated = $res->fetch_assoc();

echo json_encode([
    "status" => "success",
    "message" => "Volunteer updated successfully",
    "updated_data" => $updated
], JSON_PRETTY_PRINT);
?>
