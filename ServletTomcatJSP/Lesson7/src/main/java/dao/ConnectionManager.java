package dao;
import javax.sql.DataSource;

import org.sqlite.SQLiteDataSource;


public class ConnectionManager {

	public DataSource getMySQLDataSource() {
		
		// ResourceBundle bundle = ResourceBundle.getBundle(path);
		
		SQLiteDataSource mysqlDataSource = new SQLiteDataSource();
		mysqlDataSource.setUrl("jdbc:sqlite:database.db");
		
		return mysqlDataSource;
	}
}
