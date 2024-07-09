package com.example.demo;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;

@TestConfiguration(proxyBeanMethods = false)
public class MySqlConfig {

    private static final MySQLContainer<?> container = new MySQLContainer<>("mysql:8.0.32").withReuse(true);

    @Bean
    @ServiceConnection
    public MySQLContainer<?> mySQLContainer() {
        return container;
    }
}
