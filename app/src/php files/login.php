<?php
include 'db.php';
header("Content-Type: application/json");

// Read JSON input
$raw = file_get_contents("php://input");
$data = json_decode($raw, true);

// Get fields
$email    = trim($data['email'] ?? '');
$password = trim($data['password'] ?? '');

// 1. Check empty fields
if ($email === "" || $password === "") {
    echo json_encode([
        "status" => "error",
        "message" => "Email and password are required"
    ]);
    exit;
}

// 2. Email format validation
if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    echo json_encode([
        "status" => "error",
        "message" => "Invalid email format"
    ]);
    exit;
}

// 3. Check if email exists in DB
$sql = "SELECT * FROM users WHERE email='$email' LIMIT 1";
$result = mysqli_query($conn, $sql);

if (mysqli_num_rows($result) == 0) {
    echo json_encode([
        "status" => "error",
        "message" => "Email not registered"
    ]);
    exit;
}

$user = mysqli_fetch_assoc($result);

// 4. Password check (plain text)
if ($user['password'] !== $password) {
    echo json_encode([
        "status" => "error",
        "message" => "Incorrect password"
    ]);
    exit;
}

// SUCCESS
echo json_encode([
    "status" => "success",
    "message" => "Login successful",
    "user" => [
        "id" => $user["id"],
        "name" => $user["name"],
        "email" => $user["email"],
        "role" => $user["role"]
    ]
]);
