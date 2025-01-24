package com.unsubble._01.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.unsubble._01.jdbc.model.Person;

public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String surname = rs.getString("surname");
		int birthYear = rs.getInt("birth_year");
		
		return new Person(id, name, surname, birthYear);
	}

	
}
