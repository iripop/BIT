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
public class VerifyIfMailSentWhenVacationIsRejectedTest {
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
    public void verify_if_mail_sent_when_vacation_is_rejected(){
    	endUser.openHomePage();
    	endUser.logInAsUser(Constants.Username, Constants.Userpassword);
    	endUser.goToVacationMenu();
    	newVacationSteps.accessNewVacationRequestPage();
    	newVacationSteps.createNewVacationWithoutPayment(2, "December",2015 , 2, "December", 2015);
    	
    	logOutSteps.logOut();
    	
    	endUser.openHomePage();
    	endUser.logInAsUser(Constants.DMname, Constants.DMpassword);
    	endUser.goToVacationMenu();
    	approveRejectSteps.view_vacation_requests_assigned_to_me();
    	approveRejectSteps.access_inbox_with_success();
    	approveRejectSteps.reject_the_selected_request("Pop Irina","02/12/2015","02/12/2015","Vacation Without Payment");
		emailSteps.check_if_the_received_mail_is_correct_when_you_has_rejected_request("Pop", "2/December/2015", "2/December/2015", "Vacation Request");
    	emailSteps.check_if_dm_receives_the_correct_email_when_request_rejected(Constants.DMlastName, "2/December/2015", "2/December/2015", "Vacation Request");
    }
    @After
	public void close_browser(){
		   pages.getDriver().close();
	}
    
 
} 