package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class TableCreator {

	public static void createTable(DataSource ds) {
		dropTableIfExists(ds);
		try (Connection conn = ds.getConnection();
				PreparedStatement stmnt = conn.prepareStatement("CREATE TABLE employee(id INTEGER NOT NULL "
					+ "PRIMARY KEY AUTOINCREMENT, name VARCHAR(100), surname VARCHAR(100), salary INTEGER)")) {
			stmnt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void dropTableIfExists(DataSource ds) {
		try (Connection conn = ds.getConnection();
				PreparedStatement stmnt = conn.prepareStatement("DROP TABLE IF EXISTS employee")) {
			stmnt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
