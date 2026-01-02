package com.simats.clubconnectapp;

public class Event {
    private String title;
    private String date;
    private String time;
    private String location;
    private String description;

    public Event(String title, String date, String time, String location, String description) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }
}
