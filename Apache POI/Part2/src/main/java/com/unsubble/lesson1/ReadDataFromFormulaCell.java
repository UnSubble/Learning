package com.unsubble.lesson1;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromFormulaCell {
	
	public static void main(String[] args) {
		String path = "src/main/resources/readFormula.xlsx";
		
		try (Workbook workbook = WorkbookFactory.create(new File(path))) {
			Sheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(2);
			System.out.println(cell.getCellFormula());
			System.out.println(cell.getNumericCellValue());
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
