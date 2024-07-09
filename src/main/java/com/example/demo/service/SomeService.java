package com.example.demo.service;

import com.example.demo.entity.SomeEntity;
import com.example.demo.repository.SomeRepository;
import io.github.perplexhub.rsql.RSQLJPASupport;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    private final SomeRepository repository;

    public SomeService(SomeRepository repository) {this.repository = repository;}

    public List<SomeEntity> findByQuery(String query) {
        return repository.findAll(RSQLJPASupport.rsql(query));
    }
}
