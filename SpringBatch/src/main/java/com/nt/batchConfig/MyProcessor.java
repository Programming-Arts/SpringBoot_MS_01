package com.nt.batchConfig;

import com.nt.entity.RegistrationDetails;
import org.springframework.batch.item.ItemProcessor;

public class MyProcessor implements ItemProcessor<RegistrationDetails,RegistrationDetails> {
    public MyProcessor(){
        System.out.println("My Processor Con");
    }


    @Override
    public RegistrationDetails process(RegistrationDetails registrationDetails) throws Exception {
        return registrationDetails;
    }
}
