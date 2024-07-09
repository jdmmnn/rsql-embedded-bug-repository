package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceTest {

    @Autowired
    SomeService service;

    @Test
    void test() {
        // Given
        SomeEntity entity = new SomeEntity("1", new SomeEmbeddedEntity("name", "value"));
        service.save(entity);

        // When
        List<SomeEntity> result = service.findByQuery("embedded.name==name");

        // Then
        assertThat(result).hasSize(1);
    }
}
