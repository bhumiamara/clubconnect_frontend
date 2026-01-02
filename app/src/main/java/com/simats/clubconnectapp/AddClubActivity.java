package com.simats.clubconnectapp;



import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class AddClubActivity extends AppCompatActivity {

    private TextInputEditText etClubName, etDescription, etMentorName;
    private Spinner spCategory;
    private Button btnCreateClub, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_club);

        // Initialize views
        etClubName = findViewById(R.id.etClubName);
        etDescription = findViewById(R.id.etDescription);
        etMentorName = findViewById(R.id.etMentorName);
        spCategory = findViewById(R.id.spCategory);
        btnCreateClub = findViewById(R.id.btnCreateClub);
        btnCancel = findViewById(R.id.btnCancel);

        // Spinner data
        String[] categories = {"Academic", "Sports and Fitness", "Arts and Culture", "Community","Hobby","Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                categories
        );
        spCategory.setAdapter(adapter);

        // Create Club button
        btnCreateClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createClub();
            }
        });

        // Cancel button
        btnCancel.setOnClickListener(v -> finish());
    }

    private void createClub() {
        String clubName = etClubName.getText().toString().trim();
        String description = etDescription.getText().toString().trim();
        String mentorName = etMentorName.getText().toString().trim();
        String category = spCategory.getSelectedItem().toString();

        if (clubName.isEmpty()) {
            etClubName.setError("Club name required");
            return;
        }

        if (description.isEmpty()) {
            etDescription.setError("Description required");
            return;
        }

        if (mentorName.isEmpty()) {
            etMentorName.setError("Mentor name required");
            return;
        }

        // Success (replace with DB / API call)
        Toast.makeText(
                this,
                "Club Created:\n" + clubName + " (" + category + ")",
                Toast.LENGTH_LONG
        ).show();

        finish();
    }
}
