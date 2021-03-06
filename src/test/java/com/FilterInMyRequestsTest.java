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
public class FilterInMyRequestsTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;

	@Steps
	public EndUserSteps endUser;
	@Steps
	public MyRequestsSteps myRequestsSteps;

	@Test
	public void filterMyRequests() {
		endUser.openHomePage();
		endUser.logInAsDM(Constants.DMname, Constants.DMpassword);
		endUser.goToVacationMenu();
		myRequestsSteps.accessMyRequestsMenu();
		myRequestsSteps.filterMyRequestsStep("Approved");
		myRequestsSteps.filterMyRequestsStep("Maternity Leave");
		myRequestsSteps.filterMyRequestsStep("21 - 50");
		myRequestsSteps.applyFilterRequests();
	}

	@After
	public void closeBrowser() {
		pages.getDriver().close();
	}
}