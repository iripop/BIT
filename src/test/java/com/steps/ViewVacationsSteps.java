package com.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.WebElement;

import com.pages.LogInPage;
import com.pages.MyFreeDaysPage;
import com.pages.MyRequestsPage;
import com.pages.ViewVacationsPage;
import com.pages.InboxPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class ViewVacationsSteps extends ScenarioSteps {

	
	LogInPage page;
	InboxPage inboxPage;
	ViewVacationsPage viewVacationsPage;
	@Step
	public void check_if_the_desired_vacation_is_present(String employeeName,String startDate,String endDate,String type,String status){
		boolean isPresent = viewVacationsPage.check_if_the_desired_request_was_approved_or_rejected(employeeName, startDate, endDate, type, status);
		assertTrue("Is not present",isPresent);
	}
	@Step
	public void go_to_view_vacations_page(){
		viewVacationsPage.click_the_view_vacations_menu();
	}
	@Step

	public void filter_my_requests_step_in_view_vacations(String filter) {
		 viewVacationsPage.selectFiltersFromListInViewVacations(filter);

	}

	@Step
	public void check_filtering_my_requests_by_type_in_view_vacations(String selection) {
         viewVacationsPage. checkIfTableIsFilteredByStatusInViewVacations(selection);
	}

	@Step
	public void check_filtering_my_requests_by_status_in_view_vacations(String selection) {
		viewVacationsPage.checkIfTableIsFilteredByStatusInViewVacations(selection);
	}

	@Step
	public void check_filtering_my_requests_by_days_number_in_view_vacations(int nr1, int nr2) {
		viewVacationsPage.checkIfTableIsFilteredByDaysNumberInViewVacations(nr1, nr2);
	}

	@Step
	public void apply_filter_requests() {
		viewVacationsPage.clickApplyButtonForFiltersInViewVacations();
	}

	public void type_first_name(String firstName){
		viewVacationsPage.enter_first_name(firstName);
	}
	@Step
	public void type_last_name(String lastName){
		viewVacationsPage.enter_last_name(lastName);
	}
	@Step
	public void click_apply_button(){
		viewVacationsPage.click_apply_button();
	}
	@StepGroup
	public void search_vacations_by_employee_name(String lastName,String firstName){
		type_first_name(firstName);
		type_last_name(lastName);
		click_apply_button();
		check_if_the_requests_are_filtering_correct(lastName, firstName);
	}
	@Step
	public void check_if_the_requests_are_filtering_correct(String lastName,String firstName){
		boolean isOk = viewVacationsPage.check_if_all_requests_from_the_table_are_with_the_given_name(lastName, firstName);
		assertTrue("The requests are not filtering correct",isOk);
	}

}