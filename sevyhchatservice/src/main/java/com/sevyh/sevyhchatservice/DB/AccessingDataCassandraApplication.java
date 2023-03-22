package com.sevyh.sevyhchatservice.DB;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sevyh.sevyhchatservice.Models.Chat;
import com.sevyh.sevyhchatservice.Repositories.ChatRepository;

@SpringBootApplication
public class AccessingDataCassandraApplication {
    
    private final static Logger log = LoggerFactory.getLogger(AccessingDataCassandraApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataCassandraApplication.class, args);
    }

    @Bean
    public CommandLineRunner clr(ChatRepository chatRepository){
        return args -> {
            chatRepository.deleteAll();
      
            Chat hello = new Chat(UUID.randomUUID(), "Hello",Date.from(Instant.now()));
            Chat world = new Chat(UUID.randomUUID(), "World", Date.from(Instant.now()));
            
            Chat savedHello = chatRepository.save(hello);
            Chat savedWorld = chatRepository.save(world);
      
            chatRepository.findAll()
              .forEach(v -> log.info("Chat: {}", v.getMessage()));
            
            chatRepository.findById(savedHello.getId())
              .ifPresent(v -> log.info("Chat by id: {}", v.getMessage()));
          };
    }
 

}
