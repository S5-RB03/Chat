CREATE KEYSPACE IF NOT EXISTS chatmessages_keyspace WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

CREATE TABLE IF NOT EXISTS chatmessages_keyspace.messages (
    conversation_id UUID,
    senderId UUID,
    receiverId UUID,
    messageId text,
    timestamp timestamp,
    messageType text,
    textContent text,
    PRIMARY KEY (conversation_id, timestamp)
) WITH CLUSTERING ORDER BY (timestamp DESC);
