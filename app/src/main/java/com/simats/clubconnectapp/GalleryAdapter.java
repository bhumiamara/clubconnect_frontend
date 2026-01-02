package com.simats.clubconnectapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private List<GalleryItem> galleryItems;

    public GalleryAdapter(List<GalleryItem> galleryItems) {
        this.galleryItems = galleryItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GalleryItem item = galleryItems.get(position);
        holder.ivGalleryImage.setImageResource(item.getImageResId());
        holder.tvImageTitle.setText(item.getTitle());
        holder.tvImageDate.setText(item.getDate());
        holder.tvImageDescription.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return galleryItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGalleryImage;
        TextView tvImageTitle, tvImageDate, tvImageDescription;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGalleryImage = itemView.findViewById(R.id.ivGalleryImage);
            tvImageTitle = itemView.findViewById(R.id.tvImageTitle);
            tvImageDate = itemView.findViewById(R.id.tvImageDate);
            tvImageDescription = itemView.findViewById(R.id.tvImageDescription);
        }
    }
}
