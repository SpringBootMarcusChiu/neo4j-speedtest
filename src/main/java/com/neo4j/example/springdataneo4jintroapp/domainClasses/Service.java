package com.neo4j.example.springdataneo4jintroapp.domainClasses;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Service extends Asset {

    String extra;

    public Service() {
    }

    public Service(String name, String extra) {
        this.name = name;
        this.extra = extra;
    }

    public void setExtra(final String extra) {
        this.extra = extra;
    }

    public String getExtra() {
        return this.extra;
    }
}
