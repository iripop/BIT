package com.steps;

import com.pages.LogInPage;
import com.pages.MyFreeDaysHistoryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MyFreeDaysHistorySteps extends ScenarioSteps{
   MyFreeDaysHistoryPage freeDaysHistoryPage;
   LogInPage page;
	@Step
	public void access_my_free_days_history() {
		freeDaysHistoryPage.checkIfMyFreeDaysHistoryButtonExists();
		freeDaysHistoryPage.open_my_requests();
	}

	@Step
	public void filter_my_requests_step_in_my_free_days_history(String filter) {
		freeDaysHistoryPage.selectFiltersFromListInMyFreeDaysHistory(filter);

	}

	@Step
	public void check_filtering_my_requests_by_type_in_my_free_days_history(String selection) {
		freeDaysHistoryPage.checkIfTableIsFilteredByTypeInMyFreeDaysHistory(selection);
	}
	
	@Step
	public void check_filtering_my_requests_by_operation_in_my_free_days_history(String selection) {
		freeDaysHistoryPage.checkIfTableIsFilteredByOperationInMyFreeDaysHistory(selection);
	}

	

	@Step
	public void check_filtering_my_requests_by_days_number_in_my_free_days_history(int nr1, int nr2) {
		freeDaysHistoryPage.checkIfTableIsFilteredByDaysNumberInMyFreeDaysHistory(nr1, nr2);
	}

	@Step
	public void apply_filter_requests_in_my_free_days_history() {
		freeDaysHistoryPage.clickApplyButtonForFilters();
	}

}
