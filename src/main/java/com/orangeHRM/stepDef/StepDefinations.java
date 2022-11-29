package com.orangeHRM.stepDef;

import java.util.List;


import com.orangeHRM.pageObjects.HomePage;
import com.orangeHRM.pageObjects.LoginPage;
import com.orangeHRM.utils.Util;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinations {
	
	@Given("User on login page pre requisite")
	public void user_on_login_page_pre_requisite() {
	    System.out.println("Back ground implemnetation");
	}

	@Given("User on login page")
	public void user_on_login_page() {
		LoginPage log = new LoginPage(BaseClass.driver);
		log.isPageOpened();
	}

	@When("user enters credentials")
	public void user_enters_credentials() {
		LoginPage log = new LoginPage(BaseClass.driver);
		log.logInToPage(Util.readProperty("username"), Util.readProperty("password"));
	}

	@When("user enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) {
		LoginPage log = new LoginPage(BaseClass.driver);
		log.logInToPage(username, password);
	}

	@Then("User should successfully login")
	public void user_should_successfully_login() {
		HomePage home = new HomePage(BaseClass.driver);
		home.isPageOpened();
	}

	@Then("User should successfully login <language>")
	public void user_should_successfully_login_language(DataTable dataTable) {
		List<String> list = dataTable.asList();
		HomePage home = new HomePage(BaseClass.driver);
		home.isPageOpened();
		System.out.println("If group of values as param : "+list);

	}

	@When("User clicks on logout")
	public void user_clicks_on_logout() {
		HomePage home = new HomePage(BaseClass.driver);
		home.logoutOfThePage();
	}

	@Then("user gould be on login page")
	public void user_should_be_on_login_page() {
		LoginPage log = new LoginPage(BaseClass.driver);
		log.isPageOpened();
	}

}
