package com.steps;

import com.pages.LogInPage;
import com.pages.NewVacationRequestPage;
import com.pages.TrackPage;

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

public class TrackSteps extends ScenarioSteps {

    LogInPage logInPage;
    TrackPage trackPage;

    @Step
    public void go_to_track_page() {
    	trackPage.go_to_track_page();
    }
    @Step
    public void access_track_page_with_success(){
    	boolean found = trackPage.apply_button_is_present();
    	assertTrue("Apply button not found",found);
    }
    @Step
    public void select_desired_department(String text){
    	trackPage.select_deparment(text);
    }
    @Step
    public void select_desired_building(String text){
    	trackPage.select_building(text);
    }
    @Step
    public void click_apply_button(){
    	trackPage.click_apply_button();
    }
    @Step
    public void select_desired_start_date(int day,String month,int year){
    	trackPage.choose_the_start_date(day, month, year);
    }
    @Step
    public void select_desired_end_date(int day,String month,int year){
    	trackPage.choose_the_end_date(day, month, year);
    }
    @StepGroup
    public void view_vacation_tracker(String building,String department,int startDay,String startMonth,int startYear,int endDay,String endMonth,int endYear){
   // 	select_desired_building(building);
   // 	select_desired_department(department);
    	select_desired_end_date(endDay, endMonth, endYear);
    	select_desired_start_date(startDay, startMonth, startYear);
    	click_apply_button();
   // 	check_if_vacation_dates_correspond_with_given_dates(startDay, startMonth, startYear, endDay, endMonth, endYear);
    }
    @Step
    public void check_if_vacation_dates_correspond_with_given_dates(int startDay,String startMonth,int startYear,int endDay,String endMonth,int endYear){
    	boolean isOk = trackPage.check_if_apply_button_makes_filters_correctly(startDay, startMonth, startYear, endDay, endMonth, endYear);
    	assertTrue("Vacation dates not correspond", isOk);
    }
   
}