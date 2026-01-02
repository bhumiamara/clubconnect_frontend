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

public class CommunityActivity extends AppCompatActivity {

    private TextView tvBack;
    private Button btnAddNewClub;

    // Club buttons
    private Button btnViewNSS, btnJoinNSS;
    private Button btnViewSocial, btnJoinSocial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_clubs);

        // Header
        tvBack = findViewById(R.id.tvBack);
        btnAddNewClub = findViewById(R.id.btnAddNewClub);

        // NSS Club buttons
        btnViewNSS = findViewById(R.id.btnViewNSS);
        btnJoinNSS = findViewById(R.id.btnJoinNSS);

        // Social Service Club buttons
        btnViewSocial = findViewById(R.id.btnViewSocial);
        btnJoinSocial = findViewById(R.id.btnJoinSocial);

        // Back button
        tvBack.setOnClickListener(v -> finish());

        // Add New Club
        btnAddNewClub.setOnClickListener(v -> {
            Intent intent = new Intent(CommunityActivity.this, AddClubActivity.class);
            startActivity(intent);
        });

        // View club details
        btnViewNSS.setOnClickListener(v -> openClubDetails("NSS Club"));
        btnViewSocial.setOnClickListener(v -> openClubDetails("Social Service Club"));

        // Join club
        btnJoinNSS.setOnClickListener(v -> showJoinDialog("NSS Club"));
        btnJoinSocial.setOnClickListener(v -> showJoinDialog("Social Service Club"));
    }

    // ================= OPEN CLUB DETAILS =================
    private void openClubDetails(String clubName) {
        Intent intent = new Intent(CommunityActivity.this, ClubDetailsActivity.class);
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
                etMemberName.setError("Enter name");
                return;
            }

            if (regNo.isEmpty()) {
                etRegNo.setError("Enter registration number");
                return;
            }

            // ====================== Add member to ClubDetailsActivity ======================
            if (ClubDetailsActivity.instance != null) {
                ClubDetailsActivity.instance.addMember(name, regNo);
            } else {
                // ClubDetailsActivity not open, start it with new member
                Intent intent = new Intent(CommunityActivity.this, ClubDetailsActivity.class);
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

    @Override
    public void onBackPressed() {
        finish();
    }
}
