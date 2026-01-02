package com.simats.clubconnectapp;

public class VolunteerApplicant {

    private String name;
    private String dept;
    private String regNo;
    private String experience;
    private String date;

    public VolunteerApplicant(String name, String dept, String regNo,
                              String experience, String date) {
        this.name = name;
        this.dept = dept;
        this.regNo = regNo;
        this.experience = experience;
        this.date = date;
    }

    public String getName() { return name; }
    public String getDept() { return dept; }
    public String getRegNo() { return regNo; }
    public String getExperience() { return experience; }
    public String getDate() { return date; }
}
