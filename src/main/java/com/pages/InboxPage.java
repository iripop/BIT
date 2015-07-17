package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import mx4j.tools.adaptor.http.SetAttributeCommandProcessor;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class InboxPage extends PageObject {

	@FindBy(css = "div[class='carousel-slider span3'] a[href*='menuItem=inbox']")
	private WebElementFacade inboxButton;
	
	@FindBy(css = "div[class='carousel-slider span3'] a[href*='menuItem=view-vacations']")
	private WebElementFacade viewVacationsButton;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_applyButton']")
	private WebElementFacade applyButton;
	
	@FindBy(css = "table[class='taglib-search-iterator']")
	private WebElementFacade tableWithRequests;
	
	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_multipleApproveButton']")
	private WebElementFacade approveButton;
	
	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_multipleRejectButton']")
	private WebElementFacade rejectButton;
	

	@FindBy(css="div[class='carousel-slider span3'] a[href*='menuItem=inbox'] b")
	private WebElementFacade numberOfRequest;
	

	
	
	@FindBy(css="tr[class*='portlet-section'] td:nth-child(2) a")
	private List<WebElement> listOfNames;
	
	@FindBy(css="tr[class*='portlet-section'] td:nth-child(3) a")
	private List<WebElement> listOfStartDates;
	
	@FindBy(css="tr[class*='portlet-section'] td:nth-child(4) a")
	private List<WebElement> listOfEndDates;
	
	@FindBy(css="tr[class*='portlet-section'] td:nth-child(6) a")
	private List<WebElement> listOfTypes;
	
	@FindBy(css="tr[class*='portlet-section'] td:nth-child(1) input ")
	private List<WebElement> checkBoxes;
	
	public void access_the_inbox_menu(){
		inboxButton.click();
	}
	public void select_first_request(){
		WebElement check = tableWithRequests.findElement(By.cssSelector("input[name='_evovacation_WAR_EvoVacationportlet_rowIds']"));
		check.click();
	}
	public void click_approve_button(){
		approveButton.click();
	}
	public void click_reject_button(){
		rejectButton.click();
	}
	public boolean approve_button_is_present(){
		if(approveButton.isPresent()) return true;
		else return false;
	}

	public int getNumberOfRequests(){
		String text = numberOfRequest.getText();
		text = text.replace("(", "").replace(")", "");
		return Integer.parseInt(text);
	}
	public void access_the_view_vacations_menu(){
		viewVacationsButton.click();
	}
	public boolean apply_button_is_present(){
		if(applyButton.isPresent()) return true;
		else return false;
	}

	public void search_request(String emplyeeName,String startDate,String endDate,String type){
		int i=0;
		int nr = listOfNames.size();
		while(i<nr){
		
			if(listOfNames.get(i).getText().compareTo(emplyeeName)==0 && listOfStartDates.get(i).getText().compareTo(startDate)==0 && listOfEndDates.get(i).getText().compareTo(endDate)==0 && listOfTypes.get(i).getText().compareTo(type)==0)
				{checkBoxes.get(i).click();
				System.out.println("Da");
				}
			i++;
		}
		
		
	}
	
	
	
}
	  
	  

