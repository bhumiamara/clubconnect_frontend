package com.simats.clubconnectapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MemberDashboardActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;
    private LinearLayout btnCategories, btnMyEvents, btnWorkshops;
    private Button btnViewEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_dahsboard);

        bottomNavigation = findViewById(R.id.bottomNavigation);
        btnCategories = findViewById(R.id.btnCategories);
        btnMyEvents = findViewById(R.id.btnMyEvents);
        btnWorkshops = findViewById(R.id.btnWorkshops);
        btnViewEvent = findViewById(R.id.btnViewEvent);

        bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                return true;
            } else if (id == R.id.nav_events) {
                startActivity(new Intent(this, MemberEventsActivity.class));
            } else if (id == R.id.nav_workshops) {
                startActivity(new Intent(this, MemberWorkshopsActivity.class));
            } else if (id == R.id.nav_volunteer) {
                startActivity(new Intent(this, VolunteermemberActivity.class));
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(this, MemberProfileActivity.class));
            }
            return true;
        });

        // ✅ Categories → Member Categories Page
        btnCategories.setOnClickListener(v ->
                startActivity(new Intent(this, categorymemberactivity.class))
        );

        btnMyEvents.setOnClickListener(v ->
                startActivity(new Intent(this, MemberEventsActivity.class))
        );

        btnWorkshops.setOnClickListener(v ->
                startActivity(new Intent(this, MemberWorkshopsActivity.class))
        );

        btnViewEvent.setOnClickListener(v ->
                Toast.makeText(this, "View Event clicked", Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
