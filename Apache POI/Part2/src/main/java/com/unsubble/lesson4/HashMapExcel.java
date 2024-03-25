package com.unsubble.lesson4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class HashMapExcel {

	public static void main(String[] args) {
		String path = "src/main/resources/hashmap.xlsx";
		
		try (OutputStream out = new FileOutputStream(new File(path), true);
				Workbook workbook = WorkbookFactory.create(new File(path))) {
			Map<Integer, String> map = Map.of(101, "John", 102, "Smith", 103, "Scott", 104, "Kim");
			Sheet sheet = workbook.createSheet("Sheet1");
			int rowCount = 0;
			for (Map.Entry<Integer, String> entry : map.entrySet()) {
				Row row = sheet.createRow(rowCount++);
				row.createCell(0).setCellValue(entry.getKey());
				row.createCell(1).setCellValue(entry.getValue());
			}
			workbook.write(out);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
