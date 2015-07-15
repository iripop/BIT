package com;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import com.steps.EndUserSteps;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.serenitybdd.junit.runners.SerenityRunner;
import tools.Constants;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SerenityRunner.class)
public class MyRequestsTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;

	@Steps
	public EndUserSteps endUser;

	@Ignore
	@Test
	public void enter_my_requests() {
		endUser.is_the_home_page();
		endUser.login(Constants.DMname, Constants.DMpassword);
		endUser.go_to_vacation_menu();
		endUser.log_in_with_succes();
		endUser.access_my_requests();
	}

	// @Ignore
	@Test
	public void filter_my_requests() {
		endUser.is_the_home_page();
		endUser.login(Constants.DMname, Constants.DMpassword);
		endUser.go_to_vacation_menu();
		endUser.log_in_with_succes();
		endUser.access_my_requests();
		endUser.filtering_my_requests("Approved ");
		endUser.filtering_my_requests("21 - 50 ");
		endUser.filtering_my_requests("Maternity Leave ");
		// endUser.filterWithMoreParameters("Approved", "Maternity Leave","Sick
		// Leave6");
		endUser.apply_filter_requests();
	}

	@Ignore
	@Test
	public void check_if_filter_is_correct() {
		endUser.is_the_home_page();
		endUser.login(Constants.DMname, Constants.DMpassword);
		endUser.go_to_vacation_menu();
		endUser.log_in_with_succes();
		endUser.access_my_requests();
		endUser.filtering_my_requests("Holiday");
		endUser.apply_filter_requests();
		endUser.check_filtering_my_requests("Holiday");

	}

	@Ignore
	@Test
	public void filter_my_requests_by_future_vacations() {
		endUser.is_the_home_page();
		endUser.login(Constants.DMname, Constants.DMpassword);
		endUser.go_to_vacation_menu();
		endUser.log_in_with_succes();
		endUser.access_my_requests();
		endUser.select_future_vacations();
		endUser.apply_filter_requests();

	}
}