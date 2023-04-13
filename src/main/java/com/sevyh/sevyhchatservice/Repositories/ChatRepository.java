package com.sevyh.sevyhchatservice.Repositories;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.sevyh.sevyhchatservice.Models.Chat;

public interface ChatRepository extends CassandraRepository<Chat, UUID> {
    Optional<Chat> findByCreatedAt(Date date);

    Optional<Chat> findById(UUID id);

}
