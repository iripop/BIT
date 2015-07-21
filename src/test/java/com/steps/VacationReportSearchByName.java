package com.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.pages.LogInPage;
import com.pages.MyFreeDaysPage;
import com.pages.MyRequestsPage;
import com.pages.VacationsReportPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class VacationReportSearchByName extends ScenarioSteps {

	LogInPage page;
	VacationsReportPage reportPage;

	@Step
	public void insertLastName(String name) {
		reportPage.enterLastName(name);
	}

	@Step
	public void insertFirstName(String name) {
		reportPage.enterFirstName(name);
	}

	@Step
	public void clickSearchButton() {
		reportPage.clickSearchButton();
	}

	@StepGroup
	public void searchByLastNameAndFirstName(String lastName, String firstName) {
		insertFirstName(firstName);
		insertLastName(lastName);
		clickSearchButton();
	}

	@Step
	public void goToVacationReportWithSuccess() {
		boolean found = false;
		found = reportPage.checkIfSearchButtonIsPresent();
		assertTrue("Search button is Not found", found);
	}

	@Step
	public void viewVacationReport() {
		reportPage.clickVacationsReportMenu();
	}

	@Step
	public void checkIfLastNameIsCorrect(String lastName) {
		assertTrue("Last name Is not correct", reportPage.checkIfLastnameFromTableIsTheSameAsIntroduced(lastName));
	}

	@Step
	public void checkIfFirstNameIsCorrect(String firstName) {
		assertTrue("First name Is not correct", reportPage.checkfIfFirstNameFromTableIsTheSameAsIntroduced(firstName));
	}
}