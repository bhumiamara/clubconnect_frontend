package com.simats.clubconnectapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewApplicationActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ApplicationAdapter adapter;
    ArrayList<VolunteerApplicant> applicants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_applications);

        // Back button
        TextView tvBack = findViewById(R.id.tvBack);
        tvBack.setOnClickListener(v -> finish()); // Closes current activity and goes back

        // Role title
        TextView tvRoleTitle = findViewById(R.id.tvRoleTitle);
        String role = getIntent().getStringExtra("role");
        tvRoleTitle.setText("Applications for " + role);

        // RecyclerView setup
        recyclerView = findViewById(R.id.rvApplicants);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load applicants
        applicants = getApplicantsByRole(role);

        // Adapter
        adapter = new ApplicationAdapter(applicants);
        recyclerView.setAdapter(adapter);
    }

    // Sample applicants data
    private ArrayList<VolunteerApplicant> getApplicantsByRole(String role) {
        ArrayList<VolunteerApplicant> list = new ArrayList<>();

        if ("Social Media Manager".equals(role)) {
            list.add(new VolunteerApplicant("Ananya Sharma", "CSE", "CS2021015",
                    "Managed Instagram for college fest", "Dec 20, 2025"));
            list.add(new VolunteerApplicant("Rahul Verma", "IT", "IT2021041",
                    "Designed posters and reels", "Dec 21, 2025"));
        }

        if ("Event Coordinator".equals(role)) {
            list.add(new VolunteerApplicant("Rohan Kumar", "IT", "IT2021032",
                    "Handled inter-college events", "Dec 22, 2025"));
            list.add(new VolunteerApplicant("Sneha Iyer", "MBA", "MBA2021012",
                    "Organized workshops & seminars", "Dec 23, 2025"));
        }

        if ("Content Writer".equals(role)) {
            list.add(new VolunteerApplicant("Sneha Patel", "English", "EL2021048",
                    "Writes blogs & captions", "Dec 24, 2025"));
            list.add(new VolunteerApplicant("Arjun Mehta", "Journalism", "JR2021033",
                    "College magazine editor", "Dec 25, 2025"));
        }

        return list;
    }
}
