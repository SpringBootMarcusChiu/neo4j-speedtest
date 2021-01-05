package com.neo4j.example.springdataneo4jintroapp.domainClasses;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.typeconversion.Convert;
import org.neo4j.ogm.typeconversion.UuidStringConverter;

import java.util.UUID;

public class Asset {

    public Long id;

    @Id
    @GeneratedValue(strategy = UUIDStrategy.class)
    @Convert(UuidStringConverter.class)
    public UUID uuid;

//    @Index(unique=true)
    String name;


    public Asset() {

    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setUuid(final UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
