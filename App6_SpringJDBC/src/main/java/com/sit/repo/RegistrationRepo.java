package com.sit.repo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

@Repository

public class RegistrationRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertData() {
		String query = "Insert into reg_details (PERSON_ID,CONTACT,PERSON_EMAIL,PERSON_AGE,PERSON_NAME) values (127,32,'Kirti@gmail.com',25,'Kirti')";
		jdbcTemplate.update(query);
	}
	
	public void insertDataWithParams(int id,int contact,String email,int age,String name) {
		String query = "Insert into reg_details (PERSON_ID,CONTACT,PERSON_EMAIL,PERSON_AGE,PERSON_NAME) values (?,?,?,?,?)";
		jdbcTemplate.update(query,new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, id);
				ps.setInt(2, contact);
				ps.setString(3, email);
				ps.setInt(4, age);
				ps.setString(5, name);
				
			}
		});
	}

}
