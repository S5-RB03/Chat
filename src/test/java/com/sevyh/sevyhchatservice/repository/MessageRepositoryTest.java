package com.sevyh.sevyhchatservice.repository;

import com.sevyh.sevyhchatservice.api.model.Message;
import com.sevyh.sevyhchatservice.api.model.MessageType;
import com.sevyh.sevyhchatservice.service.MessageService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MessageRepositoryTest {

    @MockBean
    private MessageRepository messageRepository;

    @Autowired
    private MessageService messageService;

    @Test
    public void getPaginatedMessagesTest() {
        UUID conversationId = UUID.randomUUID();
        UUID senderId = UUID.randomUUID();
        UUID receiverId = UUID.randomUUID();
        String id = "id";

        // Prepare some messages
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            messages.add(new Message(id, conversationId, "Message " + i, senderId, receiverId, new Timestamp(System.currentTimeMillis()), MessageType.TEXT));
        }

        // Mock the repository behavior
        when(messageRepository.findPaginatedMessages(any(), any())).thenReturn(messages.subList(0, 5));

        // Call the getPaginatedMessages method
        List<Message> paginatedMessages = messageService.getPaginatedMessages(senderId, receiverId, 1, 5);

        // Assertions
        assertFalse(paginatedMessages.isEmpty());
        assertEquals(5, paginatedMessages.size());
    }
}
