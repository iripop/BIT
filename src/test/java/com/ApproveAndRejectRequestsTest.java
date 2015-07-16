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
//@RunWith(ThucydidesRunner.class)
public class ApproveAndRejectRequestsTest {


	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	String username,password;
	
   @ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;

	@Steps
	public EndUserSteps endUser;
	
	@Steps
	public ApproveRejectRequestsSteps approveUser;
	
	@Steps
	public ViewVacationsSteps vacationsSteps;

  @Test
    public void approve_request() {
		
        endUser.is_the_home_page();
		endUser.login(username, password);
		endUser.go_to_vacation_menu();
		approveUser.view_vacation_requests_assigned_to_me();
		approveUser.access_inbox_with_success();
		approveUser.approve_the_request("Pop Irina","08/09/2015","08/09/2015","Vacation Without Payment");
 		vacationsSteps.go_to_view_vacations_page();
		vacationsSteps.check_if_the_desired_vacation_is_present("Pop Irina","08/09/2015","08/09/2015","Vacation Without Payment","Approved");
  }
	@After
	public void close_browser(){
		   pages.getDriver().close();
	}
	
  	@Test
  	public void reject_request(){
  		 endUser.is_the_home_page();
 		endUser.login(username, password);
 		endUser.go_to_vacation_menu();
 		approveUser.view_vacation_requests_assigned_to_me();
 		approveUser.access_inbox_with_success();
 		approveUser.reject_the_request("Pop Irina","19/10/2015","19/10/2015","Vacation Without Payment");
 		vacationsSteps.go_to_view_vacations_page();
 		vacationsSteps.check_if_the_desired_vacation_is_present("Pop Irina","19/10/2015","19/10/2015","Vacation Without Payment","Rejected");
  	}
	
   
}


