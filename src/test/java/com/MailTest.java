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
import com.steps.ApproveRejectRequestsSteps;
import com.steps.EndUserSteps;
import com.steps.NewVacationRequestsSteps;
import com.steps.ReadingEmail;

@RunWith(ThucydidesRunner.class)
//@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom("/resources/data.csv")
public class MailTest {
	String username,password;
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = Constants.defaultURL)
    public Pages pages;
    
    @Steps
    public EndUserSteps endUser;
    
    @Steps
    public NewVacationRequestsSteps newVacationSteps;
   
    @Steps
    public ReadingEmail emailSteps;
    
    @Steps
    public ApproveRejectRequestsSteps approveSteps;

   // @Test
    public void vacation_request_mail(){
    	endUser.is_the_home_page();
    	endUser.login(Constants.Username, Constants.Userpassword);
    	endUser.go_to_vacation_menu();
    	newVacationSteps.go_to_new_vacation_request_page();
    	newVacationSteps.access_new_vacation_request_with_success();
    	newVacationSteps.create_a_new_holiday_request(24, "August", 2015, 24, "August", 2015);
    	String msg1 = emailSteps.check_if_the_request_was_made("Vacation Request", "24/08/2015", "24/08/2015");
    	System.out.println(msg1);
    	String msg2 = emailSteps.check_if_user_have_email("Vacation Request", "24/08/2015", "24/08/2015");
    	System.out.println(msg2);
    }
  //  @Test
    public void vacation_approved_mail(){
    	endUser.is_the_home_page();
    	endUser.login(Constants.DMname, Constants.DMpassword);
    	endUser.go_to_vacation_menu();
		approveSteps.view_vacation_requests_assigned_to_me();
		approveSteps.access_inbox_with_success();
	//	approveUser.approve_the_request();
		approveSteps.approve_request_is_correct();
    

    }
    @Test
    public void vacation_rejected_mail(){
    	endUser.is_the_home_page();
    	endUser.login(Constants.DMname, Constants.DMpassword);
    	endUser.go_to_vacation_menu();
		approveSteps.view_vacation_requests_assigned_to_me();
		approveSteps.access_inbox_with_success();
	//	approveUser.approve_the_request();
		approveSteps.reject_request_is_correct();
    

    }
    
 
} 