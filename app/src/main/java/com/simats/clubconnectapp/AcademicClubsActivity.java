package com.simats.clubconnectapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AcademicClubsActivity extends AppCompatActivity {

    TextView tvBack;
    Button btnAddNewClub, btnViewCoding, btnJoinCoding, btnViewRobotics, btnJoinRobotics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_clubs);

        tvBack = findViewById(R.id.tvBack);
        btnAddNewClub = findViewById(R.id.btnAddNewClub);

        btnViewCoding = findViewById(R.id.btnViewCoding);
        btnJoinCoding = findViewById(R.id.btnJoinCoding);

        btnViewRobotics = findViewById(R.id.btnViewRobotics);
        btnJoinRobotics = findViewById(R.id.btnJoinRobotics);

        tvBack.setOnClickListener(v -> finish());

        // Add new club page
        btnAddNewClub.setOnClickListener(v -> {
            Intent intent = new Intent(AcademicClubsActivity.this, AddClubActivity.class);
            startActivity(intent);
        });

        // ================= VIEW CLUB DETAILS =================
        btnViewCoding.setOnClickListener(v -> openClubDetails("Coding Club"));
        btnViewRobotics.setOnClickListener(v -> openClubDetails("Robotics Club"));

        // ================= JOIN CLUB =================
        btnJoinCoding.setOnClickListener(v -> showJoinDialog("Coding Club"));
        btnJoinRobotics.setOnClickListener(v -> showJoinDialog("Robotics Club"));
    }

    // ================= OPEN CLUB DETAILS =================
    private void openClubDetails(String clubName) {
        Intent intent = new Intent(AcademicClubsActivity.this, ClubDetailsActivity.class);
        intent.putExtra("club_name", clubName);
        startActivity(intent);
    }

    // ================= JOIN CLUB DIALOG =================
    private void showJoinDialog(String clubName) {

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_member);
        dialog.setCancelable(false);

        TextView tvTitle = dialog.findViewById(R.id.tvTitle);
        ImageView btnClose = dialog.findViewById(R.id.btnClose);
        EditText etMemberName = dialog.findViewById(R.id.etMemberName);
        EditText etRegNo = dialog.findViewById(R.id.etRegNo);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);
        Button btnAddMember = dialog.findViewById(R.id.btnAddMember);

        tvTitle.setText("Add Member to " + clubName);

        btnClose.setOnClickListener(v -> dialog.dismiss());
        btnCancel.setOnClickListener(v -> dialog.dismiss());

        btnAddMember.setOnClickListener(v -> {
            String name = etMemberName.getText().toString().trim();
            String regNo = etRegNo.getText().toString().trim();

            if (name.isEmpty()) {
                etMemberName.setError("Member name required");
                return;
            }

            if (regNo.isEmpty()) {
                etRegNo.setError("Registration number required");
                return;
            }

            // ====================== Add member to ClubDetailsActivity ======================
            if (ClubDetailsActivity.instance != null) {
                ClubDetailsActivity.instance.addMember(name, regNo);
            } else {
                // ClubDetailsActivity not open, start it with new member
                Intent intent = new Intent(AcademicClubsActivity.this, ClubDetailsActivity.class);
                intent.putExtra("club_name", clubName);
                intent.putExtra("new_member_name", name);
                intent.putExtra("new_member_regNo", regNo);
                startActivity(intent);
            }

            Toast.makeText(this, name + " joined " + clubName, Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        dialog.show();
    }
}

