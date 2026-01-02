package com.simats.clubconnectapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class VolunteerAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_admin);

        RecyclerView recyclerView = findViewById(R.id.rvVolunteers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<VolunteerRole> roles = new ArrayList<>();
        roles.add(new VolunteerRole(
                "Social Media Manager",
                "Coding Club",
                "3 months",
                2
        ));
        roles.add(new VolunteerRole(
                "Event Coordinator",
                "Dance Club",
                "6 months",
                2
        ));
        roles.add(new VolunteerRole(
                "Content Writer",
                "Photography Club",
                "4 months",
                2
        ));

        VolunteerAdapter adapter = new VolunteerAdapter(this, roles);
        recyclerView.setAdapter(adapter);
    }
}
