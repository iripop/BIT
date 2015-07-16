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
	public void enters_screen_name(String keyword) {
		page.enter_screen_name(keyword);
	}

	@Step
	public void enters_password(String keyword) {
		page.enter_password(keyword);
	}

	@Step
	public void starts_login() {
		page.click_sign_in();
	}

	@Step
	public void is_the_home_page() {
		getDriver().manage().window().maximize();
		page.open();

	}

	@StepGroup
	public void login(String name, String pass) {
		enters_screen_name(name);
		enters_password(pass);
		starts_login();
	}

	@Step
	public void go_to_vacation_menu() {
		page.clickVacationMenu();
	}

	@Step
	public void log_in_with_succes() {
		boolean found = page.vacation_tab_is_present();
		assertTrue("VacationMenu not found", found);
	}

	@Step
	public void access_my_requests() {
		myRequestsPage.checkIfMyRequestsExists();
		myRequestsPage.open_my_requests();
	}

	@Step
	public void filter_my_requests_step(String filter) {
		myRequestsPage.selectFiltersFromList(filter);

	}

	/*
	 * @Step public void filterWithMoreParameters(String... filters) {
	 * myRequestsPage.selectManyFiltersFromList(filters); }
	 */

	@Step
	public void check_if_my_requests_table_is_filtered_by_type(String selection) {
		myRequestsPage.checkIfTableIsFilteredByType(selection);

	}

	@Step
	public void check_if_my_requests_table_is_filtered_by_days_number(String selection) {
		myRequestsPage.checkIfTableIsFilteredByDaysNumber(selection);
	}

	@Step
	public void check_if_my_requests_table_is_filtered_by_status(String selection) {
		myRequestsPage.checkIfTableIsFilteredByStatus(selection);
	}

	@Step
	public void apply_filter_requests() {
		myRequestsPage.apply_filters();
	}

	@Step
	public void select_future_vacations() {
		myRequestsPage.showFutureVacations();
	}

	// @Step
	/*
	 * public void access_my_free_days() {
	 * myFreeDaysPage.checkIfMyFreeDaysExists();
	 * myFreeDaysPage.open_my_free_days(); }
	 * 
	 * @Step public void go_back_from_free_days() { myFreeDaysPage.goBack(); }
	 */
}