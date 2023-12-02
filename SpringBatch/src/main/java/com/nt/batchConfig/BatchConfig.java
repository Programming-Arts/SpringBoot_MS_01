package com.nt.batchConfig;

import com.nt.entity.RegistrationDetails;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Configuration

public class BatchConfig {
//    @Autowired
//    private DriverManagerDataSource dataSource;
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

    public class UserRowMapper implements RowMapper<RegistrationDetails> {
        @Override
        public RegistrationDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
            RegistrationDetails user = new RegistrationDetails();
            user.setPersonID(rs.getInt("person_id"));
            user.setPersonName(rs.getString("person_name"));
            return user;
        }
    }

//    @Bean
    public DataSource getDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/mysql");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public JdbcCursorItemReader<RegistrationDetails> reader() {
        JdbcCursorItemReader<RegistrationDetails> reader = new JdbcCursorItemReader<RegistrationDetails>();
        DataSource dataSource1 = getDataSource();
        reader.setDataSource(dataSource1);
        reader.setSql("select person_id,person_name FROM reg_details");
        reader.setRowMapper(new UserRowMapper());
        return reader;
    }

    @Bean
    public ItemProcessor<RegistrationDetails,RegistrationDetails> getProcessor(){
        return new ItemProcessor() {
            @Override
            public RegistrationDetails process(Object o) throws Exception {
                return (RegistrationDetails)o;
            }
        };


    }

    @Bean
    public ItemWriter<RegistrationDetails> getWriter(){
      return new ItemWriter<RegistrationDetails>() {
          @Override
          public void write(List<? extends RegistrationDetails> list) throws Exception {
              list.stream().forEach(obj->{
                  System.out.println(obj.getPersonName().toUpperCase());
              });
          }
      };
    }


    @Bean
    public Step getStep() {
        System.out.println("getStep: ");
        return stepBuilderFactory
                .get("getStep")
                .<RegistrationDetails, RegistrationDetails>chunk(2)
                .reader(reader())
                .processor(getProcessor())
                .writer(getWriter()).build();
    }

    @Bean
    public Job processJob() {
        return jobBuilderFactory
                .get("processJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .flow(getStep())
                .end().build();
    }
}
