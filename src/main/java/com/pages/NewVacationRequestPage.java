package com.pages;

import mx4j.tools.adaptor.http.SetAttributeCommandProcessor;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class NewVacationRequestPage extends PageObject {

	@FindBy(css = "a[href*='menuItem=new-request']")
	private WebElementFacade newVacationRequestText;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_saveButton']")
	private WebElementFacade saveButtonText;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_type_CO']")
	private WebElementFacade holidayRadio;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_type_CF']")
	private WebElementFacade withoutPaymentRadio;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_type_CM']")
	private WebElementFacade sickLeaveRadio;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_type_CS']")
	private WebElementFacade specialVacationRadio;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_type_ML']")
	private WebElementFacade maternityLeaveRadio;

	@FindBy(css = "select[id='_evovacation_WAR_EvoVacationportlet_specialReason']")
	private WebElementFacade selectSpecialVacation;

	@FindBy(css = "select[id='_evovacation_WAR_EvoVacationportlet_maternityLeave']")
	private WebElementFacade selectMaternityLeave;

	@FindBy(css = "div[id='_evovacation_WAR_EvoVacationportlet_newVacationComment']")
	private WebElementFacade requiredCommentFromSpecialVacation;

	@FindBy(css = "div[id='_evovacation_WAR_EvoVacationportlet_comment'] textarea")
	private WebElementFacade addComment;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_startDate']")
	private WebElementFacade startDatelocator;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_endDate']")
	private WebElementFacade endDateLocator;

	@FindBy(css = "div[style*='50.84375px'] table[class='dp_header'] tr td:nth-child(2)")
	private WebElementFacade monthAndYearAtStartDate;

	@FindBy(css = "div[style*='50.84375px'] table[class='dp_header'] tr td:nth-child(3)")
	private WebElementFacade nextStartDate;

	// @FindBy(css ="div[style*='50.84375px'] table[class='dp_header'] tr
	// td:nth-child(2)")
	// private WebElementFacade monthAndYearAtEndDate;

	public void enable_holiday_radio() {
		holidayRadio.click();
	}

	public void enable_vacation_without_payment() {
		withoutPaymentRadio.click();
	}

	public void enable_sick_leave() {
		sickLeaveRadio.click();
	}

	public void enable_special_vacation() {
		specialVacationRadio.click();
	}

	public void enable_maternity_leave() {
		maternityLeaveRadio.click();
	}

	public void select_special_vacation(String text) {
		(selectSpecialVacation).selectByVisibleText(text);
	}

	public void select_maternity_leave(String text) {
		(selectMaternityLeave).selectByVisibleText(text);
	}

	public void new_vacation_area() {
		newVacationRequestText.waitUntilVisible();
		newVacationRequestText.click();
	}

	public boolean save_button_is_present() {
		if (saveButtonText.isPresent())
			return true;
		else
			return false;
	}

	public void save_request() {
		saveButtonText.click();
	}

	public void add_comment_required_at_apecial_vacation(String text) {
		requiredCommentFromSpecialVacation.click();
		addComment.type(text);
	}

	public void choose_the_start_date() {
		startDatelocator.click();
		// monthAndYearAtStartDate.click();
		System.out.println("Hello");
		System.out.println(monthAndYearAtStartDate.isVisible());
		System.out.println("Hello");
	}

	public void choose_the_end_date(int day, String month, int year) {

	}

	public void set_the_date() {

	}
}
