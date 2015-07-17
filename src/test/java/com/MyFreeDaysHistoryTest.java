package com;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import com.steps.EndUserSteps;
import com.steps.MyFreeDaysHistorySteps;
import com.steps.MyRequestsSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import tools.Constants;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SerenityRunner.class)
public class MyFreeDaysHistoryTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;

	@Steps
	public EndUserSteps endUser;
	@Steps
	public MyFreeDaysHistorySteps freeDaysHistorySteps;
	
	//@Test
		public void enter_my_requests() {
			endUser.is_the_home_page();
			endUser.login(Constants.DMname, Constants.DMpassword);
			endUser.go_to_vacation_menu();
			endUser.log_in_with_succes();
			freeDaysHistorySteps.access_my_free_days_history();
		}
		
		//@Test
		public void filter_my_requests_test() {
			endUser.is_the_home_page();
			endUser.login(Constants.DMname, Constants.DMpassword);
			endUser.go_to_vacation_menu();
			endUser.log_in_with_succes();
			freeDaysHistorySteps.access_my_free_days_history();
			freeDaysHistorySteps.filter_my_requests_step_in_my_free_days_history("Vacation days");
			freeDaysHistorySteps.filter_my_requests_step_in_my_free_days_history("Vacation Without Payment ");
			freeDaysHistorySteps.filter_my_requests_step_in_my_free_days_history("21 - 50");
			freeDaysHistorySteps.apply_filter_requests_in_my_free_days_history() ;
		}

		@Test
		public void check_if_filter_is_correct() {
			endUser.is_the_home_page();
			endUser.login(Constants.DMname, Constants.DMpassword);
			endUser.go_to_vacation_menu();
			endUser.log_in_with_succes();
			freeDaysHistorySteps.access_my_free_days_history();
			freeDaysHistorySteps.filter_my_requests_step_in_my_free_days_history("Vacation days");
			freeDaysHistorySteps.filter_my_requests_step_in_my_free_days_history("1 - 5");
			freeDaysHistorySteps.filter_my_requests_step_in_my_free_days_history("Added Days");
			freeDaysHistorySteps.apply_filter_requests_in_my_free_days_history() ;
			freeDaysHistorySteps.check_filtering_my_requests_by_type_in_my_free_days_history("Vacation days");
			freeDaysHistorySteps.check_filtering_my_requests_by_days_number_in_my_free_days_history(1, 5);
			freeDaysHistorySteps.check_filtering_my_requests_by_operation_in_my_free_days_history("Added Days");
			

		}

}
