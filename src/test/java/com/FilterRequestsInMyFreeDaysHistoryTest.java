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
public class FilterRequestsInMyFreeDaysHistoryTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;

	@Steps
	public EndUserSteps endUser;
	@Steps
	public MyFreeDaysHistorySteps freeDaysHistorySteps;
	
	
		
		@Test
		public void filter_my_requests_test() {
			endUser.openHomePage();
	    	endUser.logInAsUser(Constants.DMname, Constants.DMpassword);
	    	endUser.goToVacationMenu();
			freeDaysHistorySteps.accessMyFreeDaysHistory();
			freeDaysHistorySteps.filterRequestsInMyFreeDaysHistory("Vacation days");
			freeDaysHistorySteps.filterRequestsInMyFreeDaysHistory("Vacation Without Payment ");
			freeDaysHistorySteps.filterRequestsInMyFreeDaysHistory("21 - 50");
			freeDaysHistorySteps.clickApplyButtonForFiltersInMyFreeDaysHistory();
		}

		

}
