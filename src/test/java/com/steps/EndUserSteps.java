package com.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;

import com.pages.LogInPage;

import com.pages.MyRequestsPage;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;


import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

import net.thucydides.core.steps.ScenarioSteps;

public class EndUserSteps extends ScenarioSteps {

	
	MyRequestsPage myRequestsPage;
    LogInPage page;
    @Step
    public void enters_screen_name(String keyword) {
    	page.enter_screen_name(keyword);
    }

    @Step
    public void enters_password(String keyword) {
    	page.enter_password(keyword);
    }
    @Step
    public void starts_login() {
        page.sign_in();
    }


    @Step
    public void is_the_home_page() {
    	getDriver().manage().window().maximize();
        page.open();


    }

    @StepGroup
    public void login(String name,String pass) {
        enters_screen_name(name);
        enters_password(pass);
        starts_login();
    }
    @Step
    public void go_to_vacation_menu(){
    	page.vacationMenu();
    }
    @Step
    public void log_in_with_succes(){
    	boolean found = page.vacation_is_present();
    	assertTrue("VacationMenu not found",found );
    }

    @Step
    public void access_my_requests() {
    	myRequestsPage.checkIfMyRequestsExists();
    	myRequestsPage.open_my_requests();
    }
    	 @Step
    public void filtering_my_requests() {
    	    	myRequestsPage.selectFiletersFromList("Holiday");
    	    	//myRequestsPage.selectFiletersFromList("Sick Leave");
    	    	//myRequestsPage.selectFiletersFromList("Approved");
    	    	
    	    	 }
    	 @Step
    public void apply_filter_requests() {
    	    	myRequestsPage.apply_filters();
    	    }
    	 @Step
    public void select_future_vacations() {
    	    	    	myRequestsPage.showFutureVacations() ;
    	    	    }


}