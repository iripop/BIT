package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import mx4j.tools.adaptor.http.SetAttributeCommandProcessor;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class VacationsReportPage extends PageObject {

	@FindBy(css="div[class='carousel-slider span3'] a[href*='menuItem=vacation-report']")
	private WebElementFacade vacationsReportText;

	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_reportLastName']")
	private WebElementFacade lastName;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_reportFirstName']")
	private WebElementFacade firstName;

	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_searchButton")
	private WebElementFacade searchButton;

	@FindBy(css="table[class='taglib-search-iterator'] tr:nth-child(3) td:first-child a")
	private WebElementFacade lastNameFromTable;
	
	@FindBy(css="table[class='taglib-search-iterator'] tr:nth-child(3) td:nth-child(2) a")
	private WebElementFacade firstNameFromTable;
	
	public void go_to_vacations_report(){
		vacationsReportText.click();
	}
	public boolean search_button_is_present(){
		if(searchButton.isPresent()) return true;
		else return false;
	}
	public String enter_last_name(String name){
		lastName.type(name);
		return name;
	}
	public String enter_first_name(String name){
		firstName.type(name);
		return name;
	}
	public void search_by_name(){
		searchButton.click();
	}
	public boolean last_name_is_the_same(String lastName){

		if(lastName.compareTo(lastNameFromTable.getText())==0) return true;
		else return false;
	}
	public boolean first_name_is_the_same(String firstName){
		
		if(firstName.compareTo(firstNameFromTable.getText())==0) return true;
		else return false;
	}
}
	  
	  

