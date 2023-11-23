package com.nt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RegDetailsRepository {

	@Autowired
	private JdbcTemplate template;

	// used to create a table
	public void createTable() {
//		execute method used to perdorm DDL command
		try {
			template.execute("create table Employee (emp_id number(2) primary key, emp_name varchar2(20))");
			System.out.println("Employee table created");
		} catch (Exception e) {
			System.out.println("Error while creating employee table");
		}

	}

	public void addRecords() {

		try {
			int val = template.update("insert into employee values (15, 'Rutuja')");

			System.out.println("Inserted record with id=" + val);
		} catch (Exception e) {
			System.out.println("Exception occured while inserting record");
		}

	}

	public void deleteRecord() {
		try {
			int val = template.update("delete from employee where emp_id = 13");

			System.out.println("Deleted record with id=" + val);
		} catch (Exception e) {
			System.out.println("Exception occured while deleting record");
		}
	}

	@Transactional
	public void updateRecord() {
		try {
			int noOfRecordsAffected = template.update("update Employee set emp_name = 'Ram' where emp_id=17");
			System.out.println("noOfRecordsAffected: " + noOfRecordsAffected);
		} catch (Exception e) {
			System.out.println("Exception occurred while updating record");

		}
	}

	public void setDynamicValuesToSQLQuery(int id, String name) {
		ParamSetter params = new ParamSetter(id, name);
		template.update("insert into Employee values (?,?)", params);
	}

	public void paramSetterByAnonymousClass(int id, String name) {
		try {
			PreparedStatementSetter obj = new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, id);
					ps.setString(2, name);

				}
			};

			template.update("insert into Employee values (?,?)", obj);
			System.out.println("Inserted record successfully.");
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception occurred while inserting record");
		}
	}

	public void getAllRecordsUsingRowMapper() {

		try {
//			RowMapperImpl impl = new RowMapperImpl();
			ResultSetExtractorImpl extractorImpl = new ResultSetExtractorImpl();

			Object employees =  template.query("select * from Employee", extractorImpl);
			System.out.println(employees);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception occurred while fetching records"+e.getMessage());
		}
	}

}
