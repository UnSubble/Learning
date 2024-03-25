package com.unsubble.lesson2;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingPasswordProtectedExcel {

	public static void main(String[] args) {
		String path = "src/main/resources/password123.xlsx";
		
		try (Workbook workbook = WorkbookFactory.create(new File(path), "123")) {
			Sheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(0);
			for (int i = 0; i < 3; i++) {
				System.out.println(row.getCell(i).getStringCellValue());
			}
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
