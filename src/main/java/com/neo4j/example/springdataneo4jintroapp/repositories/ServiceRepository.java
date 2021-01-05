package com.neo4j.example.springdataneo4jintroapp.repositories;

import com.neo4j.example.springdataneo4jintroapp.domainClasses.Service;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServiceRepository extends Neo4jRepository<Service, UUID> {

    Service findByName(String name);

    @Query("MERGE (e:Service {name:$s.name}) SET e.extra = $s.extra RETURN e")
    Service upsertAndReturn2(@Param("s") Service s);

//    @Query("MATCH (e:Service) RETURN e")
//    List<Service> match();
//
//    @Query("MERGE (e:Service {name:$s.name}) SET e.extra = $s.extra")
//    void upsert(@Param("s") Service s);
//
//    @Query("MERGE (e:Service {name:$s.name}) SET e.extra = $s.extra RETURN e")
//    List<Service> upsertAndReturn1(@Param("s") Service s);
}
