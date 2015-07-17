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

import java.io.IOException;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.pages.NewVacationRequestPage;
import com.steps.ApproveRejectRequestsSteps;
import com.steps.EndUserSteps;
import com.steps.LogOutSteps;
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
    public ApproveRejectRequestsSteps approveRejectSteps;
    


	@Steps
	LogOutSteps logOutSteps;
    

    @Test
    public void verify_vacation_request_mail() throws IOException{
    	endUser.is_the_home_page();
    	endUser.login(Constants.Username, Constants.Userpassword);
    	endUser.go_to_vacation_menu();
    	newVacationSteps.go_to_new_vacation_request_page();
    	newVacationSteps.access_new_vacation_request_with_success();
    	newVacationSteps.create_a_new_holiday_request(1, "October", 2015, 1, "October", 2015);
    	emailSteps.check_if_user_receives_email_when_he_makes_a_request("Vacation Request", "01/10/2015", "01/10/2015");
    	emailSteps.check_if_user_receives_email_when_he_makes_a_request("Vacation Request", "01/10/2015", "01/10/2015");
    	emailSteps.check_if_the_receive_mail_is_correct_when_you_make_a_new_vacation_request(Constants.UserLastName, "01/10/2015","01/10/2015", "Vacation Request");
    }
    @Test
    public void verify_if_mail_sent_when_vacation_is_approved(){
    	endUser.is_the_home_page();
    	endUser.login(Constants.Username, Constants.Userpassword);
    	endUser.go_to_vacation_menu();
    	
    	newVacationSteps.go_to_new_vacation_request_page();
    	newVacationSteps.create_a_new_vacation_without_payment(21, "October",2015 , 21, "October", 2015);
    	
    	logOutSteps.logOut();
    	
    	endUser.is_the_home_page();
    	endUser.login(Constants.DMname, Constants.DMpassword);
    	endUser.go_to_vacation_menu();
    	approveRejectSteps.view_vacation_requests_assigned_to_me();
    	approveRejectSteps.access_inbox_with_success();
    	approveRejectSteps.approve_the_selected_request("Pop Irina","21/10/2015","21/10/2015","VacationWithoutPayment");
		emailSteps.receive_email_when_dm_approve("08/09/2015","08/09/2015");
    	emailSteps.check_if_the_received_mail_is_correct_when_you_has_approved_request("Pop", "21/October/2015", "21/October/2015","Vacation Request");

    }
    @Test
    public void verify_if_mail_sent_when_vacation_is_rejected(){
    	endUser.is_the_home_page();
    	endUser.login(Constants.Username, Constants.Userpassword);
    	endUser.go_to_vacation_menu();
    	
    	newVacationSteps.go_to_new_vacation_request_page();
    	newVacationSteps.create_a_new_vacation_without_payment(20, "October",2015 , 20, "October", 2015);
    	
    	logOutSteps.logOut();
    	
    	endUser.is_the_home_page();
    	endUser.login(Constants.DMname, Constants.DMpassword);
    	endUser.go_to_vacation_menu();
    	approveRejectSteps.view_vacation_requests_assigned_to_me();
    	approveRejectSteps.access_inbox_with_success();
    	approveRejectSteps.reject_the_selected_request("Pop Irina","20/10/2015","20/10/2015","Vacation Without Payment");
		emailSteps.receive_email_when_dm_reject("20/10/2015","20/10/2015");
		emailSteps.check_if_the_received_mail_is_correct_when_you_has_rejected_request("Pop", "20/October/2015", "20/October/2015", "Vacation Request");

    }
    @After
	public void close_browser(){
		   pages.getDriver().close();
	}
    
 
} 