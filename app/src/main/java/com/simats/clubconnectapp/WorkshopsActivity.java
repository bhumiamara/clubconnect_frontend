package com.simats.clubconnectapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WorkshopsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshops);

        // 🔙 UI Back Button
        TextView btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        // ➕ Create Workshop Button
        Button btnCreateWorkshop = findViewById(R.id.btnCreateWorkshop);
        btnCreateWorkshop.setOnClickListener(v -> {
            Intent intent = new Intent(
                    WorkshopsActivity.this,
                    CreateWorkshopActivity.class
            );
            startActivity(intent);
        });

        // 📋 RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Workshop> list = new ArrayList<>();

        list.add(new Workshop(
                "AI Workshop",
                "AI Club",
                "Dec 5, 2025 • 2:00 PM",
                "Room 101",
                "45/50 registered"
        ));

        list.add(new Workshop(
                "Web Development Bootcamp",
                "Coding Club",
                "Dec 8, 2025 • 10:00 AM",
                "Lab 3",
                "28/30 registered"
        ));

        list.add(new Workshop(
                "Photography Basics",
                "Photography Club",
                "Dec 10, 2025 • 3:00 PM",
                "Studio A",
                "15/20 registered"
        ));

        recyclerView.setAdapter(new WorkshopAdapter(list));
    }

    // 🔥 SYSTEM BACK BUTTON
    @Override
    public void onBackPressed() {
        finish();
    }
}
