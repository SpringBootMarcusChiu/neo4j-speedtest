package com.neo4j.example.springdataneo4jintroapp.domainClasses;

import org.neo4j.ogm.id.IdStrategy;

import java.util.UUID;

public class UUIDStrategy implements IdStrategy {
    @Override
    public Object generateId(Object o) {
        return UUID.randomUUID();
    }
}
