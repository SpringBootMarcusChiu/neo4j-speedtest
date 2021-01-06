package com.neo4j.example.springdataneo4jintroapp.runs;

import com.neo4j.example.springdataneo4jintroapp.domainClasses.Service2;
import com.neo4j.example.springdataneo4jintroapp.repositories.Service2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Service2Test {

    @Autowired
    Service2Repository service2Repository;

    public void test2() {
        Service2 serviceA = new Service2("unique name", "Extra 1");
        Service2 serviceB = new Service2("unique name", "Extra 2");

        Service2 serviceAs = service2Repository.save(serviceA);
        Service2 serviceBs = service2Repository.save(serviceB);
    }
}
