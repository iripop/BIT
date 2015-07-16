package com.pages;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.WebElement;

import mx4j.tools.adaptor.http.SetAttributeCommandProcessor;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class NewVacationRequestPage extends PageObject {

	@FindBy(css = "a[href*='menuItem=new-request']")
	private WebElementFacade newVacationRequestButton;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_saveButton']")
	private WebElementFacade saveButton;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_type_CO']")
	private WebElementFacade holidayInput;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_type_CF']")
	private WebElementFacade withoutPaymentInput;

	@FindBy(css = "div[style*='50.84375px'] table[class='dp_header'] tr td:nth-child(2)")
	private WebElementFacade monthAndYearAtStartDate;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_type_CM']")
	private WebElementFacade sickLeaveInput;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_type_CS']")
	private WebElementFacade specialVacationInput;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_type_ML']")
	private WebElementFacade maternityLeaveInput;

	@FindBy(css = "select[id='_evovacation_WAR_EvoVacationportlet_specialReason']")
	private WebElementFacade selectSpecialVacationType;

	@FindBy(css = "select[id='_evovacation_WAR_EvoVacationportlet_maternityLeave']")
	private WebElementFacade selectMaternityLeaveType;

	@FindBy(css = "div[id='_evovacation_WAR_EvoVacationportlet_newVacationComment']")
	private WebElementFacade requiredCommentFromSpecialVacation;

	@FindBy(css = "div[id='_evovacation_WAR_EvoVacationportlet_comment'] textarea")
	private WebElementFacade addComment;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_startDate']")
	private WebElementFacade startDatelocator;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_endDate']")
	private WebElementFacade endDateLocator;

	@FindBy(css = "div[style*='display: block'] table[class='dp_daypicker'] td:not(.dp_not_in_month)")
	private List<WebElement> daysInMonth;

	@FindBy(css = "div[style*='display: block']")
	private WebElementFacade monthAndYearFromStartDate;

	@FindBy(css = "div[style*='50.84375px'] table[class='dp_header'] tr td:nth-child(2)")
	private WebElementFacade monthAndYearAtEndDate;

	MyFreeDaysPage freeDaysPage;
	public void click_holiday() {
		holidayInput.click();
	}

	public void click_vacation_without_payment() {
		withoutPaymentInput.click();
	}

	public void click_sick_leave() {
		sickLeaveInput.click();
	}

	public void click_special_vacation() {
		specialVacationInput.click();
	}

	public void click_maternity_leave() {
		maternityLeaveInput.click();
	}

	public void select_special_vacation_type(String text) {
		(selectSpecialVacationType).selectByVisibleText(text);
	}

	public void select_maternity_leave_type(String text) {
		(selectMaternityLeaveType).selectByVisibleText(text);
	}

	public void new_vacation_area() {
		newVacationRequestButton.waitUntilVisible();
		newVacationRequestButton.click();
	}

	public boolean save_button_is_present() {
		if (saveButton.isPresent())
			return true;
		else
			return false;
	}

	public void click_save_button() {
		saveButton.click();
	}

	public void add_comment_required_at_apecial_vacation(String text) {
		requiredCommentFromSpecialVacation.click();
		addComment.type(text);
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
	 public long dateDiffBetweenStartDateAndEndDate(int startDay,String startMonth,int startYear,int endDay,String endMonth,int endYear){
	    	int selectedDays=0;
	    	choose_the_start_date(startDay, startMonth, endYear);
	    	choose_the_end_date(endDay, endMonth, endYear);
	    	Date start = new GregorianCalendar(startYear, freeDaysPage.getMonth(startMonth), startDay).getTime();
	    	Date end=new GregorianCalendar(endYear, freeDaysPage.getMonth(endMonth), endDay).getTime();
	    	long diff = end.getTime()-start.getTime();
	    	long dif = diff / (1000 * 60 * 60 * 24);
	    	return dif-1;
	    }
	 public String getMonth(int month) {
			String x = "";
			switch (month) {
			case 1:
				x = "January";
				break;
			case 2:
				x = "February";
				break;
			case 3:
				x = "March";
				break;
			case 4:
				x = "April";
				break;
			case 5:
				x = "May";
				break;
			case 6:
				x = "June";
				break;
			case 7:
				x ="July";
				break;
			case 8:
				x = "August";
				break;
			case 9:
				x = "September";
				break;
			case 10:
				x = "October";
				break;
			case 11:
				x = "November";
				break;
			case 12:
				x = "December";
				break;
			}
			return x;
		}
	
}
