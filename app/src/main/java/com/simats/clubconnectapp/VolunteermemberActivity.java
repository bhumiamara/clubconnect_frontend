package com.simats.clubconnectapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VolunteermemberActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    ProgressBar progressBar;
    TextView txtHours;
    TextView chipStatus; // Changed from Chip to TextView
    Button btnComplete;

    int completedHours = 6;
    int totalHours = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_member);

        bottomNavigation = findViewById(R.id.bottomNavigation);
        progressBar = findViewById(R.id.progressBar);
        txtHours = findViewById(R.id.txtHours);
        chipStatus = findViewById(R.id.chipStatus);
        btnComplete = findViewById(R.id.btnComplete);

        bottomNavigation.setSelectedItemId(R.id.nav_volunteer);

        updateProgress();

        bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_volunteer) {
                // Already on this screen, do nothing
                return true;
            }

            if (id == R.id.nav_home) {
                startActivity(new Intent(this, MemberDashboardActivity.class));
            } else if (id == R.id.nav_events) {
                startActivity(new Intent(this, MemberEventsActivity.class));
            } else if (id == R.id.nav_workshops) {
                startActivity(new Intent(this, MemberWorkshopsActivity.class));
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(this, MemberProfileActivity.class));
            }
            finish();
            return true;
        });

        btnComplete.setOnClickListener(v -> {
            completedHours = totalHours;
            updateProgress();
            chipStatus.setText("Completed");
            chipStatus.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_chip_round_green)); // Assuming you have a green version
            Toast.makeText(this, "Volunteer Completed! Certificate unlocked 🎉", Toast.LENGTH_LONG).show();
        });
    }

    private void updateProgress() {
        int percent = (completedHours * 100) / totalHours;
        progressBar.setProgress(percent);
        txtHours.setText("Hours Completed: " + completedHours + " / " + totalHours);
    }
}
