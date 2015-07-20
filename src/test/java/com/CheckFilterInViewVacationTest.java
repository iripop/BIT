package com;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import com.steps.EndUserSteps;
import com.steps.ViewVacationsSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import tools.Constants;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SerenityRunner.class)
public class CheckFilterInViewVacationTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;
	@Steps
	public EndUserSteps endUser;

	@Steps
	public ViewVacationsSteps viewVacationsSteps;
	
	
	@Test
	public void check_if_filter_is_correct_in_view_vacation_page() {
		endUser.openHomePage();
		endUser.logInAsDM(Constants.DMname, Constants.DMpassword);
		endUser.goToVacationMenu();
		viewVacationsSteps.go_to_view_vacations_page();
		viewVacationsSteps.filter_my_requests_step_in_view_vacations("Holiday");
		viewVacationsSteps.filter_my_requests_step_in_view_vacations("1 - 5");
		viewVacationsSteps.filter_my_requests_step_in_view_vacations("Withdrawn");
		viewVacationsSteps.apply_filter_requests();
		viewVacationsSteps.check_filtering_my_requests_by_type_in_view_vacations("Holiday");
		viewVacationsSteps.check_filtering_my_requests_by_days_number_in_view_vacations(1, 5);
		viewVacationsSteps.check_filtering_my_requests_by_status_in_view_vacations("Withdrawn");

	}
}
