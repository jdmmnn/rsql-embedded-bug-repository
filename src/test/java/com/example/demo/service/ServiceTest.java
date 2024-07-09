package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.DemoApplication;
import com.example.demo.MySQLContainerConfig;
import com.example.demo.entity.SomeEmbeddedEntity;
import com.example.demo.entity.SomeEntity;
import com.example.demo.repository.SomeRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {MySQLContainerConfig.class, DemoApplication.class})
class ServiceTest {

    @Autowired
    SomeRepository someRepository;
    @Autowired
    SomeService service;

    @Test
    void testSearchWithFullName() {
        // Given
        someRepository.save(new SomeEntity("some-ident", new SomeEmbeddedEntity("field1", "some value")));

        // When
        List<SomeEntity> result = service.findByQuery("someEmbeddedEntity.name==field1");

        // Then
        assertThat(result).hasSize(1);
    }

    @Test
    void testSearchWithShortNameAndPropertyMapper() {
        // Given
        // TODO: add rsql property mapper

        someRepository.save(new SomeEntity("some-ident-other", new SomeEmbeddedEntity("field2", "some value")));

        // When
        List<SomeEntity> result = service.findByQuery("name==field2");

        // Then
        assertThat(result).hasSize(1);
    }
}
