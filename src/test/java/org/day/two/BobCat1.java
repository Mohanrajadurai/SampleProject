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

public class BobCat1 {

public static void excelWrite(int a, int b, String c) {
		
		try {
			File f = new File("C:\\Users\\Mohan Rajadurai N\\eclipse-workspace\\Test\\src\\test\\resources\\TestData\\Sample.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet2");
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
		
		WebElement firstProd = driver.findElement(By.xpath("//a[@title='S450 Skid-Steer Loader']/preceding::a[contains(text(), 'S70')]"));
		String prodName1 = firstProd.getText();
		excelWrite(0, 0, prodName1);
		
		WebElement secProd = driver.findElement(By.xpath("//a[contains(text(), 'S70')]/following::a[@title='S450 Skid-Steer Loader']"));
		String prodName2 = secProd.getText(); 
		excelWrite(1, 0, prodName2);
		
		WebElement thirdProd = driver.findElement(By.xpath("//a[@title='S450 Skid-Steer Loader']/following::a[contains(@title, 'S590')]"));
		String prodName3 = thirdProd.getText();
		excelWrite(2, 0, prodName3);
		
		WebElement forthProd = driver.findElement(By.xpath("//div[contains(@class, 'card')]/child::a[contains(@title, 'S770')]"));
		String prodName4 = forthProd.getText();
		excelWrite(3, 0, prodName4);
}
}