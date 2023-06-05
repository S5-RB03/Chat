package com.sevyh.sevyhchatservice.api.model;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("messages")
public class Message {

    @PrimaryKey(value = "messageid")
    private String id;
    @Column("conversation_id")
    private UUID conversationId; 
    @Column("textcontent")
    private String textContent;
    @Column("senderid")
    private UUID senderId;
    @Column("receiverid")
    private UUID receiverId;
    @Column("timestamp")
    private Instant timestamp;
    @Column("messagetype")
    private MessageType messageType;

    public Message() {
    }

    public Message(String id, UUID conversationId, UUID senderId, UUID receiverId, Instant timestamp, MessageType messageType) {
        this(id, conversationId, null, senderId, receiverId, timestamp, messageType);
    }


    public Message(String id, UUID conversationId, String textContent, UUID senderId, UUID receiverId, Instant timestamp, MessageType messageType) {
        this.id = id;
        this.conversationId = conversationId;
        this.textContent = textContent;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.timestamp = timestamp;
        this.messageType = messageType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UUID getConversationId() {
        return conversationId;
    }

    public void setConversationId(UUID conversationId) {
        this.conversationId = conversationId;
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

    public void setReceiverId(UUID reveiverId) {
        this.receiverId = reveiverId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
}