package com.neo4j.example.springdataneo4jintroapp.domainClasses;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Only one @Id / @Index(primary=true, unique=true) annotation is allowed in a class hierarchy
 */
@NodeEntity
public class Service2 {

    @Id
    String uniqueName;

    String extra;

    public Service2() {
    }

    public Service2(String uniqueName, String extra) {
        this.uniqueName = uniqueName;
        this.extra = extra;
    }

    public void setUniqueName(final String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public String getUniqueName() {
        return this.uniqueName;
    }

    public void setExtra(final String extra) {
        this.extra = extra;
    }

    public String getExtra() {
        return this.extra;
    }
}
