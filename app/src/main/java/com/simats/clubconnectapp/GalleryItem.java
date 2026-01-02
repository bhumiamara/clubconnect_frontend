package com.simats.clubconnectapp;

public class GalleryItem {
    private int imageResId;
    private String title;
    private String date;
    private String description;

    public GalleryItem(int imageResId, String title, String date, String description) {
        this.imageResId = imageResId;
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
