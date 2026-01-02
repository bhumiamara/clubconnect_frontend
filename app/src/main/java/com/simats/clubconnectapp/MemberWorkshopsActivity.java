package com.simats.clubconnectapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MemberWorkshopsActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    LinearLayout workshopsContainer;

    // Workshop model
    static class Workshop {
        String title;
        String club;
        int durationDays;
        int progress; // 0-100

        Workshop(String title, String club, int durationDays, int progress) {
            this.title = title;
            this.club = club;
            this.durationDays = durationDays;
            this.progress = progress;
        }
    }

    List<Workshop> workshops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_workshops);

        bottomNavigation = findViewById(R.id.bottomNavigation);
        workshopsContainer = findViewById(R.id.workshopsContainer);

        // Sample workshops
        workshops = new ArrayList<>();
        workshops.add(new Workshop("Android Development Workshop", "Computer Club", 5, 70));
        workshops.add(new Workshop("AI and ML Bootcamp", "AI Club", 7, 100));
        workshops.add(new Workshop("Robotics Basics", "Robotics Club", 3, 40));

        displayWorkshops();

        // Bottom navigation
        bottomNavigation.setSelectedItemId(R.id.nav_workshops);
        bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_workshops) return true;

            if (id == R.id.nav_home) startActivity(new Intent(this, MemberDashboardActivity.class));
            else if (id == R.id.nav_events) startActivity(new Intent(this, MemberEventsActivity.class));
            else if (id == R.id.nav_volunteer) startActivity(new Intent(this, VolunteermemberActivity.class));
            else if (id == R.id.nav_profile) startActivity(new Intent(this, MemberProfileActivity.class));

            finish();
            return true;
        });
    }

    // ---------------- DISPLAY WORKSHOPS ----------------
    private void displayWorkshops() {
        workshopsContainer.removeAllViews();

        for (Workshop w : workshops) {
            View workshopView = LayoutInflater.from(this).inflate(R.layout.item_workshops, workshopsContainer, false);

            // Correctly reference the IDs from item_workshops.xml
            TextView tvTitle = workshopView.findViewById(R.id.tvWorkshopTitle);
            TextView tvClub = workshopView.findViewById(R.id.tvWorkshopClub);
            ProgressBar progressBar = workshopView.findViewById(R.id.progressWorkshop);
            TextView tvProgress = workshopView.findViewById(R.id.tvProgress);
            Button btnCertificate = workshopView.findViewById(R.id.btnCertificate);

            tvTitle.setText(w.title);
            tvClub.setText(w.club + " • " + w.durationDays + " Days");
            progressBar.setProgress(w.progress);
            tvProgress.setText("Progress: " + w.progress + "%");

            if (w.progress >= 100) {
                btnCertificate.setEnabled(true);
                btnCertificate.setText("View Certificate");
                btnCertificate.setOnClickListener(v -> {
                    Intent intent = new Intent(this, CertificateActivity.class);
                    // This should be the actual logged-in user's name
                    intent.putExtra("memberName", "Bhumika");
                    intent.putExtra("workshopName", w.title);
                    startActivity(intent);
                });
            } else {
                btnCertificate.setEnabled(false);
                btnCertificate.setText("Certificate Locked");
                btnCertificate.setOnClickListener(v ->
                        Toast.makeText(this, "Complete workshop to unlock certificate", Toast.LENGTH_SHORT).show());
            }

            workshopsContainer.addView(workshopView);
        }
    }
}
