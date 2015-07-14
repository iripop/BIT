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
public class CreateNewMaternityLeaveVacationRequestTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = Constants.defaultURL)
    public Pages pages;
    
    @Steps
    public EndUserSteps endUser;
    
    @Steps
    public NewVacationRequestsSteps newVacationSteps;
   

    @Test
    public void create_a_new_prenatalPostnatal_request(){
    //	endUser.is_the_home_page();
    //	endUser.login(Constants.name, Constants.password);
    //	endUser.go_to_vacation_menu();
        newVacationSteps.go_to_new_vacation_request_page();
        newVacationSteps.access_new_vacation_request_with_success();
        newVacationSteps.create_a_new_maternity_leave_request("Prenatal / Postnatal", 12, "August", 2015, 13, "August", 2015);
  
    }
    @Test
    public void create_a_new_concediu_ingrijire_copii_request(){
    	endUser.is_the_home_page();
    	endUser.login(Constants.name, Constants.password);
    	endUser.go_to_vacation_menu();
        newVacationSteps.go_to_new_vacation_request_page();
        newVacationSteps.access_new_vacation_request_with_success();
        newVacationSteps.create_a_new_maternity_leave_request("Concediu Ingrijire Copil", 28, "July", 2015, 29, "July", 2015);
  
    }
  
  
 
} 