package com.simats.clubconnectapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WorkshopAdapter extends RecyclerView.Adapter<WorkshopAdapter.ViewHolder> {

    private final List<Workshop> workshopList;

    public WorkshopAdapter(List<Workshop> workshopList) {
        this.workshopList = workshopList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_workshop, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Workshop w = workshopList.get(position);

        holder.title.setText(w.title);
        holder.club.setText(w.club);
        holder.date.setText(w.date);
        holder.location.setText(w.location);
        holder.slots.setText(w.slots);

        // 🔥 REGISTER BUTTON CLICK
        holder.register.setOnClickListener(v -> {
            Intent intent = new Intent(
                    v.getContext(),
                    RegisterWorkshopActivity.class
            );
            intent.putExtra("workshop_name", w.title);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return workshopList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, club, date, location, slots;
        Button register;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.txtTitle);
            club = itemView.findViewById(R.id.txtClub);
            date = itemView.findViewById(R.id.txtDate);
            location = itemView.findViewById(R.id.txtLocation);
            slots = itemView.findViewById(R.id.txtSlots);
            register = itemView.findViewById(R.id.btnRegister);
        }
    }
}
