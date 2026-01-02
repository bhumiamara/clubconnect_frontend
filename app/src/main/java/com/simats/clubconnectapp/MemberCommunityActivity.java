package com.simats.clubconnectapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MemberCommunityActivity extends AppCompatActivity {

    private TextView tvBack;

    // Club buttons
    private Button btnViewNSS, btnJoinNSS;
    private Button btnViewSocial, btnJoinSocial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_community);

        // Header
        tvBack = findViewById(R.id.tvBack);

        // NSS Club
        btnViewNSS = findViewById(R.id.btnViewNSS);
        btnJoinNSS = findViewById(R.id.btnJoinNSS);

        // Social Service Club
        btnViewSocial = findViewById(R.id.btnViewSocial);
        btnJoinSocial = findViewById(R.id.btnJoinSocial);

        // Back
        tvBack.setOnClickListener(v -> finish());

        // View club details
        btnViewNSS.setOnClickListener(v -> openClubDetails("NSS Club"));
        btnViewSocial.setOnClickListener(v -> openClubDetails("Social Service Club"));

        // Join → Contact President
        btnJoinNSS.setOnClickListener(v -> showContactPresidentDialog("NSS Club"));
        btnJoinSocial.setOnClickListener(v -> showContactPresidentDialog("Social Service Club"));
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

        if ("NSS Club".equals(clubName)) {
            tvPresidentName.setText("Anand Kumar");
            tvPresidentEmail.setText("nss@college.edu");
            tvPresidentPhone.setText("+91 90000 11111");
        } else {
            tvPresidentName.setText("Priya Sharma");
            tvPresidentEmail.setText("socialservice@college.edu");
            tvPresidentPhone.setText("+91 90000 22222");
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
