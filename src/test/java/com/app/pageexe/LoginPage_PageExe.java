package com.app.pageexe;

import com.app.base.BaseClass;
import com.app.locator.LoginPage_locator;

public class LoginPage_PageExe extends LoginPage_locator{
	
	public static void username(String user) {
		BaseClass.inputValue(LoginPage_locator.get_Username(), user);
	}
	
	public static void passeword(String pass) {
		BaseClass.inputValue(LoginPage_locator.get_password(), pass);
	}
	
	public static void loginButton() {
		BaseClass.click_Value(LoginPage_locator.get_password());
	}

}
