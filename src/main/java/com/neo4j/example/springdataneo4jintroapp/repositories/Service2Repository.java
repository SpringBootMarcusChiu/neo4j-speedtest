package com.neo4j.example.springdataneo4jintroapp.repositories;

import com.neo4j.example.springdataneo4jintroapp.domainClasses.Service2;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface Service2Repository extends Neo4jRepository<Service2, String>  {
}
