package com.simats.clubconnectapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterWorkshopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_workshop);

        // Views
        ImageView btnBack = findViewById(R.id.btnBack);
        TextView tvWorkshopTitle = findViewById(R.id.tvWorkshopTitle);
        EditText etName = findViewById(R.id.etName);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etRoll = findViewById(R.id.etRoll);
        EditText etYear = findViewById(R.id.etYear);
        EditText etDepartment = findViewById(R.id.etDepartment);
        EditText etExpectation = findViewById(R.id.etExpectation);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        // Back button functionality
        btnBack.setOnClickListener(v -> finish());

        // Receive workshop name
        String workshopName = getIntent().getStringExtra("workshop_name");
        if (workshopName != null) {
            tvWorkshopTitle.setText("Register for " + workshopName);
        }

        // Submit button
        btnSubmit.setOnClickListener(v -> {
            // Basic validation
            if (etName.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show();
                return;
            }
            if (etEmail.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Enter your email", Toast.LENGTH_SHORT).show();
                return;
            }

            // You can add more validation here (phone, roll, etc.) if needed

            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
            finish(); // Return to previous screen
        });
    }
}
