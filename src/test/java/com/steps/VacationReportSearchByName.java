package com.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.pages.LogInPage;
import com.pages.MyFreeDaysPage;
import com.pages.MyRequestsPage;
import com.pages.VacationsReportPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class VacationReportSearchByName extends ScenarioSteps {

	
	LogInPage page;
	VacationsReportPage reportPage;
	@Step
	public void enter_last_name(String name){
		reportPage.enterLastName(name);
	}
	@Step
	public void enter_first_name(String name){
		reportPage.enterFirstName(name);
	}
	@Step
	public void search(){
		reportPage.clickSearchButton();
	}
	@StepGroup
	public void search_by_last_name_and_first_name(String lastName,String firstName){
		enter_first_name(firstName);
		enter_last_name(lastName);
		search();
	}
	@Step
	public void go_to_vacation_report_with_success(){
		boolean found=false;
		found = reportPage.checkIfSearchButtonIsPresent();
		assertTrue("Search button is Not found",found);
	}
	@Step
	public void view_vacation_report(){
		reportPage.clickVacationsReportMenu();
	}
	@Step
	public void check_if_last_name_is_correct(String lastName){
		assertTrue("Last name Is not correct",reportPage.checkIfLastnameFromTableIsTheSameAsIntroduced(lastName));
	}
	@Step
	public void check_if_first_name_is_correct(String firstName){
		assertTrue("First name Is not correct",reportPage.checkfIfFirstNameFromTableIsTheSameAsIntroduced(firstName));
	}
}