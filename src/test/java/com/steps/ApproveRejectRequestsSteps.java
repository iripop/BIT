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
	public void search(String employeeName,String startDate,String endDate,String type){
		inboxPage.search_request(employeeName, startDate, endDate, type);
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
	public void approve_the_request(String employeeName,String startDate,String endDate,String type){
		int beginNr = inboxPage.getNumberOfRequests();
		boolean isEqual;
		search(employeeName, startDate, endDate, type);
		click_the_approve_button();
		int endNr = inboxPage.getNumberOfRequests();
		if(beginNr == endNr+1) isEqual = true;
		else isEqual = false;
		assertTrue("Is not equal",isEqual);
		
		
	}
	@StepGroup
	public void reject_the_request(String employeeName,String startDate,String endDate,String type){
		int beginNr = inboxPage.getNumberOfRequests();
		search(employeeName, startDate, endDate, type);
		click_the_reject_button();
		boolean isEqual;
		int endNr = inboxPage.getNumberOfRequests();
		if(beginNr == endNr+1) isEqual = true;
		else isEqual = false;
		assertTrue("Is not equal",isEqual);
	}
	
	
	
}