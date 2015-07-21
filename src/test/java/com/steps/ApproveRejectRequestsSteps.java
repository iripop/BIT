package com.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.WebElement;

import com.pages.LogInPage;
import com.pages.MyFreeDaysPage;
import com.pages.MyRequestsPage;
import com.pages.ViewVacationsPage;
import com.pages.InboxPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class ApproveRejectRequestsSteps extends ScenarioSteps {

	LogInPage page;
	InboxPage inboxPage;
	ViewVacationsPage viewVacationsPage;

	@Step
	public void viewVacationRequestsAssignedToMe() {
		inboxPage.clickInboxMenu();

	}

	@Step
	public void accessInboxWithSuccess() {
		boolean found = false;
		found = inboxPage.checkIfApproveButtonIsPresent();
		assertTrue("Approve button not found", found);
	}

	@Step
	public void selectVacationToApproveOrReject(String employeeName, String startDate, String endDate,
			String type) {
		inboxPage.selectRequestsToApproveOrReject(employeeName, startDate, endDate, type);
	}

	@Step
	public void clickTheApproveButton() {
		inboxPage.clickApproveButton();
	}

	@Step
	public void click_the_reject_button() {
		inboxPage.click_reject_button();
	}

	@StepGroup
	public void approveTheSelectedRequest(String employeeName, String startDate, String endDate, String type) {
		int beginNr = inboxPage.showNumberOfRequests();
		boolean isEqual;
		selectVacationToApproveOrReject(employeeName, startDate, endDate, type);
		clickTheApproveButton();
		int endNr = inboxPage.showNumberOfRequests();
		if (beginNr == endNr + 1)
			isEqual = true;
		else
			isEqual = false;
		assertTrue("Is not equal", isEqual);

	}

	@StepGroup
	public void rejectTheSelectedRequest(String employeeName, String startDate, String endDate, String type) {
		int beginNr = inboxPage.showNumberOfRequests();
		selectVacationToApproveOrReject(employeeName, startDate, endDate, type);
		click_the_reject_button();
		boolean isEqual;
		int endNr = inboxPage.showNumberOfRequests();
		if (beginNr == endNr + 1)
			isEqual = true;
		else
			isEqual = false;
		assertTrue("Is not equal", isEqual);
	}

}