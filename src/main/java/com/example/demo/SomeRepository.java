package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface SomeRepository extends JpaRepository<SomeEntity, String>, JpaSpecificationExecutor<SomeEntity>,
        QuerydslPredicateExecutor<SomeEntity> {
}
