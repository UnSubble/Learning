package com.unsubble.lesson1;

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

public class WrtieDataToFormulaCell {
	
	public static void main(String[] args) {
		String path = "src/main/resources/readFormula.xlsx";
		
		try (OutputStream out = new FileOutputStream(new File(path), true);
				Workbook workbook = WorkbookFactory.create(new File(path))) {
			Sheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			String formula = String.format("SUM(A%d:B%d)", rows + 1, rows + 1); // row'ların index'i 0-based 
																				// olduğu için 1 eklememiz lazım.
			Row row = sheet.createRow(rows + 1);
			Cell cell = row.createCell(2);
			cell.setCellFormula(formula);
			workbook.write(out);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
