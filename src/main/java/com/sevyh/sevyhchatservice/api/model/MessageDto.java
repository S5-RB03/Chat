package com.sevyh.sevyhchatservice.api.model;

import java.util.UUID;

public class MessageDto {
    private String id;
    private String textContent;
    private UUID senderId;
    private UUID receiverId;
    private MessageType messageType;

    public MessageDto() {
    }

    public MessageDto(String id, String textContent, UUID senderId, UUID receiverId, MessageType messageType) {
        this.id = id;
        this.textContent = textContent;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.messageType = messageType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public UUID getSenderId() {
        return senderId;
    }

    public void setSenderId(UUID senderId) {
        this.senderId = senderId;
    }

    public UUID getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(UUID receiverId) {
        this.receiverId = receiverId;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
}