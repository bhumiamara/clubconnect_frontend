package com.simats.clubconnectapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ClubsActivity extends AppCompatActivity {

    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_clubs);

        tvTitle = findViewById(R.id.tvTitle);

        String category = getIntent().getStringExtra("CATEGORY_NAME");

        if (category != null) {
            tvTitle.setText(category + " Clubs");
        }
    }
}
