package com.simats.clubconnectapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin, btnAdmin, btnMember;
    private TextView tvForgotPassword, tvCreateAccount;

    private String selectedRole = "";
    private static final String LOGIN_URL = "http://10.69.152.211/clubconnect/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnAdmin = findViewById(R.id.btnAdmin);
        btnMember = findViewById(R.id.btnMember);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvCreateAccount = findViewById(R.id.tvCreateAccount);

        // Role selection
        btnAdmin.setOnClickListener(v -> {
            selectedRole = "Admin";
            btnAdmin.setBackgroundResource(R.drawable.btn_selected);
            btnMember.setBackgroundResource(R.drawable.btn_unselected);
        });

        btnMember.setOnClickListener(v -> {
            selectedRole = "Member";
            btnMember.setBackgroundResource(R.drawable.btn_selected);
            btnAdmin.setBackgroundResource(R.drawable.btn_unselected);
        });

        // Login button
        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                return;
            }

            if (selectedRole.isEmpty()) {
                Toast.makeText(this, "Please select Admin or Member", Toast.LENGTH_SHORT).show();
                return;
            }

            new LoginTask(email, password, selectedRole).execute();
        });

        tvForgotPassword.setOnClickListener(v ->
                startActivity(new Intent(LoginActivity.this, ResetPasswordEmailActivity.class))
        );

        tvCreateAccount.setOnClickListener(v ->
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class))
        );
    }

    private class LoginTask extends AsyncTask<Void, Void, JSONObject> {

        private final String email, password, role;

        LoginTask(String email, String password, String role) {
            this.email = email;
            this.password = password;
            this.role = role;
        }

        @Override
        protected JSONObject doInBackground(Void... voids) {
            HttpURLConnection conn = null;
            try {
                URL url = new URL(LOGIN_URL);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);

                JSONObject json = new JSONObject();
                json.put("email", email);
                json.put("password", password);

                OutputStream os = conn.getOutputStream();
                os.write(json.toString().getBytes("UTF-8"));
                os.close();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                return new JSONObject(response.toString());

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                if (conn != null) conn.disconnect();
            }
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            if (result == null) {
                Toast.makeText(LoginActivity.this, "Unable to connect to server", Toast.LENGTH_LONG).show();
                return;
            }

            try {
                if ("success".equalsIgnoreCase(result.getString("status"))) {
                    JSONObject user = result.getJSONObject("user");
                    String serverRole = user.getString("role");

                    if (!serverRole.equalsIgnoreCase(role)) {
                        Toast.makeText(LoginActivity.this,
                                "Selected role does not match account", Toast.LENGTH_LONG).show();
                        return;
                    }

                    // ✅ SAVE ROLE IN SHARED PREFERENCES
                    getSharedPreferences("UserPrefs", MODE_PRIVATE)
                            .edit()
                            .putString("role", serverRole.toLowerCase())
                            .apply();

// ✅ NAVIGATION BASED ON ROLE
                    Intent intent;
                    if (serverRole.equalsIgnoreCase("Admin")) {
                        intent = new Intent(LoginActivity.this, AdminDashboardActivity.class);
                    } else {
                        intent = new Intent(LoginActivity.this, MemberDashboardActivity.class);
                    }

                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();


                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(LoginActivity.this,
                            result.getString("message"), Toast.LENGTH_LONG).show();
                }

            } catch (Exception e) {
                Toast.makeText(LoginActivity.this, "Invalid server response", Toast.LENGTH_LONG).show();
            }
        }
    }
}
