package com.neo4j.example.springdataneo4jintroapp.runs;

import com.neo4j.example.springdataneo4jintroapp.domainClasses.Service1;
import com.neo4j.example.springdataneo4jintroapp.repositories.Service1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class Service1SpeedTest {

    @Autowired
    Service1Repository service1Repository;

    DecimalFormat df = new DecimalFormat("#.####");

    public void test() {
        System.out.println("\nSpeedTest Start");
        int numNodes = 500;
        testUpsertAndReturnTime(numNodes);
        testReadSaveTime(numNodes);
        testUpsertAndReturnTime(numNodes);
        testReadSaveTime(numNodes);
        System.out.println("SpeedTest End\n");

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
        List<Service1> services = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Service1 s = new Service1("upsertAndReturn() " + i, "upsertAndReturn() " + i);
            services.add(s);
        }

        long start = System.nanoTime();
        for (Service1 s: services) {
            Service1 t = service1Repository.upsertAndReturn2(s);
        }
        double elapsedTime = (double)(System.nanoTime() - start);
        double elapsedTimeSeconds = elapsedTime / 1000000000d;
        System.out.println("Average upsertAndReturn() Time: " + df.format(elapsedTimeSeconds / num));
    }

    private void testReadSaveTime(int num) {
        List<Service1> services = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Service1 s = new Service1("readSave() " + i, "readSave() " + i);
            services.add(s);
        }

        long start = System.nanoTime();
        for (Service1 s: services) {
            Service1 t = service1Repository.findByName(s.getName());
            if (t == null) {
                service1Repository.save(s);
            } else {
                t.setExtra(s.getExtra());
                service1Repository.save(t);
            }
        }
        double elapsedTime = (double)(System.nanoTime() - start);
        double elapsedTimeSeconds = elapsedTime / 1000000000d;
        System.out.println("Average readSave() Time: " + df.format(elapsedTimeSeconds / num));
    }
}
