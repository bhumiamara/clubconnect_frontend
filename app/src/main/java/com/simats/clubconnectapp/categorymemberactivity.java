package com.simats.clubconnectapp;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class categorymemberactivity extends AppCompatActivity {

    private RecyclerView recyclerCategories;
    private TextView tvBack;

    // ✅ USE MEMBER ADAPTER
    private categorymemberadapter categoryAdapter;
    private List<CategoryModel> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 🔐 MEMBER LAYOUT
        setContentView(R.layout.activity_category_member);

        recyclerCategories = findViewById(R.id.recyclerCategories);
        tvBack = findViewById(R.id.tvBack);

        // Back button
        tvBack.setOnClickListener(v -> finish());

        // Category list
        categoryList = new ArrayList<>();
        categoryList.add(new CategoryModel("Academic", "8 clubs", R.drawable.ic_academic, Color.parseColor("#2196F3")));
        categoryList.add(new CategoryModel("Arts & Culture", "7 clubs", R.drawable.ic_brush, Color.parseColor("#E91E63")));
        categoryList.add(new CategoryModel("Sports & Fitness", "10 clubs", R.drawable.ic_ball, Color.parseColor("#4CAF50")));
        categoryList.add(new CategoryModel("Community Service", "6 clubs", R.drawable.ic_person, Color.parseColor("#FF5722")));
        categoryList.add(new CategoryModel("Hobby Clubs", "9 clubs", R.drawable.ic_hobby, Color.parseColor("#FFC107")));

        // ✅ MEMBER ADAPTER HERE
        categoryAdapter = new categorymemberadapter(categoryList);
        recyclerCategories.setLayoutManager(new LinearLayoutManager(this));
        recyclerCategories.setAdapter(categoryAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
