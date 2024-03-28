package com.unsubble.lesson2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WorkingWithDateCell {

	public static void main(String[] args) {
		String path = "src/main/resources/date.xlsx";
		File file = new File(path);
		
		try (OutputStream out = new FileOutputStream(file, true);
				Workbook workbook = WorkbookFactory.create(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			Row row = sheet.createRow(rows + 1);
			Cell cell = row.createCell(0);
			LocalDate date = LocalDate.now(ZoneId.of("America/Chicago"));
			cell.setCellValue(date);
			CreationHelper creationHelper = workbook.getCreationHelper();
			CellStyle style = workbook.createCellStyle();
			style.setDataFormat(creationHelper.createDataFormat().getFormat("dd/MM/yyyy"));
			cell.setCellStyle(style);
			sheet.autoSizeColumn(0);
			workbook.write(out);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
