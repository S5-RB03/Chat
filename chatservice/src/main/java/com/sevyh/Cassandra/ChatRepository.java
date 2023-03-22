package com.sevyh.Cassandra;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ChatRepository extends CassandraRepository<Chat, UUID> {
    Optional<Chat> findById(UUID id);

    Iterable<Chat> findByMessage(String message);
}
