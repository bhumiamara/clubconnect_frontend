package com.simats.clubconnectapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MemberVolunteerAdapter
        extends RecyclerView.Adapter<MemberVolunteerAdapter.ViewHolder> {

    ArrayList<VolunteerModel> list;

    public MemberVolunteerAdapter(ArrayList<VolunteerModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.volunteer_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        VolunteerModel model = list.get(position);

        holder.txtTitle.setText(model.getTitle());
        holder.txtDetails.setText(model.getDetails());
        holder.txtRole.setText("Role: " + model.getRole());
        holder.txtDeadline.setText(model.getDeadline());
        holder.progressBar.setProgress(model.getProgress());
        holder.txtHours.setText("Progress: " + model.getProgress() + "%");

        holder.btnComplete.setOnClickListener(v ->
                Toast.makeText(v.getContext(),
                        "Marked as Completed!",
                        Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtDetails, txtRole, txtDeadline, txtHours;
        ProgressBar progressBar;
        Button btnComplete;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDetails = itemView.findViewById(R.id.txtDetails);
            txtRole = itemView.findViewById(R.id.txtRole);
            txtDeadline = itemView.findViewById(R.id.txtDeadline);
            txtHours = itemView.findViewById(R.id.txtHours);
            progressBar = itemView.findViewById(R.id.progressBar);
            btnComplete = itemView.findViewById(R.id.btnComplete);
        }
    }
}
