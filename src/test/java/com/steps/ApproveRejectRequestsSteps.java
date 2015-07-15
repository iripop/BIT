package com.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.WebElement;

import com.pages.LogInPage;
import com.pages.MyFreeDaysPage;
import com.pages.MyRequestsPage;
import com.pages.InboxPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class ApproveRejectRequestsSteps extends ScenarioSteps {

	

	LogInPage page;
	InboxPage inboxPage;
	@Step
	public void view_vacation_requests_assigned_to_me(){
		inboxPage.access_the_inbox_menu();
		
	}
	@Step
	public void access_inbox_with_success(){
		boolean found= false;
		found = inboxPage.approve_button_is_present();
		assertTrue("Approve button not found",found);
	}
	@Step
	public void check_first_request(){
		inboxPage.select_first_request();
	}
	@Step
	public void click_the_approve_button(){
		inboxPage.click_approve_button();
	}
	@Step
	public void click_the_reject_button(){
		inboxPage.click_reject_button();
	}
	@StepGroup
	public void approve_the_request(){
	//	view_vacation_requests_assigned_to_me();
		check_first_request();
		click_the_approve_button();
	}
	@StepGroup
	public void reject_the_request(){
	//	view_vacation_requests_assigned_to_me();
		check_first_request();
		click_the_reject_button();
	}
	@StepGroup
	public void approve_request_is_correct(){
		int beginNr = inboxPage.getNumberOfRequests();
		approve_the_request();
		boolean isEqual;
		int endNr = inboxPage.getNumberOfRequests();
		if(beginNr == endNr+1) isEqual = true;
		else isEqual = false;
		assertTrue("Is not equal",isEqual);
		inboxPage.access_the_view_vacations_menu();
		the_name_is_the_same();
		the_status_is_correct("Approved");
	}
	@StepGroup
	public void reject_request_is_correct(){
		int beginNr = inboxPage.getNumberOfRequests();
		reject_the_request();
		boolean isEqual;
		int endNr = inboxPage.getNumberOfRequests();
		if(beginNr == endNr+1) isEqual = true;
		else isEqual = false;
		assertTrue("Is not equal",isEqual);
		inboxPage.access_the_view_vacations_menu();
		the_name_is_the_same();
		the_status_is_correct("Rejected");
		
	}
	@Step
	public void the_name_is_the_same(){
		assertTrue("The name is not the same",inboxPage.is_name_the_same());
	}
	@Step
	public void the_status_is_correct(String status){
		if(status.compareTo("Rejected")==0) assertTrue("The status is not rejected",inboxPage.is_the_status_rejected());
		else assertTrue("The status is not approved",inboxPage.is_the_status_approved());
	}
	
}