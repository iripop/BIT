package com;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;
import tools.Constants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.pages.NewVacationRequestPage;
import com.steps.EndUserSteps;
import com.steps.NewVacationRequestsSteps;

@RunWith(ThucydidesRunner.class)
public class CreateNewVacationRequestsTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;

	@Steps
	public EndUserSteps endUser;

	@Steps
	public NewVacationRequestsSteps newVacationSteps;

	@Test
	public void go_to_new_vacation_request() {
		endUser.is_the_home_page();
		endUser.login(Constants.name, Constants.password);
		endUser.go_to_vacation_menu();
		newVacationSteps.go_to_new_vacation_request_page();
		// newVacationSteps.access_new_vacation_request_with_success();\
		newVacationSteps.create_a_new_holiday_vacation_request_with_current_date();
	}

	// @Test
	public void create_a_new_holiday_request() {
		newVacationSteps.create_a_new_holiday_vacation_request_with_current_date();

	}

	// @Test
	public void create_a_new_vacation_without_payment_request() {
		newVacationSteps.create_a_new_vacation_without_payment_with_current_date();
	}

	// @Test
	public void create_a_new_sick_leave_request() {
		newVacationSteps.create_a_new_sick_leave_vacation_request_with_current_date();
	}

	// @Test
	public void create_a_new_FUNERAL_special_vacation_request() {
		newVacationSteps.create_a_new_special_vacation_request_with_current_date("Funeral", "");
	}

	// @Test
	public void create_a_new_MARRIAGE_special_vacation_request() {
		newVacationSteps.create_a_new_special_vacation_request_with_current_date("Marriage", "");
	}

	// @Test
	public void create_a_new_CHILDBIRTH_special_vacation_request() {
		newVacationSteps.create_a_new_special_vacation_request_with_current_date("Child birth", "");
	}

	// @Test
	public void create_a_new_OTHER_special_vacation_request() {
		newVacationSteps.create_a_new_special_vacation_request_with_current_date("Other", "Merg sa ma tund");
	}

	// @Test
	public void create_a_new_PRENATALPOSTNATAL_maternity_leave_vacation_request() {
		newVacationSteps.create_a_new_maternity_leave_request_with_current_date("Prenatal / Postnatal");
	}

	// @Test
	public void create_a_new_INGRIJIRECOPIL_maternity_leave_vacation_request() {
		newVacationSteps.create_a_new_maternity_leave_request_with_current_date("Concediu ingrijire copil");
	}
}