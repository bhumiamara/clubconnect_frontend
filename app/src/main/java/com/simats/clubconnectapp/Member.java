package com.simats.clubconnectapp;

public class Member {
    private String name;
    private String rollNo;
    private String role;

    public Member(String name, String rollNo, String role) {
        this.name = name;
        this.rollNo = rollNo;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getRole() {
        return role;
    }
}
