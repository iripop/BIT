package com;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import com.steps.EndUserSteps;
import com.steps.MyRequestsSteps;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Step;
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
	@Steps
	public MyRequestsSteps myRequestsSteps;

	//@Test
	public void enter_my_requests() {
		endUser.is_the_home_page();
		endUser.login(Constants.DMname, Constants.DMpassword);
		endUser.go_to_vacation_menu();
		endUser.log_in_with_succes();
		myRequestsSteps.access_my_requests();
	}
	
	//@Test
	public void filter_my_requests_test() {
		endUser.is_the_home_page();
		endUser.login(Constants.DMname, Constants.DMpassword);
		endUser.go_to_vacation_menu();
		endUser.log_in_with_succes();
		myRequestsSteps.access_my_requests();
		myRequestsSteps.filter_my_requests_step("Approved");
		myRequestsSteps.filter_my_requests_step("Maternity Leave");
		myRequestsSteps.filter_my_requests_step("21 - 50");

		// myRequestsSteps.filterWithMoreParameters("Approved", "Maternity
		// Leave","Sick
		// Leave6");
		myRequestsSteps.apply_filter_requests();
	}

	@Test
	public void check_if_filter_is_correct() {
		endUser.is_the_home_page();
		endUser.login(Constants.DMname, Constants.DMpassword);
		endUser.go_to_vacation_menu();
		endUser.log_in_with_succes();
		myRequestsSteps.access_my_requests();
		myRequestsSteps.filter_my_requests_step("Holiday");
		myRequestsSteps.filter_my_requests_step("1 - 5");
		myRequestsSteps.filter_my_requests_step("Withdrawn");
		myRequestsSteps.apply_filter_requests();
		myRequestsSteps.check_filtering_my_requests_by_type("Holiday");
		myRequestsSteps.check_filtering_my_requests_by_days_number(1, 5);
		myRequestsSteps.check_filtering_my_requests_by_status("Withdrawn");
		// myRequestsSteps.checkfilterWithMoreParameters("Holiday", "1 - 5",
		// "Withdrawn");

	}

	//@Test
	public void filter_my_requests_by_future_vacations() {
		endUser.is_the_home_page();
		endUser.login(Constants.DMname, Constants.DMpassword);
		endUser.go_to_vacation_menu();
		endUser.log_in_with_succes();
		myRequestsSteps.access_my_requests();
		myRequestsSteps.select_future_vacations();
		myRequestsSteps.apply_filter_requests();

	}

	@After
	public void close_browser() {
		pages.getDriver().close();
	}
}