package com.nt;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

public class ParamSetter implements PreparedStatementSetter {
	int id;
	String name;

	public ParamSetter(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public void setValues(PreparedStatement ps) throws SQLException {

		// set values of column emp_id, emp_name
		ps.setInt(1, id);
		ps.setString(2, name);
	}

}
