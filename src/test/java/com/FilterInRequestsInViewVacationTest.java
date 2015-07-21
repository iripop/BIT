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
public class FilterInRequestsInViewVacationTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;
	@Steps
	public EndUserSteps endUser;

	@Steps
	public ViewVacationsSteps viewVacationsSteps;
	
	@Test
	public void filter_my_requests_from_view_vacations_test() {
		endUser.openHomePage();
		endUser.logInAsDM(Constants.DMname, Constants.DMpassword);
		endUser.goToVacationMenu();
		viewVacationsSteps.go_to_view_vacations_page();
		viewVacationsSteps.filter_my_requests_step_in_view_vacations("Approved");
		viewVacationsSteps.filter_my_requests_step_in_view_vacations("Maternity Leave");
		viewVacationsSteps.filter_my_requests_step_in_view_vacations("21 - 50");
		viewVacationsSteps.apply_filter_requests();
	}

	
}
