package com.simats.clubconnectapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class categorymemberadapter extends RecyclerView.Adapter<categorymemberadapter.ViewHolder> {

    private List<CategoryModel> categoryList;
    private Context context;

    public categorymemberadapter(List<CategoryModel> categoryList) {
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

        // ✅ MEMBER CATEGORY NAVIGATION
        holder.container.setOnClickListener(v -> {

            Intent intent = null;

            switch (category.getTitle()) {

                case "Academic":
                    intent = new Intent(context, memberAcademicClubsActivity.class);
                    break;

                case "Arts & Culture":
                    intent = new Intent(context, MemberArtsActivity.class);
                    break;

                case "Sports & Fitness":
                    intent = new Intent(context, MemberSportsActivity.class);
                    break;

                case "Community Service":
                    intent = new Intent(context, MemberCommunityActivity.class);
                    break;

                case "Hobby Clubs":
                    intent = new Intent(context, MemberHobbyClubsActivity.class);
                    break;
            }

            if (intent != null) {
                context.startActivity(intent);
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
