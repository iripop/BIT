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
    public void create_a_new_holiday_vacation_request_with_current_date(){
    	newVacationPage.enable_holiday_radio();
    	newVacationPage.choose_the_start_date();
    	newVacationPage.save_request();
    }
    @Step
    public void create_a_new_vacation_without_payment_with_current_date(){
    	newVacationPage.enable_vacation_without_payment();
    	newVacationPage.save_request();
    }
    @Step
    public void create_a_new_sick_leave_vacation_request_with_current_date(){
    	newVacationPage.enable_sick_leave();
    	newVacationPage.save_request();
    }
    @Step
    public void create_a_new_special_vacation_request_with_current_date(String text,String comment){
    	if(text.compareTo("Other")==0){
    		newVacationPage.enable_special_vacation();
        	newVacationPage.select_special_vacation(text);
        	newVacationPage.add_comment_required_at_apecial_vacation(comment);
        	newVacationPage.save_request();
    	}
    	else{
    	newVacationPage.enable_special_vacation();
    	newVacationPage.select_special_vacation(text);
    	newVacationPage.save_request();
    }
    	}
    @Step
    public void create_a_new_maternity_leave_request_with_current_date(String text){
    	newVacationPage.enable_maternity_leave();
    	newVacationPage.select_maternity_leave(text);
    	newVacationPage.save_request();
    }

}