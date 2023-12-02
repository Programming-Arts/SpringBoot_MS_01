package com.nt.batchConfig;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.batch.operations.JobExecutionAlreadyCompleteException;

@Configuration

public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public JobExecutionListener listener() {
        return new JobExecutionListenerSupport() {
            @Override
            public void afterJob(JobExecution jobExecution) {
                if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
                    System.out.println("Job is executed and completed successfully");
                }
            }
        };
    }

    @Bean
    public Step getStep(){
      return stepBuilderFactory
              .get("myStep")
              .<String, String>chunk(2)
              .reader(new MyReader())
              .processor(new MyProcessor())
              .writer(new MyWriter()).build();
    }

    @Bean
    public Job processJob(){
        return jobBuilderFactory
                .get("processJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener() )
                .flow(getStep())
                .end().build();
    }
}
