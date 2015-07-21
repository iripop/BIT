package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class VacationsReportPage extends PageObject {

	@FindBy(css="div[class='carousel-slider span3'] a[href*='menuItem=vacation-report']")
	private WebElementFacade vacationsReportButton;

	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_reportLastName']")
	private WebElementFacade lastNameInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_reportFirstName']")
	private WebElementFacade firstNameInput;

	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_searchButton")
	private WebElementFacade searchButton;

	@FindBy(css="tr[class*='portlet-section'] td:nth-child(1) a")
	private List<WebElement> lastNames;
	
	@FindBy(css="tr[class*='portlet-section'] td:nth-child(2) a")
	private List<WebElement> firstNames;
	
	
	
	@FindBy(css="table[class='taglib-search-iterator'] tr:nth-child(3) td:nth-child(2) a")
	private WebElementFacade firstNameFromTable;
	
	public void clickVacationsReportMenu(){
		vacationsReportButton.click();
	}
	public boolean checkIfSearchButtonIsPresent(){
		if(searchButton.isPresent()) return true;
		else return false;
	}
	public void enterLastName(String name){
		lastNameInput.type(name);
	}
	public void enterFirstName(String name){
		firstNameInput.type(name);
	}
	public void clickSearchButton(){
		searchButton.click();
	}
	public boolean checkIfLastnameFromTableIsTheSameAsIntroduced(String lastName){
		int i=0;
		int nr = lastNames.size();
		System.out.println(lastName);
		boolean isOk=true;
		while(i<nr){
			if(lastNames.get(i).getText().compareTo(lastName)!=0){
				isOk=false;
				System.out.println("Nu bun last="+lastNames.get(i).getText());}
			i++;
		}
		System.out.println("last="+isOk);
		return isOk;
		
		
	}
	public boolean checkfIfFirstNameFromTableIsTheSameAsIntroduced(String firstName){
		int i=0;
		int nr = firstNames.size();
		System.out.println(firstName);
		boolean isOk=true;
		while(i<nr){
			if(firstNames.get(i).getText().compareTo(firstName)!=0){
				isOk=false;
				System.out.println("Nu bun first="+firstNames.get(i).getText());
			}
				i++;
		}
		System.out.println("Firs="+isOk);
		return isOk;
		
	}
}
	  
	  

