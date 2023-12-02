package com.nt.batchConfig;

import org.springframework.batch.item.ItemProcessor;

public class MyProcessor implements ItemProcessor<String,String> {
    public MyProcessor(){
        System.out.println("My Processor Con");
    }
    @Override
    public String process(String s) throws Exception {
        System.out.println("inside process method");
        return s.toUpperCase();
    }
}
