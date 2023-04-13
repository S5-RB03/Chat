package com.sevyh.sevyhchatservice.repository;

import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;
import com.sevyh.sevyhchatservice.api.model.Message;


public interface MessageRepository extends CassandraRepository<Message, UUID> {
    Message getMessageById(UUID messageId);
}
