package com.steps;

import com.pages.LogInPage;
import com.pages.NewVacationRequestPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import tools.Constants;

import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertTrue;

public class NewVacationRequestsSteps extends ScenarioSteps {

    LogInPage logInPage;
    NewVacationRequestPage newVacationPage;

    @Step
    public void go_to_new_vacation_request_page() {
    	newVacationPage.new_vacation_area();
    }
    @Step
    public void is_the_new_vacation_page() {
        newVacationPage.open();
    }
    @Step
    public void access_new_vacation_request_with_success(){
    	boolean found = newVacationPage.save_button_is_present();
    	assertTrue("Save button not found",found);
    }

 
    @Step
    public void create_a_new_special_vacation_request(String text,String comment,int startDay,String startMonth,int startYear,int endDay,String endMonth,int endYear){
    	if(text.compareTo("Other")==0){
    		newVacationPage.click_special_vacation();
        	newVacationPage.select_special_vacation_type(text);
        	newVacationPage.add_comment_required_at_apecial_vacation(comment);
        //	newVacationPage.choose_the_start_date(startDay,startMonth,startYear);
        //	newVacationPage.choose_the_end_date(endDay,endMonth,endYear);
        //	newVacationPage.save_request();
    	}
    	else{
    	newVacationPage.click_special_vacation();
    	newVacationPage.select_special_vacation_type(text);

    }
    	newVacationPage.choose_the_start_date(startDay,startMonth,startYear);
    	newVacationPage.choose_the_end_date(endDay,endMonth,endYear);
    	newVacationPage.click_save_button();
    	}

    @Step
    public void create_a_new_holiday_request(int startDay,String startMonth,int startYear,int endDay,String endMonth,int endYear){
    	newVacationPage.click_holiday();
    	newVacationPage.choose_the_start_date(startDay,startMonth,startYear);
    	newVacationPage.choose_the_end_date(endDay,endMonth,endYear);
    	newVacationPage.click_save_button();
    }
    @Step
    public void create_a_new_vacation_without_payment(int startDay,String startMonth,int startYear,int endDay,String endMonth,int endYear){
    	newVacationPage.click_vacation_without_payment();
    	newVacationPage.choose_the_start_date(startDay,startMonth,startYear);
    	newVacationPage.choose_the_end_date(endDay,endMonth,endYear);
    	newVacationPage.click_save_button();
    }
    @Step
    public void create_a_new_sick_leave_request(int startDay,String startMonth,int startYear,int endDay,String endMonth,int endYear){
    	newVacationPage.click_sick_leave();
    	newVacationPage.choose_the_start_date(startDay,startMonth,startYear);
    	newVacationPage.choose_the_end_date(endDay,endMonth,endYear);
    	newVacationPage.click_save_button();
    }
    @Step
    public void create_a_new_maternity_leave_request(String text,int startDay,String startMonth,int startYear,int endDay,String endMonth,int endYear){
    	newVacationPage.click_maternity_leave();
    	newVacationPage.select_maternity_leave_type(text);
    	newVacationPage.choose_the_start_date(startDay,startMonth,startYear);
    	newVacationPage.choose_the_end_date(endDay,endMonth,endYear);
    	newVacationPage.click_save_button();
    }
}