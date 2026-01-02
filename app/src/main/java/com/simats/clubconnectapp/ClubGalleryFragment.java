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

public class ClubGalleryFragment extends Fragment {

    private RecyclerView rvGallery;
    private GalleryAdapter adapter;
    private List<GalleryItem> galleryItems;
    private ClubModel club;

    public static ClubGalleryFragment newInstance(ClubModel club) {
        ClubGalleryFragment fragment = new ClubGalleryFragment();
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
            galleryItems = new ArrayList<>(club.getGalleryItems());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_club_gallery, container, false);

        rvGallery = view.findViewById(R.id.rvGallery);
        adapter = new GalleryAdapter(galleryItems);

        rvGallery.setLayoutManager(new LinearLayoutManager(getContext()));
        rvGallery.setAdapter(adapter);

        return view;
    }
}
