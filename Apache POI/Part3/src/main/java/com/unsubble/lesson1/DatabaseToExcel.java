package com.unsubble.lesson1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DatabaseToExcel {

	public static void main(String[] args) {
		String dbPath = "jdbc:sqlite:database.db";
		String excelPath = "src/main//resources/databaseToExcel.xlsx";
		
		try (Connection conn = getConnection(dbPath);
				PreparedStatement stmnt = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Employee("
						+ "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, name TEXT, salary INTEGER)")) {
			stmnt.execute();
			try (PreparedStatement stmnt2 = conn.prepareStatement("INSERT INTO Employee(name, salary) VALUES("
					+ "'Test4', 123428)")) {
				stmnt2.execute();
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try (Connection conn = getConnection(dbPath);
				PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Employee");
				OutputStream out = new FileOutputStream(new File(excelPath), true);
				ResultSet rs = stmnt.executeQuery();
				Workbook workbook = WorkbookFactory.create(new File(excelPath));) {
			Sheet sheet = workbook.createSheet("Sheet1");
			int rows = 0;
			while (rs.next()) {
				Row row = sheet.createRow(rows++);
				Cell cell = row.createCell(0);
				cell.setCellValue(rs.getString(2));
				Cell cell2 = row.createCell(1);
				cell2.setCellValue(rs.getInt(3));
			}
			workbook.write(out);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public static Connection getConnection(String path) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(path);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
