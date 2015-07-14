package com.pages;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class MyRequestsPage extends PageObject{
	 
	@FindBy(css="div.carousel-slider li a[href*='menuItem=my-requests']")
	    private WebElementFacade myRequestsButton;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_HOLIDAYCheckbox']")
    private WebElementFacade holidayInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_VACATION_WITHOUT_PAYMENTCheckbox']")
    private WebElementFacade vacationWithoutPaymentInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_SPECIAL_VACATIONCheckbox']")
    private WebElementFacade specialVacationInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_SICK_LEAVECheckbox']")
    private WebElementFacade sickLeaveInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_MATERNITY_LEAVECheckbox']")
    private WebElementFacade maternityLeaveInput;

	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_FIFTHCheckbox']")
    private WebElementFacade fifthInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_TENTHCheckbox']")
    private WebElementFacade tenthInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_TWENTIETHCheckbox']")
    private WebElementFacade twentiethInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_FIFTIETHCheckbox']")
    private WebElementFacade fiftiethInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_RESTCheckbox']")
    private WebElementFacade restInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_PENDINGCheckbox']")
    private WebElementFacade pendingInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_APPROVEDCheckbox']")
    private WebElementFacade approvedInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_CANCELLEDCheckbox']")
    private WebElementFacade cancelledInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_REJECTEDCheckbox']")
    private WebElementFacade rejectInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_WITHDRAWNCheckbox']")
    private WebElementFacade withdrawInput;


	public void checkIfMyRequestsExists(){
    	boolean found = false;
    	if(myRequestsButton.isPresent()){
    		found = true;
    	}
    	Assert.assertTrue("Element not found", found);
    }
	public void open_my_requests() {
		element(myRequestsButton).waitUntilVisible();
	    myRequestsButton.click();
	}
	public void select_type(WebElementFacade fielters){
		for (int i = 0; i < 15; i++){
			element(myRequestsButton).waitUntilVisible();
		    fielters.click();
		}
	

	}
}
