package com.neo4j.example.springdataneo4jintroapp;

import com.neo4j.example.springdataneo4jintroapp.domainClasses.Service;
import com.neo4j.example.springdataneo4jintroapp.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataNeo4jIntroAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataNeo4jIntroAppApplication.class, args);
	}

	@Autowired
	ServiceRepository serviceRepository;

	DecimalFormat df = new DecimalFormat("#.####");

	@PostConstruct
	public void test() {
		int numNodes = 500;
		testUpsertAndReturnTime(numNodes);
		testReadSaveTime(numNodes);
		testUpsertAndReturnTime(numNodes);
		testReadSaveTime(numNodes);

		/*
			(Started App with Empty DB)
			Average upsertAndReturn() Time: 0.0265
			Average readSave() Time: 0.0313
			Average upsertAndReturn() Time: 0.0016
			Average readSave() Time: 0.0024

			(Started App With (All Nodes Existing) DB)
			Average upsertAndReturn() Time: 0.0024
			Average readSave() Time: 0.003
			Average upsertAndReturn() Time: 0.0016
			Average readSave() Time: 0.0026

		 */
	}

	private void testUpsertAndReturnTime(int num) {
		List<Service> services = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Service s = new Service("upsertAndReturn() " + i, "upsertAndReturn() " + i);
			services.add(s);
		}

		long start = System.nanoTime();
		for (Service s: services) {
			Service t = serviceRepository.upsertAndReturn2(s);
		}
		double elapsedTime = (double)(System.nanoTime() - start);
		double elapsedTimeSeconds = elapsedTime / 1000000000d;
		System.out.println("Average upsertAndReturn() Time: " + df.format(elapsedTimeSeconds / num));
	}

	private void testReadSaveTime(int num) {
		List<Service> services = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Service s = new Service("readSave() " + i, "readSave() " + i);
			services.add(s);
		}

		long start = System.nanoTime();
		for (Service s: services) {
			Service t = serviceRepository.findByName(s.getName());
			if (t == null) {
				serviceRepository.save(s);
			} else {
				t.setExtra(s.getExtra());
				serviceRepository.save(t);
			}
		}
		double elapsedTime = (double)(System.nanoTime() - start);
		double elapsedTimeSeconds = elapsedTime / 1000000000d;
		System.out.println("Average readSave() Time: " + df.format(elapsedTimeSeconds / num));
	}
}
