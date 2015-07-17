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
import com.steps.EndUserSteps;
import com.steps.MyRequestsSteps;
import com.steps.NewVacationRequestsSteps;

//@RunWith(ThucydidesRunner.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("/resources/data.csv")
public class CreateNewSickLeaveVacationRequestTest {
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
    public MyRequestsSteps myRequestsSteps;
    @Test
    public void create_a_new_sick_leave_request(){
    	endUser.is_the_home_page();
    	endUser.login(username, password);
    	endUser.go_to_vacation_menu();
        newVacationSteps.go_to_new_vacation_request_page();
        newVacationSteps.access_new_vacation_request_with_success();
    	newVacationSteps.create_a_new_sick_leave_request(19, "November", 2015, 19, "November", 2015);
        myRequestsSteps.access_my_requests();
        myRequestsSteps.check_if_desired_request_is_present("Sick Leave", "19/11/2015", "19/11/2015", "Sick Leave");
  
    }
 
} 