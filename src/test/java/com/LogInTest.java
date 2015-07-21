package com;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.EndUserSteps;
import com.steps.ReadingEmail;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesRunner;
import tools.Constants;
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("/resources/data.csv")
//@RunWith(ThucydidesRunner.class)
public class LogInTest {


	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	String username,password;
	
   @ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;

	@Steps
	public EndUserSteps endUser;



    
    ReadingEmail email;
  @Test
    public void log_in() {
		
        endUser.openHomePage();
		endUser.logInAsUser(username, password);
	

	}

	 @Test
	public void vacationMenu() {
		endUser.goToVacationMenu();
		endUser.logInWithSuccess();

}
	 @After
		public void close_browser(){
			   pages.getDriver().close();
		}
   
}


