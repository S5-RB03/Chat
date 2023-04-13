package com.sevyh.sevyhchatservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sevyh.sevyhchatservice.api.model.Message;
import com.sevyh.sevyhchatservice.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    private final List<Message> messages = new ArrayList<>();

    @Override
    public Message saveMessage(Message message) {
        messages.add(message);
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
        return messages.stream()
                .filter(message -> (message.getSenderId().equals(senderId) && message.getReceiverId().equals(receiverId))
                        || (message.getSenderId().equals(receiverId) && message.getReceiverId().equals(senderId)))
                .sorted((m1, m2) -> m2.getTimestamp().compareTo(m1.getTimestamp())) // Newest messages first
                .skip((page - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }
}