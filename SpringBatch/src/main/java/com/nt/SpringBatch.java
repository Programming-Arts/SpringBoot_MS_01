package com.nt;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing

public class SpringBatch implements CommandLineRunner {
    @Autowired
    private RegRepo repo;

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job processJob;

    public static void main(String[] args) {
        SpringApplication.run(SpringBatch.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Names length: "+repo.findAll().size());
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(processJob, jobParameters);
        System.out.println("Job started");

    }
}
