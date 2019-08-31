package com.ibm.batch;

import com.ibm.batch.properties.FoncProperties;
import com.ibm.batch.properties.TechProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class BatchApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private TechProperties techProperties;

	public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);


	}
    @Override
    public void run(String... args) throws Exception {

        System.out.println("***************************Batch Application***********************************");
        FoncProperties foncProperties = appContext.getBean(FoncProperties.class);
        System.out.println("Fonc Prop 1 : " + foncProperties.getFoncProp1());
        System.out.println("Tech Prop 1 : " + techProperties.getTechProp1());

    }
}
