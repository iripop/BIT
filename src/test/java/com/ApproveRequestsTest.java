package com;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.pages.ViewVacationsPage;
import com.steps.ApproveRejectRequestsSteps;
import com.steps.EndUserSteps;
import com.steps.LogOutSteps;
import com.steps.NewVacationRequestsSteps;
import com.steps.ViewVacationsSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesRunner;
import tools.Constants;

//@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom("/resources/data.csv")
@RunWith(ThucydidesRunner.class)
public class ApproveRequestsTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	String username, password;

	@ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;

	@Steps
	public EndUserSteps endUser;

	@Steps
	public ApproveRejectRequestsSteps approveUser;

	@Steps
	public ViewVacationsSteps vacationsSteps;

	@Steps
	public NewVacationRequestsSteps newVacationsSteps;

	@Steps
	LogOutSteps logOutSteps;

	@Test
	public void ApproveChosenRequests() {

		endUser.openHomePage();
		endUser.logInAsUser(Constants.Username, Constants.Userpassword);
		endUser.goToVacationMenu();

		newVacationsSteps.accessNewVacationRequestPage();
		newVacationsSteps.createNewVacationWithoutPayment(2, "November", 2015, 2, "November", 2015);

		logOutSteps.logOut();

		endUser.openHomePage();
		endUser.logInAsDM(Constants.DMname, Constants.DMpassword);
		endUser.goToVacationMenu();

		approveUser.viewVacationRequestsAssignedToMe();
		approveUser.accessInboxWithSuccess();
		approveUser.approveTheSelectedRequest("Pop Irina", "02/11/2015", "02/11/2015", "Vacation Without Payment");
		vacationsSteps.goToViewVacationsPage();
		vacationsSteps.checkIfTheDesiredVacationIsPresent("Pop Irina", "02/11/2015", "02/11/2015",
				"Vacation Without Payment", "Approved");
	}

	@After
	public void closeBrowser() {
		pages.getDriver().close();
	}

	
}
