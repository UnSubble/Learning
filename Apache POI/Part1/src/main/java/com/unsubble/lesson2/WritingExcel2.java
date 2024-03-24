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

public class WritingExcel2 {

	public static void main(String[] args) throws IOException {
		Object[][] countryData = {{"Country Name", "Capital City"}, {"Turkey", "Ankara"}, {"Azerbaijan", "Baku"}};
		
		File trgt = new File("src/main/resources/Countries.xlsx");
		try (Workbook workbook = WorkbookFactory.create(trgt)) {
			Sheet sheet = workbook.createSheet("Sheet1");
			for (int i = 0; i < countryData.length; i++) {
				Row row = sheet.createRow(i);
				for (int j = 0; j < countryData[0].length; j++) {
					Cell cell = row.createCell(j);
					cell.setCellValue(countryData[i][j].toString());
				}
			}
			OutputStream out = new FileOutputStream(trgt, true);
			workbook.write(out);
			out.close();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
