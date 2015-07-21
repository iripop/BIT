package com.steps;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.pages.LogInPage;
import com.pages.MyFreeDaysPage;
import com.pages.MyRequestsPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class EndUserSteps extends ScenarioSteps {

	MyFreeDaysPage myFreeDaysPage;
	MyRequestsPage myRequestsPage;
	LogInPage page;

	@Step
	public void enterUserName(String keyword) {
		page.insertUserName(keyword);
	}

	@Step
	public void enterPassword(String keyword) {
		page.insertPassword(keyword);
	}

	@Step
	public void startsLogIn() {
		page.clickSignInButton();
	}


	@StepGroup
	public void logInAsUser(String name, String pass) {
		enterUserName(name);
		enterPassword(pass);
		startsLogIn();
		logInWithSuccess();
	}

	@StepGroup
	public void logInAsDM(String name, String pass) {
		enterUserName(name);
		enterPassword(pass);
		startsLogIn();
		logInWithSuccess();
	}

	@Step
	public void goToVacationMenu() {
		page.clickVacationMenu();
	}

	@Step
	public void logInWithSuccess() {
		boolean found = page.checkIfVacationTabIsPresent();
		assertTrue("VacationMenu not found", found);
	}

	@Step
	public void accessMyRequests() {
		myRequestsPage.checkIfMyRequestsMenuExists();
		myRequestsPage.clickMyRequests();

	}
	@Step
	public void openHomePage() {
		getDriver().manage().window().maximize();
		page.open();

		
	}
}