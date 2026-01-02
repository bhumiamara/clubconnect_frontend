package com.simats.clubconnectapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final ClubModel club;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, ClubModel club) {
        super(fragmentActivity);
        this.club = club;

        // Create fragments and pass club data
        fragmentList.add(ClubOverviewFragment.newInstance(club));
        fragmentList.add(ClubMembersFragment.newInstance(club));
        fragmentList.add(ClubChatFragment.newInstance(club));
        fragmentList.add(ClubEventsFragment.newInstance(club));
        fragmentList.add(ClubAttendanceFragment.newInstance(club));
        fragmentList.add(ClubProjectsFragment.newInstance(club));
        fragmentList.add(ClubGalleryFragment.newInstance(club));
        fragmentList.add(ClubAnnouncementsFragment.newInstance(club));
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    public Fragment getFragment(int position) {
        if (position >= 0 && position < fragmentList.size()) {
            return fragmentList.get(position);
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}
