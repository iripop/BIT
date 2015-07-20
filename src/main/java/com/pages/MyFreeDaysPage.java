package com.pages;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class MyFreeDaysPage extends PageObject {

	@FindBy(css = "div[id='vacDaysLeft'] b")
	private WebElementFacade vacationDaysLeftFromNewVacation;

	@FindBy(css = "a[href*='menuItem=new-request']")
	private WebElementFacade newVacationRequestButton;

	@FindBy(css = "a[href*='menuItem=my-free-days']")
	private WebElementFacade myFreeDaysButton;

	@FindBy(css = "tr[class='section-result'] td:nth-child(2)")
	private WebElementFacade totalAvailableFreeDaysFromMyFreeDays;

	@FindBy(css = "label[id='_evovacation_WAR_EvoVacationportlet_businessDaysOutput']")
	private WebElementFacade selectedBusinessDays;

	public void clickNewVacationRequestMenu() {
		newVacationRequestButton.click();
	}

	public boolean checkIfVacationDaysLeftFromNewVacationRequestEqualWithMyFreeDaysFromMyFreeDaysMenu() {
		newVacationRequestButton.click();
		int myFreeDays = Integer.parseInt(vacationDaysLeftFromNewVacation.getText());
		myFreeDaysButton.click();
		int freeDays = Integer.parseInt(totalAvailableFreeDaysFromMyFreeDays.getText());
		boolean isEqual = false;
		if (myFreeDays == freeDays)
			isEqual = true;
		else
			isEqual = false;
		return isEqual;
	}

	public long checkIfSelectedBusinessDaysCalculatedCorrectly() {
		long days = Integer.parseInt(selectedBusinessDays.getText());
		return days;

	}

	public int getMonth(String month) {
		int x = 0;
		switch (month) {
		case "January":
			x = 1;
			break;
		case "February":
			x = 2;
			break;
		case "March":
			x = 3;
			break;
		case "April":
			x = 4;
			break;
		case "May":
			x = 5;
			break;
		case "June":
			x = 6;
			break;
		case "July":
			x = 7;
			break;
		case "August":
			x = 8;
			break;
		case "September":
			x = 9;
			break;
		case "October":
			x = 10;
			break;
		case "November":
			x = 11;
			break;
		case "December":
			x = 12;
			break;
		}
		return x;
	}

}
