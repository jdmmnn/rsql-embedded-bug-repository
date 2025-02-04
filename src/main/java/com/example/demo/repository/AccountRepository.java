package com.example.demo.repository;

import com.example.demo.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface AccountRepository extends JpaRepository<AccountEntity, String>, JpaSpecificationExecutor<AccountEntity>,
        QuerydslPredicateExecutor<AccountEntity> {
}
