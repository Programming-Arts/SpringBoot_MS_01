package com.nt.batchConfig;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class MyReader implements ItemReader<String> {
    public MyReader(){
        System.out.println("My Reader Con");
    }
    private String[] messages = {
            "ankur",
            "nikhil",
            "Ram",
    "dhanu",
    "kedar"};

    private int count = 0;
    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println("inside read method");
        if (count < messages.length) {
            return messages[count++];
        } else {
            count = 0;
        }
        return null;
    }
}
