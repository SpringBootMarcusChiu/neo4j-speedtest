package com.neo4j.example.springdataneo4jintroapp;

import com.neo4j.example.springdataneo4jintroapp.runs.Service1SpeedTest;
import com.neo4j.example.springdataneo4jintroapp.runs.Service2Test;
import com.neo4j.example.springdataneo4jintroapp.runs.Service3Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringDataNeo4jIntroAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataNeo4jIntroAppApplication.class, args);
	}

	@Autowired
	Service1SpeedTest service1SpeedTest;

	@Autowired
	Service2Test service2Test;

	@Autowired
	Service3Test service3Test;

	@PostConstruct
	public void run() {
		service1SpeedTest.test();
//		service2Test.test2();
//		service3Test.test2();

		System.exit(0);
	}
}
