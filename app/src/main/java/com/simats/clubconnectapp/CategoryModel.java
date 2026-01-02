package com.simats.clubconnectapp;

public class CategoryModel {

    private String title, count;
    private int icon, bgColor;

    public CategoryModel(String title, String count, int icon, int bgColor) {
        this.title = title;
        this.count = count;
        this.icon = icon;
        this.bgColor = bgColor;
    }

    public String getTitle() {
        return title;
    }

    public String getCount() {
        return count;
    }

    public int getIcon() {
        return icon;
    }

    public int getBgColor() {
        return bgColor;
    }
}
