package com.nt.batchConfig;

import com.nt.RegRepo;
import com.nt.entity.RegistrationDetails;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyReader extends JdbcCursorItemReader<RegistrationDetails> {
    @Autowired
    private RegRepo repo;
    public List<RegistrationDetails> list=new ArrayList<>();
    public MyReader()
    {

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
    protected RegistrationDetails readCursor(ResultSet rs, int currentRow) throws SQLException {
        RegistrationDetails obj=new RegistrationDetails();
        obj.setPersonName(rs.getString("person_name"));
        obj.setEmail(rs.getString("person_email"));
        obj.setPersonAge(rs.getInt("person_age"));
        obj.setContact(rs.getInt("contact"));
        obj.setPersonID(rs.getInt("person_id"));
        return super.readCursor(rs, currentRow);
    }
}
