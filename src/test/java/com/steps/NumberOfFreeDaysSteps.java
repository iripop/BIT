package com.steps;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.GregorianCalendar;

import com.pages.MyFreeDaysPage;
import com.pages.NewVacationRequestPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NumberOfFreeDaysSteps extends ScenarioSteps {

	MyFreeDaysPage myFreeDaysPage;
	NewVacationRequestPage newVacationPage;

	@Step
	public void checkIfMyFreeDaysAreCalculatedCorectly() {
		boolean isEqual = myFreeDaysPage
				.checkIfVacationDaysLeftFromNewVacationRequestEqualWithMyFreeDaysFromMyFreeDaysMenu();
		assertTrue("Is not equal", isEqual);
	}

	@Step
	public void selectedBusinessDaysAreCorrect(int startDay, String startMonth, int startYear, int endDay,
			String endMonth, int endYear) {

		boolean isEqual = false;
		if (newVacationPage.dateDiffBetweenStartDateAndEndDate(startDay, startMonth, startYear, endDay, endMonth,
				endYear) == myFreeDaysPage.checkIfSelectedBusinessDaysCalculatedCorrectly())
			isEqual = true;
		else
			isEqual = false;
		assertTrue("Is not equal", isEqual);

	}

}