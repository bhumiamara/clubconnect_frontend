package com.simats.clubconnectapp;

public class MeetingAttendance {
    private String meetingName;
    private String date;
    private int totalMembers;
    private int presentMembers;

    public MeetingAttendance(String meetingName, String date, int totalMembers, int presentMembers) {
        this.meetingName = meetingName;
        this.date = date;
        this.totalMembers = totalMembers;
        this.presentMembers = presentMembers;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public String getDate() {
        return date;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public int getPresentMembers() {
        return presentMembers;
    }

    public int getAbsentMembers() {
        return totalMembers - presentMembers;
    }

    public int getAttendancePercentage() {
        return (int) (((double) presentMembers / totalMembers) * 100);
    }
}
