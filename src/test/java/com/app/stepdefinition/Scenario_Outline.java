package com.app.stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Scenario_Outline {

	@When("Enter the user {string}")
	public void enter_the_user(String string) {
		System.out.println(string);
	}
	@When("Enter the pass {string}")
	public void enter_the_pass(String string) {
		System.out.println(string);
	}
	@When("Click the Login")
	public void click_the_login() {
		System.out.println("Login Button");
	}
	@Then("Validate the Home")
	public void validate_the_home() {
		System.out.println("HomePage");
	}
}
