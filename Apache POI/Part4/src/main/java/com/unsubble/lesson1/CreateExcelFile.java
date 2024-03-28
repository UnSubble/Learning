package com.unsubble.lesson1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CreateExcelFile {

	public static void main(String[] args) {
		String path = "src/main/resources/create.xlsx";
		
		File file = new File(path);
		
		if (!file.exists()) {
			try (OutputStream out = new FileOutputStream(file);
					Workbook workbook = WorkbookFactory.create(true)) {
				if (workbook.getSheetIndex("Sheet1") == -1)
					workbook.createSheet("Sheet1");
				workbook.write(out);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
