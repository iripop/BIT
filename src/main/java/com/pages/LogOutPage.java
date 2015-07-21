package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class LogOutPage extends PageObject {

	@FindBy(css = "a[href='/c/portal/logout']")
	private WebElementFacade signOutButton;

	@FindBy(css = "ul.main-menu a[href*='/vacation']")
	private WebElementFacade vacationMenu;

	public void clickSignOutButton() {
		signOutButton.click();
	}

	public boolean checkIfVacationTabIsPresent() {
		if (vacationMenu.isPresent())
			return false;
		else
			return true;
	}
}
