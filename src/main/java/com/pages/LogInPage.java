package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;


public class LogInPage extends PageObject {

	 	@FindBy(name="_58_login")
	    private WebElementFacade screenName;
	    
	    @FindBy(name="_58_password")
	    private WebElementFacade password;
	    
	    @FindBy(css = "input[class='aui-button-input aui-button-input-submit']")
	    private WebElementFacade signInButton;
	    
	    @FindBy(css = "ul.main-menu li:nth-child(9) a span")
	    private WebElementFacade vacationMenu;

	    public void enter_screen_name(String keyword) {
	        screenName.type(keyword);
	    }
	    public void enter_password(String keyword) {
	        password.type(keyword);
	    }
	    public void sign_in() {
	        signInButton.click();
	    }
	    public void vacationMenu(){
	    	vacationMenu.click();
	    }
	    public boolean vacation_is_present(){
	    	if(vacationMenu.isPresent()) return true;
	    	else return false;
	    }
    }
