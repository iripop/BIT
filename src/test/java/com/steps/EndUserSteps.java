package com.steps;

import com.pages.LogInPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertTrue;

public class EndUserSteps extends ScenarioSteps {

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
}