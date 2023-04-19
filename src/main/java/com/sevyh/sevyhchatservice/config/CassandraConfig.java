package com.sevyh.sevyhchatservice.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

@Configuration
public class CassandraConfig {

    @Autowired
    private CqlSession cqlSession;

    @Bean
    public CassandraOperations cassandraTemplate() {
        return new CassandraTemplate(cqlSession);
    }

}
