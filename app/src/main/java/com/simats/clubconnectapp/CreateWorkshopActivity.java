package com.simats.clubconnectapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class CreateWorkshopActivity extends AppCompatActivity {

    EditText etTitle, etDescription, etDate, etTime, etVenue, etCapacity;
    Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workshop);

        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.etDescription);
        etDate = findViewById(R.id.etDate);
        etTime = findViewById(R.id.etTime);
        etVenue = findViewById(R.id.etVenue);
        etCapacity = findViewById(R.id.etCapacity);
        btnCreate = findViewById(R.id.btnCreate);

        // 📅 Date Picker
        etDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    CreateWorkshopActivity.this,
                    (view, y, m, d) -> {
                        String selectedDate = String.format(
                                Locale.getDefault(),
                                "%02d-%02d-%04d",
                                d, m + 1, y
                        );
                        etDate.setText(selectedDate);
                    },
                    year, month, day
            );
            datePickerDialog.show();
        });

        // ⏰ Time Picker
        etTime.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();

            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    CreateWorkshopActivity.this,
                    (view, h, m) -> {
                        String selectedTime = String.format(
                                Locale.getDefault(),
                                "%02d:%02d",
                                h, m
                        );
                        etTime.setText(selectedTime);
                    },
                    hour, minute, false
            );
            timePickerDialog.show();
        });

        // ✅ Create Workshop Button
        btnCreate.setOnClickListener(v -> {

            if (etTitle.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Enter workshop title", Toast.LENGTH_SHORT).show();
                return;
            }

            if (etDate.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Select date", Toast.LENGTH_SHORT).show();
                return;
            }

            if (etTime.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Select time", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Workshop Created Successfully", Toast.LENGTH_SHORT).show();

            finish(); // 🔙 Goes back to Workshops page
        });
    }
}
