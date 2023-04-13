package com.sevyh.sevyhchatservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.cassandra.DataCassandraTest;
import org.springframework.test.context.TestPropertySource;

import com.sevyh.sevyhchatservice.Models.Chat;
import com.sevyh.sevyhchatservice.Repositories.ChatRepository;

@DataCassandraTest
@TestPropertySource(properties = {
    "spring.data.cassandra.keyspace-name=test"
})
public class ChatRepositoryIntegrationTest {
    
    // @Autowired
    // private ChatRepository chatRepository;
    
    // @Test
    // public void testFindByCreatedAt() {
    //     // create a chat entity
    //     Chat chat = new Chat(UUID.randomUUID(), "Hello, world!", Date.from(Instant.now()));
    //     chatRepository.save(chat);
        
    //     // Find the chat by its uuid
    //     Optional<Chat> foundChat = chatRepository.findById(chat.getId());
        
    //     // assert that the chat was found and has the correct properties
    //     assertThat(foundChat).isPresent();
    //     assertThat(foundChat.get().getId()).isEqualTo(chat.getId());
    //     assertThat(foundChat.get().getMessage()).isEqualTo(chat.getMessage());
    // }
}
