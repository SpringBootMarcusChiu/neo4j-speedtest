package com.neo4j.example.springdataneo4jintroapp.repositories;

import com.neo4j.example.springdataneo4jintroapp.domainClasses.Service3;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface Service3Repository extends Neo4jRepository<Service3, String>  {
}
