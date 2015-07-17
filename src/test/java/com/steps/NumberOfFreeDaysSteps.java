package com.steps;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.GregorianCalendar;

import com.pages.MyFreeDaysPage;
import com.pages.NewVacationRequestPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NumberOfFreeDaysSteps extends ScenarioSteps {

	
	MyFreeDaysPage myFreeDaysPage;
	NewVacationRequestPage newVacationPage;
    @Step
    public void my_free_days_are_correct(){
    	boolean isEqual = myFreeDaysPage.check_if_vacation_days_left_from_new_vacation_request_equal_with_my_free_days_from_my_free_days_menu();
    	assertTrue("Is not equal",isEqual);
    }

   
    @Step
    public void selected_business_days_are_correct(int startDay,String startMonth,int startYear,int endDay,String endMonth,int endYear){
 	
    	boolean isEqual = false;
    	if(newVacationPage.dateDiffBetweenStartDateAndEndDate(startDay, startMonth, startYear, endDay, endMonth, endYear)==myFreeDaysPage.checkSelectedBusinessDays()) isEqual = true;
    		else isEqual = false;
    	assertTrue("Is not equal",isEqual);
    	
    }
    
}