package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import mx4j.tools.adaptor.http.SetAttributeCommandProcessor;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class VacationManagementPage extends PageObject {

	@FindBy(css = "div[class='carousel-slider span3'] a[href*='menuItem=inbox']")
	private WebElementFacade inboxText;
	
	@FindBy(css = "div[class='carousel-slider span3'] a[href*='menuItem=view-vacations']")
	private WebElementFacade viewVacationsText;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_applyButton']")
	private WebElementFacade applyButton;
	
	@FindBy(css = "table[class='taglib-search-iterator']")
	private WebElementFacade tableWithRequests;
	
	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_multipleApproveButton']")
	private WebElementFacade approveButton;
	
	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_multipleRejectButton']")
	private WebElementFacade rejectButton;
	
	@FindBy(css = "table[class='taglib-search-iterator'] tr:nth-child(3)")
	private WebElementFacade requestWhichIsChecked;
	
	@FindBy(css="div[class='carousel-slider span3'] a[href*='menuItem=inbox'] b")
	private WebElementFacade numberOfRequest;
	
	@FindBy(css="table[class='taglib-search-iterator'] tr:nth-child(3) td:first-child a")
	private WebElementFacade nameFromTheTable;
	
	@FindBy(css="table[class='taglib-search-iterator'] tr:nth-child(3) td:nth-child(9) a")
	private WebElementFacade statusFromTheTable;
	
	public void access_the_inbox_menu(){
		inboxText.click();
	}
	public void select_one_request(){
		WebElement check = tableWithRequests.findElement(By.cssSelector("input[name='_evovacation_WAR_EvoVacationportlet_rowIds']"));
		check.click();
	}
	public void approve_request(){
		approveButton.click();
	}
	public void reject_request(){
		rejectButton.click();
	}
	public boolean approve_button_is_present(){
		if(approveButton.isPresent()) return true;
		else return false;
	}
	public String getName(){
		WebElement name = requestWhichIsChecked.findElement(By.cssSelector("td:nth-child(1) a"));
		return name.getText();
	}
	public int getNumberOfRequests(){
		String text = numberOfRequest.getText();
		char c = text.charAt(1);
		int nr = (int)c;
		return nr-'0';
	}
	public void access_the_view_vacations_menu(){
		viewVacationsText.click();
	}
	public boolean apply_button_is_present(){
		if(applyButton.isPresent()) return true;
		else return false;
	}
	public boolean is_name_the_same(){
		System.out.println("Name"+getName());
		System.out.println(nameFromTheTable.getText());
		if(getName().compareTo(nameFromTheTable.getText())==0) return true;
		else return false;
	}
	public boolean is_the_status_approved(){
		if(statusFromTheTable.getText().compareTo("Approved")==0) return true;
		else return false;
	}
	public boolean is_the_status_rejected(){
		if(statusFromTheTable.getText().compareTo("Rejected")==0) return true;
		else return false;
	}
}
	  
	  

