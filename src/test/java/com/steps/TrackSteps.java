package com.steps;

import com.pages.LogInPage;
import com.pages.NewVacationRequestPage;
import com.pages.TrackPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import tools.Constants;

import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertTrue;

public class TrackSteps extends ScenarioSteps {

	LogInPage logInPage;
	TrackPage trackPage;

	@Step
	public void goToTrackPage() {
		trackPage.clickTrackMenu();
	}

	@Step
	public void accessTrackPageWithSuccess() {
		boolean found = trackPage.checkIfApplyButtonIsPresent();
		assertTrue("Apply button not found", found);
	}

	@Step
	public void selectDesiredDepartment(String text) {
		trackPage.selectDeparment(text);
	}

	@Step
	public void selectDesiredBuilding(String text) {
		trackPage.selectBuilding(text);
	}

	@Step
	public void applyButton() {
		trackPage.clickApplyButton();
	}

	@Step
	public void selectDesiredStartDate(int day, String month, int year) {
		trackPage.chooseStartDate(day, month, year);
	}

	@Step
	public void selectDesiredEndDate(int day, String month, int year) {
		trackPage.chooseEndDate(day, month, year);
	}

	@StepGroup
	public void viewVacationTracker(String building, String department, int startDay, String startMonth,
			int startYear, int endDay, String endMonth, int endYear) {
		// select_desired_building(building);
		// select_desired_department(department);
		selectDesiredEndDate(endDay, endMonth, endYear);
		selectDesiredStartDate(startDay, startMonth, startYear);
		applyButton();
		// check_if_vacation_dates_correspond_with_given_dates(startDay,
		// startMonth, startYear, endDay, endMonth, endYear);
	}

	@Step
	public void checkIfVacationDatesCorrespondWithGivenDates(int startDay, String startMonth, int startYear, int endDay,
			String endMonth, int endYear) {
		boolean isOk = trackPage.checkIfFiltersAreCorrect(startDay, startMonth, startYear, endDay, endMonth, endYear);
		assertTrue("Vacation dates not correspond", isOk);
	}

}