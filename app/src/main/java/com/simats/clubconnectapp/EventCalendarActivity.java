package com.simats.clubconnectapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EventCalendarActivity extends AppCompatActivity {

    private RecyclerView recyclerEvents;
    private EventAdapter eventAdapter;
    private List<Event> eventList;
    private TextView tvBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_calendar);

        tvBack = findViewById(R.id.tvBack);
        recyclerEvents = findViewById(R.id.recyclerEvents);

        // Back button click (UI back)
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAdminDashboard();
            }
        });

        // Sample events
        eventList = new ArrayList<>();
        eventList.add(new Event("AI Workshop", "jan 5", "2:00 PM", "Lab 301", "An exciting workshop on AI."));
        eventList.add(new Event("Hackathon", "jan1 8", "9:00 AM", "Main Auditorium", "A 24-hour coding competition."));
        eventList.add(new Event("Cultural Fest", "jan 30", "5:00 PM", "College Grounds", "A celebration of culture and diversity."));

        // RecyclerView setup
        eventAdapter = new EventAdapter(eventList);
        recyclerEvents.setLayoutManager(new LinearLayoutManager(this));
        recyclerEvents.setAdapter(eventAdapter);
    }

    // Handle mobile back button also
    @Override
    public void onBackPressed() {
        goToAdminDashboard();
    }

    // Common method
    private void goToAdminDashboard() {
        Intent intent = new Intent(EventCalendarActivity.this, AdminDashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
