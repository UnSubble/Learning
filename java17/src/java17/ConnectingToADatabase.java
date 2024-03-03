package java17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectingToADatabase {
	public static void main(String[] args) throws SQLException {
		// jdbc:... -> ilk parça jdbc protocol'ü
		// jdbc:hsqldb:... -> ikinci parça veritabanının ismi
		// jdbc:hsqldb://localhost:5432/zoo -> üçüncü parça da subname(adres bilgisi, port bilgisi, database
																							// ismi)'sir.
		
		// connection elde etmenin 2 yolu var: DriverManager ve DataSource.
		
		final String url = "jdbc:hsqldb:file:zoo";
		try (Connection conn = DriverManager.getConnection(url)) {
			System.out.println(conn);
		}
		// try (Connection conn = DriverManager.getConnection(url, "username", "password")) {
		// 	System.out.println(conn);
		// }
	}
}
