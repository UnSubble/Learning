package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final String INSERT_EMPLOYEE = "INSERT INTO employee(name,surname,salary) VALUES(?,?,?)";
	private static final String ALL_EMPLOYEES = "SELECT * FROM employee";
	private static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id=?";

	private DataSource getDataSource() {
		ConnectionManager cm = new ConnectionManager();
		DataSource source = cm.getMySQLDataSource();
		return source;
	}
	
	@Override
	public void insertEmployee(String name, String surname, int salary) {
		DataSource source = getDataSource();
		
		try(Connection conn = source.getConnection();
				PreparedStatement stmnt = conn.prepareStatement(INSERT_EMPLOYEE)) {
			stmnt.setString(1, name);
			stmnt.setString(2, surname);
			stmnt.setInt(3, salary);
			stmnt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> getEmployees() {
		DataSource source = getDataSource();
		List<Employee> list = new ArrayList<>();

		try(Connection conn = source.getConnection();
				PreparedStatement stmnt = conn.prepareStatement(ALL_EMPLOYEES);
				ResultSet rs = stmnt.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				int salary = rs.getInt("salary");
				Employee employee = new Employee(id, name, surname, salary);
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void removeEmployee(int id) {
		DataSource source = getDataSource();
		
		try(Connection conn = source.getConnection();
				PreparedStatement stmnt = conn.prepareStatement(DELETE_EMPLOYEE)) {
			stmnt.setInt(1, id);
			stmnt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
