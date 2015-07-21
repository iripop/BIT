package com;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.pages.ViewVacationsPage;
import com.steps.ApproveRejectRequestsSteps;
import com.steps.EndUserSteps;
import com.steps.ViewVacationsSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesRunner;
import tools.Constants;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("/resources/data.csv")
// @RunWith(ThucydidesRunner.class)
public class SearchVacationsByEmployeeNameTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	String username, password;

	@ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;

	@Steps
	public EndUserSteps endUser;

	@Steps
	public ViewVacationsSteps vacationsSteps;

	@Test
	public void searchVacationsByEmployeeName() {

		endUser.openHomePage();
		endUser.logInAsDM(Constants.DMname, Constants.DMpassword);
		endUser.goToVacationMenu();
		vacationsSteps.goToViewVacationsPage();
		vacationsSteps.searchVacationsByEmployeeName("Irina", "Pop");

		vacationsSteps.checkIfTheRequestsAreFilteringCorrect("Irina", "Pop");
	}

	@After
	public void closeBrowser() {
		pages.getDriver().close();
	}

}
