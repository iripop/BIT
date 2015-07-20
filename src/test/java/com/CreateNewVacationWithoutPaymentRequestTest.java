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
public class CreateNewVacationWithoutPaymentRequestTest {
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
    public void create_a_new_vacation_without_payment_request(){
    	endUser.openHomePage();
    	endUser.logInAsUser(username, password);
    	endUser.goToVacationMenu();
    	newVacationSteps.accessNewVacationRequestPage();
        newVacationSteps.accessNewVacationRequestWithSuccess();
    	newVacationSteps.createNewVacationWithoutPayment(23, "November", 2015, 25, "November", 2015);
        myRequestsSteps.accessMyRequestsMenu();
        myRequestsSteps.checkIfDesiredRequestIsPresent("Vacation Without Payment", "23/08/2015", "25/09/2015", "Pending");
  
    }
 
} 