package com.nt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
		Demo demoObj=new Demo();
		demoObj.setAge(20);
		demoObj.setName("Yash");
		System.out.println(demoObj);

        // convert java into json object
        ObjectMapper objectMapper= new ObjectMapper();
        String objectInJSONFormat = objectMapper.writeValueAsString(demoObj);
        System.out.println("Java Object: "+demoObj);
        System.out.println("JSON object: "+objectInJSONFormat);


        String jsonObj = "{\"age\":20,\"name\":\"Yash\"}";
        Demo dmo1=objectMapper.readValue(jsonObj,Demo.class);
        System.out.println("Object converted to java from JSON: "+dmo1);

    }
}
