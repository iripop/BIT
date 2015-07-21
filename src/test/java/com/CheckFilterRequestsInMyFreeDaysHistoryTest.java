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
public class CheckFilterRequestsInMyFreeDaysHistoryTest {
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
			endUser.openHomePage();
	    	endUser.logInAsUser(Constants.DMname, Constants.DMpassword);
	    	endUser.goToVacationMenu();
			freeDaysHistorySteps.accessMyFreeDaysHistory();
		}
		
		

		@Test
		public void check_if_filter_is_correct() {
			endUser.openHomePage();
	    	endUser.logInAsUser(Constants.DMname, Constants.DMpassword);
	    	endUser.goToVacationMenu();
			freeDaysHistorySteps.accessMyFreeDaysHistory();
			freeDaysHistorySteps.filterRequestsInMyFreeDaysHistory("Vacation days");
			freeDaysHistorySteps.filterRequestsInMyFreeDaysHistory("1 - 5");
			freeDaysHistorySteps.filterRequestsInMyFreeDaysHistory("Added Days");
			freeDaysHistorySteps.clickApplyButtonForFiltersInMyFreeDaysHistory();
			freeDaysHistorySteps.checkFilteringRequestsByTypeInMyFreeDaysHistory("Vacation days");
			freeDaysHistorySteps.checkFilteringRequestsByDaysNumberInMyFreeDaysHistory(1, 5);
			freeDaysHistorySteps.checkFilteringRequestsByOperationInMyFreeDaysHistory("Added Days");
			

		}

}
