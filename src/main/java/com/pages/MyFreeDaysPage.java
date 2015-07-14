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

public class MyFreeDaysPage extends PageObject{
	 
	@FindBy(css="div[id='vacDaysLeft'] b")
	private WebElementFacade myFreeDaysFromNewVacation;
	
	@FindBy(css = "a[href*='menuItem=new-request']")
    private WebElementFacade newVacationRequestText; 
	
	@FindBy(css = "a[href*='menuItem=my-free-days']")
	private WebElementFacade myFreeDaysText;
	
	@FindBy(css = "tr[class='section-result'] td:nth-child(2)")
	private WebElementFacade myFreeDaysFromMyFreeDays;
	
	public boolean my_free_days_from_new_vacation_request_is_equal_with_my_free_days_from_my_free_days_menu(){
		newVacationRequestText.click();
		int myFreeDays = Integer.parseInt(myFreeDaysFromNewVacation.getText());
		myFreeDaysText.click();
		int freeDays = Integer.parseInt(myFreeDaysFromMyFreeDays.getText());
	//	System.out.println("1="+myFreeDays);
	//	System.out.println("2="+freeDays);
		boolean isEqual=false;
		if(myFreeDays == freeDays) isEqual=true;
		else isEqual=false;
		return isEqual;
	}


}
