package com.sevyh.sevyhchatservice.api.model;

import java.sql.Timestamp;
import java.util.UUID;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class MessageKey {

    @PrimaryKeyColumn(name = "conversation_id", type = PrimaryKeyType.PARTITIONED)
    private UUID conversationId;

    @PrimaryKeyColumn(name = "timestamp", ordinal = 0, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private Timestamp timestamp;

    public MessageKey() {
    }

    public MessageKey(UUID conversationId, Timestamp timestamp) {
        this.conversationId = conversationId;
        this.timestamp = timestamp;
    }

    public UUID getConversationId() {
        return conversationId;
    }

    public void setConversationId(UUID conversationId) {
        this.conversationId = conversationId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
