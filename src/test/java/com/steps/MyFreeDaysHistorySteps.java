package com.steps;

import com.pages.LogInPage;
import com.pages.MyFreeDaysHistoryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MyFreeDaysHistorySteps extends ScenarioSteps{
   MyFreeDaysHistoryPage freeDaysHistoryPage;
   LogInPage page;
	@Step
	public void accessMyFreeDaysHistory() {
		freeDaysHistoryPage.checkIfMyFreeDaysHistoryMenuExists();
		freeDaysHistoryPage.clickMyFreeDaysHistoryMenu();
	}

	@Step
	public void filterRequestsInMyFreeDaysHistory(String filter) {
		freeDaysHistoryPage.selectFiltersFromListInMyFreeDaysHistory(filter);

	}

	@Step
	public void checkFilteringRequestsByTypeInMyFreeDaysHistory(String selection) {
		freeDaysHistoryPage.checkIfTableIsFilteredByTypeInMyFreeDaysHistory(selection);
	}
	
	@Step
	public void checkFilteringRequestsByOperationInMyFreeDaysHistory(String selection) {
		freeDaysHistoryPage.checkIfTableIsFilteredByOperationInMyFreeDaysHistory(selection);
	}

	

	@Step
	public void checkFilteringRequestsByDaysNumberInMyFreeDaysHistory(int nr1, int nr2) {
		freeDaysHistoryPage.checkIfTableIsFilteredByDaysNumberInMyFreeDaysHistory(nr1, nr2);
	}

	@Step
	public void clickApplyButtonForFiltersInMyFreeDaysHistory() {
		freeDaysHistoryPage.clickApplyButtonForFilters();
	}

}
