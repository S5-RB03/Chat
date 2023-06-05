package com.sevyh.sevyhchatservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.datastax.oss.driver.api.core.CqlSession;

import jakarta.annotation.PostConstruct;

@Configuration
public class CassandraConfig {

    @Value("${spring.cassandra.keyspace-name}")
    private String keyspaceName;

    @Autowired
    private CqlSession session;

    @PostConstruct
    public void createKeyspace() {
        String query = "CREATE KEYSPACE IF NOT EXISTS " + keyspaceName +
                       " WITH replication = {'class':'SimpleStrategy', 'replication_factor':1};";
        session.execute(query);
    }
}
