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
	
	@Steps
	public NewVacationRequestsSteps newVacationsSteps;

	@Steps
	LogOutSteps logOutSteps;
 
	@Test
    public void approve_chosen_requests() {
		
        endUser.is_the_home_page();
		endUser.login(Constants.Username, Constants.Userpassword);
		endUser.go_to_vacation_menu();
		
		newVacationsSteps.go_to_new_vacation_request_page();
		newVacationsSteps.create_a_new_vacation_without_payment(2, "November", 2015, 2, "November", 2015);
		
		logOutSteps.logOut();
		
		endUser.is_the_home_page();
		endUser.login(Constants.DMname,Constants.DMpassword);
		endUser.go_to_vacation_menu();
		
		approveUser.view_vacation_requests_assigned_to_me();
		approveUser.access_inbox_with_success();
		approveUser.approve_the_selected_request("Pop Irina","02/11/2015","02/11/2015","Vacation Without Payment");
 		vacationsSteps.go_to_view_vacations_page();
		vacationsSteps.check_if_the_desired_vacation_is_present("Pop Irina","02/11/2015","02/11/2015","Vacation Without Payment","Approved");
  }
	@After
	public void close_browser(){
		   pages.getDriver().close();
	}
	
  	@Test
  	public void reject_chosen_requests(){
  		 endUser.is_the_home_page();
 		endUser.login(Constants.DMname,Constants.DMpassword);
 		endUser.go_to_vacation_menu();
 		
 		newVacationsSteps.go_to_new_vacation_request_page();
		newVacationsSteps.create_a_new_vacation_without_payment(4, "November", 2015, 4, "November", 2015);
 		
		logOutSteps.logOut();
		
		endUser.is_the_home_page();
		endUser.login(Constants.DMname,Constants.DMpassword);
		endUser.go_to_vacation_menu();
		
		approveUser.view_vacation_requests_assigned_to_me();
 		approveUser.access_inbox_with_success();
 		approveUser.reject_the_selected_request("Pop Irina","04/11/2015","04/11/2015","Vacation Without Payment");
 		vacationsSteps.go_to_view_vacations_page();
 		vacationsSteps.check_if_the_desired_vacation_is_present("Pop Irina","04/11/2015","04/11/2015","Vacation Without Payment","Rejected");
  	}
	
   
}


