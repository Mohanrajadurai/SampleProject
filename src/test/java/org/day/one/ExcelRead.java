package org.day.one;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExcelRead {

	public static String excelReuse(int a, int b) {
		String value = null;
		try {
			// locate
			File f = new File("C:\\Users\\Mohan Rajadurai N\\Desktop\\Sep_Project.xlsx");
			// read
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet2");
			Row row = sheet.getRow(a);
			Cell cell = row.getCell(b);
			// System.out.println(cell);
			int cellType = cell.getCellType();
			if (cellType == 1) {
				value = cell.getStringCellValue();
				// System.out.println(value);
			} else if (cellType == 0) {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
					value = sm.format(dateCellValue);
					// System.out.println(value);
				} else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					value = String.valueOf(l);
					// System.out.println(value);
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public static void excelWrite(String a) {
		try {
			// locate
			File f = new File("C:\\Users\\Mohan Rajadurai N\\eclipse-workspace\\Test\\src\\test\\resources\\TestData\\Sep_Project.xlsx");
			// read
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet2");
			Row createRow = sheet.createRow(19);
			Cell createCell = createRow.createCell(1);
			createCell.setCellValue(a);
		
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

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://adactinhotelapp.com/");
		driver.findElement(By.id("username")).sendKeys(excelReuse(0, 0));
		driver.findElement(By.id("password")).sendKeys(excelReuse(1, 0));
		driver.findElement(By.xpath("//input[@id='login']")).click();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		WebElement location = driver.findElement(By.xpath("//select[@id='location']"));
		Select s = new Select(location);
		s.selectByValue(excelReuse(2, 1));

		WebElement hotels = driver.findElement(By.xpath("//select[@id='hotels']"));
		Select s1 = new Select(hotels);
		s1.selectByValue(excelReuse(2, 2));

		WebElement room = driver.findElement(By.xpath("//select[@id='room_type']"));
		Select s2 = new Select(room);
		s2.selectByValue(excelReuse(3, 3));

		WebElement noOfRoom = driver.findElement(By.xpath("//select[@id='room_nos']"));
		Select s3 = new Select(noOfRoom);
		s3.selectByVisibleText(excelReuse(4, 4));

		driver.findElement(By.id("datepick_in")).clear();
		driver.findElement(By.id("datepick_in")).sendKeys(excelReuse(0, 7));

		driver.findElement(By.id("datepick_out")).clear();
		driver.findElement(By.id("datepick_out")).sendKeys(excelReuse(0, 8));

		WebElement aPerRoom = driver.findElement(By.xpath("//select[@id='adult_room']"));
		Select s4 = new Select(aPerRoom);
		s4.selectByVisibleText(excelReuse(2, 5));

		WebElement cPerRoom = driver.findElement(By.xpath("//select[@id='child_room']"));
		Select s5 = new Select(cPerRoom);
		s5.selectByVisibleText(excelReuse(2, 6));

		driver.findElement(By.xpath("//input[@id='Submit']")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();

		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(excelReuse(0, 9));
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(excelReuse(1, 9));
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys(excelReuse(2, 9));
		driver.findElement(By.xpath("//input[@id='cc_num']")).sendKeys(excelReuse(3, 9));

		WebElement ccType = driver.findElement(By.id("cc_type"));
		Select sType = new Select(ccType);
		sType.selectByVisibleText(excelReuse(2, 10));

		WebElement expiryMonth = driver.findElement(By.id("cc_exp_month"));
		Select sMonth = new Select(expiryMonth);
		sMonth.selectByVisibleText(excelReuse(3, 11));

		WebElement expiryYear = driver.findElement(By.id("cc_exp_year"));
		Select sYear = new Select(expiryYear);
		sYear.selectByVisibleText(excelReuse(16, 12));

		driver.findElement(By.xpath("//input[@id='cc_cvv']")).sendKeys(excelReuse(4, 9));

		driver.findElement(By.id("book_now")).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement orderNo = driver.findElement(By.id("order_no"));
		String orderNumber = orderNo.getAttribute("value");
		System.out.println(orderNumber);
		
		excelWrite("Order No. : "+orderNumber);
	}
}
