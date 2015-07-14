package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.EndUserSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import tools.Constants;
@RunWith(SerenityRunner.class)

public class MyFreeDaysTest {
	@Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = Constants.defaultURL)
    public Pages pages;
    
    @Steps
    public EndUserSteps endUser;
    
    @Test
    public void enter_my_free_days_menu() {
    	endUser.is_the_home_page();
    	endUser.login(Constants.name, Constants.password);
    	endUser.go_to_vacation_menu();
    	endUser.log_in_with_succes();
    	endUser.access_my_free_days();
    	endUser.go_back_from_free_days();
}
}