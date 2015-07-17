package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import mx4j.tools.adaptor.http.SetAttributeCommandProcessor;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class TrackPage extends PageObject {

	@FindBy(css = "a[href*='menuItem=vacation-tracker']")
	private WebElementFacade trackButton;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_applyButton']")
	private WebElementFacade applyButton;


	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_trackerStartDate']")
	private WebElementFacade startDatelocator;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_trackerEndDate']")
	private WebElementFacade endDateLocator;

	@FindBy(css = "div[style*='display: block'] table[class='dp_daypicker'] td:not(.dp_not_in_month)")
	private List<WebElement> daysInMonth;

	@FindBy(css = "div[style*='display: block']")
	private WebElementFacade monthAndYearFromStartDate;

	@FindBy(css = "div[style*='50.84375px'] table[class='dp_header'] tr td:nth-child(2)")
	private WebElementFacade monthAndYearAtEndDate;

	@FindBy(css="//div[text()='Buildings']")
	private WebElementFacade buildingsDropDown;
	
	@FindBy(css="//div[text()='Departments']")
	private WebElementFacade departmentsDropDown;
	
	@FindBy(css="tr[class*='portlet-section'] td[class*='align']:nth-child(2) ")
	private List<WebElement> startDates;
	
	@FindBy(css=" tr[class*='portlet-section'] td[class*='align']:nth-child(3)")
	private List<WebElement> endDates;

	NewVacationRequestPage newVacationPage;
	
	public void select_building(String text) {
		(buildingsDropDown).selectByVisibleText(text);
	}

	public void select_deparment(String text) {
		(departmentsDropDown).selectByVisibleText(text);
	}

	public void go_to_track_page(){
		trackButton.click();
	}
	public void click_apply_button(){
		applyButton.click();
	}

	public boolean apply_button_is_present() {
		if (applyButton.isPresent())
			return true;
		else
			return false;
	}


	public void choose_the_start_date(int day, String month, int year) {
		String monthAndYear = month + ", " + year;
		startDatelocator.click();
		WebElement date = monthAndYearFromStartDate.findElement(By.cssSelector("td[class='dp_caption']"));
		String text = date.getText();
		WebElement next = monthAndYearFromStartDate.findElement(By.cssSelector("td[class='dp_next']"));
		while (true) {
			if (text.compareTo(monthAndYear) == 0)
				break;
			else {
				next.click();
				WebElement data = monthAndYearFromStartDate.findElement(By.cssSelector("td[class='dp_caption']"));
				text = data.getText();
			}
		}
		WebElement tableDay = monthAndYearFromStartDate.findElement(By.cssSelector("table[class='dp_daypicker']"));

		String ziua = Integer.toString(day);

		for (WebElement daySelected : daysInMonth) {
			if (daySelected.getText().contentEquals(ziua)) {
				element(daySelected).waitUntilVisible();
				daySelected.click();
				break;
			}
		}

	}

	public void choose_the_end_date(int day, String month, int year) {
		String monthAndYear = month + ", " + year;
		endDateLocator.click();
		WebElement date = monthAndYearFromStartDate.findElement(By.cssSelector("td[class='dp_caption']"));
		String text = date.getText();
		WebElement next = monthAndYearFromStartDate.findElement(By.cssSelector("td[class='dp_next']"));
		while (true) {
			if (text.compareTo(monthAndYear) == 0)
				break;
			else {
				next.click();
				WebElement data = monthAndYearFromStartDate.findElement(By.cssSelector("td[class='dp_caption']"));
				text = data.getText();
			}
		}
		WebElement tableDay = monthAndYearFromStartDate.findElement(By.cssSelector("table[class='dp_daypicker']"));

		String ziua = Integer.toString(day);

		for (WebElement daySelected : daysInMonth) {
			if (daySelected.getText().contentEquals(ziua)) {
				element(daySelected).waitUntilVisible();
				daySelected.click();
				break;
			}
		}
	}
	public boolean check_if_apply_button_makes_filters_correctly(int startDay,String startMonth,int startYear,int endDay,String endMonth,int endYear){
		boolean isOk=true;
		int i=0;
		int nr = startDates.size();
		while(i<nr){
			String startD = startDates.get(i).getText();
			String endD = endDates.get(i).getText();
			String[] parts = startD.split("/");
			int sDay = Integer.parseInt(parts[0]);
			int stMonth = Integer.parseInt(parts[1]);
			String sMonth = newVacationPage.getMonth(stMonth);
			int sYear = Integer.parseInt(parts[2]);
			String[] part = endD.split("/");
			int eDay = Integer.parseInt(part[0]);
			int Month = Integer.parseInt(part[1]);
			int eYear = Integer.parseInt(part[2]);
			String eMonth = newVacationPage.getMonth(Month);
			if(newVacationPage.dateDiffBetweenStartDateAndEndDate(eDay, eMonth, eYear, endDay, endMonth, endYear)<0) isOk=false;
			if(newVacationPage.dateDiffBetweenStartDateAndEndDate(startDay, startMonth, startYear, sDay, startMonth, sYear)<0) isOk=false;
			i++;
		}
		
		return isOk;
	}

	
}
