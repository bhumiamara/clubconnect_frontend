<?php
header("Content-Type: application/json; charset=UTF-8");
error_reporting(0);

include 'db.php';

$data = json_decode(file_get_contents("php://input"), true);

$name = trim($data['name'] ?? '');
$roll = trim($data['roll'] ?? '');
$email = trim($data['email'] ?? '');
$department = trim($data['department'] ?? '');
$password = trim($data['password'] ?? '');
$role = trim($data['role'] ?? '');

if ($name=="" || $roll=="" || $email=="" || $department=="" || $password=="" || $role=="") {
    echo json_encode([
        "status" => "error",
        "message" => "All fields are required"
    ]);
    exit;
}

// ⚠️ Plain text password (as you requested earlier)
// Recommended: password_hash($password, PASSWORD_DEFAULT);

$stmt = $conn->prepare(
    "INSERT INTO users (name, roll, email, department, password, role)
     VALUES (?, ?, ?, ?, ?, ?)"
);

$stmt->bind_param("ssssss", $name, $roll, $email, $department, $password, $role);

if ($stmt->execute()) {
    echo json_encode([
        "status" => "success",
        "message" => "Registration successful"
    ]);
} else {
    echo json_encode([
        "status" => "error",
        "message" => "Email already exists"
    ]);
}

$stmt->close();
$conn->close();
?>
