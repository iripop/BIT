package com.steps;

import static org.junit.Assert.assertTrue;

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
		page.sign_in();
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
		page.vacationMenu();
	}

	@Step
	public void log_in_with_succes() {
		boolean found = page.vacation_is_present();
		assertTrue("VacationMenu not found", found);
	}

	@Step
	public void access_my_requests() {
		myRequestsPage.checkIfMyRequestsExists();
		myRequestsPage.open_my_requests();
	}

	@Step
	public void filtering_my_requests(String filter) {
		myRequestsPage.selectFiletersFromList(filter);
		// myRequestsPage.selectFiletersFromList("Sick Leave");
		// myRequestsPage.selectFiletersFromList("Approved");

	}

	@Step
	public void check_filtering_my_requests(String selection) {
			myRequestsPage.checkIfTableIsFiltered(selection);
		}
		
		
	// @StepGroup
	// public void filtering_my_requests_group(String filter1, String filter2) {
	// filtering_my_requests(filter1);
	// filtering_my_requests(filter2);
	// }

	@Step
	public void apply_filter_requests() {
		myRequestsPage.apply_filters();
	}

	@Step
	public void select_future_vacations() {
		myRequestsPage.showFutureVacations();
	}

	@Step
	public void access_my_free_days() {
		myFreeDaysPage.checkIfMyFreeDaysExists();
		myFreeDaysPage.open_my_free_days();
	}

	@Step
	public void go_back_from_free_days() {
		myFreeDaysPage.goBack();
	}
}