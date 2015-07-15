package com;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.EndUserSteps;
import com.steps.ReadingEmail;
import com.steps.vacationReportSearchByName;

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
public class searchByNameTest {


	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	String username,password;
	
   @ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;

	@Steps
	public EndUserSteps endUser;

	@Steps
	public vacationReportSearchByName searchUser;

  @Test
    public void search() {
		
        endUser.is_the_home_page();
		endUser.login(username, password);
		endUser.go_to_vacation_menu();
		searchUser.view_vacation_report();
		searchUser.go_to_vacation_report_with_success();
		searchUser.search_by_last_name_and_first_name("Pop", "Irina");
		searchUser.check_if_first_name_is_correct("Irina");
		searchUser.check_if_last_name_is_correct("Pop");

	}

	
   
}


