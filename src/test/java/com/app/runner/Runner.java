package com.app.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Mohan Rajadurai N\\eclipse-workspace\\Test\\src\\test\\java\\feature"
,glue = {"com.app.stepdefinition"},
//dryRun = true,
publish = true,
//snippets = SnippetType.CAMELCASE,
tags = "@sce1")

public class Runner {

}
