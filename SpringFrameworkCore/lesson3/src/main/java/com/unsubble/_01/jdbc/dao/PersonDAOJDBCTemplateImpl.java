package com.unsubble._01.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.unsubble._01.jdbc.model.Person;

public class PersonDAOJDBCTemplateImpl implements PersonDAOJDBCTemplate {
	
	private static final String INSERT_PERSON = "INSERT INTO person(id, name, surname, birth_year) VALUES(?,?,?,?)";
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertPerson(Person person) {
		Object[] insertParams = {person.getId(), person.getName(), person.getSurname(), person.getBirthYear()};
		jdbcTemplate.update(INSERT_PERSON, insertParams);
	}

	
}
