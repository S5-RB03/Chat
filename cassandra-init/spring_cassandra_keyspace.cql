CREATE KEYSPACE IF NOT EXISTS spring_cassandra
WITH REPLICATION = {
    'class': 'SimpleStrategy',
    'replication_factor': 1
};

CREATE TABLE IF NOT EXISTS spring_cassandra.chat(
    id UUID PRIMARY KEY,
    message TEXT,
    created_at TIMESTAMP
);
