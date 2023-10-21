package com.app.base;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
public static WebDriver driver = null;
	
	public static void browserlaunch(String data) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(data);
	}
	
	public static void inputValue(WebElement element, String data) {
		try {
		element.clear();
		element.sendKeys(data);
		} catch (TimeoutException e) {
			throw new RuntimeException("Unable to enter the Value");
		}
	}
	
	public static void click_Value(WebElement element) {
		try {
		element.click();
		} catch (TimeoutException e) {
			throw new RuntimeException("Unable to click the Value");
		}
	}

}
