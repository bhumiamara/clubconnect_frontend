package com.simats.clubconnectapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<CategoryModel> categoryList;
    private Context context;

    public CategoryAdapter(List<CategoryModel> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryModel category = categoryList.get(position);

        holder.tvTitle.setText(category.getTitle());
        holder.tvCount.setText(category.getCount());
        holder.icon.setImageResource(category.getIcon());
        holder.container.setBackgroundColor(category.getBgColor());

        // 🔥 CLICK HANDLING
        holder.container.setOnClickListener(v -> {
            String title = category.getTitle();
            if ("Academic".equals(title)) {
                Intent intent = new Intent(context, AcademicClubsActivity.class);
                context.startActivity(intent);
            } else if ("Arts & Culture".equals(title)) {
                Intent intent = new Intent(context, ArtsActivity.class);
                context.startActivity(intent);
            } else if ("Sports & Fitness".equals(title)) {
                Intent intent = new Intent(context, SportsActivity.class);
                context.startActivity(intent);
            } else if ("Community Service".equals(title)) {
                Intent intent = new Intent(context, CommunityActivity.class);
                context.startActivity(intent);
            } else if ("Hobby Clubs".equals(title)) {
                Intent intent = new Intent(context, HobbyClubsActivity.class);
                context.startActivity(intent);
            } else {
                Toast.makeText(context, "This category doesn\'t have a dedicated page yet.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvCount;
        ImageView icon;
        LinearLayout container;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvCategoryTitle);
            tvCount = itemView.findViewById(R.id.tvCategoryCount);
            icon = itemView.findViewById(R.id.ivCategoryIcon);
            container = itemView.findViewById(R.id.categoryContainer);
        }
    }
}
