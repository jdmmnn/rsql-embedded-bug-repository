package com.example.demo;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.MountableFile;

@TestConfiguration(proxyBeanMethods = false)
public class MySQLContainerConfig {

    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "";

    @Bean
    @ServiceConnection
    public MySQLContainer<?> mySQLContainer() {
        MySQLContainer<?> container = new MySQLContainer<>("mysql:8.0.34").withDatabaseName("somedatabase")
                .withUsername(DB_USERNAME)
                .withPassword(DB_PASSWORD)
                .withReuse(true)
                .withCopyFileToContainer(MountableFile.forClasspathResource("schema.sql"), "/docker-entrypoint-initdb.d/schema.sql");
        container.start();
        return container;
    }
}
