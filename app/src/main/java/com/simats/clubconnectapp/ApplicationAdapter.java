package com.simats.clubconnectapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ApplicationAdapter extends RecyclerView.Adapter<ApplicationAdapter.ViewHolder> {

    private final ArrayList<VolunteerApplicant> applicants;

    public ApplicationAdapter(ArrayList<VolunteerApplicant> applicants) {
        this.applicants = applicants;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_application, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        VolunteerApplicant applicant = applicants.get(position);

        holder.tvName.setText(applicant.getName());
        holder.tvDept.setText(applicant.getDept());
        holder.tvRegNo.setText(applicant.getRegNo());
        holder.tvExperience.setText(applicant.getExperience());
        holder.tvDate.setText(applicant.getDate());

        // Approve button
        holder.btnApprove.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), applicant.getName() + " Approved", Toast.LENGTH_SHORT).show();
            // Optionally remove from list after approval
            // removeApplicant(holder.getAdapterPosition());
        });

        // Reject button
        holder.btnReject.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), applicant.getName() + " Rejected", Toast.LENGTH_SHORT).show();
            removeApplicant(holder.getAdapterPosition());
        });
    }

    private void removeApplicant(int position) {
        if (position >= 0 && position < applicants.size()) {
            applicants.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, applicants.size());
        }
    }

    @Override
    public int getItemCount() {
        return applicants.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvDept, tvRegNo, tvExperience, tvDate;
        Button btnApprove, btnReject;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDept = itemView.findViewById(R.id.tvDept);
            tvRegNo = itemView.findViewById(R.id.tvRegNo);
            tvExperience = itemView.findViewById(R.id.tvExperience);
            tvDate = itemView.findViewById(R.id.tvDate);
            btnApprove = itemView.findViewById(R.id.btnApprove);
            btnReject = itemView.findViewById(R.id.btnReject);
        }
    }
}
