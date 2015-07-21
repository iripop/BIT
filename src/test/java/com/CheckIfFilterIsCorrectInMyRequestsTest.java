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
public class CheckIfFilterIsCorrectInMyRequestsTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;

	@Steps
	public EndUserSteps endUser;
	@Steps
	public MyRequestsSteps myRequestsSteps;

	@Test
	public void checkIfFilterIsCorrect() {
		endUser.openHomePage();
		endUser.logInAsDM(Constants.DMname, Constants.DMpassword);
		endUser.goToVacationMenu();
		myRequestsSteps.accessMyRequestsMenu();
		myRequestsSteps.filterMyRequestsStep("Holiday");
		myRequestsSteps.filterMyRequestsStep("1 - 5");
		myRequestsSteps.filterMyRequestsStep("Withdrawn");
		myRequestsSteps.applyFilterRequests();
		myRequestsSteps.checkFilteringMyRequestsByType("Holiday");
		myRequestsSteps.checkFilteringMyRequestsByDaysNumber(1, 5);
		myRequestsSteps.checkFilteringMyRequestsByStatus("Withdrawn");
		// myRequestsSteps.checkfilterWithMoreParameters("Holiday", "1 - 5",
		// "Withdrawn");

	}

	@After
	public void closeBrowser() {
		pages.getDriver().close();
	}
}