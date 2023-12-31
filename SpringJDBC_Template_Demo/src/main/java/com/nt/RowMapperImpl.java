package com.nt;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperImpl implements RowMapper<Object> {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		Employee emp = new Employee();
		int id = rs.getInt(1);
		String name = rs.getString(2);
		emp.setEmpId(id);
		emp.setEmpName(name);
		return emp;
	}

}
