package com.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.WebElement;

import com.pages.LogInPage;
import com.pages.MyFreeDaysPage;
import com.pages.MyRequestsPage;
import com.pages.ViewVacationsPage;
import com.pages.InboxPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class ViewVacationsSteps extends ScenarioSteps {

	LogInPage page;
	InboxPage inboxPage;
	ViewVacationsPage viewVacationsPage;

	@Step
	public void checkIfTheDesiredVacationIsPresent(String employeeName, String startDate, String endDate,
			String type, String status) {
		boolean isPresent = viewVacationsPage.checkIfTheDesiredRequestWasApprovedOrRejected(employeeName, startDate,
				endDate, type, status);
		assertTrue("Is not present", isPresent);
	}

	@Step
	public void goToViewVacationsPage() {
		viewVacationsPage.clickViewVacationsMenu();
	}

	@Step

	public void filterMyRequestsStepInViewVacations(String filter) {
		viewVacationsPage.selectFiltersFromListInViewVacations(filter);

	}

	@Step
	public void checkFilteringMyRequestsByTypeInViewVacations(String selection) {
		viewVacationsPage.checkIfTableIsFilteredByStatusInViewVacations(selection);
	}

	@Step
	public void checkFilteringMyRequestsByStatusInViewVacations(String selection) {
		viewVacationsPage.checkIfTableIsFilteredByStatusInViewVacations(selection);
	}

	@Step
	public void checkFilteringMyRequestsByDaysNumberInViewVacations(int nr1, int nr2) {
		viewVacationsPage.checkIfTableIsFilteredByDaysNumberInViewVacations(nr1, nr2);
	}

	@Step
	public void applyFilterRequests() {
		viewVacationsPage.clickApplyButtonForFiltersInViewVacations();
	}

	public void typeFirstName(String firstName) {
		viewVacationsPage.enterFirstName(firstName);
	}

	@Step
	public void typeLastName(String lastName) {
		viewVacationsPage.enterLastName(lastName);
	}

	@Step
	public void clickApplyButton() {
		viewVacationsPage.clickApplyButton();
	}

	@StepGroup
	public void searchVacationsByEmployeeName(String lastName, String firstName) {
		typeFirstName(firstName);
		typeLastName(lastName);
		clickApplyButton();
		checkIfTheRequestsAreFilteringCorrect(lastName, firstName);
	}

	@Step
	public void checkIfTheRequestsAreFilteringCorrect(String lastName, String firstName) {
		boolean isOk = viewVacationsPage.checkIfAllRequestsFromTheTableAreWithTheGivenName(lastName, firstName);
		assertTrue("The requests are not filtering correct", isOk);
	}

}