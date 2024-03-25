package com.unsubble.lesson3;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FormattingCellColor {

	public static void main(String[] args) {
		String path = "src/main/resources/formatting.xlsx";
		
		try (OutputStream out = new FileOutputStream(new File(path), true);
				Workbook workbook = WorkbookFactory.create(new File(path))) {
			Sheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);
			CellStyle style = workbook.createCellStyle();
			style.setFillBackgroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.DIAMONDS);
			cell.setCellStyle(style);
			workbook.write(out);
			
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
