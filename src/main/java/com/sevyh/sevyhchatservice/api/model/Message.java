package com.sevyh.sevyhchatservice.api.model;

import java.util.UUID;

enum MessageType {
    TEXT, IMAGE, VIDEO,
}

public class Message {

    private UUID id;
    private String textContent;
    private String senderId;
    private String receiverId;
    private String timestamp;
    private MessageType messageType;

    public Message() {
    }

    public Message(UUID id, String senderId, String receiverId, String timestamp, MessageType messageType) {
        this(id, null, senderId, receiverId, timestamp, messageType);
    }


    public Message(UUID id, String textContent, String senderId, String receiverId, String timestamp, MessageType messageType) {
        this.id = id;
        this.textContent = textContent;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.timestamp = timestamp;
        this.messageType = messageType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getSender() {
        return senderId;
    }

    public void setSender(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiver() {
        return receiverId;
    }

    public void setReceiver(String reveiverId) {
        this.receiverId = reveiverId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
}