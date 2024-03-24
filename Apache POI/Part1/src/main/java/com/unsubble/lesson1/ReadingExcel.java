package com.unsubble.lesson1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingExcel {

	public static void main(String[] args) {
		String excelFilePath = "src/main/resources/FinancialSample.xlsx";		
		
		try (Workbook workbook = WorkbookFactory.create(new File(excelFilePath))) {
			// Sheet sheet = workbook.getSheet("Sheet1");
			Sheet sheet = workbook.getSheetAt(0); // ismini bilmiyorsak sayfayı böyle de alabiliriz.
			
			for (Row row : sheet) {
				if (row.getCell(0).getStringCellValue().equalsIgnoreCase("government")) {
					for (Cell cell : row) {
						if (cell.getCellType() == CellType.STRING)
							System.out.print(cell.getStringCellValue() + " ");
					}
					System.out.println();
				}
			}
			
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(0).getLastCellNum();
			for (int i = 0; i <= rows; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < cols; j++) {
					Cell cell = row.getCell(j);
					System.out.print(cell.getCellType() == CellType.STRING ? 
							cell.getStringCellValue() + " ": "N/A ");
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
