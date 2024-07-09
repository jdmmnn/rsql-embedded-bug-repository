package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SomeEmbeddedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    String name;
    String value;

    public SomeEmbeddedEntity(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public SomeEmbeddedEntity() {
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}
}
