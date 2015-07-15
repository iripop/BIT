package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.EndUserSteps;
import com.steps.NewVacationRequestsSteps;
import com.steps.NumberOfFreeDaysSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import tools.Constants;
import tools.Constants;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("/resources/data.csv")
// @RunWith(ThucydidesRunner.class)
public class MyFreeDaysTest {
	String username, password;

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;

	@Steps
	public NumberOfFreeDaysSteps myFreeDay;
	@Steps
	public EndUserSteps endUser;
	public NewVacationRequestsSteps newVacationUser;

	// @Test
	public void my_free_days() {
		endUser.is_the_home_page();

		endUser.login(username, password);
		endUser.go_to_vacation_menu();
		myFreeDay.my_free_days_are_correct();
	}

	@Test
	public void selected_business_days() {
		endUser.is_the_home_page();
		endUser.login(username, password);
		endUser.go_to_vacation_menu();
		newVacationUser.go_to_new_vacation_request_page();
		myFreeDay.selected_business_days_are_correct(14, "August", 2015, 17, "August", 2015);

	}
}