package com.simats.clubconnectapp;

import java.util.List;

public class ClubModel {
    private String name;
    private String description;
    private String shortDescription;
    private int iconResId;
    private String mentor;
    private List<Member> members;
    private List<ChatMessage> chatMessages;
    private List<Event> events;
    private List<Project> projects;
    private List<GalleryItem> galleryItems;

    public ClubModel(String name, String shortDescription, String description, int iconResId, String mentor, List<Member> members, List<ChatMessage> chatMessages, List<Event> events, List<Project> projects, List<GalleryItem> galleryItems) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = description;
        this.iconResId = iconResId;
        this.mentor = mentor;
        this.members = members;
        this.chatMessages = chatMessages;
        this.events = events;
        this.projects = projects;
        this.galleryItems = galleryItems;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public int getIconResId() {
        return iconResId;
    }

    public String getMentor() {
        return mentor;
    }

    public List<Member> getMembers() {
        return members;
    }

    public int getMemberCount() {
        return members.size();
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<GalleryItem> getGalleryItems() {
        return galleryItems;
    }
}
