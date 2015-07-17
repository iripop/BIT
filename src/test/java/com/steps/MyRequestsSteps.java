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
	public void access_my_requests() {
		myRequestsPage.checkIfMyRequestsButtonExists();
		myRequestsPage.open_my_requests();
	}

	@Step
	public void filter_my_requests_step(String filter) {
		myRequestsPage.selectFiltersFromList(filter);

	}

	@Step
	public void check_filtering_my_requests_by_type(String selection) {
		myRequestsPage.checkIfTableIsFilteredByType(selection);
	}

	@Step
	public void check_filtering_my_requests_by_status(String selection) {
		myRequestsPage.checkIfTableIsFilteredByStatus(selection);
	}

	@Step
	public void check_filtering_my_requests_by_days_number(int nr1, int nr2) {
		myRequestsPage.checkIfTableIsFilteredByDaysNumber(nr1, nr2);
	}

	@Step
	public void apply_filter_requests() {
		myRequestsPage.clickApplyButtonForFilters();
	}

	@Step
	public void select_future_vacations() {
		myRequestsPage.clickShowFutureVacationsButton();
	}

	@Step


	public void check_if_desired_request_is_present(String type,String startDate,String endDate,String status){
		boolean found = myRequestsPage.check_if_desired_request_exists(type, startDate, endDate, status);
		assertTrue("Is not found",found);

	}
}