package com.simats.clubconnectapp;

public class MemberAttendance {
    private String memberName;
    private String rollNo;
    private int meetingsAttended;

    public MemberAttendance(String memberName, String rollNo, int meetingsAttended) {
        this.memberName = memberName;
        this.rollNo = rollNo;
        this.meetingsAttended = meetingsAttended;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getRollNo() {
        return rollNo;
    }

    public int getMeetingsAttended() {
        return meetingsAttended;
    }
}
