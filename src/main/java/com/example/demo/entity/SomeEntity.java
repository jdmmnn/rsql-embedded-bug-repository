package com.example.demo.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SomeEntity {

    @Id
    private String ident;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "embedded_name"))
    @AttributeOverride(name = "value", column = @Column(name = "embedded_value"))
    private SomeEmbeddedEntity someEmbeddedEntity;

    public SomeEntity(String ident, SomeEmbeddedEntity someEmbeddedEntity) {
        this.ident = ident;
        this.someEmbeddedEntity = someEmbeddedEntity;
    }

    public SomeEntity() {
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getIdent() {
        return ident;
    }

    public void setSomeEmbeddedEntity(SomeEmbeddedEntity someEmbeddedEntity) {
        this.someEmbeddedEntity = someEmbeddedEntity;
    }

    public SomeEmbeddedEntity getSomeEmbeddedEntity() {
        return someEmbeddedEntity;
    }
}
