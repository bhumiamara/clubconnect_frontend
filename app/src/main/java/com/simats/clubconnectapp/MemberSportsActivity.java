package com.simats.clubconnectapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MemberSportsActivity extends AppCompatActivity {

    private TextView tvBack;
    private Button btnViewFootball, btnJoinFootball, btnViewCricket, btnJoinCricket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_sports);

        // -------- INIT --------
        tvBack = findViewById(R.id.tvBack);

        btnViewFootball = findViewById(R.id.btnViewFootball);
        btnJoinFootball = findViewById(R.id.btnJoinFootball);

        btnViewCricket = findViewById(R.id.btnViewCricket);
        btnJoinCricket = findViewById(R.id.btnJoinCricket);

        // -------- BACK --------
        tvBack.setOnClickListener(v -> finish());

        // -------- VIEW CLUB DETAILS --------
        btnViewFootball.setOnClickListener(v -> openClubDetails("Football Club"));
        btnViewCricket.setOnClickListener(v -> openClubDetails("Cricket Club"));

        // -------- JOIN CLUB (MEMBER → CONTACT INFO ONLY) --------
        btnJoinFootball.setOnClickListener(v -> showContactPresidentDialog("Football Club"));
        btnJoinCricket.setOnClickListener(v -> showContactPresidentDialog("Cricket Club"));
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

        if ("Football Club".equals(clubName)) {
            tvPresidentName.setText("Ravi Kumar");
            tvPresidentEmail.setText("footballclub@college.edu");
            tvPresidentPhone.setText("+91 98888 11111");
        } else {
            tvPresidentName.setText("Manoj Singh");
            tvPresidentEmail.setText("cricketclub@college.edu");
            tvPresidentPhone.setText("+91 98888 22222");
        }

        ivClose.setOnClickListener(v -> dialog.dismiss());
        btnGotIt.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}
