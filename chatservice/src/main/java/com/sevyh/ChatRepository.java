package com.sevyh;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ChatRepository extends CassandraRepository<Chat, UUID> {
    Chat findByCreatedAt(String createdAt);
}