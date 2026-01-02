package com.simats.clubconnectapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CertificateActivity extends AppCompatActivity {

    private TextView tvMemberName, tvWorkshopName, tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate);

        tvMemberName = findViewById(R.id.tvMemberName);
        tvWorkshopName = findViewById(R.id.tvWorkshopName);
        tvDate = findViewById(R.id.tvDate);

        // Get data from intent
        String memberName = getIntent().getStringExtra("memberName");
        String workshopName = getIntent().getStringExtra("workshopName");

        // Set data
        tvMemberName.setText(memberName);
        tvWorkshopName.setText(workshopName);

        // Set current date
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        tvDate.setText(currentDate);
    }
}
