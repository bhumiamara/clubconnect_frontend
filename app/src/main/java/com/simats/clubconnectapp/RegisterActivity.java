package com.simats.clubconnectapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etRoll, etEmail, etDepartment, etPassword, etConfirmPassword;
    Button btnAdmin, btnMember, btnRegister;
    TextView tvLogin;

    String selectedRole = "Member";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etRoll = findViewById(R.id.etRoll);
        etEmail = findViewById(R.id.etEmail);
        etDepartment = findViewById(R.id.etDepartment);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

        btnAdmin = findViewById(R.id.btnAdmin);
        btnMember = findViewById(R.id.btnMember);
        btnRegister = findViewById(R.id.btnRegister);
        tvLogin = findViewById(R.id.tvLogin);

        btnAdmin.setOnClickListener(v -> selectRole("Admin"));
        btnMember.setOnClickListener(v -> selectRole("Member"));

        btnRegister.setOnClickListener(v -> registerUser());

        tvLogin.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            finish();
        });
    }

    private void selectRole(String role) {
        selectedRole = role;

        if (role.equals("Admin")) {
            btnAdmin.setBackgroundResource(R.drawable.btn_selected);
            btnMember.setBackgroundResource(R.drawable.btn_unselected);
            btnAdmin.setTextColor(getResources().getColor(android.R.color.white));
            btnMember.setTextColor(getResources().getColor(android.R.color.black));
        } else {
            btnMember.setBackgroundResource(R.drawable.btn_selected);
            btnAdmin.setBackgroundResource(R.drawable.btn_unselected);
            btnMember.setTextColor(getResources().getColor(android.R.color.white));
            btnAdmin.setTextColor(getResources().getColor(android.R.color.black));
        }
    }

    private void registerUser() {
        String name = etName.getText().toString().trim();
        String roll = etRoll.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String dept = etDepartment.getText().toString().trim();
        String pass = etPassword.getText().toString().trim();
        String cpass = etConfirmPassword.getText().toString().trim();

        if (name.isEmpty() || roll.isEmpty() || email.isEmpty() ||
                dept.isEmpty() || pass.isEmpty() || cpass.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!pass.equals(cpass)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this,
                "Registered as " + selectedRole,
                Toast.LENGTH_LONG).show();

        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
    }
}
