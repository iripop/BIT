package com.steps;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.pages.LogInPage;
import com.pages.LogOutPage;
import com.pages.MyFreeDaysPage;
import com.pages.MyRequestsPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class LogOutSteps extends ScenarioSteps {


	LogOutPage page;

	
	@Step
	public void logOut(){
		page.clickSignOutButton();
	}

	@Step
	public void logOutWithSucces() {
		boolean found = page.checkIfVacationTabIsPresent();
		assertTrue("VacationMenu not found", found);
	}

}