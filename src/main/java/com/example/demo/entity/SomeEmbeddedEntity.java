package com.example.demo.entity;

import jakarta.persistence.Embeddable;


@Embeddable
public class SomeEmbeddedEntity {

    private String name;
    private String value;

    public SomeEmbeddedEntity(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public SomeEmbeddedEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
