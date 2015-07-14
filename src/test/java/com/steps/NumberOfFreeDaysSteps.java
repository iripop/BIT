package com.steps;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.WebElement;

import com.pages.LogInPage;
import com.pages.MyFreeDaysPage;
import com.pages.MyRequestsPage;
import com.pages.NewVacationRequestPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;


import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

import net.thucydides.core.steps.ScenarioSteps;

public class NumberOfFreeDaysSteps extends ScenarioSteps {

	
	MyFreeDaysPage myFreeDaysPage;
	NewVacationRequestPage newVacationPage;
    @Step
    public void my_free_days_are_correct(){
    	boolean isEqual = myFreeDaysPage.my_free_days_from_new_vacation_request_are_equal_with_my_free_days_from_my_free_days_menu();
    	assertTrue("Is not equal",isEqual);
    }
  //  @Step
    public long dateDiffBetweenStartDateAndEndDate(int startDay,String startMonth,int startYear,int endDay,String endMonth,int endYear){
    	int selectedDays=0;
    	newVacationPage.choose_the_start_date(startDay, startMonth, endYear);
    	newVacationPage.choose_the_end_date(endDay, endMonth, endYear);
    	Date start = new GregorianCalendar(startYear, myFreeDaysPage.getMonth(startMonth), startDay).getTime();
    	Date end=new GregorianCalendar(endYear, myFreeDaysPage.getMonth(endMonth), endDay).getTime();
    	long diff = start.getTime()-end.getTime();

    	return diff;
    }
    @Step
    public void selected_business_days_are_correct(int startDay,String startMonth,int startYear,int endDay,String endMonth,int endYear){
    	boolean isEqual = false;
    	System.out.println(myFreeDaysPage.getSelectedBusinessDays());
    	System.out.println(dateDiffBetweenStartDateAndEndDate(startDay, startMonth, startYear, endDay, endMonth, endYear));
    	if(dateDiffBetweenStartDateAndEndDate(startDay, startMonth, startYear, endDay, endMonth, endYear)==myFreeDaysPage.getSelectedBusinessDays()) isEqual = true;
    	else isEqual = false;
    	assertTrue("Is not equal",isEqual);
    	
    }
    
}