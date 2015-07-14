package com.pages;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class MyFreeDaysPage extends PageObject {

	@FindBy(css = "div.carousel-slider li a[href*='menuItem=my-free-days']")
	private WebElementFacade myFreeDaysButton;
	@FindBy(css = "span a[id=_evovacation_WAR_EvoVacationportlet_TabsBack]")
	private WebElementFacade backButton;

	public void checkIfMyFreeDaysExists() {
		boolean found = false;
		if (myFreeDaysButton.isPresent()) {
			found = true;
		}
		Assert.assertTrue("Element not found", found);
	}

	public void open_my_free_days() {
		element(myFreeDaysButton).waitUntilVisible();
		myFreeDaysButton.click();
	}

	public void goBack() {
		element(backButton).waitUntilVisible();
		backButton.click();
	}
}
