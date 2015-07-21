package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class MyFreeDaysHistoryPage extends PageObject {
	@FindBy(css = "div.carousel-slider li a[href*='menuItem=free-days-history']")
	private WebElementFacade freeDaysHistoryButton;
	
	@FindBy(css = "div[class='filter-content-history'] span[class='aui-field-content'] label")
	private List<WebElement> filterList;
	
	@FindBy(css = "div[id*='SearchContainer'] td[headers$='column.header.operation']")
		private List<WebElement> operationList;
		
		@FindBy(css = "div[id*='SearchContainer'] td[headers$='column.header.type']")
		private List<WebElement> typeList;
		
		@FindBy(css = "div[id*='SearchContainer'] td[headers$='column.header.number']")
		private List<WebElement> daysNumberList;
	
	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_applyButton']")
	private WebElementFacade applyButton;


	
	public void checkIfMyFreeDaysHistoryMenuExists() {

		boolean found = false;
		if (freeDaysHistoryButton.isPresent()) {
			found = true;
		}
		Assert.assertTrue("Element not found", found);
	}

	public void clickMyFreeDaysHistoryMenu() {
		element(freeDaysHistoryButton).waitUntilVisible();
		freeDaysHistoryButton.click();
	}
	public void selectFiltersFromListInMyFreeDaysHistory(String filter) {
		boolean found = false;
		for (WebElement element : filterList) {
			//System.out.println("In FOR");
			if (element.getText().toLowerCase().trim().contains(filter.toLowerCase().trim())) {
				//System.out.println("Filtrul este: " + element.getText());
				found = true;
				element(freeDaysHistoryButton).waitUntilVisible();
				element.click();
				break;
			}
		}
		Assert.assertTrue("Filter was not found", found);
	}
	
	public void checkIfTableIsFilteredByTypeInMyFreeDaysHistory(String selection) {
		boolean found = true;
		for (WebElement elementtype : typeList) {
			System.out.println("-----------");
			while (!elementtype.getText().trim().contentEquals(selection)) {
		     found = false;
				System.out.println("Type filtered correctly");
				break;
			}
		}
		Assert.assertTrue("Content does not correspond to desired selection", found);
	}
	
	public void checkIfTableIsFilteredByOperationInMyFreeDaysHistory(String selection) {
		boolean found = true;
		for (WebElement elementoperation : operationList) {
			while (!elementoperation.getText().contentEquals(selection)) {
				found = false;
				System.out.println("Operation filtered correctly");
				break;
			}
		}
		Assert.assertTrue("Content does not correspond to desired selection", found);
	}
	
	public void checkIfTableIsFilteredByDaysNumberInMyFreeDaysHistory(int nr1, int nr2) {
		boolean found = true;
		for (WebElement elementdaysnumber : daysNumberList) {
			System.out.println("--------------------------" + daysNumberList);
			int day = Integer.parseInt(elementdaysnumber.getText());
			while (day < 1 && day > 5) {
				found = false;
				System.out.println("Days number filtered correctly");
				break;
			}

		}
		Assert.assertTrue("Content does not correspond to desired selection", found);
	}
	public void clickApplyButtonForFilters() {
		element(applyButton).waitUntilVisible();
		applyButton.click();
		element(applyButton).waitUntilVisible();
	}

}
