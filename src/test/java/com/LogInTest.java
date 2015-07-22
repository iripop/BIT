package com;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.EndUserSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesRunner;
import tools.Constants;
import tools.ReadingEmail;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("/resources/data.csv")
// @RunWith(ThucydidesRunner.class)
public class LogInTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	String username, password;

	@ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;

	@Steps
	public EndUserSteps endUser;

	ReadingEmail email;

	@Test
	public void logIn() {

		endUser.openHomePage();
		endUser.logInAsUser(username, password);
		endUser.goToVacationMenu();
		endUser.logInWithSuccess();
	}


	@After
	public void closeBrowser() {
		pages.getDriver().close();
	}

}
