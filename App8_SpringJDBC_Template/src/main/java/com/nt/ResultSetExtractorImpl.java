package com.nt;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class ResultSetExtractorImpl implements ResultSetExtractor<Object> {
	@Override
	public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
		Employee employee = new Employee();
		String idFromDB = rs.getString(1);
		String nameFromDB = rs.getString(2);
		employee.setEmpId(Integer.parseInt(nameFromDB));
		employee.setEmpName(nameFromDB);
		return employee;
	}
}
