package com.simats.clubconnectapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdminDashboardActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ImageView btnMenu;
    private LinearLayout btnCategories, btnWorkshops, btnEvents, btnCollaborate;
    private Button btnRegisterAI, btnRegisterDance;
    private Button btnJoinCoding, btnJoinRobotics, btnJoinPhotography;
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        // 🔗 View binding
        drawerLayout = findViewById(R.id.drawerLayout);
        btnMenu = findViewById(R.id.btnMenu);
        btnCategories = findViewById(R.id.btnCategories);
        btnWorkshops = findViewById(R.id.btnWorkshops);
        btnEvents = findViewById(R.id.btnEvents);
        btnCollaborate = findViewById(R.id.btnCollaborate);

        btnRegisterAI = findViewById(R.id.btnRegisterAI);
        btnRegisterDance = findViewById(R.id.btnRegisterDance);

        btnJoinCoding = findViewById(R.id.btnJoinCoding);
        btnJoinRobotics = findViewById(R.id.btnJoinRobotics);
        btnJoinPhotography = findViewById(R.id.btnJoinPhotography);

        bottomNavigation = findViewById(R.id.bottomNavigation);

        // ☰ Drawer toggle
        btnMenu.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        // 📂 Categories
        btnCategories.setOnClickListener(v ->
                startActivity(new Intent(this, CategoriesActivity.class))
        );

        // 🧑‍🏫 Workshops
        btnWorkshops.setOnClickListener(v ->
                startActivity(new Intent(this, WorkshopsActivity.class))
        );

        // 📅 Events
        btnEvents.setOnClickListener(v ->
                startActivity(new Intent(this, EventCalendarActivity.class))
        );

        // 🤝 Collaboration
        btnCollaborate.setOnClickListener(v ->
                startActivity(new Intent(this, CollaborationActivity.class))
        );

        // 🎓 Register Workshops
        btnRegisterAI.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterWorkshopActivity.class);
            intent.putExtra("workshop_name", "AI Workshop");
            startActivity(intent);
        });

        btnRegisterDance.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterWorkshopActivity.class);
            intent.putExtra("workshop_name", "Cultural Fest");
            startActivity(intent);
        });

        // ⭐ JOIN CLUB → OPEN JOIN DIALOG ONLY
        btnJoinCoding.setOnClickListener(v ->
                showJoinDialog("Coding Club")
        );

        btnJoinRobotics.setOnClickListener(v ->
                showJoinDialog("Robotics Club")
        );

        btnJoinPhotography.setOnClickListener(v ->
                showJoinDialog("Photography Club")
        );

        // 🔽 Bottom navigation
        bottomNavigation.setOnItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.nav_all_clubs) {
                showToast("All Clubs");
                return true;

            } else if (id == R.id.nav_collaboration) {
                startActivity(new Intent(this, CollaborationActivity.class));
                return true;

            } else if (id == R.id.nav_volunteer) {
                startActivity(new Intent(this, VolunteerAdminActivity.class));
                return true;


            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
            }


            return false;
        });

        // 🔙 Back press handling
        getOnBackPressedDispatcher().addCallback(this,
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                            drawerLayout.closeDrawer(GravityCompat.START);
                        } else {
                            finish();
                        }
                    }
                });
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

            // TODO: Save member (Firebase / Room / List)
            Toast.makeText(
                    this,
                    name + " joined " + clubName,
                    Toast.LENGTH_SHORT
            ).show();

            dialog.dismiss();
        });

        dialog.show();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
