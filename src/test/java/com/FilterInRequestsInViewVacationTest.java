package com;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import com.steps.EndUserSteps;
import com.steps.ViewVacationsSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import tools.Constants;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SerenityRunner.class)
public class FilterInRequestsInViewVacationTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;
	@Steps
	public EndUserSteps endUser;

	@Steps
	public ViewVacationsSteps viewVacationsSteps;
	
	@Test
	public void filterMyRequestsFromViewVacations() {
		endUser.openHomePage();
		endUser.logInAsDM(Constants.DMname, Constants.DMpassword);
		endUser.goToVacationMenu();
		viewVacationsSteps.goToViewVacationsPage();
		viewVacationsSteps.filterMyRequestsStepInViewVacations("Approved");
		viewVacationsSteps.filterMyRequestsStepInViewVacations("Maternity Leave");
		viewVacationsSteps.filterMyRequestsStepInViewVacations("21 - 50");
		viewVacationsSteps.applyFilterRequests();
	}

	
}
