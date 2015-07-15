package com.pages;

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
	
	@FindBy(css="label[id='_evovacation_WAR_EvoVacationportlet_businessDaysOutput']")
	private WebElementFacade selectedBusinesDays;
	
	public void go_to_new_vacation_request_area(){
		newVacationRequestText.click();
	}
	public boolean my_free_days_from_new_vacation_request_are_equal_with_my_free_days_from_my_free_days_menu(){
		newVacationRequestText.click();
		int myFreeDays = Integer.parseInt(myFreeDaysFromNewVacation.getText());
		myFreeDaysText.click();
		int freeDays = Integer.parseInt(myFreeDaysFromMyFreeDays.getText());
		boolean isEqual=false;
		if(myFreeDays == freeDays) isEqual=true;
		else isEqual=false;
		return isEqual;
	}
	public long getSelectedBusinessDays(){
		long days=Integer.parseInt(selectedBusinesDays.getText());
		return days;
			
	}
	public int getMonth(String month){
		int x=0;
		switch(month){
		case "January": x=1;
						break;
		case "February":x=2;
					break;
		case "March":
			x=3;
			break;
		case "April": x=4;
			break;
		case "May": x=5;
			break;
		case "June": x=6;
			break;
		case "July": x=7;
			break;
		case "August": x=8;
			break;
		case "September": x=9;
			break;
		case "October": x=10;
			break;
		case "November": x=11;
			break;
		case "December": x=12;
			break;
		}
		return x;
	}

}
