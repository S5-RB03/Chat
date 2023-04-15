package com.sevyh.sevyhchatservice.service.impl;

import java.nio.ByteBuffer;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sevyh.sevyhchatservice.api.model.Message;
import com.sevyh.sevyhchatservice.repository.MessageRepository;
import com.sevyh.sevyhchatservice.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    private final List<Message> messages = new ArrayList<>();

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message saveMessage(Message message) {

        // generate a random UUID for the message
        message.setMessageId(UUID.randomUUID());

        // generate a conversation ID based on the sender and receiver IDs
        UUID conversationId = generateConversationId(message.getSenderId(), message.getReceiverId());
        message.setConversationId(conversationId);

        message.setTimestamp(Instant.now());

        // save the message to the database
        messageRepository.save(message);


        return message;
    }

    @Override
    public Message getMessageById(UUID messageId) {
        return messages.stream()
                .filter(message -> message.getMessageId().equals(messageId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Message> getPaginatedMessages(UUID senderId, UUID receiverId, int page, int pageSize) {
        PageRequest pageable = PageRequest.of(page - 1, pageSize, Sort.by(Sort.Direction.DESC, "timestamp"));
        UUID conversationId = generateConversationId(senderId, receiverId);
        return messageRepository.findPaginatedMessages(conversationId, pageable);
    }

    private UUID generateConversationId(UUID senderId, UUID receiverId) {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        
        UUID firstId, secondId;
        if (senderId.compareTo(receiverId) < 0) {
            firstId = senderId;
            secondId = receiverId;
        } else {
            firstId = receiverId;
            secondId = senderId;
        }
    
        buffer.putLong(firstId.getMostSignificantBits());
        buffer.putLong(firstId.getLeastSignificantBits());
        buffer.putLong(secondId.getMostSignificantBits());
        buffer.putLong(secondId.getLeastSignificantBits());
    
        byte[] combinedBytes = buffer.array();
        UUID conversationId = UUID.nameUUIDFromBytes(combinedBytes);
        return conversationId;
    }
    

}