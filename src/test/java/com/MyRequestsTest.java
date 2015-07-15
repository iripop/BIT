package com;

import org.junit.FixMethodOrder;
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

	@Test
	public void enter_my_requests() {
		endUser.is_the_home_page();
		endUser.login(Constants.DMname, Constants.DMpassword);
		endUser.go_to_vacation_menu();
		endUser.log_in_with_succes();
		endUser.access_my_requests();
	}

	@Test
	public void filter_my_requests() {
		// endUser.is_the_home_page();
		// endUser.login(Constants.name, Constants.password);
		// endUser.go_to_vacation_menu();
		// endUser.log_in_with_succes();
		// endUser.access_my_requests();
		endUser.filtering_my_requests("Holiday");
		endUser.filtering_my_requests("Approved");
		endUser.apply_filter_requests();
	}

	@Test
	public void check_if_filter_is_correct() {
		 //endUser.is_the_home_page();
		 //endUser.login(Constants.name, Constants.password);
		 //endUser.go_to_vacation_menu();
		 //endUser.log_in_with_succes();
		 //endUser.access_my_requests();
		 endUser.filtering_my_requests("Holiday");
		endUser.apply_filter_requests();
		endUser.check_filtering_my_requests("Holiday");

	}

	@Test
	public void filter_my_requests_by_future_vacations() {
		// endUser.is_the_home_page();
		// endUser.login(Constants.name, Constants.password);
		// endUser.go_to_vacation_menu();
		// endUser.log_in_with_succes();
		// endUser.access_my_requests();
		endUser.select_future_vacations();
		endUser.apply_filter_requests();

	}
}