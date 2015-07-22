package com;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.EndUserSteps;
import com.steps.VacationReportSearchByName;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesRunner;
import tools.Constants;
import tools.ReadingEmail;
//@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom("/resources/data.csv")
@RunWith(ThucydidesRunner.class)
public class SearchByNameTest {


	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	String username,password;
	
   @ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;

	@Steps
	public EndUserSteps endUser;

	@Steps
	public VacationReportSearchByName searchUser;

  @Test
    public void searchVacationByNameInVacationReport() {
		
        endUser.openHomePage();
		endUser.logInAsDM(Constants.DMname,Constants.DMpassword);
		endUser.goToVacationMenu();
		searchUser.viewVacationReport();
		searchUser.goToVacationReportWithSuccess();
		searchUser.searchByLastNameAndFirstName("Irina", "Pop");
		searchUser.checkIfFirstNameIsCorrect("Pop");
		searchUser.checkIfLastNameIsCorrect("Irina");

	}

	
   
}


