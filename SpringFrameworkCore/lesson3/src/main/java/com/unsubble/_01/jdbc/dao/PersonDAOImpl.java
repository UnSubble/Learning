package com.unsubble._01.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.unsubble._01.jdbc.model.Person;

public class PersonDAOImpl implements PersonDAO {
	
	private static final String INSERT_PERSON = "INSERT INTO person(id, name, surname, birth_year) VALUES(?,?,?,?)";
	
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void createTableIfNotExists() {
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement stmnt = conn.prepareStatement(
				"CREATE TABLE IF NOT EXISTS person(id int, name VARCHAR(50), surname VARCHAR(50), birth_year INT)")) {
			stmnt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertPerson(Person person) {
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement stmnt = conn.prepareStatement(INSERT_PERSON)) {
			stmnt.setInt(1, person.getId());
			stmnt.setString(2, person.getName());
			stmnt.setString(3, person.getSurname());
			stmnt.setInt(4, person.getBirthYear());
			stmnt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
