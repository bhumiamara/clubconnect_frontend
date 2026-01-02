package com.simats.clubconnectapp;

public class ChatMessage {
    private String senderName;
    private String senderId;
    private String message;
    private String timestamp;

    public ChatMessage(String senderName, String senderId, String message, String timestamp) {
        this.senderName = senderName;
        this.senderId = senderId;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
