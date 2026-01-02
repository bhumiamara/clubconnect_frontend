package com.simats.clubconnectapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MemberProfileActivity extends AppCompatActivity {

    private Button btnLogout;
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_profile);

        btnLogout = findViewById(R.id.btnLogout);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        bottomNavigation.setSelectedItemId(R.id.nav_profile);

        btnLogout.setOnClickListener(v -> {
            // Handle logout logic here
            Intent intent = new Intent(MemberProfileActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_profile) {
                return true;
            }

            if (id == R.id.nav_home) {
                startActivity(new Intent(this, MemberDashboardActivity.class));
            } else if (id == R.id.nav_events) {
                startActivity(new Intent(this, MemberEventsActivity.class));
            } else if (id == R.id.nav_workshops) {
                startActivity(new Intent(this, MemberWorkshopsActivity.class));
            } else if (id == R.id.nav_volunteer) {
                startActivity(new Intent(this, VolunteermemberActivity.class));
            }
            finish();
            return true;
        });
    }
}
