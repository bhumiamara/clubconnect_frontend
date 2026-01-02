package com.simats.clubconnectapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CollaborationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collaboration);

        TextView tvBack = findViewById(R.id.tvBack);
        LinearLayout btnNewRequest = findViewById(R.id.btnNewRequest);
        LinearLayout btnRequests = findViewById(R.id.btnRequests);
        LinearLayout btnActive = findViewById(R.id.btnActive);

        // UI back button → go back naturally
        tvBack.setOnClickListener(v -> finish());

        btnNewRequest.setOnClickListener(v -> {
            Intent intent = new Intent(
                    CollaborationActivity.this,
                    NewRequestActivity.class
            );
            startActivity(intent);
        });

        btnRequests.setOnClickListener(v ->
                Toast.makeText(this, "Requests clicked", Toast.LENGTH_SHORT).show()
        );

        btnActive.setOnClickListener(v ->
                Toast.makeText(this, "Active collaborations clicked", Toast.LENGTH_SHORT).show()
        );
    }

    // ❌ REMOVE onBackPressed override completely
}
