package com.simats.clubconnectapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ClubAttendanceFragment extends Fragment {

    // Summary Cards
    private TextView tvAverageAttendance, tvTotalMeetings, tvHighestAttendance, tvLowestAttendance;

    // Meeting-wise list
    private RecyclerView rvMeetingAttendance;
    private MeetingAttendanceAdapter meetingAdapter;
    private List<MeetingAttendance> meetingAttendanceList;

    // Member-wise list
    private RecyclerView rvMemberAttendance;
    private MemberAttendanceAdapter memberAdapter;
    private List<MemberAttendance> memberAttendanceList;

    private ClubModel club;

    public static ClubAttendanceFragment newInstance(ClubModel club) {
        ClubAttendanceFragment fragment = new ClubAttendanceFragment();
        Bundle args = new Bundle();
        args.putString("club_name", club.getName());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String clubName = getArguments().getString("club_name");
            club = ClubData.getClub(clubName);
            // Initialize the member attendance list from the main club members list
            memberAttendanceList = new ArrayList<>();
            for (Member member : club.getMembers()) {
                // Dummy attendance data (e.g., attended 3 meetings)
                memberAttendanceList.add(new MemberAttendance(member.getName(), member.getRollNo(), 3));
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_club_attendance, container, false);

        // --- Find Views ---
        tvAverageAttendance = view.findViewById(R.id.tvAverageAttendance);
        tvTotalMeetings = view.findViewById(R.id.tvTotalMeetings);
        tvHighestAttendance = view.findViewById(R.id.tvHighestAttendance);
        tvLowestAttendance = view.findViewById(R.id.tvLowestAttendance);
        rvMeetingAttendance = view.findViewById(R.id.rvMeetingAttendance);
        rvMemberAttendance = view.findViewById(R.id.rvMemberAttendance);

        // --- Setup Data ---
        setupDummyData();

        // --- Setup Adapters and RecyclerViews ---
        // Meeting-wise
        meetingAdapter = new MeetingAttendanceAdapter(meetingAttendanceList);
        rvMeetingAttendance.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMeetingAttendance.setAdapter(meetingAdapter);

        // Member-wise
        memberAdapter = new MemberAttendanceAdapter(memberAttendanceList);
        rvMemberAttendance.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMemberAttendance.setAdapter(memberAdapter);

        // --- Set Summary Data ---
        updateSummaryCards();

        return view;
    }

    // This method can be called from ClubDetailsActivity to update the list
    public void updateMemberAttendance() {
        if (club != null && memberAttendanceList != null && memberAdapter != null) {
            memberAttendanceList.clear();
            for (Member member : club.getMembers()) {
                // Add new members with dummy attendance data
                memberAttendanceList.add(new MemberAttendance(member.getName(), member.getRollNo(), 3));
            }
            memberAdapter.notifyDataSetChanged();
        }
    }

    private void setupDummyData() {
        // Dummy Meeting-wise data
        meetingAttendanceList = new ArrayList<>();
        meetingAttendanceList.add(new MeetingAttendance("Weekly Meeting", "Nov 28, 2025", 45, 38));
        meetingAttendanceList.add(new MeetingAttendance("Project Discussion", "Nov 21, 2025", 45, 42));
        meetingAttendanceList.add(new MeetingAttendance("Workshop - AI Basics", "Nov 14, 2025", 45, 40));
        meetingAttendanceList.add(new MeetingAttendance("Weekly Meeting", "Nov 7, 2025", 45, 35));
        meetingAttendanceList.add(new MeetingAttendance("Halloween Event", "Oct 31, 2025", 45, 44));
    }

    private void updateSummaryCards() {
        if (meetingAttendanceList == null || meetingAttendanceList.isEmpty()) return;

        int totalMeetings = meetingAttendanceList.size();
        int totalPercentage = 0;
        int highest = 0;
        int lowest = 100;

        for (MeetingAttendance meeting : meetingAttendanceList) {
            int percentage = meeting.getAttendancePercentage();
            totalPercentage += percentage;
            if (percentage > highest) {
                highest = percentage;
            }
            if (percentage < lowest) {
                lowest = percentage;
            }
        }

        int average = totalPercentage / totalMeetings;

        tvAverageAttendance.setText(average + "%");
        tvTotalMeetings.setText(String.valueOf(totalMeetings));
        tvHighestAttendance.setText(highest + "%");
        tvLowestAttendance.setText(lowest + "%");
    }
}
