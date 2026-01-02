package com.simats.clubconnectapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class DialogContactPresident extends Dialog {

    private TextView tvPresidentName, tvPresidentEmail, tvPresidentPhone;
    private ImageView ivClose;
    private Button btnGotIt;

    private String club, name, email, phone;

    public DialogContactPresident(@NonNull Context context) {
        super(context);
    }

    // ✅ METHOD THAT WAS MISSING BEFORE
    public void setClubData(
            String club,
            String name,
            String email,
            String phone
    ) {
        this.club = club;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_contact_president);

        tvPresidentName = findViewById(R.id.tvPresidentName);
        tvPresidentEmail = findViewById(R.id.tvPresidentEmail);
        tvPresidentPhone = findViewById(R.id.tvPresidentPhone);
        ivClose = findViewById(R.id.ivClose);
        btnGotIt = findViewById(R.id.btnGotIt);

        tvPresidentName.setText(name);
        tvPresidentEmail.setText(email);
        tvPresidentPhone.setText(phone);

        ivClose.setOnClickListener(v -> dismiss());
        btnGotIt.setOnClickListener(v -> dismiss());
    }
}
