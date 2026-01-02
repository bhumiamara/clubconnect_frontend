package com.simats.clubconnectapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MemberAttendanceAdapter extends RecyclerView.Adapter<MemberAttendanceAdapter.ViewHolder> {

    private List<MemberAttendance> memberAttendanceList;

    public MemberAttendanceAdapter(List<MemberAttendance> memberAttendanceList) {
        this.memberAttendanceList = memberAttendanceList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member_attendance, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MemberAttendance item = memberAttendanceList.get(position);

        holder.tvMemberName.setText(item.getMemberName());
        holder.tvRollNo.setText(item.getRollNo());
        holder.tvMeetingsAttended.setText(String.valueOf(item.getMeetingsAttended()));
    }

    @Override
    public int getItemCount() {
        return memberAttendanceList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMemberName, tvRollNo, tvMeetingsAttended;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMemberName = itemView.findViewById(R.id.tvMemberName);
            tvRollNo = itemView.findViewById(R.id.tvRollNo);
            tvMeetingsAttended = itemView.findViewById(R.id.tvMeetingsAttended);
        }
    }
}
