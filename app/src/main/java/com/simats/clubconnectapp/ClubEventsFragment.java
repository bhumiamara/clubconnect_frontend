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

public class ClubEventsFragment extends Fragment {

    private RecyclerView rvEvents;
    private EventAdapter adapter;
    private List<Event> eventList;
    private ClubModel club;

    public static ClubEventsFragment newInstance(ClubModel club) {
        ClubEventsFragment fragment = new ClubEventsFragment();
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
            eventList = new ArrayList<>(club.getEvents());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_club_events, container, false);

        rvEvents = view.findViewById(R.id.rvEvents);
        adapter = new EventAdapter(eventList);

        rvEvents.setLayoutManager(new LinearLayoutManager(getContext()));
        rvEvents.setAdapter(adapter);

        return view;
    }
}
