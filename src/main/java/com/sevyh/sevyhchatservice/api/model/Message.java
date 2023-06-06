package com.sevyh.sevyhchatservice.api.model;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("messages")
public class Message {

    @PrimaryKey
    private MessageKey key;

    @Column("messageid")
    private String messageId;
    
    @Column("textcontent")
    private String textContent;
    
    @Column("senderid")
    private UUID senderId;
    
    @Column("receiverid")
    private UUID receiverId;
    
    @Column("messagetype")
    private MessageType messageType;

    // Constructors

    public MessageKey getKey() {
        return key;
    }

    public void setKey(MessageKey key) {
        this.key = key;
    }

    public Message() {
    }

    public Message(String messageId, UUID conversationId, UUID senderId, UUID receiverId, Timestamp timestamp, MessageType messageType) {
        this(messageId, conversationId, null, senderId, receiverId, timestamp, messageType);
    }


    public Message(String messageId, UUID conversationId, String textContent, UUID senderId, UUID receiverId, Timestamp timestamp, MessageType messageType) {
        this.messageId = messageId;
        this.textContent = textContent;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.messageType = messageType;
        this.key = new MessageKey(conversationId, timestamp);
    }
    

    public String getId() {
        return messageId;
    }

    public void setId(String messageId) {
        this.messageId = messageId;
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

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
    @Override
    public String toString() {
        return "Message{" +
                "id='" + messageId + '\'' +
                ", conversationId='" + this.key.getConversationId() + '\'' +
                ", textContent='" + textContent + '\'' +
                ", senderId='" + senderId + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", timestamp=" + this.key.getTimestamp() +
                ", messageType='" + messageType + '\'' +
                '}';
    }

}