package java17;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Types;

public class StatementsAndResultSet {
	public static void main(String[] args) throws SQLException {
		// PreparedStatement -> CallableStatement'a göre daha performanslı ve güvenli
		final String url = "jdbc:hsqldb:file:zoo";
		try (Connection conn = DriverManager.getConnection(url);
				PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM exhibits")) {
			stmnt.execute(); // ResultSet dönebilir ise true, executeUpdate gibi davranırsa false döner.
			ResultSet set = stmnt.getResultSet();	
		}
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement stmnt = conn.prepareStatement("INSERT INTO exhibits VALUES(10,'Deer',3)")) {
			//int result = stmnt.executeUpdate(); // Execute'da update edilen kaç tane satır varsa onu 
												// döner. SELECT direkt exception fırlatır.
			//System.out.println(result); // 1
		}
		try (Connection conn = DriverManager.getConnection(url);
				PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM exhibits")) {
			ResultSet set = stmnt.executeQuery(); // direkt resultset döner.
			while (set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				System.out.println(id + " " + name);
			}
		}
		
		// Method              DELETE           INSERT          SELECT         UPDATE
		// execute()           yes              yes             yes            yes
		// executeQuery()      no               no              yes            no
		// executeUpdate()     yes              yes             no             yes
		
		try (Connection conn = DriverManager.getConnection(url);
				PreparedStatement stmnt = conn.prepareStatement("INSERT INTO exhibits VALUES(?,?,?)")) {
				stmnt.setInt(1, 15);
				stmnt.setString(2, "Monkey");
				stmnt.setInt(3, 6); // birini bile set etmezsek exception fırlatır.
				stmnt.executeUpdate();
				
				// Aynı statement üzerinde birden fazla sorgu yapabiliriz.
				stmnt.setInt(1, 14);
				stmnt.setString(2, "Donkey");
				stmnt.setInt(3, 89);
				
				stmnt.executeUpdate();
		}
		
		try (Connection conn = DriverManager.getConnection(url);
				PreparedStatement stmnt = conn.prepareStatement("INSERT INTO exhibits VALUES(?,?,?)")) {
				stmnt.setInt(1, 17);
				stmnt.setString(2, "Gorilla");
				stmnt.setInt(3, 8);
				stmnt.addBatch();
				
				// arada execute kullanmamak için addBatch() kullanabiliriz. 
				
				stmnt.setInt(1, 91);
				stmnt.setString(2, "Horse");
				stmnt.setInt(3, 9);
				stmnt.addBatch();
				int[] res = stmnt.executeBatch();
		}
		
		// CALLABLE STATEMENT için:
		// Parameter type                     IN              OUT               INOUT
		// Used for input                     yes             no                yes
		// Used for output                    no              yes               yes
		// Must set parameter value           yes             no                yes
		// Must call registerOutParameter()   no			  yes				yes
		// Can include ?=                     no              yes               yes
		
		
		
		// ResultSet.TYPE_FORWARD_ONLY // resultset bir kerede sadece bir satır çalıştırabilir.
		// ResultSet.TYPE_SCROLL_INSENSITIVE // herhangi bir sırada gidebilir ancak tabloda yapılan 
																				// değişikleri göremez.
		// ResultSet.TYPE_SCROLL_SENSITIVE // herhangi bir sırada gidebilir ve tabloda yapılan değişiklik-
																				// leri görebilir.
		// ResultSet.CONCUR_READ_ONLY // Resultset değiştirilemez.
		// ResultSet.CONCUR_UPDATABLE // ResultSet değiştirilebilir.
		
	}
	
	static void resultSetExample(String sql, Connection conn) throws SQLException {
		try (var ps = conn.prepareStatement(sql);
				ResultSet set = ps.executeQuery()) {
			while (set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				int type = set.getInt("type");
				System.out.println(id + " " + name + " " + type);
			}
		}
	}
	
	static void resultSetExamp(String sql, Connection conn) throws SQLException {
		try (var ps = conn.prepareStatement(sql);
				ResultSet set = ps.executeQuery()) {
			if (set.next()) { // tek bir tane sorgu almak için böyle kullanabiliriz.
				set.getInt(1);
				set.getString(2);
				set.getInt(3);
			}
		}
	}
	
	static void callableStatementExample(Connection conn) throws SQLException {
		String sql = "{call read_e_names()}";
		try (CallableStatement cs = conn.prepareCall(sql);
				ResultSet rs = cs.executeQuery()) {
			while (rs.next()) {
				System.out.println(rs.getInt(3));
			}
		}
	}
	
	static void callableStatementExample2(Connection conn) throws SQLException {
		String sql = "{call read_names_by_letter(?)}";
		try (CallableStatement cs = conn.prepareCall(sql)) {
			cs.setString("prefix", "Z");
			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					System.out.println(rs.getInt(3));
				}
			}
		}
	}
	
	static void callableStatementExample3(Connection conn) throws SQLException {
		String sql = "{?= call magic_number(?) }";
		try (CallableStatement cs = conn.prepareCall(sql)) {
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			System.out.println(cs.getInt("num"));
		}
	}
	
	static void commitExample(String url, String sql) throws SQLException {
		try (Connection conn = DriverManager.getConnection(url)) {
			conn.setAutoCommit(false); // varsayılan olarak true // kapattığımız zaman manuel commitleyene
																 // kadar hiçbir değer veritabanına kayde-
																 // dilmez.
			
			var elephant = conn.prepareStatement(sql).execute();
			var zebra = conn.prepareStatement(sql).execute();
			
			if (!elephant || !zebra) {
				conn.rollback();
			} else {
				conn.commit();
			}
		}
	}
	
	static void commitExample2(String url, String sql) throws SQLException {
		try (Connection conn = DriverManager.getConnection(url)) {
			
			conn.setAutoCommit(false);
			
			var elephant = conn.prepareStatement(sql).execute();
			
			Savepoint sp1 = conn.setSavepoint();
			
			var zebra = conn.prepareStatement(sql).execute();
			
			if (!elephant || !zebra) {
				conn.rollback(sp1); // sp1'e döner.
			} else {
				conn.commit();
			}
		}
	}
	
}
