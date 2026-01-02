<?php
header("Content-Type: application/json");
include 'db.php';

// Read JSON input
$data = json_decode(file_get_contents("php://input"), true);

$email = $data['email'] ?? '';
$new_password = $data['new_password'] ?? '';
$confirm_password = $data['confirm_password'] ?? '';

// Check empty fields
if (empty($email) || empty($new_password) || empty($confirm_password)) {
    echo json_encode(array(
        "status" => "error",
        "message" => "email, new_password and confirm_password are required"
    ));
    exit;
}

// Check if passwords match
if ($new_password !== $confirm_password) {
    echo json_encode(array(
        "status" => "error",
        "message" => "New password and confirm password do not match"
    ));
    exit;
}

// Plain text password
$plain_password = $new_password;

// Update password
$stmt = $conn->prepare("UPDATE users SET password=? WHERE email=?");
$stmt->bind_param("ss", $plain_password, $email);
$stmt->execute();

if ($stmt->affected_rows > 0) {
    echo json_encode(array(
        "status" => "success",
        "message" => "Password updated successfully"
    ));
} else {
    echo json_encode(array(
        "status" => "error",
        "message" => "Email not found"
    ));
}
?>
