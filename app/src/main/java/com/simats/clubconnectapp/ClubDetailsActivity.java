package com.simats.clubconnectapp;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ClubDetailsActivity extends AppCompatActivity {

    public static ClubDetailsActivity instance;

    private ImageView ivBack, ivClubIcon;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ViewPagerAdapter adapter;
    private Button btnJoinClub;
    private TextView tvClubName, tvClubDescription, tvMemberCount, tvMentor;
    private ClubModel club;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_details);

        instance = this;

        // Get club from ClubData
        String clubName = getIntent().getStringExtra("club_name");
        club = ClubData.getClub(clubName);

        // 🚨 CRITICAL: Check for null club object
        if (club == null) {
            Toast.makeText(this, "Club not found!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        ivBack = findViewById(R.id.ivBack);
        ivClubIcon = findViewById(R.id.ivClubIcon);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        btnJoinClub = findViewById(R.id.btnJoinClub);
        tvClubName = findViewById(R.id.tvClubName);
        tvClubDescription = findViewById(R.id.tvClubDescription);
        tvMemberCount = findViewById(R.id.tvMemberCount);
        tvMentor = findViewById(R.id.tvMentor);

        ivBack.setOnClickListener(v -> onBackPressed());

        // Set Club Info
        ivClubIcon.setImageResource(club.getIconResId());
        tvClubName.setText(club.getName());
        tvClubDescription.setText(club.getShortDescription());
        tvMemberCount.setText(club.getMemberCount() + " Members");
        tvMentor.setText("Mentor: " + club.getMentor());

        adapter = new ViewPagerAdapter(this, club);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Overview");
                    break;
                case 1:
                    tab.setText("Members");
                    break;
                case 2:
                    tab.setText("Chat");
                    break;
                case 3:
                    tab.setText("Events");
                    break;
                case 4:
                    tab.setText("Attendance");
                    break;
                case 5:
                    tab.setText("Projects");
                    break;
                case 6:
                    tab.setText("Gallery");
                    break;
                case 7:
                    tab.setText("Announcements");
                    break;
            }
        }).attach();

        // Handle new member from Intent
        if (getIntent().hasExtra("new_member_name")) {
            String name = getIntent().getStringExtra("new_member_name");
            String regNo = getIntent().getStringExtra("new_member_regNo");
            addMember(name, regNo);
            viewPager.setCurrentItem(1); // Switch to Members tab
        }

        // Join club button
        btnJoinClub.setOnClickListener(v -> showJoinDialog(club.getName()));
    }

    public void addMember(String name, String rollNo) {
        club.getMembers().add(new Member(name, rollNo, "Member"));
        tvMemberCount.setText(club.getMemberCount() + " Members");

        // Update Members tab
        ClubMembersFragment membersFragment = (ClubMembersFragment) adapter.getFragment(1);
        if (membersFragment != null) {
            membersFragment.updateMembers(club.getMembers());
        }

        // Update Attendance tab
        ClubAttendanceFragment attendanceFragment = (ClubAttendanceFragment) adapter.getFragment(4);
        if (attendanceFragment != null) {
            attendanceFragment.updateMemberAttendance();
        }
    }

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

            addMember(name, regNo);
            viewPager.setCurrentItem(1); // Switch to Members tab

            Toast.makeText(this, name + " joined " + clubName, Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}
