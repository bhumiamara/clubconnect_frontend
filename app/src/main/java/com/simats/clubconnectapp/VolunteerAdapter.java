package com.simats.clubconnectapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VolunteerAdapter extends RecyclerView.Adapter<VolunteerAdapter.ViewHolder> {

    private Context context;
    private List<VolunteerRole> roles;

    public VolunteerAdapter(Context context, List<VolunteerRole> roles) {
        this.context = context;
        this.roles = roles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_volunteer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        VolunteerRole role = roles.get(position);

        holder.tvRole.setText(role.getRole());
        holder.tvClub.setText(role.getClub());
        holder.tvDuration.setText(role.getDuration());

        holder.btnViewApplications.setText(
                "View " + role.getApplicants() + " Applications"
        );

        // ✅ OPEN VIEW APPLICATIONS LIST (ROLE BASED)
        holder.btnViewApplications.setOnClickListener(v -> {

            Intent intent = new Intent(context, ViewApplicationActivity.class);

            // 🔹 PASS ONLY ROLE NAME
            intent.putExtra("role", role.getRole());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return roles.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvRole, tvClub, tvDuration;
        Button btnViewApplications;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRole = itemView.findViewById(R.id.tvRole);
            tvClub = itemView.findViewById(R.id.tvClub);
            tvDuration = itemView.findViewById(R.id.tvDuration);
            btnViewApplications = itemView.findViewById(R.id.btnViewApplications);
        }
    }
}
