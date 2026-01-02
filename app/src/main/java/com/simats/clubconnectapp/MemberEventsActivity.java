package com.simats.clubconnectapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MemberEventsActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    Button btnAll, btnUpcoming, btnCompleted;
    LinearLayout eventsContainer;
    TextView tvEventSummary, emptyState;

    // Event model class
    static class Event {
        String title;
        String club;
        String dateTime;
        String status; // "Upcoming" or "Completed"

        Event(String title, String club, String dateTime, String status) {
            this.title = title;
            this.club = club;
            this.dateTime = dateTime;
            this.status = status;
        }
    }

    List<Event> allEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_events);

        // ---------------- FIND VIEWS ----------------
        bottomNavigation = findViewById(R.id.bottomNavigation);

        btnAll = findViewById(R.id.btnAll);
        btnUpcoming = findViewById(R.id.btnUpcoming);
        btnCompleted = findViewById(R.id.btnCompleted);

        eventsContainer = findViewById(R.id.eventsContainer);
        tvEventSummary = findViewById(R.id.tvEventSummary);
        emptyState = findViewById(R.id.emptyState);

        // ---------------- EVENTS DATA ----------------
        allEvents = new ArrayList<>();
        allEvents.add(new Event("AI Workshop", "AI Club", "Dec 5, 2:00 PM", "Completed"));
        allEvents.add(new Event("Cultural Fest", "Dance Club", "Dec 10, 5:00 PM", "Completed"));
        allEvents.add(new Event("Hackathon", "Coding Club", "Jan 15, 10:00 AM", "Upcoming"));
        allEvents.add(new Event("Robbo", "Robotics Club", "Jan 20, 11:00 AM", "Upcoming"));
        allEvents.add(new Event("Soccer Competition", "Sports Club", "Dec 2, 3:00 PM", "Completed"));
        allEvents.add(new Event("Acoustic Night", "Music Club", "Jan 18, 7:00 PM", "Upcoming"));
        allEvents.add(new Event("Inter Department Tournament", "Sports Club", "Dec 8, 1:00 PM", "Completed"));
        allEvents.add(new Event("Tree Plantation Drive", "Eco Club", "Jan 25, 9:00 AM", "Upcoming"));
        allEvents.add(new Event("Photography Exhibition", "Photography Club", "Jan 12, 5:00 PM", "Upcoming"));

        // ---------------- DISPLAY ALL EVENTS ----------------
        displayEvents(allEvents, btnAll);

        // ---------------- FILTER BUTTONS ----------------
        btnAll.setOnClickListener(v -> displayEvents(allEvents, btnAll));

        btnUpcoming.setOnClickListener(v -> {
            List<Event> upcoming = new ArrayList<>();
            for (Event e : allEvents) {
                if (e.status.equals("Upcoming")) upcoming.add(e);
            }
            displayEvents(upcoming, btnUpcoming);
        });

        btnCompleted.setOnClickListener(v -> {
            List<Event> completed = new ArrayList<>();
            for (Event e : allEvents) {
                if (e.status.equals("Completed")) completed.add(e);
            }
            displayEvents(completed, btnCompleted);
        });

        // ---------------- BOTTOM NAVIGATION ----------------
        bottomNavigation.setSelectedItemId(R.id.nav_events);
        bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                startActivity(new Intent(this, MemberDashboardActivity.class));
                finish();
                return true;
            } else if (id == R.id.nav_events) {
                return true;
            } else if (id == R.id.nav_workshops) {
                startActivity(new Intent(this, MemberWorkshopsActivity.class));
                finish();
                return true;
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(this, MemberProfileActivity.class));
                finish();
                return true;
            }
            return false;
        });
    }

    // ---------------- DYNAMIC EVENT DISPLAY ----------------
    private void displayEvents(List<Event> events, Button selectedBtn) {
        updateButtonStyles(selectedBtn);
        eventsContainer.removeAllViews();

        if (events.isEmpty()) {
            emptyState.setVisibility(View.VISIBLE);
            tvEventSummary.setVisibility(View.GONE);
            return;
        } else {
            emptyState.setVisibility(View.GONE);
            tvEventSummary.setVisibility(View.VISIBLE);
            tvEventSummary.setText("You have " + events.size() + " events");
        }

        for (Event e : events) {
            View eventView = LayoutInflater.from(this).inflate(R.layout.item_event, eventsContainer, false);

            TextView tvTitle = eventView.findViewById(R.id.tvEventTitle);
            TextView tvEventDetails = eventView.findViewById(R.id.tvEventDetails); // ✅ Correct ID
            TextView tvDescription = eventView.findViewById(R.id.tvEventDescription);
            TextView tvStatus = eventView.findViewById(R.id.tvStatus);
            ImageView imgStatus = eventView.findViewById(R.id.imgEventStatus);
            Button btnView = eventView.findViewById(R.id.btnViewEvent);

            tvTitle.setText(e.title);
            tvEventDetails.setText(e.club + " • " + e.dateTime);
            tvDescription.setText(""); // Optional: set description if available
            tvStatus.setText("Status: " + e.status);

            // Status icon color
            if (e.status.equals("Completed")) {
                imgStatus.setImageResource(android.R.drawable.checkbox_on_background);
                imgStatus.setColorFilter(Color.GREEN);
                tvStatus.setTextColor(Color.parseColor("#4CAF50"));
            } else {
                imgStatus.setImageResource(android.R.drawable.checkbox_off_background);
                imgStatus.setColorFilter(Color.GRAY);
                tvStatus.setTextColor(Color.parseColor("#2196F3"));
            }

            btnView.setOnClickListener(v ->
                    Toast.makeText(this, e.title + " Details", Toast.LENGTH_SHORT).show()
            );

            eventsContainer.addView(eventView);
        }
    }

    private void updateButtonStyles(Button selectedBtn) {
        // Reset all buttons to default style
        btnAll.setBackgroundColor(ContextCompat.getColor(this, R.color.grey));
        btnUpcoming.setBackgroundColor(ContextCompat.getColor(this, R.color.grey));
        btnCompleted.setBackgroundColor(ContextCompat.getColor(this, R.color.grey));

        btnAll.setTextColor(ContextCompat.getColor(this, R.color.black));
        btnUpcoming.setTextColor(ContextCompat.getColor(this, R.color.black));
        btnCompleted.setTextColor(ContextCompat.getColor(this, R.color.black));

        // Set selected button style
        selectedBtn.setBackgroundColor(ContextCompat.getColor(this, R.color.pink));
        selectedBtn.setTextColor(ContextCompat.getColor(this, R.color.white));
    }
}
