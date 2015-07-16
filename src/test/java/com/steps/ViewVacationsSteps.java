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

public class ViewVacationsSteps extends ScenarioSteps {

	

	LogInPage page;
	InboxPage inboxPage;
	ViewVacationsPage viewVacationsPage;
	@Step
	public void check_if_the_desired_vacation_is_present(String employeeName,String startDate,String endDate,String type,String status){
		boolean isPresent = viewVacationsPage.check_if_the_desired_request_was_approved_or_rejected(employeeName, startDate, endDate, type, status);
		assertTrue("Is not present",isPresent);
	}
	@Step
	public void go_to_view_vacations_page(){
		viewVacationsPage.access_the_view_vacations_menu();
	}
	
}