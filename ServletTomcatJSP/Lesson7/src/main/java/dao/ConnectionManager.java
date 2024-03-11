package dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

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
