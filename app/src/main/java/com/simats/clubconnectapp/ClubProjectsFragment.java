package com.simats.clubconnectapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ClubProjectsFragment extends Fragment {

    private RecyclerView rvProjects;
    private ProjectAdapter adapter;
    private List<Project> projectList;
    private ClubModel club;

    public static ClubProjectsFragment newInstance(ClubModel club) {
        ClubProjectsFragment fragment = new ClubProjectsFragment();
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
            projectList = new ArrayList<>(club.getProjects());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_club_projects, container, false);

        rvProjects = view.findViewById(R.id.rvProjects);
        adapter = new ProjectAdapter(projectList);

        rvProjects.setLayoutManager(new LinearLayoutManager(getContext()));
        rvProjects.setAdapter(adapter);

        return view;
    }
}
