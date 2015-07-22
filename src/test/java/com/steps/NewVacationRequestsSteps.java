package com.steps;

import com.pages.LogInPage;
import com.pages.NewVacationRequestPage;

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

public class NewVacationRequestsSteps extends ScenarioSteps {

	LogInPage logInPage;
	NewVacationRequestPage newVacationPage;

	@Step
	public void accessNewVacationRequestPage() {
		newVacationPage.clickNewVacationRequest();
	}

	@Step
	public void openNewVacationPage() {
		newVacationPage.open();
	}

	@Step
	public void accessNewVacationRequestWithSuccess() {
		boolean found = newVacationPage.checkIfSaveButtonIsPresent();
		assertTrue("Save button not found", found);
	}
	@Step
	public void checkIfNewRequestWasSavedWithSuccess(){
		boolean ok = newVacationPage.checkIfRequestWasSavedWithSuccess();
		assertTrue("Is not",ok);
	}

	@Step
	public void createNewSpecialVacationRequest(String text, String comment, int startDay, String startMonth,
			int startYear, int endDay, String endMonth, int endYear) {
		if (text.compareTo("Other") == 0) {
			newVacationPage.clickSpecialVacation();
			newVacationPage.selectSpecialVacationType(text);
			newVacationPage.addCommentRequiredAtSpecialVacation(text);
		} else {
			newVacationPage.clickSpecialVacation();
			newVacationPage.selectSpecialVacationType(text);

		}
		newVacationPage.chooseStartDate(startDay, startMonth, startYear);
		newVacationPage.chooseEndDate(endDay, endMonth, endYear);
		newVacationPage.clickSaveButton();
	}

	@Step
	public void createNewHolidayRequest(int startDay, String startMonth, int startYear, int endDay, String endMonth,
			int endYear) {
		newVacationPage.click_holiday();
		newVacationPage.chooseStartDate(startDay, startMonth, startYear);
		newVacationPage.chooseEndDate(endDay, endMonth, endYear);
		newVacationPage.clickSaveButton();
	}

	@Step
	public void createNewVacationWithoutPayment(int startDay, String startMonth, int startYear, int endDay,
			String endMonth, int endYear) {
		newVacationPage.clickVacationWithoutPayment();
		newVacationPage.chooseStartDate(startDay, startMonth, startYear);
		newVacationPage.chooseEndDate(endDay, endMonth, endYear);
		newVacationPage.clickSaveButton();
	}

	@Step
	public void createNewSickLeaveRequest(int startDay, String startMonth, int startYear, int endDay, String endMonth,
			int endYear) {
		newVacationPage.clickSickLeave();
		newVacationPage.chooseStartDate(startDay, startMonth, startYear);
		newVacationPage.chooseEndDate(endDay, endMonth, endYear);
		newVacationPage.clickSaveButton();
	}

	@Step
	public void createNewMaternityLeaveRequest(String text, int startDay, String startMonth, int startYear, int endDay,
			String endMonth, int endYear) {
		newVacationPage.clickMaternityLeave();
		newVacationPage.select_maternity_leave_type(text);
		newVacationPage.chooseStartDate(startDay, startMonth, startYear);
		newVacationPage.chooseEndDate(endDay, endMonth, endYear);
		newVacationPage.clickSaveButton();
	}
}