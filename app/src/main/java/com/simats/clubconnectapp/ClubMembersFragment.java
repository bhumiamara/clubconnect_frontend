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

public class ClubMembersFragment extends Fragment {

    private RecyclerView rvMembers;
    private MembersAdapter adapter;
    private List<Member> memberList;
    private ClubModel club;

    public static ClubMembersFragment newInstance(ClubModel club) {
        ClubMembersFragment fragment = new ClubMembersFragment();
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
            memberList = new ArrayList<>(club.getMembers());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_club_members, container, false);

        rvMembers = view.findViewById(R.id.rvMembers);
        adapter = new MembersAdapter(memberList);

        rvMembers.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMembers.setAdapter(adapter);

        return view;
    }

    public void updateMembers(List<Member> members) {
        if (memberList != null && adapter != null) {
            memberList.clear();
            memberList.addAll(members);
            adapter.notifyDataSetChanged();
        }
    }
}
