package com.simats.clubconnectapp;

public class VolunteerModel {
    private String title;
    private String details;
    private String role;
    private String deadline;
    private int progress;

    public VolunteerModel(String title, String details, String role, String deadline, int progress) {
        this.title = title;
        this.details = details;
        this.role = role;
        this.deadline = deadline;
        this.progress = progress;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public String getRole() {
        return role;
    }

    public String getDeadline() {
        return deadline;
    }

    public int getProgress() {
        return progress;
    }
}
