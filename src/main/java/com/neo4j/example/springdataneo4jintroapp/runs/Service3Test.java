package com.neo4j.example.springdataneo4jintroapp.runs;

import com.neo4j.example.springdataneo4jintroapp.domainClasses.Service3;
import com.neo4j.example.springdataneo4jintroapp.repositories.Service3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Service3Test {

    @Autowired
    Service3Repository service3Repository;

    public void test2() {
        Service3 serviceA = new Service3("unique name", "Extra 1");
        Service3 serviceB = new Service3("unique name", "Extra 2");

        Service3 serviceAs = service3Repository.save(serviceA);
        Service3 serviceBs = service3Repository.save(serviceB);
    }
}
