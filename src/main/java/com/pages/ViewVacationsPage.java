package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import mx4j.tools.adaptor.http.SetAttributeCommandProcessor;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ViewVacationsPage extends PageObject {

	@FindBy(css = "div[class='carousel-slider span3'] a[href*='menuItem=view-vacations']")
	private WebElementFacade viewVacationsText;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_applyButton']")
	private WebElementFacade applyButton;
	

	@FindBy(css ="tr[class*='portlet-section'] td:nth-child(1) a")
	private List<WebElement> namesFromTheTable;
	
	@FindBy(css="tr[class*='portlet-section'] td:nth-child(2) a")
	private List<WebElement> startDatesFromTheTable;
	
	@FindBy(css="tr[class*='portlet-section'] td:nth-child(3) a")
	private List<WebElement> endDatesFromTheTable;
	
	@FindBy(css="tr[class*='portlet-section'] td:nth-child(8) a")
	private List<WebElement> typesFromTheTable;
	
	@FindBy(css="tr[class*='portlet-section'] td:nth-child(9) a")
	private List<WebElement> statusFromTheTable;
	
	//@FindBy(css="tr[class*='portlet-section'] td:nth-child(9) a")
	private List<WebElement> daysnumberFromTheTable;
	
	//@FindBy(css="tr[class*='portlet-section'] td:nth-child(9) a")
	private List<WebElement> filterList;
	
	public void click_the_view_vacations_menu(){
		viewVacationsText.click();
	}
		
	public boolean apply_button_is_present(){
		if(applyButton.isPresent()) return true;
		else return false;
	}
	public void selectFiltersFromListInViewVacations(String filter) {
		boolean found = false;
		for (WebElement element : filterList) {
			System.out.println("In FOR");
			if (element.getText().toLowerCase().trim().contains(filter.toLowerCase().trim())) {
				System.out.println("Filtrul este: " + element.getText());
				found = true;
				element(viewVacationsText).waitUntilVisible();
				element.click();
				break;
			}
		}
		Assert.assertTrue("Filter was not found", found);
	}
	public boolean check_if_the_desired_request_was_approved_or_rejected(String employeeName,String startDate,String endDate,String type,String status){
		int i=0;
		int nr = namesFromTheTable.size();
		System.out.println(nr);
		boolean isCorrect = false;
		while(i<nr){
		//	System.out.println(namesFromTheTable.get(i).getText());
			//System.out.println(startDatesFromTheTable.get(i).getText());
		//	System.out.println(endDatesFromTheTable.get(i).getText());
		//	System.out.println(statusFromTheTable.get(i).getText());
		//	System.out.println(typesFromTheTable.get(i).getText());
			if(namesFromTheTable.get(i).getText().compareTo(employeeName)==0 && startDatesFromTheTable.get(i).getText().compareTo(startDate)==0 && endDatesFromTheTable.get(i).getText().compareTo(endDate)==0 && statusFromTheTable.get(i).getText().compareTo(status)==0 && typesFromTheTable.get(i).getText().compareTo(type)==0)
				{isCorrect = true;
				break;}
			i++;
		}
		System.out.println(isCorrect);
		return isCorrect;
	}
	public void checkIfTableIsFilteredByTypeInViewVacations(String selection) {
		boolean found = true;
		for (WebElement elementtype : typesFromTheTable) {
			while (!elementtype.getText().contentEquals(selection)) {
				found = false;
				System.out.println("Type filtered correctly");
				break;
			}
		}
		Assert.assertTrue("Content does not correspond to desired selection", found);
	}
	
	public void checkIfTableIsFilteredByStatusInViewVacations(String selection) {
		boolean found = true;
		for (WebElement elementstatus : statusFromTheTable) {
			while (!elementstatus.getText().contentEquals(selection)) {
				found = false;
				System.out.println("Status filtered correctly");
				break;
			}

		}
		Assert.assertTrue("Content does not correspond to desired selection", found);
	}
	public void checkIfTableIsFilteredByDaysNumberInViewVacations(int nr1, int nr2) {
		boolean found = true;
		for (WebElement elementdaysnumber :  daysnumberFromTheTable) {
			int day = Integer.parseInt(elementdaysnumber.getText());
			while (day<1 && day>5) {
				found = false;
				System.out.println("Days number filtered correctly");
				break;
			}

		}
		Assert.assertTrue("Content does not correspond to desired selection", found);
	}

	public void clickApplyButtonForFiltersInViewVacations() {
		element(applyButton).waitUntilVisible();
		applyButton.click();
		element(applyButton).waitUntilVisible();
	}
}
	  
	  

