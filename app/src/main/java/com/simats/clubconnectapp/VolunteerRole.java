package com.simats.clubconnectapp;

public class VolunteerRole {

    private String role;
    private String club;
    private String duration;
    private int applicants;

    public VolunteerRole(String role, String club, String duration, int applicants) {
        this.role = role;
        this.club = club;
        this.duration = duration;
        this.applicants = applicants;
    }

    public String getRole() {
        return role;
    }

    public String getClub() {
        return club;
    }

    public String getDuration() {
        return duration;
    }

    public int getApplicants() {
        return applicants;
    }
}
