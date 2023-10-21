package com.app.stepdefinition;

import com.app.pageexe.LoginPage_PageExe;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage_Exe extends LoginPage_PageExe {
	
	@Given("Launch the Browser")
	public void launch_the_browser() {
		browserlaunch("https://www.facebook.com/");
	}
	@Given("Enter the URL")
	public void enter_the_url() {
		System.out.println("URL");
	}
	@When("Enter the valid Username {string}")
	public void enter_the_valid_username(String user) {
		username(user);
	}
	@When("Enter the valid Password {string}")
	public void enter_the_valid_password(String pass) {
		passeword(pass);
	}
	@When("Click the LoginButton")
	public void click_the_login_button() {
		System.out.println("LoginButton");
	}
	@Then("Validate the HomePage")
	public void validate_the_home_page() {
		System.out.println("HomePage");
	}

}
