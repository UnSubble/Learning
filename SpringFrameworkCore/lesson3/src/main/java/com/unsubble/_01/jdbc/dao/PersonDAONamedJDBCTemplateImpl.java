package com.unsubble._01.jdbc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.unsubble._01.jdbc.model.Person;

public class PersonDAONamedJDBCTemplateImpl implements PersonDAONamedJDBCTemplate {
	private static final String INSERT_PERSON = "INSERT INTO person(id, name, surname, birth_year) VALUES(:id,:name,:surname,:birthYear)";

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void insertPerson(Person person) {
		Map<String, Object> map = Map.of("id", person.getId(), "name", person.getName(),
				"surname", person.getSurname(), "birthYear", person.getBirthYear()); // böyle map de olur 
		SqlParameterSource source = new MapSqlParameterSource(map);
		namedParameterJdbcTemplate.update(INSERT_PERSON, source);
	}

	@Override
	public List<Person> getAllPersons() {
		return namedParameterJdbcTemplate.query("SELECT * FROM person", new PersonRowMapper());
	}

}
