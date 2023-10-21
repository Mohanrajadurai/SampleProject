package com.app.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
	
	@Before
	public void beforeTest() {
		System.out.println("Before");
	}
	
	@After
	public void afterTest() {
		System.out.println("After");
	}

}
