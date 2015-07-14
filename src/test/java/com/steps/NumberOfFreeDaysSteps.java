package com.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;

import com.pages.LogInPage;
import com.pages.MyFreeDaysPage;
import com.pages.MyRequestsPage;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;


import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

import net.thucydides.core.steps.ScenarioSteps;

public class NumberOfFreeDaysSteps extends ScenarioSteps {

	
	MyFreeDaysPage myFreeDaysPage;
    @Step
    public void my_free_days_is_correct(){
    	boolean isEqual = myFreeDaysPage.my_free_days_from_new_vacation_request_is_equal_with_my_free_days_from_my_free_days_menu();
    	assertTrue("Is not equal",isEqual);
    }
}