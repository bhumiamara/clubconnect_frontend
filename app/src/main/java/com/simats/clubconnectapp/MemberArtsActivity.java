package com.simats.clubconnectapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MemberArtsActivity extends AppCompatActivity {

    private TextView tvBack;
    private Button btnViewMusic, btnJoinMusic, btnViewDance, btnJoinDance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_arts);

        // -------- INIT --------
        tvBack = findViewById(R.id.tvBack);

        btnViewMusic = findViewById(R.id.btnViewMusic);
        btnJoinMusic = findViewById(R.id.btnJoinMusic);

        btnViewDance = findViewById(R.id.btnViewDance);
        btnJoinDance = findViewById(R.id.btnJoinDance);

        // -------- BACK --------
        tvBack.setOnClickListener(v -> finish());

        // -------- VIEW CLUB DETAILS --------
        btnViewMusic.setOnClickListener(v -> openClubDetails("Music Club"));
        btnViewDance.setOnClickListener(v -> openClubDetails("Dance Club"));

        // -------- JOIN CLUB (MEMBER → CONTACT INFO ONLY) --------
        btnJoinMusic.setOnClickListener(v -> showContactPresidentDialog("Music Club"));
        btnJoinDance.setOnClickListener(v -> showContactPresidentDialog("Dance Club"));
    }

    // ================= OPEN CLUB DETAILS =================
    private void openClubDetails(String clubName) {
        Intent intent = new Intent(this, ClubDetailsActivity.class);
        intent.putExtra("club_name", clubName);
        startActivity(intent);
    }

    // ================= CONTACT PRESIDENT DIALOG =================
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

        if ("Music Club".equals(clubName)) {
            tvPresidentName.setText("Sanjay Kumar");
            tvPresidentEmail.setText("musicclub@college.edu");
            tvPresidentPhone.setText("+91 90000 11111");
        } else {
            tvPresidentName.setText("Priya Sharma");
            tvPresidentEmail.setText("danceclub@college.edu");
            tvPresidentPhone.setText("+91 90000 22222");
        }

        ivClose.setOnClickListener(v -> dialog.dismiss());
        btnGotIt.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}
