package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.EndUserSteps;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import tools.Constants;

@RunWith(ThucydidesRunner.class)
public class LogInTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = Constants.defaultURL)
    public Pages pages;

    @Steps
    public EndUserSteps endUser;
 // @Test
    public void log_in() {
        endUser.is_the_home_page();
		endUser.login(Constants.name, Constants.password);
      
    }
  // @Test
  public void vacationMenu(){
  	endUser.go_to_vacation_menu();
  	endUser.log_in_with_succes();
  }
} 