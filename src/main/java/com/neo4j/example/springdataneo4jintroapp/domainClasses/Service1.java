package com.neo4j.example.springdataneo4jintroapp.domainClasses;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Service1 extends Asset {

    String extra;

    public Service1() {
    }

    public Service1(String name, String extra) {
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
