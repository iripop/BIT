package com;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;
import tools.Constants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.pages.NewVacationRequestPage;
import com.steps.EndUserSteps;
import com.steps.NewVacationRequestsSteps;

@RunWith(ThucydidesRunner.class)
public class CreateNewSpecialVacationRequestTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = Constants.defaultURL)
    public Pages pages;
    
    @Steps
    public EndUserSteps endUser;
    
    @Steps
    public NewVacationRequestsSteps newVacationSteps;
   

    @Test
    public void create_a_new_marriage_request(){
    //	endUser.is_the_home_page();
    //	endUser.login(Constants.name, Constants.password);
    //	endUser.go_to_vacation_menu();
        newVacationSteps.go_to_new_vacation_request_page();
        newVacationSteps.access_new_vacation_request_with_success();
        newVacationSteps.create_a_new_special_vacation_request("Marriage", "", 12, "August", 2015, 13, "August", 2015);
  
    }
    @Test
    public void create_a_new_childBirth_request(){
    	endUser.is_the_home_page();
    	endUser.login(Constants.DMname, Constants.DMpassword);
    	endUser.go_to_vacation_menu();
        newVacationSteps.go_to_new_vacation_request_page();
        newVacationSteps.access_new_vacation_request_with_success();
        newVacationSteps.create_a_new_special_vacation_request("Child birth", "", 28, "July", 2015, 29, "July", 2015);
  
    }
    @Test
    public void create_a_new_funeral_request(){
    //	endUser.is_the_home_page();
    //	endUser.login(Constants.name, Constants.password);
    //	endUser.go_to_vacation_menu();
        newVacationSteps.go_to_new_vacation_request_page();
        newVacationSteps.access_new_vacation_request_with_success();
        newVacationSteps.create_a_new_special_vacation_request("Funeral", "", 17, "August", 2015, 18, "August", 2015);
  
    }
    @Test
    public void create_a_new_other_request(){
    //	endUser.is_the_home_page();
    //	endUser.login(Constants.name, Constants.password);
    //	endUser.go_to_vacation_menu();
        newVacationSteps.go_to_new_vacation_request_page();
        newVacationSteps.access_new_vacation_request_with_success();
        newVacationSteps.create_a_new_special_vacation_request("Other", "I need sleep", 19, "August", 2015, 20, "August", 2015);
  
    }
 
} 