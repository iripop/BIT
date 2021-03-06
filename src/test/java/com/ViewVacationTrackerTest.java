package com;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesRunner;
import tools.Constants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.pages.NewVacationRequestPage;
import com.steps.EndUserSteps;
import com.steps.NewVacationRequestsSteps;
import com.steps.TrackSteps;

//@RunWith(ThucydidesRunner.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("/resources/data.csv")
public class ViewVacationTrackerTest {
	String username, password;
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;

	@Steps
	public EndUserSteps endUser;

	@Steps
	public TrackSteps trackSteps;

	@Steps
	public NewVacationRequestsSteps newVacationSteps;

	@Test
	public void viewVacationTracker() {
		endUser.openHomePage();
		endUser.logInAsUser(username, password);
		endUser.goToVacationMenu();
		trackSteps.goToTrackPage();
		trackSteps.accessTrackPageWithSuccess();
		trackSteps.viewVacationTracker("Beta Building", "DM Department", 07, "July", 2015, 23, "July", 2015);

	}

}