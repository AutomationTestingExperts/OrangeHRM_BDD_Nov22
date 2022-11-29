package com.orangeHRM.config;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features", 
		glue = "com.orangeHRM.stepDef", 
		dryRun = false, 
		monochrome = true, 
		tags = "@login",//Run all login tag scenarios
//		tags = "@login and not @negative", //To run all login tags except negative tag scenarios
		plugin = {"pretty", "html:Reports/CucumberReport.html"}
		)
public class Runner {

}
