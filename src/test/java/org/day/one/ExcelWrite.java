package org.day.one;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public static void excelWrite() {

		try {
			// locate
			File f = new File("C:\\Users\\Mohan Rajadurai N\\eclipse-workspace\\Test\\src\\test\\resources\\TestData\\Sep_Project.xlsx");
			// read
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.createSheet("Aiite");
			Row createRow = sheet.createRow(0);
			Cell createCell = createRow.createCell(0);
			createCell.setCellValue("Java");
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		excelWrite();
	}
}
