package com.nt.batchConfig;

import com.nt.RegRepo;
import com.nt.entity.RegistrationDetails;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MyReader extends JdbcCursorItemReader<RegistrationDetails> {
    @Autowired
    private RegRepo repo;
    private Integer count=0;
    public List<String> list = new ArrayList<>();



    @Override
    public RegistrationDetails read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {


            return null;
    }
}
