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

	@Ignore
	@Test
	public void filter_my_requests_test() {
		endUser.is_the_home_page();
		endUser.login(Constants.DMname, Constants.DMpassword);
		endUser.go_to_vacation_menu();
		endUser.log_in_with_succes();
		endUser.access_my_requests();
		endUser.filter_my_requests_step("Approved ");
		endUser.filter_my_requests_step("21 - 50 ");
		endUser.filter_my_requests_step("Maternity Leave ");
		// endUser.filterWithMoreParameters("Approved", "Maternity Leave","Sick
		// Leave6");
		endUser.apply_filter_requests();
	}

	// @Ignore
	@Test
	public void check_if_filter_is_correct() {
		endUser.is_the_home_page();
		endUser.login(Constants.DMname, Constants.DMpassword);
		endUser.go_to_vacation_menu();
		endUser.log_in_with_succes();
		endUser.access_my_requests();
		endUser.filter_my_requests_step("Holiday");
		//endUser.filter_my_requests_step("Special Vacation");
		endUser.filter_my_requests_step("1 - 5");
		endUser.filter_my_requests_step("Withdrawn");
		endUser.apply_filter_requests();
		//endUser.check_if_my_requests_table_is_filtered_by_type("Holiday");
		endUser.check_if_my_requests_table_is_filtered_by_days_number("1- 5");
		//endUser. check_if_my_requests_table_is_filtered_by_status("Withdrawn");
		//endUser.checkfilterWithMoreParameters("Holiday", "1 - 5", "Withdrawn");
		
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