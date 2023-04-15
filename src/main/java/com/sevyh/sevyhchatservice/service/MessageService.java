package com.sevyh.sevyhchatservice.service;

import java.util.List;
import java.util.UUID;

import com.sevyh.sevyhchatservice.api.model.Message;

public interface MessageService {
    Message saveMessage(Message message);
    Message getMessageById(UUID messageId);
    List<Message> getPaginatedMessages(UUID senderId, UUID receiverId, int page, int pageSize);
}