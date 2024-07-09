package com.example.demo;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class SomeEntity {

    @Id
    String ident;

    @OneToOne
    @JoinColumn(name = "embedded_id")
    SomeEmbeddedEntity embedded;

    public SomeEntity(String ident, SomeEmbeddedEntity embedded) {
        this.ident = ident;
        this.embedded = embedded;
    }

    public SomeEntity() {
    }

    public SomeEmbeddedEntity getEmbedded() {return embedded;}

    public void setEmbedded(SomeEmbeddedEntity embedded) {this.embedded = embedded;}
}
