package com.sevyh.sevyhchatservice.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.sevyh.sevyhchatservice.api.model.Message;
import com.sevyh.sevyhchatservice.api.model.MessageKey;


public interface MessageRepository extends CassandraRepository<Message, MessageKey> {
    Message getMessageById(UUID messageId);

    @Query("SELECT * FROM messages WHERE conversation_id = :conversation_id")
    List<Message> findPaginatedMessages(@Param("conversation_id") UUID conversation_id, Pageable pageable);    
}
