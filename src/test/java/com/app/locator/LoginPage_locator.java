package com.app.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.app.base.BaseClass;

public class LoginPage_locator extends BaseClass {
	
	public static WebElement get_Username() {
		return driver.findElement(By.id("email"));	
	}
	
	public static WebElement get_password() {
		return driver.findElement(By.id("pass"));	
	}

	public static WebElement get_loginButton() {
		return driver.findElement(By.id("login"));	
	}

}
