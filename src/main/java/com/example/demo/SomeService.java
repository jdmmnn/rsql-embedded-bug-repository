package com.example.demo;

import io.github.perplexhub.rsql.RSQLCommonSupport;
import io.github.perplexhub.rsql.RSQLJPASupport;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    private final SomeRepository repository;

    public SomeService(SomeRepository repository) {this.repository = repository;}

    public void save(SomeEntity entity) {
        repository.save(entity);
    }

    public List<SomeEntity> findByQuery(String query) {
        return repository.findAll(RSQLJPASupport.rsql(query));
    }
}
