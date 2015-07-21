package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class LogInPage extends PageObject {

	@FindBy(name = "_58_login")
	private WebElementFacade screenNameInput;

	@FindBy(name = "_58_password")
	private WebElementFacade passwordInput;

	@FindBy(css = "input[class='aui-button-input aui-button-input-submit']")
	private WebElementFacade signInButton;

	@FindBy(css = "ul.main-menu a[href*='/vacation']")
	private WebElementFacade vacationMenu;

	public void insertPassword(String keyword) {
		passwordInput.type(keyword);
	}

	public void clickVacationMenu() {
		vacationMenu.click();
	}

	public boolean checkIfVacationTabIsPresent() {
		if (vacationMenu.isPresent())
			return true;
		else
			return false;
	}

	public void insertUserName(String keyword) {
		screenNameInput.type(keyword);
	}

	public void clickSignInButton() {
		signInButton.click();
	}
}
