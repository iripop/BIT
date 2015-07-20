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

public class MyRequestsSteps extends ScenarioSteps {

	MyFreeDaysPage myFreeDaysPage;
	MyRequestsPage myRequestsPage;

	/*
	 * @Step public void filterWithMoreParameters(String... filters) {
	 * myRequestsPage.selectManyFiltersFromList(filters); }
	 */
	@Step
	public void accessMyRequestsMenu() {
		myRequestsPage.checkIfMyRequestsMenuExists();
		myRequestsPage.clickMyRequests();
	}

	@Step
	public void filterMyRequestsStep(String filter) {
		myRequestsPage.selectFiltersFromList(filter);

	}

	@Step
	public void checkFilteringMyRequestsByType(String selection) {
		myRequestsPage.checkIfTableIsFilteredByType(selection);
	}

	@Step
	public void checkFilteringMyRequestsByStatus(String selection) {
		myRequestsPage.checkIfTableIsFilteredByStatus(selection);
	}

	@Step
	public void checkFilteringMyRequestsByDaysNumber(int nr1, int nr2) {
		myRequestsPage.checkIfTableIsFilteredByDaysNumber(nr1, nr2);
	}

	@Step
	public void applyFilterRequests() {
		myRequestsPage.clickApplyButtonForFilters();
	}

	@Step
	public void selectFutureVacations() {
		myRequestsPage.clickShowFutureVacationsButton();
	}

	@Step
	public void checkIfDesiredRequestIsPresent(String type,String startDate,String endDate,String status){
		boolean found = myRequestsPage.checkIfDesiredRequestExists(type, startDate, endDate, status);
		assertTrue("Is not found",found);

	}
	@Step
	public void withdrawnVacationRequest(String type,String startDate,String endDate,String status){
		myRequestsPage.withdrawnDesiredRequest(type, startDate, endDate, status);
	}
}