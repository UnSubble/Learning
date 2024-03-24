package com.unsubble.lesson2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingExcel {

	public static void main(String[] args) {
		String excelFilePath = "src/main/resources/FinancialSample.xlsx";
		
		try (OutputStream out = new FileOutputStream(new File(excelFilePath), true);
				Workbook workbook = WorkbookFactory.create(new File(excelFilePath))) {
			Sheet sheet = workbook.getSheet("Sheet1");
			int rows = sheet.getLastRowNum();
			Row row = sheet.createRow(rows + 1);
			for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
				if (row.getCell(i) == null) {
					Cell cell = row.createCell(i);
					cell.setCellValue("test");
				}
			}			
			workbook.write(out);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
