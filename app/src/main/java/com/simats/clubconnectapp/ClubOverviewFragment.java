package com.simats.clubconnectapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ClubOverviewFragment extends Fragment {

    private ClubModel club;

    public static ClubOverviewFragment newInstance(ClubModel club) {
        ClubOverviewFragment fragment = new ClubOverviewFragment();
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
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_club_overview, container, false);
        TextView tvAboutTitle = view.findViewById(R.id.tvAboutTitle);
        TextView tvAbout = view.findViewById(R.id.tvAbout);

        tvAboutTitle.setText("About " + club.getName());
        tvAbout.setText(club.getDescription());
        return view;
    }
}
