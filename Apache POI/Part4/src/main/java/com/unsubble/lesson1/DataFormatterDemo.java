package com.unsubble.lesson1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFormatterDemo {

	public static void main(String[] args) {
		String path = "src/main/resources/dataFormat.xlsx";
		
		try (Workbook workbook = WorkbookFactory.create(new File(path))) {
			Sheet sheet = workbook.getSheetAt(0);
			DataFormatter dataFormatter = new DataFormatter(Locale.ENGLISH);
			int rows = sheet.getLastRowNum();
			int columns = sheet.getRow(rows).getLastCellNum();
			String data = dataFormatter.formatCellValue(sheet.getRow(rows).getCell(columns - 1));
			CellStyle style = workbook.createCellStyle();
			style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			System.out.println(data);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
