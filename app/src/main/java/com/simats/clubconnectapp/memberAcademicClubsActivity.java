package com.simats.clubconnectapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class memberAcademicClubsActivity extends AppCompatActivity {

    private TextView tvBack;
    private Button btnViewCoding, btnJoinCoding, btnViewRobotics, btnJoinRobotics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_academic_clubs);

        // -------- INIT --------
        tvBack = findViewById(R.id.tvBack);
        btnViewCoding = findViewById(R.id.btnViewCoding);
        btnJoinCoding = findViewById(R.id.btnJoinCoding);
        btnViewRobotics = findViewById(R.id.btnViewRobotics);
        btnJoinRobotics = findViewById(R.id.btnJoinRobotics);

        // -------- BACK BUTTON --------
        tvBack.setOnClickListener(v -> finish());

        // -------- VIEW CLUB DETAILS --------
        btnViewCoding.setOnClickListener(v -> openClubDetails("Coding Club"));
        btnViewRobotics.setOnClickListener(v -> openClubDetails("Robotics Club"));

        // -------- JOIN CLUB (MEMBER) --------
        btnJoinCoding.setOnClickListener(v -> showContactPresidentDialog("Coding Club"));
        btnJoinRobotics.setOnClickListener(v -> showContactPresidentDialog("Robotics Club"));
    }

    // ================= OPEN CLUB DETAILS =================
    private void openClubDetails(String clubName) {
        Intent intent = new Intent(this, ClubDetailsActivity.class);
        intent.putExtra("club_name", clubName);
        startActivity(intent);
    }

    // ================= CONTACT PRESIDENT DIALOG (MEMBER) =================
    private void showContactPresidentDialog(String clubName) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_contact_president);
        dialog.setCancelable(true);

        TextView tvDialogTitle = dialog.findViewById(R.id.tvDialogTitle);
        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView tvPresidentName = dialog.findViewById(R.id.tvPresidentName);
        TextView tvPresidentEmail = dialog.findViewById(R.id.tvPresidentEmail);
        TextView tvPresidentPhone = dialog.findViewById(R.id.tvPresidentPhone);
        Button btnGotIt = dialog.findViewById(R.id.btnGotIt);

        tvDialogTitle.setText("Join " + clubName);

        // This should be replaced with dynamic data from your ClubModel
        if ("Coding Club".equals(clubName)) {
            tvPresidentName.setText("Rahul Kumar");
            tvPresidentEmail.setText("president@coding-club.club");
            tvPresidentPhone.setText("+91 98765 43210");
        } else {
            tvPresidentName.setText("Amit Patel");
            tvPresidentEmail.setText("president@robotics-club.club");
            tvPresidentPhone.setText("+91 91234 56789");
        }

        ivClose.setOnClickListener(v -> dialog.dismiss());
        btnGotIt.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}
