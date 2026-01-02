package com.simats.clubconnectapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MeetingAttendanceAdapter extends RecyclerView.Adapter<MeetingAttendanceAdapter.ViewHolder> {

    private List<MeetingAttendance> meetingAttendanceList;

    public MeetingAttendanceAdapter(List<MeetingAttendance> meetingAttendanceList) {
        this.meetingAttendanceList = meetingAttendanceList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meeting_attendance, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MeetingAttendance item = meetingAttendanceList.get(position);

        holder.tvMeetingName.setText(item.getMeetingName());
        holder.tvMeetingDate.setText(item.getDate());
        holder.tvAttendancePercentage.setText(item.getAttendancePercentage() + "%");
        holder.tvTotalPresent.setText("Total: " + item.getTotalMembers() + "  Present: " + item.getPresentMembers());
        holder.tvAbsent.setText("Absent: " + item.getAbsentMembers());
        holder.progressBarAttendance.setProgress(item.getAttendancePercentage());
    }

    @Override
    public int getItemCount() {
        return meetingAttendanceList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMeetingName, tvMeetingDate, tvAttendancePercentage, tvTotalPresent, tvAbsent;
        ProgressBar progressBarAttendance;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMeetingName = itemView.findViewById(R.id.tvMeetingName);
            tvMeetingDate = itemView.findViewById(R.id.tvMeetingDate);
            tvAttendancePercentage = itemView.findViewById(R.id.tvAttendancePercentage);
            tvTotalPresent = itemView.findViewById(R.id.tvTotalPresent);
            tvAbsent = itemView.findViewById(R.id.tvAbsent);
            progressBarAttendance = itemView.findViewById(R.id.progressBarAttendance);
        }
    }
}
