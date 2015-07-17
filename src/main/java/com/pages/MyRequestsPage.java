package com.pages;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class MyRequestsPage extends PageObject {

	@FindBy(css = "div.carousel-slider li a[href*='menuItem=my-requests']")
	private WebElementFacade myRequestsButton;

	@FindBy(css = "div[class='filter-content'] span[class='aui-field aui-field-choice'] label")
	private List<WebElement> filterList;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_applyButton']")
	private WebElementFacade applyButton;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_futureVacationsCheckbox']")
	private WebElementFacade showFutureVacationsInput;

	/*
	 * @FindBy(css =
	 * "div[class*='search-container'] div[class='results-grid'] td[headers$='type']"
	 * ) private List<WebElement> typeList;
	 */

	@FindBy(css = "tr[class*='portlet-section'] td:nth-child(3) a")
	private List<WebElement> daysNumberList;

	@FindBy(css = "tr[class*='portlet-section'] td:nth-child(5) a")
	private List<WebElement> lastUpdateList;

	@FindBy(css = "tr[class*='portlet-section'] td:nth-child(1) a")
	private List<WebElement> startDateList;

	@FindBy(css = "tr[class*='portlet-section'] td:nth-child(2) a")
	private List<WebElement> endDateList;

	@FindBy(css = "tr[class*='portlet-section'] td:nth-child(4) a")
	private List<WebElement> typeList;

	@FindBy(css = "tr[class*='portlet-section'] td:nth-child(6) a")
	private List<WebElement> statusList;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_PENDINGCheckbox']")
	private WebElementFacade pendingCheckBox;

	public void checkIfMyRequestsButtonExists() {

		boolean found = false;
		if (myRequestsButton.isPresent()) {
			found = true;
		}
		Assert.assertTrue("Element not found", found);
	}

	public void open_my_requests() {
		element(myRequestsButton).waitUntilVisible();
		myRequestsButton.click();
	}

	/*
	 * public void selectManyFiltersFromList(String... filters) { boolean found
	 * = false; for (String filtru : filters) { for (WebElement element :
	 * filterList) { if
	 * (element.getText().toLowerCase().trim().contains(filtru.toLowerCase().
	 * trim())) { System.out.println("Filtrul este: " + element.getText());
	 * found = true; element(myRequestsButton).waitUntilVisible();
	 * element.click(); break; } } Assert.assertTrue("Filter was not found",
	 * found); found = false; }
	 * 
	 * }
	 */
	public void selectFiltersFromList(String filter) {
		boolean found = false;
		for (WebElement element : filterList) {
			// System.out.println("In FOR");
			if (element.getText().toLowerCase().trim().contains(filter.toLowerCase().trim())) {
				// System.out.println("Filtrul este: " + element.getText());
				found = true;
				element(myRequestsButton).waitUntilVisible();
				element.click();
				break;
			}
		}
		Assert.assertTrue("Filter was not found", found);
	}

	public void clickApplyButtonForFilters() {
		element(applyButton).waitUntilVisible();
		applyButton.click();
		element(applyButton).waitUntilVisible();
	}

	public void clickShowFutureVacationsButton() {
		element(showFutureVacationsInput).waitUntilVisible();
		showFutureVacationsInput.click();

	}

	public void checkIfTableIsFilteredByType(String selection) {
		boolean found = true;
		for (WebElement elementtype : typeList) {
			while (!elementtype.getText().contentEquals(selection)) {
				found = false;
				System.out.println("Type filtered correctly");
				break;
			}
		}
		Assert.assertTrue("Content does not correspond to desired selection", found);
	}

	public void checkIfTableIsFilteredByStatus(String selection) {
		boolean found = true;
		for (WebElement elementstatus : statusList) {
			while (!elementstatus.getText().contentEquals(selection)) {
				found = false;
				System.out.println("Status filtered correctly");
				break;
			}

		}
		Assert.assertTrue("Content does not correspond to desired selection", found);
	}

	public void checkIfTableIsFilteredByDaysNumber(int nr1, int nr2) {
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

	public boolean check_if_desired_request_exists(String type, String startDate, String endDate, String status) {
		int i = 0;
		int nr = startDateList.size();
		pendingCheckBox.click();
		applyButton.click();
		boolean exist = false;
		System.out.println(nr);
		while (i < nr) {
			if (startDateList.get(i).getText().compareTo(startDate) == 0
					&& endDateList.get(i).getText().compareTo(endDate) == 0
					&& statusList.get(i).getText().compareTo(status) == 0
					&& typeList.get(i).getText().compareTo(type) == 0) {
				exist = true;
				break;
			}
			i++;
		}
		System.out.println(exist);
		return exist;
	}

}
