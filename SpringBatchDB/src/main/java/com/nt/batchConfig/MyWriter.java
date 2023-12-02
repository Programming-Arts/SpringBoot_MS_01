package com.nt.batchConfig;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class MyWriter implements ItemWriter {
    public MyWriter(){
        System.out.println("My Writter Con");
    }
    @Override
    public void write(List list) throws Exception {
        System.out.println("Writing list:");
        list.stream().forEach(System.out::println);
    }
}
