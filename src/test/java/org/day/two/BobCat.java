package org.day.two;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BobCat {
	
	public static void excelWrite(int a, int b, String c) {
		
		try {
			File f = new File("C:\\Users\\Mohan Rajadurai N\\eclipse-workspace\\Test\\src\\test\\resources\\TestData\\BobCat.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			Row row = sheet.createRow(a);
			Cell cell = row.createCell(b);
			cell.setCellValue(c);
			
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
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bobcat.com/in/en");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//button[@aria-label='Close'])[1]")).click();
		
		driver.findElement(By.xpath("(//div[contains(text(),'Equipment')])[3]")).click();
		
		driver.findElement(By.xpath("(//span[contains(text(),'Skid-Steer Loaders')])[1]")).click();
		
		
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			WebElement a = driver.findElement(By.xpath("(//*[@class='card-title pt-2'])[1]"));
			String prodName1 = a.getText();
			//System.out.println(prodName1);
			excelWrite(0, 0, prodName1);
			
			WebElement b = driver.findElement(By.xpath("(//*[@class='card-title pt-2'])[2]"));
			String prodName2 = b.getText();
			excelWrite(1, 0, prodName2);
			
			WebElement c = driver.findElement(By.xpath("(//*[@class='card-title pt-2'])[3]"));
			String prodName3 = c.getText();
			excelWrite(2, 0, prodName3);
			
			WebElement d = driver.findElement(By.xpath("(//*[@class='card-title pt-2'])[4]"));
			String prodName4 = d.getText();
			excelWrite(3, 0, prodName4);
			
			try {
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//div[contains(text(),'Equipment')])[3]")).click();
				driver.findElement(By.xpath("(//span[contains(text(),'Compact Track Loaders')])[1]")).click();
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				WebElement e = driver.findElement(By.xpath("(//*[@class='card-title pt-2'])[1]"));
				String prodName5 = e.getText();
				excelWrite(5, 0, prodName5);
				
				WebElement f = driver.findElement(By.xpath("(//*[@class='card-title pt-2'])[2]"));
				String prodName6 = f.getText();
				excelWrite(6, 0, prodName6);
				
				WebElement g = driver.findElement(By.xpath("(//*[@class='card-title pt-2'])[3]"));
				String prodName7 = g.getText();
				excelWrite(7, 0, prodName7);
				
				WebElement h = driver.findElement(By.xpath("(//*[@class='card-title pt-2'])[4]"));
				String prodName8 = h.getText();
				excelWrite(8, 0, prodName8);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
