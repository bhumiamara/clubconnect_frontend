package com.simats.clubconnectapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MemberHobbyClubsActivity extends AppCompatActivity {

    TextView tvBack;
    Button btnViewPhotography, btnJoinPhotography;
    Button btnViewGaming, btnJoinGaming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_hobby_clubs);

        tvBack = findViewById(R.id.tvBack);

        btnViewPhotography = findViewById(R.id.btnViewPhotography);
        btnJoinPhotography = findViewById(R.id.btnJoinPhotography);

        btnViewGaming = findViewById(R.id.btnViewGaming);
        btnJoinGaming = findViewById(R.id.btnJoinGaming);

        tvBack.setOnClickListener(v -> finish());

        // ================= VIEW CLUB DETAILS =================
        btnViewPhotography.setOnClickListener(v -> openClubDetails("Photography Club"));
        btnViewGaming.setOnClickListener(v -> openClubDetails("Gaming Club"));

        // ================= JOIN → CONTACT PRESIDENT =================
        btnJoinPhotography.setOnClickListener(v ->
                showContactPresidentDialog("Photography Club")
        );

        btnJoinGaming.setOnClickListener(v ->
                showContactPresidentDialog("Gaming Club")
        );
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

        if ("Photography Club".equals(clubName)) {
            tvPresidentName.setText("Rahul Verma");
            tvPresidentEmail.setText("photography@college.edu");
            tvPresidentPhone.setText("+91 90000 33333");
        } else {
            tvPresidentName.setText("Sneha Patel");
            tvPresidentEmail.setText("gaming@college.edu");
            tvPresidentPhone.setText("+91 90000 44444");
        }

        ivClose.setOnClickListener(v -> dialog.dismiss());
        btnGotIt.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
