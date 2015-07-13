package com.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;


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
