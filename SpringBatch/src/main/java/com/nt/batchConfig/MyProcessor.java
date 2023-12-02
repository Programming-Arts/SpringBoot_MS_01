package com.nt.batchConfig;

import com.nt.entity.RegistrationDetails;
import org.springframework.batch.item.ItemProcessor;

public class MyProcessor implements ItemProcessor<RegistrationDetails,String> {
    public MyProcessor(){
        System.out.println("My Processor Con");
    }
    @Override
    public String process(RegistrationDetails s) throws Exception {
//        System.out.println("inside process method");
        return s.getPersonName();
    }
}
